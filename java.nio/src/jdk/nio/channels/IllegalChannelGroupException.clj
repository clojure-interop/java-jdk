(ns jdk.nio.channels.IllegalChannelGroupException
  "Unchecked exception thrown when an attempt is made to open a channel
  in a group that was not created by the same provider."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.nio.channels IllegalChannelGroupException]))

(defn ->illegal-channel-group-exception
  "Constructor.

  Constructs an instance of this class."
  (^IllegalChannelGroupException []
    (new IllegalChannelGroupException )))

