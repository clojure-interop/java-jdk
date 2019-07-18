(ns jdk.security.cert.X509CRLEntry
  "Abstract class for a revoked certificate in a CRL (Certificate
  Revocation List).

  The ASN.1 definition for revokedCertificates is:


  revokedCertificates    SEQUENCE OF SEQUENCE  {
      userCertificate    CertificateSerialNumber,
      revocationDate     ChoiceOfTime,
      crlEntryExtensions Extensions OPTIONAL
                         -- if present, must be v2
  }  OPTIONAL

  CertificateSerialNumber  ::=  INTEGER

  Extensions  ::=  SEQUENCE SIZE (1..MAX) OF Extension

  Extension  ::=  SEQUENCE  {
      extnId        OBJECT IDENTIFIER,
      critical      BOOLEAN DEFAULT FALSE,
      extnValue     OCTET STRING
                    -- contains a DER encoding of a value
                    -- of the type registered for use with
                    -- the extnId object identifier value
  }"
  (:refer-clojure :only [require comment defn ->])
  (:import [java.security.cert X509CRLEntry]))

(defn ->x-509-crl-entry
  "Constructor."
  (^X509CRLEntry []
    (new X509CRLEntry )))

(defn get-serial-number
  "Gets the serial number from this X509CRLEntry,
   the userCertificate.

  returns: the serial number. - `java.math.BigInteger`"
  (^java.math.BigInteger [^X509CRLEntry this]
    (-> this (.getSerialNumber))))

(defn get-revocation-date
  "Gets the revocation date from this X509CRLEntry,
   the revocationDate.

  returns: the revocation date. - `java.util.Date`"
  (^java.util.Date [^X509CRLEntry this]
    (-> this (.getRevocationDate))))

(defn get-certificate-issuer
  "Get the issuer of the X509Certificate described by this entry. If
   the certificate issuer is also the CRL issuer, this method returns
   null.

   This method is used with indirect CRLs. The default implementation
   always returns null. Subclasses that wish to support indirect CRLs
   should override it.

  returns: the issuer of the X509Certificate described by this entry
   or null if it is issued by the CRL issuer. - `javax.security.auth.x500.X500Principal`"
  (^javax.security.auth.x500.X500Principal [^X509CRLEntry this]
    (-> this (.getCertificateIssuer))))

(defn to-string
  "Returns a string representation of this CRL entry.

  returns: a string representation of this CRL entry. - `java.lang.String`"
  (^java.lang.String [^X509CRLEntry this]
    (-> this (.toString))))

(defn has-extensions?
  "Returns true if this CRL entry has extensions.

  returns: true if this entry has extensions, false otherwise. - `boolean`"
  (^Boolean [^X509CRLEntry this]
    (-> this (.hasExtensions))))

(defn get-revocation-reason
  "Returns the reason the certificate has been revoked, as specified
   in the Reason Code extension of this CRL entry.

  returns: the reason the certificate has been revoked, or
      null if this CRL entry does not have
      a Reason Code extension - `java.security.cert.CRLReason`"
  (^java.security.cert.CRLReason [^X509CRLEntry this]
    (-> this (.getRevocationReason))))

(defn get-encoded
  "Returns the ASN.1 DER-encoded form of this CRL Entry,
   that is the inner SEQUENCE.

  returns: the encoded form of this certificate - `byte[]`

  throws: java.security.cert.CRLException - if an encoding error occurs."
  ([^X509CRLEntry this]
    (-> this (.getEncoded))))

(defn hash-code
  "Returns a hashcode value for this CRL entry from its
   encoded form.

  returns: the hashcode value. - `int`"
  (^Integer [^X509CRLEntry this]
    (-> this (.hashCode))))

(defn equals
  "Compares this CRL entry for equality with the given
   object. If the other object is an
   instanceof X509CRLEntry, then
   its encoded form (the inner SEQUENCE) is retrieved and compared
   with the encoded form of this CRL entry.

  other - the object to test for equality with this CRL entry. - `java.lang.Object`

  returns: true iff the encoded forms of the two CRL entries
   match, false otherwise. - `boolean`"
  (^Boolean [^X509CRLEntry this ^java.lang.Object other]
    (-> this (.equals other))))

