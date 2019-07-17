(ns jdk.rmi.UnknownHostException
  "An UnknownHostException is thrown if a
  java.net.UnknownHostException occurs while creating
  a connection to the remote host for a remote method call."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.rmi UnknownHostException]))

(defn ->unknown-host-exception
  "Constructor.

  Constructs an UnknownHostException with the specified
   detail message and nested exception.

  s - the detail message - `java.lang.String`
  ex - the nested exception - `java.lang.Exception`"
  ([^java.lang.String s ^java.lang.Exception ex]
    (new UnknownHostException s ex))
  ([^java.lang.String s]
    (new UnknownHostException s)))

