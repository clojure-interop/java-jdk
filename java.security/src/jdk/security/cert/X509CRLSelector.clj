(ns jdk.security.cert.X509CRLSelector
  "A CRLSelector that selects X509CRLs that
  match all specified criteria. This class is particularly useful when
  selecting CRLs from a CertStore to check revocation status
  of a particular certificate.

  When first constructed, an X509CRLSelector has no criteria
  enabled and each of the get methods return a default
  value (null). Therefore, the match method
  would return true for any X509CRL. Typically,
  several criteria are enabled (by calling setIssuers
  or setDateAndTime, for instance) and then the
  X509CRLSelector is passed to
  CertStore.getCRLs or some similar
  method.

  Please refer to RFC 3280:
  Internet X.509 Public Key Infrastructure Certificate and CRL Profile
  for definitions of the X.509 CRL fields and extensions mentioned below.

  Concurrent Access

  Unless otherwise specified, the methods defined in this class are not
  thread-safe. Multiple threads that need to access a single
  object concurrently should synchronize amongst themselves and
  provide the necessary locking. Multiple threads each manipulating
  separate objects need not synchronize."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.security.cert X509CRLSelector]))

(defn ->x-509-crl-selector
  "Constructor.

  Creates an X509CRLSelector. Initially, no criteria are set
   so any X509CRL will match."
  ([]
    (new X509CRLSelector )))

(defn get-date-and-time
  "Returns the dateAndTime criterion. The specified date must be
   equal to or later than the value of the thisUpdate component
   of the X509CRL and earlier than the value of the
   nextUpdate component. There is no match if the
   X509CRL does not contain a nextUpdate component.
   If null, no dateAndTime check will be done.

   Note that the Date returned is cloned to protect against
   subsequent modifications.

  returns: the Date to match against (or null) - `java.util.Date`"
  ([this]
    (-> this (.getDateAndTime))))

(defn set-max-crl-number
  "Sets the maxCRLNumber criterion. The X509CRL must have a
   CRL number extension whose value is less than or equal to the
   specified value. If null, no maxCRLNumber check will be
   done.

  max-crl - the maximum CRL number accepted (or null) - `java.math.BigInteger`"
  ([this max-crl]
    (-> this (.setMaxCRLNumber max-crl))))

(defn get-max-crl
  "Returns the maxCRLNumber criterion. The X509CRL must have a
   CRL number extension whose value is less than or equal to the
   specified value. If null, no maxCRLNumber check will be
   done.

  returns: the maximum CRL number accepted (or null) - `java.math.BigInteger`"
  ([this]
    (-> this (.getMaxCRL))))

(defn get-certificate-checking
  "Returns the certificate being checked. This is not a criterion. Rather,
   it is optional information that may help a CertStore
   find CRLs that would be relevant when checking revocation for the
   specified certificate. If the value returned is null, then
   no such optional information is provided.

  returns: the certificate being checked (or null) - `java.security.cert.X509Certificate`"
  ([this]
    (-> this (.getCertificateChecking))))

(defn set-issuer-names
  "Note: use setIssuers(Collection) instead
   or only specify the byte array form of distinguished names when using
   this method. See addIssuerName(String) for more information.

   Sets the issuerNames criterion. The issuer distinguished name in the
   X509CRL must match at least one of the specified
   distinguished names. If null, any issuer distinguished name
   will do.

   This method allows the caller to specify, with a single method call,
   the complete set of issuer names which X509CRLs may contain.
   The specified value replaces the previous value for the issuerNames
   criterion.

   The names parameter (if not null) is a
   Collection of names. Each name is a String
   or a byte array representing a distinguished name (in
   RFC 2253 or
   ASN.1 DER encoded form, respectively). If null is supplied
   as the value for this argument, no issuerNames check will be performed.

   Note that the names parameter can contain duplicate
   distinguished names, but they may be removed from the
   Collection of names returned by the
   getIssuerNames method.

   If a name is specified as a byte array, it should contain a single DER
   encoded distinguished name, as defined in X.501. The ASN.1 notation for
   this structure is as follows.


   Name ::= CHOICE {
     RDNSequence }

   RDNSequence ::= SEQUENCE OF RelativeDistinguishedName

   RelativeDistinguishedName ::=
     SET SIZE (1 .. MAX) OF AttributeTypeAndValue

   AttributeTypeAndValue ::= SEQUENCE {
     type     AttributeType,
     value    AttributeValue }

   AttributeType ::= OBJECT IDENTIFIER

   AttributeValue ::= ANY DEFINED BY AttributeType
   ....
   DirectoryString ::= CHOICE {
         teletexString           TeletexString (SIZE (1..MAX)),
         printableString         PrintableString (SIZE (1..MAX)),
         universalString         UniversalString (SIZE (1..MAX)),
         utf8String              UTF8String (SIZE (1.. MAX)),
         bmpString               BMPString (SIZE (1..MAX)) }

   Note that a deep copy is performed on the Collection to
   protect against subsequent modifications.

  names - a Collection of names (or null) - `java.util.Collection<?>`

  throws: java.io.IOException - if a parsing error occurs"
  ([this names]
    (-> this (.setIssuerNames names))))

(defn add-issuer
  "Adds a name to the issuerNames criterion. The issuer distinguished
   name in the X509CRL must match at least one of the specified
   distinguished names.

   This method allows the caller to add a name to the set of issuer names
   which X509CRLs may contain. The specified name is added to
   any previous value for the issuerNames criterion.
   If the specified name is a duplicate, it may be ignored.

  issuer - the issuer as X500Principal - `javax.security.auth.x500.X500Principal`"
  ([this issuer]
    (-> this (.addIssuer issuer))))

(defn to-string
  "Returns a printable representation of the X509CRLSelector.

  returns: a String describing the contents of the
           X509CRLSelector. - `java.lang.String`"
  ([this]
    (-> this (.toString))))

(defn set-date-and-time
  "Sets the dateAndTime criterion. The specified date must be
   equal to or later than the value of the thisUpdate component
   of the X509CRL and earlier than the value of the
   nextUpdate component. There is no match if the X509CRL
   does not contain a nextUpdate component.
   If null, no dateAndTime check will be done.

   Note that the Date supplied here is cloned to protect
   against subsequent modifications.

  date-and-time - the Date to match against (or null) - `java.util.Date`"
  ([this date-and-time]
    (-> this (.setDateAndTime date-and-time))))

(defn set-issuers
  "Sets the issuerNames criterion. The issuer distinguished name in the
   X509CRL must match at least one of the specified
   distinguished names. If null, any issuer distinguished name
   will do.

   This method allows the caller to specify, with a single method call,
   the complete set of issuer names which X509CRLs may contain.
   The specified value replaces the previous value for the issuerNames
   criterion.

   The names parameter (if not null) is a
   Collection of X500Principals.

   Note that the names parameter can contain duplicate
   distinguished names, but they may be removed from the
   Collection of names returned by the
   getIssuers method.

   Note that a copy is performed on the Collection to
   protect against subsequent modifications.

  issuers - a Collection of X500Principals (or null) - `java.util.Collection<javax.security.auth.x500.X500Principal>`"
  ([this issuers]
    (-> this (.setIssuers issuers))))

(defn set-certificate-checking
  "Sets the certificate being checked. This is not a criterion. Rather,
   it is optional information that may help a CertStore
   find CRLs that would be relevant when checking revocation for the
   specified certificate. If null is specified, then no
   such optional information is provided.

  cert - the X509Certificate being checked (or null) - `java.security.cert.X509Certificate`"
  ([this cert]
    (-> this (.setCertificateChecking cert))))

(defn add-issuer-name
  "Denigrated, use
   addIssuer(X500Principal) or
   addIssuerName(byte[]) instead. This method should not be
   relied on as it can fail to match some CRLs because of a loss of
   encoding information in the RFC 2253 String form of some distinguished
   names.

   Adds a name to the issuerNames criterion. The issuer distinguished
   name in the X509CRL must match at least one of the specified
   distinguished names.

   This method allows the caller to add a name to the set of issuer names
   which X509CRLs may contain. The specified name is added to
   any previous value for the issuerNames criterion.
   If the specified name is a duplicate, it may be ignored.

  name - the name in RFC 2253 form - `java.lang.String`

  throws: java.io.IOException - if a parsing error occurs"
  ([this name]
    (-> this (.addIssuerName name))))

(defn get-min-crl
  "Returns the minCRLNumber criterion. The X509CRL must have a
   CRL number extension whose value is greater than or equal to the
   specified value. If null, no minCRLNumber check will be done.

  returns: the minimum CRL number accepted (or null) - `java.math.BigInteger`"
  ([this]
    (-> this (.getMinCRL))))

(defn set-min-crl-number
  "Sets the minCRLNumber criterion. The X509CRL must have a
   CRL number extension whose value is greater than or equal to the
   specified value. If null, no minCRLNumber check will be
   done.

  min-crl - the minimum CRL number accepted (or null) - `java.math.BigInteger`"
  ([this min-crl]
    (-> this (.setMinCRLNumber min-crl))))

(defn match
  "Decides whether a CRL should be selected.

  crl - the CRL to be checked - `java.security.cert.CRL`

  returns: true if the CRL should be selected,
           false otherwise - `boolean`"
  ([this crl]
    (-> this (.match crl))))

(defn clone
  "Returns a copy of this object.

  returns: the copy - `java.lang.Object`"
  ([this]
    (-> this (.clone))))

(defn get-issuers
  "Returns the issuerNames criterion. The issuer distinguished
   name in the X509CRL must match at least one of the specified
   distinguished names. If the value returned is null, any
   issuer distinguished name will do.

   If the value returned is not null, it is a
   unmodifiable Collection of X500Principals.

  returns: an unmodifiable Collection of names
     (or null) - `java.util.Collection<javax.security.auth.x500.X500Principal>`"
  ([this]
    (-> this (.getIssuers))))

(defn get-issuer-names
  "Returns a copy of the issuerNames criterion. The issuer distinguished
   name in the X509CRL must match at least one of the specified
   distinguished names. If the value returned is null, any
   issuer distinguished name will do.

   If the value returned is not null, it is a
   Collection of names. Each name is a String
   or a byte array representing a distinguished name (in RFC 2253 or
   ASN.1 DER encoded form, respectively).  Note that the
   Collection returned may contain duplicate names.

   If a name is specified as a byte array, it should contain a single DER
   encoded distinguished name, as defined in X.501. The ASN.1 notation for
   this structure is given in the documentation for
   setIssuerNames(Collection names).

   Note that a deep copy is performed on the Collection to
   protect against subsequent modifications.

  returns: a Collection of names (or null) - `java.util.Collection<java.lang.Object>`"
  ([this]
    (-> this (.getIssuerNames))))

