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
  ([^javax.swing.border.Border border ^java.lang.String title ^Integer title-justification ^Integer title-position ^java.awt.Font title-font ^java.awt.Color title-color]
    (new BorderUIResource$TitledBorderUIResource border title title-justification title-position title-font title-color))
  ([^javax.swing.border.Border border ^java.lang.String title ^Integer title-justification ^Integer title-position ^java.awt.Font title-font]
    (new BorderUIResource$TitledBorderUIResource border title title-justification title-position title-font))
  ([^javax.swing.border.Border border ^java.lang.String title ^Integer title-justification ^Integer title-position]
    (new BorderUIResource$TitledBorderUIResource border title title-justification title-position))
  ([^javax.swing.border.Border border ^java.lang.String title]
    (new BorderUIResource$TitledBorderUIResource border title))
  ([^java.lang.String title]
    (new BorderUIResource$TitledBorderUIResource title)))

