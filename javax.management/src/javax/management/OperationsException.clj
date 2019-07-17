(ns javax.management.OperationsException
  "Represents exceptions thrown in the MBean server when performing operations
  on MBeans."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.management OperationsException]))

(defn ->operations-exception
  "Constructor.

  Constructor that allows a specific error message to be specified.

  message - the detail message. - `java.lang.String`"
  ([message]
    (new OperationsException message))
  ([]
    (new OperationsException )))

