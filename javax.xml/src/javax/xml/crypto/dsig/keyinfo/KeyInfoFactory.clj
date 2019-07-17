(ns javax.xml.crypto.dsig.keyinfo.KeyInfoFactory
  "A factory for creating KeyInfo objects from scratch or for
  unmarshalling a KeyInfo object from a corresponding XML
  representation.

  Each instance of KeyInfoFactory supports a specific
  XML mechanism type. To create a KeyInfoFactory, call one of the
  static getInstance methods, passing in the XML
  mechanism type desired, for example:


    KeyInfoFactory factory = KeyInfoFactory.getInstance(`DOM`);


  The objects that this factory produces will be based
  on DOM and abide by the DOM interoperability requirements as defined in the

  DOM Mechanism Requirements section of the API overview. See the

  Service Providers section of the API overview for a list of standard
  mechanism types.

  KeyInfoFactory implementations are registered and loaded
  using the Provider mechanism.
  For example, a service provider that supports the
  DOM mechanism would be specified in the Provider subclass as:


      put(`KeyInfoFactory.DOM`, `org.example.DOMKeyInfoFactory`);

  Also, the XMLStructures that are created by this factory
  may contain state specific to the KeyInfo and are not
  intended to be reusable.

  An implementation MUST minimally support the default mechanism type: DOM.

  Note that a caller must use the same KeyInfoFactory
  instance to create the XMLStructures of a particular
  KeyInfo object. The behavior is undefined if
  XMLStructures from different providers or different mechanism
  types are used together.

  Concurrent Access
  The static methods of this class are guaranteed to be thread-safe.
  Multiple threads may concurrently invoke the static methods defined in this
  class with no ill effects.

  However, this is not true for the non-static methods defined by this
  class. Unless otherwise documented by a specific provider, threads that
  need to access a single KeyInfoFactory instance concurrently
  should synchronize amongst themselves and provide the necessary locking.
  Multiple threads each manipulating a different KeyInfoFactory
  instance need not synchronize."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.xml.crypto.dsig.keyinfo KeyInfoFactory]))

(defn *get-instance
  "Returns a KeyInfoFactory that supports the
   requested XML processing mechanism and representation type (ex: `DOM`),
   as supplied by the specified provider. Note that the specified
   Provider object does not have to be registered in the
   provider list.

  mechanism-type - the type of the XML processing mechanism and representation. See the Service Providers section of the API overview for a list of standard mechanism types. - `java.lang.String`
  provider - the Provider object - `java.security.Provider`

  returns: a new KeyInfoFactory - `javax.xml.crypto.dsig.keyinfo.KeyInfoFactory`

  throws: java.lang.NullPointerException - if mechanismType or provider are null"
  ([mechanism-type provider]
    (KeyInfoFactory/getInstance mechanism-type provider))
  ([mechanism-type]
    (KeyInfoFactory/getInstance mechanism-type))
  ([]
    (KeyInfoFactory/getInstance )))

(defn new-key-name
  "Creates a KeyName from the specified name.

  name - the name that identifies the key - `java.lang.String`

  returns: a KeyName - `javax.xml.crypto.dsig.keyinfo.KeyName`

  throws: java.lang.NullPointerException - if name is null"
  ([this name]
    (-> this (.newKeyName name))))

(defn get-uri-dereferencer
  "Returns a reference to the URIDereferencer that is used by
   default to dereference URIs in RetrievalMethod objects.

  returns: a reference to the default URIDereferencer - `javax.xml.crypto.URIDereferencer`"
  ([this]
    (-> this (.getURIDereferencer))))

(defn new-retrieval-method
  "Creates a RetrievalMethod from the specified parameters.

  uri - the URI that identifies the KeyInfo information to be retrieved - `java.lang.String`
  type - a URI that identifies the type of KeyInfo information to be retrieved (may be null) - `java.lang.String`
  transforms - a list of Transforms. The list is defensively copied to protect against subsequent modification. May be null or empty. - `java.util.List`

  returns: a RetrievalMethod - `javax.xml.crypto.dsig.keyinfo.RetrievalMethod`

  throws: java.lang.NullPointerException - if uri is null"
  ([this uri type transforms]
    (-> this (.newRetrievalMethod uri type transforms)))
  ([this uri]
    (-> this (.newRetrievalMethod uri))))

(defn new-x-509-issuer-serial
  "Creates an X509IssuerSerial from the specified X.500 issuer
   distinguished name and serial number.

  issuer-name - the issuer's distinguished name in RFC 2253 String format. Implementations MUST support the attribute type keywords defined in RFC 2253 (CN, L, ST, O, OU, C, STREET, DC and UID). Implementations MAY support additional keywords. - `java.lang.String`
  serial-number - the serial number - `java.math.BigInteger`

  returns: an X509IssuerSerial - `javax.xml.crypto.dsig.keyinfo.X509IssuerSerial`

  throws: java.lang.NullPointerException - if issuerName or serialNumber are null"
  ([this issuer-name serial-number]
    (-> this (.newX509IssuerSerial issuer-name serial-number))))

(defn new-x-509-data
  "Creates a X509Data containing the specified list of
   X.509 content.

  content - a list of one or more X.509 content types. Valid types are String (subject names), byte[] (subject key ids), X509Certificate, X509CRL, or XMLStructure (X509IssuerSerial objects or elements from an external namespace). Subject names are distinguished names in RFC 2253 String format. Implementations MUST support the attribute type keywords defined in RFC 2253 (CN, L, ST, O, OU, C, STREET, DC and UID). Implementations MAY support additional keywords. The list is defensively copied to protect against subsequent modification. - `java.util.List`

  returns: a X509Data - `javax.xml.crypto.dsig.keyinfo.X509Data`

  throws: java.lang.NullPointerException - if content is null"
  ([this content]
    (-> this (.newX509Data content))))

(defn get-provider
  "Returns the provider of this KeyInfoFactory.

  returns: the provider of this KeyInfoFactory - `java.security.Provider`"
  ([this]
    (-> this (.getProvider))))

(defn new-pgp-data
  "Creates a PGPData from the specified PGP public key
   identifier, and optional key material packet and list of external
   elements.

  key-id - a PGP public key identifier as defined in RFC 2440, section 11.2. The array is cloned to protect against subsequent modification. - `byte[]`
  key-packet - a PGP key material packet as defined in RFC 2440, section 5.5. The array is cloned to protect against subsequent modification. May be null. - `byte[]`
  other - a list of XMLStructures representing elements from an external namespace. The list is defensively copied to protect against subsequent modification. May be null or empty. - `java.util.List`

  returns: a PGPData - `javax.xml.crypto.dsig.keyinfo.PGPData`

  throws: java.lang.NullPointerException - if keyId is null"
  ([this key-id key-packet other]
    (-> this (.newPGPData key-id key-packet other)))
  ([this key-packet other]
    (-> this (.newPGPData key-packet other)))
  ([this key-id]
    (-> this (.newPGPData key-id))))

(defn new-key-info
  "Creates a KeyInfo containing the specified list of key
   information types and optional id. The
   id parameter represents the value of an XML
   ID attribute and is useful for referencing
   the KeyInfo from other XML structures.

  content - a list of one or more XMLStructures representing key information types. The list is defensively copied to protect against subsequent modification. - `java.util.List`
  id - the value of an XML ID (may be null) - `java.lang.String`

  returns: a KeyInfo - `javax.xml.crypto.dsig.keyinfo.KeyInfo`

  throws: java.lang.NullPointerException - if content is null"
  ([this content id]
    (-> this (.newKeyInfo content id)))
  ([this content]
    (-> this (.newKeyInfo content))))

(defn feature-supported?
  "Indicates whether a specified feature is supported.

  feature - the feature name (as an absolute URI) - `java.lang.String`

  returns: true if the specified feature is supported,
      false otherwise - `boolean`

  throws: java.lang.NullPointerException - if feature is null"
  ([this feature]
    (-> this (.isFeatureSupported feature))))

(defn get-mechanism-type
  "Returns the type of the XML processing mechanism and representation
   supported by this KeyInfoFactory (ex: `DOM`)

  returns: the XML processing mechanism type supported by this
      KeyInfoFactory - `java.lang.String`"
  ([this]
    (-> this (.getMechanismType))))

(defn new-key-value
  "Creates a KeyValue from the specified public key.

  key - the public key - `java.security.PublicKey`

  returns: a KeyValue - `javax.xml.crypto.dsig.keyinfo.KeyValue`

  throws: java.security.KeyException - if the key's algorithm is not recognized or supported by this KeyInfoFactory"
  ([this key]
    (-> this (.newKeyValue key))))

(defn unmarshal-key-info
  "Unmarshals a new KeyInfo instance from a
   mechanism-specific XMLStructure (ex: DOMStructure)
   instance.

  xml-structure - a mechanism-specific XML structure from which to unmarshal the keyinfo from - `javax.xml.crypto.XMLStructure`

  returns: the KeyInfo - `javax.xml.crypto.dsig.keyinfo.KeyInfo`

  throws: java.lang.NullPointerException - if xmlStructure is null"
  ([this xml-structure]
    (-> this (.unmarshalKeyInfo xml-structure))))

