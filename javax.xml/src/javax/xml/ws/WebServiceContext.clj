(ns javax.xml.ws.WebServiceContext
  "A WebServiceContext makes it possible for
   a web service endpoint implementation class to access
   message context and security information relative to
   a request being served.

   Typically a WebServiceContext is injected
   into an endpoint implementation class using the
   Resource annotation."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.xml.ws WebServiceContext]))

(defn get-message-context
  "Returns the MessageContext for the request being served
   at the time this method is called. Only properties with
   APPLICATION scope will be visible to the application.

  returns: MessageContext The message context. - `javax.xml.ws.handler.MessageContext`

  throws: java.lang.IllegalStateException - This exception is thrown if the method is called while no request is being serviced."
  ([^javax.xml.ws.WebServiceContext this]
    (-> this (.getMessageContext))))

(defn get-user-principal
  "Returns the Principal that identifies the sender
   of the request currently being serviced. If the
   sender has not been authenticated, the method
   returns null.

  returns: Principal The principal object. - `java.security.Principal`

  throws: java.lang.IllegalStateException - This exception is thrown if the method is called while no request is being serviced."
  ([^javax.xml.ws.WebServiceContext this]
    (-> this (.getUserPrincipal))))

(defn user-in-role?
  "Returns a boolean indicating whether the
   authenticated user is included in the specified
   logical role. If the user has not been
   authenticated, the method returns false.

  role - A String specifying the name of the role - `java.lang.String`

  returns: a boolean indicating whether
   the sender of the request belongs to a given role - `boolean`

  throws: java.lang.IllegalStateException - This exception is thrown if the method is called while no request is being serviced."
  ([^javax.xml.ws.WebServiceContext this ^java.lang.String role]
    (-> this (.isUserInRole role))))

(defn get-endpoint-reference
  "Returns the EndpointReference associated with
   this endpoint.

  clazz - The type of EndpointReference that MUST be returned. - `java.lang.Class<T>`
  reference-parameters - Reference parameters to be associated with the returned EndpointReference instance. - `org.w3c.dom.Element`

  returns: EndpointReference of type clazz of the endpoint
   associated with this WebServiceContext instance.
   If the returned EndpointReference is of type
   W3CEndpointReference then it MUST contain the
   the specified referenceParameters. - `<T extends javax.xml.ws.EndpointReference> T`

  throws: java.lang.IllegalStateException - This exception is thrown if the method is called while no request is being serviced."
  ([^javax.xml.ws.WebServiceContext this ^java.lang.Class clazz ^org.w3c.dom.Element reference-parameters]
    (-> this (.getEndpointReference clazz reference-parameters)))
  ([^javax.xml.ws.WebServiceContext this ^org.w3c.dom.Element reference-parameters]
    (-> this (.getEndpointReference reference-parameters))))

