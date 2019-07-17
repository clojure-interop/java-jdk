(ns javax.swing.border.BevelBorder
  "A class which implements a simple two-line bevel border.

  Warning:
  Serialized objects of this class will not be compatible with
  future Swing releases. The current serialization support is
  appropriate for short term storage or RMI between applications running
  the same version of Swing.  As of 1.4, support for long term storage
  of all JavaBeans™
  has been added to the java.beans package.
  Please see XMLEncoder."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing.border BevelBorder]))

(defn ->bevel-border
  "Constructor.

  Creates a bevel border with the specified type, highlight and
   shadow colors.

  bevel-type - the type of bevel for the border - `int`
  highlight-outer-color - the color to use for the bevel outer highlight - `java.awt.Color`
  highlight-inner-color - the color to use for the bevel inner highlight - `java.awt.Color`
  shadow-outer-color - the color to use for the bevel outer shadow - `java.awt.Color`
  shadow-inner-color - the color to use for the bevel inner shadow - `java.awt.Color`"
  ([^Integer bevel-type ^java.awt.Color highlight-outer-color ^java.awt.Color highlight-inner-color ^java.awt.Color shadow-outer-color ^java.awt.Color shadow-inner-color]
    (new BevelBorder bevel-type highlight-outer-color highlight-inner-color shadow-outer-color shadow-inner-color))
  ([^Integer bevel-type ^java.awt.Color highlight ^java.awt.Color shadow]
    (new BevelBorder bevel-type highlight shadow))
  ([^Integer bevel-type]
    (new BevelBorder bevel-type)))

(def *-raised
  "Static Constant.

  Raised bevel type.

  type: int"
  BevelBorder/RAISED)

(def *-lowered
  "Static Constant.

  Lowered bevel type.

  type: int"
  BevelBorder/LOWERED)

(defn paint-border
  "Paints the border for the specified component with the specified
   position and size.

  c - the component for which this border is being painted - `java.awt.Component`
  g - the paint graphics - `java.awt.Graphics`
  x - the x position of the painted border - `int`
  y - the y position of the painted border - `int`
  width - the width of the painted border - `int`
  height - the height of the painted border - `int`"
  ([^javax.swing.border.BevelBorder this ^java.awt.Component c ^java.awt.Graphics g ^Integer x ^Integer y ^Integer width ^Integer height]
    (-> this (.paintBorder c g x y width height))))

(defn get-border-insets
  "Reinitialize the insets parameter with this Border's current Insets.

  c - the component for which this border insets value applies - `java.awt.Component`
  insets - the object to be reinitialized - `java.awt.Insets`

  returns: the insets object - `java.awt.Insets`"
  (^java.awt.Insets [^javax.swing.border.BevelBorder this ^java.awt.Component c ^java.awt.Insets insets]
    (-> this (.getBorderInsets c insets))))

(defn get-highlight-outer-color
  "Returns the outer highlight color of the bevel border
   when rendered on the specified component.  If no highlight
   color was specified at instantiation, the highlight color
   is derived from the specified component's background color.

  c - the component for which the highlight may be derived - `java.awt.Component`

  returns: `java.awt.Color`"
  (^java.awt.Color [^javax.swing.border.BevelBorder this ^java.awt.Component c]
    (-> this (.getHighlightOuterColor c)))
  (^java.awt.Color [^javax.swing.border.BevelBorder this]
    (-> this (.getHighlightOuterColor))))

(defn get-highlight-inner-color
  "Returns the inner highlight color of the bevel border
   when rendered on the specified component.  If no highlight
   color was specified at instantiation, the highlight color
   is derived from the specified component's background color.

  c - the component for which the highlight may be derived - `java.awt.Component`

  returns: `java.awt.Color`"
  (^java.awt.Color [^javax.swing.border.BevelBorder this ^java.awt.Component c]
    (-> this (.getHighlightInnerColor c)))
  (^java.awt.Color [^javax.swing.border.BevelBorder this]
    (-> this (.getHighlightInnerColor))))

(defn get-shadow-inner-color
  "Returns the inner shadow color of the bevel border
   when rendered on the specified component.  If no shadow
   color was specified at instantiation, the shadow color
   is derived from the specified component's background color.

  c - the component for which the shadow may be derived - `java.awt.Component`

  returns: `java.awt.Color`"
  (^java.awt.Color [^javax.swing.border.BevelBorder this ^java.awt.Component c]
    (-> this (.getShadowInnerColor c)))
  (^java.awt.Color [^javax.swing.border.BevelBorder this]
    (-> this (.getShadowInnerColor))))

(defn get-shadow-outer-color
  "Returns the outer shadow color of the bevel border
   when rendered on the specified component.  If no shadow
   color was specified at instantiation, the shadow color
   is derived from the specified component's background color.

  c - the component for which the shadow may be derived - `java.awt.Component`

  returns: `java.awt.Color`"
  (^java.awt.Color [^javax.swing.border.BevelBorder this ^java.awt.Component c]
    (-> this (.getShadowOuterColor c)))
  (^java.awt.Color [^javax.swing.border.BevelBorder this]
    (-> this (.getShadowOuterColor))))

(defn get-bevel-type
  "Returns the type of the bevel border.

  returns: `int`"
  (^Integer [^javax.swing.border.BevelBorder this]
    (-> this (.getBevelType))))

(defn border-opaque?
  "Returns whether or not the border is opaque.

  returns: false - `boolean`"
  (^Boolean [^javax.swing.border.BevelBorder this]
    (-> this (.isBorderOpaque))))

