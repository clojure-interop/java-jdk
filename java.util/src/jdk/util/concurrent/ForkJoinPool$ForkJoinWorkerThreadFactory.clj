(ns jdk.util.concurrent.ForkJoinPool$ForkJoinWorkerThreadFactory
  "Factory for creating new ForkJoinWorkerThreads.
  A ForkJoinWorkerThreadFactory must be defined and used
  for ForkJoinWorkerThread subclasses that extend base
  functionality or initialize threads with different contexts."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.util.concurrent ForkJoinPool$ForkJoinWorkerThreadFactory]))

(defn new-thread
  "Returns a new worker thread operating in the given pool.

  pool - the pool this thread works in - `java.util.concurrent.ForkJoinPool`

  returns: the new worker thread - `java.util.concurrent.ForkJoinWorkerThread`

  throws: java.lang.NullPointerException - if the pool is null"
  (^java.util.concurrent.ForkJoinWorkerThread [^ForkJoinPool$ForkJoinWorkerThreadFactory this ^java.util.concurrent.ForkJoinPool pool]
    (-> this (.newThread pool))))

