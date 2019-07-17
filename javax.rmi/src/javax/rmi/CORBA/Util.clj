(ns javax.rmi.CORBA.Util
  "Provides utility methods that can be used by stubs and ties to
  perform common operations."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.rmi.CORBA Util]))

(defn *local?
  "The isLocal method has the same semantics as the
   ObjectImpl._is_local
   method, except that it can throw a RemoteException.

   The _is_local() method is provided so that stubs may determine if a
   particular object is implemented by a local servant and hence local
   invocation APIs may be used.

  stub - the stub to test. - `javax.rmi.CORBA.Stub`

  returns: The _is_local() method returns true if
   the servant incarnating the object is located in the same process as
   the stub and they both share the same ORB instance.  The _is_local()
   method returns false otherwise. The default behavior of _is_local() is
   to return false. - `boolean`

  throws: java.rmi.RemoteException - The Java to IDL specification does not specify the conditions that cause a RemoteException to be thrown."
  ([stub]
    (Util/isLocal stub)))

(defn *register-target
  "Registers a target for a tie. Adds the tie to an internal table and calls
   Tie.setTarget(java.rmi.Remote) on the tie object.

  tie - the tie to register. - `javax.rmi.CORBA.Tie`
  target - the target for the tie. - `java.rmi.Remote`"
  ([tie target]
    (Util/registerTarget tie target)))

(defn *copy-objects
  "Copies or connects an array of objects. Used by local stubs
   to copy any number of actual parameters, preserving sharing
   across parameters as necessary to support RMI semantics.

  obj - the objects to copy or connect. - `java.lang.Object[]`
  orb - the ORB. - `org.omg.CORBA.ORB`

  returns: the copied or connected objects. - `java.lang.Object[]`

  throws: java.rmi.RemoteException - if any object could not be copied or connected."
  ([obj orb]
    (Util/copyObjects obj orb)))

(defn *copy-object
  "Copies or connects an object. Used by local stubs to copy
   an actual parameter, result object, or exception.

  obj - the object to copy. - `java.lang.Object`
  orb - the ORB. - `org.omg.CORBA.ORB`

  returns: the copy or connected object. - `java.lang.Object`

  throws: java.rmi.RemoteException - if the object could not be copied or connected."
  ([obj orb]
    (Util/copyObject obj orb)))

(defn *write-any
  "Writes any java.lang.Object as a CORBA any.

  out - the stream in which to write the any. - `org.omg.CORBA.portable.OutputStream`
  obj - the object to write as an any. - `java.lang.Object`"
  ([out obj]
    (Util/writeAny out obj)))

(defn *write-abstract-object
  "Writes a java.lang.Object as either a value or a CORBA Object.
   If obj is a value object or a stub object, it is written to
   out.write_abstract_interface(java.lang.Object). If obj
  is
  an exported
   RMI-IIOP server object, the tie is found and wired to obj,
   then written to out.write_abstract_interface(java.lang.Object).

  out - the stream in which to write the object. - `org.omg.CORBA.portable.OutputStream`
  obj - the object to write. - `java.lang.Object`"
  ([out obj]
    (Util/writeAbstractObject out obj)))

(defn *unexport-object
  "Removes the associated tie from an internal table and calls Tie.deactivate()
   to deactivate the object.

  target - the object to unexport. - `java.rmi.Remote`

  throws: java.rmi.NoSuchObjectException"
  ([target]
    (Util/unexportObject target)))

(defn *read-any
  "Reads a java.lang.Object as a CORBA any.

  in - the stream from which to read the any. - `org.omg.CORBA.portable.InputStream`

  returns: the object read from the stream. - `java.lang.Object`"
  ([in]
    (Util/readAny in)))

(defn *load-class
  "Returns a class instance for the specified class.
   The spec for this method is the `Java to IDL language
   mapping`, ptc/00-01-06.
   In Java SE Platform, this method works as follows:
   Find the first non-null ClassLoader on the
   call stack and attempt to load the class using this
   ClassLoader.
   If the first step fails, and if remoteCodebase
   is non-null and
   useCodebaseOnly is false, then call
   java.rmi.server.RMIClassLoader.loadClass(remoteCodebase, className).
   If remoteCodebase is null or useCodebaseOnly
   is true, then call java.rmi.server.RMIClassLoader.loadClass(className).
   If a class was not successfully loaded by step 1, 2, or 3,
   and loader is non-null, then call loader.loadClass(className).
   If a class was successfully loaded by step 1, 2, 3, or 4, then
    return the loaded class, else throw ClassNotFoundException.

  class-name - the name of the class. - `java.lang.String`
  remote-codebase - a space-separated list of URLs at which the class might be found. May be null. - `java.lang.String`
  loader - a ClassLoader that may be used to load the class if all other methods fail. - `java.lang.ClassLoader`

  returns: the Class object representing the loaded class. - `java.lang.Class`

  throws: java.lang.ClassNotFoundException - if class cannot be loaded."
  ([class-name remote-codebase loader]
    (Util/loadClass class-name remote-codebase loader)))

(defn *create-value-handler
  "Returns a singleton instance of a class that implements the
   ValueHandler interface.

  returns: a class which implements the ValueHandler interface. - `javax.rmi.CORBA.ValueHandler`"
  ([]
    (Util/createValueHandler )))

(defn *wrap-exception
  "Wraps an exception thrown by an implementation
   method.  It returns the corresponding client-side exception.

  orig - the exception to wrap. - `java.lang.Throwable`

  returns: the wrapped exception. - `java.rmi.RemoteException`"
  ([orig]
    (Util/wrapException orig)))

(defn *get-tie
  "Returns the tie (if any) for a given target object.

  target - `java.rmi.Remote`

  returns: the tie or null if no tie is registered for the given target. - `javax.rmi.CORBA.Tie`"
  ([target]
    (Util/getTie target)))

(defn *write-remote-object
  "Writes a java.lang.Object as a CORBA Object. If obj is
   an exported RMI-IIOP server object, the tie is found
   and wired to obj, then written to
   out.write_Object(org.omg.CORBA.Object).
   If obj is a CORBA Object, it is written to
   out.write_Object(org.omg.CORBA.Object).

  out - the stream in which to write the object. - `org.omg.CORBA.portable.OutputStream`
  obj - the object to write. - `java.lang.Object`"
  ([out obj]
    (Util/writeRemoteObject out obj)))

(defn *get-codebase
  "Returns the codebase, if any, for the given class.

  clz - the class to get a codebase for. - `java.lang.Class`

  returns: a space-separated list of URLs, or null. - `java.lang.String`"
  ([clz]
    (Util/getCodebase clz)))

(defn *map-system-exception
  "Maps a SystemException to a RemoteException.

  ex - the SystemException to map. - `org.omg.CORBA.SystemException`

  returns: the mapped exception. - `java.rmi.RemoteException`"
  ([ex]
    (Util/mapSystemException ex)))

