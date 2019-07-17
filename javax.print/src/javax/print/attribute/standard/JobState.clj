(ns javax.print.attribute.standard.JobState
  "JobState is a printing attribute class, an enumeration, that identifies
  the current state of a print job. Class JobState defines standard job state
  values. A  Print Service implementation only needs to report those job
  states which are appropriate for the particular implementation; it does not
  have to report every defined job state. The JobStateReasons attribute augments the JobState attribute to give more
  detailed information about the job in the given job state.

  IPP Compatibility: The category name returned by
  getName() is the IPP attribute name.  The enumeration's
  integer value is the IPP enum value.  The toString() method
  returns the IPP string representation of the attribute value."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.print.attribute.standard JobState]))

(def *-unknown
  "Static Constant.

  The job state is unknown.

  type: javax.print.attribute.standard.JobState"
  JobState/UNKNOWN)

(def *-pending
  "Static Constant.

  The job is a candidate to start processing, but is not yet processing.

  type: javax.print.attribute.standard.JobState"
  JobState/PENDING)

(def *-pending-held
  "Static Constant.

  The job is not a candidate for processing for any number of reasons but
   will return to the PENDING state as soon as the reasons are no longer
   present. The job's JobStateReasons attribute must
   indicate why the job is no longer a candidate for processing.

  type: javax.print.attribute.standard.JobState"
  JobState/PENDING_HELD)

(def *-processing
  "Static Constant.

  The job is processing. One or more of the following activities is
   occurring:


   The job is using, or is attempting to use, one or more purely software
   processes that are analyzing, creating, or interpreting a PDL, etc.


   The job is using, or is attempting to use, one or more hardware
   devices that are interpreting a PDL, making marks on a medium, and/or
   performing finishing, such as stapling, etc.


   The printer has made the job ready for printing, but the output
   device is not yet printing it, either because the job hasn't reached the
   output device or because the job is queued in the output device or some
   other spooler, awaiting the output device to print it.


   When the job is in the PROCESSING state, the entire job state includes
   the detailed status represented in the printer's PrinterState and PrinterStateReasons
   attributes.

   Implementations may, though they need not, include additional values in
   the job's JobStateReasons attribute to indicate
   the progress of the job, such as adding the JOB_PRINTING value to
   indicate when the output device is actually making marks on paper and/or
   the PROCESSING_TO_STOP_POINT value to indicate that the printer is in the
   process of canceling or aborting the job.

  type: javax.print.attribute.standard.JobState"
  JobState/PROCESSING)

(def *-processing-stopped
  "Static Constant.

  The job has stopped while processing for any number of reasons and will
   return to the PROCESSING state as soon as the reasons are no longer
   present.

   The job's JobStateReasons attribute may indicate
   why the job has stopped processing. For example, if the output device is
   stopped, the PRINTER_STOPPED value may be included in the job's JobStateReasons attribute.

   Note: When an output device is stopped, the device usually
   indicates its condition in human readable form locally at the device. A
   client can obtain more complete device status remotely by querying the
   printer's PrinterState and PrinterStateReasons attributes.

  type: javax.print.attribute.standard.JobState"
  JobState/PROCESSING_STOPPED)

(def *-canceled
  "Static Constant.

  The job has been canceled by some human agency, the printer has completed
   canceling the job, and all job status attributes have reached their final
   values for the job. While the printer is canceling the job, the job
   remains in its current state, but the job's JobStateReasons attribute should contain the PROCESSING_TO_STOP_POINT
   value and one of the CANCELED_BY_USER, CANCELED_BY_OPERATOR, or
   CANCELED_AT_DEVICE values. When the job moves to the CANCELED state, the
   PROCESSING_TO_STOP_POINT value, if present, must be removed, but the
   CANCELED_BY_xxx value, if present, must remain.

  type: javax.print.attribute.standard.JobState"
  JobState/CANCELED)

(def *-aborted
  "Static Constant.

  The job has been aborted by the system (usually while the job was in the
   PROCESSING or PROCESSING_STOPPED state), the printer has completed
   aborting the job, and all job status attributes have reached their final
   values for the job. While the printer is aborting the job, the job
   remains in its current state, but the job's JobStateReasons attribute should contain the PROCESSING_TO_STOP_POINT
   and ABORTED_BY_SYSTEM values. When the job moves to the ABORTED state,
   the PROCESSING_TO_STOP_POINT value, if present, must be removed, but the
   ABORTED_BY_SYSTEM value, if present, must remain.

  type: javax.print.attribute.standard.JobState"
  JobState/ABORTED)

(def *-completed
  "Static Constant.

  The job has completed successfully or with warnings or errors after
   processing, all of the job media sheets have been successfully stacked in
   the appropriate output bin(s), and all job status attributes have reached
   their final values for the job. The job's JobStateReasons attribute should contain one of these values:
   COMPLETED_SUCCESSFULLY, COMPLETED_WITH_WARNINGS, or
   COMPLETED_WITH_ERRORS.

  type: javax.print.attribute.standard.JobState"
  JobState/COMPLETED)

(defn get-category
  "Get the printing attribute class which is to be used as the `category`
   for this printing attribute value.

   For class JobState and any vendor-defined subclasses, the category is
   class JobState itself.

  returns: Printing attribute class (category), an instance of class
            java.lang.Class. - `java.lang.Class<? extends javax.print.attribute.Attribute>`"
  ([^javax.print.attribute.standard.JobState this]
    (-> this (.getCategory))))

(defn get-name
  "Get the name of the category of which this attribute value is an
   instance.

   For class JobState and any vendor-defined subclasses, the category
   name is `job-state`.

  returns: Attribute category name. - `java.lang.String`"
  ([^javax.print.attribute.standard.JobState this]
    (-> this (.getName))))

