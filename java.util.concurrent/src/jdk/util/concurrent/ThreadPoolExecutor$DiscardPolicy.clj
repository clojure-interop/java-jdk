(ns jdk.util.concurrent.ThreadPoolExecutor$DiscardPolicy
  "A handler for rejected tasks that silently discards the
  rejected task."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.util.concurrent ThreadPoolExecutor$DiscardPolicy]))

(defn ->discard-policy
  "Constructor.

  Creates a DiscardPolicy."
  (^ThreadPoolExecutor$DiscardPolicy []
    (new ThreadPoolExecutor$DiscardPolicy )))

(defn rejected-execution
  "Does nothing, which has the effect of discarding task r.

  r - the runnable task requested to be executed - `java.lang.Runnable`
  e - the executor attempting to execute this task - `java.util.concurrent.ThreadPoolExecutor`"
  ([^ThreadPoolExecutor$DiscardPolicy this ^java.lang.Runnable r ^java.util.concurrent.ThreadPoolExecutor e]
    (-> this (.rejectedExecution r e))))

