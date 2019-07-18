(ns javax.rmi.CORBA.StubDelegate
  "Supports delegation for method implementations in Stub.
  A delegate is an instance of a class that implements this
  interface and provides a replacement implementation for all the
  methods of javax.rmi.CORBA.Stub.  If delegation is
  enabled, each stub has an associated delegate.

  Delegates are enabled by providing the delegate's class name as the
  value of the
  javax.rmi.CORBA.StubClass
  system property."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.rmi.CORBA StubDelegate]))

(defn hash-code
  "Delegation call for Stub.hashCode().

  self - `javax.rmi.CORBA.Stub`

  returns: `int`"
  (^Integer [^StubDelegate this ^javax.rmi.CORBA.Stub self]
    (-> this (.hashCode self))))

(defn equals
  "Delegation call for Stub.equals(java.lang.Object).

  self - `javax.rmi.CORBA.Stub`
  obj - `java.lang.Object`

  returns: `boolean`"
  (^Boolean [^StubDelegate this ^javax.rmi.CORBA.Stub self ^java.lang.Object obj]
    (-> this (.equals self obj))))

(defn to-string
  "Delegation call for Stub.toString().

  self - `javax.rmi.CORBA.Stub`

  returns: `java.lang.String`"
  (^java.lang.String [^StubDelegate this ^javax.rmi.CORBA.Stub self]
    (-> this (.toString self))))

(defn connect
  "Delegation call for Stub.connect(org.omg.CORBA.ORB).

  self - `javax.rmi.CORBA.Stub`
  orb - `org.omg.CORBA.ORB`

  throws: java.rmi.RemoteException"
  ([^StubDelegate this ^javax.rmi.CORBA.Stub self ^org.omg.CORBA.ORB orb]
    (-> this (.connect self orb))))

(defn read-object
  "Delegation call for
   Stub.readObject(java.io.ObjectInputStream).

  self - `javax.rmi.CORBA.Stub`
  s - `java.io.ObjectInputStream`

  throws: java.io.IOException"
  ([^StubDelegate this ^javax.rmi.CORBA.Stub self ^java.io.ObjectInputStream s]
    (-> this (.readObject self s))))

(defn write-object
  "Delegation call for
   Stub.writeObject(java.io.ObjectOutputStream).

  self - `javax.rmi.CORBA.Stub`
  s - `java.io.ObjectOutputStream`

  throws: java.io.IOException"
  ([^StubDelegate this ^javax.rmi.CORBA.Stub self ^java.io.ObjectOutputStream s]
    (-> this (.writeObject self s))))

