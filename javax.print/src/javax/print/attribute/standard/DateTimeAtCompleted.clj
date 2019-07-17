(ns javax.print.attribute.standard.DateTimeAtCompleted
  "Class DateTimeAtCompleted is a printing attribute class, a date-time
  attribute, that indicates the date and time at which the Print Job completed
  (or was canceled or aborted).

  To construct a DateTimeAtCompleted attribute from separate values of the
  year, month, day, hour, minute, and so on, use a Calendar object to construct a Date object, then use
  the Date object to construct the DateTimeAtCompleted
  attribute. To convert a DateTimeAtCompleted attribute to separate values of
  the year, month, day, hour, minute, and so on, create a Calendar object and set it to the Date from the DateTimeAtCompleted attribute.

  IPP Compatibility: The information needed to construct an IPP
  `date-time-at-completed` attribute can be obtained as described above. The
  category name returned by getName() gives the IPP attribute
  name."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.print.attribute.standard DateTimeAtCompleted]))

(defn ->date-time-at-completed
  "Constructor.

  Construct a new date-time at completed attribute with the given Date value.

  date-time - Date value. - `java.util.Date`

  throws: java.lang.NullPointerException - (unchecked exception) Thrown if dateTime is null."
  ([^java.util.Date date-time]
    (new DateTimeAtCompleted date-time)))

(defn equals
  "Returns whether this date-time at completed attribute is equivalent to
   the passed in object. To be equivalent, all of the following conditions
   must be true:


   object is not null.

   object is an instance of class DateTimeAtCompleted.

   This date-time at completed attribute's Date value
   and object's Date value are equal.

  object - Object to compare to. - `java.lang.Object`

  returns: True if object is equivalent to this date-time
            at completed attribute, false otherwise. - `boolean`"
  ([^javax.print.attribute.standard.DateTimeAtCompleted this ^java.lang.Object object]
    (-> this (.equals object))))

(defn get-category
  "Get the printing attribute class which is to be used as the `category`
   for this printing attribute value.

   For class DateTimeAtCompleted, the category is class
   DateTimeAtCompleted itself.

  returns: Printing attribute class (category), an instance of class
            java.lang.Class. - `java.lang.Class<? extends javax.print.attribute.Attribute>`"
  ([^javax.print.attribute.standard.DateTimeAtCompleted this]
    (-> this (.getCategory))))

(defn get-name
  "Get the name of the category of which this attribute value is an
   instance.

   For class DateTimeAtCompleted, the category name is
   `date-time-at-completed`.

  returns: Attribute category name. - `java.lang.String`"
  ([^javax.print.attribute.standard.DateTimeAtCompleted this]
    (-> this (.getName))))

