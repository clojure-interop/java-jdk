(ns jdk.time.chrono.HijrahDate
  "A date in the Hijrah calendar system.

  This date operates using one of several variants of the
  java.time.chrono.Hijrah calendar.

  The Hijrah calendar has a different total of days in a year than
  Gregorian calendar, and the length of each month is based on the period
  of a complete revolution of the moon around the earth
  (as between successive new moons).
  Refer to the HijrahChronology for details of supported variants.

  Each HijrahDate is created bound to a particular HijrahChronology,
  The same chronology is propagated to each HijrahDate computed from the date.
  To use a different Hijrah variant, its HijrahChronology can be used
  to create new HijrahDate instances.
  Alternatively, the withVariant(java.time.chrono.HijrahChronology) method can be used to convert
  to a new HijrahChronology.


  This is a value-based
  class; use of identity-sensitive operations (including reference equality
  (==), identity hash code, or synchronization) on instances of
  HijrahDate may have unpredictable results and should be avoided.
  The equals method should be used for comparisons."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.time.chrono HijrahDate]))

(defn *now
  "Obtains the current HijrahDate of the Islamic Umm Al-Qura calendar
   in the specified time-zone.

   This will query the system clock to obtain the current date.
   Specifying the time-zone avoids dependence on the default time-zone.

   Using this method will prevent the ability to use an alternate clock for testing
   because the clock is hard-coded.

  zone - the zone ID to use, not null - `java.time.ZoneId`

  returns: the current date using the system clock, not null - `java.time.chrono.HijrahDate`"
  (^java.time.chrono.HijrahDate [^java.time.ZoneId zone]
    (HijrahDate/now zone))
  (^java.time.chrono.HijrahDate []
    (HijrahDate/now )))

(defn *of
  "Obtains a HijrahDate of the Islamic Umm Al-Qura calendar
   from the proleptic-year, month-of-year and day-of-month fields.

   This returns a HijrahDate with the specified fields.
   The day must be valid for the year and month, otherwise an exception will be thrown.

  proleptic-year - the Hijrah proleptic-year - `int`
  month - the Hijrah month-of-year, from 1 to 12 - `int`
  day-of-month - the Hijrah day-of-month, from 1 to 30 - `int`

  returns: the date in Hijrah calendar system, not null - `java.time.chrono.HijrahDate`

  throws: java.time.DateTimeException - if the value of any field is out of range, or if the day-of-month is invalid for the month-year"
  (^java.time.chrono.HijrahDate [^Integer proleptic-year ^Integer month ^Integer day-of-month]
    (HijrahDate/of proleptic-year month day-of-month)))

(defn *from
  "Obtains a HijrahDate of the Islamic Umm Al-Qura calendar from a temporal object.

   This obtains a date in the Hijrah calendar system based on the specified temporal.
   A TemporalAccessor represents an arbitrary set of date and time information,
   which this factory converts to an instance of HijrahDate.

   The conversion typically uses the EPOCH_DAY
   field, which is standardized across calendar systems.

   This method matches the signature of the functional interface TemporalQuery
   allowing it to be used as a query via method reference, HijrahDate::from.

  temporal - the temporal object to convert, not null - `java.time.temporal.TemporalAccessor`

  returns: the date in Hijrah calendar system, not null - `java.time.chrono.HijrahDate`

  throws: java.time.DateTimeException - if unable to convert to a HijrahDate"
  (^java.time.chrono.HijrahDate [^java.time.temporal.TemporalAccessor temporal]
    (HijrahDate/from temporal)))

(defn length-of-year
  "Returns the length of the year represented by this date.

   This returns the length of the year in days.
   A Hijrah calendar system year is typically shorter than
   that of the ISO calendar system.

  returns: the length of the year in days - `int`"
  (^Integer [^java.time.chrono.HijrahDate this]
    (-> this (.lengthOfYear))))

(defn range
  "Description copied from interface: TemporalAccessor

  field - the field to query the range for, not null - `java.time.temporal.TemporalField`

  returns: the range of valid values for the field, not null - `java.time.temporal.ValueRange`"
  (^java.time.temporal.ValueRange [^java.time.chrono.HijrahDate this ^java.time.temporal.TemporalField field]
    (-> this (.range field))))

(defn get-era
  "Gets the era applicable at this date.

   The Hijrah calendar system has one era, 'AH',
   defined by HijrahEra.

  returns: the era applicable at this date, not null - `java.time.chrono.HijrahEra`"
  (^java.time.chrono.HijrahEra [^java.time.chrono.HijrahDate this]
    (-> this (.getEra))))

(defn to-epoch-day
  "Description copied from interface: ChronoLocalDate

  returns: the Epoch Day equivalent to this date - `long`"
  (^Long [^java.time.chrono.HijrahDate this]
    (-> this (.toEpochDay))))

(defn plus
  "Description copied from interface: ChronoLocalDate

  amount-to-add - the amount of the specified unit to add, may be negative - `long`
  unit - the unit of the amount to add, not null - `java.time.temporal.TemporalUnit`

  returns: an object of the same type with the specified period added, not null - `java.time.chrono.HijrahDate`"
  (^java.time.chrono.HijrahDate [^java.time.chrono.HijrahDate this ^Long amount-to-add ^java.time.temporal.TemporalUnit unit]
    (-> this (.plus amount-to-add unit)))
  (^java.time.chrono.HijrahDate [^java.time.chrono.HijrahDate this ^java.time.temporal.TemporalAmount amount]
    (-> this (.plus amount))))

(defn leap-year?
  "Checks if the year is a leap year, according to the Hijrah calendar system rules.

  returns: true if this date is in a leap year - `boolean`"
  (^Boolean [^java.time.chrono.HijrahDate this]
    (-> this (.isLeapYear))))

(defn to-string
  "Description copied from class: Object

  returns: a string representation of the object. - `java.lang.String`"
  (^java.lang.String [^java.time.chrono.HijrahDate this]
    (-> this (.toString))))

(defn minus
  "Description copied from interface: ChronoLocalDate

  amount-to-subtract - the amount of the specified unit to subtract, may be negative - `long`
  unit - the unit of the amount to subtract, not null - `java.time.temporal.TemporalUnit`

  returns: an object of the same type with the specified period subtracted, not null - `java.time.chrono.HijrahDate`"
  (^java.time.chrono.HijrahDate [^java.time.chrono.HijrahDate this ^Long amount-to-subtract ^java.time.temporal.TemporalUnit unit]
    (-> this (.minus amount-to-subtract unit)))
  (^java.time.chrono.HijrahDate [^java.time.chrono.HijrahDate this ^java.time.temporal.TemporalAmount amount]
    (-> this (.minus amount))))

(defn get-long
  "Description copied from interface: TemporalAccessor

  field - the field to get, not null - `java.time.temporal.TemporalField`

  returns: the value for the field - `long`"
  (^Long [^java.time.chrono.HijrahDate this ^java.time.temporal.TemporalField field]
    (-> this (.getLong field))))

(defn length-of-month
  "Returns the length of the month represented by this date.

   This returns the length of the month in days.
   Month lengths in the Hijrah calendar system vary between 29 and 30 days.

  returns: the length of the month in days - `int`"
  (^Integer [^java.time.chrono.HijrahDate this]
    (-> this (.lengthOfMonth))))

(defn until
  "Description copied from interface: ChronoLocalDate

  end-exclusive - the end date, exclusive, which is converted to a ChronoLocalDate in the same chronology, not null - `java.time.temporal.Temporal`
  unit - the unit to measure the amount in, not null - `java.time.temporal.TemporalUnit`

  returns: the amount of time between this date and the end date - `long`"
  (^Long [^java.time.chrono.HijrahDate this ^java.time.temporal.Temporal end-exclusive ^java.time.temporal.TemporalUnit unit]
    (-> this (.until end-exclusive unit)))
  (^java.time.chrono.ChronoPeriod [^java.time.chrono.HijrahDate this ^java.time.chrono.ChronoLocalDate end-date]
    (-> this (.until end-date))))

(defn get-chronology
  "Gets the chronology of this date, which is the Hijrah calendar system.

   The Chronology represents the calendar system in use.
   The era and other fields in ChronoField are defined by the chronology.

  returns: the Hijrah chronology, not null - `java.time.chrono.HijrahChronology`"
  (^java.time.chrono.HijrahChronology [^java.time.chrono.HijrahDate this]
    (-> this (.getChronology))))

(defn hash-code
  "A hash code for this date.

  returns: a suitable hash code based only on the Chronology and the date - `int`"
  (^Integer [^java.time.chrono.HijrahDate this]
    (-> this (.hashCode))))

(defn with-variant
  "Returns a HijrahDate with the Chronology requested.

   The year, month, and day are checked against the new requested
   HijrahChronology.  If the chronology has a shorter month length
   for the month, the day is reduced to be the last day of the month.

  chronology - the new HijrahChonology, non-null - `java.time.chrono.HijrahChronology`

  returns: a HijrahDate with the requested HijrahChronology, non-null - `java.time.chrono.HijrahDate`"
  (^java.time.chrono.HijrahDate [^java.time.chrono.HijrahDate this ^java.time.chrono.HijrahChronology chronology]
    (-> this (.withVariant chronology))))

(defn with
  "Description copied from interface: ChronoLocalDate

  field - the field to set in the result, not null - `java.time.temporal.TemporalField`
  new-value - the new value of the field in the result - `long`

  returns: an object of the same type with the specified field set, not null - `java.time.chrono.HijrahDate`"
  (^java.time.chrono.HijrahDate [^java.time.chrono.HijrahDate this ^java.time.temporal.TemporalField field ^Long new-value]
    (-> this (.with field new-value)))
  (^java.time.chrono.HijrahDate [^java.time.chrono.HijrahDate this ^java.time.temporal.TemporalAdjuster adjuster]
    (-> this (.with adjuster))))

(defn equals
  "Compares this date to another date, including the chronology.

   Compares this HijrahDate with another ensuring that the date is the same.

   Only objects of type HijrahDate are compared, other types return false.
   To compare the dates of two TemporalAccessor instances, including dates
   in two different chronologies, use ChronoField.EPOCH_DAY as a comparator.

  obj - the object to check, null returns false - `java.lang.Object`

  returns: true if this is equal to the other date and the Chronologies are equal - `boolean`"
  (^Boolean [^java.time.chrono.HijrahDate this ^java.lang.Object obj]
    (-> this (.equals obj))))

(defn at-time
  "Description copied from interface: ChronoLocalDate

  local-time - the local time to use, not null - `java.time.LocalTime`

  returns: the local date-time formed from this date and the specified time, not null - `java.time.chrono.ChronoLocalDateTime<java.time.chrono.HijrahDate>`"
  (^java.time.chrono.ChronoLocalDateTime [^java.time.chrono.HijrahDate this ^java.time.LocalTime local-time]
    (-> this (.atTime local-time))))

