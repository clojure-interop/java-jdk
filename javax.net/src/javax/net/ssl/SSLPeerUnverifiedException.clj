(ns javax.net.ssl.SSLPeerUnverifiedException
  "Indicates that the peer's identity has not been verified.

  When the peer was not able to
  identify itself (for example; no certificate, the particular
  cipher suite being used does not support authentication, or no
  peer authentication was established during SSL handshaking) this
  exception is thrown."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.net.ssl SSLPeerUnverifiedException]))

(defn ->ssl-peer-unverified-exception
  "Constructor.

  Constructs an exception reporting that the SSL peer's
   identity has not been verified.

  reason - describes the problem. - `java.lang.String`"
  ([reason]
    (new SSLPeerUnverifiedException reason)))

