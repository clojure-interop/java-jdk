(ns jdk.sql.Date
  "A thin wrapper around a millisecond value that allows
  JDBC to identify this as an SQL DATE value.  A
  milliseconds value represents the number of milliseconds that
  have passed since January 1, 1970 00:00:00.000 GMT.

  To conform with the definition of SQL DATE, the
  millisecond values wrapped by a java.sql.Date instance
  must be 'normalized' by setting the
  hours, minutes, seconds, and milliseconds to zero in the particular
  time zone with which the instance is associated."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.sql Date]))

(defn ->date
  "Constructor.

  Constructs a Date object using the given milliseconds
   time value.  If the given milliseconds value contains time
   information, the driver will set the time components to the
   time in the default time zone (the time zone of the Java virtual
   machine running the application) that corresponds to zero GMT.

  date - milliseconds since January 1, 1970, 00:00:00 GMT not to exceed the milliseconds representation for the year 8099. A negative number indicates the number of milliseconds before January 1, 1970, 00:00:00 GMT. - `long`"
  ([^Long date]
    (new Date date))
  ([^Integer year ^Integer month ^Integer day]
    (new Date year month day)))

(defn *value-of
  "Converts a string in JDBC date escape format to
   a Date value.

  s - a String object representing a date in in the format `yyyy-[m]m-[d]d`. The leading zero for mm and dd may also be omitted. - `java.lang.String`

  returns: a java.sql.Date object representing the
           given date - `java.sql.Date`

  throws: java.lang.IllegalArgumentException - if the date given is not in the JDBC date escape format (yyyy-[m]m-[d]d)"
  (^java.sql.Date [^java.lang.String s]
    (Date/valueOf s)))

(defn to-instant
  "This method always throws an UnsupportedOperationException and should
   not be used because SQL Date values do not have a time
   component.

  returns: an instant representing the same point on the time-line as
    this Date object - `java.time.Instant`

  throws: java.lang.UnsupportedOperationException - if this method is invoked"
  (^java.time.Instant [^java.sql.Date this]
    (-> this (.toInstant))))

(defn set-seconds
  "Deprecated.

  i - the seconds value. - `int`

  returns: `java.lang.  void`

  throws: java.lang.IllegalArgumentException - if this method is invoked"
  ([^java.sql.Date this ^Integer i]
    (-> this (.setSeconds i))))

(defn set-time
  "Sets an existing Date object
   using the given milliseconds time value.
   If the given milliseconds value contains time information,
   the driver will set the time components to the
   time in the default time zone (the time zone of the Java virtual
   machine running the application) that corresponds to zero GMT.

  date - milliseconds since January 1, 1970, 00:00:00 GMT not to exceed the milliseconds representation for the year 8099. A negative number indicates the number of milliseconds before January 1, 1970, 00:00:00 GMT. - `long`"
  ([^java.sql.Date this ^Long date]
    (-> this (.setTime date))))

(defn get-hours
  "Deprecated.

  returns: the hour represented by this date. - `java.lang.  int`

  throws: java.lang.IllegalArgumentException - if this method is invoked"
  ([^java.sql.Date this]
    (-> this (.getHours))))

(defn set-hours
  "Deprecated.

  i - the hour value. - `int`

  returns: `java.lang.  void`

  throws: java.lang.IllegalArgumentException - if this method is invoked"
  ([^java.sql.Date this ^Integer i]
    (-> this (.setHours i))))

(defn to-string
  "Formats a date in the date escape format yyyy-mm-dd.

  returns: a String in yyyy-mm-dd format - `java.lang.String`"
  (^java.lang.String [^java.sql.Date this]
    (-> this (.toString))))

(defn set-minutes
  "Deprecated.

  i - the value of the minutes. - `int`

  returns: `java.lang.  void`

  throws: java.lang.IllegalArgumentException - if this method is invoked"
  ([^java.sql.Date this ^Integer i]
    (-> this (.setMinutes i))))

(defn get-seconds
  "Deprecated.

  returns: the number of seconds past the minute represented by this date. - `java.lang.  int`

  throws: java.lang.IllegalArgumentException - if this method is invoked"
  ([^java.sql.Date this]
    (-> this (.getSeconds))))

(defn to-local-date
  "Converts this Date object to a LocalDate

   The conversion creates a LocalDate that represents the same
   date value as this Date in local time zone

  returns: a LocalDate object representing the same date value - `java.time.LocalDate`"
  (^java.time.LocalDate [^java.sql.Date this]
    (-> this (.toLocalDate))))

(defn get-minutes
  "Deprecated.

  returns: the number of minutes past the hour represented by this date. - `java.lang.  int`

  throws: java.lang.IllegalArgumentException - if this method is invoked"
  ([^java.sql.Date this]
    (-> this (.getMinutes))))

