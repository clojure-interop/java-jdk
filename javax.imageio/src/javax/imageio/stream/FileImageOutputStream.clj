(ns javax.imageio.stream.FileImageOutputStream
  "An implementation of ImageOutputStream that writes its
  output directly to a File or
  RandomAccessFile."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.imageio.stream FileImageOutputStream]))

(defn ->file-image-output-stream
  "Constructor.

  Constructs a FileImageOutputStream that will write
   to a given File.

  f - a File to write to. - `java.io.File`

  throws: java.lang.IllegalArgumentException - if f is null."
  ([f]
    (new FileImageOutputStream f)))

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

(defn write
  "Description copied from interface: ImageOutputStream

  b - an array of bytes to be written. - `byte[]`
  off - the start offset in the data. - `int`
  len - the number of bytes to write. - `int`

  throws: java.io.IOException - if an I/O error occurs."
  ([this b off len]
    (-> this (.write b off len)))
  ([this b]
    (-> this (.write b))))

(defn length
  "Description copied from class: ImageInputStreamImpl

  returns: -1L to indicate unknown length. - `long`"
  ([this]
    (-> this (.length))))

(defn seek
  "Sets the current stream position and resets the bit offset to
   0.  It is legal to seeking past the end of the file; an
   EOFException will be thrown only if a read is
   performed.  The file length will not be increased until a write
   is performed.

  pos - a long containing the desired file pointer position. - `long`

  throws: java.lang.IndexOutOfBoundsException - if pos is smaller than the flushed position."
  ([this pos]
    (-> this (.seek pos))))

(defn close
  "Description copied from interface: ImageInputStream

  throws: java.io.IOException - if an I/O error occurs."
  ([this]
    (-> this (.close))))

