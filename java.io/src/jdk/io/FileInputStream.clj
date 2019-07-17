(ns jdk.io.FileInputStream
  "A FileInputStream obtains input bytes
  from a file in a file system. What files
  are  available depends on the host environment.

  FileInputStream is meant for reading streams of raw bytes
  such as image data. For reading streams of characters, consider using
  FileReader."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.io FileInputStream]))

(defn ->file-input-stream
  "Constructor.

  Creates a FileInputStream by
   opening a connection to an actual file,
   the file named by the path name name
   in the file system.  A new FileDescriptor
   object is created to represent this file
   connection.

   First, if there is a security
   manager, its checkRead method
   is called with the name argument
   as its argument.

   If the named file does not exist, is a directory rather than a regular
   file, or for some other reason cannot be opened for reading then a
   FileNotFoundException is thrown.

  name - the system-dependent file name. - `java.lang.String`

  throws: java.io.FileNotFoundException - if the file does not exist, is a directory rather than a regular file, or for some other reason cannot be opened for reading."
  ([^java.lang.String name]
    (new FileInputStream name)))

(defn read
  "Reads up to len bytes of data from this input stream
   into an array of bytes. If len is not zero, the method
   blocks until some input is available; otherwise, no
   bytes are read and 0 is returned.

  b - the buffer into which the data is read. - `byte[]`
  off - the start offset in the destination array b - `int`
  len - the maximum number of bytes read. - `int`

  returns: the total number of bytes read into the buffer, or
               -1 if there is no more data because the end of
               the file has been reached. - `int`

  throws: java.lang.NullPointerException - If b is null."
  ([^java.io.FileInputStream this b ^Integer off ^Integer len]
    (-> this (.read b off len)))
  ([^java.io.FileInputStream this b]
    (-> this (.read b)))
  ([^java.io.FileInputStream this]
    (-> this (.read))))

(defn skip
  "Skips over and discards n bytes of data from the
   input stream.

   The skip method may, for a variety of
   reasons, end up skipping over some smaller number of bytes,
   possibly 0. If n is negative, the method
   will try to skip backwards. In case the backing file does not support
   backward skip at its current position, an IOException is
   thrown. The actual number of bytes skipped is returned. If it skips
   forwards, it returns a positive value. If it skips backwards, it
   returns a negative value.

   This method may skip more bytes than what are remaining in the
   backing file. This produces no exception and the number of bytes skipped
   may include some number of bytes that were beyond the EOF of the
   backing file. Attempting to read from the stream after skipping past
   the end will result in -1 indicating the end of the file.

  n - the number of bytes to be skipped. - `long`

  returns: the actual number of bytes skipped. - `long`

  throws: java.io.IOException - if n is negative, if the stream does not support seek, or if an I/O error occurs."
  ([^java.io.FileInputStream this ^Long n]
    (-> this (.skip n))))

(defn available
  "Returns an estimate of the number of remaining bytes that can be read (or
   skipped over) from this input stream without blocking by the next
   invocation of a method for this input stream. Returns 0 when the file
   position is beyond EOF. The next invocation might be the same thread
   or another thread. A single read or skip of this many bytes will not
   block, but may read or skip fewer bytes.

    In some cases, a non-blocking read (or skip) may appear to be
   blocked when it is merely slow, for example when reading large
   files over slow networks.

  returns: an estimate of the number of remaining bytes that can be read
               (or skipped over) from this input stream without blocking. - `int`

  throws: java.io.IOException - if this file input stream has been closed by calling close or an I/O error occurs."
  ([^java.io.FileInputStream this]
    (-> this (.available))))

(defn close
  "Closes this file input stream and releases any system resources
   associated with the stream.

    If this stream has an associated channel then the channel is closed
   as well.

  throws: java.io.IOException - if an I/O error occurs."
  ([^java.io.FileInputStream this]
    (-> this (.close))))

(defn get-fd
  "Returns the FileDescriptor
   object  that represents the connection to
   the actual file in the file system being
   used by this FileInputStream.

  returns: the file descriptor object associated with this stream. - `java.io.FileDescriptor`

  throws: java.io.IOException - if an I/O error occurs."
  ([^java.io.FileInputStream this]
    (-> this (.getFD))))

(defn get-channel
  "Returns the unique FileChannel
   object associated with this file input stream.

    The initial position of the returned channel will be equal to the
   number of bytes read from the file so far.  Reading bytes from this
   stream will increment the channel's position.  Changing the channel's
   position, either explicitly or by reading, will change this stream's
   file position.

  returns: the file channel associated with this file input stream - `java.nio.channels.FileChannel`"
  ([^java.io.FileInputStream this]
    (-> this (.getChannel))))

