// This file was generated by Mendix Studio Pro.
//
// WARNING: Code you write here will be lost the next time you deploy the project.

package dataservice.proxies.microflows;

import com.mendix.core.Core;
import com.mendix.systemwideinterfaces.core.IContext;
import com.mendix.systemwideinterfaces.core.IMendixObject;

public final class Microflows
{
	/**
	 * Private constructor to prevent instantiation of this class. 
	 */
	private Microflows() {}

	// These are the microflows for the DataService module
	public static com.mendix.core.actionmanagement.MicroflowCallBuilder pRS_GetTestsBuilder(
		system.proxies.HttpRequest _httpRequest,
		system.proxies.HttpResponse _httpResponse
	)
	{
		com.mendix.core.actionmanagement.MicroflowCallBuilder builder = Core.microflowCall("DataService.PRS_GetTests");
		builder = builder.withParam("httpRequest", _httpRequest);
		builder = builder.withParam("httpResponse", _httpResponse);
		return builder;
	}

	public static java.util.List<builder.proxies.Test> pRS_GetTests(
		IContext context,
		system.proxies.HttpRequest _httpRequest,
		system.proxies.HttpResponse _httpResponse
	)
	{
		Object result = pRS_GetTestsBuilder(
				_httpRequest,
				_httpResponse
			)
			.execute(context);
		return result == null ? null : com.mendix.utils.ListUtils.map((java.util.List<IMendixObject>) result, obj -> builder.proxies.Test.initialize(context, obj));
	}
}
