(ns jdk.security.spec.ECFieldFp
  "This immutable class defines an elliptic curve (EC) prime
  finite field."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.security.spec ECFieldFp]))

(defn ->ec-field-fp
  "Constructor.

  Creates an elliptic curve prime finite field
   with the specified prime p.

  p - the prime. - `java.math.BigInteger`

  throws: java.lang.NullPointerException - if p is null."
  ([p]
    (new ECFieldFp p)))

(defn get-field-size
  "Returns the field size in bits which is size of prime p
   for this prime finite field.

  returns: the field size in bits. - `int`"
  ([this]
    (-> this (.getFieldSize))))

(defn get-p
  "Returns the prime p of this prime finite field.

  returns: the prime. - `java.math.BigInteger`"
  ([this]
    (-> this (.getP))))

(defn equals
  "Compares this prime finite field for equality with the
   specified object.

  obj - the object to be compared. - `java.lang.Object`

  returns: true if obj is an instance
   of ECFieldFp and the prime value match, false otherwise. - `boolean`"
  ([this obj]
    (-> this (.equals obj))))

(defn hash-code
  "Returns a hash code value for this prime finite field.

  returns: a hash code value. - `int`"
  ([this]
    (-> this (.hashCode))))

