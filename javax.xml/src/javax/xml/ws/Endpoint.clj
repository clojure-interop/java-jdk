(ns javax.xml.ws.Endpoint
  "A Web service endpoint.

  Endpoints are created using the static methods defined in this
  class. An endpoint is always tied to one Binding
  and one implementor, both set at endpoint creation time.

  An endpoint is either in a published or an unpublished state.
  The publish methods can be used to start publishing
  an endpoint, at which point it starts accepting incoming requests.
  Conversely, the stop method can be used to stop
  accepting incoming requests and take the endpoint down.
  Once stopped, an endpoint cannot be published again.

  An Executor may be set on the endpoint in order
  to gain better control over the threads used to dispatch incoming
  requests. For instance, thread pooling with certain parameters
  can be enabled by creating a ThreadPoolExecutor and
  registering it with the endpoint.

  Handler chains can be set using the contained Binding.

  An endpoint may have a list of metadata documents, such as WSDL
  and XMLSchema documents, bound to it. At publishing time, the
  JAX-WS implementation will try to reuse as much of that metadata
  as possible instead of generating new ones based on the annotations
  present on the implementor."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.xml.ws Endpoint]))

(defn ->endpoint
  "Constructor."
  ([]
    (new Endpoint )))

(def *-wsdl-service
  "Static Constant.

  Standard property: name of WSDL service.
    Type: javax.xml.namespace.QName

  type: java.lang.String"
  Endpoint/WSDL_SERVICE)

(def *-wsdl-port
  "Static Constant.

  Standard property: name of WSDL port.
    Type: javax.xml.namespace.QName

  type: java.lang.String"
  Endpoint/WSDL_PORT)

(defn *create
  "Creates an endpoint with the specified binding type,
   implementor object, and web service features.

   The newly created endpoint may be published by calling
   one of the publish(String) and
   publish(Object) methods.

  binding-id - A URI specifying the binding to use. If the bindingID is null and no binding is specified via a BindingType annotation then a default SOAP 1.1 / HTTP binding MUST be used. - `java.lang.String`
  implementor - The endpoint implementor. - `java.lang.Object`
  features - A list of WebServiceFeature to configure on the endpoint. Supported features not in the features parameter will have their default values. - `javax.xml.ws.WebServiceFeature`

  returns: The newly created endpoint. - `javax.xml.ws.Endpoint`"
  (^javax.xml.ws.Endpoint [^java.lang.String binding-id ^java.lang.Object implementor ^javax.xml.ws.WebServiceFeature features]
    (Endpoint/create binding-id implementor features))
  (^javax.xml.ws.Endpoint [^java.lang.Object implementor ^javax.xml.ws.WebServiceFeature features]
    (Endpoint/create implementor features))
  (^javax.xml.ws.Endpoint [^java.lang.Object implementor]
    (Endpoint/create implementor)))

(defn *publish
  "Creates and publishes an endpoint for the specified implementor
   object at the given address. The created endpoint is configured
   with the web service features.

   The necessary server infrastructure will be created and
   configured by the JAX-WS implementation using some default configuration.

   In order to get more control over the server configuration, please
   use the create(String,Object) and
   publish(Object) methods instead.

  address - A URI specifying the address and transport/protocol to use. A http: URI MUST result in the SOAP 1.1/HTTP binding being used. Implementations may support other URI schemes. - `java.lang.String`
  implementor - The endpoint implementor. - `java.lang.Object`
  features - A list of WebServiceFeature to configure on the endpoint. Supported features not in the features parameter will have their default values. - `javax.xml.ws.WebServiceFeature`

  returns: The newly created endpoint. - `javax.xml.ws.Endpoint`

  throws: java.lang.SecurityException - If a java.lang.SecurityManger is being used and the application doesn't have the WebServicePermission(`publishEndpoint`) permission."
  (^javax.xml.ws.Endpoint [^java.lang.String address ^java.lang.Object implementor ^javax.xml.ws.WebServiceFeature features]
    (Endpoint/publish address implementor features))
  (^javax.xml.ws.Endpoint [^java.lang.String address ^java.lang.Object implementor]
    (Endpoint/publish address implementor)))

(defn stop
  "Stops publishing this endpoint.

   If the endpoint is not in a published state, this method
   has no effect."
  ([^javax.xml.ws.Endpoint this]
    (-> this (.stop))))

(defn get-implementor
  "Returns the implementation object for this endpoint.

  returns: The implementor for this endpoint - `java.lang.Object`"
  (^java.lang.Object [^javax.xml.ws.Endpoint this]
    (-> this (.getImplementor))))

(defn get-executor
  "Returns the executor for this Endpointinstance.

   The executor is used to dispatch an incoming request to
   the implementor object.

  returns: The java.util.concurrent.Executor to be
           used to dispatch a request. - `java.util.concurrent.Executor`"
  (^java.util.concurrent.Executor [^javax.xml.ws.Endpoint this]
    (-> this (.getExecutor))))

(defn set-executor
  "Sets the executor for this Endpoint instance.

   The executor is used to dispatch an incoming request to
   the implementor object.

   If this Endpoint is published using the
   publish(Object) method and the specified server
   context defines its own threading behavior, the executor
   may be ignored.

  executor - The java.util.concurrent.Executor to be used to dispatch a request. - `java.util.concurrent.Executor`

  throws: java.lang.SecurityException - If the instance does not support setting an executor for security reasons (e.g. the necessary permissions are missing)."
  ([^javax.xml.ws.Endpoint this ^java.util.concurrent.Executor executor]
    (-> this (.setExecutor executor))))

(defn get-binding
  "Returns the binding for this endpoint.

  returns: The binding for this endpoint - `javax.xml.ws.Binding`"
  (^javax.xml.ws.Binding [^javax.xml.ws.Endpoint this]
    (-> this (.getBinding))))

(defn get-properties
  "Returns the property bag for this Endpoint instance.

  returns: Map<String,Object> The property bag
           associated with this instance. - `java.util.Map<java.lang.String,java.lang.Object>`"
  (^java.util.Map [^javax.xml.ws.Endpoint this]
    (-> this (.getProperties))))

(defn get-endpoint-reference
  "Returns the EndpointReference associated with
   this Endpoint instance.

  clazz - Specifies the type of EndpointReference that MUST be returned. - `java.lang.Class<T>`
  reference-parameters - Reference parameters to be associated with the returned EndpointReference instance. - `org.w3c.dom.Element`

  returns: EndpointReference of type clazz of this
   Endpoint instance.
   If the returned EndpointReference is of type
   W3CEndpointReference then it MUST contain the
   the specified referenceParameters. - `<T extends javax.xml.ws.EndpointReference> T`

  throws: javax.xml.ws.WebServiceException - If any error in the creation of the EndpointReference or if the Endpoint is not in the published state or if the clazz is not a supported EndpointReference type."
  ([^javax.xml.ws.Endpoint this ^java.lang.Class clazz ^org.w3c.dom.Element reference-parameters]
    (-> this (.getEndpointReference clazz reference-parameters)))
  (^javax.xml.ws.EndpointReference [^javax.xml.ws.Endpoint this ^org.w3c.dom.Element reference-parameters]
    (-> this (.getEndpointReference reference-parameters))))

(defn publish
  "Publishes this endpoint at the given address.
   The necessary server infrastructure will be created and
   configured by the JAX-WS implementation using some default configuration.
   In order to get more control over the server configuration, please
   use the publish(Object) method instead.

  address - A URI specifying the address to use. The address MUST be compatible with the binding specified at the time the endpoint was created. - `java.lang.String`

  throws: java.lang.IllegalArgumentException - If the provided address URI is not usable in conjunction with the endpoint's binding."
  ([^javax.xml.ws.Endpoint this ^java.lang.String address]
    (-> this (.publish address))))

(defn set-properties
  "Sets the property bag for this Endpoint instance.

  properties - The property bag associated with this instance. - `java.util.Map<java.lang.String,java.lang.Object>`"
  ([^javax.xml.ws.Endpoint this ^java.util.Map properties]
    (-> this (.setProperties properties))))

(defn get-metadata
  "Returns a list of metadata documents for the service.

  returns: List<javax.xml.transform.Source> A list of metadata documents for the service - `java.util.List<javax.xml.transform.Source>`"
  (^java.util.List [^javax.xml.ws.Endpoint this]
    (-> this (.getMetadata))))

(defn published?
  "Returns true if the endpoint is in the published state.

  returns: true if the endpoint is in the published state. - `boolean`"
  (^Boolean [^javax.xml.ws.Endpoint this]
    (-> this (.isPublished))))

(defn set-endpoint-context
  "By settng a EndpointContext, JAX-WS runtime knows about
   addresses of other endpoints in an application. If multiple endpoints
   share different ports of a WSDL, then the multiple port addresses
   are patched when the WSDL is accessed.


   This needs to be set before publishing the endpoints.

  ctxt - that is shared for multiple endpoints - `javax.xml.ws.EndpointContext`

  throws: java.lang.IllegalStateException - If the endpoint has been published already or it has been stopped."
  ([^javax.xml.ws.Endpoint this ^javax.xml.ws.EndpointContext ctxt]
    (-> this (.setEndpointContext ctxt))))

(defn set-metadata
  "Sets the metadata for this endpoint.

  metadata - A list of XML document sources containing metadata information for the endpoint (e.g. WSDL or XML Schema documents) - `java.util.List<javax.xml.transform.Source>`

  throws: java.lang.IllegalStateException - If the endpoint has already been published."
  ([^javax.xml.ws.Endpoint this ^java.util.List metadata]
    (-> this (.setMetadata metadata))))

