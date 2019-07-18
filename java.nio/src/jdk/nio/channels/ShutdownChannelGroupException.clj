(ns jdk.nio.channels.ShutdownChannelGroupException
  "Unchecked exception thrown when an attempt is made to construct a channel in
  a group that is shutdown or the completion handler for an I/O operation
  cannot be invoked because the channel group has terminated."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.nio.channels ShutdownChannelGroupException]))

(defn ->shutdown-channel-group-exception
  "Constructor.

  Constructs an instance of this class."
  (^ShutdownChannelGroupException []
    (new ShutdownChannelGroupException )))

