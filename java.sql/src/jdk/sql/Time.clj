(ns jdk.sql.Time
  "A thin wrapper around the java.util.Date class that allows the JDBC
  API to identify this as an SQL TIME value. The Time
  class adds formatting and
  parsing operations to support the JDBC escape syntax for time
  values.
  The date components should be set to the `zero epoch`
  value of January 1, 1970 and should not be accessed."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.sql Time]))

(defn ->time
  "Constructor.

  Constructs a Time object using a milliseconds time value.

  time - milliseconds since January 1, 1970, 00:00:00 GMT; a negative number is milliseconds before January 1, 1970, 00:00:00 GMT - `long`"
  ([^Long time]
    (new Time time))
  ([^Integer hour ^Integer minute ^Integer second]
    (new Time hour minute second)))

(defn *value-of
  "Converts a string in JDBC time escape format to a Time value.

  s - time in format `hh:mm:ss` - `java.lang.String`

  returns: a corresponding Time object - `java.sql.Time`"
  ([^java.lang.String s]
    (Time/valueOf s)))

(defn to-instant
  "This method always throws an UnsupportedOperationException and should
   not be used because SQL Time values do not have a date
   component.

  returns: an instant representing the same point on the time-line as
    this Date object - `java.time.Instant`

  throws: java.lang.UnsupportedOperationException - if this method is invoked"
  ([^java.sql.Time this]
    (-> this (.toInstant))))

(defn set-month
  "Deprecated.

  i - the month value between 0-11. - `int`

  returns: `java.lang.  void`

  throws: java.lang.IllegalArgumentException - if this method is invoked"
  ([^java.sql.Time this ^Integer i]
    (-> this (.setMonth i))))

(defn set-time
  "Sets a Time object using a milliseconds time value.

  time - milliseconds since January 1, 1970, 00:00:00 GMT; a negative number is milliseconds before January 1, 1970, 00:00:00 GMT - `long`"
  ([^java.sql.Time this ^Long time]
    (-> this (.setTime time))))

(defn set-date
  "Deprecated.

  i - the day of the month value between 1-31. - `int`

  returns: `java.lang.  void`

  throws: java.lang.IllegalArgumentException - if this method is invoked"
  ([^java.sql.Time this ^Integer i]
    (-> this (.setDate i))))

(defn get-year
  "Deprecated.

  returns: the year represented by this date, minus 1900. - `java.lang.  int`

  throws: java.lang.IllegalArgumentException - if this method is invoked"
  ([^java.sql.Time this]
    (-> this (.getYear))))

(defn to-string
  "Formats a time in JDBC time escape format.

  returns: a String in hh:mm:ss format - `java.lang.String`"
  ([^java.sql.Time this]
    (-> this (.toString))))

(defn get-date
  "Deprecated.

  returns: the day of the month represented by this date. - `java.lang.  int`

  throws: java.lang.IllegalArgumentException - if this method is invoked"
  ([^java.sql.Time this]
    (-> this (.getDate))))

(defn to-local-time
  "Converts this Time object to a LocalTime.

   The conversion creates a LocalTime that represents the same
   hour, minute, and second time value as this Time.

  returns: a LocalTime object representing the same time value - `java.time.LocalTime`"
  ([^java.sql.Time this]
    (-> this (.toLocalTime))))

(defn get-day
  "Deprecated.

  returns: the day of the week represented by this date. - `java.lang.  int`

  throws: java.lang.IllegalArgumentException - if this method is invoked"
  ([^java.sql.Time this]
    (-> this (.getDay))))

(defn get-month
  "Deprecated.

  returns: the month represented by this date. - `java.lang.  int`

  throws: java.lang.IllegalArgumentException - if this method is invoked"
  ([^java.sql.Time this]
    (-> this (.getMonth))))

(defn set-year
  "Deprecated.

  i - the year value. - `int`

  returns: `java.lang.  void`

  throws: java.lang.IllegalArgumentException - if this method is invoked"
  ([^java.sql.Time this ^Integer i]
    (-> this (.setYear i))))

