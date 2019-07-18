(ns javax.net.ssl.SSLKeyException
  "Reports a bad SSL key.  Normally, this indicates misconfiguration
  of the server or client SSL certificate and private key."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.net.ssl SSLKeyException]))

(defn ->ssl-key-exception
  "Constructor.

  Constructs an exception reporting a key management error
   found by an SSL subsystem.

  reason - describes the problem. - `java.lang.String`"
  (^SSLKeyException [^java.lang.String reason]
    (new SSLKeyException reason)))

