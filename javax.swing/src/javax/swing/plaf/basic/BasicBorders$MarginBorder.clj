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
  (^java.awt.Insets [^javax.swing.plaf.basic.BasicBorders$MarginBorder this ^java.awt.Component c ^java.awt.Insets insets]
    (-> this (.getBorderInsets c insets))))

