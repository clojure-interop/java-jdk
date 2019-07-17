(ns jdk.security.cert.PKIXBuilderParameters
  "Parameters used as input for the PKIX CertPathBuilder
  algorithm.

  A PKIX CertPathBuilder uses these parameters to build a CertPath which has been
  validated according to the PKIX certification path validation algorithm.

  To instantiate a PKIXBuilderParameters object, an
  application must specify one or more most-trusted CAs as defined by
  the PKIX certification path validation algorithm. The most-trusted CA
  can be specified using one of two constructors. An application
  can call PKIXBuilderParameters(Set, CertSelector), specifying a
  Set of TrustAnchor objects, each of which
  identifies a most-trusted CA. Alternatively, an application can call
  PKIXBuilderParameters(KeyStore, CertSelector), specifying a
  KeyStore instance containing trusted certificate entries, each
  of which will be considered as a most-trusted CA.

  In addition, an application must specify constraints on the target
  certificate that the CertPathBuilder will attempt
  to build a path to. The constraints are specified as a
  CertSelector object. These constraints should provide the
  CertPathBuilder with enough search criteria to find the target
  certificate. Minimal criteria for an X509Certificate usually
  include the subject name and/or one or more subject alternative names.
  If enough criteria is not specified, the CertPathBuilder
  may throw a CertPathBuilderException.

  Concurrent Access

  Unless otherwise specified, the methods defined in this class are not
  thread-safe. Multiple threads that need to access a single
  object concurrently should synchronize amongst themselves and
  provide the necessary locking. Multiple threads each manipulating
  separate objects need not synchronize."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.security.cert PKIXBuilderParameters]))

(defn ->pkix-builder-parameters
  "Constructor.

  Creates an instance of PKIXBuilderParameters with
   the specified Set of most-trusted CAs.
   Each element of the set is a TrustAnchor.

   Note that the Set is copied to protect against
   subsequent modifications.

  trust-anchors - a Set of TrustAnchors - `java.util.Set<java.security.cert.TrustAnchor>`
  target-constraints - a CertSelector specifying the constraints on the target certificate - `java.security.cert.CertSelector`

  throws: java.security.InvalidAlgorithmParameterException - if trustAnchors is empty (trustAnchors.isEmpty() == true)"
  ([^java.util.Set trust-anchors ^java.security.cert.CertSelector target-constraints]
    (new PKIXBuilderParameters trust-anchors target-constraints)))

(defn set-max-path-length
  "Sets the value of the maximum number of non-self-issued intermediate
   certificates that may exist in a certification path. A certificate
   is self-issued if the DNs that appear in the subject and issuer
   fields are identical and are not empty. Note that the last certificate
   in a certification path is not an intermediate certificate, and is not
   included in this limit. Usually the last certificate is an end entity
   certificate, but it can be a CA certificate. A PKIX
   CertPathBuilder instance must not build
   paths longer than the length specified.

    A value of 0 implies that the path can only contain
   a single certificate. A value of -1 implies that the
   path length is unconstrained (i.e. there is no maximum).
   The default maximum path length, if not specified, is 5.
   Setting a value less than -1 will cause an exception to be thrown.

    If any of the CA certificates contain the
   BasicConstraintsExtension, the value of the
   pathLenConstraint field of the extension overrides
   the maximum path length parameter whenever the result is a
   certification path of smaller length.

  max-path-length - the maximum number of non-self-issued intermediate certificates that may exist in a certification path - `int`

  throws: java.security.InvalidParameterException - if maxPathLength is set to a value less than -1"
  ([^java.security.cert.PKIXBuilderParameters this ^Integer max-path-length]
    (-> this (.setMaxPathLength max-path-length))))

(defn get-max-path-length
  "Returns the value of the maximum number of intermediate non-self-issued
   certificates that may exist in a certification path. See
   the setMaxPathLength(int) method for more details.

  returns: the maximum number of non-self-issued intermediate certificates
    that may exist in a certification path, or -1 if there is no limit - `int`"
  (^Integer [^java.security.cert.PKIXBuilderParameters this]
    (-> this (.getMaxPathLength))))

(defn to-string
  "Returns a formatted string describing the parameters.

  returns: a formatted string describing the parameters - `java.lang.String`"
  (^java.lang.String [^java.security.cert.PKIXBuilderParameters this]
    (-> this (.toString))))

