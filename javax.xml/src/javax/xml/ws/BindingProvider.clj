(ns javax.xml.ws.BindingProvider
  "The BindingProvider interface provides access to the
  protocol binding and associated context objects for request and
  response message processing."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.xml.ws BindingProvider]))

(defn get-request-context
  "Get the context that is used to initialize the message context
   for request messages.

   Modifications to the request context do not affect the message context of
   either synchronous or asynchronous operations that have already been
   started.

  returns: The context that is used in processing request messages. - `java.util.Map<java.lang.String,java.lang.Object>`"
  ([^. this]
    (-> this (.getRequestContext))))

(defn get-response-context
  "Get the context that resulted from processing a response message.

   The returned context is for the most recently completed synchronous
   operation. Subsequent synchronous operation invocations overwrite the
   response context. Asynchronous operations return their response context
   via the Response interface.

  returns: The context that resulted from processing the latest
   response messages. - `java.util.Map<java.lang.String,java.lang.Object>`"
  ([^. this]
    (-> this (.getResponseContext))))

(defn get-binding
  "Get the Binding for this binding provider.

  returns: The Binding for this binding provider. - `javax.xml.ws.Binding`"
  ([^. this]
    (-> this (.getBinding))))

(defn get-endpoint-reference
  "Returns the EndpointReference associated with
   this BindingProvider instance.  The instance
   returned will be of type clazz.

  clazz - Specifies the type of EndpointReference that MUST be returned. - `java.lang.Class<T>`

  returns: EndpointReference of the target endpoint associated with this
   BindingProvider instance. MUST be of type
   clazz. - `<T extends javax.xml.ws.EndpointReference> T`

  throws: javax.xml.ws.WebServiceException - If the Class clazz is not supported by this implementation."
  ([^. this ^java.lang.Class clazz]
    (-> this (.getEndpointReference clazz)))
  ([^. this]
    (-> this (.getEndpointReference))))

