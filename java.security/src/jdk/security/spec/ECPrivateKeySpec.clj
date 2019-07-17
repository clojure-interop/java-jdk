(ns jdk.security.spec.ECPrivateKeySpec
  "This immutable class specifies an elliptic curve private key with
  its associated parameters."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.security.spec ECPrivateKeySpec]))

(defn ->ec-private-key-spec
  "Constructor.

  Creates a new ECPrivateKeySpec with the specified
   parameter values.

  s - the private value. - `java.math.BigInteger`
  params - the associated elliptic curve domain parameters. - `java.security.spec.ECParameterSpec`

  throws: java.lang.NullPointerException - if s or params is null."
  ([s params]
    (new ECPrivateKeySpec s params)))

(defn get-s
  "Returns the private value S.

  returns: the private value S. - `java.math.BigInteger`"
  ([this]
    (-> this (.getS))))

(defn get-params
  "Returns the associated elliptic curve domain
   parameters.

  returns: the EC domain parameters. - `java.security.spec.ECParameterSpec`"
  ([this]
    (-> this (.getParams))))

