(ns javax.swing.text.DefaultStyledDocument
  "A document that can be marked up with character and paragraph
  styles in a manner similar to the Rich Text Format.  The element
  structure for this document represents style crossings for
  style runs.  These style runs are mapped into a paragraph element
  structure (which may reside in some other structure).  The
  style runs break at paragraph boundaries since logical styles are
  assigned to paragraph boundaries.

  Warning:
  Serialized objects of this class will not be compatible with
  future Swing releases. The current serialization support is
  appropriate for short term storage or RMI between applications running
  the same version of Swing.  As of 1.4, support for long term storage
  of all JavaBeans™
  has been added to the java.beans package.
  Please see XMLEncoder."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing.text DefaultStyledDocument]))

(defn ->default-styled-document
  "Constructor.

  Constructs a styled document.

  c - the container for the content - `javax.swing.text.AbstractDocument.Content`
  styles - resources and style definitions which may be shared across documents - `javax.swing.text.StyleContext`"
  ([^javax.swing.text.AbstractDocument.Content c ^javax.swing.text.StyleContext styles]
    (new DefaultStyledDocument c styles))
  ([^javax.swing.text.StyleContext styles]
    (new DefaultStyledDocument styles))
  ([]
    (new DefaultStyledDocument )))

(def *-buffer-size-default
  "Static Constant.

  The default size of the initial content buffer.

  type: int"
  DefaultStyledDocument/BUFFER_SIZE_DEFAULT)

(defn get-foreground
  "Gets the foreground color from an attribute set.

  attr - the attribute set - `javax.swing.text.AttributeSet`

  returns: the color - `java.awt.Color`"
  (^java.awt.Color [^javax.swing.text.DefaultStyledDocument this ^javax.swing.text.AttributeSet attr]
    (-> this (.getForeground attr))))

(defn set-paragraph-attributes
  "Sets attributes for a paragraph.

   This method is thread safe, although most Swing methods
   are not. Please see
   Concurrency
   in Swing for more information.

  offset - the offset into the paragraph >= 0 - `int`
  length - the number of characters affected >= 0 - `int`
  s - the attributes - `javax.swing.text.AttributeSet`
  replace - whether to replace existing attributes, or merge them - `boolean`"
  ([^javax.swing.text.DefaultStyledDocument this ^Integer offset ^Integer length ^javax.swing.text.AttributeSet s ^Boolean replace]
    (-> this (.setParagraphAttributes offset length s replace))))

(defn remove-document-listener
  "Removes a document listener.

  listener - the listener - `javax.swing.event.DocumentListener`"
  ([^javax.swing.text.DefaultStyledDocument this ^javax.swing.event.DocumentListener listener]
    (-> this (.removeDocumentListener listener))))

(defn get-logical-style
  "Fetches the logical style assigned to the paragraph
   represented by the given position.

  p - the location to translate to a paragraph and determine the logical style assigned >= 0. This is an offset from the start of the document. - `int`

  returns: the style, null if none - `javax.swing.text.Style`"
  (^javax.swing.text.Style [^javax.swing.text.DefaultStyledDocument this ^Integer p]
    (-> this (.getLogicalStyle p))))

(defn set-character-attributes
  "Sets attributes for some part of the document.
   A write lock is held by this operation while changes
   are being made, and a DocumentEvent is sent to the listeners
   after the change has been successfully completed.

   This method is thread safe, although most Swing methods
   are not. Please see
   Concurrency
   in Swing for more information.

  offset - the offset in the document >= 0 - `int`
  length - the length >= 0 - `int`
  s - the attributes - `javax.swing.text.AttributeSet`
  replace - true if the previous attributes should be replaced before setting the new attributes - `boolean`"
  ([^javax.swing.text.DefaultStyledDocument this ^Integer offset ^Integer length ^javax.swing.text.AttributeSet s ^Boolean replace]
    (-> this (.setCharacterAttributes offset length s replace))))

(defn set-logical-style
  "Sets the logical style to use for the paragraph at the
   given position.  If attributes aren't explicitly set
   for character and paragraph attributes they will resolve
   through the logical style assigned to the paragraph, which
   in turn may resolve through some hierarchy completely
   independent of the element hierarchy in the document.

   This method is thread safe, although most Swing methods
   are not. Please see
   Concurrency
   in Swing for more information.

  pos - the offset from the start of the document >= 0 - `int`
  s - the logical style to assign to the paragraph, null if none - `javax.swing.text.Style`"
  ([^javax.swing.text.DefaultStyledDocument this ^Integer pos ^javax.swing.text.Style s]
    (-> this (.setLogicalStyle pos s))))

(defn add-style
  "Adds a new style into the logical style hierarchy.  Style attributes
   resolve from bottom up so an attribute specified in a child
   will override an attribute specified in the parent.

  nm - the name of the style (must be unique within the collection of named styles). The name may be null if the style is unnamed, but the caller is responsible for managing the reference returned as an unnamed style can't be fetched by name. An unnamed style may be useful for things like character attribute overrides such as found in a style run. - `java.lang.String`
  parent - the parent style. This may be null if unspecified attributes need not be resolved in some other style. - `javax.swing.text.Style`

  returns: the style - `javax.swing.text.Style`"
  (^javax.swing.text.Style [^javax.swing.text.DefaultStyledDocument this ^java.lang.String nm ^javax.swing.text.Style parent]
    (-> this (.addStyle nm parent))))

(defn remove-element
  "Removes an element from this document.

   The element is removed from its parent element, as well as
   the text in the range identified by the element.  If the
   element isn't associated with the document, IllegalArgumentException is thrown.

   As empty branch elements are not allowed in the document, if the
   element is the sole child, its parent element is removed as well,
   recursively.  This means that when replacing all the children of a
   particular element, new children should be added before
   removing old children.

   Element removal results in two events being fired, the
   DocumentEvent for changes in element structure and UndoableEditEvent for changes in document content.

   If the element contains end-of-content mark (the last `\n` character in document), this character is not removed;
   instead, preceding leaf element is extended to cover the
   character.  If the last leaf already ends with `\n`, it is
   included in content removal.

   If the element is null, NullPointerException is
   thrown.  If the element structure would become invalid after the removal,
   for example if the element is the document root element, IllegalArgumentException is thrown.  If the current element structure is
   invalid, IllegalStateException is thrown.

  elem - the element to remove - `javax.swing.text.Element`

  throws: java.lang.NullPointerException - if the element is null"
  ([^javax.swing.text.DefaultStyledDocument this ^javax.swing.text.Element elem]
    (-> this (.removeElement elem))))

(defn get-style-names
  "Fetches the list of of style names.

  returns: all the style names - `java.util.Enumeration<?>`"
  (^java.util.Enumeration [^javax.swing.text.DefaultStyledDocument this]
    (-> this (.getStyleNames))))

(defn get-character-element
  "Gets a character element based on a position.

  pos - the position in the document >= 0 - `int`

  returns: the element - `javax.swing.text.Element`"
  (^javax.swing.text.Element [^javax.swing.text.DefaultStyledDocument this ^Integer pos]
    (-> this (.getCharacterElement pos))))

(defn add-document-listener
  "Adds a document listener for notification of any changes.

  listener - the listener - `javax.swing.event.DocumentListener`"
  ([^javax.swing.text.DefaultStyledDocument this ^javax.swing.event.DocumentListener listener]
    (-> this (.addDocumentListener listener))))

(defn get-font
  "Gets the font from an attribute set.

  attr - the attribute set - `javax.swing.text.AttributeSet`

  returns: the font - `java.awt.Font`"
  (^java.awt.Font [^javax.swing.text.DefaultStyledDocument this ^javax.swing.text.AttributeSet attr]
    (-> this (.getFont attr))))

(defn get-background
  "Gets the background color from an attribute set.

  attr - the attribute set - `javax.swing.text.AttributeSet`

  returns: the color - `java.awt.Color`"
  (^java.awt.Color [^javax.swing.text.DefaultStyledDocument this ^javax.swing.text.AttributeSet attr]
    (-> this (.getBackground attr))))

(defn get-default-root-element
  "Gets the default root element.

  returns: the root - `javax.swing.text.Element`"
  (^javax.swing.text.Element [^javax.swing.text.DefaultStyledDocument this]
    (-> this (.getDefaultRootElement))))

(defn remove-style
  "Removes a named style previously added to the document.

  nm - the name of the style to remove - `java.lang.String`"
  ([^javax.swing.text.DefaultStyledDocument this ^java.lang.String nm]
    (-> this (.removeStyle nm))))

(defn get-paragraph-element
  "Gets the paragraph element at the offset pos.
   A paragraph consists of at least one child Element, which is usually
   a leaf.

  pos - the starting offset >= 0 - `int`

  returns: the element - `javax.swing.text.Element`"
  (^javax.swing.text.Element [^javax.swing.text.DefaultStyledDocument this ^Integer pos]
    (-> this (.getParagraphElement pos))))

(defn get-style
  "Fetches a named style previously added.

  nm - the name of the style - `java.lang.String`

  returns: the style - `javax.swing.text.Style`"
  (^javax.swing.text.Style [^javax.swing.text.DefaultStyledDocument this ^java.lang.String nm]
    (-> this (.getStyle nm))))

