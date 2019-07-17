(ns jdk.nio.ReadOnlyBufferException
  "Unchecked exception thrown when a content-mutation method such as
  put or compact is invoked upon a read-only buffer."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.nio ReadOnlyBufferException]))

(defn ->read-only-buffer-exception
  "Constructor.

  Constructs an instance of this class."
  ([]
    (new ReadOnlyBufferException )))

