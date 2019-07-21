(ns jdk.security.spec.MGF1ParameterSpec
  "This class specifies the set of parameters used with mask generation
  function MGF1 in OAEP Padding and RSA-PSS signature scheme, as
  defined in the
  PKCS #1 v2.1
  standard.

  Its ASN.1 definition in PKCS#1 standard is described below:


  MGF1Parameters ::= OAEP-PSSDigestAlgorthms
  where


  OAEP-PSSDigestAlgorithms    ALGORITHM-IDENTIFIER ::= {
    { OID id-sha1 PARAMETERS NULL   }|
    { OID id-sha224 PARAMETERS NULL   }|
    { OID id-sha256 PARAMETERS NULL }|
    { OID id-sha384 PARAMETERS NULL }|
    { OID id-sha512 PARAMETERS NULL },
    ...  -- Allows for future expansion --
  }"
  (:refer-clojure :only [require comment defn ->])
  (:import [java.security.spec MGF1ParameterSpec]))

(defn ->mgf-1-parameter-spec
  "Constructor.

  Constructs a parameter set for mask generation function MGF1
   as defined in the PKCS #1 standard.

  md-name - the algorithm name for the message digest used in this mask generation function MGF1. - `java.lang.String`

  throws: java.lang.NullPointerException - if mdName is null."
  (^MGF1ParameterSpec [^java.lang.String md-name]
    (new MGF1ParameterSpec md-name)))

(def *-sha-1
  "Static Constant.

  The MGF1ParameterSpec which uses \"SHA-1\" message digest.

  type: java.security.spec.MGF1ParameterSpec"
  MGF1ParameterSpec/SHA1)

(def *-sha-224
  "Static Constant.

  The MGF1ParameterSpec which uses \"SHA-224\" message digest.

  type: java.security.spec.MGF1ParameterSpec"
  MGF1ParameterSpec/SHA224)

(def *-sha-256
  "Static Constant.

  The MGF1ParameterSpec which uses \"SHA-256\" message digest.

  type: java.security.spec.MGF1ParameterSpec"
  MGF1ParameterSpec/SHA256)

(def *-sha-384
  "Static Constant.

  The MGF1ParameterSpec which uses \"SHA-384\" message digest.

  type: java.security.spec.MGF1ParameterSpec"
  MGF1ParameterSpec/SHA384)

(def *-sha-512
  "Static Constant.

  The MGF1ParameterSpec which uses SHA-512 message digest.

  type: java.security.spec.MGF1ParameterSpec"
  MGF1ParameterSpec/SHA512)

(defn get-digest-algorithm
  "Returns the algorithm name of the message digest used by the mask
   generation function.

  returns: the algorithm name of the message digest. - `java.lang.String`"
  (^java.lang.String [^MGF1ParameterSpec this]
    (-> this (.getDigestAlgorithm))))

