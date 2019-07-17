(ns jdk.security.spec.AlgorithmParameterSpec
  "A (transparent) specification of cryptographic parameters.

   This interface contains no methods or constants. Its only purpose
  is to group (and provide type safety for) all parameter specifications.
  All parameter specifications must implement this interface."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.security.spec AlgorithmParameterSpec]))

