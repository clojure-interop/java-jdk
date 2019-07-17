(ns jdk.security.interfaces.RSAMultiPrimePrivateCrtKey
  "The interface to an RSA multi-prime private key, as defined in the
  PKCS#1 v2.1, using the Chinese Remainder Theorem
  (CRT) information values."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.security.interfaces RSAMultiPrimePrivateCrtKey]))

(defn get-public-exponent
  "Returns the public exponent.

  returns: the public exponent. - `java.math.BigInteger`"
  (^java.math.BigInteger [^java.security.interfaces.RSAMultiPrimePrivateCrtKey this]
    (-> this (.getPublicExponent))))

(defn get-prime-p
  "Returns the primeP.

  returns: the primeP. - `java.math.BigInteger`"
  (^java.math.BigInteger [^java.security.interfaces.RSAMultiPrimePrivateCrtKey this]
    (-> this (.getPrimeP))))

(defn get-prime-q
  "Returns the primeQ.

  returns: the primeQ. - `java.math.BigInteger`"
  (^java.math.BigInteger [^java.security.interfaces.RSAMultiPrimePrivateCrtKey this]
    (-> this (.getPrimeQ))))

(defn get-prime-exponent-p
  "Returns the primeExponentP.

  returns: the primeExponentP. - `java.math.BigInteger`"
  (^java.math.BigInteger [^java.security.interfaces.RSAMultiPrimePrivateCrtKey this]
    (-> this (.getPrimeExponentP))))

(defn get-prime-exponent-q
  "Returns the primeExponentQ.

  returns: the primeExponentQ. - `java.math.BigInteger`"
  (^java.math.BigInteger [^java.security.interfaces.RSAMultiPrimePrivateCrtKey this]
    (-> this (.getPrimeExponentQ))))

(defn get-crt-coefficient
  "Returns the crtCoefficient.

  returns: the crtCoefficient. - `java.math.BigInteger`"
  (^java.math.BigInteger [^java.security.interfaces.RSAMultiPrimePrivateCrtKey this]
    (-> this (.getCrtCoefficient))))

(defn get-other-prime-info
  "Returns the otherPrimeInfo or null if there are only
   two prime factors (p and q).

  returns: the otherPrimeInfo. - `java.security.spec.RSAOtherPrimeInfo[]`"
  ([^java.security.interfaces.RSAMultiPrimePrivateCrtKey this]
    (-> this (.getOtherPrimeInfo))))

