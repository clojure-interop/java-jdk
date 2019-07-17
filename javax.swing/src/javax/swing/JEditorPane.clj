(ns javax.swing.JEditorPane
  "A text component to edit various kinds of content.
  You can find how-to information and examples of using editor panes in
  Using Text Components,
  a section in The Java Tutorial.


  This component uses implementations of the
  EditorKit to accomplish its behavior. It effectively
  morphs into the proper kind of text editor for the kind
  of content it is given.  The content type that editor is bound
  to at any given time is determined by the EditorKit currently
  installed.  If the content is set to a new URL, its type is used
  to determine the EditorKit that should be used to
  load the content.

  By default, the following types of content are known:

  text/plain
  Plain text, which is the default the type given isn't
  recognized.  The kit used in this case is an extension of
  DefaultEditorKit that produces a wrapped plain text view.
  text/html
  HTML text.  The kit used in this case is the class
  javax.swing.text.html.HTMLEditorKit
  which provides HTML 3.2 support.
  text/rtf
  RTF text.  The kit used in this case is the class
  javax.swing.text.rtf.RTFEditorKit
  which provides a limited support of the Rich Text Format.


  There are several ways to load content into this component.


  The setText method can be used to initialize
  the component from a string.  In this case the current
  EditorKit will be used, and the content type will be
  expected to be of this type.

  The read method can be used to initialize the
  component from a Reader.  Note that if the content type is HTML,
  relative references (e.g. for things like images) can't be resolved
  unless the <base> tag is used or the Base property
  on HTMLDocument is set.
  In this case the current EditorKit will be used,
  and the content type will be expected to be of this type.

  The setPage method can be used to initialize
  the component from a URL.  In this case, the content type will be
  determined from the URL, and the registered EditorKit
  for that content type will be set.


  Some kinds of content may provide hyperlink support by generating
  hyperlink events.  The HTML EditorKit will generate
  hyperlink events if the JEditorPane is not editable
  (JEditorPane.setEditable(false); has been called).
  If HTML frames are embedded in the document, the typical response would be
  to change a portion of the current document.  The following code
  fragment is a possible hyperlink listener implementation, that treats
  HTML frame events specially, and simply displays any other activated
  hyperlinks.


      class Hyperactive implements HyperlinkListener {

          public void hyperlinkUpdate(HyperlinkEvent e) {
              if (e.getEventType() == HyperlinkEvent.EventType.ACTIVATED) {
                  JEditorPane pane = (JEditorPane) e.getSource();
                  if (e instanceof HTMLFrameHyperlinkEvent) {
                      HTMLFrameHyperlinkEvent  evt = (HTMLFrameHyperlinkEvent)e;
                      HTMLDocument doc = (HTMLDocument)pane.getDocument();
                      doc.processHTMLFrameHyperlinkEvent(evt);
                  } else {
                      try {
                          pane.setPage(e.getURL());
                      } catch (Throwable t) {
                          t.printStackTrace();
                      }
                  }
              }
          }
      }

  For information on customizing how text/html is rendered please see
  W3C_LENGTH_UNITS and HONOR_DISPLAY_PROPERTIES

  Culturally dependent information in some documents is handled through
  a mechanism called character encoding.  Character encoding is an
  unambiguous mapping of the members of a character set (letters, ideographs,
  digits, symbols, or control functions) to specific numeric code values. It
  represents the way the file is stored. Example character encodings are
  ISO-8859-1, ISO-8859-5, Shift-jis, Euc-jp, and UTF-8. When the file is
  passed to an user agent (JEditorPane) it is converted to
  the document character set (ISO-10646 aka Unicode).

  There are multiple ways to get a character set mapping to happen
  with JEditorPane.


  One way is to specify the character set as a parameter of the MIME
  type.  This will be established by a call to the
  setContentType method.  If the content
  is loaded by the setPage method the content
  type will have been set according to the specification of the URL.
  It the file is loaded directly, the content type would be expected to
  have been set prior to loading.

  Another way the character set can be specified is in the document itself.
  This requires reading the document prior to determining the character set
  that is desired.  To handle this, it is expected that the
  EditorKit.read operation throw a
  ChangedCharSetException which will
  be caught.  The read is then restarted with a new Reader that uses
  the character set specified in the ChangedCharSetException
  (which is an IOException).



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
  (:import [javax.swing JEditorPane]))

(defn ->j-editor-pane
  "Constructor.

  Creates a JEditorPane that has been initialized
   to the given text.  This is a convenience constructor that calls the
   setContentType and setText methods.

  type - mime type of the given text - `java.lang.String`
  text - the text to initialize with; may be null - `java.lang.String`

  throws: java.lang.NullPointerException - if the type parameter is null"
  ([type text]
    (new JEditorPane type text))
  ([initial-page]
    (new JEditorPane initial-page))
  ([]
    (new JEditorPane )))

(def *-w-3-c-length-units
  "Static Constant.

  Key for a client property used to indicate whether

   w3c compliant length units are used for html rendering.

   By default this is not enabled; to enable
   it set the client property with this name
   to Boolean.TRUE.

  type: java.lang.String"
  JEditorPane/W3C_LENGTH_UNITS)

(def *-honor-display-properties
  "Static Constant.

  Key for a client property used to indicate whether
   the default font and foreground color from the component are
   used if a font or foreground color is not specified in the styled
   text.

   The default varies based on the look and feel;
   to enable it set the client property with
   this name to Boolean.TRUE.

  type: java.lang.String"
  JEditorPane/HONOR_DISPLAY_PROPERTIES)

(defn *create-editor-kit-for-content-type
  "Creates a handler for the given type from the default registry
   of editor kits.  The registry is created if necessary.  If the
   registered class has not yet been loaded, an attempt
   is made to dynamically load the prototype of the kit for the
   given type.  If the type was registered with a ClassLoader,
   that ClassLoader will be used to load the prototype.
   If there was no registered ClassLoader,
   Class.forName will be used to load the prototype.

   Once a prototype EditorKit instance is successfully
   located, it is cloned and the clone is returned.

  type - the content type - `java.lang.String`

  returns: the editor kit, or null if there is nothing
     registered for the given type - `javax.swing.text.EditorKit`"
  ([type]
    (JEditorPane/createEditorKitForContentType type)))

(defn *register-editor-kit-for-content-type
  "Establishes the default bindings of type to
   classname.
   The class will be dynamically loaded later when actually
   needed using the given ClassLoader,
   and can be safely changed
   before attempted uses to avoid loading unwanted classes.

  type - the non-null content type - `java.lang.String`
  classname - the class to load later - `java.lang.String`
  loader - the ClassLoader to use to load the name - `java.lang.ClassLoader`"
  ([type classname loader]
    (JEditorPane/registerEditorKitForContentType type classname loader))
  ([type classname]
    (JEditorPane/registerEditorKitForContentType type classname)))

(defn *get-editor-kit-class-name-for-content-type
  "Returns the currently registered EditorKit
   class name for the type type.

  type - the non-null content type - `java.lang.String`

  returns: `java.lang.String`"
  ([type]
    (JEditorPane/getEditorKitClassNameForContentType type)))

(defn set-editor-kit
  "Sets the currently installed kit for handling
   content.  This is the bound property that
   establishes the content type of the editor.
   Any old kit is first deinstalled, then if kit is
   non-null,
   the new kit is installed, and a default document created for it.
   A PropertyChange event (`editorKit`) is always fired when
   setEditorKit is called.

   NOTE: This has the side effect of changing the model,
   because the EditorKit is the source of how a
   particular type
   of content is modeled.  This method will cause setDocument
   to be called on behalf of the caller to ensure integrity
   of the internal state.

  kit - the desired editor behavior - `javax.swing.text.EditorKit`"
  ([this kit]
    (-> this (.setEditorKit kit))))

(defn set-content-type
  "Sets the type of content that this editor
   handles.  This calls getEditorKitForContentType,
   and then setEditorKit if an editor kit can
   be successfully located.  This is mostly convenience method
   that can be used as an alternative to calling
   setEditorKit directly.

   If there is a charset definition specified as a parameter
   of the content type specification, it will be used when
   loading input streams using the associated EditorKit.
   For example if the type is specified as
   text/html; charset=EUC-JP the content
   will be loaded using the EditorKit registered for
   text/html and the Reader provided to
   the EditorKit to load unicode into the document will
   use the EUC-JP charset for translating
   to unicode.  If the type is not recognized, the content
   will be loaded using the EditorKit registered
   for plain text, text/plain.

  type - the non-null mime type for the content editing support - `java.lang.String`

  throws: java.lang.NullPointerException - if the type parameter is null"
  ([this type]
    (-> this (.setContentType type))))

(defn set-text
  "Sets the text of this TextComponent to the specified
   content,
   which is expected to be in the format of the content type of
   this editor.  For example, if the type is set to text/html
   the string should be specified in terms of HTML.

   This is implemented to remove the contents of the current document,
   and replace them by parsing the given string using the current
   EditorKit.  This gives the semantics of the
   superclass by not changing
   out the model, while supporting the content type currently set on
   this component.  The assumption is that the previous content is
   relatively
   small, and that the previous content doesn't have side effects.
   Both of those assumptions can be violated and cause undesirable results.
   To avoid this, create a new document,
   getEditorKit().createDefaultDocument(), and replace the
   existing Document with the new one. You are then assured the
   previous Document won't have any lingering state.


   Leaving the existing model in place means that the old view will be
   torn down, and a new view created, where replacing the document would
   avoid the tear down of the old view.

   Some formats (such as HTML) can install things into the document that
   can influence future contents.  HTML can have style information embedded
   that would influence the next content installed unexpectedly.


   An alternative way to load this component with a string would be to
   create a StringReader and call the read method.  In this case the model
   would be replaced after it was initialized with the contents of the
   string.

  t - the new text to be set; if null the old text will be deleted - `java.lang.String`"
  ([this t]
    (-> this (.setText t))))

(defn get-text
  "Returns the text contained in this TextComponent
   in terms of the
   content type of this editor.  If an exception is thrown while
   attempting to retrieve the text, null will be returned.
   This is implemented to call JTextComponent.write with
   a StringWriter.

  returns: the text - `java.lang.String`"
  ([this]
    (-> this (.getText))))

(defn set-editor-kit-for-content-type
  "Directly sets the editor kit to use for the given type.  A
   look-and-feel implementation might use this in conjunction
   with createEditorKitForContentType to install handlers for
   content types with a look-and-feel bias.

  type - the non-null content type - `java.lang.String`
  k - the editor kit to be set - `javax.swing.text.EditorKit`"
  ([this type k]
    (-> this (.setEditorKitForContentType type k))))

(defn read
  "This method initializes from a stream.  If the kit is
   set to be of type HTMLEditorKit, and the
   desc parameter is an HTMLDocument,
   then it invokes the HTMLEditorKit to initiate
   the read. Otherwise it calls the superclass
   method which loads the model as plain text.

  in - the stream from which to read - `java.io.InputStream`
  desc - an object describing the stream - `java.lang.Object`

  throws: java.io.IOException - as thrown by the stream being used to initialize"
  ([this in desc]
    (-> this (.read in desc))))

(defn get-editor-kit-for-content-type
  "Fetches the editor kit to use for the given type
   of content.  This is called when a type is requested
   that doesn't match the currently installed type.
   If the component doesn't have an EditorKit registered
   for the given type, it will try to create an
   EditorKit from the default EditorKit registry.
   If that fails, a PlainEditorKit is used on the
   assumption that all text documents can be represented
   as plain text.

   This method can be reimplemented to use some
   other kind of type registry.  This can
   be reimplemented to use the Java Activation
   Framework, for example.

  type - the non-null content type - `java.lang.String`

  returns: the editor kit - `javax.swing.text.EditorKit`"
  ([this type]
    (-> this (.getEditorKitForContentType type))))

(defn get-ui-class-id
  "Gets the class ID for the UI.

  returns: the string `EditorPaneUI` - `java.lang.String`"
  ([this]
    (-> this (.getUIClassID))))

(defn get-content-type
  "Gets the type of content that this editor
   is currently set to deal with.  This is
   defined to be the type associated with the
   currently installed EditorKit.

  returns: the content type, null if no editor kit set - `java.lang.String`"
  ([this]
    (-> this (.getContentType))))

(defn remove-hyperlink-listener
  "Removes a hyperlink listener.

  listener - the listener - `javax.swing.event.HyperlinkListener`"
  ([this listener]
    (-> this (.removeHyperlinkListener listener))))

(defn set-page
  "Sets the current URL being displayed.  The content type of the
   pane is set, and if the editor kit for the pane is
   non-null, then
   a new default document is created and the URL is read into it.
   If the URL contains and reference location, the location will
   be scrolled to by calling the scrollToReference
   method. If the desired URL is the one currently being displayed,
   the document will not be reloaded. To force a document
   reload it is necessary to clear the stream description property
   of the document. The following code shows how this can be done:



     Document doc = jEditorPane.getDocument();
     doc.putProperty(Document.StreamDescriptionProperty, null);

   If the desired URL is not the one currently being
   displayed, the getStream method is called to
   give subclasses control over the stream provided.

   This may load either synchronously or asynchronously
   depending upon the document returned by the EditorKit.
   If the Document is of type
   AbstractDocument and has a value returned by
   AbstractDocument.getAsynchronousLoadPriority
   that is greater than or equal to zero, the page will be
   loaded on a separate thread using that priority.

   If the document is loaded synchronously, it will be
   filled in with the stream prior to being installed into
   the editor with a call to setDocument, which
   is bound and will fire a property change event.  If an
   IOException is thrown the partially loaded
   document will
   be discarded and neither the document or page property
   change events will be fired.  If the document is
   successfully loaded and installed, a view will be
   built for it by the UI which will then be scrolled if
   necessary, and then the page property change event
   will be fired.

   If the document is loaded asynchronously, the document
   will be installed into the editor immediately using a
   call to setDocument which will fire a
   document property change event, then a thread will be
   created which will begin doing the actual loading.
   In this case, the page property change event will not be
   fired by the call to this method directly, but rather will be
   fired when the thread doing the loading has finished.
   It will also be fired on the event-dispatch thread.
   Since the calling thread can not throw an IOException
   in the event of failure on the other thread, the page
   property change event will be fired when the other
   thread is done whether the load was successful or not.

  page - the URL of the page - `java.net.URL`

  throws: java.io.IOException - for a null or invalid page specification, or exception from the stream being read"
  ([this page]
    (-> this (.setPage page))))

(defn scroll-to-reference
  "Scrolls the view to the given reference location
   (that is, the value returned by the UL.getRef
   method for the URL being displayed).  By default, this
   method only knows how to locate a reference in an
   HTMLDocument.  The implementation calls the
   scrollRectToVisible method to
   accomplish the actual scrolling.  If scrolling to a
   reference location is needed for document types other
   than HTML, this method should be reimplemented.
   This method will have no effect if the component
   is not visible.

  reference - the named location to scroll to - `java.lang.String`"
  ([this reference]
    (-> this (.scrollToReference reference))))

(defn get-scrollable-tracks-viewport-width?
  "Returns true if a viewport should always force the width of this
   Scrollable to match the width of the viewport.

  returns: true if a viewport should force the Scrollables width to
   match its own, false otherwise - `boolean`"
  ([this]
    (-> this (.getScrollableTracksViewportWidth))))

(defn get-accessible-context
  "Gets the AccessibleContext associated with this JEditorPane.
   For editor panes, the AccessibleContext takes the form of an
   AccessibleJEditorPane.
   A new AccessibleJEditorPane instance is created if necessary.

  returns: an AccessibleJEditorPane that serves as the
           AccessibleContext of this JEditorPane - `javax.accessibility.AccessibleContext`"
  ([this]
    (-> this (.getAccessibleContext))))

(defn get-hyperlink-listeners
  "Returns an array of all the HyperLinkListeners added
   to this JEditorPane with addHyperlinkListener().

  returns: all of the HyperLinkListeners added or an empty
           array if no listeners have been added - `javax.swing.event.HyperlinkListener[]`"
  ([this]
    (-> this (.getHyperlinkListeners))))

(defn replace-selection
  "Replaces the currently selected content with new content
   represented by the given string.  If there is no selection
   this amounts to an insert of the given text.  If there
   is no replacement text (i.e. the content string is empty
   or null) this amounts to a removal of the
   current selection.  The replacement text will have the
   attributes currently defined for input.  If the component is not
   editable, beep and return.

  content - the content to replace the selection with. This value can be null - `java.lang.String`"
  ([this content]
    (-> this (.replaceSelection content))))

(defn add-hyperlink-listener
  "Adds a hyperlink listener for notification of any changes, for example
   when a link is selected and entered.

  listener - the listener - `javax.swing.event.HyperlinkListener`"
  ([this listener]
    (-> this (.addHyperlinkListener listener))))

(defn get-scrollable-tracks-viewport-height?
  "Returns true if a viewport should always force the height of this
   Scrollable to match the height of the viewport.

  returns: true if a viewport should force the
            Scrollable's height to match its own,
            false otherwise - `boolean`"
  ([this]
    (-> this (.getScrollableTracksViewportHeight))))

(defn get-page
  "Gets the current URL being displayed.  If a URL was
   not specified in the creation of the document, this
   will return null, and relative URL's will not be
   resolved.

  returns: the URL, or null if none - `java.net.URL`"
  ([this]
    (-> this (.getPage))))

(defn fire-hyperlink-update
  "Notifies all listeners that have registered interest for
   notification on this event type.  This is normally called
   by the currently installed EditorKit if a content type
   that supports hyperlinks is currently active and there
   was activity with a link.  The listener list is processed
   last to first.

  e - the event - `javax.swing.event.HyperlinkEvent`"
  ([this e]
    (-> this (.fireHyperlinkUpdate e))))

(defn get-editor-kit
  "Fetches the currently installed kit for handling content.
   createDefaultEditorKit is called to set up a default
   if necessary.

  returns: the editor kit - `javax.swing.text.EditorKit`"
  ([this]
    (-> this (.getEditorKit))))

(defn get-preferred-size
  "Returns the preferred size for the JEditorPane.
   The preferred size for JEditorPane is slightly altered
   from the preferred size of the superclass.  If the size
   of the viewport has become smaller than the minimum size
   of the component, the scrollable definition for tracking
   width or height will turn to false.  The default viewport
   layout will give the preferred size, and that is not desired
   in the case where the scrollable is tracking.  In that case
   the normal preferred size is adjusted to the
   minimum size.  This allows things like HTML tables to
   shrink down to their minimum size and then be laid out at
   their minimum size, refusing to shrink any further.

  returns: a Dimension containing the preferred size - `java.awt.Dimension`"
  ([this]
    (-> this (.getPreferredSize))))

