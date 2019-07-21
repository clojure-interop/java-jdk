(ns javax.crypto.spec.SecretKeySpec
  "This class specifies a secret key in a provider-independent fashion.

  It can be used to construct a SecretKey from a byte array,
  without having to go through a (provider-based)
  SecretKeyFactory.

  This class is only useful for raw secret keys that can be represented as
  a byte array and have no key parameters associated with them, e.g., DES or
  Triple DES keys."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.crypto.spec SecretKeySpec]))

(defn ->secret-key-spec
  "Constructor.

  Constructs a secret key from the given byte array, using the first
   len bytes of key, starting at
   offset inclusive.

    The bytes that constitute the secret key are
   those between key[offset] and
   key[offset+len-1] inclusive.

   This constructor does not check if the given bytes indeed specify a
   secret key of the specified algorithm. For example, if the algorithm is
   DES, this constructor does not check if key is 8 bytes
   long, and also does not check for weak or semi-weak keys.
   In order for those checks to be performed, an algorithm-specific key
   specification class (in this case:
   DESKeySpec)
   must be used.

  key - the key material of the secret key. The first len bytes of the array beginning at offset inclusive are copied to protect against subsequent modification. - `byte[]`
  offset - the offset in key where the key material starts. - `int`
  len - the length of the key material. - `int`
  algorithm - the name of the secret-key algorithm to be associated with the given key material. See Appendix A in the Java Cryptography Architecture Reference Guide for information about standard algorithm names. - `java.lang.String`

  throws: java.lang.IllegalArgumentException - if algorithm is null or key is null, empty, or too short, i.e. key.length-offset<len."
  (^SecretKeySpec [key ^Integer offset ^Integer len ^java.lang.String algorithm]
    (new SecretKeySpec key offset len algorithm))
  (^SecretKeySpec [key ^java.lang.String algorithm]
    (new SecretKeySpec key algorithm)))

(defn get-algorithm
  "Returns the name of the algorithm associated with this secret key.

  returns: the secret key algorithm. - `java.lang.String`"
  (^java.lang.String [^SecretKeySpec this]
    (-> this (.getAlgorithm))))

(defn get-format
  "Returns the name of the encoding format for this secret key.

  returns: the string \"RAW\". - `java.lang.String`"
  (^java.lang.String [^SecretKeySpec this]
    (-> this (.getFormat))))

(defn get-encoded
  "Returns the key material of this secret key.

  returns: the key material. Returns a new array
   each time this method is called. - `byte[]`"
  ([^SecretKeySpec this]
    (-> this (.getEncoded))))

(defn hash-code
  "Calculates a hash code value for the object.
   Objects that are equal will also have the same hashcode.

  returns: a hash code value for this object. - `int`"
  (^Integer [^SecretKeySpec this]
    (-> this (.hashCode))))

(defn equals
  "Tests for equality between the specified object and this
   object. Two SecretKeySpec objects are considered equal if
   they are both SecretKey instances which have the
   same case-insensitive algorithm name and key encoding.

  obj - the object to test for equality with this object. - `java.lang.Object`

  returns: true if the objects are considered equal, false if
   obj is null or otherwise. - `boolean`"
  (^Boolean [^SecretKeySpec this ^java.lang.Object obj]
    (-> this (.equals obj))))

