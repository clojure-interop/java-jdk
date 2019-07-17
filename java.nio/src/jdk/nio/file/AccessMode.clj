(ns jdk.nio.file.AccessMode
  (:refer-clojure :only [require comment defn ->])
  (:import [java.nio.file AccessMode]))

(def READ
  "Enum Constant.

  Test read access.

  type: java.nio.file.AccessMode"
  AccessMode/READ)

(def WRITE
  "Enum Constant.

  Test write access.

  type: java.nio.file.AccessMode"
  AccessMode/WRITE)

(def EXECUTE
  "Enum Constant.

  Test execute access.

  type: java.nio.file.AccessMode"
  AccessMode/EXECUTE)

(defn *values
  "Returns an array containing the constants of this enum type, in
  the order they are declared.  This method may be used to iterate
  over the constants as follows:


  for (AccessMode c : AccessMode.values())
      System.out.println(c);

  returns: an array containing the constants of this enum type, in the order they are declared - `java.nio.file.AccessMode[]`"
  ([]
    (AccessMode/values )))

(defn *value-of
  "Returns the enum constant of this type with the specified name.
  The string must match exactly an identifier used to declare an
  enum constant in this type.  (Extraneous whitespace characters are
  not permitted.)

  name - the name of the enum constant to be returned. - `java.lang.String`

  returns: the enum constant with the specified name - `java.nio.file.AccessMode`

  throws: java.lang.IllegalArgumentException - if this enum type has no constant with the specified name"
  ([name]
    (AccessMode/valueOf name)))

