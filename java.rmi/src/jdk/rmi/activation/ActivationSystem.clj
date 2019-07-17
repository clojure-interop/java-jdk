(ns jdk.rmi.activation.ActivationSystem
  "The ActivationSystem provides a means for registering
  groups and `activatable` objects to be activated within those groups.
  The ActivationSystem works closely with the
  Activator, which activates objects registered via the
  ActivationSystem, and the ActivationMonitor,
  which obtains information about active and inactive objects,
  and inactive groups."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.rmi.activation ActivationSystem]))

(defn register-object
  "The registerObject method is used to register an
   activation descriptor, desc, and obtain an
   activation identifier for a activatable remote object. The
   ActivationSystem creates an
   ActivationID (a activation identifier) for the
   object specified by the descriptor, desc, and
   records, in stable storage, the activation descriptor and its
   associated identifier for later use. When the Activator
   receives an activate request for a specific identifier, it
   looks up the activation descriptor (registered previously) for
   the specified identifier and uses that information to activate
   the object.

  desc - the object's activation descriptor - `java.rmi.activation.ActivationDesc`

  returns: the activation id that can be used to activate the object - `java.rmi.activation.ActivationID`

  throws: java.rmi.activation.ActivationException - if registration fails (e.g., database update failure, etc)."
  ([^. this ^java.rmi.activation.ActivationDesc desc]
    (-> this (.registerObject desc))))

(defn unregister-object
  "Remove the activation id and associated descriptor previously
   registered with the ActivationSystem; the object
   can no longer be activated via the object's activation id.

  id - the object's activation id (from previous registration) - `java.rmi.activation.ActivationID`

  throws: java.rmi.activation.ActivationException - if unregister fails (e.g., database update failure, etc)."
  ([^. this ^java.rmi.activation.ActivationID id]
    (-> this (.unregisterObject id))))

(defn unregister-group
  "Remove the activation group. An activation group makes this call back
   to inform the activator that the group should be removed (destroyed).
   If this call completes successfully, objects can no longer be
   registered or activated within the group. All information of the
   group and its associated objects is removed from the system.

  id - the activation group's identifier - `java.rmi.activation.ActivationGroupID`

  throws: java.rmi.activation.ActivationException - if unregister fails (e.g., database update failure, etc)."
  ([^. this ^java.rmi.activation.ActivationGroupID id]
    (-> this (.unregisterGroup id))))

(defn shutdown
  "Shutdown the activation system. Destroys all groups spawned by
   the activation daemon and exits the activation daemon.

  throws: java.rmi.RemoteException - if failed to contact/shutdown the activation daemon"
  ([^. this]
    (-> this (.shutdown))))

(defn get-activation-desc
  "Returns the activation descriptor, for the object with the activation
   identifier, id.

  id - the activation identifier for the activatable object - `java.rmi.activation.ActivationID`

  returns: the activation descriptor - `java.rmi.activation.ActivationDesc`

  throws: java.rmi.activation.UnknownObjectException - if id is not registered"
  ([^. this ^java.rmi.activation.ActivationID id]
    (-> this (.getActivationDesc id))))

(defn set-activation-group-desc
  "Set the activation group descriptor, desc for the object
   with the activation group identifier, id. The change will
   take effect upon subsequent activation of the group.

  id - the activation group identifier for the activation group - `java.rmi.activation.ActivationGroupID`
  desc - the activation group descriptor for the activation group - `java.rmi.activation.ActivationGroupDesc`

  returns: the previous value of the activation group descriptor - `java.rmi.activation.ActivationGroupDesc`

  throws: java.rmi.activation.UnknownGroupException - the group associated with id is not a registered group"
  ([^. this ^java.rmi.activation.ActivationGroupID id ^java.rmi.activation.ActivationGroupDesc desc]
    (-> this (.setActivationGroupDesc id desc))))

(defn set-activation-desc
  "Set the activation descriptor, desc for the object with
   the activation identifier, id. The change will take
   effect upon subsequent activation of the object.

  id - the activation identifier for the activatable object - `java.rmi.activation.ActivationID`
  desc - the activation descriptor for the activatable object - `java.rmi.activation.ActivationDesc`

  returns: the previous value of the activation descriptor - `java.rmi.activation.ActivationDesc`

  throws: java.rmi.activation.UnknownGroupException - the group associated with desc is not a registered group"
  ([^. this ^java.rmi.activation.ActivationID id ^java.rmi.activation.ActivationDesc desc]
    (-> this (.setActivationDesc id desc))))

(defn register-group
  "Register the activation group. An activation group must be
   registered with the ActivationSystem before objects
   can be registered within that group.

  desc - the group's descriptor - `java.rmi.activation.ActivationGroupDesc`

  returns: an identifier for the group - `java.rmi.activation.ActivationGroupID`

  throws: java.rmi.activation.ActivationException - if group registration fails"
  ([^. this ^java.rmi.activation.ActivationGroupDesc desc]
    (-> this (.registerGroup desc))))

(defn get-activation-group-desc
  "Returns the activation group descriptor, for the group
   with the activation group identifier, id.

  id - the activation group identifier for the group - `java.rmi.activation.ActivationGroupID`

  returns: the activation group descriptor - `java.rmi.activation.ActivationGroupDesc`

  throws: java.rmi.activation.UnknownGroupException - if id is not registered"
  ([^. this ^java.rmi.activation.ActivationGroupID id]
    (-> this (.getActivationGroupDesc id))))

(defn active-group
  "Callback to inform activation system that group is now
   active. This call is made internally by the
   ActivationGroup.createGroup method to inform
   the ActivationSystem that the group is now
   active.

  id - the activation group's identifier - `java.rmi.activation.ActivationGroupID`
  group - the group's instantiator - `java.rmi.activation.ActivationInstantiator`
  incarnation - the group's incarnation number - `long`

  returns: monitor for activation group - `java.rmi.activation.ActivationMonitor`

  throws: java.rmi.activation.UnknownGroupException - if group is not registered"
  ([^. this ^java.rmi.activation.ActivationGroupID id ^java.rmi.activation.ActivationInstantiator group ^Long incarnation]
    (-> this (.activeGroup id group incarnation))))

