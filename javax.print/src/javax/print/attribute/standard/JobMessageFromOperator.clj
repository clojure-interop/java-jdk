(ns javax.print.attribute.standard.JobMessageFromOperator
  "Class JobMessageFromOperator is a printing attribute class, a text attribute,
  that provides a message from an operator, system administrator, or
  `intelligent` process to indicate to the end user the reasons for
  modification or other management action taken on a job.

  A Print Job's attribute set includes zero instances or one instance of a
  JobMessageFromOperator attribute, not more than one instance. A new
  JobMessageFromOperator attribute replaces an existing JobMessageFromOperator
  attribute, if any. In other words, JobMessageFromOperator is not intended to
  be a history log. If it wishes, the client can detect changes to a Print
  Job's JobMessageFromOperator attribute and maintain the client's own history
  log of the JobMessageFromOperator attribute values.

  IPP Compatibility: The string value gives the IPP name value. The
  locale gives the IPP natural language. The category name returned by
  getName() gives the IPP attribute name."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.print.attribute.standard JobMessageFromOperator]))

(defn ->job-message-from-operator
  "Constructor.

  Constructs a new job message from operator attribute with the given
   message and locale.

  message - Message. - `java.lang.String`
  locale - Natural language of the text string. null is interpreted to mean the default locale as returned by Locale.getDefault() - `java.util.Locale`

  throws: java.lang.NullPointerException - (unchecked exception) Thrown if message is null."
  ([^java.lang.String message ^java.util.Locale locale]
    (new JobMessageFromOperator message locale)))

(defn equals
  "Returns whether this job message from operator attribute is equivalent to
   the passed in object. To be equivalent, all of the following conditions
   must be true:


   object is not null.

   object is an instance of class JobMessageFromOperator.

   This job message from operator attribute's underlying string and
   object's underlying string are equal.

   This job message from operator attribute's locale and
   object's locale are equal.

  object - Object to compare to. - `java.lang.Object`

  returns: True if object is equivalent to this job
            message from operator attribute, false otherwise. - `boolean`"
  ([^javax.print.attribute.standard.JobMessageFromOperator this ^java.lang.Object object]
    (-> this (.equals object))))

(defn get-category
  "Get the printing attribute class which is to be used as the `category`
   for this printing attribute value.

   For class JobMessageFromOperator, the
   category is class JobMessageFromOperator itself.

  returns: Printing attribute class (category), an instance of class
            java.lang.Class. - `java.lang.Class<? extends javax.print.attribute.Attribute>`"
  ([^javax.print.attribute.standard.JobMessageFromOperator this]
    (-> this (.getCategory))))

(defn get-name
  "Get the name of the category of which this attribute value is an
   instance.

   For class JobMessageFromOperator, the
   category name is `job-message-from-operator`.

  returns: Attribute category name. - `java.lang.String`"
  ([^javax.print.attribute.standard.JobMessageFromOperator this]
    (-> this (.getName))))

