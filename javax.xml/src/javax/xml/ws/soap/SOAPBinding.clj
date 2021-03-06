(ns javax.xml.ws.soap.SOAPBinding
  "The SOAPBinding interface is an abstraction for
   the SOAP binding."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.xml.ws.soap SOAPBinding]))

(defn get-roles
  "Gets the roles played by the SOAP binding instance.

  returns: Set<String> The set of roles played by the binding instance. - `java.util.Set<java.lang.String>`"
  (^java.util.Set [^SOAPBinding this]
    (-> this (.getRoles))))

(defn set-roles
  "Sets the roles played by the SOAP binding instance.

  roles - The set of roles played by the binding instance. - `java.util.Set`

  throws: WebServiceException - On an error in the configuration of the list of roles."
  ([^SOAPBinding this ^java.util.Set roles]
    (-> this (.setRoles roles))))

(defn mtom-enabled?
  "Returns true if the use of MTOM is enabled.

  returns: true if and only if the use of MTOM is enabled. - `boolean`"
  (^Boolean [^SOAPBinding this]
    (-> this (.isMTOMEnabled))))

(defn set-mtom-enabled
  "Enables or disables use of MTOM.

  flag - A boolean specifying whether the use of MTOM should be enabled or disabled. - `boolean`

  throws: WebServiceException - If the specified setting is not supported by this binding instance."
  ([^SOAPBinding this ^Boolean flag]
    (-> this (.setMTOMEnabled flag))))

(defn get-soap-factory
  "Gets the SAAJ SOAPFactory instance used by this SOAP binding.

  returns: SOAPFactory instance used by this SOAP binding. - `javax.xml.soap.SOAPFactory`"
  (^javax.xml.soap.SOAPFactory [^SOAPBinding this]
    (-> this (.getSOAPFactory))))

(defn get-message-factory
  "Gets the SAAJ MessageFactory instance used by this SOAP binding.

  returns: MessageFactory instance used by this SOAP binding. - `javax.xml.soap.MessageFactory`"
  (^javax.xml.soap.MessageFactory [^SOAPBinding this]
    (-> this (.getMessageFactory))))

