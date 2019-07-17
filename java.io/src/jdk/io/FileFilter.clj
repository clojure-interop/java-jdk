(ns jdk.io.FileFilter
  "A filter for abstract pathnames.

   Instances of this interface may be passed to the listFiles(FileFilter) method
  of the File class."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.io FileFilter]))

(defn accept
  "Tests whether or not the specified abstract pathname should be
   included in a pathname list.

  pathname - The abstract pathname to be tested - `java.io.File`

  returns: true if and only if pathname
            should be included - `boolean`"
  ([^. this ^java.io.File pathname]
    (-> this (.accept pathname))))

