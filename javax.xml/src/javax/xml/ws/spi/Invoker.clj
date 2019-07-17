(ns javax.xml.ws.spi.Invoker
  "Invoker hides the detail of calling into application endpoint
  implementation. Container hands over an implementation of Invoker
  to JAX-WS runtime, and jax-ws runtime calls invoke(java.lang.reflect.Method, java.lang.Object...)
  for a web service invocation. Finally, Invoker does the actual
  invocation of web service on endpoint instance.

  Container also injects the provided WebServiceContext and takes
  care of invoking javax.annotation.PostConstruct methods,
  if present, on the endpoint implementation."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.xml.ws.spi Invoker]))

(defn ->invoker
  "Constructor."
  ([]
    (new Invoker )))

(defn inject
  "JAX-WS runtimes calls this method to ask container to inject
   WebServiceContext on the endpoint instance. The
   WebServiceContext object uses thread-local information
   to return the correct information during the actual endpoint invocation
   regardless of how many threads are concurrently being used to serve
   requests.

  web-service-context - a holder for MessageContext - `javax.xml.ws.WebServiceContext`

  throws: java.lang.IllegalAccessException - if the injection done by reflection API throws this exception"
  ([this web-service-context]
    (-> this (.inject web-service-context))))

(defn invoke
  "JAX-WS runtime calls this method to do the actual web service
   invocation on endpoint instance. The injected
   WebServiceContext.getMessageContext() gives the correct
   information for this invocation.

  m - Method to be invoked on the service - `java.lang.reflect.Method`
  args - Method arguments - `java.lang.Object`

  returns: return value of the method - `java.lang.Object`

  throws: java.lang.IllegalAccessException - if the invocation done by reflection API throws this exception"
  ([this m args]
    (-> this (.invoke m args))))

