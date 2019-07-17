(ns jdk.rmi.AccessException
  "An AccessException is thrown by certain methods of the
  java.rmi.Naming class (specifically bind,
  rebind, and unbind) and methods of the
  java.rmi.activation.ActivationSystem interface to
  indicate that the caller does not have permission to perform the action
  requested by the method call.  If the method was invoked from a non-local
  host, then an AccessException is thrown."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.rmi AccessException]))

(defn ->access-exception
  "Constructor.

  Constructs an AccessException with the specified
   detail message and nested exception.

  s - the detail message - `java.lang.String`
  ex - the nested exception - `java.lang.Exception`"
  ([s ex]
    (new AccessException s ex))
  ([s]
    (new AccessException s)))

