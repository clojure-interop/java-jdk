(ns javax.print.attribute.standard.JobName
  "Class JobName is a printing attribute class, a text attribute, that specifies
  the name of a print job. A job's name is an arbitrary string defined by the
  client. It does not need to be unique between different jobs. A Print Job's
  JobName attribute is set to the value supplied by the client in the Print
  Request's attribute set. If, however, the client does not supply a JobName
  attribute in the Print Request, the printer, when it creates the Print Job,
  must generate a JobName. The printer should generate the value of the Print
  Job's JobName attribute from the first of the following sources that produces
  a value: (1) the DocumentName attribute of the first (or
  only) doc in the job, (2) the URL of the first (or only) doc in the job, if
  the doc's print data representation object is a URL, or (3) any other piece
  of Print Job specific and/or document content information.

  IPP Compatibility: The string value gives the IPP name value. The
  locale gives the IPP natural language. The category name returned by
  getName() gives the IPP attribute name."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.print.attribute.standard JobName]))

(defn ->job-name
  "Constructor.

  Constructs a new job name attribute with the given job name and locale.

  job-name - Job name. - `java.lang.String`
  locale - Natural language of the text string. null is interpreted to mean the default locale as returned by Locale.getDefault() - `java.util.Locale`

  throws: java.lang.NullPointerException - (unchecked exception) Thrown if jobName is null."
  ([^java.lang.String job-name ^java.util.Locale locale]
    (new JobName job-name locale)))

(defn equals
  "Returns whether this job name attribute is equivalent to the passed in
   object. To be equivalent, all of the following conditions must be true:


   object is not null.

   object is an instance of class JobName.

   This job name attribute's underlying string and object's
   underlying string are equal.

   This job name attribute's locale and object's locale are
   equal.

  object - Object to compare to. - `java.lang.Object`

  returns: True if object is equivalent to this job name
            attribute, false otherwise. - `boolean`"
  (^Boolean [^javax.print.attribute.standard.JobName this ^java.lang.Object object]
    (-> this (.equals object))))

(defn get-category
  "Get the printing attribute class which is to be used as the `category`
   for this printing attribute value.

   For class JobName, the category is class JobName itself.

  returns: Printing attribute class (category), an instance of class
            java.lang.Class. - `java.lang.Class<? extends javax.print.attribute.Attribute>`"
  ([^javax.print.attribute.standard.JobName this]
    (-> this (.getCategory))))

(defn get-name
  "Get the name of the category of which this attribute value is an
   instance.

   For class JobName, the category name is `job-name`.

  returns: Attribute category name. - `java.lang.String`"
  (^java.lang.String [^javax.print.attribute.standard.JobName this]
    (-> this (.getName))))

