(ns javax.swing.undo.UndoManager
  "UndoManager manages a list of UndoableEdits,
  providing a way to undo or redo the appropriate edits.  There are
  two ways to add edits to an UndoManager.  Add the edit
  directly using the addEdit method, or add the
  UndoManager to a bean that supports
  UndoableEditListener.  The following examples creates
  an UndoManager and adds it as an
  UndoableEditListener to a JTextField:


    UndoManager undoManager = new UndoManager();
    JTextField tf = ...;
    tf.getDocument().addUndoableEditListener(undoManager);

  UndoManager maintains an ordered list of edits and the
  index of the next edit in that list. The index of the next edit is
  either the size of the current list of edits, or if
  undo has been invoked it corresponds to the index
  of the last significant edit that was undone. When
  undo is invoked all edits from the index of the next
  edit to the last significant edit are undone, in reverse order.
  For example, consider an UndoManager consisting of the
  following edits: A b c D.  Edits with a
  upper-case letter in bold are significant, those in lower-case
  and italicized are insignificant.





  Figure 1


  As shown in figure 1, if D was just added, the
  index of the next edit will be 4. Invoking undo
  results in invoking undo on D and setting the
  index of the next edit to 3 (edit c), as shown in the following
  figure.





  Figure 2


  The last significant edit is A, so that invoking
  undo again invokes undo on c,
  b, and A, in that order, setting the index of the
  next edit to 0, as shown in the following figure.





  Figure 3


  Invoking redo results in invoking redo on
  all edits between the index of the next edit and the next
  significant edit (or the end of the list).  Continuing with the previous
  example if redo were invoked, redo would in
  turn be invoked on A, b and c.  In addition
  the index of the next edit is set to 3 (as shown in figure 2).

  Adding an edit to an UndoManager results in
  removing all edits from the index of the next edit to the end of
  the list.  Continuing with the previous example, if a new edit,
  e, is added the edit D is removed from the list
  (after having die invoked on it).  If c is not
  incorporated by the next edit
  (c.addEdit(e) returns true), or replaced
  by it (e.replaceEdit(c) returns true),
  the new edit is added after c, as shown in the following
  figure.





  Figure 4


  Once end has been invoked on an UndoManager
  the superclass behavior is used for all UndoableEdit
  methods.  Refer to CompoundEdit for more details on its
  behavior.

  Unlike the rest of Swing, this class is thread safe.

  Warning:
  Serialized objects of this class will not be compatible with
  future Swing releases. The current serialization support is
  appropriate for short term storage or RMI between applications running
  the same version of Swing.  As of 1.4, support for long term storage
  of all JavaBeans™
  has been added to the java.beans package.
  Please see XMLEncoder."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing.undo UndoManager]))

(defn ->undo-manager
  "Constructor.

  Creates a new UndoManager."
  ([]
    (new UndoManager )))

(defn undo-or-redo
  "Convenience method that invokes one of undo or
   redo. If any edits have been undone (the index of
   the next edit is less than the length of the edits list) this
   invokes redo, otherwise it invokes undo.

  throws: javax.swing.undo.CannotUndoException - if one of the edits throws CannotUndoException"
  ([^javax.swing.undo.UndoManager this]
    (-> this (.undoOrRedo))))

(defn redo
  "Redoes the appropriate edits.  If end has been
   invoked this calls through to the superclass.  Otherwise
   this invokes redo on all edits between the
   index of the next edit and the next significant edit, updating
   the index of the next edit appropriately.

  throws: javax.swing.undo.CannotRedoException - if one of the edits throws CannotRedoException or there are no edits to be redone"
  ([^javax.swing.undo.UndoManager this]
    (-> this (.redo))))

(defn discard-all-edits
  "Empties the undo manager sending each edit a die message
   in the process."
  ([^javax.swing.undo.UndoManager this]
    (-> this (.discardAllEdits))))

(defn undoable-edit-happened
  "An UndoableEditListener method. This invokes
   addEdit with e.getEdit().

  e - the UndoableEditEvent the UndoableEditEvent will be added from - `javax.swing.event.UndoableEditEvent`"
  ([^javax.swing.undo.UndoManager this ^javax.swing.event.UndoableEditEvent e]
    (-> this (.undoableEditHappened e))))

(defn add-edit
  "Adds an UndoableEdit to this
   UndoManager, if it's possible.  This removes all
   edits from the index of the next edit to the end of the edits
   list.  If end has been invoked the edit is not added
   and false is returned.  If end hasn't
   been invoked this returns true.

  an-edit - the edit to be added - `javax.swing.undo.UndoableEdit`

  returns: true if anEdit can be incorporated into this
                edit - `boolean`"
  ([^javax.swing.undo.UndoManager this ^javax.swing.undo.UndoableEdit an-edit]
    (-> this (.addEdit an-edit))))

(defn get-undo-or-redo-presentation-name
  "Convenience method that returns either
   getUndoPresentationName or
   getRedoPresentationName.  If the index of the next
   edit equals the size of the edits list,
   getUndoPresentationName is returned, otherwise
   getRedoPresentationName is returned.

  returns: undo or redo name - `java.lang.String`"
  ([^javax.swing.undo.UndoManager this]
    (-> this (.getUndoOrRedoPresentationName))))

(defn to-string
  "Returns a string that displays and identifies this
   object's properties.

  returns: a String representation of this object - `java.lang.String`"
  ([^javax.swing.undo.UndoManager this]
    (-> this (.toString))))

(defn get-undo-presentation-name
  "Returns a description of the undoable form of this edit.
   If end has been invoked this calls into super.
   Otherwise if there are edits to be undone, this returns
   the value from the next significant edit that will be undone.
   If there are no edits to be undone and end has not
   been invoked this returns the value from the UIManager
   property `AbstractUndoableEdit.undoText`.

  returns: a description of the undoable form of this edit - `java.lang.String`"
  ([^javax.swing.undo.UndoManager this]
    (-> this (.getUndoPresentationName))))

(defn undo
  "Undoes the appropriate edits.  If end has been
   invoked this calls through to the superclass, otherwise
   this invokes undo on all edits between the
   index of the next edit and the last significant edit, updating
   the index of the next edit appropriately.

  throws: javax.swing.undo.CannotUndoException - if one of the edits throws CannotUndoException or there are no edits to be undone"
  ([^javax.swing.undo.UndoManager this]
    (-> this (.undo))))

(defn can-redo?
  "Returns true if edits may be redone.  If end has
   been invoked, this returns the value from super.  Otherwise,
   this returns true if there are any edits to be redone
   (editToBeRedone returns non-null).

  returns: true if there are edits to be redone - `boolean`"
  ([^javax.swing.undo.UndoManager this]
    (-> this (.canRedo))))

(defn set-limit
  "Sets the maximum number of edits this UndoManager
   holds. A value less than 0 indicates the number of edits is not
   limited. If edits need to be discarded to shrink the limit,
   die will be invoked on them in the reverse
   order they were added.  The default is 100.

  l - the new limit - `int`

  throws: java.lang.RuntimeException - if this UndoManager is not in progress (end has been invoked)"
  ([^javax.swing.undo.UndoManager this ^Integer l]
    (-> this (.setLimit l))))

(defn get-limit
  "Returns the maximum number of edits this UndoManager
   holds. A value less than 0 indicates the number of edits is not
   limited.

  returns: the maximum number of edits this UndoManager holds - `int`"
  ([^javax.swing.undo.UndoManager this]
    (-> this (.getLimit))))

(defn can-undo-or-redo?
  "Returns true if it is possible to invoke undo or
   redo.

  returns: true if invoking canUndoOrRedo is valid - `boolean`"
  ([^javax.swing.undo.UndoManager this]
    (-> this (.canUndoOrRedo))))

(defn end
  "Turns this UndoManager into a normal
   CompoundEdit.  This removes all edits that have
   been undone."
  ([^javax.swing.undo.UndoManager this]
    (-> this (.end))))

(defn get-redo-presentation-name
  "Returns a description of the redoable form of this edit.
   If end has been invoked this calls into super.
   Otherwise if there are edits to be redone, this returns
   the value from the next significant edit that will be redone.
   If there are no edits to be redone and end has not
   been invoked this returns the value from the UIManager
   property `AbstractUndoableEdit.redoText`.

  returns: a description of the redoable form of this edit - `java.lang.String`"
  ([^javax.swing.undo.UndoManager this]
    (-> this (.getRedoPresentationName))))

(defn can-undo?
  "Returns true if edits may be undone.  If end has
   been invoked, this returns the value from super.  Otherwise
   this returns true if there are any edits to be undone
   (editToBeUndone returns non-null).

  returns: true if there are edits to be undone - `boolean`"
  ([^javax.swing.undo.UndoManager this]
    (-> this (.canUndo))))

