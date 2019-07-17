(ns jdk.lang.reflect.GenericSignatureFormatError
  "Thrown when a syntactically malformed signature attribute is
  encountered by a reflective method that needs to interpret the
  generic signature information for a type, method or constructor."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.lang.reflect GenericSignatureFormatError]))

(defn ->generic-signature-format-error
  "Constructor.

  Constructs a new GenericSignatureFormatError with the
   specified message.

  message - the detail message, may be null - `java.lang.String`"
  ([message]
    (new GenericSignatureFormatError message))
  ([]
    (new GenericSignatureFormatError )))

