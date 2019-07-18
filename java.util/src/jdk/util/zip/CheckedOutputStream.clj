(ns jdk.util.zip.CheckedOutputStream
  "An output stream that also maintains a checksum of the data being
  written. The checksum can then be used to verify the integrity of
  the output data."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.util.zip CheckedOutputStream]))

(defn ->checked-output-stream
  "Constructor.

  Creates an output stream with the specified Checksum.

  out - the output stream - `java.io.OutputStream`
  cksum - the checksum - `java.util.zip.Checksum`"
  (^CheckedOutputStream [^java.io.OutputStream out ^java.util.zip.Checksum cksum]
    (new CheckedOutputStream out cksum)))

(defn write
  "Writes an array of bytes. Will block until the bytes are
   actually written.

  b - the data to be written - `byte[]`
  off - the start offset of the data - `int`
  len - the number of bytes to be written - `int`

  throws: java.io.IOException - if an I/O error has occurred"
  ([^CheckedOutputStream this b ^Integer off ^Integer len]
    (-> this (.write b off len)))
  ([^CheckedOutputStream this ^Integer b]
    (-> this (.write b))))

(defn get-checksum
  "Returns the Checksum for this output stream.

  returns: the Checksum - `java.util.zip.Checksum`"
  (^java.util.zip.Checksum [^CheckedOutputStream this]
    (-> this (.getChecksum))))

