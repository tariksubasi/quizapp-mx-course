// This file was generated by Mendix Studio Pro.
//
// WARNING: Code you write here will be lost the next time you deploy the project.

package quizapp.proxies;

public class RemoteObject implements com.mendix.systemwideinterfaces.core.IEntityProxy
{
	private final com.mendix.systemwideinterfaces.core.IMendixObject remoteObjectMendixObject;

	private final com.mendix.systemwideinterfaces.core.IContext context;

	/**
	 * Internal name of this entity
	 */
	public static final java.lang.String entityName = "QuizApp.RemoteObject";

	/**
	 * Enum describing members of this entity
	 */
	public enum MemberNames
	{
		_Id("_Id"),
		CustomCreatedDate("CustomCreatedDate"),
		CustomChangedDate("CustomChangedDate"),
		CustomCreatedDateAsLong("CustomCreatedDateAsLong"),
		CustomChangedDateAsLong("CustomChangedDateAsLong"),
		RemoteObject_Account_CreatedBy("QuizApp.RemoteObject_Account_CreatedBy"),
		RemoteObject_Account_ChangedBy("QuizApp.RemoteObject_Account_ChangedBy");

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

	public RemoteObject(com.mendix.systemwideinterfaces.core.IContext context)
	{
		this(context, com.mendix.core.Core.instantiate(context, entityName));
	}

	protected RemoteObject(com.mendix.systemwideinterfaces.core.IContext context, com.mendix.systemwideinterfaces.core.IMendixObject remoteObjectMendixObject)
	{
		if (remoteObjectMendixObject == null) {
			throw new java.lang.IllegalArgumentException("The given object cannot be null.");
		}
		if (!com.mendix.core.Core.isSubClassOf(entityName, remoteObjectMendixObject.getType())) {
			throw new java.lang.IllegalArgumentException(String.format("The given object is not a %s", entityName));
		}	

		this.remoteObjectMendixObject = remoteObjectMendixObject;
		this.context = context;
	}

	/**
	 * Initialize a proxy using context (recommended). This context will be used for security checking when the get- and set-methods without context parameters are called.
	 * The get- and set-methods with context parameter should be used when for instance sudo access is necessary (IContext.createSudoClone() can be used to obtain sudo access).
	 * @param context The context to be used
	 * @param mendixObject The Mendix object for the new instance
	 * @return a new instance of this proxy class
	 */
	public static quizapp.proxies.RemoteObject initialize(com.mendix.systemwideinterfaces.core.IContext context, com.mendix.systemwideinterfaces.core.IMendixObject mendixObject)
	{
		if (com.mendix.core.Core.isSubClassOf("QuizApp.Car", mendixObject.getType())) {
			return quizapp.proxies.Car.initialize(context, mendixObject);
		}
		if (com.mendix.core.Core.isSubClassOf("Builder.Course", mendixObject.getType())) {
			return builder.proxies.Course.initialize(context, mendixObject);
		}
		if (com.mendix.core.Core.isSubClassOf("Builder.Lecture", mendixObject.getType())) {
			return builder.proxies.Lecture.initialize(context, mendixObject);
		}
		if (com.mendix.core.Core.isSubClassOf("QuizApp.MotorCycle", mendixObject.getType())) {
			return quizapp.proxies.MotorCycle.initialize(context, mendixObject);
		}
		if (com.mendix.core.Core.isSubClassOf("Builder.Question", mendixObject.getType())) {
			return builder.proxies.Question.initialize(context, mendixObject);
		}
		if (com.mendix.core.Core.isSubClassOf("Builder.School", mendixObject.getType())) {
			return builder.proxies.School.initialize(context, mendixObject);
		}
		if (com.mendix.core.Core.isSubClassOf("Builder.Test", mendixObject.getType())) {
			return builder.proxies.Test.initialize(context, mendixObject);
		}
		return new quizapp.proxies.RemoteObject(context, mendixObject);
	}

	public static quizapp.proxies.RemoteObject load(com.mendix.systemwideinterfaces.core.IContext context, com.mendix.systemwideinterfaces.core.IMendixIdentifier mendixIdentifier) throws com.mendix.core.CoreException
	{
		com.mendix.systemwideinterfaces.core.IMendixObject mendixObject = com.mendix.core.Core.retrieveId(context, mendixIdentifier);
		return quizapp.proxies.RemoteObject.initialize(context, mendixObject);
	}

	public static java.util.List<? extends quizapp.proxies.RemoteObject> load(com.mendix.systemwideinterfaces.core.IContext context, java.lang.String xpathConstraint) throws com.mendix.core.CoreException
	{
		return com.mendix.core.Core.createXPathQuery(String.format("//%1$s%2$s", entityName, xpathConstraint))
			.execute(context)
			.stream()
			.map(obj -> quizapp.proxies.RemoteObject.initialize(context, obj))
			.collect(java.util.stream.Collectors.toList());
	}

	/**
	 * @return value of _Id
	 */
	public final java.lang.String get_Id()
	{
		return get_Id(getContext());
	}

	/**
	 * @param context
	 * @return value of _Id
	 */
	public final java.lang.String get_Id(com.mendix.systemwideinterfaces.core.IContext context)
	{
		return (java.lang.String) getMendixObject().getValue(context, MemberNames._Id.toString());
	}

	/**
	 * Set value of _Id
	 * @param _id
	 */
	public final void set_Id(java.lang.String _id)
	{
		set_Id(getContext(), _id);
	}

	/**
	 * Set value of _Id
	 * @param context
	 * @param _id
	 */
	public final void set_Id(com.mendix.systemwideinterfaces.core.IContext context, java.lang.String _id)
	{
		getMendixObject().setValue(context, MemberNames._Id.toString(), _id);
	}

	/**
	 * @return value of CustomCreatedDate
	 */
	public final java.util.Date getCustomCreatedDate()
	{
		return getCustomCreatedDate(getContext());
	}

	/**
	 * @param context
	 * @return value of CustomCreatedDate
	 */
	public final java.util.Date getCustomCreatedDate(com.mendix.systemwideinterfaces.core.IContext context)
	{
		return (java.util.Date) getMendixObject().getValue(context, MemberNames.CustomCreatedDate.toString());
	}

	/**
	 * Set value of CustomCreatedDate
	 * @param customcreateddate
	 */
	public final void setCustomCreatedDate(java.util.Date customcreateddate)
	{
		setCustomCreatedDate(getContext(), customcreateddate);
	}

	/**
	 * Set value of CustomCreatedDate
	 * @param context
	 * @param customcreateddate
	 */
	public final void setCustomCreatedDate(com.mendix.systemwideinterfaces.core.IContext context, java.util.Date customcreateddate)
	{
		getMendixObject().setValue(context, MemberNames.CustomCreatedDate.toString(), customcreateddate);
	}

	/**
	 * @return value of CustomChangedDate
	 */
	public final java.util.Date getCustomChangedDate()
	{
		return getCustomChangedDate(getContext());
	}

	/**
	 * @param context
	 * @return value of CustomChangedDate
	 */
	public final java.util.Date getCustomChangedDate(com.mendix.systemwideinterfaces.core.IContext context)
	{
		return (java.util.Date) getMendixObject().getValue(context, MemberNames.CustomChangedDate.toString());
	}

	/**
	 * Set value of CustomChangedDate
	 * @param customchangeddate
	 */
	public final void setCustomChangedDate(java.util.Date customchangeddate)
	{
		setCustomChangedDate(getContext(), customchangeddate);
	}

	/**
	 * Set value of CustomChangedDate
	 * @param context
	 * @param customchangeddate
	 */
	public final void setCustomChangedDate(com.mendix.systemwideinterfaces.core.IContext context, java.util.Date customchangeddate)
	{
		getMendixObject().setValue(context, MemberNames.CustomChangedDate.toString(), customchangeddate);
	}

	/**
	 * @return value of CustomCreatedDateAsLong
	 */
	public final java.lang.Long getCustomCreatedDateAsLong()
	{
		return getCustomCreatedDateAsLong(getContext());
	}

	/**
	 * @param context
	 * @return value of CustomCreatedDateAsLong
	 */
	public final java.lang.Long getCustomCreatedDateAsLong(com.mendix.systemwideinterfaces.core.IContext context)
	{
		return (java.lang.Long) getMendixObject().getValue(context, MemberNames.CustomCreatedDateAsLong.toString());
	}

	/**
	 * Set value of CustomCreatedDateAsLong
	 * @param customcreateddateaslong
	 */
	public final void setCustomCreatedDateAsLong(java.lang.Long customcreateddateaslong)
	{
		setCustomCreatedDateAsLong(getContext(), customcreateddateaslong);
	}

	/**
	 * Set value of CustomCreatedDateAsLong
	 * @param context
	 * @param customcreateddateaslong
	 */
	public final void setCustomCreatedDateAsLong(com.mendix.systemwideinterfaces.core.IContext context, java.lang.Long customcreateddateaslong)
	{
		getMendixObject().setValue(context, MemberNames.CustomCreatedDateAsLong.toString(), customcreateddateaslong);
	}

	/**
	 * @return value of CustomChangedDateAsLong
	 */
	public final java.lang.Long getCustomChangedDateAsLong()
	{
		return getCustomChangedDateAsLong(getContext());
	}

	/**
	 * @param context
	 * @return value of CustomChangedDateAsLong
	 */
	public final java.lang.Long getCustomChangedDateAsLong(com.mendix.systemwideinterfaces.core.IContext context)
	{
		return (java.lang.Long) getMendixObject().getValue(context, MemberNames.CustomChangedDateAsLong.toString());
	}

	/**
	 * Set value of CustomChangedDateAsLong
	 * @param customchangeddateaslong
	 */
	public final void setCustomChangedDateAsLong(java.lang.Long customchangeddateaslong)
	{
		setCustomChangedDateAsLong(getContext(), customchangeddateaslong);
	}

	/**
	 * Set value of CustomChangedDateAsLong
	 * @param context
	 * @param customchangeddateaslong
	 */
	public final void setCustomChangedDateAsLong(com.mendix.systemwideinterfaces.core.IContext context, java.lang.Long customchangeddateaslong)
	{
		getMendixObject().setValue(context, MemberNames.CustomChangedDateAsLong.toString(), customchangeddateaslong);
	}

	/**
	 * @throws com.mendix.core.CoreException
	 * @return value of RemoteObject_Account_CreatedBy
	 */
	public final administration.proxies.Account getRemoteObject_Account_CreatedBy() throws com.mendix.core.CoreException
	{
		return getRemoteObject_Account_CreatedBy(getContext());
	}

	/**
	 * @param context
	 * @return value of RemoteObject_Account_CreatedBy
	 * @throws com.mendix.core.CoreException
	 */
	public final administration.proxies.Account getRemoteObject_Account_CreatedBy(com.mendix.systemwideinterfaces.core.IContext context) throws com.mendix.core.CoreException
	{
		administration.proxies.Account result = null;
		com.mendix.systemwideinterfaces.core.IMendixIdentifier identifier = getMendixObject().getValue(context, MemberNames.RemoteObject_Account_CreatedBy.toString());
		if (identifier != null) {
			result = administration.proxies.Account.load(context, identifier);
		}
		return result;
	}

	/**
	 * Set value of RemoteObject_Account_CreatedBy
	 * @param remoteobject_account_createdby
	 */
	public final void setRemoteObject_Account_CreatedBy(administration.proxies.Account remoteobject_account_createdby)
	{
		setRemoteObject_Account_CreatedBy(getContext(), remoteobject_account_createdby);
	}

	/**
	 * Set value of RemoteObject_Account_CreatedBy
	 * @param context
	 * @param remoteobject_account_createdby
	 */
	public final void setRemoteObject_Account_CreatedBy(com.mendix.systemwideinterfaces.core.IContext context, administration.proxies.Account remoteobject_account_createdby)
	{
		if (remoteobject_account_createdby == null) {
			getMendixObject().setValue(context, MemberNames.RemoteObject_Account_CreatedBy.toString(), null);
		} else {
			getMendixObject().setValue(context, MemberNames.RemoteObject_Account_CreatedBy.toString(), remoteobject_account_createdby.getMendixObject().getId());
		}
	}

	/**
	 * @throws com.mendix.core.CoreException
	 * @return value of RemoteObject_Account_ChangedBy
	 */
	public final administration.proxies.Account getRemoteObject_Account_ChangedBy() throws com.mendix.core.CoreException
	{
		return getRemoteObject_Account_ChangedBy(getContext());
	}

	/**
	 * @param context
	 * @return value of RemoteObject_Account_ChangedBy
	 * @throws com.mendix.core.CoreException
	 */
	public final administration.proxies.Account getRemoteObject_Account_ChangedBy(com.mendix.systemwideinterfaces.core.IContext context) throws com.mendix.core.CoreException
	{
		administration.proxies.Account result = null;
		com.mendix.systemwideinterfaces.core.IMendixIdentifier identifier = getMendixObject().getValue(context, MemberNames.RemoteObject_Account_ChangedBy.toString());
		if (identifier != null) {
			result = administration.proxies.Account.load(context, identifier);
		}
		return result;
	}

	/**
	 * Set value of RemoteObject_Account_ChangedBy
	 * @param remoteobject_account_changedby
	 */
	public final void setRemoteObject_Account_ChangedBy(administration.proxies.Account remoteobject_account_changedby)
	{
		setRemoteObject_Account_ChangedBy(getContext(), remoteobject_account_changedby);
	}

	/**
	 * Set value of RemoteObject_Account_ChangedBy
	 * @param context
	 * @param remoteobject_account_changedby
	 */
	public final void setRemoteObject_Account_ChangedBy(com.mendix.systemwideinterfaces.core.IContext context, administration.proxies.Account remoteobject_account_changedby)
	{
		if (remoteobject_account_changedby == null) {
			getMendixObject().setValue(context, MemberNames.RemoteObject_Account_ChangedBy.toString(), null);
		} else {
			getMendixObject().setValue(context, MemberNames.RemoteObject_Account_ChangedBy.toString(), remoteobject_account_changedby.getMendixObject().getId());
		}
	}

	@Override
	public final com.mendix.systemwideinterfaces.core.IMendixObject getMendixObject()
	{
		return remoteObjectMendixObject;
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
			final quizapp.proxies.RemoteObject that = (quizapp.proxies.RemoteObject) obj;
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
