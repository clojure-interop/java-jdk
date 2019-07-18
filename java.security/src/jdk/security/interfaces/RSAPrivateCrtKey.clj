(ns jdk.security.interfaces.RSAPrivateCrtKey
  "The interface to an RSA private key, as defined in the PKCS#1 standard,
  using the Chinese Remainder Theorem (CRT) information values."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.security.interfaces RSAPrivateCrtKey]))

(defn get-public-exponent
  "Returns the public exponent.

  returns: the public exponent - `java.math.BigInteger`"
  (^java.math.BigInteger [^RSAPrivateCrtKey this]
    (-> this (.getPublicExponent))))

(defn get-prime-p
  "Returns the primeP.

  returns: the primeP - `java.math.BigInteger`"
  (^java.math.BigInteger [^RSAPrivateCrtKey this]
    (-> this (.getPrimeP))))

(defn get-prime-q
  "Returns the primeQ.

  returns: the primeQ - `java.math.BigInteger`"
  (^java.math.BigInteger [^RSAPrivateCrtKey this]
    (-> this (.getPrimeQ))))

(defn get-prime-exponent-p
  "Returns the primeExponentP.

  returns: the primeExponentP - `java.math.BigInteger`"
  (^java.math.BigInteger [^RSAPrivateCrtKey this]
    (-> this (.getPrimeExponentP))))

(defn get-prime-exponent-q
  "Returns the primeExponentQ.

  returns: the primeExponentQ - `java.math.BigInteger`"
  (^java.math.BigInteger [^RSAPrivateCrtKey this]
    (-> this (.getPrimeExponentQ))))

(defn get-crt-coefficient
  "Returns the crtCoefficient.

  returns: the crtCoefficient - `java.math.BigInteger`"
  (^java.math.BigInteger [^RSAPrivateCrtKey this]
    (-> this (.getCrtCoefficient))))

