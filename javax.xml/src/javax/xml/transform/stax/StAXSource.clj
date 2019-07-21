(ns javax.xml.transform.stax.StAXSource
  "Acts as a holder for an XML Source in the
  form of a StAX reader,i.e.
  XMLStreamReader or XMLEventReader.
  StAXSource can be used in all cases that accept
  a Source, e.g. Transformer,
  Validator which accept
  Source as input.

  StAXSources are consumed during processing
  and are not reusable."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.xml.transform.stax StAXSource]))

(defn ->st-ax-source
  "Constructor.

  Creates a new instance of a StAXSource
   by supplying an XMLEventReader.

   XMLEventReader must be a
   non-null reference.

   XMLEventReader must be in
   XMLStreamConstants.START_DOCUMENT or
   XMLStreamConstants.START_ELEMENT state.

  xml-event-reader - XMLEventReader used to create this StAXSource. - `javax.xml.stream.XMLEventReader`

  throws: javax.xml.stream.XMLStreamException - If xmlEventReader access throws an Exception."
  (^StAXSource [^javax.xml.stream.XMLEventReader xml-event-reader]
    (new StAXSource xml-event-reader)))

(def *-feature
  "Static Constant.

  If TransformerFactory.getFeature(String name)
   returns true when passed this value as an argument,
   the Transformer supports Source input of this type.

  type: java.lang.String"
  StAXSource/FEATURE)

(defn get-xml-event-reader
  "Get the XMLEventReader used by this
   StAXSource.

   XMLEventReader will be null.
   if this StAXSource was created with a
   XMLStreamReader.

  returns: XMLEventReader used by this
     StAXSource. - `javax.xml.stream.XMLEventReader`"
  (^javax.xml.stream.XMLEventReader [^StAXSource this]
    (-> this (.getXMLEventReader))))

(defn get-xml-stream-reader
  "Get the XMLStreamReader used by this
   StAXSource.

   XMLStreamReader will be null
   if this StAXSource was created with a
   XMLEventReader.

  returns: XMLStreamReader used by this
     StAXSource. - `javax.xml.stream.XMLStreamReader`"
  (^javax.xml.stream.XMLStreamReader [^StAXSource this]
    (-> this (.getXMLStreamReader))))

(defn set-system-id
  "In the context of a StAXSource, it is not appropriate
   to explicitly set the system identifier.
   The XMLStreamReader or XMLEventReader
   used to construct this StAXSource determines the
   system identifier of the XML source.

   An UnsupportedOperationException is always
   thrown by this method.

  system-id - Ignored. - `java.lang.String`

  throws: java.lang.UnsupportedOperationException - Is always thrown by this method."
  ([^StAXSource this ^java.lang.String system-id]
    (-> this (.setSystemId system-id))))

(defn get-system-id
  "Get the system identifier used by this
   StAXSource.

   The XMLStreamReader or XMLEventReader
   used to construct this StAXSource is queried to determine
   the system identifier of the XML source.

   The system identifier may be null or
   an empty \"\" String.

  returns: System identifier used by this StAXSource. - `java.lang.String`"
  (^java.lang.String [^StAXSource this]
    (-> this (.getSystemId))))

