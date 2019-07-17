(ns javax.swing.border.AbstractBorder
  "A class that implements an empty border with no size.
  This provides a convenient base class from which other border
  classes can be easily derived.

  Warning:
  Serialized objects of this class will not be compatible with
  future Swing releases. The current serialization support is
  appropriate for short term storage or RMI between applications running
  the same version of Swing.  As of 1.4, support for long term storage
  of all JavaBeans™
  has been added to the java.beans package.
  Please see XMLEncoder."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing.border AbstractBorder]))

(defn ->abstract-border
  "Constructor."
  ([]
    (new AbstractBorder )))

(defn *get-interior-rectangle
  "Returns a rectangle using the arguments minus the
   insets of the border. This is useful for determining the area
   that components should draw in that will not intersect the border.

  c - the component for which this border is being computed - `java.awt.Component`
  b - the Border object - `javax.swing.border.Border`
  x - the x position of the border - `int`
  y - the y position of the border - `int`
  width - the width of the border - `int`
  height - the height of the border - `int`

  returns: a Rectangle containing the interior coordinates - `java.awt.Rectangle`"
  ([^java.awt.Component c ^javax.swing.border.Border b ^Integer x ^Integer y ^Integer width ^Integer height]
    (AbstractBorder/getInteriorRectangle c b x y width height)))

(defn paint-border
  "This default implementation does no painting.

  c - the component for which this border is being painted - `java.awt.Component`
  g - the paint graphics - `java.awt.Graphics`
  x - the x position of the painted border - `int`
  y - the y position of the painted border - `int`
  width - the width of the painted border - `int`
  height - the height of the painted border - `int`"
  ([^javax.swing.border.AbstractBorder this ^java.awt.Component c ^java.awt.Graphics g ^Integer x ^Integer y ^Integer width ^Integer height]
    (-> this (.paintBorder c g x y width height))))

(defn get-border-insets
  "Reinitializes the insets parameter with this Border's current Insets.

  c - the component for which this border insets value applies - `java.awt.Component`
  insets - the object to be reinitialized - `java.awt.Insets`

  returns: the insets object - `java.awt.Insets`"
  ([^javax.swing.border.AbstractBorder this ^java.awt.Component c ^java.awt.Insets insets]
    (-> this (.getBorderInsets c insets)))
  ([^javax.swing.border.AbstractBorder this ^java.awt.Component c]
    (-> this (.getBorderInsets c))))

(defn border-opaque?
  "This default implementation returns false.

  returns: false - `boolean`"
  ([^javax.swing.border.AbstractBorder this]
    (-> this (.isBorderOpaque))))

(defn get-interior-rectangle
  "This convenience method calls the static method.

  c - the component for which this border is being computed - `java.awt.Component`
  x - the x position of the border - `int`
  y - the y position of the border - `int`
  width - the width of the border - `int`
  height - the height of the border - `int`

  returns: a Rectangle containing the interior coordinates - `java.awt.Rectangle`"
  ([^javax.swing.border.AbstractBorder this ^java.awt.Component c ^Integer x ^Integer y ^Integer width ^Integer height]
    (-> this (.getInteriorRectangle c x y width height))))

(defn get-baseline
  "Returns the baseline.  A return value less than 0 indicates the border
   does not have a reasonable baseline.

   The default implementation returns -1.  Subclasses that support
   baseline should override appropriately.  If a value >= 0 is
   returned, then the component has a valid baseline for any
   size >= the minimum size and getBaselineResizeBehavior
   can be used to determine how the baseline changes with size.

  c - Component baseline is being requested for - `java.awt.Component`
  width - the width to get the baseline for - `int`
  height - the height to get the baseline for - `int`

  returns: the baseline or < 0 indicating there is no reasonable
           baseline - `int`

  throws: java.lang.IllegalArgumentException - if width or height is < 0"
  ([^javax.swing.border.AbstractBorder this ^java.awt.Component c ^Integer width ^Integer height]
    (-> this (.getBaseline c width height))))

(defn get-baseline-resize-behavior
  "Returns an enum indicating how the baseline of a component
   changes as the size changes.  This method is primarily meant for
   layout managers and GUI builders.

   The default implementation returns
   BaselineResizeBehavior.OTHER, subclasses that support
   baseline should override appropriately.  Subclasses should
   never return null; if the baseline can not be
   calculated return BaselineResizeBehavior.OTHER.  Callers
   should first ask for the baseline using
   getBaseline and if a value >= 0 is returned use
   this method.  It is acceptable for this method to return a
   value other than BaselineResizeBehavior.OTHER even if
   getBaseline returns a value less than 0.

  c - Component to return baseline resize behavior for - `java.awt.Component`

  returns: an enum indicating how the baseline changes as the border is
           resized - `java.awt.Component.BaselineResizeBehavior`"
  ([^javax.swing.border.AbstractBorder this ^java.awt.Component c]
    (-> this (.getBaselineResizeBehavior c))))

