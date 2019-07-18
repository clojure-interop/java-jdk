(ns jdk.nio.file.ProviderNotFoundException
  "Runtime exception thrown when a provider of the required type cannot be found."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.nio.file ProviderNotFoundException]))

(defn ->provider-not-found-exception
  "Constructor.

  Constructs an instance of this class.

  msg - the detail message - `java.lang.String`"
  (^ProviderNotFoundException [^java.lang.String msg]
    (new ProviderNotFoundException msg))
  (^ProviderNotFoundException []
    (new ProviderNotFoundException )))

