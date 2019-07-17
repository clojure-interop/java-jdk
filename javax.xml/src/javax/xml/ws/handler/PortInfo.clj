(ns javax.xml.ws.handler.PortInfo
  "The PortInfo interface is used by a
   HandlerResolver to query information about
   the port it is being asked to create a handler chain for.

   This interface is never implemented by an application,
   only by a JAX-WS implementation."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.xml.ws.handler PortInfo]))

(defn get-service-name
  "Gets the qualified name of the WSDL service name containing
    the port being accessed.

  returns: javax.xml.namespace.QName The qualified name of the WSDL service. - `javax.xml.namespace.QName`"
  (^javax.xml.namespace.QName [^javax.xml.ws.handler.PortInfo this]
    (-> this (.getServiceName))))

(defn get-port-name
  "Gets the qualified name of the WSDL port being accessed.

  returns: javax.xml.namespace.QName The qualified name of the WSDL port. - `javax.xml.namespace.QName`"
  (^javax.xml.namespace.QName [^javax.xml.ws.handler.PortInfo this]
    (-> this (.getPortName))))

(defn get-binding-id
  "Gets the URI identifying the binding used by the port being accessed.

  returns: String The binding identifier for the port. - `java.lang.String`"
  (^java.lang.String [^javax.xml.ws.handler.PortInfo this]
    (-> this (.getBindingID))))

