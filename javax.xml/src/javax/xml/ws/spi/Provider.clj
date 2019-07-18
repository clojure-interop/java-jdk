(ns javax.xml.ws.spi.Provider
  "Service provider for ServiceDelegate and
  Endpoint objects."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.xml.ws.spi Provider]))

(def *-jaxwsprovider-property
  "Static Constant.

  A constant representing the property used to lookup the
   name of a Provider implementation
   class.

  type: java.lang.String"
  Provider/JAXWSPROVIDER_PROPERTY)

(defn *provider
  "Creates a new provider object.

   The algorithm used to locate the provider subclass to use consists
   of the following steps:



     If a resource with the name of
     META-INF/services/javax.xml.ws.spi.Provider
     exists, then its first line, if present, is used as the UTF-8 encoded
     name of the implementation class.


     If the $java.home/lib/jaxws.properties file exists and it is readable by
     the java.util.Properties.load(InputStream) method and it contains
     an entry whose key is javax.xml.ws.spi.Provider, then the value of
     that entry is used as the name of the implementation class.


     If a system property with the name javax.xml.ws.spi.Provider
     is defined, then its value is used as the name of the implementation class.


     Finally, a default implementation class name is used.

  returns: `javax.xml.ws.spi.Provider`"
  (^javax.xml.ws.spi.Provider []
    (Provider/provider )))

(defn create-service-delegate
  "Creates a service delegate object.

  wsdl-document-location - A URL pointing to the WSDL document for the service, or null if there isn't one. - `java.net.URL`
  service-name - The qualified name of the service. - `javax.xml.namespace.QName`
  service-class - The service class, which MUST be either javax.xml.ws.Service or a subclass thereof. - `java.lang.Class`
  features - Web Service features that must be configured on the service. If the provider doesn't understand a feature, it must throw a WebServiceException. - `javax.xml.ws.WebServiceFeature`

  returns: The newly created service delegate. - `javax.xml.ws.spi.ServiceDelegate`"
  (^javax.xml.ws.spi.ServiceDelegate [^Provider this ^java.net.URL wsdl-document-location ^javax.xml.namespace.QName service-name ^java.lang.Class service-class ^javax.xml.ws.WebServiceFeature features]
    (-> this (.createServiceDelegate wsdl-document-location service-name service-class features)))
  (^javax.xml.ws.spi.ServiceDelegate [^Provider this ^java.net.URL wsdl-document-location ^javax.xml.namespace.QName service-name ^java.lang.Class service-class]
    (-> this (.createServiceDelegate wsdl-document-location service-name service-class))))

(defn create-endpoint
  "Creates an endpoint object with the provided binding, implementation
   class, invoker and web service features. Containers typically use
   this to create Endpoint objects. Provider
   implementations must override the default implementation.

  binding-id - A URI specifying the desired binding (e.g. SOAP/HTTP). Can be null. - `java.lang.String`
  implementor-class - A service implementation class that MUST be annotated with all the necessary Web service annotations. - `java.lang.Class`
  invoker - that does the actual invocation on the service instance. - `javax.xml.ws.spi.Invoker`
  features - A list of WebServiceFeatures to configure on the endpoint. Supported features not in the features parameter will have their default values. - `javax.xml.ws.WebServiceFeature`

  returns: The newly created endpoint. - `javax.xml.ws.Endpoint`"
  (^javax.xml.ws.Endpoint [^Provider this ^java.lang.String binding-id ^java.lang.Class implementor-class ^javax.xml.ws.spi.Invoker invoker ^javax.xml.ws.WebServiceFeature features]
    (-> this (.createEndpoint binding-id implementor-class invoker features)))
  (^javax.xml.ws.Endpoint [^Provider this ^java.lang.String binding-id ^java.lang.Object implementor ^javax.xml.ws.WebServiceFeature features]
    (-> this (.createEndpoint binding-id implementor features)))
  (^javax.xml.ws.Endpoint [^Provider this ^java.lang.String binding-id ^java.lang.Object implementor]
    (-> this (.createEndpoint binding-id implementor))))

(defn create-and-publish-endpoint
  "Creates and publishes an endpoint object with the specified
   address, implementation object and web service features.
   Provider implementations must override the
   default implementation.

  address - A URI specifying the address and transport/protocol to use. A http: URI MUST result in the SOAP 1.1/HTTP binding being used. Implementations may support other URI schemes. - `java.lang.String`
  implementor - A service implementation object to which incoming requests will be dispatched. The corresponding class MUST be annotated with all the necessary Web service annotations. - `java.lang.Object`
  features - A list of WebServiceFeatures to configure on the endpoint. Supported features not in the features parameter will have their default values. - `javax.xml.ws.WebServiceFeature`

  returns: The newly created endpoint. - `javax.xml.ws.Endpoint`"
  (^javax.xml.ws.Endpoint [^Provider this ^java.lang.String address ^java.lang.Object implementor ^javax.xml.ws.WebServiceFeature features]
    (-> this (.createAndPublishEndpoint address implementor features)))
  (^javax.xml.ws.Endpoint [^Provider this ^java.lang.String address ^java.lang.Object implementor]
    (-> this (.createAndPublishEndpoint address implementor))))

(defn read-endpoint-reference
  "read an EndpointReference from the infoset contained in
   eprInfoset.

  epr-infoset - infoset for EndpointReference - `javax.xml.transform.Source`

  returns: the EndpointReference unmarshalled from
   eprInfoset.  This method never returns null. - `javax.xml.ws.EndpointReference`

  throws: javax.xml.ws.WebServiceException - If there is an error creating the EndpointReference from the specified eprInfoset."
  (^javax.xml.ws.EndpointReference [^Provider this ^javax.xml.transform.Source epr-infoset]
    (-> this (.readEndpointReference epr-infoset))))

(defn get-port
  "The getPort method returns a proxy.  If there
   are any reference parameters in the
   endpointReference, then those reference
   parameters MUST appear as SOAP headers, indicating them to be
   reference parameters, on all messages sent to the endpoint.
   The parameter  serviceEndpointInterface specifies
   the service endpoint interface that is supported by the
   returned proxy.
   The parameter endpointReference specifies the
   endpoint that will be invoked by the returned proxy.
   In the implementation of this method, the JAX-WS
   runtime system takes the responsibility of selecting a protocol
   binding (and a port) and configuring the proxy accordingly from
   the WSDL metadata of the
   serviceEndpointInterface and the EndpointReference.
   For this method
   to successfully return a proxy, WSDL metadata MUST be available and the
   endpointReference MUST contain an implementation understood
   serviceName metadata.

  endpoint-reference - the EndpointReference that will be invoked by the returned proxy. - `javax.xml.ws.EndpointReference`
  service-endpoint-interface - Service endpoint interface - `java.lang.Class`
  features - A list of WebServiceFeatures to configure on the proxy. Supported features not in the features parameter will have their default values. - `javax.xml.ws.WebServiceFeature`

  returns: Object Proxy instance that supports the
                    specified service endpoint interface - `<T> T`

  throws: javax.xml.ws.WebServiceException - If there is an error during creation of the proxy If there is any missing WSDL metadata as required by this method} If this endpointReference is illegal If an illegal serviceEndpointInterface is specified If a feature is enabled that is not compatible with this port or is unsupported."
  ([^Provider this ^javax.xml.ws.EndpointReference endpoint-reference ^java.lang.Class service-endpoint-interface ^javax.xml.ws.WebServiceFeature features]
    (-> this (.getPort endpoint-reference service-endpoint-interface features))))

(defn create-w-3-c-endpoint-reference
  "Factory method to create a W3CEndpointReference.
   Using this method, a W3CEndpointReference instance
   can be created with extension elements, and attributes.
   Provider implementations must override the default
   implementation.


   This method can be used to create a W3CEndpointReference
   for any endpoint by specifying the address property along
   with any other desired properties.  This method
   can also be used to create a W3CEndpointReference for
   an endpoint that is published by the same Java EE application.
   To do so the address property can be provided or this
   method can automatically determine the address of
   an endpoint that is published by the same Java EE application and is
   identified by the serviceName and
   portName propeties.  If the address is
   null and the serviceName and
   portName do not identify an endpoint published by the
   same Java EE application, a
   javax.lang.IllegalStateException MUST be thrown.

  address - Specifies the address of the target endpoint - `java.lang.String`
  interface-name - the wsam:InterfaceName element in the wsa:Metadata element. - `javax.xml.namespace.QName`
  service-name - Qualified name of the service in the WSDL. - `javax.xml.namespace.QName`
  port-name - Qualified name of the endpoint in the WSDL. - `javax.xml.namespace.QName`
  metadata - A list of elements that should be added to the W3CEndpointReference instances wsa:metadata element. - `java.util.List`
  wsdl-document-location - URL for the WSDL document location for the service. - `java.lang.String`
  reference-parameters - Reference parameters to be associated with the returned EndpointReference instance. - `java.util.List`
  elements - extension elements to be associated with the returned EndpointReference instance. - `java.util.List`
  attributes - extension attributes to be associated with the returned EndpointReference instance. - `java.util.Map`

  returns: the W3CEndpointReference created from
            serviceName, portName,
            metadata, wsdlDocumentLocation
            and referenceParameters. This method
            never returns null. - `javax.xml.ws.wsaddressing.W3CEndpointReference`

  throws: java.lang.IllegalStateException - If the address, serviceName and portName are all null. If the serviceName service is null and the portName is NOT null. If the address property is null and the serviceName and portName do not specify a valid endpoint published by the same Java EE application. If the serviceNameis NOT null and is not present in the specified WSDL. If the portName port is not null and it is not present in serviceName service in the WSDL. If the wsdlDocumentLocation is NOT null and does not represent a valid WSDL. If the wsdlDocumentLocation is NOT null but wsdli:wsdlLocation's namespace name cannot be got from the available metadata."
  (^javax.xml.ws.wsaddressing.W3CEndpointReference [^Provider this ^java.lang.String address ^javax.xml.namespace.QName interface-name ^javax.xml.namespace.QName service-name ^javax.xml.namespace.QName port-name ^java.util.List metadata ^java.lang.String wsdl-document-location ^java.util.List reference-parameters ^java.util.List elements ^java.util.Map attributes]
    (-> this (.createW3CEndpointReference address interface-name service-name port-name metadata wsdl-document-location reference-parameters elements attributes)))
  (^javax.xml.ws.wsaddressing.W3CEndpointReference [^Provider this ^java.lang.String address ^javax.xml.namespace.QName service-name ^javax.xml.namespace.QName port-name ^java.util.List metadata ^java.lang.String wsdl-document-location ^java.util.List reference-parameters]
    (-> this (.createW3CEndpointReference address service-name port-name metadata wsdl-document-location reference-parameters))))

