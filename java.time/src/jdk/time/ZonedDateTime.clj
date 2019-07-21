(ns jdk.time.ZonedDateTime
  "A date-time with a time-zone in the ISO-8601 calendar system,
  such as 2007-12-03T10:15:30+01:00 Europe/Paris.

  ZonedDateTime is an immutable representation of a date-time with a time-zone.
  This class stores all date and time fields, to a precision of nanoseconds,
  and a time-zone, with a zone offset used to handle ambiguous local date-times.
  For example, the value
  \"2nd October 2007 at 13:45.30.123456789 02:00 in the Europe/Paris time-zone\"
  can be stored in a ZonedDateTime.

  This class handles conversion from the local time-line of LocalDateTime
  to the instant time-line of Instant.
  The difference between the two time-lines is the offset from UTC/Greenwich,
  represented by a ZoneOffset.

  Converting between the two time-lines involves calculating the offset using the
  rules accessed from the ZoneId.
  Obtaining the offset for an instant is simple, as there is exactly one valid
  offset for each instant. By contrast, obtaining the offset for a local date-time
  is not straightforward. There are three cases:

  Normal, with one valid offset. For the vast majority of the year, the normal
   case applies, where there is a single valid offset for the local date-time.
  Gap, with zero valid offsets. This is when clocks jump forward typically
   due to the spring daylight savings change from \"winter\" to \"summer\".
   In a gap there are local date-time values with no valid offset.
  Overlap, with two valid offsets. This is when clocks are set back typically
   due to the autumn daylight savings change from \"summer\" to \"winter\".
   In an overlap there are local date-time values with two valid offsets.


  Any method that converts directly or implicitly from a local date-time to an
  instant by obtaining the offset has the potential to be complicated.

  For Gaps, the general strategy is that if the local date-time falls in the
  middle of a Gap, then the resulting zoned date-time will have a local date-time
  shifted forwards by the length of the Gap, resulting in a date-time in the later
  offset, typically \"summer\" time.

  For Overlaps, the general strategy is that if the local date-time falls in the
  middle of an Overlap, then the previous offset will be retained. If there is no
  previous offset, or the previous offset is invalid, then the earlier offset is
  used, typically \"summer\" time.. Two additional methods,
  withEarlierOffsetAtOverlap() and withLaterOffsetAtOverlap(),
  help manage the case of an overlap.

  In terms of design, this class should be viewed primarily as the combination
  of a LocalDateTime and a ZoneId. The ZoneOffset is
  a vital, but secondary, piece of information, used to ensure that the class
  represents an instant, especially during a daylight savings overlap.


  This is a value-based
  class; use of identity-sensitive operations (including reference equality
  (==), identity hash code, or synchronization) on instances of
  ZonedDateTime may have unpredictable results and should be avoided.
  The equals method should be used for comparisons."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.time ZonedDateTime]))

(defn *now
  "Obtains the current date-time from the system clock in the specified time-zone.

   This will query the system clock to obtain the current date-time.
   Specifying the time-zone avoids dependence on the default time-zone.
   The offset will be calculated from the specified time-zone.

   Using this method will prevent the ability to use an alternate clock for testing
   because the clock is hard-coded.

  zone - the zone ID to use, not null - `java.time.ZoneId`

  returns: the current date-time using the system clock, not null - `java.time.ZonedDateTime`"
  (^java.time.ZonedDateTime [^java.time.ZoneId zone]
    (ZonedDateTime/now zone))
  (^java.time.ZonedDateTime []
    (ZonedDateTime/now )))

(defn *of
  "Obtains an instance of ZonedDateTime from a year, month, day,
   hour, minute, second, nanosecond and time-zone.

   This creates a zoned date-time matching the local date-time of the seven
   specified fields as closely as possible.
   Time-zone rules, such as daylight savings, mean that not every local date-time
   is valid for the specified zone, thus the local date-time may be adjusted.

   The local date-time is resolved to a single instant on the time-line.
   This is achieved by finding a valid offset from UTC/Greenwich for the local
   date-time as defined by the rules of the zone ID.

   In most cases, there is only one valid offset for a local date-time.
   In the case of an overlap, when clocks are set back, there are two valid offsets.
   This method uses the earlier offset typically corresponding to \"summer\".

   In the case of a gap, when clocks jump forward, there is no valid offset.
   Instead, the local date-time is adjusted to be later by the length of the gap.
   For a typical one hour daylight savings change, the local date-time will be
   moved one hour later into the offset typically corresponding to \"summer\".

   This method exists primarily for writing test cases.
   Non test-code will typically use other methods to create an offset time.
   LocalDateTime has five additional convenience variants of the
   equivalent factory method taking fewer arguments.
   They are not provided here to reduce the footprint of the API.

  year - the year to represent, from MIN_YEAR to MAX_YEAR - `int`
  month - the month-of-year to represent, from 1 (January) to 12 (December) - `int`
  day-of-month - the day-of-month to represent, from 1 to 31 - `int`
  hour - the hour-of-day to represent, from 0 to 23 - `int`
  minute - the minute-of-hour to represent, from 0 to 59 - `int`
  second - the second-of-minute to represent, from 0 to 59 - `int`
  nano-of-second - the nano-of-second to represent, from 0 to 999,999,999 - `int`
  zone - the time-zone, not null - `java.time.ZoneId`

  returns: the offset date-time, not null - `java.time.ZonedDateTime`

  throws: java.time.DateTimeException - if the value of any field is out of range, or if the day-of-month is invalid for the month-year"
  (^java.time.ZonedDateTime [^Integer year ^Integer month ^Integer day-of-month ^Integer hour ^Integer minute ^Integer second ^Integer nano-of-second ^java.time.ZoneId zone]
    (ZonedDateTime/of year month day-of-month hour minute second nano-of-second zone))
  (^java.time.ZonedDateTime [^java.time.LocalDate date ^java.time.LocalTime time ^java.time.ZoneId zone]
    (ZonedDateTime/of date time zone))
  (^java.time.ZonedDateTime [^java.time.LocalDateTime local-date-time ^java.time.ZoneId zone]
    (ZonedDateTime/of local-date-time zone)))

(defn *of-local
  "Obtains an instance of ZonedDateTime from a local date-time
   using the preferred offset if possible.

   The local date-time is resolved to a single instant on the time-line.
   This is achieved by finding a valid offset from UTC/Greenwich for the local
   date-time as defined by the rules of the zone ID.

   In most cases, there is only one valid offset for a local date-time.
   In the case of an overlap, where clocks are set back, there are two valid offsets.
   If the preferred offset is one of the valid offsets then it is used.
   Otherwise the earlier valid offset is used, typically corresponding to \"summer\".

   In the case of a gap, where clocks jump forward, there is no valid offset.
   Instead, the local date-time is adjusted to be later by the length of the gap.
   For a typical one hour daylight savings change, the local date-time will be
   moved one hour later into the offset typically corresponding to \"summer\".

  local-date-time - the local date-time, not null - `java.time.LocalDateTime`
  zone - the time-zone, not null - `java.time.ZoneId`
  preferred-offset - the zone offset, null if no preference - `java.time.ZoneOffset`

  returns: the zoned date-time, not null - `java.time.ZonedDateTime`"
  (^java.time.ZonedDateTime [^java.time.LocalDateTime local-date-time ^java.time.ZoneId zone ^java.time.ZoneOffset preferred-offset]
    (ZonedDateTime/ofLocal local-date-time zone preferred-offset)))

(defn *of-instant
  "Obtains an instance of ZonedDateTime from the instant formed by combining
   the local date-time and offset.

   This creates a zoned date-time by combining
   the LocalDateTime and ZoneOffset.
   This combination uniquely specifies an instant without ambiguity.

   Converting an instant to a zoned date-time is simple as there is only one valid
   offset for each instant. If the valid offset is different to the offset specified,
   then the date-time and offset of the zoned date-time will differ from those specified.

   If the ZoneId to be used is a ZoneOffset, this method is equivalent
   to of(LocalDateTime, ZoneId).

  local-date-time - the local date-time, not null - `java.time.LocalDateTime`
  offset - the zone offset, not null - `java.time.ZoneOffset`
  zone - the time-zone, not null - `java.time.ZoneId`

  returns: the zoned date-time, not null - `java.time.ZonedDateTime`"
  (^java.time.ZonedDateTime [^java.time.LocalDateTime local-date-time ^java.time.ZoneOffset offset ^java.time.ZoneId zone]
    (ZonedDateTime/ofInstant local-date-time offset zone))
  (^java.time.ZonedDateTime [^java.time.Instant instant ^java.time.ZoneId zone]
    (ZonedDateTime/ofInstant instant zone)))

(defn *of-strict
  "Obtains an instance of ZonedDateTime strictly validating the
   combination of local date-time, offset and zone ID.

   This creates a zoned date-time ensuring that the offset is valid for the
   local date-time according to the rules of the specified zone.
   If the offset is invalid, an exception is thrown.

  local-date-time - the local date-time, not null - `java.time.LocalDateTime`
  offset - the zone offset, not null - `java.time.ZoneOffset`
  zone - the time-zone, not null - `java.time.ZoneId`

  returns: the zoned date-time, not null - `java.time.ZonedDateTime`"
  (^java.time.ZonedDateTime [^java.time.LocalDateTime local-date-time ^java.time.ZoneOffset offset ^java.time.ZoneId zone]
    (ZonedDateTime/ofStrict local-date-time offset zone)))

(defn *from
  "Obtains an instance of ZonedDateTime from a temporal object.

   This obtains a zoned date-time based on the specified temporal.
   A TemporalAccessor represents an arbitrary set of date and time information,
   which this factory converts to an instance of ZonedDateTime.

   The conversion will first obtain a ZoneId from the temporal object,
   falling back to a ZoneOffset if necessary. It will then try to obtain
   an Instant, falling back to a LocalDateTime if necessary.
   The result will be either the combination of ZoneId or ZoneOffset
   with Instant or LocalDateTime.
   Implementations are permitted to perform optimizations such as accessing
   those fields that are equivalent to the relevant objects.

   This method matches the signature of the functional interface TemporalQuery
   allowing it to be used as a query via method reference, ZonedDateTime::from.

  temporal - the temporal object to convert, not null - `java.time.temporal.TemporalAccessor`

  returns: the zoned date-time, not null - `java.time.ZonedDateTime`

  throws: java.time.DateTimeException - if unable to convert to an ZonedDateTime"
  (^java.time.ZonedDateTime [^java.time.temporal.TemporalAccessor temporal]
    (ZonedDateTime/from temporal)))

(defn *parse
  "Obtains an instance of ZonedDateTime from a text string using a specific formatter.

   The text is parsed using the formatter, returning a date-time.

  text - the text to parse, not null - `java.lang.CharSequence`
  formatter - the formatter to use, not null - `java.time.format.DateTimeFormatter`

  returns: the parsed zoned date-time, not null - `java.time.ZonedDateTime`

  throws: java.time.format.DateTimeParseException - if the text cannot be parsed"
  (^java.time.ZonedDateTime [^java.lang.CharSequence text ^java.time.format.DateTimeFormatter formatter]
    (ZonedDateTime/parse text formatter))
  (^java.time.ZonedDateTime [^java.lang.CharSequence text]
    (ZonedDateTime/parse text)))

(defn minus-minutes
  "Returns a copy of this ZonedDateTime with the specified number of minutes subtracted.

   This operates on the instant time-line, such that subtracting one minute will
   always be a duration of one minute earlier.
   This may cause the local date-time to change by an amount other than one minute.
   Note that this is a different approach to that used by days, months and years.

   This instance is immutable and unaffected by this method call.

  minutes - the minutes to subtract, may be negative - `long`

  returns: a ZonedDateTime based on this date-time with the minutes subtracted, not null - `java.time.ZonedDateTime`

  throws: java.time.DateTimeException - if the result exceeds the supported date range"
  (^java.time.ZonedDateTime [^ZonedDateTime this ^Long minutes]
    (-> this (.minusMinutes minutes))))

(defn truncated-to
  "Returns a copy of this ZonedDateTime with the time truncated.

   Truncation returns a copy of the original date-time with fields
   smaller than the specified unit set to zero.
   For example, truncating with the minutes unit
   will set the second-of-minute and nano-of-second field to zero.

   The unit must have a duration
   that divides into the length of a standard day without remainder.
   This includes all supplied time units on ChronoUnit and
   DAYS. Other units throw an exception.

   This operates on the local time-line,
   truncating
   the underlying local date-time. This is then converted back to a
   ZonedDateTime, using the zone ID to obtain the offset.

   When converting back to ZonedDateTime, if the local date-time is in an overlap,
   then the offset will be retained if possible, otherwise the earlier offset will be used.
   If in a gap, the local date-time will be adjusted forward by the length of the gap.

   This instance is immutable and unaffected by this method call.

  unit - the unit to truncate to, not null - `java.time.temporal.TemporalUnit`

  returns: a ZonedDateTime based on this date-time with the time truncated, not null - `java.time.ZonedDateTime`

  throws: java.time.DateTimeException - if unable to truncate"
  (^java.time.ZonedDateTime [^ZonedDateTime this ^java.time.temporal.TemporalUnit unit]
    (-> this (.truncatedTo unit))))

(defn minus-weeks
  "Returns a copy of this ZonedDateTime with the specified number of weeks subtracted.

   This operates on the local time-line,
   subtracting weeks to the local date-time.
   This is then converted back to a ZonedDateTime, using the zone ID
   to obtain the offset.

   When converting back to ZonedDateTime, if the local date-time is in an overlap,
   then the offset will be retained if possible, otherwise the earlier offset will be used.
   If in a gap, the local date-time will be adjusted forward by the length of the gap.

   This instance is immutable and unaffected by this method call.

  weeks - the weeks to subtract, may be negative - `long`

  returns: a ZonedDateTime based on this date-time with the weeks subtracted, not null - `java.time.ZonedDateTime`

  throws: java.time.DateTimeException - if the result exceeds the supported date range"
  (^java.time.ZonedDateTime [^ZonedDateTime this ^Long weeks]
    (-> this (.minusWeeks weeks))))

(defn plus-weeks
  "Returns a copy of this ZonedDateTime with the specified number of weeks added.

   This operates on the local time-line,
   adding weeks to the local date-time.
   This is then converted back to a ZonedDateTime, using the zone ID
   to obtain the offset.

   When converting back to ZonedDateTime, if the local date-time is in an overlap,
   then the offset will be retained if possible, otherwise the earlier offset will be used.
   If in a gap, the local date-time will be adjusted forward by the length of the gap.

   This instance is immutable and unaffected by this method call.

  weeks - the weeks to add, may be negative - `long`

  returns: a ZonedDateTime based on this date-time with the weeks added, not null - `java.time.ZonedDateTime`

  throws: java.time.DateTimeException - if the result exceeds the supported date range"
  (^java.time.ZonedDateTime [^ZonedDateTime this ^Long weeks]
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
  (^java.time.temporal.ValueRange [^ZonedDateTime this ^java.time.temporal.TemporalField field]
    (-> this (.range field))))

(defn with-earlier-offset-at-overlap
  "Returns a copy of this date-time changing the zone offset to the
   earlier of the two valid offsets at a local time-line overlap.

   This method only has any effect when the local time-line overlaps, such as
   at an autumn daylight savings cutover. In this scenario, there are two
   valid offsets for the local date-time. Calling this method will return
   a zoned date-time with the earlier of the two selected.

   If this method is called when it is not an overlap, this
   is returned.

   This instance is immutable and unaffected by this method call.

  returns: a ZonedDateTime based on this date-time with the earlier offset, not null - `java.time.ZonedDateTime`"
  (^java.time.ZonedDateTime [^ZonedDateTime this]
    (-> this (.withEarlierOffsetAtOverlap))))

(defn get-hour
  "Gets the hour-of-day field.

  returns: the hour-of-day, from 0 to 23 - `int`"
  (^Integer [^ZonedDateTime this]
    (-> this (.getHour))))

(defn minus-hours
  "Returns a copy of this ZonedDateTime with the specified number of hours subtracted.

   This operates on the instant time-line, such that subtracting one hour will
   always be a duration of one hour earlier.
   This may cause the local date-time to change by an amount other than one hour.
   Note that this is a different approach to that used by days, months and years,
   thus subtracting one day is not the same as adding 24 hours.

   For example, consider a time-zone where the spring DST cutover means that the
   local times 01:00 to 01:59 occur twice changing from offset 02:00 to 01:00.

   Subtracting one hour from 02:30+01:00 will result in 01:30+02:00
   Subtracting one hour from 01:30+01:00 will result in 01:30+02:00
   Subtracting one hour from 01:30+02:00 will result in 00:30+01:00
   Subtracting three hours from 02:30+01:00 will result in 00:30+02:00


   This instance is immutable and unaffected by this method call.

  hours - the hours to subtract, may be negative - `long`

  returns: a ZonedDateTime based on this date-time with the hours subtracted, not null - `java.time.ZonedDateTime`

  throws: java.time.DateTimeException - if the result exceeds the supported date range"
  (^java.time.ZonedDateTime [^ZonedDateTime this ^Long hours]
    (-> this (.minusHours hours))))

(defn with-month
  "Returns a copy of this ZonedDateTime with the month-of-year altered.

   This operates on the local time-line,
   changing the month of the local date-time.
   This is then converted back to a ZonedDateTime, using the zone ID
   to obtain the offset.

   When converting back to ZonedDateTime, if the local date-time is in an overlap,
   then the offset will be retained if possible, otherwise the earlier offset will be used.
   If in a gap, the local date-time will be adjusted forward by the length of the gap.

   This instance is immutable and unaffected by this method call.

  month - the month-of-year to set in the result, from 1 (January) to 12 (December) - `int`

  returns: a ZonedDateTime based on this date-time with the requested month, not null - `java.time.ZonedDateTime`

  throws: java.time.DateTimeException - if the month-of-year value is invalid"
  (^java.time.ZonedDateTime [^ZonedDateTime this ^Integer month]
    (-> this (.withMonth month))))

(defn get-nano
  "Gets the nano-of-second field.

  returns: the nano-of-second, from 0 to 999,999,999 - `int`"
  (^Integer [^ZonedDateTime this]
    (-> this (.getNano))))

(defn get-year
  "Gets the year field.

   This method returns the primitive int value for the year.

   The year returned by this method is proleptic as per get(YEAR).
   To obtain the year-of-era, use get(YEAR_OF_ERA).

  returns: the year, from MIN_YEAR to MAX_YEAR - `int`"
  (^Integer [^ZonedDateTime this]
    (-> this (.getYear))))

(defn minus-seconds
  "Returns a copy of this ZonedDateTime with the specified number of seconds subtracted.

   This operates on the instant time-line, such that subtracting one second will
   always be a duration of one second earlier.
   This may cause the local date-time to change by an amount other than one second.
   Note that this is a different approach to that used by days, months and years.

   This instance is immutable and unaffected by this method call.

  seconds - the seconds to subtract, may be negative - `long`

  returns: a ZonedDateTime based on this date-time with the seconds subtracted, not null - `java.time.ZonedDateTime`

  throws: java.time.DateTimeException - if the result exceeds the supported date range"
  (^java.time.ZonedDateTime [^ZonedDateTime this ^Long seconds]
    (-> this (.minusSeconds seconds))))

(defn get-second
  "Gets the second-of-minute field.

  returns: the second-of-minute, from 0 to 59 - `int`"
  (^Integer [^ZonedDateTime this]
    (-> this (.getSecond))))

(defn plus-nanos
  "Returns a copy of this ZonedDateTime with the specified number of nanoseconds added.

   This operates on the instant time-line, such that adding one nano will
   always be a duration of one nano later.
   This may cause the local date-time to change by an amount other than one nano.
   Note that this is a different approach to that used by days, months and years.

   This instance is immutable and unaffected by this method call.

  nanos - the nanos to add, may be negative - `long`

  returns: a ZonedDateTime based on this date-time with the nanoseconds added, not null - `java.time.ZonedDateTime`

  throws: java.time.DateTimeException - if the result exceeds the supported date range"
  (^java.time.ZonedDateTime [^ZonedDateTime this ^Long nanos]
    (-> this (.plusNanos nanos))))

(defn get-day-of-year
  "Gets the day-of-year field.

   This method returns the primitive int value for the day-of-year.

  returns: the day-of-year, from 1 to 365, or 366 in a leap year - `int`"
  (^Integer [^ZonedDateTime this]
    (-> this (.getDayOfYear))))

(defn plus
  "Returns a copy of this date-time with the specified amount added.

   This returns a ZonedDateTime, based on this one, with the amount
   in terms of the unit added. If it is not possible to add the amount, because the
   unit is not supported or for some other reason, an exception is thrown.

   If the field is a ChronoUnit then the addition is implemented here.
   The zone is not part of the calculation and will be unchanged in the result.
   The calculation for date and time units differ.

   Date units operate on the local time-line.
   The period is first added to the local date-time, then converted back
   to a zoned date-time using the zone ID.
   The conversion uses ofLocal(LocalDateTime, ZoneId, ZoneOffset)
   with the offset before the addition.

   Time units operate on the instant time-line.
   The period is first added to the local date-time, then converted back to
   a zoned date-time using the zone ID.
   The conversion uses ofInstant(LocalDateTime, ZoneOffset, ZoneId)
   with the offset before the addition.

   If the field is not a ChronoUnit, then the result of this method
   is obtained by invoking TemporalUnit.addTo(Temporal, long)
   passing this as the argument. In this case, the unit determines
   whether and how to perform the addition.

   This instance is immutable and unaffected by this method call.

  amount-to-add - the amount of the unit to add to the result, may be negative - `long`
  unit - the unit of the amount to add, not null - `java.time.temporal.TemporalUnit`

  returns: a ZonedDateTime based on this date-time with the specified amount added, not null - `java.time.ZonedDateTime`

  throws: java.time.DateTimeException - if the addition cannot be made"
  (^java.time.ZonedDateTime [^ZonedDateTime this ^Long amount-to-add ^java.time.temporal.TemporalUnit unit]
    (-> this (.plus amount-to-add unit)))
  (^java.time.ZonedDateTime [^ZonedDateTime this ^java.time.temporal.TemporalAmount amount-to-add]
    (-> this (.plus amount-to-add))))

(defn with-hour
  "Returns a copy of this ZonedDateTime with the hour-of-day altered.

   This operates on the local time-line,
   changing the time of the local date-time.
   This is then converted back to a ZonedDateTime, using the zone ID
   to obtain the offset.

   When converting back to ZonedDateTime, if the local date-time is in an overlap,
   then the offset will be retained if possible, otherwise the earlier offset will be used.
   If in a gap, the local date-time will be adjusted forward by the length of the gap.

   This instance is immutable and unaffected by this method call.

  hour - the hour-of-day to set in the result, from 0 to 23 - `int`

  returns: a ZonedDateTime based on this date-time with the requested hour, not null - `java.time.ZonedDateTime`

  throws: java.time.DateTimeException - if the hour value is invalid"
  (^java.time.ZonedDateTime [^ZonedDateTime this ^Integer hour]
    (-> this (.withHour hour))))

(defn with-minute
  "Returns a copy of this ZonedDateTime with the minute-of-hour altered.

   This operates on the local time-line,
   changing the time of the local date-time.
   This is then converted back to a ZonedDateTime, using the zone ID
   to obtain the offset.

   When converting back to ZonedDateTime, if the local date-time is in an overlap,
   then the offset will be retained if possible, otherwise the earlier offset will be used.
   If in a gap, the local date-time will be adjusted forward by the length of the gap.

   This instance is immutable and unaffected by this method call.

  minute - the minute-of-hour to set in the result, from 0 to 59 - `int`

  returns: a ZonedDateTime based on this date-time with the requested minute, not null - `java.time.ZonedDateTime`

  throws: java.time.DateTimeException - if the minute value is invalid"
  (^java.time.ZonedDateTime [^ZonedDateTime this ^Integer minute]
    (-> this (.withMinute minute))))

(defn plus-minutes
  "Returns a copy of this ZonedDateTime with the specified number of minutes added.

   This operates on the instant time-line, such that adding one minute will
   always be a duration of one minute later.
   This may cause the local date-time to change by an amount other than one minute.
   Note that this is a different approach to that used by days, months and years.

   This instance is immutable and unaffected by this method call.

  minutes - the minutes to add, may be negative - `long`

  returns: a ZonedDateTime based on this date-time with the minutes added, not null - `java.time.ZonedDateTime`

  throws: java.time.DateTimeException - if the result exceeds the supported date range"
  (^java.time.ZonedDateTime [^ZonedDateTime this ^Long minutes]
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

  query - the query to invoke, not null - `java.time.temporal.TemporalQuery`

  returns: the query result, null may be returned (defined by the query) - `<R> R`

  throws: java.time.DateTimeException - if unable to query (defined by the query)"
  ([^ZonedDateTime this ^java.time.temporal.TemporalQuery query]
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
  (^java.time.DayOfWeek [^ZonedDateTime this]
    (-> this (.getDayOfWeek))))

(defn to-string
  "Outputs this date-time as a String, such as
   2007-12-03T10:15:30+01:00[Europe/Paris].

   The format consists of the LocalDateTime followed by the ZoneOffset.
   If the ZoneId is not the same as the offset, then the ID is output.
   The output is compatible with ISO-8601 if the offset and ID are the same.

  returns: a string representation of this date-time, not null - `java.lang.String`"
  (^java.lang.String [^ZonedDateTime this]
    (-> this (.toString))))

(defn plus-months
  "Returns a copy of this ZonedDateTime with the specified number of months added.

   This operates on the local time-line,
   adding months to the local date-time.
   This is then converted back to a ZonedDateTime, using the zone ID
   to obtain the offset.

   When converting back to ZonedDateTime, if the local date-time is in an overlap,
   then the offset will be retained if possible, otherwise the earlier offset will be used.
   If in a gap, the local date-time will be adjusted forward by the length of the gap.

   This instance is immutable and unaffected by this method call.

  months - the months to add, may be negative - `long`

  returns: a ZonedDateTime based on this date-time with the months added, not null - `java.time.ZonedDateTime`

  throws: java.time.DateTimeException - if the result exceeds the supported date range"
  (^java.time.ZonedDateTime [^ZonedDateTime this ^Long months]
    (-> this (.plusMonths months))))

(defn minus-months
  "Returns a copy of this ZonedDateTime with the specified number of months subtracted.

   This operates on the local time-line,
   subtracting months to the local date-time.
   This is then converted back to a ZonedDateTime, using the zone ID
   to obtain the offset.

   When converting back to ZonedDateTime, if the local date-time is in an overlap,
   then the offset will be retained if possible, otherwise the earlier offset will be used.
   If in a gap, the local date-time will be adjusted forward by the length of the gap.

   This instance is immutable and unaffected by this method call.

  months - the months to subtract, may be negative - `long`

  returns: a ZonedDateTime based on this date-time with the months subtracted, not null - `java.time.ZonedDateTime`

  throws: java.time.DateTimeException - if the result exceeds the supported date range"
  (^java.time.ZonedDateTime [^ZonedDateTime this ^Long months]
    (-> this (.minusMonths months))))

(defn minus
  "Returns a copy of this date-time with the specified amount subtracted.

   This returns a ZonedDateTime, based on this one, with the amount
   in terms of the unit subtracted. If it is not possible to subtract the amount,
   because the unit is not supported or for some other reason, an exception is thrown.

   The calculation for date and time units differ.

   Date units operate on the local time-line.
   The period is first subtracted from the local date-time, then converted back
   to a zoned date-time using the zone ID.
   The conversion uses ofLocal(LocalDateTime, ZoneId, ZoneOffset)
   with the offset before the subtraction.

   Time units operate on the instant time-line.
   The period is first subtracted from the local date-time, then converted back to
   a zoned date-time using the zone ID.
   The conversion uses ofInstant(LocalDateTime, ZoneOffset, ZoneId)
   with the offset before the subtraction.

   This method is equivalent to plus(long, TemporalUnit) with the amount negated.
   See that method for a full description of how addition, and thus subtraction, works.

   This instance is immutable and unaffected by this method call.

  amount-to-subtract - the amount of the unit to subtract from the result, may be negative - `long`
  unit - the unit of the amount to subtract, not null - `java.time.temporal.TemporalUnit`

  returns: a ZonedDateTime based on this date-time with the specified amount subtracted, not null - `java.time.ZonedDateTime`

  throws: java.time.DateTimeException - if the subtraction cannot be made"
  (^java.time.ZonedDateTime [^ZonedDateTime this ^Long amount-to-subtract ^java.time.temporal.TemporalUnit unit]
    (-> this (.minus amount-to-subtract unit)))
  (^java.time.ZonedDateTime [^ZonedDateTime this ^java.time.temporal.TemporalAmount amount-to-subtract]
    (-> this (.minus amount-to-subtract))))

(defn with-fixed-offset-zone
  "Returns a copy of this date-time with the zone ID set to the offset.

   This returns a zoned date-time where the zone ID is the same as getOffset().
   The local date-time, offset and instant of the result will be the same as in this date-time.

   Setting the date-time to a fixed single offset means that any future
   calculations, such as addition or subtraction, have no complex edge cases
   due to time-zone rules.
   This might also be useful when sending a zoned date-time across a network,
   as most protocols, such as ISO-8601, only handle offsets,
   and not region-based zone IDs.

   This is equivalent to ZonedDateTime.of(zdt.toLocalDateTime(), zdt.getOffset()).

  returns: a ZonedDateTime with the zone ID set to the offset, not null - `java.time.ZonedDateTime`"
  (^java.time.ZonedDateTime [^ZonedDateTime this]
    (-> this (.withFixedOffsetZone))))

(defn plus-hours
  "Returns a copy of this ZonedDateTime with the specified number of hours added.

   This operates on the instant time-line, such that adding one hour will
   always be a duration of one hour later.
   This may cause the local date-time to change by an amount other than one hour.
   Note that this is a different approach to that used by days, months and years,
   thus adding one day is not the same as adding 24 hours.

   For example, consider a time-zone where the spring DST cutover means that the
   local times 01:00 to 01:59 occur twice changing from offset 02:00 to 01:00.

   Adding one hour to 00:30+02:00 will result in 01:30+02:00
   Adding one hour to 01:30+02:00 will result in 01:30+01:00
   Adding one hour to 01:30+01:00 will result in 02:30+01:00
   Adding three hours to 00:30+02:00 will result in 02:30+01:00


   This instance is immutable and unaffected by this method call.

  hours - the hours to add, may be negative - `long`

  returns: a ZonedDateTime based on this date-time with the hours added, not null - `java.time.ZonedDateTime`

  throws: java.time.DateTimeException - if the result exceeds the supported date range"
  (^java.time.ZonedDateTime [^ZonedDateTime this ^Long hours]
    (-> this (.plusHours hours))))

(defn with-zone-same-local
  "Returns a copy of this date-time with a different time-zone,
   retaining the local date-time if possible.

   This method changes the time-zone and retains the local date-time.
   The local date-time is only changed if it is invalid for the new zone,
   determined using the same approach as
   ofLocal(LocalDateTime, ZoneId, ZoneOffset).

   To change the zone and adjust the local date-time,
   use withZoneSameInstant(ZoneId).

   This instance is immutable and unaffected by this method call.

  zone - the time-zone to change to, not null - `java.time.ZoneId`

  returns: a ZonedDateTime based on this date-time with the requested zone, not null - `java.time.ZonedDateTime`"
  (^java.time.ZonedDateTime [^ZonedDateTime this ^java.time.ZoneId zone]
    (-> this (.withZoneSameLocal zone))))

(defn with-zone-same-instant
  "Returns a copy of this date-time with a different time-zone,
   retaining the instant.

   This method changes the time-zone and retains the instant.
   This normally results in a change to the local date-time.

   This method is based on retaining the same instant, thus gaps and overlaps
   in the local time-line have no effect on the result.

   To change the offset while keeping the local time,
   use withZoneSameLocal(ZoneId).

  zone - the time-zone to change to, not null - `java.time.ZoneId`

  returns: a ZonedDateTime based on this date-time with the requested zone, not null - `java.time.ZonedDateTime`

  throws: java.time.DateTimeException - if the result exceeds the supported date range"
  (^java.time.ZonedDateTime [^ZonedDateTime this ^java.time.ZoneId zone]
    (-> this (.withZoneSameInstant zone))))

(defn plus-days
  "Returns a copy of this ZonedDateTime with the specified number of days added.

   This operates on the local time-line,
   adding days to the local date-time.
   This is then converted back to a ZonedDateTime, using the zone ID
   to obtain the offset.

   When converting back to ZonedDateTime, if the local date-time is in an overlap,
   then the offset will be retained if possible, otherwise the earlier offset will be used.
   If in a gap, the local date-time will be adjusted forward by the length of the gap.

   This instance is immutable and unaffected by this method call.

  days - the days to add, may be negative - `long`

  returns: a ZonedDateTime based on this date-time with the days added, not null - `java.time.ZonedDateTime`

  throws: java.time.DateTimeException - if the result exceeds the supported date range"
  (^java.time.ZonedDateTime [^ZonedDateTime this ^Long days]
    (-> this (.plusDays days))))

(defn to-local-time
  "Gets the LocalTime part of this date-time.

   This returns a LocalTime with the same hour, minute, second and
   nanosecond as this date-time.

  returns: the time part of this date-time, not null - `java.time.LocalTime`"
  (^java.time.LocalTime [^ZonedDateTime this]
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
  (^Long [^ZonedDateTime this ^java.time.temporal.TemporalField field]
    (-> this (.getLong field))))

(defn get-offset
  "Gets the zone offset, such as '+01:00'.

   This is the offset of the local date-time from UTC/Greenwich.

  returns: the zone offset, not null - `java.time.ZoneOffset`"
  (^java.time.ZoneOffset [^ZonedDateTime this]
    (-> this (.getOffset))))

(defn with-year
  "Returns a copy of this ZonedDateTime with the year altered.

   This operates on the local time-line,
   changing the year of the local date-time.
   This is then converted back to a ZonedDateTime, using the zone ID
   to obtain the offset.

   When converting back to ZonedDateTime, if the local date-time is in an overlap,
   then the offset will be retained if possible, otherwise the earlier offset will be used.
   If in a gap, the local date-time will be adjusted forward by the length of the gap.

   This instance is immutable and unaffected by this method call.

  year - the year to set in the result, from MIN_YEAR to MAX_YEAR - `int`

  returns: a ZonedDateTime based on this date-time with the requested year, not null - `java.time.ZonedDateTime`

  throws: java.time.DateTimeException - if the year value is invalid"
  (^java.time.ZonedDateTime [^ZonedDateTime this ^Integer year]
    (-> this (.withYear year))))

(defn with-nano
  "Returns a copy of this ZonedDateTime with the nano-of-second altered.

   This operates on the local time-line,
   changing the time of the local date-time.
   This is then converted back to a ZonedDateTime, using the zone ID
   to obtain the offset.

   When converting back to ZonedDateTime, if the local date-time is in an overlap,
   then the offset will be retained if possible, otherwise the earlier offset will be used.
   If in a gap, the local date-time will be adjusted forward by the length of the gap.

   This instance is immutable and unaffected by this method call.

  nano-of-second - the nano-of-second to set in the result, from 0 to 999,999,999 - `int`

  returns: a ZonedDateTime based on this date-time with the requested nanosecond, not null - `java.time.ZonedDateTime`

  throws: java.time.DateTimeException - if the nano value is invalid"
  (^java.time.ZonedDateTime [^ZonedDateTime this ^Integer nano-of-second]
    (-> this (.withNano nano-of-second))))

(defn to-offset-date-time
  "Converts this date-time to an OffsetDateTime.

   This creates an offset date-time using the local date-time and offset.
   The zone ID is ignored.

  returns: an offset date-time representing the same local date-time and offset, not null - `java.time.OffsetDateTime`"
  (^java.time.OffsetDateTime [^ZonedDateTime this]
    (-> this (.toOffsetDateTime))))

(defn with-later-offset-at-overlap
  "Returns a copy of this date-time changing the zone offset to the
   later of the two valid offsets at a local time-line overlap.

   This method only has any effect when the local time-line overlaps, such as
   at an autumn daylight savings cutover. In this scenario, there are two
   valid offsets for the local date-time. Calling this method will return
   a zoned date-time with the later of the two selected.

   If this method is called when it is not an overlap, this
   is returned.

   This instance is immutable and unaffected by this method call.

  returns: a ZonedDateTime based on this date-time with the later offset, not null - `java.time.ZonedDateTime`"
  (^java.time.ZonedDateTime [^ZonedDateTime this]
    (-> this (.withLaterOffsetAtOverlap))))

(defn until
  "Calculates the amount of time until another date-time in terms of the specified unit.

   This calculates the amount of time between two ZonedDateTime
   objects in terms of a single TemporalUnit.
   The start and end points are this and the specified date-time.
   The result will be negative if the end is before the start.
   For example, the amount in days between two date-times can be calculated
   using startDateTime.until(endDateTime, DAYS).

   The Temporal passed to this method is converted to a
   ZonedDateTime using from(TemporalAccessor).
   If the time-zone differs between the two zoned date-times, the specified
   end date-time is normalized to have the same zone as this date-time.

   The calculation returns a whole number, representing the number of
   complete units between the two date-times.
   For example, the amount in months between 2012-06-15T00:00Z and 2012-08-14T23:59Z
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

   The calculation for date and time units differ.

   Date units operate on the local time-line, using the local date-time.
   For example, the period from noon on day 1 to noon the following day
   in days will always be counted as exactly one day, irrespective of whether
   there was a daylight savings change or not.

   Time units operate on the instant time-line.
   The calculation effectively converts both zoned date-times to instants
   and then calculates the period between the instants.
   For example, the period from noon on day 1 to noon the following day
   in hours may be 23, 24 or 25 hours (or some other amount) depending on
   whether there was a daylight savings change or not.

   If the unit is not a ChronoUnit, then the result of this method
   is obtained by invoking TemporalUnit.between(Temporal, Temporal)
   passing this as the first argument and the converted input temporal
   as the second argument.

   This instance is immutable and unaffected by this method call.

  end-exclusive - the end date, exclusive, which is converted to a ZonedDateTime, not null - `java.time.temporal.Temporal`
  unit - the unit to measure the amount in, not null - `java.time.temporal.TemporalUnit`

  returns: the amount of time between this date-time and the end date-time - `long`

  throws: java.time.DateTimeException - if the amount cannot be calculated, or the end temporal cannot be converted to a ZonedDateTime"
  (^Long [^ZonedDateTime this ^java.time.temporal.Temporal end-exclusive ^java.time.temporal.TemporalUnit unit]
    (-> this (.until end-exclusive unit))))

(defn get-zone
  "Gets the time-zone, such as 'Europe/Paris'.

   This returns the zone ID. This identifies the time-zone rules
   that determine when and how the offset from UTC/Greenwich changes.

   The zone ID may be same as the offset.
   If this is true, then any future calculations, such as addition or subtraction,
   have no complex edge cases due to time-zone rules.
   See also withFixedOffsetZone().

  returns: the time-zone, not null - `java.time.ZoneId`"
  (^java.time.ZoneId [^ZonedDateTime this]
    (-> this (.getZone))))

(defn with-day-of-month
  "Returns a copy of this ZonedDateTime with the day-of-month altered.

   This operates on the local time-line,
   changing the day-of-month of the local date-time.
   This is then converted back to a ZonedDateTime, using the zone ID
   to obtain the offset.

   When converting back to ZonedDateTime, if the local date-time is in an overlap,
   then the offset will be retained if possible, otherwise the earlier offset will be used.
   If in a gap, the local date-time will be adjusted forward by the length of the gap.

   This instance is immutable and unaffected by this method call.

  day-of-month - the day-of-month to set in the result, from 1 to 28-31 - `int`

  returns: a ZonedDateTime based on this date-time with the requested day, not null - `java.time.ZonedDateTime`

  throws: java.time.DateTimeException - if the day-of-month value is invalid, or if the day-of-month is invalid for the month-year"
  (^java.time.ZonedDateTime [^ZonedDateTime this ^Integer day-of-month]
    (-> this (.withDayOfMonth day-of-month))))

(defn get-day-of-month
  "Gets the day-of-month field.

   This method returns the primitive int value for the day-of-month.

  returns: the day-of-month, from 1 to 31 - `int`"
  (^Integer [^ZonedDateTime this]
    (-> this (.getDayOfMonth))))

(defn minus-nanos
  "Returns a copy of this ZonedDateTime with the specified number of nanoseconds subtracted.

   This operates on the instant time-line, such that subtracting one nano will
   always be a duration of one nano earlier.
   This may cause the local date-time to change by an amount other than one nano.
   Note that this is a different approach to that used by days, months and years.

   This instance is immutable and unaffected by this method call.

  nanos - the nanos to subtract, may be negative - `long`

  returns: a ZonedDateTime based on this date-time with the nanoseconds subtracted, not null - `java.time.ZonedDateTime`

  throws: java.time.DateTimeException - if the result exceeds the supported date range"
  (^java.time.ZonedDateTime [^ZonedDateTime this ^Long nanos]
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
   INSTANT_SECONDS
   OFFSET_SECONDS

   All other ChronoField instances will return false.

   If the field is not a ChronoField, then the result of this method
   is obtained by invoking TemporalField.isSupportedBy(TemporalAccessor)
   passing this as the argument.
   Whether the field is supported is determined by the field.

  field - the field to check, null returns false - `java.time.temporal.TemporalField`

  returns: true if the field is supported on this date-time, false if not - `boolean`"
  (^Boolean [^ZonedDateTime this ^java.time.temporal.TemporalField field]
    (-> this (.isSupported field))))

(defn minus-years
  "Returns a copy of this ZonedDateTime with the specified number of years subtracted.

   This operates on the local time-line,
   subtracting years to the local date-time.
   This is then converted back to a ZonedDateTime, using the zone ID
   to obtain the offset.

   When converting back to ZonedDateTime, if the local date-time is in an overlap,
   then the offset will be retained if possible, otherwise the earlier offset will be used.
   If in a gap, the local date-time will be adjusted forward by the length of the gap.

   This instance is immutable and unaffected by this method call.

  years - the years to subtract, may be negative - `long`

  returns: a ZonedDateTime based on this date-time with the years subtracted, not null - `java.time.ZonedDateTime`

  throws: java.time.DateTimeException - if the result exceeds the supported date range"
  (^java.time.ZonedDateTime [^ZonedDateTime this ^Long years]
    (-> this (.minusYears years))))

(defn with-second
  "Returns a copy of this ZonedDateTime with the second-of-minute altered.

   This operates on the local time-line,
   changing the time of the local date-time.
   This is then converted back to a ZonedDateTime, using the zone ID
   to obtain the offset.

   When converting back to ZonedDateTime, if the local date-time is in an overlap,
   then the offset will be retained if possible, otherwise the earlier offset will be used.
   If in a gap, the local date-time will be adjusted forward by the length of the gap.

   This instance is immutable and unaffected by this method call.

  second - the second-of-minute to set in the result, from 0 to 59 - `int`

  returns: a ZonedDateTime based on this date-time with the requested second, not null - `java.time.ZonedDateTime`

  throws: java.time.DateTimeException - if the second value is invalid"
  (^java.time.ZonedDateTime [^ZonedDateTime this ^Integer second]
    (-> this (.withSecond second))))

(defn to-local-date
  "Gets the LocalDate part of this date-time.

   This returns a LocalDate with the same year, month and day
   as this date-time.

  returns: the date part of this date-time, not null - `java.time.LocalDate`"
  (^java.time.LocalDate [^ZonedDateTime this]
    (-> this (.toLocalDate))))

(defn get-minute
  "Gets the minute-of-hour field.

  returns: the minute-of-hour, from 0 to 59 - `int`"
  (^Integer [^ZonedDateTime this]
    (-> this (.getMinute))))

(defn hash-code
  "A hash code for this date-time.

  returns: a suitable hash code - `int`"
  (^Integer [^ZonedDateTime this]
    (-> this (.hashCode))))

(defn with
  "Returns a copy of this date-time with the specified field set to a new value.

   This returns a ZonedDateTime, based on this one, with the value
   for the specified field changed.
   This can be used to change any supported field, such as the year, month or day-of-month.
   If it is not possible to set the value, because the field is not supported or for
   some other reason, an exception is thrown.

   In some cases, changing the specified field can cause the resulting date-time to become invalid,
   such as changing the month from 31st January to February would make the day-of-month invalid.
   In cases like this, the field is responsible for resolving the date. Typically it will choose
   the previous valid date, which would be the last valid day of February in this example.

   If the field is a ChronoField then the adjustment is implemented here.

   The INSTANT_SECONDS field will return a date-time with the specified instant.
   The zone and nano-of-second are unchanged.
   The result will have an offset derived from the new instant and original zone.
   If the new instant value is outside the valid range then a DateTimeException will be thrown.

   The OFFSET_SECONDS field will typically be ignored.
   The offset of a ZonedDateTime is controlled primarily by the time-zone.
   As such, changing the offset does not generally make sense, because there is only
   one valid offset for the local date-time and zone.
   If the zoned date-time is in a daylight savings overlap, then the offset is used
   to switch between the two valid offsets. In all other cases, the offset is ignored.
   If the new offset value is outside the valid range then a DateTimeException will be thrown.

   The other supported fields will behave as per
   the matching method on LocalDateTime.
   The zone is not part of the calculation and will be unchanged.
   When converting back to ZonedDateTime, if the local date-time is in an overlap,
   then the offset will be retained if possible, otherwise the earlier offset will be used.
   If in a gap, the local date-time will be adjusted forward by the length of the gap.

   All other ChronoField instances will throw an UnsupportedTemporalTypeException.

   If the field is not a ChronoField, then the result of this method
   is obtained by invoking TemporalField.adjustInto(Temporal, long)
   passing this as the argument. In this case, the field determines
   whether and how to adjust the instant.

   This instance is immutable and unaffected by this method call.

  field - the field to set in the result, not null - `java.time.temporal.TemporalField`
  new-value - the new value of the field in the result - `long`

  returns: a ZonedDateTime based on this with the specified field set, not null - `java.time.ZonedDateTime`

  throws: java.time.DateTimeException - if the field cannot be set"
  (^java.time.ZonedDateTime [^ZonedDateTime this ^java.time.temporal.TemporalField field ^Long new-value]
    (-> this (.with field new-value)))
  (^java.time.ZonedDateTime [^ZonedDateTime this ^java.time.temporal.TemporalAdjuster adjuster]
    (-> this (.with adjuster))))

(defn to-local-date-time
  "Gets the LocalDateTime part of this date-time.

   This returns a LocalDateTime with the same year, month, day and time
   as this date-time.

  returns: the local date-time part of this date-time, not null - `java.time.LocalDateTime`"
  (^java.time.LocalDateTime [^ZonedDateTime this]
    (-> this (.toLocalDateTime))))

(defn get-month-value
  "Gets the month-of-year field from 1 to 12.

   This method returns the month as an int from 1 to 12.
   Application code is frequently clearer if the enum Month
   is used by calling getMonth().

  returns: the month-of-year, from 1 to 12 - `int`"
  (^Integer [^ZonedDateTime this]
    (-> this (.getMonthValue))))

(defn with-day-of-year
  "Returns a copy of this ZonedDateTime with the day-of-year altered.

   This operates on the local time-line,
   changing the day-of-year of the local date-time.
   This is then converted back to a ZonedDateTime, using the zone ID
   to obtain the offset.

   When converting back to ZonedDateTime, if the local date-time is in an overlap,
   then the offset will be retained if possible, otherwise the earlier offset will be used.
   If in a gap, the local date-time will be adjusted forward by the length of the gap.

   This instance is immutable and unaffected by this method call.

  day-of-year - the day-of-year to set in the result, from 1 to 365-366 - `int`

  returns: a ZonedDateTime based on this date with the requested day, not null - `java.time.ZonedDateTime`

  throws: java.time.DateTimeException - if the day-of-year value is invalid, or if the day-of-year is invalid for the year"
  (^java.time.ZonedDateTime [^ZonedDateTime this ^Integer day-of-year]
    (-> this (.withDayOfYear day-of-year))))

(defn get-month
  "Gets the month-of-year field using the Month enum.

   This method returns the enum Month for the month.
   This avoids confusion as to what int values mean.
   If you need access to the primitive int value then the enum
   provides the int value.

  returns: the month-of-year, not null - `java.time.Month`"
  (^java.time.Month [^ZonedDateTime this]
    (-> this (.getMonth))))

(defn plus-seconds
  "Returns a copy of this ZonedDateTime with the specified number of seconds added.

   This operates on the instant time-line, such that adding one second will
   always be a duration of one second later.
   This may cause the local date-time to change by an amount other than one second.
   Note that this is a different approach to that used by days, months and years.

   This instance is immutable and unaffected by this method call.

  seconds - the seconds to add, may be negative - `long`

  returns: a ZonedDateTime based on this date-time with the seconds added, not null - `java.time.ZonedDateTime`

  throws: java.time.DateTimeException - if the result exceeds the supported date range"
  (^java.time.ZonedDateTime [^ZonedDateTime this ^Long seconds]
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
   EPOCH_DAY, PROLEPTIC_MONTH and INSTANT_SECONDS which are too
   large to fit in an int and throw a DateTimeException.
   All other ChronoField instances will throw an UnsupportedTemporalTypeException.

   If the field is not a ChronoField, then the result of this method
   is obtained by invoking TemporalField.getFrom(TemporalAccessor)
   passing this as the argument. Whether the value can be obtained,
   and what the value represents, is determined by the field.

  field - the field to get, not null - `java.time.temporal.TemporalField`

  returns: the value for the field - `int`

  throws: java.time.DateTimeException - if a value for the field cannot be obtained or the value is outside the range of valid values for the field"
  (^Integer [^ZonedDateTime this ^java.time.temporal.TemporalField field]
    (-> this (.get field))))

(defn equals
  "Checks if this date-time is equal to another date-time.

   The comparison is based on the offset date-time and the zone.
   Only objects of type ZonedDateTime are compared, other types return false.

  obj - the object to check, null returns false - `java.lang.Object`

  returns: true if this is equal to the other date-time - `boolean`"
  (^Boolean [^ZonedDateTime this ^java.lang.Object obj]
    (-> this (.equals obj))))

(defn format
  "Formats this date-time using the specified formatter.

   This date-time will be passed to the formatter to produce a string.

  formatter - the formatter to use, not null - `java.time.format.DateTimeFormatter`

  returns: the formatted date-time string, not null - `java.lang.String`

  throws: java.time.DateTimeException - if an error occurs during printing"
  (^java.lang.String [^ZonedDateTime this ^java.time.format.DateTimeFormatter formatter]
    (-> this (.format formatter))))

(defn plus-years
  "Returns a copy of this ZonedDateTime with the specified number of years added.

   This operates on the local time-line,
   adding years to the local date-time.
   This is then converted back to a ZonedDateTime, using the zone ID
   to obtain the offset.

   When converting back to ZonedDateTime, if the local date-time is in an overlap,
   then the offset will be retained if possible, otherwise the earlier offset will be used.
   If in a gap, the local date-time will be adjusted forward by the length of the gap.

   This instance is immutable and unaffected by this method call.

  years - the years to add, may be negative - `long`

  returns: a ZonedDateTime based on this date-time with the years added, not null - `java.time.ZonedDateTime`

  throws: java.time.DateTimeException - if the result exceeds the supported date range"
  (^java.time.ZonedDateTime [^ZonedDateTime this ^Long years]
    (-> this (.plusYears years))))

(defn minus-days
  "Returns a copy of this ZonedDateTime with the specified number of days subtracted.

   This operates on the local time-line,
   subtracting days to the local date-time.
   This is then converted back to a ZonedDateTime, using the zone ID
   to obtain the offset.

   When converting back to ZonedDateTime, if the local date-time is in an overlap,
   then the offset will be retained if possible, otherwise the earlier offset will be used.
   If in a gap, the local date-time will be adjusted forward by the length of the gap.

   This instance is immutable and unaffected by this method call.

  days - the days to subtract, may be negative - `long`

  returns: a ZonedDateTime based on this date-time with the days subtracted, not null - `java.time.ZonedDateTime`

  throws: java.time.DateTimeException - if the result exceeds the supported date range"
  (^java.time.ZonedDateTime [^ZonedDateTime this ^Long days]
    (-> this (.minusDays days))))

