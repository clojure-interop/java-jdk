(ns jdk.security.cert.CertificateFactory
  "This class defines the functionality of a certificate factory, which is
  used to generate certificate, certification path (CertPath)
  and certificate revocation list (CRL) objects from their encodings.

  For encodings consisting of multiple certificates, use
  generateCertificates when you want to
  parse a collection of possibly unrelated certificates. Otherwise,
  use generateCertPath when you want to generate
  a CertPath (a certificate chain) and subsequently
  validate it with a CertPathValidator.

  A certificate factory for X.509 must return certificates that are an
  instance of java.security.cert.X509Certificate, and CRLs
  that are an instance of java.security.cert.X509CRL.

  The following example reads a file with Base64 encoded certificates,
  which are each bounded at the beginning by -----BEGIN CERTIFICATE-----, and
  bounded at the end by -----END CERTIFICATE-----. We convert the
  FileInputStream (which does not support mark
  and reset) to a BufferedInputStream (which
  supports those methods), so that each call to
  generateCertificate consumes only one certificate, and the
  read position of the input stream is positioned to the next certificate in
  the file:



  FileInputStream fis = new FileInputStream(filename);
  BufferedInputStream bis = new BufferedInputStream(fis);

  CertificateFactory cf = CertificateFactory.getInstance(\"X.509\");

  while (bis.available() > 0) {
     Certificate cert = cf.generateCertificate(bis);
     System.out.println(cert.toString());
  }

  The following example parses a PKCS#7-formatted certificate reply stored
  in a file and extracts all the certificates from it:



  FileInputStream fis = new FileInputStream(filename);
  CertificateFactory cf = CertificateFactory.getInstance(\"X.509\");
  Collection c = cf.generateCertificates(fis);
  Iterator i = c.iterator();
  while (i.hasNext()) {
     Certificate cert = (Certificate)i.next();
     System.out.println(cert);
  }

   Every implementation of the Java platform is required to support the
  following standard CertificateFactory type:

  X.509

  and the following standard CertPath encodings:

  PKCS7
  PkiPath

  The type and encodings are described in the
  CertificateFactory section and the
  CertPath Encodings section of the
  Java Cryptography Architecture Standard Algorithm Name Documentation.
  Consult the release documentation for your implementation to see if any
  other types or encodings are supported."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.security.cert CertificateFactory]))

(defn *get-instance
  "Returns a certificate factory object for the specified
   certificate type.

    A new CertificateFactory object encapsulating the
   CertificateFactorySpi implementation from the specified provider
   is returned.  The specified provider must be registered
   in the security provider list.

    Note that the list of registered providers may be retrieved via
   the Security.getProviders() method.

  type - the certificate type. See the CertificateFactory section in the Java Cryptography Architecture Standard Algorithm Name Documentation for information about standard certificate types. - `java.lang.String`
  provider - the name of the provider. - `java.lang.String`

  returns: a certificate factory object for the specified type. - `java.security.cert.CertificateFactory`

  throws: java.security.cert.CertificateException - if a CertificateFactorySpi implementation for the specified algorithm is not available from the specified provider."
  (^java.security.cert.CertificateFactory [^java.lang.String type ^java.lang.String provider]
    (CertificateFactory/getInstance type provider))
  (^java.security.cert.CertificateFactory [^java.lang.String type]
    (CertificateFactory/getInstance type)))

(defn get-provider
  "Returns the provider of this certificate factory.

  returns: the provider of this certificate factory. - `java.security.Provider`"
  (^java.security.Provider [^CertificateFactory this]
    (-> this (.getProvider))))

(defn get-type
  "Returns the name of the certificate type associated with this
   certificate factory.

  returns: the name of the certificate type associated with this
   certificate factory. - `java.lang.String`"
  (^java.lang.String [^CertificateFactory this]
    (-> this (.getType))))

(defn generate-certificate
  "Generates a certificate object and initializes it with
   the data read from the input stream inStream.

   In order to take advantage of the specialized certificate format
   supported by this certificate factory,
   the returned certificate object can be typecast to the corresponding
   certificate class. For example, if this certificate
   factory implements X.509 certificates, the returned certificate object
   can be typecast to the X509Certificate class.

   In the case of a certificate factory for X.509 certificates, the
   certificate provided in inStream must be DER-encoded and
   may be supplied in binary or printable (Base64) encoding. If the
   certificate is provided in Base64 encoding, it must be bounded at
   the beginning by -----BEGIN CERTIFICATE-----, and must be bounded at
   the end by -----END CERTIFICATE-----.

   Note that if the given input stream does not support
   mark and
   reset, this method will
   consume the entire input stream. Otherwise, each call to this
   method consumes one certificate and the read position of the
   input stream is positioned to the next available byte after
   the inherent end-of-certificate marker. If the data in the input stream
   does not contain an inherent end-of-certificate marker (other
   than EOF) and there is trailing data after the certificate is parsed, a
   CertificateException is thrown.

  in-stream - an input stream with the certificate data. - `java.io.InputStream`

  returns: a certificate object initialized with the data
   from the input stream. - `java.security.cert.Certificate`

  throws: java.security.cert.CertificateException - on parsing errors."
  (^java.security.cert.Certificate [^CertificateFactory this ^java.io.InputStream in-stream]
    (-> this (.generateCertificate in-stream))))

(defn get-cert-path-encodings
  "Returns an iteration of the CertPath encodings supported
   by this certificate factory, with the default encoding first. See
   the CertPath Encodings section in the
   Java Cryptography Architecture Standard Algorithm Name Documentation
   for information about standard encoding names and their formats.

   Attempts to modify the returned Iterator via its
   remove method result in an
   UnsupportedOperationException.

  returns: an Iterator over the names of the supported
           CertPath encodings (as Strings) - `java.util.Iterator<java.lang.String>`"
  (^java.util.Iterator [^CertificateFactory this]
    (-> this (.getCertPathEncodings))))

(defn generate-cert-path
  "Generates a CertPath object and initializes it with
   the data read from the InputStream inStream. The data
   is assumed to be in the specified encoding. See
   the CertPath Encodings section in the
   Java Cryptography Architecture Standard Algorithm Name Documentation
   for information about standard encoding names and their formats.

  in-stream - an InputStream containing the data - `java.io.InputStream`
  encoding - the encoding used for the data - `java.lang.String`

  returns: a CertPath initialized with the data from the
     InputStream - `java.security.cert.CertPath`

  throws: java.security.cert.CertificateException - if an exception occurs while decoding or the encoding requested is not supported"
  (^java.security.cert.CertPath [^CertificateFactory this ^java.io.InputStream in-stream ^java.lang.String encoding]
    (-> this (.generateCertPath in-stream encoding)))
  (^java.security.cert.CertPath [^CertificateFactory this ^java.io.InputStream in-stream]
    (-> this (.generateCertPath in-stream))))

(defn generate-certificates
  "Returns a (possibly empty) collection view of the certificates read
   from the given input stream inStream.

   In order to take advantage of the specialized certificate format
   supported by this certificate factory, each element in
   the returned collection view can be typecast to the corresponding
   certificate class. For example, if this certificate
   factory implements X.509 certificates, the elements in the returned
   collection can be typecast to the X509Certificate class.

   In the case of a certificate factory for X.509 certificates,
   inStream may contain a sequence of DER-encoded certificates
   in the formats described for
   generateCertificate.
   In addition, inStream may contain a PKCS#7 certificate
   chain. This is a PKCS#7 SignedData object, with the only
   significant field being certificates. In particular, the
   signature and the contents are ignored. This format allows multiple
   certificates to be downloaded at once. If no certificates are present,
   an empty collection is returned.

   Note that if the given input stream does not support
   mark and
   reset, this method will
   consume the entire input stream.

  in-stream - the input stream with the certificates. - `java.io.InputStream`

  returns: a (possibly empty) collection view of
   java.security.cert.Certificate objects
   initialized with the data from the input stream. - `java.util.Collection<? extends java.security.cert.Certificate>`

  throws: java.security.cert.CertificateException - on parsing errors."
  ([^CertificateFactory this ^java.io.InputStream in-stream]
    (-> this (.generateCertificates in-stream))))

(defn generate-crl
  "Generates a certificate revocation list (CRL) object and initializes it
   with the data read from the input stream inStream.

   In order to take advantage of the specialized CRL format
   supported by this certificate factory,
   the returned CRL object can be typecast to the corresponding
   CRL class. For example, if this certificate
   factory implements X.509 CRLs, the returned CRL object
   can be typecast to the X509CRL class.

   Note that if the given input stream does not support
   mark and
   reset, this method will
   consume the entire input stream. Otherwise, each call to this
   method consumes one CRL and the read position of the input stream
   is positioned to the next available byte after the inherent
   end-of-CRL marker. If the data in the
   input stream does not contain an inherent end-of-CRL marker (other
   than EOF) and there is trailing data after the CRL is parsed, a
   CRLException is thrown.

  in-stream - an input stream with the CRL data. - `java.io.InputStream`

  returns: a CRL object initialized with the data
   from the input stream. - `java.security.cert.CRL`

  throws: java.security.cert.CRLException - on parsing errors."
  (^java.security.cert.CRL [^CertificateFactory this ^java.io.InputStream in-stream]
    (-> this (.generateCRL in-stream))))

(defn generate-cr-ls
  "Returns a (possibly empty) collection view of the CRLs read
   from the given input stream inStream.

   In order to take advantage of the specialized CRL format
   supported by this certificate factory, each element in
   the returned collection view can be typecast to the corresponding
   CRL class. For example, if this certificate
   factory implements X.509 CRLs, the elements in the returned
   collection can be typecast to the X509CRL class.

   In the case of a certificate factory for X.509 CRLs,
   inStream may contain a sequence of DER-encoded CRLs.
   In addition, inStream may contain a PKCS#7 CRL
   set. This is a PKCS#7 SignedData object, with the only
   significant field being crls. In particular, the
   signature and the contents are ignored. This format allows multiple
   CRLs to be downloaded at once. If no CRLs are present,
   an empty collection is returned.

   Note that if the given input stream does not support
   mark and
   reset, this method will
   consume the entire input stream.

  in-stream - the input stream with the CRLs. - `java.io.InputStream`

  returns: a (possibly empty) collection view of
   java.security.cert.CRL objects initialized with the data from the input
   stream. - `java.util.Collection<? extends java.security.cert.CRL>`

  throws: java.security.cert.CRLException - on parsing errors."
  ([^CertificateFactory this ^java.io.InputStream in-stream]
    (-> this (.generateCRLs in-stream))))

