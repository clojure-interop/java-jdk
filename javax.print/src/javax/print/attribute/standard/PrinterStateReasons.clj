(ns javax.print.attribute.standard.PrinterStateReasons
  "Class PrinterStateReasons is a printing attribute class, a set of
  enumeration values, that provides additional information about the
  printer's current state, i.e., information that augments the value of the
  printer's PrinterState attribute.

  Instances of PrinterStateReason do not appear in
   a Print Service's attribute set directly. Rather, a PrinterStateReasons
  attribute appears in the Print Service's attribute set. The
  PrinterStateReasons attribute contains zero, one, or more than one PrinterStateReason objects which pertain to the Print
  Service's status, and each PrinterStateReason
  object is associated with a Severity level of REPORT
   (least severe), WARNING, or ERROR (most severe). The printer adds a PrinterStateReason object to the Print Service's
  PrinterStateReasons attribute when the corresponding condition becomes true
  of the printer, and the printer removes the PrinterStateReason object again when the corresponding condition becomes
  false, regardless of whether the Print Service's overall
  PrinterState also changed.

  Class PrinterStateReasons inherits its implementation from class java.util.HashMap. Each entry in the map consists of a
  PrinterStateReason object (key) mapping to a
  Severity object (value):

  Unlike most printing attributes which are immutable once constructed, class
  PrinterStateReasons is designed to be mutable; you can add PrinterStateReason objects to an existing
  PrinterStateReasons object and remove them again. However, like class
   java.util.HashMap, class PrinterStateReasons is
  not multiple thread safe. If a PrinterStateReasons object will be used by
  multiple threads, be sure to synchronize its operations (e.g., using a
  synchronized map view obtained from class java.util.Collections).

  IPP Compatibility: The string values returned by each individual
  PrinterStateReason object's and the associated
  Severity object's toString() methods,
  concatenated
  together with a hyphen (`-`) in between, gives the IPP keyword
  value. The category name returned by getName() gives the IPP
  attribute name."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.print.attribute.standard PrinterStateReasons]))

(defn ->printer-state-reasons
  "Constructor.

  Construct a new, empty printer state reasons attribute; the underlying
   hash map has the given initial capacity and load factor.

  initial-capacity - Initial capacity. - `int`
  load-factor - Load factor. - `float`

  throws: java.lang.IllegalArgumentException - if the initial capacity is less than zero."
  ([^Integer initial-capacity ^Float load-factor]
    (new PrinterStateReasons initial-capacity load-factor))
  ([^Integer initial-capacity]
    (new PrinterStateReasons initial-capacity))
  ([]
    (new PrinterStateReasons )))

(defn put
  "Adds the given printer state reason to this printer state reasons
   attribute, associating it with the given severity level. If this
   printer state reasons attribute previously contained a mapping for the
   given printer state reason, the old value is replaced.

  reason - Printer state reason. This must be an instance of class PrinterStateReason. - `javax.print.attribute.standard.PrinterStateReason`
  severity - Severity of the printer state reason. This must be an instance of class Severity. - `javax.print.attribute.standard.Severity`

  returns: Previous severity associated with the given printer state
            reason, or null if the given printer state reason was
            not present. - `javax.print.attribute.standard.Severity`

  throws: java.lang.NullPointerException - (unchecked exception) Thrown if reason is null or severity is null."
  ([^javax.print.attribute.standard.PrinterStateReasons this ^javax.print.attribute.standard.PrinterStateReason reason ^javax.print.attribute.standard.Severity severity]
    (-> this (.put reason severity))))

(defn get-category
  "Get the printing attribute class which is to be used as the `category`
   for this printing attribute value.

   For class PrinterStateReasons, the
   category is class PrinterStateReasons itself.

  returns: Printing attribute class (category), an instance of class
            java.lang.Class. - `java.lang.Class<? extends javax.print.attribute.Attribute>`"
  ([^javax.print.attribute.standard.PrinterStateReasons this]
    (-> this (.getCategory))))

(defn get-name
  "Get the name of the category of which this attribute value is an
   instance.

   For class PrinterStateReasons, the
   category name is `printer-state-reasons`.

  returns: Attribute category name. - `java.lang.String`"
  ([^javax.print.attribute.standard.PrinterStateReasons this]
    (-> this (.getName))))

(defn printer-state-reason-set
  "Obtain an unmodifiable set view of the individual printer state reason
   attributes at the given severity level in this PrinterStateReasons
   attribute. Each element in the set view is a PrinterStateReason object. The only elements in the set view are the
   PrinterStateReason objects that map to the
   given severity value. The set view is backed by this
   PrinterStateReasons attribute, so changes to this PrinterStateReasons
   attribute are reflected  in the set view.
   The set view does not support element insertion or
   removal. The set view's iterator does not support element removal.

  severity - Severity level. - `javax.print.attribute.standard.Severity`

  returns: Set view of the individual PrinterStateReason attributes at the given Severity level. - `java.util.Set<javax.print.attribute.standard.PrinterStateReason>`

  throws: java.lang.NullPointerException - (unchecked exception) Thrown if severity is null."
  ([^javax.print.attribute.standard.PrinterStateReasons this ^javax.print.attribute.standard.Severity severity]
    (-> this (.printerStateReasonSet severity))))

