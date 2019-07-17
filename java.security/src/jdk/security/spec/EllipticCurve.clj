(ns jdk.security.spec.EllipticCurve
  "This immutable class holds the necessary values needed to represent
  an elliptic curve."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.security.spec EllipticCurve]))

(defn ->elliptic-curve
  "Constructor.

  Creates an elliptic curve with the specified elliptic field
   field, the coefficients a and
   b, and the seed used for curve generation.

  field - the finite field that this elliptic curve is over. - `java.security.spec.ECField`
  a - the first coefficient of this elliptic curve. - `java.math.BigInteger`
  b - the second coefficient of this elliptic curve. - `java.math.BigInteger`
  seed - the bytes used during curve generation for later validation. Contents of this array are copied to protect against subsequent modification. - `byte[]`

  throws: java.lang.NullPointerException - if field, a, or b is null."
  ([field a b seed]
    (new EllipticCurve field a b seed))
  ([field a b]
    (new EllipticCurve field a b)))

(defn get-field
  "Returns the finite field field that this
   elliptic curve is over.

  returns: the field field that this curve
   is over. - `java.security.spec.ECField`"
  ([this]
    (-> this (.getField))))

(defn get-a
  "Returns the first coefficient a of the
   elliptic curve.

  returns: the first coefficient a. - `java.math.BigInteger`"
  ([this]
    (-> this (.getA))))

(defn get-b
  "Returns the second coefficient b of the
   elliptic curve.

  returns: the second coefficient b. - `java.math.BigInteger`"
  ([this]
    (-> this (.getB))))

(defn get-seed
  "Returns the seeding bytes seed used
   during curve generation. May be null if not specified.

  returns: the seeding bytes seed. A new
   array is returned each time this method is called. - `byte[]`"
  ([this]
    (-> this (.getSeed))))

(defn equals
  "Compares this elliptic curve for equality with the
   specified object.

  obj - the object to be compared. - `java.lang.Object`

  returns: true if obj is an instance of
   EllipticCurve and the field, A, and B match, false otherwise. - `boolean`"
  ([this obj]
    (-> this (.equals obj))))

(defn hash-code
  "Returns a hash code value for this elliptic curve.

  returns: a hash code value computed from the hash codes of the field, A,
   and B, as follows:


       (field.hashCode() << 6)  (a.hashCode() << 4)  (b.hashCode() << 2) - `int`"
  ([this]
    (-> this (.hashCode))))

