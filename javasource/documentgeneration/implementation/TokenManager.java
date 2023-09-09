package documentgeneration.implementation;

import java.util.Date;

import org.apache.commons.lang3.time.DateUtils;

import com.mendix.core.Core;
import com.mendix.core.CoreException;
import com.mendix.http.HttpResponse;
import com.mendix.logging.ILogNode;
import com.mendix.systemwideinterfaces.core.IContext;
import com.mendix.systemwideinterfaces.core.IMendixObject;
import com.mendix.thirdparty.org.json.JSONException;
import com.mendix.thirdparty.org.json.JSONObject;

import documentgeneration.proxies.Configuration;
import documentgeneration.proxies.Enum_RegistrationStatus;
import documentgeneration.proxies.TokenResult;

public class TokenManager {
	public static IMendixObject requestAccessToken(IContext context, String username, String password, 
			String applicationUrl, String appId) throws CoreException {
		
		if (applicationUrl == null)
			throw new RuntimeException("Invalid Application URL");
		if (appId == null)
			throw new RuntimeException("Invalid App ID");
		
		String verificationToken = VerificationManager.setVerificationToken(Core.createSystemContext());

		TokenRequest tokenRequest = new TokenRequest("password").addFormData("username", username)
				.addFormData("password", password).addFormData("client_id", applicationUrl.toLowerCase())
				.addFormData("app_id", appId.toLowerCase())
				.addFormData("verification_path", ConfigurationManager.VERIFY_PATH)
				.addFormData("verification_token", verificationToken);

		HttpResponse httpResponse = tokenRequest.execute();
		JSONObject tokenResponse = TokenRequest.parseTokenResponse(context, httpResponse);
		TokenResult tokenResult = new TokenResult(context);

		if (httpResponse.getStatusCode() == 200) {
			Configuration configuration = ConfigurationManager.getConfigurationObject(context);
			configuration.setApplicationUrl(applicationUrl);
			ConfigurationManager.updateTokenInformation(configuration, tokenResponse.getString("access_token"),
					tokenResponse.getString("refresh_token"), tokenResponse.getInt("expires_in"));

			configuration.commit(context);

			logging.info("The application was registered successfully!");
			tokenResult.setSuccess(true);
		} else {
			tokenResult.setSuccess(false);

			if (tokenResponse.has("error_description")) {
				String message = tokenResponse.getString("error_description");

				logging.warn("Failed to register application: " + message);
				tokenResult.setMessage(message);
			} else {
				logging.error("Failed to register application; received status code " + httpResponse.getStatusCode());
				tokenResult.setMessage("Received status " + httpResponse.getStatusCode());
			}
		}

		return tokenResult.getMendixObject();
	}
	
	public static boolean refreshTokens(IContext context) throws CoreException, JSONException {
		Configuration configuration = ConfigurationManager.getConfigurationObject(context);
		
		if (!Enum_RegistrationStatus.Registered.equals(configuration.getRegistrationStatus()))
			throw new RuntimeException("Unable to refresh tokens, app is not registered");

		TokenRequest tokenRequest = new TokenRequest("refresh_token")
				.addFormData("client_id", configuration.getApplicationUrl())
				.addFormData("refresh_token", configuration.getRefreshToken());
		
		HttpResponse httpResponse = tokenRequest.execute();
		JSONObject tokenResponse = TokenRequest.parseTokenResponse(context, httpResponse);

		if (httpResponse.getStatusCode() == 200) {			
			ConfigurationManager.updateTokenInformation(configuration, tokenResponse.getString("access_token"),
					tokenResponse.getString("refresh_token"), tokenResponse.getInt("expires_in"));
			configuration.commit(context);

			logging.info("Successfully refreshed tokens");
			return true;
		} else {
			if (tokenResponse.has("error_description")) {
				String message = tokenResponse.getString("error_description");
				logging.error("Failed to refresh tokens: " + message);
			} else {
				logging.error("Failed to refresh tokens; received status code " + httpResponse.getStatusCode());
			}

			return false;
		}
	}
	
	public static boolean tryRefreshTokens(IContext context) {	
		try {
			return TokenManager.refreshTokens(context);
		} catch (Exception e) {
			logging.warn("Could not refresh tokens: " + e.getMessage());
			return false;
		}
	}
	
	public static boolean accessTokenIsExpired(Configuration configuration) {		
		if (configuration.getAccessTokenExpirationDate() == null)
			return true;
		
		// Consider access token as expired if expiration date is within one minute
		if (configuration.getAccessTokenExpirationDate().before(DateUtils.addMinutes(new Date(), 1)))
			return true;
		
		return false;
	}

	private static final ILogNode logging = Logging.logNode;
}
