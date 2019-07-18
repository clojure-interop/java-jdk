(ns javax.swing.plaf.basic.BasicScrollBarUI
  "Implementation of ScrollBarUI for the Basic Look and Feel"
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing.plaf.basic BasicScrollBarUI]))

(defn ->basic-scroll-bar-ui
  "Constructor."
  (^BasicScrollBarUI []
    (new BasicScrollBarUI )))

(defn *create-ui
  "c - `javax.swing.JComponent`

  returns: `javax.swing.plaf.ComponentUI`"
  (^javax.swing.plaf.ComponentUI [^javax.swing.JComponent c]
    (BasicScrollBarUI/createUI c)))

(defn install-ui
  "Description copied from class: ComponentUI

  c - the component where this UI delegate is being installed - `javax.swing.JComponent`"
  ([^BasicScrollBarUI this ^javax.swing.JComponent c]
    (-> this (.installUI c))))

(defn get-maximum-size
  "Description copied from class: ComponentUI

  c - The JScrollBar that's delegating this method to us. - `javax.swing.JComponent`

  returns: new Dimension(Integer.MAX_VALUE, Integer.MAX_VALUE); - `java.awt.Dimension`"
  (^java.awt.Dimension [^BasicScrollBarUI this ^javax.swing.JComponent c]
    (-> this (.getMaximumSize c))))

(defn thumb-rollover?
  "Returns true if the mouse is currently over the thumb.

  returns: true if the thumb is currently active - `boolean`"
  (^Boolean [^BasicScrollBarUI this]
    (-> this (.isThumbRollover))))

(defn uninstall-ui
  "Description copied from class: ComponentUI

  c - the component from which this UI delegate is being removed; this argument is often ignored, but might be used if the UI object is stateless and shared by multiple components - `javax.swing.JComponent`"
  ([^BasicScrollBarUI this ^javax.swing.JComponent c]
    (-> this (.uninstallUI c))))

(defn get-supports-absolute-positioning?
  "Indicates whether the user can absolutely position the thumb with
   a mouse gesture (usually the middle mouse button).

  returns: true if a mouse gesture can absolutely position the thumb - `boolean`"
  (^Boolean [^BasicScrollBarUI this]
    (-> this (.getSupportsAbsolutePositioning))))

(defn preferred-layout-size
  "Description copied from interface: LayoutManager

  scrollbar-container - the container to be laid out - `java.awt.Container`

  returns: `java.awt.Dimension`"
  (^java.awt.Dimension [^BasicScrollBarUI this ^java.awt.Container scrollbar-container]
    (-> this (.preferredLayoutSize scrollbar-container))))

(defn minimum-layout-size
  "Description copied from interface: LayoutManager

  scrollbar-container - the component to be laid out - `java.awt.Container`

  returns: `java.awt.Dimension`"
  (^java.awt.Dimension [^BasicScrollBarUI this ^java.awt.Container scrollbar-container]
    (-> this (.minimumLayoutSize scrollbar-container))))

(defn paint
  "Description copied from class: ComponentUI

  g - the Graphics context in which to paint - `java.awt.Graphics`
  c - the component being painted; this argument is often ignored, but might be used if the UI object is stateless and shared by multiple components - `javax.swing.JComponent`"
  ([^BasicScrollBarUI this ^java.awt.Graphics g ^javax.swing.JComponent c]
    (-> this (.paint g c))))

(defn add-layout-component
  "Description copied from interface: LayoutManager

  name - the string to be associated with the component - `java.lang.String`
  child - the component to be added - `java.awt.Component`"
  ([^BasicScrollBarUI this ^java.lang.String name ^java.awt.Component child]
    (-> this (.addLayoutComponent name child))))

(defn remove-layout-component
  "Description copied from interface: LayoutManager

  child - the component to be removed - `java.awt.Component`"
  ([^BasicScrollBarUI this ^java.awt.Component child]
    (-> this (.removeLayoutComponent child))))

(defn layout-container
  "Description copied from interface: LayoutManager

  scrollbar-container - the container to be laid out - `java.awt.Container`"
  ([^BasicScrollBarUI this ^java.awt.Container scrollbar-container]
    (-> this (.layoutContainer scrollbar-container))))

(defn get-preferred-size
  "A vertical scrollbar's preferred width is the maximum of
   preferred widths of the (non null)
   increment/decrement buttons,
   and the minimum width of the thumb. The preferred height is the
   sum of the preferred heights of the same parts.  The basis for
   the preferred size of a horizontal scrollbar is similar.

   The preferredSize is only computed once, subsequent
   calls to this method just return a cached size.

  c - the JScrollBar that's delegating this method to us - `javax.swing.JComponent`

  returns: the preferred size of a Basic JScrollBar - `java.awt.Dimension`"
  (^java.awt.Dimension [^BasicScrollBarUI this ^javax.swing.JComponent c]
    (-> this (.getPreferredSize c))))

