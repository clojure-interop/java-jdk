(ns jdk.rmi.server.RemoteRef
  "RemoteRef represents the handle for a remote object. A
  RemoteStub uses a remote reference to carry out a
  remote method invocation to a remote object."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.rmi.server RemoteRef]))

(defn invoke
  "Invoke a method. This form of delegating method invocation
   to the reference allows the reference to take care of
   setting up the connection to the remote host, marshaling
   some representation for the method and parameters, then
   communicating the method invocation to the remote host.
   This method either returns the result of a method invocation
   on the remote object which resides on the remote host or
   throws a RemoteException if the call failed or an
   application-level exception if the remote invocation throws
   an exception.

  obj - the object that contains the RemoteRef (e.g., the RemoteStub for the object. - `java.rmi.Remote`
  method - the method to be invoked - `java.lang.reflect.Method`
  params - the parameter list - `java.lang.Object[]`
  opnum - a hash that may be used to represent the method - `long`

  returns: result of remote method invocation - `java.lang.Object`

  throws: java.lang.Exception - if any exception occurs during remote method invocation"
  (^java.lang.Object [^RemoteRef this ^java.rmi.Remote obj ^java.lang.reflect.Method method params ^Long opnum]
    (-> this (.invoke obj method params opnum)))
  ([^RemoteRef this ^java.rmi.server.RemoteCall call]
    (-> this (.invoke call))))

(defn new-call
  "Deprecated. 1.2 style stubs no longer use this method. Instead of
   using a sequence of method calls on the stub's the remote reference
   (newCall, invoke, and done), a
   stub uses a single method, invoke(Remote, Method, Object[],
   int), on the remote reference to carry out parameter
   marshalling, remote method executing and unmarshalling of the return
   value.

  obj - remote stub through which to make call - `java.rmi.server.RemoteObject`
  op - array of stub operations - `java.rmi.server.Operation[]`
  opnum - operation number - `int`
  hash - stub/skeleton interface hash - `long`

  returns: call object representing remote call - `.rmi.server.RemoteCall`

  throws: java.rmi.RemoteException - if failed to initiate new remote call"
  (^.rmi.server.RemoteCall [^RemoteRef this ^java.rmi.server.RemoteObject obj op ^Integer opnum ^Long hash]
    (-> this (.newCall obj op opnum hash))))

(defn done
  "Deprecated. 1.2 style stubs no longer use this method. Instead of
   using a sequence of method calls to the remote reference
   (newCall, invoke, and done), a
   stub uses a single method, invoke(Remote, Method, Object[],
   int), on the remote reference to carry out parameter
   marshalling, remote method executing and unmarshalling of the return
   value.

  call - object representing remote call - `java.rmi.server.RemoteCall`

  throws: java.rmi.RemoteException - if remote error occurs during call cleanup"
  ([^RemoteRef this ^java.rmi.server.RemoteCall call]
    (-> this (.done call))))

(defn get-ref-class
  "Returns the class name of the ref type to be serialized onto
   the stream 'out'.

  out - the output stream to which the reference will be serialized - `java.io.ObjectOutput`

  returns: the class name (without package qualification) of the reference
   type - `java.lang.String`"
  (^java.lang.String [^RemoteRef this ^java.io.ObjectOutput out]
    (-> this (.getRefClass out))))

(defn remote-hash-code
  "Returns a hashcode for a remote object.  Two remote object stubs
   that refer to the same remote object will have the same hash code
   (in order to support remote objects as keys in hash tables).

  returns: remote object hashcode - `int`"
  (^Integer [^RemoteRef this]
    (-> this (.remoteHashCode))))

(defn remote-equals
  "Compares two remote objects for equality.
   Returns a boolean that indicates whether this remote object is
   equivalent to the specified Object. This method is used when a
   remote object is stored in a hashtable.

  obj - the Object to compare with - `java.rmi.server.RemoteRef`

  returns: true if these Objects are equal; false otherwise. - `boolean`"
  (^Boolean [^RemoteRef this ^java.rmi.server.RemoteRef obj]
    (-> this (.remoteEquals obj))))

(defn remote-to-string
  "Returns a String that represents the reference of this remote
   object.

  returns: string representing remote object reference - `java.lang.String`"
  (^java.lang.String [^RemoteRef this]
    (-> this (.remoteToString))))

