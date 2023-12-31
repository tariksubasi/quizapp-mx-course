// This file was generated by Mendix Studio Pro.
//
// WARNING: Code you write here will be lost the next time you deploy the project.

package oql.proxies;

public class Query implements com.mendix.systemwideinterfaces.core.IEntityProxy
{
	private final com.mendix.systemwideinterfaces.core.IMendixObject queryMendixObject;

	private final com.mendix.systemwideinterfaces.core.IContext context;

	/**
	 * Internal name of this entity
	 */
	public static final java.lang.String entityName = "OQL.Query";

	/**
	 * Enum describing members of this entity
	 */
	public enum MemberNames
	{
		OQL("OQL"),
		CSV("CSV"),
		ShowAs("ShowAs");

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

	public Query(com.mendix.systemwideinterfaces.core.IContext context)
	{
		this(context, com.mendix.core.Core.instantiate(context, entityName));
	}

	protected Query(com.mendix.systemwideinterfaces.core.IContext context, com.mendix.systemwideinterfaces.core.IMendixObject queryMendixObject)
	{
		if (queryMendixObject == null) {
			throw new java.lang.IllegalArgumentException("The given object cannot be null.");
		}
		if (!com.mendix.core.Core.isSubClassOf(entityName, queryMendixObject.getType())) {
			throw new java.lang.IllegalArgumentException(String.format("The given object is not a %s", entityName));
		}	

		this.queryMendixObject = queryMendixObject;
		this.context = context;
	}

	/**
	 * Initialize a proxy using context (recommended). This context will be used for security checking when the get- and set-methods without context parameters are called.
	 * The get- and set-methods with context parameter should be used when for instance sudo access is necessary (IContext.createSudoClone() can be used to obtain sudo access).
	 * @param context The context to be used
	 * @param mendixObject The Mendix object for the new instance
	 * @return a new instance of this proxy class
	 */
	public static oql.proxies.Query initialize(com.mendix.systemwideinterfaces.core.IContext context, com.mendix.systemwideinterfaces.core.IMendixObject mendixObject)
	{
		return new oql.proxies.Query(context, mendixObject);
	}

	public static oql.proxies.Query load(com.mendix.systemwideinterfaces.core.IContext context, com.mendix.systemwideinterfaces.core.IMendixIdentifier mendixIdentifier) throws com.mendix.core.CoreException
	{
		com.mendix.systemwideinterfaces.core.IMendixObject mendixObject = com.mendix.core.Core.retrieveId(context, mendixIdentifier);
		return oql.proxies.Query.initialize(context, mendixObject);
	}

	/**
	 * @return value of OQL
	 */
	public final java.lang.String getOQL()
	{
		return getOQL(getContext());
	}

	/**
	 * @param context
	 * @return value of OQL
	 */
	public final java.lang.String getOQL(com.mendix.systemwideinterfaces.core.IContext context)
	{
		return (java.lang.String) getMendixObject().getValue(context, MemberNames.OQL.toString());
	}

	/**
	 * Set value of OQL
	 * @param oql
	 */
	public final void setOQL(java.lang.String oql)
	{
		setOQL(getContext(), oql);
	}

	/**
	 * Set value of OQL
	 * @param context
	 * @param oql
	 */
	public final void setOQL(com.mendix.systemwideinterfaces.core.IContext context, java.lang.String oql)
	{
		getMendixObject().setValue(context, MemberNames.OQL.toString(), oql);
	}

	/**
	 * @return value of CSV
	 */
	public final java.lang.String getCSV()
	{
		return getCSV(getContext());
	}

	/**
	 * @param context
	 * @return value of CSV
	 */
	public final java.lang.String getCSV(com.mendix.systemwideinterfaces.core.IContext context)
	{
		return (java.lang.String) getMendixObject().getValue(context, MemberNames.CSV.toString());
	}

	/**
	 * Set value of CSV
	 * @param csv
	 */
	public final void setCSV(java.lang.String csv)
	{
		setCSV(getContext(), csv);
	}

	/**
	 * Set value of CSV
	 * @param context
	 * @param csv
	 */
	public final void setCSV(com.mendix.systemwideinterfaces.core.IContext context, java.lang.String csv)
	{
		getMendixObject().setValue(context, MemberNames.CSV.toString(), csv);
	}

	/**
	 * Get value of ShowAs
	 * @param showas
	 */
	public final oql.proxies.ShowAs getShowAs()
	{
		return getShowAs(getContext());
	}

	/**
	 * @param context
	 * @return value of ShowAs
	 */
	public final oql.proxies.ShowAs getShowAs(com.mendix.systemwideinterfaces.core.IContext context)
	{
		Object obj = getMendixObject().getValue(context, MemberNames.ShowAs.toString());
		if (obj == null) {
			return null;
		}
		return oql.proxies.ShowAs.valueOf((java.lang.String) obj);
	}

	/**
	 * Set value of ShowAs
	 * @param showas
	 */
	public final void setShowAs(oql.proxies.ShowAs showas)
	{
		setShowAs(getContext(), showas);
	}

	/**
	 * Set value of ShowAs
	 * @param context
	 * @param showas
	 */
	public final void setShowAs(com.mendix.systemwideinterfaces.core.IContext context, oql.proxies.ShowAs showas)
	{
		if (showas != null) {
			getMendixObject().setValue(context, MemberNames.ShowAs.toString(), showas.toString());
		} else {
			getMendixObject().setValue(context, MemberNames.ShowAs.toString(), null);
		}
	}

	@Override
	public final com.mendix.systemwideinterfaces.core.IMendixObject getMendixObject()
	{
		return queryMendixObject;
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
			final oql.proxies.Query that = (oql.proxies.Query) obj;
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
