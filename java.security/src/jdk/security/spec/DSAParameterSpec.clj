(ns jdk.security.spec.DSAParameterSpec
  "This class specifies the set of parameters used with the DSA algorithm."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.security.spec DSAParameterSpec]))

(defn ->dsa-parameter-spec
  "Constructor.

  Creates a new DSAParameterSpec with the specified parameter values.

  p - the prime. - `java.math.BigInteger`
  q - the sub-prime. - `java.math.BigInteger`
  g - the base. - `java.math.BigInteger`"
  ([^java.math.BigInteger p ^java.math.BigInteger q ^java.math.BigInteger g]
    (new DSAParameterSpec p q g)))

(defn get-p
  "Returns the prime p.

  returns: the prime p. - `java.math.BigInteger`"
  ([^java.security.spec.DSAParameterSpec this]
    (-> this (.getP))))

(defn get-q
  "Returns the sub-prime q.

  returns: the sub-prime q. - `java.math.BigInteger`"
  ([^java.security.spec.DSAParameterSpec this]
    (-> this (.getQ))))

(defn get-g
  "Returns the base g.

  returns: the base g. - `java.math.BigInteger`"
  ([^java.security.spec.DSAParameterSpec this]
    (-> this (.getG))))

