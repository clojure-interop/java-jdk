(ns jdk.nio.channels.ClosedByInterruptException
  "Checked exception received by a thread when another thread interrupts it
  while it is blocked in an I/O operation upon a channel.  Before this
  exception is thrown the channel will have been closed and the interrupt
  status of the previously-blocked thread will have been set."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.nio.channels ClosedByInterruptException]))

(defn ->closed-by-interrupt-exception
  "Constructor.

  Constructs an instance of this class."
  ([]
    (new ClosedByInterruptException )))

