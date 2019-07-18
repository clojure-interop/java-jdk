(ns jdk.security.KeyRep$Type
  (:refer-clojure :only [require comment defn ->])
  (:import [java.security KeyRep$Type]))

(def SECRET
  "Enum Constant.

  Type for secret keys.

  type: java.security.KeyRep$Type"
  KeyRep$Type/SECRET)

(def PUBLIC
  "Enum Constant.

  Type for public keys.

  type: java.security.KeyRep$Type"
  KeyRep$Type/PUBLIC)

(def PRIVATE
  "Enum Constant.

  Type for private keys.

  type: java.security.KeyRep$Type"
  KeyRep$Type/PRIVATE)

(defn *values
  "Returns an array containing the constants of this enum type, in
  the order they are declared.  This method may be used to iterate
  over the constants as follows:


  for (KeyRep.Type c : KeyRep.Type.values())
      System.out.println(c);

  returns: an array containing the constants of this enum type, in the order they are declared - `java.security.KeyRep$Type[]`"
  ([]
    (KeyRep$Type/values )))

(defn *value-of
  "Returns the enum constant of this type with the specified name.
  The string must match exactly an identifier used to declare an
  enum constant in this type.  (Extraneous whitespace characters are
  not permitted.)

  name - the name of the enum constant to be returned. - `java.lang.String`

  returns: the enum constant with the specified name - `java.security.KeyRep$Type`

  throws: java.lang.IllegalArgumentException - if this enum type has no constant with the specified name"
  (^java.security.KeyRep$Type [^java.lang.String name]
    (KeyRep$Type/valueOf name)))

