(ns jdk.time.temporal.TemporalUnit
  "A unit of date-time, such as Days or Hours.

  Measurement of time is built on units, such as years, months, days, hours, minutes and seconds.
  Implementations of this interface represent those units.

  An instance of this interface represents the unit itself, rather than an amount of the unit.
  See Period for a class that represents an amount in terms of the common units.

  The most commonly used units are defined in ChronoUnit.
  Further units are supplied in IsoFields.
  Units can also be written by application code by implementing this interface.

  The unit works using double dispatch. Client code calls methods on a date-time like
  LocalDateTime which check if the unit is a ChronoUnit.
  If it is, then the date-time must handle it.
  Otherwise, the method call is re-dispatched to the matching method in this interface."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.time.temporal TemporalUnit]))

(defn get-duration
  "Gets the duration of this unit, which may be an estimate.

   All units return a duration measured in standard nanoseconds from this method.
   The duration will be positive and non-zero.
   For example, an hour has a duration of 60 * 60 * 1,000,000,000ns.

   Some units may return an accurate duration while others return an estimate.
   For example, days have an estimated duration due to the possibility of
   daylight saving time changes.
   To determine if the duration is an estimate, use isDurationEstimated().

  returns: the duration of this unit, which may be an estimate, not null - `java.time.Duration`"
  ([^. this]
    (-> this (.getDuration))))

(defn duration-estimated?
  "Checks if the duration of the unit is an estimate.

   All units have a duration, however the duration is not always accurate.
   For example, days have an estimated duration due to the possibility of
   daylight saving time changes.
   This method returns true if the duration is an estimate and false if it is
   accurate. Note that accurate/estimated ignores leap seconds.

  returns: true if the duration is estimated, false if accurate - `boolean`"
  ([^. this]
    (-> this (.isDurationEstimated))))

(defn date-based?
  "Checks if this unit represents a component of a date.

   A date is time-based if it can be used to imply meaning from a date.
   It must have a duration that is an integral
   multiple of the length of a standard day.
   Note that it is valid for both isDateBased() and isTimeBased()
   to return false, such as when representing a unit like 36 hours.

  returns: true if this unit is a component of a date - `boolean`"
  ([^. this]
    (-> this (.isDateBased))))

(defn time-based?
  "Checks if this unit represents a component of a time.

   A unit is time-based if it can be used to imply meaning from a time.
   It must have a duration that divides into
   the length of a standard day without remainder.
   Note that it is valid for both isDateBased() and isTimeBased()
   to return false, such as when representing a unit like 36 hours.

  returns: true if this unit is a component of a time - `boolean`"
  ([^. this]
    (-> this (.isTimeBased))))

(defn is-supported-by
  "Checks if this unit is supported by the specified temporal object.

   This checks that the implementing date-time can add/subtract this unit.
   This can be used to avoid throwing an exception.

   This default implementation derives the value using
   Temporal.plus(long, TemporalUnit).

  temporal - the temporal object to check, not null - `java.time.temporal.Temporal`

  returns: true if the unit is supported - `default boolean`"
  ([^. this ^java.time.temporal.Temporal temporal]
    (-> this (.isSupportedBy temporal))))

(defn add-to
  "Returns a copy of the specified temporal object with the specified period added.

   The period added is a multiple of this unit. For example, this method
   could be used to add `3 days` to a date by calling this method on the
   instance representing `days`, passing the date and the period `3`.
   The period to be added may be negative, which is equivalent to subtraction.

   There are two equivalent ways of using this method.
   The first is to invoke this method directly.
   The second is to use Temporal.plus(long, TemporalUnit):


     // these two lines are equivalent, but the second approach is recommended
     temporal = thisUnit.addTo(temporal);
     temporal = temporal.plus(thisUnit);
   It is recommended to use the second approach, plus(TemporalUnit),
   as it is a lot clearer to read in code.

   Implementations should perform any queries or calculations using the units
   available in ChronoUnit or the fields available in ChronoField.
   If the unit is not supported an UnsupportedTemporalTypeException must be thrown.

   Implementations must not alter the specified temporal object.
   Instead, an adjusted copy of the original must be returned.
   This provides equivalent, safe behavior for immutable and mutable implementations.

  temporal - the temporal object to adjust, not null - `R`
  amount - the amount of this unit to add, positive or negative - `long`

  returns: the adjusted temporal object, not null - `<R extends java.time.temporal.Temporal> R`

  throws: java.time.DateTimeException - if the amount cannot be added"
  ([^. this temporal ^Long amount]
    (-> this (.addTo temporal amount))))

(defn between
  "Calculates the amount of time between two temporal objects.

   This calculates the amount in terms of this unit. The start and end
   points are supplied as temporal objects and must be of compatible types.
   The implementation will convert the second type to be an instance of the
   first type before the calculating the amount.
   The result will be negative if the end is before the start.
   For example, the amount in hours between two temporal objects can be
   calculated using HOURS.between(startTime, endTime).

   The calculation returns a whole number, representing the number of
   complete units between the two temporals.
   For example, the amount in hours between the times 11:30 and 13:29
   will only be one hour as it is one minute short of two hours.

   There are two equivalent ways of using this method.
   The first is to invoke this method directly.
   The second is to use Temporal.until(Temporal, TemporalUnit):


     // these two lines are equivalent
     between = thisUnit.between(start, end);
     between = start.until(end, thisUnit);
   The choice should be made based on which makes the code more readable.

   For example, this method allows the number of days between two dates to
   be calculated:


    long daysBetween = DAYS.between(start, end);
    // or alternatively
    long daysBetween = start.until(end, DAYS);

   Implementations should perform any queries or calculations using the units
   available in ChronoUnit or the fields available in ChronoField.
   If the unit is not supported an UnsupportedTemporalTypeException must be thrown.
   Implementations must not alter the specified temporal objects.

  temporal-1-inclusive - the base temporal object, not null - `java.time.temporal.Temporal`
  temporal-2-exclusive - the other temporal object, exclusive, not null - `java.time.temporal.Temporal`

  returns: the amount of time between temporal1Inclusive and temporal2Exclusive
    in terms of this unit; positive if temporal2Exclusive is later than
    temporal1Inclusive, negative if earlier - `long`

  throws: java.time.DateTimeException - if the amount cannot be calculated, or the end temporal cannot be converted to the same type as the start temporal"
  ([^. this ^java.time.temporal.Temporal temporal-1-inclusive ^java.time.temporal.Temporal temporal-2-exclusive]
    (-> this (.between temporal-1-inclusive temporal-2-exclusive))))

(defn to-string
  "Gets a descriptive name for the unit.

   This should be in the plural and upper-first camel case, such as 'Days' or 'Minutes'.

  returns: the name of this unit, not null - `java.lang.String`"
  ([^. this]
    (-> this (.toString))))

