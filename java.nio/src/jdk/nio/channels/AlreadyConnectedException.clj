(ns jdk.nio.channels.AlreadyConnectedException
  "Unchecked exception thrown when an attempt is made to connect a SocketChannel that is already connected."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.nio.channels AlreadyConnectedException]))

(defn ->already-connected-exception
  "Constructor.

  Constructs an instance of this class."
  (^AlreadyConnectedException []
    (new AlreadyConnectedException )))

