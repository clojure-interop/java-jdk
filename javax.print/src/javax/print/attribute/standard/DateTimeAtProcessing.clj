(ns javax.print.attribute.standard.DateTimeAtProcessing
  "Class DateTimeAtProcessing is a printing attribute class, a date-time
  attribute, that indicates the date and time at which the Print Job first
  began processing.

  To construct a DateTimeAtProcessing attribute from separate values of the
  year, month, day, hour, minute, and so on, use a Calendar object to construct a Date object, then use
  the Date object to construct the DateTimeAtProcessing
  attribute. To convert a DateTimeAtProcessing attribute to separate values of
  the year, month, day, hour, minute, and so on, create a Calendar object and set it to the Date from the DateTimeAtProcessing attribute.

  IPP Compatibility: The information needed to construct an IPP
  \"date-time-at-processing\" attribute can be obtained as described above. The
  category name returned by getName() gives the IPP attribute
  name."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.print.attribute.standard DateTimeAtProcessing]))

(defn ->date-time-at-processing
  "Constructor.

  Construct a new date-time at processing attribute with the given Date value.

  date-time - Date value. - `java.util.Date`

  throws: java.lang.NullPointerException - (unchecked exception) Thrown if dateTime is null."
  (^DateTimeAtProcessing [^java.util.Date date-time]
    (new DateTimeAtProcessing date-time)))

(defn equals
  "Returns whether this date-time at processing attribute is equivalent to
   the passed in object. To be equivalent, all of the following conditions
   must be true:


   object is not null.

   object is an instance of class DateTimeAtProcessing.

   This date-time at processing attribute's Date
   value and object's Date value
   are equal.

  object - Object to compare to. - `java.lang.Object`

  returns: True if object is equivalent to this date-time
            at processing attribute, false otherwise. - `boolean`"
  (^Boolean [^DateTimeAtProcessing this ^java.lang.Object object]
    (-> this (.equals object))))

(defn get-category
  "Get the printing attribute class which is to be used as the \"category\"
   for this printing attribute value.

   For class DateTimeAtProcessing, the category is class
   DateTimeAtProcessing itself.

  returns: Printing attribute class (category), an instance of class
            java.lang.Class. - `java.lang.Class<? extends javax.print.attribute.Attribute>`"
  ([^DateTimeAtProcessing this]
    (-> this (.getCategory))))

(defn get-name
  "Get the name of the category of which this attribute value is an
   instance.

   For class DateTimeAtProcessing, the category name is
   \"date-time-at-processing\".

  returns: Attribute category name. - `java.lang.String`"
  (^java.lang.String [^DateTimeAtProcessing this]
    (-> this (.getName))))

