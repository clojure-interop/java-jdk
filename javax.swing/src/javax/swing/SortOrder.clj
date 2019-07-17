(ns javax.swing.SortOrder
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing SortOrder]))

(def ASCENDING
  "Enum Constant.

  Enumeration value indicating the items are sorted in increasing order.
   For example, the set 1, 4, 0 sorted in
   ASCENDING order is 0, 1, 4.

  type: javax.swing.SortOrder"
  SortOrder/ASCENDING)

(def DESCENDING
  "Enum Constant.

  Enumeration value indicating the items are sorted in decreasing order.
   For example, the set 1, 4, 0 sorted in
   DESCENDING order is 4, 1, 0.

  type: javax.swing.SortOrder"
  SortOrder/DESCENDING)

(def UNSORTED
  "Enum Constant.

  Enumeration value indicating the items are unordered.
   For example, the set 1, 4, 0 in
   UNSORTED order is 1, 4, 0.

  type: javax.swing.SortOrder"
  SortOrder/UNSORTED)

(defn *values
  "Returns an array containing the constants of this enum type, in
  the order they are declared.  This method may be used to iterate
  over the constants as follows:


  for (SortOrder c : SortOrder.values())
      System.out.println(c);

  returns: an array containing the constants of this enum type, in the order they are declared - `javax.swing.SortOrder[]`"
  ([]
    (SortOrder/values )))

(defn *value-of
  "Returns the enum constant of this type with the specified name.
  The string must match exactly an identifier used to declare an
  enum constant in this type.  (Extraneous whitespace characters are
  not permitted.)

  name - the name of the enum constant to be returned. - `java.lang.String`

  returns: the enum constant with the specified name - `javax.swing.SortOrder`

  throws: java.lang.IllegalArgumentException - if this enum type has no constant with the specified name"
  ([^java.lang.String name]
    (SortOrder/valueOf name)))

