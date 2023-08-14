// This file was generated by Mendix Studio Pro.
//
// WARNING: Code you write here will be lost the next time you deploy the project.

package anonymous.proxies;

public class Anonymous implements com.mendix.systemwideinterfaces.core.IEntityProxy
{
	private final com.mendix.systemwideinterfaces.core.IMendixObject anonymousMendixObject;

	private final com.mendix.systemwideinterfaces.core.IContext context;

	/**
	 * Internal name of this entity
	 */
	public static final java.lang.String entityName = "Anonymous.Anonymous";

	/**
	 * Enum describing members of this entity
	 */
	public enum MemberNames
	{
		Name("Name"),
		Password("Password"),
		ConfirmPassword("ConfirmPassword"),
		Mail("Mail"),
		FullName("FullName"),
		IsLogin("IsLogin");

		private final java.lang.String metaName;

		MemberNames(java.lang.String s)
		{
			metaName = s;
		}

		@java.lang.Override
		public java.lang.String toString()
		{
			return metaName;
		}
	}

	public Anonymous(com.mendix.systemwideinterfaces.core.IContext context)
	{
		this(context, com.mendix.core.Core.instantiate(context, entityName));
	}

	protected Anonymous(com.mendix.systemwideinterfaces.core.IContext context, com.mendix.systemwideinterfaces.core.IMendixObject anonymousMendixObject)
	{
		if (anonymousMendixObject == null) {
			throw new java.lang.IllegalArgumentException("The given object cannot be null.");
		}
		if (!com.mendix.core.Core.isSubClassOf(entityName, anonymousMendixObject.getType())) {
			throw new java.lang.IllegalArgumentException(String.format("The given object is not a %s", entityName));
		}	

		this.anonymousMendixObject = anonymousMendixObject;
		this.context = context;
	}

	/**
	 * Initialize a proxy using context (recommended). This context will be used for security checking when the get- and set-methods without context parameters are called.
	 * The get- and set-methods with context parameter should be used when for instance sudo access is necessary (IContext.createSudoClone() can be used to obtain sudo access).
	 * @param context The context to be used
	 * @param mendixObject The Mendix object for the new instance
	 * @return a new instance of this proxy class
	 */
	public static anonymous.proxies.Anonymous initialize(com.mendix.systemwideinterfaces.core.IContext context, com.mendix.systemwideinterfaces.core.IMendixObject mendixObject)
	{
		return new anonymous.proxies.Anonymous(context, mendixObject);
	}

	public static anonymous.proxies.Anonymous load(com.mendix.systemwideinterfaces.core.IContext context, com.mendix.systemwideinterfaces.core.IMendixIdentifier mendixIdentifier) throws com.mendix.core.CoreException
	{
		com.mendix.systemwideinterfaces.core.IMendixObject mendixObject = com.mendix.core.Core.retrieveId(context, mendixIdentifier);
		return anonymous.proxies.Anonymous.initialize(context, mendixObject);
	}

	/**
	 * @return value of Name
	 */
	public final java.lang.String getName()
	{
		return getName(getContext());
	}

	/**
	 * @param context
	 * @return value of Name
	 */
	public final java.lang.String getName(com.mendix.systemwideinterfaces.core.IContext context)
	{
		return (java.lang.String) getMendixObject().getValue(context, MemberNames.Name.toString());
	}

	/**
	 * Set value of Name
	 * @param name
	 */
	public final void setName(java.lang.String name)
	{
		setName(getContext(), name);
	}

	/**
	 * Set value of Name
	 * @param context
	 * @param name
	 */
	public final void setName(com.mendix.systemwideinterfaces.core.IContext context, java.lang.String name)
	{
		getMendixObject().setValue(context, MemberNames.Name.toString(), name);
	}

	/**
	 * @return value of Password
	 */
	public final java.lang.String getPassword()
	{
		return getPassword(getContext());
	}

	/**
	 * @param context
	 * @return value of Password
	 */
	public final java.lang.String getPassword(com.mendix.systemwideinterfaces.core.IContext context)
	{
		return (java.lang.String) getMendixObject().getValue(context, MemberNames.Password.toString());
	}

	/**
	 * Set value of Password
	 * @param password
	 */
	public final void setPassword(java.lang.String password)
	{
		setPassword(getContext(), password);
	}

	/**
	 * Set value of Password
	 * @param context
	 * @param password
	 */
	public final void setPassword(com.mendix.systemwideinterfaces.core.IContext context, java.lang.String password)
	{
		getMendixObject().setValue(context, MemberNames.Password.toString(), password);
	}

	/**
	 * @return value of ConfirmPassword
	 */
	public final java.lang.String getConfirmPassword()
	{
		return getConfirmPassword(getContext());
	}

	/**
	 * @param context
	 * @return value of ConfirmPassword
	 */
	public final java.lang.String getConfirmPassword(com.mendix.systemwideinterfaces.core.IContext context)
	{
		return (java.lang.String) getMendixObject().getValue(context, MemberNames.ConfirmPassword.toString());
	}

	/**
	 * Set value of ConfirmPassword
	 * @param confirmpassword
	 */
	public final void setConfirmPassword(java.lang.String confirmpassword)
	{
		setConfirmPassword(getContext(), confirmpassword);
	}

	/**
	 * Set value of ConfirmPassword
	 * @param context
	 * @param confirmpassword
	 */
	public final void setConfirmPassword(com.mendix.systemwideinterfaces.core.IContext context, java.lang.String confirmpassword)
	{
		getMendixObject().setValue(context, MemberNames.ConfirmPassword.toString(), confirmpassword);
	}

	/**
	 * @return value of Mail
	 */
	public final java.lang.String getMail()
	{
		return getMail(getContext());
	}

	/**
	 * @param context
	 * @return value of Mail
	 */
	public final java.lang.String getMail(com.mendix.systemwideinterfaces.core.IContext context)
	{
		return (java.lang.String) getMendixObject().getValue(context, MemberNames.Mail.toString());
	}

	/**
	 * Set value of Mail
	 * @param mail
	 */
	public final void setMail(java.lang.String mail)
	{
		setMail(getContext(), mail);
	}

	/**
	 * Set value of Mail
	 * @param context
	 * @param mail
	 */
	public final void setMail(com.mendix.systemwideinterfaces.core.IContext context, java.lang.String mail)
	{
		getMendixObject().setValue(context, MemberNames.Mail.toString(), mail);
	}

	/**
	 * @return value of FullName
	 */
	public final java.lang.String getFullName()
	{
		return getFullName(getContext());
	}

	/**
	 * @param context
	 * @return value of FullName
	 */
	public final java.lang.String getFullName(com.mendix.systemwideinterfaces.core.IContext context)
	{
		return (java.lang.String) getMendixObject().getValue(context, MemberNames.FullName.toString());
	}

	/**
	 * Set value of FullName
	 * @param fullname
	 */
	public final void setFullName(java.lang.String fullname)
	{
		setFullName(getContext(), fullname);
	}

	/**
	 * Set value of FullName
	 * @param context
	 * @param fullname
	 */
	public final void setFullName(com.mendix.systemwideinterfaces.core.IContext context, java.lang.String fullname)
	{
		getMendixObject().setValue(context, MemberNames.FullName.toString(), fullname);
	}

	/**
	 * @return value of IsLogin
	 */
	public final java.lang.Boolean getIsLogin()
	{
		return getIsLogin(getContext());
	}

	/**
	 * @param context
	 * @return value of IsLogin
	 */
	public final java.lang.Boolean getIsLogin(com.mendix.systemwideinterfaces.core.IContext context)
	{
		return (java.lang.Boolean) getMendixObject().getValue(context, MemberNames.IsLogin.toString());
	}

	/**
	 * Set value of IsLogin
	 * @param islogin
	 */
	public final void setIsLogin(java.lang.Boolean islogin)
	{
		setIsLogin(getContext(), islogin);
	}

	/**
	 * Set value of IsLogin
	 * @param context
	 * @param islogin
	 */
	public final void setIsLogin(com.mendix.systemwideinterfaces.core.IContext context, java.lang.Boolean islogin)
	{
		getMendixObject().setValue(context, MemberNames.IsLogin.toString(), islogin);
	}

	@Override
	public final com.mendix.systemwideinterfaces.core.IMendixObject getMendixObject()
	{
		return anonymousMendixObject;
	}

	@Override
	public final com.mendix.systemwideinterfaces.core.IContext getContext()
	{
		return context;
	}

	@java.lang.Override
	public boolean equals(Object obj)
	{
		if (obj == this) {
			return true;
		}
		if (obj != null && getClass().equals(obj.getClass()))
		{
			final anonymous.proxies.Anonymous that = (anonymous.proxies.Anonymous) obj;
			return getMendixObject().equals(that.getMendixObject());
		}
		return false;
	}

	@java.lang.Override
	public int hashCode()
	{
		return getMendixObject().hashCode();
	}

  /**
   * Gives full name ("Module.Entity" name) of the type of the entity.
   *
   * @return the name
   */
	public static java.lang.String getType()
	{
		return entityName;
	}
}
