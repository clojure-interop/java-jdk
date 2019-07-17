(ns javax.xml.stream.XMLEventFactory
  "This interface defines a utility class for creating instances of
  XMLEvents"
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.xml.stream XMLEventFactory]))

(defn *new-instance
  "Deprecated. This method has been deprecated to maintain API consistency.
                All newInstance methods have been replaced with corresponding
                newFactory methods. The replacement newFactory(java.lang.String, java.lang.ClassLoader)
                method defines no changes in behavior.

  factory-id - Name of the factory to find, same as a property name - `java.lang.String`
  class-loader - classLoader to use - `java.lang.ClassLoader`

  returns: the factory implementation - `javax.xml.stream.XMLEventFactory`

  throws: javax.xml.stream.FactoryConfigurationError - if an instance of this factory cannot be loaded"
  ([factory-id class-loader]
    (XMLEventFactory/newInstance factory-id class-loader))
  ([]
    (XMLEventFactory/newInstance )))

(defn *new-factory
  "Create a new instance of the factory.
   If the classLoader argument is null, then the ContextClassLoader is used.

   This method uses the following ordered lookup procedure to determine
   the XMLEventFactory implementation class to load:



     Use the value of the system property identified by factoryId.


     Use the properties file `lib/stax.properties` in the JRE directory.
       This configuration file is in standard java.util.Properties format
       and contains the fully qualified name of the implementation class
       with the key being the given factoryId.


     If factoryId is `javax.xml.stream.XMLEventFactory`,
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

  returns: the factory implementation - `javax.xml.stream.XMLEventFactory`

  throws: javax.xml.stream.FactoryConfigurationError - in case of java.util.service configuration error or if the implementation is not available or cannot be instantiated."
  ([factory-id class-loader]
    (XMLEventFactory/newFactory factory-id class-loader))
  ([]
    (XMLEventFactory/newFactory )))

(defn create-ignorable-space
  "Create an ignorable space

  content - the space to create - `java.lang.String`

  returns: a Characters event - `javax.xml.stream.events.Characters`"
  ([this content]
    (-> this (.createIgnorableSpace content))))

(defn create-processing-instruction
  "Create a processing instruction

  target - The target of the processing instruction - `java.lang.String`
  data - The text of the processing instruction - `java.lang.String`

  returns: a ProcessingInstruction event - `javax.xml.stream.events.ProcessingInstruction`"
  ([this target data]
    (-> this (.createProcessingInstruction target data))))

(defn create-end-document
  "Creates a new instance of an EndDocument event

  returns: an EndDocument event - `javax.xml.stream.events.EndDocument`"
  ([this]
    (-> this (.createEndDocument))))

(defn set-location
  "This method allows setting of the Location on each event that
   is created by this factory.  The values are copied by value into
   the events created by this factory.  To reset the location
   information set the location to null.

  location - the location to set on each event created - `javax.xml.stream.Location`"
  ([this location]
    (-> this (.setLocation location))))

(defn create-comment
  "Create a comment

  text - The text of the comment a Comment event - `java.lang.String`

  returns: `javax.xml.stream.events.Comment`"
  ([this text]
    (-> this (.createComment text))))

(defn create-namespace
  "Create a new Namespace

  prefix - the prefix of this namespace, may not be null - `java.lang.String`
  namespace-uri - the attribute value is set to this value, may not be null - `java.lang.String`

  returns: the Namespace with the specified values - `javax.xml.stream.events.Namespace`"
  ([this prefix namespace-uri]
    (-> this (.createNamespace prefix namespace-uri)))
  ([this namespace-uri]
    (-> this (.createNamespace namespace-uri))))

(defn create-entity-reference
  "Creates a new instance of a EntityReference event

  name - The name of the reference - `java.lang.String`
  declaration - the declaration for the event - `javax.xml.stream.events.EntityDeclaration`

  returns: an EntityReference event - `javax.xml.stream.events.EntityReference`"
  ([this name declaration]
    (-> this (.createEntityReference name declaration))))

(defn create-attribute
  "Create a new Attribute

  prefix - the prefix of this attribute, may not be null - `java.lang.String`
  namespace-uri - the attribute value is set to this value, may not be null - `java.lang.String`
  local-name - the local name of the XML name of the attribute, localName cannot be null - `java.lang.String`
  value - the attribute value to set, may not be null - `java.lang.String`

  returns: the Attribute with specified values - `javax.xml.stream.events.Attribute`"
  ([this prefix namespace-uri local-name value]
    (-> this (.createAttribute prefix namespace-uri local-name value)))
  ([this local-name value]
    (-> this (.createAttribute local-name value))))

(defn create-end-element
  "Create a new EndElement

  prefix - the prefix of the QName of the new StartElement - `java.lang.String`
  namespace-uri - the uri of the QName of the new StartElement - `java.lang.String`
  local-name - the local name of the QName of the new StartElement - `java.lang.String`
  namespaces - an unordered set of objects that implement Namespace that have gone out of scope, may be null - `java.util.Iterator`

  returns: an instance of the requested EndElement - `javax.xml.stream.events.EndElement`"
  ([this prefix namespace-uri local-name namespaces]
    (-> this (.createEndElement prefix namespace-uri local-name namespaces)))
  ([this prefix namespace-uri local-name]
    (-> this (.createEndElement prefix namespace-uri local-name)))
  ([this name namespaces]
    (-> this (.createEndElement name namespaces))))

(defn create-start-element
  "Create a new StartElement.  Namespaces can be added to this StartElement
   by passing in an Iterator that walks over a set of Namespace interfaces.
   Attributes can be added to this StartElement by passing an iterator
   that walks over a set of Attribute interfaces.

  prefix - the prefix of the QName of the new StartElement - `java.lang.String`
  namespace-uri - the uri of the QName of the new StartElement - `java.lang.String`
  local-name - the local name of the QName of the new StartElement - `java.lang.String`
  attributes - an unordered set of objects that implement Attribute to add to the new StartElement, may be null - `java.util.Iterator`
  namespaces - an unordered set of objects that implement Namespace to add to the new StartElement, may be null - `java.util.Iterator`
  context - the namespace context of this element - `javax.xml.namespace.NamespaceContext`

  returns: an instance of the requested StartElement - `javax.xml.stream.events.StartElement`"
  ([this prefix namespace-uri local-name attributes namespaces context]
    (-> this (.createStartElement prefix namespace-uri local-name attributes namespaces context)))
  ([this prefix namespace-uri local-name attributes namespaces]
    (-> this (.createStartElement prefix namespace-uri local-name attributes namespaces)))
  ([this name attributes namespaces]
    (-> this (.createStartElement name attributes namespaces))))

(defn create-start-document
  "Creates a new instance of a StartDocument event

  encoding - the encoding style - `java.lang.String`
  version - the XML version - `java.lang.String`
  standalone - the status of standalone may be set to `true` or `false` - `boolean`

  returns: a StartDocument event - `javax.xml.stream.events.StartDocument`"
  ([this encoding version standalone]
    (-> this (.createStartDocument encoding version standalone)))
  ([this encoding version]
    (-> this (.createStartDocument encoding version)))
  ([this encoding]
    (-> this (.createStartDocument encoding)))
  ([this]
    (-> this (.createStartDocument))))

(defn create-dtd
  "Create a document type definition event
   This string contains the entire document type declaration that matches
   the doctypedecl in the XML 1.0 specification

  dtd - the text of the document type definition - `java.lang.String`

  returns: a DTD event - `javax.xml.stream.events.DTD`"
  ([this dtd]
    (-> this (.createDTD dtd))))

(defn create-space
  "Create a Characters event with the isSpace flag set to true

  content - the content of the space to create - `java.lang.String`

  returns: a Characters event - `javax.xml.stream.events.Characters`"
  ([this content]
    (-> this (.createSpace content))))

(defn create-c-data
  "Create a Characters event with the CData flag set to true

  content - the string to create - `java.lang.String`

  returns: a Characters event - `javax.xml.stream.events.Characters`"
  ([this content]
    (-> this (.createCData content))))

(defn create-characters
  "Create a Characters event, this method does not check if the content
   is all whitespace.  To create a space event use #createSpace(String)

  content - the string to create - `java.lang.String`

  returns: a Characters event - `javax.xml.stream.events.Characters`"
  ([this content]
    (-> this (.createCharacters content))))

