(ns jdk.net.Socket
  "This class implements client sockets (also called just
  `sockets`). A socket is an endpoint for communication
  between two machines.

  The actual work of the socket is performed by an instance of the
  SocketImpl class. An application, by changing
  the socket factory that creates the socket implementation,
  can configure itself to create sockets appropriate to the local
  firewall."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.net Socket]))

(defn ->socket
  "Constructor.

  Creates a socket and connects it to the specified remote host on
   the specified remote port. The Socket will also bind() to the local
   address and port supplied.

   If the specified host is null it is the equivalent of
   specifying the address as
   InetAddress.getByName(null).
   In other words, it is equivalent to specifying an address of the
   loopback interface.

   A local port number of zero will let the system pick up a
   free port in the bind operation.

   If there is a security manager, its
   checkConnect method is called
   with the host address and port
   as its arguments. This could result in a SecurityException.

  host - the name of the remote host, or null for the loopback address. - `java.lang.String`
  port - the remote port - `int`
  local-addr - the local address the socket is bound to, or null for the anyLocal address. - `java.net.InetAddress`
  local-port - the local port the socket is bound to, or zero for a system selected free port. - `int`

  throws: java.io.IOException - if an I/O error occurs when creating the socket."
  (^Socket [^java.lang.String host ^Integer port ^java.net.InetAddress local-addr ^Integer local-port]
    (new Socket host port local-addr local-port))
  (^Socket [^java.lang.String host ^Integer port ^Boolean stream]
    (new Socket host port stream))
  (^Socket [^java.lang.String host ^Integer port]
    (new Socket host port))
  (^Socket [^java.net.Proxy proxy]
    (new Socket proxy))
  (^Socket []
    (new Socket )))

(defn *set-socket-impl-factory
  "Sets the client socket implementation factory for the
   application. The factory can be specified only once.

   When an application creates a new client socket, the socket
   implementation factory's createSocketImpl method is
   called to create the actual socket implementation.

   Passing null to the method is a no-op unless the factory
   was already set.
   If there is a security manager, this method first calls
   the security manager's checkSetFactory method
   to ensure the operation is allowed.
   This could result in a SecurityException.

  fac - the desired factory. - `java.net.SocketImplFactory`

  throws: java.io.IOException - if an I/O error occurs when setting the socket factory."
  ([^java.net.SocketImplFactory fac]
    (Socket/setSocketImplFactory fac)))

(defn set-traffic-class
  "Sets traffic class or type-of-service octet in the IP
   header for packets sent from this Socket.
   As the underlying network implementation may ignore this
   value applications should consider it a hint.

    The tc must be in the range 0 <= tc <=
   255 or an IllegalArgumentException will be thrown.
   Notes:
   For Internet Protocol v4 the value consists of an
   integer, the least significant 8 bits of which
   represent the value of the TOS octet in IP packets sent by
   the socket.
   RFC 1349 defines the TOS values as follows:


   IPTOS_LOWCOST (0x02)
   IPTOS_RELIABILITY (0x04)
   IPTOS_THROUGHPUT (0x08)
   IPTOS_LOWDELAY (0x10)

   The last low order bit is always ignored as this
   corresponds to the MBZ (must be zero) bit.

   Setting bits in the precedence field may result in a
   SocketException indicating that the operation is not
   permitted.

   As RFC 1122 section 4.2.4.2 indicates, a compliant TCP
   implementation should, but is not required to, let application
   change the TOS field during the lifetime of a connection.
   So whether the type-of-service field can be changed after the
   TCP connection has been established depends on the implementation
   in the underlying platform. Applications should not assume that
   they can change the TOS field after the connection.

   For Internet Protocol v6 tc is the value that
   would be placed into the sin6_flowinfo field of the IP header.

  tc - an int value for the bitset. - `int`

  throws: java.net.SocketException - if there is an error setting the traffic class or type-of-service"
  ([^Socket this ^Integer tc]
    (-> this (.setTrafficClass tc))))

(defn set-performance-preferences
  "Sets performance preferences for this socket.

    Sockets use the TCP/IP protocol by default.  Some implementations
   may offer alternative protocols which have different performance
   characteristics than TCP/IP.  This method allows the application to
   express its own preferences as to how these tradeoffs should be made
   when the implementation chooses from the available protocols.

    Performance preferences are described by three integers
   whose values indicate the relative importance of short connection time,
   low latency, and high bandwidth.  The absolute values of the integers
   are irrelevant; in order to choose a protocol the values are simply
   compared, with larger values indicating stronger preferences. Negative
   values represent a lower priority than positive values. If the
   application prefers short connection time over both low latency and high
   bandwidth, for example, then it could invoke this method with the values
   (1, 0, 0).  If the application prefers high bandwidth above low
   latency, and low latency above short connection time, then it could
   invoke this method with the values (0, 1, 2).

    Invoking this method after this socket has been connected
   will have no effect.

  connection-time - An int expressing the relative importance of a short connection time - `int`
  latency - An int expressing the relative importance of low latency - `int`
  bandwidth - An int expressing the relative importance of high bandwidth - `int`"
  ([^Socket this ^Integer connection-time ^Integer latency ^Integer bandwidth]
    (-> this (.setPerformancePreferences connection-time latency bandwidth))))

(defn get-send-buffer-size
  "Get value of the SO_SNDBUF option
   for this Socket, that is the buffer size used by the platform
   for output on this Socket.

  returns: the value of the SO_SNDBUF
           option for this Socket. - `int`

  throws: java.net.SocketException - if there is an error in the underlying protocol, such as a TCP error."
  (^Integer [^Socket this]
    (-> this (.getSendBufferSize))))

(defn get-local-port
  "Returns the local port number to which this socket is bound.

   If the socket was bound prior to being closed,
   then this method will continue to return the local port number
   after the socket is closed.

  returns: the local port number to which this socket is bound or -1
            if the socket is not bound yet. - `int`"
  (^Integer [^Socket this]
    (-> this (.getLocalPort))))

(defn set-so-timeout
  "Enable/disable SO_TIMEOUT
    with the specified timeout, in milliseconds. With this option set
    to a non-zero timeout, a read() call on the InputStream associated with
    this Socket will block for only this amount of time.  If the timeout
    expires, a java.net.SocketTimeoutException is raised, though the
    Socket is still valid. The option must be enabled
    prior to entering the blocking operation to have effect. The
    timeout must be > 0.
    A timeout of zero is interpreted as an infinite timeout.

  timeout - the specified timeout, in milliseconds. - `int`

  throws: java.net.SocketException - if there is an error in the underlying protocol, such as a TCP error."
  ([^Socket this ^Integer timeout]
    (-> this (.setSoTimeout timeout))))

(defn send-urgent-data
  "Send one byte of urgent data on the socket. The byte to be sent is the lowest eight
   bits of the data parameter. The urgent byte is
   sent after any preceding writes to the socket OutputStream
   and before any future writes to the OutputStream.

  data - The byte of data to send - `int`

  throws: java.io.IOException - if there is an error sending the data."
  ([^Socket this ^Integer data]
    (-> this (.sendUrgentData data))))

(defn shutdown-output
  "Disables the output stream for this socket.
   For a TCP socket, any previously written data will be sent
   followed by TCP's normal connection termination sequence.

   If you write to a socket output stream after invoking
   shutdownOutput() on the socket, the stream will throw
   an IOException.

  throws: java.io.IOException - if an I/O error occurs when shutting down this socket."
  ([^Socket this]
    (-> this (.shutdownOutput))))

(defn bind
  "Binds the socket to a local address.

   If the address is null, then the system will pick up
   an ephemeral port and a valid local address to bind the socket.

  bindpoint - the SocketAddress to bind to - `java.net.SocketAddress`

  throws: java.io.IOException - if the bind operation fails, or if the socket is already bound."
  ([^Socket this ^java.net.SocketAddress bindpoint]
    (-> this (.bind bindpoint))))

(defn set-reuse-address
  "Enable/disable the SO_REUSEADDR
   socket option.

   When a TCP connection is closed the connection may remain
   in a timeout state for a period of time after the connection
   is closed (typically known as the TIME_WAIT state
   or 2MSL wait state).
   For applications using a well known socket address or port
   it may not be possible to bind a socket to the required
   SocketAddress if there is a connection in the
   timeout state involving the socket address or port.

   Enabling SO_REUSEADDR
   prior to binding the socket using bind(SocketAddress) allows
   the socket to be bound even though a previous connection is in a timeout
   state.

   When a Socket is created the initial setting
   of SO_REUSEADDR is disabled.

   The behaviour when SO_REUSEADDR is
   enabled or disabled after a socket is bound (See isBound())
   is not defined.

  on - whether to enable or disable the socket option - `boolean`

  throws: java.net.SocketException - if an error occurs enabling or disabling the SO_REUSEADDR socket option, or the socket is closed."
  ([^Socket this ^Boolean on]
    (-> this (.setReuseAddress on))))

(defn output-shutdown?
  "Returns whether the write-half of the socket connection is closed.

  returns: true if the output of the socket has been shutdown - `boolean`"
  (^Boolean [^Socket this]
    (-> this (.isOutputShutdown))))

(defn connected?
  "Returns the connection state of the socket.

   Note: Closing a socket doesn't clear its connection state, which means
   this method will return true for a closed socket
   (see isClosed()) if it was successfuly connected prior
   to being closed.

  returns: true if the socket was successfuly connected to a server - `boolean`"
  (^Boolean [^Socket this]
    (-> this (.isConnected))))

(defn get-tcp-no-delay?
  "Tests if TCP_NODELAY is enabled.

  returns: a boolean indicating whether or not
           TCP_NODELAY is enabled. - `boolean`

  throws: java.net.SocketException - if there is an error in the underlying protocol, such as a TCP error."
  (^Boolean [^Socket this]
    (-> this (.getTcpNoDelay))))

(defn to-string
  "Converts this socket to a String.

  returns: a string representation of this socket. - `java.lang.String`"
  (^java.lang.String [^Socket this]
    (-> this (.toString))))

(defn get-oob-inline?
  "Tests if SO_OOBINLINE is enabled.

  returns: a boolean indicating whether or not
           SO_OOBINLINEis enabled. - `boolean`

  throws: java.net.SocketException - if there is an error in the underlying protocol, such as a TCP error."
  (^Boolean [^Socket this]
    (-> this (.getOOBInline))))

(defn get-so-timeout
  "Returns setting for SO_TIMEOUT.
   0 returns implies that the option is disabled (i.e., timeout of infinity).

  returns: the setting for SO_TIMEOUT - `int`

  throws: java.net.SocketException - if there is an error in the underlying protocol, such as a TCP error."
  (^Integer [^Socket this]
    (-> this (.getSoTimeout))))

(defn get-remote-socket-address
  "Returns the address of the endpoint this socket is connected to, or
   null if it is unconnected.

   If the socket was connected prior to being closed,
   then this method will continue to return the connected address
   after the socket is closed.

  returns: a SocketAddress representing the remote endpoint of this
           socket, or null if it is not connected yet. - `java.net.SocketAddress`"
  (^java.net.SocketAddress [^Socket this]
    (-> this (.getRemoteSocketAddress))))

(defn input-shutdown?
  "Returns whether the read-half of the socket connection is closed.

  returns: true if the input of the socket has been shutdown - `boolean`"
  (^Boolean [^Socket this]
    (-> this (.isInputShutdown))))

(defn connect
  "Connects this socket to the server with a specified timeout value.
   A timeout of zero is interpreted as an infinite timeout. The connection
   will then block until established or an error occurs.

  endpoint - the SocketAddress - `java.net.SocketAddress`
  timeout - the timeout value to be used in milliseconds. - `int`

  throws: java.io.IOException - if an error occurs during the connection"
  ([^Socket this ^java.net.SocketAddress endpoint ^Integer timeout]
    (-> this (.connect endpoint timeout)))
  ([^Socket this ^java.net.SocketAddress endpoint]
    (-> this (.connect endpoint))))

(defn closed?
  "Returns the closed state of the socket.

  returns: true if the socket has been closed - `boolean`"
  (^Boolean [^Socket this]
    (-> this (.isClosed))))

(defn set-so-linger
  "Enable/disable SO_LINGER with the
   specified linger time in seconds. The maximum timeout value is platform
   specific.

   The setting only affects socket close.

  on - whether or not to linger on. - `boolean`
  linger - how long to linger for, if on is true. - `int`

  throws: java.net.SocketException - if there is an error in the underlying protocol, such as a TCP error."
  ([^Socket this ^Boolean on ^Integer linger]
    (-> this (.setSoLinger on linger))))

(defn get-reuse-address?
  "Tests if SO_REUSEADDR is enabled.

  returns: a boolean indicating whether or not
           SO_REUSEADDR is enabled. - `boolean`

  throws: java.net.SocketException - if there is an error in the underlying protocol, such as a TCP error."
  (^Boolean [^Socket this]
    (-> this (.getReuseAddress))))

(defn set-send-buffer-size
  "Sets the SO_SNDBUF option to the
   specified value for this Socket.
   The SO_SNDBUF option is used by the
   platform's networking code as a hint for the size to set the underlying
   network I/O buffers.

   Because SO_SNDBUF is a hint,
   applications that want to verify what size the buffers were set to
   should call getSendBufferSize().

  size - the size to which to set the send buffer size. This value must be greater than 0. - `int`

  throws: java.net.SocketException - if there is an error in the underlying protocol, such as a TCP error."
  ([^Socket this ^Integer size]
    (-> this (.setSendBufferSize size))))

(defn get-local-socket-address
  "Returns the address of the endpoint this socket is bound to.

   If a socket bound to an endpoint represented by an
   InetSocketAddress  is closed,
   then this method will continue to return an InetSocketAddress
   after the socket is closed. In that case the returned
   InetSocketAddress's address is the
   wildcard address
   and its port is the local port that it was bound to.

   If there is a security manager set, its checkConnect method is
   called with the local address and -1 as its arguments to see
   if the operation is allowed. If the operation is not allowed,
   a SocketAddress representing the
   loopback address and the local
   port to which this socket is bound is returned.

  returns: a SocketAddress representing the local endpoint of
           this socket, or a SocketAddress representing the
           loopback address if denied by the security manager, or
           null if the socket is not bound yet. - `java.net.SocketAddress`"
  (^java.net.SocketAddress [^Socket this]
    (-> this (.getLocalSocketAddress))))

(defn get-local-address
  "Gets the local address to which the socket is bound.

   If there is a security manager set, its checkConnect method is
   called with the local address and -1 as its arguments to see
   if the operation is allowed. If the operation is not allowed,
   the loopback address is returned.

  returns: the local address to which the socket is bound,
           the loopback address if denied by the security manager, or
           the wildcard address if the socket is closed or not bound yet. - `java.net.InetAddress`"
  (^java.net.InetAddress [^Socket this]
    (-> this (.getLocalAddress))))

(defn get-keep-alive?
  "Tests if SO_KEEPALIVE is enabled.

  returns: a boolean indicating whether or not
           SO_KEEPALIVE is enabled. - `boolean`

  throws: java.net.SocketException - if there is an error in the underlying protocol, such as a TCP error."
  (^Boolean [^Socket this]
    (-> this (.getKeepAlive))))

(defn close
  "Closes this socket.

   Any thread currently blocked in an I/O operation upon this socket
   will throw a SocketException.

   Once a socket has been closed, it is not available for further networking
   use (i.e. can't be reconnected or rebound). A new socket needs to be
   created.

    Closing this socket will also close the socket's
   InputStream and
   OutputStream.

    If this socket has an associated channel then the channel is closed
   as well.

  throws: java.io.IOException - if an I/O error occurs when closing this socket."
  ([^Socket this]
    (-> this (.close))))

(defn get-receive-buffer-size
  "Gets the value of the SO_RCVBUF option
   for this Socket, that is the buffer size used by the platform
   for input on this Socket.

  returns: the value of the SO_RCVBUF
           option for this Socket. - `int`

  throws: java.net.SocketException - if there is an error in the underlying protocol, such as a TCP error."
  (^Integer [^Socket this]
    (-> this (.getReceiveBufferSize))))

(defn get-output-stream
  "Returns an output stream for this socket.

    If this socket has an associated channel then the resulting output
   stream delegates all of its operations to the channel.  If the channel
   is in non-blocking mode then the output stream's write
   operations will throw an IllegalBlockingModeException.

    Closing the returned OutputStream
   will close the associated socket.

  returns: an output stream for writing bytes to this socket. - `java.io.OutputStream`

  throws: java.io.IOException - if an I/O error occurs when creating the output stream or if the socket is not connected."
  (^java.io.OutputStream [^Socket this]
    (-> this (.getOutputStream))))

(defn get-traffic-class
  "Gets traffic class or type-of-service in the IP header
   for packets sent from this Socket

   As the underlying network implementation may ignore the
   traffic class or type-of-service set using setTrafficClass(int)
   this method may return a different value than was previously
   set using the setTrafficClass(int) method on this Socket.

  returns: the traffic class or type-of-service already set - `int`

  throws: java.net.SocketException - if there is an error obtaining the traffic class or type-of-service value."
  (^Integer [^Socket this]
    (-> this (.getTrafficClass))))

(defn set-receive-buffer-size
  "Sets the SO_RCVBUF option to the
   specified value for this Socket. The
   SO_RCVBUF option is
   used by the platform's networking code as a hint for the size to set
   the underlying network I/O buffers.

   Increasing the receive buffer size can increase the performance of
   network I/O for high-volume connection, while decreasing it can
   help reduce the backlog of incoming data.

   Because SO_RCVBUF is a hint,
   applications that want to verify what size the buffers were set to
   should call getReceiveBufferSize().

   The value of SO_RCVBUF is also used
   to set the TCP receive window that is advertized to the remote peer.
   Generally, the window size can be modified at any time when a socket is
   connected. However, if a receive window larger than 64K is required then
   this must be requested before the socket is connected to the
   remote peer. There are two cases to be aware of:

   For sockets accepted from a ServerSocket, this must be done by calling
   ServerSocket.setReceiveBufferSize(int) before the ServerSocket
   is bound to a local address.
   For client sockets, setReceiveBufferSize() must be called before
   connecting the socket to its remote peer.

  size - the size to which to set the receive buffer size. This value must be greater than 0. - `int`

  throws: java.lang.IllegalArgumentException - if the value is 0 or is negative."
  ([^Socket this ^Integer size]
    (-> this (.setReceiveBufferSize size))))

(defn get-port
  "Returns the remote port number to which this socket is connected.

   If the socket was connected prior to being closed,
   then this method will continue to return the connected port number
   after the socket is closed.

  returns: the remote port number to which this socket is connected, or
            0 if the socket is not connected yet. - `int`"
  (^Integer [^Socket this]
    (-> this (.getPort))))

(defn set-oob-inline
  "Enable/disable SO_OOBINLINE
   (receipt of TCP urgent data)

   By default, this option is disabled and TCP urgent data received on a
   socket is silently discarded. If the user wishes to receive urgent data, then
   this option must be enabled. When enabled, urgent data is received
   inline with normal data.

   Note, only limited support is provided for handling incoming urgent
   data. In particular, no notification of incoming urgent data is provided
   and there is no capability to distinguish between normal data and urgent
   data unless provided by a higher level protocol.

  on - true to enable SO_OOBINLINE, false to disable. - `boolean`

  throws: java.net.SocketException - if there is an error in the underlying protocol, such as a TCP error."
  ([^Socket this ^Boolean on]
    (-> this (.setOOBInline on))))

(defn set-tcp-no-delay
  "Enable/disable TCP_NODELAY
   (disable/enable Nagle's algorithm).

  on - true to enable TCP_NODELAY, false to disable. - `boolean`

  throws: java.net.SocketException - if there is an error in the underlying protocol, such as a TCP error."
  ([^Socket this ^Boolean on]
    (-> this (.setTcpNoDelay on))))

(defn get-input-stream
  "Returns an input stream for this socket.

    If this socket has an associated channel then the resulting input
   stream delegates all of its operations to the channel.  If the channel
   is in non-blocking mode then the input stream's read operations
   will throw an IllegalBlockingModeException.

   Under abnormal conditions the underlying connection may be
   broken by the remote host or the network software (for example
   a connection reset in the case of TCP connections). When a
   broken connection is detected by the network software the
   following applies to the returned input stream :-



     The network software may discard bytes that are buffered
     by the socket. Bytes that aren't discarded by the network
     software can be read using read.

     If there are no bytes buffered on the socket, or all
     buffered bytes have been consumed by
     read, then all subsequent
     calls to read will throw an
     IOException.

     If there are no bytes buffered on the socket, and the
     socket has not been closed using close, then
     available will
     return 0.



    Closing the returned InputStream
   will close the associated socket.

  returns: an input stream for reading bytes from this socket. - `java.io.InputStream`

  throws: java.io.IOException - if an I/O error occurs when creating the input stream, the socket is closed, the socket is not connected, or the socket input has been shutdown using shutdownInput()"
  (^java.io.InputStream [^Socket this]
    (-> this (.getInputStream))))

(defn bound?
  "Returns the binding state of the socket.

   Note: Closing a socket doesn't clear its binding state, which means
   this method will return true for a closed socket
   (see isClosed()) if it was successfuly bound prior
   to being closed.

  returns: true if the socket was successfuly bound to an address - `boolean`"
  (^Boolean [^Socket this]
    (-> this (.isBound))))

(defn shutdown-input
  "Places the input stream for this socket at `end of stream`.
   Any data sent to the input stream side of the socket is acknowledged
   and then silently discarded.

   If you read from a socket input stream after invoking this method on the
   socket, the stream's available method will return 0, and its
   read methods will return -1 (end of stream).

  throws: java.io.IOException - if an I/O error occurs when shutting down this socket."
  ([^Socket this]
    (-> this (.shutdownInput))))

(defn get-so-linger
  "Returns setting for SO_LINGER.
   -1 returns implies that the
   option is disabled.

   The setting only affects socket close.

  returns: the setting for SO_LINGER. - `int`

  throws: java.net.SocketException - if there is an error in the underlying protocol, such as a TCP error."
  (^Integer [^Socket this]
    (-> this (.getSoLinger))))

(defn get-channel
  "Returns the unique SocketChannel
   object associated with this socket, if any.

    A socket will have a channel if, and only if, the channel itself was
   created via the SocketChannel.open or ServerSocketChannel.accept
   methods.

  returns: the socket channel associated with this socket,
            or null if this socket was not created
            for a channel - `java.nio.channels.SocketChannel`"
  (^java.nio.channels.SocketChannel [^Socket this]
    (-> this (.getChannel))))

(defn get-inet-address
  "Returns the address to which the socket is connected.

   If the socket was connected prior to being closed,
   then this method will continue to return the connected address
   after the socket is closed.

  returns: the remote IP address to which this socket is connected,
            or null if the socket is not connected. - `java.net.InetAddress`"
  (^java.net.InetAddress [^Socket this]
    (-> this (.getInetAddress))))

(defn set-keep-alive
  "Enable/disable SO_KEEPALIVE.

  on - whether or not to have socket keep alive turned on. - `boolean`

  throws: java.net.SocketException - if there is an error in the underlying protocol, such as a TCP error."
  ([^Socket this ^Boolean on]
    (-> this (.setKeepAlive on))))

