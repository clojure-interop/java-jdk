(ns jdk.time.chrono.IsoEra
  (:refer-clojure :only [require comment defn ->])
  (:import [java.time.chrono IsoEra]))

(def BCE
  "Enum Constant.

  The singleton instance for the era before the current one, 'Before Current Era',
   which has the numeric value 0.

  type: java.time.chrono.IsoEra"
  IsoEra/BCE)

(def CE
  "Enum Constant.

  The singleton instance for the current era, 'Current Era',
   which has the numeric value 1.

  type: java.time.chrono.IsoEra"
  IsoEra/CE)

(defn *values
  "Returns an array containing the constants of this enum type, in
  the order they are declared.  This method may be used to iterate
  over the constants as follows:


  for (IsoEra c : IsoEra.values())
      System.out.println(c);

  returns: an array containing the constants of this enum type, in the order they are declared - `java.time.chrono.IsoEra[]`"
  ([]
    (IsoEra/values )))

(defn *value-of
  "Returns the enum constant of this type with the specified name.
  The string must match exactly an identifier used to declare an
  enum constant in this type.  (Extraneous whitespace characters are
  not permitted.)

  name - the name of the enum constant to be returned. - `java.lang.String`

  returns: the enum constant with the specified name - `java.time.chrono.IsoEra`

  throws: java.lang.IllegalArgumentException - if this enum type has no constant with the specified name"
  ([^java.lang.String name]
    (IsoEra/valueOf name)))

(defn *of
  "Obtains an instance of IsoEra from an int value.

   IsoEra is an enum representing the ISO eras of BCE/CE.
   This factory allows the enum to be obtained from the int value.

  iso-era - the BCE/CE value to represent, from 0 (BCE) to 1 (CE) - `int`

  returns: the era singleton, not null - `java.time.chrono.IsoEra`

  throws: java.time.DateTimeException - if the value is invalid"
  ([^Integer iso-era]
    (IsoEra/of iso-era)))

(defn get-value
  "Gets the numeric era int value.

   The era BCE has the value 0, while the era CE has the value 1.

  returns: the era value, from 0 (BCE) to 1 (CE) - `int`"
  ([^java.time.chrono.IsoEra this]
    (-> this (.getValue))))

