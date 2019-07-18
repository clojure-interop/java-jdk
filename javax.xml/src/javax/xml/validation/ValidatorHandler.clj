(ns javax.xml.validation.ValidatorHandler
  "Streaming validator that works on SAX stream.


  A ValidatorHandler object is not thread-safe and not reentrant.
  In other words, it is the application's responsibility to make
  sure that one ValidatorHandler object is not used from
  more than one thread at any given time.


  ValidatorHandler checks if the SAX events follow
  the set of constraints described in the associated Schema,
  and additionally it may modify the SAX events (for example
  by adding default values, etc.)


  ValidatorHandler extends from ContentHandler,
  but it refines the underlying ContentHandler in
  the following way:

   startElement/endElement events must receive non-null String
       for uri, localName, and qname,
       even though SAX allows some of them to be null.
       Similarly, the user-specified ContentHandler will receive non-null
       Strings for all three parameters.

   Applications must ensure that ValidatorHandler's
       ContentHandler.startPrefixMapping(String,String) and
       ContentHandler.endPrefixMapping(String) are invoked
       properly. Similarly, the user-specified ContentHandler
       will receive startPrefixMapping/endPrefixMapping events.
       If the ValidatorHandler introduces additional namespace
       bindings, the user-specified ContentHandler will receive
       additional startPrefixMapping/endPrefixMapping events.

   Attributes for the
       ContentHandler.startElement(String,String,String,Attributes) method
       may or may not include xmlns* attributes.



  A ValidatorHandler is automatically reset every time
  the startDocument method is invoked.

  Recognized Properties and Features

  This spec defines the following feature that must be recognized
  by all ValidatorHandler implementations.

  http://xml.org/sax/features/namespace-prefixes

  This feature controls how a ValidatorHandler introduces
  namespace bindings that were not present in the original SAX event
  stream.
  When this feature is set to true, it must make
  sure that the user's ContentHandler will see
  the corresponding xmlns* attribute in
  the Attributes object of the
  ContentHandler.startElement(String,String,String,Attributes)
  callback. Otherwise, xmlns* attributes must not be
  added to Attributes that's passed to the
  user-specified ContentHandler.

  (Note that regardless of this switch, namespace bindings are
  always notified to applications through
  ContentHandler.startPrefixMapping(String,String) and
  ContentHandler.endPrefixMapping(String) methods of the
  ContentHandler specified by the user.)


  Note that this feature does NOT affect the way
  a ValidatorHandler receives SAX events. It merely
  changes the way it augments SAX events.

  This feature is set to false by default."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.xml.validation ValidatorHandler]))

(defn set-content-handler
  "Sets the ContentHandler which receives
   the augmented validation result.


   When a ContentHandler is specified, a
   ValidatorHandler will work as a filter
   and basically copy the incoming events to the
   specified ContentHandler.


   In doing so, a ValidatorHandler may modify
   the events, for example by adding defaulted attributes.


   A ValidatorHandler may buffer events to certain
   extent, but to allow ValidatorHandler to be used
   by a parser, the following requirement has to be met.


    When
        ContentHandler.startElement(String, String, String, Attributes),
        ContentHandler.endElement(String, String, String),
        ContentHandler.startDocument(), or
        ContentHandler.endDocument()
        are invoked on a ValidatorHandler,
        the same method on the user-specified ContentHandler
        must be invoked for the same event before the callback
        returns.
    ValidatorHandler may not introduce new elements that
        were not present in the input.

    ValidatorHandler may not remove attributes that were
        present in the input.



   When a callback method on the specified ContentHandler
   throws an exception, the same exception object must be thrown
   from the ValidatorHandler. The ErrorHandler
   should not be notified of such an exception.


   This method can be called even during a middle of a validation.

  receiver - A ContentHandler or a null value. - `org.xml.sax.ContentHandler`"
  ([^ValidatorHandler this ^org.xml.sax.ContentHandler receiver]
    (-> this (.setContentHandler receiver))))

(defn get-feature?
  "Look up the value of a feature flag.

   The feature name is any fully-qualified URI.  It is
   possible for a ValidatorHandler to recognize a feature name but
   temporarily be unable to return its value.
   Some feature values may be available only in specific
   contexts, such as before, during, or after a validation.

   Implementors are free (and encouraged) to invent their own features,
   using names built on their own URIs.

  name - The feature name, which is a non-null fully-qualified URI. - `java.lang.String`

  returns: The current value of the feature (true or false). - `boolean`

  throws: org.xml.sax.SAXNotRecognizedException - If the feature value can't be assigned or retrieved."
  (^Boolean [^ValidatorHandler this ^java.lang.String name]
    (-> this (.getFeature name))))

(defn get-resource-resolver
  "Gets the current LSResourceResolver set to this ValidatorHandler.

  returns: This method returns the object that was last set through
        the setResourceResolver(LSResourceResolver) method, or null
        if that method has never been called since this ValidatorHandler
        has created. - `org.w3c.dom.ls.LSResourceResolver`"
  (^org.w3c.dom.ls.LSResourceResolver [^ValidatorHandler this]
    (-> this (.getResourceResolver))))

(defn set-resource-resolver
  "Sets the LSResourceResolver to customize
   resource resolution while in a validation episode.


   ValidatorHandler uses a LSResourceResolver
   when it needs to locate external resources while a validation,
   although exactly what constitutes `locating external resources` is
   up to each schema language.


   When the LSResourceResolver is null, the implementation will
   behave as if the following LSResourceResolver is set:


   class DumbLSResourceResolver implements LSResourceResolver {
       public LSInput resolveResource(
           String publicId, String systemId, String baseURI) {

           return null; // always return null
       }
   }


   If a LSResourceResolver throws a RuntimeException
    (or instances of its derived classes),
   then the ValidatorHandler will abort the parsing and
   the caller of the validate method will receive
   the same RuntimeException.


   When a new ValidatorHandler object is created, initially
   this field is set to null.

  resource-resolver - A new resource resolver to be set. This parameter can be null. - `org.w3c.dom.ls.LSResourceResolver`"
  ([^ValidatorHandler this ^org.w3c.dom.ls.LSResourceResolver resource-resolver]
    (-> this (.setResourceResolver resource-resolver))))

(defn get-type-info-provider
  "Obtains the TypeInfoProvider implementation of this
   ValidatorHandler.


   The obtained TypeInfoProvider can be queried during a parse
   to access the type information determined by the validator.


   Some schema languages do not define the notion of type,
   for those languages, this method may not be supported.
   However, to be compliant with this specification, implementations
   for W3C XML Schema 1.0 must support this operation.

  returns: null if the validator / schema language does not support
        the notion of TypeInfo.
        Otherwise a non-null valid TypeInfoProvider. - `javax.xml.validation.TypeInfoProvider`"
  (^javax.xml.validation.TypeInfoProvider [^ValidatorHandler this]
    (-> this (.getTypeInfoProvider))))

(defn get-error-handler
  "Gets the current ErrorHandler set to this ValidatorHandler.

  returns: This method returns the object that was last set through
        the setErrorHandler(ErrorHandler) method, or null
        if that method has never been called since this ValidatorHandler
        has created. - `org.xml.sax.ErrorHandler`"
  (^org.xml.sax.ErrorHandler [^ValidatorHandler this]
    (-> this (.getErrorHandler))))

(defn set-error-handler
  "Sets the ErrorHandler to receive errors encountered
   during the validation.


   Error handler can be used to customize the error handling process
   during a validation. When an ErrorHandler is set,
   errors found during the validation will be first sent
   to the ErrorHandler.


   The error handler can abort further validation immediately
   by throwing SAXException from the handler. Or for example
   it can print an error to the screen and try to continue the
   validation by returning normally from the ErrorHandler


   If any Throwable is thrown from an ErrorHandler,
   the same Throwable object will be thrown toward the
   root of the call stack.


   ValidatorHandler is not allowed to
   throw SAXException without first reporting it to
   ErrorHandler.


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


   When a new ValidatorHandler object is created, initially
   this field is set to null.

  error-handler - A new error handler to be set. This parameter can be null. - `org.xml.sax.ErrorHandler`"
  ([^ValidatorHandler this ^org.xml.sax.ErrorHandler error-handler]
    (-> this (.setErrorHandler error-handler))))

(defn get-property
  "Look up the value of a property.

   The property name is any fully-qualified URI.  It is
   possible for a ValidatorHandler to recognize a property name but
   temporarily be unable to return its value.
   Some property values may be available only in specific
   contexts, such as before, during, or after a validation.

   ValidatorHandlers are not required to recognize any specific
   property names.

   Implementors are free (and encouraged) to invent their own properties,
   using names built on their own URIs.

  name - The property name, which is a non-null fully-qualified URI. - `java.lang.String`

  returns: The current value of the property. - `java.lang.Object`

  throws: org.xml.sax.SAXNotRecognizedException - If the property value can't be assigned or retrieved."
  (^java.lang.Object [^ValidatorHandler this ^java.lang.String name]
    (-> this (.getProperty name))))

(defn set-feature
  "Set a feature for this ValidatorHandler.

   Feature can be used to control the way a
   ValidatorHandler parses schemas. The feature name is
   any fully-qualified URI. It is possible for a
   SchemaFactory to
   expose a feature value but to be unable to change the current
   value. Some feature values may be immutable or mutable only in
   specific contexts, such as before, during, or after a
   validation.

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
  ([^ValidatorHandler this ^java.lang.String name ^Boolean value]
    (-> this (.setFeature name value))))

(defn set-property
  "Set the value of a property.

   The property name is any fully-qualified URI.  It is
   possible for a ValidatorHandler to recognize a property name but
   to be unable to change the current value.
   Some property values may be immutable or mutable only
   in specific contexts, such as before, during, or after
   a validation.

   ValidatorHandlers are not required to recognize setting
   any specific property names.

  name - The property name, which is a non-null fully-qualified URI. - `java.lang.String`
  object - The requested value for the property. - `java.lang.Object`

  throws: org.xml.sax.SAXNotRecognizedException - If the property value can't be assigned or retrieved."
  ([^ValidatorHandler this ^java.lang.String name ^java.lang.Object object]
    (-> this (.setProperty name object))))

(defn get-content-handler
  "Gets the ContentHandler which receives the
   augmented validation result.

  returns: This method returns the object that was last set through
        the getContentHandler() method, or null
        if that method has never been called since this ValidatorHandler
        has created. - `org.xml.sax.ContentHandler`"
  (^org.xml.sax.ContentHandler [^ValidatorHandler this]
    (-> this (.getContentHandler))))

