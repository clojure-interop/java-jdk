(ns javax.swing.plaf.metal.MetalPopupMenuSeparatorUI
  "A Metal L&F implementation of PopupMenuSeparatorUI.  This implementation
  is a `combined` view/controller."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing.plaf.metal MetalPopupMenuSeparatorUI]))

(defn ->metal-popup-menu-separator-ui
  "Constructor."
  ([]
    (new MetalPopupMenuSeparatorUI )))

(defn *create-ui
  "c - `javax.swing.JComponent`

  returns: `javax.swing.plaf.ComponentUI`"
  ([^javax.swing.JComponent c]
    (MetalPopupMenuSeparatorUI/createUI c)))

(defn paint
  "Description copied from class: ComponentUI

  g - the Graphics context in which to paint - `java.awt.Graphics`
  c - the component being painted; this argument is often ignored, but might be used if the UI object is stateless and shared by multiple components - `javax.swing.JComponent`"
  ([^javax.swing.plaf.metal.MetalPopupMenuSeparatorUI this ^java.awt.Graphics g ^javax.swing.JComponent c]
    (-> this (.paint g c))))

(defn get-preferred-size
  "Description copied from class: ComponentUI

  c - the component whose preferred size is being queried; this argument is often ignored, but might be used if the UI object is stateless and shared by multiple components - `javax.swing.JComponent`

  returns: `java.awt.Dimension`"
  ([^javax.swing.plaf.metal.MetalPopupMenuSeparatorUI this ^javax.swing.JComponent c]
    (-> this (.getPreferredSize c))))

