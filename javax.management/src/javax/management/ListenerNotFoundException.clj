(ns javax.management.ListenerNotFoundException
  "The specified MBean listener does not exist in the repository."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.management ListenerNotFoundException]))

(defn ->listener-not-found-exception
  "Constructor.

  Constructor that allows a specific error message to be specified.

  message - the detail message. - `java.lang.String`"
  ([^java.lang.String message]
    (new ListenerNotFoundException message))
  ([]
    (new ListenerNotFoundException )))

