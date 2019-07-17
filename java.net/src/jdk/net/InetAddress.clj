(ns jdk.net.InetAddress
  "This class represents an Internet Protocol (IP) address.

   An IP address is either a 32-bit or 128-bit unsigned number
  used by IP, a lower-level protocol on which protocols like UDP and
  TCP are built. The IP address architecture is defined by RFC 790:
  Assigned Numbers,  RFC 1918:
  Address Allocation for Private Internets, RFC 2365:
  Administratively Scoped IP Multicast, and RFC 2373: IP
  Version 6 Addressing Architecture. An instance of an
  InetAddress consists of an IP address and possibly its
  corresponding host name (depending on whether it is constructed
  with a host name or whether it has already done reverse host name
  resolution).

   Address types


    unicast
        An identifier for a single interface. A packet sent to
          a unicast address is delivered to the interface identified by
          that address.

           The Unspecified Address -- Also called anylocal or wildcard
          address. It must never be assigned to any node. It indicates the
          absence of an address. One example of its use is as the target of
          bind, which allows a server to accept a client connection on any
          interface, in case the server host has multiple interfaces.

           The unspecified address must not be used as
          the destination address of an IP packet.

           The Loopback Addresses -- This is the address
          assigned to the loopback interface. Anything sent to this
          IP address loops around and becomes IP input on the local
          host. This address is often used when testing a
          client.
    multicast
        An identifier for a set of interfaces (typically belonging
          to different nodes). A packet sent to a multicast address is
          delivered to all interfaces identified by that address.


   IP address scope

   Link-local addresses are designed to be used for addressing
  on a single link for purposes such as auto-address configuration,
  neighbor discovery, or when no routers are present.

   Site-local addresses are designed to be used for addressing
  inside of a site without the need for a global prefix.

   Global addresses are unique across the internet.

   Textual representation of IP addresses

  The textual representation of an IP address is address family specific.



  For IPv4 address format, please refer to Inet4Address#format; For IPv6
  address format, please refer to Inet6Address#format.

  There is a couple of
  System Properties affecting how IPv4 and IPv6 addresses are used.

   Host Name Resolution

  Host name-to-IP address resolution is accomplished through
  the use of a combination of local machine configuration information
  and network naming services such as the Domain Name System (DNS)
  and Network Information Service(NIS). The particular naming
  services(s) being used is by default the local machine configured
  one. For any host name, its corresponding IP address is returned.

   Reverse name resolution means that for any IP address,
  the host associated with the IP address is returned.

   The InetAddress class provides methods to resolve host names to
  their IP addresses and vice versa.

   InetAddress Caching

  The InetAddress class has a cache to store successful as well as
  unsuccessful host name resolutions.

   By default, when a security manager is installed, in order to
  protect against DNS spoofing attacks,
  the result of positive host name resolutions are
  cached forever. When a security manager is not installed, the default
  behavior is to cache entries for a finite (implementation dependent)
  period of time. The result of unsuccessful host
  name resolution is cached for a very short period of time (10
  seconds) to improve performance.

   If the default behavior is not desired, then a Java security property
  can be set to a different Time-to-live (TTL) value for positive
  caching. Likewise, a system admin can configure a different
  negative caching TTL value when needed.

   Two Java security properties control the TTL values used for
   positive and negative host name resolution caching:



  networkaddress.cache.ttl
  Indicates the caching policy for successful name lookups from
  the name service. The value is specified as as integer to indicate
  the number of seconds to cache the successful lookup. The default
  setting is to cache for an implementation specific period of time.

  A value of -1 indicates `cache forever`.

  networkaddress.cache.negative.ttl (default: 10)
  Indicates the caching policy for un-successful name lookups
  from the name service. The value is specified as as integer to
  indicate the number of seconds to cache the failure for
  un-successful lookups.

  A value of 0 indicates `never cache`.
  A value of -1 indicates `cache forever`."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.net InetAddress]))

(defn *get-by-address
  "Creates an InetAddress based on the provided host name and IP address.
   No name service is checked for the validity of the address.

    The host name can either be a machine name, such as
   `java.sun.com`, or a textual representation of its IP
   address.
    No validity checking is done on the host name either.

    If addr specifies an IPv4 address an instance of Inet4Address
   will be returned; otherwise, an instance of Inet6Address
   will be returned.

    IPv4 address byte array must be 4 bytes long and IPv6 byte array
   must be 16 bytes long

  host - the specified host - `java.lang.String`
  addr - the raw IP address in network byte order - `byte[]`

  returns: an InetAddress object created from the raw IP address. - `java.net.InetAddress`

  throws: java.net.UnknownHostException - if IP address is of illegal length"
  (^java.net.InetAddress [^java.lang.String host addr]
    (InetAddress/getByAddress host addr))
  (^java.net.InetAddress [addr]
    (InetAddress/getByAddress addr)))

(defn *get-by-name
  "Determines the IP address of a host, given the host's name.

    The host name can either be a machine name, such as
   `java.sun.com`, or a textual representation of its
   IP address. If a literal IP address is supplied, only the
   validity of the address format is checked.

    For host specified in literal IPv6 address,
   either the form defined in RFC 2732 or the literal IPv6 address
   format defined in RFC 2373 is accepted. IPv6 scoped addresses are also
   supported. See here for a description of IPv6
   scoped addresses.

    If the host is null then an InetAddress
   representing an address of the loopback interface is returned.
   See RFC 3330
   section 2 and RFC 2373
   section 2.5.3.

  host - the specified host, or null. - `java.lang.String`

  returns: an IP address for the given host name. - `java.net.InetAddress`

  throws: java.net.UnknownHostException - if no IP address for the host could be found, or if a scope_id was specified for a global IPv6 address."
  (^java.net.InetAddress [^java.lang.String host]
    (InetAddress/getByName host)))

(defn *get-all-by-name
  "Given the name of a host, returns an array of its IP addresses,
   based on the configured name service on the system.

    The host name can either be a machine name, such as
   `java.sun.com`, or a textual representation of its IP
   address. If a literal IP address is supplied, only the
   validity of the address format is checked.

    For host specified in literal IPv6 address,
   either the form defined in RFC 2732 or the literal IPv6 address
   format defined in RFC 2373 is accepted. A literal IPv6 address may
   also be qualified by appending a scoped zone identifier or scope_id.
   The syntax and usage of scope_ids is described
   here.
    If the host is null then an InetAddress
   representing an address of the loopback interface is returned.
   See RFC 3330
   section 2 and RFC 2373
   section 2.5.3.

    If there is a security manager and host is not
   null and host.length()  is not equal to zero, the
   security manager's
   checkConnect method is called
   with the hostname and -1
   as its arguments to see if the operation is allowed.

  host - the name of the host, or null. - `java.lang.String`

  returns: an array of all the IP addresses for a given host name. - `java.net.InetAddress[]`

  throws: java.net.UnknownHostException - if no IP address for the host could be found, or if a scope_id was specified for a global IPv6 address."
  ([^java.lang.String host]
    (InetAddress/getAllByName host)))

(defn *get-loopback-address
  "Returns the loopback address.

   The InetAddress returned will represent the IPv4
   loopback address, 127.0.0.1, or the IPv6 loopback
   address, ::1. The IPv4 loopback address returned
   is only one of many in the form 127.*.*.*

  returns: the InetAddress loopback instance. - `java.net.InetAddress`"
  (^java.net.InetAddress []
    (InetAddress/getLoopbackAddress )))

(defn *get-local-host
  "Returns the address of the local host. This is achieved by retrieving
   the name of the host from the system, then resolving that name into
   an InetAddress.

   Note: The resolved address may be cached for a short period of time.


   If there is a security manager, its
   checkConnect method is called
   with the local host name and -1
   as its arguments to see if the operation is allowed.
   If the operation is not allowed, an InetAddress representing
   the loopback address is returned.

  returns: the address of the local host. - `java.net.InetAddress`

  throws: java.net.UnknownHostException - if the local host name could not be resolved into an address."
  (^java.net.InetAddress []
    (InetAddress/getLocalHost )))

(defn site-local-address?
  "Utility routine to check if the InetAddress is a site local address.

  returns: a boolean indicating if the InetAddress is
   a site local address; or false if address is not a site local unicast address. - `boolean`"
  (^Boolean [^java.net.InetAddress this]
    (-> this (.isSiteLocalAddress))))

(defn loopback-address?
  "Utility routine to check if the InetAddress is a loopback address.

  returns: a boolean indicating if the InetAddress is
   a loopback address; or false otherwise. - `boolean`"
  (^Boolean [^java.net.InetAddress this]
    (-> this (.isLoopbackAddress))))

(defn get-host-address
  "Returns the IP address string in textual presentation.

  returns: the raw IP address in a string format. - `java.lang.String`"
  (^java.lang.String [^java.net.InetAddress this]
    (-> this (.getHostAddress))))

(defn link-local-address?
  "Utility routine to check if the InetAddress is an link local address.

  returns: a boolean indicating if the InetAddress is
   a link local address; or false if address is not a link local unicast address. - `boolean`"
  (^Boolean [^java.net.InetAddress this]
    (-> this (.isLinkLocalAddress))))

(defn any-local-address?
  "Utility routine to check if the InetAddress in a wildcard address.

  returns: a boolean indicating if the Inetaddress is
           a wildcard address. - `boolean`"
  (^Boolean [^java.net.InetAddress this]
    (-> this (.isAnyLocalAddress))))

(defn mc-link-local?
  "Utility routine to check if the multicast address has link scope.

  returns: a boolean indicating if the address has
           is a multicast address of link-local scope, false if it is not
           of link-local scope or it is not a multicast address - `boolean`"
  (^Boolean [^java.net.InetAddress this]
    (-> this (.isMCLinkLocal))))

(defn mc-global?
  "Utility routine to check if the multicast address has global scope.

  returns: a boolean indicating if the address has
           is a multicast address of global scope, false if it is not
           of global scope or it is not a multicast address - `boolean`"
  (^Boolean [^java.net.InetAddress this]
    (-> this (.isMCGlobal))))

(defn reachable?
  "Test whether that address is reachable. Best effort is made by the
   implementation to try to reach the host, but firewalls and server
   configuration may block requests resulting in a unreachable status
   while some specific ports may be accessible.
   A typical implementation will use ICMP ECHO REQUESTs if the
   privilege can be obtained, otherwise it will try to establish
   a TCP connection on port 7 (Echo) of the destination host.

   The network interface and ttl parameters
   let the caller specify which network interface the test will go through
   and the maximum number of hops the packets should go through.
   A negative value for the ttl will result in an
   IllegalArgumentException being thrown.

   The timeout value, in milliseconds, indicates the maximum amount of time
   the try should take. If the operation times out before getting an
   answer, the host is deemed unreachable. A negative value will result
   in an IllegalArgumentException being thrown.

  netif - the NetworkInterface through which the test will be done, or null for any interface - `java.net.NetworkInterface`
  ttl - the maximum numbers of hops to try or 0 for the default - `int`
  timeout - the time, in milliseconds, before the call aborts - `int`

  returns: a booleanindicating if the address is reachable. - `boolean`

  throws: java.lang.IllegalArgumentException - if either timeout or ttl are negative."
  (^Boolean [^java.net.InetAddress this ^java.net.NetworkInterface netif ^Integer ttl ^Integer timeout]
    (-> this (.isReachable netif ttl timeout)))
  (^Boolean [^java.net.InetAddress this ^Integer timeout]
    (-> this (.isReachable timeout))))

(defn multicast-address?
  "Utility routine to check if the InetAddress is an
   IP multicast address.

  returns: a boolean indicating if the InetAddress is
   an IP multicast address - `boolean`"
  (^Boolean [^java.net.InetAddress this]
    (-> this (.isMulticastAddress))))

(defn mc-node-local?
  "Utility routine to check if the multicast address has node scope.

  returns: a boolean indicating if the address has
           is a multicast address of node-local scope, false if it is not
           of node-local scope or it is not a multicast address - `boolean`"
  (^Boolean [^java.net.InetAddress this]
    (-> this (.isMCNodeLocal))))

(defn to-string
  "Converts this IP address to a String. The
   string returned is of the form: hostname / literal IP
   address.

   If the host name is unresolved, no reverse name service lookup
   is performed. The hostname part will be represented by an empty string.

  returns: a string representation of this IP address. - `java.lang.String`"
  (^java.lang.String [^java.net.InetAddress this]
    (-> this (.toString))))

(defn get-address
  "Returns the raw IP address of this InetAddress
   object. The result is in network byte order: the highest order
   byte of the address is in getAddress()[0].

  returns: the raw IP address of this object. - `byte[]`"
  ([^java.net.InetAddress this]
    (-> this (.getAddress))))

(defn mc-org-local?
  "Utility routine to check if the multicast address has organization scope.

  returns: a boolean indicating if the address has
           is a multicast address of organization-local scope,
           false if it is not of organization-local scope
           or it is not a multicast address - `boolean`"
  (^Boolean [^java.net.InetAddress this]
    (-> this (.isMCOrgLocal))))

(defn mc-site-local?
  "Utility routine to check if the multicast address has site scope.

  returns: a boolean indicating if the address has
           is a multicast address of site-local scope, false if it is not
           of site-local scope or it is not a multicast address - `boolean`"
  (^Boolean [^java.net.InetAddress this]
    (-> this (.isMCSiteLocal))))

(defn hash-code
  "Returns a hashcode for this IP address.

  returns: a hash code value for this IP address. - `int`"
  (^Integer [^java.net.InetAddress this]
    (-> this (.hashCode))))

(defn get-canonical-host-name
  "Gets the fully qualified domain name for this IP address.
   Best effort method, meaning we may not be able to return
   the FQDN depending on the underlying system configuration.

   If there is a security manager, this method first
   calls its checkConnect method
   with the hostname and -1
   as its arguments to see if the calling code is allowed to know
   the hostname for this IP address, i.e., to connect to the host.
   If the operation is not allowed, it will return
   the textual representation of the IP address.

  returns: the fully qualified domain name for this IP address,
      or if the operation is not allowed by the security check,
      the textual representation of the IP address. - `java.lang.String`"
  (^java.lang.String [^java.net.InetAddress this]
    (-> this (.getCanonicalHostName))))

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
  (^Boolean [^java.net.InetAddress this ^java.lang.Object obj]
    (-> this (.equals obj))))

(defn get-host-name
  "Gets the host name for this IP address.

   If this InetAddress was created with a host name,
   this host name will be remembered and returned;
   otherwise, a reverse name lookup will be performed
   and the result will be returned based on the system
   configured name lookup service. If a lookup of the name service
   is required, call
   getCanonicalHostName.

   If there is a security manager, its
   checkConnect method is first called
   with the hostname and -1
   as its arguments to see if the operation is allowed.
   If the operation is not allowed, it will return
   the textual representation of the IP address.

  returns: the host name for this IP address, or if the operation
      is not allowed by the security check, the textual
      representation of the IP address. - `java.lang.String`"
  (^java.lang.String [^java.net.InetAddress this]
    (-> this (.getHostName))))

