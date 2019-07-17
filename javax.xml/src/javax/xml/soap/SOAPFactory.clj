(ns javax.xml.soap.SOAPFactory
  "SOAPFactory is a factory for creating various objects
  that exist in the SOAP XML tree.

  SOAPFactory can be
  used to create XML fragments that will eventually end up in the
  SOAP part. These fragments can be inserted as children of the
  SOAPHeaderElement or SOAPBodyElement or
  SOAPEnvelope or other SOAPElement objects.

  SOAPFactory also has methods to create
  javax.xml.soap.Detail objects as well as
  java.xml.soap.Name objects."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.xml.soap SOAPFactory]))

(defn ->soap-factory
  "Constructor."
  ([]
    (new SOAPFactory )))

(defn *new-instance
  "Creates a new SOAPFactory object that is an instance of
   the specified implementation, this method uses the SAAJMetaFactory to
   locate the implementation class and create the SOAPFactory instance.

  protocol - a string constant representing the protocol of the specified SOAP factory implementation. May be either DYNAMIC_SOAP_PROTOCOL, DEFAULT_SOAP_PROTOCOL (which is the same as) SOAP_1_1_PROTOCOL, or SOAP_1_2_PROTOCOL. - `java.lang.String`

  returns: a new instance of a SOAPFactory - `javax.xml.soap.SOAPFactory`

  throws: javax.xml.soap.SOAPException - if there was an error creating the specified SOAPFactory"
  (^javax.xml.soap.SOAPFactory [^java.lang.String protocol]
    (SOAPFactory/newInstance protocol))
  (^javax.xml.soap.SOAPFactory []
    (SOAPFactory/newInstance )))

(defn create-element
  "Creates a new SOAPElement object with the given
   local name, prefix and uri. The concrete type of the return value
   will depend on the name given to the new SOAPElement. For
   instance, a new SOAPElement with the name
   `{http://www.w3.org/2003/05/soap-envelope}Envelope` would cause a
   SOAPEnvelope that supports SOAP 1.2 behavior to be created.

  local-name - a String giving the local name for the new element - `java.lang.String`
  prefix - the prefix for this SOAPElement - `java.lang.String`
  uri - a String giving the URI of the namespace to which the new element belongs - `java.lang.String`

  returns: `javax.xml.soap.SOAPElement`

  throws: javax.xml.soap.SOAPException - if there is an error in creating the SOAPElement object"
  (^javax.xml.soap.SOAPElement [^javax.xml.soap.SOAPFactory this ^java.lang.String local-name ^java.lang.String prefix ^java.lang.String uri]
    (-> this (.createElement local-name prefix uri)))
  (^javax.xml.soap.SOAPElement [^javax.xml.soap.SOAPFactory this ^org.w3c.dom.Element dom-element]
    (-> this (.createElement dom-element))))

(defn create-detail
  "Creates a new Detail object which serves as a container
   for DetailEntry objects.

   This factory method creates Detail objects for use in
   situations where it is not practical to use the SOAPFault
   abstraction.

  returns: a Detail object - `javax.xml.soap.Detail`

  throws: javax.xml.soap.SOAPException - if there is a SOAP error"
  (^javax.xml.soap.Detail [^javax.xml.soap.SOAPFactory this]
    (-> this (.createDetail))))

(defn create-fault
  "Creates a new SOAPFault object initialized with the given reasonText
    and faultCode

  reason-text - the ReasonText/FaultString for the fault - `java.lang.String`
  fault-code - the FaultCode for the fault - `javax.xml.namespace.QName`

  returns: a SOAPFault object - `javax.xml.soap.SOAPFault`

  throws: javax.xml.soap.SOAPException - if there is a SOAP error"
  (^javax.xml.soap.SOAPFault [^javax.xml.soap.SOAPFactory this ^java.lang.String reason-text ^javax.xml.namespace.QName fault-code]
    (-> this (.createFault reason-text fault-code)))
  (^javax.xml.soap.SOAPFault [^javax.xml.soap.SOAPFactory this]
    (-> this (.createFault))))

(defn create-name
  "Creates a new Name object initialized with the
   given local name, namespace prefix, and namespace URI.

   This factory method creates Name objects for use in
   situations where it is not practical to use the SOAPEnvelope
   abstraction.

  local-name - a String giving the local name - `java.lang.String`
  prefix - a String giving the prefix of the namespace - `java.lang.String`
  uri - a String giving the URI of the namespace - `java.lang.String`

  returns: a Name object initialized with the given
           local name, namespace prefix, and namespace URI - `javax.xml.soap.Name`

  throws: javax.xml.soap.SOAPException - if there is a SOAP error"
  (^javax.xml.soap.Name [^javax.xml.soap.SOAPFactory this ^java.lang.String local-name ^java.lang.String prefix ^java.lang.String uri]
    (-> this (.createName local-name prefix uri)))
  (^javax.xml.soap.Name [^javax.xml.soap.SOAPFactory this ^java.lang.String local-name]
    (-> this (.createName local-name))))

