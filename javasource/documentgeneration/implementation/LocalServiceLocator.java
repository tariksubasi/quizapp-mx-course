package documentgeneration.implementation;

import java.io.File;
import java.util.ArrayList;

import com.mendix.core.Core;
import com.mendix.logging.ILogNode;

import documentgeneration.proxies.constants.Constants;

public class LocalServiceLocator {
	private static String nodePath = null;
	private static String servicePath = null;
	private static String chromePath = null;

	public static void verify() {
		getNodePath();
		getServicePath();
		getChromePath();
	}

	public static String getNodePath() {
		if (nodePath != null) return nodePath;
		
		ArrayList<String> potentialNodePaths = new ArrayList<String>();
		potentialNodePaths.add(Core.getConfiguration().getRuntimePath().getParent() + "\\modeler\\tools\\node\\node.exe");
		potentialNodePaths.add(Core.getConfiguration().getRuntimePath().getParent() + "\\modeler\\tools\\node\\win-x64\\node.exe");
				
		for (String potentialNodePath : potentialNodePaths) {
			File expectedNodePath = new File(potentialNodePath);
			logging.trace("Scanning for local Node executable: " + expectedNodePath);
			
			if (expectedNodePath.exists()) {
				nodePath = expectedNodePath.getAbsolutePath();
				logging.debug("Using local Node executable: " + nodePath);
				
				return nodePath;
			}
		}
		
		logging.error("Could not find local Node executable");
		return null;
	}
	
	public static String getServicePath() {
		if (servicePath != null) return servicePath;
		
		File expectedServicePath = new File(Core.getConfiguration().getBasePath().getParent() + "\\" + serviceDirectory + "\\index.js");
		logging.trace("Expected path for local DocGen service: " + expectedServicePath);

		if (!expectedServicePath.exists()) {
			logging.error("Could not find local DocGen service");
			return null;
		}

		servicePath = expectedServicePath.getAbsolutePath();
		logging.debug("Using local service: " + servicePath);
		
		return servicePath;
	}
	
	public static String getChromePath() {
		if (chromePath != null) return chromePath;
		
		ArrayList<String> potentialChromePaths = new ArrayList<String>();
		
		if (Constants.getCustomChromePath() != null && Constants.getCustomChromePath().length() > 0)
			potentialChromePaths.add(Constants.getCustomChromePath());
			
		if (System.getenv("ProgramFiles") != null)
			potentialChromePaths.add(System.getenv("ProgramFiles") + "\\Google\\Chrome\\Application\\chrome.exe");
		
		if (System.getenv("ProgramFiles(x86)") != null)
			potentialChromePaths.add(System.getenv("ProgramFiles(x86)") + "\\Google\\Chrome\\Application\\chrome.exe");
		
		if (System.getenv("LocalAppData") != null)
			potentialChromePaths.add(System.getenv("LocalAppData") + "\\Google\\Chrome\\Application\\chrome.exe");
				
		for (String potentialChromePath : potentialChromePaths) {
			File expectedChromePath = new File(potentialChromePath);
			logging.trace("Scanning for local Chrome executable: " + expectedChromePath);
			
			if (expectedChromePath.exists()) {
				chromePath = expectedChromePath.getAbsolutePath();
				logging.debug("Using local Chrome executable: " + chromePath);
				
				return chromePath;
			}
		}
		
		logging.error("Could not find local Chrome executable");
		return null;
	}

	private static final String serviceDirectory = "javascriptsource\\documentgeneration\\service";
	private static final ILogNode logging = Logging.logNode;
}
