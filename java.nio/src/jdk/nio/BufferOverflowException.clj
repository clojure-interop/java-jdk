(ns jdk.nio.BufferOverflowException
  "Unchecked exception thrown when a relative put operation reaches
  the target buffer's limit."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.nio BufferOverflowException]))

(defn ->buffer-overflow-exception
  "Constructor.

  Constructs an instance of this class."
  ([]
    (new BufferOverflowException )))

