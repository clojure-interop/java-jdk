(ns javax.swing.text.html.HTMLEditorKit
  "The Swing JEditorPane text component supports different kinds
  of content via a plug-in mechanism called an EditorKit.  Because
  HTML is a very popular format of content, some support is provided
  by default.  The default support is provided by this class, which
  supports HTML version 3.2 (with some extensions), and is migrating
  toward version 4.0.
  The <applet> tag is not supported, but some support is provided
  for the <object> tag.

  There are several goals of the HTML EditorKit provided, that have
  an effect upon the way that HTML is modeled.  These
  have influenced its design in a substantial way.


  Support editing

  It might seem fairly obvious that a plug-in for JEditorPane
  should provide editing support, but that fact has several
  design considerations.  There are a substantial number of HTML
  documents that don't properly conform to an HTML specification.
  These must be normalized somewhat into a correct form if one
  is to edit them.  Additionally, users don't like to be presented
  with an excessive amount of structure editing, so using traditional
  text editing gestures is preferred over using the HTML structure
  exactly as defined in the HTML document.

  The modeling of HTML is provided by the class HTMLDocument.
  Its documentation describes the details of how the HTML is modeled.
  The editing support leverages heavily off of the text package.


  Extendable/Scalable

  To maximize the usefulness of this kit, a great deal of effort
  has gone into making it extendable.  These are some of the
  features.


    The parser is replaceable.  The default parser is the Hot Java
    parser which is DTD based.  A different DTD can be used, or an
    entirely different parser can be used.  To change the parser,
    reimplement the getParser method.  The default parser is
    dynamically loaded when first asked for, so the class files
    will never be loaded if an alternative parser is used.  The
    default parser is in a separate package called parser below
    this package.

    The parser drives the ParserCallback, which is provided by
    HTMLDocument.  To change the callback, subclass HTMLDocument
    and reimplement the createDefaultDocument method to return
    document that produces a different reader.  The reader controls
    how the document is structured.  Although the Document provides
    HTML support by default, there is nothing preventing support of
    non-HTML tags that result in alternative element structures.

    The default view of the models are provided as a hierarchy of
    View implementations, so one can easily customize how a particular
    element is displayed or add capabilities for new kinds of elements
    by providing new View implementations.  The default set of views
    are provided by the HTMLFactory class.  This can
    be easily changed by subclassing or replacing the HTMLFactory
    and reimplementing the getViewFactory method to return the alternative
    factory.

    The View implementations work primarily off of CSS attributes,
    which are kept in the views.  This makes it possible to have
    multiple views mapped over the same model that appear substantially
    different.  This can be especially useful for printing.  For
    most HTML attributes, the HTML attributes are converted to CSS
    attributes for display.  This helps make the View implementations
    more general purpose



  Asynchronous Loading

  Larger documents involve a lot of parsing and take some time
  to load.  By default, this kit produces documents that will be
  loaded asynchronously if loaded using JEditorPane.setPage.
  This is controlled by a property on the document.  The method
  createDefaultDocument can
  be overriden to change this.  The batching of work is done
  by the HTMLDocument.HTMLReader class.  The actual
  work is done by the DefaultStyledDocument and
  AbstractDocument classes in the text package.


  Customization from current LAF

  HTML provides a well known set of features without exactly
  specifying the display characteristics.  Swing has a theme
  mechanism for its look-and-feel implementations.  It is desirable
  for the look-and-feel to feed display characteristics into the
  HTML views.  An user with poor vision for example would want
  high contrast and larger than typical fonts.

  The support for this is provided by the StyleSheet
  class.  The presentation of the HTML can be heavily influenced
  by the setting of the StyleSheet property on the EditorKit.


  Not lossy

  An EditorKit has the ability to be read and save documents.
  It is generally the most pleasing to users if there is no loss
  of data between the two operation.  The policy of the HTMLEditorKit
  will be to store things not recognized or not necessarily visible
  so they can be subsequently written out.  The model of the HTML document
  should therefore contain all information discovered while reading the
  document.  This is constrained in some ways by the need to support
  editing (i.e. incorrect documents sometimes must be normalized).
  The guiding principle is that information shouldn't be lost, but
  some might be synthesized to produce a more correct model or it might
  be rearranged."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing.text.html HTMLEditorKit]))

(defn ->html-editor-kit
  "Constructor.

  Constructs an HTMLEditorKit, creates a StyleContext,
   and loads the style sheet."
  (^HTMLEditorKit []
    (new HTMLEditorKit )))

(def *-default-css
  "Static Constant.

  Default Cascading Style Sheet file that sets
   up the tag views.

  type: java.lang.String"
  HTMLEditorKit/DEFAULT_CSS)

(def *-bold-action
  "Static Constant.

  The bold action identifier

  type: java.lang.String"
  HTMLEditorKit/BOLD_ACTION)

(def *-italic-action
  "Static Constant.

  The italic action identifier

  type: java.lang.String"
  HTMLEditorKit/ITALIC_ACTION)

(def *-para-indent-left
  "Static Constant.

  The paragraph left indent action identifier

  type: java.lang.String"
  HTMLEditorKit/PARA_INDENT_LEFT)

(def *-para-indent-right
  "Static Constant.

  The paragraph right indent action identifier

  type: java.lang.String"
  HTMLEditorKit/PARA_INDENT_RIGHT)

(def *-font-change-bigger
  "Static Constant.

  The  font size increase to next value action identifier

  type: java.lang.String"
  HTMLEditorKit/FONT_CHANGE_BIGGER)

(def *-font-change-smaller
  "Static Constant.

  The font size decrease to next value action identifier

  type: java.lang.String"
  HTMLEditorKit/FONT_CHANGE_SMALLER)

(def *-color-action
  "Static Constant.

  The Color choice action identifier
       The color is passed as an argument

  type: java.lang.String"
  HTMLEditorKit/COLOR_ACTION)

(def *-logical-style-action
  "Static Constant.

  The logical style choice action identifier
       The logical style is passed in as an argument

  type: java.lang.String"
  HTMLEditorKit/LOGICAL_STYLE_ACTION)

(def *-img-align-top
  "Static Constant.

  Align images at the top.

  type: java.lang.String"
  HTMLEditorKit/IMG_ALIGN_TOP)

(def *-img-align-middle
  "Static Constant.

  Align images in the middle.

  type: java.lang.String"
  HTMLEditorKit/IMG_ALIGN_MIDDLE)

(def *-img-align-bottom
  "Static Constant.

  Align images at the bottom.

  type: java.lang.String"
  HTMLEditorKit/IMG_ALIGN_BOTTOM)

(def *-img-border
  "Static Constant.

  Align images at the border.

  type: java.lang.String"
  HTMLEditorKit/IMG_BORDER)

(defn get-link-cursor
  "Returns the cursor to use over hyper links.

  returns: `java.awt.Cursor`"
  (^java.awt.Cursor [^HTMLEditorKit this]
    (-> this (.getLinkCursor))))

(defn get-view-factory
  "Fetch a factory that is suitable for producing
   views of any models that are produced by this
   kit.

  returns: the factory - `javax.swing.text.ViewFactory`"
  (^javax.swing.text.ViewFactory [^HTMLEditorKit this]
    (-> this (.getViewFactory))))

(defn auto-form-submission?
  "Indicates whether an html form submission is processed automatically
   or only FormSubmitEvent is fired.

  returns: true  if html form submission is processed automatically,
           false otherwise. - `boolean`"
  (^Boolean [^HTMLEditorKit this]
    (-> this (.isAutoFormSubmission))))

(defn create-default-document
  "Create an uninitialized text storage model
   that is appropriate for this type of editor.

  returns: the model - `javax.swing.text.Document`"
  (^javax.swing.text.Document [^HTMLEditorKit this]
    (-> this (.createDefaultDocument))))

(defn set-link-cursor
  "Sets the cursor to use over links.

  cursor - `java.awt.Cursor`"
  ([^HTMLEditorKit this ^java.awt.Cursor cursor]
    (-> this (.setLinkCursor cursor))))

(defn get-style-sheet
  "Get the set of styles currently being used to render the
   HTML elements.  By default the resource specified by
   DEFAULT_CSS gets loaded, and is shared by all HTMLEditorKit
   instances.

  returns: `javax.swing.text.html.StyleSheet`"
  (^javax.swing.text.html.StyleSheet [^HTMLEditorKit this]
    (-> this (.getStyleSheet))))

(defn set-default-cursor
  "Sets the default cursor.

  cursor - `java.awt.Cursor`"
  ([^HTMLEditorKit this ^java.awt.Cursor cursor]
    (-> this (.setDefaultCursor cursor))))

(defn read
  "Inserts content from the given stream. If doc is
   an instance of HTMLDocument, this will read
   HTML 3.2 text. Inserting HTML into a non-empty document must be inside
   the body Element, if you do not insert into the body an exception will
   be thrown. When inserting into a non-empty document all tags outside
   of the body (head, title) will be dropped.

  in - the stream to read from - `java.io.Reader`
  doc - the destination for the insertion - `javax.swing.text.Document`
  pos - the location in the document to place the content - `int`

  throws: java.io.IOException - on any I/O error"
  ([^HTMLEditorKit this ^java.io.Reader in ^javax.swing.text.Document doc ^Integer pos]
    (-> this (.read in doc pos))))

(defn get-actions
  "Fetches the command list for the editor.  This is
   the list of commands supported by the superclass
   augmented by the collection of commands defined
   locally for style operations.

  returns: the command list - `javax.swing.Action[]`"
  ([^HTMLEditorKit this]
    (-> this (.getActions))))

(defn get-content-type
  "Get the MIME type of the data that this
   kit represents support for.  This kit supports
   the type text/html.

  returns: the type - `java.lang.String`"
  (^java.lang.String [^HTMLEditorKit this]
    (-> this (.getContentType))))

(defn get-default-cursor
  "Returns the default cursor.

  returns: `java.awt.Cursor`"
  (^java.awt.Cursor [^HTMLEditorKit this]
    (-> this (.getDefaultCursor))))

(defn install
  "Called when the kit is being installed into the
   a JEditorPane.

  c - the JEditorPane - `javax.swing.JEditorPane`"
  ([^HTMLEditorKit this ^javax.swing.JEditorPane c]
    (-> this (.install c))))

(defn get-input-attributes
  "Gets the input attributes used for the styled
   editing actions.

  returns: the attribute set - `javax.swing.text.MutableAttributeSet`"
  (^javax.swing.text.MutableAttributeSet [^HTMLEditorKit this]
    (-> this (.getInputAttributes))))

(defn insert-html
  "Inserts HTML into an existing document.

  doc - the document to insert into - `javax.swing.text.html.HTMLDocument`
  offset - the offset to insert HTML at - `int`
  html - `java.lang.String`
  pop-depth - the number of ElementSpec.EndTagTypes to generate before inserting - `int`
  push-depth - the number of ElementSpec.StartTagTypes with a direction of ElementSpec.JoinNextDirection that should be generated before inserting, but after the end tags have been generated - `int`
  insert-tag - the first tag to start inserting into document - `javax.swing.text.html.HTML$Tag`

  throws: java.lang.RuntimeException - (will eventually be a BadLocationException) if pos is invalid"
  ([^HTMLEditorKit this ^javax.swing.text.html.HTMLDocument doc ^Integer offset ^java.lang.String html ^Integer pop-depth ^Integer push-depth ^javax.swing.text.html.HTML$Tag insert-tag]
    (-> this (.insertHTML doc offset html pop-depth push-depth insert-tag))))

(defn get-accessible-context
  "returns the AccessibleContext associated with this editor kit

  returns: the AccessibleContext associated with this editor kit - `javax.accessibility.AccessibleContext`"
  (^javax.accessibility.AccessibleContext [^HTMLEditorKit this]
    (-> this (.getAccessibleContext))))

(defn deinstall
  "Called when the kit is being removed from the
   JEditorPane.  This is used to unregister any
   listeners that were attached.

  c - the JEditorPane - `javax.swing.JEditorPane`"
  ([^HTMLEditorKit this ^javax.swing.JEditorPane c]
    (-> this (.deinstall c))))

(defn clone
  "Creates a copy of the editor kit.

  returns: the copy - `java.lang.Object`"
  (^java.lang.Object [^HTMLEditorKit this]
    (-> this (.clone))))

(defn write
  "Write content from a document to the given stream
   in a format appropriate for this kind of content handler.

  out - the stream to write to - `java.io.Writer`
  doc - the source for the write - `javax.swing.text.Document`
  pos - the location in the document to fetch the content - `int`
  len - the amount to write out - `int`

  throws: java.io.IOException - on any I/O error"
  ([^HTMLEditorKit this ^java.io.Writer out ^javax.swing.text.Document doc ^Integer pos ^Integer len]
    (-> this (.write out doc pos len))))

(defn set-style-sheet
  "Set the set of styles to be used to render the various
   HTML elements.  These styles are specified in terms of
   CSS specifications.  Each document produced by the kit
   will have a copy of the sheet which it can add the
   document specific styles to.  By default, the StyleSheet
   specified is shared by all HTMLEditorKit instances.
   This should be reimplemented to provide a finer granularity
   if desired.

  s - `javax.swing.text.html.StyleSheet`"
  ([^HTMLEditorKit this ^javax.swing.text.html.StyleSheet s]
    (-> this (.setStyleSheet s))))

(defn set-auto-form-submission
  "Specifies if an html form submission is processed
   automatically or only FormSubmitEvent is fired.
   By default it is set to true.

  is-auto - `boolean`"
  ([^HTMLEditorKit this ^Boolean is-auto]
    (-> this (.setAutoFormSubmission is-auto))))

