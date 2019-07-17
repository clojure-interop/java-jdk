(ns javax.swing.border.TitledBorder
  "A class which implements an arbitrary border
  with the addition of a String title in a
  specified position and justification.

  If the border, font, or color property values are not
  specified in the constructor or by invoking the appropriate
  set methods, the property values will be defined by the current
  look and feel, using the following property names in the
  Defaults Table:

  `TitledBorder.border`
  `TitledBorder.font`
  `TitledBorder.titleColor`


  Warning:
  Serialized objects of this class will not be compatible with
  future Swing releases. The current serialization support is
  appropriate for short term storage or RMI between applications running
  the same version of Swing.  As of 1.4, support for long term storage
  of all JavaBeans™
  has been added to the java.beans package.
  Please see XMLEncoder."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing.border TitledBorder]))

(defn ->titled-border
  "Constructor.

  Creates a TitledBorder instance with the specified border,
   title, title-justification, title-position, title-font, and
   title-color.

  border - the border - `javax.swing.border.Border`
  title - the title the border should display - `java.lang.String`
  title-justification - the justification for the title - `int`
  title-position - the position for the title - `int`
  title-font - the font of the title - `java.awt.Font`
  title-color - the color of the title - `java.awt.Color`"
  ([^javax.swing.border.Border border ^java.lang.String title ^Integer title-justification ^Integer title-position ^java.awt.Font title-font ^java.awt.Color title-color]
    (new TitledBorder border title title-justification title-position title-font title-color))
  ([^javax.swing.border.Border border ^java.lang.String title ^Integer title-justification ^Integer title-position ^java.awt.Font title-font]
    (new TitledBorder border title title-justification title-position title-font))
  ([^javax.swing.border.Border border ^java.lang.String title ^Integer title-justification ^Integer title-position]
    (new TitledBorder border title title-justification title-position))
  ([^javax.swing.border.Border border ^java.lang.String title]
    (new TitledBorder border title))
  ([^java.lang.String title]
    (new TitledBorder title)))

(def *-default-position
  "Static Constant.

  Use the default vertical orientation for the title text.

  type: int"
  TitledBorder/DEFAULT_POSITION)

(def *-above-top
  "Static Constant.

  Position the title above the border's top line.

  type: int"
  TitledBorder/ABOVE_TOP)

(def *-top
  "Static Constant.

  Position the title in the middle of the border's top line.

  type: int"
  TitledBorder/TOP)

(def *-below-top
  "Static Constant.

  Position the title below the border's top line.

  type: int"
  TitledBorder/BELOW_TOP)

(def *-above-bottom
  "Static Constant.

  Position the title above the border's bottom line.

  type: int"
  TitledBorder/ABOVE_BOTTOM)

(def *-bottom
  "Static Constant.

  Position the title in the middle of the border's bottom line.

  type: int"
  TitledBorder/BOTTOM)

(def *-below-bottom
  "Static Constant.

  Position the title below the border's bottom line.

  type: int"
  TitledBorder/BELOW_BOTTOM)

(def *-default-justification
  "Static Constant.

  Use the default justification for the title text.

  type: int"
  TitledBorder/DEFAULT_JUSTIFICATION)

(def *-left
  "Static Constant.

  Position title text at the left side of the border line.

  type: int"
  TitledBorder/LEFT)

(def *-center
  "Static Constant.

  Position title text in the center of the border line.

  type: int"
  TitledBorder/CENTER)

(def *-right
  "Static Constant.

  Position title text at the right side of the border line.

  type: int"
  TitledBorder/RIGHT)

(def *-leading
  "Static Constant.

  Position title text at the left side of the border line
    for left to right orientation, at the right side of the
    border line for right to left orientation.

  type: int"
  TitledBorder/LEADING)

(def *-trailing
  "Static Constant.

  Position title text at the right side of the border line
    for left to right orientation, at the left side of the
    border line for right to left orientation.

  type: int"
  TitledBorder/TRAILING)

(defn get-minimum-size
  "Returns the minimum dimensions this border requires
   in order to fully display the border and title.

  c - the component where this border will be drawn - `java.awt.Component`

  returns: the Dimension object - `java.awt.Dimension`"
  ([^javax.swing.border.TitledBorder this ^java.awt.Component c]
    (-> this (.getMinimumSize c))))

(defn set-title-position
  "Sets the title-position of the titled border.

  title-position - the position for the border - `int`"
  ([^javax.swing.border.TitledBorder this ^Integer title-position]
    (-> this (.setTitlePosition title-position))))

(defn paint-border
  "Paints the border for the specified component with the
   specified position and size.

  c - the component for which this border is being painted - `java.awt.Component`
  g - the paint graphics - `java.awt.Graphics`
  x - the x position of the painted border - `int`
  y - the y position of the painted border - `int`
  width - the width of the painted border - `int`
  height - the height of the painted border - `int`"
  ([^javax.swing.border.TitledBorder this ^java.awt.Component c ^java.awt.Graphics g ^Integer x ^Integer y ^Integer width ^Integer height]
    (-> this (.paintBorder c g x y width height))))

(defn set-title-justification
  "Sets the title-justification of the titled border.

  title-justification - the justification for the border - `int`"
  ([^javax.swing.border.TitledBorder this ^Integer title-justification]
    (-> this (.setTitleJustification title-justification))))

(defn get-border
  "Returns the border of the titled border.

  returns: the border of the titled border - `javax.swing.border.Border`"
  ([^javax.swing.border.TitledBorder this]
    (-> this (.getBorder))))

(defn set-title-color
  "Sets the title-color of the titled border.

  title-color - the color for the border title - `java.awt.Color`"
  ([^javax.swing.border.TitledBorder this ^java.awt.Color title-color]
    (-> this (.setTitleColor title-color))))

(defn get-baseline-resize-behavior
  "Returns an enum indicating how the baseline of the border
   changes as the size changes.

  c - Component to return baseline resize behavior for - `java.awt.Component`

  returns: an enum indicating how the baseline changes as the border is
           resized - `java.awt.Component.BaselineResizeBehavior`

  throws: java.lang.NullPointerException"
  ([^javax.swing.border.TitledBorder this ^java.awt.Component c]
    (-> this (.getBaselineResizeBehavior c))))

(defn get-border-insets
  "Reinitialize the insets parameter with this Border's current Insets.

  c - the component for which this border insets value applies - `java.awt.Component`
  insets - the object to be reinitialized - `java.awt.Insets`

  returns: the insets object - `java.awt.Insets`"
  ([^javax.swing.border.TitledBorder this ^java.awt.Component c ^java.awt.Insets insets]
    (-> this (.getBorderInsets c insets))))

(defn get-title-justification
  "Returns the title-justification of the titled border.

  returns: the title-justification of the titled border - `int`"
  ([^javax.swing.border.TitledBorder this]
    (-> this (.getTitleJustification))))

(defn get-title-color
  "Returns the title-color of the titled border.

  returns: the title-color of the titled border - `java.awt.Color`"
  ([^javax.swing.border.TitledBorder this]
    (-> this (.getTitleColor))))

(defn get-title-font
  "Returns the title-font of the titled border.

  returns: the title-font of the titled border - `java.awt.Font`"
  ([^javax.swing.border.TitledBorder this]
    (-> this (.getTitleFont))))

(defn set-title-font
  "Sets the title-font of the titled border.

  title-font - the font for the border title - `java.awt.Font`"
  ([^javax.swing.border.TitledBorder this ^java.awt.Font title-font]
    (-> this (.setTitleFont title-font))))

(defn get-title-position
  "Returns the title-position of the titled border.

  returns: the title-position of the titled border - `int`"
  ([^javax.swing.border.TitledBorder this]
    (-> this (.getTitlePosition))))

(defn border-opaque?
  "Returns whether or not the border is opaque.

  returns: false - `boolean`"
  ([^javax.swing.border.TitledBorder this]
    (-> this (.isBorderOpaque))))

(defn set-border
  "Sets the border of the titled border.

  border - the border - `javax.swing.border.Border`"
  ([^javax.swing.border.TitledBorder this ^javax.swing.border.Border border]
    (-> this (.setBorder border))))

(defn get-baseline
  "Returns the baseline.

  c - Component baseline is being requested for - `java.awt.Component`
  width - the width to get the baseline for - `int`
  height - the height to get the baseline for - `int`

  returns: the baseline or < 0 indicating there is no reasonable
           baseline - `int`

  throws: java.lang.NullPointerException"
  ([^javax.swing.border.TitledBorder this ^java.awt.Component c ^Integer width ^Integer height]
    (-> this (.getBaseline c width height))))

(defn get-title
  "Returns the title of the titled border.

  returns: the title of the titled border - `java.lang.String`"
  ([^javax.swing.border.TitledBorder this]
    (-> this (.getTitle))))

(defn set-title
  "Sets the title of the titled border.

  title - the title for the border - `java.lang.String`"
  ([^javax.swing.border.TitledBorder this ^java.lang.String title]
    (-> this (.setTitle title))))

