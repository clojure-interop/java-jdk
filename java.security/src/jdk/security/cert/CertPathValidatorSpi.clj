(ns jdk.security.cert.CertPathValidatorSpi
  "The Service Provider Interface (SPI)
  for the CertPathValidator class. All
  CertPathValidator implementations must include a class (the
  SPI class) that extends this class (CertPathValidatorSpi)
  and implements all of its methods. In general, instances of this class
  should only be accessed through the CertPathValidator class.
  For details, see the Java Cryptography Architecture.

  Concurrent Access

  Instances of this class need not be protected against concurrent
  access from multiple threads. Threads that need to access a single
  CertPathValidatorSpi instance concurrently should synchronize
  amongst themselves and provide the necessary locking before calling the
  wrapping CertPathValidator object.

  However, implementations of CertPathValidatorSpi may still
  encounter concurrency issues, since multiple threads each
  manipulating a different CertPathValidatorSpi instance need not
  synchronize."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.security.cert CertPathValidatorSpi]))

(defn ->cert-path-validator-spi
  "Constructor.

  The default constructor."
  ([]
    (new CertPathValidatorSpi )))

(defn engine-validate
  "Validates the specified certification path using the specified
   algorithm parameter set.

   The CertPath specified must be of a type that is
   supported by the validation algorithm, otherwise an
   InvalidAlgorithmParameterException will be thrown. For
   example, a CertPathValidator that implements the PKIX
   algorithm validates CertPath objects of type X.509.

  cert-path - the CertPath to be validated - `java.security.cert.CertPath`
  params - the algorithm parameters - `java.security.cert.CertPathParameters`

  returns: the result of the validation algorithm - `java.security.cert.CertPathValidatorResult`

  throws: java.security.cert.CertPathValidatorException - if the CertPath does not validate"
  ([this cert-path params]
    (-> this (.engineValidate cert-path params))))

(defn engine-get-revocation-checker
  "Returns a CertPathChecker that this implementation uses to
   check the revocation status of certificates. A PKIX implementation
   returns objects of type PKIXRevocationChecker.

   The primary purpose of this method is to allow callers to specify
   additional input parameters and options specific to revocation checking.
   See the class description of CertPathValidator for an example.

   This method was added to version 1.8 of the Java Platform Standard
   Edition. In order to maintain backwards compatibility with existing
   service providers, this method cannot be abstract and by default throws
   an UnsupportedOperationException.

  returns: a CertPathChecker that this implementation uses to
   check the revocation status of certificates - `java.security.cert.CertPathChecker`

  throws: java.lang.UnsupportedOperationException - if this method is not supported"
  ([this]
    (-> this (.engineGetRevocationChecker))))

