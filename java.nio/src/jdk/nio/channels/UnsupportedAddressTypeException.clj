(ns jdk.nio.channels.UnsupportedAddressTypeException
  "Unchecked exception thrown when an attempt is made to bind or connect
  to a socket address of a type that is not supported."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.nio.channels UnsupportedAddressTypeException]))

(defn ->unsupported-address-type-exception
  "Constructor.

  Constructs an instance of this class."
  ([]
    (new UnsupportedAddressTypeException )))

