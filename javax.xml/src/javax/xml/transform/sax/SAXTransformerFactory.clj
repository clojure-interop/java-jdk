(ns javax.xml.transform.sax.SAXTransformerFactory
  "This class extends TransformerFactory to provide SAX-specific
  factory methods.  It provides two types of ContentHandlers,
  one for creating Transformers, the other for creating Templates
  objects.

  If an application wants to set the ErrorHandler or EntityResolver
  for an XMLReader used during a transformation, it should use a URIResolver
  to return the SAXSource which provides (with getXMLReader) a reference to
  the XMLReader."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.xml.transform.sax SAXTransformerFactory]))

(def *-feature
  "Static Constant.

  If TransformerFactory.getFeature(java.lang.String)
   returns true when passed this value as an argument,
   the TransformerFactory returned from
   TransformerFactory.newInstance() may
   be safely cast to a SAXTransformerFactory.

  type: java.lang.String"
  SAXTransformerFactory/FEATURE)

(def *-feature-xmlfilter
  "Static Constant.

  If TransformerFactory.getFeature(java.lang.String)
   returns true when passed this value as an argument,
   the newXMLFilter(Source src)
   and newXMLFilter(Templates templates) methods are supported.

  type: java.lang.String"
  SAXTransformerFactory/FEATURE_XMLFILTER)

(defn new-transformer-handler
  "Get a TransformerHandler object that can process SAX
   ContentHandler events into a Result, based on the transformation
   instructions specified by the argument.

  src - The Source of the transformation instructions. - `javax.xml.transform.Source`

  returns: TransformerHandler ready to transform SAX events. - `javax.xml.transform.sax.TransformerHandler`

  throws: javax.xml.transform.TransformerConfigurationException - If for some reason the TransformerHandler can not be created."
  ([this src]
    (-> this (.newTransformerHandler src)))
  ([this]
    (-> this (.newTransformerHandler))))

(defn new-templates-handler
  "Get a TemplatesHandler object that can process SAX
   ContentHandler events into a Templates object.

  returns: A non-null reference to a TransformerHandler, that may
   be used as a ContentHandler for SAX parse events. - `javax.xml.transform.sax.TemplatesHandler`

  throws: javax.xml.transform.TransformerConfigurationException - If for some reason the TemplatesHandler cannot be created."
  ([this]
    (-> this (.newTemplatesHandler))))

(defn new-xml-filter
  "Create an XMLFilter that uses the given Source as the
   transformation instructions.

  src - The Source of the transformation instructions. - `javax.xml.transform.Source`

  returns: An XMLFilter object, or null if this feature is not supported. - `org.xml.sax.XMLFilter`

  throws: javax.xml.transform.TransformerConfigurationException - If for some reason the TemplatesHandler cannot be created."
  ([this src]
    (-> this (.newXMLFilter src))))

