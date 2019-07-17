(ns jdk.nio.file.NotDirectoryException
  "Checked exception thrown when a file system operation, intended for a
  directory, fails because the file is not a directory."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.nio.file NotDirectoryException]))

(defn ->not-directory-exception
  "Constructor.

  Constructs an instance of this class.

  file - a string identifying the file or null if not known - `java.lang.String`"
  ([file]
    (new NotDirectoryException file)))

