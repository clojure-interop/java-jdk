(ns javax.swing.plaf.InsetsUIResource
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing.plaf InsetsUIResource]))

(defn ->insets-ui-resource
  "Constructor.

  top - `int`
  left - `int`
  bottom - `int`
  right - `int`"
  (^InsetsUIResource [^Integer top ^Integer left ^Integer bottom ^Integer right]
    (new InsetsUIResource top left bottom right)))

