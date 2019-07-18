(ns jdk.nio.channels.AsynchronousCloseException
  "Checked exception received by a thread when another thread closes the
  channel or the part of the channel upon which it is blocked in an I/O
  operation."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.nio.channels AsynchronousCloseException]))

(defn ->asynchronous-close-exception
  "Constructor.

  Constructs an instance of this class."
  (^AsynchronousCloseException []
    (new AsynchronousCloseException )))

