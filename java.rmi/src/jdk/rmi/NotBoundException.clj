(ns jdk.rmi.NotBoundException
  "A NotBoundException is thrown if an attempt
  is made to lookup or unbind in the registry a name that has
  no associated binding."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.rmi NotBoundException]))

(defn ->not-bound-exception
  "Constructor.

  Constructs a NotBoundException with the specified
   detail message.

  s - the detail message - `java.lang.String`"
  ([^java.lang.String s]
    (new NotBoundException s))
  ([]
    (new NotBoundException )))

