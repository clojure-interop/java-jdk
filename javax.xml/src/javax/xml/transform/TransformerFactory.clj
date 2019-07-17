(ns javax.xml.transform.TransformerFactory
  "A TransformerFactory instance can be used to create
  Transformer and
  Templates objects.

  The system property that determines which Factory implementation
  to create is named `javax.xml.transform.TransformerFactory`.
  This property names a concrete subclass of the
  TransformerFactory abstract class. If the property is not
  defined, a platform default is be used."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.xml.transform TransformerFactory]))

(defn *new-instance
  "Obtain a new instance of a TransformerFactory from factory class name.
   This function is useful when there are multiple providers in the classpath.
   It gives more control to the application as it can specify which provider
   should be loaded.

   Once an application has obtained a reference to a
   TransformerFactory it can use the factory to configure
   and obtain transformer instances.

   Tip for Trouble-shooting
   Setting the jaxp.debug system property will cause
   this method to print a lot of debug messages
   to System.err about what it is doing and where it is looking at.

    If you have problems try:


   java -Djaxp.debug=1 YourProgram ....

  factory-class-name - fully qualified factory class name that provides implementation of javax.xml.transform.TransformerFactory. - `java.lang.String`
  class-loader - ClassLoader used to load the factory class. If null current Thread's context classLoader is used to load the factory class. - `java.lang.ClassLoader`

  returns: new TransformerFactory instance, never null. - `javax.xml.transform.TransformerFactory`

  throws: javax.xml.transform.TransformerFactoryConfigurationError - if factoryClassName is null, or the factory class cannot be loaded, instantiated."
  ([factory-class-name class-loader]
    (TransformerFactory/newInstance factory-class-name class-loader))
  ([]
    (TransformerFactory/newInstance )))

(defn get-feature?
  "Look up the value of a feature.


   Feature names are fully qualified URIs.
   Implementations may define their own features.
   false is returned if this TransformerFactory or the
   Transformers or Templates it creates cannot support the feature.
   It is possible for an TransformerFactory to expose a feature value but be unable to change its state.

  name - Feature name. - `java.lang.String`

  returns: The current state of the feature, true or false. - `boolean`

  throws: java.lang.NullPointerException - If the name parameter is null."
  ([this name]
    (-> this (.getFeature name))))

(defn set-error-listener
  "Set the error event listener for the TransformerFactory, which
   is used for the processing of transformation instructions,
   and not for the transformation itself.
   An IllegalArgumentException is thrown if the
   ErrorListener listener is null.

  listener - The new error listener. - `javax.xml.transform.ErrorListener`

  throws: java.lang.IllegalArgumentException - When listener is null"
  ([this listener]
    (-> this (.setErrorListener listener))))

(defn get-error-listener
  "Get the error event handler for the TransformerFactory.

  returns: The current error handler, which should never be null. - `javax.xml.transform.ErrorListener`"
  ([this]
    (-> this (.getErrorListener))))

(defn new-templates
  "Process the Source into a Templates object, which is a
   a compiled representation of the source. This Templates object
   may then be used concurrently across multiple threads.  Creating
   a Templates object allows the TransformerFactory to do detailed
   performance optimization of transformation instructions, without
   penalizing runtime transformation.

  source - An object that holds a URL, input stream, etc. - `javax.xml.transform.Source`

  returns: A Templates object capable of being used for transformation
     purposes, never null. - `javax.xml.transform.Templates`

  throws: javax.xml.transform.TransformerConfigurationException - When parsing to construct the Templates object fails."
  ([this source]
    (-> this (.newTemplates source))))

(defn get-attribute
  "Allows the user to retrieve specific attributes on the underlying
   implementation.
   An IllegalArgumentException is thrown if the underlying
   implementation doesn't recognize the attribute.

  name - The name of the attribute. - `java.lang.String`

  returns: value The value of the attribute. - `java.lang.Object`

  throws: java.lang.IllegalArgumentException - When implementation does not recognize the attribute."
  ([this name]
    (-> this (.getAttribute name))))

(defn new-transformer
  "Process the Source into a Transformer
   Object.  The Source is an XSLT document that
   conforms to
   XSL Transformations (XSLT) Version 1.0.  Care must
   be taken not to use this Transformer in multiple
   Threads running concurrently.
   Different TransformerFactories can be used concurrently by
   different Threads.

  source - Source of XSLT document used to create Transformer. Examples of XML Sources include DOMSource, SAXSource, and StreamSource. - `javax.xml.transform.Source`

  returns: A Transformer object that may be used to perform
     a transformation in a single Thread, never
     null. - `javax.xml.transform.Transformer`

  throws: javax.xml.transform.TransformerConfigurationException - Thrown if there are errors when parsing the Source or it is not possible to create a Transformer instance."
  ([this source]
    (-> this (.newTransformer source)))
  ([this]
    (-> this (.newTransformer))))

(defn get-uri-resolver
  "Get the object that is used by default during the transformation
   to resolve URIs used in document(), xsl:import, or xsl:include.

  returns: The URIResolver that was set with setURIResolver. - `javax.xml.transform.URIResolver`"
  ([this]
    (-> this (.getURIResolver))))

(defn set-attribute
  "Allows the user to set specific attributes on the underlying
   implementation.  An attribute in this context is defined to
   be an option that the implementation provides.
   An IllegalArgumentException is thrown if the underlying
   implementation doesn't recognize the attribute.

   All implementations that implement JAXP 1.5 or newer are required to
   support the XMLConstants.ACCESS_EXTERNAL_DTD  and
   XMLConstants.ACCESS_EXTERNAL_STYLESHEET properties.




        Access to external DTDs in the source file is restricted to the protocols
        specified by the XMLConstants.ACCESS_EXTERNAL_DTD property.
        If access is denied during transformation due to the restriction of this property,
        TransformerException will be thrown by
        Transformer.transform(Source, Result).


        Access to external DTDs in the stylesheet is restricted to the protocols
        specified by the XMLConstants.ACCESS_EXTERNAL_DTD property.
        If access is denied during the creation of a new transformer due to the
        restriction of this property,
        TransformerConfigurationException will be thrown
        by the newTransformer(Source) method.


        Access to external reference set by the stylesheet processing instruction,
        Import and Include element is restricted to the protocols specified by the
        XMLConstants.ACCESS_EXTERNAL_STYLESHEET property.
        If access is denied during the creation of a new transformer due to the
        restriction of this property,
        TransformerConfigurationException will be thrown
        by the newTransformer(Source) method.


        Access to external document through XSLT document function is restricted
        to the protocols specified by the property. If access is denied during
        the transformation due to the restriction of this property,
        TransformerException will be thrown by the
        Transformer.transform(Source, Result) method.

  name - The name of the attribute. - `java.lang.String`
  value - The value of the attribute. - `java.lang.Object`

  throws: java.lang.IllegalArgumentException - When implementation does not recognize the attribute."
  ([this name value]
    (-> this (.setAttribute name value))))

(defn get-associated-stylesheet
  "Get the stylesheet specification(s) associated with the
   XML Source document via the

   xml-stylesheet processing instruction that match the given criteria.
   Note that it is possible to return several stylesheets, in which case
   they are applied as if they were a list of imports or cascades in a
   single stylesheet.

  source - The XML source document. - `javax.xml.transform.Source`
  media - The media attribute to be matched. May be null, in which case the prefered templates will be used (i.e. alternate = no). - `java.lang.String`
  title - The value of the title attribute to match. May be null. - `java.lang.String`
  charset - The value of the charset attribute to match. May be null. - `java.lang.String`

  returns: A Source Object suitable for passing
     to the TransformerFactory. - `javax.xml.transform.Source`

  throws: javax.xml.transform.TransformerConfigurationException - An Exception is thrown if an error occurings during parsing of the source."
  ([this source media title charset]
    (-> this (.getAssociatedStylesheet source media title charset))))

(defn set-uri-resolver
  "Set an object that is used by default during the transformation
   to resolve URIs used in document(), xsl:import, or xsl:include.

  resolver - An object that implements the URIResolver interface, or null. - `javax.xml.transform.URIResolver`"
  ([this resolver]
    (-> this (.setURIResolver resolver))))

(defn set-feature
  "Set a feature for this TransformerFactory and Transformers
   or Templates created by this factory.


   Feature names are fully qualified URIs.
   Implementations may define their own features.
   An TransformerConfigurationException is thrown if this TransformerFactory or the
   Transformers or Templates it creates cannot support the feature.
   It is possible for an TransformerFactory to expose a feature value but be unable to change its state.


   All implementations are required to support the XMLConstants.FEATURE_SECURE_PROCESSING feature.
   When the feature is:


       true: the implementation will limit XML processing to conform to implementation limits
       and behave in a secure fashion as defined by the implementation.
       Examples include resolving user defined style sheets and functions.
       If XML processing is limited for security reasons, it will be reported via a call to the registered
       ErrorListener.fatalError(TransformerException exception).
       See setErrorListener(ErrorListener listener).


       false: the implementation will processing XML according to the XML specifications without
       regard to possible implementation limits.

  name - Feature name. - `java.lang.String`
  value - Is feature state true or false. - `boolean`

  throws: javax.xml.transform.TransformerConfigurationException - if this TransformerFactory or the Transformers or Templates it creates cannot support this feature."
  ([this name value]
    (-> this (.setFeature name value))))

