(ns jdk.security.CryptoPrimitive
  (:refer-clojure :only [require comment defn ->])
  (:import [java.security CryptoPrimitive]))

(def MESSAGE_DIGEST
  "Enum Constant.

  Hash function

  type: java.security.CryptoPrimitive"
  CryptoPrimitive/MESSAGE_DIGEST)

(def SECURE_RANDOM
  "Enum Constant.

  Cryptographic random number generator

  type: java.security.CryptoPrimitive"
  CryptoPrimitive/SECURE_RANDOM)

(def BLOCK_CIPHER
  "Enum Constant.

  Symmetric primitive: block cipher

  type: java.security.CryptoPrimitive"
  CryptoPrimitive/BLOCK_CIPHER)

(def STREAM_CIPHER
  "Enum Constant.

  Symmetric primitive: stream cipher

  type: java.security.CryptoPrimitive"
  CryptoPrimitive/STREAM_CIPHER)

(def MAC
  "Enum Constant.

  Symmetric primitive: message authentication code

  type: java.security.CryptoPrimitive"
  CryptoPrimitive/MAC)

(def KEY_WRAP
  "Enum Constant.

  Symmetric primitive: key wrap

  type: java.security.CryptoPrimitive"
  CryptoPrimitive/KEY_WRAP)

(def PUBLIC_KEY_ENCRYPTION
  "Enum Constant.

  Asymmetric primitive: public key encryption

  type: java.security.CryptoPrimitive"
  CryptoPrimitive/PUBLIC_KEY_ENCRYPTION)

(def SIGNATURE
  "Enum Constant.

  Asymmetric primitive: signature scheme

  type: java.security.CryptoPrimitive"
  CryptoPrimitive/SIGNATURE)

(def KEY_ENCAPSULATION
  "Enum Constant.

  Asymmetric primitive: key encapsulation mechanism

  type: java.security.CryptoPrimitive"
  CryptoPrimitive/KEY_ENCAPSULATION)

(def KEY_AGREEMENT
  "Enum Constant.

  Asymmetric primitive: key agreement and key distribution

  type: java.security.CryptoPrimitive"
  CryptoPrimitive/KEY_AGREEMENT)

(defn *values
  "Returns an array containing the constants of this enum type, in
  the order they are declared.  This method may be used to iterate
  over the constants as follows:


  for (CryptoPrimitive c : CryptoPrimitive.values())
      System.out.println(c);

  returns: an array containing the constants of this enum type, in the order they are declared - `java.security.CryptoPrimitive[]`"
  ([]
    (CryptoPrimitive/values )))

(defn *value-of
  "Returns the enum constant of this type with the specified name.
  The string must match exactly an identifier used to declare an
  enum constant in this type.  (Extraneous whitespace characters are
  not permitted.)

  name - the name of the enum constant to be returned. - `java.lang.String`

  returns: the enum constant with the specified name - `java.security.CryptoPrimitive`

  throws: java.lang.IllegalArgumentException - if this enum type has no constant with the specified name"
  ([^java.lang.String name]
    (CryptoPrimitive/valueOf name)))

