(ns jdk.security.cert.CertPathBuilder
  "A class for building certification paths (also known as certificate chains).

  This class uses a provider-based architecture.
  To create a CertPathBuilder, call
  one of the static getInstance methods, passing in the
  algorithm name of the CertPathBuilder desired and optionally
  the name of the provider desired.

  Once a CertPathBuilder object has been created, certification
  paths can be constructed by calling the build method and
  passing it an algorithm-specific set of parameters. If successful, the
  result (including the CertPath that was built) is returned
  in an object that implements the CertPathBuilderResult
  interface.

  The getRevocationChecker() method allows an application to specify
  additional algorithm-specific parameters and options used by the
  CertPathBuilder when checking the revocation status of certificates.
  Here is an example demonstrating how it is used with the PKIX algorithm:



  CertPathBuilder cpb = CertPathBuilder.getInstance(`PKIX`);
  PKIXRevocationChecker rc = (PKIXRevocationChecker)cpb.getRevocationChecker();
  rc.setOptions(EnumSet.of(Option.PREFER_CRLS));
  params.addCertPathChecker(rc);
  CertPathBuilderResult cpbr = cpb.build(params);

  Every implementation of the Java platform is required to support the
  following standard CertPathBuilder algorithm:

  PKIX

  This algorithm is described in the
  CertPathBuilder section of the
  Java Cryptography Architecture Standard Algorithm Name Documentation.
  Consult the release documentation for your implementation to see if any
  other algorithms are supported.


  Concurrent Access

  The static methods of this class are guaranteed to be thread-safe.
  Multiple threads may concurrently invoke the static methods defined in
  this class with no ill effects.

  However, this is not true for the non-static methods defined by this class.
  Unless otherwise documented by a specific provider, threads that need to
  access a single CertPathBuilder instance concurrently should
  synchronize amongst themselves and provide the necessary locking. Multiple
  threads each manipulating a different CertPathBuilder instance
  need not synchronize."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.security.cert CertPathBuilder]))

(defn *get-instance
  "Returns a CertPathBuilder object that implements the
   specified algorithm.

    A new CertPathBuilder object encapsulating the
   CertPathBuilderSpi implementation from the specified provider
   is returned.  The specified provider must be registered
   in the security provider list.

    Note that the list of registered providers may be retrieved via
   the Security.getProviders() method.

  algorithm - the name of the requested CertPathBuilder algorithm. See the CertPathBuilder section in the Java Cryptography Architecture Standard Algorithm Name Documentation for information about standard algorithm names. - `java.lang.String`
  provider - the name of the provider. - `java.lang.String`

  returns: a CertPathBuilder object that implements the
            specified algorithm. - `java.security.cert.CertPathBuilder`

  throws: java.security.NoSuchAlgorithmException - if a CertPathBuilderSpi implementation for the specified algorithm is not available from the specified provider."
  ([algorithm provider]
    (CertPathBuilder/getInstance algorithm provider))
  ([algorithm]
    (CertPathBuilder/getInstance algorithm)))

(defn *get-default-type
  "Returns the default CertPathBuilder type as specified by
   the certpathbuilder.type security property, or the string
   `PKIX` if no such property exists.

   The default CertPathBuilder type can be used by
   applications that do not want to use a hard-coded type when calling one
   of the getInstance methods, and want to provide a default
   type in case a user does not specify its own.

   The default CertPathBuilder type can be changed by
   setting the value of the certpathbuilder.type security property
   to the desired type.

  returns: the default CertPathBuilder type as specified
   by the certpathbuilder.type security property, or the string
   `PKIX` if no such property exists. - `java.lang.String`"
  ([]
    (CertPathBuilder/getDefaultType )))

(defn get-provider
  "Returns the provider of this CertPathBuilder.

  returns: the provider of this CertPathBuilder - `java.security.Provider`"
  ([this]
    (-> this (.getProvider))))

(defn get-algorithm
  "Returns the name of the algorithm of this CertPathBuilder.

  returns: the name of the algorithm of this CertPathBuilder - `java.lang.String`"
  ([this]
    (-> this (.getAlgorithm))))

(defn build
  "Attempts to build a certification path using the specified algorithm
   parameter set.

  params - the algorithm parameters - `java.security.cert.CertPathParameters`

  returns: the result of the build algorithm - `java.security.cert.CertPathBuilderResult`

  throws: java.security.cert.CertPathBuilderException - if the builder is unable to construct a certification path that satisfies the specified parameters"
  ([this params]
    (-> this (.build params))))

(defn get-revocation-checker
  "Returns a CertPathChecker that the encapsulated
   CertPathBuilderSpi implementation uses to check the revocation
   status of certificates. A PKIX implementation returns objects of
   type PKIXRevocationChecker. Each invocation of this method
   returns a new instance of CertPathChecker.

   The primary purpose of this method is to allow callers to specify
   additional input parameters and options specific to revocation checking.
   See the class description for an example.

  returns: a CertPathChecker - `java.security.cert.CertPathChecker`

  throws: java.lang.UnsupportedOperationException - if the service provider does not support this method"
  ([this]
    (-> this (.getRevocationChecker))))

