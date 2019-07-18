(ns jdk.security.spec.PSSParameterSpec
  "This class specifies a parameter spec for RSA-PSS signature scheme,
  as defined in the
  PKCS#1 v2.1
  standard.

  Its ASN.1 definition in PKCS#1 standard is described below:


  RSASSA-PSS-params ::= SEQUENCE {
    hashAlgorithm      [0] OAEP-PSSDigestAlgorithms  DEFAULT sha1,
    maskGenAlgorithm   [1] PKCS1MGFAlgorithms  DEFAULT mgf1SHA1,
    saltLength         [2] INTEGER  DEFAULT 20,
    trailerField       [3] INTEGER  DEFAULT 1
  }
  where


  OAEP-PSSDigestAlgorithms    ALGORITHM-IDENTIFIER ::= {
    { OID id-sha1 PARAMETERS NULL   }|
    { OID id-sha224 PARAMETERS NULL   }|
    { OID id-sha256 PARAMETERS NULL }|
    { OID id-sha384 PARAMETERS NULL }|
    { OID id-sha512 PARAMETERS NULL },
    ...  -- Allows for future expansion --
  }

  PKCS1MGFAlgorithms    ALGORITHM-IDENTIFIER ::= {
    { OID id-mgf1 PARAMETERS OAEP-PSSDigestAlgorithms },
    ...  -- Allows for future expansion --
  }
  Note: the PSSParameterSpec.DEFAULT uses the following:
      message digest  -- `SHA-1`
      mask generation function (mgf) -- `MGF1`
      parameters for mgf -- MGF1ParameterSpec.SHA1
      SaltLength   -- 20
      TrailerField -- 1"
  (:refer-clojure :only [require comment defn ->])
  (:import [java.security.spec PSSParameterSpec]))

(defn ->pss-parameter-spec
  "Constructor.

  Creates a new PSSParameterSpec as defined in
   the PKCS #1 standard using the specified message digest,
   mask generation function, parameters for mask generation
   function, salt length, and trailer field values.

  md-name - the algorithm name of the hash function. - `java.lang.String`
  mgf-name - the algorithm name of the mask generation function. - `java.lang.String`
  mgf-spec - the parameters for the mask generation function. If null is specified, null will be returned by getMGFParameters(). - `java.security.spec.AlgorithmParameterSpec`
  salt-len - the length of salt. - `int`
  trailer-field - the value of the trailer field. - `int`

  throws: java.lang.NullPointerException - if mdName, or mgfName is null."
  (^PSSParameterSpec [^java.lang.String md-name ^java.lang.String mgf-name ^java.security.spec.AlgorithmParameterSpec mgf-spec ^Integer salt-len ^Integer trailer-field]
    (new PSSParameterSpec md-name mgf-name mgf-spec salt-len trailer-field))
  (^PSSParameterSpec [^Integer salt-len]
    (new PSSParameterSpec salt-len)))

(def *-default
  "Static Constant.

  The PSS parameter set with all default values.

  type: java.security.spec.PSSParameterSpec"
  PSSParameterSpec/DEFAULT)

(defn get-digest-algorithm
  "Returns the message digest algorithm name.

  returns: the message digest algorithm name. - `java.lang.String`"
  (^java.lang.String [^PSSParameterSpec this]
    (-> this (.getDigestAlgorithm))))

(defn get-mgf-algorithm
  "Returns the mask generation function algorithm name.

  returns: the mask generation function algorithm name. - `java.lang.String`"
  (^java.lang.String [^PSSParameterSpec this]
    (-> this (.getMGFAlgorithm))))

(defn get-mgf-parameters
  "Returns the parameters for the mask generation function.

  returns: the parameters for the mask generation function. - `java.security.spec.AlgorithmParameterSpec`"
  (^java.security.spec.AlgorithmParameterSpec [^PSSParameterSpec this]
    (-> this (.getMGFParameters))))

(defn get-salt-length
  "Returns the salt length in bits.

  returns: the salt length. - `int`"
  (^Integer [^PSSParameterSpec this]
    (-> this (.getSaltLength))))

(defn get-trailer-field
  "Returns the value for the trailer field, i.e. bc in PKCS#1 v2.1.

  returns: the value for the trailer field, i.e. bc in PKCS#1 v2.1. - `int`"
  (^Integer [^PSSParameterSpec this]
    (-> this (.getTrailerField))))

