(ns javax.security.cert.X509Certificate
  "Abstract class for X.509 v1 certificates. This provides a standard
  way to access all the version 1 attributes of an X.509 certificate.
  Attributes that are specific to X.509 v2 or v3 are not available
  through this interface. Future API evolution will provide full access to
  complete X.509 v3 attributes.

  The basic X.509 format was defined by
  ISO/IEC and ANSI X9 and is described below in ASN.1:


  Certificate  ::=  SEQUENCE  {
      tbsCertificate       TBSCertificate,
      signatureAlgorithm   AlgorithmIdentifier,
      signature            BIT STRING  }

  These certificates are widely used to support authentication and
  other functionality in Internet security systems. Common applications
  include Privacy Enhanced Mail (PEM), Transport Layer Security (SSL),
  code signing for trusted software distribution, and Secure Electronic
  Transactions (SET).

  These certificates are managed and vouched for by Certificate
  Authorities (CAs). CAs are services which create certificates by
  placing data in the X.509 standard format and then digitally signing
  that data. CAs act as trusted third parties, making introductions
  between principals who have no direct knowledge of each other.
  CA certificates are either signed by themselves, or by some other
  CA such as a \"root\" CA.

  The ASN.1 definition of tbsCertificate is:


  TBSCertificate  ::=  SEQUENCE  {
      version         [0]  EXPLICIT Version DEFAULT v1,
      serialNumber         CertificateSerialNumber,
      signature            AlgorithmIdentifier,
      issuer               Name,
      validity             Validity,
      subject              Name,
      subjectPublicKeyInfo SubjectPublicKeyInfo,
      }

  Here is sample code to instantiate an X.509 certificate:


  InputStream inStream = new FileInputStream(\"fileName-of-cert\");
  X509Certificate cert = X509Certificate.getInstance(inStream);
  inStream.close();
  OR


  byte[] certData = <certificate read from a file, say>
  X509Certificate cert = X509Certificate.getInstance(certData);

  In either case, the code that instantiates an X.509 certificate
  consults the value of the cert.provider.x509v1 security property
  to locate the actual implementation or instantiates a default implementation.

  The cert.provider.x509v1 property is set to a default
  implementation for X.509 such as:


  cert.provider.x509v1=com.sun.security.cert.internal.x509.X509V1CertImpl

  The value of this cert.provider.x509v1 property has to be
  changed to instantiate another implementation. If this security
  property is not set, a default implementation will be used.
  Currently, due to possible security restrictions on access to
  Security properties, this value is looked up and cached at class
  initialization time and will fallback on a default implementation if
  the Security property is not accessible.

  Note: The classes in the package javax.security.cert
  exist for compatibility with earlier versions of the
  Java Secure Sockets Extension (JSSE). New applications should instead
  use the standard Java SE certificate classes located in
  java.security.cert."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.security.cert X509Certificate]))

(defn ->x-509-certificate
  "Constructor."
  (^X509Certificate []
    (new X509Certificate )))

(defn *get-instance
  "Instantiates an X509Certificate object, and initializes it with
   the data read from the input stream inStream.
   The implementation (X509Certificate is an abstract class) is
   provided by the class specified as the value of the
   cert.provider.x509v1 security property.

   Note: Only one DER-encoded
   certificate is expected to be in the input stream.
   Also, all X509Certificate
   subclasses must provide a constructor of the form:


   public <subClass>(InputStream inStream) ...

  in-stream - an input stream with the data to be read to initialize the certificate. - `java.io.InputStream`

  returns: an X509Certificate object initialized with the data
           from the input stream. - `javax.security.cert.X509Certificate`

  throws: javax.security.cert.CertificateException - if a class initialization or certificate parsing error occurs."
  (^javax.security.cert.X509Certificate [^java.io.InputStream in-stream]
    (X509Certificate/getInstance in-stream)))

(defn get-serial-number
  "Gets the serialNumber value from the certificate.
   The serial number is an integer assigned by the certification
   authority to each certificate. It must be unique for each
   certificate issued by a given CA (i.e., the issuer name and
   serial number identify a unique certificate).
   The ASN.1 definition for this is:


   serialNumber     CertificateSerialNumber

   CertificateSerialNumber  ::=  INTEGER

  returns: the serial number. - `java.math.BigInteger`"
  (^java.math.BigInteger [^X509Certificate this]
    (-> this (.getSerialNumber))))

(defn get-not-before
  "Gets the notBefore date from the validity period of
   the certificate.
   The relevant ASN.1 definitions are:


   validity             Validity

   Validity ::= SEQUENCE {
       notBefore      CertificateValidityDate,
       notAfter       CertificateValidityDate }

   CertificateValidityDate ::= CHOICE {
       utcTime        UTCTime,
       generalTime    GeneralizedTime }

  returns: the start date of the validity period. - `java.util.Date`"
  (^java.util.Date [^X509Certificate this]
    (-> this (.getNotBefore))))

(defn get-not-after
  "Gets the notAfter date from the validity period of
   the certificate. See getNotBefore
   for relevant ASN.1 definitions.

  returns: the end date of the validity period. - `java.util.Date`"
  (^java.util.Date [^X509Certificate this]
    (-> this (.getNotAfter))))

(defn check-validity
  "Checks that the specified date is within the certificate's
   validity period. In other words, this determines whether the
   certificate would be valid at the specified date/time.

  date - the Date to check against to see if this certificate is valid at that date/time. - `java.util.Date`

  throws: javax.security.cert.CertificateExpiredException - if the certificate has expired with respect to the date supplied."
  ([^X509Certificate this ^java.util.Date date]
    (-> this (.checkValidity date)))
  ([^X509Certificate this]
    (-> this (.checkValidity))))

(defn get-version
  "Gets the version (version number) value from the
   certificate. The ASN.1 definition for this is:


   version         [0]  EXPLICIT Version DEFAULT v1

   Version  ::=  INTEGER  {  v1(0), v2(1), v3(2)  }

  returns: the version number from the ASN.1 encoding, i.e. 0, 1 or 2. - `int`"
  (^Integer [^X509Certificate this]
    (-> this (.getVersion))))

(defn get-subject-dn
  "Gets the subject (subject distinguished name) value
   from the certificate.
   The ASN.1 definition for this is:


   subject    Name

   See getIssuerDN for Name
   and other relevant definitions.

  returns: a Principal whose name is the subject name. - `java.security.Principal`"
  (^java.security.Principal [^X509Certificate this]
    (-> this (.getSubjectDN))))

(defn get-issuer-dn
  "Gets the issuer (issuer distinguished name) value from
   the certificate. The issuer name identifies the entity that signed (and
   issued) the certificate.

   The issuer name field contains an
   X.500 distinguished name (DN).
   The ASN.1 definition for this is:


   issuer    Name

   Name ::= CHOICE { RDNSequence }
   RDNSequence ::= SEQUENCE OF RelativeDistinguishedName
   RelativeDistinguishedName ::=
       SET OF AttributeValueAssertion

   AttributeValueAssertion ::= SEQUENCE {
                                 AttributeType,
                                 AttributeValue }
   AttributeType ::= OBJECT IDENTIFIER
   AttributeValue ::= ANY
   The Name describes a hierarchical name composed of
   attributes, such as country name, and corresponding values, such as US.
   The type of the AttributeValue component is determined by
   the AttributeType; in general it will be a
   directoryString. A directoryString is usually
   one of PrintableString,
   TeletexString or UniversalString.

  returns: a Principal whose name is the issuer distinguished name. - `java.security.Principal`"
  (^java.security.Principal [^X509Certificate this]
    (-> this (.getIssuerDN))))

(defn get-sig-alg-params
  "Gets the DER-encoded signature algorithm parameters from this
   certificate's signature algorithm. In most cases, the signature
   algorithm parameters are null; the parameters are usually
   supplied with the certificate's public key.

   See getSigAlgName for
   relevant ASN.1 definitions.

  returns: the DER-encoded signature algorithm parameters, or
           null if no parameters are present. - `byte[]`"
  ([^X509Certificate this]
    (-> this (.getSigAlgParams))))

(defn get-sig-alg-name
  "Gets the signature algorithm name for the certificate
   signature algorithm. An example is the string \"SHA-1/DSA\".
   The ASN.1 definition for this is:


   signatureAlgorithm   AlgorithmIdentifier

   AlgorithmIdentifier  ::=  SEQUENCE  {
       algorithm               OBJECT IDENTIFIER,
       parameters              ANY DEFINED BY algorithm OPTIONAL  }
                               -- contains a value of the type
                               -- registered for use with the
                               -- algorithm object identifier value

   The algorithm name is determined from the algorithm
   OID string.

  returns: the signature algorithm name. - `java.lang.String`"
  (^java.lang.String [^X509Certificate this]
    (-> this (.getSigAlgName))))

(defn get-sig-alg-oid
  "Gets the signature algorithm OID string from the certificate.
   An OID is represented by a set of positive whole numbers separated
   by periods.
   For example, the string \"1.2.840.10040.4.3\" identifies the SHA-1
   with DSA signature algorithm, as per the PKIX part I.

   See getSigAlgName for
   relevant ASN.1 definitions.

  returns: the signature algorithm OID string. - `java.lang.String`"
  (^java.lang.String [^X509Certificate this]
    (-> this (.getSigAlgOID))))

