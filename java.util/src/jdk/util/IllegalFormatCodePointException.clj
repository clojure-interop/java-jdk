(ns jdk.util.IllegalFormatCodePointException
  "Unchecked exception thrown when a character with an invalid Unicode code
  point as defined by Character.isValidCodePoint(int) is passed to the
  Formatter.

   Unless otherwise specified, passing a null argument to any
  method or constructor in this class will cause a NullPointerException to be thrown."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.util IllegalFormatCodePointException]))

(defn ->illegal-format-code-point-exception
  "Constructor.

  Constructs an instance of this class with the specified illegal code
   point as defined by Character.isValidCodePoint(int).

  c - The illegal Unicode code point - `int`"
  ([^Integer c]
    (new IllegalFormatCodePointException c)))

(defn get-code-point
  "Returns the illegal code point as defined by Character.isValidCodePoint(int).

  returns: The illegal Unicode code point - `int`"
  (^Integer [^java.util.IllegalFormatCodePointException this]
    (-> this (.getCodePoint))))

(defn get-message
  "Description copied from class: Throwable

  returns: the detail message string of this Throwable instance
            (which may be null). - `java.lang.String`"
  (^java.lang.String [^java.util.IllegalFormatCodePointException this]
    (-> this (.getMessage))))

