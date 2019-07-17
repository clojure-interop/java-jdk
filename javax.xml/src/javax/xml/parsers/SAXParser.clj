(ns javax.xml.parsers.SAXParser
  "Defines the API that wraps an XMLReader
  implementation class. In JAXP 1.0, this class wrapped the
  Parser interface, however this interface was
  replaced by the XMLReader. For ease
  of transition, this class continues to support the same name
  and interface as well as supporting new methods.

  An instance of this class can be obtained from the
  SAXParserFactory.newSAXParser() method.
  Once an instance of this class is obtained, XML can be parsed from
  a variety of input sources. These input sources are InputStreams,
  Files, URLs, and SAX InputSources.

  This static method creates a new factory instance based
  on a system property setting or uses the platform default
  if no property has been defined.

  The system property that controls which Factory implementation
  to create is named `javax.xml.parsers.SAXParserFactory`.
  This property names a class that is a concrete subclass of this
  abstract class. If no property is defined, a platform default
  will be used.

  As the content is parsed by the underlying parser, methods of the
  given HandlerBase or the
  DefaultHandler are called.

  Implementors of this class which wrap an underlaying implementation
  can consider using the ParserAdapter
  class to initially adapt their SAX1 implementation to work under
  this revised class."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.xml.parsers SAXParser]))

(defn get-parser
  "Returns the SAX parser that is encapsultated by the
   implementation of this class.

  returns: The SAX parser that is encapsultated by the
           implementation of this class. - `org.xml.sax.Parser`

  throws: org.xml.sax.SAXException - If any SAX errors occur during processing."
  ([^javax.xml.parsers.SAXParser this]
    (-> this (.getParser))))

(defn reset
  "Reset this SAXParser to its original configuration.

   SAXParser is reset to the same state as when it was created with
   SAXParserFactory.newSAXParser().
   reset() is designed to allow the reuse of existing SAXParsers
   thus saving resources associated with the creation of new SAXParsers.

   The reset SAXParser is not guaranteed to have the same Schema
   Object, e.g. Object.equals(Object obj).  It is guaranteed to have a functionally equal
   Schema.

  throws: java.lang.UnsupportedOperationException - When Implementations do not override this method"
  ([^javax.xml.parsers.SAXParser this]
    (-> this (.reset))))

(defn get-property
  "Returns the particular property requested for in the underlying
   implementation of XMLReader.

  name - The name of the property to be retrieved. - `java.lang.String`

  returns: Value of the requested property. - `java.lang.Object`

  throws: org.xml.sax.SAXNotRecognizedException - When the underlying XMLReader does not recognize the property name."
  ([^javax.xml.parsers.SAXParser this ^java.lang.String name]
    (-> this (.getProperty name))))

(defn get-xml-reader
  "Returns the XMLReader that is encapsulated by the
   implementation of this class.

  returns: The XMLReader that is encapsulated by the
           implementation of this class. - `org.xml.sax.XMLReader`

  throws: org.xml.sax.SAXException - If any SAX errors occur during processing."
  ([^javax.xml.parsers.SAXParser this]
    (-> this (.getXMLReader))))

(defn get-schema
  "Get a reference to the the Schema being used by
   the XML processor.

   If no schema is being used, null is returned.

  returns: Schema being used or null
    if none in use - `javax.xml.validation.Schema`

  throws: java.lang.UnsupportedOperationException - When implementation does not override this method"
  ([^javax.xml.parsers.SAXParser this]
    (-> this (.getSchema))))

(defn parse
  "Parse the content of the given InputStream
   instance as XML using the specified HandlerBase.
    Use of the DefaultHandler version of this method is recommended as
   the HandlerBase class has been deprecated in SAX 2.0.

  is - InputStream containing the content to be parsed. - `java.io.InputStream`
  hb - The SAX HandlerBase to use. - `org.xml.sax.HandlerBase`
  system-id - The systemId which is needed for resolving relative URIs. - `java.lang.String`

  throws: java.lang.IllegalArgumentException - If the given InputStream is null."
  ([^javax.xml.parsers.SAXParser this ^java.io.InputStream is ^org.xml.sax.HandlerBase hb ^java.lang.String system-id]
    (-> this (.parse is hb system-id)))
  ([^javax.xml.parsers.SAXParser this ^java.io.InputStream is ^org.xml.sax.HandlerBase hb]
    (-> this (.parse is hb))))

(defn set-property
  "Sets the particular property in the underlying implementation of
   XMLReader.
   A list of the core features and properties can be found at

   http://sax.sourceforge.net/?selected=get-set.

   All implementations that implement JAXP 1.5 or newer are required to
   support the XMLConstants.ACCESS_EXTERNAL_DTD and
   XMLConstants.ACCESS_EXTERNAL_SCHEMA properties.




        Setting the XMLConstants.ACCESS_EXTERNAL_DTD property
        restricts the access to external DTDs, external Entity References to
        the protocols specified by the property.  If access is denied during parsing
        due to the restriction of this property, SAXException
        will be thrown by the parse methods defined by SAXParser.


        Setting the XMLConstants.ACCESS_EXTERNAL_SCHEMA property
        restricts the access to external Schema set by the schemaLocation attribute to
        the protocols specified by the property.  If access is denied during parsing
        due to the restriction of this property, SAXException
        will be thrown by the parse methods defined by the SAXParser.

  name - The name of the property to be set. - `java.lang.String`
  value - The value of the property to be set. - `java.lang.Object`

  throws: org.xml.sax.SAXNotRecognizedException - When the underlying XMLReader does not recognize the property name."
  ([^javax.xml.parsers.SAXParser this ^java.lang.String name ^java.lang.Object value]
    (-> this (.setProperty name value))))

(defn namespace-aware?
  "Indicates whether or not this parser is configured to
   understand namespaces.

  returns: true if this parser is configured to
           understand namespaces; false otherwise. - `boolean`"
  ([^javax.xml.parsers.SAXParser this]
    (-> this (.isNamespaceAware))))

(defn validating?
  "Indicates whether or not this parser is configured to
   validate XML documents.

  returns: true if this parser is configured to
           validate XML documents; false otherwise. - `boolean`"
  ([^javax.xml.parsers.SAXParser this]
    (-> this (.isValidating))))

(defn x-include-aware?
  "Get the XInclude processing mode for this parser.

  returns: the return value of
        the SAXParserFactory.isXIncludeAware()
        when this parser was created from factory. - `boolean`

  throws: java.lang.UnsupportedOperationException - When implementation does not override this method"
  ([^javax.xml.parsers.SAXParser this]
    (-> this (.isXIncludeAware))))

