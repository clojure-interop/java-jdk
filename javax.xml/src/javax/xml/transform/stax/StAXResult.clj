(ns javax.xml.transform.stax.StAXResult
  "Acts as a holder for an XML Result in the
  form of a StAX writer,i.e.
  XMLStreamWriter or XMLEventWriter.
  StAXResult can be used in all cases that accept
  a Result, e.g. Transformer,
  Validator which accept
  Result as input."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.xml.transform.stax StAXResult]))

(defn ->st-ax-result
  "Constructor.

  Creates a new instance of a StAXResult
   by supplying an XMLEventWriter.

   XMLEventWriter must be a
   non-null reference.

  xml-event-writer - XMLEventWriter used to create this StAXResult. - `javax.xml.stream.XMLEventWriter`

  throws: java.lang.IllegalArgumentException - If xmlEventWriter == null."
  ([^javax.xml.stream.XMLEventWriter xml-event-writer]
    (new StAXResult xml-event-writer)))

(def *-feature
  "Static Constant.

  If TransformerFactory.getFeature(String name)
   returns true when passed this value as an argument,
   the Transformer supports Result output of this type.

  type: java.lang.String"
  StAXResult/FEATURE)

(defn get-xml-event-writer
  "Get the XMLEventWriter used by this
   StAXResult.

   XMLEventWriter will be null
   if this StAXResult was created with a
   XMLStreamWriter.

  returns: XMLEventWriter used by this
     StAXResult. - `javax.xml.stream.XMLEventWriter`"
  (^javax.xml.stream.XMLEventWriter [^javax.xml.transform.stax.StAXResult this]
    (-> this (.getXMLEventWriter))))

(defn get-xml-stream-writer
  "Get the XMLStreamWriter used by this
   StAXResult.

   XMLStreamWriter will be null
   if this StAXResult was created with a
   XMLEventWriter.

  returns: XMLStreamWriter used by this
     StAXResult. - `javax.xml.stream.XMLStreamWriter`"
  (^javax.xml.stream.XMLStreamWriter [^javax.xml.transform.stax.StAXResult this]
    (-> this (.getXMLStreamWriter))))

(defn set-system-id
  "In the context of a StAXResult, it is not appropriate
   to explicitly set the system identifier.
   The XMLEventWriter or XMLStreamWriter
   used to construct this StAXResult determines the
   system identifier of the XML result.

   An UnsupportedOperationException is always
   thrown by this method.

  system-id - Ignored. - `java.lang.String`

  throws: java.lang.UnsupportedOperationException - Is always thrown by this method."
  ([^javax.xml.transform.stax.StAXResult this ^java.lang.String system-id]
    (-> this (.setSystemId system-id))))

(defn get-system-id
  "The returned system identifier is always null.

  returns: The returned system identifier is always null. - `java.lang.String`"
  (^java.lang.String [^javax.xml.transform.stax.StAXResult this]
    (-> this (.getSystemId))))

