(ns jdk.nio.file.SimpleFileVisitor
  "A simple visitor of files with default behavior to visit all files and to
  re-throw I/O errors.

   Methods in this class may be overridden subject to their general contract."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.nio.file SimpleFileVisitor]))

(defn pre-visit-directory
  "Invoked for a directory before entries in the directory are visited.

    Unless overridden, this method returns CONTINUE.

  dir - a reference to the directory - `SimpleFileVisitor.T`
  attrs - the directory's basic attributes - `java.nio.file.attribute.BasicFileAttributes`

  returns: the visit result - `java.nio.file.FileVisitResult`

  throws: java.io.IOException - if an I/O error occurs"
  ([this dir attrs]
    (-> this (.preVisitDirectory dir attrs))))

(defn visit-file
  "Invoked for a file in a directory.

    Unless overridden, this method returns CONTINUE.

  file - a reference to the file - `SimpleFileVisitor.T`
  attrs - the file's basic attributes - `java.nio.file.attribute.BasicFileAttributes`

  returns: the visit result - `java.nio.file.FileVisitResult`

  throws: java.io.IOException - if an I/O error occurs"
  ([this file attrs]
    (-> this (.visitFile file attrs))))

(defn visit-file-failed
  "Invoked for a file that could not be visited.

    Unless overridden, this method re-throws the I/O exception that prevented
   the file from being visited.

  file - a reference to the file - `SimpleFileVisitor.T`
  exc - the I/O exception that prevented the file from being visited - `java.io.IOException`

  returns: the visit result - `java.nio.file.FileVisitResult`

  throws: java.io.IOException - if an I/O error occurs"
  ([this file exc]
    (-> this (.visitFileFailed file exc))))

(defn post-visit-directory
  "Invoked for a directory after entries in the directory, and all of their
   descendants, have been visited.

    Unless overridden, this method returns CONTINUE if the directory iteration completes without an I/O exception;
   otherwise this method re-throws the I/O exception that caused the iteration
   of the directory to terminate prematurely.

  dir - a reference to the directory - `SimpleFileVisitor.T`
  exc - null if the iteration of the directory completes without an error; otherwise the I/O exception that caused the iteration of the directory to complete prematurely - `java.io.IOException`

  returns: the visit result - `java.nio.file.FileVisitResult`

  throws: java.io.IOException - if an I/O error occurs"
  ([this dir exc]
    (-> this (.postVisitDirectory dir exc))))

