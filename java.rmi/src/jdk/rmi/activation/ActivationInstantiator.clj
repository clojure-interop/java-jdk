(ns jdk.rmi.activation.ActivationInstantiator
  "An ActivationInstantiator is responsible for creating
  instances of \"activatable\" objects. A concrete subclass of
  ActivationGroup implements the newInstance
  method to handle creating objects within the group."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.rmi.activation ActivationInstantiator]))

(defn new-instance
  "The activator calls an instantiator's newInstance
   method in order to recreate in that group an object with the
   activation identifier, id, and descriptor,
   desc. The instantiator is responsible for:

    determining the class for the object using the descriptor's
   getClassName method,

    loading the class from the code location obtained from the
   descriptor (using the getLocation method),

    creating an instance of the class by invoking the special
   \"activation\" constructor of the object's class that takes two
   arguments: the object's ActivationID, and the
   MarshalledObject containing object specific
   initialization data, and

    returning a MarshalledObject containing the stub for the
   remote object it created

  id - the object's activation identifier - `java.rmi.activation.ActivationID`
  desc - the object's descriptor - `java.rmi.activation.ActivationDesc`

  returns: a marshalled object containing the serialized
   representation of remote object's stub - `java.rmi.MarshalledObject<? extends java.rmi.Remote>`

  throws: java.rmi.activation.ActivationException - if object activation fails"
  ([^ActivationInstantiator this ^java.rmi.activation.ActivationID id ^java.rmi.activation.ActivationDesc desc]
    (-> this (.newInstance id desc))))

