(ns javax.net.ServerSocketFactory
  "This class creates server sockets.  It may be subclassed by other
  factories, which create particular types of server sockets.  This
  provides a general framework for the addition of public socket-level
  functionality.  It is the server side analogue of a socket factory,
  and similarly provides a way to capture a variety of policies related
  to the sockets being constructed.

   Like socket factories, server Socket factory instances have
  methods used to create sockets. There is also an environment
  specific default server socket factory; frameworks will often use
  their own customized factory."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.net ServerSocketFactory]))

(defn *get-default
  "Returns a copy of the environment's default socket factory.

  returns: the ServerSocketFactory - `javax.net.ServerSocketFactory`"
  (^javax.net.ServerSocketFactory []
    (ServerSocketFactory/getDefault )))

(defn create-server-socket
  "Returns a server socket bound to the specified port,
   with a specified listen backlog and local IP.

   The ifAddress argument can be used on a multi-homed
   host for a ServerSocket that will only accept connect
   requests to one of its addresses. If ifAddress is null,
   it will accept connections on all local addresses. The socket is
   configured with the socket options (such as accept timeout) given
   to this factory.

   The backlog argument must be a positive
   value greater than 0. If the value passed if equal or less
   than 0, then the default value will be assumed.

   If there is a security manager, its checkListen
   method is called with the port argument as its
   argument to ensure the operation is allowed. This could result
   in a SecurityException.

  port - the port to listen to - `int`
  backlog - how many connections are queued - `int`
  if-address - the network interface address to use - `java.net.InetAddress`

  returns: the ServerSocket - `java.net.ServerSocket`

  throws: java.io.IOException - for networking errors"
  (^java.net.ServerSocket [^ServerSocketFactory this ^Integer port ^Integer backlog ^java.net.InetAddress if-address]
    (-> this (.createServerSocket port backlog if-address)))
  (^java.net.ServerSocket [^ServerSocketFactory this ^Integer port ^Integer backlog]
    (-> this (.createServerSocket port backlog)))
  (^java.net.ServerSocket [^ServerSocketFactory this ^Integer port]
    (-> this (.createServerSocket port)))
  (^java.net.ServerSocket [^ServerSocketFactory this]
    (-> this (.createServerSocket))))

