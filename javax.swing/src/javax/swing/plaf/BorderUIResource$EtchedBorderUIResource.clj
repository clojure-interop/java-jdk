(ns javax.swing.plaf.BorderUIResource$EtchedBorderUIResource
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing.plaf BorderUIResource$EtchedBorderUIResource]))

(defn ->etched-border-ui-resource
  "Constructor.

  etch-type - `int`
  highlight - `java.awt.Color`
  shadow - `java.awt.Color`"
  (^BorderUIResource$EtchedBorderUIResource [^Integer etch-type ^java.awt.Color highlight ^java.awt.Color shadow]
    (new BorderUIResource$EtchedBorderUIResource etch-type highlight shadow))
  (^BorderUIResource$EtchedBorderUIResource [^java.awt.Color highlight ^java.awt.Color shadow]
    (new BorderUIResource$EtchedBorderUIResource highlight shadow))
  (^BorderUIResource$EtchedBorderUIResource [^Integer etch-type]
    (new BorderUIResource$EtchedBorderUIResource etch-type))
  (^BorderUIResource$EtchedBorderUIResource []
    (new BorderUIResource$EtchedBorderUIResource )))

