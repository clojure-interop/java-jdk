(ns jdk.rmi.registry.LocateRegistry
  "LocateRegistry is used to obtain a reference to a bootstrap
  remote object registry on a particular host (including the local host), or
  to create a remote object registry that accepts calls on a specific port.

   Note that a getRegistry call does not actually make a
  connection to the remote host.  It simply creates a local reference to
  the remote registry and will succeed even if no registry is running on
  the remote host.  Therefore, a subsequent method invocation to a remote
  registry returned as a result of this method may fail."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.rmi.registry LocateRegistry]))

(defn *get-registry
  "Returns a locally created remote reference to the remote object
   Registry on the specified host and
   port.  Communication with this remote registry will
   use the supplied RMIClientSocketFactory csf
   to create Socket connections to the registry on the
   remote host and port.

  host - host for the remote registry - `java.lang.String`
  port - port on which the registry accepts requests - `int`
  csf - client-side Socket factory used to make connections to the registry. If csf is null, then the default client-side Socket factory will be used in the registry stub. - `java.rmi.server.RMIClientSocketFactory`

  returns: reference (a stub) to the remote registry - `java.rmi.registry.Registry`

  throws: java.rmi.RemoteException - if the reference could not be created"
  ([host port csf]
    (LocateRegistry/getRegistry host port csf))
  ([host port]
    (LocateRegistry/getRegistry host port))
  ([port]
    (LocateRegistry/getRegistry port))
  ([]
    (LocateRegistry/getRegistry )))

(defn *create-registry
  "Creates and exports a Registry instance on the local
   host that uses custom socket factories for communication with that
   instance.  The registry that is created listens for incoming
   requests on the given port using a
   ServerSocket created from the supplied
   RMIServerSocketFactory.

   The Registry instance is exported as if
   the static UnicastRemoteObject.exportObject method is invoked, passing the
   Registry instance, the specified port, the
   specified RMIClientSocketFactory, and the specified
   RMIServerSocketFactory as arguments, except that the
   Registry instance is exported with a well-known object
   identifier, an ObjID instance constructed with the value
   ObjID.REGISTRY_ID.

  port - port on which the registry accepts requests - `int`
  csf - client-side Socket factory used to make connections to the registry - `java.rmi.server.RMIClientSocketFactory`
  ssf - server-side ServerSocket factory used to accept connections to the registry - `java.rmi.server.RMIServerSocketFactory`

  returns: the registry - `java.rmi.registry.Registry`

  throws: java.rmi.RemoteException - if the registry could not be exported"
  ([port csf ssf]
    (LocateRegistry/createRegistry port csf ssf))
  ([port]
    (LocateRegistry/createRegistry port)))

