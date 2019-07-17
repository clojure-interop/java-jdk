(ns javax.xml.stream.util.StreamReaderDelegate
  "This is the base class for deriving an XMLStreamReader filter

  This class is designed to sit between an XMLStreamReader and an
  application's XMLStreamReader.   By default each method
  does nothing but call the corresponding method on the
  parent interface."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.xml.stream.util StreamReaderDelegate]))

(defn ->stream-reader-delegate
  "Constructor.

  Construct an filter with the specified parent.

  reader - the parent - `javax.xml.stream.XMLStreamReader`"
  ([reader]
    (new StreamReaderDelegate reader))
  ([]
    (new StreamReaderDelegate )))

(defn white-space?
  "Description copied from interface: XMLStreamReader

  returns: true if the cursor points to all whitespace, false otherwise - `boolean`"
  ([this]
    (-> this (.isWhiteSpace))))

(defn get-location
  "Description copied from interface: XMLStreamReader

  returns: `javax.xml.stream.Location`"
  ([this]
    (-> this (.getLocation))))

(defn set-parent
  "Set the parent of this instance.

  reader - the new parent - `javax.xml.stream.XMLStreamReader`"
  ([this reader]
    (-> this (.setParent reader))))

(defn get-attribute-name
  "Description copied from interface: XMLStreamReader

  index - the position of the attribute - `int`

  returns: the QName of the attribute - `javax.xml.namespace.QName`"
  ([this index]
    (-> this (.getAttributeName index))))

(defn get-namespace-uri
  "Description copied from interface: XMLStreamReader

  prefix - The prefix to lookup, may not be null - `java.lang.String`

  returns: the uri bound to the given prefix or null if it is not bound - `java.lang.String`"
  ([this prefix]
    (-> this (.getNamespaceURI prefix)))
  ([this]
    (-> this (.getNamespaceURI))))

(defn next
  "Description copied from interface: XMLStreamReader

  returns: the integer code corresponding to the current parse event - `int`

  throws: javax.xml.stream.XMLStreamException - if there is an error processing the underlying XML source"
  ([this]
    (-> this (.next))))

(defn get-event-type
  "Description copied from interface: XMLStreamReader

  returns: `int`"
  ([this]
    (-> this (.getEventType))))

(defn get-encoding
  "Description copied from interface: XMLStreamReader

  returns: the encoding of this instance or null - `java.lang.String`"
  ([this]
    (-> this (.getEncoding))))

(defn get-pi-data
  "Description copied from interface: XMLStreamReader

  returns: the data or null - `java.lang.String`"
  ([this]
    (-> this (.getPIData))))

(defn characters?
  "Description copied from interface: XMLStreamReader

  returns: true if the cursor points to character data, false otherwise - `boolean`"
  ([this]
    (-> this (.isCharacters))))

(defn start-element?
  "Description copied from interface: XMLStreamReader

  returns: true if the cursor points to a start tag, false otherwise - `boolean`"
  ([this]
    (-> this (.isStartElement))))

(defn has-name?
  "Description copied from interface: XMLStreamReader

  returns: `boolean`"
  ([this]
    (-> this (.hasName))))

(defn get-text-start
  "Description copied from interface: XMLStreamReader

  returns: `int`"
  ([this]
    (-> this (.getTextStart))))

(defn has-text?
  "Description copied from interface: XMLStreamReader

  returns: `boolean`"
  ([this]
    (-> this (.hasText))))

(defn get-text
  "Description copied from interface: XMLStreamReader

  returns: the current text or null - `java.lang.String`"
  ([this]
    (-> this (.getText))))

(defn get-element-text
  "Description copied from interface: XMLStreamReader

  returns: `java.lang.String`

  throws: javax.xml.stream.XMLStreamException - if the current event is not a START_ELEMENT or if a non text element is encountered"
  ([this]
    (-> this (.getElementText))))

(defn require
  "Description copied from interface: XMLStreamReader

  type - the event type - `int`
  namespace-uri - the uri of the event, may be null - `java.lang.String`
  local-name - the localName of the event, may be null - `java.lang.String`

  throws: javax.xml.stream.XMLStreamException - if the required values are not matched."
  ([this type namespace-uri local-name]
    (-> this (.require type namespace-uri local-name))))

(defn attribute-specified?
  "Description copied from interface: XMLStreamReader

  index - the position of the attribute - `int`

  returns: true if this is a default attribute - `boolean`"
  ([this index]
    (-> this (.isAttributeSpecified index))))

(defn get-namespace-count
  "Description copied from interface: XMLStreamReader

  returns: returns the number of namespace declarations on this specific element - `int`"
  ([this]
    (-> this (.getNamespaceCount))))

(defn get-attribute-count
  "Description copied from interface: XMLStreamReader

  returns: returns the number of attributes - `int`"
  ([this]
    (-> this (.getAttributeCount))))

(defn get-text-length
  "Description copied from interface: XMLStreamReader

  returns: `int`"
  ([this]
    (-> this (.getTextLength))))

(defn get-character-encoding-scheme
  "Description copied from interface: XMLStreamReader

  returns: the encoding declared in the document or null - `java.lang.String`"
  ([this]
    (-> this (.getCharacterEncodingScheme))))

(defn get-name
  "Description copied from interface: XMLStreamReader

  returns: the QName for the current START_ELEMENT or END_ELEMENT event - `javax.xml.namespace.QName`"
  ([this]
    (-> this (.getName))))

(defn get-namespace-context
  "Description copied from interface: XMLStreamReader

  returns: return a namespace context - `javax.xml.namespace.NamespaceContext`"
  ([this]
    (-> this (.getNamespaceContext))))

(defn get-text-characters
  "Description copied from interface: XMLStreamReader

  source-start - the index of the first character in the source array to copy - `int`
  target - the destination array - `char[]`
  target-start - the start offset in the target array - `int`
  length - the number of characters to copy - `int`

  returns: the number of characters actually copied - `int`

  throws: javax.xml.stream.XMLStreamException - if the underlying XML source is not well-formed"
  ([this source-start target target-start length]
    (-> this (.getTextCharacters source-start target target-start length)))
  ([this]
    (-> this (.getTextCharacters))))

(defn get-version
  "Description copied from interface: XMLStreamReader

  returns: the XML version or null - `java.lang.String`"
  ([this]
    (-> this (.getVersion))))

(defn get-parent
  "Get the parent of this instance.

  returns: the parent or null if none is set - `javax.xml.stream.XMLStreamReader`"
  ([this]
    (-> this (.getParent))))

(defn has-next?
  "Description copied from interface: XMLStreamReader

  returns: true if there are more events, false otherwise - `boolean`

  throws: javax.xml.stream.XMLStreamException - if there is a fatal error detecting the next state"
  ([this]
    (-> this (.hasNext))))

(defn get-attribute-value
  "Description copied from interface: XMLStreamReader

  namespace-uri - the namespace of the attribute - `java.lang.String`
  local-name - the local name of the attribute, cannot be null - `java.lang.String`

  returns: returns the value of the attribute , returns null if not found - `java.lang.String`"
  ([this namespace-uri local-name]
    (-> this (.getAttributeValue namespace-uri local-name)))
  ([this index]
    (-> this (.getAttributeValue index))))

(defn close
  "Description copied from interface: XMLStreamReader

  throws: javax.xml.stream.XMLStreamException - if there are errors freeing associated resources"
  ([this]
    (-> this (.close))))

(defn get-property
  "Description copied from interface: XMLStreamReader

  name - The name of the property, may not be null - `java.lang.String`

  returns: The value of the property - `java.lang.Object`"
  ([this name]
    (-> this (.getProperty name))))

(defn get-namespace-prefix
  "Description copied from interface: XMLStreamReader

  index - the position of the namespace declaration - `int`

  returns: returns the namespace prefix - `java.lang.String`"
  ([this index]
    (-> this (.getNamespacePrefix index))))

(defn next-tag
  "Description copied from interface: XMLStreamReader

  returns: the event type of the element read (START_ELEMENT or END_ELEMENT) - `int`

  throws: javax.xml.stream.XMLStreamException - if the current event is not white space, PROCESSING_INSTRUCTION, START_ELEMENT or END_ELEMENT"
  ([this]
    (-> this (.nextTag))))

(defn get-attribute-local-name
  "Description copied from interface: XMLStreamReader

  index - the position of the attribute - `int`

  returns: the localName of the attribute - `java.lang.String`"
  ([this index]
    (-> this (.getAttributeLocalName index))))

(defn standalone?
  "Description copied from interface: XMLStreamReader

  returns: true if this is standalone, or false otherwise - `boolean`"
  ([this]
    (-> this (.isStandalone))))

(defn get-prefix
  "Description copied from interface: XMLStreamReader

  returns: the prefix or null - `java.lang.String`"
  ([this]
    (-> this (.getPrefix))))

(defn get-pi-target
  "Description copied from interface: XMLStreamReader

  returns: the target or null - `java.lang.String`"
  ([this]
    (-> this (.getPITarget))))

(defn get-attribute-prefix
  "Description copied from interface: XMLStreamReader

  index - the position of the attribute - `int`

  returns: the prefix of the attribute - `java.lang.String`"
  ([this index]
    (-> this (.getAttributePrefix index))))

(defn get-local-name
  "Description copied from interface: XMLStreamReader

  returns: the localName - `java.lang.String`"
  ([this]
    (-> this (.getLocalName))))

(defn end-element?
  "Description copied from interface: XMLStreamReader

  returns: true if the cursor points to an end tag, false otherwise - `boolean`"
  ([this]
    (-> this (.isEndElement))))

(defn get-attribute-type
  "Description copied from interface: XMLStreamReader

  index - the position of the attribute - `int`

  returns: the XML type of the attribute - `java.lang.String`"
  ([this index]
    (-> this (.getAttributeType index))))

(defn standalone-set
  "Description copied from interface: XMLStreamReader

  returns: true if standalone was set in the document, or false otherwise - `boolean`"
  ([this]
    (-> this (.standaloneSet))))

(defn get-attribute-namespace
  "Description copied from interface: XMLStreamReader

  index - the position of the attribute - `int`

  returns: the namespace URI (can be null) - `java.lang.String`"
  ([this index]
    (-> this (.getAttributeNamespace index))))

