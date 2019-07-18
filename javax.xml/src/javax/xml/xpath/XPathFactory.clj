(ns javax.xml.xpath.XPathFactory
  "An XPathFactory instance can be used to create
  XPath objects.

 See newInstance(String uri) for lookup mechanism.

  The XPathFactory class is not thread-safe. In other words,
  it is the application's responsibility to ensure that at most
  one thread is using a XPathFactory object at any
  given moment. Implementations are encouraged to mark methods
  as synchronized to protect themselves from broken clients.

  XPathFactory is not re-entrant. While one of the
  newInstance methods is being invoked, applications
  may not attempt to recursively invoke a newInstance method,
  even from the same thread."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.xml.xpath XPathFactory]))

(def *-default-property-name
  "Static Constant.

  The default property name according to the JAXP spec.

  type: java.lang.String"
  XPathFactory/DEFAULT_PROPERTY_NAME)

(def *-default-object-model-uri
  "Static Constant.

  Default Object Model URI.

  type: java.lang.String"
  XPathFactory/DEFAULT_OBJECT_MODEL_URI)

(defn *new-instance
  "Obtain a new instance of a XPathFactory from a factory class name. XPathFactory
   is returned if specified factory class supports the specified object model.
   This function is useful when there are multiple providers in the classpath.
   It gives more control to the application as it can specify which provider
   should be loaded.


   Tip for Trouble-shooting
   Setting the jaxp.debug system property will cause
   this method to print a lot of debug messages
   to System.err about what it is doing and where it is looking at.

    If you have problems try:


   java -Djaxp.debug=1 YourProgram ....

  uri - Identifies the underlying object model. The specification only defines the URI DEFAULT_OBJECT_MODEL_URI,http://java.sun.com/jaxp/xpath/dom for the W3C DOM, the org.w3c.dom package, and implementations are free to introduce other URIs for other object models. - `java.lang.String`
  factory-class-name - fully qualified factory class name that provides implementation of javax.xml.xpath.XPathFactory. - `java.lang.String`
  class-loader - ClassLoader used to load the factory class. If null current Thread's context classLoader is used to load the factory class. - `java.lang.ClassLoader`

  returns: New instance of a XPathFactory - `javax.xml.xpath.XPathFactory`

  throws: javax.xml.xpath.XPathFactoryConfigurationException - if factoryClassName is null, or the factory class cannot be loaded, instantiated or the factory class does not support the object model specified in the uri parameter."
  (^javax.xml.xpath.XPathFactory [^java.lang.String uri ^java.lang.String factory-class-name ^java.lang.ClassLoader class-loader]
    (XPathFactory/newInstance uri factory-class-name class-loader))
  (^javax.xml.xpath.XPathFactory [^java.lang.String uri]
    (XPathFactory/newInstance uri))
  (^javax.xml.xpath.XPathFactory []
    (XPathFactory/newInstance )))

(defn object-model-supported?
  "Is specified object model supported by this XPathFactory?

  object-model - Specifies the object model which the returned XPathFactory will understand. - `java.lang.String`

  returns: true if XPathFactory supports objectModel, else false. - `boolean`

  throws: java.lang.NullPointerException - If objectModel is null."
  (^Boolean [^XPathFactory this ^java.lang.String object-model]
    (-> this (.isObjectModelSupported object-model))))

(defn set-feature
  "Set a feature for this XPathFactory and
   XPaths created by this factory.


   Feature names are fully qualified URIs.
   Implementations may define their own features.
   An XPathFactoryConfigurationException is thrown if this
   XPathFactory or the XPaths
   it creates cannot support the feature.
   It is possible for an XPathFactory to expose a feature value
   but be unable to change its state.



   All implementations are required to support the XMLConstants.FEATURE_SECURE_PROCESSING feature.
   When the feature is true, any reference to  an external function is an error.
   Under these conditions, the implementation must not call the XPathFunctionResolver
   and must throw an XPathFunctionException.

  name - Feature name. - `java.lang.String`
  value - Is feature state true or false. - `boolean`

  throws: javax.xml.xpath.XPathFactoryConfigurationException - if this XPathFactory or the XPaths it creates cannot support this feature."
  ([^XPathFactory this ^java.lang.String name ^Boolean value]
    (-> this (.setFeature name value))))

(defn get-feature?
  "Get the state of the named feature.


   Feature names are fully qualified URIs.
   Implementations may define their own features.
   An XPathFactoryConfigurationException is thrown if this
   XPathFactory or the XPaths
   it creates cannot support the feature.
   It is possible for an XPathFactory to expose a feature value
   but be unable to change its state.

  name - Feature name. - `java.lang.String`

  returns: State of the named feature. - `boolean`

  throws: javax.xml.xpath.XPathFactoryConfigurationException - if this XPathFactory or the XPaths it creates cannot support this feature."
  (^Boolean [^XPathFactory this ^java.lang.String name]
    (-> this (.getFeature name))))

(defn set-x-path-variable-resolver
  "Establish a default variable resolver.

   Any XPath objects constructed from this factory will use
   the specified resolver by default.

   A NullPointerException is thrown if resolver
   is null.

  resolver - Variable resolver. - `javax.xml.xpath.XPathVariableResolver`

  throws: java.lang.NullPointerException - If resolver is null."
  ([^XPathFactory this ^javax.xml.xpath.XPathVariableResolver resolver]
    (-> this (.setXPathVariableResolver resolver))))

(defn set-x-path-function-resolver
  "Establish a default function resolver.

   Any XPath objects constructed from this factory will
   use the specified resolver by default.

   A NullPointerException is thrown if
   resolver is null.

  resolver - XPath function resolver. - `javax.xml.xpath.XPathFunctionResolver`

  throws: java.lang.NullPointerException - If resolver is null."
  ([^XPathFactory this ^javax.xml.xpath.XPathFunctionResolver resolver]
    (-> this (.setXPathFunctionResolver resolver))))

(defn new-x-path
  "Return a new XPath using the underlying object
   model determined when the XPathFactory was instantiated.

  returns: New instance of an XPath. - `javax.xml.xpath.XPath`"
  (^javax.xml.xpath.XPath [^XPathFactory this]
    (-> this (.newXPath))))

