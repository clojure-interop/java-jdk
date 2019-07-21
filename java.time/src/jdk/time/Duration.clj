(ns jdk.time.Duration
  "A time-based amount of time, such as '34.5 seconds'.

  This class models a quantity or amount of time in terms of seconds and nanoseconds.
  It can be accessed using other duration-based units, such as minutes and hours.
  In addition, the DAYS unit can be used and is treated as
  exactly equal to 24 hours, thus ignoring daylight savings effects.
  See Period for the date-based equivalent to this class.

  A physical duration could be of infinite length.
  For practicality, the duration is stored with constraints similar to Instant.
  The duration uses nanosecond resolution with a maximum value of the seconds that can
  be held in a long. This is greater than the current estimated age of the universe.

  The range of a duration requires the storage of a number larger than a long.
  To achieve this, the class stores a long representing seconds and an int
  representing nanosecond-of-second, which will always be between 0 and 999,999,999.
  The model is of a directed duration, meaning that the duration may be negative.

  The duration is measured in \"seconds\", but these are not necessarily identical to
  the scientific \"SI second\" definition based on atomic clocks.
  This difference only impacts durations measured near a leap-second and should not affect
  most applications.
  See Instant for a discussion as to the meaning of the second and time-scales.


  This is a value-based
  class; use of identity-sensitive operations (including reference equality
  (==), identity hash code, or synchronization) on instances of
  Duration may have unpredictable results and should be avoided.
  The equals method should be used for comparisons."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.time Duration]))

(def *-zero
  "Static Constant.

  Constant for a duration of zero.

  type: java.time.Duration"
  Duration/ZERO)

(defn *of-days
  "Obtains a Duration representing a number of standard 24 hour days.

   The seconds are calculated based on the standard definition of a day,
   where each day is 86400 seconds which implies a 24 hour day.
   The nanosecond in second field is set to zero.

  days - the number of days, positive or negative - `long`

  returns: a Duration, not null - `java.time.Duration`

  throws: java.lang.ArithmeticException - if the input days exceeds the capacity of Duration"
  (^java.time.Duration [^Long days]
    (Duration/ofDays days)))

(defn *of
  "Obtains a Duration representing an amount in the specified unit.

   The parameters represent the two parts of a phrase like '6 Hours'. For example:


    Duration.of(3, SECONDS);
    Duration.of(465, HOURS);
   Only a subset of units are accepted by this method.
   The unit must either have an exact duration or
   be ChronoUnit.DAYS which is treated as 24 hours. Other units throw an exception.

  amount - the amount of the duration, measured in terms of the unit, positive or negative - `long`
  unit - the unit that the duration is measured in, must have an exact duration, not null - `java.time.temporal.TemporalUnit`

  returns: a Duration, not null - `java.time.Duration`

  throws: java.time.DateTimeException - if the period unit has an estimated duration"
  (^java.time.Duration [^Long amount ^java.time.temporal.TemporalUnit unit]
    (Duration/of amount unit)))

(defn *of-hours
  "Obtains a Duration representing a number of standard hours.

   The seconds are calculated based on the standard definition of an hour,
   where each hour is 3600 seconds.
   The nanosecond in second field is set to zero.

  hours - the number of hours, positive or negative - `long`

  returns: a Duration, not null - `java.time.Duration`

  throws: java.lang.ArithmeticException - if the input hours exceeds the capacity of Duration"
  (^java.time.Duration [^Long hours]
    (Duration/ofHours hours)))

(defn *of-nanos
  "Obtains a Duration representing a number of nanoseconds.

   The seconds and nanoseconds are extracted from the specified nanoseconds.

  nanos - the number of nanoseconds, positive or negative - `long`

  returns: a Duration, not null - `java.time.Duration`"
  (^java.time.Duration [^Long nanos]
    (Duration/ofNanos nanos)))

(defn *of-millis
  "Obtains a Duration representing a number of milliseconds.

   The seconds and nanoseconds are extracted from the specified milliseconds.

  millis - the number of milliseconds, positive or negative - `long`

  returns: a Duration, not null - `java.time.Duration`"
  (^java.time.Duration [^Long millis]
    (Duration/ofMillis millis)))

(defn *between
  "Obtains a Duration representing the duration between two temporal objects.

   This calculates the duration between two temporal objects. If the objects
   are of different types, then the duration is calculated based on the type
   of the first object. For example, if the first argument is a LocalTime
   then the second argument is converted to a LocalTime.

   The specified temporal objects must support the SECONDS unit.
   For full accuracy, either the NANOS unit or the
   NANO_OF_SECOND field should be supported.

   The result of this method can be a negative period if the end is before the start.
   To guarantee to obtain a positive duration call abs() on the result.

  start-inclusive - the start instant, inclusive, not null - `java.time.temporal.Temporal`
  end-exclusive - the end instant, exclusive, not null - `java.time.temporal.Temporal`

  returns: a Duration, not null - `java.time.Duration`

  throws: java.time.DateTimeException - if the seconds between the temporals cannot be obtained"
  (^java.time.Duration [^java.time.temporal.Temporal start-inclusive ^java.time.temporal.Temporal end-exclusive]
    (Duration/between start-inclusive end-exclusive)))

(defn *from
  "Obtains an instance of Duration from a temporal amount.

   This obtains a duration based on the specified amount.
   A TemporalAmount represents an  amount of time, which may be
   date-based or time-based, which this factory extracts to a duration.

   The conversion loops around the set of units from the amount and uses
   the duration of the unit to
   calculate the total Duration.
   Only a subset of units are accepted by this method. The unit must either
   have an exact duration
   or be ChronoUnit.DAYS which is treated as 24 hours.
   If any other units are found then an exception is thrown.

  amount - the temporal amount to convert, not null - `java.time.temporal.TemporalAmount`

  returns: the equivalent duration, not null - `java.time.Duration`

  throws: java.time.DateTimeException - if unable to convert to a Duration"
  (^java.time.Duration [^java.time.temporal.TemporalAmount amount]
    (Duration/from amount)))

(defn *parse
  "Obtains a Duration from a text string such as PnDTnHnMn.nS.

   This will parse a textual representation of a duration, including the
   string produced by toString(). The formats accepted are based
   on the ISO-8601 duration format PnDTnHnMn.nS with days
   considered to be exactly 24 hours.

   The string starts with an optional sign, denoted by the ASCII negative
   or positive symbol. If negative, the whole period is negated.
   The ASCII letter \"P\" is next in upper or lower case.
   There are then four sections, each consisting of a number and a suffix.
   The sections have suffixes in ASCII of \"D\", \"H\", \"M\" and \"S\" for
   days, hours, minutes and seconds, accepted in upper or lower case.
   The suffixes must occur in order. The ASCII letter \"T\" must occur before
   the first occurrence, if any, of an hour, minute or second section.
   At least one of the four sections must be present, and if \"T\" is present
   there must be at least one section after the \"T\".
   The number part of each section must consist of one or more ASCII digits.
   The number may be prefixed by the ASCII negative or positive symbol.
   The number of days, hours and minutes must parse to an long.
   The number of seconds must parse to an long with optional fraction.
   The decimal point may be either a dot or a comma.
   The fractional part may have from zero to 9 digits.

   The leading plus/minus sign, and negative values for other units are
   not part of the ISO-8601 standard.

   Examples:


      \"PT20.345S\" -- parses as \"20.345 seconds\"
      \"PT15M\"     -- parses as \"15 minutes\" (where a minute is 60 seconds)
      \"PT10H\"     -- parses as \"10 hours\" (where an hour is 3600 seconds)
      \"P2D\"       -- parses as \"2 days\" (where a day is 24 hours or 86400 seconds)
      \"P2DT3H4M\"  -- parses as \"2 days, 3 hours and 4 minutes\"
      \"P-6H3M\"    -- parses as \"-6 hours and 3 minutes\"
      \"-P6H3M\"    -- parses as \"-6 hours and -3 minutes\"
      \"-P-6H+3M\"  -- parses as \"+6 hours and -3 minutes\"

  text - the text to parse, not null - `java.lang.CharSequence`

  returns: the parsed duration, not null - `java.time.Duration`

  throws: java.time.format.DateTimeParseException - if the text cannot be parsed to a duration"
  (^java.time.Duration [^java.lang.CharSequence text]
    (Duration/parse text)))

(defn *of-minutes
  "Obtains a Duration representing a number of standard minutes.

   The seconds are calculated based on the standard definition of a minute,
   where each minute is 60 seconds.
   The nanosecond in second field is set to zero.

  minutes - the number of minutes, positive or negative - `long`

  returns: a Duration, not null - `java.time.Duration`

  throws: java.lang.ArithmeticException - if the input minutes exceeds the capacity of Duration"
  (^java.time.Duration [^Long minutes]
    (Duration/ofMinutes minutes)))

(defn *of-seconds
  "Obtains a Duration representing a number of seconds and an
   adjustment in nanoseconds.

   This method allows an arbitrary number of nanoseconds to be passed in.
   The factory will alter the values of the second and nanosecond in order
   to ensure that the stored nanosecond is in the range 0 to 999,999,999.
   For example, the following will result in the exactly the same duration:


    Duration.ofSeconds(3, 1);
    Duration.ofSeconds(4, -999_999_999);
    Duration.ofSeconds(2, 1000_000_001);

  seconds - the number of seconds, positive or negative - `long`
  nano-adjustment - the nanosecond adjustment to the number of seconds, positive or negative - `long`

  returns: a Duration, not null - `java.time.Duration`

  throws: java.lang.ArithmeticException - if the adjustment causes the seconds to exceed the capacity of Duration"
  (^java.time.Duration [^Long seconds ^Long nano-adjustment]
    (Duration/ofSeconds seconds nano-adjustment))
  (^java.time.Duration [^Long seconds]
    (Duration/ofSeconds seconds)))

(defn minus-minutes
  "Returns a copy of this duration with the specified duration in minutes subtracted.

   The number of hours is multiplied by 60 to obtain the number of seconds to subtract.

   This instance is immutable and unaffected by this method call.

  minutes-to-subtract - the minutes to subtract, positive or negative - `long`

  returns: a Duration based on this duration with the specified minutes subtracted, not null - `java.time.Duration`

  throws: java.lang.ArithmeticException - if numeric overflow occurs"
  (^java.time.Duration [^Duration this ^Long minutes-to-subtract]
    (-> this (.minusMinutes minutes-to-subtract))))

(defn to-nanos
  "Converts this duration to the total length in nanoseconds expressed as a long.

   If this duration is too large to fit in a long nanoseconds, then an
   exception is thrown.

  returns: the total length of the duration in nanoseconds - `long`

  throws: java.lang.ArithmeticException - if numeric overflow occurs"
  (^Long [^Duration this]
    (-> this (.toNanos))))

(defn minus-millis
  "Returns a copy of this duration with the specified duration in milliseconds subtracted.

   This instance is immutable and unaffected by this method call.

  millis-to-subtract - the milliseconds to subtract, positive or negative - `long`

  returns: a Duration based on this duration with the specified milliseconds subtracted, not null - `java.time.Duration`

  throws: java.lang.ArithmeticException - if numeric overflow occurs"
  (^java.time.Duration [^Duration this ^Long millis-to-subtract]
    (-> this (.minusMillis millis-to-subtract))))

(defn minus-hours
  "Returns a copy of this duration with the specified duration in hours subtracted.

   The number of hours is multiplied by 3600 to obtain the number of seconds to subtract.

   This instance is immutable and unaffected by this method call.

  hours-to-subtract - the hours to subtract, positive or negative - `long`

  returns: a Duration based on this duration with the specified hours subtracted, not null - `java.time.Duration`

  throws: java.lang.ArithmeticException - if numeric overflow occurs"
  (^java.time.Duration [^Duration this ^Long hours-to-subtract]
    (-> this (.minusHours hours-to-subtract))))

(defn negative?
  "Checks if this duration is negative, excluding zero.

   A Duration represents a directed distance between two points on
   the time-line and can therefore be positive, zero or negative.
   This method checks whether the length is less than zero.

  returns: true if this duration has a total length less than zero - `boolean`"
  (^Boolean [^Duration this]
    (-> this (.isNegative))))

(defn zero?
  "Checks if this duration is zero length.

   A Duration represents a directed distance between two points on
   the time-line and can therefore be positive, zero or negative.
   This method checks whether the length is zero.

  returns: true if this duration has a total length equal to zero - `boolean`"
  (^Boolean [^Duration this]
    (-> this (.isZero))))

(defn multiplied-by
  "Returns a copy of this duration multiplied by the scalar.

   This instance is immutable and unaffected by this method call.

  multiplicand - the value to multiply the duration by, positive or negative - `long`

  returns: a Duration based on this duration multiplied by the specified scalar, not null - `java.time.Duration`

  throws: java.lang.ArithmeticException - if numeric overflow occurs"
  (^java.time.Duration [^Duration this ^Long multiplicand]
    (-> this (.multipliedBy multiplicand))))

(defn with-nanos
  "Returns a copy of this duration with the specified nano-of-second.

   This returns a duration with the specified nano-of-second, retaining the
   seconds part of this duration.

   This instance is immutable and unaffected by this method call.

  nano-of-second - the nano-of-second to represent, from 0 to 999,999,999 - `int`

  returns: a Duration based on this period with the requested nano-of-second, not null - `java.time.Duration`

  throws: java.time.DateTimeException - if the nano-of-second is invalid"
  (^java.time.Duration [^Duration this ^Integer nano-of-second]
    (-> this (.withNanos nano-of-second))))

(defn get-units
  "Gets the set of units supported by this duration.

   The supported units are SECONDS,
   and NANOS.
   They are returned in the order seconds, nanos.

   This set can be used in conjunction with get(TemporalUnit)
   to access the entire state of the duration.

  returns: a list containing the seconds and nanos units, not null - `java.util.List<java.time.temporal.TemporalUnit>`"
  (^java.util.List [^Duration this]
    (-> this (.getUnits))))

(defn get-nano
  "Gets the number of nanoseconds within the second in this duration.

   The length of the duration is stored using two fields - seconds and nanoseconds.
   The nanoseconds part is a value from 0 to 999,999,999 that is an adjustment to
   the length in seconds.
   The total duration is defined by calling this method and getSeconds().

   A Duration represents a directed distance between two points on the time-line.
   A negative duration is expressed by the negative sign of the seconds part.
   A duration of -1 nanosecond is stored as -1 seconds plus 999,999,999 nanoseconds.

  returns: the nanoseconds within the second part of the length of the duration, from 0 to 999,999,999 - `int`"
  (^Integer [^Duration this]
    (-> this (.getNano))))

(defn plus-millis
  "Returns a copy of this duration with the specified duration in milliseconds added.

   This instance is immutable and unaffected by this method call.

  millis-to-add - the milliseconds to add, positive or negative - `long`

  returns: a Duration based on this duration with the specified milliseconds added, not null - `java.time.Duration`

  throws: java.lang.ArithmeticException - if numeric overflow occurs"
  (^java.time.Duration [^Duration this ^Long millis-to-add]
    (-> this (.plusMillis millis-to-add))))

(defn to-minutes
  "Gets the number of minutes in this duration.

   This returns the total number of minutes in the duration by dividing the
   number of seconds by 60.

   This instance is immutable and unaffected by this method call.

  returns: the number of minutes in the duration, may be negative - `long`"
  (^Long [^Duration this]
    (-> this (.toMinutes))))

(defn minus-seconds
  "Returns a copy of this duration with the specified duration in seconds subtracted.

   This instance is immutable and unaffected by this method call.

  seconds-to-subtract - the seconds to subtract, positive or negative - `long`

  returns: a Duration based on this duration with the specified seconds subtracted, not null - `java.time.Duration`

  throws: java.lang.ArithmeticException - if numeric overflow occurs"
  (^java.time.Duration [^Duration this ^Long seconds-to-subtract]
    (-> this (.minusSeconds seconds-to-subtract))))

(defn plus-nanos
  "Returns a copy of this duration with the specified duration in nanoseconds added.

   This instance is immutable and unaffected by this method call.

  nanos-to-add - the nanoseconds to add, positive or negative - `long`

  returns: a Duration based on this duration with the specified nanoseconds added, not null - `java.time.Duration`

  throws: java.lang.ArithmeticException - if numeric overflow occurs"
  (^java.time.Duration [^Duration this ^Long nanos-to-add]
    (-> this (.plusNanos nanos-to-add))))

(defn plus
  "Returns a copy of this duration with the specified duration added.

   The duration amount is measured in terms of the specified unit.
   Only a subset of units are accepted by this method.
   The unit must either have an exact duration or
   be ChronoUnit.DAYS which is treated as 24 hours. Other units throw an exception.

   This instance is immutable and unaffected by this method call.

  amount-to-add - the amount to add, measured in terms of the unit, positive or negative - `long`
  unit - the unit that the amount is measured in, must have an exact duration, not null - `java.time.temporal.TemporalUnit`

  returns: a Duration based on this duration with the specified duration added, not null - `java.time.Duration`

  throws: java.time.temporal.UnsupportedTemporalTypeException - if the unit is not supported"
  (^java.time.Duration [^Duration this ^Long amount-to-add ^java.time.temporal.TemporalUnit unit]
    (-> this (.plus amount-to-add unit)))
  (^java.time.Duration [^Duration this ^java.time.Duration duration]
    (-> this (.plus duration))))

(defn divided-by
  "Returns a copy of this duration divided by the specified value.

   This instance is immutable and unaffected by this method call.

  divisor - the value to divide the duration by, positive or negative, not zero - `long`

  returns: a Duration based on this duration divided by the specified divisor, not null - `java.time.Duration`

  throws: java.lang.ArithmeticException - if the divisor is zero or if numeric overflow occurs"
  (^java.time.Duration [^Duration this ^Long divisor]
    (-> this (.dividedBy divisor))))

(defn plus-minutes
  "Returns a copy of this duration with the specified duration in minutes added.

   This instance is immutable and unaffected by this method call.

  minutes-to-add - the minutes to add, positive or negative - `long`

  returns: a Duration based on this duration with the specified minutes added, not null - `java.time.Duration`

  throws: java.lang.ArithmeticException - if numeric overflow occurs"
  (^java.time.Duration [^Duration this ^Long minutes-to-add]
    (-> this (.plusMinutes minutes-to-add))))

(defn to-string
  "A string representation of this duration using ISO-8601 seconds
   based representation, such as PT8H6M12.345S.

   The format of the returned string will be PTnHnMnS, where n is
   the relevant hours, minutes or seconds part of the duration.
   Any fractional seconds are placed after a decimal point i the seconds section.
   If a section has a zero value, it is omitted.
   The hours, minutes and seconds will all have the same sign.

   Examples:


      \"20.345 seconds\"                 -- \"PT20.345S
      \"15 minutes\" (15 * 60 seconds)   -- \"PT15M\"
      \"10 hours\" (10 * 3600 seconds)   -- \"PT10H\"
      \"2 days\" (2 * 86400 seconds)     -- \"PT48H\"
   Note that multiples of 24 hours are not output as days to avoid confusion
   with Period.

  returns: an ISO-8601 representation of this duration, not null - `java.lang.String`"
  (^java.lang.String [^Duration this]
    (-> this (.toString))))

(defn minus
  "Returns a copy of this duration with the specified duration subtracted.

   The duration amount is measured in terms of the specified unit.
   Only a subset of units are accepted by this method.
   The unit must either have an exact duration or
   be ChronoUnit.DAYS which is treated as 24 hours. Other units throw an exception.

   This instance is immutable and unaffected by this method call.

  amount-to-subtract - the amount to subtract, measured in terms of the unit, positive or negative - `long`
  unit - the unit that the amount is measured in, must have an exact duration, not null - `java.time.temporal.TemporalUnit`

  returns: a Duration based on this duration with the specified duration subtracted, not null - `java.time.Duration`

  throws: java.lang.ArithmeticException - if numeric overflow occurs"
  (^java.time.Duration [^Duration this ^Long amount-to-subtract ^java.time.temporal.TemporalUnit unit]
    (-> this (.minus amount-to-subtract unit)))
  (^java.time.Duration [^Duration this ^java.time.Duration duration]
    (-> this (.minus duration))))

(defn add-to
  "Adds this duration to the specified temporal object.

   This returns a temporal object of the same observable type as the input
   with this duration added.

   In most cases, it is clearer to reverse the calling pattern by using
   Temporal.plus(TemporalAmount).


     // these two lines are equivalent, but the second approach is recommended
     dateTime = thisDuration.addTo(dateTime);
     dateTime = dateTime.plus(thisDuration);

   The calculation will add the seconds, then nanos.
   Only non-zero amounts will be added.

   This instance is immutable and unaffected by this method call.

  temporal - the temporal object to adjust, not null - `java.time.temporal.Temporal`

  returns: an object of the same type with the adjustment made, not null - `java.time.temporal.Temporal`

  throws: java.time.DateTimeException - if unable to add"
  (^java.time.temporal.Temporal [^Duration this ^java.time.temporal.Temporal temporal]
    (-> this (.addTo temporal))))

(defn plus-hours
  "Returns a copy of this duration with the specified duration in hours added.

   This instance is immutable and unaffected by this method call.

  hours-to-add - the hours to add, positive or negative - `long`

  returns: a Duration based on this duration with the specified hours added, not null - `java.time.Duration`

  throws: java.lang.ArithmeticException - if numeric overflow occurs"
  (^java.time.Duration [^Duration this ^Long hours-to-add]
    (-> this (.plusHours hours-to-add))))

(defn plus-days
  "Returns a copy of this duration with the specified duration in standard 24 hour days added.

   The number of days is multiplied by 86400 to obtain the number of seconds to add.
   This is based on the standard definition of a day as 24 hours.

   This instance is immutable and unaffected by this method call.

  days-to-add - the days to add, positive or negative - `long`

  returns: a Duration based on this duration with the specified days added, not null - `java.time.Duration`

  throws: java.lang.ArithmeticException - if numeric overflow occurs"
  (^java.time.Duration [^Duration this ^Long days-to-add]
    (-> this (.plusDays days-to-add))))

(defn to-millis
  "Converts this duration to the total length in milliseconds.

   If this duration is too large to fit in a long milliseconds, then an
   exception is thrown.

   If this duration has greater than millisecond precision, then the conversion
   will drop any excess precision information as though the amount in nanoseconds
   was subject to integer division by one million.

  returns: the total length of the duration in milliseconds - `long`

  throws: java.lang.ArithmeticException - if numeric overflow occurs"
  (^Long [^Duration this]
    (-> this (.toMillis))))

(defn to-hours
  "Gets the number of hours in this duration.

   This returns the total number of hours in the duration by dividing the
   number of seconds by 3600.

   This instance is immutable and unaffected by this method call.

  returns: the number of hours in the duration, may be negative - `long`"
  (^Long [^Duration this]
    (-> this (.toHours))))

(defn negated
  "Returns a copy of this duration with the length negated.

   This method swaps the sign of the total length of this duration.
   For example, PT1.3S will be returned as PT-1.3S.

   This instance is immutable and unaffected by this method call.

  returns: a Duration based on this duration with the amount negated, not null - `java.time.Duration`

  throws: java.lang.ArithmeticException - if numeric overflow occurs"
  (^java.time.Duration [^Duration this]
    (-> this (.negated))))

(defn abs
  "Returns a copy of this duration with a positive length.

   This method returns a positive duration by effectively removing the sign from any negative total length.
   For example, PT-1.3S will be returned as PT1.3S.

   This instance is immutable and unaffected by this method call.

  returns: a Duration based on this duration with an absolute length, not null - `java.time.Duration`

  throws: java.lang.ArithmeticException - if numeric overflow occurs"
  (^java.time.Duration [^Duration this]
    (-> this (.abs))))

(defn get-seconds
  "Gets the number of seconds in this duration.

   The length of the duration is stored using two fields - seconds and nanoseconds.
   The nanoseconds part is a value from 0 to 999,999,999 that is an adjustment to
   the length in seconds.
   The total duration is defined by calling this method and getNano().

   A Duration represents a directed distance between two points on the time-line.
   A negative duration is expressed by the negative sign of the seconds part.
   A duration of -1 nanosecond is stored as -1 seconds plus 999,999,999 nanoseconds.

  returns: the whole seconds part of the length of the duration, positive or negative - `long`"
  (^Long [^Duration this]
    (-> this (.getSeconds))))

(defn minus-nanos
  "Returns a copy of this duration with the specified duration in nanoseconds subtracted.

   This instance is immutable and unaffected by this method call.

  nanos-to-subtract - the nanoseconds to subtract, positive or negative - `long`

  returns: a Duration based on this duration with the specified nanoseconds subtracted, not null - `java.time.Duration`

  throws: java.lang.ArithmeticException - if numeric overflow occurs"
  (^java.time.Duration [^Duration this ^Long nanos-to-subtract]
    (-> this (.minusNanos nanos-to-subtract))))

(defn hash-code
  "A hash code for this duration.

  returns: a suitable hash code - `int`"
  (^Integer [^Duration this]
    (-> this (.hashCode))))

(defn with-seconds
  "Returns a copy of this duration with the specified amount of seconds.

   This returns a duration with the specified seconds, retaining the
   nano-of-second part of this duration.

   This instance is immutable and unaffected by this method call.

  seconds - the seconds to represent, may be negative - `long`

  returns: a Duration based on this period with the requested seconds, not null - `java.time.Duration`"
  (^java.time.Duration [^Duration this ^Long seconds]
    (-> this (.withSeconds seconds))))

(defn subtract-from
  "Subtracts this duration from the specified temporal object.

   This returns a temporal object of the same observable type as the input
   with this duration subtracted.

   In most cases, it is clearer to reverse the calling pattern by using
   Temporal.minus(TemporalAmount).


     // these two lines are equivalent, but the second approach is recommended
     dateTime = thisDuration.subtractFrom(dateTime);
     dateTime = dateTime.minus(thisDuration);

   The calculation will subtract the seconds, then nanos.
   Only non-zero amounts will be added.

   This instance is immutable and unaffected by this method call.

  temporal - the temporal object to adjust, not null - `java.time.temporal.Temporal`

  returns: an object of the same type with the adjustment made, not null - `java.time.temporal.Temporal`

  throws: java.time.DateTimeException - if unable to subtract"
  (^java.time.temporal.Temporal [^Duration this ^java.time.temporal.Temporal temporal]
    (-> this (.subtractFrom temporal))))

(defn compare-to
  "Compares this duration to the specified Duration.

   The comparison is based on the total length of the durations.
   It is \"consistent with equals\", as defined by Comparable.

  other-duration - the other duration to compare to, not null - `java.time.Duration`

  returns: the comparator value, negative if less, positive if greater - `int`"
  (^Integer [^Duration this ^java.time.Duration other-duration]
    (-> this (.compareTo other-duration))))

(defn plus-seconds
  "Returns a copy of this duration with the specified duration in seconds added.

   This instance is immutable and unaffected by this method call.

  seconds-to-add - the seconds to add, positive or negative - `long`

  returns: a Duration based on this duration with the specified seconds added, not null - `java.time.Duration`

  throws: java.lang.ArithmeticException - if numeric overflow occurs"
  (^java.time.Duration [^Duration this ^Long seconds-to-add]
    (-> this (.plusSeconds seconds-to-add))))

(defn get
  "Gets the value of the requested unit.

   This returns a value for each of the two supported units,
   SECONDS and NANOS.
   All other units throw an exception.

  unit - the TemporalUnit for which to return the value - `java.time.temporal.TemporalUnit`

  returns: the long value of the unit - `long`

  throws: java.time.DateTimeException - if the unit is not supported"
  (^Long [^Duration this ^java.time.temporal.TemporalUnit unit]
    (-> this (.get unit))))

(defn equals
  "Checks if this duration is equal to the specified Duration.

   The comparison is based on the total length of the durations.

  other-duration - the other duration, null returns false - `java.lang.Object`

  returns: true if the other duration is equal to this one - `boolean`"
  (^Boolean [^Duration this ^java.lang.Object other-duration]
    (-> this (.equals other-duration))))

(defn minus-days
  "Returns a copy of this duration with the specified duration in standard 24 hour days subtracted.

   The number of days is multiplied by 86400 to obtain the number of seconds to subtract.
   This is based on the standard definition of a day as 24 hours.

   This instance is immutable and unaffected by this method call.

  days-to-subtract - the days to subtract, positive or negative - `long`

  returns: a Duration based on this duration with the specified days subtracted, not null - `java.time.Duration`

  throws: java.lang.ArithmeticException - if numeric overflow occurs"
  (^java.time.Duration [^Duration this ^Long days-to-subtract]
    (-> this (.minusDays days-to-subtract))))

(defn to-days
  "Gets the number of days in this duration.

   This returns the total number of days in the duration by dividing the
   number of seconds by 86400.
   This is based on the standard definition of a day as 24 hours.

   This instance is immutable and unaffected by this method call.

  returns: the number of days in the duration, may be negative - `long`"
  (^Long [^Duration this]
    (-> this (.toDays))))

