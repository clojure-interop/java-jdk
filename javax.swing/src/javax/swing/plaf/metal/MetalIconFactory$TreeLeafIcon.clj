(ns javax.swing.plaf.metal.MetalIconFactory$TreeLeafIcon
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing.plaf.metal MetalIconFactory$TreeLeafIcon]))

(defn ->tree-leaf-icon
  "Constructor."
  ([]
    (new MetalIconFactory$TreeLeafIcon )))

(defn get-shift
  "returns: `int`"
  ([this]
    (-> this (.getShift))))

(defn get-additional-height
  "returns: `int`"
  ([this]
    (-> this (.getAdditionalHeight))))

