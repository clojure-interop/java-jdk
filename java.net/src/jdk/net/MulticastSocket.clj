(ns jdk.net.MulticastSocket
  "The multicast datagram socket class is useful for sending
  and receiving IP multicast packets.  A MulticastSocket is
  a (UDP) DatagramSocket, with additional capabilities for
  joining `groups` of other multicast hosts on the internet.

  A multicast group is specified by a class D IP address
  and by a standard UDP port number. Class D IP addresses
  are in the range 224.0.0.0 to 239.255.255.255,
  inclusive. The address 224.0.0.0 is reserved and should not be used.

  One would join a multicast group by first creating a MulticastSocket
  with the desired port, then invoking the
  joinGroup(InetAddress groupAddr)
  method:


  // join a Multicast group and send the group salutations
  ...
  String msg = `Hello`;
  InetAddress group = InetAddress.getByName(`228.5.6.7`);
  MulticastSocket s = new MulticastSocket(6789);
  s.joinGroup(group);
  DatagramPacket hi = new DatagramPacket(msg.getBytes(), msg.length(),
                              group, 6789);
  s.send(hi);
  // get their responses!
  byte[] buf = new byte[1000];
  DatagramPacket recv = new DatagramPacket(buf, buf.length);
  s.receive(recv);
  ...
  // OK, I'm done talking - leave the group...
  s.leaveGroup(group);

  When one sends a message to a multicast group, all subscribing
  recipients to that host and port receive the message (within the
  time-to-live range of the packet, see below).  The socket needn't
  be a member of the multicast group to send messages to it.

  When a socket subscribes to a multicast group/port, it receives
  datagrams sent by other hosts to the group/port, as do all other
  members of the group and port.  A socket relinquishes membership
  in a group by the leaveGroup(InetAddress addr) method.
  Multiple MulticastSocket's may subscribe to a multicast group
  and port concurrently, and they will all receive group datagrams.

  Currently applets are not allowed to use multicast sockets."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.net MulticastSocket]))

(defn ->multicast-socket
  "Constructor.

  Create a multicast socket and bind it to a specific port.

   If there is a security manager,
   its checkListen method is first called
   with the port argument
   as its argument to ensure the operation is allowed.
   This could result in a SecurityException.

   When the socket is created the
   DatagramSocket.setReuseAddress(boolean) method is
   called to enable the SO_REUSEADDR socket option.

  port - port to use - `int`

  throws: java.io.IOException - if an I/O exception occurs while creating the MulticastSocket"
  ([port]
    (new MulticastSocket port))
  ([]
    (new MulticastSocket )))

(defn set-time-to-live
  "Set the default time-to-live for multicast packets sent out
   on this MulticastSocket in order to control the
   scope of the multicasts.

    The ttl must be in the range 0 <= ttl <=
   255 or an IllegalArgumentException will be thrown.
   Multicast packets sent with a TTL of 0 are not transmitted
   on the network but may be delivered locally.

  ttl - the time-to-live - `int`

  throws: java.io.IOException - if an I/O exception occurs while setting the default time-to-live value"
  ([this ttl]
    (-> this (.setTimeToLive ttl))))

(defn get-interface
  "Retrieve the address of the network interface used for
   multicast packets.

  returns: An InetAddress representing
    the address of the network interface used for
    multicast packets. - `java.net.InetAddress`

  throws: java.net.SocketException - if there is an error in the underlying protocol, such as a TCP error."
  ([this]
    (-> this (.getInterface))))

(defn get-network-interface
  "Get the multicast network interface set.

  returns: the multicast NetworkInterface currently set - `java.net.NetworkInterface`

  throws: java.net.SocketException - if there is an error in the underlying protocol, such as a TCP error."
  ([this]
    (-> this (.getNetworkInterface))))

(defn send
  "Deprecated. Use the following code or its equivalent instead:
    ......
    int ttl = mcastSocket.getTimeToLive();
    mcastSocket.setTimeToLive(newttl);
    mcastSocket.send(p);
    mcastSocket.setTimeToLive(ttl);
    ......

  p - is the packet to be sent. The packet should contain the destination multicast ip address and the data to be sent. One does not need to be the member of the group to send packets to a destination multicast address. - `java.net.DatagramPacket`
  ttl - optional time to live for multicast packet. default ttl is 1. - `byte`

  returns: `java.lang.  void`

  throws: java.io.IOException - is raised if an error occurs i.e error while setting ttl."
  ([this p ttl]
    (-> this (.send p ttl))))

(defn set-network-interface
  "Specify the network interface for outgoing multicast datagrams
   sent on this socket.

  net-if - the interface - `java.net.NetworkInterface`

  throws: java.net.SocketException - if there is an error in the underlying protocol, such as a TCP error."
  ([this net-if]
    (-> this (.setNetworkInterface net-if))))

(defn get-time-to-live
  "Get the default time-to-live for multicast packets sent out on
   the socket.

  returns: the default time-to-live value - `int`

  throws: java.io.IOException - if an I/O exception occurs while getting the default time-to-live value"
  ([this]
    (-> this (.getTimeToLive))))

(defn set-interface
  "Set the multicast network interface used by methods
   whose behavior would be affected by the value of the
   network interface. Useful for multihomed hosts.

  inf - the InetAddress - `java.net.InetAddress`

  throws: java.net.SocketException - if there is an error in the underlying protocol, such as a TCP error."
  ([this inf]
    (-> this (.setInterface inf))))

(defn set-ttl
  "Deprecated. use the setTimeToLive method instead, which uses
   int instead of byte as the type for ttl.

  ttl - the time-to-live - `byte`

  returns: `java.lang.  void`

  throws: java.io.IOException - if an I/O exception occurs while setting the default time-to-live value"
  ([this ttl]
    (-> this (.setTTL ttl))))

(defn set-loopback-mode
  "Disable/Enable local loopback of multicast datagrams
   The option is used by the platform's networking code as a hint
   for setting whether multicast data will be looped back to
   the local socket.

   Because this option is a hint, applications that want to
   verify what loopback mode is set to should call
   getLoopbackMode()

  disable - true to disable the LoopbackMode - `boolean`

  throws: java.net.SocketException - if an error occurs while setting the value"
  ([this disable]
    (-> this (.setLoopbackMode disable))))

(defn join-group
  "Joins the specified multicast group at the specified interface.

   If there is a security manager, this method first
   calls its checkMulticast method
   with the mcastaddr argument
   as its argument.

  mcastaddr - is the multicast address to join - `java.net.SocketAddress`
  net-if - specifies the local interface to receive multicast datagram packets, or null to defer to the interface set by setInterface(InetAddress) or setNetworkInterface(NetworkInterface) - `java.net.NetworkInterface`

  throws: java.io.IOException - if there is an error joining or when the address is not a multicast address."
  ([this mcastaddr net-if]
    (-> this (.joinGroup mcastaddr net-if)))
  ([this mcastaddr]
    (-> this (.joinGroup mcastaddr))))

(defn get-ttl
  "Deprecated. use the getTimeToLive method instead, which returns
   an int instead of a byte.

  returns: the default time-to-live value - `java.lang.  byte`

  throws: java.io.IOException - if an I/O exception occurs while getting the default time-to-live value"
  ([this]
    (-> this (.getTTL))))

(defn leave-group
  "Leave a multicast group on a specified local interface.

   If there is a security manager, this method first
   calls its checkMulticast method
   with the mcastaddr argument
   as its argument.

  mcastaddr - is the multicast address to leave - `java.net.SocketAddress`
  net-if - specifies the local interface or null to defer to the interface set by setInterface(InetAddress) or setNetworkInterface(NetworkInterface) - `java.net.NetworkInterface`

  throws: java.io.IOException - if there is an error leaving or when the address is not a multicast address."
  ([this mcastaddr net-if]
    (-> this (.leaveGroup mcastaddr net-if)))
  ([this mcastaddr]
    (-> this (.leaveGroup mcastaddr))))

(defn get-loopback-mode?
  "Get the setting for local loopback of multicast datagrams.

  returns: true if the LoopbackMode has been disabled - `boolean`

  throws: java.net.SocketException - if an error occurs while getting the value"
  ([this]
    (-> this (.getLoopbackMode))))

