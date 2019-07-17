(ns jdk.nio.file.ClosedDirectoryStreamException
  "Unchecked exception thrown when an attempt is made to invoke an operation on
  a directory stream that is closed."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.nio.file ClosedDirectoryStreamException]))

(defn ->closed-directory-stream-exception
  "Constructor.

  Constructs an instance of this class."
  ([]
    (new ClosedDirectoryStreamException )))

