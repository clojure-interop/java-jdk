(ns jdk.nio.file.FileSystemException
  "Thrown when a file system operation fails on one or two files. This class is
  the general class for file system exceptions."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.nio.file FileSystemException]))

(defn ->file-system-exception
  "Constructor.

  Constructs an instance of this class. This constructor should be used
   when an operation involving two files fails, or there is additional
   information to explain the reason.

  file - a string identifying the file or null if not known. - `java.lang.String`
  other - a string identifying the other file or null if there isn't another file or if not known - `java.lang.String`
  reason - a reason message with additional information or null - `java.lang.String`"
  ([^java.lang.String file ^java.lang.String other ^java.lang.String reason]
    (new FileSystemException file other reason))
  ([^java.lang.String file]
    (new FileSystemException file)))

(defn get-file
  "Returns the file used to create this exception.

  returns: the file (can be null) - `java.lang.String`"
  (^java.lang.String [^java.nio.file.FileSystemException this]
    (-> this (.getFile))))

(defn get-other-file
  "Returns the other file used to create this exception.

  returns: the other file (can be null) - `java.lang.String`"
  (^java.lang.String [^java.nio.file.FileSystemException this]
    (-> this (.getOtherFile))))

(defn get-reason
  "Returns the string explaining why the file system operation failed.

  returns: the string explaining why the file system operation failed - `java.lang.String`"
  (^java.lang.String [^java.nio.file.FileSystemException this]
    (-> this (.getReason))))

(defn get-message
  "Returns the detail message string.

  returns: the detail message string of this Throwable instance
            (which may be null). - `java.lang.String`"
  (^java.lang.String [^java.nio.file.FileSystemException this]
    (-> this (.getMessage))))

