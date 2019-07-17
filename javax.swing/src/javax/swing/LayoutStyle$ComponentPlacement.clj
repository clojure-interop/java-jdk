(ns javax.swing.LayoutStyle$ComponentPlacement
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing LayoutStyle$ComponentPlacement]))

(def RELATED
  "Enum Constant.

  Enumeration value indicating the two components are
   visually related and will be placed in the same parent.
   For example, a JLabel providing a label for a
   JTextField is typically visually associated
   with the JTextField; the constant RELATED
   is used for this.

  type: javax.swing.LayoutStyle.ComponentPlacement"
  LayoutStyle$ComponentPlacement/RELATED)

(def UNRELATED
  "Enum Constant.

  Enumeration value indicating the two components are
   visually unrelated and will be placed in the same parent.
   For example, groupings of components are usually visually
   separated; the constant UNRELATED is used for this.

  type: javax.swing.LayoutStyle.ComponentPlacement"
  LayoutStyle$ComponentPlacement/UNRELATED)

(def INDENT
  "Enum Constant.

  Enumeration value indicating the distance to indent a component
   is being requested.  For example, often times the children of
   a label will be horizontally indented from the label.  To determine
   the preferred distance for such a gap use the
   INDENT type.

   This value is typically only useful with a direction of
   EAST or WEST.

  type: javax.swing.LayoutStyle.ComponentPlacement"
  LayoutStyle$ComponentPlacement/INDENT)

(defn *values
  "Returns an array containing the constants of this enum type, in
  the order they are declared.  This method may be used to iterate
  over the constants as follows:


  for (LayoutStyle.ComponentPlacement c : LayoutStyle.ComponentPlacement.values())
      System.out.println(c);

  returns: an array containing the constants of this enum type, in the order they are declared - `javax.swing.LayoutStyle.ComponentPlacement[]`"
  ([]
    (LayoutStyle$ComponentPlacement/values )))

(defn *value-of
  "Returns the enum constant of this type with the specified name.
  The string must match exactly an identifier used to declare an
  enum constant in this type.  (Extraneous whitespace characters are
  not permitted.)

  name - the name of the enum constant to be returned. - `java.lang.String`

  returns: the enum constant with the specified name - `javax.swing.LayoutStyle.ComponentPlacement`

  throws: java.lang.IllegalArgumentException - if this enum type has no constant with the specified name"
  (^javax.swing.LayoutStyle.ComponentPlacement [^java.lang.String name]
    (LayoutStyle$ComponentPlacement/valueOf name)))

