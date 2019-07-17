(ns javax.imageio.stream.FileCacheImageOutputStream
  "An implementation of ImageOutputStream that writes its
  output to a regular OutputStream.  A file is used to
  cache data until it is flushed to the output stream."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.imageio.stream FileCacheImageOutputStream]))

(defn ->file-cache-image-output-stream
  "Constructor.

  Constructs a FileCacheImageOutputStream that will write
   to a given outputStream.

    A temporary file is used as a cache.  If
   cacheDiris non-null and is a
   directory, the file will be created there.  If it is
   null, the system-dependent default temporary-file
   directory will be used (see the documentation for
   File.createTempFile for details).

  stream - an OutputStream to write to. - `java.io.OutputStream`
  cache-dir - a File indicating where the cache file should be created, or null to use the system directory. - `java.io.File`

  throws: java.lang.IllegalArgumentException - if cacheDir is non-null but is not a directory."
  ([^java.io.OutputStream stream ^java.io.File cache-dir]
    (new FileCacheImageOutputStream stream cache-dir)))

(defn flush-before
  "Description copied from interface: ImageInputStream

  pos - a long containing the length of the stream prefix that may be flushed. - `long`

  throws: java.io.IOException - if an I/O error occurs."
  ([^javax.imageio.stream.FileCacheImageOutputStream this ^Long pos]
    (-> this (.flushBefore pos))))

(defn read
  "Description copied from class: ImageInputStreamImpl

  b - an array of bytes to be written to. - `byte[]`
  off - the starting position within b to write to. - `int`
  len - the maximum number of bytes to read. - `int`

  returns: the number of bytes actually read, or -1
   to indicate EOF. - `int`

  throws: java.io.IOException - if an I/O error occurs."
  (^Integer [^javax.imageio.stream.FileCacheImageOutputStream this b ^Integer off ^Integer len]
    (-> this (.read b off len)))
  (^Integer [^javax.imageio.stream.FileCacheImageOutputStream this]
    (-> this (.read))))

(defn seek
  "Sets the current stream position and resets the bit offset to
   0.  It is legal to seek past the end of the file; an
   EOFException will be thrown only if a read is
   performed.  The file length will not be increased until a write
   is performed.

  pos - a long containing the desired file pointer position. - `long`

  throws: java.lang.IndexOutOfBoundsException - if pos is smaller than the flushed position."
  ([^javax.imageio.stream.FileCacheImageOutputStream this ^Long pos]
    (-> this (.seek pos))))

(defn cached-memory?
  "Returns false since this
   ImageOutputStream does not maintain a main memory
   cache.

  returns: false. - `boolean`"
  (^Boolean [^javax.imageio.stream.FileCacheImageOutputStream this]
    (-> this (.isCachedMemory))))

(defn length
  "Description copied from class: ImageInputStreamImpl

  returns: -1L to indicate unknown length. - `long`"
  (^Long [^javax.imageio.stream.FileCacheImageOutputStream this]
    (-> this (.length))))

(defn close
  "Closes this FileCacheImageOutputStream.  All
   pending data is flushed to the output, and the cache file
   is closed and removed.  The destination OutputStream
   is not closed.

  throws: java.io.IOException - if an error occurs."
  ([^javax.imageio.stream.FileCacheImageOutputStream this]
    (-> this (.close))))

(defn cached-file?
  "Returns true since this
   ImageOutputStream maintains a file cache.

  returns: true. - `boolean`"
  (^Boolean [^javax.imageio.stream.FileCacheImageOutputStream this]
    (-> this (.isCachedFile))))

(defn write
  "Description copied from interface: ImageOutputStream

  b - an array of bytes to be written. - `byte[]`
  off - the start offset in the data. - `int`
  len - the number of bytes to write. - `int`

  throws: java.io.IOException - if an I/O error occurs."
  ([^javax.imageio.stream.FileCacheImageOutputStream this b ^Integer off ^Integer len]
    (-> this (.write b off len)))
  ([^javax.imageio.stream.FileCacheImageOutputStream this ^Integer b]
    (-> this (.write b))))

(defn cached?
  "Returns true since this
   ImageOutputStream caches data in order to allow
   seeking backwards.

  returns: true. - `boolean`"
  (^Boolean [^javax.imageio.stream.FileCacheImageOutputStream this]
    (-> this (.isCached))))

