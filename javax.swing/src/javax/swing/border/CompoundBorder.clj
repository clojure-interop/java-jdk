(ns javax.swing.border.CompoundBorder
  "A composite Border class used to compose two Border objects
  into a single border by nesting an inside Border object within
  the insets of an outside Border object.

  For example, this class may be used to add blank margin space
  to a component with an existing decorative border:



     Border border = comp.getBorder();
     Border margin = new EmptyBorder(10,10,10,10);
     comp.setBorder(new CompoundBorder(border, margin));

  Warning:
  Serialized objects of this class will not be compatible with
  future Swing releases. The current serialization support is
  appropriate for short term storage or RMI between applications running
  the same version of Swing.  As of 1.4, support for long term storage
  of all JavaBeans™
  has been added to the java.beans package.
  Please see XMLEncoder."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing.border CompoundBorder]))

(defn ->compound-border
  "Constructor.

  Creates a compound border with the specified outside and
   inside borders.  Either border may be null.

  outside-border - the outside border - `javax.swing.border.Border`
  inside-border - the inside border to be nested - `javax.swing.border.Border`"
  ([^javax.swing.border.Border outside-border ^javax.swing.border.Border inside-border]
    (new CompoundBorder outside-border inside-border))
  ([]
    (new CompoundBorder )))

(defn border-opaque?
  "Returns whether or not the compound border is opaque.

  returns: true if the inside and outside borders
           are each either null or opaque;
           or false otherwise - `boolean`"
  (^Boolean [^javax.swing.border.CompoundBorder this]
    (-> this (.isBorderOpaque))))

(defn paint-border
  "Paints the compound border by painting the outside border
   with the specified position and size and then painting the
   inside border at the specified position and size offset by
   the insets of the outside border.

  c - the component for which this border is being painted - `java.awt.Component`
  g - the paint graphics - `java.awt.Graphics`
  x - the x position of the painted border - `int`
  y - the y position of the painted border - `int`
  width - the width of the painted border - `int`
  height - the height of the painted border - `int`"
  ([^javax.swing.border.CompoundBorder this ^java.awt.Component c ^java.awt.Graphics g ^Integer x ^Integer y ^Integer width ^Integer height]
    (-> this (.paintBorder c g x y width height))))

(defn get-border-insets
  "Reinitialize the insets parameter with this Border's current Insets.

  c - the component for which this border insets value applies - `java.awt.Component`
  insets - the object to be reinitialized - `java.awt.Insets`

  returns: the insets object - `java.awt.Insets`"
  (^java.awt.Insets [^javax.swing.border.CompoundBorder this ^java.awt.Component c ^java.awt.Insets insets]
    (-> this (.getBorderInsets c insets))))

(defn get-outside-border
  "Returns the outside border object.

  returns: `javax.swing.border.Border`"
  (^javax.swing.border.Border [^javax.swing.border.CompoundBorder this]
    (-> this (.getOutsideBorder))))

(defn get-inside-border
  "Returns the inside border object.

  returns: `javax.swing.border.Border`"
  (^javax.swing.border.Border [^javax.swing.border.CompoundBorder this]
    (-> this (.getInsideBorder))))

