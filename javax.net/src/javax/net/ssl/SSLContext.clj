(ns javax.net.ssl.SSLContext
  "Instances of this class represent a secure socket protocol
  implementation which acts as a factory for secure socket
  factories or SSLEngines. This class is initialized
  with an optional set of key and trust managers and source of
  secure random bytes.

   Every implementation of the Java platform is required to support the
  following standard SSLContext protocol:

  TLSv1

  This protocol is described in the
  SSLContext section of the
  Java Cryptography Architecture Standard Algorithm Name Documentation.
  Consult the release documentation for your implementation to see if any
  other algorithms are supported."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.net.ssl SSLContext]))

(defn *get-default
  "Returns the default SSL context.

   If a default context was set using the SSLContext.setDefault() method, it is returned. Otherwise, the first
   call of this method triggers the call
   SSLContext.getInstance(\"Default\").
   If successful, that object is made the default SSL context and returned.

   The default context is immediately
   usable and does not require initialization.

  returns: the default SSL context - `javax.net.ssl.SSLContext`

  throws: java.security.NoSuchAlgorithmException - if the SSLContext.getInstance() call fails"
  (^javax.net.ssl.SSLContext []
    (SSLContext/getDefault )))

(defn *set-default
  "Sets the default SSL context. It will be returned by subsequent calls
   to getDefault(). The default context must be immediately usable
   and not require initialization.

  context - the SSLContext - `javax.net.ssl.SSLContext`

  throws: java.lang.NullPointerException - if context is null"
  ([^javax.net.ssl.SSLContext context]
    (SSLContext/setDefault context)))

(defn *get-instance
  "Returns a SSLContext object that implements the
   specified secure socket protocol.

    A new SSLContext object encapsulating the
   SSLContextSpi implementation from the specified provider
   is returned.  The specified provider must be registered
   in the security provider list.

    Note that the list of registered providers may be retrieved via
   the Security.getProviders() method.

  protocol - the standard name of the requested protocol. See the SSLContext section in the Java Cryptography Architecture Standard Algorithm Name Documentation for information about standard protocol names. - `java.lang.String`
  provider - the name of the provider. - `java.lang.String`

  returns: the new SSLContext object. - `javax.net.ssl.SSLContext`

  throws: java.security.NoSuchAlgorithmException - if a SSLContextSpi implementation for the specified protocol is not available from the specified provider."
  (^javax.net.ssl.SSLContext [^java.lang.String protocol ^java.lang.String provider]
    (SSLContext/getInstance protocol provider))
  (^javax.net.ssl.SSLContext [^java.lang.String protocol]
    (SSLContext/getInstance protocol)))

(defn get-default-ssl-parameters
  "Returns a copy of the SSLParameters indicating the default
   settings for this SSL context.

   The parameters will always have the ciphersuites and protocols
   arrays set to non-null values.

  returns: a copy of the SSLParameters object with the default settings - `javax.net.ssl.SSLParameters`

  throws: java.lang.UnsupportedOperationException - if the default SSL parameters could not be obtained."
  (^javax.net.ssl.SSLParameters [^SSLContext this]
    (-> this (.getDefaultSSLParameters))))

(defn get-provider
  "Returns the provider of this SSLContext object.

  returns: the provider of this SSLContext object - `java.security.Provider`"
  (^java.security.Provider [^SSLContext this]
    (-> this (.getProvider))))

(defn get-client-session-context
  "Returns the client session context, which represents the set of
   SSL sessions available for use during the handshake phase of
   client-side SSL sockets.

   This context may be unavailable in some environments, in which
   case this method returns null. For example, when the underlying
   SSL provider does not provide an implementation of SSLSessionContext
   interface, this method returns null. A non-null session context
   is returned otherwise.

  returns: client session context bound to this SSL context - `javax.net.ssl.SSLSessionContext`"
  (^javax.net.ssl.SSLSessionContext [^SSLContext this]
    (-> this (.getClientSessionContext))))

(defn get-server-socket-factory
  "Returns a ServerSocketFactory object for
   this context.

  returns: the ServerSocketFactory object - `javax.net.ssl.SSLServerSocketFactory`

  throws: java.lang.IllegalStateException - if the SSLContextImpl requires initialization and the init() has not been called"
  (^javax.net.ssl.SSLServerSocketFactory [^SSLContext this]
    (-> this (.getServerSocketFactory))))

(defn get-socket-factory
  "Returns a SocketFactory object for this
   context.

  returns: the SocketFactory object - `javax.net.ssl.SSLSocketFactory`

  throws: java.lang.IllegalStateException - if the SSLContextImpl requires initialization and the init() has not been called"
  (^javax.net.ssl.SSLSocketFactory [^SSLContext this]
    (-> this (.getSocketFactory))))

(defn init
  "Initializes this context. Either of the first two parameters
   may be null in which case the installed security providers will
   be searched for the highest priority implementation of the
   appropriate factory. Likewise, the secure random parameter may
   be null in which case the default implementation will be used.

   Only the first instance of a particular key and/or trust manager
   implementation type in the array is used.  (For example, only
   the first javax.net.ssl.X509KeyManager in the array will be used.)

  km - the sources of authentication keys or null - `javax.net.ssl.KeyManager[]`
  tm - the sources of peer authentication trust decisions or null - `javax.net.ssl.TrustManager[]`
  random - the source of randomness for this generator or null - `java.security.SecureRandom`

  throws: java.security.KeyManagementException - if this operation fails"
  ([^SSLContext this km tm ^java.security.SecureRandom random]
    (-> this (.init km tm random))))

(defn get-supported-ssl-parameters
  "Returns a copy of the SSLParameters indicating the supported
   settings for this SSL context.

   The parameters will always have the ciphersuites and protocols
   arrays set to non-null values.

  returns: a copy of the SSLParameters object with the supported
     settings - `javax.net.ssl.SSLParameters`

  throws: java.lang.UnsupportedOperationException - if the supported SSL parameters could not be obtained."
  (^javax.net.ssl.SSLParameters [^SSLContext this]
    (-> this (.getSupportedSSLParameters))))

(defn get-protocol
  "Returns the protocol name of this SSLContext object.

   This is the same name that was specified in one of the
   getInstance calls that created this
   SSLContext object.

  returns: the protocol name of this SSLContext object. - `java.lang.String`"
  (^java.lang.String [^SSLContext this]
    (-> this (.getProtocol))))

(defn get-server-session-context
  "Returns the server session context, which represents the set of
   SSL sessions available for use during the handshake phase of
   server-side SSL sockets.

   This context may be unavailable in some environments, in which
   case this method returns null. For example, when the underlying
   SSL provider does not provide an implementation of SSLSessionContext
   interface, this method returns null. A non-null session context
   is returned otherwise.

  returns: server session context bound to this SSL context - `javax.net.ssl.SSLSessionContext`"
  (^javax.net.ssl.SSLSessionContext [^SSLContext this]
    (-> this (.getServerSessionContext))))

(defn create-ssl-engine
  "Creates a new SSLEngine using this context using
   advisory peer information.

   Applications using this factory method are providing hints
   for an internal session reuse strategy.

   Some cipher suites (such as Kerberos) require remote hostname
   information, in which case peerHost needs to be specified.

  peer-host - the non-authoritative name of the host - `java.lang.String`
  peer-port - the non-authoritative port - `int`

  returns: the new SSLEngine object - `javax.net.ssl.SSLEngine`

  throws: java.lang.UnsupportedOperationException - if the underlying provider does not implement the operation."
  (^javax.net.ssl.SSLEngine [^SSLContext this ^java.lang.String peer-host ^Integer peer-port]
    (-> this (.createSSLEngine peer-host peer-port)))
  (^javax.net.ssl.SSLEngine [^SSLContext this]
    (-> this (.createSSLEngine))))

