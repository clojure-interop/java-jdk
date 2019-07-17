(ns jdk.security.cert.PKIXReason
  (:refer-clojure :only [require comment defn ->])
  (:import [java.security.cert PKIXReason]))

(def NAME_CHAINING
  "Enum Constant.

  The certificate does not chain correctly.

  type: java.security.cert.PKIXReason"
  PKIXReason/NAME_CHAINING)

(def INVALID_KEY_USAGE
  "Enum Constant.

  The certificate's key usage is invalid.

  type: java.security.cert.PKIXReason"
  PKIXReason/INVALID_KEY_USAGE)

(def INVALID_POLICY
  "Enum Constant.

  The policy constraints have been violated.

  type: java.security.cert.PKIXReason"
  PKIXReason/INVALID_POLICY)

(def NO_TRUST_ANCHOR
  "Enum Constant.

  No acceptable trust anchor found.

  type: java.security.cert.PKIXReason"
  PKIXReason/NO_TRUST_ANCHOR)

(def UNRECOGNIZED_CRIT_EXT
  "Enum Constant.

  The certificate contains one or more unrecognized critical
   extensions.

  type: java.security.cert.PKIXReason"
  PKIXReason/UNRECOGNIZED_CRIT_EXT)

(def NOT_CA_CERT
  "Enum Constant.

  The certificate is not a CA certificate.

  type: java.security.cert.PKIXReason"
  PKIXReason/NOT_CA_CERT)

(def PATH_TOO_LONG
  "Enum Constant.

  The path length constraint has been violated.

  type: java.security.cert.PKIXReason"
  PKIXReason/PATH_TOO_LONG)

(def INVALID_NAME
  "Enum Constant.

  The name constraints have been violated.

  type: java.security.cert.PKIXReason"
  PKIXReason/INVALID_NAME)

(defn *values
  "Returns an array containing the constants of this enum type, in
  the order they are declared.  This method may be used to iterate
  over the constants as follows:


  for (PKIXReason c : PKIXReason.values())
      System.out.println(c);

  returns: an array containing the constants of this enum type, in the order they are declared - `java.security.cert.PKIXReason[]`"
  ([]
    (PKIXReason/values )))

(defn *value-of
  "Returns the enum constant of this type with the specified name.
  The string must match exactly an identifier used to declare an
  enum constant in this type.  (Extraneous whitespace characters are
  not permitted.)

  name - the name of the enum constant to be returned. - `java.lang.String`

  returns: the enum constant with the specified name - `java.security.cert.PKIXReason`

  throws: java.lang.IllegalArgumentException - if this enum type has no constant with the specified name"
  (^java.security.cert.PKIXReason [^java.lang.String name]
    (PKIXReason/valueOf name)))

