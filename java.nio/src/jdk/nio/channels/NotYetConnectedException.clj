(ns jdk.nio.channels.NotYetConnectedException
  "Unchecked exception thrown when an attempt is made to invoke an I/O
  operation upon a socket channel that is not yet connected."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.nio.channels NotYetConnectedException]))

(defn ->not-yet-connected-exception
  "Constructor.

  Constructs an instance of this class."
  ([]
    (new NotYetConnectedException )))

