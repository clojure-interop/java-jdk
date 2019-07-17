(ns javax.xml.ws.handler.soap.SOAPMessageContext
  "The interface SOAPMessageContext
   provides access to the SOAP message for either RPC request or
   response. The javax.xml.soap.SOAPMessage specifies
   the standard Java API for the representation of a SOAP 1.1 message
   with attachments."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.xml.ws.handler.soap SOAPMessageContext]))

(defn get-message
  "Gets the SOAPMessage from this message context. Modifications
    to the returned SOAPMessage change the message in-place, there
    is no need to subsequently call setMessage.

  returns: Returns the SOAPMessage; returns null if no
            SOAPMessage is present in this message context - `javax.xml.soap.SOAPMessage`"
  (^javax.xml.soap.SOAPMessage [^javax.xml.ws.handler.soap.SOAPMessageContext this]
    (-> this (.getMessage))))

(defn set-message
  "Sets the SOAPMessage in this message context

  message - SOAP message - `javax.xml.soap.SOAPMessage`

  throws: WebServiceException - If any error during the setting of the SOAPMessage in this message context"
  ([^javax.xml.ws.handler.soap.SOAPMessageContext this ^javax.xml.soap.SOAPMessage message]
    (-> this (.setMessage message))))

(defn get-headers
  "Gets headers that have a particular qualified name from the message in the
    message context. Note that a SOAP message can contain multiple headers
    with the same qualified name.

  header - The XML qualified name of the SOAP header(s). - `javax.xml.namespace.QName`
  context - The JAXBContext that should be used to unmarshall the header - `javax.xml.bind.JAXBContext`
  all-roles - If true then returns headers for all SOAP roles, if false then only returns headers targetted at the roles currently being played by this SOAP node, see getRoles. - `boolean`

  returns: An array of unmarshalled headers; returns an empty array if no
            message is present in this message context or no headers match
            the supplied qualified name. - `java.lang.Object[]`

  throws: WebServiceException - If an error occurs when using the supplied JAXBContext to unmarshall. The cause of the WebServiceException is the original JAXBException."
  ([^javax.xml.ws.handler.soap.SOAPMessageContext this ^javax.xml.namespace.QName header ^javax.xml.bind.JAXBContext context ^Boolean all-roles]
    (-> this (.getHeaders header context all-roles))))

(defn get-roles
  "Gets the SOAP actor roles associated with an execution
    of the handler chain.
    Note that SOAP actor roles apply to the SOAP node and
    are managed using SOAPBinding.setRoles(java.util.Set<java.lang.String>) and
    SOAPBinding.getRoles(). Handler instances in
    the handler chain use this information about the SOAP actor
    roles to process the SOAP header blocks. Note that the
    SOAP actor roles are invariant during the processing of
    SOAP message through the handler chain.

  returns: Array of String for SOAP actor roles - `java.util.Set<java.lang.String>`"
  (^java.util.Set [^javax.xml.ws.handler.soap.SOAPMessageContext this]
    (-> this (.getRoles))))

