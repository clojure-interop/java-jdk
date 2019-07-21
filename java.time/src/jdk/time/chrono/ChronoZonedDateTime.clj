(ns jdk.time.chrono.ChronoZonedDateTime
  "A date-time with a time-zone in an arbitrary chronology,
  intended for advanced globalization use cases.

  Most applications should declare method signatures, fields and variables
  as ZonedDateTime, not this interface.

  A ChronoZonedDateTime is the abstract representation of an offset date-time
  where the Chronology chronology, or calendar system, is pluggable.
  The date-time is defined in terms of fields expressed by TemporalField,
  where most common implementations are defined in ChronoField.
  The chronology defines how the calendar system operates and the meaning of
  the standard fields.

  When to use this interface
  The design of the API encourages the use of ZonedDateTime rather than this
  interface, even in the case where the application needs to deal with multiple
  calendar systems. The rationale for this is explored in detail in ChronoLocalDate.

  Ensure that the discussion in ChronoLocalDate has been read and understood
  before using this interface."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.time.chrono ChronoZonedDateTime]))

(defn to-instant
  "Converts this date-time to an Instant.

   This returns an Instant representing the same point on the
   time-line as this date-time. The calculation combines the
   local date-time and
   offset.

  returns: an Instant representing the same instant, not null - `default java.time.Instant`"
  ([^ChronoZonedDateTime this]
    (-> this (.toInstant))))

(defn range
  "Description copied from interface: TemporalAccessor

  field - the field to query the range for, not null - `java.time.temporal.TemporalField`

  returns: the range of valid values for the field, not null - `default java.time.temporal.ValueRange`"
  ([^ChronoZonedDateTime this ^java.time.temporal.TemporalField field]
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

  returns: a ChronoZonedDateTime based on this date-time with the earlier offset, not null - `java.time.chrono.ChronoZonedDateTime<D>`

  throws: java.time.DateTimeException - if no rules are valid for this date-time"
  (^java.time.chrono.ChronoZonedDateTime [^ChronoZonedDateTime this]
    (-> this (.withEarlierOffsetAtOverlap))))

(defn is-equal
  "Checks if the instant of this date-time is equal to that of the specified date-time.

   This method differs from the comparison in compareTo(java.time.chrono.ChronoZonedDateTime<?>) and equals(java.lang.Object)
   in that it only compares the instant of the date-time. This is equivalent to using
   dateTime1.toInstant().equals(dateTime2.toInstant());.

   This default implementation performs the comparison based on the epoch-second
   and nano-of-second.

  other - the other date-time to compare to, not null - `java.time.chrono.ChronoZonedDateTime`

  returns: true if the instant equals the instant of the specified date-time - `default boolean`"
  ([^ChronoZonedDateTime this ^java.time.chrono.ChronoZonedDateTime other]
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

  returns: an object of the same type with the specified period added, not null - `java.time.chrono.ChronoZonedDateTime<D>`

  throws: java.time.DateTimeException - if the unit cannot be added"
  (^java.time.chrono.ChronoZonedDateTime [^ChronoZonedDateTime this ^Long amount-to-add ^java.time.temporal.TemporalUnit unit]
    (-> this (.plus amount-to-add unit)))
  ([^ChronoZonedDateTime this ^java.time.temporal.TemporalAmount amount]
    (-> this (.plus amount))))

(defn *time-line-order
  "Gets a comparator that compares ChronoZonedDateTime in
   time-line order ignoring the chronology.

   This comparator differs from the comparison in compareTo(java.time.chrono.ChronoZonedDateTime<?>) in that it
   only compares the underlying instant and not the chronology.
   This allows dates in different calendar systems to be compared based
   on the position of the date-time on the instant time-line.
   The underlying comparison is equivalent to comparing the epoch-second and nano-of-second.

  returns: a comparator that compares in time-line order ignoring the chronology - `java.util.Comparator<java.time.chrono.ChronoZonedDateTime<?>>`"
  (^java.util.Comparator []
    (ChronoZonedDateTime/timeLineOrder )))

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

  returns: the query result, null may be returned (defined by the query) - `default <R> R`

  throws: java.time.DateTimeException - if unable to query (defined by the query)"
  ([^ChronoZonedDateTime this ^java.time.temporal.TemporalQuery query]
    (-> this (.query query))))

(defn to-string
  "Outputs this date-time as a String.

   The output will include the full zoned date-time.

  returns: a string representation of this date-time, not null - `java.lang.String`"
  (^java.lang.String [^ChronoZonedDateTime this]
    (-> this (.toString))))

(defn is-before
  "Checks if the instant of this date-time is before that of the specified date-time.

   This method differs from the comparison in compareTo(java.time.chrono.ChronoZonedDateTime<?>) in that it
   only compares the instant of the date-time. This is equivalent to using
   dateTime1.toInstant().isBefore(dateTime2.toInstant());.

   This default implementation performs the comparison based on the epoch-second
   and nano-of-second.

  other - the other date-time to compare to, not null - `java.time.chrono.ChronoZonedDateTime`

  returns: true if this point is before the specified date-time - `default boolean`"
  ([^ChronoZonedDateTime this ^java.time.chrono.ChronoZonedDateTime other]
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

  returns: an object of the same type with the specified period subtracted, not null - `default java.time.chrono.ChronoZonedDateTime<D>`

  throws: java.time.DateTimeException - if the unit cannot be subtracted"
  ([^ChronoZonedDateTime this ^Long amount-to-subtract ^java.time.temporal.TemporalUnit unit]
    (-> this (.minus amount-to-subtract unit)))
  ([^ChronoZonedDateTime this ^java.time.temporal.TemporalAmount amount]
    (-> this (.minus amount))))

(defn with-zone-same-local
  "Returns a copy of this date-time with a different time-zone,
   retaining the local date-time if possible.

   This method changes the time-zone and retains the local date-time.
   The local date-time is only changed if it is invalid for the new zone.

   To change the zone and adjust the local date-time,
   use withZoneSameInstant(ZoneId).

   This instance is immutable and unaffected by this method call.

  zone - the time-zone to change to, not null - `java.time.ZoneId`

  returns: a ChronoZonedDateTime based on this date-time with the requested zone, not null - `java.time.chrono.ChronoZonedDateTime<D>`"
  (^java.time.chrono.ChronoZonedDateTime [^ChronoZonedDateTime this ^java.time.ZoneId zone]
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

  returns: a ChronoZonedDateTime based on this date-time with the requested zone, not null - `java.time.chrono.ChronoZonedDateTime<D>`

  throws: java.time.DateTimeException - if the result exceeds the supported date range"
  (^java.time.chrono.ChronoZonedDateTime [^ChronoZonedDateTime this ^java.time.ZoneId zone]
    (-> this (.withZoneSameInstant zone))))

(defn to-local-time
  "Gets the local time part of this date-time.

   This returns a local time with the same hour, minute, second and
   nanosecond as this date-time.

  returns: the time part of this date-time, not null - `default java.time.LocalTime`"
  ([^ChronoZonedDateTime this]
    (-> this (.toLocalTime))))

(defn get-long
  "Description copied from interface: TemporalAccessor

  field - the field to get, not null - `java.time.temporal.TemporalField`

  returns: the value for the field - `default long`"
  ([^ChronoZonedDateTime this ^java.time.temporal.TemporalField field]
    (-> this (.getLong field))))

(defn get-offset
  "Gets the zone offset, such as '+01:00'.

   This is the offset of the local date-time from UTC/Greenwich.

  returns: the zone offset, not null - `java.time.ZoneOffset`"
  (^java.time.ZoneOffset [^ChronoZonedDateTime this]
    (-> this (.getOffset))))

(defn to-epoch-second
  "Converts this date-time to the number of seconds from the epoch
   of 1970-01-01T00:00:00Z.

   This uses the local date-time and
   offset to calculate the epoch-second value,
   which is the number of elapsed seconds from 1970-01-01T00:00:00Z.
   Instants on the time-line after the epoch are positive, earlier are negative.

  returns: the number of seconds from the epoch of 1970-01-01T00:00:00Z - `default long`"
  ([^ChronoZonedDateTime this]
    (-> this (.toEpochSecond))))

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

  returns: a ChronoZonedDateTime based on this date-time with the later offset, not null - `java.time.chrono.ChronoZonedDateTime<D>`

  throws: java.time.DateTimeException - if no rules are valid for this date-time"
  (^java.time.chrono.ChronoZonedDateTime [^ChronoZonedDateTime this]
    (-> this (.withLaterOffsetAtOverlap))))

(defn get-zone
  "Gets the zone ID, such as 'Europe/Paris'.

   This returns the stored time-zone id used to determine the time-zone rules.

  returns: the zone ID, not null - `java.time.ZoneId`"
  (^java.time.ZoneId [^ChronoZonedDateTime this]
    (-> this (.getZone))))

(defn *from
  "Obtains an instance of ChronoZonedDateTime from a temporal object.

   This creates a zoned date-time based on the specified temporal.
   A TemporalAccessor represents an arbitrary set of date and time information,
   which this factory converts to an instance of ChronoZonedDateTime.

   The conversion extracts and combines the chronology, date, time and zone
   from the temporal object. The behavior is equivalent to using
   Chronology.zonedDateTime(TemporalAccessor) with the extracted chronology.
   Implementations are permitted to perform optimizations such as accessing
   those fields that are equivalent to the relevant objects.

   This method matches the signature of the functional interface TemporalQuery
   allowing it to be used as a query via method reference, ChronoZonedDateTime::from.

  temporal - the temporal object to convert, not null - `java.time.temporal.TemporalAccessor`

  returns: the date-time, not null - `java.time.chrono.ChronoZonedDateTime<?>`

  throws: java.time.DateTimeException - if unable to convert to a ChronoZonedDateTime"
  (^java.time.chrono.ChronoZonedDateTime [^java.time.temporal.TemporalAccessor temporal]
    (ChronoZonedDateTime/from temporal)))

(defn is-after
  "Checks if the instant of this date-time is after that of the specified date-time.

   This method differs from the comparison in compareTo(java.time.chrono.ChronoZonedDateTime<?>) in that it
   only compares the instant of the date-time. This is equivalent to using
   dateTime1.toInstant().isAfter(dateTime2.toInstant());.

   This default implementation performs the comparison based on the epoch-second
   and nano-of-second.

  other - the other date-time to compare to, not null - `java.time.chrono.ChronoZonedDateTime`

  returns: true if this is after the specified date-time - `default boolean`"
  ([^ChronoZonedDateTime this ^java.time.chrono.ChronoZonedDateTime other]
    (-> this (.isAfter other))))

(defn supported?
  "Checks if the specified field is supported.

   This checks if the specified field can be queried on this date-time.
   If false, then calling the range,
   get and with(TemporalField, long)
   methods will throw an exception.

   The set of supported fields is defined by the chronology and normally includes
   all ChronoField fields.

   If the field is not a ChronoField, then the result of this method
   is obtained by invoking TemporalField.isSupportedBy(TemporalAccessor)
   passing this as the argument.
   Whether the field is supported is determined by the field.

  field - the field to check, null returns false - `java.time.temporal.TemporalField`

  returns: true if the field can be queried, false if not - `boolean`"
  (^Boolean [^ChronoZonedDateTime this ^java.time.temporal.TemporalField field]
    (-> this (.isSupported field))))

(defn get-chronology
  "Gets the chronology of this date-time.

   The Chronology represents the calendar system in use.
   The era and other fields in ChronoField are defined by the chronology.

  returns: the chronology, not null - `default java.time.chrono.Chronology`"
  ([^ChronoZonedDateTime this]
    (-> this (.getChronology))))

(defn to-local-date
  "Gets the local date part of this date-time.

   This returns a local date with the same year, month and day
   as this date-time.

  returns: the date part of this date-time, not null - `default D`"
  ([^ChronoZonedDateTime this]
    (-> this (.toLocalDate))))

(defn hash-code
  "A hash code for this date-time.

  returns: a suitable hash code - `int`"
  (^Integer [^ChronoZonedDateTime this]
    (-> this (.hashCode))))

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

  returns: an object of the same type with the specified field set, not null - `java.time.chrono.ChronoZonedDateTime<D>`

  throws: java.time.DateTimeException - if the field cannot be set"
  (^java.time.chrono.ChronoZonedDateTime [^ChronoZonedDateTime this ^java.time.temporal.TemporalField field ^Long new-value]
    (-> this (.with field new-value)))
  ([^ChronoZonedDateTime this ^java.time.temporal.TemporalAdjuster adjuster]
    (-> this (.with adjuster))))

(defn to-local-date-time
  "Gets the local date-time part of this date-time.

   This returns a local date with the same year, month and day
   as this date-time.

  returns: the local date-time part of this date-time, not null - `java.time.chrono.ChronoLocalDateTime<D>`"
  (^java.time.chrono.ChronoLocalDateTime [^ChronoZonedDateTime this]
    (-> this (.toLocalDateTime))))

(defn compare-to
  "Compares this date-time to another date-time, including the chronology.

   The comparison is based first on the instant, then on the local date-time,
   then on the zone ID, then on the chronology.
   It is \"consistent with equals\", as defined by Comparable.

   If all the date-time objects being compared are in the same chronology, then the
   additional chronology stage is not required.

   This default implementation performs the comparison defined above.

  other - the other date-time to compare to, not null - `java.time.chrono.ChronoZonedDateTime`

  returns: the comparator value, negative if less, positive if greater - `default int`"
  ([^ChronoZonedDateTime this ^java.time.chrono.ChronoZonedDateTime other]
    (-> this (.compareTo other))))

(defn get
  "Description copied from interface: TemporalAccessor

  field - the field to get, not null - `java.time.temporal.TemporalField`

  returns: the value for the field, within the valid range of values - `default int`"
  ([^ChronoZonedDateTime this ^java.time.temporal.TemporalField field]
    (-> this (.get field))))

(defn equals
  "Checks if this date-time is equal to another date-time.

   The comparison is based on the offset date-time and the zone.
   To compare for the same instant on the time-line, use compareTo(java.time.chrono.ChronoZonedDateTime<?>).
   Only objects of type ChronoZonedDateTime are compared, other types return false.

  obj - the object to check, null returns false - `java.lang.Object`

  returns: true if this is equal to the other date-time - `boolean`"
  (^Boolean [^ChronoZonedDateTime this ^java.lang.Object obj]
    (-> this (.equals obj))))

(defn format
  "Formats this date-time using the specified formatter.

   This date-time will be passed to the formatter to produce a string.

   The default implementation must behave as follows:


    return formatter.format(this);

  formatter - the formatter to use, not null - `java.time.format.DateTimeFormatter`

  returns: the formatted date-time string, not null - `default java.lang.String`

  throws: java.time.DateTimeException - if an error occurs during printing"
  ([^ChronoZonedDateTime this ^java.time.format.DateTimeFormatter formatter]
    (-> this (.format formatter))))

