(ns javax.swing.plaf.InputMapUIResource
  "A subclass of javax.swing.InputMap that implements UIResource.
  UI classes which provide a InputMap should use this class."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing.plaf InputMapUIResource]))

(defn ->input-map-ui-resource
  "Constructor."
  ([]
    (new InputMapUIResource )))

