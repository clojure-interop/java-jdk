(ns jdk.nio.file.NoSuchFileException
  "Checked exception thrown when an attempt is made to access a file that does
  not exist."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.nio.file NoSuchFileException]))

(defn ->no-such-file-exception
  "Constructor.

  Constructs an instance of this class.

  file - a string identifying the file or null if not known. - `java.lang.String`
  other - a string identifying the other file or null if not known. - `java.lang.String`
  reason - a reason message with additional information or null - `java.lang.String`"
  ([^java.lang.String file ^java.lang.String other ^java.lang.String reason]
    (new NoSuchFileException file other reason))
  ([^java.lang.String file]
    (new NoSuchFileException file)))

