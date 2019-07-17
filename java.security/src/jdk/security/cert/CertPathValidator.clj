(ns jdk.security.cert.CertPathValidator
  "A class for validating certification paths (also known as certificate
  chains).

  This class uses a provider-based architecture.
  To create a CertPathValidator,
  call one of the static getInstance methods, passing in the
  algorithm name of the CertPathValidator desired and
  optionally the name of the provider desired.

  Once a CertPathValidator object has been created, it can
  be used to validate certification paths by calling the validate method and passing it the CertPath to be validated
  and an algorithm-specific set of parameters. If successful, the result is
  returned in an object that implements the
  CertPathValidatorResult interface.

  The getRevocationChecker() method allows an application to specify
  additional algorithm-specific parameters and options used by the
  CertPathValidator when checking the revocation status of
  certificates. Here is an example demonstrating how it is used with the PKIX
  algorithm:



  CertPathValidator cpv = CertPathValidator.getInstance(`PKIX`);
  PKIXRevocationChecker rc = (PKIXRevocationChecker)cpv.getRevocationChecker();
  rc.setOptions(EnumSet.of(Option.SOFT_FAIL));
  params.addCertPathChecker(rc);
  CertPathValidatorResult cpvr = cpv.validate(path, params);

  Every implementation of the Java platform is required to support the
  following standard CertPathValidator algorithm:

  PKIX

  This algorithm is described in the
  CertPathValidator section of the
  Java Cryptography Architecture Standard Algorithm Name Documentation.
  Consult the release documentation for your implementation to see if any
  other algorithms are supported.


  Concurrent Access

  The static methods of this class are guaranteed to be thread-safe.
  Multiple threads may concurrently invoke the static methods defined in
  this class with no ill effects.

  However, this is not true for the non-static methods defined by this class.
  Unless otherwise documented by a specific provider, threads that need to
  access a single CertPathValidator instance concurrently should
  synchronize amongst themselves and provide the necessary locking. Multiple
  threads each manipulating a different CertPathValidator
  instance need not synchronize."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.security.cert CertPathValidator]))

(defn *get-instance
  "Returns a CertPathValidator object that implements the
   specified algorithm.

    A new CertPathValidator object encapsulating the
   CertPathValidatorSpi implementation from the specified provider
   is returned.  The specified provider must be registered
   in the security provider list.

    Note that the list of registered providers may be retrieved via
   the Security.getProviders() method.

  algorithm - the name of the requested CertPathValidator algorithm. See the CertPathValidator section in the Java Cryptography Architecture Standard Algorithm Name Documentation for information about standard algorithm names. - `java.lang.String`
  provider - the name of the provider. - `java.lang.String`

  returns: a CertPathValidator object that implements the
            specified algorithm. - `java.security.cert.CertPathValidator`

  throws: java.security.NoSuchAlgorithmException - if a CertPathValidatorSpi implementation for the specified algorithm is not available from the specified provider."
  (^java.security.cert.CertPathValidator [^java.lang.String algorithm ^java.lang.String provider]
    (CertPathValidator/getInstance algorithm provider))
  (^java.security.cert.CertPathValidator [^java.lang.String algorithm]
    (CertPathValidator/getInstance algorithm)))

(defn *get-default-type
  "Returns the default CertPathValidator type as specified by
   the certpathvalidator.type security property, or the string
   `PKIX` if no such property exists.

   The default CertPathValidator type can be used by
   applications that do not want to use a hard-coded type when calling one
   of the getInstance methods, and want to provide a default
   type in case a user does not specify its own.

   The default CertPathValidator type can be changed by
   setting the value of the certpathvalidator.type security
   property to the desired type.

  returns: the default CertPathValidator type as specified
   by the certpathvalidator.type security property, or the string
   `PKIX` if no such property exists. - `java.lang.String`"
  (^java.lang.String []
    (CertPathValidator/getDefaultType )))

(defn get-provider
  "Returns the Provider of this
   CertPathValidator.

  returns: the Provider of this CertPathValidator - `java.security.Provider`"
  (^java.security.Provider [^java.security.cert.CertPathValidator this]
    (-> this (.getProvider))))

(defn get-algorithm
  "Returns the algorithm name of this CertPathValidator.

  returns: the algorithm name of this CertPathValidator - `java.lang.String`"
  (^java.lang.String [^java.security.cert.CertPathValidator this]
    (-> this (.getAlgorithm))))

(defn validate
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
  (^java.security.cert.CertPathValidatorResult [^java.security.cert.CertPathValidator this ^java.security.cert.CertPath cert-path ^java.security.cert.CertPathParameters params]
    (-> this (.validate cert-path params))))

(defn get-revocation-checker
  "Returns a CertPathChecker that the encapsulated
   CertPathValidatorSpi implementation uses to check the revocation
   status of certificates. A PKIX implementation returns objects of
   type PKIXRevocationChecker. Each invocation of this method
   returns a new instance of CertPathChecker.

   The primary purpose of this method is to allow callers to specify
   additional input parameters and options specific to revocation checking.
   See the class description for an example.

  returns: a CertPathChecker - `java.security.cert.CertPathChecker`

  throws: java.lang.UnsupportedOperationException - if the service provider does not support this method"
  (^java.security.cert.CertPathChecker [^java.security.cert.CertPathValidator this]
    (-> this (.getRevocationChecker))))

