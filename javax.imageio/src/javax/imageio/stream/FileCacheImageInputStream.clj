(ns javax.imageio.stream.FileCacheImageInputStream
  "An implementation of ImageInputStream that gets its
  input from a regular InputStream.  A file is used to
  cache previously read data."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.imageio.stream FileCacheImageInputStream]))

(defn ->file-cache-image-input-stream
  "Constructor.

  Constructs a FileCacheImageInputStream that will read
   from a given InputStream.

    A temporary file is used as a cache.  If
   cacheDiris non-null and is a
   directory, the file will be created there.  If it is
   null, the system-dependent default temporary-file
   directory will be used (see the documentation for
   File.createTempFile for details).

  stream - an InputStream to read from. - `java.io.InputStream`
  cache-dir - a File indicating where the cache file should be created, or null to use the system directory. - `java.io.File`

  throws: java.lang.IllegalArgumentException - if cacheDir is non-null but is not a directory."
  ([stream cache-dir]
    (new FileCacheImageInputStream stream cache-dir)))

(defn read
  "Description copied from class: ImageInputStreamImpl

  b - an array of bytes to be written to. - `byte[]`
  off - the starting position within b to write to. - `int`
  len - the maximum number of bytes to read. - `int`

  returns: the number of bytes actually read, or -1
   to indicate EOF. - `int`

  throws: java.io.IOException - if an I/O error occurs."
  ([this b off len]
    (-> this (.read b off len)))
  ([this]
    (-> this (.read))))

(defn cached?
  "Returns true since this
   ImageInputStream caches data in order to allow
   seeking backwards.

  returns: true. - `boolean`"
  ([this]
    (-> this (.isCached))))

(defn cached-file?
  "Returns true since this
   ImageInputStream maintains a file cache.

  returns: true. - `boolean`"
  ([this]
    (-> this (.isCachedFile))))

(defn cached-memory?
  "Returns false since this
   ImageInputStream does not maintain a main memory
   cache.

  returns: false. - `boolean`"
  ([this]
    (-> this (.isCachedMemory))))

(defn close
  "Closes this FileCacheImageInputStream, closing
   and removing the cache file.  The source InputStream
   is not closed.

  throws: java.io.IOException - if an error occurs."
  ([this]
    (-> this (.close))))

