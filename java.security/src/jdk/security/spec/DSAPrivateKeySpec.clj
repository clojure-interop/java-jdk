(ns jdk.security.spec.DSAPrivateKeySpec
  "This class specifies a DSA private key with its associated parameters."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.security.spec DSAPrivateKeySpec]))

(defn ->dsa-private-key-spec
  "Constructor.

  Creates a new DSAPrivateKeySpec with the specified parameter values.

  x - the private key. - `java.math.BigInteger`
  p - the prime. - `java.math.BigInteger`
  q - the sub-prime. - `java.math.BigInteger`
  g - the base. - `java.math.BigInteger`"
  ([^java.math.BigInteger x ^java.math.BigInteger p ^java.math.BigInteger q ^java.math.BigInteger g]
    (new DSAPrivateKeySpec x p q g)))

(defn get-x
  "Returns the private key x.

  returns: the private key x. - `java.math.BigInteger`"
  (^java.math.BigInteger [^java.security.spec.DSAPrivateKeySpec this]
    (-> this (.getX))))

(defn get-p
  "Returns the prime p.

  returns: the prime p. - `java.math.BigInteger`"
  (^java.math.BigInteger [^java.security.spec.DSAPrivateKeySpec this]
    (-> this (.getP))))

(defn get-q
  "Returns the sub-prime q.

  returns: the sub-prime q. - `java.math.BigInteger`"
  (^java.math.BigInteger [^java.security.spec.DSAPrivateKeySpec this]
    (-> this (.getQ))))

(defn get-g
  "Returns the base g.

  returns: the base g. - `java.math.BigInteger`"
  (^java.math.BigInteger [^java.security.spec.DSAPrivateKeySpec this]
    (-> this (.getG))))

