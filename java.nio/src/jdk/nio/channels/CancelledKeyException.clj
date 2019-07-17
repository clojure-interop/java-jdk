(ns jdk.nio.channels.CancelledKeyException
  "Unchecked exception thrown when an attempt is made to use
  a selection key that is no longer valid."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.nio.channels CancelledKeyException]))

(defn ->cancelled-key-exception
  "Constructor.

  Constructs an instance of this class."
  ([]
    (new CancelledKeyException )))

