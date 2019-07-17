(ns javax.xml.transform.sax.SAXSource
  "Acts as an holder for SAX-style Source.

  Note that XSLT requires namespace support. Attempting to transform an
  input source that is not
  generated with a namespace-aware parser may result in errors.
  Parsers can be made namespace aware by calling the
  SAXParserFactory.setNamespaceAware(boolean awareness) method."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.xml.transform.sax SAXSource]))

(defn ->sax-source
  "Constructor.

  Create a SAXSource, using an XMLReader
   and a SAX InputSource. The Transformer
   or SAXTransformerFactory will set itself
   to be the reader's ContentHandler, and then will call
   reader.parse(inputSource).

  reader - An XMLReader to be used for the parse. - `org.xml.sax.XMLReader`
  input-source - A SAX input source reference that must be non-null and that will be passed to the reader parse method. - `org.xml.sax.InputSource`"
  ([^org.xml.sax.XMLReader reader ^org.xml.sax.InputSource input-source]
    (new SAXSource reader input-source))
  ([^org.xml.sax.InputSource input-source]
    (new SAXSource input-source))
  ([]
    (new SAXSource )))

(def *-feature
  "Static Constant.

  If TransformerFactory.getFeature(java.lang.String)
   returns true when passed this value as an argument,
   the Transformer supports Source input of this type.

  type: java.lang.String"
  SAXSource/FEATURE)

(defn *source-to-input-source
  "Attempt to obtain a SAX InputSource object from a Source
   object.

  source - Must be a non-null Source reference. - `javax.xml.transform.Source`

  returns: An InputSource, or null if Source can not be converted. - `org.xml.sax.InputSource`"
  ([^javax.xml.transform.Source source]
    (SAXSource/sourceToInputSource source)))

(defn set-xml-reader
  "Set the XMLReader to be used for the Source.

  reader - A valid XMLReader or XMLFilter reference. - `org.xml.sax.XMLReader`"
  ([^javax.xml.transform.sax.SAXSource this ^org.xml.sax.XMLReader reader]
    (-> this (.setXMLReader reader))))

(defn get-xml-reader
  "Get the XMLReader to be used for the Source.

  returns: A valid XMLReader or XMLFilter reference, or null. - `org.xml.sax.XMLReader`"
  ([^javax.xml.transform.sax.SAXSource this]
    (-> this (.getXMLReader))))

(defn set-input-source
  "Set the SAX InputSource to be used for the Source.

  input-source - A valid InputSource reference. - `org.xml.sax.InputSource`"
  ([^javax.xml.transform.sax.SAXSource this ^org.xml.sax.InputSource input-source]
    (-> this (.setInputSource input-source))))

(defn get-input-source
  "Get the SAX InputSource to be used for the Source.

  returns: A valid InputSource reference, or null. - `org.xml.sax.InputSource`"
  ([^javax.xml.transform.sax.SAXSource this]
    (-> this (.getInputSource))))

(defn set-system-id
  "Set the system identifier for this Source.  If an input source
   has already been set, it will set the system ID or that
   input source, otherwise it will create a new input source.

   The system identifier is optional if there is a byte stream
   or a character stream, but it is still useful to provide one,
   since the application can use it to resolve relative URIs
   and can include it in error messages and warnings (the parser
   will attempt to open a connection to the URI only if
   no byte stream or character stream is specified).

  system-id - The system identifier as a URI string. - `java.lang.String`"
  ([^javax.xml.transform.sax.SAXSource this ^java.lang.String system-id]
    (-> this (.setSystemId system-id))))

(defn get-system-id
  "Get the base ID (URI or system ID) from where URIs
   will be resolved.

  returns: Base URL for the Source, or null. - `java.lang.String`"
  ([^javax.xml.transform.sax.SAXSource this]
    (-> this (.getSystemId))))

