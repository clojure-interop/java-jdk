(ns jdk.time.format.DateTimeParseException
  "An exception thrown when an error occurs during parsing.

  This exception includes the text being parsed and the error index."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.time.format DateTimeParseException]))

(defn ->date-time-parse-exception
  "Constructor.

  Constructs a new exception with the specified message and cause.

  message - the message to use for this exception, may be null - `java.lang.String`
  parsed-data - the parsed text, should not be null - `java.lang.CharSequence`
  error-index - the index in the parsed string that was invalid, should be a valid index - `int`
  cause - the cause exception, may be null - `java.lang.Throwable`"
  ([^java.lang.String message ^java.lang.CharSequence parsed-data ^Integer error-index ^java.lang.Throwable cause]
    (new DateTimeParseException message parsed-data error-index cause))
  ([^java.lang.String message ^java.lang.CharSequence parsed-data ^Integer error-index]
    (new DateTimeParseException message parsed-data error-index)))

(defn get-parsed-string
  "Returns the string that was being parsed.

  returns: the string that was being parsed, should not be null. - `java.lang.String`"
  ([^java.time.format.DateTimeParseException this]
    (-> this (.getParsedString))))

(defn get-error-index
  "Returns the index where the error was found.

  returns: the index in the parsed string that was invalid, should be a valid index - `int`"
  ([^java.time.format.DateTimeParseException this]
    (-> this (.getErrorIndex))))

