(ns jdk.security.cert.PKIXRevocationChecker
  "A PKIXCertPathChecker for checking the revocation status of
  certificates with the PKIX algorithm.

  A PKIXRevocationChecker checks the revocation status of
  certificates with the Online Certificate Status Protocol (OCSP) or
  Certificate Revocation Lists (CRLs). OCSP is described in RFC 2560 and
  is a network protocol for determining the status of a certificate. A CRL
  is a time-stamped list identifying revoked certificates, and RFC 5280
  describes an algorithm for determining the revocation status of certificates
  using CRLs.

  Each PKIXRevocationChecker must be able to check the revocation
  status of certificates with OCSP and CRLs. By default, OCSP is the
  preferred mechanism for checking revocation status, with CRLs as the
  fallback mechanism. However, this preference can be switched to CRLs with
  the PREFER_CRLS option. In addition, the fallback
  mechanism can be disabled with the NO_FALLBACK
  option.

  A PKIXRevocationChecker is obtained by calling the
  getRevocationChecker method
  of a PKIX CertPathValidator. Additional parameters and options
  specific to revocation can be set (by calling the
  setOcspResponder method for instance). The
  PKIXRevocationChecker is added to a PKIXParameters object
  using the addCertPathChecker
  or setCertPathCheckers method,
  and then the PKIXParameters is passed along with the CertPath
  to be validated to the validate method
  of a PKIX CertPathValidator. When supplying a revocation checker in
  this manner, it will be used to check revocation irrespective of the setting
  of the RevocationEnabled flag.
  Similarly, a PKIXRevocationChecker may be added to a
  PKIXBuilderParameters object for use with a PKIX
  CertPathBuilder.

  Note that when a PKIXRevocationChecker is added to
  PKIXParameters, it clones the PKIXRevocationChecker;
  thus any subsequent modifications to the PKIXRevocationChecker
  have no effect.

  Any parameter that is not set (or is set to null) will be set to
  the default value for that parameter.

  Concurrent Access

  Unless otherwise specified, the methods defined in this class are not
  thread-safe. Multiple threads that need to access a single object
  concurrently should synchronize amongst themselves and provide the
  necessary locking. Multiple threads each manipulating separate objects
  need not synchronize."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.security.cert PKIXRevocationChecker]))

(defn set-options
  "Sets the revocation options.

  options - a set of revocation options. The set is copied to protect against subsequent modification. - `java.util.Set<java.security.cert.PKIXRevocationChecker.Option>`"
  ([this options]
    (-> this (.setOptions options))))

(defn set-ocsp-extensions
  "Sets the optional OCSP request extensions.

  extensions - a list of extensions. The list is copied to protect against subsequent modification. - `java.util.List<java.security.cert.Extension>`"
  ([this extensions]
    (-> this (.setOcspExtensions extensions))))

(defn get-ocsp-responder-cert
  "Gets the OCSP responder's certificate. This overrides the
   ocsp.responderCertSubjectName,
   ocsp.responderCertIssuerName,
   and ocsp.responderCertSerialNumber security properties. If this
   parameter or the aforementioned properties are not set, then the
   responder's certificate is determined as specified in RFC 2560.

  returns: the responder's certificate, or null if not set - `java.security.cert.X509Certificate`"
  ([this]
    (-> this (.getOcspResponderCert))))

(defn set-ocsp-responses
  "Sets the OCSP responses. These responses are used to determine
   the revocation status of the specified certificates when OCSP is used.

  responses - a map of OCSP responses. Each key is an X509Certificate that maps to the corresponding DER-encoded OCSP response for that certificate. A deep copy of the map is performed to protect against subsequent modification. - `java.util.Map<java.security.cert.X509Certificate,byte[]>`"
  ([this responses]
    (-> this (.setOcspResponses responses))))

(defn get-ocsp-responder
  "Gets the URI that identifies the location of the OCSP responder. This
   overrides the ocsp.responderURL security property. If this
   parameter or the ocsp.responderURL property is not set, the
   location is determined from the certificate's Authority Information
   Access Extension, as defined in RFC 5280.

  returns: the responder URI, or null if not set - `java.net.URI`"
  ([this]
    (-> this (.getOcspResponder))))

(defn get-soft-fail-exceptions
  "Returns a list containing the exceptions that are ignored by the
   revocation checker when the SOFT_FAIL option
   is set. The list is cleared each time init is called.
   The list is ordered in ascending order according to the certificate
   index returned by getIndex
   method of each entry.

   An implementation of PKIXRevocationChecker is responsible for
   adding the ignored exceptions to the list.

  returns: an unmodifiable list containing the ignored exceptions. The list
           is empty if no exceptions have been ignored. - `java.util.List<java.security.cert.CertPathValidatorException>`"
  ([this]
    (-> this (.getSoftFailExceptions))))

(defn set-ocsp-responder
  "Sets the URI that identifies the location of the OCSP responder. This
   overrides the ocsp.responderURL security property and any
   responder specified in a certificate's Authority Information Access
   Extension, as defined in RFC 5280.

  uri - the responder URI - `java.net.URI`"
  ([this uri]
    (-> this (.setOcspResponder uri))))

(defn get-ocsp-extensions
  "Gets the optional OCSP request extensions.

  returns: an unmodifiable list of extensions. The list is empty if no
           extensions have been specified. - `java.util.List<java.security.cert.Extension>`"
  ([this]
    (-> this (.getOcspExtensions))))

(defn get-options
  "Gets the revocation options.

  returns: an unmodifiable set of revocation options. The set is empty if
           no options have been specified. - `java.util.Set<java.security.cert.PKIXRevocationChecker.Option>`"
  ([this]
    (-> this (.getOptions))))

(defn clone
  "Description copied from class: PKIXCertPathChecker

  returns: a copy of this PKIXCertPathChecker - `java.security.cert.PKIXRevocationChecker`"
  ([this]
    (-> this (.clone))))

(defn get-ocsp-responses
  "Gets the OCSP responses. These responses are used to determine
   the revocation status of the specified certificates when OCSP is used.

  returns: a map of OCSP responses. Each key is an
          X509Certificate that maps to the corresponding
          DER-encoded OCSP response for that certificate. A deep copy of
          the map is returned to protect against subsequent modification.
          Returns an empty map if no responses have been specified. - `java.util.Map<java.security.cert.X509Certificate,byte[]>`"
  ([this]
    (-> this (.getOcspResponses))))

(defn set-ocsp-responder-cert
  "Sets the OCSP responder's certificate. This overrides the
   ocsp.responderCertSubjectName,
   ocsp.responderCertIssuerName,
   and ocsp.responderCertSerialNumber security properties.

  cert - the responder's certificate - `java.security.cert.X509Certificate`"
  ([this cert]
    (-> this (.setOcspResponderCert cert))))

