(ns javax.management.ServiceNotFoundException
  "Represents exceptions raised when a requested service is not supported."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.management ServiceNotFoundException]))

(defn ->service-not-found-exception
  "Constructor.

  Constructor that allows a specific error message to be specified.

  message - the detail message. - `java.lang.String`"
  ([message]
    (new ServiceNotFoundException message))
  ([]
    (new ServiceNotFoundException )))

