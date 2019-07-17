(ns jdk.security.spec.DSAGenParameterSpec
  "This immutable class specifies the set of parameters used for
  generating DSA parameters as specified in
  FIPS 186-3 Digital Signature Standard (DSS)."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.security.spec DSAGenParameterSpec]))

(defn ->dsa-gen-parameter-spec
  "Constructor.

  Creates a domain parameter specification for DSA parameter
   generation using primePLen, subprimeQLen,
   and seedLen.

  prime-p-len - the desired length of the prime P in bits. - `int`
  subprime-q-len - the desired length of the sub-prime Q in bits. - `int`
  seed-len - the desired length of the domain parameter seed in bits, shall be equal to or greater than subprimeQLen. - `int`

  throws: java.lang.IllegalArgumentException - if primePLenLen, subprimeQLen, or seedLen is illegal per the specification of FIPS 186-3."
  ([prime-p-len subprime-q-len seed-len]
    (new DSAGenParameterSpec prime-p-len subprime-q-len seed-len))
  ([prime-p-len subprime-q-len]
    (new DSAGenParameterSpec prime-p-len subprime-q-len)))

(defn get-prime-p-length
  "Returns the desired length of the prime P of the
   to-be-generated DSA domain parameters in bits.

  returns: the length of the prime P. - `int`"
  ([this]
    (-> this (.getPrimePLength))))

(defn get-subprime-q-length
  "Returns the desired length of the sub-prime Q of the
   to-be-generated DSA domain parameters in bits.

  returns: the length of the sub-prime Q. - `int`"
  ([this]
    (-> this (.getSubprimeQLength))))

(defn get-seed-length
  "Returns the desired length of the domain parameter seed in bits.

  returns: the length of the domain parameter seed. - `int`"
  ([this]
    (-> this (.getSeedLength))))

