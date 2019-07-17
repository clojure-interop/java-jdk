(ns jdk.rmi.registry.Registry
  "Registry is a remote interface to a simple remote
  object registry that provides methods for storing and retrieving
  remote object references bound with arbitrary string names.  The
  bind, unbind, and rebind
  methods are used to alter the name bindings in the registry, and
  the lookup and list methods are used to
  query the current name bindings.

  In its typical usage, a Registry enables RMI client
  bootstrapping: it provides a simple means for a client to obtain an
  initial reference to a remote object.  Therefore, a registry's
  remote object implementation is typically exported with a
  well-known address, such as with a well-known ObjID and TCP port number
  (default is 1099).

  The LocateRegistry class provides a programmatic API for
  constructing a bootstrap reference to a Registry at a
  remote address (see the static getRegistry methods)
  and for creating and exporting a Registry in the
  current VM on a particular local address (see the static
  createRegistry methods).

  A Registry implementation may choose to restrict
  access to some or all of its methods (for example, methods that
  mutate the registry's bindings may be restricted to calls
  originating from the local host).  If a Registry
  method chooses to deny access for a given invocation, its
  implementation may throw AccessException, which
  (because it extends RemoteException) will be
  wrapped in a ServerException when caught by a
  remote client.

  The names used for bindings in a Registry are pure
  strings, not parsed.  A service which stores its remote reference
  in a Registry may wish to use a package name as a
  prefix in the name binding to reduce the likelihood of name
  collisions in the registry."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.rmi.registry Registry]))

(defn lookup
  "Returns the remote reference bound to the specified
   name in this registry.

  name - the name for the remote reference to look up - `java.lang.String`

  returns: a reference to a remote object - `java.rmi.Remote`

  throws: java.rmi.NotBoundException - if name is not currently bound"
  (^java.rmi.Remote [^java.rmi.registry.Registry this ^java.lang.String name]
    (-> this (.lookup name))))

(defn bind
  "Binds a remote reference to the specified name in
   this registry.

  name - the name to associate with the remote reference - `java.lang.String`
  obj - a reference to a remote object (usually a stub) - `java.rmi.Remote`

  throws: java.rmi.AlreadyBoundException - if name is already bound"
  ([^java.rmi.registry.Registry this ^java.lang.String name ^java.rmi.Remote obj]
    (-> this (.bind name obj))))

(defn unbind
  "Removes the binding for the specified name in
   this registry.

  name - the name of the binding to remove - `java.lang.String`

  throws: java.rmi.NotBoundException - if name is not currently bound"
  ([^java.rmi.registry.Registry this ^java.lang.String name]
    (-> this (.unbind name))))

(defn rebind
  "Replaces the binding for the specified name in
   this registry with the supplied remote reference.  If there is
   an existing binding for the specified name, it is
   discarded.

  name - the name to associate with the remote reference - `java.lang.String`
  obj - a reference to a remote object (usually a stub) - `java.rmi.Remote`

  throws: java.rmi.RemoteException - if remote communication with the registry failed; if exception is a ServerException containing an AccessException, then the registry denies the caller access to perform this operation (if originating from a non-local host, for example)"
  ([^java.rmi.registry.Registry this ^java.lang.String name ^java.rmi.Remote obj]
    (-> this (.rebind name obj))))

(defn list
  "Returns an array of the names bound in this registry.  The
   array will contain a snapshot of the names bound in this
   registry at the time of the given invocation of this method.

  returns: an array of the names bound in this registry - `java.lang.String[]`

  throws: java.rmi.RemoteException - if remote communication with the registry failed; if exception is a ServerException containing an AccessException, then the registry denies the caller access to perform this operation"
  ([^java.rmi.registry.Registry this]
    (-> this (.list))))

