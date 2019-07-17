(ns jdk.time.OffsetTime
  "A time with an offset from UTC/Greenwich in the ISO-8601 calendar system,
  such as 10:15:30+01:00.

  OffsetTime is an immutable date-time object that represents a time, often
  viewed as hour-minute-second-offset.
  This class stores all time fields, to a precision of nanoseconds,
  as well as a zone offset.
  For example, the value `13:45.30.123456789+02:00` can be stored
  in an OffsetTime.


  This is a value-based
  class; use of identity-sensitive operations (including reference equality
  (==), identity hash code, or synchronization) on instances of
  OffsetTime may have unpredictable results and should be avoided.
  The equals method should be used for comparisons."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.time OffsetTime]))

(def *-min
  "Static Constant.

  The minimum supported OffsetTime, '00:00:00+18:00'.
   This is the time of midnight at the start of the day in the maximum offset
   (larger offsets are earlier on the time-line).
   This combines LocalTime.MIN and ZoneOffset.MAX.
   This could be used by an application as a `far past` date.

  type: java.time.OffsetTime"
  OffsetTime/MIN)

(def *-max
  "Static Constant.

  The maximum supported OffsetTime, '23:59:59.999999999-18:00'.
   This is the time just before midnight at the end of the day in the minimum offset
   (larger negative offsets are later on the time-line).
   This combines LocalTime.MAX and ZoneOffset.MIN.
   This could be used by an application as a `far future` date.

  type: java.time.OffsetTime"
  OffsetTime/MAX)

(defn *now
  "Obtains the current time from the system clock in the specified time-zone.

   This will query the system clock to obtain the current time.
   Specifying the time-zone avoids dependence on the default time-zone.
   The offset will be calculated from the specified time-zone.

   Using this method will prevent the ability to use an alternate clock for testing
   because the clock is hard-coded.

  zone - the zone ID to use, not null - `java.time.ZoneId`

  returns: the current time using the system clock, not null - `java.time.OffsetTime`"
  (^java.time.OffsetTime [^java.time.ZoneId zone]
    (OffsetTime/now zone))
  (^java.time.OffsetTime []
    (OffsetTime/now )))

(defn *of
  "Obtains an instance of OffsetTime from an hour, minute, second and nanosecond.

   This creates an offset time with the four specified fields.

   This method exists primarily for writing test cases.
   Non test-code will typically use other methods to create an offset time.
   LocalTime has two additional convenience variants of the
   equivalent factory method taking fewer arguments.
   They are not provided here to reduce the footprint of the API.

  hour - the hour-of-day to represent, from 0 to 23 - `int`
  minute - the minute-of-hour to represent, from 0 to 59 - `int`
  second - the second-of-minute to represent, from 0 to 59 - `int`
  nano-of-second - the nano-of-second to represent, from 0 to 999,999,999 - `int`
  offset - the zone offset, not null - `java.time.ZoneOffset`

  returns: the offset time, not null - `java.time.OffsetTime`

  throws: java.time.DateTimeException - if the value of any field is out of range"
  (^java.time.OffsetTime [^Integer hour ^Integer minute ^Integer second ^Integer nano-of-second ^java.time.ZoneOffset offset]
    (OffsetTime/of hour minute second nano-of-second offset))
  (^java.time.OffsetTime [^java.time.LocalTime time ^java.time.ZoneOffset offset]
    (OffsetTime/of time offset)))

(defn *of-instant
  "Obtains an instance of OffsetTime from an Instant and zone ID.

   This creates an offset time with the same instant as that specified.
   Finding the offset from UTC/Greenwich is simple as there is only one valid
   offset for each instant.

   The date component of the instant is dropped during the conversion.
   This means that the conversion can never fail due to the instant being
   out of the valid range of dates.

  instant - the instant to create the time from, not null - `java.time.Instant`
  zone - the time-zone, which may be an offset, not null - `java.time.ZoneId`

  returns: the offset time, not null - `java.time.OffsetTime`"
  (^java.time.OffsetTime [^java.time.Instant instant ^java.time.ZoneId zone]
    (OffsetTime/ofInstant instant zone)))

(defn *from
  "Obtains an instance of OffsetTime from a temporal object.

   This obtains an offset time based on the specified temporal.
   A TemporalAccessor represents an arbitrary set of date and time information,
   which this factory converts to an instance of OffsetTime.

   The conversion extracts and combines the ZoneOffset and the
   LocalTime from the temporal object.
   Implementations are permitted to perform optimizations such as accessing
   those fields that are equivalent to the relevant objects.

   This method matches the signature of the functional interface TemporalQuery
   allowing it to be used as a query via method reference, OffsetTime::from.

  temporal - the temporal object to convert, not null - `java.time.temporal.TemporalAccessor`

  returns: the offset time, not null - `java.time.OffsetTime`

  throws: java.time.DateTimeException - if unable to convert to an OffsetTime"
  (^java.time.OffsetTime [^java.time.temporal.TemporalAccessor temporal]
    (OffsetTime/from temporal)))

(defn *parse
  "Obtains an instance of OffsetTime from a text string using a specific formatter.

   The text is parsed using the formatter, returning a time.

  text - the text to parse, not null - `java.lang.CharSequence`
  formatter - the formatter to use, not null - `java.time.format.DateTimeFormatter`

  returns: the parsed offset time, not null - `java.time.OffsetTime`

  throws: java.time.format.DateTimeParseException - if the text cannot be parsed"
  (^java.time.OffsetTime [^java.lang.CharSequence text ^java.time.format.DateTimeFormatter formatter]
    (OffsetTime/parse text formatter))
  (^java.time.OffsetTime [^java.lang.CharSequence text]
    (OffsetTime/parse text)))

(defn minus-minutes
  "Returns a copy of this OffsetTime with the specified number of minutes subtracted.

   This subtracts the specified number of minutes from this time, returning a new time.
   The calculation wraps around midnight.

   This instance is immutable and unaffected by this method call.

  minutes - the minutes to subtract, may be negative - `long`

  returns: an OffsetTime based on this time with the minutes subtracted, not null - `java.time.OffsetTime`"
  (^java.time.OffsetTime [^java.time.OffsetTime this ^Long minutes]
    (-> this (.minusMinutes minutes))))

(defn truncated-to
  "Returns a copy of this OffsetTime with the time truncated.

   Truncation returns a copy of the original time with fields
   smaller than the specified unit set to zero.
   For example, truncating with the minutes unit
   will set the second-of-minute and nano-of-second field to zero.

   The unit must have a duration
   that divides into the length of a standard day without remainder.
   This includes all supplied time units on ChronoUnit and
   DAYS. Other units throw an exception.

   The offset does not affect the calculation and will be the same in the result.

   This instance is immutable and unaffected by this method call.

  unit - the unit to truncate to, not null - `java.time.temporal.TemporalUnit`

  returns: an OffsetTime based on this time with the time truncated, not null - `java.time.OffsetTime`

  throws: java.time.DateTimeException - if unable to truncate"
  (^java.time.OffsetTime [^java.time.OffsetTime this ^java.time.temporal.TemporalUnit unit]
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
  (^java.time.temporal.ValueRange [^java.time.OffsetTime this ^java.time.temporal.TemporalField field]
    (-> this (.range field))))

(defn get-hour
  "Gets the hour-of-day field.

  returns: the hour-of-day, from 0 to 23 - `int`"
  (^Integer [^java.time.OffsetTime this]
    (-> this (.getHour))))

(defn minus-hours
  "Returns a copy of this OffsetTime with the specified number of hours subtracted.

   This subtracts the specified number of hours from this time, returning a new time.
   The calculation wraps around midnight.

   This instance is immutable and unaffected by this method call.

  hours - the hours to subtract, may be negative - `long`

  returns: an OffsetTime based on this time with the hours subtracted, not null - `java.time.OffsetTime`"
  (^java.time.OffsetTime [^java.time.OffsetTime this ^Long hours]
    (-> this (.minusHours hours))))

(defn equal?
  "Checks if the instant of this OffsetTime is equal to that of the
   specified time applying both times to a common date.

   This method differs from the comparison in compareTo(java.time.OffsetTime) and equals(java.lang.Object)
   in that it only compares the instant of the time. This is equivalent to converting both
   times to an instant using the same date and comparing the instants.

  other - the other time to compare to, not null - `java.time.OffsetTime`

  returns: true if this is equal to the instant of the specified time - `boolean`"
  (^Boolean [^java.time.OffsetTime this ^java.time.OffsetTime other]
    (-> this (.isEqual other))))

(defn get-nano
  "Gets the nano-of-second field.

  returns: the nano-of-second, from 0 to 999,999,999 - `int`"
  (^Integer [^java.time.OffsetTime this]
    (-> this (.getNano))))

(defn minus-seconds
  "Returns a copy of this OffsetTime with the specified number of seconds subtracted.

   This subtracts the specified number of seconds from this time, returning a new time.
   The calculation wraps around midnight.

   This instance is immutable and unaffected by this method call.

  seconds - the seconds to subtract, may be negative - `long`

  returns: an OffsetTime based on this time with the seconds subtracted, not null - `java.time.OffsetTime`"
  (^java.time.OffsetTime [^java.time.OffsetTime this ^Long seconds]
    (-> this (.minusSeconds seconds))))

(defn get-second
  "Gets the second-of-minute field.

  returns: the second-of-minute, from 0 to 59 - `int`"
  (^Integer [^java.time.OffsetTime this]
    (-> this (.getSecond))))

(defn plus-nanos
  "Returns a copy of this OffsetTime with the specified number of nanoseconds added.

   This adds the specified number of nanoseconds to this time, returning a new time.
   The calculation wraps around midnight.

   This instance is immutable and unaffected by this method call.

  nanos - the nanos to add, may be negative - `long`

  returns: an OffsetTime based on this time with the nanoseconds added, not null - `java.time.OffsetTime`"
  (^java.time.OffsetTime [^java.time.OffsetTime this ^Long nanos]
    (-> this (.plusNanos nanos))))

(defn plus
  "Returns a copy of this time with the specified amount added.

   This returns an OffsetTime, based on this one, with the amount
   in terms of the unit added. If it is not possible to add the amount, because the
   unit is not supported or for some other reason, an exception is thrown.

   If the field is a ChronoUnit then the addition is implemented by
   LocalTime.plus(long, TemporalUnit).
   The offset is not part of the calculation and will be unchanged in the result.

   If the field is not a ChronoUnit, then the result of this method
   is obtained by invoking TemporalUnit.addTo(Temporal, long)
   passing this as the argument. In this case, the unit determines
   whether and how to perform the addition.

   This instance is immutable and unaffected by this method call.

  amount-to-add - the amount of the unit to add to the result, may be negative - `long`
  unit - the unit of the amount to add, not null - `java.time.temporal.TemporalUnit`

  returns: an OffsetTime based on this time with the specified amount added, not null - `java.time.OffsetTime`

  throws: java.time.DateTimeException - if the addition cannot be made"
  (^java.time.OffsetTime [^java.time.OffsetTime this ^Long amount-to-add ^java.time.temporal.TemporalUnit unit]
    (-> this (.plus amount-to-add unit)))
  (^java.time.OffsetTime [^java.time.OffsetTime this ^java.time.temporal.TemporalAmount amount-to-add]
    (-> this (.plus amount-to-add))))

(defn with-hour
  "Returns a copy of this OffsetTime with the hour-of-day altered.

   The offset does not affect the calculation and will be the same in the result.

   This instance is immutable and unaffected by this method call.

  hour - the hour-of-day to set in the result, from 0 to 23 - `int`

  returns: an OffsetTime based on this time with the requested hour, not null - `java.time.OffsetTime`

  throws: java.time.DateTimeException - if the hour value is invalid"
  (^java.time.OffsetTime [^java.time.OffsetTime this ^Integer hour]
    (-> this (.withHour hour))))

(defn with-minute
  "Returns a copy of this OffsetTime with the minute-of-hour altered.

   The offset does not affect the calculation and will be the same in the result.

   This instance is immutable and unaffected by this method call.

  minute - the minute-of-hour to set in the result, from 0 to 59 - `int`

  returns: an OffsetTime based on this time with the requested minute, not null - `java.time.OffsetTime`

  throws: java.time.DateTimeException - if the minute value is invalid"
  (^java.time.OffsetTime [^java.time.OffsetTime this ^Integer minute]
    (-> this (.withMinute minute))))

(defn plus-minutes
  "Returns a copy of this OffsetTime with the specified number of minutes added.

   This adds the specified number of minutes to this time, returning a new time.
   The calculation wraps around midnight.

   This instance is immutable and unaffected by this method call.

  minutes - the minutes to add, may be negative - `long`

  returns: an OffsetTime based on this time with the minutes added, not null - `java.time.OffsetTime`"
  (^java.time.OffsetTime [^java.time.OffsetTime this ^Long minutes]
    (-> this (.plusMinutes minutes))))

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
  ([^java.time.OffsetTime this ^java.time.temporal.TemporalQuery query]
    (-> this (.query query))))

(defn at-date
  "Combines this time with a date to create an OffsetDateTime.

   This returns an OffsetDateTime formed from this time and the specified date.
   All possible combinations of date and time are valid.

  date - the date to combine with, not null - `java.time.LocalDate`

  returns: the offset date-time formed from this time and the specified date, not null - `java.time.OffsetDateTime`"
  (^java.time.OffsetDateTime [^java.time.OffsetTime this ^java.time.LocalDate date]
    (-> this (.atDate date))))

(defn with-offset-same-instant
  "Returns a copy of this OffsetTime with the specified offset ensuring
   that the result is at the same instant on an implied day.

   This method returns an object with the specified ZoneOffset and a LocalTime
   adjusted by the difference between the two offsets.
   This will result in the old and new objects representing the same instant on an implied day.
   This is useful for finding the local time in a different offset.
   For example, if this time represents 10:30+02:00 and the offset specified is
   +03:00, then this method will return 11:30+03:00.

   To change the offset without adjusting the local time use withOffsetSameLocal(java.time.ZoneOffset).

   This instance is immutable and unaffected by this method call.

  offset - the zone offset to change to, not null - `java.time.ZoneOffset`

  returns: an OffsetTime based on this time with the requested offset, not null - `java.time.OffsetTime`"
  (^java.time.OffsetTime [^java.time.OffsetTime this ^java.time.ZoneOffset offset]
    (-> this (.withOffsetSameInstant offset))))

(defn to-string
  "Outputs this time as a String, such as 10:15:30+01:00.

   The output will be one of the following ISO-8601 formats:

   HH:mmXXXXX
   HH:mm:ssXXXXX
   HH:mm:ss.SSSXXXXX
   HH:mm:ss.SSSSSSXXXXX
   HH:mm:ss.SSSSSSSSSXXXXX

   The format used will be the shortest that outputs the full value of
   the time where the omitted parts are implied to be zero.

  returns: a string representation of this time, not null - `java.lang.String`"
  (^java.lang.String [^java.time.OffsetTime this]
    (-> this (.toString))))

(defn before?
  "Checks if the instant of this OffsetTime is before that of the
   specified time applying both times to a common date.

   This method differs from the comparison in compareTo(java.time.OffsetTime) in that it
   only compares the instant of the time. This is equivalent to converting both
   times to an instant using the same date and comparing the instants.

  other - the other time to compare to, not null - `java.time.OffsetTime`

  returns: true if this is before the instant of the specified time - `boolean`"
  (^Boolean [^java.time.OffsetTime this ^java.time.OffsetTime other]
    (-> this (.isBefore other))))

(defn minus
  "Returns a copy of this time with the specified amount subtracted.

   This returns an OffsetTime, based on this one, with the amount
   in terms of the unit subtracted. If it is not possible to subtract the amount,
   because the unit is not supported or for some other reason, an exception is thrown.

   This method is equivalent to plus(long, TemporalUnit) with the amount negated.
   See that method for a full description of how addition, and thus subtraction, works.

   This instance is immutable and unaffected by this method call.

  amount-to-subtract - the amount of the unit to subtract from the result, may be negative - `long`
  unit - the unit of the amount to subtract, not null - `java.time.temporal.TemporalUnit`

  returns: an OffsetTime based on this time with the specified amount subtracted, not null - `java.time.OffsetTime`

  throws: java.time.DateTimeException - if the subtraction cannot be made"
  (^java.time.OffsetTime [^java.time.OffsetTime this ^Long amount-to-subtract ^java.time.temporal.TemporalUnit unit]
    (-> this (.minus amount-to-subtract unit)))
  (^java.time.OffsetTime [^java.time.OffsetTime this ^java.time.temporal.TemporalAmount amount-to-subtract]
    (-> this (.minus amount-to-subtract))))

(defn plus-hours
  "Returns a copy of this OffsetTime with the specified number of hours added.

   This adds the specified number of hours to this time, returning a new time.
   The calculation wraps around midnight.

   This instance is immutable and unaffected by this method call.

  hours - the hours to add, may be negative - `long`

  returns: an OffsetTime based on this time with the hours added, not null - `java.time.OffsetTime`"
  (^java.time.OffsetTime [^java.time.OffsetTime this ^Long hours]
    (-> this (.plusHours hours))))

(defn to-local-time
  "Gets the LocalTime part of this date-time.

   This returns a LocalTime with the same hour, minute, second and
   nanosecond as this date-time.

  returns: the time part of this date-time, not null - `java.time.LocalTime`"
  (^java.time.LocalTime [^java.time.OffsetTime this]
    (-> this (.toLocalTime))))

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
  (^Long [^java.time.OffsetTime this ^java.time.temporal.TemporalField field]
    (-> this (.getLong field))))

(defn get-offset
  "Gets the zone offset, such as '+01:00'.

   This is the offset of the local time from UTC/Greenwich.

  returns: the zone offset, not null - `java.time.ZoneOffset`"
  (^java.time.ZoneOffset [^java.time.OffsetTime this]
    (-> this (.getOffset))))

(defn with-nano
  "Returns a copy of this OffsetTime with the nano-of-second altered.

   The offset does not affect the calculation and will be the same in the result.

   This instance is immutable and unaffected by this method call.

  nano-of-second - the nano-of-second to set in the result, from 0 to 999,999,999 - `int`

  returns: an OffsetTime based on this time with the requested nanosecond, not null - `java.time.OffsetTime`

  throws: java.time.DateTimeException - if the nanos value is invalid"
  (^java.time.OffsetTime [^java.time.OffsetTime this ^Integer nano-of-second]
    (-> this (.withNano nano-of-second))))

(defn until
  "Calculates the amount of time until another time in terms of the specified unit.

   This calculates the amount of time between two OffsetTime
   objects in terms of a single TemporalUnit.
   The start and end points are this and the specified time.
   The result will be negative if the end is before the start.
   For example, the amount in hours between two times can be calculated
   using startTime.until(endTime, HOURS).

   The Temporal passed to this method is converted to a
   OffsetTime using from(TemporalAccessor).
   If the offset differs between the two times, then the specified
   end time is normalized to have the same offset as this time.

   The calculation returns a whole number, representing the number of
   complete units between the two times.
   For example, the amount in hours between 11:30Z and 13:29Z will only
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

  end-exclusive - the end time, exclusive, which is converted to an OffsetTime, not null - `java.time.temporal.Temporal`
  unit - the unit to measure the amount in, not null - `java.time.temporal.TemporalUnit`

  returns: the amount of time between this time and the end time - `long`

  throws: java.time.DateTimeException - if the amount cannot be calculated, or the end temporal cannot be converted to an OffsetTime"
  (^Long [^java.time.OffsetTime this ^java.time.temporal.Temporal end-exclusive ^java.time.temporal.TemporalUnit unit]
    (-> this (.until end-exclusive unit))))

(defn with-offset-same-local
  "Returns a copy of this OffsetTime with the specified offset ensuring
   that the result has the same local time.

   This method returns an object with the same LocalTime and the specified ZoneOffset.
   No calculation is needed or performed.
   For example, if this time represents 10:30+02:00 and the offset specified is
   +03:00, then this method will return 10:30+03:00.

   To take into account the difference between the offsets, and adjust the time fields,
   use withOffsetSameInstant(java.time.ZoneOffset).

   This instance is immutable and unaffected by this method call.

  offset - the zone offset to change to, not null - `java.time.ZoneOffset`

  returns: an OffsetTime based on this time with the requested offset, not null - `java.time.OffsetTime`"
  (^java.time.OffsetTime [^java.time.OffsetTime this ^java.time.ZoneOffset offset]
    (-> this (.withOffsetSameLocal offset))))

(defn after?
  "Checks if the instant of this OffsetTime is after that of the
   specified time applying both times to a common date.

   This method differs from the comparison in compareTo(java.time.OffsetTime) in that it
   only compares the instant of the time. This is equivalent to converting both
   times to an instant using the same date and comparing the instants.

  other - the other time to compare to, not null - `java.time.OffsetTime`

  returns: true if this is after the instant of the specified time - `boolean`"
  (^Boolean [^java.time.OffsetTime this ^java.time.OffsetTime other]
    (-> this (.isAfter other))))

(defn minus-nanos
  "Returns a copy of this OffsetTime with the specified number of nanoseconds subtracted.

   This subtracts the specified number of nanoseconds from this time, returning a new time.
   The calculation wraps around midnight.

   This instance is immutable and unaffected by this method call.

  nanos - the nanos to subtract, may be negative - `long`

  returns: an OffsetTime based on this time with the nanoseconds subtracted, not null - `java.time.OffsetTime`"
  (^java.time.OffsetTime [^java.time.OffsetTime this ^Long nanos]
    (-> this (.minusNanos nanos))))

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
   OFFSET_SECONDS

   All other ChronoField instances will return false.

   If the field is not a ChronoField, then the result of this method
   is obtained by invoking TemporalField.isSupportedBy(TemporalAccessor)
   passing this as the argument.
   Whether the field is supported is determined by the field.

  field - the field to check, null returns false - `java.time.temporal.TemporalField`

  returns: true if the field is supported on this time, false if not - `boolean`"
  (^Boolean [^java.time.OffsetTime this ^java.time.temporal.TemporalField field]
    (-> this (.isSupported field))))

(defn with-second
  "Returns a copy of this OffsetTime with the second-of-minute altered.

   The offset does not affect the calculation and will be the same in the result.

   This instance is immutable and unaffected by this method call.

  second - the second-of-minute to set in the result, from 0 to 59 - `int`

  returns: an OffsetTime based on this time with the requested second, not null - `java.time.OffsetTime`

  throws: java.time.DateTimeException - if the second value is invalid"
  (^java.time.OffsetTime [^java.time.OffsetTime this ^Integer second]
    (-> this (.withSecond second))))

(defn get-minute
  "Gets the minute-of-hour field.

  returns: the minute-of-hour, from 0 to 59 - `int`"
  (^Integer [^java.time.OffsetTime this]
    (-> this (.getMinute))))

(defn hash-code
  "A hash code for this time.

  returns: a suitable hash code - `int`"
  (^Integer [^java.time.OffsetTime this]
    (-> this (.hashCode))))

(defn adjust-into
  "Adjusts the specified temporal object to have the same offset and time
   as this object.

   This returns a temporal object of the same observable type as the input
   with the offset and time changed to be the same as this.

   The adjustment is equivalent to using Temporal.with(TemporalField, long)
   twice, passing ChronoField.NANO_OF_DAY and
   ChronoField.OFFSET_SECONDS as the fields.

   In most cases, it is clearer to reverse the calling pattern by using
   Temporal.with(TemporalAdjuster):


     // these two lines are equivalent, but the second approach is recommended
     temporal = thisOffsetTime.adjustInto(temporal);
     temporal = temporal.with(thisOffsetTime);

   This instance is immutable and unaffected by this method call.

  temporal - the target object to be adjusted, not null - `java.time.temporal.Temporal`

  returns: the adjusted object, not null - `java.time.temporal.Temporal`

  throws: java.time.DateTimeException - if unable to make the adjustment"
  (^java.time.temporal.Temporal [^java.time.OffsetTime this ^java.time.temporal.Temporal temporal]
    (-> this (.adjustInto temporal))))

(defn with
  "Returns a copy of this time with the specified field set to a new value.

   This returns an OffsetTime, based on this one, with the value
   for the specified field changed.
   This can be used to change any supported field, such as the hour, minute or second.
   If it is not possible to set the value, because the field is not supported or for
   some other reason, an exception is thrown.

   If the field is a ChronoField then the adjustment is implemented here.

   The OFFSET_SECONDS field will return a time with the specified offset.
   The local time is unaltered. If the new offset value is outside the valid range
   then a DateTimeException will be thrown.

   The other supported fields will behave as per
   the matching method on LocalTime.with(TemporalField, long) LocalTime}.
   In this case, the offset is not part of the calculation and will be unchanged.

   All other ChronoField instances will throw an UnsupportedTemporalTypeException.

   If the field is not a ChronoField, then the result of this method
   is obtained by invoking TemporalField.adjustInto(Temporal, long)
   passing this as the argument. In this case, the field determines
   whether and how to adjust the instant.

   This instance is immutable and unaffected by this method call.

  field - the field to set in the result, not null - `java.time.temporal.TemporalField`
  new-value - the new value of the field in the result - `long`

  returns: an OffsetTime based on this with the specified field set, not null - `java.time.OffsetTime`

  throws: java.time.DateTimeException - if the field cannot be set"
  (^java.time.OffsetTime [^java.time.OffsetTime this ^java.time.temporal.TemporalField field ^Long new-value]
    (-> this (.with field new-value)))
  (^java.time.OffsetTime [^java.time.OffsetTime this ^java.time.temporal.TemporalAdjuster adjuster]
    (-> this (.with adjuster))))

(defn compare-to
  "Compares this OffsetTime to another time.

   The comparison is based first on the UTC equivalent instant, then on the local time.
   It is `consistent with equals`, as defined by Comparable.

   For example, the following is the comparator order:

   10:30+01:00
   11:00+01:00
   12:00+02:00
   11:30+01:00
   12:00+01:00
   12:30+01:00

   Values #2 and #3 represent the same instant on the time-line.
   When two values represent the same instant, the local time is compared
   to distinguish them. This step is needed to make the ordering
   consistent with equals().

   To compare the underlying local time of two TemporalAccessor instances,
   use ChronoField.NANO_OF_DAY as a comparator.

  other - the other time to compare to, not null - `java.time.OffsetTime`

  returns: the comparator value, negative if less, positive if greater - `int`

  throws: java.lang.NullPointerException - if other is null"
  (^Integer [^java.time.OffsetTime this ^java.time.OffsetTime other]
    (-> this (.compareTo other))))

(defn plus-seconds
  "Returns a copy of this OffsetTime with the specified number of seconds added.

   This adds the specified number of seconds to this time, returning a new time.
   The calculation wraps around midnight.

   This instance is immutable and unaffected by this method call.

  seconds - the seconds to add, may be negative - `long`

  returns: an OffsetTime based on this time with the seconds added, not null - `java.time.OffsetTime`"
  (^java.time.OffsetTime [^java.time.OffsetTime this ^Long seconds]
    (-> this (.plusSeconds seconds))))

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
  (^Integer [^java.time.OffsetTime this ^java.time.temporal.TemporalField field]
    (-> this (.get field))))

(defn equals
  "Checks if this time is equal to another time.

   The comparison is based on the local-time and the offset.
   To compare for the same instant on the time-line, use isEqual(OffsetTime).

   Only objects of type OffsetTime are compared, other types return false.
   To compare the underlying local time of two TemporalAccessor instances,
   use ChronoField.NANO_OF_DAY as a comparator.

  obj - the object to check, null returns false - `java.lang.Object`

  returns: true if this is equal to the other time - `boolean`"
  (^Boolean [^java.time.OffsetTime this ^java.lang.Object obj]
    (-> this (.equals obj))))

(defn format
  "Formats this time using the specified formatter.

   This time will be passed to the formatter to produce a string.

  formatter - the formatter to use, not null - `java.time.format.DateTimeFormatter`

  returns: the formatted time string, not null - `java.lang.String`

  throws: java.time.DateTimeException - if an error occurs during printing"
  (^java.lang.String [^java.time.OffsetTime this ^java.time.format.DateTimeFormatter formatter]
    (-> this (.format formatter))))

