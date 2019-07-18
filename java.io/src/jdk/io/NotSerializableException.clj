(ns jdk.io.NotSerializableException
  "Thrown when an instance is required to have a Serializable interface.
  The serialization runtime or the class of the instance can throw
  this exception. The argument should be the name of the class."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.io NotSerializableException]))

(defn ->not-serializable-exception
  "Constructor.

  Constructs a NotSerializableException object with message string.

  classname - Class of the instance being serialized/deserialized. - `java.lang.String`"
  (^NotSerializableException [^java.lang.String classname]
    (new NotSerializableException classname))
  (^NotSerializableException []
    (new NotSerializableException )))

