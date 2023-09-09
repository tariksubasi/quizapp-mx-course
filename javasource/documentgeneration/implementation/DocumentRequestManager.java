package documentgeneration.implementation;

import java.security.SecureRandom;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.apache.commons.lang3.time.DateUtils;

import com.mendix.core.Core;
import com.mendix.core.CoreException;
import com.mendix.core.objectmanagement.member.MendixHashString;
import com.mendix.datastorage.XPathQuery;
import com.mendix.logging.ILogNode;
import com.mendix.systemwideinterfaces.core.IContext;
import com.mendix.systemwideinterfaces.core.IMendixObject;

import documentgeneration.proxies.DocumentRequest;
import documentgeneration.proxies.constants.Constants;
import system.proxies.FileDocument;
import system.proxies.User;

public class DocumentRequestManager {
	public static DocumentRequest createDocumentRequest(String pageMicroflow, IMendixObject contextObject, String resultEntity, String fileName, User generateAsUser, String unhashedToken) {
		IContext systemContext = Core.createSystemContext();

		DocumentRequest documentRequest = new DocumentRequest(systemContext);
		documentRequest.setRequestId(UUID.randomUUID().toString());
		documentRequest.setFileName(fileName);
		documentRequest.setMicroflowName(pageMicroflow);
		documentRequest.setResultEntity(resultEntity);
		documentRequest.setSecurityToken(unhashedToken); // Attribute type is hashed string; will be hashed when stored
		documentRequest.setExpirationDate(DateUtils.addSeconds(new Date(), Constants.getTokenLifetimeInSeconds().intValue()));
		documentRequest.setDocumentRequest_DocumentUser(generateAsUser);
		
		if (contextObject != null) {
			documentRequest.setContextObjectGuid(contextObject.getId().toLong());
		}

		try {
			documentRequest.commit();
		} catch (CoreException e) {
			logging.error("Could not commit document request object: " + e.getMessage());
		}

		return documentRequest;
	}
	
	public static void linkFileDocument(DocumentRequest documentRequest, FileDocument document) {
		try {
			documentRequest.setDocumentRequest_FileDocument(document);
			documentRequest.commit();
		} catch (CoreException e) {
			logging.error("Could not link file to document request: " + e.getMessage());
			return;
		}
	}
	
	public static DocumentRequest verifyDocumentRequest(String requestId, String securityToken) throws SecurityException {
		IContext systemContext = Core.createSystemContext();
		DocumentRequest documentRequest;
		
		if (securityToken == null || securityToken.length() < keyLength) {
			throw new SecurityException("Invalid security token length");
		}
				
		XPathQuery query = Core.createXPathQuery("//DocumentGeneration.DocumentRequest[RequestId=$RequestId]");
		query.setVariable("RequestId", requestId);
		List<IMendixObject> result = query.execute(systemContext);

		if (result == null || result.size() == 0) {
			throw new SecurityException("Document request not found");
		}
		
		if (result.size() > 1) {
			throw new SecurityException("Match for multiple document requests, skipped processing");
		}
				
		IMendixObject requestMxObject = result.get(0);
		documentRequest = DocumentRequest.initialize(systemContext, requestMxObject);
		
		MendixHashString hashedToken = (MendixHashString) requestMxObject.getMember(systemContext,
				DocumentRequest.MemberNames.SecurityToken.toString());		
		
		// Verify security token against stored hash
		if (!hashedToken.verifyValue(systemContext, securityToken)) {
			throw new SecurityException("Invalid security token");
		}

		// Verify expiration date
		Date expirationDate = documentRequest.getExpirationDate();
		Date currentDate = new Date();

		if (expirationDate == null || expirationDate.before(currentDate)) {
			throw new SecurityException("Document request expired");
		}

		return documentRequest;
	}
	
	public static String generateSecurityToken() {
		final char[] allowedCharacters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789-_.~".toCharArray();
	    SecureRandom random = new SecureRandom();
	    StringBuilder tokenBuilder = new StringBuilder(); 
	    
	    for (int i = 0; i < keyLength; i++) {
	    	tokenBuilder.append(allowedCharacters[random.nextInt(allowedCharacters.length)]);
	    }
	    
	    return tokenBuilder.toString();
	}
	
	private static final ILogNode logging = Logging.logNode;
	private static final int keyLength = 128;
}
