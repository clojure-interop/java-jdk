(ns javax.xml.ws.EndpointReference
  "This class represents an WS-Addressing EndpointReference
  which is a remote reference to a web service endpoint.
  See
  Web Services Addressing 1.0 - Core
  for more information on WS-Addressing EndpointReferences.

  This class is immutable as the typical web service developer
  need not be concerned with its contents.  The web service
  developer should use this class strictly as a mechanism to
  reference a remote web service endpoint. See the Service APIs
  that clients can use to that utilize an EndpointReference.
  See the Endpoint, and
  BindingProvider APIs on how
  EndpointReferences can be created for published
  endpoints.

  Concrete implementations of this class will represent
  an EndpointReference for a particular version of Addressing.
  For example the W3CEndpointReference is for use
  with W3C Web Services Addressing 1.0 - Core Recommendation.
  If JAX-WS implementors need to support different versions
  of addressing, they should write their own
  EndpointReference subclass for that version.
  This will allow a JAX-WS implementation to create
  a vendor specific EndpointReferences that the
  vendor can use to flag a different version of
  addressing.

  Web service developers that wish to pass or return
  EndpointReference in Java methods in an
  SEI should use
  concrete instances of an EndpointReference such
  as the W3CEndpointReference.  This way the
  schema mapped from the SEI will be more descriptive of the
  type of endpoint reference being passed.

  JAX-WS implementors are expected to extract the XML infoset
  from an EndpointReferece using the
  writeTo(javax.xml.transform.Result)
  method.

  JAXB will bind this class to xs:anyType. If a better binding
  is desired, web services developers should use a concrete
  subclass such as W3CEndpointReference."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.xml.ws EndpointReference]))

(defn *read-from
  "Factory method to read an EndpointReference from the infoset contained in
   eprInfoset. This method delegates to the vendor specific
   implementation of the Provider.readEndpointReference(javax.xml.transform.Source) method.

  epr-infoset - The EndpointReference infoset to be unmarshalled - `javax.xml.transform.Source`

  returns: the EndpointReference unmarshalled from eprInfoset
      never null - `javax.xml.ws.EndpointReference`

  throws: javax.xml.ws.WebServiceException - if an error occurs while creating the EndpointReference from the eprInfoset"
  ([^javax.xml.transform.Source epr-infoset]
    (EndpointReference/readFrom epr-infoset)))

(defn write-to
  "write this EndpointReference to the specified infoset format

  result - for writing infoset - `javax.xml.transform.Result`

  throws: javax.xml.ws.WebServiceException - if there is an error writing the EndpointReference to the specified result."
  ([^javax.xml.ws.EndpointReference this ^javax.xml.transform.Result result]
    (-> this (.writeTo result))))

(defn get-port
  "The getPort method returns a proxy. If there
   are any reference parameters in the
   EndpointReference instance, then those reference
   parameters MUST appear as SOAP headers, indicating them to be
   reference parameters, on all messages sent to the endpoint.
   The parameter  serviceEndpointInterface specifies
   the service endpoint interface that is supported by the
   returned proxy.
   The EndpointReference instance specifies the
   endpoint that will be invoked by the returned proxy.
   In the implementation of this method, the JAX-WS
   runtime system takes the responsibility of selecting a protocol
   binding (and a port) and configuring the proxy accordingly from
   the WSDL Metadata from this EndpointReference or from
   annotations on the serviceEndpointInterface.  For this method
   to successfully return a proxy, WSDL metadata MUST be available and the
   EndpointReference instance MUST contain an implementation understood
   serviceName metadata.

   Because this port is not created from a Service object, handlers
   will not automatically be configured, and the HandlerResolver
   and Executor cannot be get or set for this port. The
   BindingProvider().getBinding().setHandlerChain()
   method can be used to manually configure handlers for this port.

  service-endpoint-interface - Service endpoint interface - `java.lang.Class<T>`
  features - An array of WebServiceFeatures to configure on the proxy. Supported features not in the features parameter will have their default values. - `javax.xml.ws.WebServiceFeature`

  returns: Object Proxy instance that supports the
                    specified service endpoint interface - `<T> T`

  throws: javax.xml.ws.WebServiceException - If there is an error during creation of the proxy If there is any missing WSDL metadata as required by this method If this endpointReference is invalid If an illegal serviceEndpointInterface is specified If a feature is enabled that is not compatible with this port or is unsupported."
  ([^javax.xml.ws.EndpointReference this ^java.lang.Class service-endpoint-interface ^javax.xml.ws.WebServiceFeature features]
    (-> this (.getPort service-endpoint-interface features))))

(defn to-string
  "Displays EPR infoset for debugging convenience.

  returns: a string representation of the object. - `java.lang.String`"
  ([^javax.xml.ws.EndpointReference this]
    (-> this (.toString))))

