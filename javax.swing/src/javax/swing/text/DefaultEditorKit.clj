(ns javax.swing.text.DefaultEditorKit
  "This is the set of things needed by a text component
  to be a reasonably functioning editor for some type
  of text document.  This implementation provides a default
  implementation which treats text as plain text and
  provides a minimal set of actions for a simple editor.


  Newlines

  There are two properties which deal with newlines.  The
  system property, line.separator, is defined to be
  platform-dependent, either `\n`, `\r`, or `\r\n`.  There is also
  a property defined in DefaultEditorKit, called
  EndOfLineStringProperty,
  which is defined automatically when a document is loaded, to be
  the first occurrence of any of the newline characters.
  When a document is loaded, EndOfLineStringProperty
  is set appropriately, and when the document is written back out, the
  EndOfLineStringProperty is used.  But while the document
  is in memory, the `\n` character is used to define a
  newline, regardless of how the newline is defined when
  the document is on disk.  Therefore, for searching purposes,
  `\n` should always be used.  When a new document is created,
  and the EndOfLineStringProperty has not been defined,
  it will use the System property when writing out the
  document.
  Note that EndOfLineStringProperty is set
  on the Document using the get/putProperty
  methods.  Subclasses may override this behavior."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing.text DefaultEditorKit]))

(defn ->default-editor-kit
  "Constructor.

  default constructor for DefaultEditorKit"
  ([]
    (new DefaultEditorKit )))

(def *-end-of-line-string-property
  "Static Constant.

  When reading a document if a CRLF is encountered a property
   with this name is added and the value will be `\r\n`.

  type: java.lang.String"
  DefaultEditorKit/EndOfLineStringProperty)

(def *-insert-content-action
  "Static Constant.

  Name of the action to place content into the associated
   document.  If there is a selection, it is removed before
   the new content is added.

  type: java.lang.String"
  DefaultEditorKit/insertContentAction)

(def *-insert-break-action
  "Static Constant.

  Name of the action to place a line/paragraph break into
   the document.  If there is a selection, it is removed before
   the break is added.

  type: java.lang.String"
  DefaultEditorKit/insertBreakAction)

(def *-insert-tab-action
  "Static Constant.

  Name of the action to place a tab character into
   the document.  If there is a selection, it is removed before
   the tab is added.

  type: java.lang.String"
  DefaultEditorKit/insertTabAction)

(def *-delete-prev-char-action
  "Static Constant.

  Name of the action to delete the character of content that
   precedes the current caret position.

  type: java.lang.String"
  DefaultEditorKit/deletePrevCharAction)

(def *-delete-next-char-action
  "Static Constant.

  Name of the action to delete the character of content that
   follows the current caret position.

  type: java.lang.String"
  DefaultEditorKit/deleteNextCharAction)

(def *-delete-next-word-action
  "Static Constant.

  Name of the action to delete the word that
   follows the beginning of the selection.

  type: java.lang.String"
  DefaultEditorKit/deleteNextWordAction)

(def *-delete-prev-word-action
  "Static Constant.

  Name of the action to delete the word that
   precedes the beginning of the selection.

  type: java.lang.String"
  DefaultEditorKit/deletePrevWordAction)

(def *-read-only-action
  "Static Constant.

  Name of the action to set the editor into read-only
   mode.

  type: java.lang.String"
  DefaultEditorKit/readOnlyAction)

(def *-writable-action
  "Static Constant.

  Name of the action to set the editor into writeable
   mode.

  type: java.lang.String"
  DefaultEditorKit/writableAction)

(def *-cut-action
  "Static Constant.

  Name of the action to cut the selected region
   and place the contents into the system clipboard.

  type: java.lang.String"
  DefaultEditorKit/cutAction)

(def *-copy-action
  "Static Constant.

  Name of the action to copy the selected region
   and place the contents into the system clipboard.

  type: java.lang.String"
  DefaultEditorKit/copyAction)

(def *-paste-action
  "Static Constant.

  Name of the action to paste the contents of the
   system clipboard into the selected region, or before the
   caret if nothing is selected.

  type: java.lang.String"
  DefaultEditorKit/pasteAction)

(def *-beep-action
  "Static Constant.

  Name of the action to create a beep.

  type: java.lang.String"
  DefaultEditorKit/beepAction)

(def *-page-up-action
  "Static Constant.

  Name of the action to page up vertically.

  type: java.lang.String"
  DefaultEditorKit/pageUpAction)

(def *-page-down-action
  "Static Constant.

  Name of the action to page down vertically.

  type: java.lang.String"
  DefaultEditorKit/pageDownAction)

(def *-forward-action
  "Static Constant.

  Name of the Action for moving the caret
   logically forward one position.

  type: java.lang.String"
  DefaultEditorKit/forwardAction)

(def *-backward-action
  "Static Constant.

  Name of the Action for moving the caret
   logically backward one position.

  type: java.lang.String"
  DefaultEditorKit/backwardAction)

(def *-selection-forward-action
  "Static Constant.

  Name of the Action for extending the selection
   by moving the caret logically forward one position.

  type: java.lang.String"
  DefaultEditorKit/selectionForwardAction)

(def *-selection-backward-action
  "Static Constant.

  Name of the Action for extending the selection
   by moving the caret logically backward one position.

  type: java.lang.String"
  DefaultEditorKit/selectionBackwardAction)

(def *-up-action
  "Static Constant.

  Name of the Action for moving the caret
   logically upward one position.

  type: java.lang.String"
  DefaultEditorKit/upAction)

(def *-down-action
  "Static Constant.

  Name of the Action for moving the caret
   logically downward one position.

  type: java.lang.String"
  DefaultEditorKit/downAction)

(def *-selection-up-action
  "Static Constant.

  Name of the Action for moving the caret
   logically upward one position, extending the selection.

  type: java.lang.String"
  DefaultEditorKit/selectionUpAction)

(def *-selection-down-action
  "Static Constant.

  Name of the Action for moving the caret
   logically downward one position, extending the selection.

  type: java.lang.String"
  DefaultEditorKit/selectionDownAction)

(def *-begin-word-action
  "Static Constant.

  Name of the Action for moving the caret
   to the beginning of a word.

  type: java.lang.String"
  DefaultEditorKit/beginWordAction)

(def *-end-word-action
  "Static Constant.

  Name of the Action for moving the caret
   to the end of a word.

  type: java.lang.String"
  DefaultEditorKit/endWordAction)

(def *-selection-begin-word-action
  "Static Constant.

  Name of the Action for moving the caret
   to the beginning of a word, extending the selection.

  type: java.lang.String"
  DefaultEditorKit/selectionBeginWordAction)

(def *-selection-end-word-action
  "Static Constant.

  Name of the Action for moving the caret
   to the end of a word, extending the selection.

  type: java.lang.String"
  DefaultEditorKit/selectionEndWordAction)

(def *-previous-word-action
  "Static Constant.

  Name of the Action for moving the caret to the
   beginning of the previous word.

  type: java.lang.String"
  DefaultEditorKit/previousWordAction)

(def *-next-word-action
  "Static Constant.

  Name of the Action for moving the caret to the
   beginning of the next word.

  type: java.lang.String"
  DefaultEditorKit/nextWordAction)

(def *-selection-previous-word-action
  "Static Constant.

  Name of the Action for moving the selection to the
   beginning of the previous word, extending the selection.

  type: java.lang.String"
  DefaultEditorKit/selectionPreviousWordAction)

(def *-selection-next-word-action
  "Static Constant.

  Name of the Action for moving the selection to the
   beginning of the next word, extending the selection.

  type: java.lang.String"
  DefaultEditorKit/selectionNextWordAction)

(def *-begin-line-action
  "Static Constant.

  Name of the Action for moving the caret
   to the beginning of a line.

  type: java.lang.String"
  DefaultEditorKit/beginLineAction)

(def *-end-line-action
  "Static Constant.

  Name of the Action for moving the caret
   to the end of a line.

  type: java.lang.String"
  DefaultEditorKit/endLineAction)

(def *-selection-begin-line-action
  "Static Constant.

  Name of the Action for moving the caret
   to the beginning of a line, extending the selection.

  type: java.lang.String"
  DefaultEditorKit/selectionBeginLineAction)

(def *-selection-end-line-action
  "Static Constant.

  Name of the Action for moving the caret
   to the end of a line, extending the selection.

  type: java.lang.String"
  DefaultEditorKit/selectionEndLineAction)

(def *-begin-paragraph-action
  "Static Constant.

  Name of the Action for moving the caret
   to the beginning of a paragraph.

  type: java.lang.String"
  DefaultEditorKit/beginParagraphAction)

(def *-end-paragraph-action
  "Static Constant.

  Name of the Action for moving the caret
   to the end of a paragraph.

  type: java.lang.String"
  DefaultEditorKit/endParagraphAction)

(def *-selection-begin-paragraph-action
  "Static Constant.

  Name of the Action for moving the caret
   to the beginning of a paragraph, extending the selection.

  type: java.lang.String"
  DefaultEditorKit/selectionBeginParagraphAction)

(def *-selection-end-paragraph-action
  "Static Constant.

  Name of the Action for moving the caret
   to the end of a paragraph, extending the selection.

  type: java.lang.String"
  DefaultEditorKit/selectionEndParagraphAction)

(def *-begin-action
  "Static Constant.

  Name of the Action for moving the caret
   to the beginning of the document.

  type: java.lang.String"
  DefaultEditorKit/beginAction)

(def *-end-action
  "Static Constant.

  Name of the Action for moving the caret
   to the end of the document.

  type: java.lang.String"
  DefaultEditorKit/endAction)

(def *-selection-begin-action
  "Static Constant.

  Name of the Action for moving the caret
   to the beginning of the document.

  type: java.lang.String"
  DefaultEditorKit/selectionBeginAction)

(def *-selection-end-action
  "Static Constant.

  Name of the Action for moving the caret
   to the end of the document.

  type: java.lang.String"
  DefaultEditorKit/selectionEndAction)

(def *-select-word-action
  "Static Constant.

  Name of the Action for selecting a word around the caret.

  type: java.lang.String"
  DefaultEditorKit/selectWordAction)

(def *-select-line-action
  "Static Constant.

  Name of the Action for selecting a line around the caret.

  type: java.lang.String"
  DefaultEditorKit/selectLineAction)

(def *-select-paragraph-action
  "Static Constant.

  Name of the Action for selecting a paragraph around the caret.

  type: java.lang.String"
  DefaultEditorKit/selectParagraphAction)

(def *-select-all-action
  "Static Constant.

  Name of the Action for selecting the entire document

  type: java.lang.String"
  DefaultEditorKit/selectAllAction)

(def *-default-key-typed-action
  "Static Constant.

  Name of the action that is executed by default if
   a key typed event is received and there
   is no keymap entry.

  type: java.lang.String"
  DefaultEditorKit/defaultKeyTypedAction)

(defn get-content-type
  "Gets the MIME type of the data that this
   kit represents support for.  The default
   is text/plain.

  returns: the type - `java.lang.String`"
  ([this]
    (-> this (.getContentType))))

(defn get-view-factory
  "Fetches a factory that is suitable for producing
   views of any models that are produced by this
   kit.  The default is to have the UI produce the
   factory, so this method has no implementation.

  returns: the view factory - `javax.swing.text.ViewFactory`"
  ([this]
    (-> this (.getViewFactory))))

(defn get-actions
  "Fetches the set of commands that can be used
   on a text component that is using a model and
   view produced by this kit.

  returns: the command list - `javax.swing.Action[]`"
  ([this]
    (-> this (.getActions))))

(defn create-caret
  "Fetches a caret that can navigate through views
   produced by the associated ViewFactory.

  returns: the caret - `javax.swing.text.Caret`"
  ([this]
    (-> this (.createCaret))))

(defn create-default-document
  "Creates an uninitialized text storage model (PlainDocument)
   that is appropriate for this type of editor.

  returns: the model - `javax.swing.text.Document`"
  ([this]
    (-> this (.createDefaultDocument))))

(defn read
  "Inserts content from the given stream which is expected
   to be in a format appropriate for this kind of content
   handler.

  in - The stream to read from - `java.io.InputStream`
  doc - The destination for the insertion. - `javax.swing.text.Document`
  pos - The location in the document to place the content >=0. - `int`

  throws: java.io.IOException - on any I/O error"
  ([this in doc pos]
    (-> this (.read in doc pos))))

(defn write
  "Writes content from a document to the given stream
   in a format appropriate for this kind of content handler.

  out - The stream to write to - `java.io.OutputStream`
  doc - The source for the write. - `javax.swing.text.Document`
  pos - The location in the document to fetch the content >=0. - `int`
  len - The amount to write out >=0. - `int`

  throws: java.io.IOException - on any I/O error"
  ([this out doc pos len]
    (-> this (.write out doc pos len))))

