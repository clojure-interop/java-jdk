(ns jdk.rmi.server.ObjID
  "An ObjID is used to identify a remote object exported
  to an RMI runtime.  When a remote object is exported, it is assigned
  an object identifier either implicitly or explicitly, depending on
  the API used to export.

  The ObjID() constructor can be used to generate a unique
  object identifier.  Such an ObjID is unique over time
  with respect to the host it is generated on.

  The ObjID(int) constructor can be used to create a
  `well-known` object identifier.  The scope of a well-known
  ObjID depends on the RMI runtime it is exported to.

  An ObjID instance contains an object number (of type
  long) and an address space identifier (of type
  UID).  In a unique ObjID, the address space
  identifier is unique with respect to a given host over time.  In a
  well-known ObjID, the address space identifier is
  equivalent to one returned by invoking the UID.UID(short)
  constructor with the value zero.

  If the system property java.rmi.server.randomIDs
  is defined to equal the string `true` (case insensitive),
  then the ObjID() constructor will use a cryptographically
  strong random number generator to choose the object number of the
  returned ObjID."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.rmi.server ObjID]))

(defn ->obj-id
  "Constructor.

  Creates a `well-known` object identifier.

   An ObjID created via this constructor will not
   clash with any ObjIDs generated via the no-arg
   constructor.

  obj-num - object number for well-known object identifier - `int`"
  ([^Integer obj-num]
    (new ObjID obj-num))
  ([]
    (new ObjID )))

(def *-registry-id
  "Static Constant.

  Object number for well-known ObjID of the registry.

  type: int"
  ObjID/REGISTRY_ID)

(def *-activator-id
  "Static Constant.

  Object number for well-known ObjID of the activator.

  type: int"
  ObjID/ACTIVATOR_ID)

(def *-dgc-id
  "Static Constant.

  Object number for well-known ObjID of
   the distributed garbage collector.

  type: int"
  ObjID/DGC_ID)

(defn *read
  "Constructs and returns a new ObjID instance by
   unmarshalling a binary representation from an
   ObjectInput instance.

   Specifically, this method first invokes the given stream's
   DataInput.readLong() method to read an object number,
   then it invokes UID.read(DataInput) with the
   stream to read an address space identifier, and then it
   creates and returns a new ObjID instance that
   contains the object number and address space identifier that
   were read from the stream.

  in - the ObjectInput instance to read ObjID from - `java.io.ObjectInput`

  returns: unmarshalled ObjID instance - `java.rmi.server.ObjID`

  throws: java.io.IOException - if an I/O error occurs while performing this operation"
  (^java.rmi.server.ObjID [^java.io.ObjectInput in]
    (ObjID/read in)))

(defn write
  "Marshals a binary representation of this ObjID to
   an ObjectOutput instance.

   Specifically, this method first invokes the given stream's
   DataOutput.writeLong(long) method with this object
   identifier's object number, and then it writes its address
   space identifier by invoking its UID.write(DataOutput)
   method with the stream.

  out - the ObjectOutput instance to write this ObjID to - `java.io.ObjectOutput`

  throws: java.io.IOException - if an I/O error occurs while performing this operation"
  ([^java.rmi.server.ObjID this ^java.io.ObjectOutput out]
    (-> this (.write out))))

(defn hash-code
  "Returns the hash code value for this object identifier, the
   object number.

  returns: the hash code value for this object identifier - `int`"
  (^Integer [^java.rmi.server.ObjID this]
    (-> this (.hashCode))))

(defn equals
  "Compares the specified object with this ObjID for
   equality.

   This method returns true if and only if the
   specified object is an ObjID instance with the same
   object number and address space identifier as this one.

  obj - the object to compare this ObjID to - `java.lang.Object`

  returns: true if the given object is equivalent to
   this one, and false otherwise - `boolean`"
  (^Boolean [^java.rmi.server.ObjID this ^java.lang.Object obj]
    (-> this (.equals obj))))

(defn to-string
  "Returns a string representation of this object identifier.

  returns: a string representation of this object identifier - `java.lang.String`"
  (^java.lang.String [^java.rmi.server.ObjID this]
    (-> this (.toString))))

