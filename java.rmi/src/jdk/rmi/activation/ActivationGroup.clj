(ns jdk.rmi.activation.ActivationGroup
  "An ActivationGroup is responsible for creating new
  instances of `activatable` objects in its group, informing its
  ActivationMonitor when either: its object's become
  active or inactive, or the group as a whole becomes inactive.

  An ActivationGroup is initially created in one
  of several ways:
  as a side-effect of creating an ActivationDesc
      without an explicit ActivationGroupID for the
      first activatable object in the group, or
  via the ActivationGroup.createGroup method
  as a side-effect of activating the first object in a group
      whose ActivationGroupDesc was only registered.

  Only the activator can recreate an
  ActivationGroup.  The activator spawns, as needed, a
  separate VM (as a child process, for example) for each registered
  activation group and directs activation requests to the appropriate
  group. It is implementation specific how VMs are spawned. An
  activation group is created via the
  ActivationGroup.createGroup static method. The
  createGroup method has two requirements on the group
  to be created: 1) the group must be a concrete subclass of
  ActivationGroup, and 2) the group must have a
  constructor that takes two arguments:


   the group's ActivationGroupID, and
   the group's initialization data (in a
       java.rmi.MarshalledObject)

  When created, the default implementation of
  ActivationGroup will override the system properties
  with the properties requested when its
  ActivationGroupDesc was created, and will set a
  SecurityManager as the default system
  security manager.  If your application requires specific properties
  to be set when objects are activated in the group, the application
  should create a special Properties object containing
  these properties, then create an ActivationGroupDesc
  with the Properties object, and use
  ActivationGroup.createGroup before creating any
  ActivationDescs (before the default
  ActivationGroupDesc is created).  If your application
  requires the use of a security manager other than
  SecurityManager, in the
  ActivativationGroupDescriptor properties list you can set
  java.security.manager property to the name of the security
  manager you would like to install."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.rmi.activation ActivationGroup]))

(defn *create-group
  "Create and set the activation group for the current VM.  The
   activation group can only be set if it is not currently set.
   An activation group is set using the createGroup
   method when the Activator initiates the
   re-creation of an activation group in order to carry out
   incoming activate requests. A group must first be
   registered with the ActivationSystem before it can
   be created via this method.

   The group class specified by the
   ActivationGroupDesc must be a concrete subclass of
   ActivationGroup and have a public constructor that
   takes two arguments: the ActivationGroupID for the
   group and the MarshalledObject containing the
   group's initialization data (obtained from the
   ActivationGroupDesc.

   If the group class name specified in the
   ActivationGroupDesc is null, then
   this method will behave as if the group descriptor contained
   the name of the default activation group implementation class.

   Note that if your application creates its own custom
   activation group, a security manager must be set for that
   group.  Otherwise objects cannot be activated in the group.
   SecurityManager is set by default.

   If a security manager is already set in the group VM, this
   method first calls the security manager's
   checkSetFactory method.  This could result in a
   SecurityException. If your application needs to
   set a different security manager, you must ensure that the
   policy file specified by the group's
   ActivationGroupDesc grants the group the necessary
   permissions to set a new security manager.  (Note: This will be
   necessary if your group downloads and sets a security manager).

   After the group is created, the
   ActivationSystem is informed that the group is
   active by calling the activeGroup method which
   returns the ActivationMonitor for the group. The
   application need not call activeGroup
   independently since it is taken care of by this method.

   Once a group is created, subsequent calls to the
   currentGroupID method will return the identifier
   for this group until the group becomes inactive.

  id - the activation group's identifier - `java.rmi.activation.ActivationGroupID`
  desc - the activation group's descriptor - `java.rmi.activation.ActivationGroupDesc`
  incarnation - the group's incarnation number (zero on group's initial creation) - `long`

  returns: the activation group for the VM - `java.rmi.activation.ActivationGroup`

  throws: java.rmi.activation.ActivationException - if group already exists or if error occurs during group creation"
  ([id desc incarnation]
    (ActivationGroup/createGroup id desc incarnation)))

(defn *current-group-id
  "Returns the current activation group's identifier.  Returns null
   if no group is currently active for this VM.

  returns: the activation group's identifier - `java.rmi.activation.ActivationGroupID`

  throws: java.lang.UnsupportedOperationException - if and only if activation is not supported by this implementation"
  ([]
    (ActivationGroup/currentGroupID )))

(defn *set-system
  "Set the activation system for the VM.  The activation system can
   only be set it if no group is currently active. If the activation
   system is not set via this call, then the getSystem
   method attempts to obtain a reference to the
   ActivationSystem by looking up the name
   `java.rmi.activation.ActivationSystem` in the Activator's
   registry. By default, the port number used to look up the
   activation system is defined by
   ActivationSystem.SYSTEM_PORT. This port can be overridden
   by setting the property java.rmi.activation.port.

   If there is a security manager, this method first
   calls the security manager's checkSetFactory method.
   This could result in a SecurityException.

  system - remote reference to the ActivationSystem - `java.rmi.activation.ActivationSystem`

  throws: java.rmi.activation.ActivationException - if activation system is already set"
  ([system]
    (ActivationGroup/setSystem system)))

(defn *get-system
  "Returns the activation system for the VM. The activation system
   may be set by the setSystem method. If the
   activation system is not set via the setSystem
   method, then the getSystem method attempts to
   obtain a reference to the ActivationSystem by
   looking up the name `java.rmi.activation.ActivationSystem` in
   the Activator's registry. By default, the port number used to
   look up the activation system is defined by
   ActivationSystem.SYSTEM_PORT. This port can be
   overridden by setting the property
   java.rmi.activation.port.

  returns: the activation system for the VM/group - `java.rmi.activation.ActivationSystem`

  throws: java.rmi.activation.ActivationException - if activation system cannot be obtained or is not bound (means that it is not running)"
  ([]
    (ActivationGroup/getSystem )))

(defn inactive-object
  "The group's inactiveObject method is called
   indirectly via a call to the Activatable.inactive
   method. A remote object implementation must call
   Activatable's inactive method when
   that object deactivates (the object deems that it is no longer
   active). If the object does not call
   Activatable.inactive when it deactivates, the
   object will never be garbage collected since the group keeps
   strong references to the objects it creates.

   The group's inactiveObject method unexports the
   remote object from the RMI runtime so that the object can no
   longer receive incoming RMI calls. An object will only be unexported
   if the object has no pending or executing calls.
   The subclass of ActivationGroup must override this
   method and unexport the object.

   After removing the object from the RMI runtime, the group
   must inform its ActivationMonitor (via the monitor's
   inactiveObject method) that the remote object is
   not currently active so that the remote object will be
   re-activated by the activator upon a subsequent activation
   request.

   This method simply informs the group's monitor that the object
   is inactive.  It is up to the concrete subclass of ActivationGroup
   to fulfill the additional requirement of unexporting the object.

  id - the object's activation identifier - `java.rmi.activation.ActivationID`

  returns: true if the object was successfully deactivated; otherwise
           returns false. - `boolean`

  throws: java.rmi.activation.UnknownObjectException - if object is unknown (may already be inactive)"
  ([this id]
    (-> this (.inactiveObject id))))

(defn active-object
  "The group's activeObject method is called when an
   object is exported (either by Activatable object
   construction or an explicit call to
   Activatable.exportObject. The group must inform its
   ActivationMonitor that the object is active (via
   the monitor's activeObject method) if the group
   hasn't already done so.

  id - the object's identifier - `java.rmi.activation.ActivationID`
  obj - the remote object implementation - `java.rmi.Remote`

  throws: java.rmi.activation.UnknownObjectException - if object is not registered"
  ([this id obj]
    (-> this (.activeObject id obj))))

