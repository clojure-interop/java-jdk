(ns javax.xml.transform.Transformer
  "An instance of this abstract class can transform a
  source tree into a result tree.

  An instance of this class can be obtained with the
  TransformerFactory.newTransformer
  method. This instance may then be used to process XML from a
  variety of sources and write the transformation output to a
  variety of sinks.

  An object of this class may not be used in multiple threads
  running concurrently.  Different Transformers may be used
  concurrently by different threads.

  A Transformer may be used multiple times.  Parameters and
  output properties are preserved across transformations."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.xml.transform Transformer]))

(defn set-output-properties
  "Set the output properties for the transformation.  These
   properties will override properties set in the Templates
   with xsl:output.

   If argument to this function is null, any properties
   previously set are removed, and the value will revert to the value
   defined in the templates object.

   Pass a qualified property key name as a two-part string, the namespace
   URI enclosed in curly braces ({}), followed by the local name. If the
   name has a null URL, the String only contain the local name. An
   application can safely check for a non-null URI by testing to see if the
   first character of the name is a '{' character.
   For example, if a URI and local name were obtained from an element
   defined with <xyz:foo
   xmlns:xyz=`http://xyz.foo.com/yada/baz.html`/>,
   then the qualified name would be `{http://xyz.foo.com/yada/baz.html}foo`.
   Note that no prefix is used.
   An IllegalArgumentException is thrown  if any of the
   argument keys are not recognized and are not namespace qualified.

  oformat - A set of output properties that will be used to override any of the same properties in affect for the transformation. - `java.util.Properties`

  throws: java.lang.IllegalArgumentException - When keys are not recognized and are not namespace qualified."
  ([^javax.xml.transform.Transformer this ^java.util.Properties oformat]
    (-> this (.setOutputProperties oformat))))

(defn set-error-listener
  "Set the error event listener in effect for the transformation.

  listener - The new error listener. - `javax.xml.transform.ErrorListener`

  throws: java.lang.IllegalArgumentException - if listener is null."
  ([^javax.xml.transform.Transformer this ^javax.xml.transform.ErrorListener listener]
    (-> this (.setErrorListener listener))))

(defn get-error-listener
  "Get the error event handler in effect for the transformation.
   Implementations must provide a default error listener.

  returns: The current error handler, which should never be null. - `javax.xml.transform.ErrorListener`"
  (^javax.xml.transform.ErrorListener [^javax.xml.transform.Transformer this]
    (-> this (.getErrorListener))))

(defn set-output-property
  "Set an output property that will be in effect for the
   transformation.

   Pass a qualified property name as a two-part string, the namespace URI
   enclosed in curly braces ({}), followed by the local name. If the
   name has a null URL, the String only contain the local name. An
   application can safely check for a non-null URI by testing to see if the
   first character of the name is a '{' character.
   For example, if a URI and local name were obtained from an element
   defined with <xyz:foo
   xmlns:xyz=`http://xyz.foo.com/yada/baz.html`/>,
   then the qualified name would be `{http://xyz.foo.com/yada/baz.html}foo`.
   Note that no prefix is used.

   The Properties object that was passed to setOutputProperties(java.util.Properties)
   won't be effected by calling this method.

  name - A non-null String that specifies an output property name, which may be namespace qualified. - `java.lang.String`
  value - The non-null string value of the output property. - `java.lang.String`

  throws: java.lang.IllegalArgumentException - If the property is not supported, and is not qualified with a namespace."
  ([^javax.xml.transform.Transformer this ^java.lang.String name ^java.lang.String value]
    (-> this (.setOutputProperty name value))))

(defn get-output-property
  "Get an output property that is in effect for the transformer.

   If a property has been set using setOutputProperty(java.lang.String, java.lang.String),
   that value will be returned. Otherwise, if a property is explicitly
   specified in the stylesheet, that value will be returned. If
   the value of the property has been defaulted, that is, if no
   value has been set explicitly either with setOutputProperty(java.lang.String, java.lang.String) or
   in the stylesheet, the result may vary depending on
   implementation and input stylesheet.

  name - A non-null String that specifies an output property name, which may be namespace qualified. - `java.lang.String`

  returns: The string value of the output property, or null
   if no property was found. - `java.lang.String`

  throws: java.lang.IllegalArgumentException - If the property is not supported."
  (^java.lang.String [^javax.xml.transform.Transformer this ^java.lang.String name]
    (-> this (.getOutputProperty name))))

(defn transform
  "Transform the XML Source to a Result.
   Specific transformation behavior is determined by the settings of the
   TransformerFactory in effect when the
   Transformer was instantiated and any modifications made to
   the Transformer instance.

   An empty Source is represented as an empty document
   as constructed by DocumentBuilder.newDocument().
   The result of transforming an empty Source depends on
   the transformation behavior; it is not always an empty
   Result.

  xml-source - The XML input to transform. - `javax.xml.transform.Source`
  output-target - The Result of transforming the xmlSource. - `javax.xml.transform.Result`

  throws: javax.xml.transform.TransformerException - If an unrecoverable error occurs during the course of the transformation."
  ([^javax.xml.transform.Transformer this ^javax.xml.transform.Source xml-source ^javax.xml.transform.Result output-target]
    (-> this (.transform xml-source output-target))))

(defn reset
  "Reset this Transformer to its original configuration.

   Transformer is reset to the same state as when it was created with
   TransformerFactory.newTransformer(),
   TransformerFactory.newTransformer(Source source) or
   Templates.newTransformer().
   reset() is designed to allow the reuse of existing Transformers
   thus saving resources associated with the creation of new Transformers.

   The reset Transformer is not guaranteed to have the same URIResolver
   or ErrorListener Objects, e.g. Object.equals(Object obj).
   It is guaranteed to have a functionally equal URIResolver
   and ErrorListener.

  throws: java.lang.UnsupportedOperationException - When implementation does not override this method."
  ([^javax.xml.transform.Transformer this]
    (-> this (.reset))))

(defn clear-parameters
  "Clear all parameters set with setParameter."
  ([^javax.xml.transform.Transformer this]
    (-> this (.clearParameters))))

(defn get-uri-resolver
  "Get an object that will be used to resolve URIs used in
   document().

  returns: An object that implements the URIResolver interface,
   or null. - `javax.xml.transform.URIResolver`"
  (^javax.xml.transform.URIResolver [^javax.xml.transform.Transformer this]
    (-> this (.getURIResolver))))

(defn get-parameter
  "Get a parameter that was explicitly set with setParameter.

   This method does not return a default parameter value, which
   cannot be determined until the node context is evaluated during
   the transformation process.

  name - of Object to get - `java.lang.String`

  returns: A parameter that has been set with setParameter. - `java.lang.Object`"
  (^java.lang.Object [^javax.xml.transform.Transformer this ^java.lang.String name]
    (-> this (.getParameter name))))

(defn set-uri-resolver
  "Set an object that will be used to resolve URIs used in
   document().

   If the resolver argument is null, the URIResolver value will
   be cleared and the transformer will no longer have a resolver.

  resolver - An object that implements the URIResolver interface, or null. - `javax.xml.transform.URIResolver`"
  ([^javax.xml.transform.Transformer this ^javax.xml.transform.URIResolver resolver]
    (-> this (.setURIResolver resolver))))

(defn set-parameter
  "Add a parameter for the transformation.

   Pass a qualified name as a two-part string, the namespace URI
   enclosed in curly braces ({}), followed by the local name. If the
   name has a null URL, the String only contain the local name. An
   application can safely check for a non-null URI by testing to see if the
   first character of the name is a '{' character.
   For example, if a URI and local name were obtained from an element
   defined with <xyz:foo
   xmlns:xyz=`http://xyz.foo.com/yada/baz.html`/>,
   then the qualified name would be `{http://xyz.foo.com/yada/baz.html}foo`.
   Note that no prefix is used.

  name - The name of the parameter, which may begin with a namespace URI in curly braces ({}). - `java.lang.String`
  value - The value object. This can be any valid Java object. It is up to the processor to provide the proper object coersion or to simply pass the object on for use in an extension. - `java.lang.Object`

  throws: java.lang.NullPointerException - If value is null."
  ([^javax.xml.transform.Transformer this ^java.lang.String name ^java.lang.Object value]
    (-> this (.setParameter name value))))

(defn get-output-properties
  "Get a copy of the output properties for the transformation.

   The properties returned should contain properties set by the user,
   and properties set by the stylesheet, and these properties
   are `defaulted` by default properties specified by
   section 16 of the
   XSL Transformations (XSLT) W3C Recommendation.  The properties that
   were specifically set by the user or the stylesheet should be in the base
   Properties list, while the XSLT default properties that were not
   specifically set should be the default Properties list.  Thus,
   getOutputProperties().getProperty(String key) will obtain any
   property in that was set by setOutputProperty(java.lang.String, java.lang.String),
   setOutputProperties(java.util.Properties), in the stylesheet, or the default
   properties, while
   getOutputProperties().get(String key) will only retrieve properties
   that were explicitly set by setOutputProperty(java.lang.String, java.lang.String),
   setOutputProperties(java.util.Properties), or in the stylesheet.

   Note that mutation of the Properties object returned will not
   effect the properties that the transformer contains.

   If any of the argument keys are not recognized and are not
   namespace qualified, the property will be ignored and not returned.
   In other words the behaviour is not orthogonal with
   setOutputProperties.

  returns: A copy of the set of output properties in effect for
     the next transformation. - `java.util.Properties`"
  (^java.util.Properties [^javax.xml.transform.Transformer this]
    (-> this (.getOutputProperties))))

