(ns javax.swing.text.PlainDocument
  "A plain document that maintains no character attributes.  The
  default element structure for this document is a map of the lines in
  the text.  The Element returned by getDefaultRootElement is
  a map of the lines, and each child element represents a line.
  This model does not maintain any character level attributes,
  but each line can be tagged with an arbitrary set of attributes.
  Line to offset, and offset to line translations can be quickly
  performed using the default root element.  The structure information
  of the DocumentEvent's fired by edits will indicate the line
  structure changes.

  The default content storage management is performed by a
  gapped buffer implementation (GapContent).  It supports
  editing reasonably large documents with good efficiency when
  the edits are contiguous or clustered, as is typical.

  Warning:
  Serialized objects of this class will not be compatible with
  future Swing releases. The current serialization support is
  appropriate for short term storage or RMI between applications running
  the same version of Swing.  As of 1.4, support for long term storage
  of all JavaBeans™
  has been added to the java.beans package.
  Please see XMLEncoder."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing.text PlainDocument]))

(defn ->plain-document
  "Constructor.

  Constructs a plain text document.  A default root element is created,
   and the tab size set to 8.

  c - the container for the content - `javax.swing.text.AbstractDocument.Content`"
  ([^javax.swing.text.AbstractDocument.Content c]
    (new PlainDocument c))
  ([]
    (new PlainDocument )))

(def *-tab-size-attribute
  "Static Constant.

  Name of the attribute that specifies the tab
   size for tabs contained in the content.  The
   type for the value is Integer.

  type: java.lang.String"
  PlainDocument/tabSizeAttribute)

(def *-line-limit-attribute
  "Static Constant.

  Name of the attribute that specifies the maximum
   length of a line, if there is a maximum length.
   The type for the value is Integer.

  type: java.lang.String"
  PlainDocument/lineLimitAttribute)

(defn insert-string
  "Inserts some content into the document.
   Inserting content causes a write lock to be held while the
   actual changes are taking place, followed by notification
   to the observers on the thread that grabbed the write lock.

   This method is thread safe, although most Swing methods
   are not. Please see
   Concurrency
   in Swing for more information.

  offs - the starting offset >= 0 - `int`
  str - the string to insert; does nothing with null/empty strings - `java.lang.String`
  a - the attributes for the inserted content - `javax.swing.text.AttributeSet`

  throws: javax.swing.text.BadLocationException - the given insert position is not a valid position within the document"
  ([^javax.swing.text.PlainDocument this ^Integer offs ^java.lang.String str ^javax.swing.text.AttributeSet a]
    (-> this (.insertString offs str a))))

(defn get-default-root-element
  "Gets the default root element for the document model.

  returns: the root - `javax.swing.text.Element`"
  (^javax.swing.text.Element [^javax.swing.text.PlainDocument this]
    (-> this (.getDefaultRootElement))))

(defn get-paragraph-element
  "Get the paragraph element containing the given position.  Since this
   document only models lines, it returns the line instead.

  pos - the starting offset >= 0 - `int`

  returns: the element - `javax.swing.text.Element`"
  (^javax.swing.text.Element [^javax.swing.text.PlainDocument this ^Integer pos]
    (-> this (.getParagraphElement pos))))

