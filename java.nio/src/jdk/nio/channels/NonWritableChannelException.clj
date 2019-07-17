(ns jdk.nio.channels.NonWritableChannelException
  "Unchecked exception thrown when an attempt is made to write
  to a channel that was not originally opened for writing."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.nio.channels NonWritableChannelException]))

(defn ->non-writable-channel-exception
  "Constructor.

  Constructs an instance of this class."
  ([]
    (new NonWritableChannelException )))

