(ns javax.swing.plaf.basic.BasicScrollPaneUI
  "A default L&F implementation of ScrollPaneUI."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing.plaf.basic BasicScrollPaneUI]))

(defn ->basic-scroll-pane-ui
  "Constructor."
  ([]
    (new BasicScrollPaneUI )))

(defn *create-ui
  "x - `javax.swing.JComponent`

  returns: `javax.swing.plaf.ComponentUI`"
  (^javax.swing.plaf.ComponentUI [^javax.swing.JComponent x]
    (BasicScrollPaneUI/createUI x)))

(defn paint
  "Description copied from class: ComponentUI

  g - the Graphics context in which to paint - `java.awt.Graphics`
  c - the component being painted; this argument is often ignored, but might be used if the UI object is stateless and shared by multiple components - `javax.swing.JComponent`"
  ([^javax.swing.plaf.basic.BasicScrollPaneUI this ^java.awt.Graphics g ^javax.swing.JComponent c]
    (-> this (.paint g c))))

(defn get-maximum-size
  "Description copied from class: ComponentUI

  c - the component whose maximum size is being queried; this argument is often ignored, but might be used if the UI object is stateless and shared by multiple components - `javax.swing.JComponent`

  returns: new Dimension(Short.MAX_VALUE, Short.MAX_VALUE) - `java.awt.Dimension`"
  (^java.awt.Dimension [^javax.swing.plaf.basic.BasicScrollPaneUI this ^javax.swing.JComponent c]
    (-> this (.getMaximumSize c))))

(defn install-ui
  "Description copied from class: ComponentUI

  x - the component where this UI delegate is being installed - `javax.swing.JComponent`"
  ([^javax.swing.plaf.basic.BasicScrollPaneUI this ^javax.swing.JComponent x]
    (-> this (.installUI x))))

(defn uninstall-ui
  "Description copied from class: ComponentUI

  c - the component from which this UI delegate is being removed; this argument is often ignored, but might be used if the UI object is stateless and shared by multiple components - `javax.swing.JComponent`"
  ([^javax.swing.plaf.basic.BasicScrollPaneUI this ^javax.swing.JComponent c]
    (-> this (.uninstallUI c))))

(defn get-baseline
  "Returns the baseline.

  c - JComponent baseline is being requested for - `javax.swing.JComponent`
  width - the width to get the baseline for - `int`
  height - the height to get the baseline for - `int`

  returns: baseline or a value < 0 indicating there is no reasonable
                    baseline - `int`

  throws: java.lang.NullPointerException - if c is null"
  (^Integer [^javax.swing.plaf.basic.BasicScrollPaneUI this ^javax.swing.JComponent c ^Integer width ^Integer height]
    (-> this (.getBaseline c width height))))

(defn get-baseline-resize-behavior
  "Returns an enum indicating how the baseline of the component
   changes as the size changes.

  c - JComponent to return baseline resize behavior for - `javax.swing.JComponent`

  returns: an enum indicating how the baseline changes as the component
           size changes - `java.awt.Component.BaselineResizeBehavior`

  throws: java.lang.NullPointerException - if c is null"
  (^java.awt.Component.BaselineResizeBehavior [^javax.swing.plaf.basic.BasicScrollPaneUI this ^javax.swing.JComponent c]
    (-> this (.getBaselineResizeBehavior c))))

