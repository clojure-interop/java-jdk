(ns javax.xml.parsers.DocumentBuilderFactory
  "Defines a factory API that enables applications to obtain a
  parser that produces DOM object trees from XML documents."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.xml.parsers DocumentBuilderFactory]))

(defn *new-instance
  "Obtain a new instance of a DocumentBuilderFactory from class name.
   This function is useful when there are multiple providers in the classpath.
   It gives more control to the application as it can specify which provider
   should be loaded.

   Once an application has obtained a reference to a DocumentBuilderFactory
   it can use the factory to configure and obtain parser instances.


   Tip for Trouble-shooting
   Setting the jaxp.debug system property will cause
   this method to print a lot of debug messages
   to System.err about what it is doing and where it is looking at.

    If you have problems try:


   java -Djaxp.debug=1 YourProgram ....

  factory-class-name - fully qualified factory class name that provides implementation of javax.xml.parsers.DocumentBuilderFactory. - `java.lang.String`
  class-loader - ClassLoader used to load the factory class. If null current Thread's context classLoader is used to load the factory class. - `java.lang.ClassLoader`

  returns: New instance of a DocumentBuilderFactory - `javax.xml.parsers.DocumentBuilderFactory`

  throws: javax.xml.parsers.FactoryConfigurationError - if factoryClassName is null, or the factory class cannot be loaded, instantiated."
  (^javax.xml.parsers.DocumentBuilderFactory [^java.lang.String factory-class-name ^java.lang.ClassLoader class-loader]
    (DocumentBuilderFactory/newInstance factory-class-name class-loader))
  (^javax.xml.parsers.DocumentBuilderFactory []
    (DocumentBuilderFactory/newInstance )))

(defn set-namespace-aware
  "Specifies that the parser produced by this code will
   provide support for XML namespaces. By default the value of this is set
   to false

  awareness - true if the parser produced will provide support for XML namespaces; false otherwise. - `boolean`"
  ([^DocumentBuilderFactory this ^Boolean awareness]
    (-> this (.setNamespaceAware awareness))))

(defn coalescing?
  "Indicates whether or not the factory is configured to produce
   parsers which converts CDATA nodes to Text nodes and appends it to
   the adjacent (if any) Text node.

  returns: true if the factory is configured to produce parsers
            which converts CDATA nodes to Text nodes and appends it to
            the adjacent (if any) Text node; false otherwise. - `boolean`"
  (^Boolean [^DocumentBuilderFactory this]
    (-> this (.isCoalescing))))

(defn get-feature?
  "Get the state of the named feature.


   Feature names are fully qualified URIs.
   Implementations may define their own features.
   An ParserConfigurationException is thrown if this DocumentBuilderFactory or the
   DocumentBuilders it creates cannot support the feature.
   It is possible for an DocumentBuilderFactory to expose a feature value but be unable to change its state.

  name - Feature name. - `java.lang.String`

  returns: State of the named feature. - `boolean`

  throws: javax.xml.parsers.ParserConfigurationException - if this DocumentBuilderFactory or the DocumentBuilders it creates cannot support this feature."
  (^Boolean [^DocumentBuilderFactory this ^java.lang.String name]
    (-> this (.getFeature name))))

(defn set-validating
  "Specifies that the parser produced by this code will
   validate documents as they are parsed. By default the value of this
   is set to false.


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

  validating - true if the parser produced will validate documents as they are parsed; false otherwise. - `boolean`"
  ([^DocumentBuilderFactory this ^Boolean validating]
    (-> this (.setValidating validating))))

(defn set-coalescing
  "Specifies that the parser produced by this code will
   convert CDATA nodes to Text nodes and append it to the
   adjacent (if any) text node. By default the value of this is set to
   false

  coalescing - true if the parser produced will convert CDATA nodes to Text nodes and append it to the adjacent (if any) text node; false otherwise. - `boolean`"
  ([^DocumentBuilderFactory this ^Boolean coalescing]
    (-> this (.setCoalescing coalescing))))

(defn get-attribute
  "Allows the user to retrieve specific attributes on the underlying
   implementation.

  name - The name of the attribute. - `java.lang.String`

  returns: value The value of the attribute. - `java.lang.Object`

  throws: java.lang.IllegalArgumentException - thrown if the underlying implementation doesn't recognize the attribute."
  (^java.lang.Object [^DocumentBuilderFactory this ^java.lang.String name]
    (-> this (.getAttribute name))))

(defn set-schema
  "Set the Schema to be used by parsers created
   from this factory.


   When a Schema is non-null, a parser will use a validator
   created from it to validate documents before it passes information
   down to the application.

   When errors are found by the validator, the parser is responsible
   to report them to the user-specified ErrorHandler
   (or if the error handler is not set, ignore them or throw them), just
   like any other errors found by the parser itself.
   In other words, if the user-specified ErrorHandler
   is set, it must receive those errors, and if not, they must be
   treated according to the implementation specific
   default error handling rules.


   A validator may modify the outcome of a parse (for example by
   adding default values that were missing in documents), and a parser
   is responsible to make sure that the application will receive
   modified DOM trees.


   Initialy, null is set as the Schema.


   This processing will take effect even if
   the isValidating() method returns false.

   It is an error to use
   the http://java.sun.com/xml/jaxp/properties/schemaSource
   property and/or the http://java.sun.com/xml/jaxp/properties/schemaLanguage
   property in conjunction with a Schema object.
   Such configuration will cause a ParserConfigurationException
   exception when the newDocumentBuilder() is invoked.


   Note for implmentors


   A parser must be able to work with any Schema
   implementation. However, parsers and schemas are allowed
   to use implementation-specific custom mechanisms
   as long as they yield the result described in the specification.

  schema - Schema to use or null to remove a schema. - `javax.xml.validation.Schema`

  throws: java.lang.UnsupportedOperationException - When implementation does not override this method."
  ([^DocumentBuilderFactory this ^javax.xml.validation.Schema schema]
    (-> this (.setSchema schema))))

(defn set-attribute
  "Allows the user to set specific attributes on the underlying
   implementation.

   All implementations that implement JAXP 1.5 or newer are required to
   support the XMLConstants.ACCESS_EXTERNAL_DTD and
   XMLConstants.ACCESS_EXTERNAL_SCHEMA properties.




        Setting the XMLConstants.ACCESS_EXTERNAL_DTD property
        restricts the access to external DTDs, external Entity References to the
        protocols specified by the property.
        If access is denied during parsing due to the restriction of this property,
        SAXException will be thrown by the parse methods defined by
        DocumentBuilder.


        Setting the XMLConstants.ACCESS_EXTERNAL_SCHEMA property
        restricts the access to external Schema set by the schemaLocation attribute to
        the protocols specified by the property.  If access is denied during parsing
        due to the restriction of this property, SAXException
        will be thrown by the parse methods defined by
        DocumentBuilder.

  name - The name of the attribute. - `java.lang.String`
  value - The value of the attribute. - `java.lang.Object`

  throws: java.lang.IllegalArgumentException - thrown if the underlying implementation doesn't recognize the attribute."
  ([^DocumentBuilderFactory this ^java.lang.String name ^java.lang.Object value]
    (-> this (.setAttribute name value))))

(defn ignoring-element-content-whitespace?
  "Indicates whether or not the factory is configured to produce
   parsers which ignore ignorable whitespace in element content.

  returns: true if the factory is configured to produce parsers
            which ignore ignorable whitespace in element content;
            false otherwise. - `boolean`"
  (^Boolean [^DocumentBuilderFactory this]
    (-> this (.isIgnoringElementContentWhitespace))))

(defn set-ignoring-comments
  "Specifies that the parser produced by this code will
   ignore comments. By default the value of this is set to false
   .

  ignore-comments - boolean value to ignore comments during processing - `boolean`"
  ([^DocumentBuilderFactory this ^Boolean ignore-comments]
    (-> this (.setIgnoringComments ignore-comments))))

(defn set-x-include-aware
  "Set state of XInclude processing.

   If XInclude markup is found in the document instance, should it be
   processed as specified in
   XML Inclusions (XInclude) Version 1.0.

   XInclude processing defaults to false.

  state - Set XInclude processing to true or false - `boolean`

  throws: java.lang.UnsupportedOperationException - When implementation does not override this method."
  ([^DocumentBuilderFactory this ^Boolean state]
    (-> this (.setXIncludeAware state))))

(defn get-schema
  "Gets the Schema object specified through
   the setSchema(Schema schema) method.

  returns: the Schema object that was last set through
        the setSchema(Schema) method, or null
        if the method was not invoked since a DocumentBuilderFactory
        is created. - `javax.xml.validation.Schema`

  throws: java.lang.UnsupportedOperationException - When implementation does not override this method."
  (^javax.xml.validation.Schema [^DocumentBuilderFactory this]
    (-> this (.getSchema))))

(defn new-document-builder
  "Creates a new instance of a DocumentBuilder
   using the currently configured parameters.

  returns: A new instance of a DocumentBuilder. - `javax.xml.parsers.DocumentBuilder`

  throws: javax.xml.parsers.ParserConfigurationException - if a DocumentBuilder cannot be created which satisfies the configuration requested."
  (^javax.xml.parsers.DocumentBuilder [^DocumentBuilderFactory this]
    (-> this (.newDocumentBuilder))))

(defn set-expand-entity-references
  "Specifies that the parser produced by this code will
   expand entity reference nodes. By default the value of this is set to
   true

  expand-entity-ref - true if the parser produced will expand entity reference nodes; false otherwise. - `boolean`"
  ([^DocumentBuilderFactory this ^Boolean expand-entity-ref]
    (-> this (.setExpandEntityReferences expand-entity-ref))))

(defn set-feature
  "Set a feature for this DocumentBuilderFactory and DocumentBuilders created by this factory.


   Feature names are fully qualified URIs.
   Implementations may define their own features.
   A ParserConfigurationException is thrown if this DocumentBuilderFactory or the
   DocumentBuilders it creates cannot support the feature.
   It is possible for a DocumentBuilderFactory to expose a feature value but be unable to change its state.



   All implementations are required to support the XMLConstants.FEATURE_SECURE_PROCESSING feature.
   When the feature is:


       true: the implementation will limit XML processing to conform to implementation limits.
       Examples include enity expansion limits and XML Schema constructs that would consume large amounts of resources.
       If XML processing is limited for security reasons, it will be reported via a call to the registered
      ErrorHandler.fatalError(SAXParseException exception).
       See DocumentBuilder.setErrorHandler(org.xml.sax.ErrorHandler errorHandler).


       false: the implementation will processing XML according to the XML specifications without
       regard to possible implementation limits.

  name - Feature name. - `java.lang.String`
  value - Is feature state true or false. - `boolean`

  throws: javax.xml.parsers.ParserConfigurationException - if this DocumentBuilderFactory or the DocumentBuilders it creates cannot support this feature."
  ([^DocumentBuilderFactory this ^java.lang.String name ^Boolean value]
    (-> this (.setFeature name value))))

(defn set-ignoring-element-content-whitespace
  "Specifies that the parsers created by this  factory must eliminate
   whitespace in element content (sometimes known loosely as
   'ignorable whitespace') when parsing XML documents (see XML Rec
   2.10). Note that only whitespace which is directly contained within
   element content that has an element only content model (see XML
   Rec 3.2.1) will be eliminated. Due to reliance on the content model
   this setting requires the parser to be in validating mode. By default
   the value of this is set to false.

  whitespace - true if the parser created must eliminate whitespace in the element content when parsing XML documents; false otherwise. - `boolean`"
  ([^DocumentBuilderFactory this ^Boolean whitespace]
    (-> this (.setIgnoringElementContentWhitespace whitespace))))

(defn namespace-aware?
  "Indicates whether or not the factory is configured to produce
   parsers which are namespace aware.

  returns: true if the factory is configured to produce parsers which
            are namespace aware; false otherwise. - `boolean`"
  (^Boolean [^DocumentBuilderFactory this]
    (-> this (.isNamespaceAware))))

(defn ignoring-comments?
  "Indicates whether or not the factory is configured to produce
   parsers which ignores comments.

  returns: true if the factory is configured to produce parsers
            which ignores comments; false otherwise. - `boolean`"
  (^Boolean [^DocumentBuilderFactory this]
    (-> this (.isIgnoringComments))))

(defn validating?
  "Indicates whether or not the factory is configured to produce
   parsers which validate the XML content during parse.

  returns: true if the factory is configured to produce parsers
            which validate the XML content during parse; false otherwise. - `boolean`"
  (^Boolean [^DocumentBuilderFactory this]
    (-> this (.isValidating))))

(defn x-include-aware?
  "Get state of XInclude processing.

  returns: current state of XInclude processing - `boolean`

  throws: java.lang.UnsupportedOperationException - When implementation does not override this method."
  (^Boolean [^DocumentBuilderFactory this]
    (-> this (.isXIncludeAware))))

(defn expand-entity-references?
  "Indicates whether or not the factory is configured to produce
   parsers which expand entity reference nodes.

  returns: true if the factory is configured to produce parsers
            which expand entity reference nodes; false otherwise. - `boolean`"
  (^Boolean [^DocumentBuilderFactory this]
    (-> this (.isExpandEntityReferences))))

