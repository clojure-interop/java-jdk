(ns javax.swing.GroupLayout$Alignment
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing GroupLayout$Alignment]))

(def LEADING
  "Enum Constant.

  Indicates the elements should be
   aligned to the origin.  For the horizontal axis with a left to
   right orientation this means aligned to the left edge. For the
   vertical axis leading means aligned to the top edge.

  type: javax.swing.GroupLayout.Alignment"
  GroupLayout$Alignment/LEADING)

(def TRAILING
  "Enum Constant.

  Indicates the elements should be aligned to the end of the
   region.  For the horizontal axis with a left to right
   orientation this means aligned to the right edge. For the
   vertical axis trailing means aligned to the bottom edge.

  type: javax.swing.GroupLayout.Alignment"
  GroupLayout$Alignment/TRAILING)

(def CENTER
  "Enum Constant.

  Indicates the elements should be centered in
   the region.

  type: javax.swing.GroupLayout.Alignment"
  GroupLayout$Alignment/CENTER)

(def BASELINE
  "Enum Constant.

  Indicates the elements should be aligned along
   their baseline.

  type: javax.swing.GroupLayout.Alignment"
  GroupLayout$Alignment/BASELINE)

(defn *values
  "Returns an array containing the constants of this enum type, in
  the order they are declared.  This method may be used to iterate
  over the constants as follows:


  for (GroupLayout.Alignment c : GroupLayout.Alignment.values())
      System.out.println(c);

  returns: an array containing the constants of this enum type, in the order they are declared - `javax.swing.GroupLayout.Alignment[]`"
  ([]
    (GroupLayout$Alignment/values )))

(defn *value-of
  "Returns the enum constant of this type with the specified name.
  The string must match exactly an identifier used to declare an
  enum constant in this type.  (Extraneous whitespace characters are
  not permitted.)

  name - the name of the enum constant to be returned. - `java.lang.String`

  returns: the enum constant with the specified name - `javax.swing.GroupLayout.Alignment`

  throws: java.lang.IllegalArgumentException - if this enum type has no constant with the specified name"
  ([name]
    (GroupLayout$Alignment/valueOf name)))

