(ns javax.xml.ws.Dispatch
  "The Dispatch interface provides support
   for the dynamic invocation of a service endpoint operations. The
   javax.xml.ws.Service
   class acts as a factory for the creation of Dispatch
   instances."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.xml.ws Dispatch]))

(defn invoke
  "Invoke a service operation synchronously.

   The client is responsible for ensuring that the msg object
   when marshalled is formed according to the requirements of the protocol
   binding in use.

  msg - An object that will form the message or payload of the message used to invoke the operation. - `Dispatch.T`

  returns: The response message or message payload to the
       operation invocation. - `Dispatch.T`

  throws: javax.xml.ws.WebServiceException - If there is any error in the configuration of the Dispatch instance"
  ([^javax.xml.ws.Dispatch this ^Dispatch.T msg]
    (-> this (.invoke msg))))

(defn invoke-async
  "Invoke a service operation asynchronously. The
    method returns without waiting for the response to the operation
    invocation, the results of the operation are communicated to the client
    via the passed in handler.

   The client is responsible for ensuring that the msg object
   when marshalled is formed according to the requirements of the protocol
   binding in use.

  msg - An object that will form the message or payload of the message used to invoke the operation. - `Dispatch.T`
  handler - The handler object that will receive the response to the operation invocation. - `javax.xml.ws.AsyncHandler<Dispatch.T>`

  returns: A Future object that may be used to check the status
       of the operation invocation. This object MUST NOT be used to try to
       obtain the results of the operation - the object returned from
       Future<?>.get() is implementation dependent
       and any use of it will result in non-portable behaviour. - `java.util.concurrent.Future<?>`

  throws: javax.xml.ws.WebServiceException - If there is any error in the configuration of the Dispatch instance"
  ([^javax.xml.ws.Dispatch this ^Dispatch.T msg ^javax.xml.ws.AsyncHandler handler]
    (-> this (.invokeAsync msg handler)))
  ([^javax.xml.ws.Dispatch this ^Dispatch.T msg]
    (-> this (.invokeAsync msg))))

(defn invoke-one-way
  "Invokes a service operation using the one-way
    interaction mode. The operation invocation is logically non-blocking,
    subject to the capabilities of the underlying protocol, no results
    are returned. When
    the protocol in use is SOAP/HTTP, this method MUST block until
    an HTTP response code has been received or an error occurs.

   The client is responsible for ensuring that the msg object
   when marshalled is formed according to the requirements of the protocol
   binding in use.

  msg - An object that will form the message or payload of the message used to invoke the operation. - `Dispatch.T`

  throws: javax.xml.ws.WebServiceException - If there is any error in the configuration of the Dispatch instance or if an error occurs during the invocation."
  ([^javax.xml.ws.Dispatch this ^Dispatch.T msg]
    (-> this (.invokeOneWay msg))))

