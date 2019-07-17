(ns javax.crypto.spec.DHPublicKeySpec
  "This class specifies a Diffie-Hellman public key with its associated
  parameters.

  Note that this class does not perform any validation on specified
  parameters. Thus, the specified values are returned directly even
  if they are null."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.crypto.spec DHPublicKeySpec]))

(defn ->dh-public-key-spec
  "Constructor.

  Constructor that takes a public value y, a prime
   modulus p, and a base generator g.

  y - public value y - `java.math.BigInteger`
  p - prime modulus p - `java.math.BigInteger`
  g - base generator g - `java.math.BigInteger`"
  ([y p g]
    (new DHPublicKeySpec y p g)))

(defn get-y
  "Returns the public value y.

  returns: the public value y - `java.math.BigInteger`"
  ([this]
    (-> this (.getY))))

(defn get-p
  "Returns the prime modulus p.

  returns: the prime modulus p - `java.math.BigInteger`"
  ([this]
    (-> this (.getP))))

(defn get-g
  "Returns the base generator g.

  returns: the base generator g - `java.math.BigInteger`"
  ([this]
    (-> this (.getG))))

