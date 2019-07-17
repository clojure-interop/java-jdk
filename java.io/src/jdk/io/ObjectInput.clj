(ns jdk.io.ObjectInput
  "ObjectInput extends the DataInput interface to include the reading of
  objects. DataInput includes methods for the input of primitive types,
  ObjectInput extends that interface to include objects, arrays, and Strings."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.io ObjectInput]))

(defn read-object
  "Read and return an object. The class that implements this interface
   defines where the object is `read` from.

  returns: the object read from the stream - `java.lang.Object`

  throws: java.lang.ClassNotFoundException - If the class of a serialized object cannot be found."
  (^java.lang.Object [^java.io.ObjectInput this]
    (-> this (.readObject))))

(defn read
  "Reads into an array of bytes.  This method will
   block until some input is available.

  b - the buffer into which the data is read - `byte[]`
  off - the start offset of the data - `int`
  len - the maximum number of bytes read - `int`

  returns: the actual number of bytes read, -1 is
            returned when the end of the stream is reached. - `int`

  throws: java.io.IOException - If an I/O error has occurred."
  (^Integer [^java.io.ObjectInput this b ^Integer off ^Integer len]
    (-> this (.read b off len)))
  (^Integer [^java.io.ObjectInput this b]
    (-> this (.read b)))
  (^Integer [^java.io.ObjectInput this]
    (-> this (.read))))

(defn skip
  "Skips n bytes of input.

  n - the number of bytes to be skipped - `long`

  returns: the actual number of bytes skipped. - `long`

  throws: java.io.IOException - If an I/O error has occurred."
  (^Long [^java.io.ObjectInput this ^Long n]
    (-> this (.skip n))))

(defn available
  "Returns the number of bytes that can be read
   without blocking.

  returns: the number of available bytes. - `int`

  throws: java.io.IOException - If an I/O error has occurred."
  (^Integer [^java.io.ObjectInput this]
    (-> this (.available))))

(defn close
  "Closes the input stream. Must be called
   to release any resources associated with
   the stream.

  throws: java.io.IOException - If an I/O error has occurred."
  ([^java.io.ObjectInput this]
    (-> this (.close))))

