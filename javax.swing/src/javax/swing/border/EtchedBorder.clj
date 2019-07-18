(ns javax.swing.border.EtchedBorder
  "A class which implements a simple etched border which can
  either be etched-in or etched-out.  If no highlight/shadow
  colors are initialized when the border is created, then
  these colors will be dynamically derived from the background
  color of the component argument passed into the paintBorder()
  method.

  Warning:
  Serialized objects of this class will not be compatible with
  future Swing releases. The current serialization support is
  appropriate for short term storage or RMI between applications running
  the same version of Swing.  As of 1.4, support for long term storage
  of all JavaBeans™
  has been added to the java.beans package.
  Please see XMLEncoder."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing.border EtchedBorder]))

(defn ->etched-border
  "Constructor.

  Creates an etched border with the specified etch-type,
   highlight and shadow colors.

  etch-type - the type of etch to be drawn by the border - `int`
  highlight - the color to use for the etched highlight - `java.awt.Color`
  shadow - the color to use for the etched shadow - `java.awt.Color`"
  (^EtchedBorder [^Integer etch-type ^java.awt.Color highlight ^java.awt.Color shadow]
    (new EtchedBorder etch-type highlight shadow))
  (^EtchedBorder [^java.awt.Color highlight ^java.awt.Color shadow]
    (new EtchedBorder highlight shadow))
  (^EtchedBorder [^Integer etch-type]
    (new EtchedBorder etch-type))
  (^EtchedBorder []
    (new EtchedBorder )))

(def *-raised
  "Static Constant.

  Raised etched type.

  type: int"
  EtchedBorder/RAISED)

(def *-lowered
  "Static Constant.

  Lowered etched type.

  type: int"
  EtchedBorder/LOWERED)

(defn paint-border
  "Paints the border for the specified component with the
   specified position and size.

  c - the component for which this border is being painted - `java.awt.Component`
  g - the paint graphics - `java.awt.Graphics`
  x - the x position of the painted border - `int`
  y - the y position of the painted border - `int`
  width - the width of the painted border - `int`
  height - the height of the painted border - `int`"
  ([^EtchedBorder this ^java.awt.Component c ^java.awt.Graphics g ^Integer x ^Integer y ^Integer width ^Integer height]
    (-> this (.paintBorder c g x y width height))))

(defn get-border-insets
  "Reinitialize the insets parameter with this Border's current Insets.

  c - the component for which this border insets value applies - `java.awt.Component`
  insets - the object to be reinitialized - `java.awt.Insets`

  returns: the insets object - `java.awt.Insets`"
  (^java.awt.Insets [^EtchedBorder this ^java.awt.Component c ^java.awt.Insets insets]
    (-> this (.getBorderInsets c insets))))

(defn border-opaque?
  "Returns whether or not the border is opaque.

  returns: false - `boolean`"
  (^Boolean [^EtchedBorder this]
    (-> this (.isBorderOpaque))))

(defn get-etch-type
  "Returns which etch-type is set on the etched border.

  returns: `int`"
  (^Integer [^EtchedBorder this]
    (-> this (.getEtchType))))

(defn get-highlight-color
  "Returns the highlight color of the etched border
   when rendered on the specified component.  If no highlight
   color was specified at instantiation, the highlight color
   is derived from the specified component's background color.

  c - the component for which the highlight may be derived - `java.awt.Component`

  returns: `java.awt.Color`"
  (^java.awt.Color [^EtchedBorder this ^java.awt.Component c]
    (-> this (.getHighlightColor c)))
  (^java.awt.Color [^EtchedBorder this]
    (-> this (.getHighlightColor))))

(defn get-shadow-color
  "Returns the shadow color of the etched border
   when rendered on the specified component.  If no shadow
   color was specified at instantiation, the shadow color
   is derived from the specified component's background color.

  c - the component for which the shadow may be derived - `java.awt.Component`

  returns: `java.awt.Color`"
  (^java.awt.Color [^EtchedBorder this ^java.awt.Component c]
    (-> this (.getShadowColor c)))
  (^java.awt.Color [^EtchedBorder this]
    (-> this (.getShadowColor))))

