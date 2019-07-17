(ns jdk.rmi.UnexpectedException
  "An UnexpectedException is thrown if the client of a
  remote method call receives, as a result of the call, a checked
  exception that is not among the checked exception types declared in the
  throws clause of the method in the remote interface."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.rmi UnexpectedException]))

(defn ->unexpected-exception
  "Constructor.

  Constructs a UnexpectedException with the specified
   detail message and nested exception.

  s - the detail message - `java.lang.String`
  ex - the nested exception - `java.lang.Exception`"
  ([s ex]
    (new UnexpectedException s ex))
  ([s]
    (new UnexpectedException s)))

