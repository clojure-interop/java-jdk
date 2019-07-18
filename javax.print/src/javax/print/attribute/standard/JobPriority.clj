(ns javax.print.attribute.standard.JobPriority
  "Class JobPriority is an integer valued printing attribute class that
  specifies a print job's priority.

  If a JobPriority attribute is specified for a Print Job, it specifies a
  priority for scheduling the job. A higher value specifies a higher priority.
  The value 1 indicates the lowest possible priority. The value 100 indicates
  the highest possible priority. Among those jobs that are ready to print, a
  printer must print all jobs with a priority value of n before printing
  those with a priority value of n-1 for all n.

  If the client does not specify a JobPriority attribute for a Print Job and
  the printer does support the JobPriority attribute, the printer must use an
  implementation-defined default JobPriority value.

  The client can always specify any job priority value from 1 to 100 for a job.
  However, a Print Service instance may support fewer than 100 different
  job priority levels. If this is the case, the Print Service instance
  automatically maps the client-specified job priority value to one of the
  supported job priority levels, dividing the 100 job priority values equally
  among the available job priority levels.

  IPP Compatibility: The integer value gives the IPP integer value. The
  category name returned by getName() gives the IPP attribute
  name."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.print.attribute.standard JobPriority]))

(defn ->job-priority
  "Constructor.

  Construct a new job priority attribute with the given integer value.

  value - Integer value. - `int`

  throws: java.lang.IllegalArgumentException - (Unchecked exception) Thrown if value is less than 1 or greater than 100."
  (^JobPriority [^Integer value]
    (new JobPriority value)))

(defn equals
  "Returns whether this job priority attribute is equivalent to the passed
   in object. To be equivalent, all of the following conditions must be
   true:


   object is not null.

   object is an instance of class JobPriority.

   This job priority attribute's value and object's value
   are equal.

  object - Object to compare to. - `java.lang.Object`

  returns: True if object is equivalent to this job
            priority attribute, false otherwise. - `boolean`"
  (^Boolean [^JobPriority this ^java.lang.Object object]
    (-> this (.equals object))))

(defn get-category
  "Get the printing attribute class which is to be used as the `category`
   for this printing attribute value.

   For class JobPriority, the category is class JobPriority itself.

  returns: Printing attribute class (category), an instance of class
            java.lang.Class. - `java.lang.Class<? extends javax.print.attribute.Attribute>`"
  ([^JobPriority this]
    (-> this (.getCategory))))

(defn get-name
  "Get the name of the category of which this attribute value is an
   instance.

   For class JobPriority, the category name is `job-priority`.

  returns: Attribute category name. - `java.lang.String`"
  (^java.lang.String [^JobPriority this]
    (-> this (.getName))))

