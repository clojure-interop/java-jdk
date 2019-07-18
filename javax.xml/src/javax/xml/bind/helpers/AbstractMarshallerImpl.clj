(ns javax.xml.bind.helpers.AbstractMarshallerImpl
  "Partial default Marshaller implementation.


  This class provides a partial default implementation for the
  Marshaller interface.


  The only methods that a JAXB Provider has to implement are
  marshal(Object, javax.xml.transform.Result),
  marshal(Object, javax.xml.stream.XMLStreamWriter), and
  marshal(Object, javax.xml.stream.XMLEventWriter)."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.xml.bind.helpers AbstractMarshallerImpl]))

(defn ->abstract-marshaller-impl
  "Constructor."
  (^AbstractMarshallerImpl []
    (new AbstractMarshallerImpl )))

(defn set-attachment-marshaller
  "Description copied from interface: Marshaller

  am - `javax.xml.bind.attachment.AttachmentMarshaller`"
  ([^AbstractMarshallerImpl this ^javax.xml.bind.attachment.AttachmentMarshaller am]
    (-> this (.setAttachmentMarshaller am))))

(defn marshal
  "Description copied from interface: Marshaller

  obj - The root of content tree to be marshalled. - `java.lang.Object`
  os - XML will be added to this stream. - `java.io.OutputStream`

  throws: javax.xml.bind.JAXBException - If any unexpected problem occurs during the marshalling."
  ([^AbstractMarshallerImpl this ^java.lang.Object obj ^java.io.OutputStream os]
    (-> this (.marshal obj os))))

(defn set-event-handler
  "Description copied from interface: Marshaller

  handler - the validation event handler - `javax.xml.bind.ValidationEventHandler`

  throws: javax.xml.bind.JAXBException - if an error was encountered while setting the event handler"
  ([^AbstractMarshallerImpl this ^javax.xml.bind.ValidationEventHandler handler]
    (-> this (.setEventHandler handler))))

(defn get-event-handler
  "Description copied from interface: Marshaller

  returns: the current ValidationEventHandler or the default event handler
           if it hasn't been set - `javax.xml.bind.ValidationEventHandler`

  throws: javax.xml.bind.JAXBException - if an error was encountered while getting the current event handler"
  (^javax.xml.bind.ValidationEventHandler [^AbstractMarshallerImpl this]
    (-> this (.getEventHandler))))

(defn get-node
  "By default, the getNode method is unsupported and throw
   an UnsupportedOperationException.

   Implementations that choose to support this method must
   override this method.

  obj - - JAXB Java representation of XML content - `java.lang.Object`

  returns: the DOM tree view of the contentTree - `org.w3c.dom.Node`

  throws: javax.xml.bind.JAXBException - If any unexpected problem occurs"
  (^org.w3c.dom.Node [^AbstractMarshallerImpl this ^java.lang.Object obj]
    (-> this (.getNode obj))))

(defn set-listener
  "Description copied from interface: Marshaller

  listener - an instance of a class that implements Marshaller.Listener - `javax.xml.bind.Marshaller$Listener`"
  ([^AbstractMarshallerImpl this ^javax.xml.bind.Marshaller$Listener listener]
    (-> this (.setListener listener))))

(defn get-adapter
  "Description copied from interface: Marshaller

  type - `java.lang.Class`

  returns: `<A extends javax.xml.bind.annotation.adapters.XmlAdapter> A`"
  ([^AbstractMarshallerImpl this ^java.lang.Class type]
    (-> this (.getAdapter type))))

(defn get-attachment-marshaller
  "returns: `javax.xml.bind.attachment.AttachmentMarshaller`"
  (^javax.xml.bind.attachment.AttachmentMarshaller [^AbstractMarshallerImpl this]
    (-> this (.getAttachmentMarshaller))))

(defn set-schema
  "Description copied from interface: Marshaller

  schema - Schema object to validate marshal operations against or null to disable validation - `javax.xml.validation.Schema`"
  ([^AbstractMarshallerImpl this ^javax.xml.validation.Schema schema]
    (-> this (.setSchema schema))))

(defn get-property
  "Default implementation of the getProperty method handles
   the four defined properties in Marshaller.  If a provider
   needs to support additional provider specific properties,
   it should override this method in a derived class.

  name - the name of the property to retrieve - `java.lang.String`

  returns: the value of the requested property - `java.lang.Object`

  throws: javax.xml.bind.PropertyException - when there is an error retrieving the given property or value property name"
  (^java.lang.Object [^AbstractMarshallerImpl this ^java.lang.String name]
    (-> this (.getProperty name))))

(defn get-listener
  "Description copied from interface: Marshaller

  returns: registered Marshaller.Listener or null if no Listener is registered with this Marshaller. - `javax.xml.bind.Marshaller$Listener`"
  (^javax.xml.bind.Marshaller$Listener [^AbstractMarshallerImpl this]
    (-> this (.getListener))))

(defn get-schema
  "Description copied from interface: Marshaller

  returns: the Schema object being used to perform marshal-time
        validation or null if not present. - `javax.xml.validation.Schema`"
  (^javax.xml.validation.Schema [^AbstractMarshallerImpl this]
    (-> this (.getSchema))))

(defn set-property
  "Default implementation of the setProperty method handles
   the four defined properties in Marshaller. If a provider
   needs to handle additional properties, it should override
   this method in a derived class.

  name - the name of the property to be set. This value can either be specified using one of the constant fields or a user supplied string. - `java.lang.String`
  value - the value of the property to be set - `java.lang.Object`

  throws: javax.xml.bind.PropertyException - when there is an error processing the given property or value"
  ([^AbstractMarshallerImpl this ^java.lang.String name ^java.lang.Object value]
    (-> this (.setProperty name value))))

(defn set-adapter
  "Description copied from interface: Marshaller

  type - The type of the adapter. The specified instance will be used when XmlJavaTypeAdapter.value() refers to this type. - `java.lang.Class`
  adapter - The instance of the adapter to be used. If null, it will un-register the current adapter set for this type. - `A`

  returns: `<A extends javax.xml.bind.annotation.adapters.XmlAdapter> void`"
  ([^AbstractMarshallerImpl this ^java.lang.Class type adapter]
    (-> this (.setAdapter type adapter)))
  ([^AbstractMarshallerImpl this ^javax.xml.bind.annotation.adapters.XmlAdapter adapter]
    (-> this (.setAdapter adapter))))

