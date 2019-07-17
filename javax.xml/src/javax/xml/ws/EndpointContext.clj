(ns javax.xml.ws.EndpointContext
  "EndpointContext allows multiple endpoints in an application
  to share any information. For example, servlet application's war may
  contain multiple endpoints and these endpoints can get addresses of each
  other by sharing this context. If multiple endpoints share different
  ports of a WSDL, then the multiple port addresses can be patched
  when the WSDL is accessed. It also allows all endpoints to share any
  other runtime information.


  This needs to be set by using Endpoint.setEndpointContext(javax.xml.ws.EndpointContext)
  before Endpoint.publish(java.lang.String) methods."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.xml.ws EndpointContext]))

(defn ->endpoint-context
  "Constructor."
  ([]
    (new EndpointContext )))

(defn get-endpoints
  "This gives list of endpoints in an application. For e.g in
   servlet container, a war file may contain multiple endpoints.
   In case of http, these endpoints are hosted on the same http
   server.

  returns: list of all endpoints in an application - `java.util.Set<javax.xml.ws.Endpoint>`"
  ([this]
    (-> this (.getEndpoints))))

