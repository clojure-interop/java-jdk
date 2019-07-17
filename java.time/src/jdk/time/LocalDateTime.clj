(ns jdk.time.LocalDateTime
  "A date-time without a time-zone in the ISO-8601 calendar system,
  such as 2007-12-03T10:15:30.

  LocalDateTime is an immutable date-time object that represents a date-time,
  often viewed as year-month-day-hour-minute-second. Other date and time fields,
  such as day-of-year, day-of-week and week-of-year, can also be accessed.
  Time is represented to nanosecond precision.
  For example, the value `2nd October 2007 at 13:45.30.123456789` can be
  stored in a LocalDateTime.

  This class does not store or represent a time-zone.
  Instead, it is a description of the date, as used for birthdays, combined with
  the local time as seen on a wall clock.
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
  LocalDateTime may have unpredictable results and should be avoided.
  The equals method should be used for comparisons."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.time LocalDateTime]))

(def *-min
  "Static Constant.

  The minimum supported LocalDateTime, '-999999999-01-01T00:00:00'.
   This is the local date-time of midnight at the start of the minimum date.
   This combines LocalDate.MIN and LocalTime.MIN.
   This could be used by an application as a `far past` date-time.

  type: java.time.LocalDateTime"
  LocalDateTime/MIN)

(def *-max
  "Static Constant.

  The maximum supported LocalDateTime, '+999999999-12-31T23:59:59.999999999'.
   This is the local date-time just before midnight at the end of the maximum date.
   This combines LocalDate.MAX and LocalTime.MAX.
   This could be used by an application as a `far future` date-time.

  type: java.time.LocalDateTime"
  LocalDateTime/MAX)

(defn *now
  "Obtains the current date-time from the system clock in the specified time-zone.

   This will query the system clock to obtain the current date-time.
   Specifying the time-zone avoids dependence on the default time-zone.

   Using this method will prevent the ability to use an alternate clock for testing
   because the clock is hard-coded.

  zone - the zone ID to use, not null - `java.time.ZoneId`

  returns: the current date-time using the system clock, not null - `java.time.LocalDateTime`"
  ([^java.time.ZoneId zone]
    (LocalDateTime/now zone))
  ([]
    (LocalDateTime/now )))

(defn *of
  "Obtains an instance of LocalDateTime from year, month,
   day, hour, minute, second and nanosecond.

   This returns a LocalDateTime with the specified year, month,
   day-of-month, hour, minute, second and nanosecond.
   The day must be valid for the year and month, otherwise an exception will be thrown.

  year - the year to represent, from MIN_YEAR to MAX_YEAR - `int`
  month - the month-of-year to represent, not null - `java.time.Month`
  day-of-month - the day-of-month to represent, from 1 to 31 - `int`
  hour - the hour-of-day to represent, from 0 to 23 - `int`
  minute - the minute-of-hour to represent, from 0 to 59 - `int`
  second - the second-of-minute to represent, from 0 to 59 - `int`
  nano-of-second - the nano-of-second to represent, from 0 to 999,999,999 - `int`

  returns: the local date-time, not null - `java.time.LocalDateTime`

  throws: java.time.DateTimeException - if the value of any field is out of range, or if the day-of-month is invalid for the month-year"
  ([^Integer year ^java.time.Month month ^Integer day-of-month ^Integer hour ^Integer minute ^Integer second ^Integer nano-of-second]
    (LocalDateTime/of year month day-of-month hour minute second nano-of-second))
  ([^Integer year ^java.time.Month month ^Integer day-of-month ^Integer hour ^Integer minute ^Integer second]
    (LocalDateTime/of year month day-of-month hour minute second))
  ([^Integer year ^java.time.Month month ^Integer day-of-month ^Integer hour ^Integer minute]
    (LocalDateTime/of year month day-of-month hour minute))
  ([^java.time.LocalDate date ^java.time.LocalTime time]
    (LocalDateTime/of date time)))

(defn *of-instant
  "Obtains an instance of LocalDateTime from an Instant and zone ID.

   This creates a local date-time based on the specified instant.
   First, the offset from UTC/Greenwich is obtained using the zone ID and instant,
   which is simple as there is only one valid offset for each instant.
   Then, the instant and offset are used to calculate the local date-time.

  instant - the instant to create the date-time from, not null - `java.time.Instant`
  zone - the time-zone, which may be an offset, not null - `java.time.ZoneId`

  returns: the local date-time, not null - `java.time.LocalDateTime`

  throws: java.time.DateTimeException - if the result exceeds the supported range"
  ([^java.time.Instant instant ^java.time.ZoneId zone]
    (LocalDateTime/ofInstant instant zone)))

(defn *of-epoch-second
  "Obtains an instance of LocalDateTime using seconds from the
   epoch of 1970-01-01T00:00:00Z.

   This allows the epoch-second field
   to be converted to a local date-time. This is primarily intended for
   low-level conversions rather than general application usage.

  epoch-second - the number of seconds from the epoch of 1970-01-01T00:00:00Z - `long`
  nano-of-second - the nanosecond within the second, from 0 to 999,999,999 - `int`
  offset - the zone offset, not null - `java.time.ZoneOffset`

  returns: the local date-time, not null - `java.time.LocalDateTime`

  throws: java.time.DateTimeException - if the result exceeds the supported range, or if the nano-of-second is invalid"
  ([^Long epoch-second ^Integer nano-of-second ^java.time.ZoneOffset offset]
    (LocalDateTime/ofEpochSecond epoch-second nano-of-second offset)))

(defn *from
  "Obtains an instance of LocalDateTime from a temporal object.

   This obtains a local date-time based on the specified temporal.
   A TemporalAccessor represents an arbitrary set of date and time information,
   which this factory converts to an instance of LocalDateTime.

   The conversion extracts and combines the LocalDate and the
   LocalTime from the temporal object.
   Implementations are permitted to perform optimizations such as accessing
   those fields that are equivalent to the relevant objects.

   This method matches the signature of the functional interface TemporalQuery
   allowing it to be used as a query via method reference, LocalDateTime::from.

  temporal - the temporal object to convert, not null - `java.time.temporal.TemporalAccessor`

  returns: the local date-time, not null - `java.time.LocalDateTime`

  throws: java.time.DateTimeException - if unable to convert to a LocalDateTime"
  ([^java.time.temporal.TemporalAccessor temporal]
    (LocalDateTime/from temporal)))

(defn *parse
  "Obtains an instance of LocalDateTime from a text string using a specific formatter.

   The text is parsed using the formatter, returning a date-time.

  text - the text to parse, not null - `java.lang.CharSequence`
  formatter - the formatter to use, not null - `java.time.format.DateTimeFormatter`

  returns: the parsed local date-time, not null - `java.time.LocalDateTime`

  throws: java.time.format.DateTimeParseException - if the text cannot be parsed"
  ([^java.lang.CharSequence text ^java.time.format.DateTimeFormatter formatter]
    (LocalDateTime/parse text formatter))
  ([^java.lang.CharSequence text]
    (LocalDateTime/parse text)))

(defn minus-minutes
  "Returns a copy of this LocalDateTime with the specified number of minutes subtracted.

   This instance is immutable and unaffected by this method call.

  minutes - the minutes to subtract, may be negative - `long`

  returns: a LocalDateTime based on this date-time with the minutes subtracted, not null - `java.time.LocalDateTime`

  throws: java.time.DateTimeException - if the result exceeds the supported date range"
  ([^java.time.LocalDateTime this ^Long minutes]
    (-> this (.minusMinutes minutes))))

(defn truncated-to
  "Returns a copy of this LocalDateTime with the time truncated.

   Truncation returns a copy of the original date-time with fields
   smaller than the specified unit set to zero.
   For example, truncating with the minutes unit
   will set the second-of-minute and nano-of-second field to zero.

   The unit must have a duration
   that divides into the length of a standard day without remainder.
   This includes all supplied time units on ChronoUnit and
   DAYS. Other units throw an exception.

   This instance is immutable and unaffected by this method call.

  unit - the unit to truncate to, not null - `java.time.temporal.TemporalUnit`

  returns: a LocalDateTime based on this date-time with the time truncated, not null - `java.time.LocalDateTime`

  throws: java.time.DateTimeException - if unable to truncate"
  ([^java.time.LocalDateTime this ^java.time.temporal.TemporalUnit unit]
    (-> this (.truncatedTo unit))))

(defn minus-weeks
  "Returns a copy of this LocalDateTime with the specified number of weeks subtracted.

   This method subtracts the specified amount in weeks from the days field decrementing
   the month and year fields as necessary to ensure the result remains valid.
   The result is only invalid if the maximum/minimum year is exceeded.

   For example, 2009-01-07 minus one week would result in 2008-12-31.

   This instance is immutable and unaffected by this method call.

  weeks - the weeks to subtract, may be negative - `long`

  returns: a LocalDateTime based on this date-time with the weeks subtracted, not null - `java.time.LocalDateTime`

  throws: java.time.DateTimeException - if the result exceeds the supported date range"
  ([^java.time.LocalDateTime this ^Long weeks]
    (-> this (.minusWeeks weeks))))

(defn plus-weeks
  "Returns a copy of this LocalDateTime with the specified number of weeks added.

   This method adds the specified amount in weeks to the days field incrementing
   the month and year fields as necessary to ensure the result remains valid.
   The result is only invalid if the maximum/minimum year is exceeded.

   For example, 2008-12-31 plus one week would result in 2009-01-07.

   This instance is immutable and unaffected by this method call.

  weeks - the weeks to add, may be negative - `long`

  returns: a LocalDateTime based on this date-time with the weeks added, not null - `java.time.LocalDateTime`

  throws: java.time.DateTimeException - if the result exceeds the supported date range"
  ([^java.time.LocalDateTime this ^Long weeks]
    (-> this (.plusWeeks weeks))))

(defn range
  "Gets the range of valid values for the specified field.

   The range object expresses the minimum and maximum valid values for a field.
   This date-time is used to enhance the accuracy of the returned range.
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
  ([^java.time.LocalDateTime this ^java.time.temporal.TemporalField field]
    (-> this (.range field))))

(defn get-hour
  "Gets the hour-of-day field.

  returns: the hour-of-day, from 0 to 23 - `int`"
  ([^java.time.LocalDateTime this]
    (-> this (.getHour))))

(defn at-offset
  "Combines this date-time with an offset to create an OffsetDateTime.

   This returns an OffsetDateTime formed from this date-time at the specified offset.
   All possible combinations of date-time and offset are valid.

  offset - the offset to combine with, not null - `java.time.ZoneOffset`

  returns: the offset date-time formed from this date-time and the specified offset, not null - `java.time.OffsetDateTime`"
  ([^java.time.LocalDateTime this ^java.time.ZoneOffset offset]
    (-> this (.atOffset offset))))

(defn minus-hours
  "Returns a copy of this LocalDateTime with the specified number of hours subtracted.

   This instance is immutable and unaffected by this method call.

  hours - the hours to subtract, may be negative - `long`

  returns: a LocalDateTime based on this date-time with the hours subtracted, not null - `java.time.LocalDateTime`

  throws: java.time.DateTimeException - if the result exceeds the supported date range"
  ([^java.time.LocalDateTime this ^Long hours]
    (-> this (.minusHours hours))))

(defn with-month
  "Returns a copy of this LocalDateTime with the month-of-year altered.

   The time does not affect the calculation and will be the same in the result.
   If the day-of-month is invalid for the year, it will be changed to the last valid day of the month.

   This instance is immutable and unaffected by this method call.

  month - the month-of-year to set in the result, from 1 (January) to 12 (December) - `int`

  returns: a LocalDateTime based on this date-time with the requested month, not null - `java.time.LocalDateTime`

  throws: java.time.DateTimeException - if the month-of-year value is invalid"
  ([^java.time.LocalDateTime this ^Integer month]
    (-> this (.withMonth month))))

(defn equal?
  "Checks if this date-time is equal to the specified date-time.

   This checks to see if this date-time represents the same point on the
   local time-line as the other date-time.


     LocalDate a = LocalDateTime.of(2012, 6, 30, 12, 00);
     LocalDate b = LocalDateTime.of(2012, 7, 1, 12, 00);
     a.isEqual(b) == false
     a.isEqual(a) == true
     b.isEqual(a) == false

   This method only considers the position of the two date-times on the local time-line.
   It does not take into account the chronology, or calendar system.
   This is different from the comparison in compareTo(ChronoLocalDateTime),
   but is the same approach as ChronoLocalDateTime.timeLineOrder().

  other - the other date-time to compare to, not null - `java.time.chrono.ChronoLocalDateTime<?>`

  returns: true if this date-time is equal to the specified date-time - `boolean`"
  ([^java.time.LocalDateTime this ^java.time.chrono.ChronoLocalDateTime other]
    (-> this (.isEqual other))))

(defn get-nano
  "Gets the nano-of-second field.

  returns: the nano-of-second, from 0 to 999,999,999 - `int`"
  ([^java.time.LocalDateTime this]
    (-> this (.getNano))))

(defn get-year
  "Gets the year field.

   This method returns the primitive int value for the year.

   The year returned by this method is proleptic as per get(YEAR).
   To obtain the year-of-era, use get(YEAR_OF_ERA).

  returns: the year, from MIN_YEAR to MAX_YEAR - `int`"
  ([^java.time.LocalDateTime this]
    (-> this (.getYear))))

(defn minus-seconds
  "Returns a copy of this LocalDateTime with the specified number of seconds subtracted.

   This instance is immutable and unaffected by this method call.

  seconds - the seconds to subtract, may be negative - `long`

  returns: a LocalDateTime based on this date-time with the seconds subtracted, not null - `java.time.LocalDateTime`

  throws: java.time.DateTimeException - if the result exceeds the supported date range"
  ([^java.time.LocalDateTime this ^Long seconds]
    (-> this (.minusSeconds seconds))))

(defn get-second
  "Gets the second-of-minute field.

  returns: the second-of-minute, from 0 to 59 - `int`"
  ([^java.time.LocalDateTime this]
    (-> this (.getSecond))))

(defn plus-nanos
  "Returns a copy of this LocalDateTime with the specified number of nanoseconds added.

   This instance is immutable and unaffected by this method call.

  nanos - the nanos to add, may be negative - `long`

  returns: a LocalDateTime based on this date-time with the nanoseconds added, not null - `java.time.LocalDateTime`

  throws: java.time.DateTimeException - if the result exceeds the supported date range"
  ([^java.time.LocalDateTime this ^Long nanos]
    (-> this (.plusNanos nanos))))

(defn get-day-of-year
  "Gets the day-of-year field.

   This method returns the primitive int value for the day-of-year.

  returns: the day-of-year, from 1 to 365, or 366 in a leap year - `int`"
  ([^java.time.LocalDateTime this]
    (-> this (.getDayOfYear))))

(defn plus
  "Returns a copy of this date-time with the specified amount added.

   This returns a LocalDateTime, based on this one, with the amount
   in terms of the unit added. If it is not possible to add the amount, because the
   unit is not supported or for some other reason, an exception is thrown.

   If the field is a ChronoUnit then the addition is implemented here.
   Date units are added as per LocalDate.plus(long, TemporalUnit).
   Time units are added as per LocalTime.plus(long, TemporalUnit) with
   any overflow in days added equivalent to using plusDays(long).

   If the field is not a ChronoUnit, then the result of this method
   is obtained by invoking TemporalUnit.addTo(Temporal, long)
   passing this as the argument. In this case, the unit determines
   whether and how to perform the addition.

   This instance is immutable and unaffected by this method call.

  amount-to-add - the amount of the unit to add to the result, may be negative - `long`
  unit - the unit of the amount to add, not null - `java.time.temporal.TemporalUnit`

  returns: a LocalDateTime based on this date-time with the specified amount added, not null - `java.time.LocalDateTime`

  throws: java.time.DateTimeException - if the addition cannot be made"
  ([^java.time.LocalDateTime this ^Long amount-to-add ^java.time.temporal.TemporalUnit unit]
    (-> this (.plus amount-to-add unit)))
  ([^java.time.LocalDateTime this ^java.time.temporal.TemporalAmount amount-to-add]
    (-> this (.plus amount-to-add))))

(defn with-hour
  "Returns a copy of this LocalDateTime with the hour-of-day altered.

   This instance is immutable and unaffected by this method call.

  hour - the hour-of-day to set in the result, from 0 to 23 - `int`

  returns: a LocalDateTime based on this date-time with the requested hour, not null - `java.time.LocalDateTime`

  throws: java.time.DateTimeException - if the hour value is invalid"
  ([^java.time.LocalDateTime this ^Integer hour]
    (-> this (.withHour hour))))

(defn with-minute
  "Returns a copy of this LocalDateTime with the minute-of-hour altered.

   This instance is immutable and unaffected by this method call.

  minute - the minute-of-hour to set in the result, from 0 to 59 - `int`

  returns: a LocalDateTime based on this date-time with the requested minute, not null - `java.time.LocalDateTime`

  throws: java.time.DateTimeException - if the minute value is invalid"
  ([^java.time.LocalDateTime this ^Integer minute]
    (-> this (.withMinute minute))))

(defn plus-minutes
  "Returns a copy of this LocalDateTime with the specified number of minutes added.

   This instance is immutable and unaffected by this method call.

  minutes - the minutes to add, may be negative - `long`

  returns: a LocalDateTime based on this date-time with the minutes added, not null - `java.time.LocalDateTime`

  throws: java.time.DateTimeException - if the result exceeds the supported date range"
  ([^java.time.LocalDateTime this ^Long minutes]
    (-> this (.plusMinutes minutes))))

(defn query
  "Queries this date-time using the specified query.

   This queries this date-time using the specified query strategy object.
   The TemporalQuery object defines the logic to be used to
   obtain the result. Read the documentation of the query to understand
   what the result of this method will be.

   The result of this method is obtained by invoking the
   TemporalQuery.queryFrom(TemporalAccessor) method on the
   specified query passing this as the argument.

  query - the query to invoke, not null - `java.time.temporal.TemporalQuery<R>`

  returns: the query result, null may be returned (defined by the query) - `<R> R`

  throws: java.time.DateTimeException - if unable to query (defined by the query)"
  ([^java.time.LocalDateTime this ^java.time.temporal.TemporalQuery query]
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
  ([^java.time.LocalDateTime this]
    (-> this (.getDayOfWeek))))

(defn to-string
  "Outputs this date-time as a String, such as 2007-12-03T10:15:30.

   The output will be one of the following ISO-8601 formats:

   uuuu-MM-dd'T'HH:mm
   uuuu-MM-dd'T'HH:mm:ss
   uuuu-MM-dd'T'HH:mm:ss.SSS
   uuuu-MM-dd'T'HH:mm:ss.SSSSSS
   uuuu-MM-dd'T'HH:mm:ss.SSSSSSSSS

   The format used will be the shortest that outputs the full value of
   the time where the omitted parts are implied to be zero.

  returns: a string representation of this date-time, not null - `java.lang.String`"
  ([^java.time.LocalDateTime this]
    (-> this (.toString))))

(defn plus-months
  "Returns a copy of this LocalDateTime with the specified number of months added.

   This method adds the specified amount to the months field in three steps:

   Add the input months to the month-of-year field
   Check if the resulting date would be invalid
   Adjust the day-of-month to the last valid day if necessary


   For example, 2007-03-31 plus one month would result in the invalid date
   2007-04-31. Instead of returning an invalid result, the last valid day
   of the month, 2007-04-30, is selected instead.

   This instance is immutable and unaffected by this method call.

  months - the months to add, may be negative - `long`

  returns: a LocalDateTime based on this date-time with the months added, not null - `java.time.LocalDateTime`

  throws: java.time.DateTimeException - if the result exceeds the supported date range"
  ([^java.time.LocalDateTime this ^Long months]
    (-> this (.plusMonths months))))

(defn before?
  "Checks if this date-time is before the specified date-time.

   This checks to see if this date-time represents a point on the
   local time-line before the other date-time.


     LocalDate a = LocalDateTime.of(2012, 6, 30, 12, 00);
     LocalDate b = LocalDateTime.of(2012, 7, 1, 12, 00);
     a.isBefore(b) == true
     a.isBefore(a) == false
     b.isBefore(a) == false

   This method only considers the position of the two date-times on the local time-line.
   It does not take into account the chronology, or calendar system.
   This is different from the comparison in compareTo(ChronoLocalDateTime),
   but is the same approach as ChronoLocalDateTime.timeLineOrder().

  other - the other date-time to compare to, not null - `java.time.chrono.ChronoLocalDateTime<?>`

  returns: true if this date-time is before the specified date-time - `boolean`"
  ([^java.time.LocalDateTime this ^java.time.chrono.ChronoLocalDateTime other]
    (-> this (.isBefore other))))

(defn minus-months
  "Returns a copy of this LocalDateTime with the specified number of months subtracted.

   This method subtracts the specified amount from the months field in three steps:

   Subtract the input months from the month-of-year field
   Check if the resulting date would be invalid
   Adjust the day-of-month to the last valid day if necessary


   For example, 2007-03-31 minus one month would result in the invalid date
   2007-04-31. Instead of returning an invalid result, the last valid day
   of the month, 2007-04-30, is selected instead.

   This instance is immutable and unaffected by this method call.

  months - the months to subtract, may be negative - `long`

  returns: a LocalDateTime based on this date-time with the months subtracted, not null - `java.time.LocalDateTime`

  throws: java.time.DateTimeException - if the result exceeds the supported date range"
  ([^java.time.LocalDateTime this ^Long months]
    (-> this (.minusMonths months))))

(defn minus
  "Returns a copy of this date-time with the specified amount subtracted.

   This returns a LocalDateTime, based on this one, with the amount
   in terms of the unit subtracted. If it is not possible to subtract the amount,
   because the unit is not supported or for some other reason, an exception is thrown.

   This method is equivalent to plus(long, TemporalUnit) with the amount negated.
   See that method for a full description of how addition, and thus subtraction, works.

   This instance is immutable and unaffected by this method call.

  amount-to-subtract - the amount of the unit to subtract from the result, may be negative - `long`
  unit - the unit of the amount to subtract, not null - `java.time.temporal.TemporalUnit`

  returns: a LocalDateTime based on this date-time with the specified amount subtracted, not null - `java.time.LocalDateTime`

  throws: java.time.DateTimeException - if the subtraction cannot be made"
  ([^java.time.LocalDateTime this ^Long amount-to-subtract ^java.time.temporal.TemporalUnit unit]
    (-> this (.minus amount-to-subtract unit)))
  ([^java.time.LocalDateTime this ^java.time.temporal.TemporalAmount amount-to-subtract]
    (-> this (.minus amount-to-subtract))))

(defn at-zone
  "Combines this date-time with a time-zone to create a ZonedDateTime.

   This returns a ZonedDateTime formed from this date-time at the
   specified time-zone. The result will match this date-time as closely as possible.
   Time-zone rules, such as daylight savings, mean that not every local date-time
   is valid for the specified zone, thus the local date-time may be adjusted.

   The local date-time is resolved to a single instant on the time-line.
   This is achieved by finding a valid offset from UTC/Greenwich for the local
   date-time as defined by the rules of the zone ID.

   In most cases, there is only one valid offset for a local date-time.
   In the case of an overlap, where clocks are set back, there are two valid offsets.
   This method uses the earlier offset typically corresponding to `summer`.

   In the case of a gap, where clocks jump forward, there is no valid offset.
   Instead, the local date-time is adjusted to be later by the length of the gap.
   For a typical one hour daylight savings change, the local date-time will be
   moved one hour later into the offset typically corresponding to `summer`.

   To obtain the later offset during an overlap, call
   ZonedDateTime.withLaterOffsetAtOverlap() on the result of this method.
   To throw an exception when there is a gap or overlap, use
   ZonedDateTime.ofStrict(LocalDateTime, ZoneOffset, ZoneId).

  zone - the time-zone to use, not null - `java.time.ZoneId`

  returns: the zoned date-time formed from this date-time, not null - `java.time.ZonedDateTime`"
  ([^java.time.LocalDateTime this ^java.time.ZoneId zone]
    (-> this (.atZone zone))))

(defn plus-hours
  "Returns a copy of this LocalDateTime with the specified number of hours added.

   This instance is immutable and unaffected by this method call.

  hours - the hours to add, may be negative - `long`

  returns: a LocalDateTime based on this date-time with the hours added, not null - `java.time.LocalDateTime`

  throws: java.time.DateTimeException - if the result exceeds the supported date range"
  ([^java.time.LocalDateTime this ^Long hours]
    (-> this (.plusHours hours))))

(defn plus-days
  "Returns a copy of this LocalDateTime with the specified number of days added.

   This method adds the specified amount to the days field incrementing the
   month and year fields as necessary to ensure the result remains valid.
   The result is only invalid if the maximum/minimum year is exceeded.

   For example, 2008-12-31 plus one day would result in 2009-01-01.

   This instance is immutable and unaffected by this method call.

  days - the days to add, may be negative - `long`

  returns: a LocalDateTime based on this date-time with the days added, not null - `java.time.LocalDateTime`

  throws: java.time.DateTimeException - if the result exceeds the supported date range"
  ([^java.time.LocalDateTime this ^Long days]
    (-> this (.plusDays days))))

(defn to-local-time
  "Gets the LocalTime part of this date-time.

   This returns a LocalTime with the same hour, minute, second and
   nanosecond as this date-time.

  returns: the time part of this date-time, not null - `java.time.LocalTime`"
  ([^java.time.LocalDateTime this]
    (-> this (.toLocalTime))))

(defn get-long
  "Gets the value of the specified field from this date-time as a long.

   This queries this date-time for the value of the specified field.
   If it is not possible to return the value, because the field is not supported
   or for some other reason, an exception is thrown.

   If the field is a ChronoField then the query is implemented here.
   The supported fields will return valid
   values based on this date-time.
   All other ChronoField instances will throw an UnsupportedTemporalTypeException.

   If the field is not a ChronoField, then the result of this method
   is obtained by invoking TemporalField.getFrom(TemporalAccessor)
   passing this as the argument. Whether the value can be obtained,
   and what the value represents, is determined by the field.

  field - the field to get, not null - `java.time.temporal.TemporalField`

  returns: the value for the field - `long`

  throws: java.time.DateTimeException - if a value for the field cannot be obtained"
  ([^java.time.LocalDateTime this ^java.time.temporal.TemporalField field]
    (-> this (.getLong field))))

(defn with-year
  "Returns a copy of this LocalDateTime with the year altered.

   The time does not affect the calculation and will be the same in the result.
   If the day-of-month is invalid for the year, it will be changed to the last valid day of the month.

   This instance is immutable and unaffected by this method call.

  year - the year to set in the result, from MIN_YEAR to MAX_YEAR - `int`

  returns: a LocalDateTime based on this date-time with the requested year, not null - `java.time.LocalDateTime`

  throws: java.time.DateTimeException - if the year value is invalid"
  ([^java.time.LocalDateTime this ^Integer year]
    (-> this (.withYear year))))

(defn with-nano
  "Returns a copy of this LocalDateTime with the nano-of-second altered.

   This instance is immutable and unaffected by this method call.

  nano-of-second - the nano-of-second to set in the result, from 0 to 999,999,999 - `int`

  returns: a LocalDateTime based on this date-time with the requested nanosecond, not null - `java.time.LocalDateTime`

  throws: java.time.DateTimeException - if the nano value is invalid"
  ([^java.time.LocalDateTime this ^Integer nano-of-second]
    (-> this (.withNano nano-of-second))))

(defn until
  "Calculates the amount of time until another date-time in terms of the specified unit.

   This calculates the amount of time between two LocalDateTime
   objects in terms of a single TemporalUnit.
   The start and end points are this and the specified date-time.
   The result will be negative if the end is before the start.
   The Temporal passed to this method is converted to a
   LocalDateTime using from(TemporalAccessor).
   For example, the amount in days between two date-times can be calculated
   using startDateTime.until(endDateTime, DAYS).

   The calculation returns a whole number, representing the number of
   complete units between the two date-times.
   For example, the amount in months between 2012-06-15T00:00 and 2012-08-14T23:59
   will only be one month as it is one minute short of two months.

   There are two equivalent ways of using this method.
   The first is to invoke this method.
   The second is to use TemporalUnit.between(Temporal, Temporal):


     // these two lines are equivalent
     amount = start.until(end, MONTHS);
     amount = MONTHS.between(start, end);
   The choice should be made based on which makes the code more readable.

   The calculation is implemented in this method for ChronoUnit.
   The units NANOS, MICROS, MILLIS, SECONDS,
   MINUTES, HOURS and HALF_DAYS, DAYS,
   WEEKS, MONTHS, YEARS, DECADES,
   CENTURIES, MILLENNIA and ERAS are supported.
   Other ChronoUnit values will throw an exception.

   If the unit is not a ChronoUnit, then the result of this method
   is obtained by invoking TemporalUnit.between(Temporal, Temporal)
   passing this as the first argument and the converted input temporal
   as the second argument.

   This instance is immutable and unaffected by this method call.

  end-exclusive - the end date, exclusive, which is converted to a LocalDateTime, not null - `java.time.temporal.Temporal`
  unit - the unit to measure the amount in, not null - `java.time.temporal.TemporalUnit`

  returns: the amount of time between this date-time and the end date-time - `long`

  throws: java.time.DateTimeException - if the amount cannot be calculated, or the end temporal cannot be converted to a LocalDateTime"
  ([^java.time.LocalDateTime this ^java.time.temporal.Temporal end-exclusive ^java.time.temporal.TemporalUnit unit]
    (-> this (.until end-exclusive unit))))

(defn with-day-of-month
  "Returns a copy of this LocalDateTime with the day-of-month altered.

   If the resulting date-time is invalid, an exception is thrown.
   The time does not affect the calculation and will be the same in the result.

   This instance is immutable and unaffected by this method call.

  day-of-month - the day-of-month to set in the result, from 1 to 28-31 - `int`

  returns: a LocalDateTime based on this date-time with the requested day, not null - `java.time.LocalDateTime`

  throws: java.time.DateTimeException - if the day-of-month value is invalid, or if the day-of-month is invalid for the month-year"
  ([^java.time.LocalDateTime this ^Integer day-of-month]
    (-> this (.withDayOfMonth day-of-month))))

(defn get-day-of-month
  "Gets the day-of-month field.

   This method returns the primitive int value for the day-of-month.

  returns: the day-of-month, from 1 to 31 - `int`"
  ([^java.time.LocalDateTime this]
    (-> this (.getDayOfMonth))))

(defn after?
  "Checks if this date-time is after the specified date-time.

   This checks to see if this date-time represents a point on the
   local time-line after the other date-time.


     LocalDate a = LocalDateTime.of(2012, 6, 30, 12, 00);
     LocalDate b = LocalDateTime.of(2012, 7, 1, 12, 00);
     a.isAfter(b) == false
     a.isAfter(a) == false
     b.isAfter(a) == true

   This method only considers the position of the two date-times on the local time-line.
   It does not take into account the chronology, or calendar system.
   This is different from the comparison in compareTo(ChronoLocalDateTime),
   but is the same approach as ChronoLocalDateTime.timeLineOrder().

  other - the other date-time to compare to, not null - `java.time.chrono.ChronoLocalDateTime<?>`

  returns: true if this date-time is after the specified date-time - `boolean`"
  ([^java.time.LocalDateTime this ^java.time.chrono.ChronoLocalDateTime other]
    (-> this (.isAfter other))))

(defn minus-nanos
  "Returns a copy of this LocalDateTime with the specified number of nanoseconds subtracted.

   This instance is immutable and unaffected by this method call.

  nanos - the nanos to subtract, may be negative - `long`

  returns: a LocalDateTime based on this date-time with the nanoseconds subtracted, not null - `java.time.LocalDateTime`

  throws: java.time.DateTimeException - if the result exceeds the supported date range"
  ([^java.time.LocalDateTime this ^Long nanos]
    (-> this (.minusNanos nanos))))

(defn supported?
  "Checks if the specified field is supported.

   This checks if this date-time can be queried for the specified field.
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

  returns: true if the field is supported on this date-time, false if not - `boolean`"
  ([^java.time.LocalDateTime this ^java.time.temporal.TemporalField field]
    (-> this (.isSupported field))))

(defn minus-years
  "Returns a copy of this LocalDateTime with the specified number of years subtracted.

   This method subtracts the specified amount from the years field in three steps:

   Subtract the input years from the year field
   Check if the resulting date would be invalid
   Adjust the day-of-month to the last valid day if necessary


   For example, 2008-02-29 (leap year) minus one year would result in the
   invalid date 2009-02-29 (standard year). Instead of returning an invalid
   result, the last valid day of the month, 2009-02-28, is selected instead.

   This instance is immutable and unaffected by this method call.

  years - the years to subtract, may be negative - `long`

  returns: a LocalDateTime based on this date-time with the years subtracted, not null - `java.time.LocalDateTime`

  throws: java.time.DateTimeException - if the result exceeds the supported date range"
  ([^java.time.LocalDateTime this ^Long years]
    (-> this (.minusYears years))))

(defn with-second
  "Returns a copy of this LocalDateTime with the second-of-minute altered.

   This instance is immutable and unaffected by this method call.

  second - the second-of-minute to set in the result, from 0 to 59 - `int`

  returns: a LocalDateTime based on this date-time with the requested second, not null - `java.time.LocalDateTime`

  throws: java.time.DateTimeException - if the second value is invalid"
  ([^java.time.LocalDateTime this ^Integer second]
    (-> this (.withSecond second))))

(defn to-local-date
  "Gets the LocalDate part of this date-time.

   This returns a LocalDate with the same year, month and day
   as this date-time.

  returns: the date part of this date-time, not null - `java.time.LocalDate`"
  ([^java.time.LocalDateTime this]
    (-> this (.toLocalDate))))

(defn get-minute
  "Gets the minute-of-hour field.

  returns: the minute-of-hour, from 0 to 59 - `int`"
  ([^java.time.LocalDateTime this]
    (-> this (.getMinute))))

(defn hash-code
  "A hash code for this date-time.

  returns: a suitable hash code - `int`"
  ([^java.time.LocalDateTime this]
    (-> this (.hashCode))))

(defn adjust-into
  "Adjusts the specified temporal object to have the same date and time as this object.

   This returns a temporal object of the same observable type as the input
   with the date and time changed to be the same as this.

   The adjustment is equivalent to using Temporal.with(TemporalField, long)
   twice, passing ChronoField.EPOCH_DAY and
   ChronoField.NANO_OF_DAY as the fields.

   In most cases, it is clearer to reverse the calling pattern by using
   Temporal.with(TemporalAdjuster):


     // these two lines are equivalent, but the second approach is recommended
     temporal = thisLocalDateTime.adjustInto(temporal);
     temporal = temporal.with(thisLocalDateTime);

   This instance is immutable and unaffected by this method call.

  temporal - the target object to be adjusted, not null - `java.time.temporal.Temporal`

  returns: the adjusted object, not null - `java.time.temporal.Temporal`

  throws: java.time.DateTimeException - if unable to make the adjustment"
  ([^java.time.LocalDateTime this ^java.time.temporal.Temporal temporal]
    (-> this (.adjustInto temporal))))

(defn with
  "Returns a copy of this date-time with the specified field set to a new value.

   This returns a LocalDateTime, based on this one, with the value
   for the specified field changed.
   This can be used to change any supported field, such as the year, month or day-of-month.
   If it is not possible to set the value, because the field is not supported or for
   some other reason, an exception is thrown.

   In some cases, changing the specified field can cause the resulting date-time to become invalid,
   such as changing the month from 31st January to February would make the day-of-month invalid.
   In cases like this, the field is responsible for resolving the date. Typically it will choose
   the previous valid date, which would be the last valid day of February in this example.

   If the field is a ChronoField then the adjustment is implemented here.
   The supported fields will behave as per
   the matching method on LocalDate
   or LocalTime.
   All other ChronoField instances will throw an UnsupportedTemporalTypeException.

   If the field is not a ChronoField, then the result of this method
   is obtained by invoking TemporalField.adjustInto(Temporal, long)
   passing this as the argument. In this case, the field determines
   whether and how to adjust the instant.

   This instance is immutable and unaffected by this method call.

  field - the field to set in the result, not null - `java.time.temporal.TemporalField`
  new-value - the new value of the field in the result - `long`

  returns: a LocalDateTime based on this with the specified field set, not null - `java.time.LocalDateTime`

  throws: java.time.DateTimeException - if the field cannot be set"
  ([^java.time.LocalDateTime this ^java.time.temporal.TemporalField field ^Long new-value]
    (-> this (.with field new-value)))
  ([^java.time.LocalDateTime this ^java.time.temporal.TemporalAdjuster adjuster]
    (-> this (.with adjuster))))

(defn get-month-value
  "Gets the month-of-year field from 1 to 12.

   This method returns the month as an int from 1 to 12.
   Application code is frequently clearer if the enum Month
   is used by calling getMonth().

  returns: the month-of-year, from 1 to 12 - `int`"
  ([^java.time.LocalDateTime this]
    (-> this (.getMonthValue))))

(defn with-day-of-year
  "Returns a copy of this LocalDateTime with the day-of-year altered.

   If the resulting date-time is invalid, an exception is thrown.

   This instance is immutable and unaffected by this method call.

  day-of-year - the day-of-year to set in the result, from 1 to 365-366 - `int`

  returns: a LocalDateTime based on this date with the requested day, not null - `java.time.LocalDateTime`

  throws: java.time.DateTimeException - if the day-of-year value is invalid, or if the day-of-year is invalid for the year"
  ([^java.time.LocalDateTime this ^Integer day-of-year]
    (-> this (.withDayOfYear day-of-year))))

(defn compare-to
  "Compares this date-time to another date-time.

   The comparison is primarily based on the date-time, from earliest to latest.
   It is `consistent with equals`, as defined by Comparable.

   If all the date-times being compared are instances of LocalDateTime,
   then the comparison will be entirely based on the date-time.
   If some dates being compared are in different chronologies, then the
   chronology is also considered, see ChronoLocalDateTime.compareTo(java.time.chrono.ChronoLocalDateTime<?>).

  other - the other date-time to compare to, not null - `java.time.chrono.ChronoLocalDateTime<?>`

  returns: the comparator value, negative if less, positive if greater - `int`"
  ([^java.time.LocalDateTime this ^java.time.chrono.ChronoLocalDateTime other]
    (-> this (.compareTo other))))

(defn get-month
  "Gets the month-of-year field using the Month enum.

   This method returns the enum Month for the month.
   This avoids confusion as to what int values mean.
   If you need access to the primitive int value then the enum
   provides the int value.

  returns: the month-of-year, not null - `java.time.Month`"
  ([^java.time.LocalDateTime this]
    (-> this (.getMonth))))

(defn plus-seconds
  "Returns a copy of this LocalDateTime with the specified number of seconds added.

   This instance is immutable and unaffected by this method call.

  seconds - the seconds to add, may be negative - `long`

  returns: a LocalDateTime based on this date-time with the seconds added, not null - `java.time.LocalDateTime`

  throws: java.time.DateTimeException - if the result exceeds the supported date range"
  ([^java.time.LocalDateTime this ^Long seconds]
    (-> this (.plusSeconds seconds))))

(defn get
  "Gets the value of the specified field from this date-time as an int.

   This queries this date-time for the value of the specified field.
   The returned value will always be within the valid range of values for the field.
   If it is not possible to return the value, because the field is not supported
   or for some other reason, an exception is thrown.

   If the field is a ChronoField then the query is implemented here.
   The supported fields will return valid
   values based on this date-time, except NANO_OF_DAY, MICRO_OF_DAY,
   EPOCH_DAY and PROLEPTIC_MONTH which are too large to fit in
   an int and throw a DateTimeException.
   All other ChronoField instances will throw an UnsupportedTemporalTypeException.

   If the field is not a ChronoField, then the result of this method
   is obtained by invoking TemporalField.getFrom(TemporalAccessor)
   passing this as the argument. Whether the value can be obtained,
   and what the value represents, is determined by the field.

  field - the field to get, not null - `java.time.temporal.TemporalField`

  returns: the value for the field - `int`

  throws: java.time.DateTimeException - if a value for the field cannot be obtained or the value is outside the range of valid values for the field"
  ([^java.time.LocalDateTime this ^java.time.temporal.TemporalField field]
    (-> this (.get field))))

(defn equals
  "Checks if this date-time is equal to another date-time.

   Compares this LocalDateTime with another ensuring that the date-time is the same.
   Only objects of type LocalDateTime are compared, other types return false.

  obj - the object to check, null returns false - `java.lang.Object`

  returns: true if this is equal to the other date-time - `boolean`"
  ([^java.time.LocalDateTime this ^java.lang.Object obj]
    (-> this (.equals obj))))

(defn format
  "Formats this date-time using the specified formatter.

   This date-time will be passed to the formatter to produce a string.

  formatter - the formatter to use, not null - `java.time.format.DateTimeFormatter`

  returns: the formatted date-time string, not null - `java.lang.String`

  throws: java.time.DateTimeException - if an error occurs during printing"
  ([^java.time.LocalDateTime this ^java.time.format.DateTimeFormatter formatter]
    (-> this (.format formatter))))

(defn plus-years
  "Returns a copy of this LocalDateTime with the specified number of years added.

   This method adds the specified amount to the years field in three steps:

   Add the input years to the year field
   Check if the resulting date would be invalid
   Adjust the day-of-month to the last valid day if necessary


   For example, 2008-02-29 (leap year) plus one year would result in the
   invalid date 2009-02-29 (standard year). Instead of returning an invalid
   result, the last valid day of the month, 2009-02-28, is selected instead.

   This instance is immutable and unaffected by this method call.

  years - the years to add, may be negative - `long`

  returns: a LocalDateTime based on this date-time with the years added, not null - `java.time.LocalDateTime`

  throws: java.time.DateTimeException - if the result exceeds the supported date range"
  ([^java.time.LocalDateTime this ^Long years]
    (-> this (.plusYears years))))

(defn minus-days
  "Returns a copy of this LocalDateTime with the specified number of days subtracted.

   This method subtracts the specified amount from the days field decrementing the
   month and year fields as necessary to ensure the result remains valid.
   The result is only invalid if the maximum/minimum year is exceeded.

   For example, 2009-01-01 minus one day would result in 2008-12-31.

   This instance is immutable and unaffected by this method call.

  days - the days to subtract, may be negative - `long`

  returns: a LocalDateTime based on this date-time with the days subtracted, not null - `java.time.LocalDateTime`

  throws: java.time.DateTimeException - if the result exceeds the supported date range"
  ([^java.time.LocalDateTime this ^Long days]
    (-> this (.minusDays days))))

