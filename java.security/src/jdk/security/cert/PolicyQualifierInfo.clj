(ns jdk.security.cert.PolicyQualifierInfo
  "An immutable policy qualifier represented by the ASN.1 PolicyQualifierInfo
  structure.

  The ASN.1 definition is as follows:


    PolicyQualifierInfo ::= SEQUENCE {
         policyQualifierId       PolicyQualifierId,
         qualifier               ANY DEFINED BY policyQualifierId }

  A certificate policies extension, if present in an X.509 version 3
  certificate, contains a sequence of one or more policy information terms,
  each of which consists of an object identifier (OID) and optional
  qualifiers. In an end-entity certificate, these policy information terms
  indicate the policy under which the certificate has been issued and the
  purposes for which the certificate may be used. In a CA certificate, these
  policy information terms limit the set of policies for certification paths
  which include this certificate.

  A Set of PolicyQualifierInfo objects are returned
  by the PolicyNode.getPolicyQualifiers
  method. This allows applications with specific policy requirements to
  process and validate each policy qualifier. Applications that need to
  process policy qualifiers should explicitly set the
  policyQualifiersRejected flag to false (by calling the
  PKIXParameters.setPolicyQualifiersRejected method) before validating
  a certification path.

  Note that the PKIX certification path validation algorithm specifies
  that any policy qualifier in a certificate policies extension that is
  marked critical must be processed and validated. Otherwise the
  certification path must be rejected. If the
  policyQualifiersRejected flag is set to false, it is up to
  the application to validate all policy qualifiers in this manner in order
  to be PKIX compliant.

  Concurrent Access

  All PolicyQualifierInfo objects must be immutable and
  thread-safe. That is, multiple threads may concurrently invoke the
  methods defined in this class on a single PolicyQualifierInfo
  object (or more than one) with no ill effects. Requiring
  PolicyQualifierInfo objects to be immutable and thread-safe
  allows them to be passed around to various pieces of code without
  worrying about coordinating access."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.security.cert PolicyQualifierInfo]))

(defn ->policy-qualifier-info
  "Constructor.

  Creates an instance of PolicyQualifierInfo from the
   encoded bytes. The encoded byte array is copied on construction.

  encoded - a byte array containing the qualifier in DER encoding - `byte[]`

  throws: java.io.IOException - thrown if the byte array does not represent a valid and parsable policy qualifier"
  ([encoded]
    (new PolicyQualifierInfo encoded)))

(defn get-policy-qualifier-id
  "Returns the policyQualifierId field of this
   PolicyQualifierInfo. The policyQualifierId
   is an Object Identifier (OID) represented by a set of nonnegative
   integers separated by periods.

  returns: the OID (never null) - `java.lang.String`"
  ([^java.security.cert.PolicyQualifierInfo this]
    (-> this (.getPolicyQualifierId))))

(defn get-encoded
  "Returns the ASN.1 DER encoded form of this
   PolicyQualifierInfo.

  returns: the ASN.1 DER encoded bytes (never null).
   Note that a copy is returned, so the data is cloned each time
   this method is called. - `byte[]`"
  ([^java.security.cert.PolicyQualifierInfo this]
    (-> this (.getEncoded))))

(defn get-policy-qualifier
  "Returns the ASN.1 DER encoded form of the qualifier
   field of this PolicyQualifierInfo.

  returns: the ASN.1 DER encoded bytes of the qualifier
   field. Note that a copy is returned, so the data is cloned each
   time this method is called. - `byte[]`"
  ([^java.security.cert.PolicyQualifierInfo this]
    (-> this (.getPolicyQualifier))))

(defn to-string
  "Return a printable representation of this
   PolicyQualifierInfo.

  returns: a String describing the contents of this
           PolicyQualifierInfo - `java.lang.String`"
  ([^java.security.cert.PolicyQualifierInfo this]
    (-> this (.toString))))

