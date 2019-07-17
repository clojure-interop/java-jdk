(ns jdk.rmi.MarshalledObject
  "A MarshalledObject contains a byte stream with the serialized
  representation of an object given to its constructor.  The get
  method returns a new copy of the original object, as deserialized from
  the contained byte stream.  The contained object is serialized and
  deserialized with the same serialization semantics used for marshaling
  and unmarshaling parameters and return values of RMI calls:  When the
  serialized form is created:


   classes are annotated with a codebase URL from where the class
       can be loaded (if available), and
   any remote object in the MarshalledObject is
       represented by a serialized instance of its stub.


  When copy of the object is retrieved (via the get method),
  if the class is not available locally, it will be loaded from the
  appropriate location (specified the URL annotated with the class descriptor
  when the class was serialized.

  MarshalledObject facilitates passing objects in RMI calls
  that are not automatically deserialized immediately by the remote peer."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.rmi MarshalledObject]))

(defn ->marshalled-object
  "Constructor.

  Creates a new MarshalledObject that contains the
   serialized representation of the current state of the supplied object.
   The object is serialized with the semantics used for marshaling
   parameters for RMI calls.

  obj - the object to be serialized (must be serializable) - `MarshalledObject.T`

  throws: java.io.IOException - if an IOException occurs; an IOException may occur if obj is not serializable."
  ([^MarshalledObject.T obj]
    (new MarshalledObject obj)))

(defn get
  "Returns a new copy of the contained marshalledobject.  The internal
   representation is deserialized with the semantics used for
   unmarshaling parameters for RMI calls.

  returns: a copy of the contained object - `MarshalledObject.T`

  throws: java.io.IOException - if an IOException occurs while deserializing the object from its internal representation."
  (^MarshalledObject.T [^java.rmi.MarshalledObject this]
    (-> this (.get))))

(defn hash-code
  "Return a hash code for this MarshalledObject.

  returns: a hash code - `int`"
  (^Integer [^java.rmi.MarshalledObject this]
    (-> this (.hashCode))))

(defn equals
  "Compares this MarshalledObject to another object.
   Returns true if and only if the argument refers to a
   MarshalledObject that contains exactly the same
   serialized representation of an object as this one does. The
   comparison ignores any class codebase annotation, meaning that
   two objects are equivalent if they have the same serialized
   representation except for the codebase of each class
   in the serialized representation.

  obj - the object to compare with this MarshalledObject - `java.lang.Object`

  returns: true if the argument contains an equivalent
   serialized object; false otherwise - `boolean`"
  (^Boolean [^java.rmi.MarshalledObject this ^java.lang.Object obj]
    (-> this (.equals obj))))

