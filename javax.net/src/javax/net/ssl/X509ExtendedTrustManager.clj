(ns javax.net.ssl.X509ExtendedTrustManager
  "Extensions to the X509TrustManager interface to support
  SSL/TLS connection sensitive trust management.

  To prevent man-in-the-middle attacks, hostname checks can be done
  to verify that the hostname in an end-entity certificate matches the
  targeted hostname.  TLS does not require such checks, but some protocols
  over TLS (such as HTTPS) do.  In earlier versions of the JDK, the
  certificate chain checks were done at the SSL/TLS layer, and the hostname
  verification checks were done at the layer over TLS.  This class allows
  for the checking to be done during a single call to this class.

  RFC 2830 defines the server identification specification for the `LDAPS`
  algorithm. RFC 2818 defines both the server identification and the
  client identification specification for the `HTTPS` algorithm."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.net.ssl X509ExtendedTrustManager]))

(defn ->x-509-extended-trust-manager
  "Constructor."
  ([]
    (new X509ExtendedTrustManager )))

(defn check-client-trusted
  "Given the partial or complete certificate chain provided by the
   peer, build and validate the certificate path based on the
   authentication type and ssl parameters.

   The authentication type is determined by the actual certificate
   used. For instance, if RSAPublicKey is used, the authType
   should be `RSA`. Checking is case-sensitive.

   If the socket parameter is an instance of
   SSLSocket, and the endpoint identification
   algorithm of the SSLParameters is non-empty, to prevent
   man-in-the-middle attacks, the address that the socket
   connected to should be checked against the peer's identity presented
   in the end-entity X509 certificate, as specified in the endpoint
   identification algorithm.

   If the socket parameter is an instance of
   SSLSocket, and the algorithm constraints of the
   SSLParameters is non-null, for every certificate in the
   certification path, fields such as subject public key, the signature
   algorithm, key usage, extended key usage, etc. need to conform to the
   algorithm constraints in place on this socket.

  chain - the peer certificate chain - `java.security.cert.X509Certificate[]`
  auth-type - the key exchange algorithm used - `java.lang.String`
  socket - the socket used for this connection. This parameter can be null, which indicates that implementations need not check the ssl parameters - `java.net.Socket`

  throws: java.lang.IllegalArgumentException - if null or zero-length array is passed in for the chain parameter or if null or zero-length string is passed in for the authType parameter"
  ([^javax.net.ssl.X509ExtendedTrustManager this ^java.security.cert.X509Certificate[] chain ^java.lang.String auth-type ^java.net.Socket socket]
    (-> this (.checkClientTrusted chain auth-type socket))))

(defn check-server-trusted
  "Given the partial or complete certificate chain provided by the
   peer, build and validate the certificate path based on the
   authentication type and ssl parameters.

   The authentication type is the key exchange algorithm portion
   of the cipher suites represented as a String, such as `RSA`,
   `DHE_DSS`. Note: for some exportable cipher suites, the key
   exchange algorithm is determined at run time during the
   handshake. For instance, for TLS_RSA_EXPORT_WITH_RC4_40_MD5,
   the authType should be RSA_EXPORT when an ephemeral RSA key is
   used for the key exchange, and RSA when the key from the server
   certificate is used. Checking is case-sensitive.

   If the socket parameter is an instance of
   SSLSocket, and the endpoint identification
   algorithm of the SSLParameters is non-empty, to prevent
   man-in-the-middle attacks, the address that the socket
   connected to should be checked against the peer's identity presented
   in the end-entity X509 certificate, as specified in the endpoint
   identification algorithm.

   If the socket parameter is an instance of
   SSLSocket, and the algorithm constraints of the
    SSLParameters is non-null, for every certificate in the
   certification path, fields such as subject public key, the signature
   algorithm, key usage, extended key usage, etc. need to conform to the
   algorithm constraints in place on this socket.

  chain - the peer certificate chain - `java.security.cert.X509Certificate[]`
  auth-type - the key exchange algorithm used - `java.lang.String`
  socket - the socket used for this connection. This parameter can be null, which indicates that implementations need not check the ssl parameters - `java.net.Socket`

  throws: java.lang.IllegalArgumentException - if null or zero-length array is passed in for the chain parameter or if null or zero-length string is passed in for the authType parameter"
  ([^javax.net.ssl.X509ExtendedTrustManager this ^java.security.cert.X509Certificate[] chain ^java.lang.String auth-type ^java.net.Socket socket]
    (-> this (.checkServerTrusted chain auth-type socket))))

