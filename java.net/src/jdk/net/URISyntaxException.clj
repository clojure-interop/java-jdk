(ns jdk.net.URISyntaxException
  "Checked exception thrown to indicate that a string could not be parsed as a
  URI reference."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.net URISyntaxException]))

(defn ->uri-syntax-exception
  "Constructor.

  Constructs an instance from the given input string, reason, and error
   index.

  input - The input string - `java.lang.String`
  reason - A string explaining why the input could not be parsed - `java.lang.String`
  index - The index at which the parse error occurred, or -1 if the index is not known - `int`

  throws: java.lang.NullPointerException - If either the input or reason strings are null"
  (^URISyntaxException [^java.lang.String input ^java.lang.String reason ^Integer index]
    (new URISyntaxException input reason index))
  (^URISyntaxException [^java.lang.String input ^java.lang.String reason]
    (new URISyntaxException input reason)))

(defn get-input
  "Returns the input string.

  returns: The input string - `java.lang.String`"
  (^java.lang.String [^URISyntaxException this]
    (-> this (.getInput))))

(defn get-reason
  "Returns a string explaining why the input string could not be parsed.

  returns: The reason string - `java.lang.String`"
  (^java.lang.String [^URISyntaxException this]
    (-> this (.getReason))))

(defn get-index
  "Returns an index into the input string of the position at which the
   parse error occurred, or -1 if this position is not known.

  returns: The error index - `int`"
  (^Integer [^URISyntaxException this]
    (-> this (.getIndex))))

(defn get-message
  "Returns a string describing the parse error.  The resulting string
   consists of the reason string followed by a colon character
   (':'), a space, and the input string.  If the error index is
   defined then the string ` at index ` followed by the index, in
   decimal, is inserted after the reason string and before the colon
   character.

  returns: A string describing the parse error - `java.lang.String`"
  (^java.lang.String [^URISyntaxException this]
    (-> this (.getMessage))))

