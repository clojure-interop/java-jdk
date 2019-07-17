(ns jdk.net.ServerSocket
  "This class implements server sockets. A server socket waits for
  requests to come in over the network. It performs some operation
  based on that request, and then possibly returns a result to the requester.

  The actual work of the server socket is performed by an instance
  of the SocketImpl class. An application can
  change the socket factory that creates the socket
  implementation to configure itself to create sockets
  appropriate to the local firewall."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.net ServerSocket]))

(defn ->server-socket
  "Constructor.

  Create a server with the specified port, listen backlog, and
   local IP address to bind to.  The bindAddr argument
   can be used on a multi-homed host for a ServerSocket that
   will only accept connect requests to one of its addresses.
   If bindAddr is null, it will default accepting
   connections on any/all local addresses.
   The port must be between 0 and 65535, inclusive.
   A port number of 0 means that the port number is
   automatically allocated, typically from an ephemeral port range.
   This port number can then be retrieved by calling
   getLocalPort.

   If there is a security manager, this method
   calls its checkListen method
   with the port argument
   as its argument to ensure the operation is allowed.
   This could result in a SecurityException.

   The backlog argument is the requested maximum number of
   pending connections on the socket. Its exact semantics are implementation
   specific. In particular, an implementation may impose a maximum length
   or may choose to ignore the parameter altogther. The value provided
   should be greater than 0. If it is less than or equal to
   0, then an implementation specific default will be used.

  port - the port number, or 0 to use a port number that is automatically allocated. - `int`
  backlog - requested maximum length of the queue of incoming connections. - `int`
  bind-addr - the local InetAddress the server will bind to - `java.net.InetAddress`

  throws: java.lang.SecurityException - if a security manager exists and its checkListen method doesn't allow the operation."
  ([^Integer port ^Integer backlog ^java.net.InetAddress bind-addr]
    (new ServerSocket port backlog bind-addr))
  ([^Integer port ^Integer backlog]
    (new ServerSocket port backlog))
  ([^Integer port]
    (new ServerSocket port))
  ([]
    (new ServerSocket )))

(defn *set-socket-factory
  "Sets the server socket implementation factory for the
   application. The factory can be specified only once.

   When an application creates a new server socket, the socket
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
    (ServerSocket/setSocketFactory fac)))

(defn set-performance-preferences
  "Sets performance preferences for this ServerSocket.

    Sockets use the TCP/IP protocol by default.  Some implementations
   may offer alternative protocols which have different performance
   characteristics than TCP/IP.  This method allows the application to
   express its own preferences as to how these tradeoffs should be made
   when the implementation chooses from the available protocols.

    Performance preferences are described by three integers
   whose values indicate the relative importance of short connection time,
   low latency, and high bandwidth.  The absolute values of the integers
   are irrelevant; in order to choose a protocol the values are simply
   compared, with larger values indicating stronger preferences.  If the
   application prefers short connection time over both low latency and high
   bandwidth, for example, then it could invoke this method with the values
   (1, 0, 0).  If the application prefers high bandwidth above low
   latency, and low latency above short connection time, then it could
   invoke this method with the values (0, 1, 2).

    Invoking this method after this socket has been bound
   will have no effect. This implies that in order to use this capability
   requires the socket to be created with the no-argument constructor.

  connection-time - An int expressing the relative importance of a short connection time - `int`
  latency - An int expressing the relative importance of low latency - `int`
  bandwidth - An int expressing the relative importance of high bandwidth - `int`"
  ([^java.net.ServerSocket this ^Integer connection-time ^Integer latency ^Integer bandwidth]
    (-> this (.setPerformancePreferences connection-time latency bandwidth))))

(defn get-local-port
  "Returns the port number on which this socket is listening.

   If the socket was bound prior to being closed,
   then this method will continue to return the port number
   after the socket is closed.

  returns: the port number to which this socket is listening or
            -1 if the socket is not bound yet. - `int`"
  (^Integer [^java.net.ServerSocket this]
    (-> this (.getLocalPort))))

(defn set-so-timeout
  "Enable/disable SO_TIMEOUT with the
   specified timeout, in milliseconds.  With this option set to a non-zero
   timeout, a call to accept() for this ServerSocket
   will block for only this amount of time.  If the timeout expires,
   a java.net.SocketTimeoutException is raised, though the
   ServerSocket is still valid.  The option must be enabled
   prior to entering the blocking operation to have effect.  The
   timeout must be > 0.
   A timeout of zero is interpreted as an infinite timeout.

  timeout - the specified timeout, in milliseconds - `int`

  throws: java.net.SocketException - if there is an error in the underlying protocol, such as a TCP error."
  ([^java.net.ServerSocket this ^Integer timeout]
    (-> this (.setSoTimeout timeout))))

(defn bind
  "Binds the ServerSocket to a specific address
   (IP address and port number).

   If the address is null, then the system will pick up
   an ephemeral port and a valid local address to bind the socket.

   The backlog argument is the requested maximum number of
   pending connections on the socket. Its exact semantics are implementation
   specific. In particular, an implementation may impose a maximum length
   or may choose to ignore the parameter altogther. The value provided
   should be greater than 0. If it is less than or equal to
   0, then an implementation specific default will be used.

  endpoint - The IP address and port number to bind to. - `java.net.SocketAddress`
  backlog - requested maximum length of the queue of incoming connections. - `int`

  throws: java.io.IOException - if the bind operation fails, or if the socket is already bound."
  ([^java.net.ServerSocket this ^java.net.SocketAddress endpoint ^Integer backlog]
    (-> this (.bind endpoint backlog)))
  ([^java.net.ServerSocket this ^java.net.SocketAddress endpoint]
    (-> this (.bind endpoint))))

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

   Enabling SO_REUSEADDR prior to
   binding the socket using bind(SocketAddress) allows the socket
   to be bound even though a previous connection is in a timeout state.

   When a ServerSocket is created the initial setting
   of SO_REUSEADDR is not defined.
   Applications can use getReuseAddress() to determine the initial
   setting of SO_REUSEADDR.

   The behaviour when SO_REUSEADDR is
   enabled or disabled after a socket is bound (See isBound())
   is not defined.

  on - whether to enable or disable the socket option - `boolean`

  throws: java.net.SocketException - if an error occurs enabling or disabling the SO_REUSEADDR socket option, or the socket is closed."
  ([^java.net.ServerSocket this ^Boolean on]
    (-> this (.setReuseAddress on))))

(defn to-string
  "Returns the implementation address and implementation port of
   this socket as a String.

   If there is a security manager set, its checkConnect method is
   called with the local address and -1 as its arguments to see
   if the operation is allowed. If the operation is not allowed,
   an InetAddress representing the
   loopback address is returned as
   the implementation address.

  returns: a string representation of this socket. - `java.lang.String`"
  (^java.lang.String [^java.net.ServerSocket this]
    (-> this (.toString))))

(defn get-so-timeout
  "Retrieve setting for SO_TIMEOUT.
   0 returns implies that the option is disabled (i.e., timeout of infinity).

  returns: the SO_TIMEOUT value - `int`

  throws: java.io.IOException - if an I/O error occurs"
  (^Integer [^java.net.ServerSocket this]
    (-> this (.getSoTimeout))))

(defn closed?
  "Returns the closed state of the ServerSocket.

  returns: true if the socket has been closed - `boolean`"
  (^Boolean [^java.net.ServerSocket this]
    (-> this (.isClosed))))

(defn accept
  "Listens for a connection to be made to this socket and accepts
   it. The method blocks until a connection is made.

   A new Socket s is created and, if there
   is a security manager,
   the security manager's checkAccept method is called
   with s.getInetAddress().getHostAddress() and
   s.getPort()
   as its arguments to ensure the operation is allowed.
   This could result in a SecurityException.

  returns: the new Socket - `java.net.Socket`

  throws: java.io.IOException - if an I/O error occurs when waiting for a connection."
  (^java.net.Socket [^java.net.ServerSocket this]
    (-> this (.accept))))

(defn get-reuse-address?
  "Tests if SO_REUSEADDR is enabled.

  returns: a boolean indicating whether or not
           SO_REUSEADDR is enabled. - `boolean`

  throws: java.net.SocketException - if there is an error in the underlying protocol, such as a TCP error."
  (^Boolean [^java.net.ServerSocket this]
    (-> this (.getReuseAddress))))

(defn get-local-socket-address
  "Returns the address of the endpoint this socket is bound to.

   If the socket was bound prior to being closed,
   then this method will continue to return the address of the endpoint
   after the socket is closed.

   If there is a security manager set, its checkConnect method is
   called with the local address and -1 as its arguments to see
   if the operation is allowed. If the operation is not allowed,
   a SocketAddress representing the
   loopback address and the local
   port to which the socket is bound is returned.

  returns: a SocketAddress representing the local endpoint of
           this socket, or a SocketAddress representing the
           loopback address if denied by the security manager,
           or null if the socket is not bound yet. - `java.net.SocketAddress`"
  (^java.net.SocketAddress [^java.net.ServerSocket this]
    (-> this (.getLocalSocketAddress))))

(defn close
  "Closes this socket.

   Any thread currently blocked in accept() will throw
   a SocketException.

    If this socket has an associated channel then the channel is closed
   as well.

  throws: java.io.IOException - if an I/O error occurs when closing the socket."
  ([^java.net.ServerSocket this]
    (-> this (.close))))

(defn get-receive-buffer-size
  "Gets the value of the SO_RCVBUF option
   for this ServerSocket, that is the proposed buffer size that
   will be used for Sockets accepted from this ServerSocket.

   Note, the value actually set in the accepted socket is determined by
   calling Socket.getReceiveBufferSize().

  returns: the value of the SO_RCVBUF
           option for this Socket. - `int`

  throws: java.net.SocketException - if there is an error in the underlying protocol, such as a TCP error."
  (^Integer [^java.net.ServerSocket this]
    (-> this (.getReceiveBufferSize))))

(defn set-receive-buffer-size
  "Sets a default proposed value for the
   SO_RCVBUF option for sockets
   accepted from this ServerSocket. The value actually set
   in the accepted socket must be determined by calling
   Socket.getReceiveBufferSize() after the socket
   is returned by accept().

   The value of SO_RCVBUF is used both to
   set the size of the internal socket receive buffer, and to set the size
   of the TCP receive window that is advertized to the remote peer.

   It is possible to change the value subsequently, by calling
   Socket.setReceiveBufferSize(int). However, if the application
   wishes to allow a receive window larger than 64K bytes, as defined by RFC1323
   then the proposed value must be set in the ServerSocket before
   it is bound to a local address. This implies, that the ServerSocket must be
   created with the no-argument constructor, then setReceiveBufferSize() must
   be called and lastly the ServerSocket is bound to an address by calling bind().

   Failure to do this will not cause an error, and the buffer size may be set to the
   requested value but the TCP receive window in sockets accepted from
   this ServerSocket will be no larger than 64K bytes.

  size - the size to which to set the receive buffer size. This value must be greater than 0. - `int`

  throws: java.net.SocketException - if there is an error in the underlying protocol, such as a TCP error."
  ([^java.net.ServerSocket this ^Integer size]
    (-> this (.setReceiveBufferSize size))))

(defn bound?
  "Returns the binding state of the ServerSocket.

  returns: true if the ServerSocket successfully bound to an address - `boolean`"
  (^Boolean [^java.net.ServerSocket this]
    (-> this (.isBound))))

(defn get-channel
  "Returns the unique ServerSocketChannel object
   associated with this socket, if any.

    A server socket will have a channel if, and only if, the channel
   itself was created via the ServerSocketChannel.open
   method.

  returns: the server-socket channel associated with this socket,
            or null if this socket was not created
            for a channel - `java.nio.channels.ServerSocketChannel`"
  (^java.nio.channels.ServerSocketChannel [^java.net.ServerSocket this]
    (-> this (.getChannel))))

(defn get-inet-address
  "Returns the local address of this server socket.

   If the socket was bound prior to being closed,
   then this method will continue to return the local address
   after the socket is closed.

   If there is a security manager set, its checkConnect method is
   called with the local address and -1 as its arguments to see
   if the operation is allowed. If the operation is not allowed,
   the loopback address is returned.

  returns: the address to which this socket is bound,
            or the loopback address if denied by the security manager,
            or null if the socket is unbound. - `java.net.InetAddress`"
  (^java.net.InetAddress [^java.net.ServerSocket this]
    (-> this (.getInetAddress))))

