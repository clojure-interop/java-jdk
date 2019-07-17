(ns jdk.time.MonthDay
  "A month-day in the ISO-8601 calendar system, such as --12-03.

  MonthDay is an immutable date-time object that represents the combination
  of a month and day-of-month. Any field that can be derived from a month and day,
  such as quarter-of-year, can be obtained.

  This class does not store or represent a year, time or time-zone.
  For example, the value `December 3rd` can be stored in a MonthDay.

  Since a MonthDay does not possess a year, the leap day of
  February 29th is considered valid.

  This class implements TemporalAccessor rather than Temporal.
  This is because it is not possible to define whether February 29th is valid or not
  without external information, preventing the implementation of plus/minus.
  Related to this, MonthDay only provides access to query and set the fields
  MONTH_OF_YEAR and DAY_OF_MONTH.

  The ISO-8601 calendar system is the modern civil calendar system used today
  in most of the world. It is equivalent to the proleptic Gregorian calendar
  system, in which today's rules for leap years are applied for all time.
  For most applications written today, the ISO-8601 rules are entirely suitable.
  However, any application that makes use of historical dates, and requires them
  to be accurate will find the ISO-8601 approach unsuitable.


  This is a value-based
  class; use of identity-sensitive operations (including reference equality
  (==), identity hash code, or synchronization) on instances of
  MonthDay may have unpredictable results and should be avoided.
  The equals method should be used for comparisons."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.time MonthDay]))

(defn *now
  "Obtains the current month-day from the system clock in the specified time-zone.

   This will query the system clock to obtain the current month-day.
   Specifying the time-zone avoids dependence on the default time-zone.

   Using this method will prevent the ability to use an alternate clock for testing
   because the clock is hard-coded.

  zone - the zone ID to use, not null - `java.time.ZoneId`

  returns: the current month-day using the system clock, not null - `java.time.MonthDay`"
  ([zone]
    (MonthDay/now zone))
  ([]
    (MonthDay/now )))

(defn *of
  "Obtains an instance of MonthDay.

   The day-of-month must be valid for the month within a leap year.
   Hence, for February, day 29 is valid.

   For example, passing in April and day 31 will throw an exception, as
   there can never be April 31st in any year. By contrast, passing in
   February 29th is permitted, as that month-day can sometimes be valid.

  month - the month-of-year to represent, not null - `java.time.Month`
  day-of-month - the day-of-month to represent, from 1 to 31 - `int`

  returns: the month-day, not null - `java.time.MonthDay`

  throws: java.time.DateTimeException - if the value of any field is out of range, or if the day-of-month is invalid for the month"
  ([month day-of-month]
    (MonthDay/of month day-of-month)))

(defn *from
  "Obtains an instance of MonthDay from a temporal object.

   This obtains a month-day based on the specified temporal.
   A TemporalAccessor represents an arbitrary set of date and time information,
   which this factory converts to an instance of MonthDay.

   The conversion extracts the MONTH_OF_YEAR and
   DAY_OF_MONTH fields.
   The extraction is only permitted if the temporal object has an ISO
   chronology, or can be converted to a LocalDate.

   This method matches the signature of the functional interface TemporalQuery
   allowing it to be used as a query via method reference, MonthDay::from.

  temporal - the temporal object to convert, not null - `java.time.temporal.TemporalAccessor`

  returns: the month-day, not null - `java.time.MonthDay`

  throws: java.time.DateTimeException - if unable to convert to a MonthDay"
  ([temporal]
    (MonthDay/from temporal)))

(defn *parse
  "Obtains an instance of MonthDay from a text string using a specific formatter.

   The text is parsed using the formatter, returning a month-day.

  text - the text to parse, not null - `java.lang.CharSequence`
  formatter - the formatter to use, not null - `java.time.format.DateTimeFormatter`

  returns: the parsed month-day, not null - `java.time.MonthDay`

  throws: java.time.format.DateTimeParseException - if the text cannot be parsed"
  ([text formatter]
    (MonthDay/parse text formatter))
  ([text]
    (MonthDay/parse text)))

(defn at-year
  "Combines this month-day with a year to create a LocalDate.

   This returns a LocalDate formed from this month-day and the specified year.

   A month-day of February 29th will be adjusted to February 28th in the resulting
   date if the year is not a leap year.

   This instance is immutable and unaffected by this method call.

  year - the year to use, from MIN_YEAR to MAX_YEAR - `int`

  returns: the local date formed from this month-day and the specified year, not null - `java.time.LocalDate`

  throws: java.time.DateTimeException - if the year is outside the valid range of years"
  ([this year]
    (-> this (.atYear year))))

(defn range
  "Gets the range of valid values for the specified field.

   The range object expresses the minimum and maximum valid values for a field.
   This month-day is used to enhance the accuracy of the returned range.
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
  ([this field]
    (-> this (.range field))))

(defn with-month
  "Returns a copy of this MonthDay with the month-of-year altered.

   This returns a month-day with the specified month.
   If the day-of-month is invalid for the specified month, the day will
   be adjusted to the last valid day-of-month.

   This instance is immutable and unaffected by this method call.

  month - the month-of-year to set in the returned month-day, from 1 (January) to 12 (December) - `int`

  returns: a MonthDay based on this month-day with the requested month, not null - `java.time.MonthDay`

  throws: java.time.DateTimeException - if the month-of-year value is invalid"
  ([this month]
    (-> this (.withMonth month))))

(defn query
  "Queries this month-day using the specified query.

   This queries this month-day using the specified query strategy object.
   The TemporalQuery object defines the logic to be used to
   obtain the result. Read the documentation of the query to understand
   what the result of this method will be.

   The result of this method is obtained by invoking the
   TemporalQuery.queryFrom(TemporalAccessor) method on the
   specified query passing this as the argument.

  query - the query to invoke, not null - `java.time.temporal.TemporalQuery<R>`

  returns: the query result, null may be returned (defined by the query) - `<R> R`

  throws: java.time.DateTimeException - if unable to query (defined by the query)"
  ([this query]
    (-> this (.query query))))

(defn to-string
  "Outputs this month-day as a String, such as --12-03.

   The output will be in the format --MM-dd:

  returns: a string representation of this month-day, not null - `java.lang.String`"
  ([this]
    (-> this (.toString))))

(defn before?
  "Checks if this month-day is before the specified month-day.

  other - the other month-day to compare to, not null - `java.time.MonthDay`

  returns: true if this point is before the specified month-day - `boolean`"
  ([this other]
    (-> this (.isBefore other))))

(defn get-long
  "Gets the value of the specified field from this month-day as a long.

   This queries this month-day for the value of the specified field.
   If it is not possible to return the value, because the field is not supported
   or for some other reason, an exception is thrown.

   If the field is a ChronoField then the query is implemented here.
   The supported fields will return valid
   values based on this month-day.
   All other ChronoField instances will throw an UnsupportedTemporalTypeException.

   If the field is not a ChronoField, then the result of this method
   is obtained by invoking TemporalField.getFrom(TemporalAccessor)
   passing this as the argument. Whether the value can be obtained,
   and what the value represents, is determined by the field.

  field - the field to get, not null - `java.time.temporal.TemporalField`

  returns: the value for the field - `long`

  throws: java.time.DateTimeException - if a value for the field cannot be obtained"
  ([this field]
    (-> this (.getLong field))))

(defn with-day-of-month
  "Returns a copy of this MonthDay with the day-of-month altered.

   This returns a month-day with the specified day-of-month.
   If the day-of-month is invalid for the month, an exception is thrown.

   This instance is immutable and unaffected by this method call.

  day-of-month - the day-of-month to set in the return month-day, from 1 to 31 - `int`

  returns: a MonthDay based on this month-day with the requested day, not null - `java.time.MonthDay`

  throws: java.time.DateTimeException - if the day-of-month value is invalid, or if the day-of-month is invalid for the month"
  ([this day-of-month]
    (-> this (.withDayOfMonth day-of-month))))

(defn get-day-of-month
  "Gets the day-of-month field.

   This method returns the primitive int value for the day-of-month.

  returns: the day-of-month, from 1 to 31 - `int`"
  ([this]
    (-> this (.getDayOfMonth))))

(defn after?
  "Checks if this month-day is after the specified month-day.

  other - the other month-day to compare to, not null - `java.time.MonthDay`

  returns: true if this is after the specified month-day - `boolean`"
  ([this other]
    (-> this (.isAfter other))))

(defn supported?
  "Checks if the specified field is supported.

   This checks if this month-day can be queried for the specified field.
   If false, then calling the range and
   get methods will throw an exception.

   If the field is a ChronoField then the query is implemented here.
   The supported fields are:

   MONTH_OF_YEAR
   YEAR

   All other ChronoField instances will return false.

   If the field is not a ChronoField, then the result of this method
   is obtained by invoking TemporalField.isSupportedBy(TemporalAccessor)
   passing this as the argument.
   Whether the field is supported is determined by the field.

  field - the field to check, null returns false - `java.time.temporal.TemporalField`

  returns: true if the field is supported on this month-day, false if not - `boolean`"
  ([this field]
    (-> this (.isSupported field))))

(defn valid-year?
  "Checks if the year is valid for this month-day.

   This method checks whether this month and day and the input year form
   a valid date. This can only return false for February 29th.

  year - the year to validate - `int`

  returns: true if the year is valid for this month-day - `boolean`"
  ([this year]
    (-> this (.isValidYear year))))

(defn hash-code
  "A hash code for this month-day.

  returns: a suitable hash code - `int`"
  ([this]
    (-> this (.hashCode))))

(defn adjust-into
  "Adjusts the specified temporal object to have this month-day.

   This returns a temporal object of the same observable type as the input
   with the month and day-of-month changed to be the same as this.

   The adjustment is equivalent to using Temporal.with(TemporalField, long)
   twice, passing ChronoField.MONTH_OF_YEAR and
   ChronoField.DAY_OF_MONTH as the fields.
   If the specified temporal object does not use the ISO calendar system then
   a DateTimeException is thrown.

   In most cases, it is clearer to reverse the calling pattern by using
   Temporal.with(TemporalAdjuster):


     // these two lines are equivalent, but the second approach is recommended
     temporal = thisMonthDay.adjustInto(temporal);
     temporal = temporal.with(thisMonthDay);

   This instance is immutable and unaffected by this method call.

  temporal - the target object to be adjusted, not null - `java.time.temporal.Temporal`

  returns: the adjusted object, not null - `java.time.temporal.Temporal`

  throws: java.time.DateTimeException - if unable to make the adjustment"
  ([this temporal]
    (-> this (.adjustInto temporal))))

(defn with
  "Returns a copy of this MonthDay with the month-of-year altered.

   This returns a month-day with the specified month.
   If the day-of-month is invalid for the specified month, the day will
   be adjusted to the last valid day-of-month.

   This instance is immutable and unaffected by this method call.

  month - the month-of-year to set in the returned month-day, not null - `java.time.Month`

  returns: a MonthDay based on this month-day with the requested month, not null - `java.time.MonthDay`"
  ([this month]
    (-> this (.with month))))

(defn get-month-value
  "Gets the month-of-year field from 1 to 12.

   This method returns the month as an int from 1 to 12.
   Application code is frequently clearer if the enum Month
   is used by calling getMonth().

  returns: the month-of-year, from 1 to 12 - `int`"
  ([this]
    (-> this (.getMonthValue))))

(defn compare-to
  "Compares this month-day to another month-day.

   The comparison is based first on value of the month, then on the value of the day.
   It is `consistent with equals`, as defined by Comparable.

  other - the other month-day to compare to, not null - `java.time.MonthDay`

  returns: the comparator value, negative if less, positive if greater - `int`"
  ([this other]
    (-> this (.compareTo other))))

(defn get-month
  "Gets the month-of-year field using the Month enum.

   This method returns the enum Month for the month.
   This avoids confusion as to what int values mean.
   If you need access to the primitive int value then the enum
   provides the int value.

  returns: the month-of-year, not null - `java.time.Month`"
  ([this]
    (-> this (.getMonth))))

(defn get
  "Gets the value of the specified field from this month-day as an int.

   This queries this month-day for the value of the specified field.
   The returned value will always be within the valid range of values for the field.
   If it is not possible to return the value, because the field is not supported
   or for some other reason, an exception is thrown.

   If the field is a ChronoField then the query is implemented here.
   The supported fields will return valid
   values based on this month-day.
   All other ChronoField instances will throw an UnsupportedTemporalTypeException.

   If the field is not a ChronoField, then the result of this method
   is obtained by invoking TemporalField.getFrom(TemporalAccessor)
   passing this as the argument. Whether the value can be obtained,
   and what the value represents, is determined by the field.

  field - the field to get, not null - `java.time.temporal.TemporalField`

  returns: the value for the field - `int`

  throws: java.time.DateTimeException - if a value for the field cannot be obtained or the value is outside the range of valid values for the field"
  ([this field]
    (-> this (.get field))))

(defn equals
  "Checks if this month-day is equal to another month-day.

   The comparison is based on the time-line position of the month-day within a year.

  obj - the object to check, null returns false - `java.lang.Object`

  returns: true if this is equal to the other month-day - `boolean`"
  ([this obj]
    (-> this (.equals obj))))

(defn format
  "Formats this month-day using the specified formatter.

   This month-day will be passed to the formatter to produce a string.

  formatter - the formatter to use, not null - `java.time.format.DateTimeFormatter`

  returns: the formatted month-day string, not null - `java.lang.String`

  throws: java.time.DateTimeException - if an error occurs during printing"
  ([this formatter]
    (-> this (.format formatter))))

