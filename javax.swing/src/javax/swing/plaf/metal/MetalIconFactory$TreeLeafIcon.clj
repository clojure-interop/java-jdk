(ns javax.swing.plaf.metal.MetalIconFactory$TreeLeafIcon
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing.plaf.metal MetalIconFactory$TreeLeafIcon]))

(defn ->tree-leaf-icon
  "Constructor."
  (^MetalIconFactory$TreeLeafIcon []
    (new MetalIconFactory$TreeLeafIcon )))

(defn get-shift
  "returns: `int`"
  (^Integer [^MetalIconFactory$TreeLeafIcon this]
    (-> this (.getShift))))

(defn get-additional-height
  "returns: `int`"
  (^Integer [^MetalIconFactory$TreeLeafIcon this]
    (-> this (.getAdditionalHeight))))

