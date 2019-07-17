(ns jdk.util.concurrent.ExecutionException
  "Exception thrown when attempting to retrieve the result of a task
  that aborted by throwing an exception. This exception can be
  inspected using the Throwable.getCause() method."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.util.concurrent ExecutionException]))

(defn ->execution-exception
  "Constructor.

  Constructs an ExecutionException with the specified detail
   message and cause.

  message - the detail message - `java.lang.String`
  cause - the cause (which is saved for later retrieval by the Throwable.getCause() method) - `java.lang.Throwable`"
  ([^java.lang.String message ^java.lang.Throwable cause]
    (new ExecutionException message cause))
  ([^java.lang.Throwable cause]
    (new ExecutionException cause)))

