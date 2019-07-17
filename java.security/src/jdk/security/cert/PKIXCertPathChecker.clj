(ns jdk.security.cert.PKIXCertPathChecker
  "An abstract class that performs one or more checks on an
  X509Certificate.

  A concrete implementation of the PKIXCertPathChecker class
  can be created to extend the PKIX certification path validation algorithm.
  For example, an implementation may check for and process a critical private
  extension of each certificate in a certification path.

  Instances of PKIXCertPathChecker are passed as parameters
  using the setCertPathCheckers
  or addCertPathChecker methods
  of the PKIXParameters and PKIXBuilderParameters
  class. Each of the PKIXCertPathCheckers check
  methods will be called, in turn, for each certificate processed by a PKIX
  CertPathValidator or CertPathBuilder
  implementation.

  A PKIXCertPathChecker may be called multiple times on
  successive certificates in a certification path. Concrete subclasses
  are expected to maintain any internal state that may be necessary to
  check successive certificates. The init method is used
  to initialize the internal state of the checker so that the certificates
  of a new certification path may be checked. A stateful implementation
  must override the clone method if necessary in
  order to allow a PKIX CertPathBuilder to efficiently
  backtrack and try other paths. In these situations, the
  CertPathBuilder is able to restore prior path validation
  states by restoring the cloned PKIXCertPathCheckers.

  The order in which the certificates are presented to the
  PKIXCertPathChecker may be either in the forward direction
  (from target to most-trusted CA) or in the reverse direction (from
  most-trusted CA to target). A PKIXCertPathChecker implementation
  must support reverse checking (the ability to perform its checks when
  it is presented with certificates in the reverse direction) and may
  support forward checking (the ability to perform its checks when it is
  presented with certificates in the forward direction). The
  isForwardCheckingSupported method
  indicates whether forward checking is supported.

  Additional input parameters required for executing the check may be
  specified through constructors of concrete implementations of this class.

  Concurrent Access

  Unless otherwise specified, the methods defined in this class are not
  thread-safe. Multiple threads that need to access a single
  object concurrently should synchronize amongst themselves and
  provide the necessary locking. Multiple threads each manipulating
  separate objects need not synchronize."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.security.cert PKIXCertPathChecker]))

(defn init
  "Initializes the internal state of this PKIXCertPathChecker.

   The forward flag specifies the order that
   certificates will be passed to the check method
   (forward or reverse). A PKIXCertPathChecker must
   support reverse checking and may support forward checking.

  forward - the order that certificates are presented to the check method. If true, certificates are presented from target to most-trusted CA (forward); if false, from most-trusted CA to target (reverse). - `boolean`

  throws: java.security.cert.CertPathValidatorException - if this PKIXCertPathChecker is unable to check certificates in the specified order; it should never be thrown if the forward flag is false since reverse checking must be supported"
  ([this forward]
    (-> this (.init forward))))

(defn forward-checking-supported?
  "Indicates if forward checking is supported. Forward checking refers
   to the ability of the PKIXCertPathChecker to perform
   its checks when certificates are presented to the check
   method in the forward direction (from target to most-trusted CA).

  returns: true if forward checking is supported,
   false otherwise - `boolean`"
  ([this]
    (-> this (.isForwardCheckingSupported))))

(defn get-supported-extensions
  "Returns an immutable Set of X.509 certificate extensions
   that this PKIXCertPathChecker supports (i.e. recognizes, is
   able to process), or null if no extensions are supported.

   Each element of the set is a String representing the
   Object Identifier (OID) of the X.509 extension that is supported.
   The OID is represented by a set of nonnegative integers separated by
   periods.

   All X.509 certificate extensions that a PKIXCertPathChecker
   might possibly be able to process should be included in the set.

  returns: an immutable Set of X.509 extension OIDs (in
   String format) supported by this
   PKIXCertPathChecker, or null if no
   extensions are supported - `java.util.Set<java.lang.String>`"
  ([this]
    (-> this (.getSupportedExtensions))))

(defn check
  "Performs the check(s) on the specified certificate using its internal
   state and removes any critical extensions that it processes from the
   specified collection of OID strings that represent the unresolved
   critical extensions. The certificates are presented in the order
   specified by the init method.

  cert - the Certificate to be checked - `java.security.cert.Certificate`
  unresolved-crit-exts - a Collection of OID strings representing the current set of unresolved critical extensions - `java.util.Collection<java.lang.String>`

  throws: java.security.cert.CertPathValidatorException - if the specified certificate does not pass the check"
  ([this cert unresolved-crit-exts]
    (-> this (.check cert unresolved-crit-exts)))
  ([this cert]
    (-> this (.check cert))))

(defn clone
  "Returns a clone of this object. Calls the Object.clone()
   method.
   All subclasses which maintain state must support and
   override this method, if necessary.

  returns: a copy of this PKIXCertPathChecker - `java.lang.Object`"
  ([this]
    (-> this (.clone))))

