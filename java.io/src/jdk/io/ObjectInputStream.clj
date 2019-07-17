(ns jdk.io.ObjectInputStream
  "An ObjectInputStream deserializes primitive data and objects previously
  written using an ObjectOutputStream.

  ObjectOutputStream and ObjectInputStream can provide an application with
  persistent storage for graphs of objects when used with a FileOutputStream
  and FileInputStream respectively.  ObjectInputStream is used to recover
  those objects previously serialized. Other uses include passing objects
  between hosts using a socket stream or for marshaling and unmarshaling
  arguments and parameters in a remote communication system.

  ObjectInputStream ensures that the types of all objects in the graph
  created from the stream match the classes present in the Java Virtual
  Machine.  Classes are loaded as required using the standard mechanisms.

  Only objects that support the java.io.Serializable or
  java.io.Externalizable interface can be read from streams.

  The method readObject is used to read an object from the
  stream.  Java's safe casting should be used to get the desired type.  In
  Java, strings and arrays are objects and are treated as objects during
  serialization. When read they need to be cast to the expected type.

  Primitive data types can be read from the stream using the appropriate
  method on DataInput.

  The default deserialization mechanism for objects restores the contents
  of each field to the value and type it had when it was written.  Fields
  declared as transient or static are ignored by the deserialization process.
  References to other objects cause those objects to be read from the stream
  as necessary.  Graphs of objects are restored correctly using a reference
  sharing mechanism.  New objects are always allocated when deserializing,
  which prevents existing objects from being overwritten.

  Reading an object is analogous to running the constructors of a new
  object.  Memory is allocated for the object and initialized to zero (NULL).
  No-arg constructors are invoked for the non-serializable classes and then
  the fields of the serializable classes are restored from the stream starting
  with the serializable class closest to java.lang.object and finishing with
  the object's most specific class.

  For example to read from a stream as written by the example in
  ObjectOutputStream:



       FileInputStream fis = new FileInputStream(`t.tmp`);
       ObjectInputStream ois = new ObjectInputStream(fis);

       int i = ois.readInt();
       String today = (String) ois.readObject();
       Date date = (Date) ois.readObject();

       ois.close();

  Classes control how they are serialized by implementing either the
  java.io.Serializable or java.io.Externalizable interfaces.

  Implementing the Serializable interface allows object serialization to
  save and restore the entire state of the object and it allows classes to
  evolve between the time the stream is written and the time it is read.  It
  automatically traverses references between objects, saving and restoring
  entire graphs.

  Serializable classes that require special handling during the
  serialization and deserialization process should implement the following
  methods:



  private void writeObject(java.io.ObjectOutputStream stream)
      throws IOException;
  private void readObject(java.io.ObjectInputStream stream)
      throws IOException, ClassNotFoundException;
  private void readObjectNoData()
      throws ObjectStreamException;

  The readObject method is responsible for reading and restoring the state
  of the object for its particular class using data written to the stream by
  the corresponding writeObject method.  The method does not need to concern
  itself with the state belonging to its superclasses or subclasses.  State is
  restored by reading data from the ObjectInputStream for the individual
  fields and making assignments to the appropriate fields of the object.
  Reading primitive data types is supported by DataInput.

  Any attempt to read object data which exceeds the boundaries of the
  custom data written by the corresponding writeObject method will cause an
  OptionalDataException to be thrown with an eof field value of true.
  Non-object reads which exceed the end of the allotted data will reflect the
  end of data in the same way that they would indicate the end of the stream:
  bytewise reads will return -1 as the byte read or number of bytes read, and
  primitive reads will throw EOFExceptions.  If there is no corresponding
  writeObject method, then the end of default serialized data marks the end of
  the allotted data.

  Primitive and object read calls issued from within a readExternal method
  behave in the same manner--if the stream is already positioned at the end of
  data written by the corresponding writeExternal method, object reads will
  throw OptionalDataExceptions with eof set to true, bytewise reads will
  return -1, and primitive reads will throw EOFExceptions.  Note that this
  behavior does not hold for streams written with the old
  ObjectStreamConstants.PROTOCOL_VERSION_1 protocol, in which the
  end of data written by writeExternal methods is not demarcated, and hence
  cannot be detected.

  The readObjectNoData method is responsible for initializing the state of
  the object for its particular class in the event that the serialization
  stream does not list the given class as a superclass of the object being
  deserialized.  This may occur in cases where the receiving party uses a
  different version of the deserialized instance's class than the sending
  party, and the receiver's version extends classes that are not extended by
  the sender's version.  This may also occur if the serialization stream has
  been tampered; hence, readObjectNoData is useful for initializing
  deserialized objects properly despite a `hostile` or incomplete source
  stream.

  Serialization does not read or assign values to the fields of any object
  that does not implement the java.io.Serializable interface.  Subclasses of
  Objects that are not serializable can be serializable. In this case the
  non-serializable class must have a no-arg constructor to allow its fields to
  be initialized.  In this case it is the responsibility of the subclass to
  save and restore the state of the non-serializable class. It is frequently
  the case that the fields of that class are accessible (public, package, or
  protected) or that there are get and set methods that can be used to restore
  the state.

  Any exception that occurs while deserializing an object will be caught by
  the ObjectInputStream and abort the reading process.

  Implementing the Externalizable interface allows the object to assume
  complete control over the contents and format of the object's serialized
  form.  The methods of the Externalizable interface, writeExternal and
  readExternal, are called to save and restore the objects state.  When
  implemented by a class they can write and read their own state using all of
  the methods of ObjectOutput and ObjectInput.  It is the responsibility of
  the objects to handle any versioning that occurs.

  Enum constants are deserialized differently than ordinary serializable or
  externalizable objects.  The serialized form of an enum constant consists
  solely of its name; field values of the constant are not transmitted.  To
  deserialize an enum constant, ObjectInputStream reads the constant name from
  the stream; the deserialized constant is then obtained by calling the static
  method Enum.valueOf(Class, String) with the enum constant's
  base type and the received constant name as arguments.  Like other
  serializable or externalizable objects, enum constants can function as the
  targets of back references appearing subsequently in the serialization
  stream.  The process by which enum constants are deserialized cannot be
  customized: any class-specific readObject, readObjectNoData, and readResolve
  methods defined by enum types are ignored during deserialization.
  Similarly, any serialPersistentFields or serialVersionUID field declarations
  are also ignored--all enum types have a fixed serialVersionUID of 0L."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.io ObjectInputStream]))

(defn ->object-input-stream
  "Constructor.

  Creates an ObjectInputStream that reads from the specified InputStream.
   A serialization stream header is read from the stream and verified.
   This constructor will block until the corresponding ObjectOutputStream
   has written and flushed the header.

   If a security manager is installed, this constructor will check for
   the `enableSubclassImplementation` SerializablePermission when invoked
   directly or indirectly by the constructor of a subclass which overrides
   the ObjectInputStream.readFields or ObjectInputStream.readUnshared
   methods.

  in - input stream to read from - `java.io.InputStream`

  throws: java.io.StreamCorruptedException - if the stream header is incorrect"
  ([in]
    (new ObjectInputStream in)))

(defn read-object
  "Read an object from the ObjectInputStream.  The class of the object, the
   signature of the class, and the values of the non-transient and
   non-static fields of the class and all of its supertypes are read.
   Default deserializing for a class can be overridden using the writeObject
   and readObject methods.  Objects referenced by this object are read
   transitively so that a complete equivalent graph of objects is
   reconstructed by readObject.

   The root object is completely restored when all of its fields and the
   objects it references are completely restored.  At this point the object
   validation callbacks are executed in order based on their registered
   priorities. The callbacks are registered by objects (in the readObject
   special methods) as they are individually restored.

   Exceptions are thrown for problems with the InputStream and for
   classes that should not be deserialized.  All exceptions are fatal to
   the InputStream and leave it in an indeterminate state; it is up to the
   caller to ignore or recover the stream state.

  returns: the object read from the stream - `java.lang.Object`

  throws: java.lang.ClassNotFoundException - Class of a serialized object cannot be found."
  ([this]
    (-> this (.readObject))))

(defn register-validation
  "Register an object to be validated before the graph is returned.  While
   similar to resolveObject these validations are called after the entire
   graph has been reconstituted.  Typically, a readObject method will
   register the object with the stream so that when all of the objects are
   restored a final set of validations can be performed.

  obj - the object to receive the validation callback. - `java.io.ObjectInputValidation`
  prio - controls the order of callbacks;zero is a good default. Use higher numbers to be called back earlier, lower numbers for later callbacks. Within a priority, callbacks are processed in no particular order. - `int`

  throws: java.io.NotActiveException - The stream is not currently reading objects so it is invalid to register a callback."
  ([this obj prio]
    (-> this (.registerValidation obj prio))))

(defn read-unsigned-byte
  "Reads an unsigned 8 bit byte.

  returns: the 8 bit byte read. - `int`

  throws: java.io.EOFException - If end of file is reached."
  ([this]
    (-> this (.readUnsignedByte))))

(defn read-byte
  "Reads an 8 bit byte.

  returns: the 8 bit byte read. - `byte`

  throws: java.io.EOFException - If end of file is reached."
  ([this]
    (-> this (.readByte))))

(defn read-fully
  "Reads bytes, blocking until all bytes are read.

  buf - the buffer into which the data is read - `byte[]`
  off - the start offset of the data - `int`
  len - the maximum number of bytes to read - `int`

  throws: java.io.EOFException - If end of file is reached."
  ([this buf off len]
    (-> this (.readFully buf off len)))
  ([this buf]
    (-> this (.readFully buf))))

(defn read-char
  "Reads a 16 bit char.

  returns: the 16 bit char read. - `char`

  throws: java.io.EOFException - If end of file is reached."
  ([this]
    (-> this (.readChar))))

(defn read-fields
  "Reads the persistent fields from the stream and makes them available by
   name.

  returns: the GetField object representing the persistent
            fields of the object being deserialized - `java.io.ObjectInputStream.GetField`

  throws: java.lang.ClassNotFoundException - if the class of a serialized object could not be found."
  ([this]
    (-> this (.readFields))))

(defn read-unshared
  "Reads an `unshared` object from the ObjectInputStream.  This method is
   identical to readObject, except that it prevents subsequent calls to
   readObject and readUnshared from returning additional references to the
   deserialized instance obtained via this call.  Specifically:

     If readUnshared is called to deserialize a back-reference (the
         stream representation of an object which has been written
         previously to the stream), an ObjectStreamException will be
         thrown.

     If readUnshared returns successfully, then any subsequent attempts
         to deserialize back-references to the stream handle deserialized
         by readUnshared will cause an ObjectStreamException to be thrown.

   Deserializing an object via readUnshared invalidates the stream handle
   associated with the returned object.  Note that this in itself does not
   always guarantee that the reference returned by readUnshared is unique;
   the deserialized object may define a readResolve method which returns an
   object visible to other parties, or readUnshared may return a Class
   object or enum constant obtainable elsewhere in the stream or through
   external means. If the deserialized object defines a readResolve method
   and the invocation of that method returns an array, then readUnshared
   returns a shallow clone of that array; this guarantees that the returned
   array object is unique and cannot be obtained a second time from an
   invocation of readObject or readUnshared on the ObjectInputStream,
   even if the underlying data stream has been manipulated.

   ObjectInputStream subclasses which override this method can only be
   constructed in security contexts possessing the
   `enableSubclassImplementation` SerializablePermission; any attempt to
   instantiate such a subclass without this permission will cause a
   SecurityException to be thrown.

  returns: reference to deserialized object - `java.lang.Object`

  throws: java.lang.ClassNotFoundException - if class of an object to deserialize cannot be found"
  ([this]
    (-> this (.readUnshared))))

(defn read-float
  "Reads a 32 bit float.

  returns: the 32 bit float read. - `float`

  throws: java.io.EOFException - If end of file is reached."
  ([this]
    (-> this (.readFloat))))

(defn read
  "Reads into an array of bytes.  This method will block until some input
   is available. Consider using java.io.DataInputStream.readFully to read
   exactly 'length' bytes.

  buf - the buffer into which the data is read - `byte[]`
  off - the start offset of the data - `int`
  len - the maximum number of bytes read - `int`

  returns: the actual number of bytes read, -1 is returned when the end of
            the stream is reached. - `int`

  throws: java.io.IOException - If an I/O error has occurred."
  ([this buf off len]
    (-> this (.read buf off len)))
  ([this]
    (-> this (.read))))

(defn read-boolean
  "Reads in a boolean.

  returns: the boolean read. - `boolean`

  throws: java.io.EOFException - If end of file is reached."
  ([this]
    (-> this (.readBoolean))))

(defn read-int
  "Reads a 32 bit int.

  returns: the 32 bit integer read. - `int`

  throws: java.io.EOFException - If end of file is reached."
  ([this]
    (-> this (.readInt))))

(defn read-long
  "Reads a 64 bit long.

  returns: the read 64 bit long. - `long`

  throws: java.io.EOFException - If end of file is reached."
  ([this]
    (-> this (.readLong))))

(defn close
  "Closes the input stream. Must be called to release any resources
   associated with the stream.

  throws: java.io.IOException - If an I/O error has occurred."
  ([this]
    (-> this (.close))))

(defn default-read-object
  "Read the non-static and non-transient fields of the current class from
   this stream.  This may only be called from the readObject method of the
   class being deserialized. It will throw the NotActiveException if it is
   called otherwise.

  throws: java.lang.ClassNotFoundException - if the class of a serialized object could not be found."
  ([this]
    (-> this (.defaultReadObject))))

(defn read-short
  "Reads a 16 bit short.

  returns: the 16 bit short read. - `short`

  throws: java.io.EOFException - If end of file is reached."
  ([this]
    (-> this (.readShort))))

(defn skip-bytes
  "Skips bytes.

  len - the number of bytes to be skipped - `int`

  returns: the actual number of bytes skipped. - `int`

  throws: java.io.IOException - If an I/O error has occurred."
  ([this len]
    (-> this (.skipBytes len))))

(defn read-utf
  "Reads a String in
   modified UTF-8
   format.

  returns: the String. - `java.lang.String`

  throws: java.io.IOException - if there are I/O errors while reading from the underlying InputStream"
  ([this]
    (-> this (.readUTF))))

(defn read-double
  "Reads a 64 bit double.

  returns: the 64 bit double read. - `double`

  throws: java.io.EOFException - If end of file is reached."
  ([this]
    (-> this (.readDouble))))

(defn available
  "Returns the number of bytes that can be read without blocking.

  returns: the number of available bytes. - `int`

  throws: java.io.IOException - if there are I/O errors while reading from the underlying InputStream"
  ([this]
    (-> this (.available))))

(defn read-line
  "Deprecated. This method does not properly convert bytes to characters.
            see DataInputStream for the details and alternatives.

  returns: a String copy of the line. - `java.lang.  java.lang.String`

  throws: java.io.IOException - if there are I/O errors while reading from the underlying InputStream"
  ([this]
    (-> this (.readLine))))

(defn read-unsigned-short
  "Reads an unsigned 16 bit short.

  returns: the 16 bit short read. - `int`

  throws: java.io.EOFException - If end of file is reached."
  ([this]
    (-> this (.readUnsignedShort))))

