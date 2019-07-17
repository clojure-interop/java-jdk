(ns javax.swing.text.AbstractDocument
  "An implementation of the document interface to serve as a
  basis for implementing various kinds of documents.  At this
  level there is very little policy, so there is a corresponding
  increase in difficulty of use.

  This class implements a locking mechanism for the document.  It
  allows multiple readers or one writer, and writers must wait until
  all observers of the document have been notified of a previous
  change before beginning another mutation to the document.  The
  read lock is acquired and released using the render
  method.  A write lock is acquired by the methods that mutate the
  document, and are held for the duration of the method call.
  Notification is done on the thread that produced the mutation,
  and the thread has full read access to the document for the
  duration of the notification, but other readers are kept out
  until the notification has finished.  The notification is a
  beans event notification which does not allow any further
  mutations until all listeners have been notified.

  Any models subclassed from this class and used in conjunction
  with a text component that has a look and feel implementation
  that is derived from BasicTextUI may be safely updated
  asynchronously, because all access to the View hierarchy
  is serialized by BasicTextUI if the document is of type
  AbstractDocument.  The locking assumes that an
  independent thread will access the View hierarchy only from
  the DocumentListener methods, and that there will be only
  one event thread active at a time.

  If concurrency support is desired, there are the following
  additional implications.  The code path for any DocumentListener
  implementation and any UndoListener implementation must be threadsafe,
  and not access the component lock if trying to be safe from deadlocks.
  The repaint and revalidate methods
  on JComponent are safe.

  AbstractDocument models an implied break at the end of the document.
  Among other things this allows you to position the caret after the last
  character. As a result of this, getLength returns one less
  than the length of the Content. If you create your own Content, be
  sure and initialize it to have an additional character. Refer to
  StringContent and GapContent for examples of this. Another implication
  of this is that Elements that model the implied end character will have
  an endOffset == (getLength()  1). For example, in DefaultStyledDocument
  getParagraphElement(getLength()).getEndOffset() == getLength()  1
  .

  Warning:
  Serialized objects of this class will not be compatible with
  future Swing releases. The current serialization support is
  appropriate for short term storage or RMI between applications running
  the same version of Swing.  As of 1.4, support for long term storage
  of all JavaBeans™
  has been added to the java.beans package.
  Please see XMLEncoder."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing.text AbstractDocument]))

(def *-paragraph-element-name
  "Static Constant.

  Name of elements used to represent paragraphs

  type: java.lang.String"
  AbstractDocument/ParagraphElementName)

(def *-content-element-name
  "Static Constant.

  Name of elements used to represent content

  type: java.lang.String"
  AbstractDocument/ContentElementName)

(def *-section-element-name
  "Static Constant.

  Name of elements used to hold sections (lines/paragraphs).

  type: java.lang.String"
  AbstractDocument/SectionElementName)

(def *-bidi-element-name
  "Static Constant.

  Name of elements used to hold a unidirectional run

  type: java.lang.String"
  AbstractDocument/BidiElementName)

(def *-element-name-attribute
  "Static Constant.

  Name of the attribute used to specify element
   names.

  type: java.lang.String"
  AbstractDocument/ElementNameAttribute)

(defn set-document-filter
  "Sets the DocumentFilter. The DocumentFilter
   is passed insert and remove to conditionally
   allow inserting/deleting of the text.  A null value
   indicates that no filtering will occur.

  filter - the DocumentFilter used to constrain text - `javax.swing.text.DocumentFilter`"
  ([this filter]
    (-> this (.setDocumentFilter filter))))

(defn get-document-properties
  "Supports managing a set of properties. Callers
   can use the documentProperties dictionary
   to annotate the document with document-wide properties.

  returns: a non-null Dictionary - `java.util.Dictionary<java.lang.Object,java.lang.Object>`"
  ([this]
    (-> this (.getDocumentProperties))))

(defn add-undoable-edit-listener
  "Adds an undo listener for notification of any changes.
   Undo/Redo operations performed on the UndoableEdit
   will cause the appropriate DocumentEvent to be fired to keep
   the view(s) in sync with the model.

  listener - the UndoableEditListener to add - `javax.swing.event.UndoableEditListener`"
  ([this listener]
    (-> this (.addUndoableEditListener listener))))

(defn remove-undoable-edit-listener
  "Removes an undo listener.

  listener - the UndoableEditListener to remove - `javax.swing.event.UndoableEditListener`"
  ([this listener]
    (-> this (.removeUndoableEditListener listener))))

(defn read-unlock
  "Does a read unlock.  This signals that one
   of the readers is done.  If there are no more readers
   then writing can begin again.  This should be balanced
   with a readLock, and should occur in a finally statement
   so that the balance is guaranteed.  The following is an
   example.


       readLock();
       try {
           // do something
       } finally {
           readUnlock();
       }"
  ([this]
    (-> this (.readUnlock))))

(defn get-text
  "Fetches the text contained within the given portion
   of the document.

   If the partialReturn property on the txt parameter is false, the
   data returned in the Segment will be the entire length requested and
   may or may not be a copy depending upon how the data was stored.
   If the partialReturn property is true, only the amount of text that
   can be returned without creating a copy is returned.  Using partial
   returns will give better performance for situations where large
   parts of the document are being scanned.  The following is an example
   of using the partial return to access the entire document:



     int nleft = doc.getDocumentLength();
     Segment text = new Segment();
     int offs = 0;
     text.setPartialReturn(true);
     while (nleft > 0) {
         doc.getText(offs, nleft, text);
         // do something with text
         nleft -= text.count;
         offs = text.count;
     }

  offset - the starting offset >= 0 - `int`
  length - the number of characters to retrieve >= 0 - `int`
  txt - the Segment object to retrieve the text into - `javax.swing.text.Segment`

  throws: javax.swing.text.BadLocationException - the range given includes a position that is not a valid position within the document"
  ([this offset length txt]
    (-> this (.getText offset length txt)))
  ([this offset length]
    (-> this (.getText offset length))))

(defn remove-document-listener
  "Removes a document listener.

  listener - the DocumentListener to remove - `javax.swing.event.DocumentListener`"
  ([this listener]
    (-> this (.removeDocumentListener listener))))

(defn get-document-filter
  "Returns the DocumentFilter that is responsible for
   filtering of insertion/removal. A null return value
   implies no filtering is to occur.

  returns: the DocumentFilter - `javax.swing.text.DocumentFilter`"
  ([this]
    (-> this (.getDocumentFilter))))

(defn get-root-elements
  "Gets all root elements defined.  Typically, there
   will only be one so the default implementation
   is to return the default root element.

  returns: the root element - `javax.swing.text.Element[]`"
  ([this]
    (-> this (.getRootElements))))

(defn replace
  "Deletes the region of text from offset to
   offset  length, and replaces it with text.
   It is up to the implementation as to how this is implemented, some
   implementations may treat this as two distinct operations: a remove
   followed by an insert, others may treat the replace as one atomic
   operation.

  offset - index of child element - `int`
  length - length of text to delete, may be 0 indicating don't delete anything - `int`
  text - text to insert, null indicates no text to insert - `java.lang.String`
  attrs - AttributeSet indicating attributes of inserted text, null is legal, and typically treated as an empty attributeset, but exact interpretation is left to the subclass - `javax.swing.text.AttributeSet`

  throws: javax.swing.text.BadLocationException - the given position is not a valid position within the document"
  ([this offset length text attrs]
    (-> this (.replace offset length text attrs))))

(defn remove
  "Removes some content from the document.
   Removing content causes a write lock to be held while the
   actual changes are taking place.  Observers are notified
   of the change on the thread that called this method.

   This method is thread safe, although most Swing methods
   are not. Please see
   Concurrency
   in Swing for more information.

  offs - the starting offset >= 0 - `int`
  len - the number of characters to remove >= 0 - `int`

  throws: javax.swing.text.BadLocationException - the given remove position is not a valid position within the document"
  ([this offs len]
    (-> this (.remove offs len))))

(defn get-undoable-edit-listeners
  "Returns an array of all the undoable edit listeners
   registered on this document.

  returns: all of this document's UndoableEditListeners
           or an empty array if no undoable edit listeners are
           currently registered - `javax.swing.event.UndoableEditListener[]`"
  ([this]
    (-> this (.getUndoableEditListeners))))

(defn set-document-properties
  "Replaces the document properties dictionary for this document.

  x - the new dictionary - `java.util.Dictionary<java.lang.Object,java.lang.Object>`"
  ([this x]
    (-> this (.setDocumentProperties x))))

(defn dump
  "Gives a diagnostic dump.

  out - the output stream - `java.io.PrintStream`"
  ([this out]
    (-> this (.dump out))))

(defn get-start-position
  "Returns a position that represents the start of the document.  The
   position returned can be counted on to track change and stay
   located at the beginning of the document.

  returns: the position - `javax.swing.text.Position`"
  ([this]
    (-> this (.getStartPosition))))

(defn get-length
  "Returns the length of the data.  This is the number of
   characters of content that represents the users data.

  returns: the length >= 0 - `int`"
  ([this]
    (-> this (.getLength))))

(defn get-property
  "A convenience method for looking up a property value. It is
   equivalent to:


   getDocumentProperties().get(key);

  key - the non-null property key - `java.lang.Object`

  returns: the value of this property or null - `java.lang.Object`"
  ([this key]
    (-> this (.getProperty key))))

(defn render
  "This allows the model to be safely rendered in the presence
   of currency, if the model supports being updated asynchronously.
   The given runnable will be executed in a way that allows it
   to safely read the model with no changes while the runnable
   is being executed.  The runnable itself may not
   make any mutations.

   This is implemented to acquire a read lock for the duration
   of the runnables execution.  There may be multiple runnables
   executing at the same time, and all writers will be blocked
   while there are active rendering runnables.  If the runnable
   throws an exception, its lock will be safely released.
   There is no protection against a runnable that never exits,
   which will effectively leave the document locked for it's
   lifetime.

   If the given runnable attempts to make any mutations in
   this implementation, a deadlock will occur.  There is
   no tracking of individual rendering threads to enable
   detecting this situation, but a subclass could incur
   the overhead of tracking them and throwing an error.

   This method is thread safe, although most Swing methods
   are not. Please see
   Concurrency
   in Swing for more information.

  r - the renderer to execute - `java.lang.Runnable`"
  ([this r]
    (-> this (.render r))))

(defn get-bidi-root-element
  "Returns the root element of the bidirectional structure for this
   document.  Its children represent character runs with a given
   Unicode bidi level.

  returns: `javax.swing.text.Element`"
  ([this]
    (-> this (.getBidiRootElement))))

(defn put-property
  "A convenience method for storing up a property value.  It is
   equivalent to:


   getDocumentProperties().put(key, value);
   If value is null this method will
   remove the property.

  key - the non-null key - `java.lang.Object`
  value - the property value - `java.lang.Object`"
  ([this key value]
    (-> this (.putProperty key value))))

(defn add-document-listener
  "Adds a document listener for notification of any changes.

  listener - the DocumentListener to add - `javax.swing.event.DocumentListener`"
  ([this listener]
    (-> this (.addDocumentListener listener))))

(defn get-listeners
  "Returns an array of all the objects currently registered
   as FooListeners
   upon this document.
   FooListeners are registered using the
   addFooListener method.


   You can specify the listenerType argument
   with a class literal, such as
   FooListener.class.
   For example, you can query a
   document d
   for its document listeners with the following code:



  DocumentListener[] mls = (DocumentListener[])(d.getListeners(DocumentListener.class));

   If no such listeners exist, this method returns an empty array.

  listener-type - the type of listeners requested; this parameter should specify an interface that descends from java.util.EventListener - `java.lang.Class<T>`

  returns: an array of all objects registered as
            FooListeners on this component,
            or an empty array if no such
            listeners have been added - `<T extends java.util.EventListener> T[]`

  throws: java.lang.ClassCastException - if listenerType doesn't specify a class or interface that implements java.util.EventListener"
  ([this listener-type]
    (-> this (.getListeners listener-type))))

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
  ([this offs str a]
    (-> this (.insertString offs str a))))

(defn get-end-position
  "Returns a position that represents the end of the document.  The
   position returned can be counted on to track change and stay
   located at the end of the document.

  returns: the position - `javax.swing.text.Position`"
  ([this]
    (-> this (.getEndPosition))))

(defn read-lock
  "Acquires a lock to begin reading some state from the
   document.  There can be multiple readers at the same time.
   Writing blocks the readers until notification of the change
   to the listeners has been completed.  This method should
   be used very carefully to avoid unintended compromise
   of the document.  It should always be balanced with a
   readUnlock."
  ([this]
    (-> this (.readLock))))

(defn get-default-root-element
  "Returns the root element that views should be based upon
   unless some other mechanism for assigning views to element
   structures is provided.

  returns: the root element - `javax.swing.text.Element`"
  ([this]
    (-> this (.getDefaultRootElement))))

(defn get-asynchronous-load-priority
  "Gets the asynchronous loading priority.  If less than zero,
   the document should not be loaded asynchronously.

  returns: the asynchronous loading priority, or -1
     if the document should not be loaded asynchronously - `int`"
  ([this]
    (-> this (.getAsynchronousLoadPriority))))

(defn set-asynchronous-load-priority
  "Sets the asynchronous loading priority.

  p - the new asynchronous loading priority; a value less than zero indicates that the document should not be loaded asynchronously - `int`"
  ([this p]
    (-> this (.setAsynchronousLoadPriority p))))

(defn get-paragraph-element
  "Get the paragraph element containing the given position.  Sub-classes
   must define for themselves what exactly constitutes a paragraph.  They
   should keep in mind however that a paragraph should at least be the
   unit of text over which to run the Unicode bidirectional algorithm.

  pos - the starting offset >= 0 - `int`

  returns: the element - `javax.swing.text.Element`"
  ([this pos]
    (-> this (.getParagraphElement pos))))

(defn get-document-listeners
  "Returns an array of all the document listeners
   registered on this document.

  returns: all of this document's DocumentListeners
           or an empty array if no document listeners are
           currently registered - `javax.swing.event.DocumentListener[]`"
  ([this]
    (-> this (.getDocumentListeners))))

(defn create-position
  "Returns a position that will track change as the document
   is altered.

   This method is thread safe, although most Swing methods
   are not. Please see
   Concurrency
   in Swing for more information.

  offs - the position in the model >= 0 - `int`

  returns: the position - `javax.swing.text.Position`

  throws: javax.swing.text.BadLocationException - if the given position does not represent a valid location in the associated document"
  ([this offs]
    (-> this (.createPosition offs))))

