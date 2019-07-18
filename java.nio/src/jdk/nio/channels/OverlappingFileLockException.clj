(ns jdk.nio.channels.OverlappingFileLockException
  "Unchecked exception thrown when an attempt is made to acquire a lock on a
  region of a file that overlaps a region already locked by the same Java
  virtual machine, or when another thread is already waiting to lock an
  overlapping region of the same file."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.nio.channels OverlappingFileLockException]))

(defn ->overlapping-file-lock-exception
  "Constructor.

  Constructs an instance of this class."
  (^OverlappingFileLockException []
    (new OverlappingFileLockException )))

