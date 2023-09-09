package documentgeneration.implementation;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.ProcessBuilder.Redirect;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.TimeZone;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.SystemUtils;

import com.mendix.core.Core;
import com.mendix.core.CoreException;
import com.mendix.http.HttpHeader;
import com.mendix.http.HttpMethod;
import com.mendix.http.HttpResponse;
import com.mendix.logging.ILogNode;
import com.mendix.systemwideinterfaces.core.IContext;
import com.mendix.systemwideinterfaces.core.IMendixObject;
import com.mendix.systemwideinterfaces.core.ISession;
import com.mendix.thirdparty.org.json.JSONObject;

import documentgeneration.proxies.Configuration;
import documentgeneration.proxies.DocumentRequest;
import documentgeneration.proxies.Enum_RegistrationStatus;
import documentgeneration.proxies.constants.Constants;
import system.proxies.FileDocument;
import system.proxies.User;

public class DocumentGenerator {
	private String resultEntity;
	private String fileName;
	private String pageMicroflow;
	private IMendixObject contextObject;
	private User generateAsUser;
	private Boolean waitForResult = true;

	public DocumentGenerator(String resultEntity, String fileName, String pageMicroflow, User generateAsUser) {
		this.resultEntity = resultEntity;
		this.fileName = fileName;
		this.pageMicroflow = pageMicroflow;
		this.generateAsUser = generateAsUser;
	}

	public DocumentGenerator withContextObject(IMendixObject contextObject) {
		this.contextObject = contextObject;
		return this;
	}

	public DocumentGenerator withWaitForResult(Boolean waitForResult) {
		this.waitForResult = waitForResult;
		return this;
	}

	public IMendixObject generate() throws CoreException {
		String securityToken = DocumentRequestManager.generateSecurityToken();
		DocumentRequest documentRequest = DocumentRequestManager.createDocumentRequest(pageMicroflow, contextObject,
				resultEntity, fileName, generateAsUser, securityToken);
		String requestId = documentRequest.getRequestId();

		ISession session = SessionManager.getSession(generateAsUser);
		String timezoneId = this.getTimezoneIdFromSession(session);

		if (isLocalDevelopmentEnvironment()) {
			logging.debug("Executing local service");
			this.executeLocalService(requestId, securityToken, timezoneId);
		} else {
			logging.debug("Using Cloud service");
			this.executeCloudService(requestId, securityToken, timezoneId, getTimeoutValue());
		}

		if (!this.waitForResult) {
			IContext sudoContext = session.createContext().createSudoClone();
			FileDocument document = DocumentGenerator.generateFileDocument(sudoContext, resultEntity, fileName);
			document.commit();

			// Link and return empty document without waiting for result
			DocumentRequestManager.linkFileDocument(documentRequest, document);
			return document.getMendixObject();
		}

		return RequestManager.waitForDocumentContent(new WaitWithBackoffStrategy(), this.resultEntity,
				documentRequest.getMendixObject().getId());
	}

	private void executeLocalService(String requestId, String securityToken, String timezoneId) {
		if (LocalServiceLocator.getNodePath() == null)
			throw new RuntimeException("Could not find Node.js executable for local document generation");

		if (LocalServiceLocator.getServicePath() == null)
			throw new RuntimeException("Could not find local service for local document generation");

		if (LocalServiceLocator.getChromePath() == null)
			throw new RuntimeException("Could not find Chrome or Chromium executable for local document generation");

		List<String> command = new ArrayList<String>();
		command.add(LocalServiceLocator.getNodePath());
		command.add(LocalServiceLocator.getServicePath());
		command.add("--chrome-path=" + LocalServiceLocator.getChromePath());
		command.add("--application-url=" + getApplicationURL());
		command.add("--generate-path=" + ConfigurationManager.GENERATE_PATH);
		command.add("--result-path=" + ConfigurationManager.RESULT_PATH);
		command.add("--request-id=" + requestId);
		command.add("--security-token=" + securityToken);
		command.add("--timezone=" + timezoneId);

		if (USE_SCREEN_MEDIATYPE)
			command.add("--use-screen-media");

		if (WAIT_FOR_IDLE_NETWORK)
			command.add("--wait-for-idle-network");

		// Execute browser process
		ProcessBuilder processBuilder = new ProcessBuilder().command(command).redirectErrorStream(true)
				.redirectOutput(Redirect.PIPE);

		logging.trace("Executing " + processBuilder.command());
		Process process;

		try {
			process = processBuilder.start();

			if (this.waitForResult)
				this.collectAndLogProcessOutput(process);
		} catch (IOException e) {
			throw new RuntimeException("Exception while executing local service: " + e);
		}

		// Do not wait for exit value when executing async
		if (!this.waitForResult)
			return;

		if (process.exitValue() != 0)
			throw new RuntimeException(
					"Local service exited with error. Please reference the troubleshooting section in the documentation for details.");
	}

	private void executeCloudService(String requestId, String securityToken, String timezoneId, long timeout) {
		URI endpoint;

		try {
			endpoint = new URI(documentgeneration.proxies.constants.Constants.getAPI_URL());
		} catch (URISyntaxException e) {
			throw new RuntimeException("Invalid API endpoint: " + e.getMessage());
		}

		IContext systemContext = Core.createSystemContext();
		Configuration configuration = ConfigurationManager.getConfigurationObject(systemContext);

		if (!Enum_RegistrationStatus.Registered.equals(configuration.getRegistrationStatus()))
			throw new RuntimeException(
					"Unable to generate PDF document. For use in Mendix cloud, your app environment needs to be registered first. Please reference the documentation for details.");

		if (TokenManager.accessTokenIsExpired(configuration)) {
			logging.info("Access token is expired; attempting to refresh tokens");
			if (TokenManager.tryRefreshTokens(systemContext))
				configuration = ConfigurationManager.getConfigurationObject(systemContext);
		}

		String accessToken = configuration.getAccessToken();

		HttpHeader[] headers = new HttpHeader[] { new HttpHeader(HEADER_AUTHORIZATION, "Bearer " + accessToken),
				new HttpHeader(HEADER_SECURITY_TOKEN, securityToken),
				new HttpHeader("Content-Type", "application/json") };

		JSONObject body = new JSONObject();
		body.put("requestId", requestId);
		body.put("applicationUrl", getCloudApplicationURL(configuration));
		body.put("generatePath", ConfigurationManager.GENERATE_PATH);
		body.put("resultPath", ConfigurationManager.RESULT_PATH);
		body.put("waitForResult", this.waitForResult);
		body.put("timezone", timezoneId);
		body.put("useScreenMediaType", USE_SCREEN_MEDIATYPE);
		body.put("waitForIdleNetwork", WAIT_FOR_IDLE_NETWORK);
		body.put("timeout", timeout);
		body.put("moduleVersion", ConfigurationManager.MODULE_VERSION);
		body.put("runtimeVersion", com.mendix.core.conf.Configuration.RUNTIME_VERSION);
		body.put("projectId", Core.getProjectId());

		String requestBody = body.toString();
		logging.trace("Request body: " + requestBody);

		// Send request
		HttpResponse response = Core.http().executeHttpRequest(endpoint, HttpMethod.POST, headers,
				new ByteArrayInputStream(requestBody.getBytes()));
		logging.trace("Service response code: " + response.getStatusCode());

		if (response.getStatusCode() != 200) {
			throw new RuntimeException(
					"Unable to generate document, service response code: " + response.getStatusCode());
		}
	}

	public static FileDocument generateFileDocument(IContext context, String entity, String fileName) {
		logging.trace("Creating new FileDocument object");
		IMendixObject resultMxObject = Core.instantiate(context, entity);
		FileDocument document = FileDocument.initialize(context, resultMxObject);

		String name = fileName.toLowerCase().endsWith(".pdf") ? fileName : fileName.concat(".pdf");
		document.setName(name);

		return document;
	}

	public static String getApplicationURL() {
		String appUrl = Core.getConfiguration().getApplicationRootUrl();
		return StringUtils.removeEnd(appUrl, "/");
	}

	public static String getCloudApplicationURL(Configuration configuration) {
		String cloudAppUrl = configuration.getApplicationUrl();
		return StringUtils.removeEnd(cloudAppUrl, "/");
	}
	
	public static String getEnvironmentApplicationURL(IContext context) {
		if (DocumentGenerator.isLocalDevelopmentEnvironment()) {
			logging.debug("Handling request using application root URL");

			return DocumentGenerator.getApplicationURL();
		} else {
			logging.debug("Handling request using the registered application URL");
			Configuration configuration = ConfigurationManager.getConfigurationObject(context);

			return DocumentGenerator.getCloudApplicationURL(configuration);
		}
	}

	public static boolean isLocalDevelopmentEnvironment() {
		if (Constants.getEmulateCloudEnvironment())
			return false;

		if (SystemUtils.IS_OS_WINDOWS) {
			File expectedModelerPath = new File(Core.getConfiguration().getRuntimePath().getParent() + "\\modeler\\");
			logging.trace("Expected modeler path: " + expectedModelerPath);

			if (expectedModelerPath.exists()) {
				logging.debug("Found modeler path, we're in local development");
				return true;
			}
		}

		return false;
	}

	public long getTimeoutValue() {
		if (this.waitForResult) {
			return documentgeneration.proxies.constants.Constants.getSyncTimeoutInSeconds() * 1000;
		} else {
			return documentgeneration.proxies.constants.Constants.getAsyncTimeoutInSeconds() * 1000;
		}
	}

	public String getTimezoneIdFromSession(ISession session) {
		TimeZone timezone = session.getTimeZone();

		if (timezone != null) {
			return timezone.getID();
		} else {
			return DEFAULT_TIMEZONE;
		}
	}

	private void collectAndLogProcessOutput(Process process) throws IOException {
		try (BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()))) {
			String line;

			while ((line = reader.readLine()) != null) {
				logging.trace(line);
			}
		}
	}

	public static final String HEADER_SECURITY_TOKEN = "X-Security-Token";
	private static final String HEADER_AUTHORIZATION = "Authorization";

	private static final boolean USE_SCREEN_MEDIATYPE = true;
	private static final boolean WAIT_FOR_IDLE_NETWORK = true;
	private static final String DEFAULT_TIMEZONE = "GMT";

	private static final ILogNode logging = Logging.logNode;
}
