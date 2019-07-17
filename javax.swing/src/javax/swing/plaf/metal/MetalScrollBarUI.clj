(ns javax.swing.plaf.metal.MetalScrollBarUI
  "Implementation of ScrollBarUI for the Metal Look and Feel"
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing.plaf.metal MetalScrollBarUI]))

(defn ->metal-scroll-bar-ui
  "Constructor."
  ([]
    (new MetalScrollBarUI )))

(def *-free-standing-prop
  "Static Constant.

  type: java.lang.String"
  MetalScrollBarUI/FREE_STANDING_PROP)

(defn *create-ui
  "c - `javax.swing.JComponent`

  returns: `javax.swing.plaf.ComponentUI`"
  ([c]
    (MetalScrollBarUI/createUI c)))

(defn get-preferred-size
  "Description copied from class: BasicScrollBarUI

  c - the JScrollBar that's delegating this method to us - `javax.swing.JComponent`

  returns: the preferred size of a Basic JScrollBar - `java.awt.Dimension`"
  ([this c]
    (-> this (.getPreferredSize c))))

