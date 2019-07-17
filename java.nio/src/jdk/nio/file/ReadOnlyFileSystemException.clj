(ns jdk.nio.file.ReadOnlyFileSystemException
  "Unchecked exception thrown when an attempt is made to update an object
  associated with a read-only FileSystem."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.nio.file ReadOnlyFileSystemException]))

(defn ->read-only-file-system-exception
  "Constructor.

  Constructs an instance of this class."
  ([]
    (new ReadOnlyFileSystemException )))

