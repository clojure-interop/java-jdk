(ns jdk.rmi.server.RemoteObject
  "The RemoteObject class implements the
  java.lang.Object behavior for remote objects.
  RemoteObject provides the remote semantics of Object by
  implementing methods for hashCode, equals, and toString."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.rmi.server RemoteObject]))

(defn *to-stub
  "Returns the stub for the remote object obj passed
   as a parameter. This operation is only valid after
   the object has been exported.

  obj - the remote object whose stub is needed - `java.rmi.Remote`

  returns: the stub for the remote object, obj. - `java.rmi.Remote`

  throws: java.rmi.NoSuchObjectException - if the stub for the remote object could not be found."
  (^java.rmi.Remote [^java.rmi.Remote obj]
    (RemoteObject/toStub obj)))

(defn get-ref
  "Returns the remote reference for the remote object.

   Note: The object returned from this method may be an instance of
   an implementation-specific class.  The RemoteObject
   class ensures serialization portability of its instances' remote
   references through the behavior of its custom
   writeObject and readObject methods.  An
   instance of RemoteRef should not be serialized outside
   of its RemoteObject wrapper instance or the result may
   be unportable.

  returns: remote reference for the remote object - `java.rmi.server.RemoteRef`"
  (^java.rmi.server.RemoteRef [^java.rmi.server.RemoteObject this]
    (-> this (.getRef))))

(defn hash-code
  "Returns a hashcode for a remote object.  Two remote object stubs
   that refer to the same remote object will have the same hash code
   (in order to support remote objects as keys in hash tables).

  returns: a hash code value for this object. - `int`"
  (^Integer [^java.rmi.server.RemoteObject this]
    (-> this (.hashCode))))

(defn equals
  "Compares two remote objects for equality.
   Returns a boolean that indicates whether this remote object is
   equivalent to the specified Object. This method is used when a
   remote object is stored in a hashtable.
   If the specified Object is not itself an instance of RemoteObject,
   then this method delegates by returning the result of invoking the
   equals method of its parameter with this remote object
   as the argument.

  obj - the Object to compare with - `java.lang.Object`

  returns: true if these Objects are equal; false otherwise. - `boolean`"
  (^Boolean [^java.rmi.server.RemoteObject this ^java.lang.Object obj]
    (-> this (.equals obj))))

(defn to-string
  "Returns a String that represents the value of this remote object.

  returns: a string representation of the object. - `java.lang.String`"
  (^java.lang.String [^java.rmi.server.RemoteObject this]
    (-> this (.toString))))

