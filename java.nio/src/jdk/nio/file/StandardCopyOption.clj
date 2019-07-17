(ns jdk.nio.file.StandardCopyOption
  (:refer-clojure :only [require comment defn ->])
  (:import [java.nio.file StandardCopyOption]))

(def REPLACE_EXISTING
  "Enum Constant.

  Replace an existing file if it exists.

  type: java.nio.file.StandardCopyOption"
  StandardCopyOption/REPLACE_EXISTING)

(def COPY_ATTRIBUTES
  "Enum Constant.

  Copy attributes to the new file.

  type: java.nio.file.StandardCopyOption"
  StandardCopyOption/COPY_ATTRIBUTES)

(def ATOMIC_MOVE
  "Enum Constant.

  Move the file as an atomic file system operation.

  type: java.nio.file.StandardCopyOption"
  StandardCopyOption/ATOMIC_MOVE)

(defn *values
  "Returns an array containing the constants of this enum type, in
  the order they are declared.  This method may be used to iterate
  over the constants as follows:


  for (StandardCopyOption c : StandardCopyOption.values())
      System.out.println(c);

  returns: an array containing the constants of this enum type, in the order they are declared - `java.nio.file.StandardCopyOption[]`"
  ([]
    (StandardCopyOption/values )))

(defn *value-of
  "Returns the enum constant of this type with the specified name.
  The string must match exactly an identifier used to declare an
  enum constant in this type.  (Extraneous whitespace characters are
  not permitted.)

  name - the name of the enum constant to be returned. - `java.lang.String`

  returns: the enum constant with the specified name - `java.nio.file.StandardCopyOption`

  throws: java.lang.IllegalArgumentException - if this enum type has no constant with the specified name"
  ([name]
    (StandardCopyOption/valueOf name)))

