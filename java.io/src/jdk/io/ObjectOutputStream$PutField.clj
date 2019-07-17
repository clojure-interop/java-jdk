(ns jdk.io.ObjectOutputStream$PutField
  "Provide programmatic access to the persistent fields to be written
  to ObjectOutput."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.io ObjectOutputStream$PutField]))

(defn ->put-field
  "Constructor."
  ([]
    (new ObjectOutputStream$PutField )))

(defn put
  "Put the value of the named boolean field into the persistent field.

  name - the name of the serializable field - `java.lang.String`
  val - the value to assign to the field - `boolean`

  throws: java.lang.IllegalArgumentException - if name does not match the name of a serializable field for the class whose fields are being written, or if the type of the named field is not boolean"
  ([this name val]
    (-> this (.put name val))))

(defn write
  "Deprecated. This method does not write the values contained by this
           PutField object in a proper format, and may
           result in corruption of the serialization stream.  The
           correct way to write PutField data is by
           calling the ObjectOutputStream.writeFields()
           method.

  out - the stream to write the data and fields to - `java.io.ObjectOutput`

  returns: `java.lang.   void`

  throws: java.io.IOException - if I/O errors occur while writing to the underlying stream"
  ([this out]
    (-> this (.write out))))

