(ns javax.swing.plaf.BorderUIResource$BevelBorderUIResource
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing.plaf BorderUIResource$BevelBorderUIResource]))

(defn ->bevel-border-ui-resource
  "Constructor.

  bevel-type - `int`
  highlight-outer - `java.awt.Color`
  highlight-inner - `java.awt.Color`
  shadow-outer - `java.awt.Color`
  shadow-inner - `java.awt.Color`"
  (^BorderUIResource$BevelBorderUIResource [^Integer bevel-type ^java.awt.Color highlight-outer ^java.awt.Color highlight-inner ^java.awt.Color shadow-outer ^java.awt.Color shadow-inner]
    (new BorderUIResource$BevelBorderUIResource bevel-type highlight-outer highlight-inner shadow-outer shadow-inner))
  (^BorderUIResource$BevelBorderUIResource [^Integer bevel-type ^java.awt.Color highlight ^java.awt.Color shadow]
    (new BorderUIResource$BevelBorderUIResource bevel-type highlight shadow))
  (^BorderUIResource$BevelBorderUIResource [^Integer bevel-type]
    (new BorderUIResource$BevelBorderUIResource bevel-type)))

