(ns jdk.time.chrono.MinguoEra
  (:refer-clojure :only [require comment defn ->])
  (:import [java.time.chrono MinguoEra]))

(def BEFORE_ROC
  "Enum Constant.

  The singleton instance for the era before the current one, 'Before Republic of China Era',
   which has the numeric value 0.

  type: java.time.chrono.MinguoEra"
  MinguoEra/BEFORE_ROC)

(def ROC
  "Enum Constant.

  The singleton instance for the current era, 'Republic of China Era',
   which has the numeric value 1.

  type: java.time.chrono.MinguoEra"
  MinguoEra/ROC)

(defn *values
  "Returns an array containing the constants of this enum type, in
  the order they are declared.  This method may be used to iterate
  over the constants as follows:


  for (MinguoEra c : MinguoEra.values())
      System.out.println(c);

  returns: an array containing the constants of this enum type, in the order they are declared - `java.time.chrono.MinguoEra[]`"
  ([]
    (MinguoEra/values )))

(defn *value-of
  "Returns the enum constant of this type with the specified name.
  The string must match exactly an identifier used to declare an
  enum constant in this type.  (Extraneous whitespace characters are
  not permitted.)

  name - the name of the enum constant to be returned. - `java.lang.String`

  returns: the enum constant with the specified name - `java.time.chrono.MinguoEra`

  throws: java.lang.IllegalArgumentException - if this enum type has no constant with the specified name"
  (^java.time.chrono.MinguoEra [^java.lang.String name]
    (MinguoEra/valueOf name)))

(defn *of
  "Obtains an instance of MinguoEra from an int value.

   MinguoEra is an enum representing the Minguo eras of BEFORE_ROC/ROC.
   This factory allows the enum to be obtained from the int value.

  minguo-era - the BEFORE_ROC/ROC value to represent, from 0 (BEFORE_ROC) to 1 (ROC) - `int`

  returns: the era singleton, not null - `java.time.chrono.MinguoEra`

  throws: java.time.DateTimeException - if the value is invalid"
  (^java.time.chrono.MinguoEra [^Integer minguo-era]
    (MinguoEra/of minguo-era)))

(defn get-value
  "Gets the numeric era int value.

   The era BEFORE_ROC has the value 0, while the era ROC has the value 1.

  returns: the era value, from 0 (BEFORE_ROC) to 1 (ROC) - `int`"
  (^Integer [^MinguoEra this]
    (-> this (.getValue))))

