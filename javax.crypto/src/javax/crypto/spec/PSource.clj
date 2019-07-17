(ns javax.crypto.spec.PSource
  "This class specifies the source for encoding input P in OAEP Padding,
  as defined in the
  PKCS #1
  standard.


  PKCS1PSourceAlgorithms    ALGORITHM-IDENTIFIER ::= {
    { OID id-pSpecified PARAMETERS OCTET STRING },
    ...  -- Allows for future expansion --
  }"
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.crypto.spec PSource]))

(defn get-algorithm
  "Returns the PSource algorithm name.

  returns: the PSource algorithm name. - `java.lang.String`"
  ([^javax.crypto.spec.PSource this]
    (-> this (.getAlgorithm))))

