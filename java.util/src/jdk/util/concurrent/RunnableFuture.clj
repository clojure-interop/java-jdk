(ns jdk.util.concurrent.RunnableFuture
  "A Future that is Runnable. Successful execution of
  the run method causes completion of the Future
  and allows access to its results."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.util.concurrent RunnableFuture]))

(defn run
  "Sets this Future to the result of its computation
   unless it has been cancelled."
  ([^. this]
    (-> this (.run))))

