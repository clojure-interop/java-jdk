(ns javax.net.ssl.SSLSocket
  "This class extends Sockets and provides secure
  socket using protocols such as the \"Secure
  Sockets Layer\" (SSL) or IETF \"Transport Layer Security\" (TLS) protocols.

  Such sockets are normal stream sockets, but they
  add a layer of security protections over the underlying network transport
  protocol, such as TCP.  Those protections include:

        Integrity Protection.  SSL protects against
       modification of messages by an active wiretapper.

        Authentication.  In most modes, SSL provides
       peer authentication.  Servers are usually authenticated,
       and clients may be authenticated as requested by servers.

        Confidentiality (Privacy Protection).  In most
       modes, SSL encrypts data being sent between client and server.
       This protects the confidentiality of data, so that passive
       wiretappers won't see sensitive data such as financial
       information or personal information of many kinds.



  These kinds of protection are specified by a \"cipher suite\", which
  is a combination of cryptographic algorithms used by a given SSL connection.
  During the negotiation process, the two endpoints must agree on
  a ciphersuite that is available in both environments.
  If there is no such suite in common, no SSL connection can
  be established, and no data can be exchanged.

   The cipher suite used is established by a negotiation process
  called \"handshaking\".  The goal of this
  process is to create or rejoin a \"session\", which may protect many
  connections over time.  After handshaking has completed, you can access
  session attributes by using the getSession method.
  The initial handshake on this connection can be initiated in
  one of three ways:

        calling startHandshake which explicitly
               begins handshakes, or
        any attempt to read or write application data on
               this socket causes an implicit handshake, or
        a call to getSession tries to set up a session
               if there is no currently valid session, and
               an implicit handshake is done.


  If handshaking fails for any reason, the SSLSocket
  is closed, and no further communications can be done.

  There are two groups of cipher suites which you will need to know
  about when managing cipher suites:

        Supported cipher suites:  all the suites which are
       supported by the SSL implementation.  This list is reported
       using getSupportedCipherSuites.

        Enabled cipher suites, which may be fewer
       than the full set of supported suites.  This group is
       set using the setEnabledCipherSuites method, and
       queried using the getEnabledCipherSuites method.
       Initially, a default set of cipher suites will be enabled on
       a new socket that represents the minimum suggested configuration.



   Implementation defaults require that only cipher
  suites which authenticate servers and provide confidentiality
  be enabled by default.
  Only if both sides explicitly agree to unauthenticated and/or
  non-private (unencrypted) communications will such a ciphersuite be
  selected.

  When SSLSockets are first created, no handshaking
  is done so that applications may first set their communication
  preferences:  what cipher suites to use, whether the socket should be
  in client or server mode, etc.
  However, security is always provided by the time that application data
  is sent over the connection.

   You may register to receive event notification of handshake
  completion.  This involves
  the use of two additional classes.  HandshakeCompletedEvent
  objects are passed to HandshakeCompletedListener instances,
  which are registered by users of this API.

  SSLSockets are created by SSLSocketFactorys,
  or by accepting a connection from a
  SSLServerSocket.

  A SSL socket must choose to operate in the client or server mode.
  This will determine who begins the handshaking process, as well
  as which messages should be sent by each party.  Each
  connection must have one client and one server, or handshaking
  will not progress properly.  Once the initial handshaking has started, a
  socket can not switch between client and server modes, even when
  performing renegotiations."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.net.ssl SSLSocket]))

(defn get-need-client-auth?
  "Returns true if the socket will require client authentication.
   This option is only useful to sockets in the server mode.

  returns: true if client authentication is required,
            or false if no client authentication is desired. - `boolean`"
  (^Boolean [^SSLSocket this]
    (-> this (.getNeedClientAuth))))

(defn get-supported-protocols
  "Returns the names of the protocols which could be enabled for use
   on an SSL connection.

  returns: an array of protocols supported - `java.lang.String[]`"
  ([^SSLSocket this]
    (-> this (.getSupportedProtocols))))

(defn get-handshake-session
  "Returns the SSLSession being constructed during a SSL/TLS
   handshake.

   TLS protocols may negotiate parameters that are needed when using
   an instance of this class, but before the SSLSession has
   been completely initialized and made available via getSession.
   For example, the list of valid signature algorithms may restrict
   the type of certificates that can used during TrustManager
   decisions, or the maximum TLS fragment packet sizes can be
   resized to better support the network environment.

   This method provides early access to the SSLSession being
   constructed.  Depending on how far the handshake has progressed,
   some data may not yet be available for use.  For example, if a
   remote server will be sending a Certificate chain, but that chain
   has yet not been processed, the getPeerCertificates
   method of SSLSession will throw a
   SSLPeerUnverifiedException.  Once that chain has been processed,
   getPeerCertificates will return the proper value.

   Unlike getSession(), this method does not initiate the
   initial handshake and does not block until handshaking is
   complete.

  returns: null if this instance is not currently handshaking, or
           if the current handshake has not progressed far enough to
           create a basic SSLSession.  Otherwise, this method returns the
           SSLSession currently being negotiated. - `javax.net.ssl.SSLSession`

  throws: java.lang.UnsupportedOperationException - if the underlying provider does not implement the operation."
  (^javax.net.ssl.SSLSession [^SSLSocket this]
    (-> this (.getHandshakeSession))))

(defn set-use-client-mode
  "Configures the socket to use client (or server) mode when
   handshaking.

   This method must be called before any handshaking occurs.
   Once handshaking has begun, the mode can not be reset for the
   life of this socket.

   Servers normally authenticate themselves, and clients
   are not required to do so.

  mode - true if the socket should start its handshaking in \"client\" mode - `boolean`

  throws: java.lang.IllegalArgumentException - if a mode change is attempted after the initial handshake has begun."
  ([^SSLSocket this ^Boolean mode]
    (-> this (.setUseClientMode mode))))

(defn remove-handshake-completed-listener
  "Removes a previously registered handshake completion listener.

  listener - the HandShake Completed event listener - `javax.net.ssl.HandshakeCompletedListener`

  throws: java.lang.IllegalArgumentException - if the listener is not registered, or the argument is null."
  ([^SSLSocket this ^javax.net.ssl.HandshakeCompletedListener listener]
    (-> this (.removeHandshakeCompletedListener listener))))

(defn get-use-client-mode?
  "Returns true if the socket is set to use client mode when
   handshaking.

  returns: true if the socket should do handshaking
            in \"client\" mode - `boolean`"
  (^Boolean [^SSLSocket this]
    (-> this (.getUseClientMode))))

(defn set-want-client-auth
  "Configures the socket to request client authentication.
   This option is only useful for sockets in the server mode.

   A socket's client authentication setting is one of the following:

    client authentication required
    client authentication requested
    no client authentication desired


   Unlike setNeedClientAuth(boolean), if this option is set and
   the client chooses not to provide authentication information
   about itself, the negotiations will continue.

   Calling this method overrides any previous setting made by
   this method or setNeedClientAuth(boolean).

  want - set to true if client authentication is requested, or false if no client authentication is desired. - `boolean`"
  ([^SSLSocket this ^Boolean want]
    (-> this (.setWantClientAuth want))))

(defn get-ssl-parameters
  "Returns the SSLParameters in effect for this SSLSocket.
   The ciphersuites and protocols of the returned SSLParameters
   are always non-null.

  returns: the SSLParameters in effect for this SSLSocket. - `javax.net.ssl.SSLParameters`"
  (^javax.net.ssl.SSLParameters [^SSLSocket this]
    (-> this (.getSSLParameters))))

(defn get-session
  "Returns the SSL Session in use by this connection.  These can
   be long lived, and frequently correspond to an entire login session
   for some user.  The session specifies a particular cipher suite
   which is being actively used by all connections in that session,
   as well as the identities of the session's client and server.

   This method will initiate the initial handshake if
   necessary and then block until the handshake has been
   established.

   If an error occurs during the initial handshake, this method
   returns an invalid session object which reports an invalid
   cipher suite of \"SSL_NULL_WITH_NULL_NULL\".

  returns: the SSLSession - `javax.net.ssl.SSLSession`"
  (^javax.net.ssl.SSLSession [^SSLSocket this]
    (-> this (.getSession))))

(defn get-enabled-cipher-suites
  "Returns the names of the SSL cipher suites which are currently
   enabled for use on this connection.  When an SSLSocket is first
   created, all enabled cipher suites support a minimum quality of
   service.  Thus, in some environments this value might be empty.

   Even if a suite has been enabled, it might never be used.  (For
   example, the peer does not support it, the requisite certificates
   (and private keys) for the suite are not available, or an
   anonymous suite is enabled but authentication is required.

  returns: an array of cipher suite names - `java.lang.String[]`"
  ([^SSLSocket this]
    (-> this (.getEnabledCipherSuites))))

(defn get-supported-cipher-suites
  "Returns the names of the cipher suites which could be enabled for use
   on this connection.  Normally, only a subset of these will actually
   be enabled by default, since this list may include cipher suites which
   do not meet quality of service requirements for those defaults.  Such
   cipher suites might be useful in specialized applications.

  returns: an array of cipher suite names - `java.lang.String[]`"
  ([^SSLSocket this]
    (-> this (.getSupportedCipherSuites))))

(defn set-ssl-parameters
  "Applies SSLParameters to this socket.

   This means:

   If params.getCipherSuites() is non-null,
     setEnabledCipherSuites() is called with that value.
   If params.getProtocols() is non-null,
     setEnabledProtocols() is called with that value.
   If params.getNeedClientAuth() or
     params.getWantClientAuth() return true,
     setNeedClientAuth(true) and
     setWantClientAuth(true) are called, respectively;
     otherwise setWantClientAuth(false) is called.
   If params.getServerNames() is non-null, the socket will
     configure its server names with that value.
   If params.getSNIMatchers() is non-null, the socket will
     configure its SNI matchers with that value.

  params - the parameters - `javax.net.ssl.SSLParameters`

  throws: java.lang.IllegalArgumentException - if the setEnabledCipherSuites() or the setEnabledProtocols() call fails"
  ([^SSLSocket this ^javax.net.ssl.SSLParameters params]
    (-> this (.setSSLParameters params))))

(defn start-handshake
  "Starts an SSL handshake on this connection.  Common reasons include
   a need to use new encryption keys, to change cipher suites, or to
   initiate a new session.  To force complete reauthentication, the
   current session could be invalidated before starting this handshake.

    If data has already been sent on the connection, it continues
   to flow during this handshake.  When the handshake completes, this
   will be signaled with an event.

   This method is synchronous for the initial handshake on a connection
   and returns when the negotiated handshake is complete. Some
   protocols may not support multiple handshakes on an existing socket
   and may throw an IOException.

  throws: java.io.IOException - on a network level error"
  ([^SSLSocket this]
    (-> this (.startHandshake))))

(defn set-enabled-cipher-suites
  "Sets the cipher suites enabled for use on this connection.

   Each cipher suite in the suites parameter must have
   been listed by getSupportedCipherSuites(), or the method will
   fail.  Following a successful call to this method, only suites
   listed in the suites parameter are enabled for use.

   See getEnabledCipherSuites() for more information
   on why a specific ciphersuite may never be used on a connection.

  suites - Names of all the cipher suites to enable - `java.lang.String[]`

  throws: java.lang.IllegalArgumentException - when one or more of the ciphers named by the parameter is not supported, or when the parameter is null."
  ([^SSLSocket this suites]
    (-> this (.setEnabledCipherSuites suites))))

(defn get-enable-session-creation?
  "Returns true if new SSL sessions may be established by this socket.

  returns: true indicates that sessions may be created; this
            is the default.  false indicates that an existing session
            must be resumed - `boolean`"
  (^Boolean [^SSLSocket this]
    (-> this (.getEnableSessionCreation))))

(defn add-handshake-completed-listener
  "Registers an event listener to receive notifications that an
   SSL handshake has completed on this connection.

  listener - the HandShake Completed event listener - `javax.net.ssl.HandshakeCompletedListener`

  throws: java.lang.IllegalArgumentException - if the argument is null."
  ([^SSLSocket this ^javax.net.ssl.HandshakeCompletedListener listener]
    (-> this (.addHandshakeCompletedListener listener))))

(defn set-enable-session-creation
  "Controls whether new SSL sessions may be established by this socket.
   If session creations are not allowed, and there are no
   existing sessions to resume, there will be no successful
   handshaking.

  flag - true indicates that sessions may be created; this is the default. false indicates that an existing session must be resumed - `boolean`"
  ([^SSLSocket this ^Boolean flag]
    (-> this (.setEnableSessionCreation flag))))

(defn set-enabled-protocols
  "Sets the protocol versions enabled for use on this connection.

   The protocols must have been listed by
   getSupportedProtocols() as being supported.
   Following a successful call to this method, only protocols listed
   in the protocols parameter are enabled for use.

  protocols - Names of all the protocols to enable. - `java.lang.String[]`

  throws: java.lang.IllegalArgumentException - when one or more of the protocols named by the parameter is not supported or when the protocols parameter is null."
  ([^SSLSocket this protocols]
    (-> this (.setEnabledProtocols protocols))))

(defn set-need-client-auth
  "Configures the socket to require client authentication.  This
   option is only useful for sockets in the server mode.

   A socket's client authentication setting is one of the following:

    client authentication required
    client authentication requested
    no client authentication desired


   Unlike setWantClientAuth(boolean), if this option is set and
   the client chooses not to provide authentication information
   about itself, the negotiations will stop and the connection
   will be dropped.

   Calling this method overrides any previous setting made by
   this method or setWantClientAuth(boolean).

  need - set to true if client authentication is required, or false if no client authentication is desired. - `boolean`"
  ([^SSLSocket this ^Boolean need]
    (-> this (.setNeedClientAuth need))))

(defn get-enabled-protocols
  "Returns the names of the protocol versions which are currently
   enabled for use on this connection.

  returns: an array of protocols - `java.lang.String[]`"
  ([^SSLSocket this]
    (-> this (.getEnabledProtocols))))

(defn get-want-client-auth?
  "Returns true if the socket will request client authentication.
   This option is only useful for sockets in the server mode.

  returns: true if client authentication is requested,
            or false if no client authentication is desired. - `boolean`"
  (^Boolean [^SSLSocket this]
    (-> this (.getWantClientAuth))))

