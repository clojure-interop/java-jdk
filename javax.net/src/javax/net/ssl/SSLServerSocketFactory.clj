(ns javax.net.ssl.SSLServerSocketFactory
  "SSLServerSocketFactorys create
  SSLServerSockets."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.net.ssl SSLServerSocketFactory]))

(defn *get-default
  "Returns the default SSL server socket factory.

   The first time this method is called, the security property
   `ssl.ServerSocketFactory.provider` is examined. If it is non-null, a
   class by that name is loaded and instantiated. If that is successful and
   the object is an instance of SSLServerSocketFactory, it is made the
   default SSL server socket factory.

   Otherwise, this method returns
   SSLContext.getDefault().getServerSocketFactory(). If that
   call fails, an inoperative factory is returned.

  returns: the default ServerSocketFactory - `javax.net.ServerSocketFactory`"
  (^javax.net.ServerSocketFactory []
    (SSLServerSocketFactory/getDefault )))

(defn get-default-cipher-suites
  "Returns the list of cipher suites which are enabled by default.
   Unless a different list is enabled, handshaking on an SSL connection
   will use one of these cipher suites.  The minimum quality of service
   for these defaults requires confidentiality protection and server
   authentication (that is, no anonymous cipher suites).

  returns: array of the cipher suites enabled by default - `java.lang.String[]`"
  ([^SSLServerSocketFactory this]
    (-> this (.getDefaultCipherSuites))))

(defn get-supported-cipher-suites
  "Returns the names of the cipher suites which could be enabled for use
   on an SSL connection created by this factory.
   Normally, only a subset of these will actually
   be enabled by default, since this list may include cipher suites which
   do not meet quality of service requirements for those defaults.  Such
   cipher suites are useful in specialized applications.

  returns: an array of cipher suite names - `java.lang.String[]`"
  ([^SSLServerSocketFactory this]
    (-> this (.getSupportedCipherSuites))))

