(ns jdk.util.concurrent.RejectedExecutionException
  "Exception thrown by an Executor when a task cannot be
  accepted for execution."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.util.concurrent RejectedExecutionException]))

(defn ->rejected-execution-exception
  "Constructor.

  Constructs a RejectedExecutionException with the
   specified detail message and cause.

  message - the detail message - `java.lang.String`
  cause - the cause (which is saved for later retrieval by the Throwable.getCause() method) - `java.lang.Throwable`"
  (^RejectedExecutionException [^java.lang.String message ^java.lang.Throwable cause]
    (new RejectedExecutionException message cause))
  (^RejectedExecutionException [^java.lang.String message]
    (new RejectedExecutionException message))
  (^RejectedExecutionException []
    (new RejectedExecutionException )))

