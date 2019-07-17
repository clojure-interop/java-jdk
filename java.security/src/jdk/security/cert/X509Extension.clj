(ns jdk.security.cert.X509Extension
  "Interface for an X.509 extension.

  The extensions defined for X.509 v3
  Certificates and v2
  CRLs (Certificate Revocation
  Lists) provide methods
  for associating additional attributes with users or public keys,
  for managing the certification hierarchy, and for managing CRL
  distribution. The X.509 extensions format also allows communities
  to define private extensions to carry information unique to those
  communities.

  Each extension in a certificate/CRL may be designated as
  critical or non-critical.  A certificate/CRL-using system (an application
  validating a certificate/CRL) must reject the certificate/CRL if it
  encounters a critical extension it does not recognize.  A non-critical
  extension may be ignored if it is not recognized.

  The ASN.1 definition for this is:


  Extensions  ::=  SEQUENCE SIZE (1..MAX) OF Extension

  Extension  ::=  SEQUENCE  {
      extnId        OBJECT IDENTIFIER,
      critical      BOOLEAN DEFAULT FALSE,
      extnValue     OCTET STRING
                    -- contains a DER encoding of a value
                    -- of the type registered for use with
                    -- the extnId object identifier value
  }
  Since not all extensions are known, the getExtensionValue
  method returns the DER-encoded OCTET STRING of the
  extension value (i.e., the extnValue). This can then
  be handled by a Class that understands the extension."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.security.cert X509Extension]))

(defn has-unsupported-critical-extension?
  "Check if there is a critical extension that is not supported.

  returns: true if a critical extension is found that is
   not supported, otherwise false. - `boolean`"
  ([this]
    (-> this (.hasUnsupportedCriticalExtension))))

(defn get-critical-extension-oi-ds
  "Gets a Set of the OID strings for the extension(s) marked
   CRITICAL in the certificate/CRL managed by the object
   implementing this interface.

   Here is sample code to get a Set of critical extensions from an
   X509Certificate and print the OIDs:


   X509Certificate cert = null;
   try (InputStream inStrm = new FileInputStream(`DER-encoded-Cert`)) {
       CertificateFactory cf = CertificateFactory.getInstance(`X.509`);
       cert = (X509Certificate)cf.generateCertificate(inStrm);
   }

   Set<String> critSet = cert.getCriticalExtensionOIDs();
   if (critSet != null && !critSet.isEmpty()) {
       System.out.println(`Set of critical extensions:`);
       for (String oid : critSet) {
           System.out.println(oid);
       }
   }

  returns: a Set (or an empty Set if none are marked critical) of
   the extension OID strings for extensions that are marked critical.
   If there are no extensions present at all, then this method returns
   null. - `java.util.Set<java.lang.String>`"
  ([this]
    (-> this (.getCriticalExtensionOIDs))))

(defn get-non-critical-extension-oi-ds
  "Gets a Set of the OID strings for the extension(s) marked
   NON-CRITICAL in the certificate/CRL managed by the object
   implementing this interface.

   Here is sample code to get a Set of non-critical extensions from an
   X509CRL revoked certificate entry and print the OIDs:


   CertificateFactory cf = null;
   X509CRL crl = null;
   try (InputStream inStrm = new FileInputStream(`DER-encoded-CRL`)) {
       cf = CertificateFactory.getInstance(`X.509`);
       crl = (X509CRL)cf.generateCRL(inStrm);
   }

   byte[] certData = <DER-encoded certificate data>
   ByteArrayInputStream bais = new ByteArrayInputStream(certData);
   X509Certificate cert = (X509Certificate)cf.generateCertificate(bais);
   X509CRLEntry badCert =
                crl.getRevokedCertificate(cert.getSerialNumber());

   if (badCert != null) {
       Set<String> nonCritSet = badCert.getNonCriticalExtensionOIDs();
       if (nonCritSet != null)
           for (String oid : nonCritSet) {
               System.out.println(oid);
           }
   }

  returns: a Set (or an empty Set if none are marked non-critical) of
   the extension OID strings for extensions that are marked non-critical.
   If there are no extensions present at all, then this method returns
   null. - `java.util.Set<java.lang.String>`"
  ([this]
    (-> this (.getNonCriticalExtensionOIDs))))

(defn get-extension-value
  "Gets the DER-encoded OCTET string for the extension value
   (extnValue) identified by the passed-in oid
   String.
   The oid string is
   represented by a set of nonnegative whole numbers separated
   by periods.

   For example:


   OID (Object Identifier)
   Extension Name
   2.5.29.14
   SubjectKeyIdentifier
   2.5.29.15
   KeyUsage
   2.5.29.16
   PrivateKeyUsage
   2.5.29.17
   SubjectAlternativeName
   2.5.29.18
   IssuerAlternativeName
   2.5.29.19
   BasicConstraints
   2.5.29.30
   NameConstraints
   2.5.29.33
   PolicyMappings
   2.5.29.35
   AuthorityKeyIdentifier
   2.5.29.36
   PolicyConstraints

  oid - the Object Identifier value for the extension. - `java.lang.String`

  returns: the DER-encoded octet string of the extension value or
   null if it is not present. - `byte[]`"
  ([this oid]
    (-> this (.getExtensionValue oid))))

