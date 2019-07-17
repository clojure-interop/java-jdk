(ns jdk.time.DayOfWeek
  (:refer-clojure :only [require comment defn ->])
  (:import [java.time DayOfWeek]))

(def MONDAY
  "Enum Constant.

  The singleton instance for the day-of-week of Monday.
   This has the numeric value of 1.

  type: java.time.DayOfWeek"
  DayOfWeek/MONDAY)

(def TUESDAY
  "Enum Constant.

  The singleton instance for the day-of-week of Tuesday.
   This has the numeric value of 2.

  type: java.time.DayOfWeek"
  DayOfWeek/TUESDAY)

(def WEDNESDAY
  "Enum Constant.

  The singleton instance for the day-of-week of Wednesday.
   This has the numeric value of 3.

  type: java.time.DayOfWeek"
  DayOfWeek/WEDNESDAY)

(def THURSDAY
  "Enum Constant.

  The singleton instance for the day-of-week of Thursday.
   This has the numeric value of 4.

  type: java.time.DayOfWeek"
  DayOfWeek/THURSDAY)

(def FRIDAY
  "Enum Constant.

  The singleton instance for the day-of-week of Friday.
   This has the numeric value of 5.

  type: java.time.DayOfWeek"
  DayOfWeek/FRIDAY)

(def SATURDAY
  "Enum Constant.

  The singleton instance for the day-of-week of Saturday.
   This has the numeric value of 6.

  type: java.time.DayOfWeek"
  DayOfWeek/SATURDAY)

(def SUNDAY
  "Enum Constant.

  The singleton instance for the day-of-week of Sunday.
   This has the numeric value of 7.

  type: java.time.DayOfWeek"
  DayOfWeek/SUNDAY)

(defn *values
  "Returns an array containing the constants of this enum type, in
  the order they are declared.  This method may be used to iterate
  over the constants as follows:


  for (DayOfWeek c : DayOfWeek.values())
      System.out.println(c);

  returns: an array containing the constants of this enum type, in the order they are declared - `java.time.DayOfWeek[]`"
  ([]
    (DayOfWeek/values )))

(defn *value-of
  "Returns the enum constant of this type with the specified name.
  The string must match exactly an identifier used to declare an
  enum constant in this type.  (Extraneous whitespace characters are
  not permitted.)

  name - the name of the enum constant to be returned. - `java.lang.String`

  returns: the enum constant with the specified name - `java.time.DayOfWeek`

  throws: java.lang.IllegalArgumentException - if this enum type has no constant with the specified name"
  (^java.time.DayOfWeek [^java.lang.String name]
    (DayOfWeek/valueOf name)))

(defn *of
  "Obtains an instance of DayOfWeek from an int value.

   DayOfWeek is an enum representing the 7 days of the week.
   This factory allows the enum to be obtained from the int value.
   The int value follows the ISO-8601 standard, from 1 (Monday) to 7 (Sunday).

  day-of-week - the day-of-week to represent, from 1 (Monday) to 7 (Sunday) - `int`

  returns: the day-of-week singleton, not null - `java.time.DayOfWeek`

  throws: java.time.DateTimeException - if the day-of-week is invalid"
  (^java.time.DayOfWeek [^Integer day-of-week]
    (DayOfWeek/of day-of-week)))

(defn *from
  "Obtains an instance of DayOfWeek from a temporal object.

   This obtains a day-of-week based on the specified temporal.
   A TemporalAccessor represents an arbitrary set of date and time information,
   which this factory converts to an instance of DayOfWeek.

   The conversion extracts the DAY_OF_WEEK field.

   This method matches the signature of the functional interface TemporalQuery
   allowing it to be used as a query via method reference, DayOfWeek::from.

  temporal - the temporal object to convert, not null - `java.time.temporal.TemporalAccessor`

  returns: the day-of-week, not null - `java.time.DayOfWeek`

  throws: java.time.DateTimeException - if unable to convert to a DayOfWeek"
  (^java.time.DayOfWeek [^java.time.temporal.TemporalAccessor temporal]
    (DayOfWeek/from temporal)))

(defn range
  "Gets the range of valid values for the specified field.

   The range object expresses the minimum and maximum valid values for a field.
   This day-of-week is used to enhance the accuracy of the returned range.
   If it is not possible to return the range, because the field is not supported
   or for some other reason, an exception is thrown.

   If the field is DAY_OF_WEEK then the
   range of the day-of-week, from 1 to 7, will be returned.
   All other ChronoField instances will throw an UnsupportedTemporalTypeException.

   If the field is not a ChronoField, then the result of this method
   is obtained by invoking TemporalField.rangeRefinedBy(TemporalAccessor)
   passing this as the argument.
   Whether the range can be obtained is determined by the field.

  field - the field to query the range for, not null - `java.time.temporal.TemporalField`

  returns: the range of valid values for the field, not null - `java.time.temporal.ValueRange`

  throws: java.time.DateTimeException - if the range for the field cannot be obtained"
  (^java.time.temporal.ValueRange [^java.time.DayOfWeek this ^java.time.temporal.TemporalField field]
    (-> this (.range field))))

(defn plus
  "Returns the day-of-week that is the specified number of days after this one.

   The calculation rolls around the end of the week from Sunday to Monday.
   The specified period may be negative.

   This instance is immutable and unaffected by this method call.

  days - the days to add, positive or negative - `long`

  returns: the resulting day-of-week, not null - `java.time.DayOfWeek`"
  (^java.time.DayOfWeek [^java.time.DayOfWeek this ^Long days]
    (-> this (.plus days))))

(defn query
  "Queries this day-of-week using the specified query.

   This queries this day-of-week using the specified query strategy object.
   The TemporalQuery object defines the logic to be used to
   obtain the result. Read the documentation of the query to understand
   what the result of this method will be.

   The result of this method is obtained by invoking the
   TemporalQuery.queryFrom(TemporalAccessor) method on the
   specified query passing this as the argument.

  query - the query to invoke, not null - `java.time.temporal.TemporalQuery<R>`

  returns: the query result, null may be returned (defined by the query) - `<R> R`

  throws: java.time.DateTimeException - if unable to query (defined by the query)"
  ([^java.time.DayOfWeek this ^java.time.temporal.TemporalQuery query]
    (-> this (.query query))))

(defn minus
  "Returns the day-of-week that is the specified number of days before this one.

   The calculation rolls around the start of the year from Monday to Sunday.
   The specified period may be negative.

   This instance is immutable and unaffected by this method call.

  days - the days to subtract, positive or negative - `long`

  returns: the resulting day-of-week, not null - `java.time.DayOfWeek`"
  (^java.time.DayOfWeek [^java.time.DayOfWeek this ^Long days]
    (-> this (.minus days))))

(defn get-display-name
  "Gets the textual representation, such as 'Mon' or 'Friday'.

   This returns the textual name used to identify the day-of-week,
   suitable for presentation to the user.
   The parameters control the style of the returned text and the locale.

   If no textual mapping is found then the numeric value is returned.

  style - the length of the text required, not null - `java.time.format.TextStyle`
  locale - the locale to use, not null - `java.util.Locale`

  returns: the text value of the day-of-week, not null - `java.lang.String`"
  (^java.lang.String [^java.time.DayOfWeek this ^java.time.format.TextStyle style ^java.util.Locale locale]
    (-> this (.getDisplayName style locale))))

(defn get-value
  "Gets the day-of-week int value.

   The values are numbered following the ISO-8601 standard, from 1 (Monday) to 7 (Sunday).
   See WeekFields.dayOfWeek() for localized week-numbering.

  returns: the day-of-week, from 1 (Monday) to 7 (Sunday) - `int`"
  (^Integer [^java.time.DayOfWeek this]
    (-> this (.getValue))))

(defn get-long
  "Gets the value of the specified field from this day-of-week as a long.

   This queries this day-of-week for the value of the specified field.
   If it is not possible to return the value, because the field is not supported
   or for some other reason, an exception is thrown.

   If the field is DAY_OF_WEEK then the
   value of the day-of-week, from 1 to 7, will be returned.
   All other ChronoField instances will throw an UnsupportedTemporalTypeException.

   If the field is not a ChronoField, then the result of this method
   is obtained by invoking TemporalField.getFrom(TemporalAccessor)
   passing this as the argument. Whether the value can be obtained,
   and what the value represents, is determined by the field.

  field - the field to get, not null - `java.time.temporal.TemporalField`

  returns: the value for the field - `long`

  throws: java.time.DateTimeException - if a value for the field cannot be obtained"
  (^Long [^java.time.DayOfWeek this ^java.time.temporal.TemporalField field]
    (-> this (.getLong field))))

(defn supported?
  "Checks if the specified field is supported.

   This checks if this day-of-week can be queried for the specified field.
   If false, then calling the range and
   get methods will throw an exception.

   If the field is DAY_OF_WEEK then
   this method returns true.
   All other ChronoField instances will return false.

   If the field is not a ChronoField, then the result of this method
   is obtained by invoking TemporalField.isSupportedBy(TemporalAccessor)
   passing this as the argument.
   Whether the field is supported is determined by the field.

  field - the field to check, null returns false - `java.time.temporal.TemporalField`

  returns: true if the field is supported on this day-of-week, false if not - `boolean`"
  (^Boolean [^java.time.DayOfWeek this ^java.time.temporal.TemporalField field]
    (-> this (.isSupported field))))

(defn adjust-into
  "Adjusts the specified temporal object to have this day-of-week.

   This returns a temporal object of the same observable type as the input
   with the day-of-week changed to be the same as this.

   The adjustment is equivalent to using Temporal.with(TemporalField, long)
   passing ChronoField.DAY_OF_WEEK as the field.
   Note that this adjusts forwards or backwards within a Monday to Sunday week.
   See WeekFields.dayOfWeek() for localized week start days.
   See TemporalAdjuster for other adjusters with more control,
   such as next(MONDAY).

   In most cases, it is clearer to reverse the calling pattern by using
   Temporal.with(TemporalAdjuster):


     // these two lines are equivalent, but the second approach is recommended
     temporal = thisDayOfWeek.adjustInto(temporal);
     temporal = temporal.with(thisDayOfWeek);

   For example, given a date that is a Wednesday, the following are output:


     dateOnWed.with(MONDAY);     // two days earlier
     dateOnWed.with(TUESDAY);    // one day earlier
     dateOnWed.with(WEDNESDAY);  // same date
     dateOnWed.with(THURSDAY);   // one day later
     dateOnWed.with(FRIDAY);     // two days later
     dateOnWed.with(SATURDAY);   // three days later
     dateOnWed.with(SUNDAY);     // four days later

   This instance is immutable and unaffected by this method call.

  temporal - the target object to be adjusted, not null - `java.time.temporal.Temporal`

  returns: the adjusted object, not null - `java.time.temporal.Temporal`

  throws: java.time.DateTimeException - if unable to make the adjustment"
  (^java.time.temporal.Temporal [^java.time.DayOfWeek this ^java.time.temporal.Temporal temporal]
    (-> this (.adjustInto temporal))))

(defn get
  "Gets the value of the specified field from this day-of-week as an int.

   This queries this day-of-week for the value of the specified field.
   The returned value will always be within the valid range of values for the field.
   If it is not possible to return the value, because the field is not supported
   or for some other reason, an exception is thrown.

   If the field is DAY_OF_WEEK then the
   value of the day-of-week, from 1 to 7, will be returned.
   All other ChronoField instances will throw an UnsupportedTemporalTypeException.

   If the field is not a ChronoField, then the result of this method
   is obtained by invoking TemporalField.getFrom(TemporalAccessor)
   passing this as the argument. Whether the value can be obtained,
   and what the value represents, is determined by the field.

  field - the field to get, not null - `java.time.temporal.TemporalField`

  returns: the value for the field, within the valid range of values - `int`

  throws: java.time.DateTimeException - if a value for the field cannot be obtained or the value is outside the range of valid values for the field"
  (^Integer [^java.time.DayOfWeek this ^java.time.temporal.TemporalField field]
    (-> this (.get field))))

