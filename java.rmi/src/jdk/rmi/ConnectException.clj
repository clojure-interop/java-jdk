(ns jdk.rmi.ConnectException
  "A ConnectException is thrown if a connection is refused
  to the remote host for a remote method call."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.rmi ConnectException]))

(defn ->connect-exception
  "Constructor.

  Constructs a ConnectException with the specified
   detail message and nested exception.

  s - the detail message - `java.lang.String`
  ex - the nested exception - `java.lang.Exception`"
  (^ConnectException [^java.lang.String s ^java.lang.Exception ex]
    (new ConnectException s ex))
  (^ConnectException [^java.lang.String s]
    (new ConnectException s)))

