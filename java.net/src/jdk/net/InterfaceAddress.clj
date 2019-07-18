(ns jdk.net.InterfaceAddress
  "This class represents a Network Interface address. In short it's an
  IP address, a subnet mask and a broadcast address when the address is
  an IPv4 one. An IP address and a network prefix length in the case
  of IPv6 address."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.net InterfaceAddress]))

(defn get-address
  "Returns an InetAddress for this address.

  returns: the InetAddress for this address. - `java.net.InetAddress`"
  (^java.net.InetAddress [^InterfaceAddress this]
    (-> this (.getAddress))))

(defn get-broadcast
  "Returns an InetAddress for the broadcast address
   for this InterfaceAddress.

   Only IPv4 networks have broadcast address therefore, in the case
   of an IPv6 network, null will be returned.

  returns: the InetAddress representing the broadcast
           address or null if there is no broadcast address. - `java.net.InetAddress`"
  (^java.net.InetAddress [^InterfaceAddress this]
    (-> this (.getBroadcast))))

(defn get-network-prefix-length
  "Returns the network prefix length for this address. This is also known
   as the subnet mask in the context of IPv4 addresses.
   Typical IPv4 values would be 8 (255.0.0.0), 16 (255.255.0.0)
   or 24 (255.255.255.0).
   Typical IPv6 values would be 128 (::1/128) or 10 (fe80::203:baff:fe27:1243/10)

  returns: a short representing the prefix length for the
           subnet of that address. - `short`"
  (^Short [^InterfaceAddress this]
    (-> this (.getNetworkPrefixLength))))

(defn equals
  "Compares this object against the specified object.
   The result is true if and only if the argument is
   not null and it represents the same interface address as
   this object.

   Two instances of InterfaceAddress represent the same
   address if the InetAddress, the prefix length and the broadcast are
   the same for both.

  obj - the object to compare against. - `java.lang.Object`

  returns: true if the objects are the same;
            false otherwise. - `boolean`"
  (^Boolean [^InterfaceAddress this ^java.lang.Object obj]
    (-> this (.equals obj))))

(defn hash-code
  "Returns a hashcode for this Interface address.

  returns: a hash code value for this Interface address. - `int`"
  (^Integer [^InterfaceAddress this]
    (-> this (.hashCode))))

(defn to-string
  "Converts this Interface address to a String. The
   string returned is of the form: InetAddress / prefix length [ broadcast address ].

  returns: a string representation of this Interface address. - `java.lang.String`"
  (^java.lang.String [^InterfaceAddress this]
    (-> this (.toString))))

