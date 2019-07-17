(ns jdk.security.KeyStore$TrustedCertificateEntry
  "A KeyStore entry that holds a trusted
  Certificate."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.security KeyStore$TrustedCertificateEntry]))

(defn ->trusted-certificate-entry
  "Constructor.

  Constructs a TrustedCertificateEntry with a
   trusted Certificate and associated entry attributes.

    The specified attributes is cloned before it is stored
   in the new TrustedCertificateEntry object.

  trusted-cert - the trusted Certificate - `java.security.cert.Certificate`
  attributes - the attributes - `java.util.Set<java.security.KeyStore.Entry.Attribute>`

  throws: java.lang.NullPointerException - if trustedCert or attributes is null"
  ([^java.security.cert.Certificate trusted-cert ^java.util.Set attributes]
    (new KeyStore$TrustedCertificateEntry trusted-cert attributes))
  ([^java.security.cert.Certificate trusted-cert]
    (new KeyStore$TrustedCertificateEntry trusted-cert)))

(defn get-trusted-certificate
  "Gets the trusted Certficate from this entry.

  returns: the trusted Certificate from this entry - `java.security.cert.Certificate`"
  ([^java.security.KeyStore$TrustedCertificateEntry this]
    (-> this (.getTrustedCertificate))))

(defn get-attributes
  "Retrieves the attributes associated with an entry.

  returns: an unmodifiable Set of attributes, possibly empty - `java.util.Set<java.security.KeyStore.Entry.Attribute>`"
  ([^java.security.KeyStore$TrustedCertificateEntry this]
    (-> this (.getAttributes))))

(defn to-string
  "Returns a string representation of this TrustedCertificateEntry.

  returns: a string representation of this TrustedCertificateEntry. - `java.lang.String`"
  ([^java.security.KeyStore$TrustedCertificateEntry this]
    (-> this (.toString))))

