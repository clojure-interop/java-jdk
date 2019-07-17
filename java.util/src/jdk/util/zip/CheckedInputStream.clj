(ns jdk.util.zip.CheckedInputStream
  "An input stream that also maintains a checksum of the data being read.
  The checksum can then be used to verify the integrity of the input data."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.util.zip CheckedInputStream]))

(defn ->checked-input-stream
  "Constructor.

  Creates an input stream using the specified Checksum.

  in - the input stream - `java.io.InputStream`
  cksum - the Checksum - `java.util.zip.Checksum`"
  ([^java.io.InputStream in ^java.util.zip.Checksum cksum]
    (new CheckedInputStream in cksum)))

(defn read
  "Reads into an array of bytes. If len is not zero, the method
   blocks until some input is available; otherwise, no
   bytes are read and 0 is returned.

  buf - the buffer into which the data is read - `byte[]`
  off - the start offset in the destination array b - `int`
  len - the maximum number of bytes read - `int`

  returns: the actual number of bytes read, or -1 if the end
              of the stream is reached. - `int`

  throws: java.lang.NullPointerException - If buf is null."
  ([^java.util.zip.CheckedInputStream this buf ^Integer off ^Integer len]
    (-> this (.read buf off len)))
  ([^java.util.zip.CheckedInputStream this]
    (-> this (.read))))

(defn skip
  "Skips specified number of bytes of input.

  n - the number of bytes to skip - `long`

  returns: the actual number of bytes skipped - `long`

  throws: java.io.IOException - if an I/O error has occurred"
  ([^java.util.zip.CheckedInputStream this ^Long n]
    (-> this (.skip n))))

(defn get-checksum
  "Returns the Checksum for this input stream.

  returns: the Checksum value - `java.util.zip.Checksum`"
  ([^java.util.zip.CheckedInputStream this]
    (-> this (.getChecksum))))

