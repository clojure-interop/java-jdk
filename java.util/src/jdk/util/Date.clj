(ns jdk.util.Date
  "The class Date represents a specific instant
  in time, with millisecond precision.

  Prior to JDK 1.1, the class Date had two additional
  functions.  It allowed the interpretation of dates as year, month, day, hour,
  minute, and second values.  It also allowed the formatting and parsing
  of date strings.  Unfortunately, the API for these functions was not
  amenable to internationalization.  As of JDK 1.1, the
  Calendar class should be used to convert between dates and time
  fields and the DateFormat class should be used to format and
  parse date strings.
  The corresponding methods in Date are deprecated.

  Although the Date class is intended to reflect
  coordinated universal time (UTC), it may not do so exactly,
  depending on the host environment of the Java Virtual Machine.
  Nearly all modern operating systems assume that 1 day =
  24 × 60 × 60 = 86400 seconds
  in all cases. In UTC, however, about once every year or two there
  is an extra second, called a `leap second.` The leap
  second is always added as the last second of the day, and always
  on December 31 or June 30. For example, the last minute of the
  year 1995 was 61 seconds long, thanks to an added leap second.
  Most computer clocks are not accurate enough to be able to reflect
  the leap-second distinction.

  Some computer standards are defined in terms of Greenwich mean
  time (GMT), which is equivalent to universal time (UT).  GMT is
  the `civil` name for the standard; UT is the
  `scientific` name for the same standard. The
  distinction between UTC and UT is that UTC is based on an atomic
  clock and UT is based on astronomical observations, which for all
  practical purposes is an invisibly fine hair to split. Because the
  earth's rotation is not uniform (it slows down and speeds up
  in complicated ways), UT does not always flow uniformly. Leap
  seconds are introduced as needed into UTC so as to keep UTC within
  0.9 seconds of UT1, which is a version of UT with certain
  corrections applied. There are other time and date systems as
  well; for example, the time scale used by the satellite-based
  global positioning system (GPS) is synchronized to UTC but is
  not adjusted for leap seconds. An interesting source of
  further information is the U.S. Naval Observatory, particularly
  the Directorate of Time at:


      http://tycho.usno.navy.mil

  and their definitions of `Systems of Time` at:


      http://tycho.usno.navy.mil/systime.html

  In all methods of class Date that accept or return
  year, month, date, hours, minutes, and seconds values, the
  following representations are used:

  A year y is represented by the integer
      y - 1900.
  A month is represented by an integer from 0 to 11; 0 is January,
      1 is February, and so forth; thus 11 is December.
  A date (day of month) is represented by an integer from 1 to 31
      in the usual manner.
  An hour is represented by an integer from 0 to 23. Thus, the hour
      from midnight to 1 a.m. is hour 0, and the hour from noon to 1
      p.m. is hour 12.
  A minute is represented by an integer from 0 to 59 in the usual manner.
  A second is represented by an integer from 0 to 61; the values 60 and
      61 occur only for leap seconds and even then only in Java
      implementations that actually track leap seconds correctly. Because
      of the manner in which leap seconds are currently introduced, it is
      extremely unlikely that two leap seconds will occur in the same
      minute, but this specification follows the date and time conventions
      for ISO C.


  In all cases, arguments given to methods for these purposes need
  not fall within the indicated ranges; for example, a date may be
  specified as January 32 and is interpreted as meaning February 1."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.util Date]))

(defn ->date
  "Constructor.

  Allocates a Date object and initializes it to
   represent the specified number of milliseconds since the
   standard base time known as `the epoch`, namely January 1,
   1970, 00:00:00 GMT.

  date - the milliseconds since January 1, 1970, 00:00:00 GMT. - `long`"
  ([^Long date]
    (new Date date))
  ([]
    (new Date ))
  ([^Integer year ^Integer month ^Integer date]
    (new Date year month date))
  ([^Integer year ^Integer month ^Integer date ^Integer hrs ^Integer min]
    (new Date year month date hrs min))
  ([^Integer year ^Integer month ^Integer date ^Integer hrs ^Integer min ^Integer sec]
    (new Date year month date hrs min sec)))

(defn *utc
  "Deprecated. As of JDK version 1.1,
   replaced by Calendar.set(year  1900, month, date,
   hrs, min, sec) or GregorianCalendar(year  1900,
   month, date, hrs, min, sec), using a UTC
   TimeZone, followed by Calendar.getTime().getTime().

  year - the year minus 1900. - `int`
  month - the month between 0-11. - `int`
  date - the day of the month between 1-31. - `int`
  hrs - the hours between 0-23. - `int`
  min - the minutes between 0-59. - `int`
  sec - the seconds between 0-59. - `int`

  returns: the number of milliseconds since January 1, 1970, 00:00:00 GMT for
            the date and time specified by the arguments. - `java.lang.   long`"
  ([^Integer year ^Integer month ^Integer date ^Integer hrs ^Integer min ^Integer sec]
    (Date/UTC year month date hrs min sec)))

(defn *parse
  "Deprecated. As of JDK version 1.1,
   replaced by DateFormat.parse(String s).

  s - a string to be parsed as a date. - `java.lang.String`

  returns: the number of milliseconds since January 1, 1970, 00:00:00 GMT
            represented by the string argument. - `java.lang.   long`"
  ([^java.lang.String s]
    (Date/parse s)))

(defn *from
  "Obtains an instance of Date from an Instant object.

   Instant uses a precision of nanoseconds, whereas Date
   uses a precision of milliseconds.  The conversion will trancate any
   excess precision information as though the amount in nanoseconds was
   subject to integer division by one million.

   Instant can store points on the time-line further in the future
   and further in the past than Date. In this scenario, this method
   will throw an exception.

  instant - the instant to convert - `java.time.Instant`

  returns: a Date representing the same point on the time-line as
    the provided instant - `java.util.Date`

  throws: java.lang.NullPointerException - if instant is null."
  ([^java.time.Instant instant]
    (Date/from instant)))

(defn to-instant
  "Converts this Date object to an Instant.

   The conversion creates an Instant that represents the same
   point on the time-line as this Date.

  returns: an instant representing the same point on the time-line as
    this Date object - `java.time.Instant`"
  ([^java.util.Date this]
    (-> this (.toInstant))))

(defn get-timezone-offset
  "Deprecated. As of JDK version 1.1,
   replaced by -(Calendar.get(Calendar.ZONE_OFFSET)
   Calendar.get(Calendar.DST_OFFSET)) / (60 * 1000).

  returns: the time-zone offset, in minutes, for the current time zone. - `java.lang.  int`"
  ([^java.util.Date this]
    (-> this (.getTimezoneOffset))))

(defn set-month
  "Deprecated. As of JDK version 1.1,
   replaced by Calendar.set(Calendar.MONTH, int month).

  month - the month value between 0-11. - `int`

  returns: `java.lang.  void`"
  ([^java.util.Date this ^Integer month]
    (-> this (.setMonth month))))

(defn set-seconds
  "Deprecated. As of JDK version 1.1,
   replaced by Calendar.set(Calendar.SECOND, int seconds).

  seconds - the seconds value. - `int`

  returns: `java.lang.  void`"
  ([^java.util.Date this ^Integer seconds]
    (-> this (.setSeconds seconds))))

(defn set-time
  "Sets this Date object to represent a point in time that is
   time milliseconds after January 1, 1970 00:00:00 GMT.

  time - the number of milliseconds. - `long`"
  ([^java.util.Date this ^Long time]
    (-> this (.setTime time))))

(defn to-locale-string
  "Deprecated. As of JDK version 1.1,
   replaced by DateFormat.format(Date date).

  returns: a string representation of this date, using the locale
            conventions. - `java.lang.  java.lang.String`"
  ([^java.util.Date this]
    (-> this (.toLocaleString))))

(defn set-date
  "Deprecated. As of JDK version 1.1,
   replaced by Calendar.set(Calendar.DAY_OF_MONTH, int date).

  date - the day of the month value between 1-31. - `int`

  returns: `java.lang.  void`"
  ([^java.util.Date this ^Integer date]
    (-> this (.setDate date))))

(defn after
  "Tests if this date is after the specified date.

  when - a date. - `java.util.Date`

  returns: true if and only if the instant represented
            by this Date object is strictly later than the
            instant represented by when;
            false otherwise. - `boolean`

  throws: java.lang.NullPointerException - if when is null."
  ([^java.util.Date this ^java.util.Date when]
    (-> this (.after when))))

(defn to-gmt-string
  "Deprecated. As of JDK version 1.1,
   replaced by DateFormat.format(Date date), using a
   GMT TimeZone.

  returns: a string representation of this date, using the Internet GMT
            conventions. - `java.lang.  java.lang.String`"
  ([^java.util.Date this]
    (-> this (.toGMTString))))

(defn get-year
  "Deprecated. As of JDK version 1.1,
   replaced by Calendar.get(Calendar.YEAR) - 1900.

  returns: the year represented by this date, minus 1900. - `java.lang.  int`"
  ([^java.util.Date this]
    (-> this (.getYear))))

(defn get-hours
  "Deprecated. As of JDK version 1.1,
   replaced by Calendar.get(Calendar.HOUR_OF_DAY).

  returns: the hour represented by this date. - `java.lang.  int`"
  ([^java.util.Date this]
    (-> this (.getHours))))

(defn set-hours
  "Deprecated. As of JDK version 1.1,
   replaced by Calendar.set(Calendar.HOUR_OF_DAY, int hours).

  hours - the hour value. - `int`

  returns: `java.lang.  void`"
  ([^java.util.Date this ^Integer hours]
    (-> this (.setHours hours))))

(defn to-string
  "Converts this Date object to a String
   of the form:


   dow mon dd hh:mm:ss zzz yyyy
   where:
   dow is the day of the week (Sun, Mon, Tue, Wed,
       Thu, Fri, Sat).
   mon is the month (Jan, Feb, Mar, Apr, May, Jun,
       Jul, Aug, Sep, Oct, Nov, Dec).
   dd is the day of the month (01 through
       31), as two decimal digits.
   hh is the hour of the day (00 through
       23), as two decimal digits.
   mm is the minute within the hour (00 through
       59), as two decimal digits.
   ss is the second within the minute (00 through
       61, as two decimal digits.
   zzz is the time zone (and may reflect daylight saving
       time). Standard time zone abbreviations include those
       recognized by the method parse. If time zone
       information is not available, then zzz is empty -
       that is, it consists of no characters at all.
   yyyy is the year, as four decimal digits.

  returns: a string representation of this date. - `java.lang.String`"
  ([^java.util.Date this]
    (-> this (.toString))))

(defn get-date
  "Deprecated. As of JDK version 1.1,
   replaced by Calendar.get(Calendar.DAY_OF_MONTH).

  returns: the day of the month represented by this date. - `java.lang.  int`"
  ([^java.util.Date this]
    (-> this (.getDate))))

(defn set-minutes
  "Deprecated. As of JDK version 1.1,
   replaced by Calendar.set(Calendar.MINUTE, int minutes).

  minutes - the value of the minutes. - `int`

  returns: `java.lang.  void`"
  ([^java.util.Date this ^Integer minutes]
    (-> this (.setMinutes minutes))))

(defn get-day
  "Deprecated. As of JDK version 1.1,
   replaced by Calendar.get(Calendar.DAY_OF_WEEK).

  returns: the day of the week represented by this date. - `java.lang.  int`"
  ([^java.util.Date this]
    (-> this (.getDay))))

(defn get-seconds
  "Deprecated. As of JDK version 1.1,
   replaced by Calendar.get(Calendar.SECOND).

  returns: the number of seconds past the minute represented by this date. - `java.lang.  int`"
  ([^java.util.Date this]
    (-> this (.getSeconds))))

(defn clone
  "Return a copy of this object.

  returns: a clone of this instance. - `java.lang.Object`"
  ([^java.util.Date this]
    (-> this (.clone))))

(defn hash-code
  "Returns a hash code value for this object. The result is the
   exclusive OR of the two halves of the primitive long
   value returned by the getTime()
   method. That is, the hash code is the value of the expression:


   (int)(this.getTime()^(this.getTime() >>> 32))

  returns: a hash code value for this object. - `int`"
  ([^java.util.Date this]
    (-> this (.hashCode))))

(defn compare-to
  "Compares two Dates for ordering.

  another-date - the Date to be compared. - `java.util.Date`

  returns: the value 0 if the argument Date is equal to
            this Date; a value less than 0 if this Date
            is before the Date argument; and a value greater than
        0 if this Date is after the Date argument. - `int`

  throws: java.lang.NullPointerException - if anotherDate is null."
  ([^java.util.Date this ^java.util.Date another-date]
    (-> this (.compareTo another-date))))

(defn get-month
  "Deprecated. As of JDK version 1.1,
   replaced by Calendar.get(Calendar.MONTH).

  returns: the month represented by this date. - `java.lang.  int`"
  ([^java.util.Date this]
    (-> this (.getMonth))))

(defn set-year
  "Deprecated. As of JDK version 1.1,
   replaced by Calendar.set(Calendar.YEAR, year  1900).

  year - the year value. - `int`

  returns: `java.lang.  void`"
  ([^java.util.Date this ^Integer year]
    (-> this (.setYear year))))

(defn before
  "Tests if this date is before the specified date.

  when - a date. - `java.util.Date`

  returns: true if and only if the instant of time
              represented by this Date object is strictly
              earlier than the instant represented by when;
            false otherwise. - `boolean`

  throws: java.lang.NullPointerException - if when is null."
  ([^java.util.Date this ^java.util.Date when]
    (-> this (.before when))))

(defn get-time
  "Returns the number of milliseconds since January 1, 1970, 00:00:00 GMT
   represented by this Date object.

  returns: the number of milliseconds since January 1, 1970, 00:00:00 GMT
            represented by this date. - `long`"
  ([^java.util.Date this]
    (-> this (.getTime))))

(defn get-minutes
  "Deprecated. As of JDK version 1.1,
   replaced by Calendar.get(Calendar.MINUTE).

  returns: the number of minutes past the hour represented by this date. - `java.lang.  int`"
  ([^java.util.Date this]
    (-> this (.getMinutes))))

(defn equals
  "Compares two dates for equality.
   The result is true if and only if the argument is
   not null and is a Date object that
   represents the same point in time, to the millisecond, as this object.

   Thus, two Date objects are equal if and only if the
   getTime method returns the same long
   value for both.

  obj - the object to compare with. - `java.lang.Object`

  returns: true if the objects are the same;
            false otherwise. - `boolean`"
  ([^java.util.Date this ^java.lang.Object obj]
    (-> this (.equals obj))))

