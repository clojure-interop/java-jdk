(ns jdk.nio.channels.ServerSocketChannel
  "A selectable channel for stream-oriented listening sockets.

   A server-socket channel is created by invoking the open
  method of this class.  It is not possible to create a channel for an arbitrary,
  pre-existing ServerSocket. A newly-created server-socket channel is
  open but not yet bound.  An attempt to invoke the accept
  method of an unbound server-socket channel will cause a NotYetBoundException
  to be thrown. A server-socket channel can be bound by invoking one of the
  bind methods defined by this class.

   Socket options are configured using the setOption method. Server-socket channels support the following options:



      Option Name
      Description


       SO_RCVBUF
       The size of the socket receive buffer


       SO_REUSEADDR
       Re-use address



  Additional (implementation specific) options may also be supported.

   Server-socket channels are safe for use by multiple concurrent threads."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.nio.channels ServerSocketChannel]))

(defn *open
  "Opens a server-socket channel.

    The new channel is created by invoking the openServerSocketChannel method of the system-wide default SelectorProvider object.

    The new channel's socket is initially unbound; it must be bound to a
   specific address via one of its socket's bind methods before
   connections can be accepted.

  returns: A new socket channel - `java.nio.channels.ServerSocketChannel`

  throws: java.io.IOException - If an I/O error occurs"
  (^java.nio.channels.ServerSocketChannel []
    (ServerSocketChannel/open )))

(defn valid-ops
  "Returns an operation set identifying this channel's supported
   operations.

    Server-socket channels only support the accepting of new
   connections, so this method returns SelectionKey.OP_ACCEPT.

  returns: The valid-operation set - `int`"
  (^Integer [^ServerSocketChannel this]
    (-> this (.validOps))))

(defn bind
  "Binds the channel's socket to a local address and configures the socket to
   listen for connections.

    This method is used to establish an association between the socket and
   a local address. Once an association is established then the socket remains
   bound until the channel is closed.

    The backlog parameter is the maximum number of pending
   connections on the socket. Its exact semantics are implementation specific.
   In particular, an implementation may impose a maximum length or may choose
   to ignore the parameter altogther. If the backlog parameter has
   the value 0, or a negative value, then an implementation specific
   default is used.

  local - The address to bind the socket, or null to bind to an automatically assigned socket address - `java.net.SocketAddress`
  backlog - The maximum number of pending connections - `int`

  returns: This channel - `java.nio.channels.ServerSocketChannel`

  throws: java.nio.channels.AlreadyBoundException - If the socket is already bound"
  (^java.nio.channels.ServerSocketChannel [^ServerSocketChannel this ^java.net.SocketAddress local ^Integer backlog]
    (-> this (.bind local backlog)))
  (^java.nio.channels.ServerSocketChannel [^ServerSocketChannel this ^java.net.SocketAddress local]
    (-> this (.bind local))))

(defn set-option
  "Description copied from interface: NetworkChannel

  name - The socket option - `java.net.SocketOption`
  value - The value of the socket option. A value of null may be a valid value for some socket options. - `T`

  returns: This channel - `<T> java.nio.channels.ServerSocketChannel`

  throws: java.lang.UnsupportedOperationException - If the socket option is not supported by this channel"
  ([^ServerSocketChannel this ^java.net.SocketOption name value]
    (-> this (.setOption name value))))

(defn socket
  "Retrieves a server socket associated with this channel.

    The returned object will not declare any public methods that are not
   declared in the ServerSocket class.

  returns: A server socket associated with this channel - `java.net.ServerSocket`"
  (^java.net.ServerSocket [^ServerSocketChannel this]
    (-> this (.socket))))

(defn accept
  "Accepts a connection made to this channel's socket.

    If this channel is in non-blocking mode then this method will
   immediately return null if there are no pending connections.
   Otherwise it will block indefinitely until a new connection is available
   or an I/O error occurs.

    The socket channel returned by this method, if any, will be in
   blocking mode regardless of the blocking mode of this channel.

    This method performs exactly the same security checks as the accept method of the ServerSocket class.  That is, if a security manager has been
   installed then for each new connection this method verifies that the
   address and port number of the connection's remote endpoint are
   permitted by the security manager's checkAccept method.

  returns: The socket channel for the new connection,
            or null if this channel is in non-blocking mode
            and no connection is available to be accepted - `java.nio.channels.SocketChannel`

  throws: java.nio.channels.ClosedChannelException - If this channel is closed"
  (^java.nio.channels.SocketChannel [^ServerSocketChannel this]
    (-> this (.accept))))

(defn get-local-address
  "Returns the socket address that this channel's socket is bound to.

    Where the channel is bound to an Internet Protocol
   socket address then the return value from this method is of type InetSocketAddress.

   If there is a security manager set, its checkConnect method is
   called with the local address and -1 as its arguments to see
   if the operation is allowed. If the operation is not allowed,
   a SocketAddress representing the
   loopback address and the
   local port of the channel's socket is returned.

  returns: The SocketAddress that the socket is bound to, or the
            SocketAddress representing the loopback address if
            denied by the security manager, or null if the
            channel's socket is not bound - `java.net.SocketAddress`

  throws: java.nio.channels.ClosedChannelException - If the channel is closed"
  (^java.net.SocketAddress [^ServerSocketChannel this]
    (-> this (.getLocalAddress))))

