package documentgeneration.implementation;

import java.util.Date;

import org.apache.commons.lang3.time.DateUtils;

import com.mendix.core.CoreException;
import com.mendix.systemwideinterfaces.core.IContext;

import documentgeneration.proxies.Configuration;

public class VerificationManager {
	public static String setVerificationToken(IContext context) throws CoreException {
		return setVerificationToken(context, VERIFICATION_TOKEN_LIFETIME);
	}
	
	public static String setVerificationToken(IContext context, int lifetime) throws CoreException {
		Configuration configuration = ConfigurationManager.getConfigurationObject(context);
		String verificationToken = DocumentRequestManager.generateSecurityToken();
				
		configuration.setVerificationToken(verificationToken);
		configuration.setVerificationTokenExpirationDate(DateUtils.addSeconds(new Date(), lifetime));
		configuration.commit(context);
		
		return verificationToken;
	}

	public static String getVerificationToken(IContext context) {
		Configuration configuration = ConfigurationManager.getConfigurationObject(context);

		Date currentDate = new Date();
		Date expirationDate = configuration.getVerificationTokenExpirationDate();

		if (expirationDate == null || expirationDate.before(currentDate))
			throw new RuntimeException("Token expired");

		return configuration.getVerificationToken();
	}

	public static final int VERIFICATION_TOKEN_LIFETIME = 60;
}
