(ns javax.swing.text.Document
  " The Document is a container for text that serves
  as the model for swing text components.  The goal for this
  interface is to scale from very simple needs (a plain text textfield)
  to complex needs (an HTML or XML document, for example).

  Content

  At the simplest level, text can be
  modeled as a linear sequence of characters. To support
  internationalization, the Swing text model uses
  unicode characters.
  The sequence of characters displayed in a text component is
  generally referred to as the component's content.

  To refer to locations within the sequence, the coordinates
  used are the location between two characters.  As the diagram
  below shows, a location in a text document can be referred to
  as a position, or an offset. This position is zero-based.


  In the example, if the content of a document is the
  sequence `The quick brown fox,` as shown in the preceding diagram,
  the location just before the word `The` is 0, and the location after
  the word `The` and before the whitespace that follows it is 3.
  The entire sequence of characters in the sequence `The` is called a
  range.
  The following methods give access to the character data
  that makes up the content.

  getLength()
  getText(int, int)
  getText(int, int, javax.swing.text.Segment)

  Structure

  Text is rarely represented simply as featureless content. Rather,
  text typically has some sort of structure associated with it.
  Exactly what structure is modeled is up to a particular Document
  implementation.  It might be as simple as no structure (i.e. a
  simple text field), or it might be something like diagram below.


  The unit of structure (i.e. a node of the tree) is referred to
  by the Element interface.  Each Element
  can be tagged with a set of attributes.  These attributes
  (name/value pairs) are defined by the
  AttributeSet interface.
  The following methods give access to the document structure.

  getDefaultRootElement()
  getRootElements()


  Mutations

  All documents need to be able to add and remove simple text.
  Typically, text is inserted and removed via gestures from
  a keyboard or a mouse.  What effect the insertion or removal
  has upon the document structure is entirely up to the
  implementation of the document.
  The following methods are related to mutation of the
  document content:

  insertString(int, java.lang.String, javax.swing.text.AttributeSet)
  remove(int, int)
  createPosition(int)


  Notification

  Mutations to the Document must be communicated to
  interested observers.  The notification of change follows the event model
  guidelines that are specified for JavaBeans.  In the JavaBeans
  event model, once an event notification is dispatched, all listeners
  must be notified before any further mutations occur to the source
  of the event.  Further, order of delivery is not guaranteed.

  Notification is provided as two separate events,
  DocumentEvent, and
  UndoableEditEvent.
  If a mutation is made to a Document through its api,
  a DocumentEvent will be sent to all of the registered
  DocumentListeners.  If the Document
  implementation supports undo/redo capabilities, an
  UndoableEditEvent will be sent
  to all of the registered UndoableEditListeners.
  If an undoable edit is undone, a DocumentEvent should be
  fired from the Document to indicate it has changed again.
  In this case however, there should be no UndoableEditEvent
  generated since that edit is actually the source of the change
  rather than a mutation to the Document made through its
  api.


  Referring to the above diagram, suppose that the component shown
  on the left mutates the document object represented by the blue
  rectangle. The document responds by dispatching a DocumentEvent to
  both component views and sends an UndoableEditEvent to the listening
  logic, which maintains a history buffer.

  Now suppose that the component shown on the right mutates the same
  document.  Again, the document dispatches a DocumentEvent to both
  component views and sends an UndoableEditEvent to the listening logic
  that is maintaining the history buffer.

  If the history buffer is then rolled back (i.e. the last UndoableEdit
  undone), a DocumentEvent is sent to both views, causing both of them to
  reflect the undone mutation to the document (that is, the
  removal of the right component's mutation). If the history buffer again
  rolls back another change, another DocumentEvent is sent to both views,
  causing them to reflect the undone mutation to the document -- that is,
  the removal of the left component's mutation.

  The methods related to observing mutations to the document are:

  addDocumentListener(DocumentListener)
  removeDocumentListener(DocumentListener)
  addUndoableEditListener(UndoableEditListener)
  removeUndoableEditListener(UndoableEditListener)


  Properties

  Document implementations will generally have some set of properties
  associated with them at runtime.  Two well known properties are the
  StreamDescriptionProperty,
  which can be used to describe where the Document came from,
  and the TitleProperty, which can be used to
  name the Document.  The methods related to the properties are:

  getProperty(java.lang.Object)
  putProperty(java.lang.Object, java.lang.Object)


  For more information on the Document class, see
  The Swing Connection
  and most particularly the article,

  The Element Interface."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing.text Document]))

(defn add-undoable-edit-listener
  "Registers the given observer to begin receiving notifications
   when undoable edits are made to the document.

  listener - the observer to register - `javax.swing.event.UndoableEditListener`"
  ([^Document this ^javax.swing.event.UndoableEditListener listener]
    (-> this (.addUndoableEditListener listener))))

(defn remove-undoable-edit-listener
  "Unregisters the given observer from the notification list
   so it will no longer receive updates.

  listener - the observer to register - `javax.swing.event.UndoableEditListener`"
  ([^Document this ^javax.swing.event.UndoableEditListener listener]
    (-> this (.removeUndoableEditListener listener))))

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
         // do someting with text
         nleft -= text.count;
         offs = text.count;
     }

  offset - the offset into the document representing the desired start of the text >= 0 - `int`
  length - the length of the desired string >= 0 - `int`
  txt - the Segment object to return the text in - `javax.swing.text.Segment`

  throws: javax.swing.text.BadLocationException - Some portion of the given range was not a valid part of the document. The location in the exception is the first bad position encountered."
  ([^Document this ^Integer offset ^Integer length ^javax.swing.text.Segment txt]
    (-> this (.getText offset length txt)))
  (^java.lang.String [^Document this ^Integer offset ^Integer length]
    (-> this (.getText offset length))))

(defn remove-document-listener
  "Unregisters the given observer from the notification list
   so it will no longer receive change updates.

  listener - the observer to register - `javax.swing.event.DocumentListener`"
  ([^Document this ^javax.swing.event.DocumentListener listener]
    (-> this (.removeDocumentListener listener))))

(defn get-root-elements
  "Returns all of the root elements that are defined.

   Typically there will be only one document structure, but the interface
   supports building an arbitrary number of structural projections over the
   text data. The document can have multiple root elements to support
   multiple document structures.  Some examples might be:


   Text direction.
   Lexical token streams.
   Parse trees.
   Conversions to formats other than the native format.
   Modification specifications.
   Annotations.

  returns: the root element - `javax.swing.text.Element[]`"
  ([^Document this]
    (-> this (.getRootElements))))

(defn remove
  "Removes a portion of the content of the document.
   This will cause a DocumentEvent of type
   DocumentEvent.EventType.REMOVE to be sent to the
   registered DocumentListeners, unless an exception
   is thrown.  The notification will be sent to the
   listeners by calling the removeUpdate method on the
   DocumentListeners.

   To ensure reasonable behavior in the face
   of concurrency, the event is dispatched after the
   mutation has occurred. This means that by the time a
   notification of removal is dispatched, the document
   has already been updated and any marks created by
   createPosition have already changed.
   For a removal, the end of the removal range is collapsed
   down to the start of the range, and any marks in the removal
   range are collapsed down to the start of the range.


   If the Document structure changed as result of the removal,
   the details of what Elements were inserted and removed in
   response to the change will also be contained in the generated
   DocumentEvent. It is up to the implementation of a Document
   to decide how the structure should change in response to a
   remove.

   If the Document supports undo/redo, an UndoableEditEvent will
   also be generated.

  offs - the offset from the beginning >= 0 - `int`
  len - the number of characters to remove >= 0 - `int`

  throws: javax.swing.text.BadLocationException - some portion of the removal range was not a valid part of the document. The location in the exception is the first bad position encountered."
  ([^Document this ^Integer offs ^Integer len]
    (-> this (.remove offs len))))

(defn get-start-position
  "Returns a position that represents the start of the document.  The
   position returned can be counted on to track change and stay
   located at the beginning of the document.

  returns: the position - `javax.swing.text.Position`"
  (^javax.swing.text.Position [^Document this]
    (-> this (.getStartPosition))))

(defn get-length
  "Returns number of characters of content currently
   in the document.

  returns: number of characters >= 0 - `int`"
  (^Integer [^Document this]
    (-> this (.getLength))))

(defn get-property
  "Gets the properties associated with the document.

  key - a non-null property key - `java.lang.Object`

  returns: the properties - `java.lang.Object`"
  (^java.lang.Object [^Document this ^java.lang.Object key]
    (-> this (.getProperty key))))

(defn render
  "Allows the model to be safely rendered in the presence
   of concurrency, if the model supports being updated asynchronously.
   The given runnable will be executed in a way that allows it
   to safely read the model with no changes while the runnable
   is being executed.  The runnable itself may not
   make any mutations.

  r - a Runnable used to render the model - `java.lang.Runnable`"
  ([^Document this ^java.lang.Runnable r]
    (-> this (.render r))))

(defn put-property
  "Associates a property with the document.  Two standard
   property keys provided are:
   StreamDescriptionProperty and
   TitleProperty.
   Other properties, such as author, may also be defined.

  key - the non-null property key - `java.lang.Object`
  value - the property value - `java.lang.Object`"
  ([^Document this ^java.lang.Object key ^java.lang.Object value]
    (-> this (.putProperty key value))))

(defn add-document-listener
  "Registers the given observer to begin receiving notifications
   when changes are made to the document.

  listener - the observer to register - `javax.swing.event.DocumentListener`"
  ([^Document this ^javax.swing.event.DocumentListener listener]
    (-> this (.addDocumentListener listener))))

(defn insert-string
  "Inserts a string of content.  This will cause a DocumentEvent
   of type DocumentEvent.EventType.INSERT to be sent to the
   registered DocumentListers, unless an exception is thrown.
   The DocumentEvent will be delivered by calling the
   insertUpdate method on the DocumentListener.
   The offset and length of the generated DocumentEvent
   will indicate what change was actually made to the Document.


   If the Document structure changed as result of the insertion,
   the details of what Elements were inserted and removed in
   response to the change will also be contained in the generated
   DocumentEvent.  It is up to the implementation of a Document
   to decide how the structure should change in response to an
   insertion.

   If the Document supports undo/redo, an UndoableEditEvent will
   also be generated.

  offset - the offset into the document to insert the content >= 0. All positions that track change at or after the given location will move. - `int`
  str - the string to insert - `java.lang.String`
  a - the attributes to associate with the inserted content. This may be null if there are no attributes. - `javax.swing.text.AttributeSet`

  throws: javax.swing.text.BadLocationException - the given insert position is not a valid position within the document"
  ([^Document this ^Integer offset ^java.lang.String str ^javax.swing.text.AttributeSet a]
    (-> this (.insertString offset str a))))

(defn get-end-position
  "Returns a position that represents the end of the document.  The
   position returned can be counted on to track change and stay
   located at the end of the document.

  returns: the position - `javax.swing.text.Position`"
  (^javax.swing.text.Position [^Document this]
    (-> this (.getEndPosition))))

(defn get-default-root-element
  "Returns the root element that views should be based upon,
   unless some other mechanism for assigning views to element
   structures is provided.

  returns: the root element - `javax.swing.text.Element`"
  (^javax.swing.text.Element [^Document this]
    (-> this (.getDefaultRootElement))))

(defn create-position
  "This method allows an application to mark a place in
   a sequence of character content. This mark can then be
   used to tracks change as insertions and removals are made
   in the content. The policy is that insertions always
   occur prior to the current position (the most common case)
   unless the insertion location is zero, in which case the
   insertion is forced to a position that follows the
   original position.

  offs - the offset from the start of the document >= 0 - `int`

  returns: the position - `javax.swing.text.Position`

  throws: javax.swing.text.BadLocationException - if the given position does not represent a valid location in the associated document"
  (^javax.swing.text.Position [^Document this ^Integer offs]
    (-> this (.createPosition offs))))

