(ns javax.swing.plaf.ActionMapUIResource
  "A subclass of javax.swing.ActionMap that implements UIResource.
  UI classes which provide an ActionMap should use this class."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing.plaf ActionMapUIResource]))

(defn ->action-map-ui-resource
  "Constructor."
  ([]
    (new ActionMapUIResource )))

