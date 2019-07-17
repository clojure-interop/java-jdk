(ns javax.rmi.ssl.SslRMIServerSocketFactory
  "An SslRMIServerSocketFactory instance is used by the RMI
  runtime in order to obtain server sockets for RMI calls via SSL.

  This class implements RMIServerSocketFactory over
  the Secure Sockets Layer (SSL) or Transport Layer Security (TLS)
  protocols.

  This class creates SSL sockets using the default
  SSLSocketFactory (see SSLSocketFactory.getDefault()) or the default
  SSLServerSocketFactory (see SSLServerSocketFactory.getDefault()) unless the
  constructor taking an SSLContext is
  used in which case the SSL sockets are created using
  the SSLSocketFactory returned by
  SSLContext.getSocketFactory() or the
  SSLServerSocketFactory returned by
  SSLContext.getServerSocketFactory().

  When an SSLContext is not supplied all the instances of this
  class share the same keystore, and the same truststore (when client
  authentication is required by the server). This behavior can be modified
  by supplying an already initialized SSLContext instance."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.rmi.ssl SslRMIServerSocketFactory]))

(defn ->ssl-rmi-server-socket-factory
  "Constructor.

  Creates a new SslRMIServerSocketFactory with the
   specified SSLContext and SSL socket configuration.

  context - the SSL context to be used for creating SSL sockets. If context is null the default SSLSocketFactory or the default SSLServerSocketFactory will be used to create SSL sockets. Otherwise, the socket factory returned by SSLContext.getSocketFactory() or SSLContext.getServerSocketFactory() will be used instead. - `javax.net.ssl.SSLContext`
  enabled-cipher-suites - names of all the cipher suites to enable on SSL connections accepted by server sockets created by this factory, or null to use the cipher suites that are enabled by default - `java.lang.String[]`
  enabled-protocols - names of all the protocol versions to enable on SSL connections accepted by server sockets created by this factory, or null to use the protocol versions that are enabled by default - `java.lang.String[]`
  need-client-auth - true to require client authentication on SSL connections accepted by server sockets created by this factory; false to not require client authentication - `boolean`

  throws: java.lang.IllegalArgumentException - when one or more of the cipher suites named by the enabledCipherSuites parameter is not supported, when one or more of the protocols named by the enabledProtocols parameter is not supported or when a problem is encountered while trying to check if the supplied cipher suites and protocols to be enabled are supported."
  ([^javax.net.ssl.SSLContext context enabled-cipher-suites enabled-protocols ^Boolean need-client-auth]
    (new SslRMIServerSocketFactory context enabled-cipher-suites enabled-protocols need-client-auth))
  ([enabled-cipher-suites enabled-protocols ^Boolean need-client-auth]
    (new SslRMIServerSocketFactory enabled-cipher-suites enabled-protocols need-client-auth))
  ([]
    (new SslRMIServerSocketFactory )))

(defn get-enabled-cipher-suites
  "Returns the names of the cipher suites enabled on SSL
   connections accepted by server sockets created by this factory,
   or null if this factory uses the cipher suites
   that are enabled by default.

  returns: an array of cipher suites enabled, or null - `java.lang.String[]`"
  ([^javax.rmi.ssl.SslRMIServerSocketFactory this]
    (-> this (.getEnabledCipherSuites))))

(defn get-enabled-protocols
  "Returns the names of the protocol versions enabled on SSL
   connections accepted by server sockets created by this factory,
   or null if this factory uses the protocol versions
   that are enabled by default.

  returns: an array of protocol versions enabled, or
   null - `java.lang.String[]`"
  ([^javax.rmi.ssl.SslRMIServerSocketFactory this]
    (-> this (.getEnabledProtocols))))

(defn get-need-client-auth?
  "Returns true if client authentication is
   required on SSL connections accepted by server sockets created
   by this factory.

  returns: true if client authentication is required - `boolean`"
  (^Boolean [^javax.rmi.ssl.SslRMIServerSocketFactory this]
    (-> this (.getNeedClientAuth))))

(defn create-server-socket
  "Creates a server socket that accepts SSL connections
   configured according to this factory's SSL socket configuration
   parameters.

  port - the port number - `int`

  returns: the server socket on the specified port - `java.net.ServerSocket`

  throws: java.io.IOException - if an I/O error occurs during server socket creation"
  (^java.net.ServerSocket [^javax.rmi.ssl.SslRMIServerSocketFactory this ^Integer port]
    (-> this (.createServerSocket port))))

(defn equals
  "Indicates whether some other object is `equal to` this one.

   Two SslRMIServerSocketFactory objects are equal
   if they have been constructed with the same SSL context and
   SSL socket configuration parameters.

   A subclass should override this method (as well as
   hashCode()) if it adds instance state that affects
   equality.

  obj - the reference object with which to compare. - `java.lang.Object`

  returns: true if this object is the same as the obj
            argument; false otherwise. - `boolean`"
  (^Boolean [^javax.rmi.ssl.SslRMIServerSocketFactory this ^java.lang.Object obj]
    (-> this (.equals obj))))

(defn hash-code
  "Returns a hash code value for this
   SslRMIServerSocketFactory.

  returns: a hash code value for this
   SslRMIServerSocketFactory. - `int`"
  (^Integer [^javax.rmi.ssl.SslRMIServerSocketFactory this]
    (-> this (.hashCode))))

