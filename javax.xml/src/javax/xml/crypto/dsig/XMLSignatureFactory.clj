(ns javax.xml.crypto.dsig.XMLSignatureFactory
  "A factory for creating XMLSignature objects from scratch or
  for unmarshalling an XMLSignature object from a corresponding
  XML representation.

  XMLSignatureFactory Type

  Each instance of XMLSignatureFactory supports a specific
  XML mechanism type. To create an XMLSignatureFactory, call one
  of the static getInstance methods, passing in the XML
  mechanism type desired, for example:


  XMLSignatureFactory factory = XMLSignatureFactory.getInstance(`DOM`);


  The objects that this factory produces will be based
  on DOM and abide by the DOM interoperability requirements as defined in the

  DOM Mechanism Requirements section of the API overview. See the

  Service Providers section of the API overview for a list of standard
  mechanism types.

  XMLSignatureFactory implementations are registered and loaded
  using the Provider mechanism.
  For example, a service provider that supports the
  DOM mechanism would be specified in the Provider subclass as:


      put(`XMLSignatureFactory.DOM`, `org.example.DOMXMLSignatureFactory`);

  An implementation MUST minimally support the default mechanism type: DOM.

  Note that a caller must use the same XMLSignatureFactory
  instance to create the XMLStructures of a particular
  XMLSignature that is to be generated. The behavior is
  undefined if XMLStructures from different providers or
  different mechanism types are used together.

  Also, the XMLStructures that are created by this factory
  may contain state specific to the XMLSignature and are not
  intended to be reusable.

  Creating XMLSignatures from scratch

  Once the XMLSignatureFactory has been created, objects
  can be instantiated by calling the appropriate method. For example, a
  Reference instance may be created by invoking one of the
  newReference methods.

  Unmarshalling XMLSignatures from XML

  Alternatively, an XMLSignature may be created from an
  existing XML representation by invoking the unmarshalXMLSignature method and passing it a mechanism-specific
  XMLValidateContext instance containing the XML content:



  DOMValidateContext context = new DOMValidateContext(key, signatureElement);
  XMLSignature signature = factory.unmarshalXMLSignature(context);

  Each XMLSignatureFactory must support the required
  XMLValidateContext types for that factory type, but may support
  others. A DOM XMLSignatureFactory must support DOMValidateContext objects.

  Signing and marshalling XMLSignatures to XML

  Each XMLSignature created by the factory can also be
  marshalled to an XML representation and signed, by invoking the
  sign method of the
  XMLSignature object and passing it a mechanism-specific
  XMLSignContext object containing the signing key and
  marshalling parameters (see DOMSignContext).
  For example:



     DOMSignContext context = new DOMSignContext(privateKey, document);
     signature.sign(context);

  Concurrent Access
  The static methods of this class are guaranteed to be thread-safe.
  Multiple threads may concurrently invoke the static methods defined in this
  class with no ill effects.

  However, this is not true for the non-static methods defined by this
  class. Unless otherwise documented by a specific provider, threads that
  need to access a single XMLSignatureFactory instance
  concurrently should synchronize amongst themselves and provide the
  necessary locking. Multiple threads each manipulating a different
  XMLSignatureFactory instance need not synchronize."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.xml.crypto.dsig XMLSignatureFactory]))

(defn *get-instance
  "Returns an XMLSignatureFactory that supports the
   requested XML processing mechanism and representation type (ex: `DOM`),
   as supplied by the specified provider. Note that the specified
   Provider object does not have to be registered in the
   provider list.

  mechanism-type - the type of the XML processing mechanism and representation. See the Service Providers section of the API overview for a list of standard mechanism types. - `java.lang.String`
  provider - the Provider object - `java.security.Provider`

  returns: a new XMLSignatureFactory - `javax.xml.crypto.dsig.XMLSignatureFactory`

  throws: java.lang.NullPointerException - if provider or mechanismType is null"
  (^javax.xml.crypto.dsig.XMLSignatureFactory [^java.lang.String mechanism-type ^java.security.Provider provider]
    (XMLSignatureFactory/getInstance mechanism-type provider))
  (^javax.xml.crypto.dsig.XMLSignatureFactory [^java.lang.String mechanism-type]
    (XMLSignatureFactory/getInstance mechanism-type))
  (^javax.xml.crypto.dsig.XMLSignatureFactory []
    (XMLSignatureFactory/getInstance )))

(defn new-signature-properties
  "Creates a SignatureProperties containing the specified
   list of SignaturePropertys and optional id.

  properties - a list of one or more SignaturePropertys. The list is defensively copied to protect against subsequent modification. - `java.util.List`
  id - the id (may be null) - `java.lang.String`

  returns: a SignatureProperties - `javax.xml.crypto.dsig.SignatureProperties`

  throws: java.lang.NullPointerException - if properties is null"
  (^javax.xml.crypto.dsig.SignatureProperties [^XMLSignatureFactory this ^java.util.List properties ^java.lang.String id]
    (-> this (.newSignatureProperties properties id))))

(defn new-signed-info
  "Creates a SignedInfo with the specified parameters.

  cm - the canonicalization method - `javax.xml.crypto.dsig.CanonicalizationMethod`
  sm - the signature method - `javax.xml.crypto.dsig.SignatureMethod`
  references - a list of one or more References. The list is defensively copied to protect against subsequent modification. - `java.util.List`
  id - the id (may be null) - `java.lang.String`

  returns: a SignedInfo - `javax.xml.crypto.dsig.SignedInfo`

  throws: java.lang.ClassCastException - if any of the references are not of type Reference"
  (^javax.xml.crypto.dsig.SignedInfo [^XMLSignatureFactory this ^javax.xml.crypto.dsig.CanonicalizationMethod cm ^javax.xml.crypto.dsig.SignatureMethod sm ^java.util.List references ^java.lang.String id]
    (-> this (.newSignedInfo cm sm references id)))
  (^javax.xml.crypto.dsig.SignedInfo [^XMLSignatureFactory this ^javax.xml.crypto.dsig.CanonicalizationMethod cm ^javax.xml.crypto.dsig.SignatureMethod sm ^java.util.List references]
    (-> this (.newSignedInfo cm sm references))))

(defn get-uri-dereferencer
  "Returns a reference to the URIDereferencer that is used by
   default to dereference URIs in Reference objects.

  returns: a reference to the default URIDereferencer (never
      null) - `javax.xml.crypto.URIDereferencer`"
  (^javax.xml.crypto.URIDereferencer [^XMLSignatureFactory this]
    (-> this (.getURIDereferencer))))

(defn new-signature-property
  "Creates a SignatureProperty containing the specified
   list of XMLStructures, target URI and optional id.

  content - a list of one or more XMLStructures. The list is defensively copied to protect against subsequent modification. - `java.util.List`
  target - the target URI of the Signature that this property applies to - `java.lang.String`
  id - the id (may be null) - `java.lang.String`

  returns: a SignatureProperty - `javax.xml.crypto.dsig.SignatureProperty`

  throws: java.lang.NullPointerException - if content or target is null"
  (^javax.xml.crypto.dsig.SignatureProperty [^XMLSignatureFactory this ^java.util.List content ^java.lang.String target ^java.lang.String id]
    (-> this (.newSignatureProperty content target id))))

(defn new-xml-object
  "Creates an XMLObject from the specified parameters.

  content - a list of XMLStructures. The list is defensively copied to protect against subsequent modification. May be null or empty. - `java.util.List`
  id - the Id (may be null) - `java.lang.String`
  mime-type - the mime type (may be null) - `java.lang.String`
  encoding - the encoding (may be null) - `java.lang.String`

  returns: an XMLObject - `javax.xml.crypto.dsig.XMLObject`

  throws: java.lang.ClassCastException - if content contains any entries that are not of type XMLStructure"
  (^javax.xml.crypto.dsig.XMLObject [^XMLSignatureFactory this ^java.util.List content ^java.lang.String id ^java.lang.String mime-type ^java.lang.String encoding]
    (-> this (.newXMLObject content id mime-type encoding))))

(defn new-xml-signature
  "Creates an XMLSignature and initializes it with the
   specified parameters.

  si - the signed info - `javax.xml.crypto.dsig.SignedInfo`
  ki - the key info (may be null) - `javax.xml.crypto.dsig.keyinfo.KeyInfo`
  objects - a list of XMLObjects (may be empty or null) - `java.util.List`
  id - the Id (may be null) - `java.lang.String`
  signature-value-id - the SignatureValue Id (may be null) - `java.lang.String`

  returns: an XMLSignature - `javax.xml.crypto.dsig.XMLSignature`

  throws: java.lang.NullPointerException - if si is null"
  (^javax.xml.crypto.dsig.XMLSignature [^XMLSignatureFactory this ^javax.xml.crypto.dsig.SignedInfo si ^javax.xml.crypto.dsig.keyinfo.KeyInfo ki ^java.util.List objects ^java.lang.String id ^java.lang.String signature-value-id]
    (-> this (.newXMLSignature si ki objects id signature-value-id)))
  (^javax.xml.crypto.dsig.XMLSignature [^XMLSignatureFactory this ^javax.xml.crypto.dsig.SignedInfo si ^javax.xml.crypto.dsig.keyinfo.KeyInfo ki]
    (-> this (.newXMLSignature si ki))))

(defn get-provider
  "Returns the provider of this XMLSignatureFactory.

  returns: the provider of this XMLSignatureFactory - `java.security.Provider`"
  (^java.security.Provider [^XMLSignatureFactory this]
    (-> this (.getProvider))))

(defn get-key-info-factory
  "Returns a KeyInfoFactory that creates KeyInfo
   objects. The returned KeyInfoFactory has the same
   mechanism type and provider as this XMLSignatureFactory.

  returns: a KeyInfoFactory - `javax.xml.crypto.dsig.keyinfo.KeyInfoFactory`

  throws: javax.xml.crypto.NoSuchMechanismException - if a KeyFactory implementation with the same mechanism type and provider is not available"
  (^javax.xml.crypto.dsig.keyinfo.KeyInfoFactory [^XMLSignatureFactory this]
    (-> this (.getKeyInfoFactory))))

(defn new-signature-method
  "Creates a SignatureMethod for the specified algorithm URI
   and parameters.

  algorithm - the URI identifying the signature algorithm - `java.lang.String`
  params - algorithm-specific signature parameters (may be null) - `javax.xml.crypto.dsig.spec.SignatureMethodParameterSpec`

  returns: the SignatureMethod - `javax.xml.crypto.dsig.SignatureMethod`

  throws: java.security.InvalidAlgorithmParameterException - if the specified parameters are inappropriate for the requested algorithm"
  (^javax.xml.crypto.dsig.SignatureMethod [^XMLSignatureFactory this ^java.lang.String algorithm ^javax.xml.crypto.dsig.spec.SignatureMethodParameterSpec params]
    (-> this (.newSignatureMethod algorithm params))))

(defn new-reference
  "Creates a Reference with the specified parameters.

   This method is useful when a list of transforms have already been
   applied to the Reference. See for example,
   the

   OASIS-DSS (Digital Signature Services) specification.

   When an XMLSignature containing this reference is
   generated, the specified transforms (if non-null) are
   applied to the specified result. The
   Transforms element of the resulting Reference
   element is set to the concatenation of the
   appliedTransforms and transforms.

  uri - the reference URI (may be null) - `java.lang.String`
  dm - the digest method - `javax.xml.crypto.dsig.DigestMethod`
  applied-transforms - a list of Transforms that have already been applied. The list is defensively copied to protect against subsequent modification. The list must contain at least one entry. - `java.util.List`
  result - the result of processing the sequence of appliedTransforms - `javax.xml.crypto.Data`
  transforms - a list of Transforms that are to be applied when generating the signature. The list is defensively copied to protect against subsequent modification. May be null or empty. - `java.util.List`
  type - the reference type, as a URI (may be null) - `java.lang.String`
  id - the reference ID (may be null) - `java.lang.String`

  returns: a Reference - `javax.xml.crypto.dsig.Reference`

  throws: java.lang.ClassCastException - if any of the transforms (in either list) are not of type Transform"
  (^javax.xml.crypto.dsig.Reference [^XMLSignatureFactory this ^java.lang.String uri ^javax.xml.crypto.dsig.DigestMethod dm ^java.util.List applied-transforms ^javax.xml.crypto.Data result ^java.util.List transforms ^java.lang.String type ^java.lang.String id]
    (-> this (.newReference uri dm applied-transforms result transforms type id)))
  (^javax.xml.crypto.dsig.Reference [^XMLSignatureFactory this ^java.lang.String uri ^javax.xml.crypto.dsig.DigestMethod dm ^java.util.List transforms ^java.lang.String type ^java.lang.String id digest-value]
    (-> this (.newReference uri dm transforms type id digest-value)))
  (^javax.xml.crypto.dsig.Reference [^XMLSignatureFactory this ^java.lang.String uri ^javax.xml.crypto.dsig.DigestMethod dm ^java.util.List transforms ^java.lang.String type ^java.lang.String id]
    (-> this (.newReference uri dm transforms type id)))
  (^javax.xml.crypto.dsig.Reference [^XMLSignatureFactory this ^java.lang.String uri ^javax.xml.crypto.dsig.DigestMethod dm]
    (-> this (.newReference uri dm))))

(defn feature-supported?
  "Indicates whether a specified feature is supported.

  feature - the feature name (as an absolute URI) - `java.lang.String`

  returns: true if the specified feature is supported,
      false otherwise - `boolean`

  throws: java.lang.NullPointerException - if feature is null"
  (^Boolean [^XMLSignatureFactory this ^java.lang.String feature]
    (-> this (.isFeatureSupported feature))))

(defn unmarshal-xml-signature
  "Unmarshals a new XMLSignature instance from a
   mechanism-specific XMLValidateContext instance.

  context - a mechanism-specific context from which to unmarshal the signature from - `javax.xml.crypto.dsig.XMLValidateContext`

  returns: the XMLSignature - `javax.xml.crypto.dsig.XMLSignature`

  throws: java.lang.NullPointerException - if context is null"
  (^javax.xml.crypto.dsig.XMLSignature [^XMLSignatureFactory this ^javax.xml.crypto.dsig.XMLValidateContext context]
    (-> this (.unmarshalXMLSignature context))))

(defn get-mechanism-type
  "Returns the type of the XML processing mechanism and representation
   supported by this XMLSignatureFactory (ex: `DOM`).

  returns: the XML processing mechanism type supported by this
      XMLSignatureFactory - `java.lang.String`"
  (^java.lang.String [^XMLSignatureFactory this]
    (-> this (.getMechanismType))))

(defn new-transform
  "Creates a Transform for the specified algorithm URI
   and parameters.

  algorithm - the URI identifying the transform algorithm - `java.lang.String`
  params - algorithm-specific transform parameters (may be null) - `javax.xml.crypto.dsig.spec.TransformParameterSpec`

  returns: the Transform - `javax.xml.crypto.dsig.Transform`

  throws: java.security.InvalidAlgorithmParameterException - if the specified parameters are inappropriate for the requested algorithm"
  (^javax.xml.crypto.dsig.Transform [^XMLSignatureFactory this ^java.lang.String algorithm ^javax.xml.crypto.dsig.spec.TransformParameterSpec params]
    (-> this (.newTransform algorithm params))))

(defn new-canonicalization-method
  "Creates a CanonicalizationMethod for the specified
   algorithm URI and parameters.

  algorithm - the URI identifying the canonicalization algorithm - `java.lang.String`
  params - algorithm-specific canonicalization parameters (may be null) - `javax.xml.crypto.dsig.spec.C14NMethodParameterSpec`

  returns: the CanonicalizationMethod - `javax.xml.crypto.dsig.CanonicalizationMethod`

  throws: java.security.InvalidAlgorithmParameterException - if the specified parameters are inappropriate for the requested algorithm"
  (^javax.xml.crypto.dsig.CanonicalizationMethod [^XMLSignatureFactory this ^java.lang.String algorithm ^javax.xml.crypto.dsig.spec.C14NMethodParameterSpec params]
    (-> this (.newCanonicalizationMethod algorithm params))))

(defn new-manifest
  "Creates a Manifest containing the specified
   list of References and optional id.

  references - a list of one or more References. The list is defensively copied to protect against subsequent modification. - `java.util.List`
  id - the id (may be null) - `java.lang.String`

  returns: a Manifest - `javax.xml.crypto.dsig.Manifest`

  throws: java.lang.NullPointerException - if references is null"
  (^javax.xml.crypto.dsig.Manifest [^XMLSignatureFactory this ^java.util.List references ^java.lang.String id]
    (-> this (.newManifest references id)))
  (^javax.xml.crypto.dsig.Manifest [^XMLSignatureFactory this ^java.util.List references]
    (-> this (.newManifest references))))

(defn new-digest-method
  "Creates a DigestMethod for the specified algorithm URI
   and parameters.

  algorithm - the URI identifying the digest algorithm - `java.lang.String`
  params - algorithm-specific digest parameters (may be null) - `javax.xml.crypto.dsig.spec.DigestMethodParameterSpec`

  returns: the DigestMethod - `javax.xml.crypto.dsig.DigestMethod`

  throws: java.security.InvalidAlgorithmParameterException - if the specified parameters are inappropriate for the requested algorithm"
  (^javax.xml.crypto.dsig.DigestMethod [^XMLSignatureFactory this ^java.lang.String algorithm ^javax.xml.crypto.dsig.spec.DigestMethodParameterSpec params]
    (-> this (.newDigestMethod algorithm params))))

