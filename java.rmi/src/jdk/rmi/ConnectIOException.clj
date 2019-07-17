(ns jdk.rmi.ConnectIOException
  "A ConnectIOException is thrown if an
  IOException occurs while making a connection
  to the remote host for a remote method call."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.rmi ConnectIOException]))

(defn ->connect-io-exception
  "Constructor.

  Constructs a ConnectIOException with the specified
   detail message and nested exception.

  s - the detail message - `java.lang.String`
  ex - the nested exception - `java.lang.Exception`"
  ([s ex]
    (new ConnectIOException s ex))
  ([s]
    (new ConnectIOException s)))

