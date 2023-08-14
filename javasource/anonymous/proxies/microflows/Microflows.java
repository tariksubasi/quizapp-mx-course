// This file was generated by Mendix Studio Pro.
//
// WARNING: Code you write here will be lost the next time you deploy the project.

package anonymous.proxies.microflows;

import com.mendix.core.Core;
import com.mendix.systemwideinterfaces.core.IContext;

public final class Microflows
{
	/**
	 * Private constructor to prevent instantiation of this class. 
	 */
	private Microflows() {}

	// These are the microflows for the Anonymous module
	public static com.mendix.core.actionmanagement.MicroflowCallBuilder sUB_CreateAccountBuilder(
		anonymous.proxies.Anonymous _anonymous
	)
	{
		com.mendix.core.actionmanagement.MicroflowCallBuilder builder = Core.microflowCall("Anonymous.SUB_CreateAccount");
		builder = builder.withParam("Anonymous", _anonymous);
		return builder;
	}

	public static void sUB_CreateAccount(
		IContext context,
		anonymous.proxies.Anonymous _anonymous
	)
	{
		sUB_CreateAccountBuilder(
				_anonymous
			)
			.execute(context);
	}
}