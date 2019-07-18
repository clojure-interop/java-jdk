(ns javax.swing.plaf.ColorUIResource
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing.plaf ColorUIResource]))

(defn ->color-ui-resource
  "Constructor.

  r - `int`
  g - `int`
  b - `int`"
  (^ColorUIResource [^Integer r ^Integer g ^Integer b]
    (new ColorUIResource r g b))
  (^ColorUIResource [^Integer rgb]
    (new ColorUIResource rgb)))

