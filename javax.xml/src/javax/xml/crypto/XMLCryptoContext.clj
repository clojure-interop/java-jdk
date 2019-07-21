(ns javax.xml.crypto.XMLCryptoContext
  "Contains common context information for XML cryptographic operations.

  This interface contains methods for setting and retrieving properties
  that affect the processing of XML signatures or XML encrypted structures.

  Note that XMLCryptoContext instances can contain information
  and state specific to the XML cryptographic structure it is used with.
  The results are unpredictable if an XMLCryptoContext is
  used with multiple structures (for example, you should not use the same
  XMLValidateContext instance to validate two
  different XMLSignature objects)."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.xml.crypto XMLCryptoContext]))

(defn get-uri-dereferencer
  "Returns a URIDereferencer that is used to dereference
   URIReferences.

  returns: the URIDereferencer, or null if not
      specified - `javax.xml.crypto.URIDereferencer`"
  (^javax.xml.crypto.URIDereferencer [^XMLCryptoContext this]
    (-> this (.getURIDereferencer))))

(defn set-key-selector
  "Sets the key selector for finding a key.

  ks - the key selector, or null to remove the current setting - `javax.xml.crypto.KeySelector`"
  ([^XMLCryptoContext this ^javax.xml.crypto.KeySelector ks]
    (-> this (.setKeySelector ks))))

(defn put
  "Associates the specified value with the specified key in this context.
   If the context previously contained a mapping for this key, the old
   value is replaced by the specified value.

   This method is useful for storing arbitrary information that is
   specific to the cryptographic operation that this context is used for.

  key - key with which the specified value is to be associated with - `java.lang.Object`
  value - value to be associated with the specified key - `java.lang.Object`

  returns: the previous value associated with the key, or null
      if there was no mapping for the key - `java.lang.Object`

  throws: java.lang.IllegalArgumentException - if some aspect of this key or value prevents it from being stored in this context"
  (^java.lang.Object [^XMLCryptoContext this ^java.lang.Object key ^java.lang.Object value]
    (-> this (.put key value))))

(defn set-base-uri
  "Sets the base URI.

  base-uri - the base URI, or null to remove current value - `java.lang.String`

  throws: java.lang.IllegalArgumentException - if baseURI is not RFC 2396 compliant"
  ([^XMLCryptoContext this ^java.lang.String base-uri]
    (-> this (.setBaseURI base-uri))))

(defn get-default-namespace-prefix
  "Returns the default namespace prefix. The default namespace prefix
   is the prefix for all namespace URIs not explicitly set by the
   putNamespacePrefix method.

  returns: the default namespace prefix, or null if none has
      been set. - `java.lang.String`"
  (^java.lang.String [^XMLCryptoContext this]
    (-> this (.getDefaultNamespacePrefix))))

(defn set-default-namespace-prefix
  "Sets the default namespace prefix. This sets the namespace prefix for
   all namespace URIs not explicitly set by the putNamespacePrefix method.

  default-prefix - the default namespace prefix, or null to remove the current setting. Specify the empty string (\"\") to bind no prefix. - `java.lang.String`"
  ([^XMLCryptoContext this ^java.lang.String default-prefix]
    (-> this (.setDefaultNamespacePrefix default-prefix))))

(defn get-key-selector
  "Returns the key selector for finding a key.

  returns: the key selector, or null if not specified - `javax.xml.crypto.KeySelector`"
  (^javax.xml.crypto.KeySelector [^XMLCryptoContext this]
    (-> this (.getKeySelector))))

(defn set-uri-dereferencer
  "Sets a URIDereferencer that is used to dereference
   URIReferences. The specified URIDereferencer
   is used in place of an implementation's default
   URIDereferencer.

  dereferencer - the URIDereferencer, or null to remove any current setting - `javax.xml.crypto.URIDereferencer`"
  ([^XMLCryptoContext this ^javax.xml.crypto.URIDereferencer dereferencer]
    (-> this (.setURIDereferencer dereferencer))))

(defn get-base-uri
  "Returns the base URI.

  returns: the base URI, or null if not specified - `java.lang.String`"
  (^java.lang.String [^XMLCryptoContext this]
    (-> this (.getBaseURI))))

(defn get-property
  "Returns the value of the specified property.

  name - the name of the property - `java.lang.String`

  returns: the current value of the specified property, or
      null if it does not have a value - `java.lang.Object`

  throws: java.lang.NullPointerException - if name is null"
  (^java.lang.Object [^XMLCryptoContext this ^java.lang.String name]
    (-> this (.getProperty name))))

(defn get-namespace-prefix
  "Returns the namespace prefix that the specified namespace URI is
   associated with. Returns the specified default prefix if the specified
   namespace URI has not been bound to a prefix. To bind a namespace URI
   to a prefix, call the putNamespacePrefix
   method.

  namespace-uri - a namespace URI - `java.lang.String`
  default-prefix - the prefix to be returned in the event that the the specified namespace URI has not been bound to a prefix. - `java.lang.String`

  returns: the prefix that is associated with the specified namespace URI,
      or defaultPrefix if the URI is not registered. If
      the namespace URI is registered but has no prefix, an empty string
      (\"\") is returned. - `java.lang.String`

  throws: java.lang.NullPointerException - if namespaceURI is null"
  (^java.lang.String [^XMLCryptoContext this ^java.lang.String namespace-uri ^java.lang.String default-prefix]
    (-> this (.getNamespacePrefix namespace-uri default-prefix))))

(defn set-property
  "Sets the specified property.

  name - the name of the property - `java.lang.String`
  value - the value of the property to be set - `java.lang.Object`

  returns: the previous value of the specified property, or
      null if it did not have a value - `java.lang.Object`

  throws: java.lang.NullPointerException - if name is null"
  (^java.lang.Object [^XMLCryptoContext this ^java.lang.String name ^java.lang.Object value]
    (-> this (.setProperty name value))))

(defn get
  "Returns the value to which this context maps the specified key.

   More formally, if this context contains a mapping from a key
   k to a value v such that
   (key==null ? k==null : key.equals(k)), then this method
   returns v; otherwise it returns null. (There
   can be at most one such mapping.)

   This method is useful for retrieving arbitrary information that is
   specific to the cryptographic operation that this context is used for.

  key - the key whose associated value is to be returned - `java.lang.Object`

  returns: the value to which this context maps the specified key, or
      null if there is no mapping for the key - `java.lang.Object`"
  (^java.lang.Object [^XMLCryptoContext this ^java.lang.Object key]
    (-> this (.get key))))

(defn put-namespace-prefix
  "Maps the specified namespace URI to the specified prefix. If there is
   already a prefix associated with the specified namespace URI, the old
   prefix is replaced by the specified prefix.

  namespace-uri - a namespace URI - `java.lang.String`
  prefix - a namespace prefix (or null to remove any existing mapping). Specifying the empty string (\"\") binds no prefix to the namespace URI. - `java.lang.String`

  returns: the previous prefix associated with the specified namespace
      URI, or null if there was none - `java.lang.String`

  throws: java.lang.NullPointerException - if namespaceURI is null"
  (^java.lang.String [^XMLCryptoContext this ^java.lang.String namespace-uri ^java.lang.String prefix]
    (-> this (.putNamespacePrefix namespace-uri prefix))))

