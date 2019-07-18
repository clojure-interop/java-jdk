(ns jdk.security.cert.PKIXRevocationChecker$Option
  (:refer-clojure :only [require comment defn ->])
  (:import [java.security.cert PKIXRevocationChecker$Option]))

(def ONLY_END_ENTITY
  "Enum Constant.

  Only check the revocation status of end-entity certificates.

  type: java.security.cert.PKIXRevocationChecker$Option"
  PKIXRevocationChecker$Option/ONLY_END_ENTITY)

(def PREFER_CRLS
  "Enum Constant.

  Prefer CRLs to OSCP. The default behavior is to prefer OCSP. Each
   PKIX implementation should document further details of their
   specific preference rules and fallback policies.

  type: java.security.cert.PKIXRevocationChecker$Option"
  PKIXRevocationChecker$Option/PREFER_CRLS)

(def NO_FALLBACK
  "Enum Constant.

  Disable the fallback mechanism.

  type: java.security.cert.PKIXRevocationChecker$Option"
  PKIXRevocationChecker$Option/NO_FALLBACK)

(def SOFT_FAIL
  "Enum Constant.

  Allow revocation check to succeed if the revocation status cannot be
   determined for one of the following reasons:

    The CRL or OCSP response cannot be obtained because of a
        network error.
    The OCSP responder returns one of the following errors
        specified in section 2.3 of RFC 2560: internalError or tryLater.

   Note that these conditions apply to both OCSP and CRLs, and unless
   the NO_FALLBACK option is set, the revocation check is
   allowed to succeed only if both mechanisms fail under one of the
   conditions as stated above.
   Exceptions that cause the network errors are ignored but can be
   later retrieved by calling the
   getSoftFailExceptions method.

  type: java.security.cert.PKIXRevocationChecker$Option"
  PKIXRevocationChecker$Option/SOFT_FAIL)

(defn *values
  "Returns an array containing the constants of this enum type, in
  the order they are declared.  This method may be used to iterate
  over the constants as follows:


  for (PKIXRevocationChecker.Option c : PKIXRevocationChecker.Option.values())
      System.out.println(c);

  returns: an array containing the constants of this enum type, in the order they are declared - `java.security.cert.PKIXRevocationChecker$Option[]`"
  ([]
    (PKIXRevocationChecker$Option/values )))

(defn *value-of
  "Returns the enum constant of this type with the specified name.
  The string must match exactly an identifier used to declare an
  enum constant in this type.  (Extraneous whitespace characters are
  not permitted.)

  name - the name of the enum constant to be returned. - `java.lang.String`

  returns: the enum constant with the specified name - `java.security.cert.PKIXRevocationChecker$Option`

  throws: java.lang.IllegalArgumentException - if this enum type has no constant with the specified name"
  (^java.security.cert.PKIXRevocationChecker$Option [^java.lang.String name]
    (PKIXRevocationChecker$Option/valueOf name)))

