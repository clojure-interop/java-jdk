(ns javax.imageio.stream.MemoryCacheImageOutputStream
  "An implementation of ImageOutputStream that writes its
  output to a regular OutputStream.  A memory buffer is
  used to cache at least the data between the discard position and
  the current write position.  The only constructor takes an
  OutputStream, so this class may not be used for
  read/modify/write operations.  Reading can occur only on parts of
  the stream that have already been written to the cache and not
  yet flushed."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.imageio.stream MemoryCacheImageOutputStream]))

(defn ->memory-cache-image-output-stream
  "Constructor.

  Constructs a MemoryCacheImageOutputStream that will write
   to a given OutputStream.

  stream - an OutputStream to write to. - `java.io.OutputStream`

  throws: java.lang.IllegalArgumentException - if stream is null."
  (^MemoryCacheImageOutputStream [^java.io.OutputStream stream]
    (new MemoryCacheImageOutputStream stream)))

(defn read
  "Description copied from class: ImageInputStreamImpl

  b - an array of bytes to be written to. - `byte[]`
  off - the starting position within b to write to. - `int`
  len - the maximum number of bytes to read. - `int`

  returns: the number of bytes actually read, or -1
   to indicate EOF. - `int`

  throws: java.io.IOException - if an I/O error occurs."
  (^Integer [^MemoryCacheImageOutputStream this b ^Integer off ^Integer len]
    (-> this (.read b off len)))
  (^Integer [^MemoryCacheImageOutputStream this]
    (-> this (.read))))

(defn write
  "Description copied from interface: ImageOutputStream

  b - an array of bytes to be written. - `byte[]`
  off - the start offset in the data. - `int`
  len - the number of bytes to write. - `int`

  throws: java.io.IOException - if an I/O error occurs."
  ([^MemoryCacheImageOutputStream this b ^Integer off ^Integer len]
    (-> this (.write b off len)))
  ([^MemoryCacheImageOutputStream this ^Integer b]
    (-> this (.write b))))

(defn length
  "Description copied from class: ImageInputStreamImpl

  returns: -1L to indicate unknown length. - `long`"
  (^Long [^MemoryCacheImageOutputStream this]
    (-> this (.length))))

(defn cached?
  "Returns true since this
   ImageOutputStream caches data in order to allow
   seeking backwards.

  returns: true. - `boolean`"
  (^Boolean [^MemoryCacheImageOutputStream this]
    (-> this (.isCached))))

(defn cached-file?
  "Returns false since this
   ImageOutputStream does not maintain a file cache.

  returns: false. - `boolean`"
  (^Boolean [^MemoryCacheImageOutputStream this]
    (-> this (.isCachedFile))))

(defn cached-memory?
  "Returns true since this
   ImageOutputStream maintains a main memory cache.

  returns: true. - `boolean`"
  (^Boolean [^MemoryCacheImageOutputStream this]
    (-> this (.isCachedMemory))))

(defn close
  "Closes this MemoryCacheImageOutputStream.  All
   pending data is flushed to the output, and the cache
   is released.  The destination OutputStream
   is not closed.

  throws: java.io.IOException - if an I/O error occurs."
  ([^MemoryCacheImageOutputStream this]
    (-> this (.close))))

(defn flush-before
  "Description copied from interface: ImageInputStream

  pos - a long containing the length of the stream prefix that may be flushed. - `long`

  throws: java.io.IOException - if an I/O error occurs."
  ([^MemoryCacheImageOutputStream this ^Long pos]
    (-> this (.flushBefore pos))))

