(ns javax.xml.ws.spi.http.HttpContext
  "HttpContext represents a mapping between the root URI path of a web
  service to a HttpHandler which is invoked to handle requests
  destined for that path on the associated container.

  Container provides the implementation for this and it matches
  web service requests to corresponding HttpContext objects."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.xml.ws.spi.http HttpContext]))

(defn ->http-context
  "Constructor."
  ([]
    (new HttpContext )))

(defn set-handler
  "JAX-WS runtime sets its handler during
   Endpoint.publish(HttpContext) to handle
   HTTP requests for this context. Container or its extensions
   use this handler to process the requests.

  handler - the handler to set for this context - `javax.xml.ws.spi.http.HttpHandler`"
  ([^javax.xml.ws.spi.http.HttpContext this ^javax.xml.ws.spi.http.HttpHandler handler]
    (-> this (.setHandler handler))))

(defn get-path
  "Returns the path for this context. This path uniquely identifies
   an endpoint inside an application and the path is relative to
   application's context path. Container should give this
   path based on how it matches request URIs to this HttpContext object.


   For servlet container, this is typically a url-pattern for an endpoint.


   Endpoint's address for this context can be computed as follows:


    HttpExchange exch = ...;
    String endpointAddress =
        exch.getScheme()  `://`
         exch.getLocalAddress().getHostName()
         `:`  exch.getLocalAddress().getPort()
         exch.getContextPath()  getPath();

  returns: this context's path - `java.lang.String`"
  (^java.lang.String [^javax.xml.ws.spi.http.HttpContext this]
    (-> this (.getPath))))

(defn get-attribute
  "Returns an attribute value for container's configuration
   and other data that can be used by jax-ws runtime.

  name - attribute name - `java.lang.String`

  returns: attribute value - `java.lang.Object`"
  (^java.lang.Object [^javax.xml.ws.spi.http.HttpContext this ^java.lang.String name]
    (-> this (.getAttribute name))))

(defn get-attribute-names
  "Returns all attribute names for container's configuration
   and other data that can be used by jax-ws runtime.

  returns: set of all attribute names - `java.util.Set<java.lang.String>`"
  (^java.util.Set [^javax.xml.ws.spi.http.HttpContext this]
    (-> this (.getAttributeNames))))

