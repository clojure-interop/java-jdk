(ns jdk.rmi.AlreadyBoundException
  "An AlreadyBoundException is thrown if an attempt
  is made to bind an object in the registry to a name that already
  has an associated binding."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.rmi AlreadyBoundException]))

(defn ->already-bound-exception
  "Constructor.

  Constructs an AlreadyBoundException with the specified
   detail message.

  s - the detail message - `java.lang.String`"
  ([s]
    (new AlreadyBoundException s))
  ([]
    (new AlreadyBoundException )))

