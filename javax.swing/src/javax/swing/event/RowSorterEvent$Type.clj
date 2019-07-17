(ns javax.swing.event.RowSorterEvent$Type
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing.event RowSorterEvent$Type]))

(def SORT_ORDER_CHANGED
  "Enum Constant.

  Indicates the sort order has changed.

  type: javax.swing.event.RowSorterEvent.Type"
  RowSorterEvent$Type/SORT_ORDER_CHANGED)

(def SORTED
  "Enum Constant.

  Indicates the contents have been newly sorted or
   transformed in some way.

  type: javax.swing.event.RowSorterEvent.Type"
  RowSorterEvent$Type/SORTED)

(defn *values
  "Returns an array containing the constants of this enum type, in
  the order they are declared.  This method may be used to iterate
  over the constants as follows:


  for (RowSorterEvent.Type c : RowSorterEvent.Type.values())
      System.out.println(c);

  returns: an array containing the constants of this enum type, in the order they are declared - `javax.swing.event.RowSorterEvent.Type[]`"
  ([]
    (RowSorterEvent$Type/values )))

(defn *value-of
  "Returns the enum constant of this type with the specified name.
  The string must match exactly an identifier used to declare an
  enum constant in this type.  (Extraneous whitespace characters are
  not permitted.)

  name - the name of the enum constant to be returned. - `java.lang.String`

  returns: the enum constant with the specified name - `javax.swing.event.RowSorterEvent.Type`

  throws: java.lang.IllegalArgumentException - if this enum type has no constant with the specified name"
  (^javax.swing.event.RowSorterEvent.Type [^java.lang.String name]
    (RowSorterEvent$Type/valueOf name)))

