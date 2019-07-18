(ns javax.xml.parsers.SAXParserFactory
  "Defines a factory API that enables applications to configure and
  obtain a SAX based parser to parse XML documents."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.xml.parsers SAXParserFactory]))

(defn *new-instance
  "Obtain a new instance of a SAXParserFactory from class name.
   This function is useful when there are multiple providers in the classpath.
   It gives more control to the application as it can specify which provider
   should be loaded.

   Once an application has obtained a reference to a SAXParserFactory
   it can use the factory to configure and obtain parser instances.


   Tip for Trouble-shooting
   Setting the jaxp.debug system property will cause
   this method to print a lot of debug messages
   to System.err about what it is doing and where it is looking at.

    If you have problems, try:


   java -Djaxp.debug=1 YourProgram ....

  factory-class-name - fully qualified factory class name that provides implementation of javax.xml.parsers.SAXParserFactory. - `java.lang.String`
  class-loader - ClassLoader used to load the factory class. If null current Thread's context classLoader is used to load the factory class. - `java.lang.ClassLoader`

  returns: New instance of a SAXParserFactory - `javax.xml.parsers.SAXParserFactory`

  throws: javax.xml.parsers.FactoryConfigurationError - if factoryClassName is null, or the factory class cannot be loaded, instantiated."
  (^javax.xml.parsers.SAXParserFactory [^java.lang.String factory-class-name ^java.lang.ClassLoader class-loader]
    (SAXParserFactory/newInstance factory-class-name class-loader))
  (^javax.xml.parsers.SAXParserFactory []
    (SAXParserFactory/newInstance )))

(defn set-namespace-aware
  "Specifies that the parser produced by this code will
   provide support for XML namespaces. By default the value of this is set
   to false.

  awareness - true if the parser produced by this code will provide support for XML namespaces; false otherwise. - `boolean`"
  ([^SAXParserFactory this ^Boolean awareness]
    (-> this (.setNamespaceAware awareness))))

(defn get-feature?
  "Returns the particular property requested for in the underlying
   implementation of org.xml.sax.XMLReader.

  name - The name of the property to be retrieved. - `java.lang.String`

  returns: Value of the requested property. - `boolean`

  throws: javax.xml.parsers.ParserConfigurationException - if a parser cannot be created which satisfies the requested configuration."
  (^Boolean [^SAXParserFactory this ^java.lang.String name]
    (-> this (.getFeature name))))

(defn set-validating
  "Specifies that the parser produced by this code will
   validate documents as they are parsed. By default the value of this is
   set to false.


   Note that `the validation` here means
   a validating
   parser as defined in the XML recommendation.
   In other words, it essentially just controls the DTD validation.
   (except the legacy two properties defined in JAXP 1.2.)



   To use modern schema languages such as W3C XML Schema or
   RELAX NG instead of DTD, you can configure your parser to be
   a non-validating parser by leaving the setValidating(boolean)
   method false, then use the setSchema(Schema)
   method to associate a schema to a parser.

  validating - true if the parser produced by this code will validate documents as they are parsed; false otherwise. - `boolean`"
  ([^SAXParserFactory this ^Boolean validating]
    (-> this (.setValidating validating))))

(defn set-schema
  "Set the Schema to be used by parsers created
   from this factory.

   When a Schema is non-null, a parser will use a validator
   created from it to validate documents before it passes information
   down to the application.

   When warnings/errors/fatal errors are found by the validator, the parser must
   handle them as if those errors were found by the parser itself.
   In other words, if the user-specified ErrorHandler
   is set, it must receive those errors, and if not, they must be
   treated according to the implementation specific
   default error handling rules.

   A validator may modify the SAX event stream (for example by
   adding default values that were missing in documents), and a parser
   is responsible to make sure that the application will receive
   those modified event stream.

   Initialy, null is set as the Schema.

   This processing will take effect even if
   the isValidating() method returns false.

   It is an error to use
   the http://java.sun.com/xml/jaxp/properties/schemaSource
   property and/or the http://java.sun.com/xml/jaxp/properties/schemaLanguage
   property in conjunction with a non-null Schema object.
   Such configuration will cause a SAXException
   exception when those properties are set on a SAXParser.

   Note for implementors

   A parser must be able to work with any Schema
   implementation. However, parsers and schemas are allowed
   to use implementation-specific custom mechanisms
   as long as they yield the result described in the specification.

  schema - Schema to use, null to remove a schema. - `javax.xml.validation.Schema`

  throws: java.lang.UnsupportedOperationException - When implementation does not override this method"
  ([^SAXParserFactory this ^javax.xml.validation.Schema schema]
    (-> this (.setSchema schema))))

(defn set-x-include-aware
  "Set state of XInclude processing.

   If XInclude markup is found in the document instance, should it be
   processed as specified in
   XML Inclusions (XInclude) Version 1.0.

   XInclude processing defaults to false.

  state - Set XInclude processing to true or false - `boolean`

  throws: java.lang.UnsupportedOperationException - When implementation does not override this method"
  ([^SAXParserFactory this ^Boolean state]
    (-> this (.setXIncludeAware state))))

(defn get-schema
  "Gets the Schema object specified through
   the setSchema(Schema schema) method.

  returns: the Schema object that was last set through
        the setSchema(Schema) method, or null
        if the method was not invoked since a SAXParserFactory
        is created. - `javax.xml.validation.Schema`

  throws: java.lang.UnsupportedOperationException - When implementation does not override this method"
  (^javax.xml.validation.Schema [^SAXParserFactory this]
    (-> this (.getSchema))))

(defn set-feature
  "Sets the particular feature in the underlying implementation of
   org.xml.sax.XMLReader.
   A list of the core features and properties can be found at
   http://www.saxproject.org/

   All implementations are required to support the XMLConstants.FEATURE_SECURE_PROCESSING feature.
   When the feature is


       true: the implementation will limit XML processing to conform to implementation limits.
       Examples include entity expansion limits and XML Schema constructs that would consume large amounts of resources.
       If XML processing is limited for security reasons, it will be reported via a call to the registered
       ErrorHandler.fatalError(SAXParseException exception).
       See SAXParser parse methods for handler specification.


       When the feature is false, the implementation will processing XML according to the XML specifications without
       regard to possible implementation limits.

  name - The name of the feature to be set. - `java.lang.String`
  value - The value of the feature to be set. - `boolean`

  throws: javax.xml.parsers.ParserConfigurationException - if a parser cannot be created which satisfies the requested configuration."
  ([^SAXParserFactory this ^java.lang.String name ^Boolean value]
    (-> this (.setFeature name value))))

(defn new-sax-parser
  "Creates a new instance of a SAXParser using the currently
   configured factory parameters.

  returns: A new instance of a SAXParser. - `javax.xml.parsers.SAXParser`

  throws: javax.xml.parsers.ParserConfigurationException - if a parser cannot be created which satisfies the requested configuration."
  (^javax.xml.parsers.SAXParser [^SAXParserFactory this]
    (-> this (.newSAXParser))))

(defn namespace-aware?
  "Indicates whether or not the factory is configured to produce
   parsers which are namespace aware.

  returns: true if the factory is configured to produce
           parsers which are namespace aware; false otherwise. - `boolean`"
  (^Boolean [^SAXParserFactory this]
    (-> this (.isNamespaceAware))))

(defn validating?
  "Indicates whether or not the factory is configured to produce
   parsers which validate the XML content during parse.

  returns: true if the factory is configured to produce parsers which validate
           the XML content during parse; false otherwise. - `boolean`"
  (^Boolean [^SAXParserFactory this]
    (-> this (.isValidating))))

(defn x-include-aware?
  "Get state of XInclude processing.

  returns: current state of XInclude processing - `boolean`

  throws: java.lang.UnsupportedOperationException - When implementation does not override this method"
  (^Boolean [^SAXParserFactory this]
    (-> this (.isXIncludeAware))))

