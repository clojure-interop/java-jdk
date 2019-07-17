(ns javax.management.JMRuntimeException
  "Runtime exceptions emitted by JMX implementations."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.management JMRuntimeException]))

(defn ->jm-runtime-exception
  "Constructor.

  Constructor that allows a specific error message to be specified.

  message - the detail message. - `java.lang.String`"
  ([message]
    (new JMRuntimeException message))
  ([]
    (new JMRuntimeException )))

