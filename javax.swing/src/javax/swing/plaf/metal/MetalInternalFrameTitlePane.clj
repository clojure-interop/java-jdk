(ns javax.swing.plaf.metal.MetalInternalFrameTitlePane
  "Class that manages a JLF title bar"
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing.plaf.metal MetalInternalFrameTitlePane]))

(defn ->metal-internal-frame-title-pane
  "Constructor.

  f - `javax.swing.JInternalFrame`"
  (^MetalInternalFrameTitlePane [^javax.swing.JInternalFrame f]
    (new MetalInternalFrameTitlePane f)))

(defn add-notify
  "Description copied from class: JComponent"
  ([^MetalInternalFrameTitlePane this]
    (-> this (.addNotify))))

(defn paint-palette
  "g - `java.awt.Graphics`"
  ([^MetalInternalFrameTitlePane this ^java.awt.Graphics g]
    (-> this (.paintPalette g))))

(defn paint-component
  "Description copied from class: JComponent

  g - the Graphics object to protect - `java.awt.Graphics`"
  ([^MetalInternalFrameTitlePane this ^java.awt.Graphics g]
    (-> this (.paintComponent g))))

(defn set-palette
  "b - `boolean`"
  ([^MetalInternalFrameTitlePane this ^Boolean b]
    (-> this (.setPalette b))))

