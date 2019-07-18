(ns javax.print.attribute.standard.PrinterIsAcceptingJobs
  "Class PrinterIsAcceptingJobs is a printing attribute class, an enumeration,
  that indicates whether the printer is currently able to accept jobs. This
  value is independent of the PrinterState and PrinterStateReasons attributes because its value does
  not affect the current job; rather it affects future jobs. If the value is
  NOT_ACCEPTING_JOBS, the printer will reject jobs even when the PrinterState is IDLE. If value is ACCEPTING_JOBS, the Printer
  will accept jobs even when the PrinterState is STOPPED.

  IPP Compatibility: The IPP boolean value is `true` for ACCEPTING_JOBS
  and `false` for NOT_ACCEPTING_JOBS. The category name returned by
  getName() is the IPP attribute name.  The enumeration's
  integer value is the IPP enum value.  The toString() method
  returns the IPP string representation of the attribute value."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.print.attribute.standard PrinterIsAcceptingJobs]))

(def *-not-accepting-jobs
  "Static Constant.

  The printer is currently rejecting any jobs sent to it.

  type: javax.print.attribute.standard.PrinterIsAcceptingJobs"
  PrinterIsAcceptingJobs/NOT_ACCEPTING_JOBS)

(def *-accepting-jobs
  "Static Constant.

  The printer is currently accepting jobs.

  type: javax.print.attribute.standard.PrinterIsAcceptingJobs"
  PrinterIsAcceptingJobs/ACCEPTING_JOBS)

(defn get-category
  "Get the printing attribute class which is to be used as the `category`
   for this printing attribute value.

   For class PrinterIsAcceptingJobs, the
   category is class PrinterIsAcceptingJobs itself.

  returns: Printing attribute class (category), an instance of class
            java.lang.Class. - `java.lang.Class<? extends javax.print.attribute.Attribute>`"
  ([^PrinterIsAcceptingJobs this]
    (-> this (.getCategory))))

(defn get-name
  "Get the name of the category of which this attribute value is an
   instance.

   For class PrinterIsAcceptingJobs, the
   category name is `printer-is-accepting-jobs`.

  returns: Attribute category name. - `java.lang.String`"
  (^java.lang.String [^PrinterIsAcceptingJobs this]
    (-> this (.getName))))

