(ns javax.xml.bind.Marshaller
  " The Marshaller class is responsible for governing the process
  of serializing Java content trees back into XML data.  It provides the basic
  marshalling methods:


  Assume the following setup code for all following code fragments:



        JAXBContext jc = JAXBContext.newInstance( `com.acme.foo` );
        Unmarshaller u = jc.createUnmarshaller();
        Object element = u.unmarshal( new File( `foo.xml` ) );
        Marshaller m = jc.createMarshaller();



  Marshalling to a File:



        OutputStream os = new FileOutputStream( `nosferatu.xml` );
        m.marshal( element, os );



  Marshalling to a SAX ContentHandler:



        // assume MyContentHandler instanceof ContentHandler
        m.marshal( element, new MyContentHandler() );



  Marshalling to a DOM Node:



        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        dbf.setNamespaceAware(true);
        DocumentBuilder db = dbf.newDocumentBuilder();
        Document doc = db.newDocument();

        m.marshal( element, doc );



  Marshalling to a java.io.OutputStream:



        m.marshal( element, System.out );



  Marshalling to a java.io.Writer:



        m.marshal( element, new PrintWriter( System.out ) );



  Marshalling to a javax.xml.transform.SAXResult:



        // assume MyContentHandler instanceof ContentHandler
        SAXResult result = new SAXResult( new MyContentHandler() );

        m.marshal( element, result );



  Marshalling to a javax.xml.transform.DOMResult:



        DOMResult result = new DOMResult();

        m.marshal( element, result );



  Marshalling to a javax.xml.transform.StreamResult:



        StreamResult result = new StreamResult( System.out );

        m.marshal( element, result );



  Marshalling to a javax.xml.stream.XMLStreamWriter:



        XMLStreamWriter xmlStreamWriter =
            XMLOutputFactory.newInstance().createXMLStreamWriter( ... );

        m.marshal( element, xmlStreamWriter );



  Marshalling to a javax.xml.stream.XMLEventWriter:



        XMLEventWriter xmlEventWriter =
            XMLOutputFactory.newInstance().createXMLEventWriter( ... );

        m.marshal( element, xmlEventWriter );




  Marshalling content tree rooted by a JAXB element

  The first parameter of the overloaded
  Marshaller.marshal(java.lang.Object, ...) methods must be a
  JAXB element as computed by
  JAXBIntrospector.isElement(java.lang.Object);
  otherwise, a Marshaller.marshal method must throw a
  MarshalException. There exist two mechanisms
  to enable marshalling an instance that is not a JAXB element.
  One method is to wrap the instance as a value of a JAXBElement,
  and pass the wrapper element as the first parameter to
  a Marshaller.marshal method. For java to schema binding, it
  is also possible to simply annotate the instance's class with
  @XmlRootElement.



  Encoding

  By default, the Marshaller will use UTF-8 encoding when generating XML data
  to a java.io.OutputStream, or a java.io.Writer.  Use the
  setProperty API to change the output
  encoding used during these marshal operations.  Client applications are
  expected to supply a valid character encoding name as defined in the
  W3C XML 1.0
  Recommendation and supported by your Java Platform.



  Validation and Well-Formedness


  Client applications are not required to validate the Java content tree prior
  to calling any of the marshal API's.  Furthermore, there is no requirement
  that the Java content tree be valid with respect to its original schema in
  order to marshal it back into XML data.  Different JAXB Providers will
  support marshalling invalid Java content trees at varying levels, however
  all JAXB Providers must be able to marshal a valid content tree back to
  XML data.  A JAXB Provider must throw a MarshalException when it
  is unable to complete the marshal operation due to invalid content.  Some
  JAXB Providers will fully allow marshalling invalid content, others will fail
  on the first validation error.

  Even when schema validation is not explictly enabled for the marshal operation,
  it is possible that certain types of validation events will be detected
  during the operation.  Validation events will be reported to the registered
  event handler.  If the client application has not registered an event handler
  prior to invoking one of the marshal API's, then events will be delivered to
  a default event handler which will terminate the marshal operation after
  encountering the first error or fatal error. Note that for JAXB 2.0 and
  later versions, DefaultValidationEventHandler is
  no longer used.





  Supported Properties


  All JAXB Providers are required to support the following set of properties.
  Some providers may support additional properties.

    jaxb.encoding - value must be a java.lang.String
    The output encoding to use when marshalling the XML data.  The
                Marshaller will use `UTF-8` by default if this property is not
        specified.
    jaxb.formatted.output - value must be a java.lang.Boolean
    This property controls whether or not the Marshaller will format
        the resulting XML data with line breaks and indentation.  A
        true value for this property indicates human readable indented
        xml data, while a false value indicates unformatted xml data.
        The Marshaller will default to false (unformatted) if this
        property is not specified.
    jaxb.schemaLocation - value must be a java.lang.String
    This property allows the client application to specify an
        xsi:schemaLocation attribute in the generated XML data.  The format of
        the schemaLocation attribute value is discussed in an easy to
        understand, non-normative form in
        Section 5.6
        of the W3C XML Schema Part 0: Primer and specified in

        Section 2.6 of the W3C XML Schema Part 1: Structures.
    jaxb.noNamespaceSchemaLocation - value must be a java.lang.String
    This property allows the client application to specify an
        xsi:noNamespaceSchemaLocation attribute in the generated XML
        data.  The format of the schemaLocation attribute value is discussed in
        an easy to understand, non-normative form in
        Section 5.6
        of the W3C XML Schema Part 0: Primer and specified in

        Section 2.6 of the W3C XML Schema Part 1: Structures.
    jaxb.fragment - value must be a java.lang.Boolean
    This property determines whether or not document level events will be
        generated by the Marshaller.  If the property is not specified, the
        default is false. This property has different implications depending
        on which marshal api you are using - when this property is set to true:

          marshal(Object,ContentHandler) - the Marshaller won't
              invoke ContentHandler.startDocument() and
              ContentHandler.endDocument().
          marshal(Object,Node) - the property has no effect on this
              API.
          marshal(Object,OutputStream) - the Marshaller won't
              generate an xml declaration.
          marshal(Object,Writer) - the Marshaller won't
              generate an xml declaration.
          marshal(Object,Result) - depends on the kind of
              Result object, see semantics for Node, ContentHandler, and Stream APIs
          marshal(Object,XMLEventWriter) - the
              Marshaller will not generate XMLStreamConstants.START_DOCUMENT and
              XMLStreamConstants.END_DOCUMENT events.
          marshal(Object,XMLStreamWriter) - the
              Marshaller will not generate XMLStreamConstants.START_DOCUMENT and
              XMLStreamConstants.END_DOCUMENT events.







  Marshal Event Callbacks

  `The Marshaller provides two styles of callback mechanisms
  that allow application specific processing during key points in the
  unmarshalling process.  In 'class defined' event callbacks, application
  specific code placed in JAXB mapped classes is triggered during
  marshalling.  'External listeners' allow for centralized processing
  of marshal events in one callback method rather than by type event callbacks.


  Class defined event callback methods allow any JAXB mapped class to specify
  its own specific callback methods by defining methods with the following method signatures:



    // Invoked by Marshaller after it has created an instance of this object.
    boolean beforeMarshal(Marshaller);

    // Invoked by Marshaller after it has marshalled all properties of this object.
    void afterMarshal(Marshaller);

  The class defined event callback methods should be used when the callback method requires
  access to non-public methods and/or fields of the class.

  The external listener callback mechanism enables the registration of a Marshaller.Listener
  instance with a setListener(Listener). The external listener receives all callback events,
  allowing for more centralized processing than per class defined callback methods.

  The 'class defined' and external listener event callback methods are independent of each other,
  both can be called for one event. The invocation ordering when both listener callback methods exist is
  defined in Marshaller.Listener.beforeMarshal(Object) and Marshaller.Listener.afterMarshal(Object).

  An event callback method throwing an exception terminates the current marshal process."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.xml.bind Marshaller]))

(defn set-attachment-marshaller
  "Associate a context that enables binary data within an XML document
   to be transmitted as XML-binary optimized attachment.
   The attachment is referenced from the XML document content model
   by content-id URIs(cid) references stored within the xml document.

  am - `javax.xml.bind.attachment.AttachmentMarshaller`

  throws: java.lang.IllegalStateException - if attempt to concurrently call this method during a marshal operation."
  ([^. this ^javax.xml.bind.attachment.AttachmentMarshaller am]
    (-> this (.setAttachmentMarshaller am))))

(defn marshal
  "Marshal the content tree rooted at jaxbElement into the specified
   javax.xml.transform.Result.


   All JAXB Providers must at least support
   DOMResult,
   SAXResult, and
   StreamResult. It can
   support other derived classes of Result as well.

  jaxb-element - The root of content tree to be marshalled. - `java.lang.Object`
  result - XML will be sent to this Result - `javax.xml.transform.Result`

  throws: javax.xml.bind.JAXBException - If any unexpected problem occurs during the marshalling."
  ([^. this ^java.lang.Object jaxb-element ^javax.xml.transform.Result result]
    (-> this (.marshal jaxb-element result))))

(defn set-event-handler
  "Allow an application to register a validation event handler.

   The validation event handler will be called by the JAXB Provider if any
   validation errors are encountered during calls to any of the marshal
   API's.  If the client application does not register a validation event
   handler before invoking one of the marshal methods, then validation
   events will be handled by the default event handler which will terminate
   the marshal operation after the first error or fatal error is encountered.

   Calling this method with a null parameter will cause the Marshaller
   to revert back to the default default event handler.

  handler - the validation event handler - `javax.xml.bind.ValidationEventHandler`

  throws: javax.xml.bind.JAXBException - if an error was encountered while setting the event handler"
  ([^. this ^javax.xml.bind.ValidationEventHandler handler]
    (-> this (.setEventHandler handler))))

(defn get-event-handler
  "Return the current event handler or the default event handler if one
   hasn't been set.

  returns: the current ValidationEventHandler or the default event handler
           if it hasn't been set - `javax.xml.bind.ValidationEventHandler`

  throws: javax.xml.bind.JAXBException - if an error was encountered while getting the current event handler"
  ([^. this]
    (-> this (.getEventHandler))))

(defn get-node
  "Get a DOM tree view of the content tree(Optional).

   If the returned DOM tree is updated, these changes are also
   visible in the content tree.
   Use marshal(Object, org.w3c.dom.Node) to force
   a deep copy of the content tree to a DOM representation.

  content-tree - - JAXB Java representation of XML content - `java.lang.Object`

  returns: the DOM tree view of the contentTree - `org.w3c.dom.Node`

  throws: java.lang.UnsupportedOperationException - If the JAXB provider implementation does not support a DOM view of the content tree"
  ([^. this ^java.lang.Object content-tree]
    (-> this (.getNode content-tree))))

(defn set-listener
  "Register marshal event callback Marshaller.Listener with this Marshaller.


   There is only one Listener per Marshaller. Setting a Listener replaces the previous set Listener.
   One can unregister current Listener by setting listener to null.

  listener - an instance of a class that implements Marshaller.Listener - `javax.xml.bind.Marshaller.Listener`"
  ([^. this ^javax.xml.bind.Marshaller.Listener listener]
    (-> this (.setListener listener))))

(defn get-adapter
  "Gets the adapter associated with the specified type.

   This is the reverse operation of the setAdapter(javax.xml.bind.annotation.adapters.XmlAdapter) method.

  type - `java.lang.Class<A>`

  returns: `<A extends javax.xml.bind.annotation.adapters.XmlAdapter> A`

  throws: java.lang.IllegalArgumentException - if the type parameter is null."
  ([^. this ^java.lang.Class type]
    (-> this (.getAdapter type))))

(defn get-attachment-marshaller
  "returns: `javax.xml.bind.attachment.AttachmentMarshaller`"
  ([^. this]
    (-> this (.getAttachmentMarshaller))))

(defn set-schema
  "Specify the JAXP 1.3 Schema
   object that should be used to validate subsequent marshal operations
   against.  Passing null into this method will disable validation.


   This method allows the caller to validate the marshalled XML as it's marshalled.


   Initially this property is set to null.

  schema - Schema object to validate marshal operations against or null to disable validation - `javax.xml.validation.Schema`

  throws: java.lang.UnsupportedOperationException - could be thrown if this method is invoked on an Marshaller created from a JAXBContext referencing JAXB 1.0 mapped classes"
  ([^. this ^javax.xml.validation.Schema schema]
    (-> this (.setSchema schema))))

(defn get-property
  "Get the particular property in the underlying implementation of
   Marshaller.  This method can only be used to get one of
   the standard JAXB defined properties above or a provider specific
   property.  Attempting to get an undefined property will result in
   a PropertyException being thrown.  See
   Supported Properties.

  name - the name of the property to retrieve - `java.lang.String`

  returns: the value of the requested property - `java.lang.Object`

  throws: javax.xml.bind.PropertyException - when there is an error retrieving the given property or value property name"
  ([^. this ^java.lang.String name]
    (-> this (.getProperty name))))

(defn get-listener
  "Return Marshaller.Listener registered with this Marshaller.

  returns: registered Marshaller.Listener or null if no Listener is registered with this Marshaller. - `javax.xml.bind.Marshaller.Listener`"
  ([^. this]
    (-> this (.getListener))))

(defn get-schema
  "Get the JAXP 1.3 Schema object
   being used to perform marshal-time validation.  If there is no
   Schema set on the marshaller, then this method will return null
   indicating that marshal-time validation will not be performed.

  returns: the Schema object being used to perform marshal-time
        validation or null if not present. - `javax.xml.validation.Schema`

  throws: java.lang.UnsupportedOperationException - could be thrown if this method is invoked on an Marshaller created from a JAXBContext referencing JAXB 1.0 mapped classes"
  ([^. this]
    (-> this (.getSchema))))

(defn set-property
  "Set the particular property in the underlying implementation of
   Marshaller.  This method can only be used to set one of
   the standard JAXB defined properties above or a provider specific
   property.  Attempting to set an undefined property will result in
   a PropertyException being thrown.  See
   Supported Properties.

  name - the name of the property to be set. This value can either be specified using one of the constant fields or a user supplied string. - `java.lang.String`
  value - the value of the property to be set - `java.lang.Object`

  throws: javax.xml.bind.PropertyException - when there is an error processing the given property or value"
  ([^. this ^java.lang.String name ^java.lang.Object value]
    (-> this (.setProperty name value))))

(defn set-adapter
  "Associates a configured instance of XmlAdapter with this marshaller.


   Every marshaller internally maintains a
   Map<Class,XmlAdapter>,
   which it uses for marshalling classes whose fields/methods are annotated
   with XmlJavaTypeAdapter.


   This method allows applications to use a configured instance of XmlAdapter.
   When an instance of an adapter is not given, a marshaller will create
   one by invoking its default constructor.

  type - The type of the adapter. The specified instance will be used when XmlJavaTypeAdapter.value() refers to this type. - `java.lang.Class<A>`
  adapter - The instance of the adapter to be used. If null, it will un-register the current adapter set for this type. - `A`

  returns: `<A extends javax.xml.bind.annotation.adapters.XmlAdapter> void`

  throws: java.lang.IllegalArgumentException - if the type parameter is null."
  ([^. this ^java.lang.Class type adapter]
    (-> this (.setAdapter type adapter)))
  ([^. this ^javax.xml.bind.annotation.adapters.XmlAdapter adapter]
    (-> this (.setAdapter adapter))))

