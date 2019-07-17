(ns jdk.nio.channels.NoConnectionPendingException
  "Unchecked exception thrown when the finishConnect method of a SocketChannel is invoked without first
  successfully invoking its connect method."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.nio.channels NoConnectionPendingException]))

(defn ->no-connection-pending-exception
  "Constructor.

  Constructs an instance of this class."
  ([]
    (new NoConnectionPendingException )))

