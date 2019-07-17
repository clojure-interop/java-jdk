(ns jdk.nio.file.FileSystemNotFoundException
  "Runtime exception thrown when a file system cannot be found."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.nio.file FileSystemNotFoundException]))

(defn ->file-system-not-found-exception
  "Constructor.

  Constructs an instance of this class.

  msg - the detail message - `java.lang.String`"
  ([^java.lang.String msg]
    (new FileSystemNotFoundException msg))
  ([]
    (new FileSystemNotFoundException )))

