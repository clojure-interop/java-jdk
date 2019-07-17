(ns jdk.security.spec.DSAPublicKeySpec
  "This class specifies a DSA public key with its associated parameters."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.security.spec DSAPublicKeySpec]))

(defn ->dsa-public-key-spec
  "Constructor.

  Creates a new DSAPublicKeySpec with the specified parameter values.

  y - the public key. - `java.math.BigInteger`
  p - the prime. - `java.math.BigInteger`
  q - the sub-prime. - `java.math.BigInteger`
  g - the base. - `java.math.BigInteger`"
  ([y p q g]
    (new DSAPublicKeySpec y p q g)))

(defn get-y
  "Returns the public key y.

  returns: the public key y. - `java.math.BigInteger`"
  ([this]
    (-> this (.getY))))

(defn get-p
  "Returns the prime p.

  returns: the prime p. - `java.math.BigInteger`"
  ([this]
    (-> this (.getP))))

(defn get-q
  "Returns the sub-prime q.

  returns: the sub-prime q. - `java.math.BigInteger`"
  ([this]
    (-> this (.getQ))))

(defn get-g
  "Returns the base g.

  returns: the base g. - `java.math.BigInteger`"
  ([this]
    (-> this (.getG))))

