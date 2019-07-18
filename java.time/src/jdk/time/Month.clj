(ns jdk.time.Month
  (:refer-clojure :only [require comment defn ->])
  (:import [java.time Month]))

(def JANUARY
  "Enum Constant.

  The singleton instance for the month of January with 31 days.
   This has the numeric value of 1.

  type: java.time.Month"
  Month/JANUARY)

(def FEBRUARY
  "Enum Constant.

  The singleton instance for the month of February with 28 days, or 29 in a leap year.
   This has the numeric value of 2.

  type: java.time.Month"
  Month/FEBRUARY)

(def MARCH
  "Enum Constant.

  The singleton instance for the month of March with 31 days.
   This has the numeric value of 3.

  type: java.time.Month"
  Month/MARCH)

(def APRIL
  "Enum Constant.

  The singleton instance for the month of April with 30 days.
   This has the numeric value of 4.

  type: java.time.Month"
  Month/APRIL)

(def MAY
  "Enum Constant.

  The singleton instance for the month of May with 31 days.
   This has the numeric value of 5.

  type: java.time.Month"
  Month/MAY)

(def JUNE
  "Enum Constant.

  The singleton instance for the month of June with 30 days.
   This has the numeric value of 6.

  type: java.time.Month"
  Month/JUNE)

(def JULY
  "Enum Constant.

  The singleton instance for the month of July with 31 days.
   This has the numeric value of 7.

  type: java.time.Month"
  Month/JULY)

(def AUGUST
  "Enum Constant.

  The singleton instance for the month of August with 31 days.
   This has the numeric value of 8.

  type: java.time.Month"
  Month/AUGUST)

(def SEPTEMBER
  "Enum Constant.

  The singleton instance for the month of September with 30 days.
   This has the numeric value of 9.

  type: java.time.Month"
  Month/SEPTEMBER)

(def OCTOBER
  "Enum Constant.

  The singleton instance for the month of October with 31 days.
   This has the numeric value of 10.

  type: java.time.Month"
  Month/OCTOBER)

(def NOVEMBER
  "Enum Constant.

  The singleton instance for the month of November with 30 days.
   This has the numeric value of 11.

  type: java.time.Month"
  Month/NOVEMBER)

(def DECEMBER
  "Enum Constant.

  The singleton instance for the month of December with 31 days.
   This has the numeric value of 12.

  type: java.time.Month"
  Month/DECEMBER)

(defn *values
  "Returns an array containing the constants of this enum type, in
  the order they are declared.  This method may be used to iterate
  over the constants as follows:


  for (Month c : Month.values())
      System.out.println(c);

  returns: an array containing the constants of this enum type, in the order they are declared - `java.time.Month[]`"
  ([]
    (Month/values )))

(defn *value-of
  "Returns the enum constant of this type with the specified name.
  The string must match exactly an identifier used to declare an
  enum constant in this type.  (Extraneous whitespace characters are
  not permitted.)

  name - the name of the enum constant to be returned. - `java.lang.String`

  returns: the enum constant with the specified name - `java.time.Month`

  throws: java.lang.IllegalArgumentException - if this enum type has no constant with the specified name"
  (^java.time.Month [^java.lang.String name]
    (Month/valueOf name)))

(defn *of
  "Obtains an instance of Month from an int value.

   Month is an enum representing the 12 months of the year.
   This factory allows the enum to be obtained from the int value.
   The int value follows the ISO-8601 standard, from 1 (January) to 12 (December).

  month - the month-of-year to represent, from 1 (January) to 12 (December) - `int`

  returns: the month-of-year, not null - `java.time.Month`

  throws: java.time.DateTimeException - if the month-of-year is invalid"
  (^java.time.Month [^Integer month]
    (Month/of month)))

(defn *from
  "Obtains an instance of Month from a temporal object.

   This obtains a month based on the specified temporal.
   A TemporalAccessor represents an arbitrary set of date and time information,
   which this factory converts to an instance of Month.

   The conversion extracts the MONTH_OF_YEAR field.
   The extraction is only permitted if the temporal object has an ISO
   chronology, or can be converted to a LocalDate.

   This method matches the signature of the functional interface TemporalQuery
   allowing it to be used as a query via method reference, Month::from.

  temporal - the temporal object to convert, not null - `java.time.temporal.TemporalAccessor`

  returns: the month-of-year, not null - `java.time.Month`

  throws: java.time.DateTimeException - if unable to convert to a Month"
  (^java.time.Month [^java.time.temporal.TemporalAccessor temporal]
    (Month/from temporal)))

(defn range
  "Gets the range of valid values for the specified field.

   The range object expresses the minimum and maximum valid values for a field.
   This month is used to enhance the accuracy of the returned range.
   If it is not possible to return the range, because the field is not supported
   or for some other reason, an exception is thrown.

   If the field is MONTH_OF_YEAR then the
   range of the month-of-year, from 1 to 12, will be returned.
   All other ChronoField instances will throw an UnsupportedTemporalTypeException.

   If the field is not a ChronoField, then the result of this method
   is obtained by invoking TemporalField.rangeRefinedBy(TemporalAccessor)
   passing this as the argument.
   Whether the range can be obtained is determined by the field.

  field - the field to query the range for, not null - `java.time.temporal.TemporalField`

  returns: the range of valid values for the field, not null - `java.time.temporal.ValueRange`

  throws: java.time.DateTimeException - if the range for the field cannot be obtained"
  (^java.time.temporal.ValueRange [^Month this ^java.time.temporal.TemporalField field]
    (-> this (.range field))))

(defn first-month-of-quarter
  "Gets the month corresponding to the first month of this quarter.

   The year can be divided into four quarters.
   This method returns the first month of the quarter for the base month.
   January, February and March return January.
   April, May and June return April.
   July, August and September return July.
   October, November and December return October.

  returns: the first month of the quarter corresponding to this month, not null - `java.time.Month`"
  (^java.time.Month [^Month this]
    (-> this (.firstMonthOfQuarter))))

(defn min-length
  "Gets the minimum length of this month in days.

   February has a minimum length of 28 days.
   April, June, September and November have 30 days.
   All other months have 31 days.

  returns: the minimum length of this month in days, from 28 to 31 - `int`"
  (^Integer [^Month this]
    (-> this (.minLength))))

(defn plus
  "Returns the month-of-year that is the specified number of quarters after this one.

   The calculation rolls around the end of the year from December to January.
   The specified period may be negative.

   This instance is immutable and unaffected by this method call.

  months - the months to add, positive or negative - `long`

  returns: the resulting month, not null - `java.time.Month`"
  (^java.time.Month [^Month this ^Long months]
    (-> this (.plus months))))

(defn query
  "Queries this month-of-year using the specified query.

   This queries this month-of-year using the specified query strategy object.
   The TemporalQuery object defines the logic to be used to
   obtain the result. Read the documentation of the query to understand
   what the result of this method will be.

   The result of this method is obtained by invoking the
   TemporalQuery.queryFrom(TemporalAccessor) method on the
   specified query passing this as the argument.

  query - the query to invoke, not null - `java.time.temporal.TemporalQuery`

  returns: the query result, null may be returned (defined by the query) - `<R> R`

  throws: java.time.DateTimeException - if unable to query (defined by the query)"
  ([^Month this ^java.time.temporal.TemporalQuery query]
    (-> this (.query query))))

(defn first-day-of-year
  "Gets the day-of-year corresponding to the first day of this month.

   This returns the day-of-year that this month begins on, using the leap
   year flag to determine the length of February.

  leap-year - true if the length is required for a leap year - `boolean`

  returns: the day of year corresponding to the first day of this month, from 1 to 336 - `int`"
  (^Integer [^Month this ^Boolean leap-year]
    (-> this (.firstDayOfYear leap-year))))

(defn minus
  "Returns the month-of-year that is the specified number of months before this one.

   The calculation rolls around the start of the year from January to December.
   The specified period may be negative.

   This instance is immutable and unaffected by this method call.

  months - the months to subtract, positive or negative - `long`

  returns: the resulting month, not null - `java.time.Month`"
  (^java.time.Month [^Month this ^Long months]
    (-> this (.minus months))))

(defn get-display-name
  "Gets the textual representation, such as 'Jan' or 'December'.

   This returns the textual name used to identify the month-of-year,
   suitable for presentation to the user.
   The parameters control the style of the returned text and the locale.

   If no textual mapping is found then the numeric value is returned.

  style - the length of the text required, not null - `java.time.format.TextStyle`
  locale - the locale to use, not null - `java.util.Locale`

  returns: the text value of the month-of-year, not null - `java.lang.String`"
  (^java.lang.String [^Month this ^java.time.format.TextStyle style ^java.util.Locale locale]
    (-> this (.getDisplayName style locale))))

(defn get-value
  "Gets the month-of-year int value.

   The values are numbered following the ISO-8601 standard,
   from 1 (January) to 12 (December).

  returns: the month-of-year, from 1 (January) to 12 (December) - `int`"
  (^Integer [^Month this]
    (-> this (.getValue))))

(defn max-length
  "Gets the maximum length of this month in days.

   February has a maximum length of 29 days.
   April, June, September and November have 30 days.
   All other months have 31 days.

  returns: the maximum length of this month in days, from 29 to 31 - `int`"
  (^Integer [^Month this]
    (-> this (.maxLength))))

(defn get-long
  "Gets the value of the specified field from this month-of-year as a long.

   This queries this month for the value of the specified field.
   If it is not possible to return the value, because the field is not supported
   or for some other reason, an exception is thrown.

   If the field is MONTH_OF_YEAR then the
   value of the month-of-year, from 1 to 12, will be returned.
   All other ChronoField instances will throw an UnsupportedTemporalTypeException.

   If the field is not a ChronoField, then the result of this method
   is obtained by invoking TemporalField.getFrom(TemporalAccessor)
   passing this as the argument. Whether the value can be obtained,
   and what the value represents, is determined by the field.

  field - the field to get, not null - `java.time.temporal.TemporalField`

  returns: the value for the field - `long`

  throws: java.time.DateTimeException - if a value for the field cannot be obtained"
  (^Long [^Month this ^java.time.temporal.TemporalField field]
    (-> this (.getLong field))))

(defn length
  "Gets the length of this month in days.

   This takes a flag to determine whether to return the length for a leap year or not.

   February has 28 days in a standard year and 29 days in a leap year.
   April, June, September and November have 30 days.
   All other months have 31 days.

  leap-year - true if the length is required for a leap year - `boolean`

  returns: the length of this month in days, from 28 to 31 - `int`"
  (^Integer [^Month this ^Boolean leap-year]
    (-> this (.length leap-year))))

(defn supported?
  "Checks if the specified field is supported.

   This checks if this month-of-year can be queried for the specified field.
   If false, then calling the range and
   get methods will throw an exception.

   If the field is MONTH_OF_YEAR then
   this method returns true.
   All other ChronoField instances will return false.

   If the field is not a ChronoField, then the result of this method
   is obtained by invoking TemporalField.isSupportedBy(TemporalAccessor)
   passing this as the argument.
   Whether the field is supported is determined by the field.

  field - the field to check, null returns false - `java.time.temporal.TemporalField`

  returns: true if the field is supported on this month-of-year, false if not - `boolean`"
  (^Boolean [^Month this ^java.time.temporal.TemporalField field]
    (-> this (.isSupported field))))

(defn adjust-into
  "Adjusts the specified temporal object to have this month-of-year.

   This returns a temporal object of the same observable type as the input
   with the month-of-year changed to be the same as this.

   The adjustment is equivalent to using Temporal.with(TemporalField, long)
   passing ChronoField.MONTH_OF_YEAR as the field.
   If the specified temporal object does not use the ISO calendar system then
   a DateTimeException is thrown.

   In most cases, it is clearer to reverse the calling pattern by using
   Temporal.with(TemporalAdjuster):


     // these two lines are equivalent, but the second approach is recommended
     temporal = thisMonth.adjustInto(temporal);
     temporal = temporal.with(thisMonth);

   For example, given a date in May, the following are output:


     dateInMay.with(JANUARY);    // four months earlier
     dateInMay.with(APRIL);      // one months earlier
     dateInMay.with(MAY);        // same date
     dateInMay.with(JUNE);       // one month later
     dateInMay.with(DECEMBER);   // seven months later

   This instance is immutable and unaffected by this method call.

  temporal - the target object to be adjusted, not null - `java.time.temporal.Temporal`

  returns: the adjusted object, not null - `java.time.temporal.Temporal`

  throws: java.time.DateTimeException - if unable to make the adjustment"
  (^java.time.temporal.Temporal [^Month this ^java.time.temporal.Temporal temporal]
    (-> this (.adjustInto temporal))))

(defn get
  "Gets the value of the specified field from this month-of-year as an int.

   This queries this month for the value of the specified field.
   The returned value will always be within the valid range of values for the field.
   If it is not possible to return the value, because the field is not supported
   or for some other reason, an exception is thrown.

   If the field is MONTH_OF_YEAR then the
   value of the month-of-year, from 1 to 12, will be returned.
   All other ChronoField instances will throw an UnsupportedTemporalTypeException.

   If the field is not a ChronoField, then the result of this method
   is obtained by invoking TemporalField.getFrom(TemporalAccessor)
   passing this as the argument. Whether the value can be obtained,
   and what the value represents, is determined by the field.

  field - the field to get, not null - `java.time.temporal.TemporalField`

  returns: the value for the field, within the valid range of values - `int`

  throws: java.time.DateTimeException - if a value for the field cannot be obtained or the value is outside the range of valid values for the field"
  (^Integer [^Month this ^java.time.temporal.TemporalField field]
    (-> this (.get field))))

