(ns jdk.nio.file.DirectoryStream$Filter
  "An interface that is implemented by objects that decide if a directory
  entry should be accepted or filtered. A Filter is passed as the
  parameter to the Files.newDirectoryStream(Path,DirectoryStream.Filter)
  method when opening a directory to iterate over the entries in the
  directory."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.nio.file DirectoryStream$Filter]))

(defn accept
  "Decides if the given directory entry should be accepted or filtered.

  entry - the directory entry to be tested - `T`

  returns: true if the directory entry should be accepted - `boolean`

  throws: java.io.IOException - If an I/O error occurs"
  (^Boolean [^DirectoryStream$Filter this entry]
    (-> this (.accept entry))))

