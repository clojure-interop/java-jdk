(ns jdk.time.temporal.TemporalAmount
  "Framework-level interface defining an amount of time, such as
  `6 hours`, `8 days` or `2 years and 3 months`.

  This is the base interface type for amounts of time.
  An amount is distinct from a date or time-of-day in that it is not tied
  to any specific point on the time-line.

  The amount can be thought of as a Map of TemporalUnit to
  long, exposed via getUnits() and get(TemporalUnit).
  A simple case might have a single unit-value pair, such as `6 hours`.
  A more complex case may have multiple unit-value pairs, such as
  `7 years, 3 months and 5 days`.

  There are two common implementations.
  Period is a date-based implementation, storing years, months and days.
  Duration is a time-based implementation, storing seconds and nanoseconds,
  but providing some access using other duration based units such as minutes,
  hours and fixed 24-hour days.

  This interface is a framework-level interface that should not be widely
  used in application code. Instead, applications should create and pass
  around instances of concrete types, such as Period and Duration."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.time.temporal TemporalAmount]))

(defn get
  "Returns the value of the requested unit.
   The units returned from getUnits() uniquely define the
   value of the TemporalAmount.  A value must be returned
   for each unit listed in getUnits.

  unit - the TemporalUnit for which to return the value - `java.time.temporal.TemporalUnit`

  returns: the long value of the unit - `long`

  throws: java.time.DateTimeException - if a value for the unit cannot be obtained"
  ([^. this ^java.time.temporal.TemporalUnit unit]
    (-> this (.get unit))))

(defn get-units
  "Returns the list of units uniquely defining the value of this TemporalAmount.
   The list of TemporalUnits is defined by the implementation class.
   The list is a snapshot of the units at the time getUnits
   is called and is not mutable.
   The units are ordered from longest duration to the shortest duration
   of the unit.

  returns: the List of TemporalUnits; not null - `java.util.List<java.time.temporal.TemporalUnit>`"
  ([^. this]
    (-> this (.getUnits))))

(defn add-to
  "Adds to the specified temporal object.

   Adds the amount to the specified temporal object using the logic
   encapsulated in the implementing class.

   There are two equivalent ways of using this method.
   The first is to invoke this method directly.
   The second is to use Temporal.plus(TemporalAmount):


     // These two lines are equivalent, but the second approach is recommended
     dateTime = amount.addTo(dateTime);
     dateTime = dateTime.plus(adder);
   It is recommended to use the second approach, plus(TemporalAmount),
   as it is a lot clearer to read in code.

  temporal - the temporal object to add the amount to, not null - `java.time.temporal.Temporal`

  returns: an object of the same observable type with the addition made, not null - `java.time.temporal.Temporal`

  throws: java.time.DateTimeException - if unable to add"
  ([^. this ^java.time.temporal.Temporal temporal]
    (-> this (.addTo temporal))))

(defn subtract-from
  "Subtracts this object from the specified temporal object.

   Subtracts the amount from the specified temporal object using the logic
   encapsulated in the implementing class.

   There are two equivalent ways of using this method.
   The first is to invoke this method directly.
   The second is to use Temporal.minus(TemporalAmount):


     // these two lines are equivalent, but the second approach is recommended
     dateTime = amount.subtractFrom(dateTime);
     dateTime = dateTime.minus(amount);
   It is recommended to use the second approach, minus(TemporalAmount),
   as it is a lot clearer to read in code.

  temporal - the temporal object to subtract the amount from, not null - `java.time.temporal.Temporal`

  returns: an object of the same observable type with the subtraction made, not null - `java.time.temporal.Temporal`

  throws: java.time.DateTimeException - if unable to subtract"
  ([^. this ^java.time.temporal.Temporal temporal]
    (-> this (.subtractFrom temporal))))

