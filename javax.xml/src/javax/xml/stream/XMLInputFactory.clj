(ns javax.xml.stream.XMLInputFactory
  "Defines an abstract implementation of a factory for getting streams.

  The following table defines the standard properties of this specification.
  Each property varies in the level of support required by each implementation.
  The level of support required is described in the 'Required' column.





           Configuration parameters





         Property Name
         Behavior
         Return type
         Default Value
         Required

  javax.xml.stream.isValidatingTurns on/off implementation specific DTD validationBooleanFalseNo
  javax.xml.stream.isNamespaceAwareTurns on/off namespace processing for XML 1.0 supportBooleanTrueTrue (required) / False (optional)
  javax.xml.stream.isCoalescingRequires the processor to coalesce adjacent character dataBooleanFalseYes
  javax.xml.stream.isReplacingEntityReferencesreplace internal entity references with their replacement text and report them as charactersBooleanTrueYes
 javax.xml.stream.isSupportingExternalEntitiesResolve external parsed entitiesBooleanUnspecifiedYes
 javax.xml.stream.supportDTDUse this property to request processors that do not support DTDsBooleanTrueYes
 javax.xml.stream.reportersets/gets the impl of the XMLReporter javax.xml.stream.XMLReporterNullYes
 javax.xml.stream.resolversets/gets the impl of the XMLResolver interfacejavax.xml.stream.XMLResolverNullYes
 javax.xml.stream.allocatorsets/gets the impl of the XMLEventAllocator interfacejavax.xml.stream.util.XMLEventAllocatorNullYes"
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.xml.stream XMLInputFactory]))

(def *-is-namespace-aware
  "Static Constant.

  The property used to turn on/off namespace support,
   this is to support XML 1.0 documents,
   only the true setting must be supported

  type: java.lang.String"
  XMLInputFactory/IS_NAMESPACE_AWARE)

(def *-is-validating
  "Static Constant.

  The property used to turn on/off implementation specific validation

  type: java.lang.String"
  XMLInputFactory/IS_VALIDATING)

(def *-is-coalescing
  "Static Constant.

  The property that requires the parser to coalesce adjacent character data sections

  type: java.lang.String"
  XMLInputFactory/IS_COALESCING)

(def *-is-replacing-entity-references
  "Static Constant.

  Requires the parser to replace internal
   entity references with their replacement
   text and report them as characters

  type: java.lang.String"
  XMLInputFactory/IS_REPLACING_ENTITY_REFERENCES)

(def *-is-supporting-external-entities
  "Static Constant.

  The property that requires the parser to resolve external parsed entities

  type: java.lang.String"
  XMLInputFactory/IS_SUPPORTING_EXTERNAL_ENTITIES)

(def *-support-dtd
  "Static Constant.

  The property that requires the parser to support DTDs

  type: java.lang.String"
  XMLInputFactory/SUPPORT_DTD)

(def *-reporter
  "Static Constant.

  The property used to
   set/get the implementation of the XMLReporter interface

  type: java.lang.String"
  XMLInputFactory/REPORTER)

(def *-resolver
  "Static Constant.

  The property used to set/get the implementation of the XMLResolver

  type: java.lang.String"
  XMLInputFactory/RESOLVER)

(def *-allocator
  "Static Constant.

  The property used to set/get the implementation of the allocator

  type: java.lang.String"
  XMLInputFactory/ALLOCATOR)

(defn *new-instance
  "Deprecated. This method has been deprecated to maintain API consistency.
                All newInstance methods have been replaced with corresponding
                newFactory methods. The replacement newFactory(java.lang.String, java.lang.ClassLoader) method
                defines no changes in behavior.

  factory-id - Name of the factory to find, same as a property name - `java.lang.String`
  class-loader - classLoader to use - `java.lang.ClassLoader`

  returns: the factory implementation - `javax.xml.stream.XMLInputFactory`

  throws: javax.xml.stream.FactoryConfigurationError - if an instance of this factory cannot be loaded"
  ([^java.lang.String factory-id ^java.lang.ClassLoader class-loader]
    (XMLInputFactory/newInstance factory-id class-loader))
  ([]
    (XMLInputFactory/newInstance )))

(defn *new-factory
  "Create a new instance of the factory.
   If the classLoader argument is null, then the ContextClassLoader is used.

   This method uses the following ordered lookup procedure to determine
   the XMLInputFactory implementation class to load:



     Use the value of the system property identified by factoryId.


     Use the properties file `lib/stax.properties` in the JRE directory.
       This configuration file is in standard java.util.Properties format
       and contains the fully qualified name of the implementation class
       with the key being the given factoryId.


     If factoryId is `javax.xml.stream.XMLInputFactory`,
     use the service-provider loading facilities, defined by the
     ServiceLoader class, to attempt to locate and load
     an implementation of the service using the specified ClassLoader.
     If classLoader is null, the default loading mechanism will apply:
     That is, the service-provider loading facility will use the current thread's context class loader
     to attempt to load the service. If the context class
     loader is null, the system class loader will be used.


     Otherwise, throws a FactoryConfigurationError.




   Note that this is a new method that replaces the deprecated
     newInstance(String factoryId, ClassLoader classLoader) method.
   No changes in behavior are defined by this replacement method relative
   to the deprecated method.

  factory-id - Name of the factory to find, same as a property name - `java.lang.String`
  class-loader - classLoader to use - `java.lang.ClassLoader`

  returns: the factory implementation - `javax.xml.stream.XMLInputFactory`

  throws: javax.xml.stream.FactoryConfigurationError - if an instance of this factory cannot be loaded"
  ([^java.lang.String factory-id ^java.lang.ClassLoader class-loader]
    (XMLInputFactory/newFactory factory-id class-loader))
  ([]
    (XMLInputFactory/newFactory )))

(defn create-xml-stream-reader
  "Create a new XMLStreamReader from a java.io.InputStream

  stream - the InputStream to read from - `java.io.InputStream`
  encoding - the character encoding of the stream - `java.lang.String`

  returns: `javax.xml.stream.XMLStreamReader`

  throws: javax.xml.stream.XMLStreamException"
  ([^javax.xml.stream.XMLInputFactory this ^java.io.InputStream stream ^java.lang.String encoding]
    (-> this (.createXMLStreamReader stream encoding)))
  ([^javax.xml.stream.XMLInputFactory this ^java.io.Reader reader]
    (-> this (.createXMLStreamReader reader))))

(defn property-supported?
  "Query the set of properties that this factory supports.

  name - The name of the property (may not be null) - `java.lang.String`

  returns: true if the property is supported and false otherwise - `boolean`"
  ([^javax.xml.stream.XMLInputFactory this ^java.lang.String name]
    (-> this (.isPropertySupported name))))

(defn create-filtered-reader
  "Create a filtered reader that wraps the filter around the reader

  reader - the reader to filter - `javax.xml.stream.XMLStreamReader`
  filter - the filter to apply to the reader - `javax.xml.stream.StreamFilter`

  returns: `javax.xml.stream.XMLStreamReader`

  throws: javax.xml.stream.XMLStreamException"
  ([^javax.xml.stream.XMLInputFactory this ^javax.xml.stream.XMLStreamReader reader ^javax.xml.stream.StreamFilter filter]
    (-> this (.createFilteredReader reader filter))))

(defn set-event-allocator
  "Set a user defined event allocator for events

  allocator - the user defined allocator - `javax.xml.stream.util.XMLEventAllocator`"
  ([^javax.xml.stream.XMLInputFactory this ^javax.xml.stream.util.XMLEventAllocator allocator]
    (-> this (.setEventAllocator allocator))))

(defn set-xml-reporter
  "The reporter that will be set on any XMLStreamReader or XMLEventReader created
   by this factory instance.

  reporter - the resolver to use to report non fatal errors - `javax.xml.stream.XMLReporter`"
  ([^javax.xml.stream.XMLInputFactory this ^javax.xml.stream.XMLReporter reporter]
    (-> this (.setXMLReporter reporter))))

(defn get-property
  "Get the value of a feature/property from the underlying implementation

  name - The name of the property (may not be null) - `java.lang.String`

  returns: The value of the property - `java.lang.Object`

  throws: java.lang.IllegalArgumentException - if the property is not supported"
  ([^javax.xml.stream.XMLInputFactory this ^java.lang.String name]
    (-> this (.getProperty name))))

(defn set-xml-resolver
  "The resolver that will be set on any XMLStreamReader or XMLEventReader created
   by this factory instance.

  resolver - the resolver to use to resolve references - `javax.xml.stream.XMLResolver`"
  ([^javax.xml.stream.XMLInputFactory this ^javax.xml.stream.XMLResolver resolver]
    (-> this (.setXMLResolver resolver))))

(defn get-event-allocator
  "Gets the allocator used by streams created with this factory

  returns: `javax.xml.stream.util.XMLEventAllocator`"
  ([^javax.xml.stream.XMLInputFactory this]
    (-> this (.getEventAllocator))))

(defn set-property
  "Allows the user to set specific feature/property on the underlying
   implementation. The underlying implementation is not required to support
   every setting of every property in the specification and may use
   IllegalArgumentException to signal that an unsupported property may not be
   set with the specified value.

   All implementations that implement JAXP 1.5 or newer are required to
   support the XMLConstants.ACCESS_EXTERNAL_DTD property.




          Access to external DTDs, external Entity References is restricted to the
          protocols specified by the property. If access is denied during parsing
          due to the restriction of this property, XMLStreamException
          will be thrown by the XMLStreamReader.next() or
          XMLEventReader.nextEvent() method.

  name - The name of the property (may not be null) - `java.lang.String`
  value - The value of the property - `java.lang.Object`

  throws: java.lang.IllegalArgumentException - if the property is not supported"
  ([^javax.xml.stream.XMLInputFactory this ^java.lang.String name ^java.lang.Object value]
    (-> this (.setProperty name value))))

(defn create-xml-event-reader
  "Create a new XMLEventReader from a reader

  system-id - the system ID of the input - `java.lang.String`
  reader - the XML data to read from - `java.io.Reader`

  returns: `javax.xml.stream.XMLEventReader`

  throws: javax.xml.stream.XMLStreamException"
  ([^javax.xml.stream.XMLInputFactory this ^java.lang.String system-id ^java.io.Reader reader]
    (-> this (.createXMLEventReader system-id reader)))
  ([^javax.xml.stream.XMLInputFactory this ^java.io.Reader reader]
    (-> this (.createXMLEventReader reader))))

(defn get-xml-resolver
  "The resolver that will be set on any XMLStreamReader or XMLEventReader created
   by this factory instance.

  returns: `javax.xml.stream.XMLResolver`"
  ([^javax.xml.stream.XMLInputFactory this]
    (-> this (.getXMLResolver))))

(defn get-xml-reporter
  "The reporter that will be set on any XMLStreamReader or XMLEventReader created
   by this factory instance.

  returns: `javax.xml.stream.XMLReporter`"
  ([^javax.xml.stream.XMLInputFactory this]
    (-> this (.getXMLReporter))))

