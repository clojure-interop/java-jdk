(ns javax.print.attribute.standard.JobPrioritySupported
  "Class JobPrioritySupported is an integer valued printing attribute class
  that specifies whether a Print Service instance supports the JobPriority attribute and the number of different job priority
  levels supported.

  The client can always specify any JobPriority value
  from 1 to 100 for a job. However, the Print Service instance may support
  fewer than 100 different job priority levels. If this is the case, the
  Print Service instance automatically maps the client-specified job priority
  value to one of the supported job priority levels, dividing the 100 job
  priority values equally among the available job priority levels.

  IPP Compatibility: The integer value gives the IPP integer value.
  The category name returned by getName() gives the IPP
  attribute name."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.print.attribute.standard JobPrioritySupported]))

(defn ->job-priority-supported
  "Constructor.

  Construct a new job priority supported attribute with the given integer
   value.

  value - Number of different job priority levels supported. - `int`

  throws: java.lang.IllegalArgumentException - (Unchecked exception) Thrown if value is less than 1 or greater than 100."
  ([^Integer value]
    (new JobPrioritySupported value)))

(defn equals
  "Returns whether this job priority supported attribute is equivalent to
   the passed in object. To be equivalent, all of the following conditions
   must be true:


   object is not null.

   object is an instance of class JobPrioritySupported.

   This job priority supported attribute's value and
   object's value are equal.

  object - Object to compare to. - `java.lang.Object`

  returns: True if object is equivalent to this job
            priority supported attribute, false otherwise. - `boolean`"
  ([^javax.print.attribute.standard.JobPrioritySupported this ^java.lang.Object object]
    (-> this (.equals object))))

(defn get-category
  "Get the printing attribute class which is to be used as the `category`
   for this printing attribute value.

   For class JobPrioritySupported, the
   category is class JobPrioritySupported itself.

  returns: Printing attribute class (category), an instance of class
            java.lang.Class. - `java.lang.Class<? extends javax.print.attribute.Attribute>`"
  ([^javax.print.attribute.standard.JobPrioritySupported this]
    (-> this (.getCategory))))

(defn get-name
  "Get the name of the category of which this attribute value is an
   instance.

   For class JobPrioritySupported, the
   category name is `job-priority-supported`.

  returns: Attribute category name. - `java.lang.String`"
  ([^javax.print.attribute.standard.JobPrioritySupported this]
    (-> this (.getName))))

