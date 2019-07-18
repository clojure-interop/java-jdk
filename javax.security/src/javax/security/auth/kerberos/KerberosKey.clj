(ns javax.security.auth.kerberos.KerberosKey
  "This class encapsulates a long term secret key for a Kerberos
  principal.

  All Kerberos JAAS login modules that obtain a principal's password and
  generate the secret key from it should use this class.
  Sometimes, such as when authenticating a server in
  the absence of user-to-user authentication, the login module will store
  an instance of this class in the private credential set of a
  Subject during the commit phase of the
  authentication process.

  A Kerberos service using a keytab to read secret keys should use
  the KeyTab class, where latest keys can be read when needed.

  It might be necessary for the application to be granted a
  PrivateCredentialPermission if it needs to access the KerberosKey
  instance from a Subject. This permission is not needed when the
  application depends on the default JGSS Kerberos mechanism to access the
  KerberosKey. In that case, however, the application will need an
  appropriate
  ServicePermission."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.security.auth.kerberos KerberosKey]))

(defn ->kerberos-key
  "Constructor.

  Constructs a KerberosKey from the given bytes when the key type and
   key version number are known. This can be used when reading the secret
   key information from a Kerberos `keytab`.

  principal - the principal that this secret key belongs to - `javax.security.auth.kerberos.KerberosPrincipal`
  key-bytes - the raw bytes for the secret key - `byte[]`
  key-type - the key type for the secret key as defined by the Kerberos protocol specification. - `int`
  version-num - the version number of this secret key - `int`"
  (^KerberosKey [^javax.security.auth.kerberos.KerberosPrincipal principal key-bytes ^Integer key-type ^Integer version-num]
    (new KerberosKey principal key-bytes key-type version-num))
  (^KerberosKey [^javax.security.auth.kerberos.KerberosPrincipal principal password ^java.lang.String algorithm]
    (new KerberosKey principal password algorithm)))

(defn get-principal
  "Returns the principal that this key belongs to.

  returns: the principal this key belongs to. - `javax.security.auth.kerberos.KerberosPrincipal`"
  (^javax.security.auth.kerberos.KerberosPrincipal [^KerberosKey this]
    (-> this (.getPrincipal))))

(defn get-key-type
  "Returns the key type for this long-term key.

  returns: the key type. - `int`"
  (^Integer [^KerberosKey this]
    (-> this (.getKeyType))))

(defn to-string
  "Description copied from class: Object

  returns: a string representation of the object. - `java.lang.String`"
  (^java.lang.String [^KerberosKey this]
    (-> this (.toString))))

(defn destroy
  "Destroys this key. A call to any of its other methods after this
   will cause an  IllegalStateException to be thrown.

  throws: javax.security.auth.DestroyFailedException - if some error occurs while destorying this key."
  ([^KerberosKey this]
    (-> this (.destroy))))

(defn get-algorithm
  "Returns the standard algorithm name for this key. For
   example, `DES` would indicate that this key is a DES key.
   See Appendix A in the
   Java Cryptography Architecture API Specification & Reference

   for information about standard algorithm names.

  returns: the name of the algorithm associated with this key. - `java.lang.String`"
  (^java.lang.String [^KerberosKey this]
    (-> this (.getAlgorithm))))

(defn get-version-number
  "Returns the key version number.

  returns: the key version number. - `int`"
  (^Integer [^KerberosKey this]
    (-> this (.getVersionNumber))))

(defn get-format
  "Returns the name of the encoding format for this secret key.

  returns: the String `RAW` - `java.lang.String`"
  (^java.lang.String [^KerberosKey this]
    (-> this (.getFormat))))

(defn get-encoded
  "Returns the key material of this secret key.

  returns: the key material - `byte[]`"
  ([^KerberosKey this]
    (-> this (.getEncoded))))

(defn hash-code
  "Returns a hashcode for this KerberosKey.

  returns: a hashCode() for the KerberosKey - `int`"
  (^Integer [^KerberosKey this]
    (-> this (.hashCode))))

(defn destroyed?
  "Determines if this key has been destroyed.

  returns: true if this Object has been destroyed,
            false otherwise. - `boolean`"
  (^Boolean [^KerberosKey this]
    (-> this (.isDestroyed))))

(defn equals
  "Compares the specified Object with this KerberosKey for equality.
   Returns true if the given object is also a
   KerberosKey and the two
   KerberosKey instances are equivalent.

  other - the Object to compare to - `java.lang.Object`

  returns: true if the specified object is equal to this KerberosKey,
   false otherwise. NOTE: Returns false if either of the KerberosKey
   objects has been destroyed. - `boolean`"
  (^Boolean [^KerberosKey this ^java.lang.Object other]
    (-> this (.equals other))))

