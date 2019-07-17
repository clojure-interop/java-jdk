(ns jdk.time.chrono.MinguoDate
  "A date in the Minguo calendar system.

  This date operates using the java.time.chrono.Minguo calendar.
  This calendar system is primarily used in the Republic of China, often known as Taiwan.
  Dates are aligned such that 0001-01-01 (Minguo) is 1912-01-01 (ISO).


  This is a value-based
  class; use of identity-sensitive operations (including reference equality
  (==), identity hash code, or synchronization) on instances of
  MinguoDate may have unpredictable results and should be avoided.
  The equals method should be used for comparisons."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.time.chrono MinguoDate]))

(defn *now
  "Obtains the current MinguoDate from the system clock in the specified time-zone.

   This will query the system clock to obtain the current date.
   Specifying the time-zone avoids dependence on the default time-zone.

   Using this method will prevent the ability to use an alternate clock for testing
   because the clock is hard-coded.

  zone - the zone ID to use, not null - `java.time.ZoneId`

  returns: the current date using the system clock, not null - `java.time.chrono.MinguoDate`"
  ([zone]
    (MinguoDate/now zone))
  ([]
    (MinguoDate/now )))

(defn *of
  "Obtains a MinguoDate representing a date in the Minguo calendar
   system from the proleptic-year, month-of-year and day-of-month fields.

   This returns a MinguoDate with the specified fields.
   The day must be valid for the year and month, otherwise an exception will be thrown.

  proleptic-year - the Minguo proleptic-year - `int`
  month - the Minguo month-of-year, from 1 to 12 - `int`
  day-of-month - the Minguo day-of-month, from 1 to 31 - `int`

  returns: the date in Minguo calendar system, not null - `java.time.chrono.MinguoDate`

  throws: java.time.DateTimeException - if the value of any field is out of range, or if the day-of-month is invalid for the month-year"
  ([proleptic-year month day-of-month]
    (MinguoDate/of proleptic-year month day-of-month)))

(defn *from
  "Obtains a MinguoDate from a temporal object.

   This obtains a date in the Minguo calendar system based on the specified temporal.
   A TemporalAccessor represents an arbitrary set of date and time information,
   which this factory converts to an instance of MinguoDate.

   The conversion typically uses the EPOCH_DAY
   field, which is standardized across calendar systems.

   This method matches the signature of the functional interface TemporalQuery
   allowing it to be used as a query via method reference, MinguoDate::from.

  temporal - the temporal object to convert, not null - `java.time.temporal.TemporalAccessor`

  returns: the date in Minguo calendar system, not null - `java.time.chrono.MinguoDate`

  throws: java.time.DateTimeException - if unable to convert to a MinguoDate"
  ([temporal]
    (MinguoDate/from temporal)))

(defn range
  "Description copied from interface: TemporalAccessor

  field - the field to query the range for, not null - `java.time.temporal.TemporalField`

  returns: the range of valid values for the field, not null - `java.time.temporal.ValueRange`"
  ([this field]
    (-> this (.range field))))

(defn get-era
  "Gets the era applicable at this date.

   The Minguo calendar system has two eras, 'ROC' and 'BEFORE_ROC',
   defined by MinguoEra.

  returns: the era applicable at this date, not null - `java.time.chrono.MinguoEra`"
  ([this]
    (-> this (.getEra))))

(defn to-epoch-day
  "Description copied from interface: ChronoLocalDate

  returns: the Epoch Day equivalent to this date - `long`"
  ([this]
    (-> this (.toEpochDay))))

(defn plus
  "Description copied from interface: ChronoLocalDate

  amount-to-add - the amount of the specified unit to add, may be negative - `long`
  unit - the unit of the amount to add, not null - `java.time.temporal.TemporalUnit`

  returns: an object of the same type with the specified period added, not null - `java.time.chrono.MinguoDate`"
  ([this amount-to-add unit]
    (-> this (.plus amount-to-add unit)))
  ([this amount]
    (-> this (.plus amount))))

(defn to-string
  "Description copied from class: Object

  returns: a string representation of the object. - `java.lang.String`"
  ([this]
    (-> this (.toString))))

(defn minus
  "Description copied from interface: ChronoLocalDate

  amount-to-add - the amount of the specified unit to subtract, may be negative - `long`
  unit - the unit of the amount to subtract, not null - `java.time.temporal.TemporalUnit`

  returns: an object of the same type with the specified period subtracted, not null - `java.time.chrono.MinguoDate`"
  ([this amount-to-add unit]
    (-> this (.minus amount-to-add unit)))
  ([this amount]
    (-> this (.minus amount))))

(defn get-long
  "Description copied from interface: TemporalAccessor

  field - the field to get, not null - `java.time.temporal.TemporalField`

  returns: the value for the field - `long`"
  ([this field]
    (-> this (.getLong field))))

(defn length-of-month
  "Returns the length of the month represented by this date.

   This returns the length of the month in days.
   Month lengths match those of the ISO calendar system.

  returns: the length of the month in days - `int`"
  ([this]
    (-> this (.lengthOfMonth))))

(defn until
  "Description copied from interface: ChronoLocalDate

  end-exclusive - the end date, exclusive, which is converted to a ChronoLocalDate in the same chronology, not null - `java.time.temporal.Temporal`
  unit - the unit to measure the amount in, not null - `java.time.temporal.TemporalUnit`

  returns: the amount of time between this date and the end date - `long`"
  ([this end-exclusive unit]
    (-> this (.until end-exclusive unit)))
  ([this end-date]
    (-> this (.until end-date))))

(defn get-chronology
  "Gets the chronology of this date, which is the Minguo calendar system.

   The Chronology represents the calendar system in use.
   The era and other fields in ChronoField are defined by the chronology.

  returns: the Minguo chronology, not null - `java.time.chrono.MinguoChronology`"
  ([this]
    (-> this (.getChronology))))

(defn hash-code
  "A hash code for this date.

  returns: a suitable hash code based only on the Chronology and the date - `int`"
  ([this]
    (-> this (.hashCode))))

(defn with
  "Description copied from interface: ChronoLocalDate

  field - the field to set in the result, not null - `java.time.temporal.TemporalField`
  new-value - the new value of the field in the result - `long`

  returns: an object of the same type with the specified field set, not null - `java.time.chrono.MinguoDate`"
  ([this field new-value]
    (-> this (.with field new-value)))
  ([this adjuster]
    (-> this (.with adjuster))))

(defn equals
  "Compares this date to another date, including the chronology.

   Compares this MinguoDate with another ensuring that the date is the same.

   Only objects of type MinguoDate are compared, other types return false.
   To compare the dates of two TemporalAccessor instances, including dates
   in two different chronologies, use ChronoField.EPOCH_DAY as a comparator.

  obj - the object to check, null returns false - `java.lang.Object`

  returns: true if this is equal to the other date - `boolean`"
  ([this obj]
    (-> this (.equals obj))))

(defn at-time
  "Description copied from interface: ChronoLocalDate

  local-time - the local time to use, not null - `java.time.LocalTime`

  returns: the local date-time formed from this date and the specified time, not null - `java.time.chrono.ChronoLocalDateTime<java.time.chrono.MinguoDate>`"
  ([this local-time]
    (-> this (.atTime local-time))))

