(ns javax.xml.bind.annotation.W3CDomHandler
  "DomHandler implementation for W3C DOM (org.w3c.dom package.)"
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.xml.bind.annotation W3CDomHandler]))

(defn ->w-3-c-dom-handler
  "Constructor.

  Constructor that allows applications to specify which DOM implementation
   to be used.

  builder - must not be null. JAXB uses this DocumentBuilder to create a new element. - `javax.xml.parsers.DocumentBuilder`"
  ([builder]
    (new W3CDomHandler builder))
  ([]
    (new W3CDomHandler )))

(defn get-builder
  "returns: `javax.xml.parsers.DocumentBuilder`"
  ([this]
    (-> this (.getBuilder))))

(defn set-builder
  "builder - `javax.xml.parsers.DocumentBuilder`"
  ([this builder]
    (-> this (.setBuilder builder))))

(defn create-unmarshaller
  "Description copied from interface: DomHandler

  error-handler - if any error happens between the invocation of this method and the invocation of DomHandler.getElement(Result), they must be reported to this handler. The caller must provide a non-null error handler. The Result object created from this method may hold a reference to this error handler. - `javax.xml.bind.ValidationEventHandler`

  returns: null if the operation fails. The error must have been reported
        to the error handler. - `javax.xml.transform.dom.DOMResult`"
  ([this error-handler]
    (-> this (.createUnmarshaller error-handler))))

(defn get-element
  "Description copied from interface: DomHandler

  r - The Result object created by DomHandler.createUnmarshaller(ValidationEventHandler). - `javax.xml.transform.dom.DOMResult`

  returns: null if the operation fails. The error must have been reported
        to the error handler. - `org.w3c.dom.Element`"
  ([this r]
    (-> this (.getElement r))))

(defn marshal
  "Description copied from interface: DomHandler

  element - `org.w3c.dom.Element`
  error-handler - `javax.xml.bind.ValidationEventHandler`

  returns: null if there was an error. The error should have been reported
        to the handler. - `javax.xml.transform.Source`"
  ([this element error-handler]
    (-> this (.marshal element error-handler))))

