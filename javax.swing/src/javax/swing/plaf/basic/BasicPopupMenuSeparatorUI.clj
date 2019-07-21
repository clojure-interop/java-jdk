(ns javax.swing.plaf.basic.BasicPopupMenuSeparatorUI
  "A Basic L&F implementation of PopupMenuSeparatorUI.  This implementation
  is a \"combined\" view/controller."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing.plaf.basic BasicPopupMenuSeparatorUI]))

(defn ->basic-popup-menu-separator-ui
  "Constructor."
  (^BasicPopupMenuSeparatorUI []
    (new BasicPopupMenuSeparatorUI )))

(defn *create-ui
  "c - `javax.swing.JComponent`

  returns: `javax.swing.plaf.ComponentUI`"
  (^javax.swing.plaf.ComponentUI [^javax.swing.JComponent c]
    (BasicPopupMenuSeparatorUI/createUI c)))

(defn paint
  "Description copied from class: ComponentUI

  g - the Graphics context in which to paint - `java.awt.Graphics`
  c - the component being painted; this argument is often ignored, but might be used if the UI object is stateless and shared by multiple components - `javax.swing.JComponent`"
  ([^BasicPopupMenuSeparatorUI this ^java.awt.Graphics g ^javax.swing.JComponent c]
    (-> this (.paint g c))))

(defn get-preferred-size
  "Description copied from class: ComponentUI

  c - the component whose preferred size is being queried; this argument is often ignored, but might be used if the UI object is stateless and shared by multiple components - `javax.swing.JComponent`

  returns: `java.awt.Dimension`"
  (^java.awt.Dimension [^BasicPopupMenuSeparatorUI this ^javax.swing.JComponent c]
    (-> this (.getPreferredSize c))))

