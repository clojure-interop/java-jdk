(ns jdk.rmi.activation.Activatable
  "The Activatable class provides support for remote
  objects that require persistent access over time and that
  can be activated by the system.

  For the constructors and static exportObject methods,
  the stub for a remote object being exported is obtained as described in
  UnicastRemoteObject.

  An attempt to serialize explicitly an instance of this class will
  fail."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.rmi.activation Activatable]))

(defn *register
  "Register an object descriptor for an activatable remote
   object so that is can be activated on demand.

  desc - the object's descriptor - `java.rmi.activation.ActivationDesc`

  returns: the stub for the activatable remote object - `java.rmi.Remote`

  throws: java.rmi.activation.UnknownGroupException - if group id in desc is not registered with the activation system"
  ([^java.rmi.activation.ActivationDesc desc]
    (Activatable/register desc)))

(defn *inactive
  "Informs the system that the object with the corresponding activation
   id is currently inactive. If the object is currently
   active, the object is `unexported` from the RMI runtime (only if
   there are no pending or in-progress calls)
   so the that it can no longer receive incoming calls. This call
   informs this VM's ActivationGroup that the object is inactive,
   that, in turn, informs its ActivationMonitor. If this call
   completes successfully, a subsequent activate request to the activator
   will cause the object to reactivate. The operation may still
   succeed if the object is considered active but has already
   unexported itself.

  id - the object's activation identifier - `java.rmi.activation.ActivationID`

  returns: true if the operation succeeds (the operation will
   succeed if the object in currently known to be active and is
   either already unexported or is currently exported and has no
   pending/executing calls); false is returned if the object has
   pending/executing calls in which case it cannot be deactivated - `boolean`

  throws: java.rmi.activation.UnknownObjectException - if object is not known (it may already be inactive)"
  ([^java.rmi.activation.ActivationID id]
    (Activatable/inactive id)))

(defn *unregister
  "Revokes previous registration for the activation descriptor
   associated with id. An object can no longer be
   activated via that id.

  id - the object's activation identifier - `java.rmi.activation.ActivationID`

  throws: java.rmi.activation.UnknownObjectException - if object (id) is unknown"
  ([^java.rmi.activation.ActivationID id]
    (Activatable/unregister id)))

(defn *export-object
  "Registers an activation descriptor (with the specified location,
   data, and restart mode) for the specified object, and exports that
   object with the specified port, and the specified client and server
   socket factories.

   Note: Using this method (as well as the
   Activatable constructors that both register and export
   an activatable remote object) is strongly discouraged because the
   actions of registering and exporting the remote object are
   not guaranteed to be atomic.  Instead, an application should
   register an activation descriptor and export a remote object
   separately, so that exceptions can be handled properly.

   This method first registers an activation descriptor for the
   specified object as follows. It obtains the activation system by
   invoking the method ActivationGroup.getSystem.  This method then obtains an ActivationID for the object by invoking the activation system's
   registerObject method with
   an ActivationDesc constructed with the specified object's
   class name, and the specified location, data, and restart mode.  If
   an exception occurs obtaining the activation system or registering
   the activation descriptor, that exception is thrown to the caller.

   Next, this method exports the object by invoking the exportObject method with the specified remote object, the
   activation identifier obtained from registration, the specified
   port, and the specified client and server socket factories.  If an
   exception occurs exporting the object, this method attempts to
   unregister the activation identifier (obtained from registration) by
   invoking the activation system's unregisterObject method with the
   activation identifier.  If an exception occurs unregistering the
   identifier, that exception is ignored, and the original exception
   that occurred exporting the object is thrown to the caller.

   Finally, this method invokes the activeObject method on the activation
   group in this VM with the activation identifier and the specified
   remote object, and returns the activation identifier to the caller.

  obj - the object being exported - `java.rmi.Remote`
  location - the object's code location - `java.lang.String`
  data - the object's bootstrapping data - `java.rmi.MarshalledObject<?>`
  restart - if true, the object is restarted (reactivated) when either the activator is restarted or the object's activation group is restarted after an unexpected crash; if false, the object is only activated on demand. Specifying restart to be true does not force an initial immediate activation of a newly registered object; initial activation is lazy. - `boolean`
  port - the port on which the object is exported (an anonymous port is used if port=0) - `int`
  csf - the client-side socket factory for making calls to the remote object - `java.rmi.server.RMIClientSocketFactory`
  ssf - the server-side socket factory for receiving remote calls - `java.rmi.server.RMIServerSocketFactory`

  returns: the activation identifier obtained from registering the
   descriptor with the activation system - `java.rmi.activation.ActivationID`

  throws: java.rmi.activation.ActivationException - if activation group is not active"
  ([^java.rmi.Remote obj ^java.lang.String location ^java.rmi.MarshalledObject data ^Boolean restart ^Integer port ^java.rmi.server.RMIClientSocketFactory csf ^java.rmi.server.RMIServerSocketFactory ssf]
    (Activatable/exportObject obj location data restart port csf ssf))
  ([^java.rmi.Remote obj ^java.lang.String location ^java.rmi.MarshalledObject data ^Boolean restart ^Integer port]
    (Activatable/exportObject obj location data restart port))
  ([^java.rmi.Remote obj ^java.rmi.activation.ActivationID id ^Integer port]
    (Activatable/exportObject obj id port)))

(defn *unexport-object
  "Remove the remote object, obj, from the RMI runtime. If
   successful, the object can no longer accept incoming RMI calls.
   If the force parameter is true, the object is forcibly unexported
   even if there are pending calls to the remote object or the
   remote object still has calls in progress.  If the force
   parameter is false, the object is only unexported if there are
   no pending or in progress calls to the object.

  obj - the remote object to be unexported - `java.rmi.Remote`
  force - if true, unexports the object even if there are pending or in-progress calls; if false, only unexports the object if there are no pending or in-progress calls - `boolean`

  returns: true if operation is successful, false otherwise - `boolean`

  throws: java.rmi.NoSuchObjectException - if the remote object is not currently exported"
  ([^java.rmi.Remote obj ^Boolean force]
    (Activatable/unexportObject obj force)))

