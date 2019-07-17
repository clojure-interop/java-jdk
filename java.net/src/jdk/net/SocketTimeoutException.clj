(ns jdk.net.SocketTimeoutException
  "Signals that a timeout has occurred on a socket read or accept."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.net SocketTimeoutException]))

(defn ->socket-timeout-exception
  "Constructor.

  Constructs a new SocketTimeoutException with a detail
   message.

  msg - the detail message - `java.lang.String`"
  ([msg]
    (new SocketTimeoutException msg))
  ([]
    (new SocketTimeoutException )))

