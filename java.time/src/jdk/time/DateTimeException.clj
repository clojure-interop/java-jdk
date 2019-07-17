(ns jdk.time.DateTimeException
  "Exception used to indicate a problem while calculating a date-time.

  This exception is used to indicate problems with creating, querying
  and manipulating date-time objects."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.time DateTimeException]))

(defn ->date-time-exception
  "Constructor.

  Constructs a new date-time exception with the specified message and cause.

  message - the message to use for this exception, may be null - `java.lang.String`
  cause - the cause of the exception, may be null - `java.lang.Throwable`"
  ([^java.lang.String message ^java.lang.Throwable cause]
    (new DateTimeException message cause))
  ([^java.lang.String message]
    (new DateTimeException message)))

