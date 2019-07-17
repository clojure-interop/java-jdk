(ns jdk.nio.file.attribute.FileTime
  "Represents the value of a file's time stamp attribute. For example, it may
  represent the time that the file was last
  modified,
  accessed,
  or created.

   Instances of this class are immutable."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.nio.file.attribute FileTime]))

(defn *from
  "Returns a FileTime representing a value at the given unit of
   granularity.

  value - the value since the epoch (1970-01-01T00:00:00Z); can be negative - `long`
  unit - the unit of granularity to interpret the value - `java.util.concurrent.TimeUnit`

  returns: a FileTime representing the given value - `java.nio.file.attribute.FileTime`"
  ([value unit]
    (FileTime/from value unit))
  ([instant]
    (FileTime/from instant)))

(defn *from-millis
  "Returns a FileTime representing the given value in milliseconds.

  value - the value, in milliseconds, since the epoch (1970-01-01T00:00:00Z); can be negative - `long`

  returns: a FileTime representing the given value - `java.nio.file.attribute.FileTime`"
  ([value]
    (FileTime/fromMillis value)))

(defn to
  "Returns the value at the given unit of granularity.

    Conversion from a coarser granularity that would numerically overflow
   saturate to Long.MIN_VALUE if negative or Long.MAX_VALUE
   if positive.

  unit - the unit of granularity for the return value - `java.util.concurrent.TimeUnit`

  returns: value in the given unit of granularity, since the epoch
            since the epoch (1970-01-01T00:00:00Z); can be negative - `long`"
  ([this unit]
    (-> this (.to unit))))

(defn to-millis
  "Returns the value in milliseconds.

    Conversion from a coarser granularity that would numerically overflow
   saturate to Long.MIN_VALUE if negative or Long.MAX_VALUE
   if positive.

  returns: the value in milliseconds, since the epoch (1970-01-01T00:00:00Z) - `long`"
  ([this]
    (-> this (.toMillis))))

(defn to-instant
  "Converts this FileTime object to an Instant.

    The conversion creates an Instant that represents the
   same point on the time-line as this FileTime.

    FileTime can store points on the time-line further in the
   future and further in the past than Instant. Conversion
   from such further time points saturates to Instant.MIN if
   earlier than Instant.MIN or Instant.MAX if later
   than Instant.MAX.

  returns: an instant representing the same point on the time-line as
            this FileTime object - `java.time.Instant`"
  ([this]
    (-> this (.toInstant))))

(defn equals
  "Tests this FileTime for equality with the given object.

    The result is true if and only if the argument is not null and is a FileTime that represents the same time. This
   method satisfies the general contract of the Object.equals method.

  obj - the object to compare with - `java.lang.Object`

  returns: true if, and only if, the given object is a FileTime that represents the same time - `boolean`"
  ([this obj]
    (-> this (.equals obj))))

(defn hash-code
  "Computes a hash code for this file time.

    The hash code is based upon the value represented, and satisfies the
   general contract of the Object.hashCode() method.

  returns: the hash-code value - `int`"
  ([this]
    (-> this (.hashCode))))

(defn compare-to
  "Compares the value of two FileTime objects for order.

  other - the other FileTime to be compared - `java.nio.file.attribute.FileTime`

  returns: 0 if this FileTime is equal to other, a
            value less than 0 if this FileTime represents a time
            that is before other, and a value greater than 0 if this
            FileTime represents a time that is after other - `int`"
  ([this other]
    (-> this (.compareTo other))))

(defn to-string
  "Returns the string representation of this FileTime. The string
   is returned in the ISO 8601 format:


       YYYY-MM-DDThh:mm:ss[.s+]Z
   where `[.s+]` represents a dot followed by one of more digits
   for the decimal fraction of a second. It is only present when the decimal
   fraction of a second is not zero. For example, FileTime.fromMillis(1234567890000L).toString() yields `2009-02-13T23:31:30Z`, and FileTime.fromMillis(1234567890123L).toString()
   yields `2009-02-13T23:31:30.123Z`.

    A FileTime is primarily intended to represent the value of a
   file's time stamp. Where used to represent extreme values, where
   the year is less than `0001` or greater than `9999` then
   this method deviates from ISO 8601 in the same manner as the
   XML Schema
   language. That is, the year may be expanded to more than four digits
   and may be negative-signed. If more than four digits then leading zeros
   are not present. The year before `0001` is `-0001`.

  returns: the string representation of this file time - `java.lang.String`"
  ([this]
    (-> this (.toString))))

