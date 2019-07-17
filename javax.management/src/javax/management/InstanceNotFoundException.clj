(ns javax.management.InstanceNotFoundException
  "The specified MBean does not exist in the repository."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.management InstanceNotFoundException]))

(defn ->instance-not-found-exception
  "Constructor.

  Constructor that allows a specific error message to be specified.

  message - the detail message. - `java.lang.String`"
  ([message]
    (new InstanceNotFoundException message))
  ([]
    (new InstanceNotFoundException )))

