(ns javax.net.ssl.HandshakeCompletedEvent
  "This event indicates that an SSL handshake completed on a given
  SSL connection.  All of the core information about that handshake's
  result is captured through an `SSLSession` object.  As a convenience,
  this event class provides direct access to some important session
  attributes.

   The source of this event is the SSLSocket on which handshaking
  just completed."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.net.ssl HandshakeCompletedEvent]))

(defn ->handshake-completed-event
  "Constructor.

  Constructs a new HandshakeCompletedEvent.

  sock - the SSLSocket acting as the source of the event - `javax.net.ssl.SSLSocket`
  s - the SSLSession this event is associated with - `javax.net.ssl.SSLSession`"
  ([^javax.net.ssl.SSLSocket sock ^javax.net.ssl.SSLSession s]
    (new HandshakeCompletedEvent sock s)))

(defn get-session
  "Returns the session that triggered this event.

  returns: the SSLSession for this handshake - `javax.net.ssl.SSLSession`"
  (^javax.net.ssl.SSLSession [^javax.net.ssl.HandshakeCompletedEvent this]
    (-> this (.getSession))))

(defn get-cipher-suite
  "Returns the cipher suite in use by the session which was produced
   by the handshake.  (This is a convenience method for
   getting the ciphersuite from the SSLsession.)

  returns: the name of the cipher suite negotiated during this session. - `java.lang.String`"
  (^java.lang.String [^javax.net.ssl.HandshakeCompletedEvent this]
    (-> this (.getCipherSuite))))

(defn get-local-certificates
  "Returns the certificate(s) that were sent to the peer during
   handshaking.
   Note: This method is useful only when using certificate-based
   cipher suites.

   When multiple certificates are available for use in a
   handshake, the implementation chooses what it considers the
   `best` certificate chain available, and transmits that to
   the other side.  This method allows the caller to know
   which certificate chain was actually used.

  returns: an ordered array of certificates, with the local
            certificate first followed by any
            certificate authorities.  If no certificates were sent,
            then null is returned. - `java.security.cert.Certificate[]`"
  ([^javax.net.ssl.HandshakeCompletedEvent this]
    (-> this (.getLocalCertificates))))

(defn get-peer-certificates
  "Returns the identity of the peer which was established as part
   of defining the session.
   Note: This method can be used only when using certificate-based
   cipher suites; using it with non-certificate-based cipher suites,
   such as Kerberos, will throw an SSLPeerUnverifiedException.

  returns: an ordered array of the peer certificates,
            with the peer's own certificate first followed by
            any certificate authorities. - `java.security.cert.Certificate[]`

  throws: javax.net.ssl.SSLPeerUnverifiedException - if the peer is not verified."
  ([^javax.net.ssl.HandshakeCompletedEvent this]
    (-> this (.getPeerCertificates))))

(defn get-peer-certificate-chain
  "Returns the identity of the peer which was identified as part
   of defining the session.
   Note: This method can be used only when using certificate-based
   cipher suites; using it with non-certificate-based cipher suites,
   such as Kerberos, will throw an SSLPeerUnverifiedException.

   Note: this method exists for compatibility with previous
   releases. New applications should use
   getPeerCertificates() instead.

  returns: an ordered array of peer X.509 certificates,
            with the peer's own certificate first followed by any
            certificate authorities.  (The certificates are in
            the original JSSE
            X509Certificate format). - `javax.security.cert.X509Certificate[]`

  throws: javax.net.ssl.SSLPeerUnverifiedException - if the peer is not verified."
  ([^javax.net.ssl.HandshakeCompletedEvent this]
    (-> this (.getPeerCertificateChain))))

(defn get-peer-principal
  "Returns the identity of the peer which was established as part of
   defining the session.

  returns: the peer's principal. Returns an X500Principal of the
   end-entity certiticate for X509-based cipher suites, and
   KerberosPrincipal for Kerberos cipher suites. - `java.security.Principal`

  throws: javax.net.ssl.SSLPeerUnverifiedException - if the peer's identity has not been verified"
  (^java.security.Principal [^javax.net.ssl.HandshakeCompletedEvent this]
    (-> this (.getPeerPrincipal))))

(defn get-local-principal
  "Returns the principal that was sent to the peer during handshaking.

  returns: the principal sent to the peer. Returns an X500Principal
   of the end-entity certificate for X509-based cipher suites, and
   KerberosPrincipal for Kerberos cipher suites. If no principal was
   sent, then null is returned. - `java.security.Principal`"
  (^java.security.Principal [^javax.net.ssl.HandshakeCompletedEvent this]
    (-> this (.getLocalPrincipal))))

(defn get-socket
  "Returns the socket which is the source of this event.
   (This is a convenience function, to let applications
   write code without type casts.)

  returns: the socket on which the connection was made. - `javax.net.ssl.SSLSocket`"
  (^javax.net.ssl.SSLSocket [^javax.net.ssl.HandshakeCompletedEvent this]
    (-> this (.getSocket))))

