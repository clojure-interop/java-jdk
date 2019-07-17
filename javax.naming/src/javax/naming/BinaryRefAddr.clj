(ns javax.naming.BinaryRefAddr
  "This class represents the binary form of the address of
  a communications end-point.

  A BinaryRefAddr consists of a type that describes the communication mechanism
  and an opaque buffer containing the address description
  specific to that communication mechanism. The format and interpretation of
  the address type and the contents of the opaque buffer are based on
  the agreement of three parties: the client that uses the address,
  the object/server that can be reached using the address,
  and the administrator or program that creates the address.

  An example of a binary reference address is an BER X.500 presentation address.
  Another example of a binary reference address is a serialized form of
  a service's object handle.

  A binary reference address is immutable in the sense that its fields
  once created, cannot be replaced. However, it is possible to access
  the byte array used to hold the opaque buffer. Programs are strongly
  recommended against changing this byte array. Changes to this
  byte array need to be explicitly synchronized."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.naming BinaryRefAddr]))

(defn ->binary-ref-addr
  "Constructor.

  Constructs a new instance of BinaryRefAddr using its address type and
   a region of a byte array for contents.

  addr-type - A non-null string describing the type of the address. - `java.lang.String`
  src - The non-null contents of the address as a byte array. The contents of src is copied into the new BinaryRefAddr. - `byte[]`
  offset - The starting index in src to get the bytes. 0 <= offset <= src.length. - `int`
  count - The number of bytes to extract from src. 0 <= count <= src.length-offset. - `int`"
  ([^java.lang.String addr-type src ^Integer offset ^Integer count]
    (new BinaryRefAddr addr-type src offset count))
  ([^java.lang.String addr-type src]
    (new BinaryRefAddr addr-type src)))

(defn get-content
  "Retrieves the contents of this address as an Object.
   The result is a byte array.
   Changes to this array will affect this BinaryRefAddr's contents.
   Programs are recommended against changing this array's contents
   and to lock the buffer if they need to change it.

  returns: The non-null buffer containing this address's contents. - `java.lang.Object`"
  ([^javax.naming.BinaryRefAddr this]
    (-> this (.getContent))))

(defn equals
  "Determines whether obj is equal to this address.  It is equal if
   it contains the same address type and their contents are byte-wise
   equivalent.

  obj - The possibly null object to check. - `java.lang.Object`

  returns: true if the object is equal; false otherwise. - `boolean`"
  ([^javax.naming.BinaryRefAddr this ^java.lang.Object obj]
    (-> this (.equals obj))))

(defn hash-code
  "Computes the hash code of this address using its address type and contents.
   Two BinaryRefAddrs have the same hash code if they have
   the same address type and the same contents.
   It is also possible for different BinaryRefAddrs to have
   the same hash code.

  returns: The hash code of this address as an int. - `int`"
  ([^javax.naming.BinaryRefAddr this]
    (-> this (.hashCode))))

(defn to-string
  "Generates the string representation of this address.
   The string consists of the address's type and contents with labels.
   The first 32 bytes of contents are displayed (in hexadecimal).
   If there are more than 32 bytes, `...` is used to indicate more.
   This string is meant to used for debugging purposes and not
   meant to be interpreted programmatically.

  returns: The non-null string representation of this address. - `java.lang.String`"
  ([^javax.naming.BinaryRefAddr this]
    (-> this (.toString))))

