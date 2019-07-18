(ns jdk.util.concurrent.ThreadPoolExecutor$AbortPolicy
  "A handler for rejected tasks that throws a
  RejectedExecutionException."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.util.concurrent ThreadPoolExecutor$AbortPolicy]))

(defn ->abort-policy
  "Constructor.

  Creates an AbortPolicy."
  (^ThreadPoolExecutor$AbortPolicy []
    (new ThreadPoolExecutor$AbortPolicy )))

(defn rejected-execution
  "Always throws RejectedExecutionException.

  r - the runnable task requested to be executed - `java.lang.Runnable`
  e - the executor attempting to execute this task - `java.util.concurrent.ThreadPoolExecutor`

  throws: java.util.concurrent.RejectedExecutionException - always"
  ([^ThreadPoolExecutor$AbortPolicy this ^java.lang.Runnable r ^java.util.concurrent.ThreadPoolExecutor e]
    (-> this (.rejectedExecution r e))))

