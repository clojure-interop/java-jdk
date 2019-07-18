(ns javax.rmi.CORBA.Tie
  "Defines methods which all RMI-IIOP server side ties must implement."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.rmi.CORBA Tie]))

(defn this-object
  "Returns an object reference for the target object represented by
   this tie.

  returns: an object reference for the target object. - `org.omg.CORBA.Object`"
  (^org.omg.CORBA.Object [^Tie this]
    (-> this (.thisObject))))

(defn deactivate
  "Deactivates the target object represented by this tie.

  throws: java.rmi.NoSuchObjectException"
  ([^Tie this]
    (-> this (.deactivate))))

(defn orb
  "Sets the ORB for this tie.

  orb - the ORB. - `org.omg.CORBA.ORB`"
  ([^Tie this ^org.omg.CORBA.ORB orb]
    (-> this (.orb orb)))
  (^org.omg.CORBA.ORB [^Tie this]
    (-> this (.orb))))

(defn set-target
  "Called by Util.registerTarget(javax.rmi.CORBA.Tie, java.rmi.Remote) to set the target
   for this tie.

  target - the object to use as the target for this tie. - `java.rmi.Remote`"
  ([^Tie this ^java.rmi.Remote target]
    (-> this (.setTarget target))))

(defn get-target
  "Returns the target for this tie.

  returns: the target. - `java.rmi.Remote`"
  (^java.rmi.Remote [^Tie this]
    (-> this (.getTarget))))

