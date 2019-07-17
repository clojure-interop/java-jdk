(ns jdk.util.concurrent.BrokenBarrierException
  "Exception thrown when a thread tries to wait upon a barrier that is
  in a broken state, or which enters the broken state while the thread
  is waiting."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.util.concurrent BrokenBarrierException]))

(defn ->broken-barrier-exception
  "Constructor.

  Constructs a BrokenBarrierException with the specified
   detail message.

  message - the detail message - `java.lang.String`"
  ([message]
    (new BrokenBarrierException message))
  ([]
    (new BrokenBarrierException )))

