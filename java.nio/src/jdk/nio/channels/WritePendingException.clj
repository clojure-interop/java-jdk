(ns jdk.nio.channels.WritePendingException
  "Unchecked exception thrown when an attempt is made to write to an
  asynchronous socket channel and a previous write has not completed."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.nio.channels WritePendingException]))

(defn ->write-pending-exception
  "Constructor.

  Constructs an instance of this class."
  ([]
    (new WritePendingException )))

