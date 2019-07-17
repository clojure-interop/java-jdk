(ns jdk.util.concurrent.RunnableScheduledFuture
  "A ScheduledFuture that is Runnable. Successful
  execution of the run method causes completion of the
  Future and allows access to its results."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.util.concurrent RunnableScheduledFuture]))

(defn periodic?
  "Returns true if this task is periodic. A periodic task may
   re-run according to some schedule. A non-periodic task can be
   run only once.

  returns: true if this task is periodic - `boolean`"
  ([this]
    (-> this (.isPeriodic))))

