(ns javax.xml.soap.SOAPBody
  "An object that represents the contents of the SOAP body
  element in a SOAP message. A SOAP body element consists of XML data
  that affects the way the application-specific content is processed.

  A SOAPBody object contains SOAPBodyElement
  objects, which have the content for the SOAP body.
  A SOAPFault object, which carries status and/or
  error information, is an example of a SOAPBodyElement object."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.xml.soap SOAPBody]))

(defn add-fault
  "Creates a new SOAPFault object and adds it to
   this SOAPBody object. The type of the
   SOAPFault will be a SOAP 1.1  or a SOAP 1.2
   SOAPFault depending on the protocol
   specified while creating the MessageFactory instance.

   For SOAP 1.2 the faultCode parameter is the value of the
   Fault/Code/Value element  and the faultString parameter
   is the value of the Fault/Reason/Text element. For SOAP 1.1
   the faultCode parameter is the value of the faultcode
   element and the faultString parameter is the value of the faultstring
   element.

   A SOAPBody may contain at most one SOAPFault
   child element.

  fault-code - a Name object giving the fault code to be set; must be one of the fault codes defined in the Version of SOAP specification in use - `javax.xml.soap.Name`
  fault-string - a String giving an explanation of the fault - `java.lang.String`
  locale - a Locale object indicating the native language of the faultString - `java.util.Locale`

  returns: the new SOAPFault object - `javax.xml.soap.SOAPFault`

  throws: javax.xml.soap.SOAPException - if there is a SOAP error"
  ([^. this ^javax.xml.soap.Name fault-code ^java.lang.String fault-string ^java.util.Locale locale]
    (-> this (.addFault fault-code fault-string locale)))
  ([^. this ^javax.xml.soap.Name fault-code ^java.lang.String fault-string]
    (-> this (.addFault fault-code fault-string)))
  ([^. this]
    (-> this (.addFault))))

(defn has-fault?
  "Indicates whether a SOAPFault object exists in this
   SOAPBody object.

  returns: true if a SOAPFault object exists
           in this SOAPBody object; false
           otherwise - `boolean`"
  ([^. this]
    (-> this (.hasFault))))

(defn get-fault
  "Returns the SOAPFault object in this SOAPBody
   object.

  returns: the SOAPFault object in this SOAPBody
           object if present, null otherwise. - `javax.xml.soap.SOAPFault`"
  ([^. this]
    (-> this (.getFault))))

(defn add-body-element
  "Creates a new SOAPBodyElement object with the specified
   name and adds it to this SOAPBody object.

  name - a Name object with the name for the new SOAPBodyElement object - `javax.xml.soap.Name`

  returns: the new SOAPBodyElement object - `javax.xml.soap.SOAPBodyElement`

  throws: javax.xml.soap.SOAPException - if a SOAP error occurs"
  ([^. this ^javax.xml.soap.Name name]
    (-> this (.addBodyElement name))))

(defn add-document
  "Adds the root node of the DOM Document
   to this SOAPBody object.

   Calling this method invalidates the document parameter.
   The client application should discard all references to this Document
   and its contents upon calling addDocument. The behavior
   of an application that continues to use such references is undefined.

  document - the Document object whose root node will be added to this SOAPBody. - `org.w3c.dom.Document`

  returns: the SOAPBodyElement that represents the root node
           that was added. - `javax.xml.soap.SOAPBodyElement`

  throws: javax.xml.soap.SOAPException - if the Document cannot be added"
  ([^. this ^org.w3c.dom.Document document]
    (-> this (.addDocument document))))

(defn extract-content-as-document
  "Creates a new DOM Document and sets
   the first child of this SOAPBody as it's document
   element. The child SOAPElement is removed as part of the
   process.

  returns: the Document representation
           of the SOAPBody content. - `org.w3c.dom.Document`

  throws: javax.xml.soap.SOAPException - if there is not exactly one child SOAPElement of the SOAPBody."
  ([^. this]
    (-> this (.extractContentAsDocument))))

