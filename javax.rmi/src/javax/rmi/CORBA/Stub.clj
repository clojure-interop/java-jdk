(ns javax.rmi.CORBA.Stub
  "Base class from which all RMI-IIOP stubs must inherit."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.rmi.CORBA Stub]))

(defn ->stub
  "Constructor."
  ([]
    (new Stub )))

(defn hash-code
  "Returns a hash code value for the object which is the same for all stubs
   that represent the same remote object.

  returns: the hash code value. - `int`"
  ([this]
    (-> this (.hashCode))))

(defn equals
  "Compares two stubs for equality. Returns true when used to compare stubs
   that represent the same remote object, and false otherwise.

  obj - the reference object with which to compare. - `java.lang.Object`

  returns: true if this object is the same as the obj
            argument; false otherwise. - `boolean`"
  ([this obj]
    (-> this (.equals obj))))

(defn to-string
  "Returns a string representation of this stub. Returns the same string
   for all stubs that represent the same remote object.

  returns: a string representation of this stub. - `java.lang.String`"
  ([this]
    (-> this (.toString))))

(defn connect
  "Connects this stub to an ORB. Required after the stub is deserialized
   but not after it is demarshalled by an ORB stream. If an unconnected
   stub is passed to an ORB stream for marshalling, it is implicitly
   connected to that ORB. Application code should not call this method
   directly, but should call the portable wrapper method
   PortableRemoteObject.connect(java.rmi.Remote, java.rmi.Remote).

  orb - the ORB to connect to. - `org.omg.CORBA.ORB`

  throws: java.rmi.RemoteException - if the stub is already connected to a different ORB, or if the stub does not represent an exported remote or local object."
  ([this orb]
    (-> this (.connect orb))))

