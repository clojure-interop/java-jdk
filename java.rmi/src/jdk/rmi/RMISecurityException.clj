(ns jdk.rmi.RMISecurityException
  "Deprecated.
 Use SecurityException instead.
  Application code should never directly reference this class, and
  RMISecurityManager no longer throws this subclass of
  java.lang.SecurityException."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.rmi RMISecurityException]))

(defn ->rmi-security-exception
  "Constructor.

  Deprecated. no replacement

  name - the detail message - `java.lang.String`"
  ([name]
    (new RMISecurityException name))
  ([name arg]
    (new RMISecurityException name arg)))

