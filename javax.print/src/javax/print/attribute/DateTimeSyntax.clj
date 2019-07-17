(ns javax.print.attribute.DateTimeSyntax
  "Class DateTimeSyntax is an abstract base class providing the common
  implementation of all attributes whose value is a date and time.

  Under the hood, a date-time attribute is stored as a value of class
  java.util.Date. You can get a date-time attribute's Date value by
  calling getValue(). A date-time attribute's
  Date value is established when it is constructed (see DateTimeSyntax(Date)). Once
  constructed, a date-time attribute's value is immutable.

  To construct a date-time attribute from separate values of the year, month,
  day, hour, minute, and so on, use a java.util.Calendar
  object to construct a java.util.Date object, then use the
  java.util.Date object to construct the date-time attribute.
  To convert
  a date-time attribute to separate values of the year, month, day, hour,
  minute, and so on, create a java.util.Calendar object and
  set it to the java.util.Date from the date-time attribute. Class
  DateTimeSyntax stores its value in the form of a java.util.Date

  rather than a java.util.Calendar because it typically takes
  less memory to store and less time to compare a java.util.Date
  than a java.util.Calendar."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.print.attribute DateTimeSyntax]))

(defn get-value
  "Returns this date-time attribute's java.util.Date
   value.

  returns: the Date. - `java.util.Date`"
  ([this]
    (-> this (.getValue))))

(defn equals
  "Returns whether this date-time attribute is equivalent to the passed in
   object. To be equivalent, all of the following conditions must be true:


   object is not null.

   object is an instance of class DateTimeSyntax.

   This date-time attribute's java.util.Date value and
   object's java.util.Date value are
   equal.

  object - Object to compare to. - `java.lang.Object`

  returns: True if object is equivalent to this date-time
            attribute, false otherwise. - `boolean`"
  ([this object]
    (-> this (.equals object))))

(defn hash-code
  "Returns a hash code value for this date-time attribute. The hashcode is
   that of this attribute's java.util.Date value.

  returns: a hash code value for this object. - `int`"
  ([this]
    (-> this (.hashCode))))

(defn to-string
  "Returns a string value corresponding to this date-time attribute.
   The string value is just this attribute's
   java.util.Date  value
   converted to a string.

  returns: a string representation of the object. - `java.lang.String`"
  ([this]
    (-> this (.toString))))

