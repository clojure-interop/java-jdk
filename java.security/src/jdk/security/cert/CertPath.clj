(ns jdk.security.cert.CertPath
  "An immutable sequence of certificates (a certification path).

  This is an abstract class that defines the methods common to all
  CertPaths. Subclasses can handle different kinds of
  certificates (X.509, PGP, etc.).

  All CertPath objects have a type, a list of
  Certificates, and one or more supported encodings. Because the
  CertPath class is immutable, a CertPath cannot
  change in any externally visible way after being constructed. This
  stipulation applies to all public fields and methods of this class and any
  added or overridden by subclasses.

  The type is a String that identifies the type of
  Certificates in the certification path. For each
  certificate cert in a certification path certPath,
  cert.getType().equals(certPath.getType()) must be
  true.

  The list of Certificates is an ordered List of
  zero or more Certificates. This List and all
  of the Certificates contained in it must be immutable.

  Each CertPath object must support one or more encodings
  so that the object can be translated into a byte array for storage or
  transmission to other parties. Preferably, these encodings should be
  well-documented standards (such as PKCS#7). One of the encodings supported
  by a CertPath is considered the default encoding. This
  encoding is used if no encoding is explicitly requested (for the
  getEncoded() method, for instance).

  All CertPath objects are also Serializable.
  CertPath objects are resolved into an alternate
  CertPathRep object during serialization. This allows
  a CertPath object to be serialized into an equivalent
  representation regardless of its underlying implementation.

  CertPath objects can be created with a
  CertificateFactory or they can be returned by other classes,
  such as a CertPathBuilder.

  By convention, X.509 CertPaths (consisting of
  X509Certificates), are ordered starting with the target
  certificate and ending with a certificate issued by the trust anchor. That
  is, the issuer of one certificate is the subject of the following one. The
  certificate representing the TrustAnchor should not be
  included in the certification path. Unvalidated X.509 CertPaths
  may not follow these conventions. PKIX CertPathValidators will
  detect any departure from these conventions that cause the certification
  path to be invalid and throw a CertPathValidatorException.

   Every implementation of the Java platform is required to support the
  following standard CertPath encodings:

  PKCS7
  PkiPath

  These encodings are described in the
  CertPath Encodings section of the
  Java Cryptography Architecture Standard Algorithm Name Documentation.
  Consult the release documentation for your implementation to see if any
  other encodings are supported.

  Concurrent Access

  All CertPath objects must be thread-safe. That is, multiple
  threads may concurrently invoke the methods defined in this class on a
  single CertPath object (or more than one) with no
  ill effects. This is also true for the List returned by
  CertPath.getCertificates.

  Requiring CertPath objects to be immutable and thread-safe
  allows them to be passed around to various pieces of code without worrying
  about coordinating access.  Providing this thread-safety is
  generally not difficult, since the CertPath and
  List objects in question are immutable."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.security.cert CertPath]))

(defn get-type
  "Returns the type of Certificates in this certification
   path. This is the same string that would be returned by
   cert.getType()
   for all Certificates in the certification path.

  returns: the type of Certificates in this certification
   path (never null) - `java.lang.String`"
  ([^java.security.cert.CertPath this]
    (-> this (.getType))))

(defn get-encodings
  "Returns an iteration of the encodings supported by this certification
   path, with the default encoding first. Attempts to modify the returned
   Iterator via its remove method result in an
   UnsupportedOperationException.

  returns: an Iterator over the names of the supported
           encodings (as Strings) - `java.util.Iterator<java.lang.String>`"
  ([^java.security.cert.CertPath this]
    (-> this (.getEncodings))))

(defn equals
  "Compares this certification path for equality with the specified
   object. Two CertPaths are equal if and only if their
   types are equal and their certificate Lists (and by
   implication the Certificates in those Lists)
   are equal. A CertPath is never equal to an object that is
   not a CertPath.

   This algorithm is implemented by this method. If it is overridden,
   the behavior specified here must be maintained.

  other - the object to test for equality with this certification path - `java.lang.Object`

  returns: true if the specified object is equal to this certification path,
   false otherwise - `boolean`"
  ([^java.security.cert.CertPath this ^java.lang.Object other]
    (-> this (.equals other))))

(defn hash-code
  "Returns the hashcode for this certification path. The hash code of
   a certification path is defined to be the result of the following
   calculation:


    hashCode = path.getType().hashCode();
    hashCode = 31*hashCode  path.getCertificates().hashCode();
   This ensures that path1.equals(path2) implies that
   path1.hashCode()==path2.hashCode() for any two certification
   paths, path1 and path2, as required by the
   general contract of Object.hashCode.

  returns: the hashcode value for this certification path - `int`"
  ([^java.security.cert.CertPath this]
    (-> this (.hashCode))))

(defn to-string
  "Returns a string representation of this certification path.
   This calls the toString method on each of the
   Certificates in the path.

  returns: a string representation of this certification path - `java.lang.String`"
  ([^java.security.cert.CertPath this]
    (-> this (.toString))))

(defn get-encoded
  "Returns the encoded form of this certification path, using the
   specified encoding.

  encoding - the name of the encoding to use - `java.lang.String`

  returns: the encoded bytes - `byte[]`

  throws: java.security.cert.CertificateEncodingException - if an encoding error occurs or the encoding requested is not supported"
  ([^java.security.cert.CertPath this ^java.lang.String encoding]
    (-> this (.getEncoded encoding)))
  ([^java.security.cert.CertPath this]
    (-> this (.getEncoded))))

(defn get-certificates
  "Returns the list of certificates in this certification path.
   The List returned must be immutable and thread-safe.

  returns: an immutable List of Certificates
           (may be empty, but not null) - `java.util.List<? extends java.security.cert.Certificate>`"
  ([^java.security.cert.CertPath this]
    (-> this (.getCertificates))))

