(ns javax.xml.ws.RespectBindingFeature
  "This feature clarifies the use of the wsdl:binding
  in a JAX-WS runtime.

  This feature can be used during the creation of SEI proxy, and
  Dispatch instances on the client side and Endpoint
  instances on the server side. This feature cannot be used for Service
  instance creation on the client side.

  This feature is only useful with web services that have an
  associated WSDL. Enabling this feature requires that a JAX-WS
  implementation inspect the wsdl:binding for an
  endpoint at runtime to make sure that all wsdl:extensions
  that have the required attribute set to true
  are understood and are being used.

  The following describes the affects of this feature with respect
  to be enabled or disabled:

    ENABLED: In this Mode, a JAX-WS runtime MUST assure that all
   required wsdl:binding extensions(including policies) are
   either understood and used by the runtime, or explicitly disabled by the
   web service application. A web service can disable a particular
   extension if there is a corresponding WebServiceFeature or annotation.
   Similarly, a web service client can disable
   particular extension using the corresponding WebServiceFeature while
   creating a proxy or Dispatch instance.
   The runtime MUST also make sure that binding of
   SEI parameters/return values respect the wsdl:binding.
   With this feature enabled, if a required (wsdl:required=`true`)
   wsdl:binding extension is in the WSDL and it is not
   supported by a JAX-WS runtime and it has not
   been explicitly turned off by the web service developer, then
   that JAX-WS runtime MUST behave appropriately based on whether it is
   on the client or server:

     Client: runtime MUST throw a
   WebServiceException no sooner than when one of the methods
   above is invoked but no later than the first invocation of an endpoint
   operation.
     Server: throw a WebServiceException and the endpoint MUST fail to deploy


    DISABLED: In this Mode, an implementation may choose whether
   to inspect the wsdl:binding or not and to what degree
   the wsdl:binding will be inspected.  For example,
   one implementation may choose to behave as if this feature is enabled,
   another implementation may only choose to verify the SEI's
   parameter/return type bindings."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.xml.ws RespectBindingFeature]))

(defn ->respect-binding-feature
  "Constructor.

  Creates an RespectBindingFeature

  enabled - specifies whether this feature should be enabled or not. - `boolean`"
  ([^Boolean enabled]
    (new RespectBindingFeature enabled))
  ([]
    (new RespectBindingFeature )))

(def *-id
  "Static Constant.

  Constant value identifying the RespectBindingFeature

  type: java.lang.String"
  RespectBindingFeature/ID)

(defn get-id
  "Get the unique identifier for this WebServiceFeature.

  returns: the unique identifier for this feature. - `java.lang.String`"
  ([^javax.xml.ws.RespectBindingFeature this]
    (-> this (.getID))))

