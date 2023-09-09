// This file was generated by Mendix Studio Pro.
//
// WARNING: Code you write here will be lost the next time you deploy the project.

package dataservice.proxies;

public class DS_Test implements com.mendix.systemwideinterfaces.core.IEntityProxy
{
	private final com.mendix.systemwideinterfaces.core.IMendixObject dS_TestMendixObject;

	private final com.mendix.systemwideinterfaces.core.IContext context;

	/**
	 * Internal name of this entity
	 */
	public static final java.lang.String entityName = "DataService.DS_Test";

	/**
	 * Enum describing members of this entity
	 */
	public enum MemberNames
	{
		TestName("TestName"),
		DS_Test_DS_TestArray("DataService.DS_Test_DS_TestArray"),
		DS_QuestionArray_DS_Test("DataService.DS_QuestionArray_DS_Test");

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

	public DS_Test(com.mendix.systemwideinterfaces.core.IContext context)
	{
		this(context, com.mendix.core.Core.instantiate(context, entityName));
	}

	protected DS_Test(com.mendix.systemwideinterfaces.core.IContext context, com.mendix.systemwideinterfaces.core.IMendixObject dS_TestMendixObject)
	{
		if (dS_TestMendixObject == null) {
			throw new java.lang.IllegalArgumentException("The given object cannot be null.");
		}
		if (!com.mendix.core.Core.isSubClassOf(entityName, dS_TestMendixObject.getType())) {
			throw new java.lang.IllegalArgumentException(String.format("The given object is not a %s", entityName));
		}	

		this.dS_TestMendixObject = dS_TestMendixObject;
		this.context = context;
	}

	/**
	 * Initialize a proxy using context (recommended). This context will be used for security checking when the get- and set-methods without context parameters are called.
	 * The get- and set-methods with context parameter should be used when for instance sudo access is necessary (IContext.createSudoClone() can be used to obtain sudo access).
	 * @param context The context to be used
	 * @param mendixObject The Mendix object for the new instance
	 * @return a new instance of this proxy class
	 */
	public static dataservice.proxies.DS_Test initialize(com.mendix.systemwideinterfaces.core.IContext context, com.mendix.systemwideinterfaces.core.IMendixObject mendixObject)
	{
		return new dataservice.proxies.DS_Test(context, mendixObject);
	}

	public static dataservice.proxies.DS_Test load(com.mendix.systemwideinterfaces.core.IContext context, com.mendix.systemwideinterfaces.core.IMendixIdentifier mendixIdentifier) throws com.mendix.core.CoreException
	{
		com.mendix.systemwideinterfaces.core.IMendixObject mendixObject = com.mendix.core.Core.retrieveId(context, mendixIdentifier);
		return dataservice.proxies.DS_Test.initialize(context, mendixObject);
	}

	/**
	 * @return value of TestName
	 */
	public final java.lang.String getTestName()
	{
		return getTestName(getContext());
	}

	/**
	 * @param context
	 * @return value of TestName
	 */
	public final java.lang.String getTestName(com.mendix.systemwideinterfaces.core.IContext context)
	{
		return (java.lang.String) getMendixObject().getValue(context, MemberNames.TestName.toString());
	}

	/**
	 * Set value of TestName
	 * @param testname
	 */
	public final void setTestName(java.lang.String testname)
	{
		setTestName(getContext(), testname);
	}

	/**
	 * Set value of TestName
	 * @param context
	 * @param testname
	 */
	public final void setTestName(com.mendix.systemwideinterfaces.core.IContext context, java.lang.String testname)
	{
		getMendixObject().setValue(context, MemberNames.TestName.toString(), testname);
	}

	/**
	 * @throws com.mendix.core.CoreException
	 * @return value of DS_Test_DS_TestArray
	 */
	public final dataservice.proxies.DS_TestArray getDS_Test_DS_TestArray() throws com.mendix.core.CoreException
	{
		return getDS_Test_DS_TestArray(getContext());
	}

	/**
	 * @param context
	 * @return value of DS_Test_DS_TestArray
	 * @throws com.mendix.core.CoreException
	 */
	public final dataservice.proxies.DS_TestArray getDS_Test_DS_TestArray(com.mendix.systemwideinterfaces.core.IContext context) throws com.mendix.core.CoreException
	{
		dataservice.proxies.DS_TestArray result = null;
		com.mendix.systemwideinterfaces.core.IMendixIdentifier identifier = getMendixObject().getValue(context, MemberNames.DS_Test_DS_TestArray.toString());
		if (identifier != null) {
			result = dataservice.proxies.DS_TestArray.load(context, identifier);
		}
		return result;
	}

	/**
	 * Set value of DS_Test_DS_TestArray
	 * @param ds_test_ds_testarray
	 */
	public final void setDS_Test_DS_TestArray(dataservice.proxies.DS_TestArray ds_test_ds_testarray)
	{
		setDS_Test_DS_TestArray(getContext(), ds_test_ds_testarray);
	}

	/**
	 * Set value of DS_Test_DS_TestArray
	 * @param context
	 * @param ds_test_ds_testarray
	 */
	public final void setDS_Test_DS_TestArray(com.mendix.systemwideinterfaces.core.IContext context, dataservice.proxies.DS_TestArray ds_test_ds_testarray)
	{
		if (ds_test_ds_testarray == null) {
			getMendixObject().setValue(context, MemberNames.DS_Test_DS_TestArray.toString(), null);
		} else {
			getMendixObject().setValue(context, MemberNames.DS_Test_DS_TestArray.toString(), ds_test_ds_testarray.getMendixObject().getId());
		}
	}

	/**
	 * @throws com.mendix.core.CoreException
	 * @return value of DS_QuestionArray_DS_Test
	 */
	public final dataservice.proxies.DS_QuestionArray getDS_QuestionArray_DS_Test() throws com.mendix.core.CoreException
	{
		return getDS_QuestionArray_DS_Test(getContext());
	}

	/**
	 * @param context
	 * @return value of DS_QuestionArray_DS_Test
	 * @throws com.mendix.core.CoreException
	 */
	public final dataservice.proxies.DS_QuestionArray getDS_QuestionArray_DS_Test(com.mendix.systemwideinterfaces.core.IContext context) throws com.mendix.core.CoreException
	{
		dataservice.proxies.DS_QuestionArray result = null;
		com.mendix.systemwideinterfaces.core.IMendixIdentifier identifier = getMendixObject().getValue(context, MemberNames.DS_QuestionArray_DS_Test.toString());
		if (identifier != null) {
			result = dataservice.proxies.DS_QuestionArray.load(context, identifier);
		}
		return result;
	}

	/**
	 * Set value of DS_QuestionArray_DS_Test
	 * @param ds_questionarray_ds_test
	 */
	public final void setDS_QuestionArray_DS_Test(dataservice.proxies.DS_QuestionArray ds_questionarray_ds_test)
	{
		setDS_QuestionArray_DS_Test(getContext(), ds_questionarray_ds_test);
	}

	/**
	 * Set value of DS_QuestionArray_DS_Test
	 * @param context
	 * @param ds_questionarray_ds_test
	 */
	public final void setDS_QuestionArray_DS_Test(com.mendix.systemwideinterfaces.core.IContext context, dataservice.proxies.DS_QuestionArray ds_questionarray_ds_test)
	{
		if (ds_questionarray_ds_test == null) {
			getMendixObject().setValue(context, MemberNames.DS_QuestionArray_DS_Test.toString(), null);
		} else {
			getMendixObject().setValue(context, MemberNames.DS_QuestionArray_DS_Test.toString(), ds_questionarray_ds_test.getMendixObject().getId());
		}
	}

	@Override
	public final com.mendix.systemwideinterfaces.core.IMendixObject getMendixObject()
	{
		return dS_TestMendixObject;
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
			final dataservice.proxies.DS_Test that = (dataservice.proxies.DS_Test) obj;
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