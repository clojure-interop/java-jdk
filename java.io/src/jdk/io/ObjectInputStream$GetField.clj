(ns jdk.io.ObjectInputStream$GetField
  "Provide access to the persistent fields read from the input stream."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.io ObjectInputStream$GetField]))

(defn ->get-field
  "Constructor."
  ([]
    (new ObjectInputStream$GetField )))

(defn get-object-stream-class
  "Get the ObjectStreamClass that describes the fields in the stream.

  returns: the descriptor class that describes the serializable fields - `java.io.ObjectStreamClass`"
  ([^java.io.ObjectInputStream$GetField this]
    (-> this (.getObjectStreamClass))))

(defn defaulted
  "Return true if the named field is defaulted and has no value in this
   stream.

  name - the name of the field - `java.lang.String`

  returns: true, if and only if the named field is defaulted - `boolean`

  throws: java.io.IOException - if there are I/O errors while reading from the underlying InputStream"
  ([^java.io.ObjectInputStream$GetField this ^java.lang.String name]
    (-> this (.defaulted name))))

(defn get
  "Get the value of the named boolean field from the persistent field.

  name - the name of the field - `java.lang.String`
  val - the default value to use if name does not have a value - `boolean`

  returns: the value of the named boolean field - `boolean`

  throws: java.io.IOException - if there are I/O errors while reading from the underlying InputStream"
  ([^java.io.ObjectInputStream$GetField this ^java.lang.String name ^Boolean val]
    (-> this (.get name val))))

