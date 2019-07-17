(ns jdk.security.spec.RSAMultiPrimePrivateCrtKeySpec
  "This class specifies an RSA multi-prime private key, as defined in the
  PKCS#1 v2.1, using the Chinese Remainder Theorem (CRT) information
  values for efficiency."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.security.spec RSAMultiPrimePrivateCrtKeySpec]))

(defn ->rsa-multi-prime-private-crt-key-spec
  "Constructor.

  Creates a new RSAMultiPrimePrivateCrtKeySpec
   given the modulus, publicExponent, privateExponent,
   primeP, primeQ, primeExponentP, primeExponentQ,
   crtCoefficient, and otherPrimeInfo as defined in PKCS#1 v2.1.

   Note that the contents of otherPrimeInfo
   are copied to protect against subsequent modification when
   constructing this object.

  modulus - the modulus n. - `java.math.BigInteger`
  public-exponent - the public exponent e. - `java.math.BigInteger`
  private-exponent - the private exponent d. - `java.math.BigInteger`
  prime-p - the prime factor p of n. - `java.math.BigInteger`
  prime-q - the prime factor q of n. - `java.math.BigInteger`
  prime-exponent-p - this is d mod (p-1). - `java.math.BigInteger`
  prime-exponent-q - this is d mod (q-1). - `java.math.BigInteger`
  crt-coefficient - the Chinese Remainder Theorem coefficient q-1 mod p. - `java.math.BigInteger`
  other-prime-info - triplets of the rest of primes, null can be specified if there are only two prime factors (p and q). - `java.security.spec.RSAOtherPrimeInfo[]`

  throws: java.lang.NullPointerException - if any of the parameters, i.e. modulus, publicExponent, privateExponent, primeP, primeQ, primeExponentP, primeExponentQ, crtCoefficient, is null."
  ([^java.math.BigInteger modulus ^java.math.BigInteger public-exponent ^java.math.BigInteger private-exponent ^java.math.BigInteger prime-p ^java.math.BigInteger prime-q ^java.math.BigInteger prime-exponent-p ^java.math.BigInteger prime-exponent-q ^java.math.BigInteger crt-coefficient ^java.security.spec.RSAOtherPrimeInfo[] other-prime-info]
    (new RSAMultiPrimePrivateCrtKeySpec modulus public-exponent private-exponent prime-p prime-q prime-exponent-p prime-exponent-q crt-coefficient other-prime-info)))

(defn get-public-exponent
  "Returns the public exponent.

  returns: the public exponent. - `java.math.BigInteger`"
  ([^java.security.spec.RSAMultiPrimePrivateCrtKeySpec this]
    (-> this (.getPublicExponent))))

(defn get-prime-p
  "Returns the primeP.

  returns: the primeP. - `java.math.BigInteger`"
  ([^java.security.spec.RSAMultiPrimePrivateCrtKeySpec this]
    (-> this (.getPrimeP))))

(defn get-prime-q
  "Returns the primeQ.

  returns: the primeQ. - `java.math.BigInteger`"
  ([^java.security.spec.RSAMultiPrimePrivateCrtKeySpec this]
    (-> this (.getPrimeQ))))

(defn get-prime-exponent-p
  "Returns the primeExponentP.

  returns: the primeExponentP. - `java.math.BigInteger`"
  ([^java.security.spec.RSAMultiPrimePrivateCrtKeySpec this]
    (-> this (.getPrimeExponentP))))

(defn get-prime-exponent-q
  "Returns the primeExponentQ.

  returns: the primeExponentQ. - `java.math.BigInteger`"
  ([^java.security.spec.RSAMultiPrimePrivateCrtKeySpec this]
    (-> this (.getPrimeExponentQ))))

(defn get-crt-coefficient
  "Returns the crtCoefficient.

  returns: the crtCoefficient. - `java.math.BigInteger`"
  ([^java.security.spec.RSAMultiPrimePrivateCrtKeySpec this]
    (-> this (.getCrtCoefficient))))

(defn get-other-prime-info
  "Returns a copy of the otherPrimeInfo or null if there are
   only two prime factors (p and q).

  returns: the otherPrimeInfo. Returns a new array each
   time this method is called. - `java.security.spec.RSAOtherPrimeInfo[]`"
  ([^java.security.spec.RSAMultiPrimePrivateCrtKeySpec this]
    (-> this (.getOtherPrimeInfo))))

