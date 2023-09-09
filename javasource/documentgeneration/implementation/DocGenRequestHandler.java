package documentgeneration.implementation;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import com.mendix.core.Core;
import com.mendix.core.CoreException;
import com.mendix.core.conf.RuntimeVersion;
import com.mendix.externalinterface.connector.RequestHandler;
import com.mendix.logging.ILogNode;
import com.mendix.m2ee.api.IMxRuntimeRequest;
import com.mendix.m2ee.api.IMxRuntimeResponse;
import com.mendix.systemwideinterfaces.core.IContext;
import com.mendix.systemwideinterfaces.core.ISession;
import com.mendix.thirdparty.org.json.JSONObject;

import documentgeneration.proxies.DocumentRequest;
import system.proxies.FileDocument;
import system.proxies.Session;
import system.proxies.User;

public class DocGenRequestHandler extends RequestHandler {

	@Override
	public void processRequest(IMxRuntimeRequest request, IMxRuntimeResponse response, String path) throws Exception {
		logging.trace("Received request for path: " + path);

		if (VERIFY_PATH.equals(path)) {
			provideVerificationToken(request, response);
			return;
		}

		String requestId = request.getParameter("id");
		String securityToken = request.getHeader(DocumentGenerator.HEADER_SECURITY_TOKEN);
		logging.trace("Using request identifier: " + requestId);

		DocumentRequest documentRequest = null;
		if (requestId != null && securityToken != null) {
			try {
				documentRequest = DocumentRequestManager.verifyDocumentRequest(requestId, securityToken);
			} catch (Exception e) {
				logging.error("Invalid document request: " + e.getMessage());
			}
		} else {
			logging.error("Invalid request; request identifier or security token is missing");
		}

		if (documentRequest == null) {
			response.setStatus(IMxRuntimeResponse.UNAUTHORIZED);
			response.getWriter().write("401 Unauthorized");
			return;
		}

		User documentUser = documentRequest.getDocumentRequest_DocumentUser();

		if (documentUser == null) {
			logging.error("Document user not found");
			response.setStatus(IMxRuntimeResponse.BAD_REQUEST);
			response.getWriter().write("400 Bad Request");
			return;
		}

		ISession session = SessionManager.getSession(documentUser);
		logging.trace("Using session " + session);

		if (GENERATE_PATH.equals(path)) {
			generateDocument(request, response, session, documentRequest);
		} else if (RESULT_PATH.equals(path)) {
			processResult(request, response, session, documentRequest);
		} else {
			logging.warn("Invalid path: " + path);
			response.setStatus(IMxRuntimeResponse.BAD_REQUEST);
			response.getWriter().write("400 Bad Request");
		}
	}

	private void provideVerificationToken(IMxRuntimeRequest request, IMxRuntimeResponse response) throws Exception {
		IContext systemContext = Core.createSystemContext();
		String verificationToken;

		try {
			verificationToken = VerificationManager.getVerificationToken(systemContext);
		} catch (Exception e) {
			logging.warn("Unable to provide verification token; " + e.getMessage());
			response.setStatus(IMxRuntimeResponse.FORBIDDEN);
			response.getWriter().write("403 Forbidden");
			return;
		}

		logging.info("Providing verification token for service registration");
		JSONObject verificationResponse = new JSONObject().put("token", verificationToken);
		response.setStatus(IMxRuntimeResponse.OK);
		response.getWriter().write(verificationResponse.toString());
	}

	private void generateDocument(IMxRuntimeRequest request, IMxRuntimeResponse response, ISession session,
			DocumentRequest documentRequest) throws Exception {

		IContext systemContext = Core.createSystemContext();
		documentRequest.setDocumentRequest_Session(Session.initialize(systemContext, session.getMendixObject()));
		documentRequest.commit();

		addCookies(response, session);

		response.getHttpServletResponse().sendRedirect(DocumentGenerator.getEnvironmentApplicationURL(systemContext)
				+ "/p/generate-document/" + documentRequest.getMendixObject().getId().toLong() + "?profile=Responsive");
	}

	private void processResult(IMxRuntimeRequest request, IMxRuntimeResponse response, ISession session,
			DocumentRequest documentRequest) throws CoreException {

		IContext sudoContext = session.createContext().createSudoClone();
		FileDocument outputDocument = DocGenRequestHandler.getFileDocument(sudoContext, documentRequest);

		if (outputDocument != null) {
			try (InputStream is = request.getInputStream()) {
				Core.storeFileDocumentContent(sudoContext, outputDocument.getMendixObject(), is);
			} catch (IOException e) {
				logging.error("Could not write to file: " + e.getMessage());
				return;
			}

			DocumentRequestManager.linkFileDocument(documentRequest, outputDocument);
			RequestManager.completePendingRequest(documentRequest.getMendixObject().getId());
		}
	}

	private static FileDocument getFileDocument(IContext context, DocumentRequest documentRequest) {
		try {
			FileDocument document = documentRequest.getDocumentRequest_FileDocument(context);

			if (document != null) {
				logging.trace("Using existing FileDocument object");
				return document;
			}
		} catch (CoreException e) {
			logging.error("Could not retrieve FileDocument: " + e.getMessage());
			return null;
		}

		return DocumentGenerator.generateFileDocument(context, documentRequest.getResultEntity(),
				documentRequest.getFileName());
	}

	private static void addCookies(IMxRuntimeResponse response, ISession session)
			throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
		String[] runtimeVersion = RuntimeVersion.getInstance().toString().split("\\.");

		if ((Integer.parseInt(runtimeVersion[0]) == 9 && Integer.parseInt(runtimeVersion[1]) >= 20)
				|| Integer.parseInt(runtimeVersion[0]) >= 10) {
			// Use reflection to call the addCookie method with the 7th parameter for
			// 'isHostOnly', which was added in 9.20
			// Based on the SessionHandler implementation of the Deeplink module
			// (https://github.com/mendix/DeeplinkModule)
			@SuppressWarnings("rawtypes")
			Class[] methodSignature = { String.class, String.class, String.class, String.class, int.class,
					boolean.class, boolean.class };
			Method addCookie = response.getClass().getMethod("addCookie", methodSignature);

			// For Mx 9.20 and above:
			// addCookie(String key, String value, String path, String domain, int expiry,
			// boolean isHttpOnly, boolean isHostOnly)
			addCookie.invoke(response, Core.getConfiguration().getSessionIdCookieName(), session.getId().toString(),
					"/", "", -1, true, true);
			addCookie.invoke(response, XAS_ID, "0." + Core.getXASId(), "/", "", -1, true, true);
		} else {
			// For Mx 9.19 and below:
			// addCookie(String key, String value, String path, String domain, int expiry,
			// boolean isHttpOnly)
			response.addCookie(Core.getConfiguration().getSessionIdCookieName(), session.getId().toString(), "/", "",
					-1, true);
			response.addCookie(XAS_ID, "0." + Core.getXASId(), "/", "", -1, true);
		}
	}

	private static final ILogNode logging = Logging.logNode;
	public static final String ENDPOINT = "docgen/";
	public static final String GENERATE_PATH = "generate";
	public static final String RESULT_PATH = "result";
	public static final String VERIFY_PATH = "verify";
	private static final String XAS_ID = "XASID";
}
