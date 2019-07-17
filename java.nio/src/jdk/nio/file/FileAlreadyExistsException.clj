(ns jdk.nio.file.FileAlreadyExistsException
  "Checked exception thrown when an attempt is made to create a file or
  directory and a file of that name already exists."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.nio.file FileAlreadyExistsException]))

(defn ->file-already-exists-exception
  "Constructor.

  Constructs an instance of this class.

  file - a string identifying the file or null if not known - `java.lang.String`
  other - a string identifying the other file or null if not known - `java.lang.String`
  reason - a reason message with additional information or null - `java.lang.String`"
  ([file other reason]
    (new FileAlreadyExistsException file other reason))
  ([file]
    (new FileAlreadyExistsException file)))

