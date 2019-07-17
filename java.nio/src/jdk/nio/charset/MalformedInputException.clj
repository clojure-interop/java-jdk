(ns jdk.nio.charset.MalformedInputException
  "Checked exception thrown when an input byte sequence is not legal for given
  charset, or an input character sequence is not a legal sixteen-bit Unicode
  sequence."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.nio.charset MalformedInputException]))

(defn ->malformed-input-exception
  "Constructor.

  Constructs an MalformedInputException with the given
   length.

  input-length - the length of the input - `int`"
  ([^Integer input-length]
    (new MalformedInputException input-length)))

(defn get-input-length
  "Returns the length of the input.

  returns: the length of the input - `int`"
  ([^java.nio.charset.MalformedInputException this]
    (-> this (.getInputLength))))

(defn get-message
  "Returns the message.

  returns: the message - `java.lang.String`"
  ([^java.nio.charset.MalformedInputException this]
    (-> this (.getMessage))))

