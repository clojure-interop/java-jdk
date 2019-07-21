(ns jdk.rmi.server.UID
  "A UID represents an identifier that is unique over time
  with respect to the host it is generated on, or one of 216
  \"well-known\" identifiers.

  The UID() constructor can be used to generate an
  identifier that is unique over time with respect to the host it is
  generated on.  The UID(short) constructor can be used to
  create one of 216 well-known identifiers.

  A UID instance contains three primitive values:

  unique, an int that uniquely identifies
  the VM that this UID was generated in, with respect to its
  host and at the time represented by the time value (an
  example implementation of the unique value would be a
  process identifier),
   or zero for a well-known UID
  time, a long equal to a time (as returned
  by System.currentTimeMillis()) at which the VM that this
  UID was generated in was alive,
  or zero for a well-known UID
  count, a short to distinguish
  UIDs generated in the same VM with the same
  time value


  An independently generated UID instance is unique
  over time with respect to the host it is generated on as long as
  the host requires more than one millisecond to reboot and its system
  clock is never set backward.  A globally unique identifier can be
  constructed by pairing a UID instance with a unique host
  identifier, such as an IP address."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.rmi.server UID]))

(defn ->uid
  "Constructor.

  Creates a \"well-known\" UID.

   There are 216 possible such well-known ids.

   A UID created via this constructor will not
   clash with any UIDs generated via the no-arg
   constructor.

  num - number for well-known UID - `short`"
  (^UID [^Short num]
    (new UID num))
  (^UID []
    (new UID )))

(defn *read
  "Constructs and returns a new UID instance by
   unmarshalling a binary representation from an
   DataInput instance.

   Specifically, this method first invokes the given stream's
   DataInput.readInt() method to read a unique value,
   then it invoke's the stream's
   DataInput.readLong() method to read a time value,
   then it invoke's the stream's
   DataInput.readShort() method to read a count value,
   and then it creates and returns a new UID instance
   that contains the unique, time, and
   count values that were read from the stream.

  in - the DataInput instance to read UID from - `java.io.DataInput`

  returns: unmarshalled UID instance - `java.rmi.server.UID`

  throws: java.io.IOException - if an I/O error occurs while performing this operation"
  (^java.rmi.server.UID [^java.io.DataInput in]
    (UID/read in)))

(defn hash-code
  "Returns the hash code value for this UID.

  returns: the hash code value for this UID - `int`"
  (^Integer [^UID this]
    (-> this (.hashCode))))

(defn equals
  "Compares the specified object with this UID for
   equality.

   This method returns true if and only if the
   specified object is a UID instance with the same
   unique, time, and count
   values as this one.

  obj - the object to compare this UID to - `java.lang.Object`

  returns: true if the given object is equivalent to
   this one, and false otherwise - `boolean`"
  (^Boolean [^UID this ^java.lang.Object obj]
    (-> this (.equals obj))))

(defn to-string
  "Returns a string representation of this UID.

  returns: a string representation of this UID - `java.lang.String`"
  (^java.lang.String [^UID this]
    (-> this (.toString))))

(defn write
  "Marshals a binary representation of this UID to
   a DataOutput instance.

   Specifically, this method first invokes the given stream's
   DataOutput.writeInt(int) method with this UID's
   unique value, then it invokes the stream's
   DataOutput.writeLong(long) method with this UID's
   time value, and then it invokes the stream's
   DataOutput.writeShort(int) method with this UID's
   count value.

  out - the DataOutput instance to write this UID to - `java.io.DataOutput`

  throws: java.io.IOException - if an I/O error occurs while performing this operation"
  ([^UID this ^java.io.DataOutput out]
    (-> this (.write out))))

