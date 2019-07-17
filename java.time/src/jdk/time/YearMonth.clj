(ns jdk.time.YearMonth
  "A year-month in the ISO-8601 calendar system, such as 2007-12.

  YearMonth is an immutable date-time object that represents the combination
  of a year and month. Any field that can be derived from a year and month, such as
  quarter-of-year, can be obtained.

  This class does not store or represent a day, time or time-zone.
  For example, the value `October 2007` can be stored in a YearMonth.

  The ISO-8601 calendar system is the modern civil calendar system used today
  in most of the world. It is equivalent to the proleptic Gregorian calendar
  system, in which today's rules for leap years are applied for all time.
  For most applications written today, the ISO-8601 rules are entirely suitable.
  However, any application that makes use of historical dates, and requires them
  to be accurate will find the ISO-8601 approach unsuitable.


  This is a value-based
  class; use of identity-sensitive operations (including reference equality
  (==), identity hash code, or synchronization) on instances of
  YearMonth may have unpredictable results and should be avoided.
  The equals method should be used for comparisons."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.time YearMonth]))

(defn *now
  "Obtains the current year-month from the system clock in the specified time-zone.

   This will query the system clock to obtain the current year-month.
   Specifying the time-zone avoids dependence on the default time-zone.

   Using this method will prevent the ability to use an alternate clock for testing
   because the clock is hard-coded.

  zone - the zone ID to use, not null - `java.time.ZoneId`

  returns: the current year-month using the system clock, not null - `java.time.YearMonth`"
  ([^java.time.ZoneId zone]
    (YearMonth/now zone))
  ([]
    (YearMonth/now )))

(defn *of
  "Obtains an instance of YearMonth from a year and month.

  year - the year to represent, from MIN_YEAR to MAX_YEAR - `int`
  month - the month-of-year to represent, not null - `java.time.Month`

  returns: the year-month, not null - `java.time.YearMonth`

  throws: java.time.DateTimeException - if the year value is invalid"
  ([^Integer year ^java.time.Month month]
    (YearMonth/of year month)))

(defn *from
  "Obtains an instance of YearMonth from a temporal object.

   This obtains a year-month based on the specified temporal.
   A TemporalAccessor represents an arbitrary set of date and time information,
   which this factory converts to an instance of YearMonth.

   The conversion extracts the YEAR and
   MONTH_OF_YEAR fields.
   The extraction is only permitted if the temporal object has an ISO
   chronology, or can be converted to a LocalDate.

   This method matches the signature of the functional interface TemporalQuery
   allowing it to be used as a query via method reference, YearMonth::from.

  temporal - the temporal object to convert, not null - `java.time.temporal.TemporalAccessor`

  returns: the year-month, not null - `java.time.YearMonth`

  throws: java.time.DateTimeException - if unable to convert to a YearMonth"
  ([^java.time.temporal.TemporalAccessor temporal]
    (YearMonth/from temporal)))

(defn *parse
  "Obtains an instance of YearMonth from a text string using a specific formatter.

   The text is parsed using the formatter, returning a year-month.

  text - the text to parse, not null - `java.lang.CharSequence`
  formatter - the formatter to use, not null - `java.time.format.DateTimeFormatter`

  returns: the parsed year-month, not null - `java.time.YearMonth`

  throws: java.time.format.DateTimeParseException - if the text cannot be parsed"
  ([^java.lang.CharSequence text ^java.time.format.DateTimeFormatter formatter]
    (YearMonth/parse text formatter))
  ([^java.lang.CharSequence text]
    (YearMonth/parse text)))

(defn length-of-year
  "Returns the length of the year.

   This returns the length of the year in days, either 365 or 366.

  returns: 366 if the year is leap, 365 otherwise - `int`"
  ([^java.time.YearMonth this]
    (-> this (.lengthOfYear))))

(defn range
  "Gets the range of valid values for the specified field.

   The range object expresses the minimum and maximum valid values for a field.
   This year-month is used to enhance the accuracy of the returned range.
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
  ([^java.time.YearMonth this ^java.time.temporal.TemporalField field]
    (-> this (.range field))))

(defn valid-day?
  "Checks if the day-of-month is valid for this year-month.

   This method checks whether this year and month and the input day form
   a valid date.

  day-of-month - the day-of-month to validate, from 1 to 31, invalid value returns false - `int`

  returns: true if the day is valid for this year-month - `boolean`"
  ([^java.time.YearMonth this ^Integer day-of-month]
    (-> this (.isValidDay day-of-month))))

(defn with-month
  "Returns a copy of this YearMonth with the month-of-year altered.

   This instance is immutable and unaffected by this method call.

  month - the month-of-year to set in the returned year-month, from 1 (January) to 12 (December) - `int`

  returns: a YearMonth based on this year-month with the requested month, not null - `java.time.YearMonth`

  throws: java.time.DateTimeException - if the month-of-year value is invalid"
  ([^java.time.YearMonth this ^Integer month]
    (-> this (.withMonth month))))

(defn at-day
  "Combines this year-month with a day-of-month to create a LocalDate.

   This returns a LocalDate formed from this year-month and the specified day-of-month.

   The day-of-month value must be valid for the year-month.

   This method can be used as part of a chain to produce a date:


    LocalDate date = year.atMonth(month).atDay(day);

  day-of-month - the day-of-month to use, from 1 to 31 - `int`

  returns: the date formed from this year-month and the specified day, not null - `java.time.LocalDate`

  throws: java.time.DateTimeException - if the day is invalid for the year-month"
  ([^java.time.YearMonth this ^Integer day-of-month]
    (-> this (.atDay day-of-month))))

(defn get-year
  "Gets the year field.

   This method returns the primitive int value for the year.

   The year returned by this method is proleptic as per get(YEAR).

  returns: the year, from MIN_YEAR to MAX_YEAR - `int`"
  ([^java.time.YearMonth this]
    (-> this (.getYear))))

(defn plus
  "Returns a copy of this year-month with the specified amount added.

   This returns a YearMonth, based on this one, with the amount
   in terms of the unit added. If it is not possible to add the amount, because the
   unit is not supported or for some other reason, an exception is thrown.

   If the field is a ChronoUnit then the addition is implemented here.
   The supported fields behave as follows:

   MONTHS -
    Returns a YearMonth with the specified number of months added.
    This is equivalent to plusMonths(long).
   YEARS -
    Returns a YearMonth with the specified number of years added.
    This is equivalent to plusYears(long).
   DECADES -
    Returns a YearMonth with the specified number of decades added.
    This is equivalent to calling plusYears(long) with the amount
    multiplied by 10.
   CENTURIES -
    Returns a YearMonth with the specified number of centuries added.
    This is equivalent to calling plusYears(long) with the amount
    multiplied by 100.
   MILLENNIA -
    Returns a YearMonth with the specified number of millennia added.
    This is equivalent to calling plusYears(long) with the amount
    multiplied by 1,000.
   ERAS -
    Returns a YearMonth with the specified number of eras added.
    Only two eras are supported so the amount must be one, zero or minus one.
    If the amount is non-zero then the year is changed such that the year-of-era
    is unchanged.


   All other ChronoUnit instances will throw an UnsupportedTemporalTypeException.

   If the field is not a ChronoUnit, then the result of this method
   is obtained by invoking TemporalUnit.addTo(Temporal, long)
   passing this as the argument. In this case, the unit determines
   whether and how to perform the addition.

   This instance is immutable and unaffected by this method call.

  amount-to-add - the amount of the unit to add to the result, may be negative - `long`
  unit - the unit of the amount to add, not null - `java.time.temporal.TemporalUnit`

  returns: a YearMonth based on this year-month with the specified amount added, not null - `java.time.YearMonth`

  throws: java.time.DateTimeException - if the addition cannot be made"
  ([^java.time.YearMonth this ^Long amount-to-add ^java.time.temporal.TemporalUnit unit]
    (-> this (.plus amount-to-add unit)))
  ([^java.time.YearMonth this ^java.time.temporal.TemporalAmount amount-to-add]
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
  ([^java.time.YearMonth this]
    (-> this (.isLeapYear))))

(defn query
  "Queries this year-month using the specified query.

   This queries this year-month using the specified query strategy object.
   The TemporalQuery object defines the logic to be used to
   obtain the result. Read the documentation of the query to understand
   what the result of this method will be.

   The result of this method is obtained by invoking the
   TemporalQuery.queryFrom(TemporalAccessor) method on the
   specified query passing this as the argument.

  query - the query to invoke, not null - `java.time.temporal.TemporalQuery<R>`

  returns: the query result, null may be returned (defined by the query) - `<R> R`

  throws: java.time.DateTimeException - if unable to query (defined by the query)"
  ([^java.time.YearMonth this ^java.time.temporal.TemporalQuery query]
    (-> this (.query query))))

(defn to-string
  "Outputs this year-month as a String, such as 2007-12.

   The output will be in the format uuuu-MM:

  returns: a string representation of this year-month, not null - `java.lang.String`"
  ([^java.time.YearMonth this]
    (-> this (.toString))))

(defn plus-months
  "Returns a copy of this YearMonth with the specified number of months added.

   This instance is immutable and unaffected by this method call.

  months-to-add - the months to add, may be negative - `long`

  returns: a YearMonth based on this year-month with the months added, not null - `java.time.YearMonth`

  throws: java.time.DateTimeException - if the result exceeds the supported range"
  ([^java.time.YearMonth this ^Long months-to-add]
    (-> this (.plusMonths months-to-add))))

(defn before?
  "Checks if this year-month is before the specified year-month.

  other - the other year-month to compare to, not null - `java.time.YearMonth`

  returns: true if this point is before the specified year-month - `boolean`"
  ([^java.time.YearMonth this ^java.time.YearMonth other]
    (-> this (.isBefore other))))

(defn minus-months
  "Returns a copy of this YearMonth with the specified number of months subtracted.

   This instance is immutable and unaffected by this method call.

  months-to-subtract - the months to subtract, may be negative - `long`

  returns: a YearMonth based on this year-month with the months subtracted, not null - `java.time.YearMonth`

  throws: java.time.DateTimeException - if the result exceeds the supported range"
  ([^java.time.YearMonth this ^Long months-to-subtract]
    (-> this (.minusMonths months-to-subtract))))

(defn minus
  "Returns a copy of this year-month with the specified amount subtracted.

   This returns a YearMonth, based on this one, with the amount
   in terms of the unit subtracted. If it is not possible to subtract the amount,
   because the unit is not supported or for some other reason, an exception is thrown.

   This method is equivalent to plus(long, TemporalUnit) with the amount negated.
   See that method for a full description of how addition, and thus subtraction, works.

   This instance is immutable and unaffected by this method call.

  amount-to-subtract - the amount of the unit to subtract from the result, may be negative - `long`
  unit - the unit of the amount to subtract, not null - `java.time.temporal.TemporalUnit`

  returns: a YearMonth based on this year-month with the specified amount subtracted, not null - `java.time.YearMonth`

  throws: java.time.DateTimeException - if the subtraction cannot be made"
  ([^java.time.YearMonth this ^Long amount-to-subtract ^java.time.temporal.TemporalUnit unit]
    (-> this (.minus amount-to-subtract unit)))
  ([^java.time.YearMonth this ^java.time.temporal.TemporalAmount amount-to-subtract]
    (-> this (.minus amount-to-subtract))))

(defn get-long
  "Gets the value of the specified field from this year-month as a long.

   This queries this year-month for the value of the specified field.
   If it is not possible to return the value, because the field is not supported
   or for some other reason, an exception is thrown.

   If the field is a ChronoField then the query is implemented here.
   The supported fields will return valid
   values based on this year-month.
   All other ChronoField instances will throw an UnsupportedTemporalTypeException.

   If the field is not a ChronoField, then the result of this method
   is obtained by invoking TemporalField.getFrom(TemporalAccessor)
   passing this as the argument. Whether the value can be obtained,
   and what the value represents, is determined by the field.

  field - the field to get, not null - `java.time.temporal.TemporalField`

  returns: the value for the field - `long`

  throws: java.time.DateTimeException - if a value for the field cannot be obtained"
  ([^java.time.YearMonth this ^java.time.temporal.TemporalField field]
    (-> this (.getLong field))))

(defn with-year
  "Returns a copy of this YearMonth with the year altered.

   This instance is immutable and unaffected by this method call.

  year - the year to set in the returned year-month, from MIN_YEAR to MAX_YEAR - `int`

  returns: a YearMonth based on this year-month with the requested year, not null - `java.time.YearMonth`

  throws: java.time.DateTimeException - if the year value is invalid"
  ([^java.time.YearMonth this ^Integer year]
    (-> this (.withYear year))))

(defn at-end-of-month
  "Returns a LocalDate at the end of the month.

   This returns a LocalDate based on this year-month.
   The day-of-month is set to the last valid day of the month, taking
   into account leap years.

   This method can be used as part of a chain to produce a date:


    LocalDate date = year.atMonth(month).atEndOfMonth();

  returns: the last valid date of this year-month, not null - `java.time.LocalDate`"
  ([^java.time.YearMonth this]
    (-> this (.atEndOfMonth))))

(defn length-of-month
  "Returns the length of the month, taking account of the year.

   This returns the length of the month in days.
   For example, a date in January would return 31.

  returns: the length of the month in days, from 28 to 31 - `int`"
  ([^java.time.YearMonth this]
    (-> this (.lengthOfMonth))))

(defn until
  "Calculates the amount of time until another year-month in terms of the specified unit.

   This calculates the amount of time between two YearMonth
   objects in terms of a single TemporalUnit.
   The start and end points are this and the specified year-month.
   The result will be negative if the end is before the start.
   The Temporal passed to this method is converted to a
   YearMonth using from(TemporalAccessor).
   For example, the amount in years between two year-months can be calculated
   using startYearMonth.until(endYearMonth, YEARS).

   The calculation returns a whole number, representing the number of
   complete units between the two year-months.
   For example, the amount in decades between 2012-06 and 2032-05
   will only be one decade as it is one month short of two decades.

   There are two equivalent ways of using this method.
   The first is to invoke this method.
   The second is to use TemporalUnit.between(Temporal, Temporal):


     // these two lines are equivalent
     amount = start.until(end, MONTHS);
     amount = MONTHS.between(start, end);
   The choice should be made based on which makes the code more readable.

   The calculation is implemented in this method for ChronoUnit.
   The units MONTHS, YEARS, DECADES,
   CENTURIES, MILLENNIA and ERAS are supported.
   Other ChronoUnit values will throw an exception.

   If the unit is not a ChronoUnit, then the result of this method
   is obtained by invoking TemporalUnit.between(Temporal, Temporal)
   passing this as the first argument and the converted input temporal
   as the second argument.

   This instance is immutable and unaffected by this method call.

  end-exclusive - the end date, exclusive, which is converted to a YearMonth, not null - `java.time.temporal.Temporal`
  unit - the unit to measure the amount in, not null - `java.time.temporal.TemporalUnit`

  returns: the amount of time between this year-month and the end year-month - `long`

  throws: java.time.DateTimeException - if the amount cannot be calculated, or the end temporal cannot be converted to a YearMonth"
  ([^java.time.YearMonth this ^java.time.temporal.Temporal end-exclusive ^java.time.temporal.TemporalUnit unit]
    (-> this (.until end-exclusive unit))))

(defn after?
  "Checks if this year-month is after the specified year-month.

  other - the other year-month to compare to, not null - `java.time.YearMonth`

  returns: true if this is after the specified year-month - `boolean`"
  ([^java.time.YearMonth this ^java.time.YearMonth other]
    (-> this (.isAfter other))))

(defn supported?
  "Checks if the specified field is supported.

   This checks if this year-month can be queried for the specified field.
   If false, then calling the range,
   get and with(TemporalField, long)
   methods will throw an exception.

   If the field is a ChronoField then the query is implemented here.
   The supported fields are:

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

  returns: true if the field is supported on this year-month, false if not - `boolean`"
  ([^java.time.YearMonth this ^java.time.temporal.TemporalField field]
    (-> this (.isSupported field))))

(defn minus-years
  "Returns a copy of this YearMonth with the specified number of years subtracted.

   This instance is immutable and unaffected by this method call.

  years-to-subtract - the years to subtract, may be negative - `long`

  returns: a YearMonth based on this year-month with the years subtracted, not null - `java.time.YearMonth`

  throws: java.time.DateTimeException - if the result exceeds the supported range"
  ([^java.time.YearMonth this ^Long years-to-subtract]
    (-> this (.minusYears years-to-subtract))))

(defn hash-code
  "A hash code for this year-month.

  returns: a suitable hash code - `int`"
  ([^java.time.YearMonth this]
    (-> this (.hashCode))))

(defn adjust-into
  "Adjusts the specified temporal object to have this year-month.

   This returns a temporal object of the same observable type as the input
   with the year and month changed to be the same as this.

   The adjustment is equivalent to using Temporal.with(TemporalField, long)
   passing ChronoField.PROLEPTIC_MONTH as the field.
   If the specified temporal object does not use the ISO calendar system then
   a DateTimeException is thrown.

   In most cases, it is clearer to reverse the calling pattern by using
   Temporal.with(TemporalAdjuster):


     // these two lines are equivalent, but the second approach is recommended
     temporal = thisYearMonth.adjustInto(temporal);
     temporal = temporal.with(thisYearMonth);

   This instance is immutable and unaffected by this method call.

  temporal - the target object to be adjusted, not null - `java.time.temporal.Temporal`

  returns: the adjusted object, not null - `java.time.temporal.Temporal`

  throws: java.time.DateTimeException - if unable to make the adjustment"
  ([^java.time.YearMonth this ^java.time.temporal.Temporal temporal]
    (-> this (.adjustInto temporal))))

(defn with
  "Returns a copy of this year-month with the specified field set to a new value.

   This returns a YearMonth, based on this one, with the value
   for the specified field changed.
   This can be used to change any supported field, such as the year or month.
   If it is not possible to set the value, because the field is not supported or for
   some other reason, an exception is thrown.

   If the field is a ChronoField then the adjustment is implemented here.
   The supported fields behave as follows:

   MONTH_OF_YEAR -
    Returns a YearMonth with the specified month-of-year.
    The year will be unchanged.
   PROLEPTIC_MONTH -
    Returns a YearMonth with the specified proleptic-month.
    This completely replaces the year and month of this object.
   YEAR_OF_ERA -
    Returns a YearMonth with the specified year-of-era
    The month and era will be unchanged.
   YEAR -
    Returns a YearMonth with the specified year.
    The month will be unchanged.
   ERA -
    Returns a YearMonth with the specified era.
    The month and year-of-era will be unchanged.


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

  returns: a YearMonth based on this with the specified field set, not null - `java.time.YearMonth`

  throws: java.time.DateTimeException - if the field cannot be set"
  ([^java.time.YearMonth this ^java.time.temporal.TemporalField field ^Long new-value]
    (-> this (.with field new-value)))
  ([^java.time.YearMonth this ^java.time.temporal.TemporalAdjuster adjuster]
    (-> this (.with adjuster))))

(defn get-month-value
  "Gets the month-of-year field from 1 to 12.

   This method returns the month as an int from 1 to 12.
   Application code is frequently clearer if the enum Month
   is used by calling getMonth().

  returns: the month-of-year, from 1 to 12 - `int`"
  ([^java.time.YearMonth this]
    (-> this (.getMonthValue))))

(defn compare-to
  "Compares this year-month to another year-month.

   The comparison is based first on the value of the year, then on the value of the month.
   It is `consistent with equals`, as defined by Comparable.

  other - the other year-month to compare to, not null - `java.time.YearMonth`

  returns: the comparator value, negative if less, positive if greater - `int`"
  ([^java.time.YearMonth this ^java.time.YearMonth other]
    (-> this (.compareTo other))))

(defn get-month
  "Gets the month-of-year field using the Month enum.

   This method returns the enum Month for the month.
   This avoids confusion as to what int values mean.
   If you need access to the primitive int value then the enum
   provides the int value.

  returns: the month-of-year, not null - `java.time.Month`"
  ([^java.time.YearMonth this]
    (-> this (.getMonth))))

(defn get
  "Gets the value of the specified field from this year-month as an int.

   This queries this year-month for the value of the specified field.
   The returned value will always be within the valid range of values for the field.
   If it is not possible to return the value, because the field is not supported
   or for some other reason, an exception is thrown.

   If the field is a ChronoField then the query is implemented here.
   The supported fields will return valid
   values based on this year-month, except PROLEPTIC_MONTH which is too
   large to fit in an int and throw a DateTimeException.
   All other ChronoField instances will throw an UnsupportedTemporalTypeException.

   If the field is not a ChronoField, then the result of this method
   is obtained by invoking TemporalField.getFrom(TemporalAccessor)
   passing this as the argument. Whether the value can be obtained,
   and what the value represents, is determined by the field.

  field - the field to get, not null - `java.time.temporal.TemporalField`

  returns: the value for the field - `int`

  throws: java.time.DateTimeException - if a value for the field cannot be obtained or the value is outside the range of valid values for the field"
  ([^java.time.YearMonth this ^java.time.temporal.TemporalField field]
    (-> this (.get field))))

(defn equals
  "Checks if this year-month is equal to another year-month.

   The comparison is based on the time-line position of the year-months.

  obj - the object to check, null returns false - `java.lang.Object`

  returns: true if this is equal to the other year-month - `boolean`"
  ([^java.time.YearMonth this ^java.lang.Object obj]
    (-> this (.equals obj))))

(defn format
  "Formats this year-month using the specified formatter.

   This year-month will be passed to the formatter to produce a string.

  formatter - the formatter to use, not null - `java.time.format.DateTimeFormatter`

  returns: the formatted year-month string, not null - `java.lang.String`

  throws: java.time.DateTimeException - if an error occurs during printing"
  ([^java.time.YearMonth this ^java.time.format.DateTimeFormatter formatter]
    (-> this (.format formatter))))

(defn plus-years
  "Returns a copy of this YearMonth with the specified number of years added.

   This instance is immutable and unaffected by this method call.

  years-to-add - the years to add, may be negative - `long`

  returns: a YearMonth based on this year-month with the years added, not null - `java.time.YearMonth`

  throws: java.time.DateTimeException - if the result exceeds the supported range"
  ([^java.time.YearMonth this ^Long years-to-add]
    (-> this (.plusYears years-to-add))))

