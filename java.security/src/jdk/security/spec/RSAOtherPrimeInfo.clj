(ns jdk.security.spec.RSAOtherPrimeInfo
  "This class represents the triplet (prime, exponent, and coefficient)
  inside RSA's OtherPrimeInfo structure, as defined in the PKCS#1 v2.1.
  The ASN.1 syntax of RSA's OtherPrimeInfo is as follows:



  OtherPrimeInfo ::= SEQUENCE {
    prime INTEGER,
    exponent INTEGER,
    coefficient INTEGER
    }"
  (:refer-clojure :only [require comment defn ->])
  (:import [java.security.spec RSAOtherPrimeInfo]))

(defn ->rsa-other-prime-info
  "Constructor.

  Creates a new RSAOtherPrimeInfo
   given the prime, primeExponent, and
   crtCoefficient as defined in PKCS#1.

  prime - the prime factor of n. - `java.math.BigInteger`
  prime-exponent - the exponent. - `java.math.BigInteger`
  crt-coefficient - the Chinese Remainder Theorem coefficient. - `java.math.BigInteger`

  throws: java.lang.NullPointerException - if any of the parameters, i.e. prime, primeExponent, crtCoefficient, is null."
  ([^java.math.BigInteger prime ^java.math.BigInteger prime-exponent ^java.math.BigInteger crt-coefficient]
    (new RSAOtherPrimeInfo prime prime-exponent crt-coefficient)))

(defn get-prime
  "Returns the prime.

  returns: the prime. - `java.math.BigInteger`"
  (^java.math.BigInteger [^java.security.spec.RSAOtherPrimeInfo this]
    (-> this (.getPrime))))

(defn get-exponent
  "Returns the prime's exponent.

  returns: the primeExponent. - `java.math.BigInteger`"
  (^java.math.BigInteger [^java.security.spec.RSAOtherPrimeInfo this]
    (-> this (.getExponent))))

(defn get-crt-coefficient
  "Returns the prime's crtCoefficient.

  returns: the crtCoefficient. - `java.math.BigInteger`"
  (^java.math.BigInteger [^java.security.spec.RSAOtherPrimeInfo this]
    (-> this (.getCrtCoefficient))))

