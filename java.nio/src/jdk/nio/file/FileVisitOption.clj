(ns jdk.nio.file.FileVisitOption
  (:refer-clojure :only [require comment defn ->])
  (:import [java.nio.file FileVisitOption]))

(def FOLLOW_LINKS
  "Enum Constant.

  Follow symbolic links.

  type: java.nio.file.FileVisitOption"
  FileVisitOption/FOLLOW_LINKS)

(defn *values
  "Returns an array containing the constants of this enum type, in
  the order they are declared.  This method may be used to iterate
  over the constants as follows:


  for (FileVisitOption c : FileVisitOption.values())
      System.out.println(c);

  returns: an array containing the constants of this enum type, in the order they are declared - `java.nio.file.FileVisitOption[]`"
  ([]
    (FileVisitOption/values )))

(defn *value-of
  "Returns the enum constant of this type with the specified name.
  The string must match exactly an identifier used to declare an
  enum constant in this type.  (Extraneous whitespace characters are
  not permitted.)

  name - the name of the enum constant to be returned. - `java.lang.String`

  returns: the enum constant with the specified name - `java.nio.file.FileVisitOption`

  throws: java.lang.IllegalArgumentException - if this enum type has no constant with the specified name"
  ([name]
    (FileVisitOption/valueOf name)))

