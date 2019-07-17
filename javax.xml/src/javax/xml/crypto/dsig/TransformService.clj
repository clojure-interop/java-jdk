(ns javax.xml.crypto.dsig.TransformService
  "A Service Provider Interface for transform and canonicalization algorithms.

  Each instance of TransformService supports a specific
  transform or canonicalization algorithm and XML mechanism type. To create a
  TransformService, call one of the static
  getInstance methods, passing in the algorithm URI and
  XML mechanism type desired, for example:


  TransformService ts = TransformService.getInstance(Transform.XPATH2, `DOM`);


  TransformService implementations are registered and loaded
  using the Provider mechanism.  Each
  TransformService service provider implementation should include
  a MechanismType service attribute that identifies the XML
  mechanism type that it supports. If the attribute is not specified,
  `DOM` is assumed. For example, a service provider that supports the
  XPath Filter 2 Transform and DOM mechanism would be specified in the
  Provider subclass as:


      put(`TransformService.`  Transform.XPATH2,
          `org.example.XPath2TransformService`);
      put(`TransformService.`  Transform.XPATH2  ` MechanismType`, `DOM`);
  TransformService implementations that support the DOM
  mechanism type must abide by the DOM interoperability requirements defined
  in the

  DOM Mechanism Requirements section of the API overview. See the

  Service Providers section of the API overview for a list of standard
  mechanism types.

  Once a TransformService has been created, it can be used
  to process Transform or CanonicalizationMethod
  objects. If the Transform or CanonicalizationMethod
  exists in XML form (for example, when validating an existing
  XMLSignature), the init(XMLStructure, XMLCryptoContext)
  method must be first called to initialize the transform and provide document
  context (even if there are no parameters). Alternatively, if the
  Transform or CanonicalizationMethod is being
  created from scratch, the init(TransformParameterSpec) method
  is called to initialize the transform with parameters and the
  marshalParams method is called to marshal the
  parameters to XML and provide the transform with document context. Finally,
  the transform method is called to perform the
  transformation.

  Concurrent Access
  The static methods of this class are guaranteed to be thread-safe.
  Multiple threads may concurrently invoke the static methods defined in this
  class with no ill effects.

  However, this is not true for the non-static methods defined by this
  class. Unless otherwise documented by a specific provider, threads that
  need to access a single TransformService instance
  concurrently should synchronize amongst themselves and provide the
  necessary locking. Multiple threads each manipulating a different
  TransformService instance need not synchronize."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.xml.crypto.dsig TransformService]))

(defn *get-instance
  "Returns a TransformService that supports the specified
   algorithm URI (ex: Transform.XPATH2) and mechanism type
   (ex: DOM) as supplied by the specified provider. Note that the specified
   Provider object does not have to be registered in the
   provider list.

  algorithm - the URI of the algorithm - `java.lang.String`
  mechanism-type - the type of the XML processing mechanism and representation - `java.lang.String`
  provider - the Provider object - `java.security.Provider`

  returns: a new TransformService - `javax.xml.crypto.dsig.TransformService`

  throws: java.lang.NullPointerException - if provider, algorithm, or mechanismType is null"
  ([algorithm mechanism-type provider]
    (TransformService/getInstance algorithm mechanism-type provider))
  ([algorithm mechanism-type]
    (TransformService/getInstance algorithm mechanism-type)))

(defn get-mechanism-type
  "Returns the mechanism type supported by this TransformService.

  returns: the mechanism type - `java.lang.String`"
  ([this]
    (-> this (.getMechanismType))))

(defn get-algorithm
  "Returns the URI of the algorithm supported by this
   TransformService.

  returns: the algorithm URI - `java.lang.String`"
  ([this]
    (-> this (.getAlgorithm))))

(defn get-provider
  "Returns the provider of this TransformService.

  returns: the provider - `java.security.Provider`"
  ([this]
    (-> this (.getProvider))))

(defn init
  "Initializes this TransformService with the specified
   parameters and document context.

  parent - a mechanism-specific structure containing the parent structure - `javax.xml.crypto.XMLStructure`
  context - the XMLCryptoContext containing additional context (may be null if not applicable) - `javax.xml.crypto.XMLCryptoContext`

  throws: java.lang.ClassCastException - if the type of parent or context is not compatible with this TransformService"
  ([this parent context]
    (-> this (.init parent context)))
  ([this params]
    (-> this (.init params))))

(defn marshal-params
  "Marshals the algorithm-specific parameters. If there are no parameters
   to be marshalled, this method returns without throwing an exception.

  parent - a mechanism-specific structure containing the parent node that the marshalled parameters should be appended to - `javax.xml.crypto.XMLStructure`
  context - the XMLCryptoContext containing additional context (may be null if not applicable) - `javax.xml.crypto.XMLCryptoContext`

  throws: java.lang.ClassCastException - if the type of parent or context is not compatible with this TransformService"
  ([this parent context]
    (-> this (.marshalParams parent context))))

