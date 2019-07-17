(ns jdk.util.zip.CRC32
  "A class that can be used to compute the CRC-32 of a data stream.

   Passing a null argument to a method in this class will cause
  a NullPointerException to be thrown."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.util.zip CRC32]))

(defn ->crc-32
  "Constructor.

  Creates a new CRC32 object."
  ([]
    (new CRC32 )))

(defn update
  "Updates the CRC-32 checksum with the specified array of bytes.

  b - the byte array to update the checksum with - `byte[]`
  off - the start offset of the data - `int`
  len - the number of bytes to use for the update - `int`

  throws: java.lang.ArrayIndexOutOfBoundsException - if off is negative, or len is negative, or off+len is greater than the length of the array b"
  ([^java.util.zip.CRC32 this b ^Integer off ^Integer len]
    (-> this (.update b off len)))
  ([^java.util.zip.CRC32 this ^Integer b]
    (-> this (.update b))))

(defn reset
  "Resets CRC-32 to initial value."
  ([^java.util.zip.CRC32 this]
    (-> this (.reset))))

(defn get-value
  "Returns CRC-32 value.

  returns: the current checksum value - `long`"
  (^Long [^java.util.zip.CRC32 this]
    (-> this (.getValue))))

