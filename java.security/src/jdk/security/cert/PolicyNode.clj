(ns jdk.security.cert.PolicyNode
  "An immutable valid policy tree node as defined by the PKIX certification
  path validation algorithm.

  One of the outputs of the PKIX certification path validation
  algorithm is a valid policy tree, which includes the policies that
  were determined to be valid, how this determination was reached,
  and any policy qualifiers encountered. This tree is of depth
  n, where n is the length of the certification
  path that has been validated.

  Most applications will not need to examine the valid policy tree.
  They can achieve their policy processing goals by setting the
  policy-related parameters in PKIXParameters. However,
  the valid policy tree is available for more sophisticated applications,
  especially those that process policy qualifiers.

  PKIXCertPathValidatorResult.getPolicyTree returns the root node of the
  valid policy tree. The tree can be traversed using the
  getChildren and getParent methods.
  Data about a particular node can be retrieved using other methods of
  PolicyNode.

  Concurrent Access
  All PolicyNode objects must be immutable and
  thread-safe. Multiple threads may concurrently invoke the methods defined
  in this class on a single PolicyNode object (or more than one)
  with no ill effects. This stipulation applies to all public fields and
  methods of this class and any added or overridden by subclasses."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.security.cert PolicyNode]))

(defn get-parent
  "Returns the parent of this node, or null if this is the
   root node.

  returns: the parent of this node, or null if this is the
   root node - `java.security.cert.PolicyNode`"
  ([^java.security.cert.PolicyNode this]
    (-> this (.getParent))))

(defn get-children
  "Returns an iterator over the children of this node. Any attempts to
   modify the children of this node through the
   Iterator's remove method must throw an
   UnsupportedOperationException.

  returns: an iterator over the children of this node - `java.util.Iterator<? extends java.security.cert.PolicyNode>`"
  ([^java.security.cert.PolicyNode this]
    (-> this (.getChildren))))

(defn get-depth
  "Returns the depth of this node in the valid policy tree.

  returns: the depth of this node (0 for the root node, 1 for its
   children, and so on) - `int`"
  ([^java.security.cert.PolicyNode this]
    (-> this (.getDepth))))

(defn get-valid-policy
  "Returns the valid policy represented by this node.

  returns: the String OID of the valid policy
   represented by this node. For the root node, this method always returns
   the special anyPolicy OID: `2.5.29.32.0`. - `java.lang.String`"
  ([^java.security.cert.PolicyNode this]
    (-> this (.getValidPolicy))))

(defn get-policy-qualifiers
  "Returns the set of policy qualifiers associated with the
   valid policy represented by this node.

  returns: an immutable Set of
   PolicyQualifierInfos. For the root node, this
   is always an empty Set. - `java.util.Set<? extends java.security.cert.PolicyQualifierInfo>`"
  ([^java.security.cert.PolicyNode this]
    (-> this (.getPolicyQualifiers))))

(defn get-expected-policies
  "Returns the set of expected policies that would satisfy this
   node's valid policy in the next certificate to be processed.

  returns: an immutable Set of expected policy
   String OIDs. For the root node, this method
   always returns a Set with one element, the
   special anyPolicy OID: `2.5.29.32.0`. - `java.util.Set<java.lang.String>`"
  ([^java.security.cert.PolicyNode this]
    (-> this (.getExpectedPolicies))))

(defn critical?
  "Returns the criticality indicator of the certificate policy extension
   in the most recently processed certificate.

  returns: true if extension marked critical,
   false otherwise. For the root node, false
   is always returned. - `boolean`"
  ([^java.security.cert.PolicyNode this]
    (-> this (.isCritical))))

