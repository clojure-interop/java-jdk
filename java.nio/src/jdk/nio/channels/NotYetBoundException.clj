(ns jdk.nio.channels.NotYetBoundException
  "Unchecked exception thrown when an attempt is made to invoke an I/O
  operation upon a server socket channel that is not yet bound."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.nio.channels NotYetBoundException]))

(defn ->not-yet-bound-exception
  "Constructor.

  Constructs an instance of this class."
  (^NotYetBoundException []
    (new NotYetBoundException )))

