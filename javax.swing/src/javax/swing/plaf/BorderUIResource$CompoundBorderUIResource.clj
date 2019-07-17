(ns javax.swing.plaf.BorderUIResource$CompoundBorderUIResource
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing.plaf BorderUIResource$CompoundBorderUIResource]))

(defn ->compound-border-ui-resource
  "Constructor.

  outside-border - `javax.swing.border.Border`
  inside-border - `javax.swing.border.Border`"
  ([outside-border inside-border]
    (new BorderUIResource$CompoundBorderUIResource outside-border inside-border)))

