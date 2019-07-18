(ns jdk.nio.channels.SocketChannel
  "A selectable channel for stream-oriented connecting sockets.

   A socket channel is created by invoking one of the open
  methods of this class.  It is not possible to create a channel for an arbitrary,
  pre-existing socket. A newly-created socket channel is open but not yet
  connected.  An attempt to invoke an I/O operation upon an unconnected
  channel will cause a NotYetConnectedException to be thrown.  A
  socket channel can be connected by invoking its connect
  method; once connected, a socket channel remains connected until it is
  closed.  Whether or not a socket channel is connected may be determined by
  invoking its isConnected method.

   Socket channels support non-blocking connection: A socket
  channel may be created and the process of establishing the link to the
  remote socket may be initiated via the connect method for
  later completion by the finishConnect method.
  Whether or not a connection operation is in progress may be determined by
  invoking the isConnectionPending method.

   Socket channels support asynchronous shutdown, which is similar
  to the asynchronous close operation specified in the Channel class.
  If the input side of a socket is shut down by one thread while another
  thread is blocked in a read operation on the socket's channel, then the read
  operation in the blocked thread will complete without reading any bytes and
  will return -1.  If the output side of a socket is shut down by one
  thread while another thread is blocked in a write operation on the socket's
  channel, then the blocked thread will receive an AsynchronousCloseException.

   Socket options are configured using the setOption method. Socket channels support the following options:



      Option Name
      Description


       SO_SNDBUF
       The size of the socket send buffer


       SO_RCVBUF
       The size of the socket receive buffer


       SO_KEEPALIVE
       Keep connection alive


       SO_REUSEADDR
       Re-use address


       SO_LINGER
       Linger on close if data is present (when configured in blocking mode
           only)


       TCP_NODELAY
       Disable the Nagle algorithm



  Additional (implementation specific) options may also be supported.

   Socket channels are safe for use by multiple concurrent threads.  They
  support concurrent reading and writing, though at most one thread may be
  reading and at most one thread may be writing at any given time.  The connect and finishConnect methods are
  mutually synchronized against each other, and an attempt to initiate a read
  or write operation while an invocation of one of these methods is in
  progress will block until that invocation is complete."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.nio.channels SocketChannel]))

(defn *open
  "Opens a socket channel and connects it to a remote address.

    This convenience method works as if by invoking the open()
   method, invoking the connect method upon
   the resulting socket channel, passing it remote, and then
   returning that channel.

  remote - The remote address to which the new channel is to be connected - `java.net.SocketAddress`

  returns: A new, and connected, socket channel - `java.nio.channels.SocketChannel`

  throws: java.nio.channels.AsynchronousCloseException - If another thread closes this channel while the connect operation is in progress"
  (^java.nio.channels.SocketChannel [^java.net.SocketAddress remote]
    (SocketChannel/open remote))
  (^java.nio.channels.SocketChannel []
    (SocketChannel/open )))

(defn shutdown-output
  "Shutdown the connection for writing without closing the channel.

    Once shutdown for writing then further attempts to write to the
   channel will throw ClosedChannelException. If the output side of
   the connection is already shutdown then invoking this method has no
   effect.

  returns: The channel - `java.nio.channels.SocketChannel`

  throws: java.nio.channels.NotYetConnectedException - If this channel is not yet connected"
  (^java.nio.channels.SocketChannel [^SocketChannel this]
    (-> this (.shutdownOutput))))

(defn bind
  "Description copied from interface: NetworkChannel

  local - The address to bind the socket, or null to bind the socket to an automatically assigned socket address - `java.net.SocketAddress`

  returns: This channel - `java.nio.channels.SocketChannel`

  throws: java.nio.channels.ConnectionPendingException - If a non-blocking connect operation is already in progress on this channel"
  (^java.nio.channels.SocketChannel [^SocketChannel this ^java.net.SocketAddress local]
    (-> this (.bind local))))

(defn get-remote-address
  "Returns the remote address to which this channel's socket is connected.

    Where the channel is bound and connected to an Internet Protocol
   socket address then the return value from this method is of type InetSocketAddress.

  returns: The remote address; null if the channel's socket is not
            connected - `java.net.SocketAddress`

  throws: java.nio.channels.ClosedChannelException - If the channel is closed"
  (^java.net.SocketAddress [^SocketChannel this]
    (-> this (.getRemoteAddress))))

(defn connected?
  "Tells whether or not this channel's network socket is connected.

  returns: true if, and only if, this channel's network socket
            is open and connected - `boolean`"
  (^Boolean [^SocketChannel this]
    (-> this (.isConnected))))

(defn read
  "Description copied from interface: ScatteringByteChannel

  dsts - The buffers into which bytes are to be transferred - `java.nio.ByteBuffer[]`
  offset - The offset within the buffer array of the first buffer into which bytes are to be transferred; must be non-negative and no larger than dsts.length - `int`
  length - The maximum number of buffers to be accessed; must be non-negative and no larger than dsts.length - offset - `int`

  returns: The number of bytes read, possibly zero,
           or -1 if the channel has reached end-of-stream - `long`

  throws: java.nio.channels.NotYetConnectedException - If this channel is not yet connected"
  (^Long [^SocketChannel this dsts ^Integer offset ^Integer length]
    (-> this (.read dsts offset length)))
  (^Integer [^SocketChannel this ^java.nio.ByteBuffer dst]
    (-> this (.read dst))))

(defn connect
  "Connects this channel's socket.

    If this channel is in non-blocking mode then an invocation of this
   method initiates a non-blocking connection operation.  If the connection
   is established immediately, as can happen with a local connection, then
   this method returns true.  Otherwise this method returns
   false and the connection operation must later be completed by
   invoking the finishConnect method.

    If this channel is in blocking mode then an invocation of this
   method will block until the connection is established or an I/O error
   occurs.

    This method performs exactly the same security checks as the Socket class.  That is, if a security manager has been
   installed then this method verifies that its checkConnect method permits
   connecting to the address and port number of the given remote endpoint.

    This method may be invoked at any time.  If a read or write
   operation upon this channel is invoked while an invocation of this
   method is in progress then that operation will first block until this
   invocation is complete.  If a connection attempt is initiated but fails,
   that is, if an invocation of this method throws a checked exception,
   then the channel will be closed.

  remote - The remote address to which this channel is to be connected - `java.net.SocketAddress`

  returns: true if a connection was established,
            false if this channel is in non-blocking mode
            and the connection operation is in progress - `boolean`

  throws: java.nio.channels.UnresolvedAddressException - If the given remote address is not fully resolved"
  (^Boolean [^SocketChannel this ^java.net.SocketAddress remote]
    (-> this (.connect remote))))

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
  (^java.net.SocketAddress [^SocketChannel this]
    (-> this (.getLocalAddress))))

(defn finish-connect
  "Finishes the process of connecting a socket channel.

    A non-blocking connection operation is initiated by placing a socket
   channel in non-blocking mode and then invoking its connect method.  Once the connection is established, or the attempt has
   failed, the socket channel will become connectable and this method may
   be invoked to complete the connection sequence.  If the connection
   operation failed then invoking this method will cause an appropriate
   IOException to be thrown.

    If this channel is already connected then this method will not block
   and will immediately return true.  If this channel is in
   non-blocking mode then this method will return false if the
   connection process is not yet complete.  If this channel is in blocking
   mode then this method will block until the connection either completes
   or fails, and will always either return true or throw a checked
   exception describing the failure.

    This method may be invoked at any time.  If a read or write
   operation upon this channel is invoked while an invocation of this
   method is in progress then that operation will first block until this
   invocation is complete.  If a connection attempt fails, that is, if an
   invocation of this method throws a checked exception, then the channel
   will be closed.

  returns: true if, and only if, this channel's socket is now
            connected - `boolean`

  throws: java.nio.channels.NoConnectionPendingException - If this channel is not connected and a connection operation has not been initiated"
  (^Boolean [^SocketChannel this]
    (-> this (.finishConnect))))

(defn valid-ops
  "Returns an operation set identifying this channel's supported
   operations.

    Socket channels support connecting, reading, and writing, so this
   method returns (SelectionKey.OP_CONNECT
   | SelectionKey.OP_READ | SelectionKey.OP_WRITE).

  returns: The valid-operation set - `int`"
  (^Integer [^SocketChannel this]
    (-> this (.validOps))))

(defn set-option
  "Description copied from interface: NetworkChannel

  name - The socket option - `java.net.SocketOption`
  value - The value of the socket option. A value of null may be a valid value for some socket options. - `T`

  returns: This channel - `<T> java.nio.channels.SocketChannel`

  throws: java.lang.UnsupportedOperationException - If the socket option is not supported by this channel"
  ([^SocketChannel this ^java.net.SocketOption name value]
    (-> this (.setOption name value))))

(defn socket
  "Retrieves a socket associated with this channel.

    The returned object will not declare any public methods that are not
   declared in the Socket class.

  returns: A socket associated with this channel - `java.net.Socket`"
  (^java.net.Socket [^SocketChannel this]
    (-> this (.socket))))

(defn shutdown-input
  "Shutdown the connection for reading without closing the channel.

    Once shutdown for reading then further reads on the channel will
   return -1, the end-of-stream indication. If the input side of the
   connection is already shutdown then invoking this method has no effect.

  returns: The channel - `java.nio.channels.SocketChannel`

  throws: java.nio.channels.NotYetConnectedException - If this channel is not yet connected"
  (^java.nio.channels.SocketChannel [^SocketChannel this]
    (-> this (.shutdownInput))))

(defn write
  "Description copied from interface: GatheringByteChannel

  srcs - The buffers from which bytes are to be retrieved - `java.nio.ByteBuffer[]`
  offset - The offset within the buffer array of the first buffer from which bytes are to be retrieved; must be non-negative and no larger than srcs.length - `int`
  length - The maximum number of buffers to be accessed; must be non-negative and no larger than srcs.length - offset - `int`

  returns: The number of bytes written, possibly zero - `long`

  throws: java.nio.channels.NotYetConnectedException - If this channel is not yet connected"
  (^Long [^SocketChannel this srcs ^Integer offset ^Integer length]
    (-> this (.write srcs offset length)))
  (^Integer [^SocketChannel this ^java.nio.ByteBuffer src]
    (-> this (.write src))))

(defn connection-pending?
  "Tells whether or not a connection operation is in progress on this
   channel.

  returns: true if, and only if, a connection operation has been
            initiated on this channel but not yet completed by invoking the
            finishConnect method - `boolean`"
  (^Boolean [^SocketChannel this]
    (-> this (.isConnectionPending))))

