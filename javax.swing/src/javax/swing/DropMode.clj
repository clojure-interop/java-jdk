(ns javax.swing.DropMode
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing DropMode]))

(def USE_SELECTION
  "Enum Constant.

  A component's own internal selection mechanism (or caret for text
   components) should be used to track the drop location.

  type: javax.swing.DropMode"
  DropMode/USE_SELECTION)

(def ON
  "Enum Constant.

  The drop location should be tracked in terms of the index of
   existing items. Useful for dropping on items in tables, lists,
   and trees.

  type: javax.swing.DropMode"
  DropMode/ON)

(def INSERT
  "Enum Constant.

  The drop location should be tracked in terms of the position
   where new data should be inserted. For components that manage
   a list of items (list and tree for example), the drop location
   should indicate the index where new data should be inserted.
   For text components the location should represent a position
   between characters. For components that manage tabular data
   (table for example), the drop location should indicate
   where to insert new rows, columns, or both, to accommodate
   the dropped data.

  type: javax.swing.DropMode"
  DropMode/INSERT)

(def INSERT_ROWS
  "Enum Constant.

  The drop location should be tracked in terms of the row index
   where new rows should be inserted to accommodate the dropped
   data. This is useful for components that manage tabular data.

  type: javax.swing.DropMode"
  DropMode/INSERT_ROWS)

(def INSERT_COLS
  "Enum Constant.

  The drop location should be tracked in terms of the column index
   where new columns should be inserted to accommodate the dropped
   data. This is useful for components that manage tabular data.

  type: javax.swing.DropMode"
  DropMode/INSERT_COLS)

(def ON_OR_INSERT
  "Enum Constant.

  This mode is a combination of ON
   and INSERT, specifying that data can be
   dropped on existing items, or in insert locations
   as specified by INSERT.

  type: javax.swing.DropMode"
  DropMode/ON_OR_INSERT)

(def ON_OR_INSERT_ROWS
  "Enum Constant.

  This mode is a combination of ON
   and INSERT_ROWS, specifying that data can be
   dropped on existing items, or as insert rows
   as specified by INSERT_ROWS.

  type: javax.swing.DropMode"
  DropMode/ON_OR_INSERT_ROWS)

(def ON_OR_INSERT_COLS
  "Enum Constant.

  This mode is a combination of ON
   and INSERT_COLS, specifying that data can be
   dropped on existing items, or as insert columns
   as specified by INSERT_COLS.

  type: javax.swing.DropMode"
  DropMode/ON_OR_INSERT_COLS)

(defn *values
  "Returns an array containing the constants of this enum type, in
  the order they are declared.  This method may be used to iterate
  over the constants as follows:


  for (DropMode c : DropMode.values())
      System.out.println(c);

  returns: an array containing the constants of this enum type, in the order they are declared - `javax.swing.DropMode[]`"
  ([]
    (DropMode/values )))

(defn *value-of
  "Returns the enum constant of this type with the specified name.
  The string must match exactly an identifier used to declare an
  enum constant in this type.  (Extraneous whitespace characters are
  not permitted.)

  name - the name of the enum constant to be returned. - `java.lang.String`

  returns: the enum constant with the specified name - `javax.swing.DropMode`

  throws: java.lang.IllegalArgumentException - if this enum type has no constant with the specified name"
  (^javax.swing.DropMode [^java.lang.String name]
    (DropMode/valueOf name)))

