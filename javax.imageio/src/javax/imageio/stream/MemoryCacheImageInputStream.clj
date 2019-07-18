(ns javax.imageio.stream.MemoryCacheImageInputStream
  "An implementation of ImageInputStream that gets its
  input from a regular InputStream.  A memory buffer is
  used to cache at least the data between the discard position and
  the current read position.

   In general, it is preferable to use a
  FileCacheImageInputStream when reading from a regular
  InputStream.  This class is provided for cases where
  it is not possible to create a writable temporary file."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.imageio.stream MemoryCacheImageInputStream]))

(defn ->memory-cache-image-input-stream
  "Constructor.

  Constructs a MemoryCacheImageInputStream that will read
   from a given InputStream.

  stream - an InputStream to read from. - `java.io.InputStream`

  throws: java.lang.IllegalArgumentException - if stream is null."
  (^MemoryCacheImageInputStream [^java.io.InputStream stream]
    (new MemoryCacheImageInputStream stream)))

(defn read
  "Description copied from class: ImageInputStreamImpl

  b - an array of bytes to be written to. - `byte[]`
  off - the starting position within b to write to. - `int`
  len - the maximum number of bytes to read. - `int`

  returns: the number of bytes actually read, or -1
   to indicate EOF. - `int`

  throws: java.io.IOException - if an I/O error occurs."
  (^Integer [^MemoryCacheImageInputStream this b ^Integer off ^Integer len]
    (-> this (.read b off len)))
  (^Integer [^MemoryCacheImageInputStream this]
    (-> this (.read))))

(defn flush-before
  "Description copied from interface: ImageInputStream

  pos - a long containing the length of the stream prefix that may be flushed. - `long`

  throws: java.io.IOException - if an I/O error occurs."
  ([^MemoryCacheImageInputStream this ^Long pos]
    (-> this (.flushBefore pos))))

(defn cached?
  "Returns true since this
   ImageInputStream caches data in order to allow
   seeking backwards.

  returns: true. - `boolean`"
  (^Boolean [^MemoryCacheImageInputStream this]
    (-> this (.isCached))))

(defn cached-file?
  "Returns false since this
   ImageInputStream does not maintain a file cache.

  returns: false. - `boolean`"
  (^Boolean [^MemoryCacheImageInputStream this]
    (-> this (.isCachedFile))))

(defn cached-memory?
  "Returns true since this
   ImageInputStream maintains a main memory cache.

  returns: true. - `boolean`"
  (^Boolean [^MemoryCacheImageInputStream this]
    (-> this (.isCachedMemory))))

(defn close
  "Closes this MemoryCacheImageInputStream, freeing
   the cache.  The source InputStream is not closed.

  throws: java.io.IOException - if an I/O error occurs."
  ([^MemoryCacheImageInputStream this]
    (-> this (.close))))

