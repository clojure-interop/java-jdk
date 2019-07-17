(ns jdk.net.InetSocketAddress
  "This class implements an IP Socket Address (IP address  port number)
  It can also be a pair (hostname  port number), in which case an attempt
  will be made to resolve the hostname. If resolution fails then the address
  is said to be unresolved but can still be used on some circumstances
  like connecting through a proxy.

  It provides an immutable object used by sockets for binding, connecting, or
  as returned values.

  The wildcard is a special local IP address. It usually means `any`
  and can only be used for bind operations."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.net InetSocketAddress]))

(defn ->inet-socket-address
  "Constructor.

  Creates a socket address from an IP address and a port number.

   A valid port value is between 0 and 65535.
   A port number of zero will let the system pick up an
   ephemeral port in a bind operation.

   A null address will assign the wildcard address.

  addr - The IP address - `java.net.InetAddress`
  port - The port number - `int`

  throws: java.lang.IllegalArgumentException - if the port parameter is outside the specified range of valid port values."
  ([^java.net.InetAddress addr ^Integer port]
    (new InetSocketAddress addr port))
  ([^Integer port]
    (new InetSocketAddress port)))

(defn *create-unresolved
  "Creates an unresolved socket address from a hostname and a port number.

   No attempt will be made to resolve the hostname into an InetAddress.
   The address will be flagged as unresolved.

   A valid port value is between 0 and 65535.
   A port number of zero will let the system pick up an
   ephemeral port in a bind operation.

  host - the Host name - `java.lang.String`
  port - The port number - `int`

  returns: a InetSocketAddress representing the unresolved
            socket address - `java.net.InetSocketAddress`

  throws: java.lang.IllegalArgumentException - if the port parameter is outside the range of valid port values, or if the hostname parameter is null."
  ([^java.lang.String host ^Integer port]
    (InetSocketAddress/createUnresolved host port)))

(defn get-port
  "Gets the port number.

  returns: the port number. - `int`"
  ([^java.net.InetSocketAddress this]
    (-> this (.getPort))))

(defn get-address
  "Gets the InetAddress.

  returns: the InetAdress or null if it is unresolved. - `java.net.InetAddress`"
  ([^java.net.InetSocketAddress this]
    (-> this (.getAddress))))

(defn get-host-name
  "Gets the hostname.
   Note: This method may trigger a name service reverse lookup if the
   address was created with a literal IP address.

  returns: the hostname part of the address. - `java.lang.String`"
  ([^java.net.InetSocketAddress this]
    (-> this (.getHostName))))

(defn get-host-string
  "Returns the hostname, or the String form of the address if it
   doesn't have a hostname (it was created using a literal).
   This has the benefit of not attempting a reverse lookup.

  returns: the hostname, or String representation of the address. - `java.lang.String`"
  ([^java.net.InetSocketAddress this]
    (-> this (.getHostString))))

(defn unresolved?
  "Checks whether the address has been resolved or not.

  returns: true if the hostname couldn't be resolved into
            an InetAddress. - `boolean`"
  ([^java.net.InetSocketAddress this]
    (-> this (.isUnresolved))))

(defn to-string
  "Constructs a string representation of this InetSocketAddress.
   This String is constructed by calling toString() on the InetAddress
   and concatenating the port number (with a colon). If the address
   is unresolved then the part before the colon will only contain the hostname.

  returns: a string representation of this object. - `java.lang.String`"
  ([^java.net.InetSocketAddress this]
    (-> this (.toString))))

(defn equals
  "Compares this object against the specified object.
   The result is true if and only if the argument is
   not null and it represents the same address as
   this object.

   Two instances of InetSocketAddress represent the same
   address if both the InetAddresses (or hostnames if it is unresolved) and port
   numbers are equal.
   If both addresses are unresolved, then the hostname and the port number
   are compared.

   Note: Hostnames are case insensitive. e.g. `FooBar` and `foobar` are
   considered equal.

  obj - the object to compare against. - `java.lang.Object`

  returns: true if the objects are the same;
            false otherwise. - `boolean`"
  ([^java.net.InetSocketAddress this ^java.lang.Object obj]
    (-> this (.equals obj))))

(defn hash-code
  "Returns a hashcode for this socket address.

  returns: a hash code value for this socket address. - `int`"
  ([^java.net.InetSocketAddress this]
    (-> this (.hashCode))))

