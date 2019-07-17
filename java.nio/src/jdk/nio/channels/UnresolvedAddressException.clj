(ns jdk.nio.channels.UnresolvedAddressException
  "Unchecked exception thrown when an attempt is made to invoke a network
  operation upon an unresolved socket address."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.nio.channels UnresolvedAddressException]))

(defn ->unresolved-address-exception
  "Constructor.

  Constructs an instance of this class."
  ([]
    (new UnresolvedAddressException )))

