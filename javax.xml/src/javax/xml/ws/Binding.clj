(ns javax.xml.ws.Binding
  "The Binding interface is the base interface
   for JAX-WS protocol bindings."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.xml.ws Binding]))

(defn get-handler-chain
  "Gets a copy of the handler chain for a protocol binding instance.
   If the returned chain is modified a call to setHandlerChain
   is required to configure the binding instance with the new chain.

  returns: java.util.List<Handler> Handler chain - `java.util.List<javax.xml.ws.handler.Handler>`"
  ([^javax.xml.ws.Binding this]
    (-> this (.getHandlerChain))))

(defn set-handler-chain
  "Sets the handler chain for the protocol binding instance.

  chain - A List of handler configuration entries - `java.util.List<javax.xml.ws.handler.Handler>`

  throws: javax.xml.ws.WebServiceException - On an error in the configuration of the handler chain"
  ([^javax.xml.ws.Binding this ^java.util.List chain]
    (-> this (.setHandlerChain chain))))

(defn get-binding-id
  "Get the URI for this binding instance.

  returns: String The binding identifier for the port.
      Never returns null - `java.lang.String`"
  ([^javax.xml.ws.Binding this]
    (-> this (.getBindingID))))

