(ns javax.crypto.CipherOutputStream
  "A CipherOutputStream is composed of an OutputStream and a Cipher so
  that write() methods first process the data before writing them out
  to the underlying OutputStream.  The cipher must be fully
  initialized before being used by a CipherOutputStream.

   For example, if the cipher is initialized for encryption, the
  CipherOutputStream will attempt to encrypt data before writing out the
  encrypted data.

   This class adheres strictly to the semantics, especially the
  failure semantics, of its ancestor classes
  java.io.OutputStream and java.io.FilterOutputStream.  This class
  has exactly those methods specified in its ancestor classes, and
  overrides them all.  Moreover, this class catches all exceptions
  that are not thrown by its ancestor classes. In particular, this
  class catches BadPaddingException and other exceptions thrown by
  failed integrity checks during decryption. These exceptions are not
  re-thrown, so the client will not be informed that integrity checks
  failed. Because of this behavior, this class may not be suitable
  for use with decryption in an authenticated mode of operation (e.g. GCM)
  if the application requires explicit notification when authentication
  fails. Such an application can use the Cipher API directly as an
  alternative to using this class.

   It is crucial for a programmer using this class not to use
  methods that are not defined or overriden in this class (such as a
  new method or constructor that is later added to one of the super
  classes), because the design and implementation of those methods
  are unlikely to have considered security impact with regard to
  CipherOutputStream."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.crypto CipherOutputStream]))

(defn ->cipher-output-stream
  "Constructor.

  Constructs a CipherOutputStream from an OutputStream and a
   Cipher.
   Note: if the specified output stream or cipher is
   null, a NullPointerException may be thrown later when
   they are used.

  os - the OutputStream object - `java.io.OutputStream`
  c - an initialized Cipher object - `javax.crypto.Cipher`"
  ([^java.io.OutputStream os ^javax.crypto.Cipher c]
    (new CipherOutputStream os c)))

(defn write
  "Writes len bytes from the specified byte array
   starting at offset off to this output stream.

  b - the data. - `byte[]`
  off - the start offset in the data. - `int`
  len - the number of bytes to write. - `int`

  throws: java.io.IOException - if an I/O error occurs."
  ([^javax.crypto.CipherOutputStream this b ^Integer off ^Integer len]
    (-> this (.write b off len)))
  ([^javax.crypto.CipherOutputStream this ^Integer b]
    (-> this (.write b))))

(defn flush
  "Flushes this output stream by forcing any buffered output bytes
   that have already been processed by the encapsulated cipher object
   to be written out.

   Any bytes buffered by the encapsulated cipher
   and waiting to be processed by it will not be written out. For example,
   if the encapsulated cipher is a block cipher, and the total number of
   bytes written using one of the write methods is less than
   the cipher's block size, no bytes will be written out.

  throws: java.io.IOException - if an I/O error occurs."
  ([^javax.crypto.CipherOutputStream this]
    (-> this (.flush))))

(defn close
  "Closes this output stream and releases any system resources
   associated with this stream.

   This method invokes the doFinal method of the encapsulated
   cipher object, which causes any bytes buffered by the encapsulated
   cipher to be processed. The result is written out by calling the
   flush method of this output stream.

   This method resets the encapsulated cipher object to its initial state
   and calls the close method of the underlying output
   stream.

  throws: java.io.IOException - if an I/O error occurs."
  ([^javax.crypto.CipherOutputStream this]
    (-> this (.close))))

