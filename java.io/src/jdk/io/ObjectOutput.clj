(ns jdk.io.ObjectOutput
  "ObjectOutput extends the DataOutput interface to include writing of objects.
  DataOutput includes methods for output of primitive types, ObjectOutput
  extends that interface to include objects, arrays, and Strings."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.io ObjectOutput]))

(defn write-object
  "Write an object to the underlying storage or stream.  The
   class that implements this interface defines how the object is
   written.

  obj - the object to be written - `java.lang.Object`

  throws: java.io.IOException - Any of the usual Input/Output related exceptions."
  ([^ObjectOutput this ^java.lang.Object obj]
    (-> this (.writeObject obj))))

(defn write
  "Writes a sub array of bytes.

  b - the data to be written - `byte[]`
  off - the start offset in the data - `int`
  len - the number of bytes that are written - `int`

  throws: java.io.IOException - If an I/O error has occurred."
  ([^ObjectOutput this b ^Integer off ^Integer len]
    (-> this (.write b off len)))
  ([^ObjectOutput this ^Integer b]
    (-> this (.write b))))

(defn flush
  "Flushes the stream. This will write any buffered
   output bytes.

  throws: java.io.IOException - If an I/O error has occurred."
  ([^ObjectOutput this]
    (-> this (.flush))))

(defn close
  "Closes the stream. This method must be called
   to release any resources associated with the
   stream.

  throws: java.io.IOException - If an I/O error has occurred."
  ([^ObjectOutput this]
    (-> this (.close))))

