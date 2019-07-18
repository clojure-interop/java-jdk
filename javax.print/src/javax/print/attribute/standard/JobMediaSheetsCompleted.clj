(ns javax.print.attribute.standard.JobMediaSheetsCompleted
  "Class JobMediaSheetsCompleted is an integer valued printing attribute class
  that specifies the number of media sheets which have completed marking and
  stacking for the entire job so far, whether those sheets have been processed
  on one side or on both.

  The JobMediaSheetsCompleted attribute describes the progress of the job. This
  attribute is intended to be a counter. That is, the JobMediaSheetsCompleted
  value for a job that has not started processing must be 0. When the job's
  JobState is PROCESSING or PROCESSING_STOPPED, the
  JobMediaSheetsCompleted value is intended to increase as the job is
  processed; it indicates the amount of the job that has been processed at the
  time the Print Job's attribute set is queried or at the time a print job
  event is reported. When the job enters the COMPLETED, CANCELED, or ABORTED
  states, the JobMediaSheetsCompleted value is the final value for the job.

  IPP Compatibility: The integer value gives the IPP integer value. The
  category name returned by getName() gives the IPP attribute
  name."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.print.attribute.standard JobMediaSheetsCompleted]))

(defn ->job-media-sheets-completed
  "Constructor.

  Construct a new job media sheets completed attribute with the given
   integer value.

  value - Integer value. - `int`

  throws: java.lang.IllegalArgumentException - (Unchecked exception) Thrown if value is less than 0."
  (^JobMediaSheetsCompleted [^Integer value]
    (new JobMediaSheetsCompleted value)))

(defn equals
  "Returns whether this job media sheets completed attribute is equivalent
   to the passed in object. To be equivalent, all of the following
   conditions must be true:


   object is not null.

   object is an instance of class JobMediaSheetsCompleted.

   This job media sheets completed attribute's value and
   object's value are equal.

  object - Object to compare to. - `java.lang.Object`

  returns: True if object is equivalent to this job media
            sheets completed attribute, false otherwise. - `boolean`"
  (^Boolean [^JobMediaSheetsCompleted this ^java.lang.Object object]
    (-> this (.equals object))))

(defn get-category
  "Get the printing attribute class which is to be used as the `category`
   for this printing attribute value.

   For class JobMediaSheetsCompleted, the category is class
   JobMediaSheetsCompleted itself.

  returns: Printing attribute class (category), an instance of class
            java.lang.Class. - `java.lang.Class<? extends javax.print.attribute.Attribute>`"
  ([^JobMediaSheetsCompleted this]
    (-> this (.getCategory))))

(defn get-name
  "Get the name of the category of which this attribute value is an
   instance.

   For class JobMediaSheetsCompleted, the category name is
   `job-media-sheets-completed`.

  returns: Attribute category name. - `java.lang.String`"
  (^java.lang.String [^JobMediaSheetsCompleted this]
    (-> this (.getName))))

