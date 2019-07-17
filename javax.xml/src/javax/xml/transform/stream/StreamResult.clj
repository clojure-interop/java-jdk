(ns javax.xml.transform.stream.StreamResult
  "Acts as an holder for a transformation result,
  which may be XML, plain Text, HTML, or some other form of markup."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.xml.transform.stream StreamResult]))

(defn ->stream-result
  "Constructor.

  Construct a StreamResult from a byte stream.  Normally,
   a stream should be used rather than a reader, so that
   the transformer may use instructions contained in the
   transformation instructions to control the encoding.

  output-stream - A valid OutputStream reference. - `java.io.OutputStream`"
  ([^java.io.OutputStream output-stream]
    (new StreamResult output-stream))
  ([]
    (new StreamResult )))

(def *-feature
  "Static Constant.

  If TransformerFactory.getFeature(java.lang.String)
   returns true when passed this value as an argument,
   the Transformer supports Result output of this type.

  type: java.lang.String"
  StreamResult/FEATURE)

(defn set-output-stream
  "Set the ByteStream that is to be written to.  Normally,
   a stream should be used rather than a reader, so that
   the transformer may use instructions contained in the
   transformation instructions to control the encoding.

  output-stream - A valid OutputStream reference. - `java.io.OutputStream`"
  ([^javax.xml.transform.stream.StreamResult this ^java.io.OutputStream output-stream]
    (-> this (.setOutputStream output-stream))))

(defn get-output-stream
  "Get the byte stream that was set with setOutputStream.

  returns: The byte stream that was set with setOutputStream, or null
   if setOutputStream or the ByteStream constructor was not called. - `java.io.OutputStream`"
  ([^javax.xml.transform.stream.StreamResult this]
    (-> this (.getOutputStream))))

(defn set-writer
  "Set the writer that is to receive the result.  Normally,
   a stream should be used rather than a writer, so that
   the transformer may use instructions contained in the
   transformation instructions to control the encoding.  However,
   there are times when it is useful to write to a writer,
   such as when using a StringWriter.

  writer - A valid Writer reference. - `java.io.Writer`"
  ([^javax.xml.transform.stream.StreamResult this ^java.io.Writer writer]
    (-> this (.setWriter writer))))

(defn get-writer
  "Get the character stream that was set with setWriter.

  returns: The character stream that was set with setWriter, or null
   if setWriter or the Writer constructor was not called. - `java.io.Writer`"
  ([^javax.xml.transform.stream.StreamResult this]
    (-> this (.getWriter))))

(defn set-system-id
  "Set the systemID that may be used in association
   with the byte or character stream, or, if neither is set, use
   this value as a writeable URI (probably a file name).

  system-id - The system identifier as a URI string. - `java.lang.String`"
  ([^javax.xml.transform.stream.StreamResult this ^java.lang.String system-id]
    (-> this (.setSystemId system-id))))

(defn get-system-id
  "Get the system identifier that was set with setSystemId.

  returns: The system identifier that was set with setSystemId, or null
   if setSystemId was not called. - `java.lang.String`"
  ([^javax.xml.transform.stream.StreamResult this]
    (-> this (.getSystemId))))

