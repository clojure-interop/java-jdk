(ns jdk.util.concurrent.RejectedExecutionHandler
  "A handler for tasks that cannot be executed by a ThreadPoolExecutor."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.util.concurrent RejectedExecutionHandler]))

(defn rejected-execution
  "Method that may be invoked by a ThreadPoolExecutor when
   execute cannot accept a
   task.  This may occur when no more threads or queue slots are
   available because their bounds would be exceeded, or upon
   shutdown of the Executor.

   In the absence of other alternatives, the method may throw
   an unchecked RejectedExecutionException, which will be
   propagated to the caller of execute.

  r - the runnable task requested to be executed - `java.lang.Runnable`
  executor - the executor attempting to execute this task - `java.util.concurrent.ThreadPoolExecutor`

  throws: java.util.concurrent.RejectedExecutionException - if there is no remedy"
  ([^RejectedExecutionHandler this ^java.lang.Runnable r ^java.util.concurrent.ThreadPoolExecutor executor]
    (-> this (.rejectedExecution r executor))))

