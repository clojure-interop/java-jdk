(ns javax.print.attribute.standard.JobImpressionsCompleted
  "Class JobImpressionsCompleted is an integer valued printing attribute class
  that specifies the number of impressions completed for the job so far. For
  printing devices, the impressions completed includes interpreting, marking,
  and stacking the output.

  The JobImpressionsCompleted attribute describes the progress of the job. This
  attribute is intended to be a counter. That is, the JobImpressionsCompleted
  value for a job that has not started processing must be 0. When the job's
  JobState is PROCESSING or PROCESSING_STOPPED, the
  JobImpressionsCompleted value is intended to increase as the job is
  processed; it indicates the amount of the job that has been processed at the
  time the Print Job's attribute set is queried or at the time a print job
  event is reported. When the job enters the COMPLETED, CANCELED, or ABORTED
  states, the JobImpressionsCompleted value is the final value for the job.

  IPP Compatibility: The integer value gives the IPP integer value. The
  category name returned by getName() gives the IPP attribute
  name."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.print.attribute.standard JobImpressionsCompleted]))

(defn ->job-impressions-completed
  "Constructor.

  Construct a new job impressions completed attribute with the given
   integer value.

  value - Integer value. - `int`

  throws: java.lang.IllegalArgumentException - (Unchecked exception) Thrown if value is less than 0."
  ([^Integer value]
    (new JobImpressionsCompleted value)))

(defn equals
  "Returns whether this job impressions completed attribute is equivalent
   tp the passed in object. To be equivalent, all of the following
   conditions must be true:


   object is not null.

   object is an instance of class JobImpressionsCompleted.

   This job impressions completed attribute's value and
   object's value are equal.

  object - Object to compare to. - `java.lang.Object`

  returns: True if object is equivalent to this job
            impressions completed attribute, false otherwise. - `boolean`"
  ([^javax.print.attribute.standard.JobImpressionsCompleted this ^java.lang.Object object]
    (-> this (.equals object))))

(defn get-category
  "Get the printing attribute class which is to be used as the `category`
   for this printing attribute value.

   For class JobImpressionsCompleted, the category is class
   JobImpressionsCompleted itself.

  returns: Printing attribute class (category), an instance of class
            java.lang.Class. - `java.lang.Class<? extends javax.print.attribute.Attribute>`"
  ([^javax.print.attribute.standard.JobImpressionsCompleted this]
    (-> this (.getCategory))))

(defn get-name
  "Get the name of the category of which this attribute value is an
   instance.

   For class JobImpressionsCompleted, the category name is
   `job-impressions-completed`.

  returns: Attribute category name. - `java.lang.String`"
  ([^javax.print.attribute.standard.JobImpressionsCompleted this]
    (-> this (.getName))))

