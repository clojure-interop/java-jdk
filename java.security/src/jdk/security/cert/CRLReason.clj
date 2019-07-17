(ns jdk.security.cert.CRLReason
  (:refer-clojure :only [require comment defn ->])
  (:import [java.security.cert CRLReason]))

(def UNSPECIFIED
  "Enum Constant.

  This reason indicates that it is unspecified as to why the
   certificate has been revoked.

  type: java.security.cert.CRLReason"
  CRLReason/UNSPECIFIED)

(def KEY_COMPROMISE
  "Enum Constant.

  This reason indicates that it is known or suspected that the
   certificate subject's private key has been compromised. It applies
   to end-entity certificates only.

  type: java.security.cert.CRLReason"
  CRLReason/KEY_COMPROMISE)

(def CA_COMPROMISE
  "Enum Constant.

  This reason indicates that it is known or suspected that the
   certificate subject's private key has been compromised. It applies
   to certificate authority (CA) certificates only.

  type: java.security.cert.CRLReason"
  CRLReason/CA_COMPROMISE)

(def AFFILIATION_CHANGED
  "Enum Constant.

  This reason indicates that the subject's name or other information
   has changed.

  type: java.security.cert.CRLReason"
  CRLReason/AFFILIATION_CHANGED)

(def SUPERSEDED
  "Enum Constant.

  This reason indicates that the certificate has been superseded.

  type: java.security.cert.CRLReason"
  CRLReason/SUPERSEDED)

(def CESSATION_OF_OPERATION
  "Enum Constant.

  This reason indicates that the certificate is no longer needed.

  type: java.security.cert.CRLReason"
  CRLReason/CESSATION_OF_OPERATION)

(def CERTIFICATE_HOLD
  "Enum Constant.

  This reason indicates that the certificate has been put on hold.

  type: java.security.cert.CRLReason"
  CRLReason/CERTIFICATE_HOLD)

(def UNUSED
  "Enum Constant.

  Unused reason.

  type: java.security.cert.CRLReason"
  CRLReason/UNUSED)

(def REMOVE_FROM_CRL
  "Enum Constant.

  This reason indicates that the certificate was previously on hold
   and should be removed from the CRL. It is for use with delta CRLs.

  type: java.security.cert.CRLReason"
  CRLReason/REMOVE_FROM_CRL)

(def PRIVILEGE_WITHDRAWN
  "Enum Constant.

  This reason indicates that the privileges granted to the subject of
   the certificate have been withdrawn.

  type: java.security.cert.CRLReason"
  CRLReason/PRIVILEGE_WITHDRAWN)

(def AA_COMPROMISE
  "Enum Constant.

  This reason indicates that it is known or suspected that the
   certificate subject's private key has been compromised. It applies
   to authority attribute (AA) certificates only.

  type: java.security.cert.CRLReason"
  CRLReason/AA_COMPROMISE)

(defn *values
  "Returns an array containing the constants of this enum type, in
  the order they are declared.  This method may be used to iterate
  over the constants as follows:


  for (CRLReason c : CRLReason.values())
      System.out.println(c);

  returns: an array containing the constants of this enum type, in the order they are declared - `java.security.cert.CRLReason[]`"
  ([]
    (CRLReason/values )))

(defn *value-of
  "Returns the enum constant of this type with the specified name.
  The string must match exactly an identifier used to declare an
  enum constant in this type.  (Extraneous whitespace characters are
  not permitted.)

  name - the name of the enum constant to be returned. - `java.lang.String`

  returns: the enum constant with the specified name - `java.security.cert.CRLReason`

  throws: java.lang.IllegalArgumentException - if this enum type has no constant with the specified name"
  ([^java.lang.String name]
    (CRLReason/valueOf name)))

