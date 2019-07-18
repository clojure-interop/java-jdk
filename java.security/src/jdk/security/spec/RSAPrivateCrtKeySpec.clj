(ns jdk.security.spec.RSAPrivateCrtKeySpec
  "This class specifies an RSA private key, as defined in the PKCS#1
  standard, using the Chinese Remainder Theorem (CRT) information values for
  efficiency."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.security.spec RSAPrivateCrtKeySpec]))

(defn ->rsa-private-crt-key-spec
  "Constructor.

  Creates a new RSAPrivateCrtKeySpec
   given the modulus, publicExponent, privateExponent,
   primeP, primeQ, primeExponentP, primeExponentQ, and
   crtCoefficient as defined in PKCS#1.

  modulus - the modulus n - `java.math.BigInteger`
  public-exponent - the public exponent e - `java.math.BigInteger`
  private-exponent - the private exponent d - `java.math.BigInteger`
  prime-p - the prime factor p of n - `java.math.BigInteger`
  prime-q - the prime factor q of n - `java.math.BigInteger`
  prime-exponent-p - this is d mod (p-1) - `java.math.BigInteger`
  prime-exponent-q - this is d mod (q-1) - `java.math.BigInteger`
  crt-coefficient - the Chinese Remainder Theorem coefficient q-1 mod p - `java.math.BigInteger`"
  (^RSAPrivateCrtKeySpec [^java.math.BigInteger modulus ^java.math.BigInteger public-exponent ^java.math.BigInteger private-exponent ^java.math.BigInteger prime-p ^java.math.BigInteger prime-q ^java.math.BigInteger prime-exponent-p ^java.math.BigInteger prime-exponent-q ^java.math.BigInteger crt-coefficient]
    (new RSAPrivateCrtKeySpec modulus public-exponent private-exponent prime-p prime-q prime-exponent-p prime-exponent-q crt-coefficient)))

(defn get-public-exponent
  "Returns the public exponent.

  returns: the public exponent - `java.math.BigInteger`"
  (^java.math.BigInteger [^RSAPrivateCrtKeySpec this]
    (-> this (.getPublicExponent))))

(defn get-prime-p
  "Returns the primeP.

  returns: the primeP - `java.math.BigInteger`"
  (^java.math.BigInteger [^RSAPrivateCrtKeySpec this]
    (-> this (.getPrimeP))))

(defn get-prime-q
  "Returns the primeQ.

  returns: the primeQ - `java.math.BigInteger`"
  (^java.math.BigInteger [^RSAPrivateCrtKeySpec this]
    (-> this (.getPrimeQ))))

(defn get-prime-exponent-p
  "Returns the primeExponentP.

  returns: the primeExponentP - `java.math.BigInteger`"
  (^java.math.BigInteger [^RSAPrivateCrtKeySpec this]
    (-> this (.getPrimeExponentP))))

(defn get-prime-exponent-q
  "Returns the primeExponentQ.

  returns: the primeExponentQ - `java.math.BigInteger`"
  (^java.math.BigInteger [^RSAPrivateCrtKeySpec this]
    (-> this (.getPrimeExponentQ))))

(defn get-crt-coefficient
  "Returns the crtCoefficient.

  returns: the crtCoefficient - `java.math.BigInteger`"
  (^java.math.BigInteger [^RSAPrivateCrtKeySpec this]
    (-> this (.getCrtCoefficient))))

