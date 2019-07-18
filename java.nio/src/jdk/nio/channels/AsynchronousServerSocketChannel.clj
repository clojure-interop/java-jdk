(ns jdk.nio.channels.AsynchronousServerSocketChannel
  "An asynchronous channel for stream-oriented listening sockets.

   An asynchronous server-socket channel is created by invoking the
  open method of this class.
  A newly-created asynchronous server-socket channel is open but not yet bound.
  It can be bound to a local address and configured to listen for connections
  by invoking the bind method. Once bound,
  the accept method
  is used to initiate the accepting of connections to the channel's socket.
  An attempt to invoke the accept method on an unbound channel will
  cause a NotYetBoundException to be thrown.

   Channels of this type are safe for use by multiple concurrent threads
  though at most one accept operation can be outstanding at any time.
  If a thread initiates an accept operation before a previous accept operation
  has completed then an AcceptPendingException will be thrown.

   Socket options are configured using the setOption method. Channels of this type support the following options:



      Option Name
      Description


       SO_RCVBUF
       The size of the socket receive buffer


       SO_REUSEADDR
       Re-use address



  Additional (implementation specific) options may also be supported.

   Usage Example:


   final AsynchronousServerSocketChannel listener =
       AsynchronousServerSocketChannel.open().bind(new InetSocketAddress(5000));

   listener.accept(null, new CompletionHandler<AsynchronousSocketChannel,Void>() {
       public void completed(AsynchronousSocketChannel ch, Void att) {
           // accept the next connection
           listener.accept(null, this);

           // handle this connection
           handle(ch);
       }
       public void failed(Throwable exc, Void att) {
           ...
       }
   });"
  (:refer-clojure :only [require comment defn ->])
  (:import [java.nio.channels AsynchronousServerSocketChannel]))

(defn *open
  "Opens an asynchronous server-socket channel.

    The new channel is created by invoking the openAsynchronousServerSocketChannel method on the AsynchronousChannelProvider object that created
   the given group. If the group parameter is null then the
   resulting channel is created by the system-wide default provider, and
   bound to the default group.

  group - The group to which the newly constructed channel should be bound, or null for the default group - `java.nio.channels.AsynchronousChannelGroup`

  returns: A new asynchronous server socket channel - `java.nio.channels.AsynchronousServerSocketChannel`

  throws: java.nio.channels.ShutdownChannelGroupException - If the channel group is shutdown"
  (^java.nio.channels.AsynchronousServerSocketChannel [^java.nio.channels.AsynchronousChannelGroup group]
    (AsynchronousServerSocketChannel/open group))
  (^java.nio.channels.AsynchronousServerSocketChannel []
    (AsynchronousServerSocketChannel/open )))

(defn provider
  "Returns the provider that created this channel.

  returns: The provider that created this channel - `java.nio.channels.spi.AsynchronousChannelProvider`"
  (^java.nio.channels.spi.AsynchronousChannelProvider [^AsynchronousServerSocketChannel this]
    (-> this (.provider))))

(defn bind
  "Binds the channel's socket to a local address and configures the socket to
   listen for connections.

    This method is used to establish an association between the socket and
   a local address. Once an association is established then the socket remains
   bound until the associated channel is closed.

    The backlog parameter is the maximum number of pending
   connections on the socket. Its exact semantics are implementation specific.
   In particular, an implementation may impose a maximum length or may choose
   to ignore the parameter altogther. If the backlog parameter has
   the value 0, or a negative value, then an implementation specific
   default is used.

  local - The local address to bind the socket, or null to bind to an automatically assigned socket address - `java.net.SocketAddress`
  backlog - The maximum number of pending connections - `int`

  returns: This channel - `java.nio.channels.AsynchronousServerSocketChannel`

  throws: java.nio.channels.AlreadyBoundException - If the socket is already bound"
  (^java.nio.channels.AsynchronousServerSocketChannel [^AsynchronousServerSocketChannel this ^java.net.SocketAddress local ^Integer backlog]
    (-> this (.bind local backlog)))
  (^java.nio.channels.AsynchronousServerSocketChannel [^AsynchronousServerSocketChannel this ^java.net.SocketAddress local]
    (-> this (.bind local))))

(defn set-option
  "Description copied from interface: NetworkChannel

  name - The socket option - `java.net.SocketOption`
  value - The value of the socket option. A value of null may be a valid value for some socket options. - `T`

  returns: This channel - `<T> java.nio.channels.AsynchronousServerSocketChannel`

  throws: java.lang.IllegalArgumentException - If the value is not a valid value for this socket option"
  ([^AsynchronousServerSocketChannel this ^java.net.SocketOption name value]
    (-> this (.setOption name value))))

(defn accept
  "Accepts a connection.

    This method initiates an asynchronous operation to accept a
   connection made to this channel's socket. The handler parameter is
   a completion handler that is invoked when a connection is accepted (or
   the operation fails). The result passed to the completion handler is
   the AsynchronousSocketChannel to the new connection.

    When a new connection is accepted then the resulting AsynchronousSocketChannel will be bound to the same AsynchronousChannelGroup as this channel. If the group is shutdown and a connection is accepted,
   then the connection is closed, and the operation completes with an IOException and cause ShutdownChannelGroupException.

    To allow for concurrent handling of new connections, the completion
   handler is not invoked directly by the initiating thread when a new
   connection is accepted immediately (see Threading).

    If a security manager has been installed then it verifies that the
   address and port number of the connection's remote endpoint are permitted
   by the security manager's checkAccept
   method. The permission check is performed with privileges that are restricted
   by the calling context of this method. If the permission check fails then
   the connection is closed and the operation completes with a SecurityException.

  attachment - The object to attach to the I/O operation; can be null - `A`
  handler - The handler for consuming the result - `java.nio.channels.CompletionHandler`

  returns: `<A> void`

  throws: java.nio.channels.AcceptPendingException - If an accept operation is already in progress on this channel"
  ([^AsynchronousServerSocketChannel this attachment ^java.nio.channels.CompletionHandler handler]
    (-> this (.accept attachment handler)))
  (^java.util.concurrent.Future [^AsynchronousServerSocketChannel this]
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
  (^java.net.SocketAddress [^AsynchronousServerSocketChannel this]
    (-> this (.getLocalAddress))))

