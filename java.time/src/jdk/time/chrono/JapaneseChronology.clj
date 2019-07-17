(ns jdk.time.chrono.JapaneseChronology
  "The Japanese Imperial calendar system.

  This chronology defines the rules of the Japanese Imperial calendar system.
  This calendar system is primarily used in Japan.
  The Japanese Imperial calendar system is the same as the ISO calendar system
  apart from the era-based year numbering.

  Japan introduced the Gregorian calendar starting with Meiji 6.
  Only Meiji and later eras are supported;
  dates before Meiji 6, January 1 are not supported.

  The supported ChronoField instances are:

  DAY_OF_WEEK
  DAY_OF_MONTH
  DAY_OF_YEAR
  EPOCH_DAY
  MONTH_OF_YEAR
  PROLEPTIC_MONTH
  YEAR_OF_ERA
  YEAR
  ERA"
  (:refer-clojure :only [require comment defn ->])
  (:import [java.time.chrono JapaneseChronology]))

(def *-instance
  "Static Constant.

  Singleton instance for Japanese chronology.

  type: java.time.chrono.JapaneseChronology"
  JapaneseChronology/INSTANCE)

(defn date-now
  "Description copied from interface: Chronology

  zone - the zone ID to use, not null - `java.time.ZoneId`

  returns: the current local date using the system clock, not null - `java.time.chrono.JapaneseDate`"
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

  returns: the local date-time in this chronology, not null - `java.time.chrono.ChronoLocalDateTime<java.time.chrono.JapaneseDate>`"
  ([this temporal]
    (-> this (.localDateTime temporal))))

(defn resolve-date
  "Description copied from class: AbstractChronology

  field-values - the map of fields to values, which can be updated, not null - `java.util.Map<java.time.temporal.TemporalField,java.lang.Long>`
  resolver-style - the requested type of resolve, not null - `java.time.format.ResolverStyle`

  returns: the resolved date, null if insufficient information to create a date - `java.time.chrono.JapaneseDate`"
  ([this field-values resolver-style]
    (-> this (.resolveDate field-values resolver-style))))

(defn leap-year?
  "Checks if the specified year is a leap year.

   Japanese calendar leap years occur exactly in line with ISO leap years.
   This method does not validate the year passed in, and only has a
   well-defined result for years in the supported range.

  proleptic-year - the proleptic-year to check, not validated for range - `long`

  returns: true if the year is a leap year - `boolean`"
  ([this proleptic-year]
    (-> this (.isLeapYear proleptic-year))))

(defn date-year-day
  "Obtains a local date in Japanese calendar system from the
   era, year-of-era and day-of-year fields.

   The day-of-year in this factory is expressed relative to the start of the year-of-era.
   This definition changes the normal meaning of day-of-year only in those years
   where the year-of-era is reset to one due to a change in the era.
   For example:


    6th Jan Showa 64 = day-of-year 6
    7th Jan Showa 64 = day-of-year 7
    8th Jan Heisei 1 = day-of-year 1
    9th Jan Heisei 1 = day-of-year 2

  era - the Japanese era, not null - `java.time.chrono.Era`
  year-of-era - the year-of-era - `int`
  day-of-year - the day-of-year - `int`

  returns: the Japanese local date, not null - `java.time.chrono.JapaneseDate`

  throws: java.time.DateTimeException - if unable to create the date"
  ([this era year-of-era day-of-year]
    (-> this (.dateYearDay era year-of-era day-of-year)))
  ([this proleptic-year day-of-year]
    (-> this (.dateYearDay proleptic-year day-of-year))))

(defn date-epoch-day
  "Obtains a local date in the Japanese calendar system from the epoch-day.

  epoch-day - the epoch day - `long`

  returns: the Japanese local date, not null - `java.time.chrono.JapaneseDate`

  throws: java.time.DateTimeException - if unable to create the date"
  ([this epoch-day]
    (-> this (.dateEpochDay epoch-day))))

(defn eras
  "Description copied from interface: Chronology

  returns: the list of eras for the chronology, may be immutable, not null - `java.util.List<java.time.chrono.Era>`"
  ([this]
    (-> this (.eras))))

(defn era-of
  "Returns the calendar system era object from the given numeric value.

   See the description of each Era for the numeric values of:
   JapaneseEra.HEISEI, JapaneseEra.SHOWA,JapaneseEra.TAISHO,
   JapaneseEra.MEIJI), only Meiji and later eras are supported.

  era-value - the era value - `int`

  returns: the Japanese Era for the given numeric era value - `java.time.chrono.JapaneseEra`

  throws: java.time.DateTimeException - if eraValue is invalid"
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
  "Gets the calendar type of the underlying calendar system - 'japanese'.

   The calendar type is an identifier defined by the
   Unicode Locale Data Markup Language (LDML) specification.
   It can be used to lookup the Chronology using Chronology.of(String).
   It can also be used as part of a locale, accessible via
   Locale.getUnicodeLocaleType(String) with the key 'ca'.

  returns: the calendar system type - 'japanese' - `java.lang.String`"
  ([this]
    (-> this (.getCalendarType))))

(defn get-id
  "Gets the ID of the chronology - 'Japanese'.

   The ID uniquely identifies the Chronology.
   It can be used to lookup the Chronology using Chronology.of(String).

  returns: the chronology ID - 'Japanese' - `java.lang.String`"
  ([this]
    (-> this (.getId))))

(defn date
  "Obtains a local date in Japanese calendar system from the
   era, year-of-era, month-of-year and day-of-month fields.

   The Japanese month and day-of-month are the same as those in the
   ISO calendar system. They are not reset when the era changes.
   For example:


    6th Jan Showa 64 = ISO 1989-01-06
    7th Jan Showa 64 = ISO 1989-01-07
    8th Jan Heisei 1 = ISO 1989-01-08
    9th Jan Heisei 1 = ISO 1989-01-09

  era - the Japanese era, not null - `java.time.chrono.Era`
  year-of-era - the year-of-era - `int`
  month - the month-of-year - `int`
  day-of-month - the day-of-month - `int`

  returns: the Japanese local date, not null - `java.time.chrono.JapaneseDate`

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

  returns: the zoned date-time, not null - `java.time.chrono.ChronoZonedDateTime<java.time.chrono.JapaneseDate>`"
  ([this instant zone]
    (-> this (.zonedDateTime instant zone)))
  ([this temporal]
    (-> this (.zonedDateTime temporal))))

