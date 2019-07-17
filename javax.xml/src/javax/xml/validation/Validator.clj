(ns javax.xml.validation.Validator
  "A processor that checks an XML document against Schema.


  A validator object is not thread-safe and not reentrant.
  In other words, it is the application's responsibility to make
  sure that one Validator object is not used from
  more than one thread at any given time, and while the validate
  method is invoked, applications may not recursively call
  the validate method."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.xml.validation Validator]))

(defn get-feature?
  "Look up the value of a feature flag.

   The feature name is any fully-qualified URI.  It is
   possible for a Validator to recognize a feature name but
   temporarily be unable to return its value.
   Some feature values may be available only in specific
   contexts, such as before, during, or after a validation.

   Implementors are free (and encouraged) to invent their own features,
   using names built on their own URIs.

  name - The feature name, which is a non-null fully-qualified URI. - `java.lang.String`

  returns: The current value of the feature (true or false). - `boolean`

  throws: org.xml.sax.SAXNotRecognizedException - If the feature value can't be assigned or retrieved."
  (^Boolean [^javax.xml.validation.Validator this ^java.lang.String name]
    (-> this (.getFeature name))))

(defn get-resource-resolver
  "Gets the current LSResourceResolver set to this Validator.

  returns: This method returns the object that was last set through
        the setResourceResolver(LSResourceResolver) method, or null
        if that method has never been called since this Validator
        has created. - `org.w3c.dom.ls.LSResourceResolver`"
  (^org.w3c.dom.ls.LSResourceResolver [^javax.xml.validation.Validator this]
    (-> this (.getResourceResolver))))

(defn set-resource-resolver
  "Sets the LSResourceResolver to customize
   resource resolution while in a validation episode.


   Validator uses a LSResourceResolver
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
   then the Validator will abort the parsing and
   the caller of the validate method will receive
   the same RuntimeException.


   When a new Validator object is created, initially
   this field is set to null.

  resource-resolver - A new resource resolver to be set. This parameter can be null. - `org.w3c.dom.ls.LSResourceResolver`"
  ([^javax.xml.validation.Validator this ^org.w3c.dom.ls.LSResourceResolver resource-resolver]
    (-> this (.setResourceResolver resource-resolver))))

(defn validate
  "Validates the specified input and send the augmented validation
   result to the specified output.

   This method places the following restrictions on the types of
   the Source/Result accepted.




     Source / Result Accepted



     StreamSource
     SAXSource
     DOMSource
     StAXSource




     null
     OK
     OK
     OK
     OK


     StreamResult
     OK
     IllegalArgumentException
     IllegalArgumentException
     IllegalArgumentException


     SAXResult
     IllegalArgumentException
     OK
     IllegalArgumentException
     IllegalArgumentException


     DOMResult
     IllegalArgumentException
     IllegalArgumentException
     OK
     IllegalArgumentException


     StAXResult
     IllegalArgumentException
     IllegalArgumentException
     IllegalArgumentException
     OK




   To validate one Source into another kind of
   Result, use the identity transformer (see
   TransformerFactory.newTransformer()).

   Errors found during the validation is sent to the specified
   ErrorHandler.

   If a document is valid, or if a document contains some errors
   but none of them were fatal and the ErrorHandler didn't
   throw any exception, then the method returns normally.

  source - XML to be validated. Must be an XML document or XML element and must not be null. For backwards compatibility, the results of attempting to validate anything other than a document or element are implementation-dependent. Implementations must either recognize and process the input or throw an IllegalArgumentException. - `javax.xml.transform.Source`
  result - The Result object that receives (possibly augmented) XML. This parameter can be null if the caller is not interested in it. Note that when a DOMResult is used, a validator might just pass the same DOM node from DOMSource to DOMResult (in which case source.getNode()==result.getNode()), it might copy the entire DOM tree, or it might alter the node given by the source. - `javax.xml.transform.Result`

  throws: java.lang.IllegalArgumentException - If the Result type doesn't match the Source type of if the Source is an XML artifact that the implementation cannot validate (for example, a processing instruction)."
  ([^javax.xml.validation.Validator this ^javax.xml.transform.Source source ^javax.xml.transform.Result result]
    (-> this (.validate source result)))
  ([^javax.xml.validation.Validator this ^javax.xml.transform.Source source]
    (-> this (.validate source))))

(defn get-error-handler
  "Gets the current ErrorHandler set to this Validator.

  returns: This method returns the object that was last set through
        the setErrorHandler(ErrorHandler) method, or null
        if that method has never been called since this Validator
        has created. - `org.xml.sax.ErrorHandler`"
  (^org.xml.sax.ErrorHandler [^javax.xml.validation.Validator this]
    (-> this (.getErrorHandler))))

(defn reset
  "Reset this Validator to its original configuration.

   Validator is reset to the same state as when it was created with
   Schema.newValidator().
   reset() is designed to allow the reuse of existing Validators
   thus saving resources associated with the creation of new Validators.

   The reset Validator is not guaranteed to have the same LSResourceResolver or ErrorHandler
   Objects, e.g. Object.equals(Object obj).  It is guaranteed to have a functionally equal
   LSResourceResolver and ErrorHandler."
  ([^javax.xml.validation.Validator this]
    (-> this (.reset))))

(defn set-error-handler
  "Sets the ErrorHandler to receive errors encountered
   during the validate method invocation.


   Error handler can be used to customize the error handling process
   during a validation. When an ErrorHandler is set,
   errors found during the validation will be first sent
   to the ErrorHandler.


   The error handler can abort further validation immediately
   by throwing SAXException from the handler. Or for example
   it can print an error to the screen and try to continue the
   validation by returning normally from the ErrorHandler


   If any Throwable is thrown from an ErrorHandler,
   the caller of the validate method will be thrown
   the same Throwable object.


   Validator is not allowed to
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


   When a new Validator object is created, initially
   this field is set to null.

  error-handler - A new error handler to be set. This parameter can be null. - `org.xml.sax.ErrorHandler`"
  ([^javax.xml.validation.Validator this ^org.xml.sax.ErrorHandler error-handler]
    (-> this (.setErrorHandler error-handler))))

(defn get-property
  "Look up the value of a property.

   The property name is any fully-qualified URI.  It is
   possible for a Validator to recognize a property name but
   temporarily be unable to return its value.
   Some property values may be available only in specific
   contexts, such as before, during, or after a validation.

   Validators are not required to recognize any specific
   property names.

   Implementors are free (and encouraged) to invent their own properties,
   using names built on their own URIs.

  name - The property name, which is a non-null fully-qualified URI. - `java.lang.String`

  returns: The current value of the property. - `java.lang.Object`

  throws: org.xml.sax.SAXNotRecognizedException - If the property value can't be assigned or retrieved."
  (^java.lang.Object [^javax.xml.validation.Validator this ^java.lang.String name]
    (-> this (.getProperty name))))

(defn set-feature
  "Set the value of a feature flag.


   Feature can be used to control the way a Validator
   parses schemas, although Validators are not required
   to recognize any specific feature names.

   The feature name is any fully-qualified URI.  It is
   possible for a Validator to expose a feature value but
   to be unable to change the current value.
   Some feature values may be immutable or mutable only
   in specific contexts, such as before, during, or after
   a validation.

  name - The feature name, which is a non-null fully-qualified URI. - `java.lang.String`
  value - The requested value of the feature (true or false). - `boolean`

  throws: org.xml.sax.SAXNotRecognizedException - If the feature value can't be assigned or retrieved."
  ([^javax.xml.validation.Validator this ^java.lang.String name ^Boolean value]
    (-> this (.setFeature name value))))

(defn set-property
  "Set the value of a property.

   The property name is any fully-qualified URI.  It is
   possible for a Validator to recognize a property name but
   to be unable to change the current value.
   Some property values may be immutable or mutable only
   in specific contexts, such as before, during, or after
   a validation.


   All implementations that implement JAXP 1.5 or newer are required to
   support the XMLConstants.ACCESS_EXTERNAL_DTD and
   XMLConstants.ACCESS_EXTERNAL_SCHEMA properties.



        Access to external DTDs in source or Schema file is restricted to
        the protocols specified by the XMLConstants.ACCESS_EXTERNAL_DTD
        property.  If access is denied during validation due to the restriction
        of this property, SAXException will be thrown by the
        validate(Source) method.

        Access to external reference set by the schemaLocation attribute is
        restricted to the protocols specified by the
        XMLConstants.ACCESS_EXTERNAL_SCHEMA property.
        If access is denied during validation due to the restriction of this property,
        SAXException will be thrown by the
        validate(Source) method.

  name - The property name, which is a non-null fully-qualified URI. - `java.lang.String`
  object - The requested value for the property. - `java.lang.Object`

  throws: org.xml.sax.SAXNotRecognizedException - If the property value can't be assigned or retrieved."
  ([^javax.xml.validation.Validator this ^java.lang.String name ^java.lang.Object object]
    (-> this (.setProperty name object))))

