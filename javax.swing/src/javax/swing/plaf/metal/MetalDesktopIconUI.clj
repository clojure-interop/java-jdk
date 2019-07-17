(ns javax.swing.plaf.metal.MetalDesktopIconUI
  "Metal desktop icon."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing.plaf.metal MetalDesktopIconUI]))

(defn ->metal-desktop-icon-ui
  "Constructor."
  ([]
    (new MetalDesktopIconUI )))

(defn *create-ui
  "c - `javax.swing.JComponent`

  returns: `javax.swing.plaf.ComponentUI`"
  (^javax.swing.plaf.ComponentUI [^javax.swing.JComponent c]
    (MetalDesktopIconUI/createUI c)))

(defn get-preferred-size
  "Description copied from class: ComponentUI

  c - the component whose preferred size is being queried; this argument is often ignored, but might be used if the UI object is stateless and shared by multiple components - `javax.swing.JComponent`

  returns: `java.awt.Dimension`"
  (^java.awt.Dimension [^javax.swing.plaf.metal.MetalDesktopIconUI this ^javax.swing.JComponent c]
    (-> this (.getPreferredSize c))))

(defn get-minimum-size
  "Description copied from class: ComponentUI

  c - the component whose minimum size is being queried; this argument is often ignored, but might be used if the UI object is stateless and shared by multiple components - `javax.swing.JComponent`

  returns: a Dimension object or null - `java.awt.Dimension`"
  (^java.awt.Dimension [^javax.swing.plaf.metal.MetalDesktopIconUI this ^javax.swing.JComponent c]
    (-> this (.getMinimumSize c))))

(defn get-maximum-size
  "Description copied from class: BasicDesktopIconUI

  c - the component whose maximum size is being queried; this argument is often ignored, but might be used if the UI object is stateless and shared by multiple components - `javax.swing.JComponent`

  returns: a Dimension object or null - `java.awt.Dimension`"
  (^java.awt.Dimension [^javax.swing.plaf.metal.MetalDesktopIconUI this ^javax.swing.JComponent c]
    (-> this (.getMaximumSize c))))

