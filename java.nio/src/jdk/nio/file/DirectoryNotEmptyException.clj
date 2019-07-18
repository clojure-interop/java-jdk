(ns jdk.nio.file.DirectoryNotEmptyException
  "Checked exception thrown when a file system operation fails because a
  directory is not empty."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.nio.file DirectoryNotEmptyException]))

(defn ->directory-not-empty-exception
  "Constructor.

  Constructs an instance of this class.

  dir - a string identifying the directory or null if not known - `java.lang.String`"
  (^DirectoryNotEmptyException [^java.lang.String dir]
    (new DirectoryNotEmptyException dir)))

