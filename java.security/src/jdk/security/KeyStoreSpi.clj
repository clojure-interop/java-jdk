(ns jdk.security.KeyStoreSpi
  "This class defines the Service Provider Interface (SPI)
  for the KeyStore class.
  All the abstract methods in this class must be implemented by each
  cryptographic service provider who wishes to supply the implementation
  of a keystore for a particular keystore type."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.security KeyStoreSpi]))

(defn ->key-store-spi
  "Constructor."
  ([]
    (new KeyStoreSpi )))

(defn engine-get-creation-date
  "Returns the creation date of the entry identified by the given alias.

  alias - the alias name - `java.lang.String`

  returns: the creation date of this entry, or null if the given alias does
   not exist - `java.util.Date`"
  ([this alias]
    (-> this (.engineGetCreationDate alias))))

(defn engine-set-entry
  "Saves a KeyStore.Entry under the specified alias.
   The specified protection parameter is used to protect the
   Entry.

    If an entry already exists for the specified alias,
   it is overridden.

  alias - save the KeyStore.Entry under this alias - `java.lang.String`
  entry - the Entry to save - `java.security.KeyStore.Entry`
  prot-param - the ProtectionParameter used to protect the Entry, which may be null - `java.security.KeyStore.ProtectionParameter`

  throws: java.security.KeyStoreException - if this operation fails"
  ([this alias entry prot-param]
    (-> this (.engineSetEntry alias entry prot-param))))

(defn engine-entry-instance-of
  "Determines if the keystore Entry for the specified
   alias is an instance or subclass of the specified
   entryClass.

  alias - the alias name - `java.lang.String`
  entry-class - the entry class - `java.security.KeyStore.Entry>`

  returns: true if the keystore Entry for the specified
            alias is an instance or subclass of the
            specified entryClass, false otherwise - `boolean`"
  ([this alias entry-class]
    (-> this (.engineEntryInstanceOf alias entry-class))))

(defn engine-aliases
  "Lists all the alias names of this keystore.

  returns: enumeration of the alias names - `java.util.Enumeration<java.lang.String>`"
  ([this]
    (-> this (.engineAliases))))

(defn engine-set-key-entry
  "Assigns the given key to the given alias, protecting it with the given
   password.

   If the given key is of type java.security.PrivateKey,
   it must be accompanied by a certificate chain certifying the
   corresponding public key.

   If the given alias already exists, the keystore information
   associated with it is overridden by the given key (and possibly
   certificate chain).

  alias - the alias name - `java.lang.String`
  key - the key to be associated with the alias - `java.security.Key`
  password - the password to protect the key - `char[]`
  chain - the certificate chain for the corresponding public key (only required if the given key is of type java.security.PrivateKey). - `java.security.cert.Certificate[]`

  throws: java.security.KeyStoreException - if the given key cannot be protected, or this operation fails for some other reason"
  ([this alias key password chain]
    (-> this (.engineSetKeyEntry alias key password chain)))
  ([this alias key chain]
    (-> this (.engineSetKeyEntry alias key chain))))

(defn engine-size
  "Retrieves the number of entries in this keystore.

  returns: the number of entries in this keystore - `int`"
  ([this]
    (-> this (.engineSize))))

(defn engine-contains-alias
  "Checks if the given alias exists in this keystore.

  alias - the alias name - `java.lang.String`

  returns: true if the alias exists, false otherwise - `boolean`"
  ([this alias]
    (-> this (.engineContainsAlias alias))))

(defn engine-store
  "Stores this keystore to the given output stream, and protects its
   integrity with the given password.

  stream - the output stream to which this keystore is written. - `java.io.OutputStream`
  password - the password to generate the keystore integrity check - `char[]`

  throws: java.io.IOException - if there was an I/O problem with data"
  ([this stream password]
    (-> this (.engineStore stream password)))
  ([this param]
    (-> this (.engineStore param))))

(defn engine-get-entry
  "Gets a KeyStore.Entry for the specified alias
   with the specified protection parameter.

  alias - get the KeyStore.Entry for this alias - `java.lang.String`
  prot-param - the ProtectionParameter used to protect the Entry, which may be null - `java.security.KeyStore.ProtectionParameter`

  returns: the KeyStore.Entry for the specified alias,
            or null if there is no such entry - `java.security.KeyStore.Entry`

  throws: java.security.KeyStoreException - if the operation failed"
  ([this alias prot-param]
    (-> this (.engineGetEntry alias prot-param))))

(defn engine-get-certificate-chain
  "Returns the certificate chain associated with the given alias.
   The certificate chain must have been associated with the alias
   by a call to setKeyEntry,
   or by a call to setEntry with a
   PrivateKeyEntry.

  alias - the alias name - `java.lang.String`

  returns: the certificate chain (ordered with the user's certificate first
   and the root certificate authority last), or null if the given alias
   does not exist or does not contain a certificate chain - `java.security.cert.Certificate[]`"
  ([this alias]
    (-> this (.engineGetCertificateChain alias))))

(defn engine-get-key
  "Returns the key associated with the given alias, using the given
   password to recover it.  The key must have been associated with
   the alias by a call to setKeyEntry,
   or by a call to setEntry with a
   PrivateKeyEntry or SecretKeyEntry.

  alias - the alias name - `java.lang.String`
  password - the password for recovering the key - `char[]`

  returns: the requested key, or null if the given alias does not exist
   or does not identify a key-related entry. - `java.security.Key`

  throws: java.security.NoSuchAlgorithmException - if the algorithm for recovering the key cannot be found"
  ([this alias password]
    (-> this (.engineGetKey alias password))))

(defn engine-load
  "Loads the keystore from the given input stream.

   A password may be given to unlock the keystore
   (e.g. the keystore resides on a hardware token device),
   or to check the integrity of the keystore data.
   If a password is not given for integrity checking,
   then integrity checking is not performed.

  stream - the input stream from which the keystore is loaded, or null - `java.io.InputStream`
  password - the password used to check the integrity of the keystore, the password used to unlock the keystore, or null - `char[]`

  throws: java.io.IOException - if there is an I/O or format problem with the keystore data, if a password is required but not given, or if the given password was incorrect. If the error is due to a wrong password, the cause of the IOException should be an UnrecoverableKeyException"
  ([this stream password]
    (-> this (.engineLoad stream password)))
  ([this param]
    (-> this (.engineLoad param))))

(defn engine-delete-entry
  "Deletes the entry identified by the given alias from this keystore.

  alias - the alias name - `java.lang.String`

  throws: java.security.KeyStoreException - if the entry cannot be removed."
  ([this alias]
    (-> this (.engineDeleteEntry alias))))

(defn engine-is-key-entry
  "Returns true if the entry identified by the given alias
   was created by a call to setKeyEntry,
   or created by a call to setEntry with a
   PrivateKeyEntry or a SecretKeyEntry.

  alias - the alias for the keystore entry to be checked - `java.lang.String`

  returns: true if the entry identified by the given alias is a
   key-related, false otherwise. - `boolean`"
  ([this alias]
    (-> this (.engineIsKeyEntry alias))))

(defn engine-set-certificate-entry
  "Assigns the given certificate to the given alias.

    If the given alias identifies an existing entry
   created by a call to setCertificateEntry,
   or created by a call to setEntry with a
   TrustedCertificateEntry,
   the trusted certificate in the existing entry
   is overridden by the given certificate.

  alias - the alias name - `java.lang.String`
  cert - the certificate - `java.security.cert.Certificate`

  throws: java.security.KeyStoreException - if the given alias already exists and does not identify an entry containing a trusted certificate, or this operation fails for some other reason."
  ([this alias cert]
    (-> this (.engineSetCertificateEntry alias cert))))

(defn engine-is-certificate-entry
  "Returns true if the entry identified by the given alias
   was created by a call to setCertificateEntry,
   or created by a call to setEntry with a
   TrustedCertificateEntry.

  alias - the alias for the keystore entry to be checked - `java.lang.String`

  returns: true if the entry identified by the given alias contains a
   trusted certificate, false otherwise. - `boolean`"
  ([this alias]
    (-> this (.engineIsCertificateEntry alias))))

(defn engine-get-certificate-alias
  "Returns the (alias) name of the first keystore entry whose certificate
   matches the given certificate.

   This method attempts to match the given certificate with each
   keystore entry. If the entry being considered was
   created by a call to setCertificateEntry,
   or created by a call to setEntry with a
   TrustedCertificateEntry,
   then the given certificate is compared to that entry's certificate.

    If the entry being considered was
   created by a call to setKeyEntry,
   or created by a call to setEntry with a
   PrivateKeyEntry,
   then the given certificate is compared to the first
   element of that entry's certificate chain.

  cert - the certificate to match with. - `java.security.cert.Certificate`

  returns: the alias name of the first entry with matching certificate,
   or null if no such entry exists in this keystore. - `java.lang.String`"
  ([this cert]
    (-> this (.engineGetCertificateAlias cert))))

(defn engine-get-certificate
  "Returns the certificate associated with the given alias.

    If the given alias name identifies an entry
   created by a call to setCertificateEntry,
   or created by a call to setEntry with a
   TrustedCertificateEntry,
   then the trusted certificate contained in that entry is returned.

    If the given alias name identifies an entry
   created by a call to setKeyEntry,
   or created by a call to setEntry with a
   PrivateKeyEntry,
   then the first element of the certificate chain in that entry
   (if a chain exists) is returned.

  alias - the alias name - `java.lang.String`

  returns: the certificate, or null if the given alias does not exist or
   does not contain a certificate. - `java.security.cert.Certificate`"
  ([this alias]
    (-> this (.engineGetCertificate alias))))

