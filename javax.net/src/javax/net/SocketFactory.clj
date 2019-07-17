(ns javax.net.SocketFactory
  "This class creates sockets.  It may be subclassed by other factories,
  which create particular subclasses of sockets and thus provide a general
  framework for the addition of public socket-level functionality.

   Socket factories are a simple way to capture a variety of policies
  related to the sockets being constructed, producing such sockets in
  a way which does not require special configuration of the code which
  asks for the sockets:

        Due to polymorphism of both factories and sockets, different
       kinds of sockets can be used by the same application code just
       by passing it different kinds of factories.

        Factories can themselves be customized with parameters used
       in socket construction.  So for example, factories could be
       customized to return sockets with different networking timeouts
       or security parameters already configured.

        The sockets returned to the application can be subclasses
       of java.net.Socket, so that they can directly expose new APIs
       for features such as compression, security, record marking,
       statistics collection, or firewall tunneling.



   Factory classes are specified by environment-specific configuration
  mechanisms.  For example, the getDefault method could return
  a factory that was appropriate for a particular user or applet, and a
  framework could use a factory customized to its own purposes."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.net SocketFactory]))

(defn *get-default
  "Returns a copy of the environment's default socket factory.

  returns: the default SocketFactory - `javax.net.SocketFactory`"
  (^javax.net.SocketFactory []
    (SocketFactory/getDefault )))

(defn create-socket
  "Creates a socket and connects it to the specified remote host
   on the specified remote port.
   The socket will also be bound to the local address and port supplied.
   This socket is configured using
   the socket options established for this factory.

   If there is a security manager, its checkConnect
   method is called with the host address and port
   as its arguments. This could result in a SecurityException.

  host - the server host name with which to connect, or null for the loopback address. - `java.lang.String`
  port - the server port - `int`
  local-host - the local address the socket is bound to - `java.net.InetAddress`
  local-port - the local port the socket is bound to - `int`

  returns: the Socket - `java.net.Socket`

  throws: java.io.IOException - if an I/O error occurs when creating the socket"
  (^java.net.Socket [^javax.net.SocketFactory this ^java.lang.String host ^Integer port ^java.net.InetAddress local-host ^Integer local-port]
    (-> this (.createSocket host port local-host local-port)))
  (^java.net.Socket [^javax.net.SocketFactory this ^java.lang.String host ^Integer port]
    (-> this (.createSocket host port)))
  (^java.net.Socket [^javax.net.SocketFactory this]
    (-> this (.createSocket))))

