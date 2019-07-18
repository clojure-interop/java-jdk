(ns javax.net.ssl.KeyManagerFactory
  "This class acts as a factory for key managers based on a
  source of key material. Each key manager manages a specific
  type of key material for use by secure sockets. The key
  material is based on a KeyStore and/or provider specific sources."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.net.ssl KeyManagerFactory]))

(defn *get-default-algorithm
  "Obtains the default KeyManagerFactory algorithm name.

   The default algorithm can be changed at runtime by setting
   the value of the ssl.KeyManagerFactory.algorithm
   security property to the desired algorithm name.

  returns: the default algorithm name as specified by the
            ssl.KeyManagerFactory.algorithm security property, or an
            implementation-specific default if no such property exists. - `java.lang.String`"
  (^java.lang.String []
    (KeyManagerFactory/getDefaultAlgorithm )))

(defn *get-instance
  "Returns a KeyManagerFactory object that acts as a
   factory for key managers.

    A new KeyManagerFactory object encapsulating the
   KeyManagerFactorySpi implementation from the specified provider
   is returned.  The specified provider must be registered
   in the security provider list.

    Note that the list of registered providers may be retrieved via
   the Security.getProviders() method.

  algorithm - the standard name of the requested algorithm. See the Java Secure Socket Extension Reference Guide for information about standard algorithm names. - `java.lang.String`
  provider - the name of the provider. - `java.lang.String`

  returns: the new KeyManagerFactory object. - `javax.net.ssl.KeyManagerFactory`

  throws: java.security.NoSuchAlgorithmException - if a KeyManagerFactorySpi implementation for the specified algorithm is not available from the specified provider."
  (^javax.net.ssl.KeyManagerFactory [^java.lang.String algorithm ^java.lang.String provider]
    (KeyManagerFactory/getInstance algorithm provider))
  (^javax.net.ssl.KeyManagerFactory [^java.lang.String algorithm]
    (KeyManagerFactory/getInstance algorithm)))

(defn get-algorithm
  "Returns the algorithm name of this KeyManagerFactory object.

   This is the same name that was specified in one of the
   getInstance calls that created this
   KeyManagerFactory object.

  returns: the algorithm name of this KeyManagerFactory object. - `java.lang.String`"
  (^java.lang.String [^KeyManagerFactory this]
    (-> this (.getAlgorithm))))

(defn get-provider
  "Returns the provider of this KeyManagerFactory object.

  returns: the provider of this KeyManagerFactory object - `java.security.Provider`"
  (^java.security.Provider [^KeyManagerFactory this]
    (-> this (.getProvider))))

(defn init
  "Initializes this factory with a source of key material.

   The provider typically uses a KeyStore for obtaining
   key material for use during secure socket negotiations.
   The KeyStore is generally password-protected.

   For more flexible initialization, please see
   init(ManagerFactoryParameters).

  ks - the key store or null - `java.security.KeyStore`
  password - the password for recovering keys in the KeyStore - `char[]`

  throws: java.security.KeyStoreException - if this operation fails"
  ([^KeyManagerFactory this ^java.security.KeyStore ks password]
    (-> this (.init ks password)))
  ([^KeyManagerFactory this ^javax.net.ssl.ManagerFactoryParameters spec]
    (-> this (.init spec))))

(defn get-key-managers
  "Returns one key manager for each type of key material.

  returns: the key managers - `javax.net.ssl.KeyManager[]`

  throws: java.lang.IllegalStateException - if the KeyManagerFactory is not initialized"
  ([^KeyManagerFactory this]
    (-> this (.getKeyManagers))))

