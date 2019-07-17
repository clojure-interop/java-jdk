(ns jdk.io.ObjectInputValidation
  "Callback interface to allow validation of objects within a graph.
  Allows an object to be called when a complete graph of objects has
  been deserialized."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.io ObjectInputValidation]))

(defn validate-object
  "Validates the object.

  throws: java.io.InvalidObjectException - If the object cannot validate itself."
  ([this]
    (-> this (.validateObject))))

