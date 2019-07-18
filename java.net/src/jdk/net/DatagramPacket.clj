(ns jdk.net.DatagramPacket
  "This class represents a datagram packet.

  Datagram packets are used to implement a connectionless packet
  delivery service. Each message is routed from one machine to
  another based solely on information contained within that packet.
  Multiple packets sent from one machine to another might be routed
  differently, and might arrive in any order. Packet delivery is
  not guaranteed."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.net DatagramPacket]))

(defn ->datagram-packet
  "Constructor.

  Constructs a datagram packet for sending packets of length
   length with offset ioffsetto the
   specified port number on the specified host. The
   length argument must be less than or equal to
   buf.length.

  buf - the packet data. - `byte[]`
  offset - the packet data offset. - `int`
  length - the packet data length. - `int`
  address - the destination address. - `java.net.InetAddress`
  port - the destination port number. - `int`"
  (^DatagramPacket [buf ^Integer offset ^Integer length ^java.net.InetAddress address ^Integer port]
    (new DatagramPacket buf offset length address port))
  (^DatagramPacket [buf ^Integer offset ^Integer length ^java.net.SocketAddress address]
    (new DatagramPacket buf offset length address))
  (^DatagramPacket [buf ^Integer offset ^Integer length]
    (new DatagramPacket buf offset length))
  (^DatagramPacket [buf ^Integer length]
    (new DatagramPacket buf length)))

(defn set-data
  "Set the data buffer for this packet. This sets the
   data, length and offset of the packet.

  buf - the buffer to set for this packet - `byte[]`
  offset - the offset into the data - `int`
  length - the length of the data and/or the length of the buffer used to receive data - `int`

  throws: java.lang.NullPointerException - if the argument is null"
  ([^DatagramPacket this buf ^Integer offset ^Integer length]
    (-> this (.setData buf offset length)))
  ([^DatagramPacket this buf]
    (-> this (.setData buf))))

(defn get-data
  "Returns the data buffer. The data received or the data to be sent
   starts from the offset in the buffer,
   and runs for length long.

  returns: the buffer used to receive or  send data - `byte[]`"
  ([^DatagramPacket this]
    (-> this (.getData))))

(defn set-socket-address
  "Sets the SocketAddress (usually IP address  port number) of the remote
   host to which this datagram is being sent.

  address - the SocketAddress - `java.net.SocketAddress`

  throws: java.lang.IllegalArgumentException - if address is null or is a SocketAddress subclass not supported by this socket"
  ([^DatagramPacket this ^java.net.SocketAddress address]
    (-> this (.setSocketAddress address))))

(defn get-address
  "Returns the IP address of the machine to which this datagram is being
   sent or from which the datagram was received.

  returns: the IP address of the machine to which this datagram is being
            sent or from which the datagram was received. - `java.net.InetAddress`"
  (^java.net.InetAddress [^DatagramPacket this]
    (-> this (.getAddress))))

(defn set-length
  "Set the length for this packet. The length of the packet is
   the number of bytes from the packet's data buffer that will be
   sent, or the number of bytes of the packet's data buffer that
   will be used for receiving data. The length must be lesser or
   equal to the offset plus the length of the packet's buffer.

  length - the length to set for this packet. - `int`

  throws: java.lang.IllegalArgumentException - if the length is negative of if the length is greater than the packet's data buffer length."
  ([^DatagramPacket this ^Integer length]
    (-> this (.setLength length))))

(defn set-address
  "Sets the IP address of the machine to which this datagram
   is being sent.

  iaddr - the InetAddress - `java.net.InetAddress`"
  ([^DatagramPacket this ^java.net.InetAddress iaddr]
    (-> this (.setAddress iaddr))))

(defn get-offset
  "Returns the offset of the data to be sent or the offset of the
   data received.

  returns: the offset of the data to be sent or the offset of the
            data received. - `int`"
  (^Integer [^DatagramPacket this]
    (-> this (.getOffset))))

(defn get-socket-address
  "Gets the SocketAddress (usually IP address  port number) of the remote
   host that this packet is being sent to or is coming from.

  returns: the SocketAddress - `java.net.SocketAddress`"
  (^java.net.SocketAddress [^DatagramPacket this]
    (-> this (.getSocketAddress))))

(defn set-port
  "Sets the port number on the remote host to which this datagram
   is being sent.

  iport - the port number - `int`"
  ([^DatagramPacket this ^Integer iport]
    (-> this (.setPort iport))))

(defn get-length
  "Returns the length of the data to be sent or the length of the
   data received.

  returns: the length of the data to be sent or the length of the
            data received. - `int`"
  (^Integer [^DatagramPacket this]
    (-> this (.getLength))))

(defn get-port
  "Returns the port number on the remote host to which this datagram is
   being sent or from which the datagram was received.

  returns: the port number on the remote host to which this datagram is
            being sent or from which the datagram was received. - `int`"
  (^Integer [^DatagramPacket this]
    (-> this (.getPort))))

