(ns javax.swing.text.EditorKit
  "Establishes the set of things needed by a text component
  to be a reasonably functioning editor for some type
  of text content.  The EditorKit acts as a factory for some
  kind of policy.  For example, an implementation
  of html and rtf can be provided that is replaceable
  with other implementations.

  A kit can safely store editing state as an instance
  of the kit will be dedicated to a text component.
  New kits will normally be created by cloning a
  prototype kit.  The kit will have it's
  setComponent method called to establish
  it's relationship with a JTextComponent."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing.text EditorKit]))

(defn ->editor-kit
  "Constructor.

  Construct an EditorKit."
  ([]
    (new EditorKit )))

(defn get-view-factory
  "Fetches a factory that is suitable for producing
   views of any models that are produced by this
   kit.

  returns: the factory - `javax.swing.text.ViewFactory`"
  (^javax.swing.text.ViewFactory [^javax.swing.text.EditorKit this]
    (-> this (.getViewFactory))))

(defn create-default-document
  "Creates an uninitialized text storage model
   that is appropriate for this type of editor.

  returns: the model - `javax.swing.text.Document`"
  (^javax.swing.text.Document [^javax.swing.text.EditorKit this]
    (-> this (.createDefaultDocument))))

(defn read
  "Inserts content from the given stream which is expected
   to be in a format appropriate for this kind of content
   handler.

  in - The stream to read from - `java.io.InputStream`
  doc - The destination for the insertion. - `javax.swing.text.Document`
  pos - The location in the document to place the content >= 0. - `int`

  throws: java.io.IOException - on any I/O error"
  ([^javax.swing.text.EditorKit this ^java.io.InputStream in ^javax.swing.text.Document doc ^Integer pos]
    (-> this (.read in doc pos))))

(defn get-actions
  "Fetches the set of commands that can be used
   on a text component that is using a model and
   view produced by this kit.

  returns: the set of actions - `javax.swing.Action[]`"
  ([^javax.swing.text.EditorKit this]
    (-> this (.getActions))))

(defn get-content-type
  "Gets the MIME type of the data that this
   kit represents support for.

  returns: the type - `java.lang.String`"
  (^java.lang.String [^javax.swing.text.EditorKit this]
    (-> this (.getContentType))))

(defn install
  "Called when the kit is being installed into the
   a JEditorPane.

  c - the JEditorPane - `javax.swing.JEditorPane`"
  ([^javax.swing.text.EditorKit this ^javax.swing.JEditorPane c]
    (-> this (.install c))))

(defn deinstall
  "Called when the kit is being removed from the
   JEditorPane.  This is used to unregister any
   listeners that were attached.

  c - the JEditorPane - `javax.swing.JEditorPane`"
  ([^javax.swing.text.EditorKit this ^javax.swing.JEditorPane c]
    (-> this (.deinstall c))))

(defn clone
  "Creates a copy of the editor kit.  This is implemented
   to use Object.clone().  If the kit cannot be cloned,
   null is returned.

  returns: the copy - `java.lang.Object`"
  (^java.lang.Object [^javax.swing.text.EditorKit this]
    (-> this (.clone))))

(defn write
  "Writes content from a document to the given stream
   in a format appropriate for this kind of content handler.

  out - The stream to write to - `java.io.OutputStream`
  doc - The source for the write. - `javax.swing.text.Document`
  pos - The location in the document to fetch the content from >= 0. - `int`
  len - The amount to write out >= 0. - `int`

  throws: java.io.IOException - on any I/O error"
  ([^javax.swing.text.EditorKit this ^java.io.OutputStream out ^javax.swing.text.Document doc ^Integer pos ^Integer len]
    (-> this (.write out doc pos len))))

(defn create-caret
  "Fetches a caret that can navigate through views
   produced by the associated ViewFactory.

  returns: the caret - `javax.swing.text.Caret`"
  (^javax.swing.text.Caret [^javax.swing.text.EditorKit this]
    (-> this (.createCaret))))

