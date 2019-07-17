(ns jdk.time.temporal.Temporal
  "Framework-level interface defining read-write access to a temporal object,
  such as a date, time, offset or some combination of these.

  This is the base interface type for date, time and offset objects that
  are complete enough to be manipulated using plus and minus.
  It is implemented by those classes that can provide and manipulate information
  as java.time.temporal.fields or java.time.temporal.queries.
  See TemporalAccessor for the read-only version of this interface.

  Most date and time information can be represented as a number.
  These are modeled using TemporalField with the number held using
  a long to handle large values. Year, month and day-of-month are
  simple examples of fields, but they also include instant and offsets.
  See ChronoField for the standard set of fields.

  Two pieces of date/time information cannot be represented by numbers,
  the java.time.chrono.chronology and the
  java.time.time-zone.
  These can be accessed via queries using
  the static methods defined on TemporalQuery.

  This interface is a framework-level interface that should not be widely
  used in application code. Instead, applications should create and pass
  around instances of concrete types, such as LocalDate.
  There are many reasons for this, part of which is that implementations
  of this interface may be in calendar systems other than ISO.
  See ChronoLocalDate for a fuller discussion of the issues.

  When to implement

  A class should implement this interface if it meets three criteria:

  it provides access to date/time/offset information, as per TemporalAccessor
  the set of fields are contiguous from the largest to the smallest
  the set of fields are complete, such that no other field is needed to define the
   valid range of values for the fields that are represented


  Four examples make this clear:

  LocalDate implements this interface as it represents a set of fields
   that are contiguous from days to forever and require no external information to determine
   the validity of each date. It is therefore able to implement plus/minus correctly.
  LocalTime implements this interface as it represents a set of fields
   that are contiguous from nanos to within days and require no external information to determine
   validity. It is able to implement plus/minus correctly, by wrapping around the day.
  MonthDay, the combination of month-of-year and day-of-month, does not implement
   this interface.  While the combination is contiguous, from days to months within years,
   the combination does not have sufficient information to define the valid range of values
   for day-of-month.  As such, it is unable to implement plus/minus correctly.
  The combination day-of-week and day-of-month (`Friday the 13th`) should not implement
   this interface. It does not represent a contiguous set of fields, as days to weeks overlaps
   days to months."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.time.temporal Temporal]))

(defn supported?
  "Checks if the specified unit is supported.

   This checks if the specified unit can be added to, or subtracted from, this date-time.
   If false, then calling the plus(long, TemporalUnit) and
   minus methods will throw an exception.

  unit - the unit to check, null returns false - `java.time.temporal.TemporalUnit`

  returns: true if the unit can be added/subtracted, false if not - `boolean`"
  ([^. this ^java.time.temporal.TemporalUnit unit]
    (-> this (.isSupported unit))))

(defn with
  "Returns an object of the same type as this object with the specified field altered.

   This returns a new object based on this one with the value for the specified field changed.
   For example, on a LocalDate, this could be used to set the year, month or day-of-month.
   The returned object will have the same observable type as this object.

   In some cases, changing a field is not fully defined. For example, if the target object is
   a date representing the 31st January, then changing the month to February would be unclear.
   In cases like this, the field is responsible for resolving the result. Typically it will choose
   the previous valid date, which would be the last valid day of February in this example.

  field - the field to set in the result, not null - `java.time.temporal.TemporalField`
  new-value - the new value of the field in the result - `long`

  returns: an object of the same type with the specified field set, not null - `java.time.temporal.Temporal`

  throws: java.time.DateTimeException - if the field cannot be set"
  ([^. this ^java.time.temporal.TemporalField field ^Long new-value]
    (-> this (.with field new-value)))
  ([^. this ^java.time.temporal.TemporalAdjuster adjuster]
    (-> this (.with adjuster))))

(defn plus
  "Returns an object of the same type as this object with the specified period added.

   This method returns a new object based on this one with the specified period added.
   For example, on a LocalDate, this could be used to add a number of years, months or days.
   The returned object will have the same observable type as this object.

   In some cases, changing a field is not fully defined. For example, if the target object is
   a date representing the 31st January, then adding one month would be unclear.
   In cases like this, the field is responsible for resolving the result. Typically it will choose
   the previous valid date, which would be the last valid day of February in this example.

  amount-to-add - the amount of the specified unit to add, may be negative - `long`
  unit - the unit of the amount to add, not null - `java.time.temporal.TemporalUnit`

  returns: an object of the same type with the specified period added, not null - `java.time.temporal.Temporal`

  throws: java.time.DateTimeException - if the unit cannot be added"
  ([^. this ^Long amount-to-add ^java.time.temporal.TemporalUnit unit]
    (-> this (.plus amount-to-add unit)))
  ([^. this ^java.time.temporal.TemporalAmount amount]
    (-> this (.plus amount))))

(defn minus
  "Returns an object of the same type as this object with the specified period subtracted.

   This method returns a new object based on this one with the specified period subtracted.
   For example, on a LocalDate, this could be used to subtract a number of years, months or days.
   The returned object will have the same observable type as this object.

   In some cases, changing a field is not fully defined. For example, if the target object is
   a date representing the 31st March, then subtracting one month would be unclear.
   In cases like this, the field is responsible for resolving the result. Typically it will choose
   the previous valid date, which would be the last valid day of February in this example.

  amount-to-subtract - the amount of the specified unit to subtract, may be negative - `long`
  unit - the unit of the amount to subtract, not null - `java.time.temporal.TemporalUnit`

  returns: an object of the same type with the specified period subtracted, not null - `default java.time.temporal.Temporal`

  throws: java.time.DateTimeException - if the unit cannot be subtracted"
  ([^. this ^Long amount-to-subtract ^java.time.temporal.TemporalUnit unit]
    (-> this (.minus amount-to-subtract unit)))
  ([^. this ^java.time.temporal.TemporalAmount amount]
    (-> this (.minus amount))))

(defn until
  "Calculates the amount of time until another temporal in terms of the specified unit.

   This calculates the amount of time between two temporal objects
   in terms of a single TemporalUnit.
   The start and end points are this and the specified temporal.
   The end point is converted to be of the same type as the start point if different.
   The result will be negative if the end is before the start.
   For example, the amount in hours between two temporal objects can be
   calculated using startTime.until(endTime, HOURS).

   The calculation returns a whole number, representing the number of
   complete units between the two temporals.
   For example, the amount in hours between the times 11:30 and 13:29
   will only be one hour as it is one minute short of two hours.

   There are two equivalent ways of using this method.
   The first is to invoke this method directly.
   The second is to use TemporalUnit.between(Temporal, Temporal):


     // these two lines are equivalent
     temporal = start.until(end, unit);
     temporal = unit.between(start, end);
   The choice should be made based on which makes the code more readable.

   For example, this method allows the number of days between two dates to
   be calculated:


    long daysBetween = start.until(end, DAYS);
    // or alternatively
    long daysBetween = DAYS.between(start, end);

  end-exclusive - the end temporal, exclusive, converted to be of the same type as this object, not null - `java.time.temporal.Temporal`
  unit - the unit to measure the amount in, not null - `java.time.temporal.TemporalUnit`

  returns: the amount of time between this temporal object and the specified one
    in terms of the unit; positive if the specified object is later than this one,
    negative if it is earlier than this one - `long`

  throws: java.time.DateTimeException - if the amount cannot be calculated, or the end temporal cannot be converted to the same type as this temporal"
  ([^. this ^java.time.temporal.Temporal end-exclusive ^java.time.temporal.TemporalUnit unit]
    (-> this (.until end-exclusive unit))))

