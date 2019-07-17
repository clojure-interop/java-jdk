(ns jdk.nio.file.FileSystemLoopException
  "Checked exception thrown when a file system loop, or cycle, is encountered."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.nio.file FileSystemLoopException]))

(defn ->file-system-loop-exception
  "Constructor.

  Constructs an instance of this class.

  file - a string identifying the file causing the cycle or null if not known - `java.lang.String`"
  ([file]
    (new FileSystemLoopException file)))

