(ns javax.swing.plaf.basic.BasicMenuUI
  "A default L&F implementation of MenuUI.  This implementation
  is a `combined` view/controller."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing.plaf.basic BasicMenuUI]))

(defn ->basic-menu-ui
  "Constructor."
  (^BasicMenuUI []
    (new BasicMenuUI )))

(defn *create-ui
  "x - `javax.swing.JComponent`

  returns: `javax.swing.plaf.ComponentUI`"
  (^javax.swing.plaf.ComponentUI [^javax.swing.JComponent x]
    (BasicMenuUI/createUI x)))

(defn get-maximum-size
  "Description copied from class: ComponentUI

  c - the component whose maximum size is being queried; this argument is often ignored, but might be used if the UI object is stateless and shared by multiple components - `javax.swing.JComponent`

  returns: a Dimension object or null - `java.awt.Dimension`"
  (^java.awt.Dimension [^BasicMenuUI this ^javax.swing.JComponent c]
    (-> this (.getMaximumSize c))))

