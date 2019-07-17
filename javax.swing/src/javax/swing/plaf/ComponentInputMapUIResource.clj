(ns javax.swing.plaf.ComponentInputMapUIResource
  "A subclass of javax.swing.ComponentInputMap that implements UIResource.
  UI classes which provide a ComponentInputMap should use this class."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing.plaf ComponentInputMapUIResource]))

(defn ->component-input-map-ui-resource
  "Constructor.

  component - `javax.swing.JComponent`"
  ([^javax.swing.JComponent component]
    (new ComponentInputMapUIResource component)))

