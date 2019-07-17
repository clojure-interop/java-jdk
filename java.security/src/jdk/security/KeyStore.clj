(ns jdk.security.KeyStore
  "This class represents a storage facility for cryptographic
  keys and certificates.

   A KeyStore manages different types of entries.
  Each type of entry implements the KeyStore.Entry interface.
  Three basic KeyStore.Entry implementations are provided:


  KeyStore.PrivateKeyEntry
   This type of entry holds a cryptographic PrivateKey,
  which is optionally stored in a protected format to prevent
  unauthorized access.  It is also accompanied by a certificate chain
  for the corresponding public key.

   Private keys and certificate chains are used by a given entity for
  self-authentication. Applications for this authentication include software
  distribution organizations which sign JAR files as part of releasing
  and/or licensing software.

  KeyStore.SecretKeyEntry
   This type of entry holds a cryptographic SecretKey,
  which is optionally stored in a protected format to prevent
  unauthorized access.

  KeyStore.TrustedCertificateEntry
   This type of entry contains a single public key Certificate
  belonging to another party. It is called a trusted certificate
  because the keystore owner trusts that the public key in the certificate
  indeed belongs to the identity identified by the subject (owner)
  of the certificate.

  This type of entry can be used to authenticate other parties.


   Each entry in a keystore is identified by an `alias` string. In the
  case of private keys and their associated certificate chains, these strings
  distinguish among the different ways in which the entity may authenticate
  itself. For example, the entity may authenticate itself using different
  certificate authorities, or using different public key algorithms.

   Whether aliases are case sensitive is implementation dependent. In order
  to avoid problems, it is recommended not to use aliases in a KeyStore that
  only differ in case.

   Whether keystores are persistent, and the mechanisms used by the
  keystore if it is persistent, are not specified here. This allows
  use of a variety of techniques for protecting sensitive (e.g., private or
  secret) keys. Smart cards or other integrated cryptographic engines
  (SafeKeyper) are one option, and simpler mechanisms such as files may also
  be used (in a variety of formats).

   Typical ways to request a KeyStore object include
  relying on the default type and providing a specific keystore type.


  To rely on the default type:


     KeyStore ks = KeyStore.getInstance(KeyStore.getDefaultType());
  The system will return a keystore implementation for the default type.

  To provide a specific keystore type:


       KeyStore ks = KeyStore.getInstance(`JKS`);
  The system will return the most preferred implementation of the
  specified keystore type available in the environment.


   Before a keystore can be accessed, it must be
  loaded.


     KeyStore ks = KeyStore.getInstance(KeyStore.getDefaultType());

     // get user password and file input stream
     char[] password = getPassword();

     try (FileInputStream fis = new FileInputStream(`keyStoreName`)) {
         ks.load(fis, password);
     }

  To create an empty keystore using the above load method,
  pass null as the InputStream argument.

   Once the keystore has been loaded, it is possible
  to read existing entries from the keystore, or to write new entries
  into the keystore:


     KeyStore.ProtectionParameter protParam =
         new KeyStore.PasswordProtection(password);

     // get my private key
     KeyStore.PrivateKeyEntry pkEntry = (KeyStore.PrivateKeyEntry)
         ks.getEntry(`privateKeyAlias`, protParam);
     PrivateKey myPrivateKey = pkEntry.getPrivateKey();

     // save my secret key
     javax.crypto.SecretKey mySecretKey;
     KeyStore.SecretKeyEntry skEntry =
         new KeyStore.SecretKeyEntry(mySecretKey);
     ks.setEntry(`secretKeyAlias`, skEntry, protParam);

     // store away the keystore
     try (FileOutputStream fos = new FileOutputStream(`newKeyStoreName`)) {
         ks.store(fos, password);
     }

  Note that although the same password may be used to
  load the keystore, to protect the private key entry,
  to protect the secret key entry, and to store the keystore
  (as is shown in the sample code above),
  different passwords or other protection parameters
  may also be used.

   Every implementation of the Java platform is required to support
  the following standard KeyStore type:

  PKCS12

  This type is described in the
  KeyStore section of the
  Java Cryptography Architecture Standard Algorithm Name Documentation.
  Consult the release documentation for your implementation to see if any
  other types are supported."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.security KeyStore]))

(defn *get-instance
  "Returns a keystore object of the specified type.

    A new KeyStore object encapsulating the
   KeyStoreSpi implementation from the specified provider
   is returned.  The specified provider must be registered
   in the security provider list.

    Note that the list of registered providers may be retrieved via
   the Security.getProviders() method.

  type - the type of keystore. See the KeyStore section in the Java Cryptography Architecture Standard Algorithm Name Documentation for information about standard keystore types. - `java.lang.String`
  provider - the name of the provider. - `java.lang.String`

  returns: a keystore object of the specified type. - `java.security.KeyStore`

  throws: java.security.KeyStoreException - if a KeyStoreSpi implementation for the specified type is not available from the specified provider."
  ([type provider]
    (KeyStore/getInstance type provider))
  ([type]
    (KeyStore/getInstance type)))

(defn *get-default-type
  "Returns the default keystore type as specified by the
   keystore.type security property, or the string
   `jks` (acronym for `Java keystore`)
   if no such property exists.

   The default keystore type can be used by applications that do not
   want to use a hard-coded keystore type when calling one of the
   getInstance methods, and want to provide a default keystore
   type in case a user does not specify its own.

   The default keystore type can be changed by setting the value of the
   keystore.type security property to the desired keystore type.

  returns: the default keystore type as specified by the
   keystore.type security property, or the string `jks`
   if no such property exists. - `java.lang.String`"
  ([]
    (KeyStore/getDefaultType )))

(defn delete-entry
  "Deletes the entry identified by the given alias from this keystore.

  alias - the alias name - `java.lang.String`

  throws: java.security.KeyStoreException - if the keystore has not been initialized, or if the entry cannot be removed."
  ([this alias]
    (-> this (.deleteEntry alias))))

(defn get-certificate-alias
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

  returns: the alias name of the first entry with a matching certificate,
   or null if no such entry exists in this keystore. - `java.lang.String`

  throws: java.security.KeyStoreException - if the keystore has not been initialized (loaded)."
  ([this cert]
    (-> this (.getCertificateAlias cert))))

(defn aliases
  "Lists all the alias names of this keystore.

  returns: enumeration of the alias names - `java.util.Enumeration<java.lang.String>`

  throws: java.security.KeyStoreException - if the keystore has not been initialized (loaded)."
  ([this]
    (-> this (.aliases))))

(defn get-type
  "Returns the type of this keystore.

  returns: the type of this keystore. - `java.lang.String`"
  ([this]
    (-> this (.getType))))

(defn get-entry
  "Gets a keystore Entry for the specified alias
   with the specified protection parameter.

  alias - get the keystore Entry for this alias - `java.lang.String`
  prot-param - the ProtectionParameter used to protect the Entry, which may be null - `java.security.KeyStore.ProtectionParameter`

  returns: the keystore Entry for the specified alias,
            or null if there is no such entry - `java.security.KeyStore.Entry`

  throws: java.lang.NullPointerException - if alias is null"
  ([this alias prot-param]
    (-> this (.getEntry alias prot-param))))

(defn load
  "Loads this KeyStore from the given input stream.

   A password may be given to unlock the keystore
   (e.g. the keystore resides on a hardware token device),
   or to check the integrity of the keystore data.
   If a password is not given for integrity checking,
   then integrity checking is not performed.

   In order to create an empty keystore, or if the keystore cannot
   be initialized from a stream, pass null
   as the stream argument.

    Note that if this keystore has already been loaded, it is
   reinitialized and loaded again from the given input stream.

  stream - the input stream from which the keystore is loaded, or null - `java.io.InputStream`
  password - the password used to check the integrity of the keystore, the password used to unlock the keystore, or null - `char[]`

  throws: java.io.IOException - if there is an I/O or format problem with the keystore data, if a password is required but not given, or if the given password was incorrect. If the error is due to a wrong password, the cause of the IOException should be an UnrecoverableKeyException"
  ([this stream password]
    (-> this (.load stream password)))
  ([this param]
    (-> this (.load param))))

(defn entry-instance-of
  "Determines if the keystore Entry for the specified
   alias is an instance or subclass of the specified
   entryClass.

  alias - the alias name - `java.lang.String`
  entry-class - the entry class - `java.security.KeyStore.Entry>`

  returns: true if the keystore Entry for the specified
            alias is an instance or subclass of the
            specified entryClass, false otherwise - `boolean`

  throws: java.lang.NullPointerException - if alias or entryClass is null"
  ([this alias entry-class]
    (-> this (.entryInstanceOf alias entry-class))))

(defn get-creation-date
  "Returns the creation date of the entry identified by the given alias.

  alias - the alias name - `java.lang.String`

  returns: the creation date of this entry, or null if the given alias does
   not exist - `java.util.Date`

  throws: java.security.KeyStoreException - if the keystore has not been initialized (loaded)."
  ([this alias]
    (-> this (.getCreationDate alias))))

(defn get-key
  "Returns the key associated with the given alias, using the given
   password to recover it.  The key must have been associated with
   the alias by a call to setKeyEntry,
   or by a call to setEntry with a
   PrivateKeyEntry or SecretKeyEntry.

  alias - the alias name - `java.lang.String`
  password - the password for recovering the key - `char[]`

  returns: the requested key, or null if the given alias does not exist
   or does not identify a key-related entry. - `java.security.Key`

  throws: java.security.KeyStoreException - if the keystore has not been initialized (loaded)."
  ([this alias password]
    (-> this (.getKey alias password))))

(defn get-provider
  "Returns the provider of this keystore.

  returns: the provider of this keystore. - `java.security.Provider`"
  ([this]
    (-> this (.getProvider))))

(defn contains-alias
  "Checks if the given alias exists in this keystore.

  alias - the alias name - `java.lang.String`

  returns: true if the alias exists, false otherwise - `boolean`

  throws: java.security.KeyStoreException - if the keystore has not been initialized (loaded)."
  ([this alias]
    (-> this (.containsAlias alias))))

(defn set-key-entry
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

  throws: java.security.KeyStoreException - if the keystore has not been initialized (loaded), the given key cannot be protected, or this operation fails for some other reason"
  ([this alias key password chain]
    (-> this (.setKeyEntry alias key password chain)))
  ([this alias key chain]
    (-> this (.setKeyEntry alias key chain))))

(defn set-certificate-entry
  "Assigns the given trusted certificate to the given alias.

    If the given alias identifies an existing entry
   created by a call to setCertificateEntry,
   or created by a call to setEntry with a
   TrustedCertificateEntry,
   the trusted certificate in the existing entry
   is overridden by the given certificate.

  alias - the alias name - `java.lang.String`
  cert - the certificate - `java.security.cert.Certificate`

  throws: java.security.KeyStoreException - if the keystore has not been initialized, or the given alias already exists and does not identify an entry containing a trusted certificate, or this operation fails for some other reason."
  ([this alias cert]
    (-> this (.setCertificateEntry alias cert))))

(defn key-entry?
  "Returns true if the entry identified by the given alias
   was created by a call to setKeyEntry,
   or created by a call to setEntry with a
   PrivateKeyEntry or a SecretKeyEntry.

  alias - the alias for the keystore entry to be checked - `java.lang.String`

  returns: true if the entry identified by the given alias is a
   key-related entry, false otherwise. - `boolean`

  throws: java.security.KeyStoreException - if the keystore has not been initialized (loaded)."
  ([this alias]
    (-> this (.isKeyEntry alias))))

(defn set-entry
  "Saves a keystore Entry under the specified alias.
   The protection parameter is used to protect the
   Entry.

    If an entry already exists for the specified alias,
   it is overridden.

  alias - save the keystore Entry under this alias - `java.lang.String`
  entry - the Entry to save - `java.security.KeyStore.Entry`
  prot-param - the ProtectionParameter used to protect the Entry, which may be null - `java.security.KeyStore.ProtectionParameter`

  throws: java.lang.NullPointerException - if alias or entry is null"
  ([this alias entry prot-param]
    (-> this (.setEntry alias entry prot-param))))

(defn size
  "Retrieves the number of entries in this keystore.

  returns: the number of entries in this keystore - `int`

  throws: java.security.KeyStoreException - if the keystore has not been initialized (loaded)."
  ([this]
    (-> this (.size))))

(defn get-certificate-chain
  "Returns the certificate chain associated with the given alias.
   The certificate chain must have been associated with the alias
   by a call to setKeyEntry,
   or by a call to setEntry with a
   PrivateKeyEntry.

  alias - the alias name - `java.lang.String`

  returns: the certificate chain (ordered with the user's certificate first
   followed by zero or more certificate authorities), or null if the given alias
   does not exist or does not contain a certificate chain - `java.security.cert.Certificate[]`

  throws: java.security.KeyStoreException - if the keystore has not been initialized (loaded)."
  ([this alias]
    (-> this (.getCertificateChain alias))))

(defn get-certificate
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
   is returned.

  alias - the alias name - `java.lang.String`

  returns: the certificate, or null if the given alias does not exist or
   does not contain a certificate. - `java.security.cert.Certificate`

  throws: java.security.KeyStoreException - if the keystore has not been initialized (loaded)."
  ([this alias]
    (-> this (.getCertificate alias))))

(defn certificate-entry?
  "Returns true if the entry identified by the given alias
   was created by a call to setCertificateEntry,
   or created by a call to setEntry with a
   TrustedCertificateEntry.

  alias - the alias for the keystore entry to be checked - `java.lang.String`

  returns: true if the entry identified by the given alias contains a
   trusted certificate, false otherwise. - `boolean`

  throws: java.security.KeyStoreException - if the keystore has not been initialized (loaded)."
  ([this alias]
    (-> this (.isCertificateEntry alias))))

(defn store
  "Stores this keystore to the given output stream, and protects its
   integrity with the given password.

  stream - the output stream to which this keystore is written. - `java.io.OutputStream`
  password - the password to generate the keystore integrity check - `char[]`

  throws: java.security.KeyStoreException - if the keystore has not been initialized (loaded)."
  ([this stream password]
    (-> this (.store stream password)))
  ([this param]
    (-> this (.store param))))

