(ns javax.xml.ws.spi.http.HttpHandler
  "A handler which is invoked to process HTTP requests.

  JAX-WS runtime provides the implementation for this and sets
  it using HttpContext.setHandler(HttpHandler) during
  Endpoint.publish(HttpContext)"
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.xml.ws.spi.http HttpHandler]))

(defn ->http-handler
  "Constructor."
  (^HttpHandler []
    (new HttpHandler )))

(defn handle
  "Handles a given request and generates an appropriate response.
   See HttpExchange for a description of the steps
   involved in handling an exchange. Container invokes this method
   when it receives an incoming request.

  exchange - the exchange containing the request from the client and used to send the response - `javax.xml.ws.spi.http.HttpExchange`

  throws: java.io.IOException - when an I/O error happens during request handling"
  ([^HttpHandler this ^javax.xml.ws.spi.http.HttpExchange exchange]
    (-> this (.handle exchange))))

