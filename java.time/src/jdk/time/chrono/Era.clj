(ns jdk.time.chrono.Era
  "An era of the time-line.

  Most calendar systems have a single epoch dividing the time-line into two eras.
  However, some calendar systems, have multiple eras, such as one for the reign
  of each leader.
  In all cases, the era is conceptually the largest division of the time-line.
  Each chronology defines the Era's that are known Eras and a
  Chronology.eras to get the valid eras.

  For example, the Thai Buddhist calendar system divides time into two eras,
  before and after a single date. By contrast, the Japanese calendar system
  has one era for the reign of each Emperor.

  Instances of Era may be compared using the == operator."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.time.chrono Era]))

(defn get-value
  "Gets the numeric value associated with the era as defined by the chronology.
   Each chronology defines the predefined Eras and methods to list the Eras
   of the chronology.

   All fields, including eras, have an associated numeric value.
   The meaning of the numeric value for era is determined by the chronology
   according to these principles:

   The era in use at the epoch 1970-01-01 (ISO) has the value 1.
   Later eras have sequentially higher values.
   Earlier eras have sequentially lower values, which may be negative.

  returns: the numeric era value - `int`"
  (^Integer [^Era this]
    (-> this (.getValue))))

(defn is-supported
  "Checks if the specified field is supported.

   This checks if this era can be queried for the specified field.
   If false, then calling the range and
   get methods will throw an exception.

   If the field is a ChronoField then the query is implemented here.
   The ERA field returns true.
   All other ChronoField instances will return false.

   If the field is not a ChronoField, then the result of this method
   is obtained by invoking TemporalField.isSupportedBy(TemporalAccessor)
   passing this as the argument.
   Whether the field is supported is determined by the field.

  field - the field to check, null returns false - `java.time.temporal.TemporalField`

  returns: true if the field is supported on this era, false if not - `default boolean`"
  ([^Era this ^java.time.temporal.TemporalField field]
    (-> this (.isSupported field))))

(defn range
  "Gets the range of valid values for the specified field.

   The range object expresses the minimum and maximum valid values for a field.
   This era is used to enhance the accuracy of the returned range.
   If it is not possible to return the range, because the field is not supported
   or for some other reason, an exception is thrown.

   If the field is a ChronoField then the query is implemented here.
   The ERA field returns the range.
   All other ChronoField instances will throw an UnsupportedTemporalTypeException.

   If the field is not a ChronoField, then the result of this method
   is obtained by invoking TemporalField.rangeRefinedBy(TemporalAccessor)
   passing this as the argument.
   Whether the range can be obtained is determined by the field.

   The default implementation must return a range for ERA from
   zero to one, suitable for two era calendar systems such as ISO.

  field - the field to query the range for, not null - `java.time.temporal.TemporalField`

  returns: the range of valid values for the field, not null - `default java.time.temporal.ValueRange`

  throws: java.time.DateTimeException - if the range for the field cannot be obtained"
  ([^Era this ^java.time.temporal.TemporalField field]
    (-> this (.range field))))

(defn get
  "Gets the value of the specified field from this era as an int.

   This queries this era for the value of the specified field.
   The returned value will always be within the valid range of values for the field.
   If it is not possible to return the value, because the field is not supported
   or for some other reason, an exception is thrown.

   If the field is a ChronoField then the query is implemented here.
   The ERA field returns the value of the era.
   All other ChronoField instances will throw an UnsupportedTemporalTypeException.

   If the field is not a ChronoField, then the result of this method
   is obtained by invoking TemporalField.getFrom(TemporalAccessor)
   passing this as the argument. Whether the value can be obtained,
   and what the value represents, is determined by the field.

  field - the field to get, not null - `java.time.temporal.TemporalField`

  returns: the value for the field - `default int`

  throws: java.time.DateTimeException - if a value for the field cannot be obtained or the value is outside the range of valid values for the field"
  ([^Era this ^java.time.temporal.TemporalField field]
    (-> this (.get field))))

(defn get-long
  "Gets the value of the specified field from this era as a long.

   This queries this era for the value of the specified field.
   If it is not possible to return the value, because the field is not supported
   or for some other reason, an exception is thrown.

   If the field is a ChronoField then the query is implemented here.
   The ERA field returns the value of the era.
   All other ChronoField instances will throw an UnsupportedTemporalTypeException.

   If the field is not a ChronoField, then the result of this method
   is obtained by invoking TemporalField.getFrom(TemporalAccessor)
   passing this as the argument. Whether the value can be obtained,
   and what the value represents, is determined by the field.

  field - the field to get, not null - `java.time.temporal.TemporalField`

  returns: the value for the field - `default long`

  throws: java.time.DateTimeException - if a value for the field cannot be obtained"
  ([^Era this ^java.time.temporal.TemporalField field]
    (-> this (.getLong field))))

(defn query
  "Queries this era using the specified query.

   This queries this era using the specified query strategy object.
   The TemporalQuery object defines the logic to be used to
   obtain the result. Read the documentation of the query to understand
   what the result of this method will be.

   The result of this method is obtained by invoking the
   TemporalQuery.queryFrom(TemporalAccessor) method on the
   specified query passing this as the argument.

  query - the query to invoke, not null - `java.time.temporal.TemporalQuery`

  returns: the query result, null may be returned (defined by the query) - `default <R> R`

  throws: java.time.DateTimeException - if unable to query (defined by the query)"
  ([^Era this ^java.time.temporal.TemporalQuery query]
    (-> this (.query query))))

(defn adjust-into
  "Adjusts the specified temporal object to have the same era as this object.

   This returns a temporal object of the same observable type as the input
   with the era changed to be the same as this.

   The adjustment is equivalent to using Temporal.with(TemporalField, long)
   passing ChronoField.ERA as the field.

   In most cases, it is clearer to reverse the calling pattern by using
   Temporal.with(TemporalAdjuster):


     // these two lines are equivalent, but the second approach is recommended
     temporal = thisEra.adjustInto(temporal);
     temporal = temporal.with(thisEra);

   This instance is immutable and unaffected by this method call.

  temporal - the target object to be adjusted, not null - `java.time.temporal.Temporal`

  returns: the adjusted object, not null - `default java.time.temporal.Temporal`

  throws: java.time.DateTimeException - if unable to make the adjustment"
  ([^Era this ^java.time.temporal.Temporal temporal]
    (-> this (.adjustInto temporal))))

(defn get-display-name
  "Gets the textual representation of this era.

   This returns the textual name used to identify the era,
   suitable for presentation to the user.
   The parameters control the style of the returned text and the locale.

   If no textual mapping is found then the numeric value is returned.

  style - the style of the text required, not null - `java.time.format.TextStyle`
  locale - the locale to use, not null - `java.util.Locale`

  returns: the text value of the era, not null - `default java.lang.String`"
  ([^Era this ^java.time.format.TextStyle style ^java.util.Locale locale]
    (-> this (.getDisplayName style locale))))

