(ns javax.xml.validation.SchemaFactory
  "Factory that creates Schema objects. Entry-point to
  the validation API.


  SchemaFactory is a schema compiler. It reads external
  representations of schemas and prepares them for validation.


  The SchemaFactory class is not thread-safe. In other words,
  it is the application's responsibility to ensure that at most
  one thread is using a SchemaFactory object at any
  given moment. Implementations are encouraged to mark methods
  as synchronized to protect themselves from broken clients.


  SchemaFactory is not re-entrant. While one of the
  newSchema methods is being invoked, applications
  may not attempt to recursively invoke the newSchema method,
  even from the same thread.

  Schema Language

  This spec uses a namespace URI to designate a schema language.
  The following table shows the values defined by this specification.

  To be compliant with the spec, the implementation
  is only required to support W3C XML Schema 1.0. However,
  if it chooses to support other schema languages listed here,
  it must conform to the relevant behaviors described in this spec.


  Schema languages not listed here are expected to
  introduce their own URIs to represent themselves.
  The SchemaFactory class is capable of locating other
  implementations for other schema languages at run-time.


  Note that because the XML DTD is strongly tied to the parsing process
  and has a significant effect on the parsing process, it is impossible
  to define the DTD validation as a process independent from parsing.
  For this reason, this specification does not define the semantics for
  the XML DTD. This doesn't prohibit implementors from implementing it
  in a way they see fit, but users are warned that any DTD
  validation implemented on this interface necessarily deviate from
  the XML DTD semantics as defined in the XML 1.0.




        value
        language




        XMLConstants.W3C_XML_SCHEMA_NS_URI (\"http://www.w3.org/2001/XMLSchema\")
        W3C XML Schema 1.0


        XMLConstants.RELAXNG_NS_URI (\"http://relaxng.org/ns/structure/1.0\")
        RELAX NG 1.0"
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.xml.validation SchemaFactory]))

(defn *new-instance
  "Obtain a new instance of a SchemaFactory from class name. SchemaFactory
   is returned if specified factory class name supports the specified schema language.
   This function is useful when there are multiple providers in the classpath.
   It gives more control to the application as it can specify which provider
   should be loaded.

   Tip for Trouble-shooting
   Setting the jaxp.debug system property will cause
   this method to print a lot of debug messages
   to System.err about what it is doing and where it is looking at.

    If you have problems try:


   java -Djaxp.debug=1 YourProgram ....

  schema-language - Specifies the schema language which the returned SchemaFactory will understand. See the list of available schema languages for the possible values. - `java.lang.String`
  factory-class-name - fully qualified factory class name that provides implementation of javax.xml.validation.SchemaFactory. - `java.lang.String`
  class-loader - ClassLoader used to load the factory class. If null current Thread's context classLoader is used to load the factory class. - `java.lang.ClassLoader`

  returns: New instance of a SchemaFactory - `javax.xml.validation.SchemaFactory`

  throws: java.lang.IllegalArgumentException - if factoryClassName is null, or the factory class cannot be loaded, instantiated or doesn't support the schema language specified in schemLanguage parameter."
  (^javax.xml.validation.SchemaFactory [^java.lang.String schema-language ^java.lang.String factory-class-name ^java.lang.ClassLoader class-loader]
    (SchemaFactory/newInstance schema-language factory-class-name class-loader))
  (^javax.xml.validation.SchemaFactory [^java.lang.String schema-language]
    (SchemaFactory/newInstance schema-language)))

(defn get-feature?
  "Look up the value of a feature flag.

   The feature name is any fully-qualified URI.  It is
   possible for a SchemaFactory to recognize a feature name but
   temporarily be unable to return its value.

   Implementors are free (and encouraged) to invent their own features,
   using names built on their own URIs.

  name - The feature name, which is a non-null fully-qualified URI. - `java.lang.String`

  returns: The current value of the feature (true or false). - `boolean`

  throws: org.xml.sax.SAXNotRecognizedException - If the feature value can't be assigned or retrieved."
  (^Boolean [^SchemaFactory this ^java.lang.String name]
    (-> this (.getFeature name))))

(defn get-resource-resolver
  "Gets the current LSResourceResolver set to this SchemaFactory.

  returns: This method returns the object that was last set through
        the setResourceResolver(LSResourceResolver) method, or null
        if that method has never been called since this SchemaFactory
        has created. - `org.w3c.dom.ls.LSResourceResolver`"
  (^org.w3c.dom.ls.LSResourceResolver [^SchemaFactory this]
    (-> this (.getResourceResolver))))

(defn set-resource-resolver
  "Sets the LSResourceResolver to customize
   resource resolution when parsing schemas.


   SchemaFactory uses a LSResourceResolver
   when it needs to locate external resources while parsing schemas,
   although exactly what constitutes \"locating external resources\" is
   up to each schema language. For example, for W3C XML Schema,
   this includes files <include>d or <import>ed,
   and DTD referenced from schema files, etc.


   Applications can call this method even during a Schema
   is being parsed.


   When the LSResourceResolver is null, the implementation will
   behave as if the following LSResourceResolver is set:


   class DumbDOMResourceResolver implements LSResourceResolver {
       public LSInput resolveResource(
           String publicId, String systemId, String baseURI) {

           return null; // always return null
       }
   }


   If a LSResourceResolver throws a RuntimeException
    (or instances of its derived classes),
   then the SchemaFactory will abort the parsing and
   the caller of the newSchema method will receive
   the same RuntimeException.


   When a new SchemaFactory object is created, initially
   this field is set to null.  This field will NOT be
   inherited to Schemas, Validators, or
   ValidatorHandlers that are created from this SchemaFactory.

  resource-resolver - A new resource resolver to be set. This parameter can be null. - `org.w3c.dom.ls.LSResourceResolver`"
  ([^SchemaFactory this ^org.w3c.dom.ls.LSResourceResolver resource-resolver]
    (-> this (.setResourceResolver resource-resolver))))

(defn get-error-handler
  "Gets the current ErrorHandler set to this SchemaFactory.

  returns: This method returns the object that was last set through
        the setErrorHandler(ErrorHandler) method, or null
        if that method has never been called since this SchemaFactory
        has created. - `org.xml.sax.ErrorHandler`"
  (^org.xml.sax.ErrorHandler [^SchemaFactory this]
    (-> this (.getErrorHandler))))

(defn schema-language-supported?
  "Is specified schema supported by this SchemaFactory?

  schema-language - Specifies the schema language which the returned SchemaFactory will understand. schemaLanguage must specify a valid schema language. - `java.lang.String`

  returns: true if SchemaFactory supports schemaLanguage, else false. - `boolean`

  throws: java.lang.NullPointerException - If schemaLanguage is null."
  (^Boolean [^SchemaFactory this ^java.lang.String schema-language]
    (-> this (.isSchemaLanguageSupported schema-language))))

(defn set-error-handler
  "Sets the ErrorHandler to receive errors encountered
   during the newSchema method invocation.


   Error handler can be used to customize the error handling process
   during schema parsing. When an ErrorHandler is set,
   errors found during the parsing of schemas will be first sent
   to the ErrorHandler.


   The error handler can abort the parsing of a schema immediately
   by throwing SAXException from the handler. Or for example
   it can print an error to the screen and try to continue the
   processing by returning normally from the ErrorHandler


   If any Throwable (or instances of its derived classes)
   is thrown from an ErrorHandler,
   the caller of the newSchema method will be thrown
   the same Throwable object.


   SchemaFactory is not allowed to
   throw SAXException without first reporting it to
   ErrorHandler.


   Applications can call this method even during a Schema
   is being parsed.


   When the ErrorHandler is null, the implementation will
   behave as if the following ErrorHandler is set:


   class DraconianErrorHandler implements ErrorHandler {
       public void fatalError( SAXParseException e ) throws SAXException {
           throw e;
       }
       public void error( SAXParseException e ) throws SAXException {
           throw e;
       }
       public void warning( SAXParseException e ) throws SAXException {
           // noop
       }
   }


   When a new SchemaFactory object is created, initially
   this field is set to null. This field will NOT be
   inherited to Schemas, Validators, or
   ValidatorHandlers that are created from this SchemaFactory.

  error-handler - A new error handler to be set. This parameter can be null. - `org.xml.sax.ErrorHandler`"
  ([^SchemaFactory this ^org.xml.sax.ErrorHandler error-handler]
    (-> this (.setErrorHandler error-handler))))

(defn get-property
  "Look up the value of a property.

   The property name is any fully-qualified URI.  It is
   possible for a SchemaFactory to recognize a property name but
   temporarily be unable to return its value.

   SchemaFactorys are not required to recognize any specific
   property names.

   Implementors are free (and encouraged) to invent their own properties,
   using names built on their own URIs.

  name - The property name, which is a non-null fully-qualified URI. - `java.lang.String`

  returns: The current value of the property. - `java.lang.Object`

  throws: org.xml.sax.SAXNotRecognizedException - If the property value can't be assigned or retrieved."
  (^java.lang.Object [^SchemaFactory this ^java.lang.String name]
    (-> this (.getProperty name))))

(defn new-schema
  "Parses the specified source as a schema and returns it as a schema.

   This is a convenience method for newSchema(Source[] schemas).

  schema - Source that represents a schema. - `javax.xml.transform.Source`

  returns: New Schema from parsing schema. - `javax.xml.validation.Schema`

  throws: org.xml.sax.SAXException - If a SAX error occurs during parsing."
  (^javax.xml.validation.Schema [^SchemaFactory this ^javax.xml.transform.Source schema]
    (-> this (.newSchema schema)))
  (^javax.xml.validation.Schema [^SchemaFactory this]
    (-> this (.newSchema))))

(defn set-feature
  "Set a feature for this SchemaFactory,
   Schemas created by this factory, and by extension,
   Validators and ValidatorHandlers created by
   those Schemas.


   Implementors and developers should pay particular attention
   to how the special Schema object returned by newSchema() is processed. In some cases, for example, when the
   SchemaFactory and the class actually loading the
   schema come from different implementations, it may not be possible
   for SchemaFactory features to be inherited automatically.
   Developers should
   make sure that features, such as secure processing, are explicitly
   set in both places.

   The feature name is any fully-qualified URI. It is
   possible for a SchemaFactory to expose a feature value but
   to be unable to change the current value.

   All implementations are required to support the XMLConstants.FEATURE_SECURE_PROCESSING feature.
   When the feature is:


       true: the implementation will limit XML processing to conform to implementation limits.
       Examples include enity expansion limits and XML Schema constructs that would consume large amounts of resources.
       If XML processing is limited for security reasons, it will be reported via a call to the registered
      ErrorHandler.fatalError(SAXParseException exception).
       See setErrorHandler(ErrorHandler errorHandler).


       false: the implementation will processing XML according to the XML specifications without
       regard to possible implementation limits.

  name - The feature name, which is a non-null fully-qualified URI. - `java.lang.String`
  value - The requested value of the feature (true or false). - `boolean`

  throws: org.xml.sax.SAXNotRecognizedException - If the feature value can't be assigned or retrieved."
  ([^SchemaFactory this ^java.lang.String name ^Boolean value]
    (-> this (.setFeature name value))))

(defn set-property
  "Set the value of a property.

   The property name is any fully-qualified URI.  It is
   possible for a SchemaFactory to recognize a property name but
   to be unable to change the current value.


   All implementations that implement JAXP 1.5 or newer are required to
   support the XMLConstants.ACCESS_EXTERNAL_DTD and
   XMLConstants.ACCESS_EXTERNAL_SCHEMA properties.



        Access to external DTDs in Schema files is restricted to the protocols
        specified by the XMLConstants.ACCESS_EXTERNAL_DTD property.
        If access is denied during the creation of new Schema due to the restriction
        of this property, SAXException will be thrown by the
        newSchema(Source) or newSchema(File)
        or newSchema(URL) or  or newSchema(Source[]) method.

        Access to external DTDs in xml source files is restricted to the protocols
        specified by the XMLConstants.ACCESS_EXTERNAL_DTD property.
        If access is denied during validation due to the restriction
        of this property, SAXException will be thrown by the
        Validator.validate(Source) or
        Validator.validate(Source, Result) method.

        Access to external reference set by the schemaLocation attribute is
        restricted to the protocols specified by the
        XMLConstants.ACCESS_EXTERNAL_SCHEMA property.
        If access is denied during validation due to the restriction of this property,
        SAXException will be thrown by the
        Validator.validate(Source) or
        Validator.validate(Source, Result) method.

        Access to external reference set by the Import
        and Include element is restricted to the protocols specified by the
        XMLConstants.ACCESS_EXTERNAL_SCHEMA property.
        If access is denied during the creation of new Schema due to the restriction
        of this property, SAXException will be thrown by the
        newSchema(Source) or newSchema(File)
        or newSchema(URL) or newSchema(Source[]) method.

  name - The property name, which is a non-null fully-qualified URI. - `java.lang.String`
  object - The requested value for the property. - `java.lang.Object`

  throws: org.xml.sax.SAXNotRecognizedException - If the property value can't be assigned or retrieved."
  ([^SchemaFactory this ^java.lang.String name ^java.lang.Object object]
    (-> this (.setProperty name object))))

