(ns jdk.security.cert.CertPathChecker
  "Performs one or more checks on each Certificate of a
  CertPath.

  A CertPathChecker implementation is typically created to extend
  a certification path validation algorithm. For example, an implementation
  may check for and process a critical private extension of each certificate
  in a certification path."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.security.cert CertPathChecker]))

(defn init
  "Initializes the internal state of this CertPathChecker.

   The forward flag specifies the order that certificates will
   be passed to the check method (forward or reverse).

  forward - the order that certificates are presented to the check method. If true, certificates are presented from target to trust anchor (forward); if false, from trust anchor to target (reverse). - `boolean`

  throws: java.security.cert.CertPathValidatorException - if this CertPathChecker is unable to check certificates in the specified order"
  ([^java.security.cert.CertPathChecker this ^Boolean forward]
    (-> this (.init forward))))

(defn forward-checking-supported?
  "Indicates if forward checking is supported. Forward checking refers
   to the ability of the CertPathChecker to perform its checks
   when certificates are presented to the check method in the
   forward direction (from target to trust anchor).

  returns: true if forward checking is supported, false
           otherwise - `boolean`"
  (^Boolean [^java.security.cert.CertPathChecker this]
    (-> this (.isForwardCheckingSupported))))

(defn check
  "Performs the check(s) on the specified certificate using its internal
   state. The certificates are presented in the order specified by the
   init method.

  cert - the Certificate to be checked - `java.security.cert.Certificate`

  throws: java.security.cert.CertPathValidatorException - if the specified certificate does not pass the check"
  ([^java.security.cert.CertPathChecker this ^java.security.cert.Certificate cert]
    (-> this (.check cert))))

