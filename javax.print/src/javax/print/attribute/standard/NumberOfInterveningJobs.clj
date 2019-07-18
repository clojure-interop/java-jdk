(ns javax.print.attribute.standard.NumberOfInterveningJobs
  "Class NumberOfInterveningJobs is an integer valued printing attribute that
  indicates the number of jobs that are ahead of this job in the relative
  chronological order of expected time to complete (i.e., the current
  scheduled order).

  IPP Compatibility: The integer value gives the IPP integer value.
  The category name returned by getName() gives the IPP
  attribute name."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.print.attribute.standard NumberOfInterveningJobs]))

(defn ->number-of-intervening-jobs
  "Constructor.

  Construct a new number of intervening jobs attribute with the given
   integer value.

  value - Integer value. - `int`

  throws: java.lang.IllegalArgumentException - (Unchecked exception) Thrown if value is less than 0."
  (^NumberOfInterveningJobs [^Integer value]
    (new NumberOfInterveningJobs value)))

(defn equals
  "Returns whether this number of intervening jobs attribute is equivalent
   to the passed in object. To be equivalent, all of the following
   conditions must be true:


   object is not null.

   object is an instance of class NumberOfInterveningJobs.

   This number of intervening jobs attribute's value and
   object's value are equal.

  object - Object to compare to. - `java.lang.Object`

  returns: True if object is equivalent to this number of
            intervening jobs attribute, false otherwise. - `boolean`"
  (^Boolean [^NumberOfInterveningJobs this ^java.lang.Object object]
    (-> this (.equals object))))

(defn get-category
  "Get the printing attribute class which is to be used as the `category`
   for this printing attribute value.

   For class NumberOfInterveningJobs, the
   category is class NumberOfInterveningJobs itself.

  returns: Printing attribute class (category), an instance of class
            java.lang.Class. - `java.lang.Class<? extends javax.print.attribute.Attribute>`"
  ([^NumberOfInterveningJobs this]
    (-> this (.getCategory))))

(defn get-name
  "Get the name of the category of which this attribute value is an
   instance.

   For class NumberOfInterveningJobs, the
   category name is `number-of-intervening-jobs`.

  returns: Attribute category name. - `java.lang.String`"
  (^java.lang.String [^NumberOfInterveningJobs this]
    (-> this (.getName))))

