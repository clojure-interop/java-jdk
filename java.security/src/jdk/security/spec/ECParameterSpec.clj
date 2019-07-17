(ns jdk.security.spec.ECParameterSpec
  "This immutable class specifies the set of domain parameters
  used with elliptic curve cryptography (ECC)."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.security.spec ECParameterSpec]))

(defn ->ec-parameter-spec
  "Constructor.

  Creates elliptic curve domain parameters based on the
   specified values.

  curve - the elliptic curve which this parameter defines. - `java.security.spec.EllipticCurve`
  g - the generator which is also known as the base point. - `java.security.spec.ECPoint`
  n - the order of the generator g. - `java.math.BigInteger`
  h - the cofactor. - `int`

  throws: java.lang.NullPointerException - if curve, g, or n is null."
  ([curve g n h]
    (new ECParameterSpec curve g n h)))

(defn get-curve
  "Returns the elliptic curve that this parameter defines.

  returns: the elliptic curve that this parameter defines. - `java.security.spec.EllipticCurve`"
  ([this]
    (-> this (.getCurve))))

(defn get-generator
  "Returns the generator which is also known as the base point.

  returns: the generator which is also known as the base point. - `java.security.spec.ECPoint`"
  ([this]
    (-> this (.getGenerator))))

(defn get-order
  "Returns the order of the generator.

  returns: the order of the generator. - `java.math.BigInteger`"
  ([this]
    (-> this (.getOrder))))

(defn get-cofactor
  "Returns the cofactor.

  returns: the cofactor. - `int`"
  ([this]
    (-> this (.getCofactor))))

