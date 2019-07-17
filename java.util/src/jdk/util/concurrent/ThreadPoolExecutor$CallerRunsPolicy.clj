(ns jdk.util.concurrent.ThreadPoolExecutor$CallerRunsPolicy
  "A handler for rejected tasks that runs the rejected task
  directly in the calling thread of the execute method,
  unless the executor has been shut down, in which case the task
  is discarded."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.util.concurrent ThreadPoolExecutor$CallerRunsPolicy]))

(defn ->caller-runs-policy
  "Constructor.

  Creates a CallerRunsPolicy."
  ([]
    (new ThreadPoolExecutor$CallerRunsPolicy )))

(defn rejected-execution
  "Executes task r in the caller's thread, unless the executor
   has been shut down, in which case the task is discarded.

  r - the runnable task requested to be executed - `java.lang.Runnable`
  e - the executor attempting to execute this task - `java.util.concurrent.ThreadPoolExecutor`"
  ([this r e]
    (-> this (.rejectedExecution r e))))

