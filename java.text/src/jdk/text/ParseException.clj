(ns jdk.text.ParseException
  "Signals that an error has been reached unexpectedly
  while parsing."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.text ParseException]))

(defn ->parse-exception
  "Constructor.

  Constructs a ParseException with the specified detail message and
   offset.
   A detail message is a String that describes this particular exception.

  s - the detail message - `java.lang.String`
  error-offset - the position where the error is found while parsing. - `int`"
  ([^java.lang.String s ^Integer error-offset]
    (new ParseException s error-offset)))

(defn get-error-offset
  "Returns the position where the error was found.

  returns: the position where the error was found - `int`"
  (^Integer [^java.text.ParseException this]
    (-> this (.getErrorOffset))))

