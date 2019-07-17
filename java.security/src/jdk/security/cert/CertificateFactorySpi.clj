(ns jdk.security.cert.CertificateFactorySpi
  "This class defines the Service Provider Interface (SPI)
  for the CertificateFactory class.
  All the abstract methods in this class must be implemented by each
  cryptographic service provider who wishes to supply the implementation
  of a certificate factory for a particular certificate type, e.g., X.509.

  Certificate factories are used to generate certificate, certification path
  (CertPath) and certificate revocation list (CRL) objects from
  their encodings.

  A certificate factory for X.509 must return certificates that are an
  instance of java.security.cert.X509Certificate, and CRLs
  that are an instance of java.security.cert.X509CRL."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.security.cert CertificateFactorySpi]))

(defn ->certificate-factory-spi
  "Constructor."
  ([]
    (new CertificateFactorySpi )))

(defn engine-generate-certificate
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
   method consumes one certificate and the read position of the input stream
   is positioned to the next available byte after the inherent
   end-of-certificate marker. If the data in the
   input stream does not contain an inherent end-of-certificate marker (other
   than EOF) and there is trailing data after the certificate is parsed, a
   CertificateException is thrown.

  in-stream - an input stream with the certificate data. - `java.io.InputStream`

  returns: a certificate object initialized with the data
   from the input stream. - `java.security.cert.Certificate`

  throws: java.security.cert.CertificateException - on parsing errors."
  ([this in-stream]
    (-> this (.engineGenerateCertificate in-stream))))

(defn engine-generate-cert-path
  "Generates a CertPath object and initializes it with
   the data read from the InputStream inStream. The data
   is assumed to be in the specified encoding.

    This method was added to version 1.4 of the Java 2 Platform
   Standard Edition. In order to maintain backwards compatibility with
   existing service providers, this method cannot be abstract
   and by default throws an UnsupportedOperationException.

  in-stream - an InputStream containing the data - `java.io.InputStream`
  encoding - the encoding used for the data - `java.lang.String`

  returns: a CertPath initialized with the data from the
     InputStream - `java.security.cert.CertPath`

  throws: java.security.cert.CertificateException - if an exception occurs while decoding or the encoding requested is not supported"
  ([this in-stream encoding]
    (-> this (.engineGenerateCertPath in-stream encoding)))
  ([this in-stream]
    (-> this (.engineGenerateCertPath in-stream))))

(defn engine-get-cert-path-encodings
  "Returns an iteration of the CertPath encodings supported
   by this certificate factory, with the default encoding first. See
   the CertPath Encodings section in the
   Java Cryptography Architecture Standard Algorithm Name Documentation
   for information about standard encoding names.

   Attempts to modify the returned Iterator via its
   remove method result in an
   UnsupportedOperationException.

    This method was added to version 1.4 of the Java 2 Platform
   Standard Edition. In order to maintain backwards compatibility with
   existing service providers, this method cannot be abstract
   and by default throws an UnsupportedOperationException.

  returns: an Iterator over the names of the supported
           CertPath encodings (as Strings) - `java.util.Iterator<java.lang.String>`

  throws: java.lang.UnsupportedOperationException - if the method is not supported"
  ([this]
    (-> this (.engineGetCertPathEncodings))))

(defn engine-generate-certificates
  "Returns a (possibly empty) collection view of the certificates read
   from the given input stream inStream.

   In order to take advantage of the specialized certificate format
   supported by this certificate factory, each element in
   the returned collection view can be typecast to the corresponding
   certificate class. For example, if this certificate
   factory implements X.509 certificates, the elements in the returned
   collection can be typecast to the X509Certificate class.

   In the case of a certificate factory for X.509 certificates,
   inStream may contain a single DER-encoded certificate
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
  ([this in-stream]
    (-> this (.engineGenerateCertificates in-stream))))

(defn engine-generate-crl
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
  ([this in-stream]
    (-> this (.engineGenerateCRL in-stream))))

(defn engine-generate-cr-ls
  "Returns a (possibly empty) collection view of the CRLs read
   from the given input stream inStream.

   In order to take advantage of the specialized CRL format
   supported by this certificate factory, each element in
   the returned collection view can be typecast to the corresponding
   CRL class. For example, if this certificate
   factory implements X.509 CRLs, the elements in the returned
   collection can be typecast to the X509CRL class.

   In the case of a certificate factory for X.509 CRLs,
   inStream may contain a single DER-encoded CRL.
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
  ([this in-stream]
    (-> this (.engineGenerateCRLs in-stream))))

