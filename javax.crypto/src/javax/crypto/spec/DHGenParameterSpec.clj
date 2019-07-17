(ns javax.crypto.spec.DHGenParameterSpec
  "This class specifies the set of parameters used for generating
  Diffie-Hellman (system) parameters for use in Diffie-Hellman key
  agreement. This is typically done by a central
  authority.

   The central authority, after computing the parameters, must send this
  information to the parties looking to agree on a secret key."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.crypto.spec DHGenParameterSpec]))

(defn ->dh-gen-parameter-spec
  "Constructor.

  Constructs a parameter set for the generation of Diffie-Hellman
   (system) parameters. The constructed parameter set can be used to
   initialize an
   AlgorithmParameterGenerator
   object for the generation of Diffie-Hellman parameters.

  prime-size - the size (in bits) of the prime modulus. - `int`
  exponent-size - the size (in bits) of the random exponent. - `int`"
  ([^Integer prime-size ^Integer exponent-size]
    (new DHGenParameterSpec prime-size exponent-size)))

(defn get-prime-size
  "Returns the size in bits of the prime modulus.

  returns: the size in bits of the prime modulus - `int`"
  (^Integer [^javax.crypto.spec.DHGenParameterSpec this]
    (-> this (.getPrimeSize))))

(defn get-exponent-size
  "Returns the size in bits of the random exponent (private value).

  returns: the size in bits of the random exponent (private value) - `int`"
  (^Integer [^javax.crypto.spec.DHGenParameterSpec this]
    (-> this (.getExponentSize))))

