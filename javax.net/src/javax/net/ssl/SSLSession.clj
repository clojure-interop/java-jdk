(ns javax.net.ssl.SSLSession
  "In SSL, sessions are used to describe an ongoing relationship between
  two entities.  Each SSL connection involves one session at a time, but
  that session may be used on many connections between those entities,
  simultaneously or sequentially.  The session used on a connection may
  also be replaced by a different session.  Sessions are created, or
  rejoined, as part of the SSL handshaking protocol. Sessions may be
  invalidated due to policies affecting security or resource usage,
  or by an application explicitly calling invalidate.
  Session management policies are typically used to tune performance.

   In addition to the standard session attributes, SSL sessions expose
  these read-only attributes:

        Peer Identity.  Sessions are between a particular
       client and a particular server.  The identity of the peer may
       have been established as part of session setup.  Peers are
       generally identified by X.509 certificate chains.

        Cipher Suite Name.  Cipher suites describe the
       kind of cryptographic protection that's used by connections
       in a particular session.

        Peer Host.  All connections in a session are
       between the same two hosts.  The address of the host on the other
       side of the connection is available.



   Sessions may be explicitly invalidated.  Invalidation may also
  be done implicitly, when faced with certain kinds of errors."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.net.ssl SSLSession]))

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
            the original JSSE certificate
            X509Certificate format.) - `javax.security.cert.X509Certificate[]`

  throws: javax.net.ssl.SSLPeerUnverifiedException - if the peer's identity has not been verified"
  ([^javax.net.ssl.SSLSession this]
    (-> this (.getPeerCertificateChain))))

(defn get-cipher-suite
  "Returns the name of the SSL cipher suite which is used for all
   connections in the session.

    This defines the level of protection
   provided to the data sent on the connection, including the kind
   of encryption used and most aspects of how authentication is done.

  returns: the name of the session's cipher suite - `java.lang.String`"
  ([^javax.net.ssl.SSLSession this]
    (-> this (.getCipherSuite))))

(defn get-local-principal
  "Returns the principal that was sent to the peer during handshaking.

  returns: the principal sent to the peer. Returns an X500Principal
   of the end-entity certificate for X509-based cipher suites, and
   KerberosPrincipal for Kerberos cipher suites. If no principal was
   sent, then null is returned. - `java.security.Principal`"
  ([^javax.net.ssl.SSLSession this]
    (-> this (.getLocalPrincipal))))

(defn put-value
  "Binds the specified value object into the
   session's application layer data
   with the given name.

   Any existing binding using the same name is
   replaced.  If the new (or existing) value implements the
   SSLSessionBindingListener interface, the object
   represented by value is notified appropriately.

   For security reasons, the same named values may not be
   visible across different access control contexts.

  name - the name to which the data object will be bound. This may not be null. - `java.lang.String`
  value - the data object to be bound. This may not be null. - `java.lang.Object`

  throws: java.lang.IllegalArgumentException - if either argument is null."
  ([^javax.net.ssl.SSLSession this ^java.lang.String name ^java.lang.Object value]
    (-> this (.putValue name value))))

(defn remove-value
  "Removes the object bound to the given name in the session's
   application layer data.  Does nothing if there is no object
   bound to the given name.  If the bound existing object
   implements the SessionBindingListener interface,
   it is notified appropriately.

   For security reasons, the same named values may not be
   visible across different access control contexts.

  name - the name of the object to remove visible across different access control contexts - `java.lang.String`

  throws: java.lang.IllegalArgumentException - if the argument is null."
  ([^javax.net.ssl.SSLSession this ^java.lang.String name]
    (-> this (.removeValue name))))

(defn get-value
  "Returns the object bound to the given name in the session's
   application layer data.  Returns null if there is no such binding.

   For security reasons, the same named values may not be
   visible across different access control contexts.

  name - the name of the binding to find. - `java.lang.String`

  returns: the value bound to that name, or null if the binding does
            not exist. - `java.lang.Object`

  throws: java.lang.IllegalArgumentException - if the argument is null."
  ([^javax.net.ssl.SSLSession this ^java.lang.String name]
    (-> this (.getValue name))))

(defn get-packet-buffer-size
  "Gets the current size of the largest SSL/TLS packet that is expected
   when using this session.

   A SSLEngine using this session may generate SSL/TLS
   packets of any size up to and including the value returned by this
   method. All SSLEngine network buffers should be sized
   at least this large to avoid insufficient space problems when
   performing wrap and unwrap calls.

  returns: the current maximum expected network packet size - `int`"
  ([^javax.net.ssl.SSLSession this]
    (-> this (.getPacketBufferSize))))

(defn invalidate
  "Invalidates the session.

   Future connections will not be able to
   resume or join this session.  However, any existing connection
   using this session can continue to use the session until the
   connection is closed."
  ([^javax.net.ssl.SSLSession this]
    (-> this (.invalidate))))

(defn get-id
  "Returns the identifier assigned to this Session.

  returns: the Session identifier - `byte[]`"
  ([^javax.net.ssl.SSLSession this]
    (-> this (.getId))))

(defn get-peer-certificates
  "Returns the identity of the peer which was established as part
   of defining the session.

   Note: This method can be used only when using certificate-based
   cipher suites; using it with non-certificate-based cipher suites,
   such as Kerberos, will throw an SSLPeerUnverifiedException.

  returns: an ordered array of peer certificates,
            with the peer's own certificate first followed by any
            certificate authorities. - `java.security.cert.Certificate[]`

  throws: javax.net.ssl.SSLPeerUnverifiedException - if the peer's identity has not been verified"
  ([^javax.net.ssl.SSLSession this]
    (-> this (.getPeerCertificates))))

(defn get-peer-host
  "Returns the host name of the peer in this session.

   For the server, this is the client's host;  and for
   the client, it is the server's host. The name may not be
   a fully qualified host name or even a host name at all as
   it may represent a string encoding of the peer's network address.
   If such a name is desired, it might
   be resolved through a name service based on the value returned
   by this method.

   This value is not authenticated and should not be relied upon.
   It is mainly used as a hint for SSLSession caching
   strategies.

  returns: the host name of the peer host, or null if no information
            is available. - `java.lang.String`"
  ([^javax.net.ssl.SSLSession this]
    (-> this (.getPeerHost))))

(defn valid?
  "Returns whether this session is valid and available for resuming or
   joining.

  returns: true if this session may be rejoined. - `boolean`"
  ([^javax.net.ssl.SSLSession this]
    (-> this (.isValid))))

(defn get-session-context
  "Returns the context in which this session is bound.

   This context may be unavailable in some environments,
   in which case this method returns null.

   If the context is available and there is a
   security manager installed, the caller may require
   permission to access it or a security exception may be thrown.
   In a Java environment, the security manager's
   checkPermission method is called with a
   SSLPermission(`getSSLSessionContext`) permission.

  returns: the session context used for this session, or null
   if the context is unavailable. - `javax.net.ssl.SSLSessionContext`

  throws: java.lang.SecurityException - if the calling thread does not have permission to get SSL session context."
  ([^javax.net.ssl.SSLSession this]
    (-> this (.getSessionContext))))

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

  returns: an ordered array of certificates,
   with the local certificate first followed by any
   certificate authorities.  If no certificates were sent,
   then null is returned. - `java.security.cert.Certificate[]`"
  ([^javax.net.ssl.SSLSession this]
    (-> this (.getLocalCertificates))))

(defn get-protocol
  "Returns the standard name of the protocol used for all
   connections in the session.

    This defines the protocol used in the connection.

  returns: the standard name of the protocol used for all
   connections in the session. - `java.lang.String`"
  ([^javax.net.ssl.SSLSession this]
    (-> this (.getProtocol))))

(defn get-value-names
  "Returns an array of the names of all the application layer
   data objects bound into the Session.

   For security reasons, the same named values may not be
   visible across different access control contexts.

  returns: a non-null (possibly empty) array of names of the objects
    bound to this Session. - `java.lang.String[]`"
  ([^javax.net.ssl.SSLSession this]
    (-> this (.getValueNames))))

(defn get-application-buffer-size
  "Gets the current size of the largest application data that is
   expected when using this session.

   SSLEngine application data buffers must be large
   enough to hold the application data from any inbound network
   application data packet received.  Typically, outbound
   application data buffers can be of any size.

  returns: the current maximum expected application packet size - `int`"
  ([^javax.net.ssl.SSLSession this]
    (-> this (.getApplicationBufferSize))))

(defn get-peer-principal
  "Returns the identity of the peer which was established as part of
   defining the session.

  returns: the peer's principal. Returns an X500Principal of the
   end-entity certiticate for X509-based cipher suites, and
   KerberosPrincipal for Kerberos cipher suites. - `java.security.Principal`

  throws: javax.net.ssl.SSLPeerUnverifiedException - if the peer's identity has not been verified"
  ([^javax.net.ssl.SSLSession this]
    (-> this (.getPeerPrincipal))))

(defn get-peer-port
  "Returns the port number of the peer in this session.

   For the server, this is the client's port number;  and for
   the client, it is the server's port number.

   This value is not authenticated and should not be relied upon.
   It is mainly used as a hint for SSLSession caching
   strategies.

  returns: the port number of the peer host, or -1 if no information
            is available. - `int`"
  ([^javax.net.ssl.SSLSession this]
    (-> this (.getPeerPort))))

(defn get-last-accessed-time
  "Returns the last time this Session representation was accessed by the
   session level infrastructure, in milliseconds since
   midnight, January 1, 1970 UTC.

   Access indicates a new connection being established using session data.
   Application level operations, such as getting or setting a value
   associated with the session, are not reflected in this access time.

    This information is particularly useful in session management
   policies.  For example, a session manager thread could leave all
   sessions in a given context which haven't been used in a long time;
   or, the sessions might be sorted according to age to optimize some task.

  returns: the last time this Session was accessed - `long`"
  ([^javax.net.ssl.SSLSession this]
    (-> this (.getLastAccessedTime))))

(defn get-creation-time
  "Returns the time at which this Session representation was created,
   in milliseconds since midnight, January 1, 1970 UTC.

  returns: the time this Session was created - `long`"
  ([^javax.net.ssl.SSLSession this]
    (-> this (.getCreationTime))))

