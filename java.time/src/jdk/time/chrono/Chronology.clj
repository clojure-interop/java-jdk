(ns jdk.time.chrono.Chronology
  "A calendar system, used to organize and identify dates.

  The main date and time API is built on the ISO calendar system.
  The chronology operates behind the scenes to represent the general concept of a calendar system.
  For example, the Japanese, Minguo, Thai Buddhist and others.

  Most other calendar systems also operate on the shared concepts of year, month and day,
  linked to the cycles of the Earth around the Sun, and the Moon around the Earth.
  These shared concepts are defined by ChronoField and are available
  for use by any Chronology implementation:


    LocalDate isoDate = ...
    ThaiBuddhistDate thaiDate = ...
    int isoYear = isoDate.get(ChronoField.YEAR);
    int thaiYear = thaiDate.get(ChronoField.YEAR);
  As shown, although the date objects are in different calendar systems, represented by different
  Chronology instances, both can be queried using the same constant on ChronoField.
  For a full discussion of the implications of this, see ChronoLocalDate.
  In general, the advice is to use the known ISO-based LocalDate, rather than
  ChronoLocalDate.

  While a Chronology object typically uses ChronoField and is based on
  an era, year-of-era, month-of-year, day-of-month model of a date, this is not required.
  A Chronology instance may represent a totally different kind of calendar system,
  such as the Mayan.

  In practical terms, the Chronology instance also acts as a factory.
  The of(String) method allows an instance to be looked up by identifier,
  while the ofLocale(Locale) method allows lookup by locale.

  The Chronology instance provides a set of methods to create ChronoLocalDate instances.
  The date classes are used to manipulate specific dates.

   dateNow()
   dateNow(clock)
   dateNow(zone)
   date(yearProleptic, month, day)
   date(era, yearOfEra, month, day)
   dateYearDay(yearProleptic, dayOfYear)
   dateYearDay(era, yearOfEra, dayOfYear)
   date(TemporalAccessor)


  Adding New Calendars
  The set of available chronologies can be extended by applications.
  Adding a new calendar system requires the writing of an implementation of
  Chronology, ChronoLocalDate and Era.
  The majority of the logic specific to the calendar system will be in the
  ChronoLocalDate implementation.
  The Chronology implementation acts as a factory.

  To permit the discovery of additional chronologies, the ServiceLoader
  is used. A file must be added to the META-INF/services directory with the
  name 'java.time.chrono.Chronology' listing the implementation classes.
  See the ServiceLoader for more details on service loading.
  For lookup by id or calendarType, the system provided calendars are found
  first followed by application provided calendars.

  Each chronology must define a chronology ID that is unique within the system.
  If the chronology represents a calendar system defined by the
  CLDR specification then the calendar type is the concatenation of the
  CLDR type and, if applicable, the CLDR variant,"
  (:refer-clojure :only [require comment defn ->])
  (:import [java.time.chrono Chronology]))

(defn date-now
  "Obtains the current local date in this chronology from the system clock in the specified time-zone.

   This will query the system clock to obtain the current date.
   Specifying the time-zone avoids dependence on the default time-zone.

   Using this method will prevent the ability to use an alternate clock for testing
   because the clock is hard-coded.

  zone - the zone ID to use, not null - `java.time.ZoneId`

  returns: the current local date using the system clock, not null - `default java.time.chrono.ChronoLocalDate`

  throws: java.time.DateTimeException - if unable to create the date"
  ([^java.time.chrono.Chronology this ^java.time.ZoneId zone]
    (-> this (.dateNow zone)))
  ([^java.time.chrono.Chronology this]
    (-> this (.dateNow))))

(defn range
  "Gets the range of valid values for the specified field.

   All fields can be expressed as a long integer.
   This method returns an object that describes the valid range for that value.

   Note that the result only describes the minimum and maximum valid values
   and it is important not to read too much into them. For example, there
   could be values within the range that are invalid for the field.

   This method will return a result whether or not the chronology supports the field.

  field - the field to get the range for, not null - `java.time.temporal.ChronoField`

  returns: the range of valid values for the field, not null - `java.time.temporal.ValueRange`

  throws: java.time.DateTimeException - if the range for the field cannot be obtained"
  (^java.time.temporal.ValueRange [^java.time.chrono.Chronology this ^java.time.temporal.ChronoField field]
    (-> this (.range field))))

(defn *of-locale
  "Obtains an instance of Chronology from a locale.

   This returns a Chronology based on the specified locale,
   typically returning IsoChronology. Other calendar systems
   are only returned if they are explicitly selected within the locale.

   The Locale class provide access to a range of information useful
   for localizing an application. This includes the language and region,
   such as `en-GB` for English as used in Great Britain.

   The Locale class also supports an extension mechanism that
   can be used to identify a calendar system. The mechanism is a form
   of key-value pairs, where the calendar system has the key `ca`.
   For example, the locale `en-JP-u-ca-japanese` represents the English
   language as used in Japan with the Japanese calendar system.

   This method finds the desired calendar system by in a manner equivalent
   to passing `ca` to Locale.getUnicodeLocaleType(String).
   If the `ca` key is not present, then IsoChronology is returned.

   Note that the behavior of this method differs from the older
   Calendar.getInstance(Locale) method.
   If that method receives a locale of `th_TH` it will return BuddhistCalendar.
   By contrast, this method will return IsoChronology.
   Passing the locale `th-TH-u-ca-buddhist` into either method will
   result in the Thai Buddhist calendar system and is therefore the
   recommended approach going forward for Thai calendar system localization.

   A similar, but simpler, situation occurs for the Japanese calendar system.
   The locale `jp_JP_JP` has previously been used to access the calendar.
   However, unlike the Thai locale, `ja_JP_JP` is automatically converted by
   Locale to the modern and recommended form of `ja-JP-u-ca-japanese`.
   Thus, there is no difference in behavior between this method and
   Calendar#getInstance(Locale).

  locale - the locale to use to obtain the calendar system, not null - `java.util.Locale`

  returns: the calendar system associated with the locale, not null - `java.time.chrono.Chronology`

  throws: java.time.DateTimeException - if the locale-specified calendar cannot be found"
  (^java.time.chrono.Chronology [^java.util.Locale locale]
    (Chronology/ofLocale locale)))

(defn local-date-time
  "Obtains a local date-time in this chronology from another temporal object.

   This obtains a date-time in this chronology based on the specified temporal.
   A TemporalAccessor represents an arbitrary set of date and time information,
   which this factory converts to an instance of ChronoLocalDateTime.

   The conversion extracts and combines the ChronoLocalDate and the
   LocalTime from the temporal object.
   Implementations are permitted to perform optimizations such as accessing
   those fields that are equivalent to the relevant objects.
   The result uses this chronology.

   This method matches the signature of the functional interface TemporalQuery
   allowing it to be used as a query via method reference, aChronology::localDateTime.

  temporal - the temporal object to convert, not null - `java.time.temporal.TemporalAccessor`

  returns: the local date-time in this chronology, not null - `default java.time.chrono.ChronoLocalDateTime<? extends java.time.chrono.ChronoLocalDate>`

  throws: java.time.DateTimeException - if unable to create the date-time"
  ([^java.time.chrono.Chronology this ^java.time.temporal.TemporalAccessor temporal]
    (-> this (.localDateTime temporal))))

(defn *of
  "Obtains an instance of Chronology from a chronology ID or
   calendar system type.

   This returns a chronology based on either the ID or the type.
   The chronology ID uniquely identifies the chronology.
   The calendar system type is defined by the
   CLDR specification.

   The chronology may be a system chronology or a chronology
   provided by the application via ServiceLoader configuration.

   Since some calendars can be customized, the ID or type typically refers
   to the default customization. For example, the Gregorian calendar can have multiple
   cutover dates from the Julian, but the lookup only provides the default cutover date.

  id - the chronology ID or calendar system type, not null - `java.lang.String`

  returns: the chronology with the identifier requested, not null - `java.time.chrono.Chronology`

  throws: java.time.DateTimeException - if the chronology cannot be found"
  (^java.time.chrono.Chronology [^java.lang.String id]
    (Chronology/of id)))

(defn resolve-date
  "Resolves parsed ChronoField values into a date during parsing.

   Most TemporalField implementations are resolved using the
   resolve method on the field. By contrast, the ChronoField class
   defines fields that only have meaning relative to the chronology.
   As such, ChronoField date fields are resolved here in the
   context of a specific chronology.

   The default implementation, which explains typical resolve behaviour,
   is provided in AbstractChronology.

  field-values - the map of fields to values, which can be updated, not null - `java.util.Map<java.time.temporal.TemporalField,java.lang.Long>`
  resolver-style - the requested type of resolve, not null - `java.time.format.ResolverStyle`

  returns: the resolved date, null if insufficient information to create a date - `java.time.chrono.ChronoLocalDate`

  throws: java.time.DateTimeException - if the date cannot be resolved, typically because of a conflict in the input data"
  (^java.time.chrono.ChronoLocalDate [^java.time.chrono.Chronology this ^java.util.Map field-values ^java.time.format.ResolverStyle resolver-style]
    (-> this (.resolveDate field-values resolver-style))))

(defn leap-year?
  "Checks if the specified year is a leap year.

   A leap-year is a year of a longer length than normal.
   The exact meaning is determined by the chronology according to the following constraints.

   a leap-year must imply a year-length longer than a non leap-year.
   a chronology that does not support the concept of a year must return false.

  proleptic-year - the proleptic-year to check, not validated for range - `long`

  returns: true if the year is a leap year - `boolean`"
  (^Boolean [^java.time.chrono.Chronology this ^Long proleptic-year]
    (-> this (.isLeapYear proleptic-year))))

(defn date-year-day
  "Obtains a local date in this chronology from the era, year-of-era and
   day-of-year fields.

  era - the era of the correct type for the chronology, not null - `java.time.chrono.Era`
  year-of-era - the chronology year-of-era - `int`
  day-of-year - the chronology day-of-year - `int`

  returns: the local date in this chronology, not null - `default java.time.chrono.ChronoLocalDate`

  throws: java.time.DateTimeException - if unable to create the date"
  ([^java.time.chrono.Chronology this ^java.time.chrono.Era era ^Integer year-of-era ^Integer day-of-year]
    (-> this (.dateYearDay era year-of-era day-of-year)))
  (^java.time.chrono.ChronoLocalDate [^java.time.chrono.Chronology this ^Integer proleptic-year ^Integer day-of-year]
    (-> this (.dateYearDay proleptic-year day-of-year))))

(defn to-string
  "Outputs this chronology as a String.

   The format should include the entire state of the object.

  returns: a string representation of this chronology, not null - `java.lang.String`"
  (^java.lang.String [^java.time.chrono.Chronology this]
    (-> this (.toString))))

(defn date-epoch-day
  "Obtains a local date in this chronology from the epoch-day.

   The definition of EPOCH_DAY is the same
   for all calendar systems, thus it can be used for conversion.

  epoch-day - the epoch day - `long`

  returns: the local date in this chronology, not null - `java.time.chrono.ChronoLocalDate`

  throws: java.time.DateTimeException - if unable to create the date"
  (^java.time.chrono.ChronoLocalDate [^java.time.chrono.Chronology this ^Long epoch-day]
    (-> this (.dateEpochDay epoch-day))))

(defn get-display-name
  "Gets the textual representation of this chronology.

   This returns the textual name used to identify the chronology,
   suitable for presentation to the user.
   The parameters control the style of the returned text and the locale.

  style - the style of the text required, not null - `java.time.format.TextStyle`
  locale - the locale to use, not null - `java.util.Locale`

  returns: the text value of the chronology, not null - `default java.lang.String`"
  ([^java.time.chrono.Chronology this ^java.time.format.TextStyle style ^java.util.Locale locale]
    (-> this (.getDisplayName style locale))))

(defn eras
  "Gets the list of eras for the chronology.

   Most calendar systems have an era, within which the year has meaning.
   If the calendar system does not support the concept of eras, an empty
   list must be returned.

  returns: the list of eras for the chronology, may be immutable, not null - `java.util.List<java.time.chrono.Era>`"
  (^java.util.List [^java.time.chrono.Chronology this]
    (-> this (.eras))))

(defn era-of
  "Creates the chronology era object from the numeric value.

   The era is, conceptually, the largest division of the time-line.
   Most calendar systems have a single epoch dividing the time-line into two eras.
   However, some have multiple eras, such as one for the reign of each leader.
   The exact meaning is determined by the chronology according to the following constraints.

   The era in use at 1970-01-01 must have the value 1.
   Later eras must have sequentially higher values.
   Earlier eras must have sequentially lower values.
   Each chronology must refer to an enum or similar singleton to provide the era values.

   This method returns the singleton era of the correct type for the specified era value.

  era-value - the era value - `int`

  returns: the calendar system era, not null - `java.time.chrono.Era`

  throws: java.time.DateTimeException - if unable to create the era"
  (^java.time.chrono.Era [^java.time.chrono.Chronology this ^Integer era-value]
    (-> this (.eraOf era-value))))

(defn proleptic-year
  "Calculates the proleptic-year given the era and year-of-era.

   This combines the era and year-of-era into the single proleptic-year field.

   If the chronology makes active use of eras, such as JapaneseChronology
   then the year-of-era will be validated against the era.
   For other chronologies, validation is optional.

  era - the era of the correct type for the chronology, not null - `java.time.chrono.Era`
  year-of-era - the chronology year-of-era - `int`

  returns: the proleptic-year - `int`

  throws: java.time.DateTimeException - if unable to convert to a proleptic-year, such as if the year is invalid for the era"
  (^Integer [^java.time.chrono.Chronology this ^java.time.chrono.Era era ^Integer year-of-era]
    (-> this (.prolepticYear era year-of-era))))

(defn get-calendar-type
  "Gets the calendar type of the calendar system.

   The calendar type is an identifier defined by the CLDR and
   Unicode Locale Data Markup Language (LDML) specifications
   to uniquely identification a calendar.
   The getCalendarType is the concatenation of the CLDR calendar type
   and the variant, if applicable, is appended separated by `-`.
   The calendar type is used to lookup the Chronology using of(String).

  returns: the calendar system type, null if the calendar is not defined by CLDR/LDML - `java.lang.String`"
  (^java.lang.String [^java.time.chrono.Chronology this]
    (-> this (.getCalendarType))))

(defn get-id
  "Gets the ID of the chronology.

   The ID uniquely identifies the Chronology.
   It can be used to lookup the Chronology using of(String).

  returns: the chronology ID, not null - `java.lang.String`"
  (^java.lang.String [^java.time.chrono.Chronology this]
    (-> this (.getId))))

(defn *get-available-chronologies
  "Returns the available chronologies.

   Each returned Chronology is available for use in the system.
   The set of chronologies includes the system chronologies and
   any chronologies provided by the application via ServiceLoader
   configuration.

  returns: the independent, modifiable set of the available chronology IDs, not null - `java.util.Set<java.time.chrono.Chronology>`"
  (^java.util.Set []
    (Chronology/getAvailableChronologies )))

(defn *from
  "Obtains an instance of Chronology from a temporal object.

   This obtains a chronology based on the specified temporal.
   A TemporalAccessor represents an arbitrary set of date and time information,
   which this factory converts to an instance of Chronology.

   The conversion will obtain the chronology using TemporalQueries.chronology().
   If the specified temporal object does not have a chronology, IsoChronology is returned.

   This method matches the signature of the functional interface TemporalQuery
   allowing it to be used as a query via method reference, Chronology::from.

  temporal - the temporal to convert, not null - `java.time.temporal.TemporalAccessor`

  returns: the chronology, not null - `java.time.chrono.Chronology`

  throws: java.time.DateTimeException - if unable to convert to an Chronology"
  (^java.time.chrono.Chronology [^java.time.temporal.TemporalAccessor temporal]
    (Chronology/from temporal)))

(defn date
  "Obtains a local date in this chronology from the era, year-of-era,
   month-of-year and day-of-month fields.

  era - the era of the correct type for the chronology, not null - `java.time.chrono.Era`
  year-of-era - the chronology year-of-era - `int`
  month - the chronology month-of-year - `int`
  day-of-month - the chronology day-of-month - `int`

  returns: the local date in this chronology, not null - `default java.time.chrono.ChronoLocalDate`

  throws: java.time.DateTimeException - if unable to create the date"
  ([^java.time.chrono.Chronology this ^java.time.chrono.Era era ^Integer year-of-era ^Integer month ^Integer day-of-month]
    (-> this (.date era year-of-era month day-of-month)))
  (^java.time.chrono.ChronoLocalDate [^java.time.chrono.Chronology this ^Integer proleptic-year ^Integer month ^Integer day-of-month]
    (-> this (.date proleptic-year month day-of-month)))
  (^java.time.chrono.ChronoLocalDate [^java.time.chrono.Chronology this ^java.time.temporal.TemporalAccessor temporal]
    (-> this (.date temporal))))

(defn hash-code
  "A hash code for this chronology.

   The hash code should be based on the entire state of the object.

  returns: a suitable hash code - `int`"
  (^Integer [^java.time.chrono.Chronology this]
    (-> this (.hashCode))))

(defn period
  "Obtains a period for this chronology based on years, months and days.

   This returns a period tied to this chronology using the specified
   years, months and days.  All supplied chronologies use periods
   based on years, months and days, however the ChronoPeriod API
   allows the period to be represented using other units.

  years - the number of years, may be negative - `int`
  months - the number of years, may be negative - `int`
  days - the number of years, may be negative - `int`

  returns: the period in terms of this chronology, not null - `default java.time.chrono.ChronoPeriod`"
  ([^java.time.chrono.Chronology this ^Integer years ^Integer months ^Integer days]
    (-> this (.period years months days))))

(defn compare-to
  "Compares this chronology to another chronology.

   The comparison order first by the chronology ID string, then by any
   additional information specific to the subclass.
   It is `consistent with equals`, as defined by Comparable.

  other - the other chronology to compare to, not null - `java.time.chrono.Chronology`

  returns: the comparator value, negative if less, positive if greater - `int`"
  (^Integer [^java.time.chrono.Chronology this ^java.time.chrono.Chronology other]
    (-> this (.compareTo other))))

(defn equals
  "Checks if this chronology is equal to another chronology.

   The comparison is based on the entire state of the object.

  obj - the object to check, null returns false - `java.lang.Object`

  returns: true if this is equal to the other chronology - `boolean`"
  (^Boolean [^java.time.chrono.Chronology this ^java.lang.Object obj]
    (-> this (.equals obj))))

(defn zoned-date-time
  "Obtains a ChronoZonedDateTime in this chronology from an Instant.

   This obtains a zoned date-time with the same instant as that specified.

  instant - the instant to create the date-time from, not null - `java.time.Instant`
  zone - the time-zone, not null - `java.time.ZoneId`

  returns: the zoned date-time, not null - `default java.time.chrono.ChronoZonedDateTime<? extends java.time.chrono.ChronoLocalDate>`

  throws: java.time.DateTimeException - if the result exceeds the supported range"
  ([^java.time.chrono.Chronology this ^java.time.Instant instant ^java.time.ZoneId zone]
    (-> this (.zonedDateTime instant zone)))
  ([^java.time.chrono.Chronology this ^java.time.temporal.TemporalAccessor temporal]
    (-> this (.zonedDateTime temporal))))

