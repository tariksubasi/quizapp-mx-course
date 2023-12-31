// This file was generated by Mendix Studio Pro.
//
// WARNING: Code you write here will be lost the next time you deploy the project.

package randomobject.proxies.microflows;

import com.mendix.core.Core;
import com.mendix.systemwideinterfaces.core.IContext;
import com.mendix.systemwideinterfaces.core.IMendixObject;

public final class Microflows
{
	/**
	 * Private constructor to prevent instantiation of this class. 
	 */
	private Microflows() {}

	// These are the microflows for the RandomObject module
	public static com.mendix.core.actionmanagement.MicroflowCallBuilder exampleObject_GetSampleBuilder(
		java.lang.Long _sampleSize,
		java.util.List<randomobject.proxies.ExampleObject> _exampleObjectList_Input
	)
	{
		com.mendix.core.actionmanagement.MicroflowCallBuilder builder = Core.microflowCall("RandomObject.ExampleObject_GetSample");
		builder = builder.withParam("SampleSize", _sampleSize);
		builder = builder.withParam("ExampleObjectList_Input", _exampleObjectList_Input);
		return builder;
	}

	public static java.util.List<randomobject.proxies.ExampleObject> exampleObject_GetSample(
		IContext context,
		java.lang.Long _sampleSize,
		java.util.List<randomobject.proxies.ExampleObject> _exampleObjectList_Input
	)
	{
		Object result = exampleObject_GetSampleBuilder(
				_sampleSize,
				_exampleObjectList_Input
			)
			.execute(context);
		return result == null ? null : com.mendix.utils.ListUtils.map((java.util.List<IMendixObject>) result, obj -> randomobject.proxies.ExampleObject.initialize(context, obj));
	}
}
