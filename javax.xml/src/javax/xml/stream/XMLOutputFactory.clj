(ns javax.xml.stream.XMLOutputFactory
  "Defines an abstract implementation of a factory for
  getting XMLEventWriters and XMLStreamWriters.

  The following table defines the standard properties of this specification.
  Each property varies in the level of support required by each implementation.
  The level of support required is described in the 'Required' column.





           Configuration parameters





         Property Name
         Behavior
         Return type
         Default Value
         Required

          javax.xml.stream.isRepairingNamespacesdefaults prefixes on the output sideBooleanFalseYes



  The following paragraphs describe the namespace and prefix repair algorithm:

  The property can be set with the following code line:
  setProperty(`javax.xml.stream.isRepairingNamespaces`,new Boolean(true|false));

  This property specifies that the writer default namespace prefix declarations.
  The default value is false.

  If a writer isRepairingNamespaces it will create a namespace declaration
  on the current StartElement for
  any attribute that does not
  currently have a namespace declaration in scope.  If the StartElement
  has a uri but no prefix specified a prefix will be assigned, if the prefix
  has not been declared in a parent of the current StartElement it will be declared
  on the current StartElement.  If the defaultNamespace is bound and in scope
  and the default namespace matches the URI of the attribute or StartElement
  QName no prefix will be assigned.

  If an element or attribute name has a prefix, but is not
  bound to any namespace URI, then the prefix will be removed
  during serialization.

  If element and/or attribute names in the same start or
  empty-element tag are bound to different namespace URIs and
  are using the same prefix then the element or the first
  occurring attribute retains the original prefix and the
  following attributes have their prefixes replaced with a
  new prefix that is bound to the namespace URIs of those
  attributes.

  If an element or attribute name uses a prefix that is
  bound to a different URI than that inherited from the
  namespace context of the parent of that element and there
  is no namespace declaration in the context of the current
  element then such a namespace declaration is added.

  If an element or attribute name is bound to a prefix and
  there is a namespace declaration that binds that prefix
  to a different URI then that namespace declaration is
  either removed if the correct mapping is inherited from
  the parent context of that element, or changed to the
  namespace URI of the element or attribute using that prefix."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.xml.stream XMLOutputFactory]))

(def *-is-repairing-namespaces
  "Static Constant.

  Property used to set prefix defaulting on the output side

  type: java.lang.String"
  XMLOutputFactory/IS_REPAIRING_NAMESPACES)

(defn *new-instance
  "Deprecated. This method has been deprecated because it returns an
                instance of XMLInputFactory, which is of the wrong class.
                Use the new method newFactory(java.lang.String,
                java.lang.ClassLoader) instead.

  factory-id - Name of the factory to find, same as a property name - `java.lang.String`
  class-loader - classLoader to use - `java.lang.ClassLoader`

  returns: the factory implementation - `javax.xml.stream.XMLInputFactory`

  throws: javax.xml.stream.FactoryConfigurationError - if an instance of this factory cannot be loaded"
  (^javax.xml.stream.XMLInputFactory [^java.lang.String factory-id ^java.lang.ClassLoader class-loader]
    (XMLOutputFactory/newInstance factory-id class-loader))
  (^javax.xml.stream.XMLOutputFactory []
    (XMLOutputFactory/newInstance )))

(defn *new-factory
  "Create a new instance of the factory.
   If the classLoader argument is null, then the ContextClassLoader is used.

   This method uses the following ordered lookup procedure to determine
   the XMLOutputFactory implementation class to load:



     Use the value of the system property identified by factoryId.


     Use the properties file `lib/stax.properties` in the JRE directory.
       This configuration file is in standard java.util.Properties format
       and contains the fully qualified name of the implementation class
       with the key being the given factoryId.


     If factoryId is `javax.xml.stream.XMLOutputFactory`,
     use the service-provider loading facilities, defined by the
     ServiceLoader class, to attempt to locate and load
     an implementation of the service using the specified ClassLoader.
     If classLoader is null, the default loading mechanism will apply:
     That is, the service-provider loading facility will use the current thread's context class loader
     to attempt to load the service. If the context class
     loader is null, the system class loader will be used.


     Otherwise, throws a FactoryConfigurationError.

  factory-id - Name of the factory to find, same as a property name - `java.lang.String`
  class-loader - classLoader to use - `java.lang.ClassLoader`

  returns: the factory implementation - `javax.xml.stream.XMLOutputFactory`

  throws: javax.xml.stream.FactoryConfigurationError - in case of java.util.service configuration error or if the implementation is not available or cannot be instantiated."
  (^javax.xml.stream.XMLOutputFactory [^java.lang.String factory-id ^java.lang.ClassLoader class-loader]
    (XMLOutputFactory/newFactory factory-id class-loader))
  (^javax.xml.stream.XMLOutputFactory []
    (XMLOutputFactory/newFactory )))

(defn create-xml-stream-writer
  "Create a new XMLStreamWriter that writes to a stream

  stream - the stream to write to - `java.io.OutputStream`
  encoding - the encoding to use - `java.lang.String`

  returns: `javax.xml.stream.XMLStreamWriter`

  throws: javax.xml.stream.XMLStreamException"
  (^javax.xml.stream.XMLStreamWriter [^javax.xml.stream.XMLOutputFactory this ^java.io.OutputStream stream ^java.lang.String encoding]
    (-> this (.createXMLStreamWriter stream encoding)))
  (^javax.xml.stream.XMLStreamWriter [^javax.xml.stream.XMLOutputFactory this ^java.io.Writer stream]
    (-> this (.createXMLStreamWriter stream))))

(defn create-xml-event-writer
  "Create a new XMLEventWriter that writes to a stream

  stream - the stream to write to - `java.io.OutputStream`
  encoding - the encoding to use - `java.lang.String`

  returns: `javax.xml.stream.XMLEventWriter`

  throws: javax.xml.stream.XMLStreamException"
  (^javax.xml.stream.XMLEventWriter [^javax.xml.stream.XMLOutputFactory this ^java.io.OutputStream stream ^java.lang.String encoding]
    (-> this (.createXMLEventWriter stream encoding)))
  (^javax.xml.stream.XMLEventWriter [^javax.xml.stream.XMLOutputFactory this ^javax.xml.transform.Result result]
    (-> this (.createXMLEventWriter result))))

(defn set-property
  "Allows the user to set specific features/properties on the underlying implementation.

  name - The name of the property - `java.lang.String`
  value - The value of the property - `java.lang.Object`

  throws: java.lang.IllegalArgumentException - if the property is not supported"
  ([^javax.xml.stream.XMLOutputFactory this ^java.lang.String name ^java.lang.Object value]
    (-> this (.setProperty name value))))

(defn get-property
  "Get a feature/property on the underlying implementation

  name - The name of the property - `java.lang.String`

  returns: The value of the property - `java.lang.Object`

  throws: java.lang.IllegalArgumentException - if the property is not supported"
  (^java.lang.Object [^javax.xml.stream.XMLOutputFactory this ^java.lang.String name]
    (-> this (.getProperty name))))

(defn property-supported?
  "Query the set of properties that this factory supports.

  name - The name of the property (may not be null) - `java.lang.String`

  returns: true if the property is supported and false otherwise - `boolean`"
  (^Boolean [^javax.xml.stream.XMLOutputFactory this ^java.lang.String name]
    (-> this (.isPropertySupported name))))

