(ns jdk.security.cert.CertificateRevokedException
  "An exception that indicates an X.509 certificate is revoked. A
  CertificateRevokedException contains additional information
  about the revoked certificate, such as the date on which the
  certificate was revoked and the reason it was revoked."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.security.cert CertificateRevokedException]))

(defn ->certificate-revoked-exception
  "Constructor.

  Constructs a CertificateRevokedException with
   the specified revocation date, reason code, authority name, and map
   of extensions.

  revocation-date - the date on which the certificate was revoked. The date is copied to protect against subsequent modification. - `java.util.Date`
  reason - the revocation reason - `java.security.cert.CRLReason`
  authority - the X500Principal that represents the name of the authority that signed the certificate's revocation status information - `javax.security.auth.x500.X500Principal`
  extensions - a map of X.509 Extensions. Each key is an OID String that maps to the corresponding Extension. The map is copied to prevent subsequent modification. - `java.util.Map<java.lang.String,java.security.cert.Extension>`

  throws: java.lang.NullPointerException - if revocationDate, reason, authority, or extensions is null"
  ([revocation-date reason authority extensions]
    (new CertificateRevokedException revocation-date reason authority extensions)))

(defn get-revocation-date
  "Returns the date on which the certificate was revoked. A new copy is
   returned each time the method is invoked to protect against subsequent
   modification.

  returns: the revocation date - `java.util.Date`"
  ([this]
    (-> this (.getRevocationDate))))

(defn get-revocation-reason
  "Returns the reason the certificate was revoked.

  returns: the revocation reason - `java.security.cert.CRLReason`"
  ([this]
    (-> this (.getRevocationReason))))

(defn get-authority-name
  "Returns the name of the authority that signed the certificate's
   revocation status information.

  returns: the X500Principal that represents the name of the
       authority that signed the certificate's revocation status information - `javax.security.auth.x500.X500Principal`"
  ([this]
    (-> this (.getAuthorityName))))

(defn get-invalidity-date
  "Returns the invalidity date, as specified in the Invalidity Date
   extension of this CertificateRevokedException. The
   invalidity date is the date on which it is known or suspected that the
   private key was compromised or that the certificate otherwise became
   invalid. This implementation calls getExtensions() and
   checks the returned map for an entry for the Invalidity Date extension
   OID (`2.5.29.24`). If found, it returns the invalidity date in the
   extension; otherwise null. A new Date object is returned each time the
   method is invoked to protect against subsequent modification.

  returns: the invalidity date, or null if not specified - `java.util.Date`"
  ([this]
    (-> this (.getInvalidityDate))))

(defn get-extensions
  "Returns a map of X.509 extensions containing additional information
   about the revoked certificate, such as the Invalidity Date
   Extension. Each key is an OID String that maps to the corresponding
   Extension.

  returns: an unmodifiable map of X.509 extensions, or an empty map
      if there are no extensions - `java.util.Map<java.lang.String,java.security.cert.Extension>`"
  ([this]
    (-> this (.getExtensions))))

(defn get-message
  "Description copied from class: Throwable

  returns: the detail message string of this Throwable instance
            (which may be null). - `java.lang.String`"
  ([this]
    (-> this (.getMessage))))

