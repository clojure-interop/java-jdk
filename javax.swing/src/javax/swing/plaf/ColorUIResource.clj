(ns javax.swing.plaf.ColorUIResource
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing.plaf ColorUIResource]))

(defn ->color-ui-resource
  "Constructor.

  r - `int`
  g - `int`
  b - `int`"
  ([r g b]
    (new ColorUIResource r g b))
  ([rgb]
    (new ColorUIResource rgb)))

