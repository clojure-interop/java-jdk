(ns javax.swing.plaf.BorderUIResource$EmptyBorderUIResource
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing.plaf BorderUIResource$EmptyBorderUIResource]))

(defn ->empty-border-ui-resource
  "Constructor.

  top - `int`
  left - `int`
  bottom - `int`
  right - `int`"
  ([^Integer top ^Integer left ^Integer bottom ^Integer right]
    (new BorderUIResource$EmptyBorderUIResource top left bottom right))
  ([^java.awt.Insets insets]
    (new BorderUIResource$EmptyBorderUIResource insets)))

