(ns jdk.security.cert.CertPathBuilderSpi
  "The Service Provider Interface (SPI)
  for the CertPathBuilder class. All
  CertPathBuilder implementations must include a class (the
  SPI class) that extends this class (CertPathBuilderSpi) and
  implements all of its methods. In general, instances of this class should
  only be accessed through the CertPathBuilder class. For
  details, see the Java Cryptography Architecture.

  Concurrent Access

  Instances of this class need not be protected against concurrent
  access from multiple threads. Threads that need to access a single
  CertPathBuilderSpi instance concurrently should synchronize
  amongst themselves and provide the necessary locking before calling the
  wrapping CertPathBuilder object.

  However, implementations of CertPathBuilderSpi may still
  encounter concurrency issues, since multiple threads each
  manipulating a different CertPathBuilderSpi instance need not
  synchronize."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.security.cert CertPathBuilderSpi]))

(defn ->cert-path-builder-spi
  "Constructor.

  The default constructor."
  ([]
    (new CertPathBuilderSpi )))

(defn engine-build
  "Attempts to build a certification path using the specified
   algorithm parameter set.

  params - the algorithm parameters - `java.security.cert.CertPathParameters`

  returns: the result of the build algorithm - `java.security.cert.CertPathBuilderResult`

  throws: java.security.cert.CertPathBuilderException - if the builder is unable to construct a certification path that satisfies the specified parameters"
  ([^java.security.cert.CertPathBuilderSpi this ^java.security.cert.CertPathParameters params]
    (-> this (.engineBuild params))))

(defn engine-get-revocation-checker
  "Returns a CertPathChecker that this implementation uses to
   check the revocation status of certificates. A PKIX implementation
   returns objects of type PKIXRevocationChecker.

   The primary purpose of this method is to allow callers to specify
   additional input parameters and options specific to revocation checking.
   See the class description of CertPathBuilder for an example.

   This method was added to version 1.8 of the Java Platform Standard
   Edition. In order to maintain backwards compatibility with existing
   service providers, this method cannot be abstract and by default throws
   an UnsupportedOperationException.

  returns: a CertPathChecker that this implementation uses to
   check the revocation status of certificates - `java.security.cert.CertPathChecker`

  throws: java.lang.UnsupportedOperationException - if this method is not supported"
  ([^java.security.cert.CertPathBuilderSpi this]
    (-> this (.engineGetRevocationChecker))))

