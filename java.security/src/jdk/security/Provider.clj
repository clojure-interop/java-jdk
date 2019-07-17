(ns jdk.security.Provider
  "This class represents a `provider` for the
  Java Security API, where a provider implements some or all parts of
  Java Security. Services that a provider may implement include:



  Algorithms (such as DSA, RSA, MD5 or SHA-1).

  Key generation, conversion, and management facilities (such as for
  algorithm-specific keys).



  Each provider has a name and a version number, and is configured
  in each runtime it is installed in.

  See The Provider Class
  in the `Java Cryptography Architecture API Specification & Reference`
  for information about how a particular type of provider, the
  cryptographic service provider, works and is installed. However,
  please note that a provider can be used to implement any security
  service in Java that uses a pluggable architecture with a choice
  of implementations that fit underneath.

  Some provider implementations may encounter unrecoverable internal
  errors during their operation, for example a failure to communicate with a
  security token. A ProviderException should be used to indicate
  such errors.

  The service type Provider is reserved for use by the
  security framework. Services of this type cannot be added, removed,
  or modified by applications.
  The following attributes are automatically placed in each Provider object:

  Attributes Automatically Placed in a Provider Object
  NameValue
  Provider.id name
     String.valueOf(provider.getName())
  Provider.id version
      String.valueOf(provider.getVersion())
  Provider.id info
        String.valueOf(provider.getInfo())
  Provider.id className
      provider.getClass().getName()"
  (:refer-clojure :only [require comment defn ->])
  (:import [java.security Provider]))

(defn values
  "Returns an unmodifiable Collection view of the property values
   contained in this provider.

  returns: a collection view of the values contained in this map - `java.util.Collection<java.lang.Object>`"
  (^java.util.Collection [^java.security.Provider this]
    (-> this (.values))))

(defn for-each
  "Description copied from interface: Map

  action - The action to be performed for each entry - `java.lang.Object>`"
  ([^java.security.Provider this ^java.lang.Object> action]
    (-> this (.forEach action))))

(defn keys
  "Description copied from class: Hashtable

  returns: an enumeration of the keys in this hashtable. - `java.util.Enumeration<java.lang.Object>`"
  (^java.util.Enumeration [^java.security.Provider this]
    (-> this (.keys))))

(defn replace-all
  "Replaces each entry's value with the result of invoking the given
   function on that entry, in the order entries are returned by an entry
   set iterator, until all entries have been processed or the function
   throws an exception.

   If a security manager is enabled, its checkSecurityAccess
   method is called with the string `putProviderProperty.`+name,
   where name is the provider name, to see if it's ok to set this
   provider's property values.

  function - the function to apply to each entry - `java.lang.Object>`

  throws: java.lang.SecurityException - if a security manager exists and its SecurityManager.checkSecurityAccess(java.lang.String) method denies access to set property values."
  ([^java.security.Provider this ^java.lang.Object> function]
    (-> this (.replaceAll function))))

(defn put-all
  "Copies all of the mappings from the specified Map to this provider.
   These mappings will replace any properties that this provider had
   for any of the keys currently in the specified Map.

  t - mappings to be stored in this map - `java.util.Map<?,?>`"
  ([^java.security.Provider this ^java.util.Map t]
    (-> this (.putAll t))))

(defn put-if-absent
  "If the specified key is not already associated with a value (or is mapped
   to null) associates it with the given value and returns
   null, else returns the current value.

   If a security manager is enabled, its checkSecurityAccess
   method is called with the string `putProviderProperty.`+name,
   where name is the provider name, to see if it's ok to set this
   provider's property values.

  key - key with which the specified value is to be associated - `java.lang.Object`
  value - value to be associated with the specified key - `java.lang.Object`

  returns: the previous value associated with the specified key, or
           null if there was no mapping for the key.
           (A null return can also indicate that the map
           previously associated null with the key,
           if the implementation supports null values.) - `java.lang.Object`

  throws: java.lang.SecurityException - if a security manager exists and its SecurityManager.checkSecurityAccess(java.lang.String) method denies access to set property values."
  (^java.lang.Object [^java.security.Provider this ^java.lang.Object key ^java.lang.Object value]
    (-> this (.putIfAbsent key value))))

(defn put
  "Sets the key property to have the specified
   value.

   If a security manager is enabled, its checkSecurityAccess
   method is called with the string `putProviderProperty.`+name,
   where name is the provider name, to see if it's ok to set this
   provider's property values.

  key - the hashtable key - `java.lang.Object`
  value - the value - `java.lang.Object`

  returns: the previous value of the specified key in this hashtable,
               or null if it did not have one - `java.lang.Object`

  throws: java.lang.SecurityException - if a security manager exists and its SecurityManager.checkSecurityAccess(java.lang.String) method denies access to set property values."
  (^java.lang.Object [^java.security.Provider this ^java.lang.Object key ^java.lang.Object value]
    (-> this (.put key value))))

(defn load
  "Reads a property list (key and element pairs) from the input stream.

  in-stream - the input stream. - `java.io.InputStream`

  throws: java.io.IOException - if an error occurred when reading from the input stream."
  ([^java.security.Provider this ^java.io.InputStream in-stream]
    (-> this (.load in-stream))))

(defn entry-set
  "Returns an unmodifiable Set view of the property entries contained
   in this Provider.

  returns: a set view of the mappings contained in this map - `java.util.Set<java.util.Map.Entry<java.lang.Object,java.lang.Object>>`"
  (^java.util.Set> [^java.security.Provider this]
    (-> this (.entrySet))))

(defn get-services
  "Get an unmodifiable Set of all services supported by
   this Provider.

  returns: an unmodifiable Set of all services supported by
   this Provider - `java.util.Set<java.security.Provider.Service>`"
  (^java.util.Set [^java.security.Provider this]
    (-> this (.getServices))))

(defn to-string
  "Returns a string with the name and the version number
   of this provider.

  returns: the string with the name and the version number
   for this provider. - `java.lang.String`"
  (^java.lang.String [^java.security.Provider this]
    (-> this (.toString))))

(defn get-name
  "Returns the name of this provider.

  returns: the name of this provider. - `java.lang.String`"
  (^java.lang.String [^java.security.Provider this]
    (-> this (.getName))))

(defn get-service
  "Get the service describing this Provider's implementation of the
   specified type of this algorithm or alias. If no such
   implementation exists, this method returns null. If there are two
   matching services, one added to this provider using
   putService() and one added via put(),
   the service added via putService() is returned.

  type - the type of service requested (for example, MessageDigest) - `java.lang.String`
  algorithm - the case insensitive algorithm name (or alternate alias) of the service requested (for example, SHA-1) - `java.lang.String`

  returns: the service describing this Provider's matching service
   or null if no such service exists - `java.security.Provider.Service`

  throws: java.lang.NullPointerException - if type or algorithm is null"
  (^java.security.Provider.Service [^java.security.Provider this ^java.lang.String type ^java.lang.String algorithm]
    (-> this (.getService type algorithm))))

(defn get-or-default
  "Description copied from interface: Map

  key - the key whose associated value is to be returned - `java.lang.Object`
  default-value - the default mapping of the key - `java.lang.Object`

  returns: the value to which the specified key is mapped, or
   defaultValue if this map contains no mapping for the key - `java.lang.Object`"
  (^java.lang.Object [^java.security.Provider this ^java.lang.Object key ^java.lang.Object default-value]
    (-> this (.getOrDefault key default-value))))

(defn replace
  "Replaces the entry for the specified key only if currently
   mapped to the specified value.

   If a security manager is enabled, its checkSecurityAccess
   method is called with the string `putProviderProperty.`+name,
   where name is the provider name, to see if it's ok to set this
   provider's property values.

  key - key with which the specified value is associated - `java.lang.Object`
  old-value - value expected to be associated with the specified key - `java.lang.Object`
  new-value - value to be associated with the specified key - `java.lang.Object`

  returns: true if the value was replaced - `boolean`

  throws: java.lang.SecurityException - if a security manager exists and its SecurityManager.checkSecurityAccess(java.lang.String) method denies access to set property values."
  (^Boolean [^java.security.Provider this ^java.lang.Object key ^java.lang.Object old-value ^java.lang.Object new-value]
    (-> this (.replace key old-value new-value)))
  (^java.lang.Object [^java.security.Provider this ^java.lang.Object key ^java.lang.Object value]
    (-> this (.replace key value))))

(defn get-info
  "Returns a human-readable description of the provider and its
   services.  This may return an HTML page, with relevant links.

  returns: a description of the provider and its services. - `java.lang.String`"
  (^java.lang.String [^java.security.Provider this]
    (-> this (.getInfo))))

(defn get-version
  "Returns the version number for this provider.

  returns: the version number for this provider. - `double`"
  (^Double [^java.security.Provider this]
    (-> this (.getVersion))))

(defn remove
  "Removes the entry for the specified key only if it is currently
   mapped to the specified value.

   If a security manager is enabled, its checkSecurityAccess
   method is called with the string `removeProviderProperty.`+name,
   where name is the provider name, to see if it's ok to remove this
   provider's properties.

  key - key with which the specified value is associated - `java.lang.Object`
  value - value expected to be associated with the specified key - `java.lang.Object`

  returns: true if the value was removed - `boolean`

  throws: java.lang.SecurityException - if a security manager exists and its SecurityManager.checkSecurityAccess(java.lang.String) method denies access to remove this provider's properties."
  (^Boolean [^java.security.Provider this ^java.lang.Object key ^java.lang.Object value]
    (-> this (.remove key value)))
  (^java.lang.Object [^java.security.Provider this ^java.lang.Object key]
    (-> this (.remove key))))

(defn key-set
  "Returns an unmodifiable Set view of the property keys contained in
   this provider.

  returns: a set view of the keys contained in this map - `java.util.Set<java.lang.Object>`"
  (^java.util.Set [^java.security.Provider this]
    (-> this (.keySet))))

(defn get-property
  "Description copied from class: Properties

  key - the property key. - `java.lang.String`

  returns: the value in this property list with the specified key value. - `java.lang.String`"
  (^java.lang.String [^java.security.Provider this ^java.lang.String key]
    (-> this (.getProperty key))))

(defn compute-if-present
  "If the value for the specified key is present and non-null, attempts to
   compute a new mapping given the key and its current mapped value.

   If a security manager is enabled, its checkSecurityAccess
   method is called with the strings `putProviderProperty.`+name
   and `removeProviderProperty.`+name, where name is the
   provider name, to see if it's ok to set this provider's property values
   and remove this provider's properties.

  key - key with which the specified value is to be associated - `java.lang.Object`
  remapping-function - the function to compute a value - `java.lang.Object>`

  returns: the new value associated with the specified key, or null if none - `java.lang.Object`

  throws: java.lang.SecurityException - if a security manager exists and its SecurityManager.checkSecurityAccess(java.lang.String) method denies access to set property values or remove properties."
  (^java.lang.Object [^java.security.Provider this ^java.lang.Object key ^java.lang.Object> remapping-function]
    (-> this (.computeIfPresent key remapping-function))))

(defn clear
  "Clears this provider so that it no longer contains the properties
   used to look up facilities implemented by the provider.

   If a security manager is enabled, its checkSecurityAccess
   method is called with the string `clearProviderProperties.`+name
   (where name is the provider name) to see if it's ok to clear
   this provider.

  throws: java.lang.SecurityException - if a security manager exists and its SecurityManager.checkSecurityAccess(java.lang.String) method denies access to clear this provider"
  ([^java.security.Provider this]
    (-> this (.clear))))

(defn get
  "Description copied from class: Hashtable

  key - the key whose associated value is to be returned - `java.lang.Object`

  returns: the value to which the specified key is mapped, or
           null if this map contains no mapping for the key - `java.lang.Object`"
  (^java.lang.Object [^java.security.Provider this ^java.lang.Object key]
    (-> this (.get key))))

(defn merge
  "If the specified key is not already associated with a value or is
   associated with null, associates it with the given value. Otherwise,
   replaces the value with the results of the given remapping function,
   or removes if the result is null. This method may be of use when
   combining multiple mapped values for a key.

   If a security manager is enabled, its checkSecurityAccess
   method is called with the strings `putProviderProperty.`+name
   and `removeProviderProperty.`+name, where name is the
   provider name, to see if it's ok to set this provider's property values
   and remove this provider's properties.

  key - key with which the resulting value is to be associated - `java.lang.Object`
  value - the non-null value to be merged with the existing value associated with the key or, if no existing value or a null value is associated with the key, to be associated with the key - `java.lang.Object`
  remapping-function - the function to recompute a value if present - `java.lang.Object>`

  returns: the new value associated with the specified key, or null if no
           value is associated with the key - `java.lang.Object`

  throws: java.lang.SecurityException - if a security manager exists and its SecurityManager.checkSecurityAccess(java.lang.String) method denies access to set property values or remove properties."
  (^java.lang.Object [^java.security.Provider this ^java.lang.Object key ^java.lang.Object value ^java.lang.Object> remapping-function]
    (-> this (.merge key value remapping-function))))

(defn compute
  "Attempts to compute a mapping for the specified key and its
   current mapped value (or null if there is no current
   mapping).

   If a security manager is enabled, its checkSecurityAccess
   method is called with the strings `putProviderProperty.`+name
   and `removeProviderProperty.`+name, where name is the
   provider name, to see if it's ok to set this provider's property values
   and remove this provider's properties.

  key - key with which the specified value is to be associated - `java.lang.Object`
  remapping-function - the function to compute a value - `java.lang.Object>`

  returns: the new value associated with the specified key, or null if none - `java.lang.Object`

  throws: java.lang.SecurityException - if a security manager exists and its SecurityManager.checkSecurityAccess(java.lang.String) method denies access to set property values or remove properties."
  (^java.lang.Object [^java.security.Provider this ^java.lang.Object key ^java.lang.Object> remapping-function]
    (-> this (.compute key remapping-function))))

(defn elements
  "Description copied from class: Hashtable

  returns: an enumeration of the values in this hashtable. - `java.util.Enumeration<java.lang.Object>`"
  (^java.util.Enumeration [^java.security.Provider this]
    (-> this (.elements))))

(defn compute-if-absent
  "If the specified key is not already associated with a value (or
   is mapped to null), attempts to compute its value using
   the given mapping function and enters it into this map unless
   null.

   If a security manager is enabled, its checkSecurityAccess
   method is called with the strings `putProviderProperty.`+name
   and `removeProviderProperty.`+name, where name is the
   provider name, to see if it's ok to set this provider's property values
   and remove this provider's properties.

  key - key with which the specified value is to be associated - `java.lang.Object`
  mapping-function - the function to compute a value - `java.lang.Object>`

  returns: the current (existing or computed) value associated with
           the specified key, or null if the computed value is null - `java.lang.Object`

  throws: java.lang.SecurityException - if a security manager exists and its SecurityManager.checkSecurityAccess(java.lang.String) method denies access to set property values and remove properties."
  (^java.lang.Object [^java.security.Provider this ^java.lang.Object key ^java.lang.Object> mapping-function]
    (-> this (.computeIfAbsent key mapping-function))))

