(ns jdk.rmi.RMISecurityManager
  "Deprecated.
 Use SecurityManager instead."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.rmi RMISecurityManager]))

(defn ->rmi-security-manager
  "Constructor.

  Deprecated."
  ([]
    (new RMISecurityManager )))

