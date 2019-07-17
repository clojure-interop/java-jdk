(ns jdk.util.zip.Checksum
  "An interface representing a data checksum."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.util.zip Checksum]))

(defn update
  "Updates the current checksum with the specified array of bytes.

  b - the byte array to update the checksum with - `byte[]`
  off - the start offset of the data - `int`
  len - the number of bytes to use for the update - `int`"
  ([^java.util.zip.Checksum this b ^Integer off ^Integer len]
    (-> this (.update b off len)))
  ([^java.util.zip.Checksum this ^Integer b]
    (-> this (.update b))))

(defn get-value
  "Returns the current checksum value.

  returns: the current checksum value - `long`"
  (^Long [^java.util.zip.Checksum this]
    (-> this (.getValue))))

(defn reset
  "Resets the checksum to its initial value."
  ([^java.util.zip.Checksum this]
    (-> this (.reset))))

