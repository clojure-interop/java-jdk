(ns jdk.security.cert.CertPathValidatorException$BasicReason
  (:refer-clojure :only [require comment defn ->])
  (:import [java.security.cert CertPathValidatorException$BasicReason]))

(def UNSPECIFIED
  "Enum Constant.

  Unspecified reason.

  type: java.security.cert.CertPathValidatorException.BasicReason"
  CertPathValidatorException$BasicReason/UNSPECIFIED)

(def EXPIRED
  "Enum Constant.

  The certificate is expired.

  type: java.security.cert.CertPathValidatorException.BasicReason"
  CertPathValidatorException$BasicReason/EXPIRED)

(def NOT_YET_VALID
  "Enum Constant.

  The certificate is not yet valid.

  type: java.security.cert.CertPathValidatorException.BasicReason"
  CertPathValidatorException$BasicReason/NOT_YET_VALID)

(def REVOKED
  "Enum Constant.

  The certificate is revoked.

  type: java.security.cert.CertPathValidatorException.BasicReason"
  CertPathValidatorException$BasicReason/REVOKED)

(def UNDETERMINED_REVOCATION_STATUS
  "Enum Constant.

  The revocation status of the certificate could not be determined.

  type: java.security.cert.CertPathValidatorException.BasicReason"
  CertPathValidatorException$BasicReason/UNDETERMINED_REVOCATION_STATUS)

(def INVALID_SIGNATURE
  "Enum Constant.

  The signature is invalid.

  type: java.security.cert.CertPathValidatorException.BasicReason"
  CertPathValidatorException$BasicReason/INVALID_SIGNATURE)

(def ALGORITHM_CONSTRAINED
  "Enum Constant.

  The public key or the signature algorithm has been constrained.

  type: java.security.cert.CertPathValidatorException.BasicReason"
  CertPathValidatorException$BasicReason/ALGORITHM_CONSTRAINED)

(defn *values
  "Returns an array containing the constants of this enum type, in
  the order they are declared.  This method may be used to iterate
  over the constants as follows:


  for (CertPathValidatorException.BasicReason c : CertPathValidatorException.BasicReason.values())
      System.out.println(c);

  returns: an array containing the constants of this enum type, in the order they are declared - `java.security.cert.CertPathValidatorException.BasicReason[]`"
  ([]
    (CertPathValidatorException$BasicReason/values )))

(defn *value-of
  "Returns the enum constant of this type with the specified name.
  The string must match exactly an identifier used to declare an
  enum constant in this type.  (Extraneous whitespace characters are
  not permitted.)

  name - the name of the enum constant to be returned. - `java.lang.String`

  returns: the enum constant with the specified name - `java.security.cert.CertPathValidatorException.BasicReason`

  throws: java.lang.IllegalArgumentException - if this enum type has no constant with the specified name"
  (^java.security.cert.CertPathValidatorException.BasicReason [^java.lang.String name]
    (CertPathValidatorException$BasicReason/valueOf name)))

