(ns jdk.time.LocalTime
  "A time without a time-zone in the ISO-8601 calendar system,
  such as 10:15:30.

  LocalTime is an immutable date-time object that represents a time,
  often viewed as hour-minute-second.
  Time is represented to nanosecond precision.
  For example, the value `13:45.30.123456789` can be stored in a LocalTime.

  This class does not store or represent a date or time-zone.
  Instead, it is a description of the local time as seen on a wall clock.
  It cannot represent an instant on the time-line without additional information
  such as an offset or time-zone.

  The ISO-8601 calendar system is the modern civil calendar system used today
  in most of the world. This API assumes that all calendar systems use the same
  representation, this class, for time-of-day.


  This is a value-based
  class; use of identity-sensitive operations (including reference equality
  (==), identity hash code, or synchronization) on instances of
  LocalTime may have unpredictable results and should be avoided.
  The equals method should be used for comparisons."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.time LocalTime]))

(def *-min
  "Static Constant.

  The minimum supported LocalTime, '00:00'.
   This is the time of midnight at the start of the day.

  type: java.time.LocalTime"
  LocalTime/MIN)

(def *-max
  "Static Constant.

  The maximum supported LocalTime, '23:59:59.999999999'.
   This is the time just before midnight at the end of the day.

  type: java.time.LocalTime"
  LocalTime/MAX)

(def *-midnight
  "Static Constant.

  The time of midnight at the start of the day, '00:00'.

  type: java.time.LocalTime"
  LocalTime/MIDNIGHT)

(def *-noon
  "Static Constant.

  The time of noon in the middle of the day, '12:00'.

  type: java.time.LocalTime"
  LocalTime/NOON)

(defn *now
  "Obtains the current time from the system clock in the specified time-zone.

   This will query the system clock to obtain the current time.
   Specifying the time-zone avoids dependence on the default time-zone.

   Using this method will prevent the ability to use an alternate clock for testing
   because the clock is hard-coded.

  zone - the zone ID to use, not null - `java.time.ZoneId`

  returns: the current time using the system clock, not null - `java.time.LocalTime`"
  ([zone]
    (LocalTime/now zone))
  ([]
    (LocalTime/now )))

(defn *of
  "Obtains an instance of LocalTime from an hour, minute, second and nanosecond.

   This returns a LocalTime with the specified hour, minute, second and nanosecond.

  hour - the hour-of-day to represent, from 0 to 23 - `int`
  minute - the minute-of-hour to represent, from 0 to 59 - `int`
  second - the second-of-minute to represent, from 0 to 59 - `int`
  nano-of-second - the nano-of-second to represent, from 0 to 999,999,999 - `int`

  returns: the local time, not null - `java.time.LocalTime`

  throws: java.time.DateTimeException - if the value of any field is out of range"
  ([hour minute second nano-of-second]
    (LocalTime/of hour minute second nano-of-second))
  ([hour minute second]
    (LocalTime/of hour minute second))
  ([hour minute]
    (LocalTime/of hour minute)))

(defn *of-second-of-day
  "Obtains an instance of LocalTime from a second-of-day value.

   This returns a LocalTime with the specified second-of-day.
   The nanosecond field will be set to zero.

  second-of-day - the second-of-day, from 0 to 24 * 60 * 60 - 1 - `long`

  returns: the local time, not null - `java.time.LocalTime`

  throws: java.time.DateTimeException - if the second-of-day value is invalid"
  ([second-of-day]
    (LocalTime/ofSecondOfDay second-of-day)))

(defn *of-nano-of-day
  "Obtains an instance of LocalTime from a nanos-of-day value.

   This returns a LocalTime with the specified nanosecond-of-day.

  nano-of-day - the nano of day, from 0 to 24 * 60 * 60 * 1,000,000,000 - 1 - `long`

  returns: the local time, not null - `java.time.LocalTime`

  throws: java.time.DateTimeException - if the nanos of day value is invalid"
  ([nano-of-day]
    (LocalTime/ofNanoOfDay nano-of-day)))

(defn *from
  "Obtains an instance of LocalTime from a temporal object.

   This obtains a local time based on the specified temporal.
   A TemporalAccessor represents an arbitrary set of date and time information,
   which this factory converts to an instance of LocalTime.

   The conversion uses the TemporalQueries.localTime() query, which relies
   on extracting the NANO_OF_DAY field.

   This method matches the signature of the functional interface TemporalQuery
   allowing it to be used as a query via method reference, LocalTime::from.

  temporal - the temporal object to convert, not null - `java.time.temporal.TemporalAccessor`

  returns: the local time, not null - `java.time.LocalTime`

  throws: java.time.DateTimeException - if unable to convert to a LocalTime"
  ([temporal]
    (LocalTime/from temporal)))

(defn *parse
  "Obtains an instance of LocalTime from a text string using a specific formatter.

   The text is parsed using the formatter, returning a time.

  text - the text to parse, not null - `java.lang.CharSequence`
  formatter - the formatter to use, not null - `java.time.format.DateTimeFormatter`

  returns: the parsed local time, not null - `java.time.LocalTime`

  throws: java.time.format.DateTimeParseException - if the text cannot be parsed"
  ([text formatter]
    (LocalTime/parse text formatter))
  ([text]
    (LocalTime/parse text)))

(defn minus-minutes
  "Returns a copy of this LocalTime with the specified number of minutes subtracted.

   This subtracts the specified number of minutes from this time, returning a new time.
   The calculation wraps around midnight.

   This instance is immutable and unaffected by this method call.

  minutes-to-subtract - the minutes to subtract, may be negative - `long`

  returns: a LocalTime based on this time with the minutes subtracted, not null - `java.time.LocalTime`"
  ([this minutes-to-subtract]
    (-> this (.minusMinutes minutes-to-subtract))))

(defn truncated-to
  "Returns a copy of this LocalTime with the time truncated.

   Truncation returns a copy of the original time with fields
   smaller than the specified unit set to zero.
   For example, truncating with the minutes unit
   will set the second-of-minute and nano-of-second field to zero.

   The unit must have a duration
   that divides into the length of a standard day without remainder.
   This includes all supplied time units on ChronoUnit and
   DAYS. Other units throw an exception.

   This instance is immutable and unaffected by this method call.

  unit - the unit to truncate to, not null - `java.time.temporal.TemporalUnit`

  returns: a LocalTime based on this time with the time truncated, not null - `java.time.LocalTime`

  throws: java.time.DateTimeException - if unable to truncate"
  ([this unit]
    (-> this (.truncatedTo unit))))

(defn range
  "Gets the range of valid values for the specified field.

   The range object expresses the minimum and maximum valid values for a field.
   This time is used to enhance the accuracy of the returned range.
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

(defn get-hour
  "Gets the hour-of-day field.

  returns: the hour-of-day, from 0 to 23 - `int`"
  ([this]
    (-> this (.getHour))))

(defn at-offset
  "Combines this time with an offset to create an OffsetTime.

   This returns an OffsetTime formed from this time at the specified offset.
   All possible combinations of time and offset are valid.

  offset - the offset to combine with, not null - `java.time.ZoneOffset`

  returns: the offset time formed from this time and the specified offset, not null - `java.time.OffsetTime`"
  ([this offset]
    (-> this (.atOffset offset))))

(defn minus-hours
  "Returns a copy of this LocalTime with the specified number of hours subtracted.

   This subtracts the specified number of hours from this time, returning a new time.
   The calculation wraps around midnight.

   This instance is immutable and unaffected by this method call.

  hours-to-subtract - the hours to subtract, may be negative - `long`

  returns: a LocalTime based on this time with the hours subtracted, not null - `java.time.LocalTime`"
  ([this hours-to-subtract]
    (-> this (.minusHours hours-to-subtract))))

(defn get-nano
  "Gets the nano-of-second field.

  returns: the nano-of-second, from 0 to 999,999,999 - `int`"
  ([this]
    (-> this (.getNano))))

(defn minus-seconds
  "Returns a copy of this LocalTime with the specified number of seconds subtracted.

   This subtracts the specified number of seconds from this time, returning a new time.
   The calculation wraps around midnight.

   This instance is immutable and unaffected by this method call.

  seconds-to-subtract - the seconds to subtract, may be negative - `long`

  returns: a LocalTime based on this time with the seconds subtracted, not null - `java.time.LocalTime`"
  ([this seconds-to-subtract]
    (-> this (.minusSeconds seconds-to-subtract))))

(defn get-second
  "Gets the second-of-minute field.

  returns: the second-of-minute, from 0 to 59 - `int`"
  ([this]
    (-> this (.getSecond))))

(defn plus-nanos
  "Returns a copy of this LocalTime with the specified number of nanoseconds added.

   This adds the specified number of nanoseconds to this time, returning a new time.
   The calculation wraps around midnight.

   This instance is immutable and unaffected by this method call.

  nanos-to-add - the nanos to add, may be negative - `long`

  returns: a LocalTime based on this time with the nanoseconds added, not null - `java.time.LocalTime`"
  ([this nanos-to-add]
    (-> this (.plusNanos nanos-to-add))))

(defn plus
  "Returns a copy of this time with the specified amount added.

   This returns a LocalTime, based on this one, with the amount
   in terms of the unit added. If it is not possible to add the amount, because the
   unit is not supported or for some other reason, an exception is thrown.

   If the field is a ChronoUnit then the addition is implemented here.
   The supported fields behave as follows:

   NANOS -
    Returns a LocalTime with the specified number of nanoseconds added.
    This is equivalent to plusNanos(long).
   MICROS -
    Returns a LocalTime with the specified number of microseconds added.
    This is equivalent to plusNanos(long) with the amount
    multiplied by 1,000.
   MILLIS -
    Returns a LocalTime with the specified number of milliseconds added.
    This is equivalent to plusNanos(long) with the amount
    multiplied by 1,000,000.
   SECONDS -
    Returns a LocalTime with the specified number of seconds added.
    This is equivalent to plusSeconds(long).
   MINUTES -
    Returns a LocalTime with the specified number of minutes added.
    This is equivalent to plusMinutes(long).
   HOURS -
    Returns a LocalTime with the specified number of hours added.
    This is equivalent to plusHours(long).
   HALF_DAYS -
    Returns a LocalTime with the specified number of half-days added.
    This is equivalent to plusHours(long) with the amount
    multiplied by 12.


   All other ChronoUnit instances will throw an UnsupportedTemporalTypeException.

   If the field is not a ChronoUnit, then the result of this method
   is obtained by invoking TemporalUnit.addTo(Temporal, long)
   passing this as the argument. In this case, the unit determines
   whether and how to perform the addition.

   This instance is immutable and unaffected by this method call.

  amount-to-add - the amount of the unit to add to the result, may be negative - `long`
  unit - the unit of the amount to add, not null - `java.time.temporal.TemporalUnit`

  returns: a LocalTime based on this time with the specified amount added, not null - `java.time.LocalTime`

  throws: java.time.DateTimeException - if the addition cannot be made"
  ([this amount-to-add unit]
    (-> this (.plus amount-to-add unit)))
  ([this amount-to-add]
    (-> this (.plus amount-to-add))))

(defn with-hour
  "Returns a copy of this LocalTime with the hour-of-day altered.

   This instance is immutable and unaffected by this method call.

  hour - the hour-of-day to set in the result, from 0 to 23 - `int`

  returns: a LocalTime based on this time with the requested hour, not null - `java.time.LocalTime`

  throws: java.time.DateTimeException - if the hour value is invalid"
  ([this hour]
    (-> this (.withHour hour))))

(defn with-minute
  "Returns a copy of this LocalTime with the minute-of-hour altered.

   This instance is immutable and unaffected by this method call.

  minute - the minute-of-hour to set in the result, from 0 to 59 - `int`

  returns: a LocalTime based on this time with the requested minute, not null - `java.time.LocalTime`

  throws: java.time.DateTimeException - if the minute value is invalid"
  ([this minute]
    (-> this (.withMinute minute))))

(defn plus-minutes
  "Returns a copy of this LocalTime with the specified number of minutes added.

   This adds the specified number of minutes to this time, returning a new time.
   The calculation wraps around midnight.

   This instance is immutable and unaffected by this method call.

  minutes-to-add - the minutes to add, may be negative - `long`

  returns: a LocalTime based on this time with the minutes added, not null - `java.time.LocalTime`"
  ([this minutes-to-add]
    (-> this (.plusMinutes minutes-to-add))))

(defn query
  "Queries this time using the specified query.

   This queries this time using the specified query strategy object.
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

(defn at-date
  "Combines this time with a date to create a LocalDateTime.

   This returns a LocalDateTime formed from this time at the specified date.
   All possible combinations of date and time are valid.

  date - the date to combine with, not null - `java.time.LocalDate`

  returns: the local date-time formed from this time and the specified date, not null - `java.time.LocalDateTime`"
  ([this date]
    (-> this (.atDate date))))

(defn to-string
  "Outputs this time as a String, such as 10:15.

   The output will be one of the following ISO-8601 formats:

   HH:mm
   HH:mm:ss
   HH:mm:ss.SSS
   HH:mm:ss.SSSSSS
   HH:mm:ss.SSSSSSSSS

   The format used will be the shortest that outputs the full value of
   the time where the omitted parts are implied to be zero.

  returns: a string representation of this time, not null - `java.lang.String`"
  ([this]
    (-> this (.toString))))

(defn before?
  "Checks if this time is before the specified time.

   The comparison is based on the time-line position of the time within a day.

  other - the other time to compare to, not null - `java.time.LocalTime`

  returns: true if this point is before the specified time - `boolean`

  throws: java.lang.NullPointerException - if other is null"
  ([this other]
    (-> this (.isBefore other))))

(defn minus
  "Returns a copy of this time with the specified amount subtracted.

   This returns a LocalTime, based on this one, with the amount
   in terms of the unit subtracted. If it is not possible to subtract the amount,
   because the unit is not supported or for some other reason, an exception is thrown.

   This method is equivalent to plus(long, TemporalUnit) with the amount negated.
   See that method for a full description of how addition, and thus subtraction, works.

   This instance is immutable and unaffected by this method call.

  amount-to-subtract - the amount of the unit to subtract from the result, may be negative - `long`
  unit - the unit of the amount to subtract, not null - `java.time.temporal.TemporalUnit`

  returns: a LocalTime based on this time with the specified amount subtracted, not null - `java.time.LocalTime`

  throws: java.time.DateTimeException - if the subtraction cannot be made"
  ([this amount-to-subtract unit]
    (-> this (.minus amount-to-subtract unit)))
  ([this amount-to-subtract]
    (-> this (.minus amount-to-subtract))))

(defn plus-hours
  "Returns a copy of this LocalTime with the specified number of hours added.

   This adds the specified number of hours to this time, returning a new time.
   The calculation wraps around midnight.

   This instance is immutable and unaffected by this method call.

  hours-to-add - the hours to add, may be negative - `long`

  returns: a LocalTime based on this time with the hours added, not null - `java.time.LocalTime`"
  ([this hours-to-add]
    (-> this (.plusHours hours-to-add))))

(defn to-second-of-day
  "Extracts the time as seconds of day,
   from 0 to 24 * 60 * 60 - 1.

  returns: the second-of-day equivalent to this time - `int`"
  ([this]
    (-> this (.toSecondOfDay))))

(defn get-long
  "Gets the value of the specified field from this time as a long.

   This queries this time for the value of the specified field.
   If it is not possible to return the value, because the field is not supported
   or for some other reason, an exception is thrown.

   If the field is a ChronoField then the query is implemented here.
   The supported fields will return valid
   values based on this time.
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

(defn with-nano
  "Returns a copy of this LocalTime with the nano-of-second altered.

   This instance is immutable and unaffected by this method call.

  nano-of-second - the nano-of-second to set in the result, from 0 to 999,999,999 - `int`

  returns: a LocalTime based on this time with the requested nanosecond, not null - `java.time.LocalTime`

  throws: java.time.DateTimeException - if the nanos value is invalid"
  ([this nano-of-second]
    (-> this (.withNano nano-of-second))))

(defn until
  "Calculates the amount of time until another time in terms of the specified unit.

   This calculates the amount of time between two LocalTime
   objects in terms of a single TemporalUnit.
   The start and end points are this and the specified time.
   The result will be negative if the end is before the start.
   The Temporal passed to this method is converted to a
   LocalTime using from(TemporalAccessor).
   For example, the amount in hours between two times can be calculated
   using startTime.until(endTime, HOURS).

   The calculation returns a whole number, representing the number of
   complete units between the two times.
   For example, the amount in hours between 11:30 and 13:29 will only
   be one hour as it is one minute short of two hours.

   There are two equivalent ways of using this method.
   The first is to invoke this method.
   The second is to use TemporalUnit.between(Temporal, Temporal):


     // these two lines are equivalent
     amount = start.until(end, MINUTES);
     amount = MINUTES.between(start, end);
   The choice should be made based on which makes the code more readable.

   The calculation is implemented in this method for ChronoUnit.
   The units NANOS, MICROS, MILLIS, SECONDS,
   MINUTES, HOURS and HALF_DAYS are supported.
   Other ChronoUnit values will throw an exception.

   If the unit is not a ChronoUnit, then the result of this method
   is obtained by invoking TemporalUnit.between(Temporal, Temporal)
   passing this as the first argument and the converted input temporal
   as the second argument.

   This instance is immutable and unaffected by this method call.

  end-exclusive - the end time, exclusive, which is converted to a LocalTime, not null - `java.time.temporal.Temporal`
  unit - the unit to measure the amount in, not null - `java.time.temporal.TemporalUnit`

  returns: the amount of time between this time and the end time - `long`

  throws: java.time.DateTimeException - if the amount cannot be calculated, or the end temporal cannot be converted to a LocalTime"
  ([this end-exclusive unit]
    (-> this (.until end-exclusive unit))))

(defn after?
  "Checks if this time is after the specified time.

   The comparison is based on the time-line position of the time within a day.

  other - the other time to compare to, not null - `java.time.LocalTime`

  returns: true if this is after the specified time - `boolean`

  throws: java.lang.NullPointerException - if other is null"
  ([this other]
    (-> this (.isAfter other))))

(defn minus-nanos
  "Returns a copy of this LocalTime with the specified number of nanoseconds subtracted.

   This subtracts the specified number of nanoseconds from this time, returning a new time.
   The calculation wraps around midnight.

   This instance is immutable and unaffected by this method call.

  nanos-to-subtract - the nanos to subtract, may be negative - `long`

  returns: a LocalTime based on this time with the nanoseconds subtracted, not null - `java.time.LocalTime`"
  ([this nanos-to-subtract]
    (-> this (.minusNanos nanos-to-subtract))))

(defn supported?
  "Checks if the specified field is supported.

   This checks if this time can be queried for the specified field.
   If false, then calling the range,
   get and with(TemporalField, long)
   methods will throw an exception.

   If the field is a ChronoField then the query is implemented here.
   The supported fields are:

   NANO_OF_SECOND
   NANO_OF_DAY
   MICRO_OF_SECOND
   MICRO_OF_DAY
   MILLI_OF_SECOND
   MILLI_OF_DAY
   SECOND_OF_MINUTE
   SECOND_OF_DAY
   MINUTE_OF_HOUR
   MINUTE_OF_DAY
   HOUR_OF_AMPM
   CLOCK_HOUR_OF_AMPM
   HOUR_OF_DAY
   CLOCK_HOUR_OF_DAY
   AMPM_OF_DAY

   All other ChronoField instances will return false.

   If the field is not a ChronoField, then the result of this method
   is obtained by invoking TemporalField.isSupportedBy(TemporalAccessor)
   passing this as the argument.
   Whether the field is supported is determined by the field.

  field - the field to check, null returns false - `java.time.temporal.TemporalField`

  returns: true if the field is supported on this time, false if not - `boolean`"
  ([this field]
    (-> this (.isSupported field))))

(defn with-second
  "Returns a copy of this LocalTime with the second-of-minute altered.

   This instance is immutable and unaffected by this method call.

  second - the second-of-minute to set in the result, from 0 to 59 - `int`

  returns: a LocalTime based on this time with the requested second, not null - `java.time.LocalTime`

  throws: java.time.DateTimeException - if the second value is invalid"
  ([this second]
    (-> this (.withSecond second))))

(defn get-minute
  "Gets the minute-of-hour field.

  returns: the minute-of-hour, from 0 to 59 - `int`"
  ([this]
    (-> this (.getMinute))))

(defn hash-code
  "A hash code for this time.

  returns: a suitable hash code - `int`"
  ([this]
    (-> this (.hashCode))))

(defn adjust-into
  "Adjusts the specified temporal object to have the same time as this object.

   This returns a temporal object of the same observable type as the input
   with the time changed to be the same as this.

   The adjustment is equivalent to using Temporal.with(TemporalField, long)
   passing ChronoField.NANO_OF_DAY as the field.

   In most cases, it is clearer to reverse the calling pattern by using
   Temporal.with(TemporalAdjuster):


     // these two lines are equivalent, but the second approach is recommended
     temporal = thisLocalTime.adjustInto(temporal);
     temporal = temporal.with(thisLocalTime);

   This instance is immutable and unaffected by this method call.

  temporal - the target object to be adjusted, not null - `java.time.temporal.Temporal`

  returns: the adjusted object, not null - `java.time.temporal.Temporal`

  throws: java.time.DateTimeException - if unable to make the adjustment"
  ([this temporal]
    (-> this (.adjustInto temporal))))

(defn with
  "Returns a copy of this time with the specified field set to a new value.

   This returns a LocalTime, based on this one, with the value
   for the specified field changed.
   This can be used to change any supported field, such as the hour, minute or second.
   If it is not possible to set the value, because the field is not supported or for
   some other reason, an exception is thrown.

   If the field is a ChronoField then the adjustment is implemented here.
   The supported fields behave as follows:

   NANO_OF_SECOND -
    Returns a LocalTime with the specified nano-of-second.
    The hour, minute and second will be unchanged.
   NANO_OF_DAY -
    Returns a LocalTime with the specified nano-of-day.
    This completely replaces the time and is equivalent to ofNanoOfDay(long).
   MICRO_OF_SECOND -
    Returns a LocalTime with the nano-of-second replaced by the specified
    micro-of-second multiplied by 1,000.
    The hour, minute and second will be unchanged.
   MICRO_OF_DAY -
    Returns a LocalTime with the specified micro-of-day.
    This completely replaces the time and is equivalent to using ofNanoOfDay(long)
    with the micro-of-day multiplied by 1,000.
   MILLI_OF_SECOND -
    Returns a LocalTime with the nano-of-second replaced by the specified
    milli-of-second multiplied by 1,000,000.
    The hour, minute and second will be unchanged.
   MILLI_OF_DAY -
    Returns a LocalTime with the specified milli-of-day.
    This completely replaces the time and is equivalent to using ofNanoOfDay(long)
    with the milli-of-day multiplied by 1,000,000.
   SECOND_OF_MINUTE -
    Returns a LocalTime with the specified second-of-minute.
    The hour, minute and nano-of-second will be unchanged.
   SECOND_OF_DAY -
    Returns a LocalTime with the specified second-of-day.
    The nano-of-second will be unchanged.
   MINUTE_OF_HOUR -
    Returns a LocalTime with the specified minute-of-hour.
    The hour, second-of-minute and nano-of-second will be unchanged.
   MINUTE_OF_DAY -
    Returns a LocalTime with the specified minute-of-day.
    The second-of-minute and nano-of-second will be unchanged.
   HOUR_OF_AMPM -
    Returns a LocalTime with the specified hour-of-am-pm.
    The AM/PM, minute-of-hour, second-of-minute and nano-of-second will be unchanged.
   CLOCK_HOUR_OF_AMPM -
    Returns a LocalTime with the specified clock-hour-of-am-pm.
    The AM/PM, minute-of-hour, second-of-minute and nano-of-second will be unchanged.
   HOUR_OF_DAY -
    Returns a LocalTime with the specified hour-of-day.
    The minute-of-hour, second-of-minute and nano-of-second will be unchanged.
   CLOCK_HOUR_OF_DAY -
    Returns a LocalTime with the specified clock-hour-of-day.
    The minute-of-hour, second-of-minute and nano-of-second will be unchanged.
   AMPM_OF_DAY -
    Returns a LocalTime with the specified AM/PM.
    The hour-of-am-pm, minute-of-hour, second-of-minute and nano-of-second will be unchanged.


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

  returns: a LocalTime based on this with the specified field set, not null - `java.time.LocalTime`

  throws: java.time.DateTimeException - if the field cannot be set"
  ([this field new-value]
    (-> this (.with field new-value)))
  ([this adjuster]
    (-> this (.with adjuster))))

(defn compare-to
  "Compares this time to another time.

   The comparison is based on the time-line position of the local times within a day.
   It is `consistent with equals`, as defined by Comparable.

  other - the other time to compare to, not null - `java.time.LocalTime`

  returns: the comparator value, negative if less, positive if greater - `int`

  throws: java.lang.NullPointerException - if other is null"
  ([this other]
    (-> this (.compareTo other))))

(defn to-nano-of-day
  "Extracts the time as nanos of day,
   from 0 to 24 * 60 * 60 * 1,000,000,000 - 1.

  returns: the nano of day equivalent to this time - `long`"
  ([this]
    (-> this (.toNanoOfDay))))

(defn plus-seconds
  "Returns a copy of this LocalTime with the specified number of seconds added.

   This adds the specified number of seconds to this time, returning a new time.
   The calculation wraps around midnight.

   This instance is immutable and unaffected by this method call.

  secondsto-add - the seconds to add, may be negative - `long`

  returns: a LocalTime based on this time with the seconds added, not null - `java.time.LocalTime`"
  ([this secondsto-add]
    (-> this (.plusSeconds secondsto-add))))

(defn get
  "Gets the value of the specified field from this time as an int.

   This queries this time for the value of the specified field.
   The returned value will always be within the valid range of values for the field.
   If it is not possible to return the value, because the field is not supported
   or for some other reason, an exception is thrown.

   If the field is a ChronoField then the query is implemented here.
   The supported fields will return valid
   values based on this time, except NANO_OF_DAY and MICRO_OF_DAY
   which are too large to fit in an int and throw a DateTimeException.
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
  "Checks if this time is equal to another time.

   The comparison is based on the time-line position of the time within a day.

   Only objects of type LocalTime are compared, other types return false.
   To compare the date of two TemporalAccessor instances, use
   ChronoField.NANO_OF_DAY as a comparator.

  obj - the object to check, null returns false - `java.lang.Object`

  returns: true if this is equal to the other time - `boolean`"
  ([this obj]
    (-> this (.equals obj))))

(defn format
  "Formats this time using the specified formatter.

   This time will be passed to the formatter to produce a string.

  formatter - the formatter to use, not null - `java.time.format.DateTimeFormatter`

  returns: the formatted time string, not null - `java.lang.String`

  throws: java.time.DateTimeException - if an error occurs during printing"
  ([this formatter]
    (-> this (.format formatter))))

