(ns jdk.rmi.Naming
  "The Naming class provides methods for storing and obtaining
  references to remote objects in a remote object registry.  Each method of
  the Naming class takes as one of its arguments a name that
  is a java.lang.String in URL format (without the
  scheme component) of the form:



     //host:port/name

  where host is the host (remote or local) where the registry
  is located, port is the port number on which the registry
  accepts calls, and where name is a simple string uninterpreted
  by the registry. Both host and port are optional.
  If host is omitted, the host defaults to the local host. If
  port is omitted, then the port defaults to 1099, the
  \"well-known\" port that RMI's registry, rmiregistry, uses.

  Binding a name for a remote object is associating or
  registering a name for a remote object that can be used at a later time to
  look up that remote object.  A remote object can be associated with a name
  using the Naming class's bind or
  rebind methods.

  Once a remote object is registered (bound) with the RMI registry on the
  local host, callers on a remote (or local) host can lookup the remote
  object by name, obtain its reference, and then invoke remote methods on the
  object.  A registry may be shared by all servers running on a host or an
  individual server process may create and use its own registry if desired
  (see java.rmi.registry.LocateRegistry.createRegistry method
  for details)."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.rmi Naming]))

(defn *lookup
  "Returns a reference, a stub, for the remote object associated
   with the specified name.

  name - a name in URL format (without the scheme component) - `java.lang.String`

  returns: a reference for a remote object - `java.rmi.Remote`

  throws: java.rmi.NotBoundException - if name is not currently bound"
  (^java.rmi.Remote [^java.lang.String name]
    (Naming/lookup name)))

(defn *bind
  "Binds the specified name to a remote object.

  name - a name in URL format (without the scheme component) - `java.lang.String`
  obj - a reference for the remote object (usually a stub) - `java.rmi.Remote`

  throws: java.rmi.AlreadyBoundException - if name is already bound"
  ([^java.lang.String name ^java.rmi.Remote obj]
    (Naming/bind name obj)))

(defn *unbind
  "Destroys the binding for the specified name that is associated
   with a remote object.

  name - a name in URL format (without the scheme component) - `java.lang.String`

  throws: java.rmi.NotBoundException - if name is not currently bound"
  ([^java.lang.String name]
    (Naming/unbind name)))

(defn *rebind
  "Rebinds the specified name to a new remote object. Any existing
   binding for the name is replaced.

  name - a name in URL format (without the scheme component) - `java.lang.String`
  obj - new remote object to associate with the name - `java.rmi.Remote`

  throws: java.net.MalformedURLException - if the name is not an appropriately formatted URL"
  ([^java.lang.String name ^java.rmi.Remote obj]
    (Naming/rebind name obj)))

(defn *list
  "Returns an array of the names bound in the registry.  The names are
   URL-formatted (without the scheme component) strings. The array contains
   a snapshot of the names present in the registry at the time of the
   call.

  name - a registry name in URL format (without the scheme component) - `java.lang.String`

  returns: an array of names (in the appropriate format) bound
            in the registry - `java.lang.String[]`

  throws: java.net.MalformedURLException - if the name is not an appropriately formatted URL"
  ([^java.lang.String name]
    (Naming/list name)))

