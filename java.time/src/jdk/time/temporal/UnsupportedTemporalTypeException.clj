(ns jdk.time.temporal.UnsupportedTemporalTypeException
  "UnsupportedTemporalTypeException indicates that a ChronoField or ChronoUnit is
  not supported for a Temporal class."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.time.temporal UnsupportedTemporalTypeException]))

(defn ->unsupported-temporal-type-exception
  "Constructor.

  Constructs a new UnsupportedTemporalTypeException with the specified message and cause.

  message - the message to use for this exception, may be null - `java.lang.String`
  cause - the cause of the exception, may be null - `java.lang.Throwable`"
  (^UnsupportedTemporalTypeException [^java.lang.String message ^java.lang.Throwable cause]
    (new UnsupportedTemporalTypeException message cause))
  (^UnsupportedTemporalTypeException [^java.lang.String message]
    (new UnsupportedTemporalTypeException message)))

