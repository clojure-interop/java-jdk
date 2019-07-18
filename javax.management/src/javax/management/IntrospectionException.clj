(ns javax.management.IntrospectionException
  "An exception occurred during the introspection of an MBean."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.management IntrospectionException]))

(defn ->introspection-exception
  "Constructor.

  Constructor that allows a specific error message to be specified.

  message - the detail message. - `java.lang.String`"
  (^IntrospectionException [^java.lang.String message]
    (new IntrospectionException message))
  (^IntrospectionException []
    (new IntrospectionException )))

