(ns javax.rmi.CORBA.PortableRemoteObjectDelegate
  "Supports delegation for method implementations in PortableRemoteObject.
  The delegate is a singleton instance of a class that implements this
  interface and provides a replacement implementation for all the
  methods of javax.rmi.PortableRemoteObject.

  Delegates are enabled by providing the delegate's class name as the
  value of the
  javax.rmi.CORBA.PortableRemoteObjectClass
  system property."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.rmi.CORBA PortableRemoteObjectDelegate]))

(defn export-object
  "Delegation call for PortableRemoteObject.exportObject(java.rmi.Remote).

  obj - `java.rmi.Remote`

  throws: java.rmi.RemoteException"
  ([this obj]
    (-> this (.exportObject obj))))

(defn to-stub
  "Delegation call for PortableRemoteObject.toStub(java.rmi.Remote).

  obj - `java.rmi.Remote`

  returns: `java.rmi.Remote`

  throws: java.rmi.NoSuchObjectException"
  ([this obj]
    (-> this (.toStub obj))))

(defn unexport-object
  "Delegation call for PortableRemoteObject.unexportObject(java.rmi.Remote).

  obj - `java.rmi.Remote`

  throws: java.rmi.NoSuchObjectException"
  ([this obj]
    (-> this (.unexportObject obj))))

(defn narrow
  "Delegation call for PortableRemoteObject.narrow(java.lang.Object, java.lang.Class).

  narrow-from - `java.lang.Object`
  narrow-to - `java.lang.Class`

  returns: `java.lang.Object`

  throws: java.lang.ClassCastException"
  ([this narrow-from narrow-to]
    (-> this (.narrow narrow-from narrow-to))))

(defn connect
  "Delegation call for PortableRemoteObject.connect(java.rmi.Remote, java.rmi.Remote).

  target - `java.rmi.Remote`
  source - `java.rmi.Remote`

  throws: java.rmi.RemoteException"
  ([this target source]
    (-> this (.connect target source))))

