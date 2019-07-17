(ns jdk.net.SocketPermission
  "This class represents access to a network via sockets.
  A SocketPermission consists of a
  host specification and a set of `actions` specifying ways to
  connect to that host. The host is specified as


     host = (hostname | IPv4address | iPv6reference) [:portrange]
     portrange = portnumber | -portnumber | portnumber-[portnumber]
  The host is expressed as a DNS name, as a numerical IP address,
  or as `localhost` (for the local machine).
  The wildcard `*` may be included once in a DNS name host
  specification. If it is included, it must be in the leftmost
  position, as in `*.sun.com`.

  The format of the IPv6reference should follow that specified in RFC 2732: Format
  for Literal IPv6 Addresses in URLs:


     ipv6reference = `[` IPv6address `]`
  For example, you can construct a SocketPermission instance
  as the following:


     String hostAddress = inetaddress.getHostAddress();
     if (inetaddress instanceof Inet6Address) {
         sp = new SocketPermission(`[`  hostAddress  `]:`  port, action);
     } else {
         sp = new SocketPermission(hostAddress  `:`  port, action);
     }
  or


     String host = url.getHost();
     sp = new SocketPermission(host  `:`  port, action);

  The full uncompressed form of
  an IPv6 literal address is also valid.

  The port or portrange is optional. A port specification of the
  form `N-`, where N is a port number, signifies all ports
  numbered N and above, while a specification of the
  form `-N` indicates all ports numbered N and below.
  The special port value 0 refers to the entire ephemeral
  port range. This is a fixed range of ports a system may use to
  allocate dynamic ports from. The actual range may be system dependent.

  The possible ways to connect to the host are


  accept
  connect
  listen
  resolve
  The `listen` action is only meaningful when used with `localhost` and
  means the ability to bind to a specified port.
  The `resolve` action is implied when any of the other actions are present.
  The action `resolve` refers to host/ip name service lookups.

  The actions string is converted to lowercase before processing.
  As an example of the creation and meaning of SocketPermissions,
  note that if the following permission:



    p1 = new SocketPermission(`puffin.eng.sun.com:7777`, `connect,accept`);

  is granted to some code, it allows that code to connect to port 7777 on
  puffin.eng.sun.com, and to accept connections on that port.

  Similarly, if the following permission:



    p2 = new SocketPermission(`localhost:1024-`, `accept,connect,listen`);

  is granted to some code, it allows that code to
  accept connections on, connect to, or listen on any port between
  1024 and 65535 on the local host.

  Note: Granting code permission to accept or make connections to remote
  hosts may be dangerous because malevolent code can then more easily
  transfer and share confidential data among parties who may not
  otherwise have access to the data."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.net SocketPermission]))

(defn ->socket-permission
  "Constructor.

  Creates a new SocketPermission object with the specified actions.
   The host is expressed as a DNS name, or as a numerical IP address.
   Optionally, a port or a portrange may be supplied (separated
   from the DNS name or IP address by a colon).

   To specify the local machine, use `localhost` as the host.
   Also note: An empty host String (``) is equivalent to `localhost`.

   The actions parameter contains a comma-separated list of the
   actions granted for the specified host (and port(s)). Possible actions are
   `connect`, `listen`, `accept`, `resolve`, or
   any combination of those. `resolve` is automatically added
   when any of the other three are specified.

   Examples of SocketPermission instantiation are the following:


      nr = new SocketPermission(`www.catalog.com`, `connect`);
      nr = new SocketPermission(`www.sun.com:80`, `connect`);
      nr = new SocketPermission(`*.sun.com`, `connect`);
      nr = new SocketPermission(`*.edu`, `resolve`);
      nr = new SocketPermission(`204.160.241.0`, `connect`);
      nr = new SocketPermission(`localhost:1024-65535`, `listen`);
      nr = new SocketPermission(`204.160.241.0:1024-65535`, `connect`);

  host - the hostname or IPaddress of the computer, optionally including a colon followed by a port or port range. - `java.lang.String`
  action - the action string. - `java.lang.String`"
  ([^java.lang.String host ^java.lang.String action]
    (new SocketPermission host action)))

(defn implies
  "Checks if this socket permission object `implies` the
   specified permission.

   More specifically, this method first ensures that all of the following
   are true (and returns false if any of them are not):

    p is an instanceof SocketPermission,
    p's actions are a proper subset of this
   object's actions, and
    p's port range is included in this port range. Note:
   port range is ignored when p only contains the action, 'resolve'.


   Then implies checks each of the following, in order,
   and for each returns true if the stated condition is true:

    If this object was initialized with a single IP address and one of p's
   IP addresses is equal to this object's IP address.
   If this object is a wildcard domain (such as *.sun.com), and
   p's canonical name (the name without any preceding *)
   ends with this object's canonical host name. For example, *.sun.com
   implies *.eng.sun.com.
   If this object was not initialized with a single IP address, and one of this
   object's IP addresses equals one of p's IP addresses.
   If this canonical name equals p's canonical name.


   If none of the above are true, implies returns false.

  p - the permission to check against. - `java.security.Permission`

  returns: true if the specified permission is implied by this object,
   false if not. - `boolean`"
  (^Boolean [^java.net.SocketPermission this ^java.security.Permission p]
    (-> this (.implies p))))

(defn equals
  "Checks two SocketPermission objects for equality.

  obj - the object to test for equality with this object. - `java.lang.Object`

  returns: true if obj is a SocketPermission, and has the
    same hostname, port range, and actions as this
    SocketPermission object. However, port range will be ignored
    in the comparison if obj only contains the action, 'resolve'. - `boolean`"
  (^Boolean [^java.net.SocketPermission this ^java.lang.Object obj]
    (-> this (.equals obj))))

(defn hash-code
  "Returns the hash code value for this object.

  returns: a hash code value for this object. - `int`"
  (^Integer [^java.net.SocketPermission this]
    (-> this (.hashCode))))

(defn get-actions
  "Returns the canonical string representation of the actions.
   Always returns present actions in the following order:
   connect, listen, accept, resolve.

  returns: the canonical string representation of the actions. - `java.lang.String`"
  (^java.lang.String [^java.net.SocketPermission this]
    (-> this (.getActions))))

(defn new-permission-collection
  "Returns a new PermissionCollection object for storing SocketPermission
   objects.

   SocketPermission objects must be stored in a manner that allows them
   to be inserted into the collection in any order, but that also enables the
   PermissionCollection implies
   method to be implemented in an efficient (and consistent) manner.

  returns: a new PermissionCollection object suitable for storing SocketPermissions. - `java.security.PermissionCollection`"
  (^java.security.PermissionCollection [^java.net.SocketPermission this]
    (-> this (.newPermissionCollection))))

