(ns javax.swing.plaf.basic.BasicPopupMenuUI
  "A Windows L&F implementation of PopupMenuUI.  This implementation
  is a `combined` view/controller."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing.plaf.basic BasicPopupMenuUI]))

(defn ->basic-popup-menu-ui
  "Constructor."
  (^BasicPopupMenuUI []
    (new BasicPopupMenuUI )))

(defn *create-ui
  "x - `javax.swing.JComponent`

  returns: `javax.swing.plaf.ComponentUI`"
  (^javax.swing.plaf.ComponentUI [^javax.swing.JComponent x]
    (BasicPopupMenuUI/createUI x)))

(defn install-ui
  "Description copied from class: ComponentUI

  c - the component where this UI delegate is being installed - `javax.swing.JComponent`"
  ([^BasicPopupMenuUI this ^javax.swing.JComponent c]
    (-> this (.installUI c))))

(defn install-defaults
  ""
  ([^BasicPopupMenuUI this]
    (-> this (.installDefaults))))

(defn uninstall-ui
  "Description copied from class: ComponentUI

  c - the component from which this UI delegate is being removed; this argument is often ignored, but might be used if the UI object is stateless and shared by multiple components - `javax.swing.JComponent`"
  ([^BasicPopupMenuUI this ^javax.swing.JComponent c]
    (-> this (.uninstallUI c))))

(defn popup-trigger?
  "e - `java.awt.event.MouseEvent`

  returns: `boolean`"
  (^Boolean [^BasicPopupMenuUI this e]
    (-> this (.isPopupTrigger e))))

