(ns jdk.sql.Timestamp
  "A thin wrapper around java.util.Date that allows
  the JDBC API to identify this as an SQL TIMESTAMP value.
  It adds the ability
  to hold the SQL TIMESTAMP fractional seconds value, by allowing
  the specification of fractional seconds to a precision of nanoseconds.
  A Timestamp also provides formatting and
  parsing operations to support the JDBC escape syntax for timestamp values.

  The precision of a Timestamp object is calculated to be either:

  19 , which is the number of characters in yyyy-mm-dd hh:mm:ss
    20  s , which is the number
  of characters in the yyyy-mm-dd hh:mm:ss.[fff...] and s represents  the scale of the given Timestamp,
  its fractional seconds precision.


  Note: This type is a composite of a java.util.Date and a
  separate nanoseconds value. Only integral seconds are stored in the
  java.util.Date component. The fractional seconds - the nanos - are
  separate.  The Timestamp.equals(Object) method never returns
  true when passed an object
  that isn't an instance of java.sql.Timestamp,
  because the nanos component of a date is unknown.
  As a result, the Timestamp.equals(Object)
  method is not symmetric with respect to the
  java.util.Date.equals(Object)
  method.  Also, the hashCode method uses the underlying
  java.util.Date
  implementation and therefore does not include nanos in its computation.

  Due to the differences between the Timestamp class
  and the java.util.Date
  class mentioned above, it is recommended that code not view
  Timestamp values generically as an instance of
  java.util.Date.  The
  inheritance relationship between Timestamp
  and java.util.Date really
  denotes implementation inheritance, and not type inheritance."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.sql Timestamp]))

(defn ->timestamp
  "Constructor.

  Constructs a Timestamp object
   using a milliseconds time value. The
   integral seconds are stored in the underlying date value; the
   fractional seconds are stored in the nanos field of
   the Timestamp object.

  time - milliseconds since January 1, 1970, 00:00:00 GMT. A negative number is the number of milliseconds before January 1, 1970, 00:00:00 GMT. - `long`"
  ([time]
    (new Timestamp time))
  ([year month date hour minute second nano]
    (new Timestamp year month date hour minute second nano)))

(defn *value-of
  "Converts a String object in JDBC timestamp escape format to a
   Timestamp value.

  s - timestamp in format yyyy-[m]m-[d]d hh:mm:ss[.f...]. The fractional seconds may be omitted. The leading zero for mm and dd may also be omitted. - `java.lang.String`

  returns: corresponding Timestamp value - `java.sql.Timestamp`

  throws: java.lang.IllegalArgumentException - if the given argument does not have the format yyyy-[m]m-[d]d hh:mm:ss[.f...]"
  ([s]
    (Timestamp/valueOf s)))

(defn *from
  "Obtains an instance of Timestamp from an Instant object.

   Instant can store points on the time-line further in the future
   and further in the past than Date. In this scenario, this method
   will throw an exception.

  instant - the instant to convert - `java.time.Instant`

  returns: an Timestamp representing the same point on the time-line as
    the provided instant - `java.sql.Timestamp`

  throws: java.lang.NullPointerException - if instant is null."
  ([instant]
    (Timestamp/from instant)))

(defn to-instant
  "Converts this Timestamp object to an Instant.

   The conversion creates an Instant that represents the same
   point on the time-line as this Timestamp.

  returns: an instant representing the same point on the time-line - `java.time.Instant`"
  ([this]
    (-> this (.toInstant))))

(defn set-time
  "Sets this Timestamp object to represent a point in time that is
   time milliseconds after January 1, 1970 00:00:00 GMT.

  time - the number of milliseconds. - `long`"
  ([this time]
    (-> this (.setTime time))))

(defn after
  "Indicates whether this Timestamp object is
   later than the given Timestamp object.

  ts - the Timestamp value to compare with - `java.sql.Timestamp`

  returns: true if this Timestamp object is later;
          false otherwise - `boolean`"
  ([this ts]
    (-> this (.after ts))))

(defn set-nanos
  "Sets this Timestamp object's nanos field
   to the given value.

  n - the new fractional seconds component - `int`

  throws: java.lang.IllegalArgumentException - if the given argument is greater than 999999999 or less than 0"
  ([this n]
    (-> this (.setNanos n))))

(defn get-nanos
  "Gets this Timestamp object's nanos value.

  returns: this Timestamp object's fractional seconds component - `int`"
  ([this]
    (-> this (.getNanos))))

(defn to-string
  "Formats a timestamp in JDBC timestamp escape format.
           yyyy-mm-dd hh:mm:ss.fffffffff,
   where ffffffffff indicates nanoseconds.

  returns: a String object in
             yyyy-mm-dd hh:mm:ss.fffffffff format - `java.lang.String`"
  ([this]
    (-> this (.toString))))

(defn hash-code
  "Returns a hash code value for this object. The result is the
   exclusive OR of the two halves of the primitive long
   value returned by the Date.getTime()
   method. That is, the hash code is the value of the expression:


   (int)(this.getTime()^(this.getTime() >>> 32))

   The hashCode method uses the underlying java.util.Date
   implementation and therefore does not include nanos in its computation.

  returns: a hash code value for this object. - `int`"
  ([this]
    (-> this (.hashCode))))

(defn to-local-date-time
  "Converts this Timestamp object to a LocalDateTime.

   The conversion creates a LocalDateTime that represents the
   same year, month, day of month, hours, minutes, seconds and nanos
   date-time value as this Timestamp in the local time zone.

  returns: a LocalDateTime object representing the same date-time value - `java.time.LocalDateTime`"
  ([this]
    (-> this (.toLocalDateTime))))

(defn compare-to
  "Compares this Timestamp object to the given
   Timestamp object.

  ts - the Timestamp object to be compared to this Timestamp object - `java.sql.Timestamp`

  returns: the value 0 if the two Timestamp
            objects are equal; a value less than 0 if this
            Timestamp object is before the given argument;
            and a value greater than 0 if this
            Timestamp object is after the given argument. - `int`"
  ([this ts]
    (-> this (.compareTo ts))))

(defn before
  "Indicates whether this Timestamp object is
   earlier than the given Timestamp object.

  ts - the Timestamp value to compare with - `java.sql.Timestamp`

  returns: true if this Timestamp object is earlier;
          false otherwise - `boolean`"
  ([this ts]
    (-> this (.before ts))))

(defn get-time
  "Returns the number of milliseconds since January 1, 1970, 00:00:00 GMT
   represented by this Timestamp object.

  returns: the number of milliseconds since January 1, 1970, 00:00:00 GMT
            represented by this date. - `long`"
  ([this]
    (-> this (.getTime))))

(defn equals
  "Tests to see if this Timestamp object is
   equal to the given Timestamp object.

  ts - the Timestamp value to compare with - `java.sql.Timestamp`

  returns: true if the given Timestamp
           object is equal to this Timestamp object;
           false otherwise - `boolean`"
  ([this ts]
    (-> this (.equals ts))))

