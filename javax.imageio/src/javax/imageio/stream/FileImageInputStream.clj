(ns javax.imageio.stream.FileImageInputStream
  "An implementation of ImageInputStream that gets its
  input from a File or RandomAccessFile.
  The file contents are assumed to be stable during the lifetime of
  the object."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.imageio.stream FileImageInputStream]))

(defn ->file-image-input-stream
  "Constructor.

  Constructs a FileImageInputStream that will read
   from a given File.

    The file contents must not change between the time this
   object is constructed and the time of the last call to a read
   method.

  f - a File to read from. - `java.io.File`

  throws: java.lang.IllegalArgumentException - if f is null."
  (^FileImageInputStream [^java.io.File f]
    (new FileImageInputStream f)))

(defn read
  "Description copied from class: ImageInputStreamImpl

  b - an array of bytes to be written to. - `byte[]`
  off - the starting position within b to write to. - `int`
  len - the maximum number of bytes to read. - `int`

  returns: the number of bytes actually read, or -1
   to indicate EOF. - `int`

  throws: java.io.IOException - if an I/O error occurs."
  (^Integer [^FileImageInputStream this b ^Integer off ^Integer len]
    (-> this (.read b off len)))
  (^Integer [^FileImageInputStream this]
    (-> this (.read))))

(defn length
  "Returns the length of the underlying file, or -1
   if it is unknown.

  returns: the file length as a long, or
   -1. - `long`"
  (^Long [^FileImageInputStream this]
    (-> this (.length))))

(defn seek
  "Description copied from interface: ImageInputStream

  pos - a long containing the desired file pointer position. - `long`

  throws: java.io.IOException - if any other I/O error occurs."
  ([^FileImageInputStream this ^Long pos]
    (-> this (.seek pos))))

(defn close
  "Description copied from interface: ImageInputStream

  throws: java.io.IOException - if an I/O error occurs."
  ([^FileImageInputStream this]
    (-> this (.close))))

