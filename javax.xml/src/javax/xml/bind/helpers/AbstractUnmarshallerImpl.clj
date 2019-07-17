(ns javax.xml.bind.helpers.AbstractUnmarshallerImpl
  "Partial default Unmarshaller implementation.


  This class provides a partial default implementation for the
  Unmarshallerinterface.


  A JAXB Provider has to implement five methods (getUnmarshallerHandler,
  unmarshal(Node), unmarshal(XMLReader,InputSource),
  unmarshal(XMLStreamReader), and unmarshal(XMLEventReader)."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.xml.bind.helpers AbstractUnmarshallerImpl]))

(defn ->abstract-unmarshaller-impl
  "Constructor."
  ([]
    (new AbstractUnmarshallerImpl )))

(defn set-validating
  "Specifies whether or not the Unmarshaller should validate during
   unmarshal operations.  By default, the Unmarshaller does
   not validate.

   This method may only be invoked before or after calling one of the
   unmarshal methods.

  validating - true if the Unmarshaller should validate during unmarshal, false otherwise - `boolean`

  throws: javax.xml.bind.JAXBException - if an error occurred while enabling or disabling validation at unmarshal time"
  ([^javax.xml.bind.helpers.AbstractUnmarshallerImpl this ^Boolean validating]
    (-> this (.setValidating validating))))

(defn set-event-handler
  "Allow an application to register a validation event handler.

   The validation event handler will be called by the JAXB Provider if any
   validation errors are encountered during calls to any of the
   unmarshal methods.  If the client application does not register
   a validation event handler before invoking the unmarshal methods, then
   all validation events will be silently ignored and may result in
   unexpected behaviour.

  handler - the validation event handler - `javax.xml.bind.ValidationEventHandler`

  throws: javax.xml.bind.JAXBException - if an error was encountered while setting the event handler"
  ([^javax.xml.bind.helpers.AbstractUnmarshallerImpl this ^javax.xml.bind.ValidationEventHandler handler]
    (-> this (.setEventHandler handler))))

(defn get-event-handler
  "Return the current event handler or the default event handler if one
   hasn't been set.

  returns: the current ValidationEventHandler or the default event handler
          if it hasn't been set - `javax.xml.bind.ValidationEventHandler`

  throws: javax.xml.bind.JAXBException - if an error was encountered while getting the current event handler"
  ([^javax.xml.bind.helpers.AbstractUnmarshallerImpl this]
    (-> this (.getEventHandler))))

(defn get-attachment-unmarshaller
  "returns: `javax.xml.bind.attachment.AttachmentUnmarshaller`"
  ([^javax.xml.bind.helpers.AbstractUnmarshallerImpl this]
    (-> this (.getAttachmentUnmarshaller))))

(defn set-listener
  "Description copied from interface: Unmarshaller

  listener - provides unmarshal event callbacks for this Unmarshaller - `javax.xml.bind.Unmarshaller.Listener`"
  ([^javax.xml.bind.helpers.AbstractUnmarshallerImpl this ^javax.xml.bind.Unmarshaller.Listener listener]
    (-> this (.setListener listener))))

(defn get-adapter
  "Description copied from interface: Unmarshaller

  type - `java.lang.Class<A>`

  returns: `<A extends javax.xml.bind.annotation.adapters.XmlAdapter> A`"
  ([^javax.xml.bind.helpers.AbstractUnmarshallerImpl this ^java.lang.Class type]
    (-> this (.getAdapter type))))

(defn set-schema
  "Description copied from interface: Unmarshaller

  schema - Schema object to validate unmarshal operations against or null to disable validation - `javax.xml.validation.Schema`"
  ([^javax.xml.bind.helpers.AbstractUnmarshallerImpl this ^javax.xml.validation.Schema schema]
    (-> this (.setSchema schema))))

(defn set-attachment-unmarshaller
  "Description copied from interface: Unmarshaller

  au - `javax.xml.bind.attachment.AttachmentUnmarshaller`"
  ([^javax.xml.bind.helpers.AbstractUnmarshallerImpl this ^javax.xml.bind.attachment.AttachmentUnmarshaller au]
    (-> this (.setAttachmentUnmarshaller au))))

(defn get-property
  "Default implementation of the getProperty method always
   throws PropertyException since there are no required
   properties. If a provider needs to handle additional
   properties, it should override this method in a derived class.

  name - the name of the property to retrieve - `java.lang.String`

  returns: the value of the requested property - `java.lang.Object`

  throws: javax.xml.bind.PropertyException - when there is an error retrieving the given property or value property name"
  ([^javax.xml.bind.helpers.AbstractUnmarshallerImpl this ^java.lang.String name]
    (-> this (.getProperty name))))

(defn get-listener
  "Description copied from interface: Unmarshaller

  returns: registered Unmarshaller.Listener or null if no Listener is registered with this Unmarshaller. - `javax.xml.bind.Unmarshaller.Listener`"
  ([^javax.xml.bind.helpers.AbstractUnmarshallerImpl this]
    (-> this (.getListener))))

(defn get-schema
  "Description copied from interface: Unmarshaller

  returns: the Schema object being used to perform unmarshal-time
        validation or null if not present - `javax.xml.validation.Schema`"
  ([^javax.xml.bind.helpers.AbstractUnmarshallerImpl this]
    (-> this (.getSchema))))

(defn set-property
  "Default implementation of the setProperty method always
   throws PropertyException since there are no required
   properties. If a provider needs to handle additional
   properties, it should override this method in a derived class.

  name - the name of the property to be set. This value can either be specified using one of the constant fields or a user supplied string. - `java.lang.String`
  value - the value of the property to be set - `java.lang.Object`

  throws: javax.xml.bind.PropertyException - when there is an error processing the given property or value"
  ([^javax.xml.bind.helpers.AbstractUnmarshallerImpl this ^java.lang.String name ^java.lang.Object value]
    (-> this (.setProperty name value))))

(defn unmarshal
  "Description copied from interface: Unmarshaller

  node - the document/element to unmarshal XML data from. The caller must support at least Document and Element. - `org.w3c.dom.Node`
  expected-type - appropriate JAXB mapped class to hold node's XML data. - `java.lang.Class<T>`

  returns: JAXB Element representation of node - `<T> javax.xml.bind.JAXBElement<T>`

  throws: javax.xml.bind.JAXBException - If any unexpected errors occur while unmarshalling"
  ([^javax.xml.bind.helpers.AbstractUnmarshallerImpl this ^org.w3c.dom.Node node ^java.lang.Class expected-type]
    (-> this (.unmarshal node expected-type)))
  ([^javax.xml.bind.helpers.AbstractUnmarshallerImpl this ^javax.xml.transform.Source source]
    (-> this (.unmarshal source))))

(defn set-adapter
  "Description copied from interface: Unmarshaller

  type - The type of the adapter. The specified instance will be used when XmlJavaTypeAdapter.value() refers to this type. - `java.lang.Class<A>`
  adapter - The instance of the adapter to be used. If null, it will un-register the current adapter set for this type. - `A`

  returns: `<A extends javax.xml.bind.annotation.adapters.XmlAdapter> void`"
  ([^javax.xml.bind.helpers.AbstractUnmarshallerImpl this ^java.lang.Class type adapter]
    (-> this (.setAdapter type adapter)))
  ([^javax.xml.bind.helpers.AbstractUnmarshallerImpl this ^javax.xml.bind.annotation.adapters.XmlAdapter adapter]
    (-> this (.setAdapter adapter))))

(defn validating?
  "Indicates whether or not the Unmarshaller is configured to validate
   during unmarshal operations.

   Note: I named this method isValidating() to stay in-line
   with JAXP, as opposed to naming it getValidating().

  returns: true if the Unmarshaller is configured to validate during
          unmarshal operations, false otherwise - `boolean`

  throws: javax.xml.bind.JAXBException - if an error occurs while retrieving the validating flag"
  ([^javax.xml.bind.helpers.AbstractUnmarshallerImpl this]
    (-> this (.isValidating))))

