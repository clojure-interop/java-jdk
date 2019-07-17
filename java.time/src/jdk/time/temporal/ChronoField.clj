(ns jdk.time.temporal.ChronoField
  (:refer-clojure :only [require comment defn ->])
  (:import [java.time.temporal ChronoField]))

(def NANO_OF_SECOND
  "Enum Constant.

  The nano-of-second.

   This counts the nanosecond within the second, from 0 to 999,999,999.
   This field has the same meaning for all calendar systems.

   This field is used to represent the nano-of-second handling any fraction of the second.
   Implementations of TemporalAccessor should provide a value for this field if
   they can return a value for SECOND_OF_MINUTE, SECOND_OF_DAY or
   INSTANT_SECONDS filling unknown precision with zero.

   When this field is used for setting a value, it should set as much precision as the
   object stores, using integer division to remove excess precision.
   For example, if the TemporalAccessor stores time to millisecond precision,
   then the nano-of-second must be divided by 1,000,000 before replacing the milli-of-second.

   When parsing this field it behaves equivalent to the following:
   The value is validated in strict and smart mode but not in lenient mode.
   The field is resolved in combination with MILLI_OF_SECOND and MICRO_OF_SECOND.

  type: java.time.temporal.ChronoField"
  ChronoField/NANO_OF_SECOND)

(def NANO_OF_DAY
  "Enum Constant.

  The nano-of-day.

   This counts the nanosecond within the day, from 0 to (24 * 60 * 60 * 1,000,000,000) - 1.
   This field has the same meaning for all calendar systems.

   This field is used to represent the nano-of-day handling any fraction of the second.
   Implementations of TemporalAccessor should provide a value for this field if
   they can return a value for SECOND_OF_DAY filling unknown precision with zero.

   When parsing this field it behaves equivalent to the following:
   The value is validated in strict and smart mode but not in lenient mode.
   The value is split to form NANO_OF_SECOND, SECOND_OF_MINUTE,
   MINUTE_OF_HOUR and HOUR_OF_DAY fields.

  type: java.time.temporal.ChronoField"
  ChronoField/NANO_OF_DAY)

(def MICRO_OF_SECOND
  "Enum Constant.

  The micro-of-second.

   This counts the microsecond within the second, from 0 to 999,999.
   This field has the same meaning for all calendar systems.

   This field is used to represent the micro-of-second handling any fraction of the second.
   Implementations of TemporalAccessor should provide a value for this field if
   they can return a value for SECOND_OF_MINUTE, SECOND_OF_DAY or
   INSTANT_SECONDS filling unknown precision with zero.

   When this field is used for setting a value, it should behave in the same way as
   setting NANO_OF_SECOND with the value multiplied by 1,000.

   When parsing this field it behaves equivalent to the following:
   The value is validated in strict and smart mode but not in lenient mode.
   The field is resolved in combination with MILLI_OF_SECOND to produce
   NANO_OF_SECOND.

  type: java.time.temporal.ChronoField"
  ChronoField/MICRO_OF_SECOND)

(def MICRO_OF_DAY
  "Enum Constant.

  The micro-of-day.

   This counts the microsecond within the day, from 0 to (24 * 60 * 60 * 1,000,000) - 1.
   This field has the same meaning for all calendar systems.

   This field is used to represent the micro-of-day handling any fraction of the second.
   Implementations of TemporalAccessor should provide a value for this field if
   they can return a value for SECOND_OF_DAY filling unknown precision with zero.

   When this field is used for setting a value, it should behave in the same way as
   setting NANO_OF_DAY with the value multiplied by 1,000.

   When parsing this field it behaves equivalent to the following:
   The value is validated in strict and smart mode but not in lenient mode.
   The value is split to form MICRO_OF_SECOND, SECOND_OF_MINUTE,
   MINUTE_OF_HOUR and HOUR_OF_DAY fields.

  type: java.time.temporal.ChronoField"
  ChronoField/MICRO_OF_DAY)

(def MILLI_OF_SECOND
  "Enum Constant.

  The milli-of-second.

   This counts the millisecond within the second, from 0 to 999.
   This field has the same meaning for all calendar systems.

   This field is used to represent the milli-of-second handling any fraction of the second.
   Implementations of TemporalAccessor should provide a value for this field if
   they can return a value for SECOND_OF_MINUTE, SECOND_OF_DAY or
   INSTANT_SECONDS filling unknown precision with zero.

   When this field is used for setting a value, it should behave in the same way as
   setting NANO_OF_SECOND with the value multiplied by 1,000,000.

   When parsing this field it behaves equivalent to the following:
   The value is validated in strict and smart mode but not in lenient mode.
   The field is resolved in combination with MICRO_OF_SECOND to produce
   NANO_OF_SECOND.

  type: java.time.temporal.ChronoField"
  ChronoField/MILLI_OF_SECOND)

(def MILLI_OF_DAY
  "Enum Constant.

  The milli-of-day.

   This counts the millisecond within the day, from 0 to (24 * 60 * 60 * 1,000) - 1.
   This field has the same meaning for all calendar systems.

   This field is used to represent the milli-of-day handling any fraction of the second.
   Implementations of TemporalAccessor should provide a value for this field if
   they can return a value for SECOND_OF_DAY filling unknown precision with zero.

   When this field is used for setting a value, it should behave in the same way as
   setting NANO_OF_DAY with the value multiplied by 1,000,000.

   When parsing this field it behaves equivalent to the following:
   The value is validated in strict and smart mode but not in lenient mode.
   The value is split to form MILLI_OF_SECOND, SECOND_OF_MINUTE,
   MINUTE_OF_HOUR and HOUR_OF_DAY fields.

  type: java.time.temporal.ChronoField"
  ChronoField/MILLI_OF_DAY)

(def SECOND_OF_MINUTE
  "Enum Constant.

  The second-of-minute.

   This counts the second within the minute, from 0 to 59.
   This field has the same meaning for all calendar systems.

   When parsing this field it behaves equivalent to the following:
   The value is validated in strict and smart mode but not in lenient mode.

  type: java.time.temporal.ChronoField"
  ChronoField/SECOND_OF_MINUTE)

(def SECOND_OF_DAY
  "Enum Constant.

  The second-of-day.

   This counts the second within the day, from 0 to (24 * 60 * 60) - 1.
   This field has the same meaning for all calendar systems.

   When parsing this field it behaves equivalent to the following:
   The value is validated in strict and smart mode but not in lenient mode.
   The value is split to form SECOND_OF_MINUTE, MINUTE_OF_HOUR
   and HOUR_OF_DAY fields.

  type: java.time.temporal.ChronoField"
  ChronoField/SECOND_OF_DAY)

(def MINUTE_OF_HOUR
  "Enum Constant.

  The minute-of-hour.

   This counts the minute within the hour, from 0 to 59.
   This field has the same meaning for all calendar systems.

   When parsing this field it behaves equivalent to the following:
   The value is validated in strict and smart mode but not in lenient mode.

  type: java.time.temporal.ChronoField"
  ChronoField/MINUTE_OF_HOUR)

(def MINUTE_OF_DAY
  "Enum Constant.

  The minute-of-day.

   This counts the minute within the day, from 0 to (24 * 60) - 1.
   This field has the same meaning for all calendar systems.

   When parsing this field it behaves equivalent to the following:
   The value is validated in strict and smart mode but not in lenient mode.
   The value is split to form MINUTE_OF_HOUR and HOUR_OF_DAY fields.

  type: java.time.temporal.ChronoField"
  ChronoField/MINUTE_OF_DAY)

(def HOUR_OF_AMPM
  "Enum Constant.

  The hour-of-am-pm.

   This counts the hour within the AM/PM, from 0 to 11.
   This is the hour that would be observed on a standard 12-hour digital clock.
   This field has the same meaning for all calendar systems.

   When parsing this field it behaves equivalent to the following:
   The value is validated from 0 to 11 in strict and smart mode.
   In lenient mode the value is not validated. It is combined with
   AMPM_OF_DAY to form HOUR_OF_DAY by multiplying
   the {AMPM_OF_DAY} value by 12.

  type: java.time.temporal.ChronoField"
  ChronoField/HOUR_OF_AMPM)

(def CLOCK_HOUR_OF_AMPM
  "Enum Constant.

  The clock-hour-of-am-pm.

   This counts the hour within the AM/PM, from 1 to 12.
   This is the hour that would be observed on a standard 12-hour analog wall clock.
   This field has the same meaning for all calendar systems.

   When parsing this field it behaves equivalent to the following:
   The value is validated from 1 to 12 in strict mode and from
   0 to 12 in smart mode. In lenient mode the value is not validated.
   The field is converted to an HOUR_OF_AMPM with the same value,
   unless the value is 12, in which case it is converted to 0.

  type: java.time.temporal.ChronoField"
  ChronoField/CLOCK_HOUR_OF_AMPM)

(def HOUR_OF_DAY
  "Enum Constant.

  The hour-of-day.

   This counts the hour within the day, from 0 to 23.
   This is the hour that would be observed on a standard 24-hour digital clock.
   This field has the same meaning for all calendar systems.

   When parsing this field it behaves equivalent to the following:
   The value is validated in strict and smart mode but not in lenient mode.
   The field is combined with MINUTE_OF_HOUR, SECOND_OF_MINUTE and
   NANO_OF_SECOND to produce a LocalTime.
   In lenient mode, any excess days are added to the parsed date, or
   made available via DateTimeFormatter.parsedExcessDays().

  type: java.time.temporal.ChronoField"
  ChronoField/HOUR_OF_DAY)

(def CLOCK_HOUR_OF_DAY
  "Enum Constant.

  The clock-hour-of-day.

   This counts the hour within the AM/PM, from 1 to 24.
   This is the hour that would be observed on a 24-hour analog wall clock.
   This field has the same meaning for all calendar systems.

   When parsing this field it behaves equivalent to the following:
   The value is validated from 1 to 24 in strict mode and from
   0 to 24 in smart mode. In lenient mode the value is not validated.
   The field is converted to an HOUR_OF_DAY with the same value,
   unless the value is 24, in which case it is converted to 0.

  type: java.time.temporal.ChronoField"
  ChronoField/CLOCK_HOUR_OF_DAY)

(def AMPM_OF_DAY
  "Enum Constant.

  The am-pm-of-day.

   This counts the AM/PM within the day, from 0 (AM) to 1 (PM).
   This field has the same meaning for all calendar systems.

   When parsing this field it behaves equivalent to the following:
   The value is validated from 0 to 1 in strict and smart mode.
   In lenient mode the value is not validated. It is combined with
   HOUR_OF_AMPM to form HOUR_OF_DAY by multiplying
   the {AMPM_OF_DAY} value by 12.

  type: java.time.temporal.ChronoField"
  ChronoField/AMPM_OF_DAY)

(def DAY_OF_WEEK
  "Enum Constant.

  The day-of-week, such as Tuesday.

   This represents the standard concept of the day of the week.
   In the default ISO calendar system, this has values from Monday (1) to Sunday (7).
   The DayOfWeek class can be used to interpret the result.

   Most non-ISO calendar systems also define a seven day week that aligns with ISO.
   Those calendar systems must also use the same numbering system, from Monday (1) to
   Sunday (7), which allows DayOfWeek to be used.

   Calendar systems that do not have a standard seven day week should implement this field
   if they have a similar concept of named or numbered days within a period similar
   to a week. It is recommended that the numbering starts from 1.

  type: java.time.temporal.ChronoField"
  ChronoField/DAY_OF_WEEK)

(def ALIGNED_DAY_OF_WEEK_IN_MONTH
  "Enum Constant.

  The aligned day-of-week within a month.

   This represents concept of the count of days within the period of a week
   where the weeks are aligned to the start of the month.
   This field is typically used with ALIGNED_WEEK_OF_MONTH.

   For example, in a calendar systems with a seven day week, the first aligned-week-of-month
   starts on day-of-month 1, the second aligned-week starts on day-of-month 8, and so on.
   Within each of these aligned-weeks, the days are numbered from 1 to 7 and returned
   as the value of this field.
   As such, day-of-month 1 to 7 will have aligned-day-of-week values from 1 to 7.
   And day-of-month 8 to 14 will repeat this with aligned-day-of-week values from 1 to 7.

   Calendar systems that do not have a seven day week should typically implement this
   field in the same way, but using the alternate week length.

  type: java.time.temporal.ChronoField"
  ChronoField/ALIGNED_DAY_OF_WEEK_IN_MONTH)

(def ALIGNED_DAY_OF_WEEK_IN_YEAR
  "Enum Constant.

  The aligned day-of-week within a year.

   This represents concept of the count of days within the period of a week
   where the weeks are aligned to the start of the year.
   This field is typically used with ALIGNED_WEEK_OF_YEAR.

   For example, in a calendar systems with a seven day week, the first aligned-week-of-year
   starts on day-of-year 1, the second aligned-week starts on day-of-year 8, and so on.
   Within each of these aligned-weeks, the days are numbered from 1 to 7 and returned
   as the value of this field.
   As such, day-of-year 1 to 7 will have aligned-day-of-week values from 1 to 7.
   And day-of-year 8 to 14 will repeat this with aligned-day-of-week values from 1 to 7.

   Calendar systems that do not have a seven day week should typically implement this
   field in the same way, but using the alternate week length.

  type: java.time.temporal.ChronoField"
  ChronoField/ALIGNED_DAY_OF_WEEK_IN_YEAR)

(def DAY_OF_MONTH
  "Enum Constant.

  The day-of-month.

   This represents the concept of the day within the month.
   In the default ISO calendar system, this has values from 1 to 31 in most months.
   April, June, September, November have days from 1 to 30, while February has days
   from 1 to 28, or 29 in a leap year.

   Non-ISO calendar systems should implement this field using the most recognized
   day-of-month values for users of the calendar system.
   Normally, this is a count of days from 1 to the length of the month.

  type: java.time.temporal.ChronoField"
  ChronoField/DAY_OF_MONTH)

(def DAY_OF_YEAR
  "Enum Constant.

  The day-of-year.

   This represents the concept of the day within the year.
   In the default ISO calendar system, this has values from 1 to 365 in standard
   years and 1 to 366 in leap years.

   Non-ISO calendar systems should implement this field using the most recognized
   day-of-year values for users of the calendar system.
   Normally, this is a count of days from 1 to the length of the year.

   Note that a non-ISO calendar system may have year numbering system that changes
   at a different point to the natural reset in the month numbering. An example
   of this is the Japanese calendar system where a change of era, which resets
   the year number to 1, can happen on any date. The era and year reset also cause
   the day-of-year to be reset to 1, but not the month-of-year or day-of-month.

  type: java.time.temporal.ChronoField"
  ChronoField/DAY_OF_YEAR)

(def EPOCH_DAY
  "Enum Constant.

  The epoch-day, based on the Java epoch of 1970-01-01 (ISO).

   This field is the sequential count of days where 1970-01-01 (ISO) is zero.
   Note that this uses the local time-line, ignoring offset and time-zone.

   This field is strictly defined to have the same meaning in all calendar systems.
   This is necessary to ensure interoperation between calendars.

  type: java.time.temporal.ChronoField"
  ChronoField/EPOCH_DAY)

(def ALIGNED_WEEK_OF_MONTH
  "Enum Constant.

  The aligned week within a month.

   This represents concept of the count of weeks within the period of a month
   where the weeks are aligned to the start of the month.
   This field is typically used with ALIGNED_DAY_OF_WEEK_IN_MONTH.

   For example, in a calendar systems with a seven day week, the first aligned-week-of-month
   starts on day-of-month 1, the second aligned-week starts on day-of-month 8, and so on.
   Thus, day-of-month values 1 to 7 are in aligned-week 1, while day-of-month values
   8 to 14 are in aligned-week 2, and so on.

   Calendar systems that do not have a seven day week should typically implement this
   field in the same way, but using the alternate week length.

  type: java.time.temporal.ChronoField"
  ChronoField/ALIGNED_WEEK_OF_MONTH)

(def ALIGNED_WEEK_OF_YEAR
  "Enum Constant.

  The aligned week within a year.

   This represents concept of the count of weeks within the period of a year
   where the weeks are aligned to the start of the year.
   This field is typically used with ALIGNED_DAY_OF_WEEK_IN_YEAR.

   For example, in a calendar systems with a seven day week, the first aligned-week-of-year
   starts on day-of-year 1, the second aligned-week starts on day-of-year 8, and so on.
   Thus, day-of-year values 1 to 7 are in aligned-week 1, while day-of-year values
   8 to 14 are in aligned-week 2, and so on.

   Calendar systems that do not have a seven day week should typically implement this
   field in the same way, but using the alternate week length.

  type: java.time.temporal.ChronoField"
  ChronoField/ALIGNED_WEEK_OF_YEAR)

(def MONTH_OF_YEAR
  "Enum Constant.

  The month-of-year, such as March.

   This represents the concept of the month within the year.
   In the default ISO calendar system, this has values from January (1) to December (12).

   Non-ISO calendar systems should implement this field using the most recognized
   month-of-year values for users of the calendar system.
   Normally, this is a count of months starting from 1.

  type: java.time.temporal.ChronoField"
  ChronoField/MONTH_OF_YEAR)

(def PROLEPTIC_MONTH
  "Enum Constant.

  The proleptic-month based, counting months sequentially from year 0.

   This field is the sequential count of months where the first month
   in proleptic-year zero has the value zero.
   Later months have increasingly larger values.
   Earlier months have increasingly small values.
   There are no gaps or breaks in the sequence of months.
   Note that this uses the local time-line, ignoring offset and time-zone.

   In the default ISO calendar system, June 2012 would have the value
   (2012 * 12  6 - 1). This field is primarily for internal use.

   Non-ISO calendar systems must implement this field as per the definition above.
   It is just a simple zero-based count of elapsed months from the start of proleptic-year 0.
   All calendar systems with a full proleptic-year definition will have a year zero.
   If the calendar system has a minimum year that excludes year zero, then one must
   be extrapolated in order for this method to be defined.

  type: java.time.temporal.ChronoField"
  ChronoField/PROLEPTIC_MONTH)

(def YEAR_OF_ERA
  "Enum Constant.

  The year within the era.

   This represents the concept of the year within the era.
   This field is typically used with ERA.

   The standard mental model for a date is based on three concepts - year, month and day.
   These map onto the YEAR, MONTH_OF_YEAR and DAY_OF_MONTH fields.
   Note that there is no reference to eras.
   The full model for a date requires four concepts - era, year, month and day. These map onto
   the ERA, YEAR_OF_ERA, MONTH_OF_YEAR and DAY_OF_MONTH fields.
   Whether this field or YEAR is used depends on which mental model is being used.
   See ChronoLocalDate for more discussion on this topic.

   In the default ISO calendar system, there are two eras defined, 'BCE' and 'CE'.
   The era 'CE' is the one currently in use and year-of-era runs from 1 to the maximum value.
   The era 'BCE' is the previous era, and the year-of-era runs backwards.

   For example, subtracting a year each time yield the following:
   - year-proleptic 2  = 'CE' year-of-era 2
   - year-proleptic 1  = 'CE' year-of-era 1
   - year-proleptic 0  = 'BCE' year-of-era 1
   - year-proleptic -1 = 'BCE' year-of-era 2

   Note that the ISO-8601 standard does not actually define eras.
   Note also that the ISO eras do not align with the well-known AD/BC eras due to the
   change between the Julian and Gregorian calendar systems.

   Non-ISO calendar systems should implement this field using the most recognized
   year-of-era value for users of the calendar system.
   Since most calendar systems have only two eras, the year-of-era numbering approach
   will typically be the same as that used by the ISO calendar system.
   The year-of-era value should typically always be positive, however this is not required.

  type: java.time.temporal.ChronoField"
  ChronoField/YEAR_OF_ERA)

(def YEAR
  "Enum Constant.

  The proleptic year, such as 2012.

   This represents the concept of the year, counting sequentially and using negative numbers.
   The proleptic year is not interpreted in terms of the era.
   See YEAR_OF_ERA for an example showing the mapping from proleptic year to year-of-era.

   The standard mental model for a date is based on three concepts - year, month and day.
   These map onto the YEAR, MONTH_OF_YEAR and DAY_OF_MONTH fields.
   Note that there is no reference to eras.
   The full model for a date requires four concepts - era, year, month and day. These map onto
   the ERA, YEAR_OF_ERA, MONTH_OF_YEAR and DAY_OF_MONTH fields.
   Whether this field or YEAR_OF_ERA is used depends on which mental model is being used.
   See ChronoLocalDate for more discussion on this topic.

   Non-ISO calendar systems should implement this field as follows.
   If the calendar system has only two eras, before and after a fixed date, then the
   proleptic-year value must be the same as the year-of-era value for the later era,
   and increasingly negative for the earlier era.
   If the calendar system has more than two eras, then the proleptic-year value may be
   defined with any appropriate value, although defining it to be the same as ISO may be
   the best option.

  type: java.time.temporal.ChronoField"
  ChronoField/YEAR)

(def ERA
  "Enum Constant.

  The era.

   This represents the concept of the era, which is the largest division of the time-line.
   This field is typically used with YEAR_OF_ERA.

   In the default ISO calendar system, there are two eras defined, 'BCE' and 'CE'.
   The era 'CE' is the one currently in use and year-of-era runs from 1 to the maximum value.
   The era 'BCE' is the previous era, and the year-of-era runs backwards.
   See YEAR_OF_ERA for a full example.

   Non-ISO calendar systems should implement this field to define eras.
   The value of the era that was active on 1970-01-01 (ISO) must be assigned the value 1.
   Earlier eras must have sequentially smaller values.
   Later eras must have sequentially larger values,

  type: java.time.temporal.ChronoField"
  ChronoField/ERA)

(def INSTANT_SECONDS
  "Enum Constant.

  The instant epoch-seconds.

   This represents the concept of the sequential count of seconds where
   1970-01-01T00:00Z (ISO) is zero.
   This field may be used with NANO_OF_SECOND to represent the fraction of the second.

   An Instant represents an instantaneous point on the time-line.
   On their own, an instant has insufficient information to allow a local date-time to be obtained.
   Only when paired with an offset or time-zone can the local date or time be calculated.

   This field is strictly defined to have the same meaning in all calendar systems.
   This is necessary to ensure interoperation between calendars.

  type: java.time.temporal.ChronoField"
  ChronoField/INSTANT_SECONDS)

(def OFFSET_SECONDS
  "Enum Constant.

  The offset from UTC/Greenwich.

   This represents the concept of the offset in seconds of local time from UTC/Greenwich.

   A ZoneOffset represents the period of time that local time differs from UTC/Greenwich.
   This is usually a fixed number of hours and minutes.
   It is equivalent to the total amount of the offset in seconds.
   For example, during the winter Paris has an offset of +01:00, which is 3600 seconds.

   This field is strictly defined to have the same meaning in all calendar systems.
   This is necessary to ensure interoperation between calendars.

  type: java.time.temporal.ChronoField"
  ChronoField/OFFSET_SECONDS)

(defn *values
  "Returns an array containing the constants of this enum type, in
  the order they are declared.  This method may be used to iterate
  over the constants as follows:


  for (ChronoField c : ChronoField.values())
      System.out.println(c);

  returns: an array containing the constants of this enum type, in the order they are declared - `java.time.temporal.ChronoField[]`"
  ([]
    (ChronoField/values )))

(defn *value-of
  "Returns the enum constant of this type with the specified name.
  The string must match exactly an identifier used to declare an
  enum constant in this type.  (Extraneous whitespace characters are
  not permitted.)

  name - the name of the enum constant to be returned. - `java.lang.String`

  returns: the enum constant with the specified name - `java.time.temporal.ChronoField`

  throws: java.lang.IllegalArgumentException - if this enum type has no constant with the specified name"
  ([name]
    (ChronoField/valueOf name)))

(defn get-range-unit
  "Description copied from interface: TemporalField

  returns: the unit defining the range of the field, not null - `java.time.temporal.TemporalUnit`"
  ([this]
    (-> this (.getRangeUnit))))

(defn range
  "Gets the range of valid values for the field.

   All fields can be expressed as a long integer.
   This method returns an object that describes the valid range for that value.

   This method returns the range of the field in the ISO-8601 calendar system.
   This range may be incorrect for other calendar systems.
   Use Chronology.range(ChronoField) to access the correct range
   for a different calendar system.

   Note that the result only describes the minimum and maximum valid values
   and it is important not to read too much into them. For example, there
   could be values within the range that are invalid for the field.

  returns: the range of valid values for the field, not null - `java.time.temporal.ValueRange`"
  ([this]
    (-> this (.range))))

(defn check-valid-int-value
  "Checks that the specified value is valid and fits in an int.

   This validates that the value is within the outer range of valid values
   returned by range().
   It also checks that all valid values are within the bounds of an int.

   This method checks against the range of the field in the ISO-8601 calendar system.
   This range may be incorrect for other calendar systems.
   Use Chronology.range(ChronoField) to access the correct range
   for a different calendar system.

  value - the value to check - `long`

  returns: the value that was passed in - `int`"
  ([this value]
    (-> this (.checkValidIntValue value))))

(defn get-base-unit
  "Description copied from interface: TemporalField

  returns: the unit defining the base unit of the field, not null - `java.time.temporal.TemporalUnit`"
  ([this]
    (-> this (.getBaseUnit))))

(defn to-string
  "Description copied from class: Enum

  returns: the name of this enum constant - `java.lang.String`"
  ([this]
    (-> this (.toString))))

(defn date-based?
  "Checks if this field represents a component of a date.

   Fields from day-of-week to era are date-based.

  returns: true if it is a component of a date - `boolean`"
  ([this]
    (-> this (.isDateBased))))

(defn get-display-name
  "Description copied from interface: TemporalField

  locale - the locale to use, not null - `java.util.Locale`

  returns: the display name for the locale or a suitable default, not null - `java.lang.String`"
  ([this locale]
    (-> this (.getDisplayName locale))))

(defn supported-by?
  "Description copied from interface: TemporalField

  temporal - the temporal object to query, not null - `java.time.temporal.TemporalAccessor`

  returns: true if the date-time can be queried for this field, false if not - `boolean`"
  ([this temporal]
    (-> this (.isSupportedBy temporal))))

(defn range-refined-by
  "Description copied from interface: TemporalField

  temporal - the temporal object used to refine the result, not null - `java.time.temporal.TemporalAccessor`

  returns: the range of valid values for this field, not null - `java.time.temporal.ValueRange`"
  ([this temporal]
    (-> this (.rangeRefinedBy temporal))))

(defn adjust-into
  "Description copied from interface: TemporalField

  temporal - the temporal object to adjust, not null - `R`
  new-value - the new value of the field - `long`

  returns: the adjusted temporal object, not null - `<R extends java.time.temporal.Temporal> R`"
  ([this temporal new-value]
    (-> this (.adjustInto temporal new-value))))

(defn get-from
  "Description copied from interface: TemporalField

  temporal - the temporal object to query, not null - `java.time.temporal.TemporalAccessor`

  returns: the value of this field, not null - `long`"
  ([this temporal]
    (-> this (.getFrom temporal))))

(defn time-based?
  "Checks if this field represents a component of a time.

   Fields from nano-of-second to am-pm-of-day are time-based.

  returns: true if it is a component of a time - `boolean`"
  ([this]
    (-> this (.isTimeBased))))

(defn check-valid-value
  "Checks that the specified value is valid for this field.

   This validates that the value is within the outer range of valid values
   returned by range().

   This method checks against the range of the field in the ISO-8601 calendar system.
   This range may be incorrect for other calendar systems.
   Use Chronology.range(ChronoField) to access the correct range
   for a different calendar system.

  value - the value to check - `long`

  returns: the value that was passed in - `long`"
  ([this value]
    (-> this (.checkValidValue value))))

