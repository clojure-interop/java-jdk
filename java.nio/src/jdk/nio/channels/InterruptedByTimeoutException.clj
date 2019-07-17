(ns jdk.nio.channels.InterruptedByTimeoutException
  "Checked exception received by a thread when a timeout elapses before an
  asynchronous operation completes."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.nio.channels InterruptedByTimeoutException]))

(defn ->interrupted-by-timeout-exception
  "Constructor.

  Constructs an instance of this class."
  ([]
    (new InterruptedByTimeoutException )))

