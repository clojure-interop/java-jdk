(ns javax.crypto.spec.RC5ParameterSpec
  "This class specifies the parameters used with the
  RC5
  algorithm.

   The parameters consist of a version number, a rounds count, a word
  size, and optionally an initialization vector (IV) (only in feedback mode).

   This class can be used to initialize a Cipher object that
  implements the RC5 algorithm as supplied by
  RSA Security Inc.,
  or any parties authorized by RSA Security."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.crypto.spec RC5ParameterSpec]))

(defn ->rc-5-parameter-spec
  "Constructor.

  Constructs a parameter set for RC5 from the given version, number of
   rounds, word size (in bits), and IV.

    The IV is taken from iv, starting at
   offset inclusive.
   Note that the size of the IV (block size), starting at
   offset inclusive, must be twice the word size.
   The bytes that constitute the IV are those between
   iv[offset] and iv[offset+2*(wordSize/8)-1]
   inclusive.

  version - the version. - `int`
  rounds - the number of rounds. - `int`
  word-size - the word size in bits. - `int`
  iv - the buffer with the IV. The first 2*(wordSize/8) bytes of the buffer beginning at offset inclusive are copied to protect against subsequent modification. - `byte[]`
  offset - the offset in iv where the IV starts. - `int`

  throws: java.lang.IllegalArgumentException - if iv is null or (iv.length - offset < 2 * (wordSize / 8))"
  ([^Integer version ^Integer rounds ^Integer word-size iv ^Integer offset]
    (new RC5ParameterSpec version rounds word-size iv offset))
  ([^Integer version ^Integer rounds ^Integer word-size iv]
    (new RC5ParameterSpec version rounds word-size iv))
  ([^Integer version ^Integer rounds ^Integer word-size]
    (new RC5ParameterSpec version rounds word-size)))

(defn get-version
  "Returns the version.

  returns: the version. - `int`"
  (^Integer [^javax.crypto.spec.RC5ParameterSpec this]
    (-> this (.getVersion))))

(defn get-rounds
  "Returns the number of rounds.

  returns: the number of rounds. - `int`"
  (^Integer [^javax.crypto.spec.RC5ParameterSpec this]
    (-> this (.getRounds))))

(defn get-word-size
  "Returns the word size in bits.

  returns: the word size in bits. - `int`"
  (^Integer [^javax.crypto.spec.RC5ParameterSpec this]
    (-> this (.getWordSize))))

(defn get-iv
  "Returns the IV or null if this parameter set does not contain an IV.

  returns: the IV or null if this parameter set does not contain an IV.
   Returns a new array each time this method is called. - `byte[]`"
  ([^javax.crypto.spec.RC5ParameterSpec this]
    (-> this (.getIV))))

(defn equals
  "Tests for equality between the specified object and this
   object. Two RC5ParameterSpec objects are considered equal if their
   version numbers, number of rounds, word sizes, and IVs are equal.
   (Two IV references are considered equal if both are null.)

  obj - the object to test for equality with this object. - `java.lang.Object`

  returns: true if the objects are considered equal, false if
   obj is null or otherwise. - `boolean`"
  (^Boolean [^javax.crypto.spec.RC5ParameterSpec this ^java.lang.Object obj]
    (-> this (.equals obj))))

(defn hash-code
  "Calculates a hash code value for the object.
   Objects that are equal will also have the same hashcode.

  returns: a hash code value for this object. - `int`"
  (^Integer [^javax.crypto.spec.RC5ParameterSpec this]
    (-> this (.hashCode))))

