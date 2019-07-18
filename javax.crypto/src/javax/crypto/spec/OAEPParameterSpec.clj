(ns javax.crypto.spec.OAEPParameterSpec
  "This class specifies the set of parameters used with OAEP Padding,
  as defined in the
  PKCS #1
  standard.

  Its ASN.1 definition in PKCS#1 standard is described below:


  RSAES-OAEP-params ::= SEQUENCE {
    hashAlgorithm      [0] OAEP-PSSDigestAlgorithms     DEFAULT sha1,
    maskGenAlgorithm   [1] PKCS1MGFAlgorithms  DEFAULT mgf1SHA1,
    pSourceAlgorithm   [2] PKCS1PSourceAlgorithms  DEFAULT pSpecifiedEmpty
  }
  where


  OAEP-PSSDigestAlgorithms    ALGORITHM-IDENTIFIER ::= {
    { OID id-sha1 PARAMETERS NULL   }|
    { OID id-sha256 PARAMETERS NULL }|
    { OID id-sha384 PARAMETERS NULL }|
    { OID id-sha512 PARAMETERS NULL },
    ...  -- Allows for future expansion --
  }
  PKCS1MGFAlgorithms    ALGORITHM-IDENTIFIER ::= {
    { OID id-mgf1 PARAMETERS OAEP-PSSDigestAlgorithms },
    ...  -- Allows for future expansion --
  }
  PKCS1PSourceAlgorithms    ALGORITHM-IDENTIFIER ::= {
    { OID id-pSpecified PARAMETERS OCTET STRING },
    ...  -- Allows for future expansion --
  }
  Note: the OAEPParameterSpec.DEFAULT uses the following:
      message digest  -- `SHA-1`
      mask generation function (mgf) -- `MGF1`
      parameters for mgf -- MGF1ParameterSpec.SHA1
      source of encoding input -- PSource.PSpecified.DEFAULT"
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.crypto.spec OAEPParameterSpec]))

(defn ->oaep-parameter-spec
  "Constructor.

  Constructs a parameter set for OAEP padding as defined in
   the PKCS #1 standard using the specified message digest
   algorithm mdName, mask generation function
   algorithm mgfName, parameters for the mask
   generation function mgfSpec, and source of
   the encoding input P pSrc.

  md-name - the algorithm name for the message digest. - `java.lang.String`
  mgf-name - the algorithm name for the mask generation function. - `java.lang.String`
  mgf-spec - the parameters for the mask generation function. If null is specified, null will be returned by getMGFParameters(). - `java.security.spec.AlgorithmParameterSpec`
  p-src - the source of the encoding input P. - `javax.crypto.spec.PSource`

  throws: java.lang.NullPointerException - if mdName, mgfName, or pSrc is null."
  (^OAEPParameterSpec [^java.lang.String md-name ^java.lang.String mgf-name ^java.security.spec.AlgorithmParameterSpec mgf-spec ^javax.crypto.spec.PSource p-src]
    (new OAEPParameterSpec md-name mgf-name mgf-spec p-src)))

(def *-default
  "Static Constant.

  The OAEP parameter set with all default values.

  type: javax.crypto.spec.OAEPParameterSpec"
  OAEPParameterSpec/DEFAULT)

(defn get-digest-algorithm
  "Returns the message digest algorithm name.

  returns: the message digest algorithm name. - `java.lang.String`"
  (^java.lang.String [^OAEPParameterSpec this]
    (-> this (.getDigestAlgorithm))))

(defn get-mgf-algorithm
  "Returns the mask generation function algorithm name.

  returns: the mask generation function algorithm name. - `java.lang.String`"
  (^java.lang.String [^OAEPParameterSpec this]
    (-> this (.getMGFAlgorithm))))

(defn get-mgf-parameters
  "Returns the parameters for the mask generation function.

  returns: the parameters for the mask generation function. - `java.security.spec.AlgorithmParameterSpec`"
  (^java.security.spec.AlgorithmParameterSpec [^OAEPParameterSpec this]
    (-> this (.getMGFParameters))))

(defn get-p-source
  "Returns the source of encoding input P.

  returns: the source of encoding input P. - `javax.crypto.spec.PSource`"
  (^javax.crypto.spec.PSource [^OAEPParameterSpec this]
    (-> this (.getPSource))))

