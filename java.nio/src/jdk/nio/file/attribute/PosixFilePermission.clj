(ns jdk.nio.file.attribute.PosixFilePermission
  (:refer-clojure :only [require comment defn ->])
  (:import [java.nio.file.attribute PosixFilePermission]))

(def OWNER_READ
  "Enum Constant.

  Read permission, owner.

  type: java.nio.file.attribute.PosixFilePermission"
  PosixFilePermission/OWNER_READ)

(def OWNER_WRITE
  "Enum Constant.

  Write permission, owner.

  type: java.nio.file.attribute.PosixFilePermission"
  PosixFilePermission/OWNER_WRITE)

(def OWNER_EXECUTE
  "Enum Constant.

  Execute/search permission, owner.

  type: java.nio.file.attribute.PosixFilePermission"
  PosixFilePermission/OWNER_EXECUTE)

(def GROUP_READ
  "Enum Constant.

  Read permission, group.

  type: java.nio.file.attribute.PosixFilePermission"
  PosixFilePermission/GROUP_READ)

(def GROUP_WRITE
  "Enum Constant.

  Write permission, group.

  type: java.nio.file.attribute.PosixFilePermission"
  PosixFilePermission/GROUP_WRITE)

(def GROUP_EXECUTE
  "Enum Constant.

  Execute/search permission, group.

  type: java.nio.file.attribute.PosixFilePermission"
  PosixFilePermission/GROUP_EXECUTE)

(def OTHERS_READ
  "Enum Constant.

  Read permission, others.

  type: java.nio.file.attribute.PosixFilePermission"
  PosixFilePermission/OTHERS_READ)

(def OTHERS_WRITE
  "Enum Constant.

  Write permission, others.

  type: java.nio.file.attribute.PosixFilePermission"
  PosixFilePermission/OTHERS_WRITE)

(def OTHERS_EXECUTE
  "Enum Constant.

  Execute/search permission, others.

  type: java.nio.file.attribute.PosixFilePermission"
  PosixFilePermission/OTHERS_EXECUTE)

(defn *values
  "Returns an array containing the constants of this enum type, in
  the order they are declared.  This method may be used to iterate
  over the constants as follows:


  for (PosixFilePermission c : PosixFilePermission.values())
      System.out.println(c);

  returns: an array containing the constants of this enum type, in the order they are declared - `java.nio.file.attribute.PosixFilePermission[]`"
  ([]
    (PosixFilePermission/values )))

(defn *value-of
  "Returns the enum constant of this type with the specified name.
  The string must match exactly an identifier used to declare an
  enum constant in this type.  (Extraneous whitespace characters are
  not permitted.)

  name - the name of the enum constant to be returned. - `java.lang.String`

  returns: the enum constant with the specified name - `java.nio.file.attribute.PosixFilePermission`

  throws: java.lang.IllegalArgumentException - if this enum type has no constant with the specified name"
  ([name]
    (PosixFilePermission/valueOf name)))

