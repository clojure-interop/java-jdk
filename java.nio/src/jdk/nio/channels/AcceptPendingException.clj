(ns jdk.nio.channels.AcceptPendingException
  "Unchecked exception thrown when an attempt is made to initiate an accept
  operation on a channel and a previous accept operation has not completed."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.nio.channels AcceptPendingException]))

(defn ->accept-pending-exception
  "Constructor.

  Constructs an instance of this class."
  ([]
    (new AcceptPendingException )))

