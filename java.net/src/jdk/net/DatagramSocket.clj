(ns jdk.net.DatagramSocket
  "This class represents a socket for sending and receiving datagram packets.

  A datagram socket is the sending or receiving point for a packet
  delivery service. Each packet sent or received on a datagram socket
  is individually addressed and routed. Multiple packets sent from
  one machine to another may be routed differently, and may arrive in
  any order.

   Where possible, a newly constructed DatagramSocket has the
  SO_BROADCAST socket option enabled so as
  to allow the transmission of broadcast datagrams. In order to receive
  broadcast packets a DatagramSocket should be bound to the wildcard address.
  In some implementations, broadcast packets may also be received when
  a DatagramSocket is bound to a more specific address.

  Example:
  DatagramSocket s = new DatagramSocket(null);
               s.bind(new InetSocketAddress(8888));

  Which is equivalent to:
  DatagramSocket s = new DatagramSocket(8888);

  Both cases will create a DatagramSocket able to receive broadcasts on
  UDP port 8888."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.net DatagramSocket]))

(defn ->datagram-socket
  "Constructor.

  Creates a datagram socket, bound to the specified local
   address.  The local port must be between 0 and 65535 inclusive.
   If the IP address is 0.0.0.0, the socket will be bound to the
   wildcard address,
   an IP address chosen by the kernel.

   If there is a security manager,
   its checkListen method is first called
   with the port argument
   as its argument to ensure the operation is allowed.
   This could result in a SecurityException.

  port - local port to use - `int`
  laddr - local address to bind - `java.net.InetAddress`

  throws: java.net.SocketException - if the socket could not be opened, or the socket could not bind to the specified local port."
  ([^Integer port ^java.net.InetAddress laddr]
    (new DatagramSocket port laddr))
  ([^java.net.SocketAddress bindaddr]
    (new DatagramSocket bindaddr))
  ([]
    (new DatagramSocket )))

(defn *set-datagram-socket-impl-factory
  "Sets the datagram socket implementation factory for the
   application. The factory can be specified only once.

   When an application creates a new datagram socket, the socket
   implementation factory's createDatagramSocketImpl method is
   called to create the actual datagram socket implementation.

   Passing null to the method is a no-op unless the factory
   was already set.

   If there is a security manager, this method first calls
   the security manager's checkSetFactory method
   to ensure the operation is allowed.
   This could result in a SecurityException.

  fac - the desired factory. - `java.net.DatagramSocketImplFactory`

  throws: java.io.IOException - if an I/O error occurs when setting the datagram socket factory."
  ([^java.net.DatagramSocketImplFactory fac]
    (DatagramSocket/setDatagramSocketImplFactory fac)))

(defn set-traffic-class
  "Sets traffic class or type-of-service octet in the IP
   datagram header for datagrams sent from this DatagramSocket.
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

   for Internet Protocol v6 tc is the value that
   would be placed into the sin6_flowinfo field of the IP header.

  tc - an int value for the bitset. - `int`

  throws: java.net.SocketException - if there is an error setting the traffic class or type-of-service"
  ([^java.net.DatagramSocket this ^Integer tc]
    (-> this (.setTrafficClass tc))))

(defn get-send-buffer-size
  "Get value of the SO_SNDBUF option for this DatagramSocket, that is the
   buffer size used by the platform for output on this DatagramSocket.

  returns: the value of the SO_SNDBUF option for this DatagramSocket - `int`

  throws: java.net.SocketException - if there is an error in the underlying protocol, such as an UDP error."
  ([^java.net.DatagramSocket this]
    (-> this (.getSendBufferSize))))

(defn get-local-port
  "Returns the port number on the local host to which this socket
   is bound.

  returns: the port number on the local host to which this socket is bound,
                  -1 if the socket is closed, or
                  0 if it is not bound yet. - `int`"
  ([^java.net.DatagramSocket this]
    (-> this (.getLocalPort))))

(defn set-so-timeout
  "Enable/disable SO_TIMEOUT with the specified timeout, in
    milliseconds. With this option set to a non-zero timeout,
    a call to receive() for this DatagramSocket
    will block for only this amount of time.  If the timeout expires,
    a java.net.SocketTimeoutException is raised, though the
    DatagramSocket is still valid.  The option must be enabled
    prior to entering the blocking operation to have effect.  The
    timeout must be > 0.
    A timeout of zero is interpreted as an infinite timeout.

  timeout - the specified timeout in milliseconds. - `int`

  throws: java.net.SocketException - if there is an error in the underlying protocol, such as an UDP error."
  ([^java.net.DatagramSocket this ^Integer timeout]
    (-> this (.setSoTimeout timeout))))

(defn disconnect
  "Disconnects the socket. If the socket is closed or not connected,
   then this method has no effect."
  ([^java.net.DatagramSocket this]
    (-> this (.disconnect))))

(defn send
  "Sends a datagram packet from this socket. The
   DatagramPacket includes information indicating the
   data to be sent, its length, the IP address of the remote host,
   and the port number on the remote host.

   If there is a security manager, and the socket is not currently
   connected to a remote address, this method first performs some
   security checks. First, if p.getAddress().isMulticastAddress()
   is true, this method calls the
   security manager's checkMulticast method
   with p.getAddress() as its argument.
   If the evaluation of that expression is false,
   this method instead calls the security manager's
   checkConnect method with arguments
   p.getAddress().getHostAddress() and
   p.getPort(). Each call to a security manager method
   could result in a SecurityException if the operation is not allowed.

  p - the DatagramPacket to be sent. - `java.net.DatagramPacket`

  throws: java.io.IOException - if an I/O error occurs."
  ([^java.net.DatagramSocket this ^java.net.DatagramPacket p]
    (-> this (.send p))))

(defn bind
  "Binds this DatagramSocket to a specific address and port.

   If the address is null, then the system will pick up
   an ephemeral port and a valid local address to bind the socket.

  addr - The address and port to bind to. - `java.net.SocketAddress`

  throws: java.net.SocketException - if any error happens during the bind, or if the socket is already bound."
  ([^java.net.DatagramSocket this ^java.net.SocketAddress addr]
    (-> this (.bind addr))))

(defn set-reuse-address
  "Enable/disable the SO_REUSEADDR socket option.

   For UDP sockets it may be necessary to bind more than one
   socket to the same socket address. This is typically for the
   purpose of receiving multicast packets
   (See MulticastSocket). The
   SO_REUSEADDR socket option allows multiple
   sockets to be bound to the same socket address if the
   SO_REUSEADDR socket option is enabled prior
   to binding the socket using bind(SocketAddress).

   Note: This functionality is not supported by all existing platforms,
   so it is implementation specific whether this option will be ignored
   or not. However, if it is not supported then
   getReuseAddress() will always return false.

   When a DatagramSocket is created the initial setting
   of SO_REUSEADDR is disabled.

   The behaviour when SO_REUSEADDR is enabled or
   disabled after a socket is bound (See isBound())
   is not defined.

  on - whether to enable or disable the - `boolean`

  throws: java.net.SocketException - if an error occurs enabling or disabling the SO_RESUEADDR socket option, or the socket is closed."
  ([^java.net.DatagramSocket this ^Boolean on]
    (-> this (.setReuseAddress on))))

(defn connected?
  "Returns the connection state of the socket.

   If the socket was connected prior to being closed,
   then this method will continue to return true
   after the socket is closed.

  returns: true if the socket successfully connected to a server - `boolean`"
  ([^java.net.DatagramSocket this]
    (-> this (.isConnected))))

(defn get-so-timeout
  "Retrieve setting for SO_TIMEOUT.  0 returns implies that the
   option is disabled (i.e., timeout of infinity).

  returns: the setting for SO_TIMEOUT - `int`

  throws: java.net.SocketException - if there is an error in the underlying protocol, such as an UDP error."
  ([^java.net.DatagramSocket this]
    (-> this (.getSoTimeout))))

(defn get-remote-socket-address
  "Returns the address of the endpoint this socket is connected to, or
   null if it is unconnected.

   If the socket was connected prior to being closed,
   then this method will continue to return the connected address
   after the socket is closed.

  returns: a SocketAddress representing the remote
           endpoint of this socket, or null if it is
           not connected yet. - `java.net.SocketAddress`"
  ([^java.net.DatagramSocket this]
    (-> this (.getRemoteSocketAddress))))

(defn connect
  "Connects the socket to a remote address for this socket. When a
   socket is connected to a remote address, packets may only be
   sent to or received from that address. By default a datagram
   socket is not connected.

   If the remote destination to which the socket is connected does not
   exist, or is otherwise unreachable, and if an ICMP destination unreachable
   packet has been received for that address, then a subsequent call to
   send or receive may throw a PortUnreachableException. Note, there is no
   guarantee that the exception will be thrown.

    If a security manager has been installed then it is invoked to check
   access to the remote address. Specifically, if the given address
   is a multicast address,
   the security manager's checkMulticast method is invoked with the given address.
   Otherwise, the security manager's checkConnect
   and checkAccept methods
   are invoked, with the given address and port, to
   verify that datagrams are permitted to be sent and received
   respectively.

    When a socket is connected, receive and
   send will not perform any security checks
   on incoming and outgoing packets, other than matching the packet's
   and the socket's address and port. On a send operation, if the
   packet's address is set and the packet's address and the socket's
   address do not match, an IllegalArgumentException will be
   thrown. A socket connected to a multicast address may only be used
   to send packets.

  address - the remote address for the socket - `java.net.InetAddress`
  port - the remote port for the socket. - `int`

  throws: java.lang.IllegalArgumentException - if the address is null, or the port is out of range."
  ([^java.net.DatagramSocket this ^java.net.InetAddress address ^Integer port]
    (-> this (.connect address port)))
  ([^java.net.DatagramSocket this ^java.net.SocketAddress addr]
    (-> this (.connect addr))))

(defn closed?
  "Returns whether the socket is closed or not.

  returns: true if the socket has been closed - `boolean`"
  ([^java.net.DatagramSocket this]
    (-> this (.isClosed))))

(defn get-reuse-address?
  "Tests if SO_REUSEADDR is enabled.

  returns: a boolean indicating whether or not SO_REUSEADDR is enabled. - `boolean`

  throws: java.net.SocketException - if there is an error in the underlying protocol, such as an UDP error."
  ([^java.net.DatagramSocket this]
    (-> this (.getReuseAddress))))

(defn set-send-buffer-size
  "Sets the SO_SNDBUF option to the specified value for this
   DatagramSocket. The SO_SNDBUF option is used by the
   network implementation as a hint to size the underlying
   network I/O buffers. The SO_SNDBUF setting may also be used
   by the network implementation to determine the maximum size
   of the packet that can be sent on this socket.

   As SO_SNDBUF is a hint, applications that want to verify
   what size the buffer is should call getSendBufferSize().

   Increasing the buffer size may allow multiple outgoing packets
   to be queued by the network implementation when the send rate
   is high.

   Note: If send(DatagramPacket) is used to send a
   DatagramPacket that is larger than the setting
   of SO_SNDBUF then it is implementation specific if the
   packet is sent or discarded.

  size - the size to which to set the send buffer size. This value must be greater than 0. - `int`

  throws: java.net.SocketException - if there is an error in the underlying protocol, such as an UDP error."
  ([^java.net.DatagramSocket this ^Integer size]
    (-> this (.setSendBufferSize size))))

(defn get-local-socket-address
  "Returns the address of the endpoint this socket is bound to.

  returns: a SocketAddress representing the local endpoint of this
           socket, or null if it is closed or not bound yet. - `java.net.SocketAddress`"
  ([^java.net.DatagramSocket this]
    (-> this (.getLocalSocketAddress))))

(defn get-local-address
  "Gets the local address to which the socket is bound.

   If there is a security manager, its
   checkConnect method is first called
   with the host address and -1
   as its arguments to see if the operation is allowed.

  returns: the local address to which the socket is bound,
            null if the socket is closed, or
            an InetAddress representing
            wildcard
            address if either the socket is not bound, or
            the security manager checkConnect
            method does not allow the operation - `java.net.InetAddress`"
  ([^java.net.DatagramSocket this]
    (-> this (.getLocalAddress))))

(defn close
  "Closes this datagram socket.

   Any thread currently blocked in receive(java.net.DatagramPacket) upon this socket
   will throw a SocketException.

    If this socket has an associated channel then the channel is closed
   as well."
  ([^java.net.DatagramSocket this]
    (-> this (.close))))

(defn get-broadcast?
  "Tests if SO_BROADCAST is enabled.

  returns: a boolean indicating whether or not SO_BROADCAST is enabled. - `boolean`

  throws: java.net.SocketException - if there is an error in the underlying protocol, such as an UDP error."
  ([^java.net.DatagramSocket this]
    (-> this (.getBroadcast))))

(defn get-receive-buffer-size
  "Get value of the SO_RCVBUF option for this DatagramSocket, that is the
   buffer size used by the platform for input on this DatagramSocket.

  returns: the value of the SO_RCVBUF option for this DatagramSocket - `int`

  throws: java.net.SocketException - if there is an error in the underlying protocol, such as an UDP error."
  ([^java.net.DatagramSocket this]
    (-> this (.getReceiveBufferSize))))

(defn get-traffic-class
  "Gets traffic class or type-of-service in the IP datagram
   header for packets sent from this DatagramSocket.

   As the underlying network implementation may ignore the
   traffic class or type-of-service set using setTrafficClass(int)
   this method may return a different value than was previously
   set using the setTrafficClass(int) method on this
   DatagramSocket.

  returns: the traffic class or type-of-service already set - `int`

  throws: java.net.SocketException - if there is an error obtaining the traffic class or type-of-service value."
  ([^java.net.DatagramSocket this]
    (-> this (.getTrafficClass))))

(defn set-receive-buffer-size
  "Sets the SO_RCVBUF option to the specified value for this
   DatagramSocket. The SO_RCVBUF option is used by the
   the network implementation as a hint to size the underlying
   network I/O buffers. The SO_RCVBUF setting may also be used
   by the network implementation to determine the maximum size
   of the packet that can be received on this socket.

   Because SO_RCVBUF is a hint, applications that want to
   verify what size the buffers were set to should call
   getReceiveBufferSize().

   Increasing SO_RCVBUF may allow the network implementation
   to buffer multiple packets when packets arrive faster than
   are being received using receive(DatagramPacket).

   Note: It is implementation specific if a packet larger
   than SO_RCVBUF can be received.

  size - the size to which to set the receive buffer size. This value must be greater than 0. - `int`

  throws: java.net.SocketException - if there is an error in the underlying protocol, such as an UDP error."
  ([^java.net.DatagramSocket this ^Integer size]
    (-> this (.setReceiveBufferSize size))))

(defn get-port
  "Returns the port number to which this socket is connected.
   Returns -1 if the socket is not connected.

   If the socket was connected prior to being closed,
   then this method will continue to return the connected port number
   after the socket is closed.

  returns: the port number to which this socket is connected. - `int`"
  ([^java.net.DatagramSocket this]
    (-> this (.getPort))))

(defn bound?
  "Returns the binding state of the socket.

   If the socket was bound prior to being closed,
   then this method will continue to return true
   after the socket is closed.

  returns: true if the socket successfully bound to an address - `boolean`"
  ([^java.net.DatagramSocket this]
    (-> this (.isBound))))

(defn set-broadcast
  "Enable/disable SO_BROADCAST.

    Some operating systems may require that the Java virtual machine be
   started with implementation specific privileges to enable this option or
   send broadcast datagrams.

  on - whether or not to have broadcast turned on. - `boolean`

  throws: java.net.SocketException - if there is an error in the underlying protocol, such as an UDP error."
  ([^java.net.DatagramSocket this ^Boolean on]
    (-> this (.setBroadcast on))))

(defn get-channel
  "Returns the unique DatagramChannel object
   associated with this datagram socket, if any.

    A datagram socket will have a channel if, and only if, the channel
   itself was created via the DatagramChannel.open method.

  returns: the datagram channel associated with this datagram socket,
            or null if this socket was not created for a channel - `java.nio.channels.DatagramChannel`"
  ([^java.net.DatagramSocket this]
    (-> this (.getChannel))))

(defn receive
  "Receives a datagram packet from this socket. When this method
   returns, the DatagramPacket's buffer is filled with
   the data received. The datagram packet also contains the sender's
   IP address, and the port number on the sender's machine.

   This method blocks until a datagram is received. The
   length field of the datagram packet object contains
   the length of the received message. If the message is longer than
   the packet's length, the message is truncated.

   If there is a security manager, a packet cannot be received if the
   security manager's checkAccept method
   does not allow it.

  p - the DatagramPacket into which to place the incoming data. - `java.net.DatagramPacket`

  throws: java.io.IOException - if an I/O error occurs."
  ([^java.net.DatagramSocket this ^java.net.DatagramPacket p]
    (-> this (.receive p))))

(defn get-inet-address
  "Returns the address to which this socket is connected. Returns
   null if the socket is not connected.

   If the socket was connected prior to being closed,
   then this method will continue to return the connected address
   after the socket is closed.

  returns: the address to which this socket is connected. - `java.net.InetAddress`"
  ([^java.net.DatagramSocket this]
    (-> this (.getInetAddress))))

