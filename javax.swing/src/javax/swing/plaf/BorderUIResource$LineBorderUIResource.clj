(ns javax.swing.plaf.BorderUIResource$LineBorderUIResource
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing.plaf BorderUIResource$LineBorderUIResource]))

(defn ->line-border-ui-resource
  "Constructor.

  color - `java.awt.Color`
  thickness - `int`"
  ([color thickness]
    (new BorderUIResource$LineBorderUIResource color thickness))
  ([color]
    (new BorderUIResource$LineBorderUIResource color)))

