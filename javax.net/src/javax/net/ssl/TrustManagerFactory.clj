(ns javax.net.ssl.TrustManagerFactory
  "This class acts as a factory for trust managers based on a
  source of trust material. Each trust manager manages a specific
  type of trust material for use by secure sockets. The trust
  material is based on a KeyStore and/or provider specific sources."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.net.ssl TrustManagerFactory]))

(defn *get-default-algorithm
  "Obtains the default TrustManagerFactory algorithm name.

   The default TrustManager can be changed at runtime by setting
   the value of the ssl.TrustManagerFactory.algorithm
   security property to the desired algorithm name.

  returns: the default algorithm name as specified by the
   ssl.TrustManagerFactory.algorithm security property, or an
   implementation-specific default if no such property exists. - `java.lang.String`"
  ([]
    (TrustManagerFactory/getDefaultAlgorithm )))

(defn *get-instance
  "Returns a TrustManagerFactory object that acts as a
   factory for trust managers.

    A new KeyManagerFactory object encapsulating the
   KeyManagerFactorySpi implementation from the specified provider
   is returned.  The specified provider must be registered
   in the security provider list.

    Note that the list of registered providers may be retrieved via
   the Security.getProviders() method.

  algorithm - the standard name of the requested trust management algorithm. See the Java Secure Socket Extension Reference Guide for information about standard algorithm names. - `java.lang.String`
  provider - the name of the provider. - `java.lang.String`

  returns: the new TrustManagerFactory object - `javax.net.ssl.TrustManagerFactory`

  throws: java.security.NoSuchAlgorithmException - if a TrustManagerFactorySpi implementation for the specified algorithm is not available from the specified provider."
  ([^java.lang.String algorithm ^java.lang.String provider]
    (TrustManagerFactory/getInstance algorithm provider))
  ([^java.lang.String algorithm]
    (TrustManagerFactory/getInstance algorithm)))

(defn get-algorithm
  "Returns the algorithm name of this TrustManagerFactory
   object.

   This is the same name that was specified in one of the
   getInstance calls that created this
   TrustManagerFactory object.

  returns: the algorithm name of this TrustManagerFactory
            object - `java.lang.String`"
  ([^javax.net.ssl.TrustManagerFactory this]
    (-> this (.getAlgorithm))))

(defn get-provider
  "Returns the provider of this TrustManagerFactory object.

  returns: the provider of this TrustManagerFactory object - `java.security.Provider`"
  ([^javax.net.ssl.TrustManagerFactory this]
    (-> this (.getProvider))))

(defn init
  "Initializes this factory with a source of certificate
   authorities and related trust material.

   The provider typically uses a KeyStore as a basis for making
   trust decisions.

   For more flexible initialization, please see
   init(ManagerFactoryParameters).

  ks - the key store, or null - `java.security.KeyStore`

  throws: java.security.KeyStoreException - if this operation fails"
  ([^javax.net.ssl.TrustManagerFactory this ^java.security.KeyStore ks]
    (-> this (.init ks))))

(defn get-trust-managers
  "Returns one trust manager for each type of trust material.

  returns: the trust managers - `javax.net.ssl.TrustManager[]`

  throws: java.lang.IllegalStateException - if the factory is not initialized."
  ([^javax.net.ssl.TrustManagerFactory this]
    (-> this (.getTrustManagers))))

