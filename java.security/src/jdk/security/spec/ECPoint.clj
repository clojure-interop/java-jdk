(ns jdk.security.spec.ECPoint
  "This immutable class represents a point on an elliptic curve (EC)
  in affine coordinates. Other coordinate systems can
  extend this class to represent this point in other
  coordinates."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.security.spec ECPoint]))

(defn ->ec-point
  "Constructor.

  Creates an ECPoint from the specified affine x-coordinate
   x and affine y-coordinate y.

  x - the affine x-coordinate. - `java.math.BigInteger`
  y - the affine y-coordinate. - `java.math.BigInteger`

  throws: java.lang.NullPointerException - if x or y is null."
  ([^java.math.BigInteger x ^java.math.BigInteger y]
    (new ECPoint x y)))

(def *-point-infinity
  "Static Constant.

  This defines the point at infinity.

  type: java.security.spec.ECPoint"
  ECPoint/POINT_INFINITY)

(defn get-affine-x
  "Returns the affine x-coordinate x.
   Note: POINT_INFINITY has a null affine x-coordinate.

  returns: the affine x-coordinate. - `java.math.BigInteger`"
  ([^java.security.spec.ECPoint this]
    (-> this (.getAffineX))))

(defn get-affine-y
  "Returns the affine y-coordinate y.
   Note: POINT_INFINITY has a null affine y-coordinate.

  returns: the affine y-coordinate. - `java.math.BigInteger`"
  ([^java.security.spec.ECPoint this]
    (-> this (.getAffineY))))

(defn equals
  "Compares this elliptic curve point for equality with
   the specified object.

  obj - the object to be compared. - `java.lang.Object`

  returns: true if obj is an instance of
   ECPoint and the affine coordinates match, false otherwise. - `boolean`"
  ([^java.security.spec.ECPoint this ^java.lang.Object obj]
    (-> this (.equals obj))))

(defn hash-code
  "Returns a hash code value for this elliptic curve point.

  returns: a hash code value. - `int`"
  ([^java.security.spec.ECPoint this]
    (-> this (.hashCode))))

