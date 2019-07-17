(ns javax.xml.ws.spi.ServiceDelegate
  "Service delegates are used internally by Service objects
  to allow pluggability of JAX-WS implementations.

  Every Service object has its own delegate, created using
  the Provider.createServiceDelegate(java.net.URL, javax.xml.namespace.QName, java.lang.Class<? extends javax.xml.ws.Service>) method. A Service
  object delegates all of its instance methods to its delegate."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.xml.ws.spi ServiceDelegate]))

(defn create-dispatch
  "Creates a Dispatch instance for use with objects of
   the user's choosing.

  port-name - Qualified name for the target service endpoint - `javax.xml.namespace.QName`
  type - The class of object used for messages or message payloads. Implementations are required to support javax.xml.transform.Source and javax.xml.soap.SOAPMessage. - `java.lang.Class<T>`
  mode - Controls whether the created dispatch instance is message or payload oriented, i.e. whether the user will work with complete protocol messages or message payloads. E.g. when using the SOAP protocol, this parameter controls whether the user will work with SOAP messages or the contents of a SOAP body. Mode MUST be MESSAGE when type is SOAPMessage. - `javax.xml.ws.Service.Mode`
  features - A list of WebServiceFeatures to configure on the proxy. Supported features not in the features parameter will have their default values. - `javax.xml.ws.WebServiceFeature`

  returns: Dispatch instance - `<T> javax.xml.ws.Dispatch<T>`

  throws: javax.xml.ws.WebServiceException - If any error in the creation of the Dispatch object or if a feature is enabled that is not compatible with this port or is unsupported."
  ([this port-name type mode features]
    (-> this (.createDispatch port-name type mode features)))
  ([this port-name type mode]
    (-> this (.createDispatch port-name type mode))))

(defn set-handler-resolver
  "Sets the HandlerResolver for this Service
   instance.

   The handler resolver, if present, will be called once for each
   proxy or dispatch instance that is created, and the handler chain
   returned by the resolver will be set on the instance.

  handler-resolver - The HandlerResolver to use for all subsequently created proxy/dispatch objects. - `javax.xml.ws.handler.HandlerResolver`"
  ([this handler-resolver]
    (-> this (.setHandlerResolver handler-resolver))))

(defn get-executor
  "Returns the executor for this Serviceinstance.

   The executor is used for all asynchronous invocations that
   require callbacks.

  returns: The java.util.concurrent.Executor to be
           used to invoke a callback. - `java.util.concurrent.Executor`"
  ([this]
    (-> this (.getExecutor))))

(defn set-executor
  "Sets the executor for this Service instance.

   The executor is used for all asynchronous invocations that
   require callbacks.

  executor - The java.util.concurrent.Executor to be used to invoke a callback. - `java.util.concurrent.Executor`

  throws: java.lang.SecurityException - If the instance does not support setting an executor for security reasons (e.g. the necessary permissions are missing)."
  ([this executor]
    (-> this (.setExecutor executor))))

(defn get-handler-resolver
  "Returns the configured handler resolver.

  returns: HandlerResolver The HandlerResolver being
           used by this Service instance, or null
           if there isn't one. - `javax.xml.ws.handler.HandlerResolver`"
  ([this]
    (-> this (.getHandlerResolver))))

(defn get-service-name
  "Gets the name of this service.

  returns: Qualified name of this service - `javax.xml.namespace.QName`"
  ([this]
    (-> this (.getServiceName))))

(defn get-port
  "The getPort method returns a proxy. A service client
   uses this proxy to invoke operations on the target
   service endpoint. The serviceEndpointInterface
   specifies the service endpoint interface that is supported by
   the created dynamic proxy instance.

  port-name - Qualified name of the service endpoint in the WSDL service description - `javax.xml.namespace.QName`
  service-endpoint-interface - Service endpoint interface supported by the dynamic proxy or instance - `java.lang.Class<T>`
  features - A list of WebServiceFeatures to configure on the proxy. Supported features not in the features parameter will have their default values. - `javax.xml.ws.WebServiceFeature`

  returns: Object Proxy instance that
                  supports the specified service endpoint
                  interface - `<T> T`

  throws: javax.xml.ws.WebServiceException - This exception is thrown in the following cases: If there is an error in creation of the proxy If there is any missing WSDL metadata as required by this method If an illegal serviceEndpointInterface or portName is specified If a feature is enabled that is not compatible with this port or is unsupported."
  ([this port-name service-endpoint-interface features]
    (-> this (.getPort port-name service-endpoint-interface features)))
  ([this port-name service-endpoint-interface]
    (-> this (.getPort port-name service-endpoint-interface)))
  ([this service-endpoint-interface]
    (-> this (.getPort service-endpoint-interface))))

(defn get-wsdl-document-location
  "Gets the location of the WSDL document for this Service.

  returns: URL for the location of the WSDL document for
           this service - `java.net.URL`"
  ([this]
    (-> this (.getWSDLDocumentLocation))))

(defn get-ports
  "Returns an Iterator for the list of
   QNames of service endpoints grouped by this
   service

  returns: Returns java.util.Iterator with elements
           of type javax.xml.namespace.QName - `java.util.Iterator<javax.xml.namespace.QName>`

  throws: javax.xml.ws.WebServiceException - If this Service class does not have access to the required WSDL metadata"
  ([this]
    (-> this (.getPorts))))

(defn add-port
  "Creates a new port for the service. Ports created in this way contain
   no WSDL port type information and can only be used for creating
   Dispatchinstances.

  port-name - Qualified name for the target service endpoint - `javax.xml.namespace.QName`
  binding-id - A URI identifier of a binding. - `java.lang.String`
  endpoint-address - Address of the target service endpoint as a URI - `java.lang.String`

  throws: javax.xml.ws.WebServiceException - If any error in the creation of the port"
  ([this port-name binding-id endpoint-address]
    (-> this (.addPort port-name binding-id endpoint-address))))

