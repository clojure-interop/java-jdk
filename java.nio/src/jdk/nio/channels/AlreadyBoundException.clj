(ns jdk.nio.channels.AlreadyBoundException
  "Unchecked exception thrown when an attempt is made to bind the socket a
  network oriented channel that is already bound."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.nio.channels AlreadyBoundException]))

(defn ->already-bound-exception
  "Constructor.

  Constructs an instance of this class."
  (^AlreadyBoundException []
    (new AlreadyBoundException )))

