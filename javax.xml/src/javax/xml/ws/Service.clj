(ns javax.xml.ws.Service
  "Service objects provide the client view of a Web service.
  Service acts as a factory of the following:

  Proxies for a target service endpoint.
  Instances of Dispatch for
      dynamic message-oriented invocation of a remote
      operation.



  The ports available on a service can be enumerated using the
  getPorts method. Alternatively, you can pass a
  service endpoint interface to the unary getPort method
  and let the runtime select a compatible port.

  Handler chains for all the objects created by a Service
  can be set by means of a HandlerResolver.

  An Executor may be set on the service in order
  to gain better control over the threads used to dispatch asynchronous
  callbacks. For instance, thread pooling with certain parameters
  can be enabled by creating a ThreadPoolExecutor and
  registering it with the service."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.xml.ws Service]))

(defn *create
  "Creates a Service instance. The created instance is
   configured with the web service features.

   The specified WSDL document location and service qualified name MUST
   uniquely identify a wsdl:service element.

  wsdl-document-location - URL for the WSDL document location for the service - `java.net.URL`
  service-name - QName for the service - `javax.xml.namespace.QName`
  features - Web Service features that must be configured on the service. If the provider doesn't understand a feature, it must throw a WebServiceException. - `javax.xml.ws.WebServiceFeature`

  returns: `javax.xml.ws.Service`

  throws: javax.xml.ws.WebServiceException - If any error in creation of the specified service."
  (^javax.xml.ws.Service [^java.net.URL wsdl-document-location ^javax.xml.namespace.QName service-name ^javax.xml.ws.WebServiceFeature features]
    (Service/create wsdl-document-location service-name features))
  (^javax.xml.ws.Service [^java.net.URL wsdl-document-location ^javax.xml.namespace.QName service-name]
    (Service/create wsdl-document-location service-name))
  (^javax.xml.ws.Service [^javax.xml.namespace.QName service-name]
    (Service/create service-name)))

(defn create-dispatch
  "Creates a Dispatch instance for use with objects of
   the client's choosing.

  port-name - Qualified name for the target service endpoint - `javax.xml.namespace.QName`
  type - The class of object used for messages or message payloads. Implementations are required to support javax.xml.transform.Source and javax.xml.soap.SOAPMessage. - `java.lang.Class`
  mode - Controls whether the created dispatch instance is message or payload oriented, i.e. whether the client will work with complete protocol messages or message payloads. E.g. when using the SOAP protocol, this parameter controls whether the client will work with SOAP messages or the contents of a SOAP body. Mode MUST be MESSAGE when type is SOAPMessage. - `javax.xml.ws.Service$Mode`
  features - A list of WebServiceFeatures to configure on the proxy. Supported features not in the features parameter will have their default values. - `javax.xml.ws.WebServiceFeature`

  returns: Dispatch instance. - `<T> javax.xml.ws.Dispatch<T>`

  throws: javax.xml.ws.WebServiceException - If any error in the creation of the Dispatch object or if a feature is enabled that is not compatible with this port or is unsupported."
  ([^Service this ^javax.xml.namespace.QName port-name ^java.lang.Class type ^javax.xml.ws.Service$Mode mode ^javax.xml.ws.WebServiceFeature features]
    (-> this (.createDispatch port-name type mode features)))
  ([^Service this ^javax.xml.namespace.QName port-name ^java.lang.Class type ^javax.xml.ws.Service$Mode mode]
    (-> this (.createDispatch port-name type mode))))

(defn set-handler-resolver
  "Sets the HandlerResolver for this Service
   instance.

   The handler resolver, if present, will be called once for each
   proxy or dispatch instance that is created, and the handler chain
   returned by the resolver will be set on the instance.

  handler-resolver - The HandlerResolver to use for all subsequently created proxy/dispatch objects. - `javax.xml.ws.handler.HandlerResolver`"
  ([^Service this ^javax.xml.ws.handler.HandlerResolver handler-resolver]
    (-> this (.setHandlerResolver handler-resolver))))

(defn get-executor
  "Returns the executor for this Serviceinstance.

   The executor is used for all asynchronous invocations that
   require callbacks.

  returns: The java.util.concurrent.Executor to be
           used to invoke a callback. - `java.util.concurrent.Executor`"
  (^java.util.concurrent.Executor [^Service this]
    (-> this (.getExecutor))))

(defn set-executor
  "Sets the executor for this Service instance.

   The executor is used for all asynchronous invocations that
   require callbacks.

  executor - The java.util.concurrent.Executor to be used to invoke a callback. - `java.util.concurrent.Executor`

  throws: java.lang.SecurityException - If the instance does not support setting an executor for security reasons (e.g. the necessary permissions are missing)."
  ([^Service this ^java.util.concurrent.Executor executor]
    (-> this (.setExecutor executor))))

(defn get-handler-resolver
  "Returns the configured handler resolver.

  returns: HandlerResolver The HandlerResolver being
           used by this Service instance, or null
           if there isn't one. - `javax.xml.ws.handler.HandlerResolver`"
  (^javax.xml.ws.handler.HandlerResolver [^Service this]
    (-> this (.getHandlerResolver))))

(defn get-service-name
  "Gets the name of this service.

  returns: Qualified name of this service - `javax.xml.namespace.QName`"
  (^javax.xml.namespace.QName [^Service this]
    (-> this (.getServiceName))))

(defn get-port
  "The getPort method returns a proxy. A service client
   uses this proxy to invoke operations on the target
   service endpoint. The serviceEndpointInterface
   specifies the service endpoint interface that is supported by
   the created dynamic proxy instance.

  port-name - Qualified name of the service endpoint in the WSDL service description. - `javax.xml.namespace.QName`
  service-endpoint-interface - Service endpoint interface supported by the dynamic proxy instance. - `java.lang.Class`
  features - A list of WebServiceFeatures to configure on the proxy. Supported features not in the features parameter will have their default values. - `javax.xml.ws.WebServiceFeature`

  returns: Object Proxy instance that
                  supports the specified service endpoint
                  interface. - `<T> T`

  throws: javax.xml.ws.WebServiceException - This exception is thrown in the following cases: If there is an error in creation of the proxy. If there is any missing WSDL metadata as required by this method. If an illegal serviceEndpointInterface or portName is specified. If a feature is enabled that is not compatible with this port or is unsupported."
  ([^Service this ^javax.xml.namespace.QName port-name ^java.lang.Class service-endpoint-interface ^javax.xml.ws.WebServiceFeature features]
    (-> this (.getPort port-name service-endpoint-interface features)))
  ([^Service this ^javax.xml.namespace.QName port-name ^java.lang.Class service-endpoint-interface]
    (-> this (.getPort port-name service-endpoint-interface)))
  ([^Service this ^java.lang.Class service-endpoint-interface]
    (-> this (.getPort service-endpoint-interface))))

(defn get-wsdl-document-location
  "Gets the location of the WSDL document for this Service.

  returns: URL for the location of the WSDL document for
           this service. - `java.net.URL`"
  (^java.net.URL [^Service this]
    (-> this (.getWSDLDocumentLocation))))

(defn get-ports
  "Returns an Iterator for the list of
   QNames of service endpoints grouped by this
   service

  returns: Returns java.util.Iterator with elements
           of type javax.xml.namespace.QName. - `java.util.Iterator<javax.xml.namespace.QName>`

  throws: javax.xml.ws.WebServiceException - If this Service class does not have access to the required WSDL metadata."
  (^java.util.Iterator [^Service this]
    (-> this (.getPorts))))

(defn add-port
  "Creates a new port for the service. Ports created in this way contain
   no WSDL port type information and can only be used for creating
   Dispatchinstances.

  port-name - Qualified name for the target service endpoint. - `javax.xml.namespace.QName`
  binding-id - A String identifier of a binding. - `java.lang.String`
  endpoint-address - Address of the target service endpoint as a URI. - `java.lang.String`

  throws: javax.xml.ws.WebServiceException - If any error in the creation of the port."
  ([^Service this ^javax.xml.namespace.QName port-name ^java.lang.String binding-id ^java.lang.String endpoint-address]
    (-> this (.addPort port-name binding-id endpoint-address))))

