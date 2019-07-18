(ns jdk.time.chrono.HijrahEra
  (:refer-clojure :only [require comment defn ->])
  (:import [java.time.chrono HijrahEra]))

(def AH
  "Enum Constant.

  The singleton instance for the current era, 'Anno Hegirae',
   which has the numeric value 1.

  type: java.time.chrono.HijrahEra"
  HijrahEra/AH)

(defn *values
  "Returns an array containing the constants of this enum type, in
  the order they are declared.  This method may be used to iterate
  over the constants as follows:


  for (HijrahEra c : HijrahEra.values())
      System.out.println(c);

  returns: an array containing the constants of this enum type, in the order they are declared - `java.time.chrono.HijrahEra[]`"
  ([]
    (HijrahEra/values )))

(defn *value-of
  "Returns the enum constant of this type with the specified name.
  The string must match exactly an identifier used to declare an
  enum constant in this type.  (Extraneous whitespace characters are
  not permitted.)

  name - the name of the enum constant to be returned. - `java.lang.String`

  returns: the enum constant with the specified name - `java.time.chrono.HijrahEra`

  throws: java.lang.IllegalArgumentException - if this enum type has no constant with the specified name"
  (^java.time.chrono.HijrahEra [^java.lang.String name]
    (HijrahEra/valueOf name)))

(defn *of
  "Obtains an instance of HijrahEra from an int value.

   The current era, which is the only accepted value, has the value 1

  hijrah-era - the era to represent, only 1 supported - `int`

  returns: the HijrahEra.AH singleton, not null - `java.time.chrono.HijrahEra`

  throws: java.time.DateTimeException - if the value is invalid"
  (^java.time.chrono.HijrahEra [^Integer hijrah-era]
    (HijrahEra/of hijrah-era)))

(defn get-value
  "Gets the numeric era int value.

   The era AH has the value 1.

  returns: the era value, 1 (AH) - `int`"
  (^Integer [^HijrahEra this]
    (-> this (.getValue))))

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

   The ERA field returns a range for the one valid Hijrah era.

  field - the field to query the range for, not null - `java.time.temporal.TemporalField`

  returns: the range of valid values for the field, not null - `java.time.temporal.ValueRange`

  throws: java.time.DateTimeException - if the range for the field cannot be obtained"
  (^java.time.temporal.ValueRange [^HijrahEra this ^java.time.temporal.TemporalField field]
    (-> this (.range field))))

