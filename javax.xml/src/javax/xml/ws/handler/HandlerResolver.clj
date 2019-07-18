(ns javax.xml.ws.handler.HandlerResolver
  "HandlerResolver is an interface implemented
   by an application to get control over the handler chain
   set on proxy/dispatch objects at the time of their creation.

   A HandlerResolver may be set on a Service
   using the setHandlerResolver method.

   When the runtime invokes a HandlerResolver, it will
   pass it a PortInfo object containing information
   about the port that the proxy/dispatch object will be accessing."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.xml.ws.handler HandlerResolver]))

(defn get-handler-chain
  "Gets the handler chain for the specified port.

  port-info - Contains information about the port being accessed. - `javax.xml.ws.handler.PortInfo`

  returns: java.util.List<Handler> chain - `java.util.List<javax.xml.ws.handler.Handler>`"
  (^java.util.List [^HandlerResolver this ^javax.xml.ws.handler.PortInfo port-info]
    (-> this (.getHandlerChain port-info))))

