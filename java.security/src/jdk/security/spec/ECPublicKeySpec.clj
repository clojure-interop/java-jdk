(ns jdk.security.spec.ECPublicKeySpec
  "This immutable class specifies an elliptic curve public key with
  its associated parameters."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.security.spec ECPublicKeySpec]))

(defn ->ec-public-key-spec
  "Constructor.

  Creates a new ECPublicKeySpec with the specified
   parameter values.

  w - the public point. - `java.security.spec.ECPoint`
  params - the associated elliptic curve domain parameters. - `java.security.spec.ECParameterSpec`

  throws: java.lang.NullPointerException - if w or params is null."
  ([^java.security.spec.ECPoint w ^java.security.spec.ECParameterSpec params]
    (new ECPublicKeySpec w params)))

(defn get-w
  "Returns the public point W.

  returns: the public point W. - `java.security.spec.ECPoint`"
  (^java.security.spec.ECPoint [^java.security.spec.ECPublicKeySpec this]
    (-> this (.getW))))

(defn get-params
  "Returns the associated elliptic curve domain
   parameters.

  returns: the EC domain parameters. - `java.security.spec.ECParameterSpec`"
  (^java.security.spec.ECParameterSpec [^java.security.spec.ECPublicKeySpec this]
    (-> this (.getParams))))

