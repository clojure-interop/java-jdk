(ns javax.swing.RowFilter$ComparisonType
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing RowFilter$ComparisonType]))

(def BEFORE
  "Enum Constant.

  Indicates that entries with a value before the supplied
   value should be included.

  type: javax.swing.RowFilter$ComparisonType"
  RowFilter$ComparisonType/BEFORE)

(def AFTER
  "Enum Constant.

  Indicates that entries with a value after the supplied
   value should be included.

  type: javax.swing.RowFilter$ComparisonType"
  RowFilter$ComparisonType/AFTER)

(def EQUAL
  "Enum Constant.

  Indicates that entries with a value equal to the supplied
   value should be included.

  type: javax.swing.RowFilter$ComparisonType"
  RowFilter$ComparisonType/EQUAL)

(def NOT_EQUAL
  "Enum Constant.

  Indicates that entries with a value not equal to the supplied
   value should be included.

  type: javax.swing.RowFilter$ComparisonType"
  RowFilter$ComparisonType/NOT_EQUAL)

(defn *values
  "Returns an array containing the constants of this enum type, in
  the order they are declared.  This method may be used to iterate
  over the constants as follows:


  for (RowFilter.ComparisonType c : RowFilter.ComparisonType.values())
      System.out.println(c);

  returns: an array containing the constants of this enum type, in the order they are declared - `javax.swing.RowFilter$ComparisonType[]`"
  ([]
    (RowFilter$ComparisonType/values )))

(defn *value-of
  "Returns the enum constant of this type with the specified name.
  The string must match exactly an identifier used to declare an
  enum constant in this type.  (Extraneous whitespace characters are
  not permitted.)

  name - the name of the enum constant to be returned. - `java.lang.String`

  returns: the enum constant with the specified name - `javax.swing.RowFilter$ComparisonType`

  throws: java.lang.IllegalArgumentException - if this enum type has no constant with the specified name"
  (^javax.swing.RowFilter$ComparisonType [^java.lang.String name]
    (RowFilter$ComparisonType/valueOf name)))

