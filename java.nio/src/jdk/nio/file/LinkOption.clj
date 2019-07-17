(ns jdk.nio.file.LinkOption
  (:refer-clojure :only [require comment defn ->])
  (:import [java.nio.file LinkOption]))

(def NOFOLLOW_LINKS
  "Enum Constant.

  Do not follow symbolic links.

  type: java.nio.file.LinkOption"
  LinkOption/NOFOLLOW_LINKS)

(defn *values
  "Returns an array containing the constants of this enum type, in
  the order they are declared.  This method may be used to iterate
  over the constants as follows:


  for (LinkOption c : LinkOption.values())
      System.out.println(c);

  returns: an array containing the constants of this enum type, in the order they are declared - `java.nio.file.LinkOption[]`"
  ([]
    (LinkOption/values )))

(defn *value-of
  "Returns the enum constant of this type with the specified name.
  The string must match exactly an identifier used to declare an
  enum constant in this type.  (Extraneous whitespace characters are
  not permitted.)

  name - the name of the enum constant to be returned. - `java.lang.String`

  returns: the enum constant with the specified name - `java.nio.file.LinkOption`

  throws: java.lang.IllegalArgumentException - if this enum type has no constant with the specified name"
  ([^java.lang.String name]
    (LinkOption/valueOf name)))

