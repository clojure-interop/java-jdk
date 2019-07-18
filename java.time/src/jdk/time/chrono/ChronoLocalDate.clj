(ns jdk.time.chrono.ChronoLocalDate
  "A date without time-of-day or time-zone in an arbitrary chronology, intended
  for advanced globalization use cases.

  Most applications should declare method signatures, fields and variables
  as LocalDate, not this interface.

  A ChronoLocalDate is the abstract representation of a date where the
  Chronology chronology, or calendar system, is pluggable.
  The date is defined in terms of fields expressed by TemporalField,
  where most common implementations are defined in ChronoField.
  The chronology defines how the calendar system operates and the meaning of
  the standard fields.

  When to use this interface
  The design of the API encourages the use of LocalDate rather than this
  interface, even in the case where the application needs to deal with multiple
  calendar systems.

  This concept can seem surprising at first, as the natural way to globalize an
  application might initially appear to be to abstract the calendar system.
  However, as explored below, abstracting the calendar system is usually the wrong
  approach, resulting in logic errors and hard to find bugs.
  As such, it should be considered an application-wide architectural decision to choose
  to use this interface as opposed to LocalDate.

  Architectural issues to consider
  These are some of the points that must be considered before using this interface
  throughout an application.

  1) Applications using this interface, as opposed to using just LocalDate,
  face a significantly higher probability of bugs. This is because the calendar system
  in use is not known at development time. A key cause of bugs is where the developer
  applies assumptions from their day-to-day knowledge of the ISO calendar system
  to code that is intended to deal with any arbitrary calendar system.
  The section below outlines how those assumptions can cause problems
  The primary mechanism for reducing this increased risk of bugs is a strong code review process.
  This should also be considered a extra cost in maintenance for the lifetime of the code.

  2) This interface does not enforce immutability of implementations.
  While the implementation notes indicate that all implementations must be immutable
  there is nothing in the code or type system to enforce this. Any method declared
  to accept a ChronoLocalDate could therefore be passed a poorly or
  maliciously written mutable implementation.

  3) Applications using this interface  must consider the impact of eras.
  LocalDate shields users from the concept of eras, by ensuring that getYear()
  returns the proleptic year. That decision ensures that developers can think of
  LocalDate instances as consisting of three fields - year, month-of-year and day-of-month.
  By contrast, users of this interface must think of dates as consisting of four fields -
  era, year-of-era, month-of-year and day-of-month. The extra era field is frequently
  forgotten, yet it is of vital importance to dates in an arbitrary calendar system.
  For example, in the Japanese calendar system, the era represents the reign of an Emperor.
  Whenever one reign ends and another starts, the year-of-era is reset to one.

  4) The only agreed international standard for passing a date between two systems
  is the ISO-8601 standard which requires the ISO calendar system. Using this interface
  throughout the application will inevitably lead to the requirement to pass the date
  across a network or component boundary, requiring an application specific protocol or format.

  5) Long term persistence, such as a database, will almost always only accept dates in the
  ISO-8601 calendar system (or the related Julian-Gregorian). Passing around dates in other
  calendar systems increases the complications of interacting with persistence.

  6) Most of the time, passing a ChronoLocalDate throughout an application
  is unnecessary, as discussed in the last section below.

  False assumptions causing bugs in multi-calendar system code
  As indicated above, there are many issues to consider when try to use and manipulate a
  date in an arbitrary calendar system. These are some of the key issues.

  Code that queries the day-of-month and assumes that the value will never be more than
  31 is invalid. Some calendar systems have more than 31 days in some months.

  Code that adds 12 months to a date and assumes that a year has been added is invalid.
  Some calendar systems have a different number of months, such as 13 in the Coptic or Ethiopic.

  Code that adds one month to a date and assumes that the month-of-year value will increase
  by one or wrap to the next year is invalid. Some calendar systems have a variable number
  of months in a year, such as the Hebrew.

  Code that adds one month, then adds a second one month and assumes that the day-of-month
  will remain close to its original value is invalid. Some calendar systems have a large difference
  between the length of the longest month and the length of the shortest month.
  For example, the Coptic or Ethiopic have 12 months of 30 days and 1 month of 5 days.

  Code that adds seven days and assumes that a week has been added is invalid.
  Some calendar systems have weeks of other than seven days, such as the French Revolutionary.

  Code that assumes that because the year of date1 is greater than the year of date2
  then date1 is after date2 is invalid. This is invalid for all calendar systems
  when referring to the year-of-era, and especially untrue of the Japanese calendar system
  where the year-of-era restarts with the reign of every new Emperor.

  Code that treats month-of-year one and day-of-month one as the start of the year is invalid.
  Not all calendar systems start the year when the month value is one.

  In general, manipulating a date, and even querying a date, is wide open to bugs when the
  calendar system is unknown at development time. This is why it is essential that code using
  this interface is subjected to additional code reviews. It is also why an architectural
  decision to avoid this interface type is usually the correct one.

  Using LocalDate instead
  The primary alternative to using this interface throughout your application is as follows.

  Declare all method signatures referring to dates in terms of LocalDate.
  Either store the chronology (calendar system) in the user profile or lookup
   the chronology from the user locale
  Convert the ISO LocalDate to and from the user's preferred calendar system during
   printing and parsing

  This approach treats the problem of globalized calendar systems as a localization issue
  and confines it to the UI layer. This approach is in keeping with other localization
  issues in the java platform.

  As discussed above, performing calculations on a date where the rules of the calendar system
  are pluggable requires skill and is not recommended.
  Fortunately, the need to perform calculations on a date in an arbitrary calendar system
  is extremely rare. For example, it is highly unlikely that the business rules of a library
  book rental scheme will allow rentals to be for one month, where meaning of the month
  is dependent on the user's preferred calendar system.

  A key use case for calculations on a date in an arbitrary calendar system is producing
  a month-by-month calendar for display and user interaction. Again, this is a UI issue,
  and use of this interface solely within a few methods of the UI layer may be justified.

  In any other part of the system, where a date must be manipulated in a calendar system
  other than ISO, the use case will generally specify the calendar system to use.
  For example, an application may need to calculate the next Islamic or Hebrew holiday
  which may require manipulating the date.
  This kind of use case can be handled as follows:

  start from the ISO LocalDate being passed to the method
  convert the date to the alternate calendar system, which for this use case is known
   rather than arbitrary
  perform the calculation
  convert back to LocalDate

  Developers writing low-level frameworks or libraries should also avoid this interface.
  Instead, one of the two general purpose access interfaces should be used.
  Use TemporalAccessor if read-only access is required, or use Temporal
  if read-write access is required."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.time.chrono ChronoLocalDate]))

(defn length-of-year
  "Returns the length of the year represented by this date, as defined by the calendar system.

   This returns the length of the year in days.

   The default implementation uses isLeapYear() and returns 365 or 366.

  returns: the length of the year in days - `default int`"
  ([^ChronoLocalDate this]
    (-> this (.lengthOfYear))))

(defn get-era
  "Gets the era, as defined by the chronology.

   The era is, conceptually, the largest division of the time-line.
   Most calendar systems have a single epoch dividing the time-line into two eras.
   However, some have multiple eras, such as one for the reign of each leader.
   The exact meaning is determined by the Chronology.

   All correctly implemented Era classes are singletons, thus it
   is valid code to write date.getEra() == SomeChrono.ERA_NAME).

   This default implementation uses Chronology.eraOf(int).

  returns: the chronology specific era constant applicable at this date, not null - `default java.time.chrono.Era`"
  ([^ChronoLocalDate this]
    (-> this (.getEra))))

(defn is-equal
  "Checks if this date is equal to the specified date ignoring the chronology.

   This method differs from the comparison in compareTo(java.time.chrono.ChronoLocalDate) in that it
   only compares the underlying date and not the chronology.
   This allows dates in different calendar systems to be compared based
   on the time-line position.
   This is equivalent to using date1.toEpochDay() == date2.toEpochDay().

   This default implementation performs the comparison based on the epoch-day.

  other - the other date to compare to, not null - `java.time.chrono.ChronoLocalDate`

  returns: true if the underlying date is equal to the specified date - `default boolean`"
  ([^ChronoLocalDate this ^java.time.chrono.ChronoLocalDate other]
    (-> this (.isEqual other))))

(defn to-epoch-day
  "Converts this date to the Epoch Day.

   The Epoch Day count is a simple
   incrementing count of days where day 0 is 1970-01-01 (ISO).
   This definition is the same for all chronologies, enabling conversion.

   This default implementation queries the EPOCH_DAY field.

  returns: the Epoch Day equivalent to this date - `default long`"
  ([^ChronoLocalDate this]
    (-> this (.toEpochDay))))

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

  returns: an object of the same type with the specified period added, not null - `default java.time.chrono.ChronoLocalDate`

  throws: java.time.DateTimeException - if the unit cannot be added"
  ([^ChronoLocalDate this ^Long amount-to-add ^java.time.temporal.TemporalUnit unit]
    (-> this (.plus amount-to-add unit)))
  ([^ChronoLocalDate this ^java.time.temporal.TemporalAmount amount]
    (-> this (.plus amount))))

(defn *time-line-order
  "Gets a comparator that compares ChronoLocalDate in
   time-line order ignoring the chronology.

   This comparator differs from the comparison in compareTo(java.time.chrono.ChronoLocalDate) in that it
   only compares the underlying date and not the chronology.
   This allows dates in different calendar systems to be compared based
   on the position of the date on the local time-line.
   The underlying comparison is equivalent to comparing the epoch-day.

  returns: a comparator that compares in time-line order ignoring the chronology - `java.util.Comparator<java.time.chrono.ChronoLocalDate>`"
  (^java.util.Comparator []
    (ChronoLocalDate/timeLineOrder )))

(defn is-leap-year
  "Checks if the year is a leap year, as defined by the calendar system.

   A leap-year is a year of a longer length than normal.
   The exact meaning is determined by the chronology with the constraint that
   a leap-year must imply a year-length longer than a non leap-year.

   This default implementation uses Chronology.isLeapYear(long).

  returns: true if this date is in a leap year, false otherwise - `default boolean`"
  ([^ChronoLocalDate this]
    (-> this (.isLeapYear))))

(defn query
  "Queries this date using the specified query.

   This queries this date using the specified query strategy object.
   The TemporalQuery object defines the logic to be used to
   obtain the result. Read the documentation of the query to understand
   what the result of this method will be.

   The result of this method is obtained by invoking the
   TemporalQuery.queryFrom(TemporalAccessor) method on the
   specified query passing this as the argument.

  query - the query to invoke, not null - `java.time.temporal.TemporalQuery`

  returns: the query result, null may be returned (defined by the query) - `default <R> R`

  throws: java.time.DateTimeException - if unable to query (defined by the query)"
  ([^ChronoLocalDate this ^java.time.temporal.TemporalQuery query]
    (-> this (.query query))))

(defn to-string
  "Outputs this date as a String.

   The output will include the full local date.

  returns: the formatted date, not null - `java.lang.String`"
  (^java.lang.String [^ChronoLocalDate this]
    (-> this (.toString))))

(defn is-before
  "Checks if this date is before the specified date ignoring the chronology.

   This method differs from the comparison in compareTo(java.time.chrono.ChronoLocalDate) in that it
   only compares the underlying date and not the chronology.
   This allows dates in different calendar systems to be compared based
   on the time-line position.
   This is equivalent to using date1.toEpochDay() < date2.toEpochDay().

   This default implementation performs the comparison based on the epoch-day.

  other - the other date to compare to, not null - `java.time.chrono.ChronoLocalDate`

  returns: true if this is before the specified date - `default boolean`"
  ([^ChronoLocalDate this ^java.time.chrono.ChronoLocalDate other]
    (-> this (.isBefore other))))

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

  returns: an object of the same type with the specified period subtracted, not null - `default java.time.chrono.ChronoLocalDate`

  throws: java.time.DateTimeException - if the unit cannot be subtracted"
  ([^ChronoLocalDate this ^Long amount-to-subtract ^java.time.temporal.TemporalUnit unit]
    (-> this (.minus amount-to-subtract unit)))
  ([^ChronoLocalDate this ^java.time.temporal.TemporalAmount amount]
    (-> this (.minus amount))))

(defn length-of-month
  "Returns the length of the month represented by this date, as defined by the calendar system.

   This returns the length of the month in days.

  returns: the length of the month in days - `int`"
  (^Integer [^ChronoLocalDate this]
    (-> this (.lengthOfMonth))))

(defn until
  "Calculates the amount of time until another date in terms of the specified unit.

   This calculates the amount of time between two ChronoLocalDate
   objects in terms of a single TemporalUnit.
   The start and end points are this and the specified date.
   The result will be negative if the end is before the start.
   The Temporal passed to this method is converted to a
   ChronoLocalDate using Chronology.date(TemporalAccessor).
   The calculation returns a whole number, representing the number of
   complete units between the two dates.
   For example, the amount in days between two dates can be calculated
   using startDate.until(endDate, DAYS).

   There are two equivalent ways of using this method.
   The first is to invoke this method.
   The second is to use TemporalUnit.between(Temporal, Temporal):


     // these two lines are equivalent
     amount = start.until(end, MONTHS);
     amount = MONTHS.between(start, end);
   The choice should be made based on which makes the code more readable.

   The calculation is implemented in this method for ChronoUnit.
   The units DAYS, WEEKS, MONTHS, YEARS,
   DECADES, CENTURIES, MILLENNIA and ERAS
   should be supported by all implementations.
   Other ChronoUnit values will throw an exception.

   If the unit is not a ChronoUnit, then the result of this method
   is obtained by invoking TemporalUnit.between(Temporal, Temporal)
   passing this as the first argument and the converted input temporal as
   the second argument.

   This instance is immutable and unaffected by this method call.

  end-exclusive - the end date, exclusive, which is converted to a ChronoLocalDate in the same chronology, not null - `java.time.temporal.Temporal`
  unit - the unit to measure the amount in, not null - `java.time.temporal.TemporalUnit`

  returns: the amount of time between this date and the end date - `long`

  throws: java.time.DateTimeException - if the amount cannot be calculated, or the end temporal cannot be converted to a ChronoLocalDate"
  (^Long [^ChronoLocalDate this ^java.time.temporal.Temporal end-exclusive ^java.time.temporal.TemporalUnit unit]
    (-> this (.until end-exclusive unit)))
  (^java.time.chrono.ChronoPeriod [^ChronoLocalDate this ^java.time.chrono.ChronoLocalDate end-date-exclusive]
    (-> this (.until end-date-exclusive))))

(defn *from
  "Obtains an instance of ChronoLocalDate from a temporal object.

   This obtains a local date based on the specified temporal.
   A TemporalAccessor represents an arbitrary set of date and time information,
   which this factory converts to an instance of ChronoLocalDate.

   The conversion extracts and combines the chronology and the date
   from the temporal object. The behavior is equivalent to using
   Chronology.date(TemporalAccessor) with the extracted chronology.
   Implementations are permitted to perform optimizations such as accessing
   those fields that are equivalent to the relevant objects.

   This method matches the signature of the functional interface TemporalQuery
   allowing it to be used as a query via method reference, ChronoLocalDate::from.

  temporal - the temporal object to convert, not null - `java.time.temporal.TemporalAccessor`

  returns: the date, not null - `java.time.chrono.ChronoLocalDate`

  throws: java.time.DateTimeException - if unable to convert to a ChronoLocalDate"
  (^java.time.chrono.ChronoLocalDate [^java.time.temporal.TemporalAccessor temporal]
    (ChronoLocalDate/from temporal)))

(defn is-after
  "Checks if this date is after the specified date ignoring the chronology.

   This method differs from the comparison in compareTo(java.time.chrono.ChronoLocalDate) in that it
   only compares the underlying date and not the chronology.
   This allows dates in different calendar systems to be compared based
   on the time-line position.
   This is equivalent to using date1.toEpochDay() > date2.toEpochDay().

   This default implementation performs the comparison based on the epoch-day.

  other - the other date to compare to, not null - `java.time.chrono.ChronoLocalDate`

  returns: true if this is after the specified date - `default boolean`"
  ([^ChronoLocalDate this ^java.time.chrono.ChronoLocalDate other]
    (-> this (.isAfter other))))

(defn is-supported
  "Checks if the specified field is supported.

   This checks if the specified field can be queried on this date.
   If false, then calling the range,
   get and with(TemporalField, long)
   methods will throw an exception.

   The set of supported fields is defined by the chronology and normally includes
   all ChronoField date fields.

   If the field is not a ChronoField, then the result of this method
   is obtained by invoking TemporalField.isSupportedBy(TemporalAccessor)
   passing this as the argument.
   Whether the field is supported is determined by the field.

  field - the field to check, null returns false - `java.time.temporal.TemporalField`

  returns: true if the field can be queried, false if not - `default boolean`"
  ([^ChronoLocalDate this ^java.time.temporal.TemporalField field]
    (-> this (.isSupported field))))

(defn get-chronology
  "Gets the chronology of this date.

   The Chronology represents the calendar system in use.
   The era and other fields in ChronoField are defined by the chronology.

  returns: the chronology, not null - `java.time.chrono.Chronology`"
  (^java.time.chrono.Chronology [^ChronoLocalDate this]
    (-> this (.getChronology))))

(defn hash-code
  "A hash code for this date.

  returns: a suitable hash code - `int`"
  (^Integer [^ChronoLocalDate this]
    (-> this (.hashCode))))

(defn adjust-into
  "Adjusts the specified temporal object to have the same date as this object.

   This returns a temporal object of the same observable type as the input
   with the date changed to be the same as this.

   The adjustment is equivalent to using Temporal.with(TemporalField, long)
   passing ChronoField.EPOCH_DAY as the field.

   In most cases, it is clearer to reverse the calling pattern by using
   Temporal.with(TemporalAdjuster):


     // these two lines are equivalent, but the second approach is recommended
     temporal = thisLocalDate.adjustInto(temporal);
     temporal = temporal.with(thisLocalDate);

   This instance is immutable and unaffected by this method call.

  temporal - the target object to be adjusted, not null - `java.time.temporal.Temporal`

  returns: the adjusted object, not null - `default java.time.temporal.Temporal`

  throws: java.time.DateTimeException - if unable to make the adjustment"
  ([^ChronoLocalDate this ^java.time.temporal.Temporal temporal]
    (-> this (.adjustInto temporal))))

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

  returns: an object of the same type with the specified field set, not null - `default java.time.chrono.ChronoLocalDate`

  throws: java.time.DateTimeException - if the field cannot be set"
  ([^ChronoLocalDate this ^java.time.temporal.TemporalField field ^Long new-value]
    (-> this (.with field new-value)))
  ([^ChronoLocalDate this ^java.time.temporal.TemporalAdjuster adjuster]
    (-> this (.with adjuster))))

(defn compare-to
  "Compares this date to another date, including the chronology.

   The comparison is based first on the underlying time-line date, then
   on the chronology.
   It is `consistent with equals`, as defined by Comparable.

   For example, the following is the comparator order:

   2012-12-03 (ISO)
   2012-12-04 (ISO)
   2555-12-04 (ThaiBuddhist)
   2012-12-05 (ISO)

   Values #2 and #3 represent the same date on the time-line.
   When two values represent the same date, the chronology ID is compared to distinguish them.
   This step is needed to make the ordering `consistent with equals`.

   If all the date objects being compared are in the same chronology, then the
   additional chronology stage is not required and only the local date is used.
   To compare the dates of two TemporalAccessor instances, including dates
   in two different chronologies, use ChronoField.EPOCH_DAY as a comparator.

   This default implementation performs the comparison defined above.

  other - the other date to compare to, not null - `java.time.chrono.ChronoLocalDate`

  returns: the comparator value, negative if less, positive if greater - `default int`"
  ([^ChronoLocalDate this ^java.time.chrono.ChronoLocalDate other]
    (-> this (.compareTo other))))

(defn equals
  "Checks if this date is equal to another date, including the chronology.

   Compares this date with another ensuring that the date and chronology are the same.

   To compare the dates of two TemporalAccessor instances, including dates
   in two different chronologies, use ChronoField.EPOCH_DAY as a comparator.

  obj - the object to check, null returns false - `java.lang.Object`

  returns: true if this is equal to the other date - `boolean`"
  (^Boolean [^ChronoLocalDate this ^java.lang.Object obj]
    (-> this (.equals obj))))

(defn at-time
  "Combines this date with a time to create a ChronoLocalDateTime.

   This returns a ChronoLocalDateTime formed from this date at the specified time.
   All possible combinations of date and time are valid.

  local-time - the local time to use, not null - `java.time.LocalTime`

  returns: the local date-time formed from this date and the specified time, not null - `default java.time.chrono.ChronoLocalDateTime<?>`"
  ([^ChronoLocalDate this ^java.time.LocalTime local-time]
    (-> this (.atTime local-time))))

(defn format
  "Formats this date using the specified formatter.

   This date will be passed to the formatter to produce a string.

   The default implementation must behave as follows:


    return formatter.format(this);

  formatter - the formatter to use, not null - `java.time.format.DateTimeFormatter`

  returns: the formatted date string, not null - `default java.lang.String`

  throws: java.time.DateTimeException - if an error occurs during printing"
  ([^ChronoLocalDate this ^java.time.format.DateTimeFormatter formatter]
    (-> this (.format formatter))))

