(ns jdk.security.cert.X509CertSelector
  "A CertSelector that selects X509Certificates that
  match all specified criteria. This class is particularly useful when
  selecting certificates from a CertStore to build a
  PKIX-compliant certification path.

  When first constructed, an X509CertSelector has no criteria
  enabled and each of the get methods return a default value
  (null, or -1 for the getBasicConstraints method). Therefore, the match
  method would return true for any X509Certificate.
  Typically, several criteria are enabled (by calling
  setIssuer or
  setKeyUsage, for instance) and then the
  X509CertSelector is passed to
  CertStore.getCertificates or some similar
  method.

  Several criteria can be enabled (by calling setIssuer
  and setSerialNumber,
  for example) such that the match method
  usually uniquely matches a single X509Certificate. We say
  usually, since it is possible for two issuing CAs to have the same
  distinguished name and each issue a certificate with the same serial
  number. Other unique combinations include the issuer, subject,
  subjectKeyIdentifier and/or the subjectPublicKey criteria.

  Please refer to RFC 3280:
  Internet X.509 Public Key Infrastructure Certificate and CRL Profile for
  definitions of the X.509 certificate extensions mentioned below.

  Concurrent Access

  Unless otherwise specified, the methods defined in this class are not
  thread-safe. Multiple threads that need to access a single
  object concurrently should synchronize amongst themselves and
  provide the necessary locking. Multiple threads each manipulating
  separate objects need not synchronize."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.security.cert X509CertSelector]))

(defn ->x-509-cert-selector
  "Constructor.

  Creates an X509CertSelector. Initially, no criteria are set
   so any X509Certificate will match."
  ([]
    (new X509CertSelector )))

(defn set-key-usage
  "Sets the keyUsage criterion. The X509Certificate
   must allow the specified keyUsage values. If null, no
   keyUsage check will be done. Note that an X509Certificate
   that has no keyUsage extension implicitly allows all keyUsage values.

   Note that the boolean array supplied here is cloned to protect against
   subsequent modifications.

  key-usage - a boolean array in the same format as the boolean array returned by X509Certificate.getKeyUsage(). Or null. - `boolean[]`"
  ([this key-usage]
    (-> this (.setKeyUsage key-usage))))

(defn set-subject-key-identifier
  "Sets the subjectKeyIdentifier criterion. The
   X509Certificate must contain a SubjectKeyIdentifier
   extension for which the contents of the extension
   matches the specified criterion value.
   If the criterion value is null, no
   subjectKeyIdentifier check will be done.

   If subjectKeyID is not null, it
   should contain a single DER encoded value corresponding to the contents
   of the extension value (not including the object identifier,
   criticality setting, and encapsulating OCTET STRING)
   for a SubjectKeyIdentifier extension.
   The ASN.1 notation for this structure follows.



   SubjectKeyIdentifier ::= KeyIdentifier

   KeyIdentifier ::= OCTET STRING

   Since the format of subject key identifiers is not mandated by
   any standard, subject key identifiers are not parsed by the
   X509CertSelector. Instead, the values are compared using
   a byte-by-byte comparison.

   Note that the byte array supplied here is cloned to protect against
   subsequent modifications.

  subject-key-id - the subject key identifier (or null) - `byte[]`"
  ([this subject-key-id]
    (-> this (.setSubjectKeyIdentifier subject-key-id))))

(defn get-serial-number
  "Returns the serialNumber criterion. The specified serial number
   must match the certificate serial number in the
   X509Certificate. If null, any certificate
   serial number will do.

  returns: the certificate serial number to match
                  (or null) - `java.math.BigInteger`"
  ([this]
    (-> this (.getSerialNumber))))

(defn get-subject-alternative-names
  "Returns a copy of the subjectAlternativeNames criterion.
   The X509Certificate must contain all or at least one
   of the specified subjectAlternativeNames, depending on the value
   of the matchAllNames flag (see getMatchAllSubjectAltNames). If the value returned is
   null, no subjectAlternativeNames check will be performed.

   If the value returned is not null, it is a
   Collection with
   one entry for each name to be included in the subject alternative name
   criterion. Each entry is a List whose first entry is an
   Integer (the name type, 0-8) and whose second
   entry is a String or a byte array (the name, in
   string or ASN.1 DER encoded form, respectively).
   There can be multiple names of the same type.  Note that the
   Collection returned may contain duplicate names (same name
   and name type).

   Each subject alternative name in the Collection
   may be specified either as a String or as an ASN.1 encoded
   byte array. For more details about the formats used, see
   addSubjectAlternativeName(int type, String name) and
   addSubjectAlternativeName(int type, byte [] name).

   Note that a deep copy is performed on the Collection to
   protect against subsequent modifications.

  returns: a Collection of names (or null) - `java.util.Collection<java.util.List<?>>`"
  ([this]
    (-> this (.getSubjectAlternativeNames))))

(defn get-issuer
  "Returns the issuer criterion as an X500Principal. This
   distinguished name must match the issuer distinguished name in the
   X509Certificate. If null, the issuer criterion
   is disabled and any issuer distinguished name will do.

  returns: the required issuer distinguished name as X500Principal
           (or null) - `javax.security.auth.x500.X500Principal`"
  ([this]
    (-> this (.getIssuer))))

(defn get-subject
  "Returns the subject criterion as an X500Principal. This
   distinguished name must match the subject distinguished name in the
   X509Certificate. If null, the subject criterion
   is disabled and any subject distinguished name will do.

  returns: the required subject distinguished name as X500Principal
           (or null) - `javax.security.auth.x500.X500Principal`"
  ([this]
    (-> this (.getSubject))))

(defn set-private-key-valid
  "Sets the privateKeyValid criterion. The specified date must fall
   within the private key validity period for the
   X509Certificate. If null, no privateKeyValid
   check will be done.

   Note that the Date supplied here is cloned to protect
   against subsequent modifications.

  private-key-valid - the Date to check (or null) - `java.util.Date`"
  ([this private-key-valid]
    (-> this (.setPrivateKeyValid private-key-valid))))

(defn get-issuer-as-string
  "Denigrated, use getIssuer() or
   getIssuerAsBytes() instead. This method should not be
   relied on as it can fail to match some certificates because of a loss of
   encoding information in the RFC 2253 String form of some distinguished
   names.

   Returns the issuer criterion as a String. This
   distinguished name must match the issuer distinguished name in the
   X509Certificate. If null, the issuer criterion
   is disabled and any issuer distinguished name will do.

   If the value returned is not null, it is a
   distinguished name, in RFC 2253 format.

  returns: the required issuer distinguished name in RFC 2253 format
           (or null) - `java.lang.String`"
  ([this]
    (-> this (.getIssuerAsString))))

(defn get-match-all-subject-alt-names?
  "Indicates if the X509Certificate must contain all
   or at least one of the subjectAlternativeNames
   specified in the setSubjectAlternativeNames or addSubjectAlternativeName methods. If true,
   the X509Certificate must contain all of the
   specified subject alternative names. If false, the
   X509Certificate must contain at least one of the
   specified subject alternative names.

  returns: true if the flag is enabled;
   false if the flag is disabled. The flag is
   true by default. - `boolean`"
  ([this]
    (-> this (.getMatchAllSubjectAltNames))))

(defn set-policy
  "Sets the policy constraint. The X509Certificate must
   include at least one of the specified policies in its certificate
   policies extension. If certPolicySet is empty, then the
   X509Certificate must include at least some specified policy
   in its certificate policies extension. If certPolicySet is
   null, no policy check will be performed.

   Note that the Set is cloned to protect against
   subsequent modifications.

  cert-policy-set - a Set of certificate policy OIDs in string format (or null). Each OID is represented by a set of nonnegative integers separated by periods. - `java.util.Set<java.lang.String>`

  throws: java.io.IOException - if a parsing error occurs on the OID such as the first component is not 0, 1 or 2 or the second component is greater than 39."
  ([this cert-policy-set]
    (-> this (.setPolicy cert-policy-set))))

(defn get-issuer-as-bytes
  "Returns the issuer criterion as a byte array. This distinguished name
   must match the issuer distinguished name in the
   X509Certificate. If null, the issuer criterion
   is disabled and any issuer distinguished name will do.

   If the value returned is not null, it is a byte
   array containing a single DER encoded distinguished name, as defined in
   X.501. The ASN.1 notation for this structure is supplied in the
   documentation for
   setIssuer(byte [] issuerDN).

   Note that the byte array returned is cloned to protect against
   subsequent modifications.

  returns: a byte array containing the required issuer distinguished name
           in ASN.1 DER format (or null) - `byte[]`

  throws: java.io.IOException - if an encoding error occurs"
  ([this]
    (-> this (.getIssuerAsBytes))))

(defn set-name-constraints
  "Sets the name constraints criterion. The X509Certificate
   must have subject and subject alternative names that
   meet the specified name constraints.

   The name constraints are specified as a byte array. This byte array
   should contain the DER encoded form of the name constraints, as they
   would appear in the NameConstraints structure defined in RFC 3280
   and X.509. The ASN.1 definition of this structure appears below.



    NameConstraints ::= SEQUENCE {
         permittedSubtrees       [0]     GeneralSubtrees OPTIONAL,
         excludedSubtrees        [1]     GeneralSubtrees OPTIONAL }

    GeneralSubtrees ::= SEQUENCE SIZE (1..MAX) OF GeneralSubtree

    GeneralSubtree ::= SEQUENCE {
         base                    GeneralName,
         minimum         [0]     BaseDistance DEFAULT 0,
         maximum         [1]     BaseDistance OPTIONAL }

    BaseDistance ::= INTEGER (0..MAX)

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

   Note that the byte array supplied here is cloned to protect against
   subsequent modifications.

  bytes - a byte array containing the ASN.1 DER encoding of a NameConstraints extension to be used for checking name constraints. Only the value of the extension is included, not the OID or criticality flag. Can be null, in which case no name constraints check will be performed. - `byte[]`

  throws: java.io.IOException - if a parsing error occurs"
  ([this bytes]
    (-> this (.setNameConstraints bytes))))

(defn get-certificate-valid
  "Returns the certificateValid criterion. The specified date must fall
   within the certificate validity period for the
   X509Certificate. If null, no certificateValid
   check will be done.

   Note that the Date returned is cloned to protect against
   subsequent modifications.

  returns: the Date to check (or null) - `java.util.Date`"
  ([this]
    (-> this (.getCertificateValid))))

(defn set-certificate-valid
  "Sets the certificateValid criterion. The specified date must fall
   within the certificate validity period for the
   X509Certificate. If null, no certificateValid
   check will be done.

   Note that the Date supplied here is cloned to protect
   against subsequent modifications.

  cert-valid - the Date to check (or null) - `java.util.Date`"
  ([this cert-valid]
    (-> this (.setCertificateValid cert-valid))))

(defn get-key-usage
  "Returns the keyUsage criterion. The X509Certificate
   must allow the specified keyUsage values. If null, no keyUsage
   check will be done.

   Note that the boolean array returned is cloned to protect against
   subsequent modifications.

  returns: a boolean array in the same format as the boolean
                   array returned by
   X509Certificate.getKeyUsage().
                   Or null. - `boolean[]`"
  ([this]
    (-> this (.getKeyUsage))))

(defn set-extended-key-usage
  "Sets the extendedKeyUsage criterion. The X509Certificate
   must allow the specified key purposes in its extended key usage
   extension. If keyPurposeSet is empty or null,
   no extendedKeyUsage check will be done. Note that an
   X509Certificate that has no extendedKeyUsage extension
   implicitly allows all key purposes.

   Note that the Set is cloned to protect against
   subsequent modifications.

  key-purpose-set - a Set of key purpose OIDs in string format (or null). Each OID is represented by a set of nonnegative integers separated by periods. - `java.util.Set<java.lang.String>`

  throws: java.io.IOException - if the OID is invalid, such as the first component being not 0, 1 or 2 or the second component being greater than 39."
  ([this key-purpose-set]
    (-> this (.setExtendedKeyUsage key-purpose-set))))

(defn get-basic-constraints
  "Returns the basic constraints constraint. If the value is greater than
   or equal to zero, the X509Certificates must include a
   basicConstraints extension with a pathLen of at least this value.
   If the value is -2, only end-entity certificates are accepted. If
   the value is -1, no basicConstraints check is done.

  returns: the value for the basic constraints constraint - `int`"
  ([this]
    (-> this (.getBasicConstraints))))

(defn to-string
  "Return a printable representation of the CertSelector.

  returns: a String describing the contents of the
           CertSelector - `java.lang.String`"
  ([this]
    (-> this (.toString))))

(defn set-serial-number
  "Sets the serialNumber criterion. The specified serial number
   must match the certificate serial number in the
   X509Certificate. If null, any certificate
   serial number will do.

  serial - the certificate serial number to match (or null) - `java.math.BigInteger`"
  ([this serial]
    (-> this (.setSerialNumber serial))))

(defn set-path-to-names
  "Sets the pathToNames criterion. The X509Certificate must
   not include name constraints that would prohibit building a
   path to the specified names.

   This method allows the caller to specify, with a single method call,
   the complete set of names which the X509Certificates's
   name constraints must permit. The specified value replaces
   the previous value for the pathToNames criterion.

   This constraint is useful when building a certification path forward
   (from the target toward the trust anchor. If a partial path has been
   built, any candidate certificate must not include name constraints that
   would prohibit building a path to any of the names in the partial path.

   The names parameter (if not null) is a
   Collection with one
   entry for each name to be included in the pathToNames
   criterion. Each entry is a List whose first entry is an
   Integer (the name type, 0-8) and whose second
   entry is a String or a byte array (the name, in
   string or ASN.1 DER encoded form, respectively).
   There can be multiple names of the same type. If null
   is supplied as the value for this argument, no
   pathToNames check will be performed.

   Each name in the Collection
   may be specified either as a String or as an ASN.1 encoded
   byte array. For more details about the formats used, see
   addPathToName(int type, String name) and
   addPathToName(int type, byte [] name).

   Note: for distinguished names, specify the byte
   array form instead of the String form. See the note in
   addPathToName(int, String) for more information.

   Note that the names parameter can contain duplicate
   names (same name and name type), but they may be removed from the
   Collection of names returned by the
   getPathToNames method.

   Note that a deep copy is performed on the Collection to
   protect against subsequent modifications.

  names - a Collection with one entry per name (or null) - `java.util.Collection<java.util.List<?>>`

  throws: java.io.IOException - if a parsing error occurs"
  ([this names]
    (-> this (.setPathToNames names))))

(defn get-subject-public-key
  "Returns the subjectPublicKey criterion. The
   X509Certificate must contain the specified subject
   public key. If null, no subjectPublicKey check will be done.

  returns: the subject public key to check for (or null) - `java.security.PublicKey`"
  ([this]
    (-> this (.getSubjectPublicKey))))

(defn get-subject-key-identifier
  "Returns the subjectKeyIdentifier criterion. The
   X509Certificate must contain a SubjectKeyIdentifier
   extension with the specified value. If null, no
   subjectKeyIdentifier check will be done.

   Note that the byte array returned is cloned to protect against
   subsequent modifications.

  returns: the key identifier (or null) - `byte[]`"
  ([this]
    (-> this (.getSubjectKeyIdentifier))))

(defn get-path-to-names
  "Returns a copy of the pathToNames criterion. The
   X509Certificate must not include name constraints that would
   prohibit building a path to the specified names. If the value
   returned is null, no pathToNames check will be performed.

   If the value returned is not null, it is a
   Collection with one
   entry for each name to be included in the pathToNames
   criterion. Each entry is a List whose first entry is an
   Integer (the name type, 0-8) and whose second
   entry is a String or a byte array (the name, in
   string or ASN.1 DER encoded form, respectively).
   There can be multiple names of the same type. Note that the
   Collection returned may contain duplicate names (same
   name and name type).

   Each name in the Collection
   may be specified either as a String or as an ASN.1 encoded
   byte array. For more details about the formats used, see
   addPathToName(int type, String name) and
   addPathToName(int type, byte [] name).

   Note that a deep copy is performed on the Collection to
   protect against subsequent modifications.

  returns: a Collection of names (or null) - `java.util.Collection<java.util.List<?>>`"
  ([this]
    (-> this (.getPathToNames))))

(defn get-authority-key-identifier
  "Returns the authorityKeyIdentifier criterion. The
   X509Certificate must contain a AuthorityKeyIdentifier
   extension with the specified value. If null, no
   authorityKeyIdentifier check will be done.

   Note that the byte array returned is cloned to protect against
   subsequent modifications.

  returns: the key identifier (or null) - `byte[]`"
  ([this]
    (-> this (.getAuthorityKeyIdentifier))))

(defn get-subject-as-string
  "Denigrated, use getSubject() or
   getSubjectAsBytes() instead. This method should not be
   relied on as it can fail to match some certificates because of a loss of
   encoding information in the RFC 2253 String form of some distinguished
   names.

   Returns the subject criterion as a String. This
   distinguished name must match the subject distinguished name in the
   X509Certificate. If null, the subject criterion
   is disabled and any subject distinguished name will do.

   If the value returned is not null, it is a
   distinguished name, in RFC 2253 format.

  returns: the required subject distinguished name in RFC 2253 format
           (or null) - `java.lang.String`"
  ([this]
    (-> this (.getSubjectAsString))))

(defn get-private-key-valid
  "Returns the privateKeyValid criterion. The specified date must fall
   within the private key validity period for the
   X509Certificate. If null, no privateKeyValid
   check will be done.

   Note that the Date returned is cloned to protect against
   subsequent modifications.

  returns: the Date to check (or null) - `java.util.Date`"
  ([this]
    (-> this (.getPrivateKeyValid))))

(defn get-subject-as-bytes
  "Returns the subject criterion as a byte array. This distinguished name
   must match the subject distinguished name in the
   X509Certificate. If null, the subject criterion
   is disabled and any subject distinguished name will do.

   If the value returned is not null, it is a byte
   array containing a single DER encoded distinguished name, as defined in
   X.501. The ASN.1 notation for this structure is supplied in the
   documentation for
   setSubject(byte [] subjectDN).

   Note that the byte array returned is cloned to protect against
   subsequent modifications.

  returns: a byte array containing the required subject distinguished name
           in ASN.1 DER format (or null) - `byte[]`

  throws: java.io.IOException - if an encoding error occurs"
  ([this]
    (-> this (.getSubjectAsBytes))))

(defn set-issuer
  "Sets the issuer criterion. The specified distinguished name
   must match the issuer distinguished name in the
   X509Certificate. If null, any issuer
   distinguished name will do.

  issuer - a distinguished name as X500Principal (or null) - `javax.security.auth.x500.X500Principal`"
  ([this issuer]
    (-> this (.setIssuer issuer))))

(defn add-subject-alternative-name
  "Adds a name to the subjectAlternativeNames criterion. The
   X509Certificate must contain all or at least one
   of the specified subjectAlternativeNames, depending on the value of
   the matchAllNames flag (see setMatchAllSubjectAltNames).

   This method allows the caller to add a name to the set of subject
   alternative names.
   The specified name is added to any previous value for the
   subjectAlternativeNames criterion. If the specified name is a
   duplicate, it may be ignored.

   The name is provided in string format.
   RFC 822, DNS, and URI
   names use the well-established string formats for those types (subject to
   the restrictions included in RFC 3280). IPv4 address names are
   supplied using dotted quad notation. OID address names are represented
   as a series of nonnegative integers separated by periods. And
   directory names (distinguished names) are supplied in RFC 2253 format.
   No standard string format is defined for otherNames, X.400 names,
   EDI party names, IPv6 address names, or any other type of names. They
   should be specified using the
   addSubjectAlternativeName(int type, byte [] name)
   method.

   Note: for distinguished names, use
   addSubjectAlternativeName(int, byte[]) instead.
   This method should not be relied on as it can fail to match some
   certificates because of a loss of encoding information in the RFC 2253
   String form of some distinguished names.

  type - the name type (0-8, as specified in RFC 3280, section 4.2.1.7) - `int`
  name - the name in string form (not null) - `java.lang.String`

  throws: java.io.IOException - if a parsing error occurs"
  ([this type name]
    (-> this (.addSubjectAlternativeName type name))))

(defn get-policy
  "Returns the policy criterion. The X509Certificate must
   include at least one of the specified policies in its certificate policies
   extension. If the Set returned is empty, then the
   X509Certificate must include at least some specified policy
   in its certificate policies extension. If the Set returned is
   null, no policy check will be performed.

  returns: an immutable Set of certificate policy OIDs in
           string format (or null) - `java.util.Set<java.lang.String>`"
  ([this]
    (-> this (.getPolicy))))

(defn set-subject-public-key
  "Sets the subjectPublicKey criterion. The
   X509Certificate must contain the specified subject public
   key. If null, no subjectPublicKey check will be done.

  key - the subject public key to check for (or null) - `java.security.PublicKey`"
  ([this key]
    (-> this (.setSubjectPublicKey key))))

(defn set-authority-key-identifier
  "Sets the authorityKeyIdentifier criterion. The
   X509Certificate must contain an
   AuthorityKeyIdentifier extension for which the contents of the
   extension value matches the specified criterion value.
   If the criterion value is null, no
   authorityKeyIdentifier check will be done.

   If authorityKeyID is not null, it
   should contain a single DER encoded value corresponding to the contents
   of the extension value (not including the object identifier,
   criticality setting, and encapsulating OCTET STRING)
   for an AuthorityKeyIdentifier extension.
   The ASN.1 notation for this structure follows.



   AuthorityKeyIdentifier ::= SEQUENCE {
      keyIdentifier             [0] KeyIdentifier           OPTIONAL,
      authorityCertIssuer       [1] GeneralNames            OPTIONAL,
      authorityCertSerialNumber [2] CertificateSerialNumber OPTIONAL  }

   KeyIdentifier ::= OCTET STRING

   Authority key identifiers are not parsed by the
   X509CertSelector.  Instead, the values are
   compared using a byte-by-byte comparison.

   When the keyIdentifier field of
   AuthorityKeyIdentifier is populated, the value is
   usually taken from the SubjectKeyIdentifier extension
   in the issuer's certificate.  Note, however, that the result of
   X509Certificate.getExtensionValue(<SubjectKeyIdentifier Object
   Identifier>) on the issuer's certificate may NOT be used
   directly as the input to setAuthorityKeyIdentifier.
   This is because the SubjectKeyIdentifier contains
   only a KeyIdentifier OCTET STRING, and not a SEQUENCE of
   KeyIdentifier, GeneralNames, and CertificateSerialNumber.
   In order to use the extension value of the issuer certificate's
   SubjectKeyIdentifier
   extension, it will be necessary to extract the value of the embedded
   KeyIdentifier OCTET STRING, then DER encode this OCTET
   STRING inside a SEQUENCE.
   For more details on SubjectKeyIdentifier, see
   setSubjectKeyIdentifier(byte[] subjectKeyID).

   Note also that the byte array supplied here is cloned to protect against
   subsequent modifications.

  authority-key-id - the authority key identifier (or null) - `byte[]`"
  ([this authority-key-id]
    (-> this (.setAuthorityKeyIdentifier authority-key-id))))

(defn match
  "Decides whether a Certificate should be selected.

  cert - the Certificate to be checked - `java.security.cert.Certificate`

  returns: true if the Certificate should be
           selected, false otherwise - `boolean`"
  ([this cert]
    (-> this (.match cert))))

(defn set-subject
  "Sets the subject criterion. The specified distinguished name
   must match the subject distinguished name in the
   X509Certificate. If null, any subject
   distinguished name will do.

  subject - a distinguished name as X500Principal (or null) - `javax.security.auth.x500.X500Principal`"
  ([this subject]
    (-> this (.setSubject subject))))

(defn add-path-to-name
  "Adds a name to the pathToNames criterion. The X509Certificate
   must not include name constraints that would prohibit building a
   path to the specified name.

   This method allows the caller to add a name to the set of names which
   the X509Certificates's name constraints must permit.
   The specified name is added to any previous value for the
   pathToNames criterion.  If the name is a duplicate, it may be ignored.

   The name is provided in string format. RFC 822, DNS, and URI names
   use the well-established string formats for those types (subject to
   the restrictions included in RFC 3280). IPv4 address names are
   supplied using dotted quad notation. OID address names are represented
   as a series of nonnegative integers separated by periods. And
   directory names (distinguished names) are supplied in RFC 2253 format.
   No standard string format is defined for otherNames, X.400 names,
   EDI party names, IPv6 address names, or any other type of names. They
   should be specified using the
   addPathToName(int type, byte [] name) method.

   Note: for distinguished names, use
   addPathToName(int, byte[]) instead.
   This method should not be relied on as it can fail to match some
   certificates because of a loss of encoding information in the RFC 2253
   String form of some distinguished names.

  type - the name type (0-8, as specified in RFC 3280, section 4.2.1.7) - `int`
  name - the name in string form - `java.lang.String`

  throws: java.io.IOException - if a parsing error occurs"
  ([this type name]
    (-> this (.addPathToName type name))))

(defn clone
  "Returns a copy of this object.

  returns: the copy - `java.lang.Object`"
  ([this]
    (-> this (.clone))))

(defn set-basic-constraints
  "Sets the basic constraints constraint. If the value is greater than or
   equal to zero, X509Certificates must include a
   basicConstraints extension with
   a pathLen of at least this value. If the value is -2, only end-entity
   certificates are accepted. If the value is -1, no check is done.

   This constraint is useful when building a certification path forward
   (from the target toward the trust anchor. If a partial path has been
   built, any candidate certificate must have a maxPathLen value greater
   than or equal to the number of certificates in the partial path.

  min-max-path-len - the value for the basic constraints constraint - `int`

  throws: java.lang.IllegalArgumentException - if the value is less than -2"
  ([this min-max-path-len]
    (-> this (.setBasicConstraints min-max-path-len))))

(defn get-extended-key-usage
  "Returns the extendedKeyUsage criterion. The X509Certificate
   must allow the specified key purposes in its extended key usage
   extension. If the keyPurposeSet returned is empty or
   null, no extendedKeyUsage check will be done. Note that an
   X509Certificate that has no extendedKeyUsage extension
   implicitly allows all key purposes.

  returns: an immutable Set of key purpose OIDs in string
   format (or null) - `java.util.Set<java.lang.String>`"
  ([this]
    (-> this (.getExtendedKeyUsage))))

(defn set-subject-alternative-names
  "Sets the subjectAlternativeNames criterion. The
   X509Certificate must contain all or at least one of the
   specified subjectAlternativeNames, depending on the value of
   the matchAllNames flag (see setMatchAllSubjectAltNames).

   This method allows the caller to specify, with a single method call,
   the complete set of subject alternative names for the
   subjectAlternativeNames criterion. The specified value replaces
   the previous value for the subjectAlternativeNames criterion.

   The names parameter (if not null) is a
   Collection with one
   entry for each name to be included in the subject alternative name
   criterion. Each entry is a List whose first entry is an
   Integer (the name type, 0-8) and whose second
   entry is a String or a byte array (the name, in
   string or ASN.1 DER encoded form, respectively).
   There can be multiple names of the same type. If null
   is supplied as the value for this argument, no
   subjectAlternativeNames check will be performed.

   Each subject alternative name in the Collection
   may be specified either as a String or as an ASN.1 encoded
   byte array. For more details about the formats used, see
   addSubjectAlternativeName(int type, String name) and
   addSubjectAlternativeName(int type, byte [] name).

   Note: for distinguished names, specify the byte
   array form instead of the String form. See the note in
   addSubjectAlternativeName(int, String) for more information.

   Note that the names parameter can contain duplicate
   names (same name and name type), but they may be removed from the
   Collection of names returned by the
   getSubjectAlternativeNames method.

   Note that a deep copy is performed on the Collection to
   protect against subsequent modifications.

  names - a Collection of names (or null) - `java.util.Collection<java.util.List<?>>`

  throws: java.io.IOException - if a parsing error occurs"
  ([this names]
    (-> this (.setSubjectAlternativeNames names))))

(defn get-certificate
  "Returns the certificateEquals criterion. The specified
   X509Certificate must be equal to the
   X509Certificate passed to the match method.
   If null, this check is not applied.

  returns: the X509Certificate to match (or null) - `java.security.cert.X509Certificate`"
  ([this]
    (-> this (.getCertificate))))

(defn get-subject-public-key-alg-id
  "Returns the subjectPublicKeyAlgID criterion. The
   X509Certificate must contain a subject public key
   with the specified algorithm. If null, no
   subjectPublicKeyAlgID check will be done.

  returns: the object identifier (OID) of the signature algorithm to check
           for (or null). An OID is represented by a set of
           nonnegative integers separated by periods. - `java.lang.String`"
  ([this]
    (-> this (.getSubjectPublicKeyAlgID))))

(defn get-name-constraints
  "Returns the name constraints criterion. The X509Certificate
   must have subject and subject alternative names that
   meet the specified name constraints.

   The name constraints are returned as a byte array. This byte array
   contains the DER encoded form of the name constraints, as they
   would appear in the NameConstraints structure defined in RFC 3280
   and X.509. The ASN.1 notation for this structure is supplied in the
   documentation for
   setNameConstraints(byte [] bytes).

   Note that the byte array returned is cloned to protect against
   subsequent modifications.

  returns: a byte array containing the ASN.1 DER encoding of
           a NameConstraints extension used for checking name constraints.
           null if no name constraints check will be performed. - `byte[]`"
  ([this]
    (-> this (.getNameConstraints))))

(defn set-certificate
  "Sets the certificateEquals criterion. The specified
   X509Certificate must be equal to the
   X509Certificate passed to the match method.
   If null, then this check is not applied.

   This method is particularly useful when it is necessary to
   match a single certificate. Although other criteria can be specified
   in conjunction with the certificateEquals criterion, it is usually not
   practical or necessary.

  cert - the X509Certificate to match (or null) - `java.security.cert.X509Certificate`"
  ([this cert]
    (-> this (.setCertificate cert))))

(defn set-match-all-subject-alt-names
  "Enables/disables matching all of the subjectAlternativeNames
   specified in the setSubjectAlternativeNames or addSubjectAlternativeName methods. If enabled,
   the X509Certificate must contain all of the
   specified subject alternative names. If disabled, the
   X509Certificate must contain at least one of the
   specified subject alternative names.

   The matchAllNames flag is true by default.

  match-all-names - if true, the flag is enabled; if false, the flag is disabled. - `boolean`"
  ([this match-all-names]
    (-> this (.setMatchAllSubjectAltNames match-all-names))))

(defn set-subject-public-key-alg-id
  "Sets the subjectPublicKeyAlgID criterion. The
   X509Certificate must contain a subject public key
   with the specified algorithm. If null, no
   subjectPublicKeyAlgID check will be done.

  oid - The object identifier (OID) of the algorithm to check for (or null). An OID is represented by a set of nonnegative integers separated by periods. - `java.lang.String`

  throws: java.io.IOException - if the OID is invalid, such as the first component being not 0, 1 or 2 or the second component being greater than 39."
  ([this oid]
    (-> this (.setSubjectPublicKeyAlgID oid))))

