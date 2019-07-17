(ns jdk.nio.file.NotLinkException
  "Checked exception thrown when a file system operation fails because a file
  is not a symbolic link."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.nio.file NotLinkException]))

(defn ->not-link-exception
  "Constructor.

  Constructs an instance of this class.

  file - a string identifying the file or null if not known - `java.lang.String`
  other - a string identifying the other file or null if not known - `java.lang.String`
  reason - a reason message with additional information or null - `java.lang.String`"
  ([file other reason]
    (new NotLinkException file other reason))
  ([file]
    (new NotLinkException file)))

