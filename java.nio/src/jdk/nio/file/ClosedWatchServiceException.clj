(ns jdk.nio.file.ClosedWatchServiceException
  "Unchecked exception thrown when an attempt is made to invoke an operation on
  a watch service that is closed."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.nio.file ClosedWatchServiceException]))

(defn ->closed-watch-service-exception
  "Constructor.

  Constructs an instance of this class."
  (^ClosedWatchServiceException []
    (new ClosedWatchServiceException )))

