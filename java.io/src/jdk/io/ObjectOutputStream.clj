(ns jdk.io.ObjectOutputStream
  "An ObjectOutputStream writes primitive data types and graphs of Java objects
  to an OutputStream.  The objects can be read (reconstituted) using an
  ObjectInputStream.  Persistent storage of objects can be accomplished by
  using a file for the stream.  If the stream is a network socket stream, the
  objects can be reconstituted on another host or in another process.

  Only objects that support the java.io.Serializable interface can be
  written to streams.  The class of each serializable object is encoded
  including the class name and signature of the class, the values of the
  object's fields and arrays, and the closure of any other objects referenced
  from the initial objects.

  The method writeObject is used to write an object to the stream.  Any
  object, including Strings and arrays, is written with writeObject. Multiple
  objects or primitives can be written to the stream.  The objects must be
  read back from the corresponding ObjectInputstream with the same types and
  in the same order as they were written.

  Primitive data types can also be written to the stream using the
  appropriate methods from DataOutput. Strings can also be written using the
  writeUTF method.

  The default serialization mechanism for an object writes the class of the
  object, the class signature, and the values of all non-transient and
  non-static fields.  References to other objects (except in transient or
  static fields) cause those objects to be written also. Multiple references
  to a single object are encoded using a reference sharing mechanism so that
  graphs of objects can be restored to the same shape as when the original was
  written.

  For example to write an object that can be read by the example in
  ObjectInputStream:



       FileOutputStream fos = new FileOutputStream(`t.tmp`);
       ObjectOutputStream oos = new ObjectOutputStream(fos);

       oos.writeInt(12345);
       oos.writeObject(`Today`);
       oos.writeObject(new Date());

       oos.close();

  Classes that require special handling during the serialization and
  deserialization process must implement special methods with these exact
  signatures:



  private void readObject(java.io.ObjectInputStream stream)
      throws IOException, ClassNotFoundException;
  private void writeObject(java.io.ObjectOutputStream stream)
      throws IOException
  private void readObjectNoData()
      throws ObjectStreamException;

  The writeObject method is responsible for writing the state of the object
  for its particular class so that the corresponding readObject method can
  restore it.  The method does not need to concern itself with the state
  belonging to the object's superclasses or subclasses.  State is saved by
  writing the individual fields to the ObjectOutputStream using the
  writeObject method or by using the methods for primitive data types
  supported by DataOutput.

  Serialization does not write out the fields of any object that does not
  implement the java.io.Serializable interface.  Subclasses of Objects that
  are not serializable can be serializable. In this case the non-serializable
  class must have a no-arg constructor to allow its fields to be initialized.
  In this case it is the responsibility of the subclass to save and restore
  the state of the non-serializable class. It is frequently the case that the
  fields of that class are accessible (public, package, or protected) or that
  there are get and set methods that can be used to restore the state.

  Serialization of an object can be prevented by implementing writeObject
  and readObject methods that throw the NotSerializableException.  The
  exception will be caught by the ObjectOutputStream and abort the
  serialization process.

  Implementing the Externalizable interface allows the object to assume
  complete control over the contents and format of the object's serialized
  form.  The methods of the Externalizable interface, writeExternal and
  readExternal, are called to save and restore the objects state.  When
  implemented by a class they can write and read their own state using all of
  the methods of ObjectOutput and ObjectInput.  It is the responsibility of
  the objects to handle any versioning that occurs.

  Enum constants are serialized differently than ordinary serializable or
  externalizable objects.  The serialized form of an enum constant consists
  solely of its name; field values of the constant are not transmitted.  To
  serialize an enum constant, ObjectOutputStream writes the string returned by
  the constant's name method.  Like other serializable or externalizable
  objects, enum constants can function as the targets of back references
  appearing subsequently in the serialization stream.  The process by which
  enum constants are serialized cannot be customized; any class-specific
  writeObject and writeReplace methods defined by enum types are ignored
  during serialization.  Similarly, any serialPersistentFields or
  serialVersionUID field declarations are also ignored--all enum types have a
  fixed serialVersionUID of 0L.

  Primitive data, excluding serializable fields and externalizable data, is
  written to the ObjectOutputStream in block-data records. A block data record
  is composed of a header and data. The block data header consists of a marker
  and the number of bytes to follow the header.  Consecutive primitive data
  writes are merged into one block-data record.  The blocking factor used for
  a block-data record will be 1024 bytes.  Each block-data record will be
  filled up to 1024 bytes, or be written whenever there is a termination of
  block-data mode.  Calls to the ObjectOutputStream methods writeObject,
  defaultWriteObject and writeFields initially terminate any existing
  block-data record."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.io ObjectOutputStream]))

(defn ->object-output-stream
  "Constructor.

  Creates an ObjectOutputStream that writes to the specified OutputStream.
   This constructor writes the serialization stream header to the
   underlying stream; callers may wish to flush the stream immediately to
   ensure that constructors for receiving ObjectInputStreams will not block
   when reading the header.

   If a security manager is installed, this constructor will check for
   the `enableSubclassImplementation` SerializablePermission when invoked
   directly or indirectly by the constructor of a subclass which overrides
   the ObjectOutputStream.putFields or ObjectOutputStream.writeUnshared
   methods.

  out - output stream to write to - `java.io.OutputStream`

  throws: java.io.IOException - if an I/O error occurs while writing stream header"
  ([^java.io.OutputStream out]
    (new ObjectOutputStream out)))

(defn write-unshared
  "Writes an `unshared` object to the ObjectOutputStream.  This method is
   identical to writeObject, except that it always writes the given object
   as a new, unique object in the stream (as opposed to a back-reference
   pointing to a previously serialized instance).  Specifically:

     An object written via writeUnshared is always serialized in the
         same manner as a newly appearing object (an object that has not
         been written to the stream yet), regardless of whether or not the
         object has been written previously.

     If writeObject is used to write an object that has been previously
         written with writeUnshared, the previous writeUnshared operation
         is treated as if it were a write of a separate object.  In other
         words, ObjectOutputStream will never generate back-references to
         object data written by calls to writeUnshared.

   While writing an object via writeUnshared does not in itself guarantee a
   unique reference to the object when it is deserialized, it allows a
   single object to be defined multiple times in a stream, so that multiple
   calls to readUnshared by the receiver will not conflict.  Note that the
   rules described above only apply to the base-level object written with
   writeUnshared, and not to any transitively referenced sub-objects in the
   object graph to be serialized.

   ObjectOutputStream subclasses which override this method can only be
   constructed in security contexts possessing the
   `enableSubclassImplementation` SerializablePermission; any attempt to
   instantiate such a subclass without this permission will cause a
   SecurityException to be thrown.

  obj - object to write to stream - `java.lang.Object`

  throws: java.io.NotSerializableException - if an object in the graph to be serialized does not implement the Serializable interface"
  ([^java.io.ObjectOutputStream this ^java.lang.Object obj]
    (-> this (.writeUnshared obj))))

(defn write-fields
  "Write the buffered fields to the stream.

  throws: java.io.IOException - if I/O errors occur while writing to the underlying stream"
  ([^java.io.ObjectOutputStream this]
    (-> this (.writeFields))))

(defn write-utf
  "Primitive data write of this String in
   modified UTF-8
   format.  Note that there is a
   significant difference between writing a String into the stream as
   primitive data or as an Object. A String instance written by writeObject
   is written into the stream as a String initially. Future writeObject()
   calls write references to the string into the stream.

  str - the String to be written - `java.lang.String`

  throws: java.io.IOException - if I/O errors occur while writing to the underlying stream"
  ([^java.io.ObjectOutputStream this ^java.lang.String str]
    (-> this (.writeUTF str))))

(defn write-bytes
  "Writes a String as a sequence of bytes.

  str - the String of bytes to be written - `java.lang.String`

  throws: java.io.IOException - if I/O errors occur while writing to the underlying stream"
  ([^java.io.ObjectOutputStream this ^java.lang.String str]
    (-> this (.writeBytes str))))

(defn write-double
  "Writes a 64 bit double.

  val - the double value to be written - `double`

  throws: java.io.IOException - if I/O errors occur while writing to the underlying stream"
  ([^java.io.ObjectOutputStream this ^Double val]
    (-> this (.writeDouble val))))

(defn write-object
  "Write the specified object to the ObjectOutputStream.  The class of the
   object, the signature of the class, and the values of the non-transient
   and non-static fields of the class and all of its supertypes are
   written.  Default serialization for a class can be overridden using the
   writeObject and the readObject methods.  Objects referenced by this
   object are written transitively so that a complete equivalent graph of
   objects can be reconstructed by an ObjectInputStream.

   Exceptions are thrown for problems with the OutputStream and for
   classes that should not be serialized.  All exceptions are fatal to the
   OutputStream, which is left in an indeterminate state, and it is up to
   the caller to ignore or recover the stream state.

  obj - the object to be written - `java.lang.Object`

  throws: java.io.InvalidClassException - Something is wrong with a class used by serialization."
  ([^java.io.ObjectOutputStream this ^java.lang.Object obj]
    (-> this (.writeObject obj))))

(defn write-boolean
  "Writes a boolean.

  val - the boolean to be written - `boolean`

  throws: java.io.IOException - if I/O errors occur while writing to the underlying stream"
  ([^java.io.ObjectOutputStream this ^Boolean val]
    (-> this (.writeBoolean val))))

(defn flush
  "Flushes the stream. This will write any buffered output bytes and flush
   through to the underlying stream.

  throws: java.io.IOException - If an I/O error has occurred."
  ([^java.io.ObjectOutputStream this]
    (-> this (.flush))))

(defn write-long
  "Writes a 64 bit long.

  val - the long value to be written - `long`

  throws: java.io.IOException - if I/O errors occur while writing to the underlying stream"
  ([^java.io.ObjectOutputStream this ^Long val]
    (-> this (.writeLong val))))

(defn write-short
  "Writes a 16 bit short.

  val - the short value to be written - `int`

  throws: java.io.IOException - if I/O errors occur while writing to the underlying stream"
  ([^java.io.ObjectOutputStream this ^Integer val]
    (-> this (.writeShort val))))

(defn reset
  "Reset will disregard the state of any objects already written to the
   stream.  The state is reset to be the same as a new ObjectOutputStream.
   The current point in the stream is marked as reset so the corresponding
   ObjectInputStream will be reset at the same point.  Objects previously
   written to the stream will not be referred to as already being in the
   stream.  They will be written to the stream again.

  throws: java.io.IOException - if reset() is invoked while serializing an object."
  ([^java.io.ObjectOutputStream this]
    (-> this (.reset))))

(defn use-protocol-version
  "Specify stream protocol version to use when writing the stream.

   This routine provides a hook to enable the current version of
   Serialization to write in a format that is backwards compatible to a
   previous version of the stream format.

   Every effort will be made to avoid introducing additional
   backwards incompatibilities; however, sometimes there is no
   other alternative.

  version - use ProtocolVersion from java.io.ObjectStreamConstants. - `int`

  throws: java.lang.IllegalStateException - if called after any objects have been serialized."
  ([^java.io.ObjectOutputStream this ^Integer version]
    (-> this (.useProtocolVersion version))))

(defn close
  "Closes the stream. This method must be called to release any resources
   associated with the stream.

  throws: java.io.IOException - If an I/O error has occurred."
  ([^java.io.ObjectOutputStream this]
    (-> this (.close))))

(defn write-int
  "Writes a 32 bit int.

  val - the integer value to be written - `int`

  throws: java.io.IOException - if I/O errors occur while writing to the underlying stream"
  ([^java.io.ObjectOutputStream this ^Integer val]
    (-> this (.writeInt val))))

(defn write-float
  "Writes a 32 bit float.

  val - the float value to be written - `float`

  throws: java.io.IOException - if I/O errors occur while writing to the underlying stream"
  ([^java.io.ObjectOutputStream this ^Float val]
    (-> this (.writeFloat val))))

(defn write-chars
  "Writes a String as a sequence of chars.

  str - the String of chars to be written - `java.lang.String`

  throws: java.io.IOException - if I/O errors occur while writing to the underlying stream"
  ([^java.io.ObjectOutputStream this ^java.lang.String str]
    (-> this (.writeChars str))))

(defn write-char
  "Writes a 16 bit char.

  val - the char value to be written - `int`

  throws: java.io.IOException - if I/O errors occur while writing to the underlying stream"
  ([^java.io.ObjectOutputStream this ^Integer val]
    (-> this (.writeChar val))))

(defn write-byte
  "Writes an 8 bit byte.

  val - the byte value to be written - `int`

  throws: java.io.IOException - if I/O errors occur while writing to the underlying stream"
  ([^java.io.ObjectOutputStream this ^Integer val]
    (-> this (.writeByte val))))

(defn write
  "Writes a sub array of bytes.

  buf - the data to be written - `byte[]`
  off - the start offset in the data - `int`
  len - the number of bytes that are written - `int`

  throws: java.io.IOException - If an I/O error has occurred."
  ([^java.io.ObjectOutputStream this buf ^Integer off ^Integer len]
    (-> this (.write buf off len)))
  ([^java.io.ObjectOutputStream this ^Integer val]
    (-> this (.write val))))

(defn put-fields
  "Retrieve the object used to buffer persistent fields to be written to
   the stream.  The fields will be written to the stream when writeFields
   method is called.

  returns: an instance of the class Putfield that holds the serializable
            fields - `java.io.ObjectOutputStream.PutField`

  throws: java.io.IOException - if I/O errors occur"
  ([^java.io.ObjectOutputStream this]
    (-> this (.putFields))))

(defn default-write-object
  "Write the non-static and non-transient fields of the current class to
   this stream.  This may only be called from the writeObject method of the
   class being serialized. It will throw the NotActiveException if it is
   called otherwise.

  throws: java.io.IOException - if I/O errors occur while writing to the underlying OutputStream"
  ([^java.io.ObjectOutputStream this]
    (-> this (.defaultWriteObject))))

