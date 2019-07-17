(ns jdk.rmi.activation.ActivationGroupDesc
  "An activation group descriptor contains the information necessary to
  create/recreate an activation group in which to activate objects.
  Such a descriptor contains:
   the group's class name,
   the group's code location (the location of the group's class), and
   a `marshalled` object that can contain group specific
  initialization data.

  The group's class must be a concrete subclass of
  ActivationGroup. A subclass of
  ActivationGroup is created/recreated via the
  ActivationGroup.createGroup static method that invokes
  a special constructor that takes two arguments:

   the group's ActivationGroupID, and
   the group's initialization data (in a
  java.rmi.MarshalledObject)"
  (:refer-clojure :only [require comment defn ->])
  (:import [java.rmi.activation ActivationGroupDesc]))

(defn ->activation-group-desc
  "Constructor.

  Specifies an alternate group implementation and execution
   environment to be used for the group.

  class-name - the group's package qualified class name or null. A null group class name indicates the system's default ActivationGroup implementation. - `java.lang.String`
  location - the location from where to load the group's class - `java.lang.String`
  data - the group's initialization data contained in marshalled form (could contain properties, for example) - `java.rmi.MarshalledObject<?>`
  overrides - a properties map which will override those set by default in the subprocess environment (will be translated into -D options), or null. - `java.util.Properties`
  cmd - the controlling options for executing the VM in another process (or null). - `java.rmi.activation.ActivationGroupDesc.CommandEnvironment`"
  ([class-name location data overrides cmd]
    (new ActivationGroupDesc class-name location data overrides cmd))
  ([overrides cmd]
    (new ActivationGroupDesc overrides cmd)))

(defn get-class-name
  "Returns the group's class name (possibly null).  A
   null group class name indicates the system's default
   ActivationGroup implementation.

  returns: the group's class name - `java.lang.String`"
  ([this]
    (-> this (.getClassName))))

(defn get-location
  "Returns the group's code location.

  returns: the group's code location - `java.lang.String`"
  ([this]
    (-> this (.getLocation))))

(defn get-data
  "Returns the group's initialization data.

  returns: the group's initialization data - `java.rmi.MarshalledObject<?>`"
  ([this]
    (-> this (.getData))))

(defn get-property-overrides
  "Returns the group's property-override list.

  returns: the property-override list, or null - `java.util.Properties`"
  ([this]
    (-> this (.getPropertyOverrides))))

(defn get-command-environment
  "Returns the group's command-environment control object.

  returns: the command-environment object, or null - `java.rmi.activation.ActivationGroupDesc.CommandEnvironment`"
  ([this]
    (-> this (.getCommandEnvironment))))

(defn equals
  "Compares two activation group descriptors for content equality.

  obj - the Object to compare with - `java.lang.Object`

  returns: true if these Objects are equal; false otherwise. - `boolean`"
  ([this obj]
    (-> this (.equals obj))))

(defn hash-code
  "Produce identical numbers for similar ActivationGroupDescs.

  returns: an integer - `int`"
  ([this]
    (-> this (.hashCode))))

