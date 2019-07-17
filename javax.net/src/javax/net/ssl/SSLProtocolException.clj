(ns javax.net.ssl.SSLProtocolException
  "Reports an error in the operation of the SSL protocol.  Normally
  this indicates a flaw in one of the protocol implementations."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.net.ssl SSLProtocolException]))

(defn ->ssl-protocol-exception
  "Constructor.

  Constructs an exception reporting an SSL protocol error
   detected by an SSL subsystem.

  reason - describes the problem. - `java.lang.String`"
  ([reason]
    (new SSLProtocolException reason)))

