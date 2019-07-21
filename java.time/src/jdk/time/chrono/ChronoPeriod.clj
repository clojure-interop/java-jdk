(ns jdk.time.chrono.ChronoPeriod
  "A date-based amount of time, such as '3 years, 4 months and 5 days' in an
  arbitrary chronology, intended for advanced globalization use cases.

  This interface models a date-based amount of time in a calendar system.
  While most calendar systems use years, months and days, some do not.
  Therefore, this interface operates solely in terms of a set of supported
  units that are defined by the Chronology.
  The set of supported units is fixed for a given chronology.
  The amount of a supported unit may be set to zero.

  The period is modeled as a directed amount of time, meaning that individual
  parts of the period may be negative."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.time.chrono ChronoPeriod]))

(defn is-negative
  "Checks if any of the supported units of this period are negative.

  returns: true if any unit of this period is negative - `default boolean`"
  ([^ChronoPeriod this]
    (-> this (.isNegative))))

(defn is-zero
  "Checks if all the supported units of this period are zero.

  returns: true if this period is zero-length - `default boolean`"
  ([^ChronoPeriod this]
    (-> this (.isZero))))

(defn multiplied-by
  "Returns a new instance with each amount in this period in this period
   multiplied by the specified scalar.

   This returns a period with each supported unit individually multiplied.
   For example, a period of \"2 years, -3 months and 4 days\" multiplied by
   3 will return \"6 years, -9 months and 12 days\".
   No normalization is performed.

  scalar - the scalar to multiply by, not null - `int`

  returns: a ChronoPeriod based on this period with the amounts multiplied
    by the scalar, not null - `java.time.chrono.ChronoPeriod`

  throws: java.lang.ArithmeticException - if numeric overflow occurs"
  (^java.time.chrono.ChronoPeriod [^ChronoPeriod this ^Integer scalar]
    (-> this (.multipliedBy scalar))))

(defn get-units
  "Gets the set of units supported by this period.

   The supported units are chronology specific.
   They will typically be YEARS,
   MONTHS and DAYS.
   They are returned in order from largest to smallest.

   This set can be used in conjunction with get(TemporalUnit)
   to access the entire state of the period.

  returns: a list containing the supported units, not null - `java.util.List<java.time.temporal.TemporalUnit>`"
  (^java.util.List [^ChronoPeriod this]
    (-> this (.getUnits))))

(defn plus
  "Returns a copy of this period with the specified period added.

   If the specified amount is a ChronoPeriod then it must have
   the same chronology as this period. Implementations may choose to
   accept or reject other TemporalAmount implementations.

   This instance is immutable and unaffected by this method call.

  amount-to-add - the period to add, not null - `java.time.temporal.TemporalAmount`

  returns: a ChronoPeriod based on this period with the requested period added, not null - `java.time.chrono.ChronoPeriod`

  throws: java.lang.ArithmeticException - if numeric overflow occurs"
  (^java.time.chrono.ChronoPeriod [^ChronoPeriod this ^java.time.temporal.TemporalAmount amount-to-add]
    (-> this (.plus amount-to-add))))

(defn to-string
  "Outputs this period as a String.

   The output will include the period amounts and chronology.

  returns: a string representation of this period, not null - `java.lang.String`"
  (^java.lang.String [^ChronoPeriod this]
    (-> this (.toString))))

(defn minus
  "Returns a copy of this period with the specified period subtracted.

   If the specified amount is a ChronoPeriod then it must have
   the same chronology as this period. Implementations may choose to
   accept or reject other TemporalAmount implementations.

   This instance is immutable and unaffected by this method call.

  amount-to-subtract - the period to subtract, not null - `java.time.temporal.TemporalAmount`

  returns: a ChronoPeriod based on this period with the requested period subtracted, not null - `java.time.chrono.ChronoPeriod`

  throws: java.lang.ArithmeticException - if numeric overflow occurs"
  (^java.time.chrono.ChronoPeriod [^ChronoPeriod this ^java.time.temporal.TemporalAmount amount-to-subtract]
    (-> this (.minus amount-to-subtract))))

(defn add-to
  "Adds this period to the specified temporal object.

   This returns a temporal object of the same observable type as the input
   with this period added.

   In most cases, it is clearer to reverse the calling pattern by using
   Temporal.plus(TemporalAmount).


     // these two lines are equivalent, but the second approach is recommended
     dateTime = thisPeriod.addTo(dateTime);
     dateTime = dateTime.plus(thisPeriod);

   The specified temporal must have the same chronology as this period.
   This returns a temporal with the non-zero supported units added.

   This instance is immutable and unaffected by this method call.

  temporal - the temporal object to adjust, not null - `java.time.temporal.Temporal`

  returns: an object of the same type with the adjustment made, not null - `java.time.temporal.Temporal`

  throws: java.time.DateTimeException - if unable to add"
  (^java.time.temporal.Temporal [^ChronoPeriod this ^java.time.temporal.Temporal temporal]
    (-> this (.addTo temporal))))

(defn negated
  "Returns a new instance with each amount in this period negated.

   This returns a period with each supported unit individually negated.
   For example, a period of \"2 years, -3 months and 4 days\" will be
   negated to \"-2 years, 3 months and -4 days\".
   No normalization is performed.

  returns: a ChronoPeriod based on this period with the amounts negated, not null - `default java.time.chrono.ChronoPeriod`

  throws: java.lang.ArithmeticException - if numeric overflow occurs, which only happens if one of the units has the value Long.MIN_VALUE"
  ([^ChronoPeriod this]
    (-> this (.negated))))

(defn normalized
  "Returns a copy of this period with the amounts of each unit normalized.

   The process of normalization is specific to each calendar system.
   For example, in the ISO calendar system, the years and months are
   normalized but the days are not, such that \"15 months\" would be
   normalized to \"1 year and 3 months\".

   This instance is immutable and unaffected by this method call.

  returns: a ChronoPeriod based on this period with the amounts of each
    unit normalized, not null - `java.time.chrono.ChronoPeriod`

  throws: java.lang.ArithmeticException - if numeric overflow occurs"
  (^java.time.chrono.ChronoPeriod [^ChronoPeriod this]
    (-> this (.normalized))))

(defn *between
  "Obtains a ChronoPeriod consisting of amount of time between two dates.

   The start date is included, but the end date is not.
   The period is calculated using ChronoLocalDate.until(ChronoLocalDate).
   As such, the calculation is chronology specific.

   The chronology of the first date is used.
   The chronology of the second date is ignored, with the date being converted
   to the target chronology system before the calculation starts.

   The result of this method can be a negative period if the end is before the start.
   In most cases, the positive/negative sign will be the same in each of the supported fields.

  start-date-inclusive - the start date, inclusive, specifying the chronology of the calculation, not null - `java.time.chrono.ChronoLocalDate`
  end-date-exclusive - the end date, exclusive, in any chronology, not null - `java.time.chrono.ChronoLocalDate`

  returns: the period between this date and the end date, not null - `java.time.chrono.ChronoPeriod`"
  (^java.time.chrono.ChronoPeriod [^java.time.chrono.ChronoLocalDate start-date-inclusive ^java.time.chrono.ChronoLocalDate end-date-exclusive]
    (ChronoPeriod/between start-date-inclusive end-date-exclusive)))

(defn get-chronology
  "Gets the chronology that defines the meaning of the supported units.

   The period is defined by the chronology.
   It controls the supported units and restricts addition/subtraction
   to ChronoLocalDate instances of the same chronology.

  returns: the chronology defining the period, not null - `java.time.chrono.Chronology`"
  (^java.time.chrono.Chronology [^ChronoPeriod this]
    (-> this (.getChronology))))

(defn hash-code
  "A hash code for this period.

  returns: a suitable hash code - `int`"
  (^Integer [^ChronoPeriod this]
    (-> this (.hashCode))))

(defn subtract-from
  "Subtracts this period from the specified temporal object.

   This returns a temporal object of the same observable type as the input
   with this period subtracted.

   In most cases, it is clearer to reverse the calling pattern by using
   Temporal.minus(TemporalAmount).


     // these two lines are equivalent, but the second approach is recommended
     dateTime = thisPeriod.subtractFrom(dateTime);
     dateTime = dateTime.minus(thisPeriod);

   The specified temporal must have the same chronology as this period.
   This returns a temporal with the non-zero supported units subtracted.

   This instance is immutable and unaffected by this method call.

  temporal - the temporal object to adjust, not null - `java.time.temporal.Temporal`

  returns: an object of the same type with the adjustment made, not null - `java.time.temporal.Temporal`

  throws: java.time.DateTimeException - if unable to subtract"
  (^java.time.temporal.Temporal [^ChronoPeriod this ^java.time.temporal.Temporal temporal]
    (-> this (.subtractFrom temporal))))

(defn get
  "Gets the value of the requested unit.

   The supported units are chronology specific.
   They will typically be YEARS,
   MONTHS and DAYS.
   Requesting an unsupported unit will throw an exception.

  unit - the TemporalUnit for which to return the value - `java.time.temporal.TemporalUnit`

  returns: the long value of the unit - `long`

  throws: java.time.DateTimeException - if the unit is not supported"
  (^Long [^ChronoPeriod this ^java.time.temporal.TemporalUnit unit]
    (-> this (.get unit))))

(defn equals
  "Checks if this period is equal to another period, including the chronology.

   Compares this period with another ensuring that the type, each amount and
   the chronology are the same.
   Note that this means that a period of \"15 Months\" is not equal to a period
   of \"1 Year and 3 Months\".

  obj - the object to check, null returns false - `java.lang.Object`

  returns: true if this is equal to the other period - `boolean`"
  (^Boolean [^ChronoPeriod this ^java.lang.Object obj]
    (-> this (.equals obj))))

