(ns jdk.nio.channels.AsynchronousSocketChannel
  "An asynchronous channel for stream-oriented connecting sockets.

   Asynchronous socket channels are created in one of two ways. A newly-created
  AsynchronousSocketChannel is created by invoking one of the open methods defined by this class. A newly-created channel is open but
  not yet connected. A connected AsynchronousSocketChannel is created
  when a connection is made to the socket of an AsynchronousServerSocketChannel.
  It is not possible to create an asynchronous socket channel for an arbitrary,
  pre-existing socket.

   A newly-created channel is connected by invoking its connect
  method; once connected, a channel remains connected until it is closed.  Whether
  or not a socket channel is connected may be determined by invoking its getRemoteAddress method. An attempt to invoke an I/O
  operation upon an unconnected channel will cause a NotYetConnectedException
  to be thrown.

   Channels of this type are safe for use by multiple concurrent threads.
  They support concurrent reading and writing, though at most one read operation
  and one write operation can be outstanding at any time.
  If a thread initiates a read operation before a previous read operation has
  completed then a ReadPendingException will be thrown. Similarly, an
  attempt to initiate a write operation before a previous write has completed
  will throw a WritePendingException.

   Socket options are configured using the setOption method. Asynchronous socket channels support the following options:



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


       TCP_NODELAY
       Disable the Nagle algorithm



  Additional (implementation specific) options may also be supported.

  Timeouts

   The read
  and write
  methods defined by this class allow a timeout to be specified when initiating
  a read or write operation. If the timeout elapses before an operation completes
  then the operation completes with the exception InterruptedByTimeoutException. A timeout may leave the channel, or the
  underlying connection, in an inconsistent state. Where the implementation
  cannot guarantee that bytes have not been read from the channel then it puts
  the channel into an implementation specific error state. A subsequent
  attempt to initiate a read operation causes an unspecified runtime
  exception to be thrown. Similarly if a write operation times out and
  the implementation cannot guarantee bytes have not been written to the
  channel then further attempts to write to the channel cause an
  unspecified runtime exception to be thrown. When a timeout elapses then the
  state of the ByteBuffer, or the sequence of buffers, for the I/O
  operation is not defined. Buffers should be discarded or at least care must
  be taken to ensure that the buffers are not accessed while the channel remains
  open. All methods that accept timeout parameters treat values less than or
  equal to zero to mean that the I/O operation does not timeout."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.nio.channels AsynchronousSocketChannel]))

(defn *open
  "Opens an asynchronous socket channel.

    The new channel is created by invoking the openAsynchronousSocketChannel method on the AsynchronousChannelProvider that created the group. If the group parameter
   is null then the resulting channel is created by the system-wide
   default provider, and bound to the default group.

  group - The group to which the newly constructed channel should be bound, or null for the default group - `java.nio.channels.AsynchronousChannelGroup`

  returns: A new asynchronous socket channel - `java.nio.channels.AsynchronousSocketChannel`

  throws: java.nio.channels.ShutdownChannelGroupException - If the channel group is shutdown"
  (^java.nio.channels.AsynchronousSocketChannel [^java.nio.channels.AsynchronousChannelGroup group]
    (AsynchronousSocketChannel/open group))
  (^java.nio.channels.AsynchronousSocketChannel []
    (AsynchronousSocketChannel/open )))

(defn shutdown-output
  "Shutdown the connection for writing without closing the channel.

    Once shutdown for writing then further attempts to write to the
   channel will throw ClosedChannelException. If the output side of
   the connection is already shutdown then invoking this method has no
   effect. The effect on an outstanding write operation is system dependent
   and therefore not specified.

  returns: The channel - `java.nio.channels.AsynchronousSocketChannel`

  throws: java.nio.channels.NotYetConnectedException - If this channel is not yet connected"
  (^java.nio.channels.AsynchronousSocketChannel [^AsynchronousSocketChannel this]
    (-> this (.shutdownOutput))))

(defn bind
  "Description copied from interface: NetworkChannel

  local - The address to bind the socket, or null to bind the socket to an automatically assigned socket address - `java.net.SocketAddress`

  returns: This channel - `java.nio.channels.AsynchronousSocketChannel`

  throws: java.nio.channels.ConnectionPendingException - If a connection operation is already in progress on this channel"
  (^java.nio.channels.AsynchronousSocketChannel [^AsynchronousSocketChannel this ^java.net.SocketAddress local]
    (-> this (.bind local))))

(defn get-remote-address
  "Returns the remote address to which this channel's socket is connected.

    Where the channel is bound and connected to an Internet Protocol
   socket address then the return value from this method is of type InetSocketAddress.

  returns: The remote address; null if the channel's socket is not
            connected - `java.net.SocketAddress`

  throws: java.nio.channels.ClosedChannelException - If the channel is closed"
  (^java.net.SocketAddress [^AsynchronousSocketChannel this]
    (-> this (.getRemoteAddress))))

(defn read
  "Reads a sequence of bytes from this channel into a subsequence of the
   given buffers. This operation, sometimes called a scattering read,
   is often useful when implementing network protocols that group data into
   segments consisting of one or more fixed-length headers followed by a
   variable-length body. The handler parameter is a completion
   handler that is invoked when the read operation completes (or fails). The
   result passed to the completion handler is the number of bytes read or
   -1 if no bytes could be read because the channel has reached
   end-of-stream.

    This method initiates a read of up to r bytes from this channel,
   where r is the total number of bytes remaining in the specified
   subsequence of the given buffer array, that is,



   dsts[offset].remaining()
        dsts[offset+1].remaining()
        ...  dsts[offset+length-1].remaining()

   at the moment that the read is attempted.

    Suppose that a byte sequence of length n is read, where
   0 < n <= r.
   Up to the first dsts[offset].remaining() bytes of this sequence
   are transferred into buffer dsts[offset], up to the next
   dsts[offset+1].remaining() bytes are transferred into buffer
   dsts[offset+1], and so forth, until the entire byte sequence
   is transferred into the given buffers.  As many bytes as possible are
   transferred into each buffer, hence the final position of each updated
   buffer, except the last updated buffer, is guaranteed to be equal to
   that buffer's limit. The underlying operating system may impose a limit
   on the number of buffers that may be used in an I/O operation. Where the
   number of buffers (with bytes remaining), exceeds this limit, then the
   I/O operation is performed with the maximum number of buffers allowed by
   the operating system.

    If a timeout is specified and the timeout elapses before the operation
   completes then it completes with the exception InterruptedByTimeoutException. Where a timeout occurs, and the
   implementation cannot guarantee that bytes have not been read, or will not
   be read from the channel into the given buffers, then further attempts to
   read from the channel will cause an unspecific runtime exception to be
   thrown.

  dsts - The buffers into which bytes are to be transferred - `java.nio.ByteBuffer[]`
  offset - The offset within the buffer array of the first buffer into which bytes are to be transferred; must be non-negative and no larger than dsts.length - `int`
  length - The maximum number of buffers to be accessed; must be non-negative and no larger than dsts.length - offset - `int`
  timeout - The maximum time for the I/O operation to complete - `long`
  unit - The time unit of the timeout argument - `java.util.concurrent.TimeUnit`
  attachment - The object to attach to the I/O operation; can be null - `A`
  handler - The handler for consuming the result - `java.nio.channels.CompletionHandler`

  returns: `<A> void`

  throws: java.lang.IndexOutOfBoundsException - If the pre-conditions for the offset and length parameter aren't met"
  ([^AsynchronousSocketChannel this dsts ^Integer offset ^Integer length ^Long timeout ^java.util.concurrent.TimeUnit unit attachment ^java.nio.channels.CompletionHandler handler]
    (-> this (.read dsts offset length timeout unit attachment handler)))
  ([^AsynchronousSocketChannel this ^java.nio.ByteBuffer dst ^Long timeout ^java.util.concurrent.TimeUnit unit attachment ^java.nio.channels.CompletionHandler handler]
    (-> this (.read dst timeout unit attachment handler)))
  ([^AsynchronousSocketChannel this ^java.nio.ByteBuffer dst attachment ^java.nio.channels.CompletionHandler handler]
    (-> this (.read dst attachment handler)))
  (^java.util.concurrent.Future [^AsynchronousSocketChannel this ^java.nio.ByteBuffer dst]
    (-> this (.read dst))))

(defn provider
  "Returns the provider that created this channel.

  returns: The provider that created this channel - `java.nio.channels.spi.AsynchronousChannelProvider`"
  (^java.nio.channels.spi.AsynchronousChannelProvider [^AsynchronousSocketChannel this]
    (-> this (.provider))))

(defn connect
  "Connects this channel.

    This method initiates an operation to connect this channel. The
   handler parameter is a completion handler that is invoked when
   the connection is successfully established or connection cannot be
   established. If the connection cannot be established then the channel is
   closed.

    This method performs exactly the same security checks as the Socket class.  That is, if a security manager has been
   installed then this method verifies that its checkConnect method permits
   connecting to the address and port number of the given remote endpoint.

  remote - The remote address to which this channel is to be connected - `java.net.SocketAddress`
  attachment - The object to attach to the I/O operation; can be null - `A`
  handler - The handler for consuming the result - `java.nio.channels.CompletionHandler`

  returns: `<A> void`

  throws: java.nio.channels.UnresolvedAddressException - If the given remote address is not fully resolved"
  ([^AsynchronousSocketChannel this ^java.net.SocketAddress remote attachment ^java.nio.channels.CompletionHandler handler]
    (-> this (.connect remote attachment handler)))
  (^java.util.concurrent.Future [^AsynchronousSocketChannel this ^java.net.SocketAddress remote]
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
  (^java.net.SocketAddress [^AsynchronousSocketChannel this]
    (-> this (.getLocalAddress))))

(defn set-option
  "Description copied from interface: NetworkChannel

  name - The socket option - `java.net.SocketOption`
  value - The value of the socket option. A value of null may be a valid value for some socket options. - `T`

  returns: This channel - `<T> java.nio.channels.AsynchronousSocketChannel`

  throws: java.lang.IllegalArgumentException - If the value is not a valid value for this socket option"
  ([^AsynchronousSocketChannel this ^java.net.SocketOption name value]
    (-> this (.setOption name value))))

(defn shutdown-input
  "Shutdown the connection for reading without closing the channel.

    Once shutdown for reading then further reads on the channel will
   return -1, the end-of-stream indication. If the input side of the
   connection is already shutdown then invoking this method has no effect.
   The effect on an outstanding read operation is system dependent and
   therefore not specified. The effect, if any, when there is data in the
   socket receive buffer that has not been read, or data arrives subsequently,
   is also system dependent.

  returns: The channel - `java.nio.channels.AsynchronousSocketChannel`

  throws: java.nio.channels.NotYetConnectedException - If this channel is not yet connected"
  (^java.nio.channels.AsynchronousSocketChannel [^AsynchronousSocketChannel this]
    (-> this (.shutdownInput))))

(defn write
  "Writes a sequence of bytes to this channel from a subsequence of the given
   buffers. This operation, sometimes called a gathering write, is
   often useful when implementing network protocols that group data into
   segments consisting of one or more fixed-length headers followed by a
   variable-length body. The handler parameter is a completion
   handler that is invoked when the write operation completes (or fails).
   The result passed to the completion handler is the number of bytes written.

    This method initiates a write of up to r bytes to this channel,
   where r is the total number of bytes remaining in the specified
   subsequence of the given buffer array, that is,



   srcs[offset].remaining()
        srcs[offset+1].remaining()
        ...  srcs[offset+length-1].remaining()

   at the moment that the write is attempted.

    Suppose that a byte sequence of length n is written, where
   0 < n <= r.
   Up to the first srcs[offset].remaining() bytes of this sequence
   are written from buffer srcs[offset], up to the next
   srcs[offset+1].remaining() bytes are written from buffer
   srcs[offset+1], and so forth, until the entire byte sequence is
   written.  As many bytes as possible are written from each buffer, hence
   the final position of each updated buffer, except the last updated
   buffer, is guaranteed to be equal to that buffer's limit. The underlying
   operating system may impose a limit on the number of buffers that may be
   used in an I/O operation. Where the number of buffers (with bytes
   remaining), exceeds this limit, then the I/O operation is performed with
   the maximum number of buffers allowed by the operating system.

    If a timeout is specified and the timeout elapses before the operation
   completes then it completes with the exception InterruptedByTimeoutException. Where a timeout occurs, and the
   implementation cannot guarantee that bytes have not been written, or will
   not be written to the channel from the given buffers, then further attempts
   to write to the channel will cause an unspecific runtime exception to be
   thrown.

  srcs - The buffers from which bytes are to be retrieved - `java.nio.ByteBuffer[]`
  offset - The offset within the buffer array of the first buffer from which bytes are to be retrieved; must be non-negative and no larger than srcs.length - `int`
  length - The maximum number of buffers to be accessed; must be non-negative and no larger than srcs.length - offset - `int`
  timeout - The maximum time for the I/O operation to complete - `long`
  unit - The time unit of the timeout argument - `java.util.concurrent.TimeUnit`
  attachment - The object to attach to the I/O operation; can be null - `A`
  handler - The handler for consuming the result - `java.nio.channels.CompletionHandler`

  returns: `<A> void`

  throws: java.lang.IndexOutOfBoundsException - If the pre-conditions for the offset and length parameter aren't met"
  ([^AsynchronousSocketChannel this srcs ^Integer offset ^Integer length ^Long timeout ^java.util.concurrent.TimeUnit unit attachment ^java.nio.channels.CompletionHandler handler]
    (-> this (.write srcs offset length timeout unit attachment handler)))
  ([^AsynchronousSocketChannel this ^java.nio.ByteBuffer src ^Long timeout ^java.util.concurrent.TimeUnit unit attachment ^java.nio.channels.CompletionHandler handler]
    (-> this (.write src timeout unit attachment handler)))
  ([^AsynchronousSocketChannel this ^java.nio.ByteBuffer src attachment ^java.nio.channels.CompletionHandler handler]
    (-> this (.write src attachment handler)))
  (^java.util.concurrent.Future [^AsynchronousSocketChannel this ^java.nio.ByteBuffer src]
    (-> this (.write src))))

