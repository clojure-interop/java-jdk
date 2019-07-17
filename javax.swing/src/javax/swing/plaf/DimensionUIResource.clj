(ns javax.swing.plaf.DimensionUIResource
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing.plaf DimensionUIResource]))

(defn ->dimension-ui-resource
  "Constructor.

  width - `int`
  height - `int`"
  ([width height]
    (new DimensionUIResource width height)))

