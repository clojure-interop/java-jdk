(ns javax.xml.transform.stream.StreamSource
  "Acts as an holder for a transformation Source in the form
  of a stream of XML markup.

  Note: Due to their internal use of either a Reader or InputStream instance,
  StreamSource instances may only be used once."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.xml.transform.stream StreamSource]))

(defn ->stream-source
  "Constructor.

  Construct a StreamSource from a byte stream.  Normally,
   a stream should be used rather than a reader, so that
   the XML parser can resolve character encoding specified
   by the XML declaration.

   This constructor allows the systemID to be set in addition
   to the input stream, which allows relative URIs
   to be processed.

  input-stream - A valid InputStream reference to an XML stream. - `java.io.InputStream`
  system-id - Must be a String that conforms to the URI syntax. - `java.lang.String`"
  ([^java.io.InputStream input-stream ^java.lang.String system-id]
    (new StreamSource input-stream system-id))
  ([^java.io.InputStream input-stream]
    (new StreamSource input-stream))
  ([]
    (new StreamSource )))

(def *-feature
  "Static Constant.

  If TransformerFactory.getFeature(java.lang.String)
   returns true when passed this value as an argument,
   the Transformer supports Source input of this type.

  type: java.lang.String"
  StreamSource/FEATURE)

(defn set-input-stream
  "Set the byte stream to be used as input.  Normally,
   a stream should be used rather than a reader, so that
   the XML parser can resolve character encoding specified
   by the XML declaration.

   If this Source object is used to process a stylesheet, normally
   setSystemId should also be called, so that relative URL references
   can be resolved.

  input-stream - A valid InputStream reference to an XML stream. - `java.io.InputStream`"
  ([^javax.xml.transform.stream.StreamSource this ^java.io.InputStream input-stream]
    (-> this (.setInputStream input-stream))))

(defn get-input-stream
  "Get the byte stream that was set with setByteStream.

  returns: The byte stream that was set with setByteStream, or null
   if setByteStream or the ByteStream constructor was not called. - `java.io.InputStream`"
  (^java.io.InputStream [^javax.xml.transform.stream.StreamSource this]
    (-> this (.getInputStream))))

(defn set-reader
  "Set the input to be a character reader.  Normally,
   a stream should be used rather than a reader, so that
   the XML parser can resolve character encoding specified
   by the XML declaration.  However, in many cases the encoding
   of the input stream is already resolved, as in the case of
   reading XML from a StringReader.

  reader - A valid Reader reference to an XML CharacterStream. - `java.io.Reader`"
  ([^javax.xml.transform.stream.StreamSource this ^java.io.Reader reader]
    (-> this (.setReader reader))))

(defn get-reader
  "Get the character stream that was set with setReader.

  returns: The character stream that was set with setReader, or null
   if setReader or the Reader constructor was not called. - `java.io.Reader`"
  (^java.io.Reader [^javax.xml.transform.stream.StreamSource this]
    (-> this (.getReader))))

(defn set-public-id
  "Set the public identifier for this Source.

   The public identifier is always optional: if the application
   writer includes one, it will be provided as part of the
   location information.

  public-id - The public identifier as a string. - `java.lang.String`"
  ([^javax.xml.transform.stream.StreamSource this ^java.lang.String public-id]
    (-> this (.setPublicId public-id))))

(defn get-public-id
  "Get the public identifier that was set with setPublicId.

  returns: The public identifier that was set with setPublicId, or null
   if setPublicId was not called. - `java.lang.String`"
  (^java.lang.String [^javax.xml.transform.stream.StreamSource this]
    (-> this (.getPublicId))))

(defn set-system-id
  "Set the system identifier for this Source.

   The system identifier is optional if there is a byte stream
   or a character stream, but it is still useful to provide one,
   since the application can use it to resolve relative URIs
   and can include it in error messages and warnings (the parser
   will attempt to open a connection to the URI only if
   there is no byte stream or character stream specified).

  system-id - The system identifier as a URL string. - `java.lang.String`"
  ([^javax.xml.transform.stream.StreamSource this ^java.lang.String system-id]
    (-> this (.setSystemId system-id))))

(defn get-system-id
  "Get the system identifier that was set with setSystemId.

  returns: The system identifier that was set with setSystemId, or null
   if setSystemId was not called. - `java.lang.String`"
  (^java.lang.String [^javax.xml.transform.stream.StreamSource this]
    (-> this (.getSystemId))))

