(ns jdk.security.AlgorithmConstraints
  "This interface specifies constraints for cryptographic algorithms,
  keys (key sizes), and other algorithm parameters.

  AlgorithmConstraints objects are immutable.  An implementation
  of this interface should not provide methods that can change the state
  of an instance once it has been created.

  Note that AlgorithmConstraints can be used to represent the
  restrictions described by the security properties
  jdk.certpath.disabledAlgorithms and
  jdk.tls.disabledAlgorithms, or could be used by a
  concrete PKIXCertPathChecker to check whether a specified
  certificate in the certification path contains the required algorithm
  constraints."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.security AlgorithmConstraints]))

(defn permits
  "Determines whether an algorithm and the corresponding key are granted
   permission for the specified cryptographic primitives.

  primitives - a set of cryptographic primitives - `java.util.Set<java.security.CryptoPrimitive>`
  algorithm - the algorithm name - `java.lang.String`
  key - the key - `java.security.Key`
  parameters - the algorithm parameters, or null if no additional parameters - `java.security.AlgorithmParameters`

  returns: true if the key and the algorithm can be used for all of the
       specified cryptographic primitives - `boolean`

  throws: java.lang.IllegalArgumentException - if primitives or algorithm is null or empty, or the key is null"
  ([this primitives algorithm key parameters]
    (-> this (.permits primitives algorithm key parameters)))
  ([this primitives algorithm parameters]
    (-> this (.permits primitives algorithm parameters)))
  ([this primitives key]
    (-> this (.permits primitives key))))

