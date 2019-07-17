(ns jdk.time.chrono.ThaiBuddhistChronology
  "The Thai Buddhist calendar system.

  This chronology defines the rules of the Thai Buddhist calendar system.
  This calendar system is primarily used in Thailand.
  Dates are aligned such that 2484-01-01 (Buddhist) is 1941-01-01 (ISO).

  The fields are defined as follows:

  era - There are two eras, the current 'Buddhist' (ERA_BE) and the previous era (ERA_BEFORE_BE).
  year-of-era - The year-of-era for the current era increases uniformly from the epoch at year one.
   For the previous era the year increases from one as time goes backwards.
   The value for the current era is equal to the ISO proleptic-year plus 543.
  proleptic-year - The proleptic year is the same as the year-of-era for the
   current era. For the previous era, years have zero, then negative values.
   The value is equal to the ISO proleptic-year plus 543.
  month-of-year - The ThaiBuddhist month-of-year exactly matches ISO.
  day-of-month - The ThaiBuddhist day-of-month exactly matches ISO.
  day-of-year - The ThaiBuddhist day-of-year exactly matches ISO.
  leap-year - The ThaiBuddhist leap-year pattern exactly matches ISO, such that the two calendars
   are never out of step."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.time.chrono ThaiBuddhistChronology]))

(def *-instance
  "Static Constant.

  Singleton instance of the Buddhist chronology.

  type: java.time.chrono.ThaiBuddhistChronology"
  ThaiBuddhistChronology/INSTANCE)

(defn date-now
  "Description copied from interface: Chronology

  zone - the zone ID to use, not null - `java.time.ZoneId`

  returns: the current local date using the system clock, not null - `java.time.chrono.ThaiBuddhistDate`"
  ([this zone]
    (-> this (.dateNow zone)))
  ([this]
    (-> this (.dateNow))))

(defn range
  "Description copied from interface: Chronology

  field - the field to get the range for, not null - `java.time.temporal.ChronoField`

  returns: the range of valid values for the field, not null - `java.time.temporal.ValueRange`"
  ([this field]
    (-> this (.range field))))

(defn local-date-time
  "Description copied from interface: Chronology

  temporal - the temporal object to convert, not null - `java.time.temporal.TemporalAccessor`

  returns: the local date-time in this chronology, not null - `java.time.chrono.ChronoLocalDateTime<java.time.chrono.ThaiBuddhistDate>`"
  ([this temporal]
    (-> this (.localDateTime temporal))))

(defn resolve-date
  "Description copied from class: AbstractChronology

  field-values - the map of fields to values, which can be updated, not null - `java.util.Map<java.time.temporal.TemporalField,java.lang.Long>`
  resolver-style - the requested type of resolve, not null - `java.time.format.ResolverStyle`

  returns: the resolved date, null if insufficient information to create a date - `java.time.chrono.ThaiBuddhistDate`"
  ([this field-values resolver-style]
    (-> this (.resolveDate field-values resolver-style))))

(defn leap-year?
  "Checks if the specified year is a leap year.

   Thai Buddhist leap years occur exactly in line with ISO leap years.
   This method does not validate the year passed in, and only has a
   well-defined result for years in the supported range.

  proleptic-year - the proleptic-year to check, not validated for range - `long`

  returns: true if the year is a leap year - `boolean`"
  ([this proleptic-year]
    (-> this (.isLeapYear proleptic-year))))

(defn date-year-day
  "Obtains a local date in Thai Buddhist calendar system from the
   era, year-of-era and day-of-year fields.

  era - the Thai Buddhist era, not null - `java.time.chrono.Era`
  year-of-era - the year-of-era - `int`
  day-of-year - the day-of-year - `int`

  returns: the Thai Buddhist local date, not null - `java.time.chrono.ThaiBuddhistDate`

  throws: java.time.DateTimeException - if unable to create the date"
  ([this era year-of-era day-of-year]
    (-> this (.dateYearDay era year-of-era day-of-year)))
  ([this proleptic-year day-of-year]
    (-> this (.dateYearDay proleptic-year day-of-year))))

(defn date-epoch-day
  "Obtains a local date in the Thai Buddhist calendar system from the epoch-day.

  epoch-day - the epoch day - `long`

  returns: the Thai Buddhist local date, not null - `java.time.chrono.ThaiBuddhistDate`

  throws: java.time.DateTimeException - if unable to create the date"
  ([this epoch-day]
    (-> this (.dateEpochDay epoch-day))))

(defn eras
  "Description copied from interface: Chronology

  returns: the list of eras for the chronology, may be immutable, not null - `java.util.List<java.time.chrono.Era>`"
  ([this]
    (-> this (.eras))))

(defn era-of
  "Description copied from interface: Chronology

  era-value - the era value - `int`

  returns: the calendar system era, not null - `java.time.chrono.ThaiBuddhistEra`"
  ([this era-value]
    (-> this (.eraOf era-value))))

(defn proleptic-year
  "Description copied from interface: Chronology

  era - the era of the correct type for the chronology, not null - `java.time.chrono.Era`
  year-of-era - the chronology year-of-era - `int`

  returns: the proleptic-year - `int`"
  ([this era year-of-era]
    (-> this (.prolepticYear era year-of-era))))

(defn get-calendar-type
  "Gets the calendar type of the underlying calendar system - 'buddhist'.

   The calendar type is an identifier defined by the
   Unicode Locale Data Markup Language (LDML) specification.
   It can be used to lookup the Chronology using Chronology.of(String).
   It can also be used as part of a locale, accessible via
   Locale.getUnicodeLocaleType(String) with the key 'ca'.

  returns: the calendar system type - 'buddhist' - `java.lang.String`"
  ([this]
    (-> this (.getCalendarType))))

(defn get-id
  "Gets the ID of the chronology - 'ThaiBuddhist'.

   The ID uniquely identifies the Chronology.
   It can be used to lookup the Chronology using Chronology.of(String).

  returns: the chronology ID - 'ThaiBuddhist' - `java.lang.String`"
  ([this]
    (-> this (.getId))))

(defn date
  "Obtains a local date in Thai Buddhist calendar system from the
   era, year-of-era, month-of-year and day-of-month fields.

  era - the Thai Buddhist era, not null - `java.time.chrono.Era`
  year-of-era - the year-of-era - `int`
  month - the month-of-year - `int`
  day-of-month - the day-of-month - `int`

  returns: the Thai Buddhist local date, not null - `java.time.chrono.ThaiBuddhistDate`

  throws: java.time.DateTimeException - if unable to create the date"
  ([this era year-of-era month day-of-month]
    (-> this (.date era year-of-era month day-of-month)))
  ([this proleptic-year month day-of-month]
    (-> this (.date proleptic-year month day-of-month)))
  ([this temporal]
    (-> this (.date temporal))))

(defn zoned-date-time
  "Description copied from interface: Chronology

  instant - the instant to create the date-time from, not null - `java.time.Instant`
  zone - the time-zone, not null - `java.time.ZoneId`

  returns: the zoned date-time, not null - `java.time.chrono.ChronoZonedDateTime<java.time.chrono.ThaiBuddhistDate>`"
  ([this instant zone]
    (-> this (.zonedDateTime instant zone)))
  ([this temporal]
    (-> this (.zonedDateTime temporal))))

