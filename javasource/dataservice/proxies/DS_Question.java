// This file was generated by Mendix Studio Pro.
//
// WARNING: Code you write here will be lost the next time you deploy the project.

package dataservice.proxies;

public class DS_Question implements com.mendix.systemwideinterfaces.core.IEntityProxy
{
	private final com.mendix.systemwideinterfaces.core.IMendixObject dS_QuestionMendixObject;

	private final com.mendix.systemwideinterfaces.core.IContext context;

	/**
	 * Internal name of this entity
	 */
	public static final java.lang.String entityName = "DataService.DS_Question";

	/**
	 * Enum describing members of this entity
	 */
	public enum MemberNames
	{
		QuestionBody("QuestionBody"),
		OptionA("OptionA"),
		OptionB("OptionB"),
		OptionC("OptionC"),
		OptionD("OptionD"),
		Answer("Answer"),
		Sort("Sort"),
		DS_Question_DS_QuestionArray("DataService.DS_Question_DS_QuestionArray");

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

	public DS_Question(com.mendix.systemwideinterfaces.core.IContext context)
	{
		this(context, com.mendix.core.Core.instantiate(context, entityName));
	}

	protected DS_Question(com.mendix.systemwideinterfaces.core.IContext context, com.mendix.systemwideinterfaces.core.IMendixObject dS_QuestionMendixObject)
	{
		if (dS_QuestionMendixObject == null) {
			throw new java.lang.IllegalArgumentException("The given object cannot be null.");
		}
		if (!com.mendix.core.Core.isSubClassOf(entityName, dS_QuestionMendixObject.getType())) {
			throw new java.lang.IllegalArgumentException(String.format("The given object is not a %s", entityName));
		}	

		this.dS_QuestionMendixObject = dS_QuestionMendixObject;
		this.context = context;
	}

	/**
	 * Initialize a proxy using context (recommended). This context will be used for security checking when the get- and set-methods without context parameters are called.
	 * The get- and set-methods with context parameter should be used when for instance sudo access is necessary (IContext.createSudoClone() can be used to obtain sudo access).
	 * @param context The context to be used
	 * @param mendixObject The Mendix object for the new instance
	 * @return a new instance of this proxy class
	 */
	public static dataservice.proxies.DS_Question initialize(com.mendix.systemwideinterfaces.core.IContext context, com.mendix.systemwideinterfaces.core.IMendixObject mendixObject)
	{
		return new dataservice.proxies.DS_Question(context, mendixObject);
	}

	public static dataservice.proxies.DS_Question load(com.mendix.systemwideinterfaces.core.IContext context, com.mendix.systemwideinterfaces.core.IMendixIdentifier mendixIdentifier) throws com.mendix.core.CoreException
	{
		com.mendix.systemwideinterfaces.core.IMendixObject mendixObject = com.mendix.core.Core.retrieveId(context, mendixIdentifier);
		return dataservice.proxies.DS_Question.initialize(context, mendixObject);
	}

	/**
	 * @return value of QuestionBody
	 */
	public final java.lang.String getQuestionBody()
	{
		return getQuestionBody(getContext());
	}

	/**
	 * @param context
	 * @return value of QuestionBody
	 */
	public final java.lang.String getQuestionBody(com.mendix.systemwideinterfaces.core.IContext context)
	{
		return (java.lang.String) getMendixObject().getValue(context, MemberNames.QuestionBody.toString());
	}

	/**
	 * Set value of QuestionBody
	 * @param questionbody
	 */
	public final void setQuestionBody(java.lang.String questionbody)
	{
		setQuestionBody(getContext(), questionbody);
	}

	/**
	 * Set value of QuestionBody
	 * @param context
	 * @param questionbody
	 */
	public final void setQuestionBody(com.mendix.systemwideinterfaces.core.IContext context, java.lang.String questionbody)
	{
		getMendixObject().setValue(context, MemberNames.QuestionBody.toString(), questionbody);
	}

	/**
	 * @return value of OptionA
	 */
	public final java.lang.String getOptionA()
	{
		return getOptionA(getContext());
	}

	/**
	 * @param context
	 * @return value of OptionA
	 */
	public final java.lang.String getOptionA(com.mendix.systemwideinterfaces.core.IContext context)
	{
		return (java.lang.String) getMendixObject().getValue(context, MemberNames.OptionA.toString());
	}

	/**
	 * Set value of OptionA
	 * @param optiona
	 */
	public final void setOptionA(java.lang.String optiona)
	{
		setOptionA(getContext(), optiona);
	}

	/**
	 * Set value of OptionA
	 * @param context
	 * @param optiona
	 */
	public final void setOptionA(com.mendix.systemwideinterfaces.core.IContext context, java.lang.String optiona)
	{
		getMendixObject().setValue(context, MemberNames.OptionA.toString(), optiona);
	}

	/**
	 * @return value of OptionB
	 */
	public final java.lang.String getOptionB()
	{
		return getOptionB(getContext());
	}

	/**
	 * @param context
	 * @return value of OptionB
	 */
	public final java.lang.String getOptionB(com.mendix.systemwideinterfaces.core.IContext context)
	{
		return (java.lang.String) getMendixObject().getValue(context, MemberNames.OptionB.toString());
	}

	/**
	 * Set value of OptionB
	 * @param optionb
	 */
	public final void setOptionB(java.lang.String optionb)
	{
		setOptionB(getContext(), optionb);
	}

	/**
	 * Set value of OptionB
	 * @param context
	 * @param optionb
	 */
	public final void setOptionB(com.mendix.systemwideinterfaces.core.IContext context, java.lang.String optionb)
	{
		getMendixObject().setValue(context, MemberNames.OptionB.toString(), optionb);
	}

	/**
	 * @return value of OptionC
	 */
	public final java.lang.String getOptionC()
	{
		return getOptionC(getContext());
	}

	/**
	 * @param context
	 * @return value of OptionC
	 */
	public final java.lang.String getOptionC(com.mendix.systemwideinterfaces.core.IContext context)
	{
		return (java.lang.String) getMendixObject().getValue(context, MemberNames.OptionC.toString());
	}

	/**
	 * Set value of OptionC
	 * @param optionc
	 */
	public final void setOptionC(java.lang.String optionc)
	{
		setOptionC(getContext(), optionc);
	}

	/**
	 * Set value of OptionC
	 * @param context
	 * @param optionc
	 */
	public final void setOptionC(com.mendix.systemwideinterfaces.core.IContext context, java.lang.String optionc)
	{
		getMendixObject().setValue(context, MemberNames.OptionC.toString(), optionc);
	}

	/**
	 * @return value of OptionD
	 */
	public final java.lang.String getOptionD()
	{
		return getOptionD(getContext());
	}

	/**
	 * @param context
	 * @return value of OptionD
	 */
	public final java.lang.String getOptionD(com.mendix.systemwideinterfaces.core.IContext context)
	{
		return (java.lang.String) getMendixObject().getValue(context, MemberNames.OptionD.toString());
	}

	/**
	 * Set value of OptionD
	 * @param optiond
	 */
	public final void setOptionD(java.lang.String optiond)
	{
		setOptionD(getContext(), optiond);
	}

	/**
	 * Set value of OptionD
	 * @param context
	 * @param optiond
	 */
	public final void setOptionD(com.mendix.systemwideinterfaces.core.IContext context, java.lang.String optiond)
	{
		getMendixObject().setValue(context, MemberNames.OptionD.toString(), optiond);
	}

	/**
	 * Get value of Answer
	 * @param answer
	 */
	public final builder.proxies.ENUM_Answer getAnswer()
	{
		return getAnswer(getContext());
	}

	/**
	 * @param context
	 * @return value of Answer
	 */
	public final builder.proxies.ENUM_Answer getAnswer(com.mendix.systemwideinterfaces.core.IContext context)
	{
		Object obj = getMendixObject().getValue(context, MemberNames.Answer.toString());
		if (obj == null) {
			return null;
		}
		return builder.proxies.ENUM_Answer.valueOf((java.lang.String) obj);
	}

	/**
	 * Set value of Answer
	 * @param answer
	 */
	public final void setAnswer(builder.proxies.ENUM_Answer answer)
	{
		setAnswer(getContext(), answer);
	}

	/**
	 * Set value of Answer
	 * @param context
	 * @param answer
	 */
	public final void setAnswer(com.mendix.systemwideinterfaces.core.IContext context, builder.proxies.ENUM_Answer answer)
	{
		if (answer != null) {
			getMendixObject().setValue(context, MemberNames.Answer.toString(), answer.toString());
		} else {
			getMendixObject().setValue(context, MemberNames.Answer.toString(), null);
		}
	}

	/**
	 * @return value of Sort
	 */
	public final java.lang.Integer getSort()
	{
		return getSort(getContext());
	}

	/**
	 * @param context
	 * @return value of Sort
	 */
	public final java.lang.Integer getSort(com.mendix.systemwideinterfaces.core.IContext context)
	{
		return (java.lang.Integer) getMendixObject().getValue(context, MemberNames.Sort.toString());
	}

	/**
	 * Set value of Sort
	 * @param sort
	 */
	public final void setSort(java.lang.Integer sort)
	{
		setSort(getContext(), sort);
	}

	/**
	 * Set value of Sort
	 * @param context
	 * @param sort
	 */
	public final void setSort(com.mendix.systemwideinterfaces.core.IContext context, java.lang.Integer sort)
	{
		getMendixObject().setValue(context, MemberNames.Sort.toString(), sort);
	}

	/**
	 * @throws com.mendix.core.CoreException
	 * @return value of DS_Question_DS_QuestionArray
	 */
	public final dataservice.proxies.DS_QuestionArray getDS_Question_DS_QuestionArray() throws com.mendix.core.CoreException
	{
		return getDS_Question_DS_QuestionArray(getContext());
	}

	/**
	 * @param context
	 * @return value of DS_Question_DS_QuestionArray
	 * @throws com.mendix.core.CoreException
	 */
	public final dataservice.proxies.DS_QuestionArray getDS_Question_DS_QuestionArray(com.mendix.systemwideinterfaces.core.IContext context) throws com.mendix.core.CoreException
	{
		dataservice.proxies.DS_QuestionArray result = null;
		com.mendix.systemwideinterfaces.core.IMendixIdentifier identifier = getMendixObject().getValue(context, MemberNames.DS_Question_DS_QuestionArray.toString());
		if (identifier != null) {
			result = dataservice.proxies.DS_QuestionArray.load(context, identifier);
		}
		return result;
	}

	/**
	 * Set value of DS_Question_DS_QuestionArray
	 * @param ds_question_ds_questionarray
	 */
	public final void setDS_Question_DS_QuestionArray(dataservice.proxies.DS_QuestionArray ds_question_ds_questionarray)
	{
		setDS_Question_DS_QuestionArray(getContext(), ds_question_ds_questionarray);
	}

	/**
	 * Set value of DS_Question_DS_QuestionArray
	 * @param context
	 * @param ds_question_ds_questionarray
	 */
	public final void setDS_Question_DS_QuestionArray(com.mendix.systemwideinterfaces.core.IContext context, dataservice.proxies.DS_QuestionArray ds_question_ds_questionarray)
	{
		if (ds_question_ds_questionarray == null) {
			getMendixObject().setValue(context, MemberNames.DS_Question_DS_QuestionArray.toString(), null);
		} else {
			getMendixObject().setValue(context, MemberNames.DS_Question_DS_QuestionArray.toString(), ds_question_ds_questionarray.getMendixObject().getId());
		}
	}

	@Override
	public final com.mendix.systemwideinterfaces.core.IMendixObject getMendixObject()
	{
		return dS_QuestionMendixObject;
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
			final dataservice.proxies.DS_Question that = (dataservice.proxies.DS_Question) obj;
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
