(ns javax.print.attribute.standard.JobKOctetsProcessed
  "Class JobKOctetsProcessed is an integer valued printing attribute class that
  specifies the total number of print data octets processed so far in K octets,
  i.e., in units of 1024 octets. The value must be rounded up, so that a job
  between 1 and 1024 octets inclusive must be indicated as being 1K octets,
  1025 to 2048 inclusive must be 2K, etc. For a multidoc print job (a job with
  multiple documents), the JobKOctetsProcessed value is computed by adding up
  the individual documents' number of octets processed so far, then rounding up
  to the next K octets value.

  The JobKOctetsProcessed attribute describes the progress of the job. This
  attribute is intended to be a counter. That is, the JobKOctetsProcessed value
  for a job that has not started processing must be 0. When the job's JobState is PROCESSING or PROCESSING_STOPPED, the
  JobKOctetsProcessed value is intended to increase as the job is processed; it
  indicates the amount of the job that has been processed at the time the Print
  Job's attribute set is queried or at the time a print job event is reported.
  When the job enters the COMPLETED, CANCELED, or ABORTED states, the
  JobKOctetsProcessed value is the final value for the job.

  For implementations where multiple copies are produced by the interpreter
  with only a single pass over the data, the final value of the
  JobKOctetsProcessed attribute must be equal to the value of the JobKOctets attribute. For implementations where multiple copies
  are produced by the interpreter by processing the data for each copy, the
  final value must be a multiple of the value of the JobKOctets attribute.

  IPP Compatibility: The integer value gives the IPP integer value. The
  category name returned by getName() gives the IPP attribute
  name."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.print.attribute.standard JobKOctetsProcessed]))

(defn ->job-k-octets-processed
  "Constructor.

  Construct a new job K octets processed attribute with the given integer
   value.

  value - Integer value. - `int`

  throws: java.lang.IllegalArgumentException - (Unchecked exception) Thrown if value is less than 0."
  (^JobKOctetsProcessed [^Integer value]
    (new JobKOctetsProcessed value)))

(defn equals
  "Returns whether this job K octets processed attribute is equivalent to
   the passed in object. To be equivalent, all of the following conditions
   must be true:


   object is not null.

   object is an instance of class JobKOctetsProcessed.

   This job K octets processed attribute's value and
   object's value are equal.

  object - Object to compare to. - `java.lang.Object`

  returns: True if object is equivalent to this job K
            octets processed attribute, false otherwise. - `boolean`"
  (^Boolean [^JobKOctetsProcessed this ^java.lang.Object object]
    (-> this (.equals object))))

(defn get-category
  "Get the printing attribute class which is to be used as the `category`
   for this printing attribute value.

   For class JobKOctetsProcessed, the category is class
   JobKOctetsProcessed itself.

  returns: Printing attribute class (category), an instance of class
            java.lang.Class. - `java.lang.Class<? extends javax.print.attribute.Attribute>`"
  ([^JobKOctetsProcessed this]
    (-> this (.getCategory))))

(defn get-name
  "Get the name of the category of which this attribute value is an
   instance.

   For class JobKOctetsProcessed, the category name is
   `job-k-octets-processed`.

  returns: Attribute category name. - `java.lang.String`"
  (^java.lang.String [^JobKOctetsProcessed this]
    (-> this (.getName))))

