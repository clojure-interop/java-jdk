(ns javax.management.InstanceAlreadyExistsException
  "The MBean is already registered in the repository."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.management InstanceAlreadyExistsException]))

(defn ->instance-already-exists-exception
  "Constructor.

  Constructor that allows a specific error message to be specified.

  message - the detail message. - `java.lang.String`"
  ([^java.lang.String message]
    (new InstanceAlreadyExistsException message))
  ([]
    (new InstanceAlreadyExistsException )))

