(ns jdk.security.cert.CertStore
  "A class for retrieving Certificates and CRLs
  from a repository.

  This class uses a provider-based architecture.
  To create a CertStore, call one of the static
  getInstance methods, passing in the type of
  CertStore desired, any applicable initialization parameters
  and optionally the name of the provider desired.

  Once the CertStore has been created, it can be used to
  retrieve Certificates and CRLs by calling its
  getCertificates and
  getCRLs methods.

  Unlike a KeyStore, which provides access
  to a cache of private keys and trusted certificates, a
  CertStore is designed to provide access to a potentially
  vast repository of untrusted certificates and CRLs. For example, an LDAP
  implementation of CertStore provides access to certificates
  and CRLs stored in one or more directories using the LDAP protocol and the
  schema as defined in the RFC service attribute.

   Every implementation of the Java platform is required to support the
  following standard CertStore type:

  Collection

  This type is described in the
  CertStore section of the
  Java Cryptography Architecture Standard Algorithm Name Documentation.
  Consult the release documentation for your implementation to see if any
  other types are supported.


  Concurrent Access

  All public methods of CertStore objects must be thread-safe.
  That is, multiple threads may concurrently invoke these methods on a
  single CertStore object (or more than one) with no
  ill effects. This allows a CertPathBuilder to search for a
  CRL while simultaneously searching for further certificates, for instance.

  The static methods of this class are also guaranteed to be thread-safe.
  Multiple threads may concurrently invoke the static methods defined in
  this class with no ill effects."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.security.cert CertStore]))

(defn *get-instance
  "Returns a CertStore object that implements the specified
   CertStore type.

    A new CertStore object encapsulating the
   CertStoreSpi implementation from the specified provider
   is returned.  The specified provider must be registered
   in the security provider list.

    Note that the list of registered providers may be retrieved via
   the Security.getProviders() method.

   The CertStore that is returned is initialized with the
   specified CertStoreParameters. The type of parameters
   needed may vary between different types of CertStores.
   Note that the specified CertStoreParameters object is
   cloned.

  type - the requested CertStore type. See the CertStore section in the Java Cryptography Architecture Standard Algorithm Name Documentation for information about standard types. - `java.lang.String`
  params - the initialization parameters (may be null). - `java.security.cert.CertStoreParameters`
  provider - the name of the provider. - `java.lang.String`

  returns: a CertStore object that implements the
            specified type. - `java.security.cert.CertStore`

  throws: java.security.NoSuchAlgorithmException - if a CertStoreSpi implementation for the specified type is not available from the specified provider."
  (^java.security.cert.CertStore [^java.lang.String type ^java.security.cert.CertStoreParameters params ^java.lang.String provider]
    (CertStore/getInstance type params provider))
  (^java.security.cert.CertStore [^java.lang.String type ^java.security.cert.CertStoreParameters params]
    (CertStore/getInstance type params)))

(defn *get-default-type
  "Returns the default CertStore type as specified by the
   certstore.type security property, or the string
   `LDAP` if no such property exists.

   The default CertStore type can be used by applications
   that do not want to use a hard-coded type when calling one of the
   getInstance methods, and want to provide a default
   CertStore type in case a user does not specify its own.

   The default CertStore type can be changed by setting
   the value of the certstore.type security property to the
   desired type.

  returns: the default CertStore type as specified by the
   certstore.type security property, or the string
   `LDAP` if no such property exists. - `java.lang.String`"
  (^java.lang.String []
    (CertStore/getDefaultType )))

(defn get-certificates
  "Returns a Collection of Certificates that
   match the specified selector. If no Certificates
   match the selector, an empty Collection will be returned.

   For some CertStore types, the resulting
   Collection may not contain all of the
   Certificates that match the selector. For instance,
   an LDAP CertStore may not search all entries in the
   directory. Instead, it may just search entries that are likely to
   contain the Certificates it is looking for.

   Some CertStore implementations (especially LDAP
   CertStores) may throw a CertStoreException
   unless a non-null CertSelector is provided that
   includes specific criteria that can be used to find the certificates.
   Issuer and/or subject names are especially useful criteria.

  selector - A CertSelector used to select which Certificates should be returned. Specify null to return all Certificates (if supported). - `java.security.cert.CertSelector`

  returns: A Collection of Certificates that
           match the specified selector (never null) - `java.util.Collection<? extends java.security.cert.Certificate>`

  throws: java.security.cert.CertStoreException - if an exception occurs"
  ([^java.security.cert.CertStore this ^java.security.cert.CertSelector selector]
    (-> this (.getCertificates selector))))

(defn get-cr-ls
  "Returns a Collection of CRLs that
   match the specified selector. If no CRLs
   match the selector, an empty Collection will be returned.

   For some CertStore types, the resulting
   Collection may not contain all of the
   CRLs that match the selector. For instance,
   an LDAP CertStore may not search all entries in the
   directory. Instead, it may just search entries that are likely to
   contain the CRLs it is looking for.

   Some CertStore implementations (especially LDAP
   CertStores) may throw a CertStoreException
   unless a non-null CRLSelector is provided that
   includes specific criteria that can be used to find the CRLs.
   Issuer names and/or the certificate to be checked are especially useful.

  selector - A CRLSelector used to select which CRLs should be returned. Specify null to return all CRLs (if supported). - `java.security.cert.CRLSelector`

  returns: A Collection of CRLs that
           match the specified selector (never null) - `java.util.Collection<? extends java.security.cert.CRL>`

  throws: java.security.cert.CertStoreException - if an exception occurs"
  ([^java.security.cert.CertStore this ^java.security.cert.CRLSelector selector]
    (-> this (.getCRLs selector))))

(defn get-cert-store-parameters
  "Returns the parameters used to initialize this CertStore.
   Note that the CertStoreParameters object is cloned before
   it is returned.

  returns: the parameters used to initialize this CertStore
   (may be null) - `java.security.cert.CertStoreParameters`"
  (^java.security.cert.CertStoreParameters [^java.security.cert.CertStore this]
    (-> this (.getCertStoreParameters))))

(defn get-type
  "Returns the type of this CertStore.

  returns: the type of this CertStore - `java.lang.String`"
  (^java.lang.String [^java.security.cert.CertStore this]
    (-> this (.getType))))

(defn get-provider
  "Returns the provider of this CertStore.

  returns: the provider of this CertStore - `java.security.Provider`"
  (^java.security.Provider [^java.security.cert.CertStore this]
    (-> this (.getProvider))))

