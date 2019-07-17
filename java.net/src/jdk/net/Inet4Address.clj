(ns jdk.net.Inet4Address
  "This class represents an Internet Protocol version 4 (IPv4) address.
  Defined by
  RFC 790: Assigned Numbers,

  RFC 1918: Address Allocation for Private Internets,
  and RFC 2365:
  Administratively Scoped IP Multicast

   Textual representation of IP addresses

  Textual representation of IPv4 address used as input to methods
  takes one of the following forms:


  d.d.d.d
  d.d.d
  d.d
  d


   When four parts are specified, each is interpreted as a byte of
  data and assigned, from left to right, to the four bytes of an IPv4
  address.

   When a three part address is specified, the last part is
  interpreted as a 16-bit quantity and placed in the right most two
  bytes of the network address. This makes the three part address
  format convenient for specifying Class B net- work addresses as
  128.net.host.

   When a two part address is supplied, the last part is
  interpreted as a 24-bit quantity and placed in the right most three
  bytes of the network address. This makes the two part address
  format convenient for specifying Class A network addresses as
  net.host.

   When only one part is given, the value is stored directly in
  the network address without any byte rearrangement.

   For methods that return a textual representation as output
  value, the first form, i.e. a dotted-quad string, is used.

   The Scope of a Multicast Address

  Historically the IPv4 TTL field in the IP header has doubled as a
  multicast scope field: a TTL of 0 means node-local, 1 means
  link-local, up through 32 means site-local, up through 64 means
  region-local, up through 128 means continent-local, and up through
  255 are global. However, the administrative scoping is preferred.
  Please refer to
  RFC 2365: Administratively Scoped IP Multicast"
  (:refer-clojure :only [require comment defn ->])
  (:import [java.net Inet4Address]))

(defn site-local-address?
  "Utility routine to check if the InetAddress is a site local address.

  returns: a boolean indicating if the InetAddress is
   a site local address; or false if address is not a site local unicast address. - `boolean`"
  ([this]
    (-> this (.isSiteLocalAddress))))

(defn loopback-address?
  "Utility routine to check if the InetAddress is a loopback address.

  returns: a boolean indicating if the InetAddress is
   a loopback address; or false otherwise. - `boolean`"
  ([this]
    (-> this (.isLoopbackAddress))))

(defn get-host-address
  "Returns the IP address string in textual presentation form.

  returns: the raw IP address in a string format. - `java.lang.String`"
  ([this]
    (-> this (.getHostAddress))))

(defn link-local-address?
  "Utility routine to check if the InetAddress is an link local address.

  returns: a boolean indicating if the InetAddress is
   a link local address; or false if address is not a link local unicast address. - `boolean`"
  ([this]
    (-> this (.isLinkLocalAddress))))

(defn any-local-address?
  "Utility routine to check if the InetAddress in a wildcard address.

  returns: a boolean indicating if the Inetaddress is
           a wildcard address. - `boolean`"
  ([this]
    (-> this (.isAnyLocalAddress))))

(defn mc-link-local?
  "Utility routine to check if the multicast address has link scope.

  returns: a boolean indicating if the address has
           is a multicast address of link-local scope, false if it is not
           of link-local scope or it is not a multicast address - `boolean`"
  ([this]
    (-> this (.isMCLinkLocal))))

(defn mc-global?
  "Utility routine to check if the multicast address has global scope.

  returns: a boolean indicating if the address has
           is a multicast address of global scope, false if it is not
           of global scope or it is not a multicast address - `boolean`"
  ([this]
    (-> this (.isMCGlobal))))

(defn multicast-address?
  "Utility routine to check if the InetAddress is an
   IP multicast address. IP multicast address is a Class D
   address i.e first four bits of the address are 1110.

  returns: a boolean indicating if the InetAddress is
   an IP multicast address - `boolean`"
  ([this]
    (-> this (.isMulticastAddress))))

(defn mc-node-local?
  "Utility routine to check if the multicast address has node scope.

  returns: a boolean indicating if the address has
           is a multicast address of node-local scope, false if it is not
           of node-local scope or it is not a multicast address - `boolean`"
  ([this]
    (-> this (.isMCNodeLocal))))

(defn get-address
  "Returns the raw IP address of this InetAddress
   object. The result is in network byte order: the highest order
   byte of the address is in getAddress()[0].

  returns: the raw IP address of this object. - `byte[]`"
  ([this]
    (-> this (.getAddress))))

(defn mc-org-local?
  "Utility routine to check if the multicast address has organization scope.

  returns: a boolean indicating if the address has
           is a multicast address of organization-local scope,
           false if it is not of organization-local scope
           or it is not a multicast address - `boolean`"
  ([this]
    (-> this (.isMCOrgLocal))))

(defn mc-site-local?
  "Utility routine to check if the multicast address has site scope.

  returns: a boolean indicating if the address has
           is a multicast address of site-local scope, false if it is not
           of site-local scope or it is not a multicast address - `boolean`"
  ([this]
    (-> this (.isMCSiteLocal))))

(defn hash-code
  "Returns a hashcode for this IP address.

  returns: a hash code value for this IP address. - `int`"
  ([this]
    (-> this (.hashCode))))

(defn equals
  "Compares this object against the specified object.
   The result is true if and only if the argument is
   not null and it represents the same IP address as
   this object.

   Two instances of InetAddress represent the same IP
   address if the length of the byte arrays returned by
   getAddress is the same for both, and each of the
   array components is the same for the byte arrays.

  obj - the object to compare against. - `java.lang.Object`

  returns: true if the objects are the same;
            false otherwise. - `boolean`"
  ([this obj]
    (-> this (.equals obj))))

