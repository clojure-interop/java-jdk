(ns jdk.security.KeyStore$Builder
  "A description of a to-be-instantiated KeyStore object.

  An instance of this class encapsulates the information needed to
  instantiate and initialize a KeyStore object. That process is
  triggered when the getKeyStore() method is called.

  This makes it possible to decouple configuration from KeyStore
  object creation and e.g. delay a password prompt until it is
  needed."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.security KeyStore$Builder]))

(defn *new-instance
  "Returns a new Builder object.

   The first call to the getKeyStore() method on the returned
   builder will create a KeyStore of type type and call
   its load() method.
   The inputStream argument is constructed from
   file.
   If protection is a
   PasswordProtection, the password is obtained by
   calling the getPassword method.
   Otherwise, if protection is a
   CallbackHandlerProtection, the password is obtained
   by invoking the CallbackHandler.

   Subsequent calls to getKeyStore() return the same object
   as the initial call. If the initial call to failed with a
   KeyStoreException, subsequent calls also throw a
   KeyStoreException.

   The KeyStore is instantiated from provider if
   non-null. Otherwise, all installed providers are searched.

   Calls to getProtectionParameter()
   will return a PasswordProtection
   object encapsulating the password that was used to invoke the
   load method.

   Note that the getKeyStore() method is executed
   within the AccessControlContext of the code invoking this
   method.

  type - the type of KeyStore to be constructed - `java.lang.String`
  provider - the provider from which the KeyStore is to be instantiated (or null) - `java.security.Provider`
  file - the File that contains the KeyStore data - `java.io.File`
  protection - the ProtectionParameter securing the KeyStore data - `java.security.KeyStore.ProtectionParameter`

  returns: a new Builder object - `java.security.KeyStore.Builder`

  throws: java.lang.NullPointerException - if type, file or protection is null"
  ([^java.lang.String type ^java.security.Provider provider ^java.io.File file ^java.security.KeyStore.ProtectionParameter protection]
    (KeyStore$Builder/newInstance type provider file protection))
  ([^java.lang.String type ^java.security.Provider provider ^java.security.KeyStore.ProtectionParameter protection]
    (KeyStore$Builder/newInstance type provider protection))
  ([^java.security.KeyStore key-store ^java.security.KeyStore.ProtectionParameter protection-parameter]
    (KeyStore$Builder/newInstance key-store protection-parameter)))

(defn get-key-store
  "Returns the KeyStore described by this object.

  returns: the KeyStore described by this object - `java.security.KeyStore`

  throws: java.security.KeyStoreException - if an error occurred during the operation, for example if the KeyStore could not be instantiated or loaded"
  ([^java.security.KeyStore$Builder this]
    (-> this (.getKeyStore))))

(defn get-protection-parameter
  "Returns the ProtectionParameters that should be used to obtain
   the Entry with the given alias.
   The getKeyStore method must be invoked before this
   method may be called.

  alias - the alias of the KeyStore entry - `java.lang.String`

  returns: the ProtectionParameters that should be used to obtain
     the Entry with the given alias. - `java.security.KeyStore.ProtectionParameter`

  throws: java.lang.NullPointerException - if alias is null"
  ([^java.security.KeyStore$Builder this ^java.lang.String alias]
    (-> this (.getProtectionParameter alias))))

