(ns jdk.security.cert.PKIXCertPathValidatorResult
  "This class represents the successful result of the PKIX certification
  path validation algorithm.

  Instances of PKIXCertPathValidatorResult are returned by the
  validate method of
  CertPathValidator objects implementing the PKIX algorithm.

   All PKIXCertPathValidatorResult objects contain the
  valid policy tree and subject public key resulting from the
  validation algorithm, as well as a TrustAnchor describing
  the certification authority (CA) that served as a trust anchor for the
  certification path.

  Concurrent Access

  Unless otherwise specified, the methods defined in this class are not
  thread-safe. Multiple threads that need to access a single
  object concurrently should synchronize amongst themselves and
  provide the necessary locking. Multiple threads each manipulating
  separate objects need not synchronize."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.security.cert PKIXCertPathValidatorResult]))

(defn ->pkix-cert-path-validator-result
  "Constructor.

  Creates an instance of PKIXCertPathValidatorResult
   containing the specified parameters.

  trust-anchor - a TrustAnchor describing the CA that served as a trust anchor for the certification path - `java.security.cert.TrustAnchor`
  policy-tree - the immutable valid policy tree, or null if there are no valid policies - `java.security.cert.PolicyNode`
  subject-public-key - the public key of the subject - `java.security.PublicKey`

  throws: java.lang.NullPointerException - if the subjectPublicKey or trustAnchor parameters are null"
  ([^java.security.cert.TrustAnchor trust-anchor ^java.security.cert.PolicyNode policy-tree ^java.security.PublicKey subject-public-key]
    (new PKIXCertPathValidatorResult trust-anchor policy-tree subject-public-key)))

(defn get-trust-anchor
  "Returns the TrustAnchor describing the CA that served
   as a trust anchor for the certification path.

  returns: the TrustAnchor (never null) - `java.security.cert.TrustAnchor`"
  (^java.security.cert.TrustAnchor [^java.security.cert.PKIXCertPathValidatorResult this]
    (-> this (.getTrustAnchor))))

(defn get-policy-tree
  "Returns the root node of the valid policy tree resulting from the
   PKIX certification path validation algorithm. The
   PolicyNode object that is returned and any objects that
   it returns through public methods are immutable.

   Most applications will not need to examine the valid policy tree.
   They can achieve their policy processing goals by setting the
   policy-related parameters in PKIXParameters. However, more
   sophisticated applications, especially those that process policy
   qualifiers, may need to traverse the valid policy tree using the
   PolicyNode.getParent and
   PolicyNode.getChildren methods.

  returns: the root node of the valid policy tree, or null
   if there are no valid policies - `java.security.cert.PolicyNode`"
  (^java.security.cert.PolicyNode [^java.security.cert.PKIXCertPathValidatorResult this]
    (-> this (.getPolicyTree))))

(defn get-public-key
  "Returns the public key of the subject (target) of the certification
   path, including any inherited public key parameters if applicable.

  returns: the public key of the subject (never null) - `java.security.PublicKey`"
  (^java.security.PublicKey [^java.security.cert.PKIXCertPathValidatorResult this]
    (-> this (.getPublicKey))))

(defn clone
  "Returns a copy of this object.

  returns: the copy - `java.lang.Object`"
  (^java.lang.Object [^java.security.cert.PKIXCertPathValidatorResult this]
    (-> this (.clone))))

(defn to-string
  "Return a printable representation of this
   PKIXCertPathValidatorResult.

  returns: a String describing the contents of this
           PKIXCertPathValidatorResult - `java.lang.String`"
  (^java.lang.String [^java.security.cert.PKIXCertPathValidatorResult this]
    (-> this (.toString))))

