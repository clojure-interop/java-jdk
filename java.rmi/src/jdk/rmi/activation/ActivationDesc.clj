(ns jdk.rmi.activation.ActivationDesc
  "An activation descriptor contains the information necessary to
  activate an object:
   the object's group identifier,
   the object's fully-qualified class name,
   the object's code location (the location of the class), a codebase URL
  path,
   the object's restart `mode`, and,
   a `marshalled` object that can contain object specific
  initialization data.

  A descriptor registered with the activation system can be used to
  recreate/activate the object specified by the descriptor. The
  MarshalledObject in the object's descriptor is passed
  as the second argument to the remote object's constructor for
  object to use during reinitialization/activation."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.rmi.activation ActivationDesc]))

(defn ->activation-desc
  "Constructor.

  Constructs an object descriptor for an object whose class name
   is className that can be loaded from the
   code location and whose initialization
   information is data. All objects with the same
   groupID are activated in the same Java VM.

  group-id - the group's identifier (obtained from registering ActivationSystem.registerGroup method). The group indicates the VM in which the object should be activated. - `java.rmi.activation.ActivationGroupID`
  class-name - the object's fully package-qualified class name - `java.lang.String`
  location - the object's code location (from where the class is loaded) - `java.lang.String`
  data - the object's initialization (activation) data contained in marshalled form. - `java.rmi.MarshalledObject<?>`
  restart - if true, the object is restarted (reactivated) when either the activator is restarted or the object's activation group is restarted after an unexpected crash; if false, the object is only activated on demand. Specifying restart to be true does not force an initial immediate activation of a newly registered object; initial activation is lazy. - `boolean`

  throws: java.lang.IllegalArgumentException - if groupID is null"
  ([^java.rmi.activation.ActivationGroupID group-id ^java.lang.String class-name ^java.lang.String location ^java.rmi.MarshalledObject data ^Boolean restart]
    (new ActivationDesc group-id class-name location data restart))
  ([^java.lang.String class-name ^java.lang.String location ^java.rmi.MarshalledObject data ^Boolean restart]
    (new ActivationDesc class-name location data restart))
  ([^java.lang.String class-name ^java.lang.String location ^java.rmi.MarshalledObject data]
    (new ActivationDesc class-name location data)))

(defn get-group-id
  "Returns the group identifier for the object specified by this
   descriptor. A group provides a way to aggregate objects into a
   single Java virtual machine. RMI creates/activates objects with
   the same groupID in the same virtual machine.

  returns: the group identifier - `java.rmi.activation.ActivationGroupID`"
  (^java.rmi.activation.ActivationGroupID [^java.rmi.activation.ActivationDesc this]
    (-> this (.getGroupID))))

(defn get-class-name
  "Returns the class name for the object specified by this
   descriptor.

  returns: the class name - `java.lang.String`"
  (^java.lang.String [^java.rmi.activation.ActivationDesc this]
    (-> this (.getClassName))))

(defn get-location
  "Returns the code location for the object specified by
   this descriptor.

  returns: the code location - `java.lang.String`"
  (^java.lang.String [^java.rmi.activation.ActivationDesc this]
    (-> this (.getLocation))))

(defn get-data
  "Returns a `marshalled object` containing intialization/activation
   data for the object specified by this descriptor.

  returns: the object specific `initialization` data - `java.rmi.MarshalledObject<?>`"
  (^java.rmi.MarshalledObject [^java.rmi.activation.ActivationDesc this]
    (-> this (.getData))))

(defn get-restart-mode?
  "Returns the `restart` mode of the object associated with
   this activation descriptor.

  returns: true if the activatable object associated with this
   activation descriptor is restarted via the activation
   daemon when either the daemon comes up or the object's group
   is restarted after an unexpected crash; otherwise it returns false,
   meaning that the object is only activated on demand via a
   method call.  Note that if the restart mode is true, the
   activator does not force an initial immediate activation of
   a newly registered object;  initial activation is lazy. - `boolean`"
  (^Boolean [^java.rmi.activation.ActivationDesc this]
    (-> this (.getRestartMode))))

(defn equals
  "Compares two activation descriptors for content equality.

  obj - the Object to compare with - `java.lang.Object`

  returns: true if these Objects are equal; false otherwise. - `boolean`"
  (^Boolean [^java.rmi.activation.ActivationDesc this ^java.lang.Object obj]
    (-> this (.equals obj))))

(defn hash-code
  "Return the same hashCode for similar ActivationDescs.

  returns: an integer - `int`"
  (^Integer [^java.rmi.activation.ActivationDesc this]
    (-> this (.hashCode))))

