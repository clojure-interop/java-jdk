(ns jdk.nio.channels.FileLockInterruptionException
  "Checked exception received by a thread when another thread interrupts it
  while it is waiting to acquire a file lock.  Before this exception is thrown
  the interrupt status of the previously-blocked thread will have been set."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.nio.channels FileLockInterruptionException]))

(defn ->file-lock-interruption-exception
  "Constructor.

  Constructs an instance of this class."
  (^FileLockInterruptionException []
    (new FileLockInterruptionException )))

