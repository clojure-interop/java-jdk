(ns jdk.rmi.activation.ActivationGroupID
  "The identifier for a registered activation group serves several
  purposes:
  identifies the group uniquely within the activation system, and
  contains a reference to the group's activation system so that the
  group can contact its activation system when necessary.

  The ActivationGroupID is returned from the call to
  ActivationSystem.registerGroup and is used to identify
  the group within the activation system. This group id is passed
  as one of the arguments to the activation group's special constructor
  when an activation group is created/recreated."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.rmi.activation ActivationGroupID]))

(defn ->activation-group-id
  "Constructor.

  Constructs a unique group id.

  system - the group's activation system - `java.rmi.activation.ActivationSystem`

  throws: java.lang.UnsupportedOperationException - if and only if activation is not supported by this implementation"
  ([^java.rmi.activation.ActivationSystem system]
    (new ActivationGroupID system)))

(defn get-system
  "Returns the group's activation system.

  returns: the group's activation system - `java.rmi.activation.ActivationSystem`"
  (^java.rmi.activation.ActivationSystem [^java.rmi.activation.ActivationGroupID this]
    (-> this (.getSystem))))

(defn hash-code
  "Returns a hashcode for the group's identifier.  Two group
   identifiers that refer to the same remote group will have the
   same hash code.

  returns: a hash code value for this object. - `int`"
  (^Integer [^java.rmi.activation.ActivationGroupID this]
    (-> this (.hashCode))))

(defn equals
  "Compares two group identifiers for content equality.
   Returns true if both of the following conditions are true:
   1) the unique identifiers are equivalent (by content), and
   2) the activation system specified in each
      refers to the same remote object.

  obj - the Object to compare with - `java.lang.Object`

  returns: true if these Objects are equal; false otherwise. - `boolean`"
  (^Boolean [^java.rmi.activation.ActivationGroupID this ^java.lang.Object obj]
    (-> this (.equals obj))))

