// This file was generated by Mendix Studio Pro.
//
// WARNING: Code you write here will be lost the next time you deploy the project.

package builder.proxies;

public class Course extends quizapp.proxies.RemoteObject
{
	/**
	 * Internal name of this entity
	 */
	public static final java.lang.String entityName = "Builder.Course";

	/**
	 * Enum describing members of this entity
	 */
	public enum MemberNames
	{
		CourseId("CourseId"),
		CourseName("CourseName"),
		_Id("_Id"),
		CustomCreatedDate("CustomCreatedDate"),
		CustomChangedDate("CustomChangedDate"),
		CustomCreatedDateAsLong("CustomCreatedDateAsLong"),
		CustomChangedDateAsLong("CustomChangedDateAsLong"),
		Course_School("Builder.Course_School"),
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

	public Course(com.mendix.systemwideinterfaces.core.IContext context)
	{
		this(context, com.mendix.core.Core.instantiate(context, entityName));
	}

	protected Course(com.mendix.systemwideinterfaces.core.IContext context, com.mendix.systemwideinterfaces.core.IMendixObject courseMendixObject)
	{
		super(context, courseMendixObject);
		if (!com.mendix.core.Core.isSubClassOf(entityName, courseMendixObject.getType())) {
			throw new java.lang.IllegalArgumentException(String.format("The given object is not a %s", entityName));
		}	
	}

	/**
	 * Initialize a proxy using context (recommended). This context will be used for security checking when the get- and set-methods without context parameters are called.
	 * The get- and set-methods with context parameter should be used when for instance sudo access is necessary (IContext.createSudoClone() can be used to obtain sudo access).
	 * @param context The context to be used
	 * @param mendixObject The Mendix object for the new instance
	 * @return a new instance of this proxy class
	 */
	public static builder.proxies.Course initialize(com.mendix.systemwideinterfaces.core.IContext context, com.mendix.systemwideinterfaces.core.IMendixObject mendixObject)
	{
		return new builder.proxies.Course(context, mendixObject);
	}

	public static builder.proxies.Course load(com.mendix.systemwideinterfaces.core.IContext context, com.mendix.systemwideinterfaces.core.IMendixIdentifier mendixIdentifier) throws com.mendix.core.CoreException
	{
		com.mendix.systemwideinterfaces.core.IMendixObject mendixObject = com.mendix.core.Core.retrieveId(context, mendixIdentifier);
		return builder.proxies.Course.initialize(context, mendixObject);
	}

	public static java.util.List<builder.proxies.Course> load(com.mendix.systemwideinterfaces.core.IContext context, java.lang.String xpathConstraint) throws com.mendix.core.CoreException
	{
		return com.mendix.core.Core.createXPathQuery(String.format("//%1$s%2$s", entityName, xpathConstraint))
			.execute(context)
			.stream()
			.map(obj -> builder.proxies.Course.initialize(context, obj))
			.collect(java.util.stream.Collectors.toList());
	}

	/**
	 * @return value of CourseId
	 */
	public final java.lang.Long getCourseId()
	{
		return getCourseId(getContext());
	}

	/**
	 * @param context
	 * @return value of CourseId
	 */
	public final java.lang.Long getCourseId(com.mendix.systemwideinterfaces.core.IContext context)
	{
		return (java.lang.Long) getMendixObject().getValue(context, MemberNames.CourseId.toString());
	}

	/**
	 * Set value of CourseId
	 * @param courseid
	 */
	public final void setCourseId(java.lang.Long courseid)
	{
		setCourseId(getContext(), courseid);
	}

	/**
	 * Set value of CourseId
	 * @param context
	 * @param courseid
	 */
	public final void setCourseId(com.mendix.systemwideinterfaces.core.IContext context, java.lang.Long courseid)
	{
		getMendixObject().setValue(context, MemberNames.CourseId.toString(), courseid);
	}

	/**
	 * @return value of CourseName
	 */
	public final java.lang.String getCourseName()
	{
		return getCourseName(getContext());
	}

	/**
	 * @param context
	 * @return value of CourseName
	 */
	public final java.lang.String getCourseName(com.mendix.systemwideinterfaces.core.IContext context)
	{
		return (java.lang.String) getMendixObject().getValue(context, MemberNames.CourseName.toString());
	}

	/**
	 * Set value of CourseName
	 * @param coursename
	 */
	public final void setCourseName(java.lang.String coursename)
	{
		setCourseName(getContext(), coursename);
	}

	/**
	 * Set value of CourseName
	 * @param context
	 * @param coursename
	 */
	public final void setCourseName(com.mendix.systemwideinterfaces.core.IContext context, java.lang.String coursename)
	{
		getMendixObject().setValue(context, MemberNames.CourseName.toString(), coursename);
	}

	/**
	 * @throws com.mendix.core.CoreException
	 * @return value of Course_School
	 */
	public final builder.proxies.School getCourse_School() throws com.mendix.core.CoreException
	{
		return getCourse_School(getContext());
	}

	/**
	 * @param context
	 * @return value of Course_School
	 * @throws com.mendix.core.CoreException
	 */
	public final builder.proxies.School getCourse_School(com.mendix.systemwideinterfaces.core.IContext context) throws com.mendix.core.CoreException
	{
		builder.proxies.School result = null;
		com.mendix.systemwideinterfaces.core.IMendixIdentifier identifier = getMendixObject().getValue(context, MemberNames.Course_School.toString());
		if (identifier != null) {
			result = builder.proxies.School.load(context, identifier);
		}
		return result;
	}

	/**
	 * Set value of Course_School
	 * @param course_school
	 */
	public final void setCourse_School(builder.proxies.School course_school)
	{
		setCourse_School(getContext(), course_school);
	}

	/**
	 * Set value of Course_School
	 * @param context
	 * @param course_school
	 */
	public final void setCourse_School(com.mendix.systemwideinterfaces.core.IContext context, builder.proxies.School course_school)
	{
		if (course_school == null) {
			getMendixObject().setValue(context, MemberNames.Course_School.toString(), null);
		} else {
			getMendixObject().setValue(context, MemberNames.Course_School.toString(), course_school.getMendixObject().getId());
		}
	}

	@java.lang.Override
	public boolean equals(Object obj)
	{
		if (obj == this) {
			return true;
		}
		if (obj != null && getClass().equals(obj.getClass()))
		{
			final builder.proxies.Course that = (builder.proxies.Course) obj;
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
