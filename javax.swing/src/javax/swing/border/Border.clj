(ns javax.swing.border.Border
  "Interface describing an object capable of rendering a border
  around the edges of a swing component.
  For examples of using borders see
  How to Use Borders,
  a section in The Java Tutorial.

  In the Swing component set, borders supercede Insets as the
  mechanism for creating a (decorated or plain) area around the
  edge of a component.

  Usage Notes:

  Use EmptyBorder to create a plain border (this mechanism
      replaces its predecessor, setInsets).
  Use CompoundBorder to nest multiple border objects, creating
      a single, combined border.
  Border instances are designed to be shared. Rather than creating
      a new border object using one of border classes, use the
      BorderFactory methods, which produces a shared instance of the
      common border types.
  Additional border styles include BevelBorder, SoftBevelBorder,
      EtchedBorder, LineBorder, TitledBorder, and MatteBorder.
  To create a new border class, subclass AbstractBorder."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing.border Border]))

(defn paint-border
  "Paints the border for the specified component with the specified
   position and size.

  c - the component for which this border is being painted - `java.awt.Component`
  g - the paint graphics - `java.awt.Graphics`
  x - the x position of the painted border - `int`
  y - the y position of the painted border - `int`
  width - the width of the painted border - `int`
  height - the height of the painted border - `int`"
  ([^. this ^java.awt.Component c ^java.awt.Graphics g ^Integer x ^Integer y ^Integer width ^Integer height]
    (-> this (.paintBorder c g x y width height))))

(defn get-border-insets
  "Returns the insets of the border.

  c - the component for which this border insets value applies - `java.awt.Component`

  returns: `java.awt.Insets`"
  ([^. this ^java.awt.Component c]
    (-> this (.getBorderInsets c))))

(defn border-opaque?
  "Returns whether or not the border is opaque.  If the border
   is opaque, it is responsible for filling in it's own
   background when painting.

  returns: `boolean`"
  ([^. this]
    (-> this (.isBorderOpaque))))

