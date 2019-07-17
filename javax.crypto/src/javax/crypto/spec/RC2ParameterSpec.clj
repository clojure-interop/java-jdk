(ns javax.crypto.spec.RC2ParameterSpec
  "This class specifies the parameters used with the
  RC2
  algorithm.

   The parameters consist of an effective key size and optionally
  an 8-byte initialization vector (IV) (only in feedback mode).

   This class can be used to initialize a Cipher object that
  implements the RC2 algorithm."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.crypto.spec RC2ParameterSpec]))

(defn ->rc-2-parameter-spec
  "Constructor.

  Constructs a parameter set for RC2 from the given effective key size
   (in bits) and IV.

    The IV is taken from iv, starting at
   offset inclusive.
   The bytes that constitute the IV are those between
   iv[offset] and iv[offset+7] inclusive.

  effective-key-bits - the effective key size in bits. - `int`
  iv - the buffer with the IV. The first 8 bytes of the buffer beginning at offset inclusive are copied to protect against subsequent modification. - `byte[]`
  offset - the offset in iv where the 8-byte IV starts. - `int`

  throws: java.lang.IllegalArgumentException - if iv is null."
  ([^Integer effective-key-bits iv ^Integer offset]
    (new RC2ParameterSpec effective-key-bits iv offset))
  ([^Integer effective-key-bits iv]
    (new RC2ParameterSpec effective-key-bits iv))
  ([^Integer effective-key-bits]
    (new RC2ParameterSpec effective-key-bits)))

(defn get-effective-key-bits
  "Returns the effective key size in bits.

  returns: the effective key size in bits. - `int`"
  ([^javax.crypto.spec.RC2ParameterSpec this]
    (-> this (.getEffectiveKeyBits))))

(defn get-iv
  "Returns the IV or null if this parameter set does not contain an IV.

  returns: the IV or null if this parameter set does not contain an IV.
   Returns a new array each time this method is called. - `byte[]`"
  ([^javax.crypto.spec.RC2ParameterSpec this]
    (-> this (.getIV))))

(defn equals
  "Tests for equality between the specified object and this
   object. Two RC2ParameterSpec objects are considered equal if their
   effective key sizes and IVs are equal.
   (Two IV references are considered equal if both are null.)

  obj - the object to test for equality with this object. - `java.lang.Object`

  returns: true if the objects are considered equal, false if
   obj is null or otherwise. - `boolean`"
  ([^javax.crypto.spec.RC2ParameterSpec this ^java.lang.Object obj]
    (-> this (.equals obj))))

(defn hash-code
  "Calculates a hash code value for the object.
   Objects that are equal will also have the same hashcode.

  returns: a hash code value for this object. - `int`"
  ([^javax.crypto.spec.RC2ParameterSpec this]
    (-> this (.hashCode))))

