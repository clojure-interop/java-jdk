(ns javax.swing.plaf.BorderUIResource$EtchedBorderUIResource
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing.plaf BorderUIResource$EtchedBorderUIResource]))

(defn ->etched-border-ui-resource
  "Constructor.

  etch-type - `int`
  highlight - `java.awt.Color`
  shadow - `java.awt.Color`"
  ([^Integer etch-type ^java.awt.Color highlight ^java.awt.Color shadow]
    (new BorderUIResource$EtchedBorderUIResource etch-type highlight shadow))
  ([^java.awt.Color highlight ^java.awt.Color shadow]
    (new BorderUIResource$EtchedBorderUIResource highlight shadow))
  ([^Integer etch-type]
    (new BorderUIResource$EtchedBorderUIResource etch-type))
  ([]
    (new BorderUIResource$EtchedBorderUIResource )))

