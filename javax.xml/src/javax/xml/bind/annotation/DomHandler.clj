(ns javax.xml.bind.annotation.DomHandler
  "Converts an element (and its descendants)
  from/to DOM (or similar) representation.


  Implementations of this interface will be used in conjunction with
  XmlAnyElement annotation to map an element of XML into a representation
  of infoset such as W3C DOM.


  Implementations hide how a portion of XML is converted into/from such
  DOM-like representation, allowing JAXB providers to work with arbitrary
  such library.


  This interface is intended to be implemented by library writers
  and consumed by JAXB providers. None of those methods are intended to
  be called from applications."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.xml.bind.annotation DomHandler]))

(defn create-unmarshaller
  "When a JAXB provider needs to unmarshal a part of a document into an
   infoset representation, it first calls this method to create a
   Result object.


   A JAXB provider will then send a portion of the XML
   into the given result. Such a portion always form a subtree
   of the whole XML document rooted at an element.

  error-handler - if any error happens between the invocation of this method and the invocation of getElement(Result), they must be reported to this handler. The caller must provide a non-null error handler. The Result object created from this method may hold a reference to this error handler. - `javax.xml.bind.ValidationEventHandler`

  returns: null if the operation fails. The error must have been reported
        to the error handler. - `DomHandler.ResultT`"
  ([^. this ^javax.xml.bind.ValidationEventHandler error-handler]
    (-> this (.createUnmarshaller error-handler))))

(defn get-element
  "Once the portion is sent to the Result. This method is called
   by a JAXB provider to obtain the unmarshalled element representation.


   Multiple invocations of this method may return different objects.
   This method can be invoked only when the whole sub-tree are fed
   to the Result object.

  rt - The Result object created by createUnmarshaller(ValidationEventHandler). - `DomHandler.ResultT`

  returns: null if the operation fails. The error must have been reported
        to the error handler. - `DomHandler.ElementT`"
  ([^. this ^DomHandler.ResultT rt]
    (-> this (.getElement rt))))

(defn marshal
  "This method is called when a JAXB provider needs to marshal an element
   to XML.


   If non-null, the returned Source must contain a whole document
   rooted at one element, which will then be weaved into a bigger document
   that the JAXB provider is marshalling.

  n - `DomHandler.ElementT`
  error-handler - Receives any errors happened during the process of converting an element into a Source. The caller must provide a non-null error handler. - `javax.xml.bind.ValidationEventHandler`

  returns: null if there was an error. The error should have been reported
        to the handler. - `javax.xml.transform.Source`"
  ([^. this ^DomHandler.ElementT n ^javax.xml.bind.ValidationEventHandler error-handler]
    (-> this (.marshal n error-handler))))

