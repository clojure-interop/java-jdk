(ns jdk.net.SocketException
  "Thrown to indicate that there is an error creating or accessing a Socket."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.net SocketException]))

(defn ->socket-exception
  "Constructor.

  Constructs a new SocketException with the
   specified detail message.

  msg - the detail message. - `java.lang.String`"
  ([^java.lang.String msg]
    (new SocketException msg))
  ([]
    (new SocketException )))

