(ns jdk.rmi.MarshalException
  "A MarshalException is thrown if a
  java.io.IOException occurs while marshalling the remote call
  header, arguments or return value for a remote method call.  A
  MarshalException is also thrown if the receiver does not
  support the protocol version of the sender.

  If a MarshalException occurs during a remote method call,
  the call may or may not have reached the server.  If the call did reach the
  server, parameters may have been deserialized.  A call may not be
  retransmitted after a MarshalException and reliably preserve
  `at most once` call semantics."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.rmi MarshalException]))

(defn ->marshal-exception
  "Constructor.

  Constructs a MarshalException with the specified
   detail message and nested exception.

  s - the detail message - `java.lang.String`
  ex - the nested exception - `java.lang.Exception`"
  ([^java.lang.String s ^java.lang.Exception ex]
    (new MarshalException s ex))
  ([^java.lang.String s]
    (new MarshalException s)))

