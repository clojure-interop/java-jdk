(ns jdk.time.temporal.TemporalAccessor
  "Framework-level interface defining read-only access to a temporal object,
  such as a date, time, offset or some combination of these.

  This is the base interface type for date, time and offset objects.
  It is implemented by those classes that can provide information
  as java.time.temporal.fields or java.time.temporal.queries.

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

  A sub-interface, Temporal, extends this definition to one that also
  supports adjustment and manipulation on more complete temporal objects.

  This interface is a framework-level interface that should not be widely
  used in application code. Instead, applications should create and pass
  around instances of concrete types, such as LocalDate.
  There are many reasons for this, part of which is that implementations
  of this interface may be in calendar systems other than ISO.
  See ChronoLocalDate for a fuller discussion of the issues."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.time.temporal TemporalAccessor]))

(defn supported?
  "Checks if the specified field is supported.

   This checks if the date-time can be queried for the specified field.
   If false, then calling the range and get
   methods will throw an exception.

  field - the field to check, null returns false - `java.time.temporal.TemporalField`

  returns: true if this date-time can be queried for the field, false if not - `boolean`"
  ([^. this ^java.time.temporal.TemporalField field]
    (-> this (.isSupported field))))

(defn range
  "Gets the range of valid values for the specified field.

   All fields can be expressed as a long integer.
   This method returns an object that describes the valid range for that value.
   The value of this temporal object is used to enhance the accuracy of the returned range.
   If the date-time cannot return the range, because the field is unsupported or for
   some other reason, an exception will be thrown.

   Note that the result only describes the minimum and maximum valid values
   and it is important not to read too much into them. For example, there
   could be values within the range that are invalid for the field.

  field - the field to query the range for, not null - `java.time.temporal.TemporalField`

  returns: the range of valid values for the field, not null - `default java.time.temporal.ValueRange`

  throws: java.time.DateTimeException - if the range for the field cannot be obtained"
  ([^. this ^java.time.temporal.TemporalField field]
    (-> this (.range field))))

(defn get
  "Gets the value of the specified field as an int.

   This queries the date-time for the value of the specified field.
   The returned value will always be within the valid range of values for the field.
   If the date-time cannot return the value, because the field is unsupported or for
   some other reason, an exception will be thrown.

  field - the field to get, not null - `java.time.temporal.TemporalField`

  returns: the value for the field, within the valid range of values - `default int`

  throws: java.time.DateTimeException - if a value for the field cannot be obtained or the value is outside the range of valid values for the field"
  ([^. this ^java.time.temporal.TemporalField field]
    (-> this (.get field))))

(defn get-long
  "Gets the value of the specified field as a long.

   This queries the date-time for the value of the specified field.
   The returned value may be outside the valid range of values for the field.
   If the date-time cannot return the value, because the field is unsupported or for
   some other reason, an exception will be thrown.

  field - the field to get, not null - `java.time.temporal.TemporalField`

  returns: the value for the field - `long`

  throws: java.time.DateTimeException - if a value for the field cannot be obtained"
  ([^. this ^java.time.temporal.TemporalField field]
    (-> this (.getLong field))))

(defn query
  "Queries this date-time.

   This queries this date-time using the specified query strategy object.

   Queries are a key tool for extracting information from date-times.
   They exists to externalize the process of querying, permitting different
   approaches, as per the strategy design pattern.
   Examples might be a query that checks if the date is the day before February 29th
   in a leap year, or calculates the number of days to your next birthday.

   The most common query implementations are method references, such as
   LocalDate::from and ZoneId::from.
   Additional implementations are provided as static methods on TemporalQuery.

  query - the query to invoke, not null - `java.time.temporal.TemporalQuery<R>`

  returns: the query result, null may be returned (defined by the query) - `default <R> R`

  throws: java.time.DateTimeException - if unable to query"
  ([^. this ^java.time.temporal.TemporalQuery query]
    (-> this (.query query))))

