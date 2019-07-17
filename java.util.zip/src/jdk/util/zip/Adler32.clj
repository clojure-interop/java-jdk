(ns jdk.util.zip.Adler32
  "A class that can be used to compute the Adler-32 checksum of a data
  stream. An Adler-32 checksum is almost as reliable as a CRC-32 but
  can be computed much faster.

   Passing a null argument to a method in this class will cause
  a NullPointerException to be thrown."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.util.zip Adler32]))

(defn ->adler-32
  "Constructor.

  Creates a new Adler32 object."
  ([]
    (new Adler32 )))

(defn update
  "Updates the checksum with the specified array of bytes.

  b - the byte array to update the checksum with - `byte[]`
  off - the start offset of the data - `int`
  len - the number of bytes to use for the update - `int`

  throws: java.lang.ArrayIndexOutOfBoundsException - if off is negative, or len is negative, or off+len is greater than the length of the array b"
  ([this b off len]
    (-> this (.update b off len)))
  ([this b]
    (-> this (.update b))))

(defn reset
  "Resets the checksum to initial value."
  ([this]
    (-> this (.reset))))

(defn get-value
  "Returns the checksum value.

  returns: the current checksum value - `long`"
  ([this]
    (-> this (.getValue))))

