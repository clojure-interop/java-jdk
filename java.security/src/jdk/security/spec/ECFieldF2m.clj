(ns jdk.security.spec.ECFieldF2m
  "This immutable class defines an elliptic curve (EC)
  characteristic 2 finite field."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.security.spec ECFieldF2m]))

(defn ->ec-field-f-2m
  "Constructor.

  Creates an elliptic curve characteristic 2 finite
   field which has 2^m elements with
   polynomial basis.
   The reduction polynomial for this field is based
   on rp whose i-th bit corresponds to
   the i-th coefficient of the reduction polynomial.
   Note: A valid reduction polynomial is either a
   trinomial (X^m  X^k  1
   with m > k >= 1) or a
   pentanomial (X^m  X^k3
    X^k2  X^k1  1 with
   m > k3 > k2
   > k1 >= 1).

  m - with 2^m being the number of elements. - `int`
  rp - the BigInteger whose i-th bit corresponds to the i-th coefficient of the reduction polynomial. - `java.math.BigInteger`

  throws: java.lang.NullPointerException - if rp is null."
  ([^Integer m ^java.math.BigInteger rp]
    (new ECFieldF2m m rp))
  ([^Integer m]
    (new ECFieldF2m m)))

(defn get-field-size
  "Returns the field size in bits which is m
   for this characteristic 2 finite field.

  returns: the field size in bits. - `int`"
  (^Integer [^java.security.spec.ECFieldF2m this]
    (-> this (.getFieldSize))))

(defn get-m
  "Returns the value m of this characteristic
   2 finite field.

  returns: m with 2^m being the
   number of elements. - `int`"
  (^Integer [^java.security.spec.ECFieldF2m this]
    (-> this (.getM))))

(defn get-reduction-polynomial
  "Returns a BigInteger whose i-th bit corresponds to the
   i-th coefficient of the reduction polynomial for polynomial
   basis or null for normal basis.

  returns: a BigInteger whose i-th bit corresponds to the
   i-th coefficient of the reduction polynomial for polynomial
   basis or null for normal basis. - `java.math.BigInteger`"
  (^java.math.BigInteger [^java.security.spec.ECFieldF2m this]
    (-> this (.getReductionPolynomial))))

(defn get-mid-terms-of-reduction-polynomial
  "Returns an integer array which contains the order of the
   middle term(s) of the reduction polynomial for polynomial
   basis or null for normal basis.

  returns: an integer array which contains the order of the
   middle term(s) of the reduction polynomial for polynomial
   basis or null for normal basis. A new array is returned
   each time this method is called. - `int[]`"
  ([^java.security.spec.ECFieldF2m this]
    (-> this (.getMidTermsOfReductionPolynomial))))

(defn equals
  "Compares this finite field for equality with the
   specified object.

  obj - the object to be compared. - `java.lang.Object`

  returns: true if obj is an instance
   of ECFieldF2m and both m and the reduction
   polynomial match, false otherwise. - `boolean`"
  (^Boolean [^java.security.spec.ECFieldF2m this ^java.lang.Object obj]
    (-> this (.equals obj))))

(defn hash-code
  "Returns a hash code value for this characteristic 2
   finite field.

  returns: a hash code value. - `int`"
  (^Integer [^java.security.spec.ECFieldF2m this]
    (-> this (.hashCode))))

