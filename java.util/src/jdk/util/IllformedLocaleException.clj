(ns jdk.util.IllformedLocaleException
  "Thrown by methods in Locale and Locale.Builder to
  indicate that an argument is not a well-formed BCP 47 tag."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.util IllformedLocaleException]))

(defn ->illformed-locale-exception
  "Constructor.

  Constructs a new IllformedLocaleException with the
   given message and the error index.  The error index is the approximate
   offset from the start of the ill-formed value to the point where the
   parse first detected an error.  A negative error index value indicates
   either the error index is not applicable or unknown.

  message - the message - `java.lang.String`
  error-index - the index - `int`"
  ([message error-index]
    (new IllformedLocaleException message error-index))
  ([message]
    (new IllformedLocaleException message))
  ([]
    (new IllformedLocaleException )))

(defn get-error-index
  "Returns the index where the error was found. A negative value indicates
   either the error index is not applicable or unknown.

  returns: the error index - `int`"
  ([this]
    (-> this (.getErrorIndex))))

