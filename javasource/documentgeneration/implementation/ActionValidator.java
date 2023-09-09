package documentgeneration.implementation;

import java.util.Map;
import java.util.Optional;

import com.mendix.core.Core;
import com.mendix.logging.ILogNode;
import com.mendix.systemwideinterfaces.core.IDataType;
import com.mendix.systemwideinterfaces.core.IMendixObject;
import com.mendix.systemwideinterfaces.core.meta.IMetaObject;

import system.proxies.FileDocument;
import system.proxies.User;

public class ActionValidator {
	public static void validateResultEntity(String resultEntity) {		
		if (!Core.getMetaObject(resultEntity).isFileDocument()) {
			throwValidationException("The provided result entity " + resultEntity + " does not inherit from System.FileDocument");
		}
		
		if (resultEntity.equals(FileDocument.entityName)) {
			throwValidationException("The result entity should be a specialization of System.FileDocument");
		}
	}

	public static void validatePageMicroflow(String pageMicroflow, IMendixObject contextObject) {
		Map<String, IDataType> inputParametersMap = Core.getInputParameters(pageMicroflow);
		logging.debug("Page microflow parameters are: " + inputParametersMap);

		if (inputParametersMap == null || inputParametersMap.size() == 0) {
			logging.trace("Page microflow is valid and has no parameters");
			return;
		}
		
		if (inputParametersMap.size() > 1) {
			throwValidationException("The page microflow should have maximum 1 parameter");
		}
		
		if (inputParametersMap.size() == 1) {
			IDataType inputParameter = inputParametersMap.values().iterator().next();
			
			if (inputParameter.isMendixObject()) {
				if (contextObject != null)
					validateMicroflowParamObject(contextObject, inputParameter);
			} else {
				throwValidationException("The page microflow can only have one parameter of type Mendix object");
			}
		}
	}

	public static void validateContextObject(IMendixObject contextObject) {
		if (contextObject == null) return; 
		if (contextObject.isNew() || !contextObject.getMetaObject().isPersistable()) {
			throwValidationException("Context object should be persistable and committed");
		}
	}

	public static void validateFileName(String fileName) {
		if (fileName == null)
			throwValidationException("No file name provided");
		
		if (fileName.length() < 1)
			throwValidationException("File name needs to be at least 1 character");
	}
	
	public static void validateDocumentUser(User documentUser) {
		if (documentUser == null) 
			throwValidationException("No document user provided");
		
		String userName = documentUser.getName();
		
		if (!documentUserExists(userName)) 
			throwValidationException("The provided document user '" + userName + "' does not exist or is inactive");
	}
	
	public static boolean documentUserExists(String userName) {
		String query = String.format("//%s[Name = $Name][Active]", "System.User");

		Optional<IMendixObject> result = Core.createXPathQuery(query).setVariable("Name", userName)
				.execute(Core.createSystemContext())
				.stream()
				.findAny();
		
		return result.isPresent();
	}
	
	private static void validateMicroflowParamObject(IMendixObject contextObject, IDataType inputParameter) {	
		IMetaObject contextMetaObject = contextObject.getMetaObject();
		IMetaObject parameterMetaObject = Core.getMetaObject(inputParameter.getObjectType());
		
		if (contextMetaObject.isSubClassOf(parameterMetaObject)) {
			logging.trace("The context object is of the same entity as or a specalization of the microflow parameter");
			return;
		}
		
		throwValidationException("The context object should match or be a specialization of the page microflow parameter");
	}
	
	private static void throwValidationException(String message) {
		logging.warn(message);
		throw new RuntimeException(message);
	}

	private static final ILogNode logging = Logging.logNode;
}