(ns jdk.time.chrono.HijrahChronology
  "The Hijrah calendar is a lunar calendar supporting Islamic calendars.

  The HijrahChronology follows the rules of the Hijrah calendar system. The Hijrah
  calendar has several variants based on differences in when the new moon is
  determined to have occurred and where the observation is made.
  In some variants the length of each month is
  computed algorithmically from the astronomical data for the moon and earth and
  in others the length of the month is determined by an authorized sighting
  of the new moon. For the algorithmically based calendars the calendar
  can project into the future.
  For sighting based calendars only historical data from past
  sightings is available.

  The length of each month is 29 or 30 days.
  Ordinary years have 354 days; leap years have 355 days.


  CLDR and LDML identify variants:



  Chronology ID
  Calendar Type
  Locale extension, see Locale
  Description




  Hijrah-umalqura
  islamic-umalqura
  ca-islamic-umalqura
  Islamic - Umm Al-Qura calendar of Saudi Arabia



  Additional variants may be available through Chronology.getAvailableChronologies().

  Example

  Selecting the chronology from the locale uses Chronology.ofLocale(java.util.Locale)
  to find the Chronology based on Locale supported BCP 47 extension mechanism
  to request a specific calendar (`ca`). For example,



       Locale locale = Locale.forLanguageTag(`en-US-u-ca-islamic-umalqura`);
       Chronology chrono = Chronology.ofLocale(locale);"
  (:refer-clojure :only [require comment defn ->])
  (:import [java.time.chrono HijrahChronology]))

(def *-instance
  "Static Constant.

  Singleton instance of the Islamic Umm Al-Qura calendar of Saudi Arabia.
   Other Hijrah chronology variants may be available from
   Chronology.getAvailableChronologies().

  type: java.time.chrono.HijrahChronology"
  HijrahChronology/INSTANCE)

(defn date-now
  "Description copied from interface: Chronology

  zone - the zone ID to use, not null - `java.time.ZoneId`

  returns: the current local date using the system clock, not null - `java.time.chrono.HijrahDate`"
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

  returns: the local date-time in this chronology, not null - `java.time.chrono.ChronoLocalDateTime<java.time.chrono.HijrahDate>`"
  ([this temporal]
    (-> this (.localDateTime temporal))))

(defn resolve-date
  "Description copied from class: AbstractChronology

  field-values - the map of fields to values, which can be updated, not null - `java.util.Map<java.time.temporal.TemporalField,java.lang.Long>`
  resolver-style - the requested type of resolve, not null - `java.time.format.ResolverStyle`

  returns: the resolved date, null if insufficient information to create a date - `java.time.chrono.HijrahDate`"
  ([this field-values resolver-style]
    (-> this (.resolveDate field-values resolver-style))))

(defn leap-year?
  "Description copied from interface: Chronology

  proleptic-year - the proleptic-year to check, not validated for range - `long`

  returns: true if the year is a leap year - `boolean`"
  ([this proleptic-year]
    (-> this (.isLeapYear proleptic-year))))

(defn date-year-day
  "Obtains a local date in Hijrah calendar system from the
   era, year-of-era and day-of-year fields.

  era - the Hijrah era, not null - `java.time.chrono.Era`
  year-of-era - the year-of-era - `int`
  day-of-year - the day-of-year - `int`

  returns: the Hijrah local date, not null - `java.time.chrono.HijrahDate`

  throws: java.time.DateTimeException - if unable to create the date"
  ([this era year-of-era day-of-year]
    (-> this (.dateYearDay era year-of-era day-of-year)))
  ([this proleptic-year day-of-year]
    (-> this (.dateYearDay proleptic-year day-of-year))))

(defn date-epoch-day
  "Obtains a local date in the Hijrah calendar system from the epoch-day.

  epoch-day - the epoch day - `long`

  returns: the Hijrah local date, not null - `java.time.chrono.HijrahDate`

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

  returns: the calendar system era, not null - `java.time.chrono.HijrahEra`"
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
  "Gets the calendar type of the Islamic calendar.

   The calendar type is an identifier defined by the
   Unicode Locale Data Markup Language (LDML) specification.
   It can be used to lookup the Chronology using Chronology.of(String).

  returns: the calendar system type; non-null if the calendar has
      a standard type, otherwise null - `java.lang.String`"
  ([this]
    (-> this (.getCalendarType))))

(defn get-id
  "Gets the ID of the chronology.

   The ID uniquely identifies the Chronology. It can be used to
   lookup the Chronology using Chronology.of(String).

  returns: the chronology ID, non-null - `java.lang.String`"
  ([this]
    (-> this (.getId))))

(defn date
  "Obtains a local date in Hijrah calendar system from the
   era, year-of-era, month-of-year and day-of-month fields.

  era - the Hijrah era, not null - `java.time.chrono.Era`
  year-of-era - the year-of-era - `int`
  month - the month-of-year - `int`
  day-of-month - the day-of-month - `int`

  returns: the Hijrah local date, not null - `java.time.chrono.HijrahDate`

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

  returns: the zoned date-time, not null - `java.time.chrono.ChronoZonedDateTime<java.time.chrono.HijrahDate>`"
  ([this instant zone]
    (-> this (.zonedDateTime instant zone)))
  ([this temporal]
    (-> this (.zonedDateTime temporal))))

