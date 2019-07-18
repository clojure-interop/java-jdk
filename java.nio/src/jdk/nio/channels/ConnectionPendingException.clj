(ns jdk.nio.channels.ConnectionPendingException
  "Unchecked exception thrown when an attempt is made to connect a SocketChannel for which a non-blocking connection operation is already in
  progress."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.nio.channels ConnectionPendingException]))

(defn ->connection-pending-exception
  "Constructor.

  Constructs an instance of this class."
  (^ConnectionPendingException []
    (new ConnectionPendingException )))

