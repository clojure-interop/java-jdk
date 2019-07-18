(ns jdk.time.LocalDate
  "A date without a time-zone in the ISO-8601 calendar system,
  such as 2007-12-03.

  LocalDate is an immutable date-time object that represents a date,
  often viewed as year-month-day. Other date fields, such as day-of-year,
  day-of-week and week-of-year, can also be accessed.
  For example, the value `2nd October 2007` can be stored in a LocalDate.

  This class does not store or represent a time or time-zone.
  Instead, it is a description of the date, as used for birthdays.
  It cannot represent an instant on the time-line without additional information
  such as an offset or time-zone.

  The ISO-8601 calendar system is the modern civil calendar system used today
  in most of the world. It is equivalent to the proleptic Gregorian calendar
  system, in which today's rules for leap years are applied for all time.
  For most applications written today, the ISO-8601 rules are entirely suitable.
  However, any application that makes use of historical dates, and requires them
  to be accurate will find the ISO-8601 approach unsuitable.


  This is a value-based
  class; use of identity-sensitive operations (including reference equality
  (==), identity hash code, or synchronization) on instances of
  LocalDate may have unpredictable results and should be avoided.
  The equals method should be used for comparisons."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.time LocalDate]))

(def *-min
  "Static Constant.

  The minimum supported LocalDate, '-999999999-01-01'.
   This could be used by an application as a `far past` date.

  type: java.time.LocalDate"
  LocalDate/MIN)

(def *-max
  "Static Constant.

  The maximum supported LocalDate, '+999999999-12-31'.
   This could be used by an application as a `far future` date.

  type: java.time.LocalDate"
  LocalDate/MAX)

(defn *now
  "Obtains the current date from the system clock in the specified time-zone.

   This will query the system clock to obtain the current date.
   Specifying the time-zone avoids dependence on the default time-zone.

   Using this method will prevent the ability to use an alternate clock for testing
   because the clock is hard-coded.

  zone - the zone ID to use, not null - `java.time.ZoneId`

  returns: the current date using the system clock, not null - `java.time.LocalDate`"
  (^java.time.LocalDate [^java.time.ZoneId zone]
    (LocalDate/now zone))
  (^java.time.LocalDate []
    (LocalDate/now )))

(defn *of
  "Obtains an instance of LocalDate from a year, month and day.

   This returns a LocalDate with the specified year, month and day-of-month.
   The day must be valid for the year and month, otherwise an exception will be thrown.

  year - the year to represent, from MIN_YEAR to MAX_YEAR - `int`
  month - the month-of-year to represent, not null - `java.time.Month`
  day-of-month - the day-of-month to represent, from 1 to 31 - `int`

  returns: the local date, not null - `java.time.LocalDate`

  throws: java.time.DateTimeException - if the value of any field is out of range, or if the day-of-month is invalid for the month-year"
  (^java.time.LocalDate [^Integer year ^java.time.Month month ^Integer day-of-month]
    (LocalDate/of year month day-of-month)))

(defn *of-year-day
  "Obtains an instance of LocalDate from a year and day-of-year.

   This returns a LocalDate with the specified year and day-of-year.
   The day-of-year must be valid for the year, otherwise an exception will be thrown.

  year - the year to represent, from MIN_YEAR to MAX_YEAR - `int`
  day-of-year - the day-of-year to represent, from 1 to 366 - `int`

  returns: the local date, not null - `java.time.LocalDate`

  throws: java.time.DateTimeException - if the value of any field is out of range, or if the day-of-year is invalid for the year"
  (^java.time.LocalDate [^Integer year ^Integer day-of-year]
    (LocalDate/ofYearDay year day-of-year)))

(defn *of-epoch-day
  "Obtains an instance of LocalDate from the epoch day count.

   This returns a LocalDate with the specified epoch-day.
   The EPOCH_DAY is a simple incrementing count
   of days where day 0 is 1970-01-01. Negative numbers represent earlier days.

  epoch-day - the Epoch Day to convert, based on the epoch 1970-01-01 - `long`

  returns: the local date, not null - `java.time.LocalDate`

  throws: java.time.DateTimeException - if the epoch day exceeds the supported date range"
  (^java.time.LocalDate [^Long epoch-day]
    (LocalDate/ofEpochDay epoch-day)))

(defn *from
  "Obtains an instance of LocalDate from a temporal object.

   This obtains a local date based on the specified temporal.
   A TemporalAccessor represents an arbitrary set of date and time information,
   which this factory converts to an instance of LocalDate.

   The conversion uses the TemporalQueries.localDate() query, which relies
   on extracting the EPOCH_DAY field.

   This method matches the signature of the functional interface TemporalQuery
   allowing it to be used as a query via method reference, LocalDate::from.

  temporal - the temporal object to convert, not null - `java.time.temporal.TemporalAccessor`

  returns: the local date, not null - `java.time.LocalDate`

  throws: java.time.DateTimeException - if unable to convert to a LocalDate"
  (^java.time.LocalDate [^java.time.temporal.TemporalAccessor temporal]
    (LocalDate/from temporal)))

(defn *parse
  "Obtains an instance of LocalDate from a text string using a specific formatter.

   The text is parsed using the formatter, returning a date.

  text - the text to parse, not null - `java.lang.CharSequence`
  formatter - the formatter to use, not null - `java.time.format.DateTimeFormatter`

  returns: the parsed local date, not null - `java.time.LocalDate`

  throws: java.time.format.DateTimeParseException - if the text cannot be parsed"
  (^java.time.LocalDate [^java.lang.CharSequence text ^java.time.format.DateTimeFormatter formatter]
    (LocalDate/parse text formatter))
  (^java.time.LocalDate [^java.lang.CharSequence text]
    (LocalDate/parse text)))

(defn minus-weeks
  "Returns a copy of this LocalDate with the specified number of weeks subtracted.

   This method subtracts the specified amount in weeks from the days field decrementing
   the month and year fields as necessary to ensure the result remains valid.
   The result is only invalid if the maximum/minimum year is exceeded.

   For example, 2009-01-07 minus one week would result in 2008-12-31.

   This instance is immutable and unaffected by this method call.

  weeks-to-subtract - the weeks to subtract, may be negative - `long`

  returns: a LocalDate based on this date with the weeks subtracted, not null - `java.time.LocalDate`

  throws: java.time.DateTimeException - if the result exceeds the supported date range"
  (^java.time.LocalDate [^LocalDate this ^Long weeks-to-subtract]
    (-> this (.minusWeeks weeks-to-subtract))))

(defn plus-weeks
  "Returns a copy of this LocalDate with the specified number of weeks added.

   This method adds the specified amount in weeks to the days field incrementing
   the month and year fields as necessary to ensure the result remains valid.
   The result is only invalid if the maximum/minimum year is exceeded.

   For example, 2008-12-31 plus one week would result in 2009-01-07.

   This instance is immutable and unaffected by this method call.

  weeks-to-add - the weeks to add, may be negative - `long`

  returns: a LocalDate based on this date with the weeks added, not null - `java.time.LocalDate`

  throws: java.time.DateTimeException - if the result exceeds the supported date range"
  (^java.time.LocalDate [^LocalDate this ^Long weeks-to-add]
    (-> this (.plusWeeks weeks-to-add))))

(defn length-of-year
  "Returns the length of the year represented by this date.

   This returns the length of the year in days, either 365 or 366.

  returns: 366 if the year is leap, 365 otherwise - `int`"
  (^Integer [^LocalDate this]
    (-> this (.lengthOfYear))))

(defn range
  "Gets the range of valid values for the specified field.

   The range object expresses the minimum and maximum valid values for a field.
   This date is used to enhance the accuracy of the returned range.
   If it is not possible to return the range, because the field is not supported
   or for some other reason, an exception is thrown.

   If the field is a ChronoField then the query is implemented here.
   The supported fields will return
   appropriate range instances.
   All other ChronoField instances will throw an UnsupportedTemporalTypeException.

   If the field is not a ChronoField, then the result of this method
   is obtained by invoking TemporalField.rangeRefinedBy(TemporalAccessor)
   passing this as the argument.
   Whether the range can be obtained is determined by the field.

  field - the field to query the range for, not null - `java.time.temporal.TemporalField`

  returns: the range of valid values for the field, not null - `java.time.temporal.ValueRange`

  throws: java.time.DateTimeException - if the range for the field cannot be obtained"
  (^java.time.temporal.ValueRange [^LocalDate this ^java.time.temporal.TemporalField field]
    (-> this (.range field))))

(defn get-era
  "Gets the era applicable at this date.

   The official ISO-8601 standard does not define eras, however IsoChronology does.
   It defines two eras, 'CE' from year one onwards and 'BCE' from year zero backwards.
   Since dates before the Julian-Gregorian cutover are not in line with history,
   the cutover between 'BCE' and 'CE' is also not aligned with the commonly used
   eras, often referred to using 'BC' and 'AD'.

   Users of this class should typically ignore this method as it exists primarily
   to fulfill the ChronoLocalDate contract where it is necessary to support
   the Japanese calendar system.

   The returned era will be a singleton capable of being compared with the constants
   in IsoChronology using the == operator.

  returns: the IsoChronology era constant applicable at this date, not null - `java.time.chrono.Era`"
  (^java.time.chrono.Era [^LocalDate this]
    (-> this (.getEra))))

(defn with-month
  "Returns a copy of this LocalDate with the month-of-year altered.

   If the day-of-month is invalid for the year, it will be changed to the last valid day of the month.

   This instance is immutable and unaffected by this method call.

  month - the month-of-year to set in the result, from 1 (January) to 12 (December) - `int`

  returns: a LocalDate based on this date with the requested month, not null - `java.time.LocalDate`

  throws: java.time.DateTimeException - if the month-of-year value is invalid"
  (^java.time.LocalDate [^LocalDate this ^Integer month]
    (-> this (.withMonth month))))

(defn equal?
  "Checks if this date is equal to the specified date.

   This checks to see if this date represents the same point on the
   local time-line as the other date.


     LocalDate a = LocalDate.of(2012, 6, 30);
     LocalDate b = LocalDate.of(2012, 7, 1);
     a.isEqual(b) == false
     a.isEqual(a) == true
     b.isEqual(a) == false

   This method only considers the position of the two dates on the local time-line.
   It does not take into account the chronology, or calendar system.
   This is different from the comparison in compareTo(ChronoLocalDate)
   but is the same approach as ChronoLocalDate.timeLineOrder().

  other - the other date to compare to, not null - `java.time.chrono.ChronoLocalDate`

  returns: true if this date is equal to the specified date - `boolean`"
  (^Boolean [^LocalDate this ^java.time.chrono.ChronoLocalDate other]
    (-> this (.isEqual other))))

(defn get-year
  "Gets the year field.

   This method returns the primitive int value for the year.

   The year returned by this method is proleptic as per get(YEAR).
   To obtain the year-of-era, use get(YEAR_OF_ERA).

  returns: the year, from MIN_YEAR to MAX_YEAR - `int`"
  (^Integer [^LocalDate this]
    (-> this (.getYear))))

(defn to-epoch-day
  "Description copied from interface: ChronoLocalDate

  returns: the Epoch Day equivalent to this date - `long`"
  (^Long [^LocalDate this]
    (-> this (.toEpochDay))))

(defn get-day-of-year
  "Gets the day-of-year field.

   This method returns the primitive int value for the day-of-year.

  returns: the day-of-year, from 1 to 365, or 366 in a leap year - `int`"
  (^Integer [^LocalDate this]
    (-> this (.getDayOfYear))))

(defn plus
  "Returns a copy of this date with the specified amount added.

   This returns a LocalDate, based on this one, with the amount
   in terms of the unit added. If it is not possible to add the amount, because the
   unit is not supported or for some other reason, an exception is thrown.

   In some cases, adding the amount can cause the resulting date to become invalid.
   For example, adding one month to 31st January would result in 31st February.
   In cases like this, the unit is responsible for resolving the date.
   Typically it will choose the previous valid date, which would be the last valid
   day of February in this example.

   If the field is a ChronoUnit then the addition is implemented here.
   The supported fields behave as follows:

   DAYS -
    Returns a LocalDate with the specified number of days added.
    This is equivalent to plusDays(long).
   WEEKS -
    Returns a LocalDate with the specified number of weeks added.
    This is equivalent to plusWeeks(long) and uses a 7 day week.
   MONTHS -
    Returns a LocalDate with the specified number of months added.
    This is equivalent to plusMonths(long).
    The day-of-month will be unchanged unless it would be invalid for the new
    month and year. In that case, the day-of-month is adjusted to the maximum
    valid value for the new month and year.
   YEARS -
    Returns a LocalDate with the specified number of years added.
    This is equivalent to plusYears(long).
    The day-of-month will be unchanged unless it would be invalid for the new
    month and year. In that case, the day-of-month is adjusted to the maximum
    valid value for the new month and year.
   DECADES -
    Returns a LocalDate with the specified number of decades added.
    This is equivalent to calling plusYears(long) with the amount
    multiplied by 10.
    The day-of-month will be unchanged unless it would be invalid for the new
    month and year. In that case, the day-of-month is adjusted to the maximum
    valid value for the new month and year.
   CENTURIES -
    Returns a LocalDate with the specified number of centuries added.
    This is equivalent to calling plusYears(long) with the amount
    multiplied by 100.
    The day-of-month will be unchanged unless it would be invalid for the new
    month and year. In that case, the day-of-month is adjusted to the maximum
    valid value for the new month and year.
   MILLENNIA -
    Returns a LocalDate with the specified number of millennia added.
    This is equivalent to calling plusYears(long) with the amount
    multiplied by 1,000.
    The day-of-month will be unchanged unless it would be invalid for the new
    month and year. In that case, the day-of-month is adjusted to the maximum
    valid value for the new month and year.
   ERAS -
    Returns a LocalDate with the specified number of eras added.
    Only two eras are supported so the amount must be one, zero or minus one.
    If the amount is non-zero then the year is changed such that the year-of-era
    is unchanged.
    The day-of-month will be unchanged unless it would be invalid for the new
    month and year. In that case, the day-of-month is adjusted to the maximum
    valid value for the new month and year.


   All other ChronoUnit instances will throw an UnsupportedTemporalTypeException.

   If the field is not a ChronoUnit, then the result of this method
   is obtained by invoking TemporalUnit.addTo(Temporal, long)
   passing this as the argument. In this case, the unit determines
   whether and how to perform the addition.

   This instance is immutable and unaffected by this method call.

  amount-to-add - the amount of the unit to add to the result, may be negative - `long`
  unit - the unit of the amount to add, not null - `java.time.temporal.TemporalUnit`

  returns: a LocalDate based on this date with the specified amount added, not null - `java.time.LocalDate`

  throws: java.time.DateTimeException - if the addition cannot be made"
  (^java.time.LocalDate [^LocalDate this ^Long amount-to-add ^java.time.temporal.TemporalUnit unit]
    (-> this (.plus amount-to-add unit)))
  (^java.time.LocalDate [^LocalDate this ^java.time.temporal.TemporalAmount amount-to-add]
    (-> this (.plus amount-to-add))))

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

  returns: true if the year is leap, false otherwise - `boolean`"
  (^Boolean [^LocalDate this]
    (-> this (.isLeapYear))))

(defn query
  "Queries this date using the specified query.

   This queries this date using the specified query strategy object.
   The TemporalQuery object defines the logic to be used to
   obtain the result. Read the documentation of the query to understand
   what the result of this method will be.

   The result of this method is obtained by invoking the
   TemporalQuery.queryFrom(TemporalAccessor) method on the
   specified query passing this as the argument.

  query - the query to invoke, not null - `java.time.temporal.TemporalQuery`

  returns: the query result, null may be returned (defined by the query) - `<R> R`

  throws: java.time.DateTimeException - if unable to query (defined by the query)"
  ([^LocalDate this ^java.time.temporal.TemporalQuery query]
    (-> this (.query query))))

(defn get-day-of-week
  "Gets the day-of-week field, which is an enum DayOfWeek.

   This method returns the enum DayOfWeek for the day-of-week.
   This avoids confusion as to what int values mean.
   If you need access to the primitive int value then the enum
   provides the int value.

   Additional information can be obtained from the DayOfWeek.
   This includes textual names of the values.

  returns: the day-of-week, not null - `java.time.DayOfWeek`"
  (^java.time.DayOfWeek [^LocalDate this]
    (-> this (.getDayOfWeek))))

(defn to-string
  "Outputs this date as a String, such as 2007-12-03.

   The output will be in the ISO-8601 format uuuu-MM-dd.

  returns: a string representation of this date, not null - `java.lang.String`"
  (^java.lang.String [^LocalDate this]
    (-> this (.toString))))

(defn plus-months
  "Returns a copy of this LocalDate with the specified number of months added.

   This method adds the specified amount to the months field in three steps:

   Add the input months to the month-of-year field
   Check if the resulting date would be invalid
   Adjust the day-of-month to the last valid day if necessary


   For example, 2007-03-31 plus one month would result in the invalid date
   2007-04-31. Instead of returning an invalid result, the last valid day
   of the month, 2007-04-30, is selected instead.

   This instance is immutable and unaffected by this method call.

  months-to-add - the months to add, may be negative - `long`

  returns: a LocalDate based on this date with the months added, not null - `java.time.LocalDate`

  throws: java.time.DateTimeException - if the result exceeds the supported date range"
  (^java.time.LocalDate [^LocalDate this ^Long months-to-add]
    (-> this (.plusMonths months-to-add))))

(defn before?
  "Checks if this date is before the specified date.

   This checks to see if this date represents a point on the
   local time-line before the other date.


     LocalDate a = LocalDate.of(2012, 6, 30);
     LocalDate b = LocalDate.of(2012, 7, 1);
     a.isBefore(b) == true
     a.isBefore(a) == false
     b.isBefore(a) == false

   This method only considers the position of the two dates on the local time-line.
   It does not take into account the chronology, or calendar system.
   This is different from the comparison in compareTo(ChronoLocalDate),
   but is the same approach as ChronoLocalDate.timeLineOrder().

  other - the other date to compare to, not null - `java.time.chrono.ChronoLocalDate`

  returns: true if this date is before the specified date - `boolean`"
  (^Boolean [^LocalDate this ^java.time.chrono.ChronoLocalDate other]
    (-> this (.isBefore other))))

(defn minus-months
  "Returns a copy of this LocalDate with the specified number of months subtracted.

   This method subtracts the specified amount from the months field in three steps:

   Subtract the input months from the month-of-year field
   Check if the resulting date would be invalid
   Adjust the day-of-month to the last valid day if necessary


   For example, 2007-03-31 minus one month would result in the invalid date
   2007-02-31. Instead of returning an invalid result, the last valid day
   of the month, 2007-02-28, is selected instead.

   This instance is immutable and unaffected by this method call.

  months-to-subtract - the months to subtract, may be negative - `long`

  returns: a LocalDate based on this date with the months subtracted, not null - `java.time.LocalDate`

  throws: java.time.DateTimeException - if the result exceeds the supported date range"
  (^java.time.LocalDate [^LocalDate this ^Long months-to-subtract]
    (-> this (.minusMonths months-to-subtract))))

(defn minus
  "Returns a copy of this date with the specified amount subtracted.

   This returns a LocalDate, based on this one, with the amount
   in terms of the unit subtracted. If it is not possible to subtract the amount,
   because the unit is not supported or for some other reason, an exception is thrown.

   This method is equivalent to plus(long, TemporalUnit) with the amount negated.
   See that method for a full description of how addition, and thus subtraction, works.

   This instance is immutable and unaffected by this method call.

  amount-to-subtract - the amount of the unit to subtract from the result, may be negative - `long`
  unit - the unit of the amount to subtract, not null - `java.time.temporal.TemporalUnit`

  returns: a LocalDate based on this date with the specified amount subtracted, not null - `java.time.LocalDate`

  throws: java.time.DateTimeException - if the subtraction cannot be made"
  (^java.time.LocalDate [^LocalDate this ^Long amount-to-subtract ^java.time.temporal.TemporalUnit unit]
    (-> this (.minus amount-to-subtract unit)))
  (^java.time.LocalDate [^LocalDate this ^java.time.temporal.TemporalAmount amount-to-subtract]
    (-> this (.minus amount-to-subtract))))

(defn plus-days
  "Returns a copy of this LocalDate with the specified number of days added.

   This method adds the specified amount to the days field incrementing the
   month and year fields as necessary to ensure the result remains valid.
   The result is only invalid if the maximum/minimum year is exceeded.

   For example, 2008-12-31 plus one day would result in 2009-01-01.

   This instance is immutable and unaffected by this method call.

  days-to-add - the days to add, may be negative - `long`

  returns: a LocalDate based on this date with the days added, not null - `java.time.LocalDate`

  throws: java.time.DateTimeException - if the result exceeds the supported date range"
  (^java.time.LocalDate [^LocalDate this ^Long days-to-add]
    (-> this (.plusDays days-to-add))))

(defn get-long
  "Gets the value of the specified field from this date as a long.

   This queries this date for the value of the specified field.
   If it is not possible to return the value, because the field is not supported
   or for some other reason, an exception is thrown.

   If the field is a ChronoField then the query is implemented here.
   The supported fields will return valid
   values based on this date.
   All other ChronoField instances will throw an UnsupportedTemporalTypeException.

   If the field is not a ChronoField, then the result of this method
   is obtained by invoking TemporalField.getFrom(TemporalAccessor)
   passing this as the argument. Whether the value can be obtained,
   and what the value represents, is determined by the field.

  field - the field to get, not null - `java.time.temporal.TemporalField`

  returns: the value for the field - `long`

  throws: java.time.DateTimeException - if a value for the field cannot be obtained"
  (^Long [^LocalDate this ^java.time.temporal.TemporalField field]
    (-> this (.getLong field))))

(defn with-year
  "Returns a copy of this LocalDate with the year altered.

   If the day-of-month is invalid for the year, it will be changed to the last valid day of the month.

   This instance is immutable and unaffected by this method call.

  year - the year to set in the result, from MIN_YEAR to MAX_YEAR - `int`

  returns: a LocalDate based on this date with the requested year, not null - `java.time.LocalDate`

  throws: java.time.DateTimeException - if the year value is invalid"
  (^java.time.LocalDate [^LocalDate this ^Integer year]
    (-> this (.withYear year))))

(defn length-of-month
  "Returns the length of the month represented by this date.

   This returns the length of the month in days.
   For example, a date in January would return 31.

  returns: the length of the month in days - `int`"
  (^Integer [^LocalDate this]
    (-> this (.lengthOfMonth))))

(defn until
  "Calculates the amount of time until another date in terms of the specified unit.

   This calculates the amount of time between two LocalDate
   objects in terms of a single TemporalUnit.
   The start and end points are this and the specified date.
   The result will be negative if the end is before the start.
   The Temporal passed to this method is converted to a
   LocalDate using from(TemporalAccessor).
   For example, the amount in days between two dates can be calculated
   using startDate.until(endDate, DAYS).

   The calculation returns a whole number, representing the number of
   complete units between the two dates.
   For example, the amount in months between 2012-06-15 and 2012-08-14
   will only be one month as it is one day short of two months.

   There are two equivalent ways of using this method.
   The first is to invoke this method.
   The second is to use TemporalUnit.between(Temporal, Temporal):


     // these two lines are equivalent
     amount = start.until(end, MONTHS);
     amount = MONTHS.between(start, end);
   The choice should be made based on which makes the code more readable.

   The calculation is implemented in this method for ChronoUnit.
   The units DAYS, WEEKS, MONTHS, YEARS,
   DECADES, CENTURIES, MILLENNIA and ERAS
   are supported. Other ChronoUnit values will throw an exception.

   If the unit is not a ChronoUnit, then the result of this method
   is obtained by invoking TemporalUnit.between(Temporal, Temporal)
   passing this as the first argument and the converted input temporal
   as the second argument.

   This instance is immutable and unaffected by this method call.

  end-exclusive - the end date, exclusive, which is converted to a LocalDate, not null - `java.time.temporal.Temporal`
  unit - the unit to measure the amount in, not null - `java.time.temporal.TemporalUnit`

  returns: the amount of time between this date and the end date - `long`

  throws: java.time.DateTimeException - if the amount cannot be calculated, or the end temporal cannot be converted to a LocalDate"
  (^Long [^LocalDate this ^java.time.temporal.Temporal end-exclusive ^java.time.temporal.TemporalUnit unit]
    (-> this (.until end-exclusive unit)))
  (^java.time.Period [^LocalDate this ^java.time.chrono.ChronoLocalDate end-date-exclusive]
    (-> this (.until end-date-exclusive))))

(defn with-day-of-month
  "Returns a copy of this LocalDate with the day-of-month altered.

   If the resulting date is invalid, an exception is thrown.

   This instance is immutable and unaffected by this method call.

  day-of-month - the day-of-month to set in the result, from 1 to 28-31 - `int`

  returns: a LocalDate based on this date with the requested day, not null - `java.time.LocalDate`

  throws: java.time.DateTimeException - if the day-of-month value is invalid, or if the day-of-month is invalid for the month-year"
  (^java.time.LocalDate [^LocalDate this ^Integer day-of-month]
    (-> this (.withDayOfMonth day-of-month))))

(defn get-day-of-month
  "Gets the day-of-month field.

   This method returns the primitive int value for the day-of-month.

  returns: the day-of-month, from 1 to 31 - `int`"
  (^Integer [^LocalDate this]
    (-> this (.getDayOfMonth))))

(defn after?
  "Checks if this date is after the specified date.

   This checks to see if this date represents a point on the
   local time-line after the other date.


     LocalDate a = LocalDate.of(2012, 6, 30);
     LocalDate b = LocalDate.of(2012, 7, 1);
     a.isAfter(b) == false
     a.isAfter(a) == false
     b.isAfter(a) == true

   This method only considers the position of the two dates on the local time-line.
   It does not take into account the chronology, or calendar system.
   This is different from the comparison in compareTo(ChronoLocalDate),
   but is the same approach as ChronoLocalDate.timeLineOrder().

  other - the other date to compare to, not null - `java.time.chrono.ChronoLocalDate`

  returns: true if this date is after the specified date - `boolean`"
  (^Boolean [^LocalDate this ^java.time.chrono.ChronoLocalDate other]
    (-> this (.isAfter other))))

(defn supported?
  "Checks if the specified field is supported.

   This checks if this date can be queried for the specified field.
   If false, then calling the range,
   get and with(TemporalField, long)
   methods will throw an exception.

   If the field is a ChronoField then the query is implemented here.
   The supported fields are:

   DAY_OF_WEEK
   ALIGNED_DAY_OF_WEEK_IN_MONTH
   ALIGNED_DAY_OF_WEEK_IN_YEAR
   DAY_OF_MONTH
   DAY_OF_YEAR
   EPOCH_DAY
   ALIGNED_WEEK_OF_MONTH
   ALIGNED_WEEK_OF_YEAR
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
  (^Boolean [^LocalDate this ^java.time.temporal.TemporalField field]
    (-> this (.isSupported field))))

(defn minus-years
  "Returns a copy of this LocalDate with the specified number of years subtracted.

   This method subtracts the specified amount from the years field in three steps:

   Subtract the input years from the year field
   Check if the resulting date would be invalid
   Adjust the day-of-month to the last valid day if necessary


   For example, 2008-02-29 (leap year) minus one year would result in the
   invalid date 2007-02-29 (standard year). Instead of returning an invalid
   result, the last valid day of the month, 2007-02-28, is selected instead.

   This instance is immutable and unaffected by this method call.

  years-to-subtract - the years to subtract, may be negative - `long`

  returns: a LocalDate based on this date with the years subtracted, not null - `java.time.LocalDate`

  throws: java.time.DateTimeException - if the result exceeds the supported date range"
  (^java.time.LocalDate [^LocalDate this ^Long years-to-subtract]
    (-> this (.minusYears years-to-subtract))))

(defn get-chronology
  "Gets the chronology of this date, which is the ISO calendar system.

   The Chronology represents the calendar system in use.
   The ISO-8601 calendar system is the modern civil calendar system used today
   in most of the world. It is equivalent to the proleptic Gregorian calendar
   system, in which today's rules for leap years are applied for all time.

  returns: the ISO chronology, not null - `java.time.chrono.IsoChronology`"
  (^java.time.chrono.IsoChronology [^LocalDate this]
    (-> this (.getChronology))))

(defn hash-code
  "A hash code for this date.

  returns: a suitable hash code - `int`"
  (^Integer [^LocalDate this]
    (-> this (.hashCode))))

(defn adjust-into
  "Adjusts the specified temporal object to have the same date as this object.

   This returns a temporal object of the same observable type as the input
   with the date changed to be the same as this.

   The adjustment is equivalent to using Temporal.with(TemporalField, long)
   passing ChronoField.EPOCH_DAY as the field.

   In most cases, it is clearer to reverse the calling pattern by using
   Temporal.with(TemporalAdjuster):


     // these two lines are equivalent, but the second approach is recommended
     temporal = thisLocalDate.adjustInto(temporal);
     temporal = temporal.with(thisLocalDate);

   This instance is immutable and unaffected by this method call.

  temporal - the target object to be adjusted, not null - `java.time.temporal.Temporal`

  returns: the adjusted object, not null - `java.time.temporal.Temporal`

  throws: java.time.DateTimeException - if unable to make the adjustment"
  (^java.time.temporal.Temporal [^LocalDate this ^java.time.temporal.Temporal temporal]
    (-> this (.adjustInto temporal))))

(defn with
  "Returns a copy of this date with the specified field set to a new value.

   This returns a LocalDate, based on this one, with the value
   for the specified field changed.
   This can be used to change any supported field, such as the year, month or day-of-month.
   If it is not possible to set the value, because the field is not supported or for
   some other reason, an exception is thrown.

   In some cases, changing the specified field can cause the resulting date to become invalid,
   such as changing the month from 31st January to February would make the day-of-month invalid.
   In cases like this, the field is responsible for resolving the date. Typically it will choose
   the previous valid date, which would be the last valid day of February in this example.

   If the field is a ChronoField then the adjustment is implemented here.
   The supported fields behave as follows:

   DAY_OF_WEEK -
    Returns a LocalDate with the specified day-of-week.
    The date is adjusted up to 6 days forward or backward within the boundary
    of a Monday to Sunday week.
   ALIGNED_DAY_OF_WEEK_IN_MONTH -
    Returns a LocalDate with the specified aligned-day-of-week.
    The date is adjusted to the specified month-based aligned-day-of-week.
    Aligned weeks are counted such that the first week of a given month starts
    on the first day of that month.
    This may cause the date to be moved up to 6 days into the following month.
   ALIGNED_DAY_OF_WEEK_IN_YEAR -
    Returns a LocalDate with the specified aligned-day-of-week.
    The date is adjusted to the specified year-based aligned-day-of-week.
    Aligned weeks are counted such that the first week of a given year starts
    on the first day of that year.
    This may cause the date to be moved up to 6 days into the following year.
   DAY_OF_MONTH -
    Returns a LocalDate with the specified day-of-month.
    The month and year will be unchanged. If the day-of-month is invalid for the
    year and month, then a DateTimeException is thrown.
   DAY_OF_YEAR -
    Returns a LocalDate with the specified day-of-year.
    The year will be unchanged. If the day-of-year is invalid for the
    year, then a DateTimeException is thrown.
   EPOCH_DAY -
    Returns a LocalDate with the specified epoch-day.
    This completely replaces the date and is equivalent to ofEpochDay(long).
   ALIGNED_WEEK_OF_MONTH -
    Returns a LocalDate with the specified aligned-week-of-month.
    Aligned weeks are counted such that the first week of a given month starts
    on the first day of that month.
    This adjustment moves the date in whole week chunks to match the specified week.
    The result will have the same day-of-week as this date.
    This may cause the date to be moved into the following month.
   ALIGNED_WEEK_OF_YEAR -
    Returns a LocalDate with the specified aligned-week-of-year.
    Aligned weeks are counted such that the first week of a given year starts
    on the first day of that year.
    This adjustment moves the date in whole week chunks to match the specified week.
    The result will have the same day-of-week as this date.
    This may cause the date to be moved into the following year.
   MONTH_OF_YEAR -
    Returns a LocalDate with the specified month-of-year.
    The year will be unchanged. The day-of-month will also be unchanged,
    unless it would be invalid for the new month and year. In that case, the
    day-of-month is adjusted to the maximum valid value for the new month and year.
   PROLEPTIC_MONTH -
    Returns a LocalDate with the specified proleptic-month.
    The day-of-month will be unchanged, unless it would be invalid for the new month
    and year. In that case, the day-of-month is adjusted to the maximum valid value
    for the new month and year.
   YEAR_OF_ERA -
    Returns a LocalDate with the specified year-of-era.
    The era and month will be unchanged. The day-of-month will also be unchanged,
    unless it would be invalid for the new month and year. In that case, the
    day-of-month is adjusted to the maximum valid value for the new month and year.
   YEAR -
    Returns a LocalDate with the specified year.
    The month will be unchanged. The day-of-month will also be unchanged,
    unless it would be invalid for the new month and year. In that case, the
    day-of-month is adjusted to the maximum valid value for the new month and year.
   ERA -
    Returns a LocalDate with the specified era.
    The year-of-era and month will be unchanged. The day-of-month will also be unchanged,
    unless it would be invalid for the new month and year. In that case, the
    day-of-month is adjusted to the maximum valid value for the new month and year.


   In all cases, if the new value is outside the valid range of values for the field
   then a DateTimeException will be thrown.

   All other ChronoField instances will throw an UnsupportedTemporalTypeException.

   If the field is not a ChronoField, then the result of this method
   is obtained by invoking TemporalField.adjustInto(Temporal, long)
   passing this as the argument. In this case, the field determines
   whether and how to adjust the instant.

   This instance is immutable and unaffected by this method call.

  field - the field to set in the result, not null - `java.time.temporal.TemporalField`
  new-value - the new value of the field in the result - `long`

  returns: a LocalDate based on this with the specified field set, not null - `java.time.LocalDate`

  throws: java.time.DateTimeException - if the field cannot be set"
  (^java.time.LocalDate [^LocalDate this ^java.time.temporal.TemporalField field ^Long new-value]
    (-> this (.with field new-value)))
  (^java.time.LocalDate [^LocalDate this ^java.time.temporal.TemporalAdjuster adjuster]
    (-> this (.with adjuster))))

(defn at-start-of-day
  "Returns a zoned date-time from this date at the earliest valid time according
   to the rules in the time-zone.

   Time-zone rules, such as daylight savings, mean that not every local date-time
   is valid for the specified zone, thus the local date-time may not be midnight.

   In most cases, there is only one valid offset for a local date-time.
   In the case of an overlap, there are two valid offsets, and the earlier one is used,
   corresponding to the first occurrence of midnight on the date.
   In the case of a gap, the zoned date-time will represent the instant just after the gap.

   If the zone ID is a ZoneOffset, then the result always has a time of midnight.

   To convert to a specific time in a given time-zone call atTime(LocalTime)
   followed by LocalDateTime.atZone(ZoneId).

  zone - the zone ID to use, not null - `java.time.ZoneId`

  returns: the zoned date-time formed from this date and the earliest valid time for the zone, not null - `java.time.ZonedDateTime`"
  (^java.time.ZonedDateTime [^LocalDate this ^java.time.ZoneId zone]
    (-> this (.atStartOfDay zone)))
  (^java.time.LocalDateTime [^LocalDate this]
    (-> this (.atStartOfDay))))

(defn get-month-value
  "Gets the month-of-year field from 1 to 12.

   This method returns the month as an int from 1 to 12.
   Application code is frequently clearer if the enum Month
   is used by calling getMonth().

  returns: the month-of-year, from 1 to 12 - `int`"
  (^Integer [^LocalDate this]
    (-> this (.getMonthValue))))

(defn with-day-of-year
  "Returns a copy of this LocalDate with the day-of-year altered.

   If the resulting date is invalid, an exception is thrown.

   This instance is immutable and unaffected by this method call.

  day-of-year - the day-of-year to set in the result, from 1 to 365-366 - `int`

  returns: a LocalDate based on this date with the requested day, not null - `java.time.LocalDate`

  throws: java.time.DateTimeException - if the day-of-year value is invalid, or if the day-of-year is invalid for the year"
  (^java.time.LocalDate [^LocalDate this ^Integer day-of-year]
    (-> this (.withDayOfYear day-of-year))))

(defn compare-to
  "Compares this date to another date.

   The comparison is primarily based on the date, from earliest to latest.
   It is `consistent with equals`, as defined by Comparable.

   If all the dates being compared are instances of LocalDate,
   then the comparison will be entirely based on the date.
   If some dates being compared are in different chronologies, then the
   chronology is also considered, see ChronoLocalDate.compareTo(java.time.chrono.ChronoLocalDate).

  other - the other date to compare to, not null - `java.time.chrono.ChronoLocalDate`

  returns: the comparator value, negative if less, positive if greater - `int`"
  (^Integer [^LocalDate this ^java.time.chrono.ChronoLocalDate other]
    (-> this (.compareTo other))))

(defn get-month
  "Gets the month-of-year field using the Month enum.

   This method returns the enum Month for the month.
   This avoids confusion as to what int values mean.
   If you need access to the primitive int value then the enum
   provides the int value.

  returns: the month-of-year, not null - `java.time.Month`"
  (^java.time.Month [^LocalDate this]
    (-> this (.getMonth))))

(defn get
  "Gets the value of the specified field from this date as an int.

   This queries this date for the value of the specified field.
   The returned value will always be within the valid range of values for the field.
   If it is not possible to return the value, because the field is not supported
   or for some other reason, an exception is thrown.

   If the field is a ChronoField then the query is implemented here.
   The supported fields will return valid
   values based on this date, except EPOCH_DAY and PROLEPTIC_MONTH
   which are too large to fit in an int and throw a DateTimeException.
   All other ChronoField instances will throw an UnsupportedTemporalTypeException.

   If the field is not a ChronoField, then the result of this method
   is obtained by invoking TemporalField.getFrom(TemporalAccessor)
   passing this as the argument. Whether the value can be obtained,
   and what the value represents, is determined by the field.

  field - the field to get, not null - `java.time.temporal.TemporalField`

  returns: the value for the field - `int`

  throws: java.time.DateTimeException - if a value for the field cannot be obtained or the value is outside the range of valid values for the field"
  (^Integer [^LocalDate this ^java.time.temporal.TemporalField field]
    (-> this (.get field))))

(defn equals
  "Checks if this date is equal to another date.

   Compares this LocalDate with another ensuring that the date is the same.

   Only objects of type LocalDate are compared, other types return false.
   To compare the dates of two TemporalAccessor instances, including dates
   in two different chronologies, use ChronoField.EPOCH_DAY as a comparator.

  obj - the object to check, null returns false - `java.lang.Object`

  returns: true if this is equal to the other date - `boolean`"
  (^Boolean [^LocalDate this ^java.lang.Object obj]
    (-> this (.equals obj))))

(defn at-time
  "Combines this date with a time to create a LocalDateTime.

   This returns a LocalDateTime formed from this date at the
   specified hour, minute, second and nanosecond.
   The individual time fields must be within their valid range.
   All possible combinations of date and time are valid.

  hour - the hour-of-day to use, from 0 to 23 - `int`
  minute - the minute-of-hour to use, from 0 to 59 - `int`
  second - the second-of-minute to represent, from 0 to 59 - `int`
  nano-of-second - the nano-of-second to represent, from 0 to 999,999,999 - `int`

  returns: the local date-time formed from this date and the specified time, not null - `java.time.LocalDateTime`

  throws: java.time.DateTimeException - if the value of any field is out of range"
  (^java.time.LocalDateTime [^LocalDate this ^Integer hour ^Integer minute ^Integer second ^Integer nano-of-second]
    (-> this (.atTime hour minute second nano-of-second)))
  (^java.time.LocalDateTime [^LocalDate this ^Integer hour ^Integer minute ^Integer second]
    (-> this (.atTime hour minute second)))
  (^java.time.LocalDateTime [^LocalDate this ^Integer hour ^Integer minute]
    (-> this (.atTime hour minute)))
  (^java.time.LocalDateTime [^LocalDate this ^java.time.LocalTime time]
    (-> this (.atTime time))))

(defn format
  "Formats this date using the specified formatter.

   This date will be passed to the formatter to produce a string.

  formatter - the formatter to use, not null - `java.time.format.DateTimeFormatter`

  returns: the formatted date string, not null - `java.lang.String`

  throws: java.time.DateTimeException - if an error occurs during printing"
  (^java.lang.String [^LocalDate this ^java.time.format.DateTimeFormatter formatter]
    (-> this (.format formatter))))

(defn plus-years
  "Returns a copy of this LocalDate with the specified number of years added.

   This method adds the specified amount to the years field in three steps:

   Add the input years to the year field
   Check if the resulting date would be invalid
   Adjust the day-of-month to the last valid day if necessary


   For example, 2008-02-29 (leap year) plus one year would result in the
   invalid date 2009-02-29 (standard year). Instead of returning an invalid
   result, the last valid day of the month, 2009-02-28, is selected instead.

   This instance is immutable and unaffected by this method call.

  years-to-add - the years to add, may be negative - `long`

  returns: a LocalDate based on this date with the years added, not null - `java.time.LocalDate`

  throws: java.time.DateTimeException - if the result exceeds the supported date range"
  (^java.time.LocalDate [^LocalDate this ^Long years-to-add]
    (-> this (.plusYears years-to-add))))

(defn minus-days
  "Returns a copy of this LocalDate with the specified number of days subtracted.

   This method subtracts the specified amount from the days field decrementing the
   month and year fields as necessary to ensure the result remains valid.
   The result is only invalid if the maximum/minimum year is exceeded.

   For example, 2009-01-01 minus one day would result in 2008-12-31.

   This instance is immutable and unaffected by this method call.

  days-to-subtract - the days to subtract, may be negative - `long`

  returns: a LocalDate based on this date with the days subtracted, not null - `java.time.LocalDate`

  throws: java.time.DateTimeException - if the result exceeds the supported date range"
  (^java.time.LocalDate [^LocalDate this ^Long days-to-subtract]
    (-> this (.minusDays days-to-subtract))))

