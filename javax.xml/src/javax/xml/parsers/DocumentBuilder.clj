(ns javax.xml.parsers.DocumentBuilder
  "Defines the API to obtain DOM Document instances from an XML
  document. Using this class, an application programmer can obtain a
  Document from XML.

  An instance of this class can be obtained from the
  DocumentBuilderFactory.newDocumentBuilder() method. Once
  an instance of this class is obtained, XML can be parsed from a
  variety of input sources. These input sources are InputStreams,
  Files, URLs, and SAX InputSources.

  Note that this class reuses several classes from the SAX API. This
  does not require that the implementor of the underlying DOM
  implementation use a SAX parser to parse XML document into a
  Document. It merely requires that the implementation
  communicate with the application using these existing APIs."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.xml.parsers DocumentBuilder]))

(defn get-dom-implementation
  "Obtain an instance of a DOMImplementation object.

  returns: A new instance of a DOMImplementation. - `org.w3c.dom.DOMImplementation`"
  (^org.w3c.dom.DOMImplementation [^javax.xml.parsers.DocumentBuilder this]
    (-> this (.getDOMImplementation))))

(defn new-document
  "Obtain a new instance of a DOM Document object
   to build a DOM tree with.

  returns: A new instance of a DOM Document object. - `org.w3c.dom.Document`"
  (^org.w3c.dom.Document [^javax.xml.parsers.DocumentBuilder this]
    (-> this (.newDocument))))

(defn reset
  "Reset this DocumentBuilder to its original configuration.

   DocumentBuilder is reset to the same state as when it was created with
   DocumentBuilderFactory.newDocumentBuilder().
   reset() is designed to allow the reuse of existing DocumentBuilders
   thus saving resources associated with the creation of new DocumentBuilders.

   The reset DocumentBuilder is not guaranteed to have the same EntityResolver or ErrorHandler
   Objects, e.g. Object.equals(Object obj).  It is guaranteed to have a functionally equal
   EntityResolver and ErrorHandler.

  throws: java.lang.UnsupportedOperationException - When implementation does not override this method."
  ([^javax.xml.parsers.DocumentBuilder this]
    (-> this (.reset))))

(defn set-error-handler
  "Specify the ErrorHandler to be used by the parser.
   Setting this to null will result in the underlying
   implementation using it's own default implementation and
   behavior.

  eh - The ErrorHandler to be used by the parser. - `org.xml.sax.ErrorHandler`"
  ([^javax.xml.parsers.DocumentBuilder this ^org.xml.sax.ErrorHandler eh]
    (-> this (.setErrorHandler eh))))

(defn get-schema
  "Get a reference to the the Schema being used by
   the XML processor.

   If no schema is being used, null is returned.

  returns: Schema being used or null
    if none in use - `javax.xml.validation.Schema`

  throws: java.lang.UnsupportedOperationException - When implementation does not override this method"
  (^javax.xml.validation.Schema [^javax.xml.parsers.DocumentBuilder this]
    (-> this (.getSchema))))

(defn parse
  "Parse the content of the given InputStream as an
   XML document and return a new DOM Document object.
   An IllegalArgumentException is thrown if the
   InputStream is null.

  is - InputStream containing the content to be parsed. - `java.io.InputStream`
  system-id - Provide a base for resolving relative URIs. - `java.lang.String`

  returns: A new DOM Document object. - `org.w3c.dom.Document`

  throws: java.io.IOException - If any IO errors occur."
  (^org.w3c.dom.Document [^javax.xml.parsers.DocumentBuilder this ^java.io.InputStream is ^java.lang.String system-id]
    (-> this (.parse is system-id)))
  (^org.w3c.dom.Document [^javax.xml.parsers.DocumentBuilder this ^java.io.InputStream is]
    (-> this (.parse is))))

(defn set-entity-resolver
  "Specify the EntityResolver to be used to resolve
   entities present in the XML document to be parsed. Setting
   this to null will result in the underlying
   implementation using it's own default implementation and
   behavior.

  er - The EntityResolver to be used to resolve entities present in the XML document to be parsed. - `org.xml.sax.EntityResolver`"
  ([^javax.xml.parsers.DocumentBuilder this ^org.xml.sax.EntityResolver er]
    (-> this (.setEntityResolver er))))

(defn namespace-aware?
  "Indicates whether or not this parser is configured to
   understand namespaces.

  returns: true if this parser is configured to understand
           namespaces; false otherwise. - `boolean`"
  (^Boolean [^javax.xml.parsers.DocumentBuilder this]
    (-> this (.isNamespaceAware))))

(defn validating?
  "Indicates whether or not this parser is configured to
   validate XML documents.

  returns: true if this parser is configured to validate
           XML documents; false otherwise. - `boolean`"
  (^Boolean [^javax.xml.parsers.DocumentBuilder this]
    (-> this (.isValidating))))

(defn x-include-aware?
  "Get the XInclude processing mode for this parser.

  returns: the return value of
        the DocumentBuilderFactory.isXIncludeAware()
        when this parser was created from factory. - `boolean`

  throws: java.lang.UnsupportedOperationException - When implementation does not override this method"
  (^Boolean [^javax.xml.parsers.DocumentBuilder this]
    (-> this (.isXIncludeAware))))

