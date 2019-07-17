(ns javax.xml.soap.MessageFactory
  "A factory for creating SOAPMessage objects.

  A SAAJ client can create a MessageFactory object
  using the method newInstance, as shown in the following
  lines of code.


        MessageFactory mf = MessageFactory.newInstance();
        MessageFactory mf12 = MessageFactory.newInstance(SOAPConstants.SOAP_1_2_PROTOCOL);

  All MessageFactory objects, regardless of how they are
  created, will produce SOAPMessage objects that
  have the following elements by default:

   A SOAPPart object
   A SOAPEnvelope object
   A SOAPBody object
   A SOAPHeader object

  In some cases, specialized MessageFactory objects may be obtained that produce messages
  prepopulated with additional entries in the SOAPHeader object and the
  SOAPBody object.
  The content of a new SOAPMessage object depends on which of the two
  MessageFactory methods is used to create it.

   createMessage()
       This is the method clients would normally use to create a request message.
   createMessage(MimeHeaders, java.io.InputStream) -- message has
        content from the InputStream object and headers from the
        MimeHeaders object
         This method can be used internally by a service implementation to
         create a message that is a response to a request."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.xml.soap MessageFactory]))

(defn ->message-factory
  "Constructor."
  ([]
    (new MessageFactory )))

(defn *new-instance
  "Creates a new MessageFactory object that is an instance
   of the specified implementation.  May be a dynamic message factory,
   a SOAP 1.1 message factory, or a SOAP 1.2 message factory. A dynamic
   message factory creates messages based on the MIME headers specified
   as arguments to the createMessage method.

   This method uses the SAAJMetaFactory to locate the implementation class
   and create the MessageFactory instance.

  protocol - a string constant representing the class of the specified message factory implementation. May be either DYNAMIC_SOAP_PROTOCOL, DEFAULT_SOAP_PROTOCOL (which is the same as) SOAP_1_1_PROTOCOL, or SOAP_1_2_PROTOCOL. - `java.lang.String`

  returns: a new instance of a MessageFactory - `javax.xml.soap.MessageFactory`

  throws: javax.xml.soap.SOAPException - if there was an error in creating the specified implementation of MessageFactory."
  ([protocol]
    (MessageFactory/newInstance protocol))
  ([]
    (MessageFactory/newInstance )))

(defn create-message
  "Internalizes the contents of the given InputStream object into a
   new SOAPMessage object and returns the SOAPMessage
   object.

  headers - the transport-specific headers passed to the message in a transport-independent fashion for creation of the message - `javax.xml.soap.MimeHeaders`
  in - the InputStream object that contains the data for a message - `java.io.InputStream`

  returns: a new SOAPMessage object containing the data from
           the given InputStream object - `javax.xml.soap.SOAPMessage`

  throws: java.io.IOException - if there is a problem in reading data from the input stream"
  ([this headers in]
    (-> this (.createMessage headers in)))
  ([this]
    (-> this (.createMessage))))

