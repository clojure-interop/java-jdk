(ns javax.crypto.CipherInputStream
  "A CipherInputStream is composed of an InputStream and a Cipher so
  that read() methods return data that are read in from the
  underlying InputStream but have been additionally processed by the
  Cipher.  The Cipher must be fully initialized before being used by
  a CipherInputStream.

   For example, if the Cipher is initialized for decryption, the
  CipherInputStream will attempt to read in data and decrypt them,
  before returning the decrypted data.

   This class adheres strictly to the semantics, especially the
  failure semantics, of its ancestor classes
  java.io.FilterInputStream and java.io.InputStream.  This class has
  exactly those methods specified in its ancestor classes, and
  overrides them all.  Moreover, this class catches all exceptions
  that are not thrown by its ancestor classes.  In particular, the
  skip method skips, and the available
  method counts only data that have been processed by the encapsulated Cipher.
  This class may catch BadPaddingException and other exceptions thrown by
  failed integrity checks during decryption. These exceptions are not
  re-thrown, so the client may not be informed that integrity checks
  failed. Because of this behavior, this class may not be suitable
  for use with decryption in an authenticated mode of operation (e.g. GCM).
  Applications that require authenticated encryption can use the Cipher API
  directly as an alternative to using this class.

   It is crucial for a programmer using this class not to use
  methods that are not defined or overriden in this class (such as a
  new method or constructor that is later added to one of the super
  classes), because the design and implementation of those methods
  are unlikely to have considered security impact with regard to
  CipherInputStream."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.crypto CipherInputStream]))

(defn ->cipher-input-stream
  "Constructor.

  Constructs a CipherInputStream from an InputStream and a
   Cipher.
   Note: if the specified input stream or cipher is
   null, a NullPointerException may be thrown later when
   they are used.

  is - the to-be-processed input stream - `java.io.InputStream`
  c - an initialized Cipher object - `javax.crypto.Cipher`"
  ([is c]
    (new CipherInputStream is c)))

(defn read
  "Reads up to len bytes of data from this input stream
   into an array of bytes. This method blocks until some input is
   available. If the first argument is null, up to
   len bytes are read and discarded.

  b - the buffer into which the data is read. - `byte[]`
  off - the start offset in the destination array buf - `int`
  len - the maximum number of bytes read. - `int`

  returns: the total number of bytes read into the buffer, or
               -1 if there is no more data because the end of
               the stream has been reached. - `int`

  throws: java.io.IOException - if an I/O error occurs."
  ([this b off len]
    (-> this (.read b off len)))
  ([this b]
    (-> this (.read b)))
  ([this]
    (-> this (.read))))

(defn skip
  "Skips n bytes of input from the bytes that can be read
   from this input stream without blocking.

   Fewer bytes than requested might be skipped.
   The actual number of bytes skipped is equal to n or
   the result of a call to
   available,
   whichever is smaller.
   If n is less than zero, no bytes are skipped.

   The actual number of bytes skipped is returned.

  n - the number of bytes to be skipped. - `long`

  returns: the actual number of bytes skipped. - `long`

  throws: java.io.IOException - if an I/O error occurs."
  ([this n]
    (-> this (.skip n))))

(defn available
  "Returns the number of bytes that can be read from this input
   stream without blocking. The available method of
   InputStream returns 0. This method
   should be overridden by subclasses.

  returns: the number of bytes that can be read from this input stream
               without blocking. - `int`

  throws: java.io.IOException - if an I/O error occurs."
  ([this]
    (-> this (.available))))

(defn close
  "Closes this input stream and releases any system resources
   associated with the stream.

   The close method of CipherInputStream
   calls the close method of its underlying input
   stream.

  throws: java.io.IOException - if an I/O error occurs."
  ([this]
    (-> this (.close))))

(defn mark-supported
  "Tests if this input stream supports the mark
   and reset methods, which it does not.

  returns: false, since this class does not support the
            mark and reset methods. - `boolean`"
  ([this]
    (-> this (.markSupported))))

