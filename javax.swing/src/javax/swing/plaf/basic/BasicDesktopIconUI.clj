(ns javax.swing.plaf.basic.BasicDesktopIconUI
  "Basic L&F for a minimized window on a desktop."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing.plaf.basic BasicDesktopIconUI]))

(defn ->basic-desktop-icon-ui
  "Constructor."
  ([]
    (new BasicDesktopIconUI )))

(defn *create-ui
  "c - `javax.swing.JComponent`

  returns: `javax.swing.plaf.ComponentUI`"
  ([c]
    (BasicDesktopIconUI/createUI c)))

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

(defn get-preferred-size
  "Description copied from class: ComponentUI

  c - the component whose preferred size is being queried; this argument is often ignored, but might be used if the UI object is stateless and shared by multiple components - `javax.swing.JComponent`

  returns: `java.awt.Dimension`"
  ([this c]
    (-> this (.getPreferredSize c))))

(defn get-minimum-size
  "Description copied from class: ComponentUI

  c - the component whose minimum size is being queried; this argument is often ignored, but might be used if the UI object is stateless and shared by multiple components - `javax.swing.JComponent`

  returns: a Dimension object or null - `java.awt.Dimension`"
  ([this c]
    (-> this (.getMinimumSize c))))

(defn get-maximum-size
  "Desktop icons can not be resized.  Therefore, we should always
   return the minimum size of the desktop icon.

  c - the component whose maximum size is being queried; this argument is often ignored, but might be used if the UI object is stateless and shared by multiple components - `javax.swing.JComponent`

  returns: a Dimension object or null - `java.awt.Dimension`"
  ([this c]
    (-> this (.getMaximumSize c))))

(defn get-insets
  "c - `javax.swing.JComponent`

  returns: `java.awt.Insets`"
  ([this c]
    (-> this (.getInsets c))))

(defn deiconize
  ""
  ([this]
    (-> this (.deiconize))))

