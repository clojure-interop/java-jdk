(ns javax.swing.plaf.BorderUIResource$EtchedBorderUIResource
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing.plaf BorderUIResource$EtchedBorderUIResource]))

(defn ->etched-border-ui-resource
  "Constructor.

  etch-type - `int`
  highlight - `java.awt.Color`
  shadow - `java.awt.Color`"
  ([etch-type highlight shadow]
    (new BorderUIResource$EtchedBorderUIResource etch-type highlight shadow))
  ([highlight shadow]
    (new BorderUIResource$EtchedBorderUIResource highlight shadow))
  ([etch-type]
    (new BorderUIResource$EtchedBorderUIResource etch-type))
  ([]
    (new BorderUIResource$EtchedBorderUIResource )))

