(ns javax.rmi.PortableRemoteObject
  "Server implementation objects may either inherit from
  javax.rmi.PortableRemoteObject or they may implement a remote interface
  and then use the exportObject method to register themselves as a server object.
  The toStub method takes a server implementation and returns a stub that
  can be used to access that server object.
  The connect method makes a Remote object ready for remote communication.
  The unexportObject method is used to deregister a server object, allowing it to become
  available for garbage collection.
  The narrow method takes an object reference or abstract interface type and
  attempts to narrow it to conform to
  the given interface. If the operation is successful the result will be an
  object of the specified type, otherwise an exception will be thrown."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.rmi PortableRemoteObject]))

(defn *export-object
  "Makes a server object ready to receive remote calls. Note
   that subclasses of PortableRemoteObject do not need to call this
   method, as it is called by the constructor.

  obj - the server object to export. - `java.rmi.Remote`

  throws: java.rmi.RemoteException - if export fails."
  ([^java.rmi.Remote obj]
    (PortableRemoteObject/exportObject obj)))

(defn *to-stub
  "Returns a stub for the given server object.

  obj - the server object for which a stub is required. Must either be a subclass of PortableRemoteObject or have been previously the target of a call to exportObject(java.rmi.Remote). - `java.rmi.Remote`

  returns: the most derived stub for the object. - `java.rmi.Remote`

  throws: java.rmi.NoSuchObjectException - if a stub cannot be located for the given server object."
  ([^java.rmi.Remote obj]
    (PortableRemoteObject/toStub obj)))

(defn *unexport-object
  "Deregisters a server object from the runtime, allowing the object to become
   available for garbage collection.

  obj - the object to unexport. - `java.rmi.Remote`

  throws: java.rmi.NoSuchObjectException - if the remote object is not currently exported."
  ([^java.rmi.Remote obj]
    (PortableRemoteObject/unexportObject obj)))

(defn *narrow
  "Checks to ensure that an object of a remote or abstract interface type
   can be cast to a desired type.

  narrow-from - the object to check. - `java.lang.Object`
  narrow-to - the desired type. - `java.lang.Class`

  returns: an object which can be cast to the desired type. - `java.lang.Object`

  throws: java.lang.ClassCastException - if narrowFrom cannot be cast to narrowTo."
  ([^java.lang.Object narrow-from ^java.lang.Class narrow-to]
    (PortableRemoteObject/narrow narrow-from narrow-to)))

(defn *connect
  "Makes a Remote object ready for remote communication. This normally
   happens implicitly when the object is sent or received as an argument
   on a remote method call, but in some circumstances it is useful to
   perform this action by making an explicit call.  See the
   Stub.connect(org.omg.CORBA.ORB) method for more information.

  target - the object to connect. - `java.rmi.Remote`
  source - a previously connected object. - `java.rmi.Remote`

  throws: java.rmi.RemoteException - if source is not connected or if target is already connected to a different ORB than source."
  ([^java.rmi.Remote target ^java.rmi.Remote source]
    (PortableRemoteObject/connect target source)))

