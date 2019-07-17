(ns jdk.awt.dnd.InvalidDnDOperationException
  "This exception is thrown by various methods in the java.awt.dnd package.
  It is usually thrown to indicate that the target in question is unable
  to undertake the requested operation that the present time, since the
  underlying DnD system is not in the appropriate state."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.awt.dnd InvalidDnDOperationException]))

(defn ->invalid-dn-d-operation-exception
  "Constructor.

  Create an Exception with its own descriptive message

  msg - the detail message - `java.lang.String`"
  ([^java.lang.String msg]
    (new InvalidDnDOperationException msg))
  ([]
    (new InvalidDnDOperationException )))

