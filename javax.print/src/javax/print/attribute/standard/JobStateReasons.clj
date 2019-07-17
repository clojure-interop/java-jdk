(ns javax.print.attribute.standard.JobStateReasons
  "Class JobStateReasons is a printing attribute class, a set of enumeration
  values, that provides additional information about the job's current state,
  i.e., information that augments the value of the job's JobState attribute.

  Instances of JobStateReason do not appear in a Print
  Job's attribute set directly. Rather, a JobStateReasons attribute appears in
  the Print Job's attribute set. The JobStateReasons attribute contains zero,
  one, or more than one JobStateReason objects which
  pertain to the Print Job's status. The printer adds a JobStateReason object to the Print Job's JobStateReasons attribute when the
  corresponding condition becomes true of the Print Job, and the printer
  removes the JobStateReason object again when the
  corresponding condition becomes false, regardless of whether the Print Job's
  overall JobState also changed.

  Class JobStateReasons inherits its implementation from class java.util.HashSet. Unlike most printing attributes which
  are immutable once constructed, class JobStateReasons is designed to be
  mutable; you can add JobStateReason objects to an
  existing JobStateReasons object and remove them again. However, like class
  java.util.HashSet, class JobStateReasons is not
  multiple thread safe. If a JobStateReasons object will be used by multiple
  threads, be sure to synchronize its operations (e.g., using a synchronized
  set view obtained from class java.util.Collections).

  IPP Compatibility: The string value returned by each individual JobStateReason object's toString() method gives
  the IPP keyword value. The category name returned by getName()
  gives the IPP attribute name."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.print.attribute.standard JobStateReasons]))

(defn ->job-state-reasons
  "Constructor.

  Construct a new, empty job state reasons attribute; the underlying hash
   set has the given initial capacity and load factor.

  initial-capacity - Initial capacity. - `int`
  load-factor - Load factor. - `float`

  throws: java.lang.IllegalArgumentException - if the initial capacity is less than zero."
  ([^Integer initial-capacity ^Float load-factor]
    (new JobStateReasons initial-capacity load-factor))
  ([^Integer initial-capacity]
    (new JobStateReasons initial-capacity))
  ([]
    (new JobStateReasons )))

(defn add
  "Adds the specified element to this job state reasons attribute if it is
   not already present. The element to be added must be an instance of class
   JobStateReason. If this job state reasons
   attribute already contains the specified element, the call leaves this
   job state reasons attribute unchanged and returns false.

  o - Element to be added to this job state reasons attribute. - `javax.print.attribute.standard.JobStateReason`

  returns: true if this job state reasons attribute did not
            already contain the specified element. - `boolean`

  throws: java.lang.NullPointerException - (unchecked exception) Thrown if the specified element is null."
  (^Boolean [^javax.print.attribute.standard.JobStateReasons this ^javax.print.attribute.standard.JobStateReason o]
    (-> this (.add o))))

(defn get-category
  "Get the printing attribute class which is to be used as the `category`
   for this printing attribute value.

   For class JobStateReasons, the category is class JobStateReasons itself.

  returns: Printing attribute class (category), an instance of class
            java.lang.Class. - `java.lang.Class<? extends javax.print.attribute.Attribute>`"
  ([^javax.print.attribute.standard.JobStateReasons this]
    (-> this (.getCategory))))

(defn get-name
  "Get the name of the category of which this attribute value is an
   instance.

   For class JobStateReasons, the category
   name is `job-state-reasons`.

  returns: Attribute category name. - `java.lang.String`"
  (^java.lang.String [^javax.print.attribute.standard.JobStateReasons this]
    (-> this (.getName))))

