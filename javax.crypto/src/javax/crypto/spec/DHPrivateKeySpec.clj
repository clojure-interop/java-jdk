(ns javax.crypto.spec.DHPrivateKeySpec
  "This class specifies a Diffie-Hellman private key with its associated
  parameters.

  Note that this class does not perform any validation on specified
  parameters. Thus, the specified values are returned directly even
  if they are null."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.crypto.spec DHPrivateKeySpec]))

(defn ->dh-private-key-spec
  "Constructor.

  Constructor that takes a private value x, a prime
   modulus p, and a base generator g.

  x - private value x - `java.math.BigInteger`
  p - prime modulus p - `java.math.BigInteger`
  g - base generator g - `java.math.BigInteger`"
  ([^java.math.BigInteger x ^java.math.BigInteger p ^java.math.BigInteger g]
    (new DHPrivateKeySpec x p g)))

(defn get-x
  "Returns the private value x.

  returns: the private value x - `java.math.BigInteger`"
  ([^javax.crypto.spec.DHPrivateKeySpec this]
    (-> this (.getX))))

(defn get-p
  "Returns the prime modulus p.

  returns: the prime modulus p - `java.math.BigInteger`"
  ([^javax.crypto.spec.DHPrivateKeySpec this]
    (-> this (.getP))))

(defn get-g
  "Returns the base generator g.

  returns: the base generator g - `java.math.BigInteger`"
  ([^javax.crypto.spec.DHPrivateKeySpec this]
    (-> this (.getG))))

