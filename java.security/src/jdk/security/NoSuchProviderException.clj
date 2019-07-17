(ns jdk.security.NoSuchProviderException
  "This exception is thrown when a particular security provider is
  requested but is not available in the environment."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.security NoSuchProviderException]))

(defn ->no-such-provider-exception
  "Constructor.

  Constructs a NoSuchProviderException with the specified detail
   message. A detail message is a String that describes this
   particular exception.

  msg - the detail message. - `java.lang.String`"
  ([msg]
    (new NoSuchProviderException msg))
  ([]
    (new NoSuchProviderException )))

