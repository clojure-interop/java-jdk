(ns jdk.rmi.StubNotFoundException
  "A StubNotFoundException is thrown if a valid stub class
  could not be found for a remote object when it is exported.
  A StubNotFoundException may also be
  thrown when an activatable object is registered via the
  java.rmi.activation.Activatable.register method."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.rmi StubNotFoundException]))

(defn ->stub-not-found-exception
  "Constructor.

  Constructs a StubNotFoundException with the specified
   detail message and nested exception.

  s - the detail message - `java.lang.String`
  ex - the nested exception - `java.lang.Exception`"
  ([^java.lang.String s ^java.lang.Exception ex]
    (new StubNotFoundException s ex))
  ([^java.lang.String s]
    (new StubNotFoundException s)))

