(ns jdk.time.temporal.TemporalField
  "A field of date-time, such as month-of-year or hour-of-minute.

  Date and time is expressed using fields which partition the time-line into something
  meaningful for humans. Implementations of this interface represent those fields.

  The most commonly used units are defined in ChronoField.
  Further fields are supplied in IsoFields, WeekFields and JulianFields.
  Fields can also be written by application code by implementing this interface.

  The field works using double dispatch. Client code calls methods on a date-time like
  LocalDateTime which check if the field is a ChronoField.
  If it is, then the date-time must handle it.
  Otherwise, the method call is re-dispatched to the matching method in this interface."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.time.temporal TemporalField]))

(defn get-range-unit
  "Gets the range that the field is bound by.

   The range of the field is the period that the field varies within.
   For example, in the field 'MonthOfYear', the range is 'Years'.
   See also getBaseUnit().

   The range is never null. For example, the 'Year' field is shorthand for
   'YearOfForever'. It therefore has a unit of 'Years' and a range of 'Forever'.

  returns: the unit defining the range of the field, not null - `java.time.temporal.TemporalUnit`"
  ([^. this]
    (-> this (.getRangeUnit))))

(defn range
  "Gets the range of valid values for the field.

   All fields can be expressed as a long integer.
   This method returns an object that describes the valid range for that value.
   This method is generally only applicable to the ISO-8601 calendar system.

   Note that the result only describes the minimum and maximum valid values
   and it is important not to read too much into them. For example, there
   could be values within the range that are invalid for the field.

  returns: the range of valid values for the field, not null - `java.time.temporal.ValueRange`"
  ([^. this]
    (-> this (.range))))

(defn resolve
  "Resolves this field to provide a simpler alternative or a date.

   This method is invoked during the resolve phase of parsing.
   It is designed to allow application defined fields to be simplified into
   more standard fields, such as those on ChronoField, or into a date.

   Applications should not normally invoke this method directly.

  field-values - the map of fields to values, which can be updated, not null - `java.util.Map<java.time.temporal.TemporalField,java.lang.Long>`
  partial-temporal - the partially complete temporal to query for zone and chronology; querying for other things is undefined and not recommended, not null - `java.time.temporal.TemporalAccessor`
  resolver-style - the requested type of resolve, not null - `java.time.format.ResolverStyle`

  returns: the resolved temporal object; null if resolving only
    changed the map, or no resolve occurred - `default java.time.temporal.TemporalAccessor`

  throws: java.lang.ArithmeticException - if numeric overflow occurs"
  ([^. this ^java.util.Map field-values ^java.time.temporal.TemporalAccessor partial-temporal ^java.time.format.ResolverStyle resolver-style]
    (-> this (.resolve field-values partial-temporal resolver-style))))

(defn get-base-unit
  "Gets the unit that the field is measured in.

   The unit of the field is the period that varies within the range.
   For example, in the field 'MonthOfYear', the unit is 'Months'.
   See also getRangeUnit().

  returns: the unit defining the base unit of the field, not null - `java.time.temporal.TemporalUnit`"
  ([^. this]
    (-> this (.getBaseUnit))))

(defn to-string
  "Gets a descriptive name for the field.

   The should be of the format 'BaseOfRange', such as 'MonthOfYear',
   unless the field has a range of FOREVER, when only
   the base unit is mentioned, such as 'Year' or 'Era'.

  returns: the name of the field, not null - `java.lang.String`"
  ([^. this]
    (-> this (.toString))))

(defn date-based?
  "Checks if this field represents a component of a date.

   A field is date-based if it can be derived from
   EPOCH_DAY.
   Note that it is valid for both isDateBased() and isTimeBased()
   to return false, such as when representing a field like minute-of-week.

  returns: true if this field is a component of a date - `boolean`"
  ([^. this]
    (-> this (.isDateBased))))

(defn get-display-name
  "Gets the display name for the field in the requested locale.

   If there is no display name for the locale then a suitable default must be returned.

   The default implementation must check the locale is not null
   and return toString().

  locale - the locale to use, not null - `java.util.Locale`

  returns: the display name for the locale or a suitable default, not null - `default java.lang.String`"
  ([^. this ^java.util.Locale locale]
    (-> this (.getDisplayName locale))))

(defn supported-by?
  "Checks if this field is supported by the temporal object.

   This determines whether the temporal accessor supports this field.
   If this returns false, then the temporal cannot be queried for this field.

   There are two equivalent ways of using this method.
   The first is to invoke this method directly.
   The second is to use TemporalAccessor.isSupported(TemporalField):


     // these two lines are equivalent, but the second approach is recommended
     temporal = thisField.isSupportedBy(temporal);
     temporal = temporal.isSupported(thisField);
   It is recommended to use the second approach, isSupported(TemporalField),
   as it is a lot clearer to read in code.

   Implementations should determine whether they are supported using the fields
   available in ChronoField.

  temporal - the temporal object to query, not null - `java.time.temporal.TemporalAccessor`

  returns: true if the date-time can be queried for this field, false if not - `boolean`"
  ([^. this ^java.time.temporal.TemporalAccessor temporal]
    (-> this (.isSupportedBy temporal))))

(defn range-refined-by
  "Get the range of valid values for this field using the temporal object to
   refine the result.

   This uses the temporal object to find the range of valid values for the field.
   This is similar to range(), however this method refines the result
   using the temporal. For example, if the field is DAY_OF_MONTH the
   range method is not accurate as there are four possible month lengths,
   28, 29, 30 and 31 days. Using this method with a date allows the range to be
   accurate, returning just one of those four options.

   There are two equivalent ways of using this method.
   The first is to invoke this method directly.
   The second is to use TemporalAccessor.range(TemporalField):


     // these two lines are equivalent, but the second approach is recommended
     temporal = thisField.rangeRefinedBy(temporal);
     temporal = temporal.range(thisField);
   It is recommended to use the second approach, range(TemporalField),
   as it is a lot clearer to read in code.

   Implementations should perform any queries or calculations using the fields
   available in ChronoField.
   If the field is not supported an UnsupportedTemporalTypeException must be thrown.

  temporal - the temporal object used to refine the result, not null - `java.time.temporal.TemporalAccessor`

  returns: the range of valid values for this field, not null - `java.time.temporal.ValueRange`

  throws: java.time.DateTimeException - if the range for the field cannot be obtained"
  ([^. this ^java.time.temporal.TemporalAccessor temporal]
    (-> this (.rangeRefinedBy temporal))))

(defn adjust-into
  "Returns a copy of the specified temporal object with the value of this field set.

   This returns a new temporal object based on the specified one with the value for
   this field changed. For example, on a LocalDate, this could be used to
   set the year, month or day-of-month.
   The returned object has the same observable type as the specified object.

   In some cases, changing a field is not fully defined. For example, if the target object is
   a date representing the 31st January, then changing the month to February would be unclear.
   In cases like this, the implementation is responsible for resolving the result.
   Typically it will choose the previous valid date, which would be the last valid
   day of February in this example.

   There are two equivalent ways of using this method.
   The first is to invoke this method directly.
   The second is to use Temporal.with(TemporalField, long):


     // these two lines are equivalent, but the second approach is recommended
     temporal = thisField.adjustInto(temporal);
     temporal = temporal.with(thisField);
   It is recommended to use the second approach, with(TemporalField),
   as it is a lot clearer to read in code.

   Implementations should perform any queries or calculations using the fields
   available in ChronoField.
   If the field is not supported an UnsupportedTemporalTypeException must be thrown.

   Implementations must not alter the specified temporal object.
   Instead, an adjusted copy of the original must be returned.
   This provides equivalent, safe behavior for immutable and mutable implementations.

  temporal - the temporal object to adjust, not null - `R`
  new-value - the new value of the field - `long`

  returns: the adjusted temporal object, not null - `<R extends java.time.temporal.Temporal> R`

  throws: java.time.DateTimeException - if the field cannot be set"
  ([^. this temporal ^Long new-value]
    (-> this (.adjustInto temporal new-value))))

(defn get-from
  "Gets the value of this field from the specified temporal object.

   This queries the temporal object for the value of this field.

   There are two equivalent ways of using this method.
   The first is to invoke this method directly.
   The second is to use TemporalAccessor.getLong(TemporalField)
   (or TemporalAccessor.get(TemporalField)):


     // these two lines are equivalent, but the second approach is recommended
     temporal = thisField.getFrom(temporal);
     temporal = temporal.getLong(thisField);
   It is recommended to use the second approach, getLong(TemporalField),
   as it is a lot clearer to read in code.

   Implementations should perform any queries or calculations using the fields
   available in ChronoField.
   If the field is not supported an UnsupportedTemporalTypeException must be thrown.

  temporal - the temporal object to query, not null - `java.time.temporal.TemporalAccessor`

  returns: the value of this field, not null - `long`

  throws: java.time.DateTimeException - if a value for the field cannot be obtained"
  ([^. this ^java.time.temporal.TemporalAccessor temporal]
    (-> this (.getFrom temporal))))

(defn time-based?
  "Checks if this field represents a component of a time.

   A field is time-based if it can be derived from
   NANO_OF_DAY.
   Note that it is valid for both isDateBased() and isTimeBased()
   to return false, such as when representing a field like minute-of-week.

  returns: true if this field is a component of a time - `boolean`"
  ([^. this]
    (-> this (.isTimeBased))))

