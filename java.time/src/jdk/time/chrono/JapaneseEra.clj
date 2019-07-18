(ns jdk.time.chrono.JapaneseEra
  "An era in the Japanese Imperial calendar system.

  The Japanese government defines the official name and start date of
  each era. Eras are consecutive and their date ranges do not overlap,
  so the end date of one era is always the day before the start date
  of the next era.

  The Java SE Platform supports all eras defined by the Japanese government,
  beginning with the Meiji era. Each era is identified in the Platform by an
  integer value and a name. The of(int) and valueOf(String)
  methods may be used to obtain a singleton instance of JapaneseEra for each
  era. The values() method returns the singleton instances of all
  supported eras.

  For convenience, this class declares a number of public static final fields
  that refer to singleton instances returned by the values() method."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.time.chrono JapaneseEra]))

(def *-meiji
  "Static Constant.

  The singleton instance for the 'Meiji' era (1868-01-01 - 1912-07-29)
   which has the value -1.

  type: java.time.chrono.JapaneseEra"
  JapaneseEra/MEIJI)

(def *-taisho
  "Static Constant.

  The singleton instance for the 'Taisho' era (1912-07-30 - 1926-12-24)
   which has the value 0.

  type: java.time.chrono.JapaneseEra"
  JapaneseEra/TAISHO)

(def *-showa
  "Static Constant.

  The singleton instance for the 'Showa' era (1926-12-25 - 1989-01-07)
   which has the value 1.

  type: java.time.chrono.JapaneseEra"
  JapaneseEra/SHOWA)

(def *-heisei
  "Static Constant.

  The singleton instance for the 'Heisei' era (1989-01-08 - 2019-04-30)
   which has the value 2.

  type: java.time.chrono.JapaneseEra"
  JapaneseEra/HEISEI)

(defn *of
  "Obtains an instance of JapaneseEra from an int value.

   The value 1 is associated with the 'Showa' era, because
   it contains 1970-01-01 (ISO calendar system).
   The values -1 and 0 are associated with two earlier
   eras, Meiji and Taisho, respectively.
   A value greater than 1 is associated with a later era,
   beginning with Heisei (2).


   Every instance of JapaneseEra that is returned from the values()
   method has an int value (available via Era.getValue() which is
   accepted by this method.

  japanese-era - the era to represent - `int`

  returns: the JapaneseEra singleton, not null - `java.time.chrono.JapaneseEra`

  throws: java.time.DateTimeException - if the value is invalid"
  (^java.time.chrono.JapaneseEra [^Integer japanese-era]
    (JapaneseEra/of japanese-era)))

(defn *value-of
  "Returns the JapaneseEra with the name.

   The string must match exactly the name of the era.
   (Extraneous whitespace characters are not permitted.)

  japanese-era - the japaneseEra name; non-null - `java.lang.String`

  returns: the JapaneseEra singleton, never null - `java.time.chrono.JapaneseEra`

  throws: java.lang.IllegalArgumentException - if there is not JapaneseEra with the specified name"
  (^java.time.chrono.JapaneseEra [^java.lang.String japanese-era]
    (JapaneseEra/valueOf japanese-era)))

(defn *values
  "Returns an array of JapaneseEras.

   This method may be used to iterate over the JapaneseEras as follows:


   for (JapaneseEra c : JapaneseEra.values())
       System.out.println(c);

  returns: an array of JapaneseEras - `java.time.chrono.JapaneseEra[]`"
  ([]
    (JapaneseEra/values )))

(defn get-display-name
  "Gets the textual representation of this era.

   This returns the textual name used to identify the era,
   suitable for presentation to the user.
   The parameters control the style of the returned text and the locale.

   If no textual mapping is found then the numeric value is returned.

  style - the style of the text required, not null - `java.time.format.TextStyle`
  locale - the locale to use, not null - `java.util.Locale`

  returns: the text value of the era, not null - `java.lang.String`"
  (^java.lang.String [^JapaneseEra this ^java.time.format.TextStyle style ^java.util.Locale locale]
    (-> this (.getDisplayName style locale))))

(defn get-value
  "Gets the numeric era int value.

   The SHOWA era that contains 1970-01-01 (ISO calendar system) has the value 1.
   Later eras are numbered from 2 (HEISEI).
   Earlier eras are numbered 0 (TAISHO), -1 (MEIJI)).

  returns: the era value - `int`"
  (^Integer [^JapaneseEra this]
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

   The range of valid Japanese eras can change over time due to the nature
   of the Japanese calendar system.

  field - the field to query the range for, not null - `java.time.temporal.TemporalField`

  returns: the range of valid values for the field, not null - `java.time.temporal.ValueRange`

  throws: java.time.DateTimeException - if the range for the field cannot be obtained"
  (^java.time.temporal.ValueRange [^JapaneseEra this ^java.time.temporal.TemporalField field]
    (-> this (.range field))))

(defn to-string
  "Description copied from class: Object

  returns: a string representation of the object. - `java.lang.String`"
  (^java.lang.String [^JapaneseEra this]
    (-> this (.toString))))

