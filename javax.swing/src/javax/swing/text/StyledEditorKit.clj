(ns javax.swing.text.StyledEditorKit
  "This is the set of things needed by a text component
  to be a reasonably functioning editor for some type
  of text document.  This implementation provides a default
  implementation which treats text as styled text and
  provides a minimal set of actions for editing styled text."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing.text StyledEditorKit]))

(defn ->styled-editor-kit
  "Constructor.

  Creates a new EditorKit used for styled documents."
  ([]
    (new StyledEditorKit )))

(defn get-input-attributes
  "Gets the input attributes for the pane.  When
   the caret moves and there is no selection, the
   input attributes are automatically mutated to
   reflect the character attributes of the current
   caret location.  The styled editing actions
   use the input attributes to carry out their
   actions.

  returns: the attribute set - `javax.swing.text.MutableAttributeSet`"
  ([^javax.swing.text.StyledEditorKit this]
    (-> this (.getInputAttributes))))

(defn get-character-attribute-run
  "Fetches the element representing the current
   run of character attributes for the caret.

  returns: the element - `javax.swing.text.Element`"
  ([^javax.swing.text.StyledEditorKit this]
    (-> this (.getCharacterAttributeRun))))

(defn get-actions
  "Fetches the command list for the editor.  This is
   the list of commands supported by the superclass
   augmented by the collection of commands defined
   locally for style operations.

  returns: the command list - `javax.swing.Action[]`"
  ([^javax.swing.text.StyledEditorKit this]
    (-> this (.getActions))))

(defn create-default-document
  "Creates an uninitialized text storage model
   that is appropriate for this type of editor.

  returns: the model - `javax.swing.text.Document`"
  ([^javax.swing.text.StyledEditorKit this]
    (-> this (.createDefaultDocument))))

(defn install
  "Called when the kit is being installed into
   a JEditorPane.

  c - the JEditorPane - `javax.swing.JEditorPane`"
  ([^javax.swing.text.StyledEditorKit this ^javax.swing.JEditorPane c]
    (-> this (.install c))))

(defn deinstall
  "Called when the kit is being removed from the
   JEditorPane.  This is used to unregister any
   listeners that were attached.

  c - the JEditorPane - `javax.swing.JEditorPane`"
  ([^javax.swing.text.StyledEditorKit this ^javax.swing.JEditorPane c]
    (-> this (.deinstall c))))

(defn get-view-factory
  "Fetches a factory that is suitable for producing
   views of any models that are produced by this
   kit.  This is implemented to return View implementations
   for the following kinds of elements:

   AbstractDocument.ContentElementName
   AbstractDocument.ParagraphElementName
   AbstractDocument.SectionElementName
   StyleConstants.ComponentElementName
   StyleConstants.IconElementName

  returns: the factory - `javax.swing.text.ViewFactory`"
  ([^javax.swing.text.StyledEditorKit this]
    (-> this (.getViewFactory))))

(defn clone
  "Creates a copy of the editor kit.

  returns: the copy - `java.lang.Object`"
  ([^javax.swing.text.StyledEditorKit this]
    (-> this (.clone))))

