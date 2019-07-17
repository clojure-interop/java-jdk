(ns javax.swing.plaf.basic.BasicBorders$MarginBorder
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing.plaf.basic BasicBorders$MarginBorder]))

(defn ->margin-border
  "Constructor."
  ([]
    (new BasicBorders$MarginBorder )))

(defn get-border-insets
  "Description copied from class: AbstractBorder

  c - the component for which this border insets value applies - `java.awt.Component`
  insets - the object to be reinitialized - `java.awt.Insets`

  returns: the insets object - `java.awt.Insets`"
  ([this c insets]
    (-> this (.getBorderInsets c insets))))

