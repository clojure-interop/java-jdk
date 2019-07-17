(ns javax.xml.ws.soap.AddressingFeature
  "AddressingFeature represents the use of WS-Addressing with either
  the SOAP 1.1/HTTP or SOAP 1.2/HTTP binding. Using this feature
  with any other binding is undefined.

  This feature can be used during the creation of SEI proxy, and
  Dispatch instances on the client side and Endpoint
  instances on the server side. This feature cannot be used for Service
  instance creation on the client side.

  The following describes the effects of this feature with respect
  to be enabled or disabled:

    ENABLED: In this Mode, WS-Addressing will be enabled. It means
        the endpoint supports WS-Addressing but does not require its use.
        A sender could send messages with WS-Addressing headers or without
        WS-Addressing headers. But a receiver MUST consume both types of
        messages.
    DISABLED: In this Mode, WS-Addressing will be disabled.
        At runtime, WS-Addressing headers MUST NOT be used by a sender or
        receiver.


  If the feature is enabled, the required property determines
  whether the endpoint requires WS-Addressing. If it is set true,
  WS-Addressing headers MUST be present on incoming and outgoing messages.
  By default the required property is false.


  If the web service developer has not explicitly enabled this feature,
  WSDL's wsam:Addressing policy assertion is used to find
  the use of WS-Addressing. By using the feature explicitly, an application
  overrides WSDL's indication of the use of WS-Addressing. In some cases,
  this is really required. For example, if an application has implemented
  WS-Addressing itself, it can use this feature to disable addressing. That
  means a JAX-WS implementation doesn't consume or produce WS-Addressing
  headers.


  If addressing is enabled, a corresponding wsam:Addressing policy assertion
  must be generated in the WSDL as per

  3.1 WS-Policy Assertions


  Example 1: Possible Policy Assertion in the generated WSDL for
  @Addressing


    <wsam:Addressing wsp:Optional=`true`>
      <wsp:Policy/>
    </wsam:Addressing>


  Example 2: Possible Policy Assertion in the generated WSDL for
  @Addressing(required=true)


    <wsam:Addressing>
      <wsp:Policy/>
    </wsam:Addressing>


  Example 3: Possible Policy Assertion in the generated WSDL for
  @Addressing(required=true, responses=Responses.ANONYMOUS)


    <wsam:Addressing>
       <wsp:Policy>
         <wsam:AnonymousResponses/>
       </wsp:Policy>
    </wsam:Addressing>


  See
  Web Services Addressing - Core,

  Web Services Addressing 1.0 - SOAP Binding,
  and
  Web Services Addressing 1.0 - Metadata
  for more information on WS-Addressing."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.xml.ws.soap AddressingFeature]))

(defn ->addressing-feature
  "Constructor.

  Creates and configures an AddressingFeature with the
   use of addressing requirements. If enabled and
   required are true, it enables ws-addressing and
   requires its use. Also, the response types can be configured using
   responses parameter.

  enabled - true enables ws-addressing i.e.ws-addressing is supported but doesn't require its use - `boolean`
  required - true means requires the use of ws-addressing . - `boolean`
  responses - specifies what type of responses are required - `javax.xml.ws.soap.AddressingFeature.Responses`"
  ([^Boolean enabled ^Boolean required ^javax.xml.ws.soap.AddressingFeature.Responses responses]
    (new AddressingFeature enabled required responses))
  ([^Boolean enabled ^Boolean required]
    (new AddressingFeature enabled required))
  ([^Boolean enabled]
    (new AddressingFeature enabled))
  ([]
    (new AddressingFeature )))

(def *-id
  "Static Constant.

  Constant value identifying the AddressingFeature

  type: java.lang.String"
  AddressingFeature/ID)

(defn get-id
  "Get the unique identifier for this WebServiceFeature.

  returns: the unique identifier for this feature. - `java.lang.String`"
  (^java.lang.String [^javax.xml.ws.soap.AddressingFeature this]
    (-> this (.getID))))

(defn required?
  "If addressing is enabled, this property determines whether the endpoint
   requires WS-Addressing. If required is true, WS-Addressing headers MUST
   be present on incoming and outgoing messages.

  returns: the current required value - `boolean`"
  (^Boolean [^javax.xml.ws.soap.AddressingFeature this]
    (-> this (.isRequired))))

(defn get-responses
  "If addressing is enabled, this property determines whether endpoint
   requires the use of anonymous responses, or non-anonymous responses,
   or all responses.

  returns: AddressingFeature.Responses.ALL when endpoint supports all types of
   responses,
           AddressingFeature.Responses.ANONYMOUS when endpoint requires the use of
   only anonymous responses,
           AddressingFeature.Responses.NON_ANONYMOUS when endpoint requires the use
   of only non-anonymous responses - `javax.xml.ws.soap.AddressingFeature.Responses`"
  (^javax.xml.ws.soap.AddressingFeature.Responses [^javax.xml.ws.soap.AddressingFeature this]
    (-> this (.getResponses))))

