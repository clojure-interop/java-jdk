(ns javax.management.NotCompliantMBeanException
  "Exception which occurs when trying to register an  object in the MBean server that is not a JMX compliant MBean."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.management NotCompliantMBeanException]))

(defn ->not-compliant-m-bean-exception
  "Constructor.

  Constructor that allows a specific error message to be specified.

  message - the detail message. - `java.lang.String`"
  ([message]
    (new NotCompliantMBeanException message))
  ([]
    (new NotCompliantMBeanException )))

