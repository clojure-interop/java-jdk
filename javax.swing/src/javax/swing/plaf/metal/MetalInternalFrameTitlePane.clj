(ns javax.swing.plaf.metal.MetalInternalFrameTitlePane
  "Class that manages a JLF title bar"
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing.plaf.metal MetalInternalFrameTitlePane]))

(defn ->metal-internal-frame-title-pane
  "Constructor.

  f - `javax.swing.JInternalFrame`"
  ([f]
    (new MetalInternalFrameTitlePane f)))

(defn add-notify
  "Description copied from class: JComponent"
  ([this]
    (-> this (.addNotify))))

(defn paint-palette
  "g - `java.awt.Graphics`"
  ([this g]
    (-> this (.paintPalette g))))

(defn paint-component
  "Description copied from class: JComponent

  g - the Graphics object to protect - `java.awt.Graphics`"
  ([this g]
    (-> this (.paintComponent g))))

(defn set-palette
  "b - `boolean`"
  ([this b]
    (-> this (.setPalette b))))

