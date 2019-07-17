(ns jdk.nio.channels.ReadPendingException
  "Unchecked exception thrown when an attempt is made to read from an
  asynchronous socket channel and a previous read has not completed."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.nio.channels ReadPendingException]))

(defn ->read-pending-exception
  "Constructor.

  Constructs an instance of this class."
  ([]
    (new ReadPendingException )))

