(ns jdk.security.KeyStore$PrivateKeyEntry
  "A KeyStore entry that holds a PrivateKey
  and corresponding certificate chain."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.security KeyStore$PrivateKeyEntry]))

(defn ->private-key-entry
  "Constructor.

  Constructs a PrivateKeyEntry with a PrivateKey and
   corresponding certificate chain and associated entry attributes.

    The specified chain and attributes are cloned
   before they are stored in the new PrivateKeyEntry object.

  private-key - the PrivateKey - `java.security.PrivateKey`
  chain - an array of Certificates representing the certificate chain. The chain must be ordered and contain a Certificate at index 0 corresponding to the private key. - `java.security.cert.Certificate[]`
  attributes - the attributes - `java.util.Set<java.security.KeyStore.Entry.Attribute>`

  throws: java.lang.NullPointerException - if privateKey, chain or attributes is null"
  ([^java.security.PrivateKey private-key ^java.security.cert.Certificate[] chain ^java.util.Set attributes]
    (new KeyStore$PrivateKeyEntry private-key chain attributes))
  ([^java.security.PrivateKey private-key ^java.security.cert.Certificate[] chain]
    (new KeyStore$PrivateKeyEntry private-key chain)))

(defn get-private-key
  "Gets the PrivateKey from this entry.

  returns: the PrivateKey from this entry - `java.security.PrivateKey`"
  ([^java.security.KeyStore$PrivateKeyEntry this]
    (-> this (.getPrivateKey))))

(defn get-certificate-chain
  "Gets the Certificate chain from this entry.

    The stored chain is cloned before being returned.

  returns: an array of Certificates corresponding
        to the certificate chain for the public key.
        If the certificates are of type X.509,
        the runtime type of the returned array is
        X509Certificate[]. - `java.security.cert.Certificate[]`"
  ([^java.security.KeyStore$PrivateKeyEntry this]
    (-> this (.getCertificateChain))))

(defn get-certificate
  "Gets the end entity Certificate
   from the certificate chain in this entry.

  returns: the end entity Certificate (at index 0)
        from the certificate chain in this entry.
        If the certificate is of type X.509,
        the runtime type of the returned certificate is
        X509Certificate. - `java.security.cert.Certificate`"
  ([^java.security.KeyStore$PrivateKeyEntry this]
    (-> this (.getCertificate))))

(defn get-attributes
  "Retrieves the attributes associated with an entry.

  returns: an unmodifiable Set of attributes, possibly empty - `java.util.Set<java.security.KeyStore.Entry.Attribute>`"
  ([^java.security.KeyStore$PrivateKeyEntry this]
    (-> this (.getAttributes))))

(defn to-string
  "Returns a string representation of this PrivateKeyEntry.

  returns: a string representation of this PrivateKeyEntry. - `java.lang.String`"
  ([^java.security.KeyStore$PrivateKeyEntry this]
    (-> this (.toString))))

