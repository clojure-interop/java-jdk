(ns jdk.security.cert.PKIXParameters
  "Parameters used as input for the PKIX CertPathValidator
  algorithm.

  A PKIX CertPathValidator uses these parameters to
  validate a CertPath according to the PKIX certification path
  validation algorithm.

  To instantiate a PKIXParameters object, an
  application must specify one or more most-trusted CAs as defined by
  the PKIX certification path validation algorithm. The most-trusted CAs
  can be specified using one of two constructors. An application
  can call PKIXParameters(Set),
  specifying a Set of TrustAnchor objects, each
  of which identify a most-trusted CA. Alternatively, an application can call
  PKIXParameters(KeyStore), specifying a
  KeyStore instance containing trusted certificate entries, each
  of which will be considered as a most-trusted CA.

  Once a PKIXParameters object has been created, other parameters
  can be specified (by calling setInitialPolicies
  or setDate, for instance) and then the
  PKIXParameters is passed along with the CertPath
  to be validated to CertPathValidator.validate.

  Any parameter that is not set (or is set to null) will
  be set to the default value for that parameter. The default value for the
  date parameter is null, which indicates
  the current time when the path is validated. The default for the
  remaining parameters is the least constrained.

  Concurrent Access

  Unless otherwise specified, the methods defined in this class are not
  thread-safe. Multiple threads that need to access a single
  object concurrently should synchronize amongst themselves and
  provide the necessary locking. Multiple threads each manipulating
  separate objects need not synchronize."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.security.cert PKIXParameters]))

(defn ->pkix-parameters
  "Constructor.

  Creates an instance of PKIXParameters with the specified
   Set of most-trusted CAs. Each element of the
   set is a TrustAnchor.

   Note that the Set is copied to protect against
   subsequent modifications.

  trust-anchors - a Set of TrustAnchors - `java.util.Set<java.security.cert.TrustAnchor>`

  throws: java.security.InvalidAlgorithmParameterException - if the specified Set is empty (trustAnchors.isEmpty() == true)"
  ([^java.util.Set trust-anchors]
    (new PKIXParameters trust-anchors)))

(defn revocation-enabled?
  "Checks the RevocationEnabled flag. If this flag is true, the default
   revocation checking mechanism of the underlying PKIX service provider
   will be used. If this flag is false, the default revocation checking
   mechanism will be disabled (not used). See the setRevocationEnabled method for more details on
   setting the value of this flag.

  returns: the current value of the RevocationEnabled flag - `boolean`"
  (^Boolean [^java.security.cert.PKIXParameters this]
    (-> this (.isRevocationEnabled))))

(defn get-policy-qualifiers-rejected?
  "Gets the PolicyQualifiersRejected flag. If this flag is true,
   certificates that include policy qualifiers in a certificate policies
   extension that is marked critical are rejected.
   If the flag is false, certificates are not rejected on this basis.

    When a PKIXParameters object is created, this flag is
   set to true. This setting reflects the most common (and simplest)
   strategy for processing policy qualifiers. Applications that want to use
   a more sophisticated policy must set this flag to false.

  returns: the current value of the PolicyQualifiersRejected flag - `boolean`"
  (^Boolean [^java.security.cert.PKIXParameters this]
    (-> this (.getPolicyQualifiersRejected))))

(defn set-policy-mapping-inhibited
  "Sets the PolicyMappingInhibited flag. If this flag is true, policy
   mapping is inhibited. By default, policy mapping is not inhibited (the
   flag is false).

  val - true if policy mapping is to be inhibited, false otherwise - `boolean`"
  ([^java.security.cert.PKIXParameters this ^Boolean val]
    (-> this (.setPolicyMappingInhibited val))))

(defn set-revocation-enabled
  "Sets the RevocationEnabled flag. If this flag is true, the default
   revocation checking mechanism of the underlying PKIX service provider
   will be used. If this flag is false, the default revocation checking
   mechanism will be disabled (not used).

   When a PKIXParameters object is created, this flag is set
   to true. This setting reflects the most common strategy for checking
   revocation, since each service provider must support revocation
   checking to be PKIX compliant. Sophisticated applications should set
   this flag to false when it is not practical to use a PKIX service
   provider's default revocation checking mechanism or when an alternative
   revocation checking mechanism is to be substituted (by also calling the
   addCertPathChecker or setCertPathCheckers methods).

  val - the new value of the RevocationEnabled flag - `boolean`"
  ([^java.security.cert.PKIXParameters this ^Boolean val]
    (-> this (.setRevocationEnabled val))))

(defn set-explicit-policy-required
  "Sets the ExplicitPolicyRequired flag. If this flag is true, an
   acceptable policy needs to be explicitly identified in every certificate.
   By default, the ExplicitPolicyRequired flag is false.

  val - true if explicit policy is to be required, false otherwise - `boolean`"
  ([^java.security.cert.PKIXParameters this ^Boolean val]
    (-> this (.setExplicitPolicyRequired val))))

(defn get-cert-stores
  "Returns an immutable List of CertStores that
   are used to find certificates and CRLs.

  returns: an immutable List of CertStores
   (may be empty, but never null) - `java.util.List<java.security.cert.CertStore>`"
  (^java.util.List [^java.security.cert.PKIXParameters this]
    (-> this (.getCertStores))))

(defn set-date
  "Sets the time for which the validity of the certification path
   should be determined. If null, the current time is used.

   Note that the Date supplied here is copied to protect
   against subsequent modifications.

  date - the Date, or null for the current time - `java.util.Date`"
  ([^java.security.cert.PKIXParameters this ^java.util.Date date]
    (-> this (.setDate date))))

(defn add-cert-path-checker
  "Adds a PKIXCertPathChecker to the list of certification
   path checkers. See the setCertPathCheckers
   method for more details.

   Note that the PKIXCertPathChecker is cloned to protect
   against subsequent modifications.

  checker - a PKIXCertPathChecker to add to the list of checks. If null, the checker is ignored (not added to list). - `java.security.cert.PKIXCertPathChecker`"
  ([^java.security.cert.PKIXParameters this ^java.security.cert.PKIXCertPathChecker checker]
    (-> this (.addCertPathChecker checker))))

(defn set-sig-provider
  "Sets the signature provider's name. The specified provider will be
   preferred when creating Signature
   objects. If null or not set, the first provider found
   supporting the algorithm will be used.

  sig-provider - the signature provider's name (or null) - `java.lang.String`"
  ([^java.security.cert.PKIXParameters this ^java.lang.String sig-provider]
    (-> this (.setSigProvider sig-provider))))

(defn set-cert-stores
  "Sets the list of CertStores to be used in finding
   certificates and CRLs. May be null, in which case
   no CertStores will be used. The first
   CertStores in the list may be preferred to those that
   appear later.

   Note that the List is copied to protect against
   subsequent modifications.

  stores - a List of CertStores (or null) - `java.util.List<java.security.cert.CertStore>`

  throws: java.lang.ClassCastException - if any of the elements in the list are not of type java.security.cert.CertStore"
  ([^java.security.cert.PKIXParameters this ^java.util.List stores]
    (-> this (.setCertStores stores))))

(defn add-cert-store
  "Adds a CertStore to the end of the list of
   CertStores used in finding certificates and CRLs.

  store - the CertStore to add. If null, the store is ignored (not added to list). - `java.security.cert.CertStore`"
  ([^java.security.cert.PKIXParameters this ^java.security.cert.CertStore store]
    (-> this (.addCertStore store))))

(defn set-policy-qualifiers-rejected
  "Sets the PolicyQualifiersRejected flag. If this flag is true,
   certificates that include policy qualifiers in a certificate
   policies extension that is marked critical are rejected.
   If the flag is false, certificates are not rejected on this basis.

    When a PKIXParameters object is created, this flag is
   set to true. This setting reflects the most common (and simplest)
   strategy for processing policy qualifiers. Applications that want to use
   a more sophisticated policy must set this flag to false.

   Note that the PKIX certification path validation algorithm specifies
   that any policy qualifier in a certificate policies extension that is
   marked critical must be processed and validated. Otherwise the
   certification path must be rejected. If the policyQualifiersRejected flag
   is set to false, it is up to the application to validate all policy
   qualifiers in this manner in order to be PKIX compliant.

  qualifiers-rejected - the new value of the PolicyQualifiersRejected flag - `boolean`"
  ([^java.security.cert.PKIXParameters this ^Boolean qualifiers-rejected]
    (-> this (.setPolicyQualifiersRejected qualifiers-rejected))))

(defn explicit-policy-required?
  "Checks if explicit policy is required. If this flag is true, an
   acceptable policy needs to be explicitly identified in every certificate.
   By default, the ExplicitPolicyRequired flag is false.

  returns: true if explicit policy is required,
   false otherwise - `boolean`"
  (^Boolean [^java.security.cert.PKIXParameters this]
    (-> this (.isExplicitPolicyRequired))))

(defn to-string
  "Returns a formatted string describing the parameters.

  returns: a formatted string describing the parameters. - `java.lang.String`"
  (^java.lang.String [^java.security.cert.PKIXParameters this]
    (-> this (.toString))))

(defn any-policy-inhibited?
  "Checks whether the any policy OID should be processed if it
   is included in a certificate.

  returns: true if the any policy OID is inhibited,
   false otherwise - `boolean`"
  (^Boolean [^java.security.cert.PKIXParameters this]
    (-> this (.isAnyPolicyInhibited))))

(defn get-date
  "Returns the time for which the validity of the certification path
   should be determined. If null, the current time is used.

   Note that the Date returned is copied to protect against
   subsequent modifications.

  returns: the Date, or null if not set - `java.util.Date`"
  (^java.util.Date [^java.security.cert.PKIXParameters this]
    (-> this (.getDate))))

(defn set-cert-path-checkers
  "Sets a List of additional certification path checkers. If
   the specified List contains an object that is not a
   PKIXCertPathChecker, it is ignored.

   Each PKIXCertPathChecker specified implements
   additional checks on a certificate. Typically, these are checks to
   process and verify private extensions contained in certificates.
   Each PKIXCertPathChecker should be instantiated with any
   initialization parameters needed to execute the check.

   This method allows sophisticated applications to extend a PKIX
   CertPathValidator or CertPathBuilder.
   Each of the specified PKIXCertPathCheckers will be called,
   in turn, by a PKIX CertPathValidator or
   CertPathBuilder for each certificate processed or
   validated.

   Regardless of whether these additional PKIXCertPathCheckers
   are set, a PKIX CertPathValidator or
   CertPathBuilder must perform all of the required PKIX
   checks on each certificate. The one exception to this rule is if the
   RevocationEnabled flag is set to false (see the setRevocationEnabled method).

   Note that the List supplied here is copied and each
   PKIXCertPathChecker in the list is cloned to protect
   against subsequent modifications.

  checkers - a List of PKIXCertPathCheckers. May be null, in which case no additional checkers will be used. - `java.util.List<java.security.cert.PKIXCertPathChecker>`

  throws: java.lang.ClassCastException - if any of the elements in the list are not of type java.security.cert.PKIXCertPathChecker"
  ([^java.security.cert.PKIXParameters this ^java.util.List checkers]
    (-> this (.setCertPathCheckers checkers))))

(defn policy-mapping-inhibited?
  "Checks if policy mapping is inhibited. If this flag is true, policy
   mapping is inhibited. By default, policy mapping is not inhibited (the
   flag is false).

  returns: true if policy mapping is inhibited, false otherwise - `boolean`"
  (^Boolean [^java.security.cert.PKIXParameters this]
    (-> this (.isPolicyMappingInhibited))))

(defn get-trust-anchors
  "Returns an immutable Set of the most-trusted
   CAs.

  returns: an immutable Set of TrustAnchors
   (never null) - `java.util.Set<java.security.cert.TrustAnchor>`"
  (^java.util.Set [^java.security.cert.PKIXParameters this]
    (-> this (.getTrustAnchors))))

(defn set-trust-anchors
  "Sets the Set of most-trusted CAs.

   Note that the Set is copied to protect against
   subsequent modifications.

  trust-anchors - a Set of TrustAnchors - `java.util.Set<java.security.cert.TrustAnchor>`

  throws: java.security.InvalidAlgorithmParameterException - if the specified Set is empty (trustAnchors.isEmpty() == true)"
  ([^java.security.cert.PKIXParameters this ^java.util.Set trust-anchors]
    (-> this (.setTrustAnchors trust-anchors))))

(defn clone
  "Makes a copy of this PKIXParameters object. Changes
   to the copy will not affect the original and vice versa.

  returns: a copy of this PKIXParameters object - `java.lang.Object`"
  (^java.lang.Object [^java.security.cert.PKIXParameters this]
    (-> this (.clone))))

(defn get-initial-policies
  "Returns an immutable Set of initial
   policy identifiers (OID strings), indicating that any one of these
   policies would be acceptable to the certificate user for the purposes of
   certification path processing. The default return value is an empty
   Set, which is interpreted as meaning that any policy would
   be acceptable.

  returns: an immutable Set of initial policy OIDs in
   String format, or an empty Set (implying any
   policy is acceptable). Never returns null. - `java.util.Set<java.lang.String>`"
  (^java.util.Set [^java.security.cert.PKIXParameters this]
    (-> this (.getInitialPolicies))))

(defn get-cert-path-checkers
  "Returns the List of certification path checkers.
   The returned List is immutable, and each
   PKIXCertPathChecker in the List is cloned
   to protect against subsequent modifications.

  returns: an immutable List of
   PKIXCertPathCheckers (may be empty, but not
   null) - `java.util.List<java.security.cert.PKIXCertPathChecker>`"
  (^java.util.List [^java.security.cert.PKIXParameters this]
    (-> this (.getCertPathCheckers))))

(defn set-initial-policies
  "Sets the Set of initial policy identifiers
   (OID strings), indicating that any one of these
   policies would be acceptable to the certificate user for the purposes of
   certification path processing. By default, any policy is acceptable
   (i.e. all policies), so a user that wants to allow any policy as
   acceptable does not need to call this method, or can call it
   with an empty Set (or null).

   Note that the Set is copied to protect against
   subsequent modifications.

  initial-policies - a Set of initial policy OIDs in String format (or null) - `java.util.Set<java.lang.String>`

  throws: java.lang.ClassCastException - if any of the elements in the set are not of type String"
  ([^java.security.cert.PKIXParameters this ^java.util.Set initial-policies]
    (-> this (.setInitialPolicies initial-policies))))

(defn get-target-cert-constraints
  "Returns the required constraints on the target certificate.
   The constraints are returned as an instance of CertSelector.
   If null, no constraints are defined.

   Note that the CertSelector returned is cloned
   to protect against subsequent modifications.

  returns: a CertSelector specifying the constraints
   on the target certificate (or null) - `java.security.cert.CertSelector`"
  (^java.security.cert.CertSelector [^java.security.cert.PKIXParameters this]
    (-> this (.getTargetCertConstraints))))

(defn get-sig-provider
  "Returns the signature provider's name, or null
   if not set.

  returns: the signature provider's name (or null) - `java.lang.String`"
  (^java.lang.String [^java.security.cert.PKIXParameters this]
    (-> this (.getSigProvider))))

(defn set-target-cert-constraints
  "Sets the required constraints on the target certificate.
   The constraints are specified as an instance of
   CertSelector. If null, no constraints are
   defined.

   Note that the CertSelector specified is cloned
   to protect against subsequent modifications.

  selector - a CertSelector specifying the constraints on the target certificate (or null) - `java.security.cert.CertSelector`"
  ([^java.security.cert.PKIXParameters this ^java.security.cert.CertSelector selector]
    (-> this (.setTargetCertConstraints selector))))

(defn set-any-policy-inhibited
  "Sets state to determine if the any policy OID should be processed
   if it is included in a certificate. By default, the any policy OID
   is not inhibited (isAnyPolicyInhibited()
   returns false).

  val - true if the any policy OID is to be inhibited, false otherwise - `boolean`"
  ([^java.security.cert.PKIXParameters this ^Boolean val]
    (-> this (.setAnyPolicyInhibited val))))

