(ns javax.swing.JTextArea
  "A JTextArea is a multi-line area that displays plain text.
  It is intended to be a lightweight component that provides source
  compatibility with the java.awt.TextArea class where it can
  reasonably do so.
  You can find information and examples of using all the text components in
  Using Text Components,
  a section in The Java Tutorial.


  This component has capabilities not found in the
  java.awt.TextArea class.  The superclass should be
  consulted for additional capabilities.
  Alternative multi-line text classes with
  more capabilities are JTextPane and JEditorPane.

  The java.awt.TextArea internally handles scrolling.
  JTextArea is different in that it doesn't manage scrolling,
  but implements the swing Scrollable interface.  This allows it
  to be placed inside a JScrollPane if scrolling
  behavior is desired, and used directly if scrolling is not desired.

  The java.awt.TextArea has the ability to do line wrapping.
  This was controlled by the horizontal scrolling policy.  Since
  scrolling is not done by JTextArea directly, backward
  compatibility must be provided another way.  JTextArea has
  a bound property for line wrapping that controls whether or
  not it will wrap lines.  By default, the line wrapping property
  is set to false (not wrapped).

  java.awt.TextArea has two properties rows
  and columns that are used to determine the preferred size.
  JTextArea uses these properties to indicate the
  preferred size of the viewport when placed inside a JScrollPane
  to match the functionality provided by java.awt.TextArea.
  JTextArea has a preferred size of what is needed to
  display all of the text, so that it functions properly inside of
  a JScrollPane.  If the value for rows
  or columns is equal to zero,
  the preferred size along that axis is used for
  the viewport preferred size along the same axis.

  The java.awt.TextArea could be monitored for changes by adding
  a TextListener for TextEvents.
  In the JTextComponent based
  components, changes are broadcasted from the model via a
  DocumentEvent to DocumentListeners.
  The DocumentEvent gives
  the location of the change and the kind of change if desired.
  The code fragment might look something like:


     DocumentListener myListener = ??;
     JTextArea myArea = ??;
     myArea.getDocument().addDocumentListener(myListener);


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
  (:import [javax.swing JTextArea]))

(defn ->j-text-area
  "Constructor.

  Constructs a new JTextArea with the specified number of rows
   and columns, and the given model.  All of the constructors
   feed through this constructor.

  doc - the model to use, or create a default one if null - `javax.swing.text.Document`
  text - the text to be displayed, null if none - `java.lang.String`
  rows - the number of rows >= 0 - `int`
  columns - the number of columns >= 0 - `int`

  throws: java.lang.IllegalArgumentException - if the rows or columns arguments are negative."
  (^JTextArea [^javax.swing.text.Document doc ^java.lang.String text ^Integer rows ^Integer columns]
    (new JTextArea doc text rows columns))
  (^JTextArea [^java.lang.String text ^Integer rows ^Integer columns]
    (new JTextArea text rows columns))
  (^JTextArea [^Integer rows ^Integer columns]
    (new JTextArea rows columns))
  (^JTextArea [^java.lang.String text]
    (new JTextArea text))
  (^JTextArea []
    (new JTextArea )))

(defn get-tab-size
  "Gets the number of characters used to expand tabs.  If the document is
   null or doesn't have a tab setting, return a default of 8.

  returns: the number of characters - `int`"
  (^Integer [^JTextArea this]
    (-> this (.getTabSize))))

(defn set-columns
  "Sets the number of columns for this TextArea.  Does an invalidate()
   after setting the new value.

  columns - the number of columns >= 0 - `int`

  throws: java.lang.IllegalArgumentException - if columns is less than 0"
  ([^JTextArea this ^Integer columns]
    (-> this (.setColumns columns))))

(defn get-line-of-offset
  "Translates an offset into the components text to a
   line number.

  offset - the offset >= 0 - `int`

  returns: the line number >= 0 - `int`

  throws: javax.swing.text.BadLocationException - thrown if the offset is less than zero or greater than the document length."
  (^Integer [^JTextArea this ^Integer offset]
    (-> this (.getLineOfOffset offset))))

(defn get-line-count
  "Determines the number of lines contained in the area.

  returns: the number of lines > 0 - `int`"
  (^Integer [^JTextArea this]
    (-> this (.getLineCount))))

(defn get-columns
  "Returns the number of columns in the TextArea.

  returns: number of columns >= 0 - `int`"
  (^Integer [^JTextArea this]
    (-> this (.getColumns))))

(defn set-wrap-style-word
  "Sets the style of wrapping used if the text area is wrapping
   lines.  If set to true the lines will be wrapped at word
   boundaries (whitespace) if they are too long
   to fit within the allocated width.  If set to false,
   the lines will be wrapped at character boundaries.
   By default this property is false.

  word - indicates if word boundaries should be used for line wrapping - `boolean`"
  ([^JTextArea this ^Boolean word]
    (-> this (.setWrapStyleWord word))))

(defn get-ui-class-id
  "Returns the class ID for the UI.

  returns: the ID (\"TextAreaUI\") - `java.lang.String`"
  (^java.lang.String [^JTextArea this]
    (-> this (.getUIClassID))))

(defn get-scrollable-unit-increment
  "Components that display logical rows or columns should compute
   the scroll increment that will completely expose one new row
   or column, depending on the value of orientation.  This is implemented
   to use the values returned by the getRowHeight and
   getColumnWidth methods.

   Scrolling containers, like JScrollPane, will use this method
   each time the user requests a unit scroll.

  visible-rect - the view area visible within the viewport - `java.awt.Rectangle`
  orientation - Either SwingConstants.VERTICAL or SwingConstants.HORIZONTAL. - `int`
  direction - Less than zero to scroll up/left, greater than zero for down/right. - `int`

  returns: The \"unit\" increment for scrolling in the specified direction - `int`

  throws: java.lang.IllegalArgumentException - for an invalid orientation"
  (^Integer [^JTextArea this ^java.awt.Rectangle visible-rect ^Integer orientation ^Integer direction]
    (-> this (.getScrollableUnitIncrement visible-rect orientation direction))))

(defn set-line-wrap
  "Sets the line-wrapping policy of the text area.  If set
   to true the lines will be wrapped if they are too long
   to fit within the allocated width.  If set to false,
   the lines will always be unwrapped.  A PropertyChange
   event (\"lineWrap\") is fired when the policy is changed.
   By default this property is false.

  wrap - indicates if lines should be wrapped - `boolean`"
  ([^JTextArea this ^Boolean wrap]
    (-> this (.setLineWrap wrap))))

(defn get-line-end-offset
  "Determines the offset of the end of the given line.

  line - the line >= 0 - `int`

  returns: the offset >= 0 - `int`

  throws: javax.swing.text.BadLocationException - Thrown if the line is less than zero or greater or equal to the number of lines contained in the document (as reported by getLineCount)."
  (^Integer [^JTextArea this ^Integer line]
    (-> this (.getLineEndOffset line))))

(defn get-preferred-scrollable-viewport-size
  "Returns the preferred size of the viewport if this component
   is embedded in a JScrollPane.  This uses the desired column
   and row settings if they have been set, otherwise the superclass
   behavior is used.

  returns: The preferredSize of a JViewport whose view is this Scrollable. - `java.awt.Dimension`"
  (^java.awt.Dimension [^JTextArea this]
    (-> this (.getPreferredScrollableViewportSize))))

(defn get-wrap-style-word?
  "Gets the style of wrapping used if the text area is wrapping
   lines.  If set to true the lines will be wrapped at word
   boundaries (ie whitespace) if they are too long
   to fit within the allocated width.  If set to false,
   the lines will be wrapped at character boundaries.

  returns: if the wrap style should be word boundaries
    instead of character boundaries - `boolean`"
  (^Boolean [^JTextArea this]
    (-> this (.getWrapStyleWord))))

(defn set-tab-size
  "Sets the number of characters to expand tabs to.
   This will be multiplied by the maximum advance for
   variable width fonts.  A PropertyChange event (\"tabSize\") is fired
   when the tab size changes.

  size - number of characters to expand to - `int`"
  ([^JTextArea this ^Integer size]
    (-> this (.setTabSize size))))

(defn set-font
  "Sets the current font.  This removes cached row height and column
   width so the new font will be reflected, and calls revalidate().

  f - the font to use as the current font - `java.awt.Font`"
  ([^JTextArea this ^java.awt.Font f]
    (-> this (.setFont f))))

(defn get-scrollable-tracks-viewport-width?
  "Returns true if a viewport should always force the width of this
   Scrollable to match the width of the viewport.  This is implemented
   to return true if the line wrapping policy is true, and false
   if lines are not being wrapped.

  returns: true if a viewport should force the Scrollables width
   to match its own. - `boolean`"
  (^Boolean [^JTextArea this]
    (-> this (.getScrollableTracksViewportWidth))))

(defn get-rows
  "Returns the number of rows in the TextArea.

  returns: the number of rows >= 0 - `int`"
  (^Integer [^JTextArea this]
    (-> this (.getRows))))

(defn get-accessible-context
  "Gets the AccessibleContext associated with this JTextArea.
   For JTextAreas, the AccessibleContext takes the form of an
   AccessibleJTextArea.
   A new AccessibleJTextArea instance is created if necessary.

  returns: an AccessibleJTextArea that serves as the
           AccessibleContext of this JTextArea - `javax.accessibility.AccessibleContext`"
  (^javax.accessibility.AccessibleContext [^JTextArea this]
    (-> this (.getAccessibleContext))))

(defn get-line-wrap?
  "Gets the line-wrapping policy of the text area.  If set
   to true the lines will be wrapped if they are too long
   to fit within the allocated width.  If set to false,
   the lines will always be unwrapped.

  returns: if lines will be wrapped - `boolean`"
  (^Boolean [^JTextArea this]
    (-> this (.getLineWrap))))

(defn get-line-start-offset
  "Determines the offset of the start of the given line.

  line - the line number to translate >= 0 - `int`

  returns: the offset >= 0 - `int`

  throws: javax.swing.text.BadLocationException - thrown if the line is less than zero or greater or equal to the number of lines contained in the document (as reported by getLineCount)."
  (^Integer [^JTextArea this ^Integer line]
    (-> this (.getLineStartOffset line))))

(defn append
  "Appends the given text to the end of the document.  Does nothing if
   the model is null or the string is null or empty.

  str - the text to insert - `java.lang.String`"
  ([^JTextArea this ^java.lang.String str]
    (-> this (.append str))))

(defn insert
  "Inserts the specified text at the specified position.  Does nothing
   if the model is null or if the text is null or empty.

  str - the text to insert - `java.lang.String`
  pos - the position at which to insert >= 0 - `int`

  throws: java.lang.IllegalArgumentException - if pos is an invalid position in the model"
  ([^JTextArea this ^java.lang.String str ^Integer pos]
    (-> this (.insert str pos))))

(defn replace-range
  "Replaces text from the indicated start to end position with the
   new text specified.  Does nothing if the model is null.  Simply
   does a delete if the new string is null or empty.

  str - the text to use as the replacement - `java.lang.String`
  start - the start position >= 0 - `int`
  end - the end position >= start - `int`

  throws: java.lang.IllegalArgumentException - if part of the range is an invalid position in the model"
  ([^JTextArea this ^java.lang.String str ^Integer start ^Integer end]
    (-> this (.replaceRange str start end))))

(defn set-rows
  "Sets the number of rows for this TextArea.  Calls invalidate() after
   setting the new value.

  rows - the number of rows >= 0 - `int`

  throws: java.lang.IllegalArgumentException - if rows is less than 0"
  ([^JTextArea this ^Integer rows]
    (-> this (.setRows rows))))

(defn get-preferred-size
  "Returns the preferred size of the TextArea.  This is the
   maximum of the size needed to display the text and the
   size requested for the viewport.

  returns: the size - `java.awt.Dimension`"
  (^java.awt.Dimension [^JTextArea this]
    (-> this (.getPreferredSize))))

