(ns jdk.security.cert.X509CRL
  " Abstract class for an X.509 Certificate Revocation List (CRL).
  A CRL is a time-stamped list identifying revoked certificates.
  It is signed by a Certificate Authority (CA) and made freely
  available in a public repository.

  Each revoked certificate is
  identified in a CRL by its certificate serial number. When a
  certificate-using system uses a certificate (e.g., for verifying a
  remote user's digital signature), that system not only checks the
  certificate signature and validity but also acquires a suitably-
  recent CRL and checks that the certificate serial number is not on
  that CRL.  The meaning of `suitably-recent` may vary with local
  policy, but it usually means the most recently-issued CRL.  A CA
  issues a new CRL on a regular periodic basis (e.g., hourly, daily, or
  weekly).  Entries are added to CRLs as revocations occur, and an
  entry may be removed when the certificate expiration date is reached.

  The X.509 v2 CRL format is described below in ASN.1:


  CertificateList  ::=  SEQUENCE  {
      tbsCertList          TBSCertList,
      signatureAlgorithm   AlgorithmIdentifier,
      signature            BIT STRING  }

  More information can be found in
  RFC 3280: Internet X.509
  Public Key Infrastructure Certificate and CRL Profile.

  The ASN.1 definition of tbsCertList is:


  TBSCertList  ::=  SEQUENCE  {
      version                 Version OPTIONAL,
                              -- if present, must be v2
      signature               AlgorithmIdentifier,
      issuer                  Name,
      thisUpdate              ChoiceOfTime,
      nextUpdate              ChoiceOfTime OPTIONAL,
      revokedCertificates     SEQUENCE OF SEQUENCE  {
          userCertificate         CertificateSerialNumber,
          revocationDate          ChoiceOfTime,
          crlEntryExtensions      Extensions OPTIONAL
                                  -- if present, must be v2
          }  OPTIONAL,
      crlExtensions           [0]  EXPLICIT Extensions OPTIONAL
                                   -- if present, must be v2
      }

  CRLs are instantiated using a certificate factory. The following is an
  example of how to instantiate an X.509 CRL:


  try (InputStream inStream = new FileInputStream(`fileName-of-crl`)) {
      CertificateFactory cf = CertificateFactory.getInstance(`X.509`);
      X509CRL crl = (X509CRL)cf.generateCRL(inStream);
  }"
  (:refer-clojure :only [require comment defn ->])
  (:import [java.security.cert X509CRL]))

(defn get-signature
  "Gets the signature value (the raw signature bits) from
   the CRL.
   The ASN.1 definition for this is:


   signature     BIT STRING

  returns: the signature. - `byte[]`"
  ([^java.security.cert.X509CRL this]
    (-> this (.getSignature))))

(defn get-revoked-certificate
  "Gets the CRL entry, if any, with the given certificate serialNumber.

  serial-number - the serial number of the certificate for which a CRL entry is to be looked up - `java.math.BigInteger`

  returns: the entry with the given serial number, or null if no such entry
   exists in this CRL. - `java.security.cert.X509CRLEntry`"
  (^java.security.cert.X509CRLEntry [^java.security.cert.X509CRL this ^java.math.BigInteger serial-number]
    (-> this (.getRevokedCertificate serial-number))))

(defn get-tbs-cert-list
  "Gets the DER-encoded CRL information, the
   tbsCertList from this CRL.
   This can be used to verify the signature independently.

  returns: the DER-encoded CRL information. - `byte[]`

  throws: java.security.cert.CRLException - if an encoding error occurs."
  ([^java.security.cert.X509CRL this]
    (-> this (.getTBSCertList))))

(defn get-next-update
  "Gets the nextUpdate date from the CRL.

  returns: the nextUpdate date from the CRL, or null if
   not present. - `java.util.Date`"
  (^java.util.Date [^java.security.cert.X509CRL this]
    (-> this (.getNextUpdate))))

(defn get-issuer-x-500-principal
  "Returns the issuer (issuer distinguished name) value from the
   CRL as an X500Principal.

   It is recommended that subclasses override this method.

  returns: an X500Principal representing the issuer
            distinguished name - `javax.security.auth.x500.X500Principal`"
  (^javax.security.auth.x500.X500Principal [^java.security.cert.X509CRL this]
    (-> this (.getIssuerX500Principal))))

(defn verify
  "Verifies that this CRL was signed using the
   private key that corresponds to the given public key.
   This method uses the signature verification engine
   supplied by the given provider.

  key - the PublicKey used to carry out the verification. - `java.security.PublicKey`
  sig-provider - the name of the signature provider. - `java.lang.String`

  throws: java.security.NoSuchAlgorithmException - on unsupported signature algorithms."
  ([^java.security.cert.X509CRL this ^java.security.PublicKey key ^java.lang.String sig-provider]
    (-> this (.verify key sig-provider)))
  ([^java.security.cert.X509CRL this ^java.security.PublicKey key]
    (-> this (.verify key))))

(defn get-version
  "Gets the version (version number) value from the CRL.
   The ASN.1 definition for this is:


   version    Version OPTIONAL,
               -- if present, must be v2

   Version  ::=  INTEGER  {  v1(0), v2(1), v3(2)  }
               -- v3 does not apply to CRLs but appears for consistency
               -- with definition of Version for certs

  returns: the version number, i.e. 1 or 2. - `int`"
  (^Integer [^java.security.cert.X509CRL this]
    (-> this (.getVersion))))

(defn get-issuer-dn
  "Denigrated, replaced by getIssuerX500Principal(). This method returns the issuer
   as an implementation specific Principal object, which should not be
   relied upon by portable code.


   Gets the issuer (issuer distinguished name) value from
   the CRL. The issuer name identifies the entity that signed (and
   issued) the CRL.

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
  (^java.security.Principal [^java.security.cert.X509CRL this]
    (-> this (.getIssuerDN))))

(defn get-revoked-certificates
  "Gets all the entries from this CRL.
   This returns a Set of X509CRLEntry objects.

  returns: all the entries or null if there are none present. - `java.util.Set<? extends java.security.cert.X509CRLEntry>`"
  ([^java.security.cert.X509CRL this]
    (-> this (.getRevokedCertificates))))

(defn get-encoded
  "Returns the ASN.1 DER-encoded form of this CRL.

  returns: the encoded form of this certificate - `byte[]`

  throws: java.security.cert.CRLException - if an encoding error occurs."
  ([^java.security.cert.X509CRL this]
    (-> this (.getEncoded))))

(defn get-sig-alg-params
  "Gets the DER-encoded signature algorithm parameters from this
   CRL's signature algorithm. In most cases, the signature
   algorithm parameters are null; the parameters are usually
   supplied with the public key.
   If access to individual parameter values is needed then use
   AlgorithmParameters
   and instantiate with the name returned by
   getSigAlgName.

   See getSigAlgName for
   relevant ASN.1 definitions.

  returns: the DER-encoded signature algorithm parameters, or
           null if no parameters are present. - `byte[]`"
  ([^java.security.cert.X509CRL this]
    (-> this (.getSigAlgParams))))

(defn hash-code
  "Returns a hashcode value for this CRL from its
   encoded form.

  returns: the hashcode value. - `int`"
  (^Integer [^java.security.cert.X509CRL this]
    (-> this (.hashCode))))

(defn get-sig-alg-name
  "Gets the signature algorithm name for the CRL
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
  (^java.lang.String [^java.security.cert.X509CRL this]
    (-> this (.getSigAlgName))))

(defn get-this-update
  "Gets the thisUpdate date from the CRL.
   The ASN.1 definition for this is:


   thisUpdate   ChoiceOfTime
   ChoiceOfTime ::= CHOICE {
       utcTime        UTCTime,
       generalTime    GeneralizedTime }

  returns: the thisUpdate date from the CRL. - `java.util.Date`"
  (^java.util.Date [^java.security.cert.X509CRL this]
    (-> this (.getThisUpdate))))

(defn equals
  "Compares this CRL for equality with the given
   object. If the other object is an
   instanceof X509CRL, then
   its encoded form is retrieved and compared with the
   encoded form of this CRL.

  other - the object to test for equality with this CRL. - `java.lang.Object`

  returns: true iff the encoded forms of the two CRLs
   match, false otherwise. - `boolean`"
  (^Boolean [^java.security.cert.X509CRL this ^java.lang.Object other]
    (-> this (.equals other))))

(defn get-sig-alg-oid
  "Gets the signature algorithm OID string from the CRL.
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
  (^java.lang.String [^java.security.cert.X509CRL this]
    (-> this (.getSigAlgOID))))

