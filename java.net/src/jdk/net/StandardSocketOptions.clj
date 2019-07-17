(ns jdk.net.StandardSocketOptions
  "Defines the standard socket options.

   The name of each socket option defined by this
  class is its field name.

   In this release, the socket options defined here are used by network channels in the channels package."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.net StandardSocketOptions]))

(def *-so-broadcast
  "Static Constant.

  Allow transmission of broadcast datagrams.

    The value of this socket option is a Boolean that represents
   whether the option is enabled or disabled. The option is specific to
   datagram-oriented sockets sending to IPv4
   broadcast addresses. When the socket option is enabled then the socket
   can be used to send broadcast datagrams.

    The initial value of this socket option is FALSE. The socket
   option may be enabled or disabled at any time. Some operating systems may
   require that the Java virtual machine be started with implementation
   specific privileges to enable this option or send broadcast datagrams.

  type: java.net.SocketOption<java.lang.Boolean>"
  StandardSocketOptions/SO_BROADCAST)

(def *-so-keepalive
  "Static Constant.

  Keep connection alive.

    The value of this socket option is a Boolean that represents
   whether the option is enabled or disabled. When the SO_KEEPALIVE
   option is enabled the operating system may use a keep-alive
   mechanism to periodically probe the other end of a connection when the
   connection is otherwise idle. The exact semantics of the keep alive
   mechanism is system dependent and therefore unspecified.

    The initial value of this socket option is FALSE. The socket
   option may be enabled or disabled at any time.

  type: java.net.SocketOption<java.lang.Boolean>"
  StandardSocketOptions/SO_KEEPALIVE)

(def *-so-sndbuf
  "Static Constant.

  The size of the socket send buffer.

    The value of this socket option is an Integer that is the
   size of the socket send buffer in bytes. The socket send buffer is an
   output buffer used by the networking implementation. It may need to be
   increased for high-volume connections. The value of the socket option is
   a hint to the implementation to size the buffer and the actual
   size may differ. The socket option can be queried to retrieve the actual
   size.

    For datagram-oriented sockets, the size of the send buffer may limit
   the size of the datagrams that may be sent by the socket. Whether
   datagrams larger than the buffer size are sent or discarded is system
   dependent.

    The initial/default size of the socket send buffer and the range of
   allowable values is system dependent although a negative size is not
   allowed. An attempt to set the socket send buffer to larger than its
   maximum size causes it to be set to its maximum size.

    An implementation allows this socket option to be set before the
   socket is bound or connected. Whether an implementation allows the
   socket send buffer to be changed after the socket is bound is system
   dependent.

  type: java.net.SocketOption<java.lang.Integer>"
  StandardSocketOptions/SO_SNDBUF)

(def *-so-rcvbuf
  "Static Constant.

  The size of the socket receive buffer.

    The value of this socket option is an Integer that is the
   size of the socket receive buffer in bytes. The socket receive buffer is
   an input buffer used by the networking implementation. It may need to be
   increased for high-volume connections or decreased to limit the possible
   backlog of incoming data. The value of the socket option is a
   hint to the implementation to size the buffer and the actual
   size may differ.

    For datagram-oriented sockets, the size of the receive buffer may
   limit the size of the datagrams that can be received. Whether datagrams
   larger than the buffer size can be received is system dependent.
   Increasing the socket receive buffer may be important for cases where
   datagrams arrive in bursts faster than they can be processed.

    In the case of stream-oriented sockets and the TCP/IP protocol, the
   size of the socket receive buffer may be used when advertising the size
   of the TCP receive window to the remote peer.

    The initial/default size of the socket receive buffer and the range
   of allowable values is system dependent although a negative size is not
   allowed. An attempt to set the socket receive buffer to larger than its
   maximum size causes it to be set to its maximum size.

    An implementation allows this socket option to be set before the
   socket is bound or connected. Whether an implementation allows the
   socket receive buffer to be changed after the socket is bound is system
   dependent.

  type: java.net.SocketOption<java.lang.Integer>"
  StandardSocketOptions/SO_RCVBUF)

(def *-so-reuseaddr
  "Static Constant.

  Re-use address.

    The value of this socket option is a Boolean that represents
   whether the option is enabled or disabled. The exact semantics of this
   socket option are socket type and system dependent.

    In the case of stream-oriented sockets, this socket option will
   usually determine whether the socket can be bound to a socket address
   when a previous connection involving that socket address is in the
   TIME_WAIT state. On implementations where the semantics differ,
   and the socket option is not required to be enabled in order to bind the
   socket when a previous connection is in this state, then the
   implementation may choose to ignore this option.

    For datagram-oriented sockets the socket option is used to allow
   multiple programs bind to the same address. This option should be enabled
   when the socket is to be used for Internet Protocol (IP) multicasting.

    An implementation allows this socket option to be set before the
   socket is bound or connected. Changing the value of this socket option
   after the socket is bound has no effect. The default value of this
   socket option is system dependent.

  type: java.net.SocketOption<java.lang.Boolean>"
  StandardSocketOptions/SO_REUSEADDR)

(def *-so-linger
  "Static Constant.

  Linger on close if data is present.

    The value of this socket option is an Integer that controls
   the action taken when unsent data is queued on the socket and a method
   to close the socket is invoked. If the value of the socket option is zero
   or greater, then it represents a timeout value, in seconds, known as the
   linger interval. The linger interval is the timeout for the
   close method to block while the operating system attempts to
   transmit the unsent data or it decides that it is unable to transmit the
   data. If the value of the socket option is less than zero then the option
   is disabled. In that case the close method does not wait until
   unsent data is transmitted; if possible the operating system will transmit
   any unsent data before the connection is closed.

    This socket option is intended for use with sockets that are configured
   in blocking mode
   only. The behavior of the close method when this option is
   enabled on a non-blocking socket is not defined.

    The initial value of this socket option is a negative value, meaning
   that the option is disabled. The option may be enabled, or the linger
   interval changed, at any time. The maximum value of the linger interval
   is system dependent. Setting the linger interval to a value that is
   greater than its maximum value causes the linger interval to be set to
   its maximum value.

  type: java.net.SocketOption<java.lang.Integer>"
  StandardSocketOptions/SO_LINGER)

(def *-ip-tos
  "Static Constant.

  The Type of Service (ToS) octet in the Internet Protocol (IP) header.

    The value of this socket option is an Integer representing
   the value of the ToS octet in IP packets sent by sockets to an IPv4 socket. The interpretation of the ToS
   octet is network specific and is not defined by this class. Further
   information on the ToS octet can be found in RFC 1349 and RFC 2474. The value
   of the socket option is a hint. An implementation may ignore the
   value, or ignore specific values.

    The initial/default value of the TOS field in the ToS octet is
   implementation specific but will typically be 0. For
   datagram-oriented sockets the option may be configured at any time after
   the socket has been bound. The new value of the octet is used when sending
   subsequent datagrams. It is system dependent whether this option can be
   queried or changed prior to binding the socket.

    The behavior of this socket option on a stream-oriented socket, or an
   IPv6 socket, is not defined in this
   release.

  type: java.net.SocketOption<java.lang.Integer>"
  StandardSocketOptions/IP_TOS)

(def *-ip-multicast-if
  "Static Constant.

  The network interface for Internet Protocol (IP) multicast datagrams.

    The value of this socket option is a NetworkInterface that
   represents the outgoing interface for multicast datagrams sent by the
   datagram-oriented socket. For IPv6
   sockets then it is system dependent whether setting this option also
   sets the outgoing interface for multicast datagrams sent to IPv4
   addresses.

    The initial/default value of this socket option may be null
   to indicate that outgoing interface will be selected by the operating
   system, typically based on the network routing tables. An implementation
   allows this socket option to be set after the socket is bound. Whether
   the socket option can be queried or changed prior to binding the socket
   is system dependent.

  type: java.net.SocketOption<java.net.NetworkInterface>"
  StandardSocketOptions/IP_MULTICAST_IF)

(def *-ip-multicast-ttl
  "Static Constant.

  The time-to-live for Internet Protocol (IP) multicast datagrams.

    The value of this socket option is an Integer in the range
   0 <= value <= 255. It is used to control the scope of multicast
   datagrams sent by the datagram-oriented socket.
   In the case of an IPv4 socket
   the option is the time-to-live (TTL) on multicast datagrams sent by the
   socket. Datagrams with a TTL of zero are not transmitted on the network
   but may be delivered locally. In the case of an IPv6 socket the option is the
   hop limit which is number of hops that the datagram can
   pass through before expiring on the network. For IPv6 sockets it is
   system dependent whether the option also sets the time-to-live
   on multicast datagrams sent to IPv4 addresses.

    The initial/default value of the time-to-live setting is typically
   1. An implementation allows this socket option to be set after
   the socket is bound. Whether the socket option can be queried or changed
   prior to binding the socket is system dependent.

  type: java.net.SocketOption<java.lang.Integer>"
  StandardSocketOptions/IP_MULTICAST_TTL)

(def *-ip-multicast-loop
  "Static Constant.

  Loopback for Internet Protocol (IP) multicast datagrams.

    The value of this socket option is a Boolean that controls
   the loopback of multicast datagrams. The value of the socket
   option represents if the option is enabled or disabled.

    The exact semantics of this socket options are system dependent.
   In particular, it is system dependent whether the loopback applies to
   multicast datagrams sent from the socket or received by the socket.
   For IPv6 sockets then it is
   system dependent whether the option also applies to multicast datagrams
   sent to IPv4 addresses.

    The initial/default value of this socket option is TRUE. An
   implementation allows this socket option to be set after the socket is
   bound. Whether the socket option can be queried or changed prior to
   binding the socket is system dependent.

  type: java.net.SocketOption<java.lang.Boolean>"
  StandardSocketOptions/IP_MULTICAST_LOOP)

(def *-tcp-nodelay
  "Static Constant.

  Disable the Nagle algorithm.

    The value of this socket option is a Boolean that represents
   whether the option is enabled or disabled. The socket option is specific to
   stream-oriented sockets using the TCP/IP protocol. TCP/IP uses an algorithm
   known as The Nagle Algorithm to coalesce short segments and
   improve network efficiency.

    The default value of this socket option is FALSE. The
   socket option should only be enabled in cases where it is known that the
   coalescing impacts performance. The socket option may be enabled at any
   time. In other words, the Nagle Algorithm can be disabled. Once the option
   is enabled, it is system dependent whether it can be subsequently
   disabled. If it cannot, then invoking the setOption method to
   disable the option has no effect.

  type: java.net.SocketOption<java.lang.Boolean>"
  StandardSocketOptions/TCP_NODELAY)

