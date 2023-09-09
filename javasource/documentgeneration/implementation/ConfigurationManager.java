package documentgeneration.implementation;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Date;
import java.util.Optional;

import org.apache.commons.lang3.time.DateUtils;

import com.mendix.core.Core;
import com.mendix.core.CoreException;
import com.mendix.systemwideinterfaces.core.IContext;
import com.mendix.systemwideinterfaces.core.IMendixObject;

import documentgeneration.proxies.Configuration;

public class ConfigurationManager {
	public static Configuration getConfigurationObject(IContext context) {
		String query = String.format("//%s", Configuration.entityName);
		Optional<IMendixObject> maybeConfiguration = Core.createXPathQuery(query).execute(Core.createSystemContext())
				.stream().findAny();
		
		if (maybeConfiguration.isEmpty())
			throw new RuntimeException("No configuration object available. For use in Mendix cloud, your app environment needs to be registered first. Please reference the documentation for details.");

		return Configuration.initialize(context, maybeConfiguration.get());
	}

	public static void updateTokenInformation(Configuration configuration, String accessToken, String refreshToken, int expiresIn)
			throws CoreException {
		configuration.setAccessToken(accessToken);
		configuration.setRefreshToken(refreshToken);
		configuration.setAccessTokenExpirationDate(DateUtils.addSeconds(new Date(), expiresIn));
	}
	
	public static URI getTokenEndpoint() {
		try {
			return new URI(documentgeneration.proxies.constants.Constants.getTOKEN_URL());
		} catch (URISyntaxException e) {
			throw new RuntimeException("Invalid token endpoint: " + e.getMessage());
		}
	}

	public static final String MODULE_VERSION = "1.1.1";
	public static final String GENERATE_PATH = DocGenRequestHandler.ENDPOINT + DocGenRequestHandler.GENERATE_PATH;
	public static final String RESULT_PATH = DocGenRequestHandler.ENDPOINT + DocGenRequestHandler.RESULT_PATH;
	public static final String VERIFY_PATH = DocGenRequestHandler.ENDPOINT + DocGenRequestHandler.VERIFY_PATH;
}
