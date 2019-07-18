(ns javax.management.JMException
  "Exceptions thrown by JMX implementations.
  It does not include the runtime exceptions."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.management JMException]))

(defn ->jm-exception
  "Constructor.

  Constructor that allows a specific error message to be specified.

  msg - the detail message. - `java.lang.String`"
  (^JMException [^java.lang.String msg]
    (new JMException msg))
  (^JMException []
    (new JMException )))

