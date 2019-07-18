(ns jdk.security.cert.PKIXCertPathBuilderResult
  "This class represents the successful result of the PKIX certification
  path builder algorithm. All certification paths that are built and
  returned using this algorithm are also validated according to the PKIX
  certification path validation algorithm.

  Instances of PKIXCertPathBuilderResult are returned by
  the build method of CertPathBuilder
  objects implementing the PKIX algorithm.

  All PKIXCertPathBuilderResult objects contain the
  certification path constructed by the build algorithm, the
  valid policy tree and subject public key resulting from the build
  algorithm, and a TrustAnchor describing the certification
  authority (CA) that served as a trust anchor for the certification path.

  Concurrent Access

  Unless otherwise specified, the methods defined in this class are not
  thread-safe. Multiple threads that need to access a single
  object concurrently should synchronize amongst themselves and
  provide the necessary locking. Multiple threads each manipulating
  separate objects need not synchronize."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.security.cert PKIXCertPathBuilderResult]))

(defn ->pkix-cert-path-builder-result
  "Constructor.

  Creates an instance of PKIXCertPathBuilderResult
   containing the specified parameters.

  cert-path - the validated CertPath - `java.security.cert.CertPath`
  trust-anchor - a TrustAnchor describing the CA that served as a trust anchor for the certification path - `java.security.cert.TrustAnchor`
  policy-tree - the immutable valid policy tree, or null if there are no valid policies - `java.security.cert.PolicyNode`
  subject-public-key - the public key of the subject - `java.security.PublicKey`

  throws: java.lang.NullPointerException - if the certPath, trustAnchor or subjectPublicKey parameters are null"
  (^PKIXCertPathBuilderResult [^java.security.cert.CertPath cert-path ^java.security.cert.TrustAnchor trust-anchor ^java.security.cert.PolicyNode policy-tree ^java.security.PublicKey subject-public-key]
    (new PKIXCertPathBuilderResult cert-path trust-anchor policy-tree subject-public-key)))

(defn get-cert-path
  "Returns the built and validated certification path. The
   CertPath object does not include the trust anchor.
   Instead, use the getTrustAnchor() method to
   obtain the TrustAnchor that served as the trust anchor
   for the certification path.

  returns: the built and validated CertPath (never
   null) - `java.security.cert.CertPath`"
  (^java.security.cert.CertPath [^PKIXCertPathBuilderResult this]
    (-> this (.getCertPath))))

(defn to-string
  "Return a printable representation of this
   PKIXCertPathBuilderResult.

  returns: a String describing the contents of this
           PKIXCertPathBuilderResult - `java.lang.String`"
  (^java.lang.String [^PKIXCertPathBuilderResult this]
    (-> this (.toString))))

