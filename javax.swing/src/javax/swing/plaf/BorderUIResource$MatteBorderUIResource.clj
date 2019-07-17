(ns javax.swing.plaf.BorderUIResource$MatteBorderUIResource
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing.plaf BorderUIResource$MatteBorderUIResource]))

(defn ->matte-border-ui-resource
  "Constructor.

  top - `int`
  left - `int`
  bottom - `int`
  right - `int`
  color - `java.awt.Color`"
  ([top left bottom right color]
    (new BorderUIResource$MatteBorderUIResource top left bottom right color))
  ([tile-icon]
    (new BorderUIResource$MatteBorderUIResource tile-icon)))

