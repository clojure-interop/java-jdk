(ns javax.xml.stream.XMLEventWriter
  "This is the top level interface for writing XML documents.

  Instances of this interface are not required to validate the
  form of the XML."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.xml.stream XMLEventWriter]))

(defn flush
  "Writes any cached events to the underlying output mechanism

  throws: javax.xml.stream.XMLStreamException"
  ([^. this]
    (-> this (.flush))))

(defn close
  "Frees any resources associated with this stream

  throws: javax.xml.stream.XMLStreamException"
  ([^. this]
    (-> this (.close))))

(defn add
  "Add an event to the output stream
   Adding a START_ELEMENT will open a new namespace scope that
   will be closed when the corresponding END_ELEMENT is written.




           Required and optional fields for events added to the writer





         Event Type
         Required Fields
         Optional Fields
         Required Behavior


          START_ELEMENT
          QName name
          namespaces , attributes
          A START_ELEMENT will be written by writing the name,
         namespaces, and attributes of the event in XML 1.0 valid
         syntax for START_ELEMENTs.
         The name is written by looking up the prefix for
         the namespace uri.  The writer can be configured to
         respect prefixes of QNames.  If the writer is respecting
         prefixes it must use the prefix set on the QName.  The
         default behavior is to lookup the value for the prefix
         on the EventWriter's internal namespace context.
         Each attribute (if any)
         is written using the behavior specified in the attribute
         section of this table.  Each namespace (if any) is written
         using the behavior specified in the namespace section of this
         table.



          END_ELEMENT
          Qname name
          None
          A well formed END_ELEMENT tag is written.
         The name is written by looking up the prefix for
         the namespace uri.  The writer can be configured to
         respect prefixes of QNames.  If the writer is respecting
         prefixes it must use the prefix set on the QName.  The
         default behavior is to lookup the value for the prefix
         on the EventWriter's internal namespace context.
         If the END_ELEMENT name does not match the START_ELEMENT
         name an XMLStreamException is thrown.



          ATTRIBUTE
          QName name , String value
          QName type
          An attribute is written using the same algorithm
              to find the lexical form as used in START_ELEMENT.
              The default is to use double quotes to wrap attribute
              values and to escape any double quotes found in the
              value.  The type value is ignored.



          NAMESPACE
          String prefix, String namespaceURI,
              boolean isDefaultNamespaceDeclaration

          None
          A namespace declaration is written.  If the
              namespace is a default namespace declaration
              (isDefault is true) then xmlns=`$namespaceURI`
              is written and the prefix is optional.  If
              isDefault is false, the prefix must be declared
              and the writer must prepend xmlns to the prefix
              and write out a standard prefix declaration.



          PROCESSING_INSTRUCTION
            None
            String target, String data
            The data does not need to be present and may be
                null.  Target is required and many not be null.
                The writer
                will write data section
                directly after the target,
                enclosed in appropriate XML 1.0 syntax



          COMMENT
          None
          String comment
          If the comment is present (not null) it is written, otherwise an
              an empty comment is written



          START_DOCUMENT
          None
          String encoding , boolean standalone, String version
          A START_DOCUMENT event is not required to be written to the
               stream.  If present the attributes are written inside
               the appropriate XML declaration syntax



          END_DOCUMENT
          None
          None
          Nothing is written to the output


          DTD
          String DocumentTypeDefinition
          None
          The DocumentTypeDefinition is written to the output

  event - the event to be added - `javax.xml.stream.events.XMLEvent`

  throws: javax.xml.stream.XMLStreamException"
  ([^. this ^javax.xml.stream.events.XMLEvent event]
    (-> this (.add event))))

(defn get-prefix
  "Gets the prefix the uri is bound to

  uri - the uri to look up - `java.lang.String`

  returns: `java.lang.String`

  throws: javax.xml.stream.XMLStreamException"
  ([^. this ^java.lang.String uri]
    (-> this (.getPrefix uri))))

(defn set-prefix
  "Sets the prefix the uri is bound to.  This prefix is bound
   in the scope of the current START_ELEMENT / END_ELEMENT pair.
   If this method is called before a START_ELEMENT has been written
   the prefix is bound in the root scope.

  prefix - the prefix to bind to the uri - `java.lang.String`
  uri - the uri to bind to the prefix - `java.lang.String`

  throws: javax.xml.stream.XMLStreamException"
  ([^. this ^java.lang.String prefix ^java.lang.String uri]
    (-> this (.setPrefix prefix uri))))

(defn set-default-namespace
  "Binds a URI to the default namespace
   This URI is bound
   in the scope of the current START_ELEMENT / END_ELEMENT pair.
   If this method is called before a START_ELEMENT has been written
   the uri is bound in the root scope.

  uri - the uri to bind to the default namespace - `java.lang.String`

  throws: javax.xml.stream.XMLStreamException"
  ([^. this ^java.lang.String uri]
    (-> this (.setDefaultNamespace uri))))

(defn set-namespace-context
  "Sets the current namespace context for prefix and uri bindings.
   This context becomes the root namespace context for writing and
   will replace the current root namespace context.  Subsequent calls
   to setPrefix and setDefaultNamespace will bind namespaces using
   the context passed to the method as the root context for resolving
   namespaces.

  context - the namespace context to use for this writer - `javax.xml.namespace.NamespaceContext`

  throws: javax.xml.stream.XMLStreamException"
  ([^. this ^javax.xml.namespace.NamespaceContext context]
    (-> this (.setNamespaceContext context))))

(defn get-namespace-context
  "Returns the current namespace context.

  returns: the current namespace context - `javax.xml.namespace.NamespaceContext`"
  ([^. this]
    (-> this (.getNamespaceContext))))

