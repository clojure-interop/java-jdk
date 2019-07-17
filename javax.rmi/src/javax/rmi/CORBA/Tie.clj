(ns javax.rmi.CORBA.Tie
  "Defines methods which all RMI-IIOP server side ties must implement."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.rmi.CORBA Tie]))

(defn this-object
  "Returns an object reference for the target object represented by
   this tie.

  returns: an object reference for the target object. - `org.omg.CORBA.Object`"
  ([this]
    (-> this (.thisObject))))

(defn deactivate
  "Deactivates the target object represented by this tie.

  throws: java.rmi.NoSuchObjectException"
  ([this]
    (-> this (.deactivate))))

(defn orb
  "Sets the ORB for this tie.

  orb - the ORB. - `org.omg.CORBA.ORB`"
  ([this orb]
    (-> this (.orb orb)))
  ([this]
    (-> this (.orb))))

(defn set-target
  "Called by Util.registerTarget(javax.rmi.CORBA.Tie, java.rmi.Remote) to set the target
   for this tie.

  target - the object to use as the target for this tie. - `java.rmi.Remote`"
  ([this target]
    (-> this (.setTarget target))))

(defn get-target
  "Returns the target for this tie.

  returns: the target. - `java.rmi.Remote`"
  ([this]
    (-> this (.getTarget))))

