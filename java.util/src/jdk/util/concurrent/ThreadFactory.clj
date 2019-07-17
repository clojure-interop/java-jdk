(ns jdk.util.concurrent.ThreadFactory
  "An object that creates new threads on demand.  Using thread factories
  removes hardwiring of calls to new Thread,
  enabling applications to use special thread subclasses, priorities, etc.


  The simplest implementation of this interface is just:


  class SimpleThreadFactory implements ThreadFactory {
    public Thread newThread(Runnable r) {
      return new Thread(r);
    }
  }

  The Executors.defaultThreadFactory() method provides a more
  useful simple implementation, that sets the created thread context
  to known values before returning it."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.util.concurrent ThreadFactory]))

(defn new-thread
  "Constructs a new Thread.  Implementations may also initialize
   priority, name, daemon status, ThreadGroup, etc.

  r - a runnable to be executed by new thread instance - `java.lang.Runnable`

  returns: constructed thread, or null if the request to
           create a thread is rejected - `java.lang.Thread`"
  ([^java.util.concurrent.ThreadFactory this ^java.lang.Runnable r]
    (-> this (.newThread r))))

