(ns jdk.net.ProtocolException
  "Thrown to indicate that there is an error in the underlying
  protocol, such as a TCP error."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.net ProtocolException]))

(defn ->protocol-exception
  "Constructor.

  Constructs a new ProtocolException with the
   specified detail message.

  host - the detail message. - `java.lang.String`"
  ([^java.lang.String host]
    (new ProtocolException host))
  ([]
    (new ProtocolException )))

