(ns jdk.time.Year
  "A year in the ISO-8601 calendar system, such as 2007.

  Year is an immutable date-time object that represents a year.
  Any field that can be derived from a year can be obtained.

  Note that years in the ISO chronology only align with years in the
  Gregorian-Julian system for modern years. Parts of Russia did not switch to the
  modern Gregorian/ISO rules until 1920.
  As such, historical years must be treated with caution.

  This class does not store or represent a month, day, time or time-zone.
  For example, the value `2007` can be stored in a Year.

  Years represented by this class follow the ISO-8601 standard and use
  the proleptic numbering system. Year 1 is preceded by year 0, then by year -1.

  The ISO-8601 calendar system is the modern civil calendar system used today
  in most of the world. It is equivalent to the proleptic Gregorian calendar
  system, in which today's rules for leap years are applied for all time.
  For most applications written today, the ISO-8601 rules are entirely suitable.
  However, any application that makes use of historical dates, and requires them
  to be accurate will find the ISO-8601 approach unsuitable.


  This is a value-based
  class; use of identity-sensitive operations (including reference equality
  (==), identity hash code, or synchronization) on instances of
  Year may have unpredictable results and should be avoided.
  The equals method should be used for comparisons."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.time Year]))

(def *-min-value
  "Static Constant.

  The minimum supported year, '-999,999,999'.

  type: int"
  Year/MIN_VALUE)

(def *-max-value
  "Static Constant.

  The maximum supported year, '+999,999,999'.

  type: int"
  Year/MAX_VALUE)

(defn *now
  "Obtains the current year from the system clock in the specified time-zone.

   This will query the system clock to obtain the current year.
   Specifying the time-zone avoids dependence on the default time-zone.

   Using this method will prevent the ability to use an alternate clock for testing
   because the clock is hard-coded.

  zone - the zone ID to use, not null - `java.time.ZoneId`

  returns: the current year using the system clock, not null - `java.time.Year`"
  (^java.time.Year [^java.time.ZoneId zone]
    (Year/now zone))
  (^java.time.Year []
    (Year/now )))

(defn *of
  "Obtains an instance of Year.

   This method accepts a year value from the proleptic ISO calendar system.

   The year 2AD/CE is represented by 2.
   The year 1AD/CE is represented by 1.
   The year 1BC/BCE is represented by 0.
   The year 2BC/BCE is represented by -1.

  iso-year - the ISO proleptic year to represent, from MIN_VALUE to MAX_VALUE - `int`

  returns: the year, not null - `java.time.Year`

  throws: java.time.DateTimeException - if the field is invalid"
  (^java.time.Year [^Integer iso-year]
    (Year/of iso-year)))

(defn *from
  "Obtains an instance of Year from a temporal object.

   This obtains a year based on the specified temporal.
   A TemporalAccessor represents an arbitrary set of date and time information,
   which this factory converts to an instance of Year.

   The conversion extracts the year field.
   The extraction is only permitted if the temporal object has an ISO
   chronology, or can be converted to a LocalDate.

   This method matches the signature of the functional interface TemporalQuery
   allowing it to be used as a query via method reference, Year::from.

  temporal - the temporal object to convert, not null - `java.time.temporal.TemporalAccessor`

  returns: the year, not null - `java.time.Year`

  throws: java.time.DateTimeException - if unable to convert to a Year"
  (^java.time.Year [^java.time.temporal.TemporalAccessor temporal]
    (Year/from temporal)))

(defn *parse
  "Obtains an instance of Year from a text string using a specific formatter.

   The text is parsed using the formatter, returning a year.

  text - the text to parse, not null - `java.lang.CharSequence`
  formatter - the formatter to use, not null - `java.time.format.DateTimeFormatter`

  returns: the parsed year, not null - `java.time.Year`

  throws: java.time.format.DateTimeParseException - if the text cannot be parsed"
  (^java.time.Year [^java.lang.CharSequence text ^java.time.format.DateTimeFormatter formatter]
    (Year/parse text formatter))
  (^java.time.Year [^java.lang.CharSequence text]
    (Year/parse text)))

(defn *leap?
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

  year - the year to check - `long`

  returns: true if the year is leap, false otherwise - `boolean`"
  (^Boolean [^Long year]
    (Year/isLeap year)))

(defn range
  "Gets the range of valid values for the specified field.

   The range object expresses the minimum and maximum valid values for a field.
   This year is used to enhance the accuracy of the returned range.
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
  (^java.time.temporal.ValueRange [^Year this ^java.time.temporal.TemporalField field]
    (-> this (.range field))))

(defn at-day
  "Combines this year with a day-of-year to create a LocalDate.

   This returns a LocalDate formed from this year and the specified day-of-year.

   The day-of-year value 366 is only valid in a leap year.

  day-of-year - the day-of-year to use, from 1 to 365-366 - `int`

  returns: the local date formed from this year and the specified date of year, not null - `java.time.LocalDate`

  throws: java.time.DateTimeException - if the day of year is zero or less, 366 or greater or equal to 366 and this is not a leap year"
  (^java.time.LocalDate [^Year this ^Integer day-of-year]
    (-> this (.atDay day-of-year))))

(defn plus
  "Returns a copy of this year with the specified amount added.

   This returns a Year, based on this one, with the amount
   in terms of the unit added. If it is not possible to add the amount, because the
   unit is not supported or for some other reason, an exception is thrown.

   If the field is a ChronoUnit then the addition is implemented here.
   The supported fields behave as follows:

   YEARS -
    Returns a Year with the specified number of years added.
    This is equivalent to plusYears(long).
   DECADES -
    Returns a Year with the specified number of decades added.
    This is equivalent to calling plusYears(long) with the amount
    multiplied by 10.
   CENTURIES -
    Returns a Year with the specified number of centuries added.
    This is equivalent to calling plusYears(long) with the amount
    multiplied by 100.
   MILLENNIA -
    Returns a Year with the specified number of millennia added.
    This is equivalent to calling plusYears(long) with the amount
    multiplied by 1,000.
   ERAS -
    Returns a Year with the specified number of eras added.
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

  returns: a Year based on this year with the specified amount added, not null - `java.time.Year`

  throws: java.time.DateTimeException - if the addition cannot be made"
  (^java.time.Year [^Year this ^Long amount-to-add ^java.time.temporal.TemporalUnit unit]
    (-> this (.plus amount-to-add unit)))
  (^java.time.Year [^Year this ^java.time.temporal.TemporalAmount amount-to-add]
    (-> this (.plus amount-to-add))))

(defn valid-month-day?
  "Checks if the month-day is valid for this year.

   This method checks whether this year and the input month and day form
   a valid date.

  month-day - the month-day to validate, null returns false - `java.time.MonthDay`

  returns: true if the month and day are valid for this year - `boolean`"
  (^Boolean [^Year this ^java.time.MonthDay month-day]
    (-> this (.isValidMonthDay month-day))))

(defn query
  "Queries this year using the specified query.

   This queries this year using the specified query strategy object.
   The TemporalQuery object defines the logic to be used to
   obtain the result. Read the documentation of the query to understand
   what the result of this method will be.

   The result of this method is obtained by invoking the
   TemporalQuery.queryFrom(TemporalAccessor) method on the
   specified query passing this as the argument.

  query - the query to invoke, not null - `java.time.temporal.TemporalQuery`

  returns: the query result, null may be returned (defined by the query) - `<R> R`

  throws: java.time.DateTimeException - if unable to query (defined by the query)"
  ([^Year this ^java.time.temporal.TemporalQuery query]
    (-> this (.query query))))

(defn leap?
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
  (^Boolean [^Year this]
    (-> this (.isLeap))))

(defn to-string
  "Outputs this year as a String.

  returns: a string representation of this year, not null - `java.lang.String`"
  (^java.lang.String [^Year this]
    (-> this (.toString))))

(defn before?
  "Checks if this year is before the specified year.

  other - the other year to compare to, not null - `java.time.Year`

  returns: true if this point is before the specified year - `boolean`"
  (^Boolean [^Year this ^java.time.Year other]
    (-> this (.isBefore other))))

(defn minus
  "Returns a copy of this year with the specified amount subtracted.

   This returns a Year, based on this one, with the amount
   in terms of the unit subtracted. If it is not possible to subtract the amount,
   because the unit is not supported or for some other reason, an exception is thrown.

   This method is equivalent to plus(long, TemporalUnit) with the amount negated.
   See that method for a full description of how addition, and thus subtraction, works.

   This instance is immutable and unaffected by this method call.

  amount-to-subtract - the amount of the unit to subtract from the result, may be negative - `long`
  unit - the unit of the amount to subtract, not null - `java.time.temporal.TemporalUnit`

  returns: a Year based on this year with the specified amount subtracted, not null - `java.time.Year`

  throws: java.time.DateTimeException - if the subtraction cannot be made"
  (^java.time.Year [^Year this ^Long amount-to-subtract ^java.time.temporal.TemporalUnit unit]
    (-> this (.minus amount-to-subtract unit)))
  (^java.time.Year [^Year this ^java.time.temporal.TemporalAmount amount-to-subtract]
    (-> this (.minus amount-to-subtract))))

(defn at-month-day
  "Combines this year with a month-day to create a LocalDate.

   This returns a LocalDate formed from this year and the specified month-day.

   A month-day of February 29th will be adjusted to February 28th in the resulting
   date if the year is not a leap year.

  month-day - the month-day to use, not null - `java.time.MonthDay`

  returns: the local date formed from this year and the specified month-day, not null - `java.time.LocalDate`"
  (^java.time.LocalDate [^Year this ^java.time.MonthDay month-day]
    (-> this (.atMonthDay month-day))))

(defn get-value
  "Gets the year value.

   The year returned by this method is proleptic as per get(YEAR).

  returns: the year, MIN_VALUE to MAX_VALUE - `int`"
  (^Integer [^Year this]
    (-> this (.getValue))))

(defn get-long
  "Gets the value of the specified field from this year as a long.

   This queries this year for the value of the specified field.
   If it is not possible to return the value, because the field is not supported
   or for some other reason, an exception is thrown.

   If the field is a ChronoField then the query is implemented here.
   The supported fields will return valid
   values based on this year.
   All other ChronoField instances will throw an UnsupportedTemporalTypeException.

   If the field is not a ChronoField, then the result of this method
   is obtained by invoking TemporalField.getFrom(TemporalAccessor)
   passing this as the argument. Whether the value can be obtained,
   and what the value represents, is determined by the field.

  field - the field to get, not null - `java.time.temporal.TemporalField`

  returns: the value for the field - `long`

  throws: java.time.DateTimeException - if a value for the field cannot be obtained"
  (^Long [^Year this ^java.time.temporal.TemporalField field]
    (-> this (.getLong field))))

(defn at-month
  "Combines this year with a month to create a YearMonth.

   This returns a YearMonth formed from this year and the specified month.
   All possible combinations of year and month are valid.

   This method can be used as part of a chain to produce a date:


    LocalDate date = year.atMonth(month).atDay(day);

  month - the month-of-year to use, not null - `java.time.Month`

  returns: the year-month formed from this year and the specified month, not null - `java.time.YearMonth`"
  (^java.time.YearMonth [^Year this ^java.time.Month month]
    (-> this (.atMonth month))))

(defn until
  "Calculates the amount of time until another year in terms of the specified unit.

   This calculates the amount of time between two Year
   objects in terms of a single TemporalUnit.
   The start and end points are this and the specified year.
   The result will be negative if the end is before the start.
   The Temporal passed to this method is converted to a
   Year using from(TemporalAccessor).
   For example, the amount in decades between two year can be calculated
   using startYear.until(endYear, DECADES).

   The calculation returns a whole number, representing the number of
   complete units between the two years.
   For example, the amount in decades between 2012 and 2031
   will only be one decade as it is one year short of two decades.

   There are two equivalent ways of using this method.
   The first is to invoke this method.
   The second is to use TemporalUnit.between(Temporal, Temporal):


     // these two lines are equivalent
     amount = start.until(end, YEARS);
     amount = YEARS.between(start, end);
   The choice should be made based on which makes the code more readable.

   The calculation is implemented in this method for ChronoUnit.
   The units YEARS, DECADES, CENTURIES,
   MILLENNIA and ERAS are supported.
   Other ChronoUnit values will throw an exception.

   If the unit is not a ChronoUnit, then the result of this method
   is obtained by invoking TemporalUnit.between(Temporal, Temporal)
   passing this as the first argument and the converted input temporal
   as the second argument.

   This instance is immutable and unaffected by this method call.

  end-exclusive - the end date, exclusive, which is converted to a Year, not null - `java.time.temporal.Temporal`
  unit - the unit to measure the amount in, not null - `java.time.temporal.TemporalUnit`

  returns: the amount of time between this year and the end year - `long`

  throws: java.time.DateTimeException - if the amount cannot be calculated, or the end temporal cannot be converted to a Year"
  (^Long [^Year this ^java.time.temporal.Temporal end-exclusive ^java.time.temporal.TemporalUnit unit]
    (-> this (.until end-exclusive unit))))

(defn length
  "Gets the length of this year in days.

  returns: the length of this year in days, 365 or 366 - `int`"
  (^Integer [^Year this]
    (-> this (.length))))

(defn after?
  "Checks if this year is after the specified year.

  other - the other year to compare to, not null - `java.time.Year`

  returns: true if this is after the specified year - `boolean`"
  (^Boolean [^Year this ^java.time.Year other]
    (-> this (.isAfter other))))

(defn supported?
  "Checks if the specified field is supported.

   This checks if this year can be queried for the specified field.
   If false, then calling the range,
   get and with(TemporalField, long)
   methods will throw an exception.

   If the field is a ChronoField then the query is implemented here.
   The supported fields are:

   YEAR_OF_ERA
   YEAR
   ERA

   All other ChronoField instances will return false.

   If the field is not a ChronoField, then the result of this method
   is obtained by invoking TemporalField.isSupportedBy(TemporalAccessor)
   passing this as the argument.
   Whether the field is supported is determined by the field.

  field - the field to check, null returns false - `java.time.temporal.TemporalField`

  returns: true if the field is supported on this year, false if not - `boolean`"
  (^Boolean [^Year this ^java.time.temporal.TemporalField field]
    (-> this (.isSupported field))))

(defn minus-years
  "Returns a copy of this Year with the specified number of years subtracted.

   This instance is immutable and unaffected by this method call.

  years-to-subtract - the years to subtract, may be negative - `long`

  returns: a Year based on this year with the year subtracted, not null - `java.time.Year`

  throws: java.time.DateTimeException - if the result exceeds the supported range"
  (^java.time.Year [^Year this ^Long years-to-subtract]
    (-> this (.minusYears years-to-subtract))))

(defn hash-code
  "A hash code for this year.

  returns: a suitable hash code - `int`"
  (^Integer [^Year this]
    (-> this (.hashCode))))

(defn adjust-into
  "Adjusts the specified temporal object to have this year.

   This returns a temporal object of the same observable type as the input
   with the year changed to be the same as this.

   The adjustment is equivalent to using Temporal.with(TemporalField, long)
   passing ChronoField.YEAR as the field.
   If the specified temporal object does not use the ISO calendar system then
   a DateTimeException is thrown.

   In most cases, it is clearer to reverse the calling pattern by using
   Temporal.with(TemporalAdjuster):


     // these two lines are equivalent, but the second approach is recommended
     temporal = thisYear.adjustInto(temporal);
     temporal = temporal.with(thisYear);

   This instance is immutable and unaffected by this method call.

  temporal - the target object to be adjusted, not null - `java.time.temporal.Temporal`

  returns: the adjusted object, not null - `java.time.temporal.Temporal`

  throws: java.time.DateTimeException - if unable to make the adjustment"
  (^java.time.temporal.Temporal [^Year this ^java.time.temporal.Temporal temporal]
    (-> this (.adjustInto temporal))))

(defn with
  "Returns a copy of this year with the specified field set to a new value.

   This returns a Year, based on this one, with the value
   for the specified field changed.
   If it is not possible to set the value, because the field is not supported or for
   some other reason, an exception is thrown.

   If the field is a ChronoField then the adjustment is implemented here.
   The supported fields behave as follows:

   YEAR_OF_ERA -
    Returns a Year with the specified year-of-era
    The era will be unchanged.
   YEAR -
    Returns a Year with the specified year.
    This completely replaces the date and is equivalent to of(int).
   ERA -
    Returns a Year with the specified era.
    The year-of-era will be unchanged.


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

  returns: a Year based on this with the specified field set, not null - `java.time.Year`

  throws: java.time.DateTimeException - if the field cannot be set"
  (^java.time.Year [^Year this ^java.time.temporal.TemporalField field ^Long new-value]
    (-> this (.with field new-value)))
  (^java.time.Year [^Year this ^java.time.temporal.TemporalAdjuster adjuster]
    (-> this (.with adjuster))))

(defn compare-to
  "Compares this year to another year.

   The comparison is based on the value of the year.
   It is `consistent with equals`, as defined by Comparable.

  other - the other year to compare to, not null - `java.time.Year`

  returns: the comparator value, negative if less, positive if greater - `int`"
  (^Integer [^Year this ^java.time.Year other]
    (-> this (.compareTo other))))

(defn get
  "Gets the value of the specified field from this year as an int.

   This queries this year for the value of the specified field.
   The returned value will always be within the valid range of values for the field.
   If it is not possible to return the value, because the field is not supported
   or for some other reason, an exception is thrown.

   If the field is a ChronoField then the query is implemented here.
   The supported fields will return valid
   values based on this year.
   All other ChronoField instances will throw an UnsupportedTemporalTypeException.

   If the field is not a ChronoField, then the result of this method
   is obtained by invoking TemporalField.getFrom(TemporalAccessor)
   passing this as the argument. Whether the value can be obtained,
   and what the value represents, is determined by the field.

  field - the field to get, not null - `java.time.temporal.TemporalField`

  returns: the value for the field - `int`

  throws: java.time.DateTimeException - if a value for the field cannot be obtained or the value is outside the range of valid values for the field"
  (^Integer [^Year this ^java.time.temporal.TemporalField field]
    (-> this (.get field))))

(defn equals
  "Checks if this year is equal to another year.

   The comparison is based on the time-line position of the years.

  obj - the object to check, null returns false - `java.lang.Object`

  returns: true if this is equal to the other year - `boolean`"
  (^Boolean [^Year this ^java.lang.Object obj]
    (-> this (.equals obj))))

(defn format
  "Formats this year using the specified formatter.

   This year will be passed to the formatter to produce a string.

  formatter - the formatter to use, not null - `java.time.format.DateTimeFormatter`

  returns: the formatted year string, not null - `java.lang.String`

  throws: java.time.DateTimeException - if an error occurs during printing"
  (^java.lang.String [^Year this ^java.time.format.DateTimeFormatter formatter]
    (-> this (.format formatter))))

(defn plus-years
  "Returns a copy of this Year with the specified number of years added.

   This instance is immutable and unaffected by this method call.

  years-to-add - the years to add, may be negative - `long`

  returns: a Year based on this year with the years added, not null - `java.time.Year`

  throws: java.time.DateTimeException - if the result exceeds the supported range"
  (^java.time.Year [^Year this ^Long years-to-add]
    (-> this (.plusYears years-to-add))))

