(ns jdk.time.Instant
  "An instantaneous point on the time-line.

  This class models a single instantaneous point on the time-line.
  This might be used to record event time-stamps in the application.

  The range of an instant requires the storage of a number larger than a long.
  To achieve this, the class stores a long representing epoch-seconds and an
  int representing nanosecond-of-second, which will always be between 0 and 999,999,999.
  The epoch-seconds are measured from the standard Java epoch of 1970-01-01T00:00:00Z
  where instants after the epoch have positive values, and earlier instants have negative values.
  For both the epoch-second and nanosecond parts, a larger value is always later on the time-line
  than a smaller value.

  Time-scale

  The length of the solar day is the standard way that humans measure time.
  This has traditionally been subdivided into 24 hours of 60 minutes of 60 seconds,
  forming a 86400 second day.

  Modern timekeeping is based on atomic clocks which precisely define an SI second
  relative to the transitions of a Caesium atom. The length of an SI second was defined
  to be very close to the 86400th fraction of a day.

  Unfortunately, as the Earth rotates the length of the day varies.
  In addition, over time the average length of the day is getting longer as the Earth slows.
  As a result, the length of a solar day in 2012 is slightly longer than 86400 SI seconds.
  The actual length of any given day and the amount by which the Earth is slowing
  are not predictable and can only be determined by measurement.
  The UT1 time-scale captures the accurate length of day, but is only available some
  time after the day has completed.

  The UTC time-scale is a standard approach to bundle up all the additional fractions
  of a second from UT1 into whole seconds, known as leap-seconds.
  A leap-second may be added or removed depending on the Earth's rotational changes.
  As such, UTC permits a day to have 86399 SI seconds or 86401 SI seconds where
  necessary in order to keep the day aligned with the Sun.

  The modern UTC time-scale was introduced in 1972, introducing the concept of whole leap-seconds.
  Between 1958 and 1972, the definition of UTC was complex, with minor sub-second leaps and
  alterations to the length of the notional second. As of 2012, discussions are underway
  to change the definition of UTC again, with the potential to remove leap seconds or
  introduce other changes.

  Given the complexity of accurate timekeeping described above, this Java API defines
  its own time-scale, the Java Time-Scale.

  The Java Time-Scale divides each calendar day into exactly 86400
  subdivisions, known as seconds.  These seconds may differ from the
  SI second.  It closely matches the de facto international civil time
  scale, the definition of which changes from time to time.

  The Java Time-Scale has slightly different definitions for different
  segments of the time-line, each based on the consensus international
  time scale that is used as the basis for civil time. Whenever the
  internationally-agreed time scale is modified or replaced, a new
  segment of the Java Time-Scale must be defined for it.  Each segment
  must meet these requirements:

  the Java Time-Scale shall closely match the underlying international
   civil time scale;
  the Java Time-Scale shall exactly match the international civil
   time scale at noon each day;
  the Java Time-Scale shall have a precisely-defined relationship to
   the international civil time scale.

  There are currently, as of 2013, two segments in the Java time-scale.

  For the segment from 1972-11-03 (exact boundary discussed below) until
  further notice, the consensus international time scale is UTC (with
  leap seconds).  In this segment, the Java Time-Scale is identical to
  UTC-SLS.
  This is identical to UTC on days that do not have a leap second.
  On days that do have a leap second, the leap second is spread equally
  over the last 1000 seconds of the day, maintaining the appearance of
  exactly 86400 seconds per day.

  For the segment prior to 1972-11-03, extending back arbitrarily far,
  the consensus international time scale is defined to be UT1, applied
  proleptically, which is equivalent to the (mean) solar time on the
  prime meridian (Greenwich). In this segment, the Java Time-Scale is
  identical to the consensus international time scale. The exact
  boundary between the two segments is the instant where UT1 = UTC
  between 1972-11-03T00:00 and 1972-11-04T12:00.

  Implementations of the Java time-scale using the JSR-310 API are not
  required to provide any clock that is sub-second accurate, or that
  progresses monotonically or smoothly. Implementations are therefore
  not required to actually perform the UTC-SLS slew or to otherwise be
  aware of leap seconds. JSR-310 does, however, require that
  implementations must document the approach they use when defining a
  clock representing the current instant.
  See Clock for details on the available clocks.

  The Java time-scale is used for all date-time classes.
  This includes Instant, LocalDate, LocalTime, OffsetDateTime,
  ZonedDateTime and Duration.


  This is a value-based
  class; use of identity-sensitive operations (including reference equality
  (==), identity hash code, or synchronization) on instances of
  Instant may have unpredictable results and should be avoided.
  The equals method should be used for comparisons."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.time Instant]))

(def *-epoch
  "Static Constant.

  Constant for the 1970-01-01T00:00:00Z epoch instant.

  type: java.time.Instant"
  Instant/EPOCH)

(def *-min
  "Static Constant.

  The minimum supported Instant, '-1000000000-01-01T00:00Z'.
   This could be used by an application as a `far past` instant.

   This is one year earlier than the minimum LocalDateTime.
   This provides sufficient values to handle the range of ZoneOffset
   which affect the instant in addition to the local date-time.
   The value is also chosen such that the value of the year fits in
   an int.

  type: java.time.Instant"
  Instant/MIN)

(def *-max
  "Static Constant.

  The maximum supported Instant, '1000000000-12-31T23:59:59.999999999Z'.
   This could be used by an application as a `far future` instant.

   This is one year later than the maximum LocalDateTime.
   This provides sufficient values to handle the range of ZoneOffset
   which affect the instant in addition to the local date-time.
   The value is also chosen such that the value of the year fits in
   an int.

  type: java.time.Instant"
  Instant/MAX)

(defn *now
  "Obtains the current instant from the specified clock.

   This will query the specified clock to obtain the current time.

   Using this method allows the use of an alternate clock for testing.
   The alternate clock may be introduced using dependency injection.

  clock - the clock to use, not null - `java.time.Clock`

  returns: the current instant, not null - `java.time.Instant`"
  (^java.time.Instant [^java.time.Clock clock]
    (Instant/now clock))
  (^java.time.Instant []
    (Instant/now )))

(defn *of-epoch-second
  "Obtains an instance of Instant using seconds from the
   epoch of 1970-01-01T00:00:00Z and nanosecond fraction of second.

   This method allows an arbitrary number of nanoseconds to be passed in.
   The factory will alter the values of the second and nanosecond in order
   to ensure that the stored nanosecond is in the range 0 to 999,999,999.
   For example, the following will result in the exactly the same instant:


    Instant.ofEpochSecond(3, 1);
    Instant.ofEpochSecond(4, -999_999_999);
    Instant.ofEpochSecond(2, 1000_000_001);

  epoch-second - the number of seconds from 1970-01-01T00:00:00Z - `long`
  nano-adjustment - the nanosecond adjustment to the number of seconds, positive or negative - `long`

  returns: an instant, not null - `java.time.Instant`

  throws: java.time.DateTimeException - if the instant exceeds the maximum or minimum instant"
  (^java.time.Instant [^Long epoch-second ^Long nano-adjustment]
    (Instant/ofEpochSecond epoch-second nano-adjustment))
  (^java.time.Instant [^Long epoch-second]
    (Instant/ofEpochSecond epoch-second)))

(defn *of-epoch-milli
  "Obtains an instance of Instant using milliseconds from the
   epoch of 1970-01-01T00:00:00Z.

   The seconds and nanoseconds are extracted from the specified milliseconds.

  epoch-milli - the number of milliseconds from 1970-01-01T00:00:00Z - `long`

  returns: an instant, not null - `java.time.Instant`

  throws: java.time.DateTimeException - if the instant exceeds the maximum or minimum instant"
  (^java.time.Instant [^Long epoch-milli]
    (Instant/ofEpochMilli epoch-milli)))

(defn *from
  "Obtains an instance of Instant from a temporal object.

   This obtains an instant based on the specified temporal.
   A TemporalAccessor represents an arbitrary set of date and time information,
   which this factory converts to an instance of Instant.

   The conversion extracts the INSTANT_SECONDS
   and NANO_OF_SECOND fields.

   This method matches the signature of the functional interface TemporalQuery
   allowing it to be used as a query via method reference, Instant::from.

  temporal - the temporal object to convert, not null - `java.time.temporal.TemporalAccessor`

  returns: the instant, not null - `java.time.Instant`

  throws: java.time.DateTimeException - if unable to convert to an Instant"
  (^java.time.Instant [^java.time.temporal.TemporalAccessor temporal]
    (Instant/from temporal)))

(defn *parse
  "Obtains an instance of Instant from a text string such as
   2007-12-03T10:15:30.00Z.

   The string must represent a valid instant in UTC and is parsed using
   DateTimeFormatter.ISO_INSTANT.

  text - the text to parse, not null - `java.lang.CharSequence`

  returns: the parsed instant, not null - `java.time.Instant`

  throws: java.time.format.DateTimeParseException - if the text cannot be parsed"
  (^java.time.Instant [^java.lang.CharSequence text]
    (Instant/parse text)))

(defn truncated-to
  "Returns a copy of this Instant truncated to the specified unit.

   Truncating the instant returns a copy of the original with fields
   smaller than the specified unit set to zero.
   The fields are calculated on the basis of using a UTC offset as seen
   in toString.
   For example, truncating with the MINUTES unit will
   round down to the nearest minute, setting the seconds and nanoseconds to zero.

   The unit must have a duration
   that divides into the length of a standard day without remainder.
   This includes all supplied time units on ChronoUnit and
   DAYS. Other units throw an exception.

   This instance is immutable and unaffected by this method call.

  unit - the unit to truncate to, not null - `java.time.temporal.TemporalUnit`

  returns: an Instant based on this instant with the time truncated, not null - `java.time.Instant`

  throws: java.time.DateTimeException - if the unit is invalid for truncation"
  (^java.time.Instant [^Instant this ^java.time.temporal.TemporalUnit unit]
    (-> this (.truncatedTo unit))))

(defn range
  "Gets the range of valid values for the specified field.

   The range object expresses the minimum and maximum valid values for a field.
   This instant is used to enhance the accuracy of the returned range.
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
  (^java.time.temporal.ValueRange [^Instant this ^java.time.temporal.TemporalField field]
    (-> this (.range field))))

(defn at-offset
  "Combines this instant with an offset to create an OffsetDateTime.

   This returns an OffsetDateTime formed from this instant at the
   specified offset from UTC/Greenwich. An exception will be thrown if the
   instant is too large to fit into an offset date-time.

   This method is equivalent to
   OffsetDateTime.ofInstant(this, offset).

  offset - the offset to combine with, not null - `java.time.ZoneOffset`

  returns: the offset date-time formed from this instant and the specified offset, not null - `java.time.OffsetDateTime`

  throws: java.time.DateTimeException - if the result exceeds the supported range"
  (^java.time.OffsetDateTime [^Instant this ^java.time.ZoneOffset offset]
    (-> this (.atOffset offset))))

(defn minus-millis
  "Returns a copy of this instant with the specified duration in milliseconds subtracted.

   This instance is immutable and unaffected by this method call.

  millis-to-subtract - the milliseconds to subtract, positive or negative - `long`

  returns: an Instant based on this instant with the specified milliseconds subtracted, not null - `java.time.Instant`

  throws: java.time.DateTimeException - if the result exceeds the maximum or minimum instant"
  (^java.time.Instant [^Instant this ^Long millis-to-subtract]
    (-> this (.minusMillis millis-to-subtract))))

(defn get-nano
  "Gets the number of nanoseconds, later along the time-line, from the start
   of the second.

   The nanosecond-of-second value measures the total number of nanoseconds from
   the second returned by getEpochSecond.

  returns: the nanoseconds within the second, always positive, never exceeds 999,999,999 - `int`"
  (^Integer [^Instant this]
    (-> this (.getNano))))

(defn plus-millis
  "Returns a copy of this instant with the specified duration in milliseconds added.

   This instance is immutable and unaffected by this method call.

  millis-to-add - the milliseconds to add, positive or negative - `long`

  returns: an Instant based on this instant with the specified milliseconds added, not null - `java.time.Instant`

  throws: java.time.DateTimeException - if the result exceeds the maximum or minimum instant"
  (^java.time.Instant [^Instant this ^Long millis-to-add]
    (-> this (.plusMillis millis-to-add))))

(defn minus-seconds
  "Returns a copy of this instant with the specified duration in seconds subtracted.

   This instance is immutable and unaffected by this method call.

  seconds-to-subtract - the seconds to subtract, positive or negative - `long`

  returns: an Instant based on this instant with the specified seconds subtracted, not null - `java.time.Instant`

  throws: java.time.DateTimeException - if the result exceeds the maximum or minimum instant"
  (^java.time.Instant [^Instant this ^Long seconds-to-subtract]
    (-> this (.minusSeconds seconds-to-subtract))))

(defn plus-nanos
  "Returns a copy of this instant with the specified duration in nanoseconds added.

   This instance is immutable and unaffected by this method call.

  nanos-to-add - the nanoseconds to add, positive or negative - `long`

  returns: an Instant based on this instant with the specified nanoseconds added, not null - `java.time.Instant`

  throws: java.time.DateTimeException - if the result exceeds the maximum or minimum instant"
  (^java.time.Instant [^Instant this ^Long nanos-to-add]
    (-> this (.plusNanos nanos-to-add))))

(defn plus
  "Returns a copy of this instant with the specified amount added.

   This returns an Instant, based on this one, with the amount
   in terms of the unit added. If it is not possible to add the amount, because the
   unit is not supported or for some other reason, an exception is thrown.

   If the field is a ChronoUnit then the addition is implemented here.
   The supported fields behave as follows:

   NANOS -
    Returns a Instant with the specified number of nanoseconds added.
    This is equivalent to plusNanos(long).
   MICROS -
    Returns a Instant with the specified number of microseconds added.
    This is equivalent to plusNanos(long) with the amount
    multiplied by 1,000.
   MILLIS -
    Returns a Instant with the specified number of milliseconds added.
    This is equivalent to plusNanos(long) with the amount
    multiplied by 1,000,000.
   SECONDS -
    Returns a Instant with the specified number of seconds added.
    This is equivalent to plusSeconds(long).
   MINUTES -
    Returns a Instant with the specified number of minutes added.
    This is equivalent to plusSeconds(long) with the amount
    multiplied by 60.
   HOURS -
    Returns a Instant with the specified number of hours added.
    This is equivalent to plusSeconds(long) with the amount
    multiplied by 3,600.
   HALF_DAYS -
    Returns a Instant with the specified number of half-days added.
    This is equivalent to plusSeconds(long) with the amount
    multiplied by 43,200 (12 hours).
   DAYS -
    Returns a Instant with the specified number of days added.
    This is equivalent to plusSeconds(long) with the amount
    multiplied by 86,400 (24 hours).


   All other ChronoUnit instances will throw an UnsupportedTemporalTypeException.

   If the field is not a ChronoUnit, then the result of this method
   is obtained by invoking TemporalUnit.addTo(Temporal, long)
   passing this as the argument. In this case, the unit determines
   whether and how to perform the addition.

   This instance is immutable and unaffected by this method call.

  amount-to-add - the amount of the unit to add to the result, may be negative - `long`
  unit - the unit of the amount to add, not null - `java.time.temporal.TemporalUnit`

  returns: an Instant based on this instant with the specified amount added, not null - `java.time.Instant`

  throws: java.time.DateTimeException - if the addition cannot be made"
  (^java.time.Instant [^Instant this ^Long amount-to-add ^java.time.temporal.TemporalUnit unit]
    (-> this (.plus amount-to-add unit)))
  (^java.time.Instant [^Instant this ^java.time.temporal.TemporalAmount amount-to-add]
    (-> this (.plus amount-to-add))))

(defn query
  "Queries this instant using the specified query.

   This queries this instant using the specified query strategy object.
   The TemporalQuery object defines the logic to be used to
   obtain the result. Read the documentation of the query to understand
   what the result of this method will be.

   The result of this method is obtained by invoking the
   TemporalQuery.queryFrom(TemporalAccessor) method on the
   specified query passing this as the argument.

  query - the query to invoke, not null - `java.time.temporal.TemporalQuery`

  returns: the query result, null may be returned (defined by the query) - `<R> R`

  throws: java.time.DateTimeException - if unable to query (defined by the query)"
  ([^Instant this ^java.time.temporal.TemporalQuery query]
    (-> this (.query query))))

(defn to-string
  "A string representation of this instant using ISO-8601 representation.

   The format used is the same as DateTimeFormatter.ISO_INSTANT.

  returns: an ISO-8601 representation of this instant, not null - `java.lang.String`"
  (^java.lang.String [^Instant this]
    (-> this (.toString))))

(defn before?
  "Checks if this instant is before the specified instant.

   The comparison is based on the time-line position of the instants.

  other-instant - the other instant to compare to, not null - `java.time.Instant`

  returns: true if this instant is before the specified instant - `boolean`

  throws: java.lang.NullPointerException - if otherInstant is null"
  (^Boolean [^Instant this ^java.time.Instant other-instant]
    (-> this (.isBefore other-instant))))

(defn minus
  "Returns a copy of this instant with the specified amount subtracted.

   This returns a Instant, based on this one, with the amount
   in terms of the unit subtracted. If it is not possible to subtract the amount,
   because the unit is not supported or for some other reason, an exception is thrown.

   This method is equivalent to plus(long, TemporalUnit) with the amount negated.
   See that method for a full description of how addition, and thus subtraction, works.

   This instance is immutable and unaffected by this method call.

  amount-to-subtract - the amount of the unit to subtract from the result, may be negative - `long`
  unit - the unit of the amount to subtract, not null - `java.time.temporal.TemporalUnit`

  returns: an Instant based on this instant with the specified amount subtracted, not null - `java.time.Instant`

  throws: java.time.DateTimeException - if the subtraction cannot be made"
  (^java.time.Instant [^Instant this ^Long amount-to-subtract ^java.time.temporal.TemporalUnit unit]
    (-> this (.minus amount-to-subtract unit)))
  (^java.time.Instant [^Instant this ^java.time.temporal.TemporalAmount amount-to-subtract]
    (-> this (.minus amount-to-subtract))))

(defn at-zone
  "Combines this instant with a time-zone to create a ZonedDateTime.

   This returns an ZonedDateTime formed from this instant at the
   specified time-zone. An exception will be thrown if the instant is too
   large to fit into a zoned date-time.

   This method is equivalent to
   ZonedDateTime.ofInstant(this, zone).

  zone - the zone to combine with, not null - `java.time.ZoneId`

  returns: the zoned date-time formed from this instant and the specified zone, not null - `java.time.ZonedDateTime`

  throws: java.time.DateTimeException - if the result exceeds the supported range"
  (^java.time.ZonedDateTime [^Instant this ^java.time.ZoneId zone]
    (-> this (.atZone zone))))

(defn get-long
  "Gets the value of the specified field from this instant as a long.

   This queries this instant for the value of the specified field.
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
  (^Long [^Instant this ^java.time.temporal.TemporalField field]
    (-> this (.getLong field))))

(defn until
  "Calculates the amount of time until another instant in terms of the specified unit.

   This calculates the amount of time between two Instant
   objects in terms of a single TemporalUnit.
   The start and end points are this and the specified instant.
   The result will be negative if the end is before the start.
   The calculation returns a whole number, representing the number of
   complete units between the two instants.
   The Temporal passed to this method is converted to a
   Instant using from(TemporalAccessor).
   For example, the amount in days between two dates can be calculated
   using startInstant.until(endInstant, SECONDS).

   There are two equivalent ways of using this method.
   The first is to invoke this method.
   The second is to use TemporalUnit.between(Temporal, Temporal):


     // these two lines are equivalent
     amount = start.until(end, SECONDS);
     amount = SECONDS.between(start, end);
   The choice should be made based on which makes the code more readable.

   The calculation is implemented in this method for ChronoUnit.
   The units NANOS, MICROS, MILLIS, SECONDS,
   MINUTES, HOURS, HALF_DAYS and DAYS
   are supported. Other ChronoUnit values will throw an exception.

   If the unit is not a ChronoUnit, then the result of this method
   is obtained by invoking TemporalUnit.between(Temporal, Temporal)
   passing this as the first argument and the converted input temporal
   as the second argument.

   This instance is immutable and unaffected by this method call.

  end-exclusive - the end date, exclusive, which is converted to an Instant, not null - `java.time.temporal.Temporal`
  unit - the unit to measure the amount in, not null - `java.time.temporal.TemporalUnit`

  returns: the amount of time between this instant and the end instant - `long`

  throws: java.time.DateTimeException - if the amount cannot be calculated, or the end temporal cannot be converted to an Instant"
  (^Long [^Instant this ^java.time.temporal.Temporal end-exclusive ^java.time.temporal.TemporalUnit unit]
    (-> this (.until end-exclusive unit))))

(defn after?
  "Checks if this instant is after the specified instant.

   The comparison is based on the time-line position of the instants.

  other-instant - the other instant to compare to, not null - `java.time.Instant`

  returns: true if this instant is after the specified instant - `boolean`

  throws: java.lang.NullPointerException - if otherInstant is null"
  (^Boolean [^Instant this ^java.time.Instant other-instant]
    (-> this (.isAfter other-instant))))

(defn minus-nanos
  "Returns a copy of this instant with the specified duration in nanoseconds subtracted.

   This instance is immutable and unaffected by this method call.

  nanos-to-subtract - the nanoseconds to subtract, positive or negative - `long`

  returns: an Instant based on this instant with the specified nanoseconds subtracted, not null - `java.time.Instant`

  throws: java.time.DateTimeException - if the result exceeds the maximum or minimum instant"
  (^java.time.Instant [^Instant this ^Long nanos-to-subtract]
    (-> this (.minusNanos nanos-to-subtract))))

(defn supported?
  "Checks if the specified field is supported.

   This checks if this instant can be queried for the specified field.
   If false, then calling the range,
   get and with(TemporalField, long)
   methods will throw an exception.

   If the field is a ChronoField then the query is implemented here.
   The supported fields are:

   NANO_OF_SECOND
   MICRO_OF_SECOND
   MILLI_OF_SECOND
   INSTANT_SECONDS

   All other ChronoField instances will return false.

   If the field is not a ChronoField, then the result of this method
   is obtained by invoking TemporalField.isSupportedBy(TemporalAccessor)
   passing this as the argument.
   Whether the field is supported is determined by the field.

  field - the field to check, null returns false - `java.time.temporal.TemporalField`

  returns: true if the field is supported on this instant, false if not - `boolean`"
  (^Boolean [^Instant this ^java.time.temporal.TemporalField field]
    (-> this (.isSupported field))))

(defn hash-code
  "Returns a hash code for this instant.

  returns: a suitable hash code - `int`"
  (^Integer [^Instant this]
    (-> this (.hashCode))))

(defn adjust-into
  "Adjusts the specified temporal object to have this instant.

   This returns a temporal object of the same observable type as the input
   with the instant changed to be the same as this.

   The adjustment is equivalent to using Temporal.with(TemporalField, long)
   twice, passing ChronoField.INSTANT_SECONDS and
   ChronoField.NANO_OF_SECOND as the fields.

   In most cases, it is clearer to reverse the calling pattern by using
   Temporal.with(TemporalAdjuster):


     // these two lines are equivalent, but the second approach is recommended
     temporal = thisInstant.adjustInto(temporal);
     temporal = temporal.with(thisInstant);

   This instance is immutable and unaffected by this method call.

  temporal - the target object to be adjusted, not null - `java.time.temporal.Temporal`

  returns: the adjusted object, not null - `java.time.temporal.Temporal`

  throws: java.time.DateTimeException - if unable to make the adjustment"
  (^java.time.temporal.Temporal [^Instant this ^java.time.temporal.Temporal temporal]
    (-> this (.adjustInto temporal))))

(defn with
  "Returns a copy of this instant with the specified field set to a new value.

   This returns an Instant, based on this one, with the value
   for the specified field changed.
   If it is not possible to set the value, because the field is not supported or for
   some other reason, an exception is thrown.

   If the field is a ChronoField then the adjustment is implemented here.
   The supported fields behave as follows:

   NANO_OF_SECOND -
    Returns an Instant with the specified nano-of-second.
    The epoch-second will be unchanged.
   MICRO_OF_SECOND -
    Returns an Instant with the nano-of-second replaced by the specified
    micro-of-second multiplied by 1,000. The epoch-second will be unchanged.
   MILLI_OF_SECOND -
    Returns an Instant with the nano-of-second replaced by the specified
    milli-of-second multiplied by 1,000,000. The epoch-second will be unchanged.
   INSTANT_SECONDS -
    Returns an Instant with the specified epoch-second.
    The nano-of-second will be unchanged.


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

  returns: an Instant based on this with the specified field set, not null - `java.time.Instant`

  throws: java.time.DateTimeException - if the field cannot be set"
  (^java.time.Instant [^Instant this ^java.time.temporal.TemporalField field ^Long new-value]
    (-> this (.with field new-value)))
  (^java.time.Instant [^Instant this ^java.time.temporal.TemporalAdjuster adjuster]
    (-> this (.with adjuster))))

(defn to-epoch-milli
  "Converts this instant to the number of milliseconds from the epoch
   of 1970-01-01T00:00:00Z.

   If this instant represents a point on the time-line too far in the future
   or past to fit in a long milliseconds, then an exception is thrown.

   If this instant has greater than millisecond precision, then the conversion
   will drop any excess precision information as though the amount in nanoseconds
   was subject to integer division by one million.

  returns: the number of milliseconds since the epoch of 1970-01-01T00:00:00Z - `long`

  throws: java.lang.ArithmeticException - if numeric overflow occurs"
  (^Long [^Instant this]
    (-> this (.toEpochMilli))))

(defn get-epoch-second
  "Gets the number of seconds from the Java epoch of 1970-01-01T00:00:00Z.

   The epoch second count is a simple incrementing count of seconds where
   second 0 is 1970-01-01T00:00:00Z.
   The nanosecond part of the day is returned by getNanosOfSecond.

  returns: the seconds from the epoch of 1970-01-01T00:00:00Z - `long`"
  (^Long [^Instant this]
    (-> this (.getEpochSecond))))

(defn compare-to
  "Compares this instant to the specified instant.

   The comparison is based on the time-line position of the instants.
   It is `consistent with equals`, as defined by Comparable.

  other-instant - the other instant to compare to, not null - `java.time.Instant`

  returns: the comparator value, negative if less, positive if greater - `int`

  throws: java.lang.NullPointerException - if otherInstant is null"
  (^Integer [^Instant this ^java.time.Instant other-instant]
    (-> this (.compareTo other-instant))))

(defn plus-seconds
  "Returns a copy of this instant with the specified duration in seconds added.

   This instance is immutable and unaffected by this method call.

  seconds-to-add - the seconds to add, positive or negative - `long`

  returns: an Instant based on this instant with the specified seconds added, not null - `java.time.Instant`

  throws: java.time.DateTimeException - if the result exceeds the maximum or minimum instant"
  (^java.time.Instant [^Instant this ^Long seconds-to-add]
    (-> this (.plusSeconds seconds-to-add))))

(defn get
  "Gets the value of the specified field from this instant as an int.

   This queries this instant for the value of the specified field.
   The returned value will always be within the valid range of values for the field.
   If it is not possible to return the value, because the field is not supported
   or for some other reason, an exception is thrown.

   If the field is a ChronoField then the query is implemented here.
   The supported fields will return valid
   values based on this date-time, except INSTANT_SECONDS which is too
   large to fit in an int and throws a DateTimeException.
   All other ChronoField instances will throw an UnsupportedTemporalTypeException.

   If the field is not a ChronoField, then the result of this method
   is obtained by invoking TemporalField.getFrom(TemporalAccessor)
   passing this as the argument. Whether the value can be obtained,
   and what the value represents, is determined by the field.

  field - the field to get, not null - `java.time.temporal.TemporalField`

  returns: the value for the field - `int`

  throws: java.time.DateTimeException - if a value for the field cannot be obtained or the value is outside the range of valid values for the field"
  (^Integer [^Instant this ^java.time.temporal.TemporalField field]
    (-> this (.get field))))

(defn equals
  "Checks if this instant is equal to the specified instant.

   The comparison is based on the time-line position of the instants.

  other-instant - the other instant, null returns false - `java.lang.Object`

  returns: true if the other instant is equal to this one - `boolean`"
  (^Boolean [^Instant this ^java.lang.Object other-instant]
    (-> this (.equals other-instant))))

