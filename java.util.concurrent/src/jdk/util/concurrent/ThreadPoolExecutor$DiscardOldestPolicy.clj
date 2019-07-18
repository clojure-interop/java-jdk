(ns jdk.util.concurrent.ThreadPoolExecutor$DiscardOldestPolicy
  "A handler for rejected tasks that discards the oldest unhandled
  request and then retries execute, unless the executor
  is shut down, in which case the task is discarded."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.util.concurrent ThreadPoolExecutor$DiscardOldestPolicy]))

(defn ->discard-oldest-policy
  "Constructor.

  Creates a DiscardOldestPolicy for the given executor."
  (^ThreadPoolExecutor$DiscardOldestPolicy []
    (new ThreadPoolExecutor$DiscardOldestPolicy )))

(defn rejected-execution
  "Obtains and ignores the next task that the executor
   would otherwise execute, if one is immediately available,
   and then retries execution of task r, unless the executor
   is shut down, in which case task r is instead discarded.

  r - the runnable task requested to be executed - `java.lang.Runnable`
  e - the executor attempting to execute this task - `java.util.concurrent.ThreadPoolExecutor`"
  ([^ThreadPoolExecutor$DiscardOldestPolicy this ^java.lang.Runnable r ^java.util.concurrent.ThreadPoolExecutor e]
    (-> this (.rejectedExecution r e))))

