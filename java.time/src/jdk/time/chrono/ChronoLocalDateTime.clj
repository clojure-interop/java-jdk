(ns jdk.time.chrono.ChronoLocalDateTime
  "A date-time without a time-zone in an arbitrary chronology, intended
  for advanced globalization use cases.

  Most applications should declare method signatures, fields and variables
  as LocalDateTime, not this interface.

  A ChronoLocalDateTime is the abstract representation of a local date-time
  where the Chronology chronology, or calendar system, is pluggable.
  The date-time is defined in terms of fields expressed by TemporalField,
  where most common implementations are defined in ChronoField.
  The chronology defines how the calendar system operates and the meaning of
  the standard fields.

  When to use this interface
  The design of the API encourages the use of LocalDateTime rather than this
  interface, even in the case where the application needs to deal with multiple
  calendar systems. The rationale for this is explored in detail in ChronoLocalDate.

  Ensure that the discussion in ChronoLocalDate has been read and understood
  before using this interface."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.time.chrono ChronoLocalDateTime]))

(defn to-instant
  "Converts this date-time to an Instant.

   This combines this local date-time and the specified offset to form
   an Instant.

   This default implementation calculates from the epoch-day of the date and the
   second-of-day of the time.

  offset - the offset to use for the conversion, not null - `java.time.ZoneOffset`

  returns: an Instant representing the same instant, not null - `default java.time.Instant`"
  ([^java.time.chrono.ChronoLocalDateTime this ^java.time.ZoneOffset offset]
    (-> this (.toInstant offset))))

(defn is-equal
  "Checks if this date-time is equal to the specified date-time ignoring the chronology.

   This method differs from the comparison in compareTo(java.time.chrono.ChronoLocalDateTime<?>) in that it
   only compares the underlying date and time and not the chronology.
   This allows date-times in different calendar systems to be compared based
   on the time-line position.

   This default implementation performs the comparison based on the epoch-day
   and nano-of-day.

  other - the other date-time to compare to, not null - `java.time.chrono.ChronoLocalDateTime<?>`

  returns: true if the underlying date-time is equal to the specified date-time on the timeline - `default boolean`"
  ([^java.time.chrono.ChronoLocalDateTime this ^java.time.chrono.ChronoLocalDateTime other]
    (-> this (.isEqual other))))

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

  returns: an object of the same type with the specified period added, not null - `java.time.chrono.ChronoLocalDateTime<ChronoLocalDateTime.D>`

  throws: java.time.DateTimeException - if the unit cannot be added"
  ([^java.time.chrono.ChronoLocalDateTime this ^Long amount-to-add ^java.time.temporal.TemporalUnit unit]
    (-> this (.plus amount-to-add unit)))
  ([^java.time.chrono.ChronoLocalDateTime this ^java.time.temporal.TemporalAmount amount]
    (-> this (.plus amount))))

(defn *time-line-order
  "Gets a comparator that compares ChronoLocalDateTime in
   time-line order ignoring the chronology.

   This comparator differs from the comparison in compareTo(java.time.chrono.ChronoLocalDateTime<?>) in that it
   only compares the underlying date-time and not the chronology.
   This allows dates in different calendar systems to be compared based
   on the position of the date-time on the local time-line.
   The underlying comparison is equivalent to comparing the epoch-day and nano-of-day.

  returns: a comparator that compares in time-line order ignoring the chronology - `java.util.Comparator<java.time.chrono.ChronoLocalDateTime<?>>`"
  ([]
    (ChronoLocalDateTime/timeLineOrder )))

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

  returns: the query result, null may be returned (defined by the query) - `default <R> R`

  throws: java.time.DateTimeException - if unable to query (defined by the query)"
  ([^java.time.chrono.ChronoLocalDateTime this ^java.time.temporal.TemporalQuery query]
    (-> this (.query query))))

(defn to-string
  "Outputs this date-time as a String.

   The output will include the full local date-time.

  returns: a string representation of this date-time, not null - `java.lang.String`"
  ([^java.time.chrono.ChronoLocalDateTime this]
    (-> this (.toString))))

(defn is-before
  "Checks if this date-time is before the specified date-time ignoring the chronology.

   This method differs from the comparison in compareTo(java.time.chrono.ChronoLocalDateTime<?>) in that it
   only compares the underlying date-time and not the chronology.
   This allows dates in different calendar systems to be compared based
   on the time-line position.

   This default implementation performs the comparison based on the epoch-day
   and nano-of-day.

  other - the other date-time to compare to, not null - `java.time.chrono.ChronoLocalDateTime<?>`

  returns: true if this is before the specified date-time - `default boolean`"
  ([^java.time.chrono.ChronoLocalDateTime this ^java.time.chrono.ChronoLocalDateTime other]
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

  returns: an object of the same type with the specified period subtracted, not null - `default java.time.chrono.ChronoLocalDateTime<ChronoLocalDateTime.D>`

  throws: java.time.DateTimeException - if the unit cannot be subtracted"
  ([^java.time.chrono.ChronoLocalDateTime this ^Long amount-to-subtract ^java.time.temporal.TemporalUnit unit]
    (-> this (.minus amount-to-subtract unit)))
  ([^java.time.chrono.ChronoLocalDateTime this ^java.time.temporal.TemporalAmount amount]
    (-> this (.minus amount))))

(defn at-zone
  "Combines this time with a time-zone to create a ChronoZonedDateTime.

   This returns a ChronoZonedDateTime formed from this date-time at the
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
   ChronoZonedDateTime.withLaterOffsetAtOverlap() on the result of this method.

  zone - the time-zone to use, not null - `java.time.ZoneId`

  returns: the zoned date-time formed from this date-time, not null - `java.time.chrono.ChronoZonedDateTime<ChronoLocalDateTime.D>`"
  ([^java.time.chrono.ChronoLocalDateTime this ^java.time.ZoneId zone]
    (-> this (.atZone zone))))

(defn to-local-time
  "Gets the local time part of this date-time.

   This returns a local time with the same hour, minute, second and
   nanosecond as this date-time.

  returns: the time part of this date-time, not null - `java.time.LocalTime`"
  ([^java.time.chrono.ChronoLocalDateTime this]
    (-> this (.toLocalTime))))

(defn to-epoch-second
  "Converts this date-time to the number of seconds from the epoch
   of 1970-01-01T00:00:00Z.

   This combines this local date-time and the specified offset to calculate the
   epoch-second value, which is the number of elapsed seconds from 1970-01-01T00:00:00Z.
   Instants on the time-line after the epoch are positive, earlier are negative.

   This default implementation calculates from the epoch-day of the date and the
   second-of-day of the time.

  offset - the offset to use for the conversion, not null - `java.time.ZoneOffset`

  returns: the number of seconds from the epoch of 1970-01-01T00:00:00Z - `default long`"
  ([^java.time.chrono.ChronoLocalDateTime this ^java.time.ZoneOffset offset]
    (-> this (.toEpochSecond offset))))

(defn *from
  "Obtains an instance of ChronoLocalDateTime from a temporal object.

   This obtains a local date-time based on the specified temporal.
   A TemporalAccessor represents an arbitrary set of date and time information,
   which this factory converts to an instance of ChronoLocalDateTime.

   The conversion extracts and combines the chronology and the date-time
   from the temporal object. The behavior is equivalent to using
   Chronology.localDateTime(TemporalAccessor) with the extracted chronology.
   Implementations are permitted to perform optimizations such as accessing
   those fields that are equivalent to the relevant objects.

   This method matches the signature of the functional interface TemporalQuery
   allowing it to be used as a query via method reference, ChronoLocalDateTime::from.

  temporal - the temporal object to convert, not null - `java.time.temporal.TemporalAccessor`

  returns: the date-time, not null - `java.time.chrono.ChronoLocalDateTime<?>`

  throws: java.time.DateTimeException - if unable to convert to a ChronoLocalDateTime"
  ([^java.time.temporal.TemporalAccessor temporal]
    (ChronoLocalDateTime/from temporal)))

(defn is-after
  "Checks if this date-time is after the specified date-time ignoring the chronology.

   This method differs from the comparison in compareTo(java.time.chrono.ChronoLocalDateTime<?>) in that it
   only compares the underlying date-time and not the chronology.
   This allows dates in different calendar systems to be compared based
   on the time-line position.

   This default implementation performs the comparison based on the epoch-day
   and nano-of-day.

  other - the other date-time to compare to, not null - `java.time.chrono.ChronoLocalDateTime<?>`

  returns: true if this is after the specified date-time - `default boolean`"
  ([^java.time.chrono.ChronoLocalDateTime this ^java.time.chrono.ChronoLocalDateTime other]
    (-> this (.isAfter other))))

(defn supported?
  "Checks if the specified field is supported.

   This checks if the specified field can be queried on this date-time.
   If false, then calling the range,
   get and with(TemporalField, long)
   methods will throw an exception.

   The set of supported fields is defined by the chronology and normally includes
   all ChronoField date and time fields.

   If the field is not a ChronoField, then the result of this method
   is obtained by invoking TemporalField.isSupportedBy(TemporalAccessor)
   passing this as the argument.
   Whether the field is supported is determined by the field.

  field - the field to check, null returns false - `java.time.temporal.TemporalField`

  returns: true if the field can be queried, false if not - `boolean`"
  ([^java.time.chrono.ChronoLocalDateTime this ^java.time.temporal.TemporalField field]
    (-> this (.isSupported field))))

(defn get-chronology
  "Gets the chronology of this date-time.

   The Chronology represents the calendar system in use.
   The era and other fields in ChronoField are defined by the chronology.

  returns: the chronology, not null - `default java.time.chrono.Chronology`"
  ([^java.time.chrono.ChronoLocalDateTime this]
    (-> this (.getChronology))))

(defn to-local-date
  "Gets the local date part of this date-time.

   This returns a local date with the same year, month and day
   as this date-time.

  returns: the date part of this date-time, not null - `ChronoLocalDateTime.D`"
  ([^java.time.chrono.ChronoLocalDateTime this]
    (-> this (.toLocalDate))))

(defn hash-code
  "A hash code for this date-time.

  returns: a suitable hash code - `int`"
  ([^java.time.chrono.ChronoLocalDateTime this]
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

  returns: the adjusted object, not null - `default java.time.temporal.Temporal`

  throws: java.time.DateTimeException - if unable to make the adjustment"
  ([^java.time.chrono.ChronoLocalDateTime this ^java.time.temporal.Temporal temporal]
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

  returns: an object of the same type with the specified field set, not null - `java.time.chrono.ChronoLocalDateTime<ChronoLocalDateTime.D>`

  throws: java.time.DateTimeException - if the field cannot be set"
  ([^java.time.chrono.ChronoLocalDateTime this ^java.time.temporal.TemporalField field ^Long new-value]
    (-> this (.with field new-value)))
  ([^java.time.chrono.ChronoLocalDateTime this ^java.time.temporal.TemporalAdjuster adjuster]
    (-> this (.with adjuster))))

(defn compare-to
  "Compares this date-time to another date-time, including the chronology.

   The comparison is based first on the underlying time-line date-time, then
   on the chronology.
   It is `consistent with equals`, as defined by Comparable.

   For example, the following is the comparator order:

   2012-12-03T12:00 (ISO)
   2012-12-04T12:00 (ISO)
   2555-12-04T12:00 (ThaiBuddhist)
   2012-12-05T12:00 (ISO)

   Values #2 and #3 represent the same date-time on the time-line.
   When two values represent the same date-time, the chronology ID is compared to distinguish them.
   This step is needed to make the ordering `consistent with equals`.

   If all the date-time objects being compared are in the same chronology, then the
   additional chronology stage is not required and only the local date-time is used.

   This default implementation performs the comparison defined above.

  other - the other date-time to compare to, not null - `java.time.chrono.ChronoLocalDateTime<?>`

  returns: the comparator value, negative if less, positive if greater - `default int`"
  ([^java.time.chrono.ChronoLocalDateTime this ^java.time.chrono.ChronoLocalDateTime other]
    (-> this (.compareTo other))))

(defn equals
  "Checks if this date-time is equal to another date-time, including the chronology.

   Compares this date-time with another ensuring that the date-time and chronology are the same.

  obj - the object to check, null returns false - `java.lang.Object`

  returns: true if this is equal to the other date - `boolean`"
  ([^java.time.chrono.ChronoLocalDateTime this ^java.lang.Object obj]
    (-> this (.equals obj))))

(defn format
  "Formats this date-time using the specified formatter.

   This date-time will be passed to the formatter to produce a string.

   The default implementation must behave as follows:


    return formatter.format(this);

  formatter - the formatter to use, not null - `java.time.format.DateTimeFormatter`

  returns: the formatted date-time string, not null - `default java.lang.String`

  throws: java.time.DateTimeException - if an error occurs during printing"
  ([^java.time.chrono.ChronoLocalDateTime this ^java.time.format.DateTimeFormatter formatter]
    (-> this (.format formatter))))

