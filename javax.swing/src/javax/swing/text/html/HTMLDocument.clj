(ns javax.swing.text.html.HTMLDocument
  "A document that models HTML.  The purpose of this model is to
  support both browsing and editing.  As a result, the structure
  described by an HTML document is not exactly replicated by default.
  The element structure that is modeled by default, is built by the
  class HTMLDocument.HTMLReader, which implements the
  HTMLEditorKit.ParserCallback protocol that the parser
  expects.  To change the structure one can subclass
  HTMLReader, and reimplement the method getReader(int) to return the new reader implementation.  The
  documentation for HTMLReader should be consulted for
  the details of the default structure created.  The intent is that
  the document be non-lossy (although reproducing the HTML format may
  result in a different format).

  The document models only HTML, and makes no attempt to store
  view attributes in it.  The elements are identified by the
  StyleContext.NameAttribute attribute, which should
  always have a value of type HTML.Tag that identifies
  the kind of element.  Some of the elements (such as comments) are
  synthesized.  The HTMLFactory uses this attribute to
  determine what kind of view to build.

  This document supports incremental loading.  The
  TokenThreshold property controls how much of the parse
  is buffered before trying to update the element structure of the
  document.  This property is set by the EditorKit so
  that subclasses can disable it.

  The Base property determines the URL against which
  relative URLs are resolved.  By default, this will be the
  Document.StreamDescriptionProperty if the value of the
  property is a URL.  If a <BASE> tag is encountered, the base
  will become the URL specified by that tag.  Because the base URL is
  a property, it can of course be set directly.

  The default content storage mechanism for this document is a gap
  buffer (GapContent).  Alternatives can be supplied by
  using the constructor that takes a Content
  implementation.

  Modifying HTMLDocument

  In addition to the methods provided by Document and
  StyledDocument for mutating an HTMLDocument, HTMLDocument provides
  a number of convenience methods.  The following methods can be used
  to insert HTML content into an existing document.


    setInnerHTML(Element, String)
    setOuterHTML(Element, String)
    insertBeforeStart(Element, String)
    insertAfterStart(Element, String)
    insertBeforeEnd(Element, String)
    insertAfterEnd(Element, String)


  The following examples illustrate using these methods.  Each
  example assumes the HTML document is initialized in the following
  way:



  JEditorPane p = new JEditorPane();
  p.setContentType(\"text/html\");
  p.setText(\"...\"); // Document text is provided below.
  HTMLDocument d = (HTMLDocument) p.getDocument();

  With the following HTML content:



  <html>
    <head>
      <title>An example HTMLDocument</title>
      <style type=\"text/css\">
        div { background-color: silver; }
        ul { color: red; }
      </style>
    </head>
    <body>
      <div id=\"BOX\">
        <p>Paragraph 1</p>
        <p>Paragraph 2</p>
      </div>
    </body>
  </html>

  All the methods for modifying an HTML document require an Element.  Elements can be obtained from an HTML document by using
  the method getElement(Element e, Object attribute, Object
  value).  It returns the first descendant element that contains the
  specified attribute with the given value, in depth-first order.
  For example, d.getElement(d.getDefaultRootElement(),
  StyleConstants.NameAttribute, HTML.Tag.P) returns the first
  paragraph element.

  A convenient shortcut for locating elements is the method getElement(String); returns an element whose ID
  attribute matches the specified value.  For example,
  d.getElement(\"BOX\") returns the DIV
  element.

  The getIterator(HTML.Tag t) method can also be used for
  finding all occurrences of the specified HTML tag in the
  document.

  Inserting elements

  Elements can be inserted before or after the existing children
  of any non-leaf element by using the methods
  insertAfterStart and insertBeforeEnd.
  For example, if e is the DIV element,
  d.insertAfterStart(e, \"<ul><li>List
  Item</li></ul>\") inserts the list before the first
  paragraph, and d.insertBeforeEnd(e, \"<ul><li>List
  Item</li></ul>\") inserts the list after the last
  paragraph.  The DIV block becomes the parent of the
  newly inserted elements.

  Sibling elements can be inserted before or after any element by
  using the methods insertBeforeStart and
  insertAfterEnd.  For example, if e is the
  DIV element, d.insertBeforeStart(e,
  \"<ul><li>List Item</li></ul>\") inserts the list
  before the DIV element, and d.insertAfterEnd(e,
  \"<ul><li>List Item</li></ul>\") inserts the list
  after the DIV element.  The newly inserted elements
  become siblings of the DIV element.

  Replacing elements

  Elements and all their descendants can be replaced by using the
  methods setInnerHTML and setOuterHTML.
  For example, if e is the DIV element,
  d.setInnerHTML(e, \"<ul><li>List
  Item</li></ul>\") replaces all children paragraphs with
  the list, and d.setOuterHTML(e, \"<ul><li>List
  Item</li></ul>\") replaces the DIV element
  itself.  In latter case the parent of the list is the
  BODY element.

  Summary

  The following table shows the example document and the results
  of various methods described above.



      Example
      insertAfterStart
      insertBeforeEnd
      insertBeforeStart
      insertAfterEnd
      setInnerHTML
      setOuterHTML




          Paragraph 1
          Paragraph 2


  insertAfterStart



            List Item

          Paragraph 1
          Paragraph 2


  insertBeforeEnd


          Paragraph 1
          Paragraph 2

            List Item



  insertBeforeStart


          List Item


          Paragraph 1
          Paragraph 2


  insertAfterEnd


          Paragraph 1
          Paragraph 2


          List Item


  setInnerHTML



            List Item



  setOuterHTML


          List Item





  Warning: Serialized objects of this class will
  not be compatible with future Swing releases. The current
  serialization support is appropriate for short term storage or RMI
  between applications running the same version of Swing.  As of 1.4,
  support for long term storage of all JavaBeans™
  has been added to the
  java.beans package.  Please see XMLEncoder."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing.text.html HTMLDocument]))

(defn ->html-document
  "Constructor.

  Constructs an HTML document with the given content
   storage implementation and the given style/attribute
   storage mechanism.

  c - the container for the content - `javax.swing.text.AbstractDocument$Content`
  styles - the styles - `javax.swing.text.html.StyleSheet`"
  (^HTMLDocument [^javax.swing.text.AbstractDocument$Content c ^javax.swing.text.html.StyleSheet styles]
    (new HTMLDocument c styles))
  (^HTMLDocument [^javax.swing.text.html.StyleSheet styles]
    (new HTMLDocument styles))
  (^HTMLDocument []
    (new HTMLDocument )))

(def *-additional-comments
  "Static Constant.

  Document property key value. The value for the key will be a Vector
   of Strings that are comments not found in the body.

  type: java.lang.String"
  HTMLDocument/AdditionalComments)

(defn insert-before-start
  "Inserts the HTML specified as a string before the start of
   the given element.

   Consider the following structure (the elem
   parameter is in bold).



       <body>
         |
       <div>
        /  \\
      <p>   <p>

   Invoking insertBeforeStart(elem,
   \"<ul><li>\") results in the following structure
   (new elements are in red).



          <body>
           /  \\
        <ul> <div>
         /    /  \\
       <li> <p>  <p>

   Unlike the insertAfterStart method, new
   elements become siblings of the specified element, not
   children.

   If either elem or htmlText
   parameter is null, no changes are made to the
   document.

   For this to work correctly, the document must have an
   HTMLEditorKit.Parser set. This will be the case
   if the document was created from an HTMLEditorKit via the
   createDefaultDocument method.

  elem - the element the content is inserted before - `javax.swing.text.Element`
  html-text - the string to be parsed and inserted before elem - `java.lang.String`

  throws: java.lang.IllegalStateException - if an HTMLEditorKit.Parser has not been set on the document"
  ([^HTMLDocument this ^javax.swing.text.Element elem ^java.lang.String html-text]
    (-> this (.insertBeforeStart elem html-text))))

(defn set-base
  "Sets the location to resolve relative URLs against.  By
   default this will be the document's URL if the document
   was loaded from a URL.  If a base tag is found and
   can be parsed, it will be used as the base location.
   This also sets the base of the StyleSheet
   to be u as well as the base of the document.

  u - the desired base URL - `java.net.URL`"
  ([^HTMLDocument this ^java.net.URL u]
    (-> this (.setBase u))))

(defn get-style-sheet
  "Fetches the StyleSheet with the document-specific display
   rules (CSS) that were specified in the HTML document itself.

  returns: the StyleSheet - `javax.swing.text.html.StyleSheet`"
  (^javax.swing.text.html.StyleSheet [^HTMLDocument this]
    (-> this (.getStyleSheet))))

(defn set-outer-html
  "Replaces the given element in the parent with the contents
   specified as an HTML string.

   This will be seen as at least two events, n inserts followed by
   a remove.

   When replacing a leaf this will attempt to make sure there is
   a newline present if one is needed. This may result in an additional
   element being inserted. Consider, if you were to replace a character
   element that contained a newline with <img> this would create
   two elements, one for the image, and one for the newline.

   If you try to replace the element at length you will most
   likely end up with two elements, eg
   setOuterHTML(getCharacterElement (getLength()),
   \"blah\") will result in two leaf elements at the end, one
   representing 'blah', and the other representing the end
   element.

   Consider the following structure (the elem
   parameter is in bold).



       <body>
         |
       <div>
        /  \\
      <p>   <p>

   Invoking setOuterHTML(elem, \"<ul><li>\")
   results in the following structure (new elements are in red).



      <body>
        |
       <ul>
         \\
         <li>

   If either elem or htmlText
   parameter is null, no changes are made to the
   document.

   For this to work correctly, the document must have an
   HTMLEditorKit.Parser set. This will be the case if the document
   was created from an HTMLEditorKit via the
   createDefaultDocument method.

  elem - the element to replace - `javax.swing.text.Element`
  html-text - the string to be parsed and inserted in place of elem - `java.lang.String`

  throws: java.lang.IllegalStateException - if an HTMLEditorKit.Parser has not been set"
  ([^HTMLDocument this ^javax.swing.text.Element elem ^java.lang.String html-text]
    (-> this (.setOuterHTML elem html-text))))

(defn get-element
  "Returns the child element of e that contains the
   attribute, attribute with value value, or
   null if one isn't found. This is not thread-safe.

  e - the root element where the search begins - `javax.swing.text.Element`
  attribute - the desired Attribute - `java.lang.Object`
  value - the values for the specified Attribute - `java.lang.Object`

  returns: the element with the specified Attribute
            and the specified value, or null
            if it can't be found - `javax.swing.text.Element`"
  (^javax.swing.text.Element [^HTMLDocument this ^javax.swing.text.Element e ^java.lang.Object attribute ^java.lang.Object value]
    (-> this (.getElement e attribute value)))
  (^javax.swing.text.Element [^HTMLDocument this ^java.lang.String id]
    (-> this (.getElement id))))

(defn set-paragraph-attributes
  "Sets attributes for a paragraph.

   This method is thread safe, although most Swing methods
   are not. Please see
   Concurrency
   in Swing for more information.

  offset - the offset into the paragraph (must be at least 0) - `int`
  length - the number of characters affected (must be at least 0) - `int`
  s - the attributes - `javax.swing.text.AttributeSet`
  replace - whether to replace existing attributes, or merge them - `boolean`"
  ([^HTMLDocument this ^Integer offset ^Integer length ^javax.swing.text.AttributeSet s ^Boolean replace]
    (-> this (.setParagraphAttributes offset length s replace))))

(defn get-parser
  "Returns the parser that is used when inserting HTML into the existing
   document.

  returns: the parser used for text insertion - `javax.swing.text.html.HTMLEditorKit$Parser`"
  (^javax.swing.text.html.HTMLEditorKit$Parser [^HTMLDocument this]
    (-> this (.getParser))))

(defn get-iterator
  "Fetches an iterator for the specified HTML tag.
   This can be used for things like iterating over the
   set of anchors contained, or iterating over the input
   elements.

  t - the requested HTML.Tag - `javax.swing.text.html.HTML$Tag`

  returns: the Iterator for the given HTML tag - `javax.swing.text.html.HTMLDocument$Iterator`"
  (^javax.swing.text.html.HTMLDocument$Iterator [^HTMLDocument this ^javax.swing.text.html.HTML$Tag t]
    (-> this (.getIterator t))))

(defn get-reader
  "Returns the reader for the parser to use to load the document
   with HTML.  This is implemented to return an instance of
   HTMLDocument.HTMLReader.
   Subclasses can reimplement this
   method to change how the document gets structured if desired.
   (For example, to handle custom tags, or structurally represent character
   style elements.)
   This is a convenience method for
   getReader(int, int, int, HTML.Tag, TRUE).

  pos - `int`
  pop-depth - the number of ElementSpec.EndTagTypes to generate before inserting - `int`
  push-depth - the number of ElementSpec.StartTagTypes with a direction of ElementSpec.JoinNextDirection that should be generated before inserting, but after the end tags have been generated - `int`
  insert-tag - the first tag to start inserting into document - `javax.swing.text.html.HTML$Tag`

  returns: the reader used by the parser to load the document - `javax.swing.text.html.HTMLEditorKit$ParserCallback`"
  (^javax.swing.text.html.HTMLEditorKit$ParserCallback [^HTMLDocument this ^Integer pos ^Integer pop-depth ^Integer push-depth ^javax.swing.text.html.HTML$Tag insert-tag]
    (-> this (.getReader pos pop-depth push-depth insert-tag)))
  (^javax.swing.text.html.HTMLEditorKit$ParserCallback [^HTMLDocument this ^Integer pos]
    (-> this (.getReader pos))))

(defn get-token-threshold
  "Gets the number of tokens to buffer before trying to update
   the documents element structure.  The default value is
   Integer.MAX_VALUE.

  returns: the number of tokens to buffer - `int`"
  (^Integer [^HTMLDocument this]
    (-> this (.getTokenThreshold))))

(defn set-token-threshold
  "Sets the number of tokens to buffer before trying to update
   the documents element structure.

  n - the number of tokens to buffer - `int`"
  ([^HTMLDocument this ^Integer n]
    (-> this (.setTokenThreshold n))))

(defn process-html-frame-hyperlink-event
  "Processes HyperlinkEvents that
   are generated by documents in an HTML frame.
   The HyperlinkEvent type, as the parameter suggests,
   is HTMLFrameHyperlinkEvent.
   In addition to the typical information contained in a
   HyperlinkEvent,
   this event contains the element that corresponds to the frame in
   which the click happened (the source element) and the
   target name.  The target name has 4 possible values:

     _self
     _parent
     _top
     a named frame


   If target is _self, the action is to change the value of the
   HTML.Attribute.SRC attribute and fires a
   ChangedUpdate event.

   If the target is _parent, then it deletes the parent element,
   which is a <FRAMESET> element, and inserts a new <FRAME>
   element, and sets its HTML.Attribute.SRC attribute
   to have a value equal to the destination URL and fire a
   RemovedUpdate and InsertUpdate.

   If the target is _top, this method does nothing. In the implementation
   of the view for a frame, namely the FrameView,
   the processing of _top is handled.  Given that _top implies
   replacing the entire document, it made sense to handle this outside
   of the document that it will replace.

   If the target is a named frame, then the element hierarchy is searched
   for an element with a name equal to the target, its
   HTML.Attribute.SRC attribute is updated and a
   ChangedUpdate event is fired.

  e - the event - `javax.swing.text.html.HTMLFrameHyperlinkEvent`"
  ([^HTMLDocument this ^javax.swing.text.html.HTMLFrameHyperlinkEvent e]
    (-> this (.processHTMLFrameHyperlinkEvent e))))

(defn get-base
  "Returns the location to resolve relative URLs against.  By
   default this will be the document's URL if the document
   was loaded from a URL.  If a base tag is found and
   can be parsed, it will be used as the base location.

  returns: the base location - `java.net.URL`"
  (^java.net.URL [^HTMLDocument this]
    (-> this (.getBase))))

(defn insert-after-end
  "Inserts the HTML specified as a string after the the end of the
   given element.

   Consider the following structure (the elem
   parameter is in bold).



       <body>
         |
       <div>
        /  \\
      <p>   <p>

   Invoking insertAfterEnd(elem, \"<ul><li>\")
   results in the following structure (new elements are in red).



          <body>
           /  \\
        <div> <ul>
         / \\    \\
       <p> <p>  <li>

   Unlike the insertBeforeEnd method, new elements
   become siblings of the specified element, not
   children.

   If either elem or htmlText
   parameter is null, no changes are made to the
   document.

   For this to work correctly, the document must have an
   HTMLEditorKit.Parser set. This will be the case
   if the document was created from an HTMLEditorKit via the
   createDefaultDocument method.

  elem - the element the content is inserted after - `javax.swing.text.Element`
  html-text - the string to be parsed and inserted after elem - `java.lang.String`

  throws: java.lang.IllegalStateException - if an HTMLEditorKit.Parser has not been set on the document"
  ([^HTMLDocument this ^javax.swing.text.Element elem ^java.lang.String html-text]
    (-> this (.insertAfterEnd elem html-text))))

(defn set-preserves-unknown-tags
  "Determines how unknown tags are handled by the parser.
   If set to true, unknown
   tags are put in the model, otherwise they are dropped.

  preserves-tags - true if unknown tags should be saved in the model, otherwise tags are dropped - `boolean`"
  ([^HTMLDocument this ^Boolean preserves-tags]
    (-> this (.setPreservesUnknownTags preserves-tags))))

(defn set-parser
  "Sets the parser that is used by the methods that insert html
   into the existing document, such as setInnerHTML,
   and setOuterHTML.

   HTMLEditorKit.createDefaultDocument will set the parser
   for you. If you create an HTMLDocument by hand,
   be sure and set the parser accordingly.

  parser - the parser to be used for text insertion - `javax.swing.text.html.HTMLEditorKit$Parser`"
  ([^HTMLDocument this ^javax.swing.text.html.HTMLEditorKit$Parser parser]
    (-> this (.setParser parser))))

(defn insert-after-start
  "Inserts the HTML specified as a string at the start
   of the element.

   Consider the following structure (the elem
   parameter is in bold).



       <body>
         |
       <div>
        /  \\
      <p>   <p>

   Invoking insertAfterStart(elem,
   \"<ul><li>\") results in the following structure
   (new elements are in red).



          <body>
            |
          <div>
         /  |  \\
      <ul> <p> <p>
       /
    <li>

   Unlike the insertBeforeStart method, new
    elements become children of the specified element,
    not siblings.

   Parameter elem must not be a leaf element,
   otherwise an IllegalArgumentException is thrown.
   If either elem or htmlText parameter
   is null, no changes are made to the document.

   For this to work correctly, the document must have an
   HTMLEditorKit.Parser set. This will be the case
   if the document was created from an HTMLEditorKit via the
   createDefaultDocument method.

  elem - the branch element to be the root for the new text - `javax.swing.text.Element`
  html-text - the string to be parsed and assigned to elem - `java.lang.String`

  throws: java.lang.IllegalArgumentException - if elem is a leaf"
  ([^HTMLDocument this ^javax.swing.text.Element elem ^java.lang.String html-text]
    (-> this (.insertAfterStart elem html-text))))

(defn get-preserves-unknown-tags?
  "Returns the behavior the parser observes when encountering
   unknown tags.

  returns: true if unknown tags are to be preserved when parsing - `boolean`"
  (^Boolean [^HTMLDocument this]
    (-> this (.getPreservesUnknownTags))))

(defn insert-before-end
  "Inserts the HTML specified as a string at the end of
   the element.

    If elem's children are leaves, and the
   character at a elem.getEndOffset() - 1 is a newline,
   this will insert before the newline so that there isn't text after
   the newline.

   Consider the following structure (the elem
   parameter is in bold).



       <body>
         |
       <div>
        /  \\
      <p>   <p>

   Invoking insertBeforeEnd(elem, \"<ul><li>\")
   results in the following structure (new elements are in red).



          <body>
            |
          <div>
         /  |  \\
       <p> <p> <ul>
                 \\
                 <li>

   Unlike the insertAfterEnd method, new elements
   become children of the specified element, not
   siblings.

   Parameter elem must not be a leaf element,
   otherwise an IllegalArgumentException is thrown.
   If either elem or htmlText parameter
   is null, no changes are made to the document.

   For this to work correctly, the document must have an
   HTMLEditorKit.Parser set. This will be the case
   if the document was created from an HTMLEditorKit via the
   createDefaultDocument method.

  elem - the element to be the root for the new text - `javax.swing.text.Element`
  html-text - the string to be parsed and assigned to elem - `java.lang.String`

  throws: java.lang.IllegalArgumentException - if elem is a leaf"
  ([^HTMLDocument this ^javax.swing.text.Element elem ^java.lang.String html-text]
    (-> this (.insertBeforeEnd elem html-text))))

(defn set-inner-html
  "Replaces the children of the given element with the contents
   specified as an HTML string.

   This will be seen as at least two events, n inserts followed by
   a remove.

   Consider the following structure (the elem
   parameter is in bold).



       <body>
         |
       <div>
        /  \\
      <p>   <p>

   Invoking setInnerHTML(elem, \"<ul><li>\")
   results in the following structure (new elements are in red).



       <body>
         |
       <div>
           \\
           <ul>
             \\
             <li>

   Parameter elem must not be a leaf element,
   otherwise an IllegalArgumentException is thrown.
   If either elem or htmlText parameter
   is null, no changes are made to the document.

   For this to work correctly, the document must have an
   HTMLEditorKit.Parser set. This will be the case
   if the document was created from an HTMLEditorKit via the
   createDefaultDocument method.

  elem - the branch element whose children will be replaced - `javax.swing.text.Element`
  html-text - the string to be parsed and assigned to elem - `java.lang.String`

  throws: java.lang.IllegalArgumentException - if elem is a leaf"
  ([^HTMLDocument this ^javax.swing.text.Element elem ^java.lang.String html-text]
    (-> this (.setInnerHTML elem html-text))))

