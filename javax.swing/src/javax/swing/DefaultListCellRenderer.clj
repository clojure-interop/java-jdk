(ns javax.swing.DefaultListCellRenderer
  "Renders an item in a list.

  Implementation Note:
  This class overrides
  invalidate,
  validate,
  revalidate,
  repaint,
  isOpaque,
  and
  firePropertyChange
  solely to improve performance.
  If not overridden, these frequently called methods would execute code paths
  that are unnecessary for the default list cell renderer.
  If you write your own renderer,
  take care to weigh the benefits and
  drawbacks of overriding these methods.



  Warning:
  Serialized objects of this class will not be compatible with
  future Swing releases. The current serialization support is
  appropriate for short term storage or RMI between applications running
  the same version of Swing.  As of 1.4, support for long term storage
  of all JavaBeans™
  has been added to the java.beans package.
  Please see XMLEncoder."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing DefaultListCellRenderer]))

(defn ->default-list-cell-renderer
  "Constructor.

  Constructs a default renderer object for an item
   in a list."
  ([]
    (new DefaultListCellRenderer )))

(defn get-list-cell-renderer-component
  "Description copied from interface: ListCellRenderer

  list - The JList we're painting. - `javax.swing.JList<?>`
  value - The value returned by list.getModel().getElementAt(index). - `java.lang.Object`
  index - The cells index. - `int`
  is-selected - True if the specified cell was selected. - `boolean`
  cell-has-focus - True if the specified cell has the focus. - `boolean`

  returns: A component whose paint() method will render the specified value. - `java.awt.Component`"
  (^java.awt.Component [^javax.swing.DefaultListCellRenderer this ^javax.swing.JList list ^java.lang.Object value ^Integer index ^Boolean is-selected ^Boolean cell-has-focus]
    (-> this (.getListCellRendererComponent list value index is-selected cell-has-focus))))

(defn opaque?
  "Overridden for performance reasons.
   See the Implementation Note
   for more information.

  returns: true if the background is completely opaque
           and differs from the JList's background;
           false otherwise - `boolean`"
  (^Boolean [^javax.swing.DefaultListCellRenderer this]
    (-> this (.isOpaque))))

(defn validate
  "Overridden for performance reasons.
   See the Implementation Note
   for more information."
  ([^javax.swing.DefaultListCellRenderer this]
    (-> this (.validate))))

(defn invalidate
  "Overridden for performance reasons.
   See the Implementation Note
   for more information."
  ([^javax.swing.DefaultListCellRenderer this]
    (-> this (.invalidate))))

(defn repaint
  "Overridden for performance reasons.
   See the Implementation Note
   for more information.

  tm - this parameter is not used - `long`
  x - the x value of the dirty region - `int`
  y - the y value of the dirty region - `int`
  width - the width of the dirty region - `int`
  height - the height of the dirty region - `int`"
  ([^javax.swing.DefaultListCellRenderer this ^Long tm ^Integer x ^Integer y ^Integer width ^Integer height]
    (-> this (.repaint tm x y width height)))
  ([^javax.swing.DefaultListCellRenderer this ^java.awt.Rectangle r]
    (-> this (.repaint r)))
  ([^javax.swing.DefaultListCellRenderer this]
    (-> this (.repaint))))

(defn revalidate
  "Overridden for performance reasons.
   See the Implementation Note
   for more information."
  ([^javax.swing.DefaultListCellRenderer this]
    (-> this (.revalidate))))

(defn fire-property-change
  "Overridden for performance reasons.
   See the Implementation Note
   for more information.

  property-name - the programmatic name of the property that was changed - `java.lang.String`
  old-value - the old value of the property (as a byte) - `byte`
  new-value - the new value of the property (as a byte) - `byte`"
  ([^javax.swing.DefaultListCellRenderer this ^java.lang.String property-name ^Byte old-value ^Byte new-value]
    (-> this (.firePropertyChange property-name old-value new-value))))

