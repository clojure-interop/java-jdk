(ns jdk.time.chrono.IsoChronology
  "The ISO calendar system.

  This chronology defines the rules of the ISO calendar system.
  This calendar system is based on the ISO-8601 standard, which is the
  de facto world calendar.

  The fields are defined as follows:

  era - There are two eras, 'Current Era' (CE) and 'Before Current Era' (BCE).
  year-of-era - The year-of-era is the same as the proleptic-year for the current CE era.
   For the BCE era before the ISO epoch the year increases from 1 upwards as time goes backwards.
  proleptic-year - The proleptic year is the same as the year-of-era for the
   current era. For the previous era, years have zero, then negative values.
  month-of-year - There are 12 months in an ISO year, numbered from 1 to 12.
  day-of-month - There are between 28 and 31 days in each of the ISO month, numbered from 1 to 31.
   Months 4, 6, 9 and 11 have 30 days, Months 1, 3, 5, 7, 8, 10 and 12 have 31 days.
   Month 2 has 28 days, or 29 in a leap year.
  day-of-year - There are 365 days in a standard ISO year and 366 in a leap year.
   The days are numbered from 1 to 365 or 1 to 366.
  leap-year - Leap years occur every 4 years, except where the year is divisble by 100 and not divisble by 400."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.time.chrono IsoChronology]))

(def *-instance
  "Static Constant.

  Singleton instance of the ISO chronology.

  type: java.time.chrono.IsoChronology"
  IsoChronology/INSTANCE)

(defn date-now
  "Obtains the current ISO local date from the system clock in the specified time-zone.

   This will query the system clock to obtain the current date.
   Specifying the time-zone avoids dependence on the default time-zone.

   Using this method will prevent the ability to use an alternate clock for testing
   because the clock is hard-coded.

  zone - the zone ID to use, not null - `java.time.ZoneId`

  returns: the current ISO local date using the system clock, not null - `java.time.LocalDate`

  throws: java.time.DateTimeException - if unable to create the date"
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
  "Obtains an ISO local date-time from another date-time object.

   This is equivalent to LocalDateTime.from(TemporalAccessor).

  temporal - the date-time object to convert, not null - `java.time.temporal.TemporalAccessor`

  returns: the ISO local date-time, not null - `java.time.LocalDateTime`

  throws: java.time.DateTimeException - if unable to create the date-time"
  ([this temporal]
    (-> this (.localDateTime temporal))))

(defn resolve-date
  "Resolves parsed ChronoField values into a date during parsing.

   Most TemporalField implementations are resolved using the
   resolve method on the field. By contrast, the ChronoField class
   defines fields that only have meaning relative to the chronology.
   As such, ChronoField date fields are resolved here in the
   context of a specific chronology.

   ChronoField instances on the ISO calendar system are resolved
   as follows.

   EPOCH_DAY - If present, this is converted to a LocalDate
    and all other date fields are then cross-checked against the date.
   PROLEPTIC_MONTH - If present, then it is split into the
    YEAR and MONTH_OF_YEAR. If the mode is strict or smart
    then the field is validated.
   YEAR_OF_ERA and ERA - If both are present, then they
    are combined to form a YEAR. In lenient mode, the YEAR_OF_ERA
    range is not validated, in smart and strict mode it is. The ERA is
    validated for range in all three modes. If only the YEAR_OF_ERA is
    present, and the mode is smart or lenient, then the current era (CE/AD)
    is assumed. In strict mode, no era is assumed and the YEAR_OF_ERA is
    left untouched. If only the ERA is present, then it is left untouched.
   YEAR, MONTH_OF_YEAR and DAY_OF_MONTH -
    If all three are present, then they are combined to form a LocalDate.
    In all three modes, the YEAR is validated. If the mode is smart or strict,
    then the month and day are validated, with the day validated from 1 to 31.
    If the mode is lenient, then the date is combined in a manner equivalent to
    creating a date on the first of January in the requested year, then adding
    the difference in months, then the difference in days.
    If the mode is smart, and the day-of-month is greater than the maximum for
    the year-month, then the day-of-month is adjusted to the last day-of-month.
    If the mode is strict, then the three fields must form a valid date.
   YEAR and DAY_OF_YEAR -
    If both are present, then they are combined to form a LocalDate.
    In all three modes, the YEAR is validated.
    If the mode is lenient, then the date is combined in a manner equivalent to
    creating a date on the first of January in the requested year, then adding
    the difference in days.
    If the mode is smart or strict, then the two fields must form a valid date.
   YEAR, MONTH_OF_YEAR, ALIGNED_WEEK_OF_MONTH and
    ALIGNED_DAY_OF_WEEK_IN_MONTH -
    If all four are present, then they are combined to form a LocalDate.
    In all three modes, the YEAR is validated.
    If the mode is lenient, then the date is combined in a manner equivalent to
    creating a date on the first of January in the requested year, then adding
    the difference in months, then the difference in weeks, then in days.
    If the mode is smart or strict, then the all four fields are validated to
    their outer ranges. The date is then combined in a manner equivalent to
    creating a date on the first day of the requested year and month, then adding
    the amount in weeks and days to reach their values. If the mode is strict,
    the date is additionally validated to check that the day and week adjustment
    did not change the month.
   YEAR, MONTH_OF_YEAR, ALIGNED_WEEK_OF_MONTH and
    DAY_OF_WEEK - If all four are present, then they are combined to
    form a LocalDate. The approach is the same as described above for
    years, months and weeks in ALIGNED_DAY_OF_WEEK_IN_MONTH.
    The day-of-week is adjusted as the next or same matching day-of-week once
    the years, months and weeks have been handled.
   YEAR, ALIGNED_WEEK_OF_YEAR and ALIGNED_DAY_OF_WEEK_IN_YEAR -
    If all three are present, then they are combined to form a LocalDate.
    In all three modes, the YEAR is validated.
    If the mode is lenient, then the date is combined in a manner equivalent to
    creating a date on the first of January in the requested year, then adding
    the difference in weeks, then in days.
    If the mode is smart or strict, then the all three fields are validated to
    their outer ranges. The date is then combined in a manner equivalent to
    creating a date on the first day of the requested year, then adding
    the amount in weeks and days to reach their values. If the mode is strict,
    the date is additionally validated to check that the day and week adjustment
    did not change the year.
   YEAR, ALIGNED_WEEK_OF_YEAR and DAY_OF_WEEK -
    If all three are present, then they are combined to form a LocalDate.
    The approach is the same as described above for years and weeks in
    ALIGNED_DAY_OF_WEEK_IN_YEAR. The day-of-week is adjusted as the
    next or same matching day-of-week once the years and weeks have been handled.

  field-values - the map of fields to values, which can be updated, not null - `java.util.Map<java.time.temporal.TemporalField,java.lang.Long>`
  resolver-style - the requested type of resolve, not null - `java.time.format.ResolverStyle`

  returns: the resolved date, null if insufficient information to create a date - `java.time.LocalDate`

  throws: java.time.DateTimeException - if the date cannot be resolved, typically because of a conflict in the input data"
  ([this field-values resolver-style]
    (-> this (.resolveDate field-values resolver-style))))

(defn leap-year?
  "Checks if the year is a leap year, according to the ISO proleptic
   calendar system rules.

   This method applies the current rules for leap years across the whole time-line.
   In general, a year is a leap year if it is divisible by four without
   remainder. However, years divisible by 100, are not leap years, with
   the exception of years divisible by 400 which are.

   For example, 1904 is a leap year it is divisible by 4.
   1900 was not a leap year as it is divisible by 100, however 2000 was a
   leap year as it is divisible by 400.

   The calculation is proleptic - applying the same rules into the far future and far past.
   This is historically inaccurate, but is correct for the ISO-8601 standard.

  proleptic-year - the ISO proleptic year to check - `long`

  returns: true if the year is leap, false otherwise - `boolean`"
  ([this proleptic-year]
    (-> this (.isLeapYear proleptic-year))))

(defn date-year-day
  "Obtains an ISO local date from the era, year-of-era and day-of-year fields.

  era - the ISO era, not null - `java.time.chrono.Era`
  year-of-era - the ISO year-of-era - `int`
  day-of-year - the ISO day-of-year - `int`

  returns: the ISO local date, not null - `java.time.LocalDate`

  throws: java.time.DateTimeException - if unable to create the date"
  ([this era year-of-era day-of-year]
    (-> this (.dateYearDay era year-of-era day-of-year)))
  ([this proleptic-year day-of-year]
    (-> this (.dateYearDay proleptic-year day-of-year))))

(defn date-epoch-day
  "Obtains an ISO local date from the epoch-day.

   This is equivalent to LocalDate.ofEpochDay(long).

  epoch-day - the epoch day - `long`

  returns: the ISO local date, not null - `java.time.LocalDate`

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

  returns: the calendar system era, not null - `java.time.chrono.IsoEra`"
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
  "Gets the calendar type of the underlying calendar system - 'iso8601'.

   The calendar type is an identifier defined by the
   Unicode Locale Data Markup Language (LDML) specification.
   It can be used to lookup the Chronology using Chronology.of(String).
   It can also be used as part of a locale, accessible via
   Locale.getUnicodeLocaleType(String) with the key 'ca'.

  returns: the calendar system type - 'iso8601' - `java.lang.String`"
  ([this]
    (-> this (.getCalendarType))))

(defn get-id
  "Gets the ID of the chronology - 'ISO'.

   The ID uniquely identifies the Chronology.
   It can be used to lookup the Chronology using Chronology.of(String).

  returns: the chronology ID - 'ISO' - `java.lang.String`"
  ([this]
    (-> this (.getId))))

(defn date
  "Obtains an ISO local date from the era, year-of-era, month-of-year
   and day-of-month fields.

  era - the ISO era, not null - `java.time.chrono.Era`
  year-of-era - the ISO year-of-era - `int`
  month - the ISO month-of-year - `int`
  day-of-month - the ISO day-of-month - `int`

  returns: the ISO local date, not null - `java.time.LocalDate`

  throws: java.time.DateTimeException - if unable to create the date"
  ([this era year-of-era month day-of-month]
    (-> this (.date era year-of-era month day-of-month)))
  ([this proleptic-year month day-of-month]
    (-> this (.date proleptic-year month day-of-month)))
  ([this temporal]
    (-> this (.date temporal))))

(defn period
  "Obtains a period for this chronology based on years, months and days.

   This returns a period tied to the ISO chronology using the specified
   years, months and days. See Period for further details.

  years - the number of years, may be negative - `int`
  months - the number of years, may be negative - `int`
  days - the number of years, may be negative - `int`

  returns: the period in terms of this chronology, not null - `java.time.Period`"
  ([this years months days]
    (-> this (.period years months days))))

(defn zoned-date-time
  "Obtains an ISO zoned date-time in this chronology from an Instant.

   This is equivalent to ZonedDateTime.ofInstant(Instant, ZoneId).

  instant - the instant to create the date-time from, not null - `java.time.Instant`
  zone - the time-zone, not null - `java.time.ZoneId`

  returns: the zoned date-time, not null - `java.time.ZonedDateTime`

  throws: java.time.DateTimeException - if the result exceeds the supported range"
  ([this instant zone]
    (-> this (.zonedDateTime instant zone)))
  ([this temporal]
    (-> this (.zonedDateTime temporal))))

