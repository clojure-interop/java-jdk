(ns javax.swing.text.rtf.RTFEditorKit
  "This is the default implementation of RTF editing
  functionality.  The RTF support was not written by the
  Swing team.  In the future we hope to improve the support
  provided."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing.text.rtf RTFEditorKit]))

(defn ->rtf-editor-kit
  "Constructor.

  Constructs an RTFEditorKit."
  (^RTFEditorKit []
    (new RTFEditorKit )))

(defn get-content-type
  "Get the MIME type of the data that this
   kit represents support for.  This kit supports
   the type text/rtf.

  returns: the type - `java.lang.String`"
  (^java.lang.String [^RTFEditorKit this]
    (-> this (.getContentType))))

(defn read
  "Insert content from the given stream which is expected
   to be in a format appropriate for this kind of content
   handler.

  in - The stream to read from - `java.io.InputStream`
  doc - The destination for the insertion. - `javax.swing.text.Document`
  pos - The location in the document to place the content. - `int`

  throws: java.io.IOException - on any I/O error"
  ([^RTFEditorKit this ^java.io.InputStream in ^javax.swing.text.Document doc ^Integer pos]
    (-> this (.read in doc pos))))

(defn write
  "Write content from a document to the given stream
   in a format appropriate for this kind of content handler.

  out - The stream to write to - `java.io.OutputStream`
  doc - The source for the write. - `javax.swing.text.Document`
  pos - The location in the document to fetch the content. - `int`
  len - The amount to write out. - `int`

  throws: java.io.IOException - on any I/O error"
  ([^RTFEditorKit this ^java.io.OutputStream out ^javax.swing.text.Document doc ^Integer pos ^Integer len]
    (-> this (.write out doc pos len))))

