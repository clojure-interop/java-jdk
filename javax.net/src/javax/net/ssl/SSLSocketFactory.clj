(ns javax.net.ssl.SSLSocketFactory
  "SSLSocketFactorys create SSLSockets."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.net.ssl SSLSocketFactory]))

(defn ->ssl-socket-factory
  "Constructor.

  Constructor is used only by subclasses."
  ([]
    (new SSLSocketFactory )))

(defn *get-default
  "Returns the default SSL socket factory.

   The first time this method is called, the security property
   `ssl.SocketFactory.provider` is examined. If it is non-null, a class by
   that name is loaded and instantiated. If that is successful and the
   object is an instance of SSLSocketFactory, it is made the default SSL
   socket factory.

   Otherwise, this method returns
   SSLContext.getDefault().getSocketFactory(). If that
   call fails, an inoperative factory is returned.

  returns: the default SocketFactory - `javax.net.SocketFactory`"
  (^javax.net.SocketFactory []
    (SSLSocketFactory/getDefault )))

(defn get-default-cipher-suites
  "Returns the list of cipher suites which are enabled by default.
   Unless a different list is enabled, handshaking on an SSL connection
   will use one of these cipher suites.  The minimum quality of service
   for these defaults requires confidentiality protection and server
   authentication (that is, no anonymous cipher suites).

  returns: array of the cipher suites enabled by default - `java.lang.String[]`"
  ([^javax.net.ssl.SSLSocketFactory this]
    (-> this (.getDefaultCipherSuites))))

(defn get-supported-cipher-suites
  "Returns the names of the cipher suites which could be enabled for use
   on an SSL connection.  Normally, only a subset of these will actually
   be enabled by default, since this list may include cipher suites which
   do not meet quality of service requirements for those defaults.  Such
   cipher suites are useful in specialized applications.

  returns: an array of cipher suite names - `java.lang.String[]`"
  ([^javax.net.ssl.SSLSocketFactory this]
    (-> this (.getSupportedCipherSuites))))

(defn create-socket
  "Returns a socket layered over an existing socket connected to the named
   host, at the given port.  This constructor can be used when tunneling SSL
   through a proxy or when negotiating the use of SSL over an existing
   socket. The host and port refer to the logical peer destination.
   This socket is configured using the socket options established for
   this factory.

  s - the existing socket - `java.net.Socket`
  host - the server host - `java.lang.String`
  port - the server port - `int`
  auto-close - close the underlying socket when this socket is closed - `boolean`

  returns: a socket connected to the specified host and port - `java.net.Socket`

  throws: java.io.IOException - if an I/O error occurs when creating the socket"
  (^java.net.Socket [^javax.net.ssl.SSLSocketFactory this ^java.net.Socket s ^java.lang.String host ^Integer port ^Boolean auto-close]
    (-> this (.createSocket s host port auto-close)))
  (^java.net.Socket [^javax.net.ssl.SSLSocketFactory this ^java.net.Socket s ^java.io.InputStream consumed ^Boolean auto-close]
    (-> this (.createSocket s consumed auto-close))))

