(ns jdk.net.ConnectException
  "Signals that an error occurred while attempting to connect a
  socket to a remote address and port.  Typically, the connection
  was refused remotely (e.g., no process is listening on the
  remote address/port)."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.net ConnectException]))

(defn ->connect-exception
  "Constructor.

  Constructs a new ConnectException with the specified detail
   message as to why the connect error occurred.
   A detail message is a String that gives a specific
   description of this error.

  msg - the detail message - `java.lang.String`"
  ([^java.lang.String msg]
    (new ConnectException msg))
  ([]
    (new ConnectException )))

