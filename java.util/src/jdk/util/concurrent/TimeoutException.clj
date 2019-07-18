(ns jdk.util.concurrent.TimeoutException
  "Exception thrown when a blocking operation times out.  Blocking
  operations for which a timeout is specified need a means to
  indicate that the timeout has occurred. For many such operations it
  is possible to return a value that indicates timeout; when that is
  not possible or desirable then TimeoutException should be
  declared and thrown."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.util.concurrent TimeoutException]))

(defn ->timeout-exception
  "Constructor.

  Constructs a TimeoutException with the specified detail
   message.

  message - the detail message - `java.lang.String`"
  (^TimeoutException [^java.lang.String message]
    (new TimeoutException message))
  (^TimeoutException []
    (new TimeoutException )))

