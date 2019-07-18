(ns jdk.util.concurrent.CompletionException
  "Exception thrown when an error or other exception is encountered
  in the course of completing a result or task."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.util.concurrent CompletionException]))

(defn ->completion-exception
  "Constructor.

  Constructs a CompletionException with the specified detail
   message and cause.

  message - the detail message - `java.lang.String`
  cause - the cause (which is saved for later retrieval by the Throwable.getCause() method) - `java.lang.Throwable`"
  (^CompletionException [^java.lang.String message ^java.lang.Throwable cause]
    (new CompletionException message cause))
  (^CompletionException [^java.lang.Throwable cause]
    (new CompletionException cause)))

