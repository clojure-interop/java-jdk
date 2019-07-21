(ns javax.net.ssl.StandardConstants
  "Standard constants definitions"
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.net.ssl StandardConstants]))

(def *-sni-host-name
  "Static Constant.

  The \"host_name\" type representing of a DNS hostname
   (see SNIHostName) in a Server Name Indication (SNI) extension.

   The SNI extension is a feature that extends the SSL/TLS protocols to
   indicate what server name the client is attempting to connect to during
   handshaking.  See section 3, \"Server Name Indication\", of TLS Extensions (RFC 6066).

   The value of this constant is 0.

  type: int"
  StandardConstants/SNI_HOST_NAME)

