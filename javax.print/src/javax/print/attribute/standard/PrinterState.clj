(ns javax.print.attribute.standard.PrinterState
  "Class PrinterState is a printing attribute class, an enumeration, that
  identifies the current state of a printer. Class PrinterState defines
  standard printer state values. A Print Service implementation only needs
  to report those printer states which are appropriate for the particular
  implementation; it does not have to report every defined printer state. The
  PrinterStateReasons attribute augments the
  PrinterState attribute to give more detailed information about the printer
  in  given printer state.

  IPP Compatibility: The category name returned by
  getName() is the IPP attribute name.  The enumeration's
  integer value is the IPP enum value.  The toString() method
  returns the IPP string representation of the attribute value."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.print.attribute.standard PrinterState]))

(def *-unknown
  "Static Constant.

  The printer state is unknown.

  type: javax.print.attribute.standard.PrinterState"
  PrinterState/UNKNOWN)

(def *-idle
  "Static Constant.

  Indicates that new jobs can start processing without waiting.

  type: javax.print.attribute.standard.PrinterState"
  PrinterState/IDLE)

(def *-processing
  "Static Constant.

  Indicates that jobs are processing;
   new jobs will wait before processing.

  type: javax.print.attribute.standard.PrinterState"
  PrinterState/PROCESSING)

(def *-stopped
  "Static Constant.

  Indicates that no jobs can be processed and intervention is required.

  type: javax.print.attribute.standard.PrinterState"
  PrinterState/STOPPED)

(defn get-category
  "Get the printing attribute class which is to be used as the \"category\"
   for this printing attribute value.

   For class PrinterState, the category is class PrinterState itself.

  returns: Printing attribute class (category), an instance of class
            java.lang.Class. - `java.lang.Class<? extends javax.print.attribute.Attribute>`"
  ([^PrinterState this]
    (-> this (.getCategory))))

(defn get-name
  "Get the name of the category of which this attribute value is an
   instance.

   For class PrinterState, the category name is \"printer-state\".

  returns: Attribute category name. - `java.lang.String`"
  (^java.lang.String [^PrinterState this]
    (-> this (.getName))))

