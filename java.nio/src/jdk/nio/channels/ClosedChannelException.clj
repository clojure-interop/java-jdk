(ns jdk.nio.channels.ClosedChannelException
  "Checked exception thrown when an attempt is made to invoke or complete an
  I/O operation upon channel that is closed, or at least closed to that
  operation.  That this exception is thrown does not necessarily imply that
  the channel is completely closed.  A socket channel whose write half has
  been shut down, for example, may still be open for reading."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.nio.channels ClosedChannelException]))

(defn ->closed-channel-exception
  "Constructor.

  Constructs an instance of this class."
  ([]
    (new ClosedChannelException )))

