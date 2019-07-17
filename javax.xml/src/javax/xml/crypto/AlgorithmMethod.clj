(ns javax.xml.crypto.AlgorithmMethod
  "An abstract representation of an algorithm defined in the XML Security
  specifications. Subclasses represent specific types of XML security
  algorithms, such as a Transform."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.xml.crypto AlgorithmMethod]))

(defn get-algorithm
  "Returns the algorithm URI of this AlgorithmMethod.

  returns: the algorithm URI of this AlgorithmMethod - `java.lang.String`"
  ([^. this]
    (-> this (.getAlgorithm))))

(defn get-parameter-spec
  "Returns the algorithm parameters of this AlgorithmMethod.

  returns: the algorithm parameters of this AlgorithmMethod.
      Returns null if this AlgorithmMethod does
      not require parameters and they are not specified. - `java.security.spec.AlgorithmParameterSpec`"
  ([^. this]
    (-> this (.getParameterSpec))))

