(ns javax.print.attribute.standard.Severity
  "Class Severity is a printing attribute class, an enumeration, that denotes
  the severity of a PrinterStateReason attribute.

  Instances of Severity do not appear in a Print Service's attribute set
  directly. Rather, a PrinterStateReasons
  attribute appears in the Print Service's attribute set.
   The PrinterStateReasons attribute contains zero, one, or more than one PrinterStateReason objects which pertain to the Print
  Service's status, and each PrinterStateReason
  object is associated with a Severity level of REPORT (least severe),
  WARNING, or ERROR (most severe).
  The printer adds a PrinterStateReason object to the Print Service's
  PrinterStateReasons attribute when the
  corresponding condition becomes true
  of the printer, and the printer removes the PrinterStateReason object again when the corresponding condition becomes
  false, regardless of whether the Print Service's overall
  PrinterState also changed.

  IPP Compatibility:
  Severity.toString() returns either `error`, `warning`, or
  `report`.  The string values returned by
  each individual PrinterStateReason and
  associated Severity object's toString()
  methods, concatenated together with a hyphen (`-`) in
  between, gives the IPP keyword value for a PrinterStateReasons.
  The category name returned by getName() gives the IPP
  attribute name."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.print.attribute.standard Severity]))

(def *-report
  "Static Constant.

  Indicates that the PrinterStateReason is a
   `report` (least severe). An implementation may choose to omit some or
   all reports.
   Some reports specify finer granularity about the printer state;
   others serve as a precursor to a warning. A report must contain nothing
   that could affect the printed output.

  type: javax.print.attribute.standard.Severity"
  Severity/REPORT)

(def *-warning
  "Static Constant.

  Indicates that the PrinterStateReason is a
   `warning.` An implementation may choose to omit some or all warnings.
   Warnings serve as a precursor to an error. A warning must contain
   nothing  that prevents a job from completing, though in some cases the
   output may be of lower quality.

  type: javax.print.attribute.standard.Severity"
  Severity/WARNING)

(def *-error
  "Static Constant.

  Indicates that the PrinterStateReason is an
   `error` (most severe). An implementation must include all errors.
   If this attribute contains one or more errors, the printer's
   PrinterState must be STOPPED.

  type: javax.print.attribute.standard.Severity"
  Severity/ERROR)

(defn get-category
  "Get the printing attribute class which is to be used as the `category`
   for this printing attribute value.

   For class Severity, the category is class Severity itself.

  returns: Printing attribute class (category), an instance of class
            java.lang.Class. - `java.lang.Class<? extends javax.print.attribute.Attribute>`"
  ([this]
    (-> this (.getCategory))))

(defn get-name
  "Get the name of the category of which this attribute value is an
   instance.

   For class Severit, the category name is `severity`.

  returns: Attribute category name. - `java.lang.String`"
  ([this]
    (-> this (.getName))))

