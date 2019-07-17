(ns jdk.nio.charset.UnmappableCharacterException
  "Checked exception thrown when an input character (or byte) sequence
  is valid but cannot be mapped to an output byte (or character)
  sequence."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.nio.charset UnmappableCharacterException]))

(defn ->unmappable-character-exception
  "Constructor.

  Constructs an UnmappableCharacterException with the
   given length.

  input-length - the length of the input - `int`"
  ([input-length]
    (new UnmappableCharacterException input-length)))

(defn get-input-length
  "Returns the length of the input.

  returns: the length of the input - `int`"
  ([this]
    (-> this (.getInputLength))))

(defn get-message
  "Returns the message.

  returns: the message - `java.lang.String`"
  ([this]
    (-> this (.getMessage))))

