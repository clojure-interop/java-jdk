(ns jdk.security.spec.RSAKeyGenParameterSpec
  "This class specifies the set of parameters used to generate an RSA
  key pair."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.security.spec RSAKeyGenParameterSpec]))

(defn ->rsa-key-gen-parameter-spec
  "Constructor.

  Constructs a new RSAParameterSpec object from the
   given keysize and public-exponent value.

  keysize - the modulus size (specified in number of bits) - `int`
  public-exponent - the public exponent - `java.math.BigInteger`"
  ([^Integer keysize ^java.math.BigInteger public-exponent]
    (new RSAKeyGenParameterSpec keysize public-exponent)))

(def *-f-0
  "Static Constant.

  The public-exponent value F0 = 3.

  type: java.math.BigInteger"
  RSAKeyGenParameterSpec/F0)

(def *-f-4
  "Static Constant.

  The public exponent-value F4 = 65537.

  type: java.math.BigInteger"
  RSAKeyGenParameterSpec/F4)

(defn get-keysize
  "Returns the keysize.

  returns: the keysize. - `int`"
  ([^java.security.spec.RSAKeyGenParameterSpec this]
    (-> this (.getKeysize))))

(defn get-public-exponent
  "Returns the public-exponent value.

  returns: the public-exponent value. - `java.math.BigInteger`"
  ([^java.security.spec.RSAKeyGenParameterSpec this]
    (-> this (.getPublicExponent))))

