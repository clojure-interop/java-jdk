(ns jdk.rmi.activation.ActivationID
  "Activation makes use of special identifiers to denote remote
  objects that can be activated over time. An activation identifier
  (an instance of the class ActivationID) contains several
  pieces of information needed for activating an object:

   a remote reference to the object's activator (a RemoteRef
  instance), and
   a unique identifier (a UID
  instance) for the object.

  An activation identifier for an object can be obtained by registering
  an object with the activation system. Registration is accomplished
  in a few ways:
  via the Activatable.register method
  via the first Activatable constructor (that takes
  three arguments and both registers and exports the object, and
  via the first Activatable.exportObject method
  that takes the activation descriptor, object and port as arguments;
  this method both registers and exports the object."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.rmi.activation ActivationID]))

(defn ->activation-id
  "Constructor.

  The constructor for ActivationID takes a single
   argument, activator, that specifies a remote reference to the
   activator responsible for activating the object associated with
   this identifier. An instance of ActivationID is globally
   unique.

  activator - reference to the activator responsible for activating the object - `java.rmi.activation.Activator`

  throws: java.lang.UnsupportedOperationException - if and only if activation is not supported by this implementation"
  ([^java.rmi.activation.Activator activator]
    (new ActivationID activator)))

(defn activate
  "Activate the object for this id.

  force - if true, forces the activator to contact the group when activating the object (instead of returning a cached reference); if false, returning a cached value is acceptable. - `boolean`

  returns: the reference to the active remote object - `java.rmi.Remote`

  throws: java.rmi.activation.ActivationException - if activation fails"
  (^java.rmi.Remote [^java.rmi.activation.ActivationID this ^Boolean force]
    (-> this (.activate force))))

(defn hash-code
  "Returns a hashcode for the activation id.  Two identifiers that
   refer to the same remote object will have the same hash code.

  returns: a hash code value for this object. - `int`"
  (^Integer [^java.rmi.activation.ActivationID this]
    (-> this (.hashCode))))

(defn equals
  "Compares two activation ids for content equality.
   Returns true if both of the following conditions are true:
   1) the unique identifiers equivalent (by content), and
   2) the activator specified in each identifier
      refers to the same remote object.

  obj - the Object to compare with - `java.lang.Object`

  returns: true if these Objects are equal; false otherwise. - `boolean`"
  (^Boolean [^java.rmi.activation.ActivationID this ^java.lang.Object obj]
    (-> this (.equals obj))))

