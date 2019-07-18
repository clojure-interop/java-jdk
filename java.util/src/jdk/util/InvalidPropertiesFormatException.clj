(ns jdk.util.InvalidPropertiesFormatException
  "Thrown to indicate that an operation could not complete because
  the input did not conform to the appropriate XML document type
  for a collection of properties, as per the Properties
  specification.

  Note, that although InvalidPropertiesFormatException inherits Serializable
  interface from Exception, it is not intended to be Serializable. Appropriate
  serialization methods are implemented to throw NotSerializableException."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.util InvalidPropertiesFormatException]))

(defn ->invalid-properties-format-exception
  "Constructor.

  Constructs an InvalidPropertiesFormatException with the specified
   cause.

  cause - the cause (which is saved for later retrieval by the Throwable.getCause() method). - `java.lang.Throwable`"
  (^InvalidPropertiesFormatException [^java.lang.Throwable cause]
    (new InvalidPropertiesFormatException cause)))

