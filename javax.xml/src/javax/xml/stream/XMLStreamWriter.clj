(ns javax.xml.stream.XMLStreamWriter
  "The XMLStreamWriter interface specifies how to write XML.  The XMLStreamWriter  does
  not perform well formedness checking on its input.  However
  the writeCharacters method is required to escape & , < and >
  For attribute values the writeAttribute method will escape the
  above characters plus ` to ensure that all character content
  and attribute values are well formed.

  Each NAMESPACE
  and ATTRIBUTE must be individually written.




              XML Namespaces, javax.xml.stream.isRepairingNamespaces and write method behaviour


              Method  method
              isRepairingNamespaces == true
              isRepairingNamespaces == false


                method
              namespaceURI bound
              namespaceURI unbound
              namespaceURI bound
              namespaceURI unbound





              writeAttribute(namespaceURI, localName, value)
               isRepairingNamespaces == true

                   namespaceURI bound
                  prefix:localName=`value` [1]


                   namespaceURI unbound
                  xmlns:{generated}=`namespaceURI` {generated}:localName=`value`

               isRepairingNamespaces == false

                   namespaceURI bound
                  prefix:localName=`value` [1]


                   namespaceURI unbound
                  XMLStreamException




              writeAttribute(prefix, namespaceURI, localName, value)
               isRepairingNamespaces == true

                   namespaceURI bound
                  bound to same prefix:
                  prefix:localName=`value` [1]

                  bound to different prefix:
                  xmlns:{generated}=`namespaceURI` {generated}:localName=`value`


                   namespaceURI unbound
                  xmlns:prefix=`namespaceURI` prefix:localName=`value` [3]

               isRepairingNamespaces == false

                   namespaceURI bound
                  bound to same prefix:
                  prefix:localName=`value` [1][2]

                  bound to different prefix:
                  XMLStreamException[2]


                   namespaceURI unbound
                  xmlns:prefix=`namespaceURI` prefix:localName=`value` [2][5]




              writeStartElement(namespaceURI, localName)

                  writeEmptyElement(namespaceURI, localName)
               isRepairingNamespaces == true

                   namespaceURI bound
                  <prefix:localName> [1]


                   namespaceURI unbound
                  <{generated}:localName xmlns:{generated}=`namespaceURI`>

               isRepairingNamespaces == false

                   namespaceURI bound
                  <prefix:localName> [1]


                   namespaceURI unbound
                  XMLStreamException




              writeStartElement(prefix, localName, namespaceURI)

                  writeEmptyElement(prefix, localName, namespaceURI)
               isRepairingNamespaces == true

                   namespaceURI bound
                  bound to same prefix:
                  <prefix:localName> [1]

                  bound to different prefix:
                  <{generated}:localName xmlns:{generated}=`namespaceURI`>


                   namespaceURI unbound
                  <prefix:localName xmlns:prefix=`namespaceURI`> [4]

               isRepairingNamespaces == false

                   namespaceURI bound
                  bound to same prefix:
                  <prefix:localName> [1]

                  bound to different prefix:
                  XMLStreamException


                   namespaceURI unbound
                  <prefix:localName>






                  Notes:

                      [1] if namespaceURI == default Namespace URI, then no prefix is written
                      [2] if prefix == `` || null && namespaceURI == ``, then no prefix or Namespace declaration is generated or written
                      [3] if prefix == `` || null, then a prefix is randomly generated
                      [4] if prefix == `` || null, then it is treated as the default Namespace and no prefix is generated or written, an xmlns declaration is generated and written if the namespaceURI is unbound
                      [5] if prefix == `` || null, then it is treated as an invalid attempt to define the default Namespace and an XMLStreamException is thrown"
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.xml.stream XMLStreamWriter]))

(defn set-prefix
  "Sets the prefix the uri is bound to.  This prefix is bound
   in the scope of the current START_ELEMENT / END_ELEMENT pair.
   If this method is called before a START_ELEMENT has been written
   the prefix is bound in the root scope.

  prefix - the prefix to bind to the uri, may not be null - `java.lang.String`
  uri - the uri to bind to the prefix, may be null - `java.lang.String`

  throws: javax.xml.stream.XMLStreamException"
  ([^XMLStreamWriter this ^java.lang.String prefix ^java.lang.String uri]
    (-> this (.setPrefix prefix uri))))

(defn write-namespace
  "Writes a namespace to the output stream
   If the prefix argument to this method is the empty string,
   `xmlns`, or null this method will delegate to writeDefaultNamespace

  prefix - the prefix to bind this namespace to - `java.lang.String`
  namespace-uri - the uri to bind the prefix to - `java.lang.String`

  throws: java.lang.IllegalStateException - if the current state does not allow Namespace writing"
  ([^XMLStreamWriter this ^java.lang.String prefix ^java.lang.String namespace-uri]
    (-> this (.writeNamespace prefix namespace-uri))))

(defn write-dtd
  "Write a DTD section.  This string represents the entire doctypedecl production
   from the XML 1.0 specification.

  dtd - the DTD to be written - `java.lang.String`

  throws: javax.xml.stream.XMLStreamException"
  ([^XMLStreamWriter this ^java.lang.String dtd]
    (-> this (.writeDTD dtd))))

(defn set-namespace-context
  "Sets the current namespace context for prefix and uri bindings.
   This context becomes the root namespace context for writing and
   will replace the current root namespace context.  Subsequent calls
   to setPrefix and setDefaultNamespace will bind namespaces using
   the context passed to the method as the root context for resolving
   namespaces.  This method may only be called once at the start of
   the document.  It does not cause the namespaces to be declared.
   If a namespace URI to prefix mapping is found in the namespace
   context it is treated as declared and the prefix may be used
   by the StreamWriter.

  context - the namespace context to use for this writer, may not be null - `javax.xml.namespace.NamespaceContext`

  throws: javax.xml.stream.XMLStreamException"
  ([^XMLStreamWriter this ^javax.xml.namespace.NamespaceContext context]
    (-> this (.setNamespaceContext context))))

(defn write-default-namespace
  "Writes the default namespace to the stream

  namespace-uri - the uri to bind the default namespace to - `java.lang.String`

  throws: java.lang.IllegalStateException - if the current state does not allow Namespace writing"
  ([^XMLStreamWriter this ^java.lang.String namespace-uri]
    (-> this (.writeDefaultNamespace namespace-uri))))

(defn flush
  "Write any cached data to the underlying output mechanism.

  throws: javax.xml.stream.XMLStreamException"
  ([^XMLStreamWriter this]
    (-> this (.flush))))

(defn write-comment
  "Writes an xml comment with the data enclosed

  data - the data contained in the comment, may be null - `java.lang.String`

  throws: javax.xml.stream.XMLStreamException"
  ([^XMLStreamWriter this ^java.lang.String data]
    (-> this (.writeComment data))))

(defn write-start-document
  "Write the XML Declaration.  Note that the encoding parameter does
   not set the actual encoding of the underlying output.  That must
   be set when the instance of the XMLStreamWriter is created using the
   XMLOutputFactory

  encoding - encoding of the xml declaration - `java.lang.String`
  version - version of the xml document - `java.lang.String`

  throws: javax.xml.stream.XMLStreamException - If given encoding does not match encoding of the underlying stream"
  ([^XMLStreamWriter this ^java.lang.String encoding ^java.lang.String version]
    (-> this (.writeStartDocument encoding version)))
  ([^XMLStreamWriter this ^java.lang.String version]
    (-> this (.writeStartDocument version)))
  ([^XMLStreamWriter this]
    (-> this (.writeStartDocument))))

(defn write-processing-instruction
  "Writes a processing instruction

  target - the target of the processing instruction, may not be null - `java.lang.String`
  data - the data contained in the processing instruction, may not be null - `java.lang.String`

  throws: javax.xml.stream.XMLStreamException"
  ([^XMLStreamWriter this ^java.lang.String target ^java.lang.String data]
    (-> this (.writeProcessingInstruction target data)))
  ([^XMLStreamWriter this ^java.lang.String target]
    (-> this (.writeProcessingInstruction target))))

(defn set-default-namespace
  "Binds a URI to the default namespace
   This URI is bound
   in the scope of the current START_ELEMENT / END_ELEMENT pair.
   If this method is called before a START_ELEMENT has been written
   the uri is bound in the root scope.

  uri - the uri to bind to the default namespace, may be null - `java.lang.String`

  throws: javax.xml.stream.XMLStreamException"
  ([^XMLStreamWriter this ^java.lang.String uri]
    (-> this (.setDefaultNamespace uri))))

(defn write-characters
  "Write text to the output

  text - the value to write - `char[]`
  start - the starting position in the array - `int`
  len - the number of characters to write - `int`

  throws: javax.xml.stream.XMLStreamException"
  ([^XMLStreamWriter this text ^Integer start ^Integer len]
    (-> this (.writeCharacters text start len)))
  ([^XMLStreamWriter this ^java.lang.String text]
    (-> this (.writeCharacters text))))

(defn get-namespace-context
  "Returns the current namespace context.

  returns: the current NamespaceContext - `javax.xml.namespace.NamespaceContext`"
  (^javax.xml.namespace.NamespaceContext [^XMLStreamWriter this]
    (-> this (.getNamespaceContext))))

(defn write-start-element
  "Writes a start tag to the output

  prefix - the prefix of the tag, may not be null - `java.lang.String`
  local-name - local name of the tag, may not be null - `java.lang.String`
  namespace-uri - the uri to bind the prefix to, may not be null - `java.lang.String`

  throws: javax.xml.stream.XMLStreamException"
  ([^XMLStreamWriter this ^java.lang.String prefix ^java.lang.String local-name ^java.lang.String namespace-uri]
    (-> this (.writeStartElement prefix local-name namespace-uri)))
  ([^XMLStreamWriter this ^java.lang.String namespace-uri ^java.lang.String local-name]
    (-> this (.writeStartElement namespace-uri local-name)))
  ([^XMLStreamWriter this ^java.lang.String local-name]
    (-> this (.writeStartElement local-name))))

(defn write-c-data
  "Writes a CData section

  data - the data contained in the CData Section, may not be null - `java.lang.String`

  throws: javax.xml.stream.XMLStreamException"
  ([^XMLStreamWriter this ^java.lang.String data]
    (-> this (.writeCData data))))

(defn close
  "Close this writer and free any resources associated with the
   writer.  This must not close the underlying output stream.

  throws: javax.xml.stream.XMLStreamException"
  ([^XMLStreamWriter this]
    (-> this (.close))))

(defn get-property
  "Get the value of a feature/property from the underlying implementation

  name - The name of the property, may not be null - `java.lang.String`

  returns: The value of the property - `java.lang.Object`

  throws: java.lang.IllegalArgumentException - if the property is not supported"
  (^java.lang.Object [^XMLStreamWriter this ^java.lang.String name]
    (-> this (.getProperty name))))

(defn write-attribute
  "Writes an attribute to the output stream

  prefix - the prefix for this attribute - `java.lang.String`
  namespace-uri - the uri of the prefix for this attribute - `java.lang.String`
  local-name - the local name of the attribute - `java.lang.String`
  value - the value of the attribute - `java.lang.String`

  throws: java.lang.IllegalStateException - if the current state does not allow Attribute writing"
  ([^XMLStreamWriter this ^java.lang.String prefix ^java.lang.String namespace-uri ^java.lang.String local-name ^java.lang.String value]
    (-> this (.writeAttribute prefix namespace-uri local-name value)))
  ([^XMLStreamWriter this ^java.lang.String namespace-uri ^java.lang.String local-name ^java.lang.String value]
    (-> this (.writeAttribute namespace-uri local-name value)))
  ([^XMLStreamWriter this ^java.lang.String local-name ^java.lang.String value]
    (-> this (.writeAttribute local-name value))))

(defn get-prefix
  "Gets the prefix the uri is bound to

  uri - `java.lang.String`

  returns: the prefix or null - `java.lang.String`

  throws: javax.xml.stream.XMLStreamException"
  (^java.lang.String [^XMLStreamWriter this ^java.lang.String uri]
    (-> this (.getPrefix uri))))

(defn write-entity-ref
  "Writes an entity reference

  name - the name of the entity - `java.lang.String`

  throws: javax.xml.stream.XMLStreamException"
  ([^XMLStreamWriter this ^java.lang.String name]
    (-> this (.writeEntityRef name))))

(defn write-empty-element
  "Writes an empty element tag to the output

  prefix - the prefix of the tag, may not be null - `java.lang.String`
  local-name - local name of the tag, may not be null - `java.lang.String`
  namespace-uri - the uri to bind the tag to, may not be null - `java.lang.String`

  throws: javax.xml.stream.XMLStreamException"
  ([^XMLStreamWriter this ^java.lang.String prefix ^java.lang.String local-name ^java.lang.String namespace-uri]
    (-> this (.writeEmptyElement prefix local-name namespace-uri)))
  ([^XMLStreamWriter this ^java.lang.String namespace-uri ^java.lang.String local-name]
    (-> this (.writeEmptyElement namespace-uri local-name)))
  ([^XMLStreamWriter this ^java.lang.String local-name]
    (-> this (.writeEmptyElement local-name))))

(defn write-end-document
  "Closes any start tags and writes corresponding end tags.

  throws: javax.xml.stream.XMLStreamException"
  ([^XMLStreamWriter this]
    (-> this (.writeEndDocument))))

(defn write-end-element
  "Writes an end tag to the output relying on the internal
   state of the writer to determine the prefix and local name
   of the event.

  throws: javax.xml.stream.XMLStreamException"
  ([^XMLStreamWriter this]
    (-> this (.writeEndElement))))

