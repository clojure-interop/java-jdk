(ns jdk.io.FilenameFilter
  "Instances of classes that implement this interface are used to
  filter filenames. These instances are used to filter directory
  listings in the list method of class
  File, and by the Abstract Window Toolkit's file
  dialog component."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.io FilenameFilter]))

(defn accept
  "Tests if a specified file should be included in a file list.

  dir - the directory in which the file was found. - `java.io.File`
  name - the name of the file. - `java.lang.String`

  returns: true if and only if the name should be
   included in the file list; false otherwise. - `boolean`"
  (^Boolean [^java.io.FilenameFilter this ^java.io.File dir ^java.lang.String name]
    (-> this (.accept dir name))))

