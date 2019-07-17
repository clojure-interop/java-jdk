(ns jdk.io.FileOutputStream
  "A file output stream is an output stream for writing data to a
  File or to a FileDescriptor. Whether or not
  a file is available or may be created depends upon the underlying
  platform.  Some platforms, in particular, allow a file to be opened
  for writing by only one FileOutputStream (or other
  file-writing object) at a time.  In such situations the constructors in
  this class will fail if the file involved is already open.

  FileOutputStream is meant for writing streams of raw bytes
  such as image data. For writing streams of characters, consider using
  FileWriter."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.io FileOutputStream]))

(defn ->file-output-stream
  "Constructor.

  Creates a file output stream to write to the file with the specified
   name.  If the second argument is true, then
   bytes will be written to the end of the file rather than the beginning.
   A new FileDescriptor object is created to represent this
   file connection.

   First, if there is a security manager, its checkWrite
   method is called with name as its argument.

   If the file exists but is a directory rather than a regular file, does
   not exist but cannot be created, or cannot be opened for any other
   reason then a FileNotFoundException is thrown.

  name - the system-dependent file name - `java.lang.String`
  append - if true, then bytes will be written to the end of the file rather than the beginning - `boolean`

  throws: java.io.FileNotFoundException - if the file exists but is a directory rather than a regular file, does not exist but cannot be created, or cannot be opened for any other reason."
  ([^java.lang.String name ^Boolean append]
    (new FileOutputStream name append))
  ([^java.lang.String name]
    (new FileOutputStream name)))

(defn write
  "Writes len bytes from the specified byte array
   starting at offset off to this file output stream.

  b - the data. - `byte[]`
  off - the start offset in the data. - `int`
  len - the number of bytes to write. - `int`

  throws: java.io.IOException - if an I/O error occurs."
  ([^java.io.FileOutputStream this b ^Integer off ^Integer len]
    (-> this (.write b off len)))
  ([^java.io.FileOutputStream this ^Integer b]
    (-> this (.write b))))

(defn close
  "Closes this file output stream and releases any system resources
   associated with this stream. This file output stream may no longer
   be used for writing bytes.

    If this stream has an associated channel then the channel is closed
   as well.

  throws: java.io.IOException - if an I/O error occurs."
  ([^java.io.FileOutputStream this]
    (-> this (.close))))

(defn get-fd
  "Returns the file descriptor associated with this stream.

  returns: the FileDescriptor object that represents
            the connection to the file in the file system being used
            by this FileOutputStream object. - `java.io.FileDescriptor`

  throws: java.io.IOException - if an I/O error occurs."
  ([^java.io.FileOutputStream this]
    (-> this (.getFD))))

(defn get-channel
  "Returns the unique FileChannel
   object associated with this file output stream.

    The initial position of the returned channel will be equal to the
   number of bytes written to the file so far unless this stream is in
   append mode, in which case it will be equal to the size of the file.
   Writing bytes to this stream will increment the channel's position
   accordingly.  Changing the channel's position, either explicitly or by
   writing, will change this stream's file position.

  returns: the file channel associated with this file output stream - `java.nio.channels.FileChannel`"
  ([^java.io.FileOutputStream this]
    (-> this (.getChannel))))

