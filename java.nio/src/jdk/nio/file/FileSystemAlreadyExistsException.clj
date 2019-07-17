(ns jdk.nio.file.FileSystemAlreadyExistsException
  "Runtime exception thrown when an attempt is made to create a file system that
  already exists."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.nio.file FileSystemAlreadyExistsException]))

(defn ->file-system-already-exists-exception
  "Constructor.

  Constructs an instance of this class.

  msg - the detail message - `java.lang.String`"
  ([msg]
    (new FileSystemAlreadyExistsException msg))
  ([]
    (new FileSystemAlreadyExistsException )))

