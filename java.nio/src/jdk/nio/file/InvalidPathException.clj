(ns jdk.nio.file.InvalidPathException
  "Unchecked exception thrown when path string cannot be converted into a
  Path because the path string contains invalid characters, or
  the path string is invalid for other file system specific reasons."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.nio.file InvalidPathException]))

(defn ->invalid-path-exception
  "Constructor.

  Constructs an instance from the given input string, reason, and error
   index.

  input - the input string - `java.lang.String`
  reason - a string explaining why the input was rejected - `java.lang.String`
  index - the index at which the error occurred, or -1 if the index is not known - `int`

  throws: java.lang.NullPointerException - if either the input or reason strings are null"
  (^InvalidPathException [^java.lang.String input ^java.lang.String reason ^Integer index]
    (new InvalidPathException input reason index))
  (^InvalidPathException [^java.lang.String input ^java.lang.String reason]
    (new InvalidPathException input reason)))

(defn get-input
  "Returns the input string.

  returns: the input string - `java.lang.String`"
  (^java.lang.String [^InvalidPathException this]
    (-> this (.getInput))))

(defn get-reason
  "Returns a string explaining why the input string was rejected.

  returns: the reason string - `java.lang.String`"
  (^java.lang.String [^InvalidPathException this]
    (-> this (.getReason))))

(defn get-index
  "Returns an index into the input string of the position at which the
   error occurred, or -1 if this position is not known.

  returns: the error index - `int`"
  (^Integer [^InvalidPathException this]
    (-> this (.getIndex))))

(defn get-message
  "Returns a string describing the error.  The resulting string
   consists of the reason string followed by a colon character
   (':'), a space, and the input string.  If the error index is
   defined then the string ` at index ` followed by the index, in
   decimal, is inserted after the reason string and before the colon
   character.

  returns: a string describing the error - `java.lang.String`"
  (^java.lang.String [^InvalidPathException this]
    (-> this (.getMessage))))

