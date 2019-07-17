(ns jdk.util.concurrent.CancellationException
  "Exception indicating that the result of a value-producing task,
  such as a FutureTask, cannot be retrieved because the task
  was cancelled."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.util.concurrent CancellationException]))

(defn ->cancellation-exception
  "Constructor.

  Constructs a CancellationException with the specified detail
   message.

  message - the detail message - `java.lang.String`"
  ([message]
    (new CancellationException message))
  ([]
    (new CancellationException )))

