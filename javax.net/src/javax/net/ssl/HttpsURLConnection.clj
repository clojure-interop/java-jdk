(ns javax.net.ssl.HttpsURLConnection
  "HttpsURLConnection extends HttpURLConnection
  with support for https-specific features.

  See
  http://www.w3.org/pub/WWW/Protocols/ and
   RFC 2818
  for more details on the
  https specification.

  This class uses HostnameVerifier and
  SSLSocketFactory.
  There are default implementations defined for both classes.
  However, the implementations can be replaced on a per-class (static) or
  per-instance basis.  All new HttpsURLConnections instances
  will be assigned
  the \"default\" static values at instance creation, but they can be overriden
  by calling the appropriate per-instance set method(s) before
  connecting."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.net.ssl HttpsURLConnection]))

(defn *set-default-hostname-verifier
  "Sets the default HostnameVerifier inherited by a
   new instance of this class.

   If this method is not called, the default
   HostnameVerifier assumes the connection should not
   be permitted.

  v - the default host name verifier - `javax.net.ssl.HostnameVerifier`

  throws: java.lang.IllegalArgumentException - if the HostnameVerifier parameter is null."
  ([^javax.net.ssl.HostnameVerifier v]
    (HttpsURLConnection/setDefaultHostnameVerifier v)))

(defn *get-default-hostname-verifier
  "Gets the default HostnameVerifier that is inherited
   by new instances of this class.

  returns: the default host name verifier - `javax.net.ssl.HostnameVerifier`"
  (^javax.net.ssl.HostnameVerifier []
    (HttpsURLConnection/getDefaultHostnameVerifier )))

(defn *set-default-ssl-socket-factory
  "Sets the default SSLSocketFactory inherited by new
   instances of this class.

   The socket factories are used when creating sockets for secure
   https URL connections.

  sf - the default SSL socket factory - `javax.net.ssl.SSLSocketFactory`

  throws: java.lang.IllegalArgumentException - if the SSLSocketFactory parameter is null."
  ([^javax.net.ssl.SSLSocketFactory sf]
    (HttpsURLConnection/setDefaultSSLSocketFactory sf)))

(defn *get-default-ssl-socket-factory
  "Gets the default static SSLSocketFactory that is
   inherited by new instances of this class.

   The socket factories are used when creating sockets for secure
   https URL connections.

  returns: the default SSLSocketFactory - `javax.net.ssl.SSLSocketFactory`"
  (^javax.net.ssl.SSLSocketFactory []
    (HttpsURLConnection/getDefaultSSLSocketFactory )))

(defn get-cipher-suite
  "Returns the cipher suite in use on this connection.

  returns: the cipher suite - `java.lang.String`

  throws: java.lang.IllegalStateException - if this method is called before the connection has been established."
  (^java.lang.String [^HttpsURLConnection this]
    (-> this (.getCipherSuite))))

(defn get-local-principal
  "Returns the principal that was sent to the server during handshaking.

   Note: Subclasses should override this method. If not overridden, it
   will default to returning the X500Principal of the end-entity certificate
   that was sent to the server for certificate-based ciphersuites or,
   return null for non-certificate based ciphersuites, such as Kerberos.

  returns: the principal sent to the server. Returns an X500Principal
   of the end-entity certificate for X509-based cipher suites, and
   KerberosPrincipal for Kerberos cipher suites. If no principal was
   sent, then null is returned. - `java.security.Principal`

  throws: java.lang.IllegalStateException - if this method is called before the connection has been established."
  (^java.security.Principal [^HttpsURLConnection this]
    (-> this (.getLocalPrincipal))))

(defn get-hostname-verifier
  "Gets the HostnameVerifier in place on this instance.

  returns: the host name verifier - `javax.net.ssl.HostnameVerifier`"
  (^javax.net.ssl.HostnameVerifier [^HttpsURLConnection this]
    (-> this (.getHostnameVerifier))))

(defn set-ssl-socket-factory
  "Sets the SSLSocketFactory to be used when this instance
   creates sockets for secure https URL connections.

   New instances of this class inherit the default static
   SSLSocketFactory set by
   setDefaultSSLSocketFactory.  Calls to this method replace
   this object's SSLSocketFactory.

  sf - the SSL socket factory - `javax.net.ssl.SSLSocketFactory`

  throws: java.lang.IllegalArgumentException - if the SSLSocketFactory parameter is null."
  ([^HttpsURLConnection this ^javax.net.ssl.SSLSocketFactory sf]
    (-> this (.setSSLSocketFactory sf))))

(defn get-server-certificates
  "Returns the server's certificate chain which was established
   as part of defining the session.

   Note: This method can be used only when using certificate-based
   cipher suites; using it with non-certificate-based cipher suites,
   such as Kerberos, will throw an SSLPeerUnverifiedException.

  returns: an ordered array of server certificates,
            with the peer's own certificate first followed by
            any certificate authorities. - `java.security.cert.Certificate[]`

  throws: javax.net.ssl.SSLPeerUnverifiedException - if the peer is not verified."
  ([^HttpsURLConnection this]
    (-> this (.getServerCertificates))))

(defn set-hostname-verifier
  "Sets the HostnameVerifier for this instance.

   New instances of this class inherit the default static hostname
   verifier set by setDefaultHostnameVerifier.  Calls to this method replace
   this object's HostnameVerifier.

  v - the host name verifier - `javax.net.ssl.HostnameVerifier`

  throws: java.lang.IllegalArgumentException - if the HostnameVerifier parameter is null."
  ([^HttpsURLConnection this ^javax.net.ssl.HostnameVerifier v]
    (-> this (.setHostnameVerifier v))))

(defn get-ssl-socket-factory
  "Gets the SSL socket factory to be used when creating sockets
   for secure https URL connections.

  returns: the SSLSocketFactory - `javax.net.ssl.SSLSocketFactory`"
  (^javax.net.ssl.SSLSocketFactory [^HttpsURLConnection this]
    (-> this (.getSSLSocketFactory))))

(defn get-local-certificates
  "Returns the certificate(s) that were sent to the server during
   handshaking.

   Note: This method is useful only when using certificate-based
   cipher suites.

   When multiple certificates are available for use in a
   handshake, the implementation chooses what it considers the
   \"best\" certificate chain available, and transmits that to
   the other side.  This method allows the caller to know
   which certificate chain was actually sent.

  returns: an ordered array of certificates,
            with the client's own certificate first followed by any
            certificate authorities.  If no certificates were sent,
            then null is returned. - `java.security.cert.Certificate[]`

  throws: java.lang.IllegalStateException - if this method is called before the connection has been established."
  ([^HttpsURLConnection this]
    (-> this (.getLocalCertificates))))

(defn get-peer-principal
  "Returns the server's principal which was established as part of
   defining the session.

   Note: Subclasses should override this method. If not overridden, it
   will default to returning the X500Principal of the server's end-entity
   certificate for certificate-based ciphersuites, or throw an
   SSLPeerUnverifiedException for non-certificate based ciphersuites,
   such as Kerberos.

  returns: the server's principal. Returns an X500Principal of the
   end-entity certiticate for X509-based cipher suites, and
   KerberosPrincipal for Kerberos cipher suites. - `java.security.Principal`

  throws: javax.net.ssl.SSLPeerUnverifiedException - if the peer was not verified"
  (^java.security.Principal [^HttpsURLConnection this]
    (-> this (.getPeerPrincipal))))

