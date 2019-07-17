(ns jdk.nio.channels.NonReadableChannelException
  "Unchecked exception thrown when an attempt is made to read
  from a channel that was not originally opened for reading."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.nio.channels NonReadableChannelException]))

(defn ->non-readable-channel-exception
  "Constructor.

  Constructs an instance of this class."
  ([]
    (new NonReadableChannelException )))

