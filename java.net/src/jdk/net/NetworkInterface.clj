(ns jdk.net.NetworkInterface
  "This class represents a Network Interface made up of a name,
  and a list of IP addresses assigned to this interface.
  It is used to identify the local interface on which a multicast group
  is joined.

  Interfaces are normally known by names such as `le0`."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.net NetworkInterface]))

(defn *get-by-name
  "Searches for the network interface with the specified name.

  name - The name of the network interface. - `java.lang.String`

  returns: A NetworkInterface with the specified name,
            or null if there is no network interface
            with the specified name. - `java.net.NetworkInterface`

  throws: java.net.SocketException - If an I/O error occurs."
  (^java.net.NetworkInterface [^java.lang.String name]
    (NetworkInterface/getByName name)))

(defn *get-by-index
  "Get a network interface given its index.

  index - an integer, the index of the interface - `int`

  returns: the NetworkInterface obtained from its index, or null if
           there is no interface with such an index on the system - `java.net.NetworkInterface`

  throws: java.net.SocketException - if an I/O error occurs."
  (^java.net.NetworkInterface [^Integer index]
    (NetworkInterface/getByIndex index)))

(defn *get-by-inet-address
  "Convenience method to search for a network interface that
   has the specified Internet Protocol (IP) address bound to
   it.

   If the specified IP address is bound to multiple network
   interfaces it is not defined which network interface is
   returned.

  addr - The InetAddress to search with. - `java.net.InetAddress`

  returns: A NetworkInterface
            or null if there is no network interface
            with the specified IP address. - `java.net.NetworkInterface`

  throws: java.net.SocketException - If an I/O error occurs."
  (^java.net.NetworkInterface [^java.net.InetAddress addr]
    (NetworkInterface/getByInetAddress addr)))

(defn *get-network-interfaces
  "Returns all the interfaces on this machine. The Enumeration
   contains at least one element, possibly representing a loopback
   interface that only supports communication between entities on
   this machine.

   NOTE: can use getNetworkInterfaces()+getInetAddresses()
         to obtain all IP addresses for this node

  returns: an Enumeration of NetworkInterfaces found on this machine - `java.util.Enumeration<java.net.NetworkInterface>`

  throws: java.net.SocketException - if an I/O error occurs."
  (^java.util.Enumeration []
    (NetworkInterface/getNetworkInterfaces )))

(defn get-hardware-address
  "Returns the hardware address (usually MAC) of the interface if it
   has one and if it can be accessed given the current privileges.
   If a security manager is set, then the caller must have
   the permission NetPermission(`getNetworkInformation`).

  returns: a byte array containing the address, or null if
            the address doesn't exist, is not accessible or a security
            manager is set and the caller does not have the permission
            NetPermission(`getNetworkInformation`) - `byte[]`

  throws: java.net.SocketException - if an I/O error occurs."
  ([^java.net.NetworkInterface this]
    (-> this (.getHardwareAddress))))

(defn virtual?
  "Returns whether this interface is a virtual interface (also called
   subinterface).
   Virtual interfaces are, on some systems, interfaces created as a child
   of a physical interface and given different settings (like address or
   MTU). Usually the name of the interface will the name of the parent
   followed by a colon (:) and a number identifying the child since there
   can be several virtual interfaces attached to a single physical
   interface.

  returns: true if this interface is a virtual interface. - `boolean`"
  (^Boolean [^java.net.NetworkInterface this]
    (-> this (.isVirtual))))

(defn get-index
  "Returns the index of this network interface. The index is an integer greater
   or equal to zero, or -1 for unknown. This is a system specific value
   and interfaces with the same name can have different indexes on different
   machines.

  returns: the index of this network interface or -1 if the index is
           unknown - `int`"
  (^Integer [^java.net.NetworkInterface this]
    (-> this (.getIndex))))

(defn get-mtu
  "Returns the Maximum Transmission Unit (MTU) of this interface.

  returns: the value of the MTU for that interface. - `int`

  throws: java.net.SocketException - if an I/O error occurs."
  (^Integer [^java.net.NetworkInterface this]
    (-> this (.getMTU))))

(defn to-string
  "Description copied from class: Object

  returns: a string representation of the object. - `java.lang.String`"
  (^java.lang.String [^java.net.NetworkInterface this]
    (-> this (.toString))))

(defn get-display-name
  "Get the display name of this network interface.
   A display name is a human readable String describing the network
   device.

  returns: a non-empty string representing the display name of this network
           interface, or null if no display name is available. - `java.lang.String`"
  (^java.lang.String [^java.net.NetworkInterface this]
    (-> this (.getDisplayName))))

(defn get-sub-interfaces
  "Get an Enumeration with all the subinterfaces (also known as virtual
   interfaces) attached to this network interface.

   For instance eth0:1 will be a subinterface to eth0.

  returns: an Enumeration object with all of the subinterfaces
   of this network interface - `java.util.Enumeration<java.net.NetworkInterface>`"
  (^java.util.Enumeration [^java.net.NetworkInterface this]
    (-> this (.getSubInterfaces))))

(defn get-inet-addresses
  "Convenience method to return an Enumeration with all or a
   subset of the InetAddresses bound to this network interface.

   If there is a security manager, its checkConnect
   method is called for each InetAddress. Only InetAddresses where
   the checkConnect doesn't throw a SecurityException
   will be returned in the Enumeration. However, if the caller has the
   NetPermission(`getNetworkInformation`) permission, then all
   InetAddresses are returned.

  returns: an Enumeration object with all or a subset of the InetAddresses
   bound to this network interface - `java.util.Enumeration<java.net.InetAddress>`"
  (^java.util.Enumeration [^java.net.NetworkInterface this]
    (-> this (.getInetAddresses))))

(defn get-name
  "Get the name of this network interface.

  returns: the name of this network interface - `java.lang.String`"
  (^java.lang.String [^java.net.NetworkInterface this]
    (-> this (.getName))))

(defn get-parent
  "Returns the parent NetworkInterface of this interface if this is
   a subinterface, or null if it is a physical
   (non virtual) interface or has no parent.

  returns: The NetworkInterface this interface is attached to. - `java.net.NetworkInterface`"
  (^java.net.NetworkInterface [^java.net.NetworkInterface this]
    (-> this (.getParent))))

(defn supports-multicast
  "Returns whether a network interface supports multicasting or not.

  returns: true if the interface supports Multicasting. - `boolean`

  throws: java.net.SocketException - if an I/O error occurs."
  (^Boolean [^java.net.NetworkInterface this]
    (-> this (.supportsMulticast))))

(defn get-interface-addresses
  "Get a List of all or a subset of the InterfaceAddresses
   of this network interface.

   If there is a security manager, its checkConnect
   method is called with the InetAddress for each InterfaceAddress.
   Only InterfaceAddresses where the checkConnect doesn't throw
   a SecurityException will be returned in the List.

  returns: a List object with all or a subset of the
           InterfaceAddresss of this network interface - `java.util.List<java.net.InterfaceAddress>`"
  (^java.util.List [^java.net.NetworkInterface this]
    (-> this (.getInterfaceAddresses))))

(defn loopback?
  "Returns whether a network interface is a loopback interface.

  returns: true if the interface is a loopback interface. - `boolean`

  throws: java.net.SocketException - if an I/O error occurs."
  (^Boolean [^java.net.NetworkInterface this]
    (-> this (.isLoopback))))

(defn point-to-point?
  "Returns whether a network interface is a point to point interface.
   A typical point to point interface would be a PPP connection through
   a modem.

  returns: true if the interface is a point to point
            interface. - `boolean`

  throws: java.net.SocketException - if an I/O error occurs."
  (^Boolean [^java.net.NetworkInterface this]
    (-> this (.isPointToPoint))))

(defn up?
  "Returns whether a network interface is up and running.

  returns: true if the interface is up and running. - `boolean`

  throws: java.net.SocketException - if an I/O error occurs."
  (^Boolean [^java.net.NetworkInterface this]
    (-> this (.isUp))))

(defn hash-code
  "Description copied from class: Object

  returns: a hash code value for this object. - `int`"
  (^Integer [^java.net.NetworkInterface this]
    (-> this (.hashCode))))

(defn equals
  "Compares this object against the specified object.
   The result is true if and only if the argument is
   not null and it represents the same NetworkInterface
   as this object.

   Two instances of NetworkInterface represent the same
   NetworkInterface if both name and addrs are the same for both.

  obj - the object to compare against. - `java.lang.Object`

  returns: true if the objects are the same;
            false otherwise. - `boolean`"
  (^Boolean [^java.net.NetworkInterface this ^java.lang.Object obj]
    (-> this (.equals obj))))

