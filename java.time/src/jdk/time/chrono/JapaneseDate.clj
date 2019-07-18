(ns jdk.time.chrono.JapaneseDate
  "A date in the Japanese Imperial calendar system.

  This date operates using the java.time.chrono.Japanese Imperial calendar.
  This calendar system is primarily used in Japan.

  The Japanese Imperial calendar system is the same as the ISO calendar system
  apart from the era-based year numbering. The proleptic-year is defined to be
  equal to the ISO proleptic-year.

  Japan introduced the Gregorian calendar starting with Meiji 6.
  Only Meiji and later eras are supported;
  dates before Meiji 6, January 1 are not supported.

  For example, the Japanese year `Heisei 24` corresponds to ISO year `2012`.
  Calling japaneseDate.get(YEAR_OF_ERA) will return 24.
  Calling japaneseDate.get(YEAR) will return 2012.
  Calling japaneseDate.get(ERA) will return 2, corresponding to
  JapaneseChronology.ERA_HEISEI.


  This is a value-based
  class; use of identity-sensitive operations (including reference equality
  (==), identity hash code, or synchronization) on instances of
  JapaneseDate may have unpredictable results and should be avoided.
  The equals method should be used for comparisons."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.time.chrono JapaneseDate]))

(defn *now
  "Obtains the current JapaneseDate from the system clock in the specified time-zone.

   This will query the system clock to obtain the current date.
   Specifying the time-zone avoids dependence on the default time-zone.

   Using this method will prevent the ability to use an alternate clock for testing
   because the clock is hard-coded.

  zone - the zone ID to use, not null - `java.time.ZoneId`

  returns: the current date using the system clock, not null - `java.time.chrono.JapaneseDate`"
  (^java.time.chrono.JapaneseDate [^java.time.ZoneId zone]
    (JapaneseDate/now zone))
  (^java.time.chrono.JapaneseDate []
    (JapaneseDate/now )))

(defn *of
  "Obtains a JapaneseDate representing a date in the Japanese calendar
   system from the era, year-of-era, month-of-year and day-of-month fields.

   This returns a JapaneseDate with the specified fields.
   The day must be valid for the year and month, otherwise an exception will be thrown.

   The Japanese month and day-of-month are the same as those in the
   ISO calendar system. They are not reset when the era changes.
   For example:


    6th Jan Showa 64 = ISO 1989-01-06
    7th Jan Showa 64 = ISO 1989-01-07
    8th Jan Heisei 1 = ISO 1989-01-08
    9th Jan Heisei 1 = ISO 1989-01-09

  era - the Japanese era, not null - `java.time.chrono.JapaneseEra`
  year-of-era - the Japanese year-of-era - `int`
  month - the Japanese month-of-year, from 1 to 12 - `int`
  day-of-month - the Japanese day-of-month, from 1 to 31 - `int`

  returns: the date in Japanese calendar system, not null - `java.time.chrono.JapaneseDate`

  throws: java.time.DateTimeException - if the value of any field is out of range, or if the day-of-month is invalid for the month-year, or if the date is not a Japanese era"
  (^java.time.chrono.JapaneseDate [^java.time.chrono.JapaneseEra era ^Integer year-of-era ^Integer month ^Integer day-of-month]
    (JapaneseDate/of era year-of-era month day-of-month))
  (^java.time.chrono.JapaneseDate [^Integer proleptic-year ^Integer month ^Integer day-of-month]
    (JapaneseDate/of proleptic-year month day-of-month)))

(defn *from
  "Obtains a JapaneseDate from a temporal object.

   This obtains a date in the Japanese calendar system based on the specified temporal.
   A TemporalAccessor represents an arbitrary set of date and time information,
   which this factory converts to an instance of JapaneseDate.

   The conversion typically uses the EPOCH_DAY
   field, which is standardized across calendar systems.

   This method matches the signature of the functional interface TemporalQuery
   allowing it to be used as a query via method reference, JapaneseDate::from.

  temporal - the temporal object to convert, not null - `java.time.temporal.TemporalAccessor`

  returns: the date in Japanese calendar system, not null - `java.time.chrono.JapaneseDate`

  throws: java.time.DateTimeException - if unable to convert to a JapaneseDate"
  (^java.time.chrono.JapaneseDate [^java.time.temporal.TemporalAccessor temporal]
    (JapaneseDate/from temporal)))

(defn length-of-year
  "Description copied from interface: ChronoLocalDate

  returns: the length of the year in days - `int`"
  (^Integer [^JapaneseDate this]
    (-> this (.lengthOfYear))))

(defn range
  "Description copied from interface: TemporalAccessor

  field - the field to query the range for, not null - `java.time.temporal.TemporalField`

  returns: the range of valid values for the field, not null - `java.time.temporal.ValueRange`"
  (^java.time.temporal.ValueRange [^JapaneseDate this ^java.time.temporal.TemporalField field]
    (-> this (.range field))))

(defn get-era
  "Gets the era applicable at this date.

   The Japanese calendar system has multiple eras defined by JapaneseEra.

  returns: the era applicable at this date, not null - `java.time.chrono.JapaneseEra`"
  (^java.time.chrono.JapaneseEra [^JapaneseDate this]
    (-> this (.getEra))))

(defn to-epoch-day
  "Description copied from interface: ChronoLocalDate

  returns: the Epoch Day equivalent to this date - `long`"
  (^Long [^JapaneseDate this]
    (-> this (.toEpochDay))))

(defn plus
  "Description copied from interface: ChronoLocalDate

  amount-to-add - the amount of the specified unit to add, may be negative - `long`
  unit - the unit of the amount to add, not null - `java.time.temporal.TemporalUnit`

  returns: an object of the same type with the specified period added, not null - `java.time.chrono.JapaneseDate`"
  (^java.time.chrono.JapaneseDate [^JapaneseDate this ^Long amount-to-add ^java.time.temporal.TemporalUnit unit]
    (-> this (.plus amount-to-add unit)))
  (^java.time.chrono.JapaneseDate [^JapaneseDate this ^java.time.temporal.TemporalAmount amount]
    (-> this (.plus amount))))

(defn to-string
  "Description copied from class: Object

  returns: a string representation of the object. - `java.lang.String`"
  (^java.lang.String [^JapaneseDate this]
    (-> this (.toString))))

(defn minus
  "Description copied from interface: ChronoLocalDate

  amount-to-add - the amount of the specified unit to subtract, may be negative - `long`
  unit - the unit of the amount to subtract, not null - `java.time.temporal.TemporalUnit`

  returns: an object of the same type with the specified period subtracted, not null - `java.time.chrono.JapaneseDate`"
  (^java.time.chrono.JapaneseDate [^JapaneseDate this ^Long amount-to-add ^java.time.temporal.TemporalUnit unit]
    (-> this (.minus amount-to-add unit)))
  (^java.time.chrono.JapaneseDate [^JapaneseDate this ^java.time.temporal.TemporalAmount amount]
    (-> this (.minus amount))))

(defn get-long
  "Description copied from interface: TemporalAccessor

  field - the field to get, not null - `java.time.temporal.TemporalField`

  returns: the value for the field - `long`"
  (^Long [^JapaneseDate this ^java.time.temporal.TemporalField field]
    (-> this (.getLong field))))

(defn length-of-month
  "Returns the length of the month represented by this date.

   This returns the length of the month in days.
   Month lengths match those of the ISO calendar system.

  returns: the length of the month in days - `int`"
  (^Integer [^JapaneseDate this]
    (-> this (.lengthOfMonth))))

(defn until
  "Description copied from interface: ChronoLocalDate

  end-exclusive - the end date, exclusive, which is converted to a ChronoLocalDate in the same chronology, not null - `java.time.temporal.Temporal`
  unit - the unit to measure the amount in, not null - `java.time.temporal.TemporalUnit`

  returns: the amount of time between this date and the end date - `long`"
  (^Long [^JapaneseDate this ^java.time.temporal.Temporal end-exclusive ^java.time.temporal.TemporalUnit unit]
    (-> this (.until end-exclusive unit)))
  (^java.time.chrono.ChronoPeriod [^JapaneseDate this ^java.time.chrono.ChronoLocalDate end-date]
    (-> this (.until end-date))))

(defn supported?
  "Checks if the specified field is supported.

   This checks if this date can be queried for the specified field.
   If false, then calling the range and
   get methods will throw an exception.

   If the field is a ChronoField then the query is implemented here.
   The supported fields are:

   DAY_OF_WEEK
   DAY_OF_MONTH
   DAY_OF_YEAR
   EPOCH_DAY
   MONTH_OF_YEAR
   PROLEPTIC_MONTH
   YEAR_OF_ERA
   YEAR
   ERA

   All other ChronoField instances will return false.

   If the field is not a ChronoField, then the result of this method
   is obtained by invoking TemporalField.isSupportedBy(TemporalAccessor)
   passing this as the argument.
   Whether the field is supported is determined by the field.

  field - the field to check, null returns false - `java.time.temporal.TemporalField`

  returns: true if the field is supported on this date, false if not - `boolean`"
  (^Boolean [^JapaneseDate this ^java.time.temporal.TemporalField field]
    (-> this (.isSupported field))))

(defn get-chronology
  "Gets the chronology of this date, which is the Japanese calendar system.

   The Chronology represents the calendar system in use.
   The era and other fields in ChronoField are defined by the chronology.

  returns: the Japanese chronology, not null - `java.time.chrono.JapaneseChronology`"
  (^java.time.chrono.JapaneseChronology [^JapaneseDate this]
    (-> this (.getChronology))))

(defn hash-code
  "A hash code for this date.

  returns: a suitable hash code based only on the Chronology and the date - `int`"
  (^Integer [^JapaneseDate this]
    (-> this (.hashCode))))

(defn with
  "Description copied from interface: ChronoLocalDate

  field - the field to set in the result, not null - `java.time.temporal.TemporalField`
  new-value - the new value of the field in the result - `long`

  returns: an object of the same type with the specified field set, not null - `java.time.chrono.JapaneseDate`"
  (^java.time.chrono.JapaneseDate [^JapaneseDate this ^java.time.temporal.TemporalField field ^Long new-value]
    (-> this (.with field new-value)))
  (^java.time.chrono.JapaneseDate [^JapaneseDate this ^java.time.temporal.TemporalAdjuster adjuster]
    (-> this (.with adjuster))))

(defn equals
  "Compares this date to another date, including the chronology.

   Compares this JapaneseDate with another ensuring that the date is the same.

   Only objects of type JapaneseDate are compared, other types return false.
   To compare the dates of two TemporalAccessor instances, including dates
   in two different chronologies, use ChronoField.EPOCH_DAY as a comparator.

  obj - the object to check, null returns false - `java.lang.Object`

  returns: true if this is equal to the other date - `boolean`"
  (^Boolean [^JapaneseDate this ^java.lang.Object obj]
    (-> this (.equals obj))))

(defn at-time
  "Description copied from interface: ChronoLocalDate

  local-time - the local time to use, not null - `java.time.LocalTime`

  returns: the local date-time formed from this date and the specified time, not null - `java.time.chrono.ChronoLocalDateTime<java.time.chrono.JapaneseDate>`"
  (^java.time.chrono.ChronoLocalDateTime [^JapaneseDate this ^java.time.LocalTime local-time]
    (-> this (.atTime local-time))))

