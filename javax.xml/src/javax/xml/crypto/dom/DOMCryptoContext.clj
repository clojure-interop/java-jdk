(ns javax.xml.crypto.dom.DOMCryptoContext
  "This class provides a DOM-specific implementation of the
  XMLCryptoContext interface. It also includes additional
  methods that are specific to a DOM-based implementation for registering
  and retrieving elements that contain attributes of type ID."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.xml.crypto.dom DOMCryptoContext]))

(defn get-uri-dereferencer
  "Description copied from interface: XMLCryptoContext

  returns: the URIDereferencer, or null if not
      specified - `javax.xml.crypto.URIDereferencer`"
  (^javax.xml.crypto.URIDereferencer [^DOMCryptoContext this]
    (-> this (.getURIDereferencer))))

(defn set-id-attribute-ns
  "Registers the element's attribute specified by the namespace URI and
   local name to be of type ID. The attribute must have a non-empty value.

   This implementation uses an internal HashMap to map the
   attribute's value to the specified element.

  element - the element - `org.w3c.dom.Element`
  namespace-uri - the namespace URI of the attribute (specify null if not applicable) - `java.lang.String`
  local-name - the local name of the attribute - `java.lang.String`

  throws: java.lang.IllegalArgumentException - if localName is not an attribute of the specified element or it does not contain a specific value"
  ([^DOMCryptoContext this ^org.w3c.dom.Element element ^java.lang.String namespace-uri ^java.lang.String local-name]
    (-> this (.setIdAttributeNS element namespace-uri local-name))))

(defn set-key-selector
  "Description copied from interface: XMLCryptoContext

  ks - the key selector, or null to remove the current setting - `javax.xml.crypto.KeySelector`"
  ([^DOMCryptoContext this ^javax.xml.crypto.KeySelector ks]
    (-> this (.setKeySelector ks))))

(defn get-element-by-id
  "Returns the Element with the specified ID attribute value.

   This implementation uses an internal HashMap to get the
   element that the specified attribute value maps to.

  id-value - the value of the ID - `java.lang.String`

  returns: the Element with the specified ID attribute value,
      or null if none. - `org.w3c.dom.Element`

  throws: java.lang.NullPointerException - if idValue is null"
  (^org.w3c.dom.Element [^DOMCryptoContext this ^java.lang.String id-value]
    (-> this (.getElementById id-value))))

(defn put
  "This implementation uses an internal HashMap to map the key
   to the specified object.

  key - key with which the specified value is to be associated with - `java.lang.Object`
  value - value to be associated with the specified key - `java.lang.Object`

  returns: the previous value associated with the key, or null
      if there was no mapping for the key - `java.lang.Object`

  throws: java.lang.IllegalArgumentException - if some aspect of this key or value prevents it from being stored in this context"
  (^java.lang.Object [^DOMCryptoContext this ^java.lang.Object key ^java.lang.Object value]
    (-> this (.put key value))))

(defn set-base-uri
  "Description copied from interface: XMLCryptoContext

  base-uri - the base URI, or null to remove current value - `java.lang.String`

  throws: java.lang.IllegalArgumentException - if baseURI is not RFC 2396 compliant"
  ([^DOMCryptoContext this ^java.lang.String base-uri]
    (-> this (.setBaseURI base-uri))))

(defn get-default-namespace-prefix
  "Description copied from interface: XMLCryptoContext

  returns: the default namespace prefix, or null if none has
      been set. - `java.lang.String`"
  (^java.lang.String [^DOMCryptoContext this]
    (-> this (.getDefaultNamespacePrefix))))

(defn set-default-namespace-prefix
  "Description copied from interface: XMLCryptoContext

  default-prefix - the default namespace prefix, or null to remove the current setting. Specify the empty string (``) to bind no prefix. - `java.lang.String`"
  ([^DOMCryptoContext this ^java.lang.String default-prefix]
    (-> this (.setDefaultNamespacePrefix default-prefix))))

(defn iterator
  "Returns a read-only iterator over the set of Id/Element mappings of
   this DOMCryptoContext. Attempts to modify the set via the
   Iterator.remove() method throw an
   UnsupportedOperationException. The mappings are returned
   in no particular order. Each element in the iteration is represented as a
   Map.Entry. If the DOMCryptoContext is
   modified while an iteration is in progress, the results of the
   iteration are undefined.

  returns: a read-only iterator over the set of mappings - `java.util.Iterator`"
  (^java.util.Iterator [^DOMCryptoContext this]
    (-> this (.iterator))))

(defn get-key-selector
  "Description copied from interface: XMLCryptoContext

  returns: the key selector, or null if not specified - `javax.xml.crypto.KeySelector`"
  (^javax.xml.crypto.KeySelector [^DOMCryptoContext this]
    (-> this (.getKeySelector))))

(defn set-uri-dereferencer
  "Description copied from interface: XMLCryptoContext

  dereferencer - the URIDereferencer, or null to remove any current setting - `javax.xml.crypto.URIDereferencer`"
  ([^DOMCryptoContext this ^javax.xml.crypto.URIDereferencer dereferencer]
    (-> this (.setURIDereferencer dereferencer))))

(defn get-base-uri
  "Description copied from interface: XMLCryptoContext

  returns: the base URI, or null if not specified - `java.lang.String`"
  (^java.lang.String [^DOMCryptoContext this]
    (-> this (.getBaseURI))))

(defn get-property
  "This implementation uses an internal HashMap to get the object
   that the specified name maps to.

  name - the name of the property - `java.lang.String`

  returns: the current value of the specified property, or
      null if it does not have a value - `java.lang.Object`

  throws: java.lang.NullPointerException - if name is null"
  (^java.lang.Object [^DOMCryptoContext this ^java.lang.String name]
    (-> this (.getProperty name))))

(defn get-namespace-prefix
  "This implementation uses an internal HashMap to get the prefix
   that the specified URI maps to. It returns the defaultPrefix
   if it maps to null.

  namespace-uri - a namespace URI - `java.lang.String`
  default-prefix - the prefix to be returned in the event that the the specified namespace URI has not been bound to a prefix. - `java.lang.String`

  returns: the prefix that is associated with the specified namespace URI,
      or defaultPrefix if the URI is not registered. If
      the namespace URI is registered but has no prefix, an empty string
      (``) is returned. - `java.lang.String`

  throws: java.lang.NullPointerException - if namespaceURI is null"
  (^java.lang.String [^DOMCryptoContext this ^java.lang.String namespace-uri ^java.lang.String default-prefix]
    (-> this (.getNamespacePrefix namespace-uri default-prefix))))

(defn set-property
  "This implementation uses an internal HashMap to map the name
   to the specified object.

  name - the name of the property - `java.lang.String`
  value - the value of the property to be set - `java.lang.Object`

  returns: the previous value of the specified property, or
      null if it did not have a value - `java.lang.Object`

  throws: java.lang.NullPointerException - if name is null"
  (^java.lang.Object [^DOMCryptoContext this ^java.lang.String name ^java.lang.Object value]
    (-> this (.setProperty name value))))

(defn get
  "This implementation uses an internal HashMap to get the object
   that the specified key maps to.

  key - the key whose associated value is to be returned - `java.lang.Object`

  returns: the value to which this context maps the specified key, or
      null if there is no mapping for the key - `java.lang.Object`"
  (^java.lang.Object [^DOMCryptoContext this ^java.lang.Object key]
    (-> this (.get key))))

(defn put-namespace-prefix
  "This implementation uses an internal HashMap to map the URI
   to the specified prefix.

  namespace-uri - a namespace URI - `java.lang.String`
  prefix - a namespace prefix (or null to remove any existing mapping). Specifying the empty string (``) binds no prefix to the namespace URI. - `java.lang.String`

  returns: the previous prefix associated with the specified namespace
      URI, or null if there was none - `java.lang.String`

  throws: java.lang.NullPointerException - if namespaceURI is null"
  (^java.lang.String [^DOMCryptoContext this ^java.lang.String namespace-uri ^java.lang.String prefix]
    (-> this (.putNamespacePrefix namespace-uri prefix))))

