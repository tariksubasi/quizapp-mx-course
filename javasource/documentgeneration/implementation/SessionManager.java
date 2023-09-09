package documentgeneration.implementation;

import java.util.Date;
import java.util.Optional;

import com.mendix.core.Core;
import com.mendix.core.CoreException;
import com.mendix.logging.ILogNode;
import com.mendix.systemwideinterfaces.core.ISession;

import system.proxies.User;

public class SessionManager {
	private static boolean canReuse(Date lastActive) {
		long maxAge = new Date().getTime() - (sessionTimeout - sessionKeepAliveUpdatesInterval);
		return lastActive != null && lastActive.getTime() > maxAge;
	}
	
	public static synchronized ISession getSession(User user) throws CoreException {
		Optional<ISession> maybeUserSession =
				Optional.ofNullable(Core.getActiveSession(user.getName()))
				.filter((s) -> canReuse(s.getLastActive()));
		
		if (maybeUserSession.isPresent()) {
			logging.debug("Reusing session for user " + user.getName());
			ISession session = maybeUserSession.get();
			session.keepAlive();
			return session;
		} else {
			logging.debug("Initializing session for user " + user.getName());
			return Core.initializeSession(Core.getUser(Core.createSystemContext(), user.getName()), null);
		}
	}

	private static final ILogNode logging = Logging.logNode;
	private static final int sessionTimeout = Core.getConfiguration().getSessionTimeout();
	private static final long sessionKeepAliveUpdatesInterval = Core.getConfiguration().getSessionKeepAliveUpdatesInterval();
}