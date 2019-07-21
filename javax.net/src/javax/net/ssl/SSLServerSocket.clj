(ns javax.net.ssl.SSLServerSocket
  "This class extends ServerSockets and
  provides secure server sockets using protocols such as the Secure
  Sockets Layer (SSL) or Transport Layer Security (TLS) protocols.

  Instances of this class are generally created using a
  SSLServerSocketFactory.  The primary function
  of SSLServerSockets
  is to create SSLSockets by accepting
  connections.

  SSLServerSockets contain several pieces of state data
  which are inherited by the SSLSocket at
  socket creation.  These include the enabled cipher
  suites and protocols, whether client
  authentication is necessary, and whether created sockets should
  begin handshaking in client or server mode.  The state
  inherited by the created SSLSocket can be
  overriden by calling the appropriate methods."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.net.ssl SSLServerSocket]))

(defn get-need-client-auth?
  "Returns true if client authentication will be required on
   newly accepted server-mode SSLSockets.

   The initial inherited setting may be overridden by calling
   SSLSocket.setNeedClientAuth(boolean) or
   SSLSocket.setWantClientAuth(boolean).

  returns: true if client authentication is required,
            or false if no client authentication is desired. - `boolean`"
  (^Boolean [^SSLServerSocket this]
    (-> this (.getNeedClientAuth))))

(defn get-supported-protocols
  "Returns the names of the protocols which could be enabled for use.

  returns: an array of protocol names supported - `java.lang.String[]`"
  ([^SSLServerSocket this]
    (-> this (.getSupportedProtocols))))

(defn set-use-client-mode
  "Controls whether accepted connections are in the (default) SSL
   server mode, or the SSL client mode.

   Servers normally authenticate themselves, and clients are not
   required to do so.

   In rare cases, TCP servers
   need to act in the SSL client mode on newly accepted
   connections. For example, FTP clients acquire server sockets
   and listen there for reverse connections from the server. An
   FTP client would use an SSLServerSocket in \"client\" mode to
   accept the reverse connection while the FTP server uses an
   SSLSocket with \"client\" mode disabled to initiate the
   connection. During the resulting handshake, existing SSL
   sessions may be reused.

   SSLSockets returned from accept()
   inherit this setting.

  mode - true if newly accepted connections should use SSL client mode. - `boolean`"
  ([^SSLServerSocket this ^Boolean mode]
    (-> this (.setUseClientMode mode))))

(defn get-use-client-mode?
  "Returns true if accepted connections will be in SSL client mode.

  returns: true if the connection should use SSL client mode. - `boolean`"
  (^Boolean [^SSLServerSocket this]
    (-> this (.getUseClientMode))))

(defn set-want-client-auth
  "Controls whether accepted server-mode
   SSLSockets will be initially configured to
   request client authentication.

   A socket's client authentication setting is one of the following:

    client authentication required
    client authentication requested
    no client authentication desired


   Unlike setNeedClientAuth(boolean), if the accepted
   socket's option is set and the client chooses not to provide
   authentication information about itself, the negotiations
   will continue.

   Calling this method overrides any previous setting made by
   this method or setNeedClientAuth(boolean).

   The initial inherited setting may be overridden by calling
   SSLSocket.setNeedClientAuth(boolean) or
   SSLSocket.setWantClientAuth(boolean).

  want - set to true if client authentication is requested, or false if no client authentication is desired. - `boolean`"
  ([^SSLServerSocket this ^Boolean want]
    (-> this (.setWantClientAuth want))))

(defn get-ssl-parameters
  "Returns the SSLParameters in effect for newly accepted connections.
   The ciphersuites and protocols of the returned SSLParameters
   are always non-null.

  returns: the SSLParameters in effect for newly accepted connections - `javax.net.ssl.SSLParameters`"
  (^javax.net.ssl.SSLParameters [^SSLServerSocket this]
    (-> this (.getSSLParameters))))

(defn get-enabled-cipher-suites
  "Returns the list of cipher suites which are currently enabled
   for use by newly accepted connections.

   If this list has not been explicitly modified, a system-provided
   default guarantees a minimum quality of service in all enabled
   cipher suites.

   There are several reasons why an enabled cipher suite might
   not actually be used.  For example:  the server socket might
   not have appropriate private keys available to it or the cipher
   suite might be anonymous, precluding the use of client authentication,
   while the server socket has been told to require that sort of
   authentication.

  returns: an array of cipher suites enabled - `java.lang.String[]`"
  ([^SSLServerSocket this]
    (-> this (.getEnabledCipherSuites))))

(defn get-supported-cipher-suites
  "Returns the names of the cipher suites which could be enabled for use
   on an SSL connection.

   Normally, only a subset of these will actually
   be enabled by default, since this list may include cipher suites which
   do not meet quality of service requirements for those defaults.  Such
   cipher suites are useful in specialized applications.

  returns: an array of cipher suite names - `java.lang.String[]`"
  ([^SSLServerSocket this]
    (-> this (.getSupportedCipherSuites))))

(defn set-ssl-parameters
  "Applies SSLParameters to newly accepted connections.

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
  ([^SSLServerSocket this ^javax.net.ssl.SSLParameters params]
    (-> this (.setSSLParameters params))))

(defn set-enabled-cipher-suites
  "Sets the cipher suites enabled for use by accepted connections.

   The cipher suites must have been listed by getSupportedCipherSuites()
   as being supported.  Following a successful call to this method,
   only suites listed in the suites parameter are enabled
   for use.

   Suites that require authentication information which is not available
   in this ServerSocket's authentication context will not be used
   in any case, even if they are enabled.

   SSLSockets returned from accept()
   inherit this setting.

  suites - Names of all the cipher suites to enable - `java.lang.String[]`

  throws: java.lang.IllegalArgumentException - when one or more of ciphers named by the parameter is not supported, or when the parameter is null."
  ([^SSLServerSocket this suites]
    (-> this (.setEnabledCipherSuites suites))))

(defn get-enable-session-creation?
  "Returns true if new SSL sessions may be established by the
   sockets which are created from this server socket.

  returns: true indicates that sessions may be created; this
            is the default.  false indicates that an existing
            session must be resumed - `boolean`"
  (^Boolean [^SSLServerSocket this]
    (-> this (.getEnableSessionCreation))))

(defn set-enable-session-creation
  "Controls whether new SSL sessions may be established by the
   sockets which are created from this server socket.

   SSLSockets returned from accept()
   inherit this setting.

  flag - true indicates that sessions may be created; this is the default. false indicates that an existing session must be resumed. - `boolean`"
  ([^SSLServerSocket this ^Boolean flag]
    (-> this (.setEnableSessionCreation flag))))

(defn set-enabled-protocols
  "Controls which particular protocols are enabled for use by
   accepted connections.

   The protocols must have been listed by
   getSupportedProtocols() as being supported.
   Following a successful call to this method, only protocols listed
   in the protocols parameter are enabled for use.

   SSLSockets returned from accept()
   inherit this setting.

  protocols - Names of all the protocols to enable. - `java.lang.String[]`

  throws: java.lang.IllegalArgumentException - when one or more of the protocols named by the parameter is not supported or when the protocols parameter is null."
  ([^SSLServerSocket this protocols]
    (-> this (.setEnabledProtocols protocols))))

(defn set-need-client-auth
  "Controls whether accepted server-mode
   SSLSockets will be initially configured to
   require client authentication.

   A socket's client authentication setting is one of the following:

    client authentication required
    client authentication requested
    no client authentication desired


   Unlike setWantClientAuth(boolean), if the accepted
   socket's option is set and the client chooses not to provide
   authentication information about itself, the negotiations
   will stop and the connection will be dropped.

   Calling this method overrides any previous setting made by
   this method or setWantClientAuth(boolean).

   The initial inherited setting may be overridden by calling
   SSLSocket.setNeedClientAuth(boolean) or
   SSLSocket.setWantClientAuth(boolean).

  need - set to true if client authentication is required, or false if no client authentication is desired. - `boolean`"
  ([^SSLServerSocket this ^Boolean need]
    (-> this (.setNeedClientAuth need))))

(defn get-enabled-protocols
  "Returns the names of the protocols which are currently
   enabled for use by the newly accepted connections.

  returns: an array of protocol names - `java.lang.String[]`"
  ([^SSLServerSocket this]
    (-> this (.getEnabledProtocols))))

(defn get-want-client-auth?
  "Returns true if client authentication will be requested on
   newly accepted server-mode connections.

   The initial inherited setting may be overridden by calling
   SSLSocket.setNeedClientAuth(boolean) or
   SSLSocket.setWantClientAuth(boolean).

  returns: true if client authentication is requested,
            or false if no client authentication is desired. - `boolean`"
  (^Boolean [^SSLServerSocket this]
    (-> this (.getWantClientAuth))))

