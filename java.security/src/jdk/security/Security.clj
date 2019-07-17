(ns jdk.security.Security
  "This class centralizes all security properties and common security
  methods. One of its primary uses is to manage providers.

  The default values of security properties are read from an
  implementation-specific location, which is typically the properties file
  lib/security/java.security in the Java installation directory."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.security Security]))

(defn *get-providers
  "Returns an array containing all installed providers that satisfy the
   specified selection criterion, or null if no such providers have been
   installed. The returned providers are ordered
   according to their
   preference order.

    A cryptographic service is always associated with a particular
   algorithm or type. For example, a digital signature service is
   always associated with a particular algorithm (e.g., DSA),
   and a CertificateFactory service is always associated with
   a particular certificate type (e.g., X.509).

   The selection criterion must be specified in one of the following two
   formats:

    <crypto_service>.<algorithm_or_type>
    The cryptographic service name must not contain any dots.
    A
   provider satisfies the specified selection criterion iff the provider
   implements the
   specified algorithm or type for the specified cryptographic service.
    For example, `CertificateFactory.X.509`
   would be satisfied by any provider that supplied
   a CertificateFactory implementation for X.509 certificates.
    <crypto_service>.<algorithm_or_type>
   <attribute_name>:<attribute_value>
    The cryptographic service name must not contain any dots. There
   must be one or more space characters between the
   <algorithm_or_type> and the
   <attribute_name>.
     A provider satisfies this selection criterion iff the
   provider implements the specified algorithm or type for the specified
   cryptographic service and its implementation meets the
   constraint expressed by the specified attribute name/value pair.
    For example, `Signature.SHA1withDSA KeySize:1024` would be
   satisfied by any provider that implemented
   the SHA1withDSA signature algorithm with a keysize of 1024 (or larger).



    See the
   Java Cryptography Architecture Standard Algorithm Name Documentation
   for information about standard cryptographic service names, standard
   algorithm names and standard attribute names.

  filter - the criterion for selecting providers. The filter is case-insensitive. - `java.lang.String`

  returns: all the installed providers that satisfy the selection
   criterion, or null if no such providers have been installed. - `java.security.Provider[]`

  throws: java.security.InvalidParameterException - if the filter is not in the required format"
  ([^java.lang.String filter]
    (Security/getProviders filter))
  ([]
    (Security/getProviders )))

(defn *remove-provider
  "Removes the provider with the specified name.

   When the specified provider is removed, all providers located
   at a position greater than where the specified provider was are shifted
   down one position (towards the head of the list of installed
   providers).

   This method returns silently if the provider is not installed or
   if name is null.

   First, if there is a security manager, its
   checkSecurityAccess
   method is called with the string `removeProvider.`+name
   to see if it's ok to remove the provider.
   If the default implementation of checkSecurityAccess
   is used (i.e., that method is not overriden), then this will result in
   a call to the security manager's checkPermission method
   with a SecurityPermission(`removeProvider.`+name)
   permission.

  name - the name of the provider to remove. - `java.lang.String`

  throws: java.lang.SecurityException - if a security manager exists and its SecurityManager.checkSecurityAccess(java.lang.String) method denies access to remove the provider"
  ([^java.lang.String name]
    (Security/removeProvider name)))

(defn *get-algorithm-property
  "Deprecated. This method used to return the value of a proprietary
   property in the master file of the `SUN` Cryptographic Service
   Provider in order to determine how to parse algorithm-specific
   parameters. Use the new provider-based and algorithm-independent
   AlgorithmParameters and KeyFactory engine
   classes (introduced in the J2SE version 1.2 platform) instead.

  alg-name - the algorithm name. - `java.lang.String`
  prop-name - the name of the property to get. - `java.lang.String`

  returns: the value of the specified property. - `java.lang.   java.lang.String`"
  ([^java.lang.String alg-name ^java.lang.String prop-name]
    (Security/getAlgorithmProperty alg-name prop-name)))

(defn *get-provider
  "Returns the provider installed with the specified name, if
   any. Returns null if no provider with the specified name is
   installed or if name is null.

  name - the name of the provider to get. - `java.lang.String`

  returns: the provider of the specified name. - `java.security.Provider`"
  ([^java.lang.String name]
    (Security/getProvider name)))

(defn *get-property
  "Gets a security property value.

   First, if there is a security manager, its
   checkPermission  method is called with a
   java.security.SecurityPermission(`getProperty.`+key)
   permission to see if it's ok to retrieve the specified
   security property value..

  key - the key of the property being retrieved. - `java.lang.String`

  returns: the value of the security property corresponding to key. - `java.lang.String`

  throws: java.lang.SecurityException - if a security manager exists and its SecurityManager.checkPermission(java.security.Permission) method denies access to retrieve the specified security property value"
  ([^java.lang.String key]
    (Security/getProperty key)))

(defn *add-provider
  "Adds a provider to the next position available.

   If there is a security manager, the
   SecurityManager.checkSecurityAccess(java.lang.String) method is called
   with the `insertProvider` permission target name to see if
   it's ok to add a new provider. If this permission check is denied,
   checkSecurityAccess is called again with the
   `insertProvider.`+provider.getName() permission target name. If
   both checks are denied, a SecurityException is thrown.

  provider - the provider to be added. - `java.security.Provider`

  returns: the preference position in which the provider was
   added, or -1 if the provider was not added because it is
   already installed. - `int`

  throws: java.lang.NullPointerException - if provider is null"
  ([^java.security.Provider provider]
    (Security/addProvider provider)))

(defn *set-property
  "Sets a security property value.

   First, if there is a security manager, its
   checkPermission method is called with a
   java.security.SecurityPermission(`setProperty.`+key)
   permission to see if it's ok to set the specified
   security property value.

  key - the name of the property to be set. - `java.lang.String`
  datum - the value of the property to be set. - `java.lang.String`

  throws: java.lang.SecurityException - if a security manager exists and its SecurityManager.checkPermission(java.security.Permission) method denies access to set the specified security property value"
  ([^java.lang.String key ^java.lang.String datum]
    (Security/setProperty key datum)))

(defn *insert-provider-at
  "Adds a new provider, at a specified position. The position is
   the preference order in which providers are searched for
   requested algorithms.  The position is 1-based, that is,
   1 is most preferred, followed by 2, and so on.

   If the given provider is installed at the requested position,
   the provider that used to be at that position, and all providers
   with a position greater than position, are shifted up
   one position (towards the end of the list of installed providers).

   A provider cannot be added if it is already installed.

   If there is a security manager, the
   SecurityManager.checkSecurityAccess(java.lang.String) method is called
   with the `insertProvider` permission target name to see if
   it's ok to add a new provider. If this permission check is denied,
   checkSecurityAccess is called again with the
   `insertProvider.`+provider.getName() permission target name. If
   both checks are denied, a SecurityException is thrown.

  provider - the provider to be added. - `java.security.Provider`
  position - the preference position that the caller would like for this provider. - `int`

  returns: the actual preference position in which the provider was
   added, or -1 if the provider was not added because it is
   already installed. - `int`

  throws: java.lang.NullPointerException - if provider is null"
  ([^java.security.Provider provider ^Integer position]
    (Security/insertProviderAt provider position)))

(defn *get-algorithms
  "Returns a Set of Strings containing the names of all available
   algorithms or types for the specified Java cryptographic service
   (e.g., Signature, MessageDigest, Cipher, Mac, KeyStore). Returns
   an empty Set if there is no provider that supports the
   specified service or if serviceName is null. For a complete list
   of Java cryptographic services, please see the
   Java
   Cryptography Architecture API Specification & Reference.
   Note: the returned set is immutable.

  service-name - the name of the Java cryptographic service (e.g., Signature, MessageDigest, Cipher, Mac, KeyStore). Note: this parameter is case-insensitive. - `java.lang.String`

  returns: a Set of Strings containing the names of all available
   algorithms or types for the specified Java cryptographic service
   or an empty set if no provider supports the specified service. - `java.util.Set<java.lang.String>`"
  ([^java.lang.String service-name]
    (Security/getAlgorithms service-name)))

