(ns javax.net.ssl.X509TrustManager
  "Instance of this interface manage which X509 certificates
  may be used to authenticate the remote side of a secure
  socket. Decisions may be based on trusted certificate
  authorities, certificate revocation lists, online
  status checking or other means."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.net.ssl X509TrustManager]))

(defn check-client-trusted
  "Given the partial or complete certificate chain provided by the
   peer, build a certificate path to a trusted root and return if
   it can be validated and is trusted for client SSL
   authentication based on the authentication type.

   The authentication type is determined by the actual certificate
   used. For instance, if RSAPublicKey is used, the authType
   should be \"RSA\". Checking is case-sensitive.

  chain - the peer certificate chain - `java.security.cert.X509Certificate[]`
  auth-type - the authentication type based on the client certificate - `java.lang.String`

  throws: java.lang.IllegalArgumentException - if null or zero-length chain is passed in for the chain parameter or if null or zero-length string is passed in for the authType parameter"
  ([^X509TrustManager this chain ^java.lang.String auth-type]
    (-> this (.checkClientTrusted chain auth-type))))

(defn check-server-trusted
  "Given the partial or complete certificate chain provided by the
   peer, build a certificate path to a trusted root and return if
   it can be validated and is trusted for server SSL
   authentication based on the authentication type.

   The authentication type is the key exchange algorithm portion
   of the cipher suites represented as a String, such as \"RSA\",
   \"DHE_DSS\". Note: for some exportable cipher suites, the key
   exchange algorithm is determined at run time during the
   handshake. For instance, for TLS_RSA_EXPORT_WITH_RC4_40_MD5,
   the authType should be RSA_EXPORT when an ephemeral RSA key is
   used for the key exchange, and RSA when the key from the server
   certificate is used. Checking is case-sensitive.

  chain - the peer certificate chain - `java.security.cert.X509Certificate[]`
  auth-type - the key exchange algorithm used - `java.lang.String`

  throws: java.lang.IllegalArgumentException - if null or zero-length chain is passed in for the chain parameter or if null or zero-length string is passed in for the authType parameter"
  ([^X509TrustManager this chain ^java.lang.String auth-type]
    (-> this (.checkServerTrusted chain auth-type))))

(defn get-accepted-issuers
  "Return an array of certificate authority certificates
   which are trusted for authenticating peers.

  returns: a non-null (possibly empty) array of acceptable
            CA issuer certificates. - `java.security.cert.X509Certificate[]`"
  ([^X509TrustManager this]
    (-> this (.getAcceptedIssuers))))

