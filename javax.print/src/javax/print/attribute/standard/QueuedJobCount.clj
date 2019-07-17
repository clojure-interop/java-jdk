(ns javax.print.attribute.standard.QueuedJobCount
  "Class QueuedJobCount is an integer valued printing attribute that indicates
  the number of jobs in the printer whose JobState is either
  PENDING, PENDING_HELD, PROCESSING, or PROCESSING_STOPPED.

  IPP Compatibility: The integer value gives the IPP integer value.
  The category name returned by getName() gives the IPP
  attribute name."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.print.attribute.standard QueuedJobCount]))

(defn ->queued-job-count
  "Constructor.

  Construct a new queued job count attribute with the given integer
   value.

  value - Integer value. - `int`

  throws: java.lang.IllegalArgumentException - (Unchecked exception) Thrown if value is less than 0."
  ([value]
    (new QueuedJobCount value)))

(defn equals
  "Returns whether this queued job count attribute is equivalent to the
   passed in object. To be equivalent, all of the following conditions
   mus  be true:


   object is not null.

   object is an instance of class QueuedJobCount.

   This queued job count attribute's value and object's
   value are equal.

  object - Object to compare to. - `java.lang.Object`

  returns: True if object is equivalent to this queued job
            count attribute, false otherwise. - `boolean`"
  ([this object]
    (-> this (.equals object))))

(defn get-category
  "Get the printing attribute class which is to be used as the `category`
   for this printing attribute value.

   For class QueuedJobCount, the category is class QueuedJobCount itself.

  returns: Printing attribute class (category), an instance of class
            java.lang.Class. - `java.lang.Class<? extends javax.print.attribute.Attribute>`"
  ([this]
    (-> this (.getCategory))))

(defn get-name
  "Get the name of the category of which this attribute value is an
   instance.

   For class QueuedJobCount, the
   category name is `queued-job-count`.

  returns: Attribute category name. - `java.lang.String`"
  ([this]
    (-> this (.getName))))

