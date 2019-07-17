(ns javax.xml.soap.SOAPConnection
  "A point-to-point connection that a client can use for sending messages
  directly to a remote party (represented by a URL, for instance).

  The SOAPConnection class is optional. Some implementations may
  not implement this interface in which case the call to
  SOAPConnectionFactory.newInstance() (see below) will
  throw an UnsupportedOperationException.

  A client can obtain a SOAPConnection object using a
  SOAPConnectionFactory object as in the following example:


       SOAPConnectionFactory factory = SOAPConnectionFactory.newInstance();
       SOAPConnection con = factory.createConnection();
  A SOAPConnection object can be used to send messages
  directly to a URL following the request/response paradigm.  That is,
  messages are sent using the method call, which sends the
  message and then waits until it gets a reply."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.xml.soap SOAPConnection]))

(defn ->soap-connection
  "Constructor."
  ([]
    (new SOAPConnection )))

(defn call
  "Sends the given message to the specified endpoint and blocks until
   it has returned the response.

  request - the SOAPMessage object to be sent - `javax.xml.soap.SOAPMessage`
  to - an Object that identifies where the message should be sent. It is required to support Objects of type java.lang.String, java.net.URL, and when JAXM is present javax.xml.messaging.URLEndpoint - `java.lang.Object`

  returns: the SOAPMessage object that is the response to the
           message that was sent - `javax.xml.soap.SOAPMessage`

  throws: javax.xml.soap.SOAPException - if there is a SOAP error"
  ([this request to]
    (-> this (.call request to))))

(defn get
  "Gets a message from a specific endpoint and blocks until it receives,

  to - an Object that identifies where the request should be sent. Objects of type java.lang.String and java.net.URL must be supported. - `java.lang.Object`

  returns: the SOAPMessage object that is the response to the
                    get message request - `javax.xml.soap.SOAPMessage`

  throws: javax.xml.soap.SOAPException - if there is a SOAP error"
  ([this to]
    (-> this (.get to))))

(defn close
  "Closes this SOAPConnection object.

  throws: javax.xml.soap.SOAPException - if there is a SOAP error"
  ([this]
    (-> this (.close))))

