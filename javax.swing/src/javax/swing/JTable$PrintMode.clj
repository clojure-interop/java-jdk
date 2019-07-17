(ns javax.swing.JTable$PrintMode
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing JTable$PrintMode]))

(def NORMAL
  "Enum Constant.

  Printing mode that prints the table at its current size,
   spreading both columns and rows across multiple pages if necessary.

  type: javax.swing.JTable.PrintMode"
  JTable$PrintMode/NORMAL)

(def FIT_WIDTH
  "Enum Constant.

  Printing mode that scales the output smaller, if necessary,
   to fit the table's entire width (and thereby all columns) on each page;
   Rows are spread across multiple pages as necessary.

  type: javax.swing.JTable.PrintMode"
  JTable$PrintMode/FIT_WIDTH)

(defn *values
  "Returns an array containing the constants of this enum type, in
  the order they are declared.  This method may be used to iterate
  over the constants as follows:


  for (JTable.PrintMode c : JTable.PrintMode.values())
      System.out.println(c);

  returns: an array containing the constants of this enum type, in the order they are declared - `javax.swing.JTable.PrintMode[]`"
  ([]
    (JTable$PrintMode/values )))

(defn *value-of
  "Returns the enum constant of this type with the specified name.
  The string must match exactly an identifier used to declare an
  enum constant in this type.  (Extraneous whitespace characters are
  not permitted.)

  name - the name of the enum constant to be returned. - `java.lang.String`

  returns: the enum constant with the specified name - `javax.swing.JTable.PrintMode`

  throws: java.lang.IllegalArgumentException - if this enum type has no constant with the specified name"
  ([^java.lang.String name]
    (JTable$PrintMode/valueOf name)))

