(ns jdk.time.chrono.ThaiBuddhistEra
  (:refer-clojure :only [require comment defn ->])
  (:import [java.time.chrono ThaiBuddhistEra]))

(def BEFORE_BE
  "Enum Constant.

  The singleton instance for the era before the current one, 'Before Buddhist Era',
   which has the numeric value 0.

  type: java.time.chrono.ThaiBuddhistEra"
  ThaiBuddhistEra/BEFORE_BE)

(def BE
  "Enum Constant.

  The singleton instance for the current era, 'Buddhist Era',
   which has the numeric value 1.

  type: java.time.chrono.ThaiBuddhistEra"
  ThaiBuddhistEra/BE)

(defn *values
  "Returns an array containing the constants of this enum type, in
  the order they are declared.  This method may be used to iterate
  over the constants as follows:


  for (ThaiBuddhistEra c : ThaiBuddhistEra.values())
      System.out.println(c);

  returns: an array containing the constants of this enum type, in the order they are declared - `java.time.chrono.ThaiBuddhistEra[]`"
  ([]
    (ThaiBuddhistEra/values )))

(defn *value-of
  "Returns the enum constant of this type with the specified name.
  The string must match exactly an identifier used to declare an
  enum constant in this type.  (Extraneous whitespace characters are
  not permitted.)

  name - the name of the enum constant to be returned. - `java.lang.String`

  returns: the enum constant with the specified name - `java.time.chrono.ThaiBuddhistEra`

  throws: java.lang.IllegalArgumentException - if this enum type has no constant with the specified name"
  (^java.time.chrono.ThaiBuddhistEra [^java.lang.String name]
    (ThaiBuddhistEra/valueOf name)))

(defn *of
  "Obtains an instance of ThaiBuddhistEra from an int value.

   ThaiBuddhistEra is an enum representing the Thai Buddhist eras of BEFORE_BE/BE.
   This factory allows the enum to be obtained from the int value.

  thai-buddhist-era - the era to represent, from 0 to 1 - `int`

  returns: the BuddhistEra singleton, never null - `java.time.chrono.ThaiBuddhistEra`

  throws: java.time.DateTimeException - if the era is invalid"
  (^java.time.chrono.ThaiBuddhistEra [^Integer thai-buddhist-era]
    (ThaiBuddhistEra/of thai-buddhist-era)))

(defn get-value
  "Gets the numeric era int value.

   The era BEFORE_BE has the value 0, while the era BE has the value 1.

  returns: the era value, from 0 (BEFORE_BE) to 1 (BE) - `int`"
  (^Integer [^java.time.chrono.ThaiBuddhistEra this]
    (-> this (.getValue))))

