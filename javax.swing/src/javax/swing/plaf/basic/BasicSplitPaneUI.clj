(ns javax.swing.plaf.basic.BasicSplitPaneUI
  "A Basic L&F implementation of the SplitPaneUI."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing.plaf.basic BasicSplitPaneUI]))

(defn ->basic-split-pane-ui
  "Constructor."
  ([]
    (new BasicSplitPaneUI )))

(defn *create-ui
  "Creates a new BasicSplitPaneUI instance

  x - `javax.swing.JComponent`

  returns: `javax.swing.plaf.ComponentUI`"
  (^javax.swing.plaf.ComponentUI [^javax.swing.JComponent x]
    (BasicSplitPaneUI/createUI x)))

(defn install-ui
  "Installs the UI.

  c - the component where this UI delegate is being installed - `javax.swing.JComponent`"
  ([^javax.swing.plaf.basic.BasicSplitPaneUI this ^javax.swing.JComponent c]
    (-> this (.installUI c))))

(defn get-minimum-size
  "Returns the minimum size for the passed in component,
   This is passed off to the current layout manager.

  jc - the component whose minimum size is being queried; this argument is often ignored, but might be used if the UI object is stateless and shared by multiple components - `javax.swing.JComponent`

  returns: a Dimension object or null - `java.awt.Dimension`"
  (^java.awt.Dimension [^javax.swing.plaf.basic.BasicSplitPaneUI this ^javax.swing.JComponent jc]
    (-> this (.getMinimumSize jc))))

(defn get-orientation
  "Returns the orientation for the JSplitPane.

  returns: `int`"
  (^Integer [^javax.swing.plaf.basic.BasicSplitPaneUI this]
    (-> this (.getOrientation))))

(defn get-divider-location
  "Returns the location of the divider, which may differ from what
   the splitpane thinks the location of the divider is.

  jc - `javax.swing.JSplitPane`

  returns: `int`"
  (^Integer [^javax.swing.plaf.basic.BasicSplitPaneUI this ^javax.swing.JSplitPane jc]
    (-> this (.getDividerLocation jc))))

(defn get-maximum-size
  "Returns the maximum size for the passed in component,
   This is passed off to the current layout manager.

  jc - the component whose maximum size is being queried; this argument is often ignored, but might be used if the UI object is stateless and shared by multiple components - `javax.swing.JComponent`

  returns: a Dimension object or null - `java.awt.Dimension`"
  (^java.awt.Dimension [^javax.swing.plaf.basic.BasicSplitPaneUI this ^javax.swing.JComponent jc]
    (-> this (.getMaximumSize jc))))

(defn get-maximum-divider-location
  "Gets the maximum location of the divider.

  jc - `javax.swing.JSplitPane`

  returns: `int`"
  (^Integer [^javax.swing.plaf.basic.BasicSplitPaneUI this ^javax.swing.JSplitPane jc]
    (-> this (.getMaximumDividerLocation jc))))

(defn set-divider-location
  "Sets the location of the divider to location.

  jc - `javax.swing.JSplitPane`
  location - `int`"
  ([^javax.swing.plaf.basic.BasicSplitPaneUI this ^javax.swing.JSplitPane jc ^Integer location]
    (-> this (.setDividerLocation jc location))))

(defn get-insets
  "Returns the insets. The insets are returned from the border insets
   of the current border.

  jc - `javax.swing.JComponent`

  returns: `java.awt.Insets`"
  (^java.awt.Insets [^javax.swing.plaf.basic.BasicSplitPaneUI this ^javax.swing.JComponent jc]
    (-> this (.getInsets jc))))

(defn set-last-drag-location
  "Set the last drag location of the JSplitPane.

  l - `int`"
  ([^javax.swing.plaf.basic.BasicSplitPaneUI this ^Integer l]
    (-> this (.setLastDragLocation l))))

(defn uninstall-ui
  "Uninstalls the UI.

  c - the component from which this UI delegate is being removed; this argument is often ignored, but might be used if the UI object is stateless and shared by multiple components - `javax.swing.JComponent`"
  ([^javax.swing.plaf.basic.BasicSplitPaneUI this ^javax.swing.JComponent c]
    (-> this (.uninstallUI c))))

(defn get-split-pane
  "Returns the splitpane this instance is currently contained
   in.

  returns: `javax.swing.JSplitPane`"
  (^javax.swing.JSplitPane [^javax.swing.plaf.basic.BasicSplitPaneUI this]
    (-> this (.getSplitPane))))

(defn reset-to-preferred-sizes
  "Messaged to reset the preferred sizes.

  jc - `javax.swing.JSplitPane`"
  ([^javax.swing.plaf.basic.BasicSplitPaneUI this ^javax.swing.JSplitPane jc]
    (-> this (.resetToPreferredSizes jc))))

(defn finished-painting-children
  "Called when the specified split pane has finished painting
   its children.

  sp - `javax.swing.JSplitPane`
  g - `java.awt.Graphics`"
  ([^javax.swing.plaf.basic.BasicSplitPaneUI this ^javax.swing.JSplitPane sp ^java.awt.Graphics g]
    (-> this (.finishedPaintingChildren sp g))))

(defn get-divider
  "Returns the divider between the top Components.

  returns: `javax.swing.plaf.basic.BasicSplitPaneDivider`"
  (^javax.swing.plaf.basic.BasicSplitPaneDivider [^javax.swing.plaf.basic.BasicSplitPaneUI this]
    (-> this (.getDivider))))

(defn get-minimum-divider-location
  "Gets the minimum location of the divider.

  jc - `javax.swing.JSplitPane`

  returns: `int`"
  (^Integer [^javax.swing.plaf.basic.BasicSplitPaneUI this ^javax.swing.JSplitPane jc]
    (-> this (.getMinimumDividerLocation jc))))

(defn paint
  "Paints the specified component appropriately for the look and feel.
   This method is invoked from the ComponentUI.update method when
   the specified component is being painted.  Subclasses should override
   this method and use the specified Graphics object to
   render the content of the component.

  g - the Graphics context in which to paint - `java.awt.Graphics`
  jc - the component being painted; this argument is often ignored, but might be used if the UI object is stateless and shared by multiple components - `javax.swing.JComponent`"
  ([^javax.swing.plaf.basic.BasicSplitPaneUI this ^java.awt.Graphics g ^javax.swing.JComponent jc]
    (-> this (.paint g jc))))

(defn set-orientation
  "Set the orientation for the JSplitPane.

  orientation - `int`"
  ([^javax.swing.plaf.basic.BasicSplitPaneUI this ^Integer orientation]
    (-> this (.setOrientation orientation))))

(defn get-last-drag-location
  "Returns the last drag location of the JSplitPane.

  returns: `int`"
  (^Integer [^javax.swing.plaf.basic.BasicSplitPaneUI this]
    (-> this (.getLastDragLocation))))

(defn set-continuous-layout
  "Turn continuous layout on/off.

  b - `boolean`"
  ([^javax.swing.plaf.basic.BasicSplitPaneUI this ^Boolean b]
    (-> this (.setContinuousLayout b))))

(defn continuous-layout?
  "Determines whether the JSplitPane is set to use a continuous layout.

  returns: `boolean`"
  (^Boolean [^javax.swing.plaf.basic.BasicSplitPaneUI this]
    (-> this (.isContinuousLayout))))

(defn create-default-divider
  "Creates the default divider.

  returns: `javax.swing.plaf.basic.BasicSplitPaneDivider`"
  (^javax.swing.plaf.basic.BasicSplitPaneDivider [^javax.swing.plaf.basic.BasicSplitPaneUI this]
    (-> this (.createDefaultDivider))))

(defn get-preferred-size
  "Returns the preferred size for the passed in component,
   This is passed off to the current layout manager.

  jc - the component whose preferred size is being queried; this argument is often ignored, but might be used if the UI object is stateless and shared by multiple components - `javax.swing.JComponent`

  returns: `java.awt.Dimension`"
  (^java.awt.Dimension [^javax.swing.plaf.basic.BasicSplitPaneUI this ^javax.swing.JComponent jc]
    (-> this (.getPreferredSize jc))))

(defn get-non-continuous-layout-divider
  "Returns the divider to use when the splitPane is configured to
   not continuously layout. This divider will only be used during a
   dragging session.

  returns: `java.awt.Component`"
  (^java.awt.Component [^javax.swing.plaf.basic.BasicSplitPaneUI this]
    (-> this (.getNonContinuousLayoutDivider))))

