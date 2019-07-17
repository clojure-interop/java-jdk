(ns jdk.nio.channels.DatagramChannel
  "A selectable channel for datagram-oriented sockets.

   A datagram channel is created by invoking one of the open methods
  of this class. It is not possible to create a channel for an arbitrary,
  pre-existing datagram socket. A newly-created datagram channel is open but not
  connected. A datagram channel need not be connected in order for the send and receive methods to be used.  A datagram channel may be
  connected, by invoking its connect method, in order to
  avoid the overhead of the security checks are otherwise performed as part of
  every send and receive operation.  A datagram channel must be connected in
  order to use the read and write methods, since those methods do not
  accept or return socket addresses.

   Once connected, a datagram channel remains connected until it is
  disconnected or closed.  Whether or not a datagram channel is connected may
  be determined by invoking its isConnected method.

   Socket options are configured using the setOption method. A datagram channel to an Internet Protocol socket supports
  the following options:



      Option Name
      Description


       SO_SNDBUF
       The size of the socket send buffer


       SO_RCVBUF
       The size of the socket receive buffer


       SO_REUSEADDR
       Re-use address


       SO_BROADCAST
       Allow transmission of broadcast datagrams


       IP_TOS
       The Type of Service (ToS) octet in the Internet Protocol (IP) header


       IP_MULTICAST_IF
       The network interface for Internet Protocol (IP) multicast datagrams


       IP_MULTICAST_TTL
       The time-to-live for Internet Protocol (IP) multicast
        datagrams


       IP_MULTICAST_LOOP
       Loopback for Internet Protocol (IP) multicast datagrams



  Additional (implementation specific) options may also be supported.

   Datagram channels are safe for use by multiple concurrent threads.  They
  support concurrent reading and writing, though at most one thread may be
  reading and at most one thread may be writing at any given time."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.nio.channels DatagramChannel]))

(defn *open
  "Opens a datagram channel.

    The family parameter is used to specify the ProtocolFamily. If the datagram channel is to be used for IP multicasting
   then this should correspond to the address type of the multicast groups
   that this channel will join.

    The new channel is created by invoking the openDatagramChannel method of the system-wide default SelectorProvider object.  The channel will not be
   connected.

  family - The protocol family - `java.net.ProtocolFamily`

  returns: A new datagram channel - `java.nio.channels.DatagramChannel`

  throws: java.lang.UnsupportedOperationException - If the specified protocol family is not supported. For example, suppose the parameter is specified as StandardProtocolFamily.INET6 but IPv6 is not enabled on the platform."
  ([^java.net.ProtocolFamily family]
    (DatagramChannel/open family))
  ([]
    (DatagramChannel/open )))

(defn disconnect
  "Disconnects this channel's socket.

    The channel's socket is configured so that it can receive datagrams
   from, and sends datagrams to, any remote address so long as the security
   manager, if installed, permits it.

    This method may be invoked at any time.  It will not have any effect
   on read or write operations that are already in progress at the moment
   that it is invoked.

    If this channel's socket is not connected, or if the channel is
   closed, then invoking this method has no effect.

  returns: This datagram channel - `java.nio.channels.DatagramChannel`

  throws: java.io.IOException - If some other I/O error occurs"
  ([^java.nio.channels.DatagramChannel this]
    (-> this (.disconnect))))

(defn send
  "Sends a datagram via this channel.

    If this channel is in non-blocking mode and there is sufficient room
   in the underlying output buffer, or if this channel is in blocking mode
   and sufficient room becomes available, then the remaining bytes in the
   given buffer are transmitted as a single datagram to the given target
   address.

    The datagram is transferred from the byte buffer as if by a regular
   write operation.

    This method performs exactly the same security checks as the send method of the DatagramSocket class.  That is, if the socket is not connected
   to a specific remote address and a security manager has been installed
   then for each datagram sent this method verifies that the target address
   and port number are permitted by the security manager's checkConnect method.  The
   overhead of this security check can be avoided by first connecting the
   socket via the connect method.

    This method may be invoked at any time.  If another thread has
   already initiated a write operation upon this channel, however, then an
   invocation of this method will block until the first operation is
   complete. If this channel's socket is not bound then this method will
   first cause the socket to be bound to an address that is assigned
   automatically, as if by invoking the bind method with a
   parameter of null.

  src - The buffer containing the datagram to be sent - `java.nio.ByteBuffer`
  target - The address to which the datagram is to be sent - `java.net.SocketAddress`

  returns: The number of bytes sent, which will be either the number
             of bytes that were remaining in the source buffer when this
             method was invoked or, if this channel is non-blocking, may be
             zero if there was insufficient room for the datagram in the
             underlying output buffer - `int`

  throws: java.nio.channels.ClosedChannelException - If this channel is closed"
  ([^java.nio.channels.DatagramChannel this ^java.nio.ByteBuffer src ^java.net.SocketAddress target]
    (-> this (.send src target))))

(defn bind
  "Description copied from interface: NetworkChannel

  local - The address to bind the socket, or null to bind the socket to an automatically assigned socket address - `java.net.SocketAddress`

  returns: This channel - `java.nio.channels.DatagramChannel`

  throws: java.nio.channels.AlreadyBoundException - If the socket is already bound"
  ([^java.nio.channels.DatagramChannel this ^java.net.SocketAddress local]
    (-> this (.bind local))))

(defn get-remote-address
  "Returns the remote address to which this channel's socket is connected.

  returns: The remote address; null if the channel's socket is not
            connected - `java.net.SocketAddress`

  throws: java.nio.channels.ClosedChannelException - If the channel is closed"
  ([^java.nio.channels.DatagramChannel this]
    (-> this (.getRemoteAddress))))

(defn connected?
  "Tells whether or not this channel's socket is connected.

  returns: true if, and only if, this channel's socket
            is open and connected - `boolean`"
  ([^java.nio.channels.DatagramChannel this]
    (-> this (.isConnected))))

(defn read
  "Reads a datagram from this channel.

    This method may only be invoked if this channel's socket is
   connected, and it only accepts datagrams from the socket's peer.  If
   there are more bytes in the datagram than remain in the given buffers
   then the remainder of the datagram is silently discarded.  Otherwise
   this method behaves exactly as specified in the ScatteringByteChannel interface.

  dsts - The buffers into which bytes are to be transferred - `java.nio.ByteBuffer[]`
  offset - The offset within the buffer array of the first buffer into which bytes are to be transferred; must be non-negative and no larger than dsts.length - `int`
  length - The maximum number of buffers to be accessed; must be non-negative and no larger than dsts.length - offset - `int`

  returns: The number of bytes read, possibly zero,
           or -1 if the channel has reached end-of-stream - `long`

  throws: java.nio.channels.NotYetConnectedException - If this channel's socket is not connected"
  ([^java.nio.channels.DatagramChannel this ^java.nio.ByteBuffer[] dsts ^Integer offset ^Integer length]
    (-> this (.read dsts offset length)))
  ([^java.nio.channels.DatagramChannel this ^java.nio.ByteBuffer dst]
    (-> this (.read dst))))

(defn connect
  "Connects this channel's socket.

    The channel's socket is configured so that it only receives
   datagrams from, and sends datagrams to, the given remote peer
   address.  Once connected, datagrams may not be received from or sent to
   any other address.  A datagram socket remains connected until it is
   explicitly disconnected or until it is closed.

    This method performs exactly the same security checks as the connect method of the DatagramSocket class.  That is, if a security manager has been
   installed then this method verifies that its checkAccept and checkConnect methods permit
   datagrams to be received from and sent to, respectively, the given
   remote address.

    This method may be invoked at any time.  It will not have any effect
   on read or write operations that are already in progress at the moment
   that it is invoked. If this channel's socket is not bound then this method
   will first cause the socket to be bound to an address that is assigned
   automatically, as if invoking the bind method with a
   parameter of null.

  remote - The remote address to which this channel is to be connected - `java.net.SocketAddress`

  returns: This datagram channel - `java.nio.channels.DatagramChannel`

  throws: java.nio.channels.ClosedChannelException - If this channel is closed"
  ([^java.nio.channels.DatagramChannel this ^java.net.SocketAddress remote]
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
  ([^java.nio.channels.DatagramChannel this]
    (-> this (.getLocalAddress))))

(defn valid-ops
  "Returns an operation set identifying this channel's supported
   operations.

    Datagram channels support reading and writing, so this method
   returns (SelectionKey.OP_READ | SelectionKey.OP_WRITE).

  returns: The valid-operation set - `int`"
  ([^java.nio.channels.DatagramChannel this]
    (-> this (.validOps))))

(defn set-option
  "Description copied from interface: NetworkChannel

  name - The socket option - `java.net.SocketOption<T>`
  value - The value of the socket option. A value of null may be a valid value for some socket options. - `T`

  returns: This channel - `<T> java.nio.channels.DatagramChannel`

  throws: java.lang.UnsupportedOperationException - If the socket option is not supported by this channel"
  ([^java.nio.channels.DatagramChannel this ^java.net.SocketOption name value]
    (-> this (.setOption name value))))

(defn socket
  "Retrieves a datagram socket associated with this channel.

    The returned object will not declare any public methods that are not
   declared in the DatagramSocket class.

  returns: A datagram socket associated with this channel - `java.net.DatagramSocket`"
  ([^java.nio.channels.DatagramChannel this]
    (-> this (.socket))))

(defn write
  "Writes a datagram to this channel.

    This method may only be invoked if this channel's socket is
   connected, in which case it sends datagrams directly to the socket's
   peer.  Otherwise it behaves exactly as specified in the GatheringByteChannel interface.

  srcs - The buffers from which bytes are to be retrieved - `java.nio.ByteBuffer[]`
  offset - The offset within the buffer array of the first buffer from which bytes are to be retrieved; must be non-negative and no larger than srcs.length - `int`
  length - The maximum number of buffers to be accessed; must be non-negative and no larger than srcs.length - offset - `int`

  returns: The number of bytes sent, which will be either the number
             of bytes that were remaining in the source buffer when this
             method was invoked or, if this channel is non-blocking, may be
             zero if there was insufficient room for the datagram in the
             underlying output buffer - `long`

  throws: java.nio.channels.NotYetConnectedException - If this channel's socket is not connected"
  ([^java.nio.channels.DatagramChannel this ^java.nio.ByteBuffer[] srcs ^Integer offset ^Integer length]
    (-> this (.write srcs offset length)))
  ([^java.nio.channels.DatagramChannel this ^java.nio.ByteBuffer src]
    (-> this (.write src))))

(defn receive
  "Receives a datagram via this channel.

    If a datagram is immediately available, or if this channel is in
   blocking mode and one eventually becomes available, then the datagram is
   copied into the given byte buffer and its source address is returned.
   If this channel is in non-blocking mode and a datagram is not
   immediately available then this method immediately returns
   null.

    The datagram is transferred into the given byte buffer starting at
   its current position, as if by a regular read operation.  If there
   are fewer bytes remaining in the buffer than are required to hold the
   datagram then the remainder of the datagram is silently discarded.

    This method performs exactly the same security checks as the receive method of the DatagramSocket class.  That is, if the socket is not connected
   to a specific remote address and a security manager has been installed
   then for each datagram received this method verifies that the source's
   address and port number are permitted by the security manager's checkAccept method.  The overhead
   of this security check can be avoided by first connecting the socket via
   the connect method.

    This method may be invoked at any time.  If another thread has
   already initiated a read operation upon this channel, however, then an
   invocation of this method will block until the first operation is
   complete. If this channel's socket is not bound then this method will
   first cause the socket to be bound to an address that is assigned
   automatically, as if invoking the bind method with a
   parameter of null.

  dst - The buffer into which the datagram is to be transferred - `java.nio.ByteBuffer`

  returns: The datagram's source address,
            or null if this channel is in non-blocking mode
            and no datagram was immediately available - `java.net.SocketAddress`

  throws: java.nio.channels.ClosedChannelException - If this channel is closed"
  ([^java.nio.channels.DatagramChannel this ^java.nio.ByteBuffer dst]
    (-> this (.receive dst))))

