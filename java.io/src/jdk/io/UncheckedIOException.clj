(ns jdk.io.UncheckedIOException
  "Wraps an IOException with an unchecked exception."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.io UncheckedIOException]))

(defn ->unchecked-io-exception
  "Constructor.

  Constructs an instance of this class.

  message - the detail message, can be null - `java.lang.String`
  cause - the IOException - `java.io.IOException`

  throws: java.lang.NullPointerException - if the cause is null"
  ([^java.lang.String message ^java.io.IOException cause]
    (new UncheckedIOException message cause))
  ([^java.io.IOException cause]
    (new UncheckedIOException cause)))

(defn get-cause
  "Returns the cause of this exception.

  returns: the IOException which is the cause of this exception. - `java.io.IOException`"
  (^java.io.IOException [^java.io.UncheckedIOException this]
    (-> this (.getCause))))

