(ns javax.print.attribute.standard.JobOriginatingUserName
  "Class JobOriginatingUserName is a printing attribute class, a text
  attribute, that contains the name of the end user that submitted the
  print job. If possible, the printer sets this attribute to the most
  authenticated printable user name that it can obtain from the
  authentication service that authenticated the submitted Print Request.
  If such is not available, the printer uses the value of the
  RequestingUserName
  attribute supplied by the client in the Print Request's attribute set.
  If no authentication service is available, and the client did not supply
  a RequestingUserName attribute,
  the printer sets the JobOriginatingUserName attribute to an empty
  (zero-length) string.

  IPP Compatibility: The string value gives the IPP name value. The
  locale gives the IPP natural language. The category name returned by
  getName() gives the IPP attribute name."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.print.attribute.standard JobOriginatingUserName]))

(defn ->job-originating-user-name
  "Constructor.

  Constructs a new job originating user name attribute with the given
   user name and locale.

  user-name - User name. - `java.lang.String`
  locale - Natural language of the text string. null is interpreted to mean the default locale as returned by Locale.getDefault() - `java.util.Locale`

  throws: java.lang.NullPointerException - (unchecked exception) Thrown if userName is null."
  ([user-name locale]
    (new JobOriginatingUserName user-name locale)))

(defn equals
  "Returns whether this job originating user name attribute is equivalent to
   the passed in object. To be equivalent, all of the following conditions
   must be true:


   object is not null.

   object is an instance of class JobOriginatingUserName.

   This job originating user name attribute's underlying string and
   object's underlying string are equal.

   This job originating user name attribute's locale and
   object's locale are equal.

  object - Object to compare to. - `java.lang.Object`

  returns: True if object is equivalent to this job
            originating user name attribute, false otherwise. - `boolean`"
  ([this object]
    (-> this (.equals object))))

(defn get-category
  "Get the printing attribute class which is to be used as the `category`
   for this printing attribute value.

   For class JobOriginatingUserName, the
   category is class JobOriginatingUserName itself.

  returns: Printing attribute class (category), an instance of class
            java.lang.Class. - `java.lang.Class<? extends javax.print.attribute.Attribute>`"
  ([this]
    (-> this (.getCategory))))

(defn get-name
  "Get the name of the category of which this attribute value is an
   instance.

   For class JobOriginatingUserName, the
   category name is `job-originating-user-name`.

  returns: Attribute category name. - `java.lang.String`"
  ([this]
    (-> this (.getName))))

