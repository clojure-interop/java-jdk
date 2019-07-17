(ns javax.swing.plaf.BorderUIResource$TitledBorderUIResource
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing.plaf BorderUIResource$TitledBorderUIResource]))

(defn ->titled-border-ui-resource
  "Constructor.

  border - `javax.swing.border.Border`
  title - `java.lang.String`
  title-justification - `int`
  title-position - `int`
  title-font - `java.awt.Font`
  title-color - `java.awt.Color`"
  ([border title title-justification title-position title-font title-color]
    (new BorderUIResource$TitledBorderUIResource border title title-justification title-position title-font title-color))
  ([border title title-justification title-position title-font]
    (new BorderUIResource$TitledBorderUIResource border title title-justification title-position title-font))
  ([border title title-justification title-position]
    (new BorderUIResource$TitledBorderUIResource border title title-justification title-position))
  ([border title]
    (new BorderUIResource$TitledBorderUIResource border title))
  ([title]
    (new BorderUIResource$TitledBorderUIResource title)))

