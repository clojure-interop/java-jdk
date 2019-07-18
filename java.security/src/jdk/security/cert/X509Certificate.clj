(ns jdk.security.cert.X509Certificate
  " Abstract class for X.509 certificates. This provides a standard
  way to access all the attributes of an X.509 certificate.

  In June of 1996, the basic X.509 v3 format was completed by
  ISO/IEC and ANSI X9, which is described below in ASN.1:


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
  CA such as a `root` CA.

  More information can be found in
  RFC 3280: Internet X.509
  Public Key Infrastructure Certificate and CRL Profile.

  The ASN.1 definition of tbsCertificate is:


  TBSCertificate  ::=  SEQUENCE  {
      version         [0]  EXPLICIT Version DEFAULT v1,
      serialNumber         CertificateSerialNumber,
      signature            AlgorithmIdentifier,
      issuer               Name,
      validity             Validity,
      subject              Name,
      subjectPublicKeyInfo SubjectPublicKeyInfo,
      issuerUniqueID  [1]  IMPLICIT UniqueIdentifier OPTIONAL,
                           -- If present, version must be v2 or v3
      subjectUniqueID [2]  IMPLICIT UniqueIdentifier OPTIONAL,
                           -- If present, version must be v2 or v3
      extensions      [3]  EXPLICIT Extensions OPTIONAL
                           -- If present, version must be v3
      }

  Certificates are instantiated using a certificate factory. The following is
  an example of how to instantiate an X.509 certificate:


  try (InputStream inStream = new FileInputStream(`fileName-of-cert`)) {
      CertificateFactory cf = CertificateFactory.getInstance(`X.509`);
      X509Certificate cert = (X509Certificate)cf.generateCertificate(inStream);
  }"
  (:refer-clojure :only [require comment defn ->])
  (:import [java.security.cert X509Certificate]))

(defn get-signature
  "Gets the signature value (the raw signature bits) from
   the certificate.
   The ASN.1 definition for this is:


   signature     BIT STRING

  returns: the signature. - `byte[]`"
  ([^X509Certificate this]
    (-> this (.getSignature))))

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

(defn get-subject-alternative-names
  "Gets an immutable collection of subject alternative names from the
   SubjectAltName extension, (OID = 2.5.29.17).

   The ASN.1 definition of the SubjectAltName extension is:


   SubjectAltName ::= GeneralNames

   GeneralNames :: = SEQUENCE SIZE (1..MAX) OF GeneralName

   GeneralName ::= CHOICE {
        otherName                       [0]     OtherName,
        rfc822Name                      [1]     IA5String,
        dNSName                         [2]     IA5String,
        x400Address                     [3]     ORAddress,
        directoryName                   [4]     Name,
        ediPartyName                    [5]     EDIPartyName,
        uniformResourceIdentifier       [6]     IA5String,
        iPAddress                       [7]     OCTET STRING,
        registeredID                    [8]     OBJECT IDENTIFIER}

   If this certificate does not contain a SubjectAltName
   extension, null is returned. Otherwise, a
   Collection is returned with an entry representing each
   GeneralName included in the extension. Each entry is a
   List whose first entry is an Integer
   (the name type, 0-8) and whose second entry is a String
   or a byte array (the name, in string or ASN.1 DER encoded form,
   respectively).

   RFC 822, DNS, and URI
   names are returned as Strings,
   using the well-established string formats for those types (subject to
   the restrictions included in RFC 3280). IPv4 address names are
   returned using dotted quad notation. IPv6 address names are returned
   in the form `a1:a2:...:a8`, where a1-a8 are hexadecimal values
   representing the eight 16-bit pieces of the address. OID names are
   returned as Strings represented as a series of nonnegative
   integers separated by periods. And directory names (distinguished names)
   are returned in
   RFC 2253 string format. No standard string format is
   defined for otherNames, X.400 names, EDI party names, or any
   other type of names. They are returned as byte arrays
   containing the ASN.1 DER encoded form of the name.

   Note that the Collection returned may contain more
   than one name of the same type. Also, note that the returned
   Collection is immutable and any entries containing byte
   arrays are cloned to protect against subsequent modifications.

   This method was added to version 1.4 of the Java 2 Platform Standard
   Edition. In order to maintain backwards compatibility with existing
   service providers, this method is not abstract
   and it provides a default implementation. Subclasses
   should override this method with a correct implementation.

  returns: an immutable Collection of subject alternative
   names (or null) - `java.util.Collection<java.util.List<?>>`

  throws: java.security.cert.CertificateParsingException - if the extension cannot be decoded"
  (^java.util.Collection [^X509Certificate this]
    (-> this (.getSubjectAlternativeNames))))

(defn get-issuer-unique-id
  "Gets the issuerUniqueID value from the certificate.
   The issuer unique identifier is present in the certificate
   to handle the possibility of reuse of issuer names over time.
   RFC 3280 recommends that names not be reused and that
   conforming certificates not make use of unique identifiers.
   Applications conforming to that profile should be capable of
   parsing unique identifiers and making comparisons.

   The ASN.1 definition for this is:


   issuerUniqueID  [1]  IMPLICIT UniqueIdentifier OPTIONAL

   UniqueIdentifier  ::=  BIT STRING

  returns: the issuer unique identifier or null if it is not
   present in the certificate. - `boolean[]`"
  ([^X509Certificate this]
    (-> this (.getIssuerUniqueID))))

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

(defn get-key-usage
  "Gets a boolean array representing bits of
   the KeyUsage extension, (OID = 2.5.29.15).
   The key usage extension defines the purpose (e.g., encipherment,
   signature, certificate signing) of the key contained in the
   certificate.
   The ASN.1 definition for this is:


   KeyUsage ::= BIT STRING {
       digitalSignature        (0),
       nonRepudiation          (1),
       keyEncipherment         (2),
       dataEncipherment        (3),
       keyAgreement            (4),
       keyCertSign             (5),
       cRLSign                 (6),
       encipherOnly            (7),
       decipherOnly            (8) }
   RFC 3280 recommends that when used, this be marked
   as a critical extension.

  returns: the KeyUsage extension of this certificate, represented as
   an array of booleans. The order of KeyUsage values in the array is
   the same as in the above ASN.1 definition. The array will contain a
   value for each KeyUsage defined above. If the KeyUsage list encoded
   in the certificate is longer than the above list, it will not be
   truncated. Returns null if this certificate does not
   contain a KeyUsage extension. - `boolean[]`"
  ([^X509Certificate this]
    (-> this (.getKeyUsage))))

(defn get-basic-constraints
  "Gets the certificate constraints path length from the
   critical BasicConstraints extension, (OID = 2.5.29.19).

   The basic constraints extension identifies whether the subject
   of the certificate is a Certificate Authority (CA) and
   how deep a certification path may exist through that CA. The
   pathLenConstraint field (see below) is meaningful
   only if cA is set to TRUE. In this case, it gives the
   maximum number of CA certificates that may follow this certificate in a
   certification path. A value of zero indicates that only an end-entity
   certificate may follow in the path.

   The ASN.1 definition for this is:


   BasicConstraints ::= SEQUENCE {
       cA                  BOOLEAN DEFAULT FALSE,
       pathLenConstraint   INTEGER (0..MAX) OPTIONAL }

  returns: the value of pathLenConstraint if the
   BasicConstraints extension is present in the certificate and the
   subject of the certificate is a CA, otherwise -1.
   If the subject of the certificate is a CA and
   pathLenConstraint does not appear,
   Integer.MAX_VALUE is returned to indicate that there is no
   limit to the allowed length of the certification path. - `int`"
  (^Integer [^X509Certificate this]
    (-> this (.getBasicConstraints))))

(defn get-subject-unique-id
  "Gets the subjectUniqueID value from the certificate.

   The ASN.1 definition for this is:


   subjectUniqueID  [2]  IMPLICIT UniqueIdentifier OPTIONAL

   UniqueIdentifier  ::=  BIT STRING

  returns: the subject unique identifier or null if it is not
   present in the certificate. - `boolean[]`"
  ([^X509Certificate this]
    (-> this (.getSubjectUniqueID))))

(defn get-issuer-alternative-names
  "Gets an immutable collection of issuer alternative names from the
   IssuerAltName extension, (OID = 2.5.29.18).

   The ASN.1 definition of the IssuerAltName extension is:


   IssuerAltName ::= GeneralNames
   The ASN.1 definition of GeneralNames is defined
   in getSubjectAlternativeNames.

   If this certificate does not contain an IssuerAltName
   extension, null is returned. Otherwise, a
   Collection is returned with an entry representing each
   GeneralName included in the extension. Each entry is a
   List whose first entry is an Integer
   (the name type, 0-8) and whose second entry is a String
   or a byte array (the name, in string or ASN.1 DER encoded form,
   respectively). For more details about the formats used for each
   name type, see the getSubjectAlternativeNames method.

   Note that the Collection returned may contain more
   than one name of the same type. Also, note that the returned
   Collection is immutable and any entries containing byte
   arrays are cloned to protect against subsequent modifications.

   This method was added to version 1.4 of the Java 2 Platform Standard
   Edition. In order to maintain backwards compatibility with existing
   service providers, this method is not abstract
   and it provides a default implementation. Subclasses
   should override this method with a correct implementation.

  returns: an immutable Collection of issuer alternative
   names (or null) - `java.util.Collection<java.util.List<?>>`

  throws: java.security.cert.CertificateParsingException - if the extension cannot be decoded"
  (^java.util.Collection [^X509Certificate this]
    (-> this (.getIssuerAlternativeNames))))

(defn check-validity
  "Checks that the given date is within the certificate's
   validity period. In other words, this determines whether the
   certificate would be valid at the given date/time.

  date - the Date to check against to see if this certificate is valid at that date/time. - `java.util.Date`

  throws: java.security.cert.CertificateExpiredException - if the certificate has expired with respect to the date supplied."
  ([^X509Certificate this ^java.util.Date date]
    (-> this (.checkValidity date)))
  ([^X509Certificate this]
    (-> this (.checkValidity))))

(defn get-issuer-x-500-principal
  "Returns the issuer (issuer distinguished name) value from the
   certificate as an X500Principal.

   It is recommended that subclasses override this method.

  returns: an X500Principal representing the issuer
            distinguished name - `javax.security.auth.x500.X500Principal`"
  (^javax.security.auth.x500.X500Principal [^X509Certificate this]
    (-> this (.getIssuerX500Principal))))

(defn verify
  "Verifies that this certificate was signed using the
   private key that corresponds to the specified public key.
   This method uses the signature verification engine
   supplied by the specified provider. Note that the specified
   Provider object does not have to be registered in the provider list.

   This method was added to version 1.8 of the Java Platform Standard
   Edition. In order to maintain backwards compatibility with existing
   service providers, this method is not abstract
   and it provides a default implementation.

  key - the PublicKey used to carry out the verification. - `java.security.PublicKey`
  sig-provider - the signature provider. - `java.security.Provider`

  throws: java.security.NoSuchAlgorithmException - on unsupported signature algorithms."
  ([^X509Certificate this ^java.security.PublicKey key ^java.security.Provider sig-provider]
    (-> this (.verify key sig-provider))))

(defn get-version
  "Gets the version (version number) value from the
   certificate.
   The ASN.1 definition for this is:


   version  [0] EXPLICIT Version DEFAULT v1

   Version ::=  INTEGER  {  v1(0), v2(1), v3(2)  }

  returns: the version number, i.e. 1, 2 or 3. - `int`"
  (^Integer [^X509Certificate this]
    (-> this (.getVersion))))

(defn get-subject-dn
  "Denigrated, replaced by getSubjectX500Principal(). This method returns the subject
   as an implementation specific Principal object, which should not be
   relied upon by portable code.


   Gets the subject (subject distinguished name) value
   from the certificate.  If the subject value is empty,
   then the getName() method of the returned
   Principal object returns an empty string (``).

    The ASN.1 definition for this is:


   subject    Name

   See getIssuerDN for Name
   and other relevant definitions.

  returns: a Principal whose name is the subject name. - `java.security.Principal`"
  (^java.security.Principal [^X509Certificate this]
    (-> this (.getSubjectDN))))

(defn get-issuer-dn
  "Denigrated, replaced by getIssuerX500Principal(). This method returns the issuer
   as an implementation specific Principal object, which should not be
   relied upon by portable code.


   Gets the issuer (issuer distinguished name) value from
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
   attributes,
   such as country name, and corresponding values, such as US.
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
   If access to individual parameter values is needed then use
   AlgorithmParameters
   and instantiate with the name returned by
   getSigAlgName.

   See getSigAlgName for
   relevant ASN.1 definitions.

  returns: the DER-encoded signature algorithm parameters, or
           null if no parameters are present. - `byte[]`"
  ([^X509Certificate this]
    (-> this (.getSigAlgParams))))

(defn get-extended-key-usage
  "Gets an unmodifiable list of Strings representing the OBJECT
   IDENTIFIERs of the ExtKeyUsageSyntax field of the
   extended key usage extension, (OID = 2.5.29.37).  It indicates
   one or more purposes for which the certified public key may be
   used, in addition to or in place of the basic purposes
   indicated in the key usage extension field.  The ASN.1
   definition for this is:


   ExtKeyUsageSyntax ::= SEQUENCE SIZE (1..MAX) OF KeyPurposeId

   KeyPurposeId ::= OBJECT IDENTIFIER

   Key purposes may be defined by any organization with a
   need. Object identifiers used to identify key purposes shall be
   assigned in accordance with IANA or ITU-T Rec. X.660 |
   ISO/IEC/ITU 9834-1.

   This method was added to version 1.4 of the Java 2 Platform Standard
   Edition. In order to maintain backwards compatibility with existing
   service providers, this method is not abstract
   and it provides a default implementation. Subclasses
   should override this method with a correct implementation.

  returns: the ExtendedKeyUsage extension of this certificate,
           as an unmodifiable list of object identifiers represented
           as Strings. Returns null if this certificate does not
           contain an ExtendedKeyUsage extension. - `java.util.List<java.lang.String>`

  throws: java.security.cert.CertificateParsingException - if the extension cannot be decoded"
  (^java.util.List [^X509Certificate this]
    (-> this (.getExtendedKeyUsage))))

(defn get-sig-alg-name
  "Gets the signature algorithm name for the certificate
   signature algorithm. An example is the string `SHA256withRSA`.
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

(defn get-subject-x-500-principal
  "Returns the subject (subject distinguished name) value from the
   certificate as an X500Principal.  If the subject value
   is empty, then the getName() method of the returned
   X500Principal object returns an empty string (``).

   It is recommended that subclasses override this method.

  returns: an X500Principal representing the subject
            distinguished name - `javax.security.auth.x500.X500Principal`"
  (^javax.security.auth.x500.X500Principal [^X509Certificate this]
    (-> this (.getSubjectX500Principal))))

(defn get-sig-alg-oid
  "Gets the signature algorithm OID string from the certificate.
   An OID is represented by a set of nonnegative whole numbers separated
   by periods.
   For example, the string `1.2.840.10040.4.3` identifies the SHA-1
   with DSA signature algorithm defined in
   RFC 3279: Algorithms and
   Identifiers for the Internet X.509 Public Key Infrastructure Certificate
   and CRL Profile.

   See getSigAlgName for
   relevant ASN.1 definitions.

  returns: the signature algorithm OID string. - `java.lang.String`"
  (^java.lang.String [^X509Certificate this]
    (-> this (.getSigAlgOID))))

(defn get-tbs-certificate
  "Gets the DER-encoded certificate information, the
   tbsCertificate from this certificate.
   This can be used to verify the signature independently.

  returns: the DER-encoded certificate information. - `byte[]`

  throws: java.security.cert.CertificateEncodingException - if an encoding error occurs."
  ([^X509Certificate this]
    (-> this (.getTBSCertificate))))

