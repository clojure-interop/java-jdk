(ns javax.security.auth.kerberos.KeyTab
  "This class encapsulates a keytab file.

  A Kerberos JAAS login module that obtains long term secret keys from a
  keytab file should use this class. The login module will store
  an instance of this class in the private credential set of a
  Subject during the commit phase of the
  authentication process.

  If a KeyTab object is obtained from getUnboundInstance()
  or getUnboundInstance(java.io.File), it is unbound and thus can be
  used by any service principal. Otherwise, if it's obtained from
  getInstance(KerberosPrincipal) or
  getInstance(KerberosPrincipal, java.io.File), it is bound to the
  specific service principal and can only be used by it.

  Please note the constructors getInstance() and
  getInstance(java.io.File) were created when there was no support
  for unbound keytabs. These methods should not be used anymore. An object
  created with either of these methods are considered to be bound to an
  unknown principal, which means, its isBound() returns true and
  getPrincipal() returns null.

  It might be necessary for the application to be granted a
  PrivateCredentialPermission if it needs to access the KeyTab
  instance from a Subject. This permission is not needed when the
  application depends on the default JGSS Kerberos mechanism to access the
  KeyTab. In that case, however, the application will need an appropriate
  ServicePermission.

  The keytab file format is described at

  http://www.ioplex.com/utilities/keytab.txt."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.security.auth.kerberos KeyTab]))

(defn *get-instance
  "Returns a KeyTab instance from a File object
   that is bound to the specified service principal.

   The result of this method is never null. This method only associates
   the returned KeyTab object with the file and does not read it.

  princ - the bound service principal, must not be null - `javax.security.auth.kerberos.KerberosPrincipal`
  file - the keytab File object, must not be null - `java.io.File`

  returns: the keytab instance - `javax.security.auth.kerberos.KeyTab`

  throws: java.lang.NullPointerException - if either of the arguments is null"
  ([^javax.security.auth.kerberos.KerberosPrincipal princ ^java.io.File file]
    (KeyTab/getInstance princ file))
  ([^java.io.File file]
    (KeyTab/getInstance file))
  ([]
    (KeyTab/getInstance )))

(defn *get-unbound-instance
  "Returns an unbound KeyTab instance from a File
   object.

   The result of this method is never null. This method only associates
   the returned KeyTab object with the file and does not read it.

  file - the keytab File object, must not be null - `java.io.File`

  returns: the keytab instance - `javax.security.auth.kerberos.KeyTab`

  throws: java.lang.NullPointerException - if the file argument is null"
  ([^java.io.File file]
    (KeyTab/getUnboundInstance file))
  ([]
    (KeyTab/getUnboundInstance )))

(defn get-keys
  "Returns fresh keys for the given Kerberos principal.

   Implementation of this method should make sure the returned keys match
   the latest content of the keytab file. The result is a newly created
   copy that can be modified by the caller without modifying the keytab
   object. The caller should destroy the
   result keys after they are used.

   Please note that the keytab file can be created after the
   KeyTab object is instantiated and its content may change over
   time. Therefore, an application should call this method only when it
   needs to use the keys. Any previous result from an earlier invocation
   could potentially be expired.

   If there is any error (say, I/O error or format error)
   during the reading process of the KeyTab file, a saved result should be
   returned. If there is no saved result (say, this is the first time this
   method is called, or, all previous read attempts failed), an empty array
   should be returned. This can make sure the result is not drastically
   changed during the (probably slow) update of the keytab file.

   Each time this method is called and the reading of the file succeeds
   with no exception (say, I/O error or file format error),
   the result should be saved for principal. The implementation can
   also save keys for other principals having keys in the same keytab object
   if convenient.

   Any unsupported key read from the keytab is ignored and not included
   in the result.

   If this keytab is bound to a specific principal, calling this method on
   another principal will return an empty array.

  principal - the Kerberos principal, must not be null. - `javax.security.auth.kerberos.KerberosPrincipal`

  returns: the keys (never null, may be empty) - `javax.security.auth.kerberos.KerberosKey[]`

  throws: java.lang.NullPointerException - if the principal argument is null"
  ([^javax.security.auth.kerberos.KeyTab this ^javax.security.auth.kerberos.KerberosPrincipal principal]
    (-> this (.getKeys principal))))

(defn exists?
  "Checks if the keytab file exists. Implementation of this method
   should make sure that the result matches the latest status of the
   keytab file.

   The caller can use the result to determine if it should fallback to
   another mechanism to read the keys.

  returns: true if the keytab file exists; false otherwise. - `boolean`

  throws: java.lang.SecurityException - if a security manager exists and the read access to the keytab file is not permitted"
  ([^javax.security.auth.kerberos.KeyTab this]
    (-> this (.exists))))

(defn to-string
  "Description copied from class: Object

  returns: a string representation of the object. - `java.lang.String`"
  ([^javax.security.auth.kerberos.KeyTab this]
    (-> this (.toString))))

(defn hash-code
  "Returns a hashcode for this KeyTab.

  returns: a hashCode() for the KeyTab - `int`"
  ([^javax.security.auth.kerberos.KeyTab this]
    (-> this (.hashCode))))

(defn equals
  "Compares the specified Object with this KeyTab for equality.
   Returns true if the given object is also a
   KeyTab and the two
   KeyTab instances are equivalent.

  other - the Object to compare to - `java.lang.Object`

  returns: true if the specified object is equal to this KeyTab - `boolean`"
  ([^javax.security.auth.kerberos.KeyTab this ^java.lang.Object other]
    (-> this (.equals other))))

(defn get-principal
  "Returns the service principal this KeyTab object
   is bound to. Returns null if it's not bound.

   Please note the deprecated constructors create a KeyTab object bound for
   some unknown principal. In this case, this method also returns null.
   User can call isBound() to verify this case.

  returns: the service principal - `javax.security.auth.kerberos.KerberosPrincipal`"
  ([^javax.security.auth.kerberos.KeyTab this]
    (-> this (.getPrincipal))))

(defn bound?
  "Returns if the keytab is bound to a principal

  returns: if the keytab is bound to a principal - `boolean`"
  ([^javax.security.auth.kerberos.KeyTab this]
    (-> this (.isBound))))

