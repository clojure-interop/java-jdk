(ns javax.net.ssl.SSLHandshakeException
  "Indicates that the client and server could not negotiate the
  desired level of security.  The connection is no longer usable."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.net.ssl SSLHandshakeException]))

(defn ->ssl-handshake-exception
  "Constructor.

  Constructs an exception reporting an error found by
   an SSL subsystem during handshaking.

  reason - describes the problem. - `java.lang.String`"
  (^SSLHandshakeException [^java.lang.String reason]
    (new SSLHandshakeException reason)))

