(ns javax.xml.stream.XMLStreamReader
  "The XMLStreamReader interface allows forward, read-only access to XML.
   It is designed to be the lowest level and most efficient way to
   read XML data.

   The XMLStreamReader is designed to iterate over XML using
  next() and hasNext().  The data can be accessed using methods such as getEventType(),
  getNamespaceURI(), getLocalName() and getText();

   The next() method causes the reader to read the next parse event.
  The next() method returns an integer which identifies the type of event just read.
   The event type can be determined using getEventType().
   Parsing events are defined as the XML Declaration, a DTD,
  start tag, character data, white space, end tag, comment,
  or processing instruction.  An attribute or namespace event may be encountered
  at the root level of a document as the result of a query operation.

  For XML 1.0 compliance an XML processor must pass the
  identifiers of declared unparsed entities, notation declarations and their
  associated identifiers to the application.  This information is
  provided through the property API on this interface.
  The following two properties allow access to this information:
  javax.xml.stream.notations and javax.xml.stream.entities.
  When the current event is a DTD the following call will return a
  list of Notations
   List l = (List) getProperty(`javax.xml.stream.notations`);
  The following call will return a list of entity declarations:
  List l = (List) getProperty(`javax.xml.stream.entities`);
  These properties can only be accessed during a DTD event and
  are defined to return null if the information is not available.

  The following table describes which methods are valid in what state.
  If a method is called in an invalid state the method will throw a
  java.lang.IllegalStateException.





          Valid methods for each state





        Event Type
        Valid Methods


         All States
         getProperty(), hasNext(), require(), close(),
             getNamespaceURI(), isStartElement(),
             isEndElement(), isCharacters(), isWhiteSpace(),
             getNamespaceContext(), getEventType(),getLocation(),
             hasText(), hasName()



         START_ELEMENT
         next(), getName(), getLocalName(), hasName(), getPrefix(),
             getAttributeXXX(), isAttributeSpecified(),
             getNamespaceXXX(),
             getElementText(), nextTag()


         ATTRIBUTE
         next(), nextTag()
             getAttributeXXX(), isAttributeSpecified(),



         NAMESPACE
         next(), nextTag()
             getNamespaceXXX()



         END_ELEMENT
         next(), getName(), getLocalName(), hasName(), getPrefix(),
             getNamespaceXXX(), nextTag()



         CHARACTERS
         next(), getTextXXX(), nextTag()


         CDATA
         next(), getTextXXX(), nextTag()


         COMMENT
         next(), getTextXXX(), nextTag()


         SPACE
         next(), getTextXXX(), nextTag()


         START_DOCUMENT
         next(), getEncoding(), getVersion(), isStandalone(), standaloneSet(),
             getCharacterEncodingScheme(), nextTag()


         END_DOCUMENT
         close()


         PROCESSING_INSTRUCTION
         next(), getPITarget(), getPIData(), nextTag()


         ENTITY_REFERENCE
         next(), getLocalName(), getText(), nextTag()


         DTD
         next(), getText(), nextTag()"
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.xml.stream XMLStreamReader]))

(defn white-space?
  "Returns true if the cursor points to a character data event
   that consists of all whitespace

  returns: true if the cursor points to all whitespace, false otherwise - `boolean`"
  ([^. this]
    (-> this (.isWhiteSpace))))

(defn get-location
  "Return the current location of the processor.
   If the Location is unknown the processor should return
   an implementation of Location that returns -1 for the
   location and null for the publicId and systemId.
   The location information is only valid until next() is
   called.

  returns: `javax.xml.stream.Location`"
  ([^. this]
    (-> this (.getLocation))))

(defn get-attribute-name
  "Returns the qname of the attribute at the provided index

  index - the position of the attribute - `int`

  returns: the QName of the attribute - `javax.xml.namespace.QName`

  throws: java.lang.IllegalStateException - if this is not a START_ELEMENT or ATTRIBUTE"
  ([^. this ^Integer index]
    (-> this (.getAttributeName index))))

(defn get-namespace-uri
  "Return the uri for the given prefix.
   The uri returned depends on the current state of the processor.

   NOTE:The 'xml' prefix is bound as defined in
   Namespaces in XML
   specification to `http://www.w3.org/XML/1998/namespace`.

   NOTE: The 'xmlns' prefix must be resolved to following namespace
   http://www.w3.org/2000/xmlns/

  prefix - The prefix to lookup, may not be null - `java.lang.String`

  returns: the uri bound to the given prefix or null if it is not bound - `java.lang.String`

  throws: java.lang.IllegalArgumentException - if the prefix is null"
  ([^. this ^java.lang.String prefix]
    (-> this (.getNamespaceURI prefix)))
  ([^. this]
    (-> this (.getNamespaceURI))))

(defn next
  "Get next parsing event - a processor may return all contiguous
   character data in a single chunk, or it may split it into several chunks.
   If the property javax.xml.stream.isCoalescing is set to true
   element content must be coalesced and only one CHARACTERS event
   must be returned for contiguous element content or
   CDATA Sections.

   By default entity references must be
   expanded and reported transparently to the application.
   An exception will be thrown if an entity reference cannot be expanded.
   If element content is empty (i.e. content is ``) then no CHARACTERS event will be reported.

   Given the following XML:
   <foo><!--description-->content text<![CDATA[<greeting>Hello</greeting>]]>other content</foo>
   The behavior of calling next() when being on foo will be:
   1- the comment (COMMENT)
   2- then the characters section (CHARACTERS)
   3- then the CDATA section (another CHARACTERS)
   4- then the next characters section (another CHARACTERS)
   5- then the END_ELEMENT

   NOTE: empty element (such as <tag/>) will be reported
    with  two separate events: START_ELEMENT, END_ELEMENT - This preserves
     parsing equivalency of empty element to <tag></tag>.

   This method will throw an IllegalStateException if it is called after hasNext() returns false.

  returns: the integer code corresponding to the current parse event - `int`

  throws: NoSuchElementException - if this is called when hasNext() returns false"
  ([^. this]
    (-> this (.next))))

(defn get-event-type
  "Returns an integer code that indicates the type
   of the event the cursor is pointing to.

  returns: `int`"
  ([^. this]
    (-> this (.getEventType))))

(defn get-encoding
  "Return input encoding if known or null if unknown.

  returns: the encoding of this instance or null - `java.lang.String`"
  ([^. this]
    (-> this (.getEncoding))))

(defn get-pi-data
  "Get the data section of a processing instruction

  returns: the data or null - `java.lang.String`"
  ([^. this]
    (-> this (.getPIData))))

(defn characters?
  "Returns true if the cursor points to a character data event

  returns: true if the cursor points to character data, false otherwise - `boolean`"
  ([^. this]
    (-> this (.isCharacters))))

(defn start-element?
  "Returns true if the cursor points to a start tag (otherwise false)

  returns: true if the cursor points to a start tag, false otherwise - `boolean`"
  ([^. this]
    (-> this (.isStartElement))))

(defn has-name?
  "returns true if the current event has a name (is a START_ELEMENT or END_ELEMENT)
   returns false otherwise

  returns: `boolean`"
  ([^. this]
    (-> this (.hasName))))

(defn get-text-start
  "Returns the offset into the text character array where the first
   character (of this text event) is stored.

  returns: `int`

  throws: java.lang.IllegalStateException - if this state is not a valid text state."
  ([^. this]
    (-> this (.getTextStart))))

(defn has-text?
  "Return true if the current event has text, false otherwise
   The following events have text:
   CHARACTERS,DTD ,ENTITY_REFERENCE, COMMENT, SPACE

  returns: `boolean`"
  ([^. this]
    (-> this (.hasText))))

(defn get-text
  "Returns the current value of the parse event as a string,
   this returns the string value of a CHARACTERS event,
   returns the value of a COMMENT, the replacement value
   for an ENTITY_REFERENCE, the string value of a CDATA section,
   the string value for a SPACE event,
   or the String value of the internal subset of the DTD.
   If an ENTITY_REFERENCE has been resolved, any character data
   will be reported as CHARACTERS events.

  returns: the current text or null - `java.lang.String`

  throws: java.lang.IllegalStateException - if this state is not a valid text state."
  ([^. this]
    (-> this (.getText))))

(defn get-element-text
  "Reads the content of a text-only element, an exception is thrown if this is
   not a text-only element.
   Regardless of value of javax.xml.stream.isCoalescing this method always returns coalesced content.
    Precondition: the current event is START_ELEMENT.
    Postcondition: the current event is the corresponding END_ELEMENT.

   The method does the following (implementations are free to optimized
   but must do equivalent processing):


   if(getEventType() != XMLStreamConstants.START_ELEMENT) {
   throw new XMLStreamException(
   `parser must be on START_ELEMENT to read next text`, getLocation());
   }
   int eventType = next();
   StringBuffer content = new StringBuffer();
   while(eventType != XMLStreamConstants.END_ELEMENT ) {
   if(eventType == XMLStreamConstants.CHARACTERS
   || eventType == XMLStreamConstants.CDATA
   || eventType == XMLStreamConstants.SPACE
   || eventType == XMLStreamConstants.ENTITY_REFERENCE) {
   buf.append(getText());
   } else if(eventType == XMLStreamConstants.PROCESSING_INSTRUCTION
   || eventType == XMLStreamConstants.COMMENT) {
   // skipping
   } else if(eventType == XMLStreamConstants.END_DOCUMENT) {
   throw new XMLStreamException(
   `unexpected end of document when reading element text content`, this);
   } else if(eventType == XMLStreamConstants.START_ELEMENT) {
   throw new XMLStreamException(
   `element text content may not contain START_ELEMENT`, getLocation());
   } else {
   throw new XMLStreamException(
   `Unexpected event type `+eventType, getLocation());
   }
   eventType = next();
   }
   return buf.toString();

  returns: `java.lang.String`

  throws: javax.xml.stream.XMLStreamException - if the current event is not a START_ELEMENT or if a non text element is encountered"
  ([^. this]
    (-> this (.getElementText))))

(defn require
  "Test if the current event is of the given type and if the namespace and name match the current
   namespace and name of the current event.  If the namespaceURI is null it is not checked for equality,
   if the localName is null it is not checked for equality.

  type - the event type - `int`
  namespace-uri - the uri of the event, may be null - `java.lang.String`
  local-name - the localName of the event, may be null - `java.lang.String`

  throws: javax.xml.stream.XMLStreamException - if the required values are not matched."
  ([^. this ^Integer type ^java.lang.String namespace-uri ^java.lang.String local-name]
    (-> this (.require type namespace-uri local-name))))

(defn attribute-specified?
  "Returns a boolean which indicates if this
   attribute was created by default

  index - the position of the attribute - `int`

  returns: true if this is a default attribute - `boolean`

  throws: java.lang.IllegalStateException - if this is not a START_ELEMENT or ATTRIBUTE"
  ([^. this ^Integer index]
    (-> this (.isAttributeSpecified index))))

(defn get-namespace-count
  "Returns the count of namespaces declared on this START_ELEMENT or END_ELEMENT,
   this method is only valid on a START_ELEMENT, END_ELEMENT or NAMESPACE. On
   an END_ELEMENT the count is of the namespaces that are about to go
   out of scope.  This is the equivalent of the information reported
   by SAX callback for an end element event.

  returns: returns the number of namespace declarations on this specific element - `int`

  throws: java.lang.IllegalStateException - if this is not a START_ELEMENT, END_ELEMENT or NAMESPACE"
  ([^. this]
    (-> this (.getNamespaceCount))))

(defn get-attribute-count
  "Returns the count of attributes on this START_ELEMENT,
   this method is only valid on a START_ELEMENT or ATTRIBUTE.  This
   count excludes namespace definitions.  Attribute indices are
   zero-based.

  returns: returns the number of attributes - `int`

  throws: java.lang.IllegalStateException - if this is not a START_ELEMENT or ATTRIBUTE"
  ([^. this]
    (-> this (.getAttributeCount))))

(defn get-text-length
  "Returns the length of the sequence of characters for this
   Text event within the text character array.

  returns: `int`

  throws: java.lang.IllegalStateException - if this state is not a valid text state."
  ([^. this]
    (-> this (.getTextLength))))

(defn get-character-encoding-scheme
  "Returns the character encoding declared on the xml declaration
   Returns null if none was declared

  returns: the encoding declared in the document or null - `java.lang.String`"
  ([^. this]
    (-> this (.getCharacterEncodingScheme))))

(defn get-name
  "Returns a QName for the current START_ELEMENT or END_ELEMENT event

  returns: the QName for the current START_ELEMENT or END_ELEMENT event - `javax.xml.namespace.QName`

  throws: java.lang.IllegalStateException - if this is not a START_ELEMENT or END_ELEMENT"
  ([^. this]
    (-> this (.getName))))

(defn get-namespace-context
  "Returns a read only namespace context for the current
   position.  The context is transient and only valid until
   a call to next() changes the state of the reader.

  returns: return a namespace context - `javax.xml.namespace.NamespaceContext`"
  ([^. this]
    (-> this (.getNamespaceContext))))

(defn get-text-characters
  "Gets the the text associated with a CHARACTERS, SPACE or CDATA event.
   Text starting a `sourceStart` is copied into `target` starting at `targetStart`.
   Up to `length` characters are copied.  The number of characters actually copied is returned.

   The `sourceStart` argument must be greater or equal to 0 and less than or equal to
   the number of characters associated with the event.  Usually, one requests text starting at a `sourceStart` of 0.
   If the number of characters actually copied is less than the `length`, then there is no more text.
   Otherwise, subsequent calls need to be made until all text has been retrieved. For example:


   int length = 1024;
   char[] myBuffer = new char[ length ];

   for ( int sourceStart = 0 ; ; sourceStart = length )
   {
      int nCopied = stream.getTextCharacters( sourceStart, myBuffer, 0, length );

     if (nCopied < length)
         break;
   }

   XMLStreamException may be thrown if there are any XML errors in the underlying source.
   The `targetStart` argument must be greater than or equal to 0 and less than the length of `target`,
   Length must be greater than 0 and `targetStart  length` must be less than or equal to length of `target`.

  source-start - the index of the first character in the source array to copy - `int`
  target - the destination array - `char[]`
  target-start - the start offset in the target array - `int`
  length - the number of characters to copy - `int`

  returns: the number of characters actually copied - `int`

  throws: javax.xml.stream.XMLStreamException - if the underlying XML source is not well-formed"
  ([^. this ^Integer source-start target ^Integer target-start ^Integer length]
    (-> this (.getTextCharacters source-start target target-start length)))
  ([^. this]
    (-> this (.getTextCharacters))))

(defn get-version
  "Get the xml version declared on the xml declaration
   Returns null if none was declared

  returns: the XML version or null - `java.lang.String`"
  ([^. this]
    (-> this (.getVersion))))

(defn has-next?
  "Returns true if there are more parsing events and false
   if there are no more events.  This method will return
   false if the current state of the XMLStreamReader is
   END_DOCUMENT

  returns: true if there are more events, false otherwise - `boolean`

  throws: javax.xml.stream.XMLStreamException - if there is a fatal error detecting the next state"
  ([^. this]
    (-> this (.hasNext))))

(defn get-attribute-value
  "Returns the normalized attribute value of the
   attribute with the namespace and localName
   If the namespaceURI is null the namespace
   is not checked for equality

  namespace-uri - the namespace of the attribute - `java.lang.String`
  local-name - the local name of the attribute, cannot be null - `java.lang.String`

  returns: returns the value of the attribute , returns null if not found - `java.lang.String`

  throws: java.lang.IllegalStateException - if this is not a START_ELEMENT or ATTRIBUTE"
  ([^. this ^java.lang.String namespace-uri ^java.lang.String local-name]
    (-> this (.getAttributeValue namespace-uri local-name)))
  ([^. this ^Integer index]
    (-> this (.getAttributeValue index))))

(defn close
  "Frees any resources associated with this Reader.  This method does not close the
   underlying input source.

  throws: javax.xml.stream.XMLStreamException - if there are errors freeing associated resources"
  ([^. this]
    (-> this (.close))))

(defn get-property
  "Get the value of a feature/property from the underlying implementation

  name - The name of the property, may not be null - `java.lang.String`

  returns: The value of the property - `java.lang.Object`

  throws: java.lang.IllegalArgumentException - if name is null"
  ([^. this ^java.lang.String name]
    (-> this (.getProperty name))))

(defn get-namespace-prefix
  "Returns the prefix for the namespace declared at the
   index.  Returns null if this is the default namespace
   declaration

  index - the position of the namespace declaration - `int`

  returns: returns the namespace prefix - `java.lang.String`

  throws: java.lang.IllegalStateException - if this is not a START_ELEMENT, END_ELEMENT or NAMESPACE"
  ([^. this ^Integer index]
    (-> this (.getNamespacePrefix index))))

(defn next-tag
  "Skips any white space (isWhiteSpace() returns true), COMMENT,
   or PROCESSING_INSTRUCTION,
   until a START_ELEMENT or END_ELEMENT is reached.
   If other than white space characters, COMMENT, PROCESSING_INSTRUCTION, START_ELEMENT, END_ELEMENT
   are encountered, an exception is thrown. This method should
   be used when processing element-only content seperated by white space.

    Precondition: none
    Postcondition: the current event is START_ELEMENT or END_ELEMENT
   and cursor may have moved over any whitespace event.

   Essentially it does the following (implementations are free to optimized
   but must do equivalent processing):


   int eventType = next();
   while((eventType == XMLStreamConstants.CHARACTERS && isWhiteSpace()) // skip whitespace
   || (eventType == XMLStreamConstants.CDATA && isWhiteSpace())
   // skip whitespace
   || eventType == XMLStreamConstants.SPACE
   || eventType == XMLStreamConstants.PROCESSING_INSTRUCTION
   || eventType == XMLStreamConstants.COMMENT
   ) {
   eventType = next();
   }
   if (eventType != XMLStreamConstants.START_ELEMENT && eventType != XMLStreamConstants.END_ELEMENT) {
   throw new String XMLStreamException(`expected start or end tag`, getLocation());
   }
   return eventType;

  returns: the event type of the element read (START_ELEMENT or END_ELEMENT) - `int`

  throws: javax.xml.stream.XMLStreamException - if the current event is not white space, PROCESSING_INSTRUCTION, START_ELEMENT or END_ELEMENT"
  ([^. this]
    (-> this (.nextTag))))

(defn get-attribute-local-name
  "Returns the localName of the attribute at the provided
   index

  index - the position of the attribute - `int`

  returns: the localName of the attribute - `java.lang.String`

  throws: java.lang.IllegalStateException - if this is not a START_ELEMENT or ATTRIBUTE"
  ([^. this ^Integer index]
    (-> this (.getAttributeLocalName index))))

(defn standalone?
  "Get the standalone declaration from the xml declaration

  returns: true if this is standalone, or false otherwise - `boolean`"
  ([^. this]
    (-> this (.isStandalone))))

(defn get-prefix
  "Returns the prefix of the current event or null if the event does not have a prefix

  returns: the prefix or null - `java.lang.String`"
  ([^. this]
    (-> this (.getPrefix))))

(defn get-pi-target
  "Get the target of a processing instruction

  returns: the target or null - `java.lang.String`"
  ([^. this]
    (-> this (.getPITarget))))

(defn get-attribute-prefix
  "Returns the prefix of this attribute at the
   provided index

  index - the position of the attribute - `int`

  returns: the prefix of the attribute - `java.lang.String`

  throws: java.lang.IllegalStateException - if this is not a START_ELEMENT or ATTRIBUTE"
  ([^. this ^Integer index]
    (-> this (.getAttributePrefix index))))

(defn get-local-name
  "Returns the (local) name of the current event.
   For START_ELEMENT or END_ELEMENT returns the (local) name of the current element.
   For ENTITY_REFERENCE it returns entity name.
   The current event must be START_ELEMENT or END_ELEMENT,
   or ENTITY_REFERENCE

  returns: the localName - `java.lang.String`

  throws: java.lang.IllegalStateException - if this not a START_ELEMENT, END_ELEMENT or ENTITY_REFERENCE"
  ([^. this]
    (-> this (.getLocalName))))

(defn end-element?
  "Returns true if the cursor points to an end tag (otherwise false)

  returns: true if the cursor points to an end tag, false otherwise - `boolean`"
  ([^. this]
    (-> this (.isEndElement))))

(defn get-attribute-type
  "Returns the XML type of the attribute at the provided
   index

  index - the position of the attribute - `int`

  returns: the XML type of the attribute - `java.lang.String`

  throws: java.lang.IllegalStateException - if this is not a START_ELEMENT or ATTRIBUTE"
  ([^. this ^Integer index]
    (-> this (.getAttributeType index))))

(defn standalone-set
  "Checks if standalone was set in the document

  returns: true if standalone was set in the document, or false otherwise - `boolean`"
  ([^. this]
    (-> this (.standaloneSet))))

(defn get-attribute-namespace
  "Returns the namespace of the attribute at the provided
   index

  index - the position of the attribute - `int`

  returns: the namespace URI (can be null) - `java.lang.String`

  throws: java.lang.IllegalStateException - if this is not a START_ELEMENT or ATTRIBUTE"
  ([^. this ^Integer index]
    (-> this (.getAttributeNamespace index))))

