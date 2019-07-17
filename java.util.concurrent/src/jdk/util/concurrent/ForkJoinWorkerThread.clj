(ns jdk.util.concurrent.ForkJoinWorkerThread
  "A thread managed by a ForkJoinPool, which executes
  ForkJoinTasks.
  This class is subclassable solely for the sake of adding
  functionality -- there are no overridable methods dealing with
  scheduling or execution.  However, you can override initialization
  and termination methods surrounding the main task processing loop.
  If you do create such a subclass, you will also need to supply a
  custom ForkJoinPool.ForkJoinWorkerThreadFactory to
  use it in a ForkJoinPool."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.util.concurrent ForkJoinWorkerThread]))

(defn get-pool
  "Returns the pool hosting this thread.

  returns: the pool - `java.util.concurrent.ForkJoinPool`"
  (^java.util.concurrent.ForkJoinPool [^java.util.concurrent.ForkJoinWorkerThread this]
    (-> this (.getPool))))

(defn get-pool-index
  "Returns the unique index number of this thread in its pool.
   The returned value ranges from zero to the maximum number of
   threads (minus one) that may exist in the pool, and does not
   change during the lifetime of the thread.  This method may be
   useful for applications that track status or collect results
   per-worker-thread rather than per-task.

  returns: the index number - `int`"
  (^Integer [^java.util.concurrent.ForkJoinWorkerThread this]
    (-> this (.getPoolIndex))))

(defn run
  "This method is required to be public, but should never be
   called explicitly. It performs the main run loop to execute
   ForkJoinTasks."
  ([^java.util.concurrent.ForkJoinWorkerThread this]
    (-> this (.run))))

