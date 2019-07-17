(ns jdk.nio.file.FileVisitResult
  (:refer-clojure :only [require comment defn ->])
  (:import [java.nio.file FileVisitResult]))

(def CONTINUE
  "Enum Constant.

  Continue. When returned from a preVisitDirectory method then the entries in the directory should also
   be visited.

  type: java.nio.file.FileVisitResult"
  FileVisitResult/CONTINUE)

(def TERMINATE
  "Enum Constant.

  Terminate.

  type: java.nio.file.FileVisitResult"
  FileVisitResult/TERMINATE)

(def SKIP_SUBTREE
  "Enum Constant.

  Continue without visiting the entries in this directory. This result
   is only meaningful when returned from the preVisitDirectory method; otherwise
   this result type is the same as returning CONTINUE.

  type: java.nio.file.FileVisitResult"
  FileVisitResult/SKIP_SUBTREE)

(def SKIP_SIBLINGS
  "Enum Constant.

  Continue without visiting the siblings of this file or directory.
   If returned from the preVisitDirectory method then the entries in the directory are also
   skipped and the postVisitDirectory
   method is not invoked.

  type: java.nio.file.FileVisitResult"
  FileVisitResult/SKIP_SIBLINGS)

(defn *values
  "Returns an array containing the constants of this enum type, in
  the order they are declared.  This method may be used to iterate
  over the constants as follows:


  for (FileVisitResult c : FileVisitResult.values())
      System.out.println(c);

  returns: an array containing the constants of this enum type, in the order they are declared - `java.nio.file.FileVisitResult[]`"
  ([]
    (FileVisitResult/values )))

(defn *value-of
  "Returns the enum constant of this type with the specified name.
  The string must match exactly an identifier used to declare an
  enum constant in this type.  (Extraneous whitespace characters are
  not permitted.)

  name - the name of the enum constant to be returned. - `java.lang.String`

  returns: the enum constant with the specified name - `java.nio.file.FileVisitResult`

  throws: java.lang.IllegalArgumentException - if this enum type has no constant with the specified name"
  ([^java.lang.String name]
    (FileVisitResult/valueOf name)))

