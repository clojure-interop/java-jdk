(ns javax.management.MalformedObjectNameException
  "The format of the string does not correspond to a valid ObjectName."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.management MalformedObjectNameException]))

(defn ->malformed-object-name-exception
  "Constructor.

  Constructor that allows a specific error message to be specified.

  message - the detail message. - `java.lang.String`"
  ([message]
    (new MalformedObjectNameException message))
  ([]
    (new MalformedObjectNameException )))

