(ns jdk.time.chrono.MinguoChronology
  "The Minguo calendar system.

  This chronology defines the rules of the Minguo calendar system.
  This calendar system is primarily used in the Republic of China, often known as Taiwan.
  Dates are aligned such that 0001-01-01 (Minguo) is 1912-01-01 (ISO).

  The fields are defined as follows:

  era - There are two eras, the current 'Republic' (ERA_ROC) and the previous era (ERA_BEFORE_ROC).
  year-of-era - The year-of-era for the current era increases uniformly from the epoch at year one.
   For the previous era the year increases from one as time goes backwards.
   The value for the current era is equal to the ISO proleptic-year minus 1911.
  proleptic-year - The proleptic year is the same as the year-of-era for the
   current era. For the previous era, years have zero, then negative values.
   The value is equal to the ISO proleptic-year minus 1911.
  month-of-year - The Minguo month-of-year exactly matches ISO.
  day-of-month - The Minguo day-of-month exactly matches ISO.
  day-of-year - The Minguo day-of-year exactly matches ISO.
  leap-year - The Minguo leap-year pattern exactly matches ISO, such that the two calendars
   are never out of step."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.time.chrono MinguoChronology]))

(def *-instance
  "Static Constant.

  Singleton instance for the Minguo chronology.

  type: java.time.chrono.MinguoChronology"
  MinguoChronology/INSTANCE)

(defn date-now
  "Description copied from interface: Chronology

  zone - the zone ID to use, not null - `java.time.ZoneId`

  returns: the current local date using the system clock, not null - `java.time.chrono.MinguoDate`"
  ([^java.time.chrono.MinguoChronology this ^java.time.ZoneId zone]
    (-> this (.dateNow zone)))
  ([^java.time.chrono.MinguoChronology this]
    (-> this (.dateNow))))

(defn range
  "Description copied from interface: Chronology

  field - the field to get the range for, not null - `java.time.temporal.ChronoField`

  returns: the range of valid values for the field, not null - `java.time.temporal.ValueRange`"
  ([^java.time.chrono.MinguoChronology this ^java.time.temporal.ChronoField field]
    (-> this (.range field))))

(defn local-date-time
  "Description copied from interface: Chronology

  temporal - the temporal object to convert, not null - `java.time.temporal.TemporalAccessor`

  returns: the local date-time in this chronology, not null - `java.time.chrono.ChronoLocalDateTime<java.time.chrono.MinguoDate>`"
  ([^java.time.chrono.MinguoChronology this ^java.time.temporal.TemporalAccessor temporal]
    (-> this (.localDateTime temporal))))

(defn resolve-date
  "Description copied from class: AbstractChronology

  field-values - the map of fields to values, which can be updated, not null - `java.util.Map<java.time.temporal.TemporalField,java.lang.Long>`
  resolver-style - the requested type of resolve, not null - `java.time.format.ResolverStyle`

  returns: the resolved date, null if insufficient information to create a date - `java.time.chrono.MinguoDate`"
  ([^java.time.chrono.MinguoChronology this ^java.util.Map field-values ^java.time.format.ResolverStyle resolver-style]
    (-> this (.resolveDate field-values resolver-style))))

(defn leap-year?
  "Checks if the specified year is a leap year.

   Minguo leap years occur exactly in line with ISO leap years.
   This method does not validate the year passed in, and only has a
   well-defined result for years in the supported range.

  proleptic-year - the proleptic-year to check, not validated for range - `long`

  returns: true if the year is a leap year - `boolean`"
  ([^java.time.chrono.MinguoChronology this ^Long proleptic-year]
    (-> this (.isLeapYear proleptic-year))))

(defn date-year-day
  "Obtains a local date in Minguo calendar system from the
   era, year-of-era and day-of-year fields.

  era - the Minguo era, not null - `java.time.chrono.Era`
  year-of-era - the year-of-era - `int`
  day-of-year - the day-of-year - `int`

  returns: the Minguo local date, not null - `java.time.chrono.MinguoDate`

  throws: java.time.DateTimeException - if unable to create the date"
  ([^java.time.chrono.MinguoChronology this ^java.time.chrono.Era era ^Integer year-of-era ^Integer day-of-year]
    (-> this (.dateYearDay era year-of-era day-of-year)))
  ([^java.time.chrono.MinguoChronology this ^Integer proleptic-year ^Integer day-of-year]
    (-> this (.dateYearDay proleptic-year day-of-year))))

(defn date-epoch-day
  "Obtains a local date in the Minguo calendar system from the epoch-day.

  epoch-day - the epoch day - `long`

  returns: the Minguo local date, not null - `java.time.chrono.MinguoDate`

  throws: java.time.DateTimeException - if unable to create the date"
  ([^java.time.chrono.MinguoChronology this ^Long epoch-day]
    (-> this (.dateEpochDay epoch-day))))

(defn eras
  "Description copied from interface: Chronology

  returns: the list of eras for the chronology, may be immutable, not null - `java.util.List<java.time.chrono.Era>`"
  ([^java.time.chrono.MinguoChronology this]
    (-> this (.eras))))

(defn era-of
  "Description copied from interface: Chronology

  era-value - the era value - `int`

  returns: the calendar system era, not null - `java.time.chrono.MinguoEra`"
  ([^java.time.chrono.MinguoChronology this ^Integer era-value]
    (-> this (.eraOf era-value))))

(defn proleptic-year
  "Description copied from interface: Chronology

  era - the era of the correct type for the chronology, not null - `java.time.chrono.Era`
  year-of-era - the chronology year-of-era - `int`

  returns: the proleptic-year - `int`"
  ([^java.time.chrono.MinguoChronology this ^java.time.chrono.Era era ^Integer year-of-era]
    (-> this (.prolepticYear era year-of-era))))

(defn get-calendar-type
  "Gets the calendar type of the underlying calendar system - 'roc'.

   The calendar type is an identifier defined by the
   Unicode Locale Data Markup Language (LDML) specification.
   It can be used to lookup the Chronology using Chronology.of(String).
   It can also be used as part of a locale, accessible via
   Locale.getUnicodeLocaleType(String) with the key 'ca'.

  returns: the calendar system type - 'roc' - `java.lang.String`"
  ([^java.time.chrono.MinguoChronology this]
    (-> this (.getCalendarType))))

(defn get-id
  "Gets the ID of the chronology - 'Minguo'.

   The ID uniquely identifies the Chronology.
   It can be used to lookup the Chronology using Chronology.of(String).

  returns: the chronology ID - 'Minguo' - `java.lang.String`"
  ([^java.time.chrono.MinguoChronology this]
    (-> this (.getId))))

(defn date
  "Obtains a local date in Minguo calendar system from the
   era, year-of-era, month-of-year and day-of-month fields.

  era - the Minguo era, not null - `java.time.chrono.Era`
  year-of-era - the year-of-era - `int`
  month - the month-of-year - `int`
  day-of-month - the day-of-month - `int`

  returns: the Minguo local date, not null - `java.time.chrono.MinguoDate`

  throws: java.time.DateTimeException - if unable to create the date"
  ([^java.time.chrono.MinguoChronology this ^java.time.chrono.Era era ^Integer year-of-era ^Integer month ^Integer day-of-month]
    (-> this (.date era year-of-era month day-of-month)))
  ([^java.time.chrono.MinguoChronology this ^Integer proleptic-year ^Integer month ^Integer day-of-month]
    (-> this (.date proleptic-year month day-of-month)))
  ([^java.time.chrono.MinguoChronology this ^java.time.temporal.TemporalAccessor temporal]
    (-> this (.date temporal))))

(defn zoned-date-time
  "Description copied from interface: Chronology

  instant - the instant to create the date-time from, not null - `java.time.Instant`
  zone - the time-zone, not null - `java.time.ZoneId`

  returns: the zoned date-time, not null - `java.time.chrono.ChronoZonedDateTime<java.time.chrono.MinguoDate>`"
  ([^java.time.chrono.MinguoChronology this ^java.time.Instant instant ^java.time.ZoneId zone]
    (-> this (.zonedDateTime instant zone)))
  ([^java.time.chrono.MinguoChronology this ^java.time.temporal.TemporalAccessor temporal]
    (-> this (.zonedDateTime temporal))))

