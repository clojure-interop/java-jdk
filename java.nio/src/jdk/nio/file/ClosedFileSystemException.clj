(ns jdk.nio.file.ClosedFileSystemException
  "Unchecked exception thrown when an attempt is made to invoke an operation on
  a file and the file system is closed."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.nio.file ClosedFileSystemException]))

(defn ->closed-file-system-exception
  "Constructor.

  Constructs an instance of this class."
  ([]
    (new ClosedFileSystemException )))

