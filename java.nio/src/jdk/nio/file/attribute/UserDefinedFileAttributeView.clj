(ns jdk.nio.file.attribute.UserDefinedFileAttributeView
  "A file attribute view that provides a view of a file's user-defined
  attributes, sometimes known as extended attributes. User-defined
  file attributes are used to store metadata with a file that is not meaningful
  to the file system. It is primarily intended for file system implementations
  that support such a capability directly but may be emulated. The details of
  such emulation are highly implementation specific and therefore not specified.

   This FileAttributeView provides a view of a file's user-defined
  attributes as a set of name/value pairs, where the attribute name is
  represented by a String. An implementation may require to encode and
  decode from the platform or file system representation when accessing the
  attribute. The value has opaque content. This attribute view defines the
  read and write methods to read the value into
  or write from a ByteBuffer. This FileAttributeView is not
  intended for use where the size of an attribute value is larger than Integer.MAX_VALUE.

   User-defined attributes may be used in some implementations to store
  security related attributes so consequently, in the case of the default
  provider at least, all methods that access user-defined attributes require the
  RuntimePermission(`accessUserDefinedAttributes`) permission when a
  security manager is installed.

   The supportsFileAttributeView method may be used to test if a specific FileStore supports the storage of user-defined
  attributes.

   Where dynamic access to file attributes is required, the getAttribute method may be used to read
  the attribute value. The attribute value is returned as a byte array (byte[]).
  The setAttribute method may be used
  to write the value of a user-defined attribute from a buffer (as if by
  invoking the write method), or byte array (byte[])."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.nio.file.attribute UserDefinedFileAttributeView]))

(defn name
  "Returns the name of this attribute view. Attribute views of this type
   have the name `user`.

  returns: the name of the attribute view - `java.lang.String`"
  (^java.lang.String [^UserDefinedFileAttributeView this]
    (-> this (.name))))

(defn list
  "Returns a list containing the names of the user-defined attributes.

  returns: An unmodifiable list containing the names of the file's
            user-defined - `java.util.List<java.lang.String>`

  throws: java.io.IOException - If an I/O error occurs"
  (^java.util.List [^UserDefinedFileAttributeView this]
    (-> this (.list))))

(defn size
  "Returns the size of the value of a user-defined attribute.

  name - The attribute name - `java.lang.String`

  returns: The size of the attribute value, in bytes. - `int`

  throws: java.lang.ArithmeticException - If the size of the attribute is larger than Integer.MAX_VALUE"
  (^Integer [^UserDefinedFileAttributeView this ^java.lang.String name]
    (-> this (.size name))))

(defn read
  "Read the value of a user-defined attribute into a buffer.

    This method reads the value of the attribute into the given buffer
   as a sequence of bytes, failing if the number of bytes remaining in
   the buffer is insufficient to read the complete attribute value. The
   number of bytes transferred into the buffer is n, where n
   is the size of the attribute value. The first byte in the sequence is at
   index p and the last byte is at index p  n - 1, where
   p is the buffer's position. Upon return the buffer's position
   will be equal to p  n; its limit will not have changed.

    Usage Example:
   Suppose we want to read a file's MIME type that is stored as a user-defined
   attribute with the name `user.mimetype`.


      UserDefinedFileAttributeView view =
          Files.getFileAttributeView(path, UserDefinedFileAttributeView.class);
      String name = `user.mimetype`;
      ByteBuffer buf = ByteBuffer.allocate(view.size(name));
      view.read(name, buf);
      buf.flip();
      String value = Charset.defaultCharset().decode(buf).toString();

  name - The attribute name - `java.lang.String`
  dst - The destination buffer - `java.nio.ByteBuffer`

  returns: The number of bytes read, possibly zero - `int`

  throws: java.lang.IllegalArgumentException - If the destination buffer is read-only"
  (^Integer [^UserDefinedFileAttributeView this ^java.lang.String name ^java.nio.ByteBuffer dst]
    (-> this (.read name dst))))

(defn write
  "Writes the value of a user-defined attribute from a buffer.

    This method writes the value of the attribute from a given buffer as
   a sequence of bytes. The size of the value to transfer is r,
   where r is the number of bytes remaining in the buffer, that is
   src.remaining(). The sequence of bytes is transferred from the
   buffer starting at index p, where p is the buffer's
   position. Upon return, the buffer's position will be equal to p  n, where n is the number of bytes transferred; its limit
   will not have changed.

    If an attribute of the given name already exists then its value is
   replaced. If the attribute does not exist then it is created. If it
   implementation specific if a test to check for the existence of the
   attribute and the creation of attribute are atomic with respect to other
   file system activities.

    Where there is insufficient space to store the attribute, or the
   attribute name or value exceed an implementation specific maximum size
   then an IOException is thrown.

    Usage Example:
   Suppose we want to write a file's MIME type as a user-defined attribute:


      UserDefinedFileAttributeView view =
          FIles.getFileAttributeView(path, UserDefinedFileAttributeView.class);
      view.write(`user.mimetype`, Charset.defaultCharset().encode(`text/html`));

  name - The attribute name - `java.lang.String`
  src - The buffer containing the attribute value - `java.nio.ByteBuffer`

  returns: The number of bytes written, possibly zero - `int`

  throws: java.io.IOException - If an I/O error occurs"
  (^Integer [^UserDefinedFileAttributeView this ^java.lang.String name ^java.nio.ByteBuffer src]
    (-> this (.write name src))))

(defn delete
  "Deletes a user-defined attribute.

  name - The attribute name - `java.lang.String`

  throws: java.io.IOException - If an I/O error occurs or the attribute does not exist"
  ([^UserDefinedFileAttributeView this ^java.lang.String name]
    (-> this (.delete name))))

