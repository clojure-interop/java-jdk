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
  ([message cause]
    (new RejectedExecutionException message cause))
  ([message]
    (new RejectedExecutionException message))
  ([]
    (new RejectedExecutionException )))

