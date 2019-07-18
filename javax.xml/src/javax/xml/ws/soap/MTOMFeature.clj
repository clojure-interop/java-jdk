(ns javax.xml.ws.soap.MTOMFeature
  "This feature represents the use of MTOM with a
  web service.

  This feature can be used during the creation of SEI proxy, and
  Dispatch instances on the client side and Endpoint
  instances on the server side. This feature cannot be used for Service
  instance creation on the client side.


  The following describes the affects of this feature with respect
  to being enabled or disabled:

    ENABLED: In this Mode, MTOM will be enabled. A receiver MUST accept
  both a non-optimized and an optimized message, and a sender MAY send an
  optimized message, or a non-optimized message. The heuristics used by a
  sender to determine whether to use optimization or not are
  implementation-specific.
    DISABLED: In this Mode, MTOM will be disabled


  The threshold property can be used to set the threshold
  value used to determine when binary data should be XOP encoded."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.xml.ws.soap MTOMFeature]))

(defn ->mtom-feature
  "Constructor.

  Creates an MTOMFeature.

  enabled - specifies if this feature should be enabled or not - `boolean`
  threshold - the size in bytes that binary data SHOULD be before being sent as an attachment. - `int`

  throws: javax.xml.ws.WebServiceException - if threshold is < 0"
  (^MTOMFeature [^Boolean enabled ^Integer threshold]
    (new MTOMFeature enabled threshold))
  (^MTOMFeature [^Boolean enabled]
    (new MTOMFeature enabled))
  (^MTOMFeature []
    (new MTOMFeature )))

(def *-id
  "Static Constant.

  Constant value identifying the MTOMFeature

  type: java.lang.String"
  MTOMFeature/ID)

(defn get-id
  "Get the unique identifier for this WebServiceFeature.

  returns: the unique identifier for this feature. - `java.lang.String`"
  (^java.lang.String [^MTOMFeature this]
    (-> this (.getID))))

(defn get-threshold
  "Gets the threshold value used to determine when binary data
   should be sent as an attachment.

  returns: the current threshold size in bytes - `int`"
  (^Integer [^MTOMFeature this]
    (-> this (.getThreshold))))

