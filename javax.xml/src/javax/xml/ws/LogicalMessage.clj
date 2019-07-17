(ns javax.xml.ws.LogicalMessage
  "The LogicalMessage interface represents a
   protocol agnostic XML message and contains methods that
   provide access to the payload of the message."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.xml.ws LogicalMessage]))

(defn get-payload
  "Gets the message payload as a JAXB object. Note that there is no
    connection between the returned object and the message payload,
    changes to the payload require calling setPayload.

  context - The JAXBContext that should be used to unmarshall the message payload - `javax.xml.bind.JAXBContext`

  returns: The contained message payload; returns null if no
            payload is present in this message - `java.lang.Object`

  throws: javax.xml.ws.WebServiceException - If an error occurs when using a supplied JAXBContext to unmarshall the payload. The cause of the WebServiceException is the original JAXBException."
  ([^. this ^javax.xml.bind.JAXBContext context]
    (-> this (.getPayload context)))
  ([^. this]
    (-> this (.getPayload))))

(defn set-payload
  "Sets the message payload

  payload - message payload - `java.lang.Object`
  context - The JAXBContext that should be used to marshall the payload - `javax.xml.bind.JAXBContext`

  throws: java.lang.UnsupportedOperationException - If this operation is not supported"
  ([^. this ^java.lang.Object payload ^javax.xml.bind.JAXBContext context]
    (-> this (.setPayload payload context)))
  ([^. this ^javax.xml.transform.Source payload]
    (-> this (.setPayload payload))))

