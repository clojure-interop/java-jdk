(ns javax.rmi.ssl.SslRMIClientSocketFactory
  "An SslRMIClientSocketFactory instance is used by the RMI
  runtime in order to obtain client sockets for RMI calls via SSL.

  This class implements RMIClientSocketFactory over
  the Secure Sockets Layer (SSL) or Transport Layer Security (TLS)
  protocols.

  This class creates SSL sockets using the default
  SSLSocketFactory (see SSLSocketFactory.getDefault()).  All instances of this class are
  functionally equivalent.  In particular, they all share the same
  truststore, and the same keystore when client authentication is
  required by the server.  This behavior can be modified in
  subclasses by overriding the createSocket(String,int)
  method; in that case, equals and hashCode may also need to be overridden.

  If the system property
  javax.rmi.ssl.client.enabledCipherSuites is specified,
  the createSocket(String,int) method will call SSLSocket.setEnabledCipherSuites(String[]) before returning the
  socket.  The value of this system property is a string that is a
  comma-separated list of SSL/TLS cipher suites to enable.

  If the system property
  javax.rmi.ssl.client.enabledProtocols is specified,
  the createSocket(String,int) method will call SSLSocket.setEnabledProtocols(String[]) before returning the
  socket.  The value of this system property is a string that is a
  comma-separated list of SSL/TLS protocol versions to enable."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.rmi.ssl SslRMIClientSocketFactory]))

(defn ->ssl-rmi-client-socket-factory
  "Constructor.

  Creates a new SslRMIClientSocketFactory."
  ([]
    (new SslRMIClientSocketFactory )))

(defn create-socket
  "Creates an SSL socket.

   If the system property
   javax.rmi.ssl.client.enabledCipherSuites is
   specified, this method will call SSLSocket.setEnabledCipherSuites(String[]) before returning
   the socket. The value of this system property is a string that
   is a comma-separated list of SSL/TLS cipher suites to
   enable.

   If the system property
   javax.rmi.ssl.client.enabledProtocols is
   specified, this method will call SSLSocket.setEnabledProtocols(String[]) before returning the
   socket. The value of this system property is a string that is a
   comma-separated list of SSL/TLS protocol versions to
   enable.

  host - the host name - `java.lang.String`
  port - the port number - `int`

  returns: a socket connected to the specified host and port. - `java.net.Socket`

  throws: java.io.IOException - if an I/O error occurs during socket creation"
  (^java.net.Socket [^javax.rmi.ssl.SslRMIClientSocketFactory this ^java.lang.String host ^Integer port]
    (-> this (.createSocket host port))))

(defn equals
  "Indicates whether some other object is `equal to` this one.

   Because all instances of this class are functionally equivalent
   (they all use the default
   SSLSocketFactory), this method simply returns
   this.getClass().equals(obj.getClass()).

   A subclass should override this method (as well
   as hashCode()) if its instances are not all
   functionally equivalent.

  obj - the reference object with which to compare. - `java.lang.Object`

  returns: true if this object is the same as the obj
            argument; false otherwise. - `boolean`"
  (^Boolean [^javax.rmi.ssl.SslRMIClientSocketFactory this ^java.lang.Object obj]
    (-> this (.equals obj))))

(defn hash-code
  "Returns a hash code value for this
   SslRMIClientSocketFactory.

  returns: a hash code value for this
   SslRMIClientSocketFactory. - `int`"
  (^Integer [^javax.rmi.ssl.SslRMIClientSocketFactory this]
    (-> this (.hashCode))))

