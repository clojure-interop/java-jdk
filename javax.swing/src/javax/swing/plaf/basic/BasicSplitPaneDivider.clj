(ns javax.swing.plaf.basic.BasicSplitPaneDivider
  "Divider used by BasicSplitPaneUI. Subclassers may wish to override
  paint to do something more interesting.
  The border effect is drawn in BasicSplitPaneUI, so if you don't like
  that border, reset it there.
  To conditionally drag from certain areas subclass mousePressed and
  call super when you wish the dragging to begin.

  Warning:
  Serialized objects of this class will not be compatible with
  future Swing releases. The current serialization support is
  appropriate for short term storage or RMI between applications running
  the same version of Swing.  As of 1.4, support for long term storage
  of all JavaBeans™
  has been added to the java.beans package.
  Please see XMLEncoder."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing.plaf.basic BasicSplitPaneDivider]))

(defn ->basic-split-pane-divider
  "Constructor.

  Creates an instance of BasicSplitPaneDivider. Registers this
   instance for mouse events and mouse dragged events.

  ui - `javax.swing.plaf.basic.BasicSplitPaneUI`"
  ([ui]
    (new BasicSplitPaneDivider ui)))

(defn get-minimum-size
  "Returns dividerSize x dividerSize

  returns: an instance of Dimension that represents
                  the minimum size of this container. - `java.awt.Dimension`"
  ([this]
    (-> this (.getMinimumSize))))

(defn set-divider-size
  "Sets the size of the divider to newSize. That is
   the width if the splitpane is HORIZONTAL_SPLIT, or
   the height of VERTICAL_SPLIT.

  new-size - `int`"
  ([this new-size]
    (-> this (.setDividerSize new-size))))

(defn get-insets
  "If a border has been set on this component, returns the
   border's insets, else calls super.getInsets.

  returns: the value of the insets property. - `java.awt.Insets`"
  ([this]
    (-> this (.getInsets))))

(defn set-basic-split-pane-ui
  "Sets the SplitPaneUI that is using the receiver.

  new-ui - `javax.swing.plaf.basic.BasicSplitPaneUI`"
  ([this new-ui]
    (-> this (.setBasicSplitPaneUI new-ui))))

(defn get-border
  "Returns the border of this component or null if no border is
   currently set.

  returns: the border object for this component - `javax.swing.border.Border`"
  ([this]
    (-> this (.getBorder))))

(defn property-change
  "Property change event, presumably from the JSplitPane, will message
   updateOrientation if necessary.

  e - A PropertyChangeEvent object describing the event source and the property that has changed. - `java.beans.PropertyChangeEvent`"
  ([this e]
    (-> this (.propertyChange e))))

(defn get-divider-size
  "Returns the size of the divider, that is the width if the splitpane
   is HORIZONTAL_SPLIT, or the height of VERTICAL_SPLIT.

  returns: `int`"
  ([this]
    (-> this (.getDividerSize))))

(defn mouse-over?
  "Returns whether or not the mouse is currently over the divider

  returns: whether or not the mouse is currently over the divider - `boolean`"
  ([this]
    (-> this (.isMouseOver))))

(defn paint
  "Paints the divider.

  g - the specified Graphics window - `java.awt.Graphics`"
  ([this g]
    (-> this (.paint g))))

(defn get-basic-split-pane-ui
  "Returns the SplitPaneUI the receiver is currently
   in.

  returns: `javax.swing.plaf.basic.BasicSplitPaneUI`"
  ([this]
    (-> this (.getBasicSplitPaneUI))))

(defn set-border
  "Sets the border of this component.

  border - `javax.swing.border.Border`"
  ([this border]
    (-> this (.setBorder border))))

(defn get-preferred-size
  "Returns dividerSize x dividerSize

  returns: an instance of Dimension that represents
                  the preferred size of this container. - `java.awt.Dimension`"
  ([this]
    (-> this (.getPreferredSize))))

