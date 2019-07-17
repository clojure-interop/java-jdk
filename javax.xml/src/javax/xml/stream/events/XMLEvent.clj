(ns javax.xml.stream.events.XMLEvent
  "This is the base event interface for handling markup events.
  Events are value objects that are used to communicate the
  XML 1.0 InfoSet to the Application.  Events may be cached
  and referenced after the parse has completed."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.xml.stream.events XMLEvent]))

(defn write-as-encoded-unicode
  "This method will write the XMLEvent as per the XML 1.0 specification as Unicode characters.
   No indentation or whitespace should be outputted.

   Any user defined event type SHALL have this method
   called when being written to on an output stream.
   Built in Event types MUST implement this method,
   but implementations MAY choose not call these methods
   for optimizations reasons when writing out built in
   Events to an output stream.
   The output generated MUST be equivalent in terms of the
   infoset expressed.

  writer - The writer that will output the data - `java.io.Writer`

  throws: XMLStreamException - if there is a fatal error writing the event"
  ([^javax.xml.stream.events.XMLEvent this ^java.io.Writer writer]
    (-> this (.writeAsEncodedUnicode writer))))

(defn get-location
  "Return the location of this event.  The Location
   returned from this method is non-volatile and
   will retain its information.

  returns: `javax.xml.stream.Location`"
  ([^javax.xml.stream.events.XMLEvent this]
    (-> this (.getLocation))))

(defn get-event-type
  "Returns an integer code for this event.

  returns: `int`"
  ([^javax.xml.stream.events.XMLEvent this]
    (-> this (.getEventType))))

(defn namespace?
  "A utility function to check if this event is a Namespace.

  returns: `boolean`"
  ([^javax.xml.stream.events.XMLEvent this]
    (-> this (.isNamespace))))

(defn characters?
  "A utility function to check if this event is Characters.

  returns: `boolean`"
  ([^javax.xml.stream.events.XMLEvent this]
    (-> this (.isCharacters))))

(defn start-element?
  "A utility function to check if this event is a StartElement.

  returns: `boolean`"
  ([^javax.xml.stream.events.XMLEvent this]
    (-> this (.isStartElement))))

(defn processing-instruction?
  "A utility function to check if this event is a ProcessingInstruction.

  returns: `boolean`"
  ([^javax.xml.stream.events.XMLEvent this]
    (-> this (.isProcessingInstruction))))

(defn end-document?
  "A utility function to check if this event is an EndDocument.

  returns: `boolean`"
  ([^javax.xml.stream.events.XMLEvent this]
    (-> this (.isEndDocument))))

(defn entity-reference?
  "A utility function to check if this event is an EntityReference.

  returns: `boolean`"
  ([^javax.xml.stream.events.XMLEvent this]
    (-> this (.isEntityReference))))

(defn as-characters
  "Returns this event as Characters, may result in
   a class cast exception if this event is not Characters.

  returns: `javax.xml.stream.events.Characters`"
  ([^javax.xml.stream.events.XMLEvent this]
    (-> this (.asCharacters))))

(defn get-schema-type
  "This method is provided for implementations to provide
   optional type information about the associated event.
   It is optional and will return null if no information
   is available.

  returns: `javax.xml.namespace.QName`"
  ([^javax.xml.stream.events.XMLEvent this]
    (-> this (.getSchemaType))))

(defn as-end-element
  "Returns this event as an end  element event, may result in
   a class cast exception if this event is not a end element.

  returns: `javax.xml.stream.events.EndElement`"
  ([^javax.xml.stream.events.XMLEvent this]
    (-> this (.asEndElement))))

(defn as-start-element
  "Returns this event as a start element event, may result in
   a class cast exception if this event is not a start element.

  returns: `javax.xml.stream.events.StartElement`"
  ([^javax.xml.stream.events.XMLEvent this]
    (-> this (.asStartElement))))

(defn start-document?
  "A utility function to check if this event is a StartDocument.

  returns: `boolean`"
  ([^javax.xml.stream.events.XMLEvent this]
    (-> this (.isStartDocument))))

(defn attribute?
  "A utility function to check if this event is an Attribute.

  returns: `boolean`"
  ([^javax.xml.stream.events.XMLEvent this]
    (-> this (.isAttribute))))

(defn end-element?
  "A utility function to check if this event is a EndElement.

  returns: `boolean`"
  ([^javax.xml.stream.events.XMLEvent this]
    (-> this (.isEndElement))))

