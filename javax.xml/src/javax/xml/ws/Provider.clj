(ns javax.xml.ws.Provider
  "Service endpoints may implement the Provider
   interface as a dynamic alternative to an SEI.

   Implementations are required to support Provider<Source>,
   Provider<SOAPMessage> and
   Provider<DataSource>, depending on the binding
   in use and the service mode.

   The ServiceMode annotation can be used to control whether
   the Provider instance will receive entire protocol messages
   or just message payloads."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.xml.ws Provider]))

(defn invoke
  "Invokes an operation occording to the contents of the request
    message.

  request - The request message or message payload. - `T`

  returns: The response message or message payload. May be null if
                there is no response. - `T`

  throws: javax.xml.ws.WebServiceException - If there is an error processing request. The cause of the WebServiceException may be set to a subclass of ProtocolException to control the protocol level representation of the exception."
  ([^Provider this request]
    (-> this (.invoke request))))

