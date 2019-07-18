(ns javax.swing.JTextPane
  "A text component that can be marked up with attributes that are
  represented graphically.
  You can find how-to information and examples of using text panes in
  Using Text Components,
  a section in The Java Tutorial.


  This component models paragraphs
  that are composed of runs of character level attributes.  Each
  paragraph may have a logical style attached to it which contains
  the default attributes to use if not overridden by attributes set
  on the paragraph or character run.  Components and images may
  be embedded in the flow of text.


  Newlines

  For a discussion on how newlines are handled, see
  DefaultEditorKit.



  Warning: Swing is not thread safe. For more
  information see Swing's Threading
  Policy.

  Warning:
  Serialized objects of this class will not be compatible with
  future Swing releases. The current serialization support is
  appropriate for short term storage or RMI between applications running
  the same version of Swing.  As of 1.4, support for long term storage
  of all JavaBeans™
  has been added to the java.beans package.
  Please see XMLEncoder."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing JTextPane]))

(defn ->j-text-pane
  "Constructor.

  Creates a new JTextPane, with a specified document model.
   A new instance of javax.swing.text.StyledEditorKit
    is created and set.

  doc - the document model - `javax.swing.text.StyledDocument`"
  (^JTextPane [^javax.swing.text.StyledDocument doc]
    (new JTextPane doc))
  (^JTextPane []
    (new JTextPane )))

(defn set-editor-kit
  "Sets the currently installed kit for handling
   content.  This is the bound property that
   establishes the content type of the editor.

  kit - the desired editor behavior - `javax.swing.text.EditorKit`

  throws: java.lang.IllegalArgumentException - if kit is not a StyledEditorKit"
  ([^JTextPane this ^javax.swing.text.EditorKit kit]
    (-> this (.setEditorKit kit))))

(defn set-document
  "Associates the editor with a text document.  This
   must be a StyledDocument.

  doc - the document to display/edit - `javax.swing.text.Document`

  throws: java.lang.IllegalArgumentException - if doc can't be narrowed to a StyledDocument which is the required type of model for this text component"
  ([^JTextPane this ^javax.swing.text.Document doc]
    (-> this (.setDocument doc))))

(defn get-character-attributes
  "Fetches the character attributes in effect at the
   current location of the caret, or null.

  returns: the attributes, or null - `javax.swing.text.AttributeSet`"
  (^javax.swing.text.AttributeSet [^JTextPane this]
    (-> this (.getCharacterAttributes))))

(defn insert-component
  "Inserts a component into the document as a replacement
   for the currently selected content.  If there is no
   selection the component is effectively inserted at the
   current position of the caret.  This is represented in
   the associated document as an attribute of one character
   of content.

   The component given is the actual component used by the
   JTextPane.  Since components cannot be a child of more than
   one container, this method should not be used in situations
   where the model is shared by text components.

   The component is placed relative to the text baseline
   according to the value returned by
   Component.getAlignmentY.  For Swing components
   this value can be conveniently set using the method
   JComponent.setAlignmentY.  For example, setting
   a value of 0.75 will cause 75 percent of the
   component to be above the baseline, and 25 percent of the
   component to be below the baseline.

  c - the component to insert - `java.awt.Component`"
  ([^JTextPane this ^java.awt.Component c]
    (-> this (.insertComponent c))))

(defn set-paragraph-attributes
  "Applies the given attributes to paragraphs.  If
   there is a selection, the attributes are applied
   to the paragraphs that intersect the selection.
   If there is no selection, the attributes are applied
   to the paragraph at the current caret position.

  attr - the non-null attributes - `javax.swing.text.AttributeSet`
  replace - if true, replace the existing attributes first - `boolean`"
  ([^JTextPane this ^javax.swing.text.AttributeSet attr ^Boolean replace]
    (-> this (.setParagraphAttributes attr replace))))

(defn get-ui-class-id
  "Returns the class ID for the UI.

  returns: the string `TextPaneUI` - `java.lang.String`"
  (^java.lang.String [^JTextPane this]
    (-> this (.getUIClassID))))

(defn get-logical-style
  "Fetches the logical style assigned to the paragraph represented
   by the current position of the caret, or null.

  returns: the Style - `javax.swing.text.Style`"
  (^javax.swing.text.Style [^JTextPane this]
    (-> this (.getLogicalStyle))))

(defn get-paragraph-attributes
  "Fetches the current paragraph attributes in effect
   at the location of the caret, or null if none.

  returns: the attributes - `javax.swing.text.AttributeSet`"
  (^javax.swing.text.AttributeSet [^JTextPane this]
    (-> this (.getParagraphAttributes))))

(defn set-styled-document
  "Associates the editor with a text document.
   The currently registered factory is used to build a view for
   the document, which gets displayed by the editor.

  doc - the document to display/edit - `javax.swing.text.StyledDocument`"
  ([^JTextPane this ^javax.swing.text.StyledDocument doc]
    (-> this (.setStyledDocument doc))))

(defn set-character-attributes
  "Applies the given attributes to character
   content.  If there is a selection, the attributes
   are applied to the selection range.  If there
   is no selection, the attributes are applied to
   the input attribute set which defines the attributes
   for any new text that gets inserted.

  attr - the attributes - `javax.swing.text.AttributeSet`
  replace - if true, then replace the existing attributes first - `boolean`"
  ([^JTextPane this ^javax.swing.text.AttributeSet attr ^Boolean replace]
    (-> this (.setCharacterAttributes attr replace))))

(defn set-logical-style
  "Sets the logical style to use for the paragraph at the
   current caret position.  If attributes aren't explicitly set
   for character and paragraph attributes they will resolve
   through the logical style assigned to the paragraph, which
   in term may resolve through some hierarchy completely
   independent of the element hierarchy in the document.

  s - the logical style to assign to the paragraph, or null for no style - `javax.swing.text.Style`"
  ([^JTextPane this ^javax.swing.text.Style s]
    (-> this (.setLogicalStyle s))))

(defn add-style
  "Adds a new style into the logical style hierarchy.  Style attributes
   resolve from bottom up so an attribute specified in a child
   will override an attribute specified in the parent.

  nm - the name of the style (must be unique within the collection of named styles). The name may be null if the style is unnamed, but the caller is responsible for managing the reference returned as an unnamed style can't be fetched by name. An unnamed style may be useful for things like character attribute overrides such as found in a style run. - `java.lang.String`
  parent - the parent style. This may be null if unspecified attributes need not be resolved in some other style. - `javax.swing.text.Style`

  returns: the new Style - `javax.swing.text.Style`"
  (^javax.swing.text.Style [^JTextPane this ^java.lang.String nm ^javax.swing.text.Style parent]
    (-> this (.addStyle nm parent))))

(defn get-input-attributes
  "Gets the input attributes for the pane.

  returns: the attributes - `javax.swing.text.MutableAttributeSet`"
  (^javax.swing.text.MutableAttributeSet [^JTextPane this]
    (-> this (.getInputAttributes))))

(defn insert-icon
  "Inserts an icon into the document as a replacement
   for the currently selected content.  If there is no
   selection the icon is effectively inserted at the
   current position of the caret.  This is represented in
   the associated document as an attribute of one character
   of content.

  g - the icon to insert - `javax.swing.Icon`"
  ([^JTextPane this ^javax.swing.Icon g]
    (-> this (.insertIcon g))))

(defn get-styled-document
  "Fetches the model associated with the editor.

  returns: the model - `javax.swing.text.StyledDocument`"
  (^javax.swing.text.StyledDocument [^JTextPane this]
    (-> this (.getStyledDocument))))

(defn replace-selection
  "Replaces the currently selected content with new content
   represented by the given string.  If there is no selection
   this amounts to an insert of the given text.  If there
   is no replacement text this amounts to a removal of the
   current selection.  The replacement text will have the
   attributes currently defined for input at the point of
   insertion.  If the document is not editable, beep and return.

  content - the content to replace the selection with - `java.lang.String`"
  ([^JTextPane this ^java.lang.String content]
    (-> this (.replaceSelection content))))

(defn remove-style
  "Removes a named non-null style previously added to
   the document.

  nm - the name of the style to remove - `java.lang.String`"
  ([^JTextPane this ^java.lang.String nm]
    (-> this (.removeStyle nm))))

(defn get-style
  "Fetches a named non-null style previously added.

  nm - the name of the style - `java.lang.String`

  returns: the Style - `javax.swing.text.Style`"
  (^javax.swing.text.Style [^JTextPane this ^java.lang.String nm]
    (-> this (.getStyle nm))))

