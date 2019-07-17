(ns jdk.nio.file.AtomicMoveNotSupportedException
  "Checked exception thrown when a file cannot be moved as an atomic file system
  operation."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.nio.file AtomicMoveNotSupportedException]))

(defn ->atomic-move-not-supported-exception
  "Constructor.

  Constructs an instance of this class.

  source - a string identifying the source file or null if not known - `java.lang.String`
  target - a string identifying the target file or null if not known - `java.lang.String`
  reason - a reason message with additional information - `java.lang.String`"
  ([source target reason]
    (new AtomicMoveNotSupportedException source target reason)))

