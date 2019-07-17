(ns javax.swing.plaf.basic.BasicTabbedPaneUI
  "A Basic L&F implementation of TabbedPaneUI."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing.plaf.basic BasicTabbedPaneUI]))

(defn ->basic-tabbed-pane-ui
  "Constructor."
  ([]
    (new BasicTabbedPaneUI )))

(defn *create-ui
  "c - `javax.swing.JComponent`

  returns: `javax.swing.plaf.ComponentUI`"
  ([^javax.swing.JComponent c]
    (BasicTabbedPaneUI/createUI c)))

(defn install-ui
  "Description copied from class: ComponentUI

  c - the component where this UI delegate is being installed - `javax.swing.JComponent`"
  ([^javax.swing.plaf.basic.BasicTabbedPaneUI this ^javax.swing.JComponent c]
    (-> this (.installUI c))))

(defn get-minimum-size
  "Description copied from class: ComponentUI

  c - the component whose minimum size is being queried; this argument is often ignored, but might be used if the UI object is stateless and shared by multiple components - `javax.swing.JComponent`

  returns: a Dimension object or null - `java.awt.Dimension`"
  ([^javax.swing.plaf.basic.BasicTabbedPaneUI this ^javax.swing.JComponent c]
    (-> this (.getMinimumSize c))))

(defn get-maximum-size
  "Description copied from class: ComponentUI

  c - the component whose maximum size is being queried; this argument is often ignored, but might be used if the UI object is stateless and shared by multiple components - `javax.swing.JComponent`

  returns: a Dimension object or null - `java.awt.Dimension`"
  ([^javax.swing.plaf.basic.BasicTabbedPaneUI this ^javax.swing.JComponent c]
    (-> this (.getMaximumSize c))))

(defn get-tab-run-count
  "pane - `javax.swing.JTabbedPane`

  returns: `int`"
  ([^javax.swing.plaf.basic.BasicTabbedPaneUI this ^javax.swing.JTabbedPane pane]
    (-> this (.getTabRunCount pane))))

(defn uninstall-ui
  "Description copied from class: ComponentUI

  c - the component from which this UI delegate is being removed; this argument is often ignored, but might be used if the UI object is stateless and shared by multiple components - `javax.swing.JComponent`"
  ([^javax.swing.plaf.basic.BasicTabbedPaneUI this ^javax.swing.JComponent c]
    (-> this (.uninstallUI c))))

(defn get-baseline-resize-behavior
  "Returns an enum indicating how the baseline of the component
   changes as the size changes.

  c - JComponent to return baseline resize behavior for - `javax.swing.JComponent`

  returns: an enum indicating how the baseline changes as the component
           size changes - `java.awt.Component.BaselineResizeBehavior`

  throws: java.lang.NullPointerException - if c is null"
  ([^javax.swing.plaf.basic.BasicTabbedPaneUI this ^javax.swing.JComponent c]
    (-> this (.getBaselineResizeBehavior c))))

(defn tab-for-coordinate
  "Returns the tab index which intersects the specified point
   in the JTabbedPane's coordinate space.

  pane - `javax.swing.JTabbedPane`
  x - `int`
  y - `int`

  returns: `int`"
  ([^javax.swing.plaf.basic.BasicTabbedPaneUI this ^javax.swing.JTabbedPane pane ^Integer x ^Integer y]
    (-> this (.tabForCoordinate pane x y))))

(defn paint
  "Description copied from class: ComponentUI

  g - the Graphics context in which to paint - `java.awt.Graphics`
  c - the component being painted; this argument is often ignored, but might be used if the UI object is stateless and shared by multiple components - `javax.swing.JComponent`"
  ([^javax.swing.plaf.basic.BasicTabbedPaneUI this ^java.awt.Graphics g ^javax.swing.JComponent c]
    (-> this (.paint g c))))

(defn get-tab-bounds
  "Returns the bounds of the specified tab index.  The bounds are
   with respect to the JTabbedPane's coordinate space.

  pane - `javax.swing.JTabbedPane`
  i - `int`

  returns: `java.awt.Rectangle`"
  ([^javax.swing.plaf.basic.BasicTabbedPaneUI this ^javax.swing.JTabbedPane pane ^Integer i]
    (-> this (.getTabBounds pane i))))

(defn get-baseline
  "Returns the baseline.

  c - JComponent baseline is being requested for - `javax.swing.JComponent`
  width - the width to get the baseline for - `int`
  height - the height to get the baseline for - `int`

  returns: baseline or a value < 0 indicating there is no reasonable
                    baseline - `int`

  throws: java.lang.NullPointerException - if c is null"
  ([^javax.swing.plaf.basic.BasicTabbedPaneUI this ^javax.swing.JComponent c ^Integer width ^Integer height]
    (-> this (.getBaseline c width height))))

