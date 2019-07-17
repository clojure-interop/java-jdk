(ns jdk.time.chrono.ThaiBuddhistDate
  "A date in the Thai Buddhist calendar system.

  This date operates using the java.time.chrono.Thai Buddhist calendar.
  This calendar system is primarily used in Thailand.
  Dates are aligned such that 2484-01-01 (Buddhist) is 1941-01-01 (ISO).


  This is a value-based
  class; use of identity-sensitive operations (including reference equality
  (==), identity hash code, or synchronization) on instances of
  ThaiBuddhistDate may have unpredictable results and should be avoided.
  The equals method should be used for comparisons."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.time.chrono ThaiBuddhistDate]))

(defn *now
  "Obtains the current ThaiBuddhistDate from the system clock in the specified time-zone.

   This will query the system clock to obtain the current date.
   Specifying the time-zone avoids dependence on the default time-zone.

   Using this method will prevent the ability to use an alternate clock for testing
   because the clock is hard-coded.

  zone - the zone ID to use, not null - `java.time.ZoneId`

  returns: the current date using the system clock, not null - `java.time.chrono.ThaiBuddhistDate`"
  ([^java.time.ZoneId zone]
    (ThaiBuddhistDate/now zone))
  ([]
    (ThaiBuddhistDate/now )))

(defn *of
  "Obtains a ThaiBuddhistDate representing a date in the Thai Buddhist calendar
   system from the proleptic-year, month-of-year and day-of-month fields.

   This returns a ThaiBuddhistDate with the specified fields.
   The day must be valid for the year and month, otherwise an exception will be thrown.

  proleptic-year - the Thai Buddhist proleptic-year - `int`
  month - the Thai Buddhist month-of-year, from 1 to 12 - `int`
  day-of-month - the Thai Buddhist day-of-month, from 1 to 31 - `int`

  returns: the date in Thai Buddhist calendar system, not null - `java.time.chrono.ThaiBuddhistDate`

  throws: java.time.DateTimeException - if the value of any field is out of range, or if the day-of-month is invalid for the month-year"
  ([^Integer proleptic-year ^Integer month ^Integer day-of-month]
    (ThaiBuddhistDate/of proleptic-year month day-of-month)))

(defn *from
  "Obtains a ThaiBuddhistDate from a temporal object.

   This obtains a date in the Thai Buddhist calendar system based on the specified temporal.
   A TemporalAccessor represents an arbitrary set of date and time information,
   which this factory converts to an instance of ThaiBuddhistDate.

   The conversion typically uses the EPOCH_DAY
   field, which is standardized across calendar systems.

   This method matches the signature of the functional interface TemporalQuery
   allowing it to be used as a query via method reference, ThaiBuddhistDate::from.

  temporal - the temporal object to convert, not null - `java.time.temporal.TemporalAccessor`

  returns: the date in Thai Buddhist calendar system, not null - `java.time.chrono.ThaiBuddhistDate`

  throws: java.time.DateTimeException - if unable to convert to a ThaiBuddhistDate"
  ([^java.time.temporal.TemporalAccessor temporal]
    (ThaiBuddhistDate/from temporal)))

(defn range
  "Description copied from interface: TemporalAccessor

  field - the field to query the range for, not null - `java.time.temporal.TemporalField`

  returns: the range of valid values for the field, not null - `java.time.temporal.ValueRange`"
  ([^java.time.chrono.ThaiBuddhistDate this ^java.time.temporal.TemporalField field]
    (-> this (.range field))))

(defn get-era
  "Gets the era applicable at this date.

   The Thai Buddhist calendar system has two eras, 'BE' and 'BEFORE_BE',
   defined by ThaiBuddhistEra.

  returns: the era applicable at this date, not null - `java.time.chrono.ThaiBuddhistEra`"
  ([^java.time.chrono.ThaiBuddhistDate this]
    (-> this (.getEra))))

(defn to-epoch-day
  "Description copied from interface: ChronoLocalDate

  returns: the Epoch Day equivalent to this date - `long`"
  ([^java.time.chrono.ThaiBuddhistDate this]
    (-> this (.toEpochDay))))

(defn plus
  "Description copied from interface: ChronoLocalDate

  amount-to-add - the amount of the specified unit to add, may be negative - `long`
  unit - the unit of the amount to add, not null - `java.time.temporal.TemporalUnit`

  returns: an object of the same type with the specified period added, not null - `java.time.chrono.ThaiBuddhistDate`"
  ([^java.time.chrono.ThaiBuddhistDate this ^Long amount-to-add ^java.time.temporal.TemporalUnit unit]
    (-> this (.plus amount-to-add unit)))
  ([^java.time.chrono.ThaiBuddhistDate this ^java.time.temporal.TemporalAmount amount]
    (-> this (.plus amount))))

(defn to-string
  "Description copied from class: Object

  returns: a string representation of the object. - `java.lang.String`"
  ([^java.time.chrono.ThaiBuddhistDate this]
    (-> this (.toString))))

(defn minus
  "Description copied from interface: ChronoLocalDate

  amount-to-add - the amount of the specified unit to subtract, may be negative - `long`
  unit - the unit of the amount to subtract, not null - `java.time.temporal.TemporalUnit`

  returns: an object of the same type with the specified period subtracted, not null - `java.time.chrono.ThaiBuddhistDate`"
  ([^java.time.chrono.ThaiBuddhistDate this ^Long amount-to-add ^java.time.temporal.TemporalUnit unit]
    (-> this (.minus amount-to-add unit)))
  ([^java.time.chrono.ThaiBuddhistDate this ^java.time.temporal.TemporalAmount amount]
    (-> this (.minus amount))))

(defn get-long
  "Description copied from interface: TemporalAccessor

  field - the field to get, not null - `java.time.temporal.TemporalField`

  returns: the value for the field - `long`"
  ([^java.time.chrono.ThaiBuddhistDate this ^java.time.temporal.TemporalField field]
    (-> this (.getLong field))))

(defn length-of-month
  "Returns the length of the month represented by this date.

   This returns the length of the month in days.
   Month lengths match those of the ISO calendar system.

  returns: the length of the month in days - `int`"
  ([^java.time.chrono.ThaiBuddhistDate this]
    (-> this (.lengthOfMonth))))

(defn until
  "Description copied from interface: ChronoLocalDate

  end-exclusive - the end date, exclusive, which is converted to a ChronoLocalDate in the same chronology, not null - `java.time.temporal.Temporal`
  unit - the unit to measure the amount in, not null - `java.time.temporal.TemporalUnit`

  returns: the amount of time between this date and the end date - `long`"
  ([^java.time.chrono.ThaiBuddhistDate this ^java.time.temporal.Temporal end-exclusive ^java.time.temporal.TemporalUnit unit]
    (-> this (.until end-exclusive unit)))
  ([^java.time.chrono.ThaiBuddhistDate this ^java.time.chrono.ChronoLocalDate end-date]
    (-> this (.until end-date))))

(defn get-chronology
  "Gets the chronology of this date, which is the Thai Buddhist calendar system.

   The Chronology represents the calendar system in use.
   The era and other fields in ChronoField are defined by the chronology.

  returns: the Thai Buddhist chronology, not null - `java.time.chrono.ThaiBuddhistChronology`"
  ([^java.time.chrono.ThaiBuddhistDate this]
    (-> this (.getChronology))))

(defn hash-code
  "A hash code for this date.

  returns: a suitable hash code based only on the Chronology and the date - `int`"
  ([^java.time.chrono.ThaiBuddhistDate this]
    (-> this (.hashCode))))

(defn with
  "Description copied from interface: ChronoLocalDate

  field - the field to set in the result, not null - `java.time.temporal.TemporalField`
  new-value - the new value of the field in the result - `long`

  returns: an object of the same type with the specified field set, not null - `java.time.chrono.ThaiBuddhistDate`"
  ([^java.time.chrono.ThaiBuddhistDate this ^java.time.temporal.TemporalField field ^Long new-value]
    (-> this (.with field new-value)))
  ([^java.time.chrono.ThaiBuddhistDate this ^java.time.temporal.TemporalAdjuster adjuster]
    (-> this (.with adjuster))))

(defn equals
  "Compares this date to another date, including the chronology.

   Compares this ThaiBuddhistDate with another ensuring that the date is the same.

   Only objects of type ThaiBuddhistDate are compared, other types return false.
   To compare the dates of two TemporalAccessor instances, including dates
   in two different chronologies, use ChronoField.EPOCH_DAY as a comparator.

  obj - the object to check, null returns false - `java.lang.Object`

  returns: true if this is equal to the other date - `boolean`"
  ([^java.time.chrono.ThaiBuddhistDate this ^java.lang.Object obj]
    (-> this (.equals obj))))

(defn at-time
  "Description copied from interface: ChronoLocalDate

  local-time - the local time to use, not null - `java.time.LocalTime`

  returns: the local date-time formed from this date and the specified time, not null - `java.time.chrono.ChronoLocalDateTime<java.time.chrono.ThaiBuddhistDate>`"
  ([^java.time.chrono.ThaiBuddhistDate this ^java.time.LocalTime local-time]
    (-> this (.atTime local-time))))

