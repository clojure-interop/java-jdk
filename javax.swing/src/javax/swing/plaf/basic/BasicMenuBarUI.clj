(ns javax.swing.plaf.basic.BasicMenuBarUI
  "A default L&F implementation of MenuBarUI.  This implementation
  is a `combined` view/controller."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing.plaf.basic BasicMenuBarUI]))

(defn ->basic-menu-bar-ui
  "Constructor."
  ([]
    (new BasicMenuBarUI )))

(defn *create-ui
  "x - `javax.swing.JComponent`

  returns: `javax.swing.plaf.ComponentUI`"
  ([x]
    (BasicMenuBarUI/createUI x)))

(defn install-ui
  "Description copied from class: ComponentUI

  c - the component where this UI delegate is being installed - `javax.swing.JComponent`"
  ([this c]
    (-> this (.installUI c))))

(defn uninstall-ui
  "Description copied from class: ComponentUI

  c - the component from which this UI delegate is being removed; this argument is often ignored, but might be used if the UI object is stateless and shared by multiple components - `javax.swing.JComponent`"
  ([this c]
    (-> this (.uninstallUI c))))

(defn get-minimum-size
  "Description copied from class: ComponentUI

  c - the component whose minimum size is being queried; this argument is often ignored, but might be used if the UI object is stateless and shared by multiple components - `javax.swing.JComponent`

  returns: a Dimension object or null - `java.awt.Dimension`"
  ([this c]
    (-> this (.getMinimumSize c))))

(defn get-maximum-size
  "Description copied from class: ComponentUI

  c - the component whose maximum size is being queried; this argument is often ignored, but might be used if the UI object is stateless and shared by multiple components - `javax.swing.JComponent`

  returns: a Dimension object or null - `java.awt.Dimension`"
  ([this c]
    (-> this (.getMaximumSize c))))

