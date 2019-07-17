(ns javax.swing.undo.AbstractUndoableEdit
  "An abstract implementation of UndoableEdit,
  implementing simple responses to all boolean methods in
  that interface."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing.undo AbstractUndoableEdit]))

(defn ->abstract-undoable-edit
  "Constructor.

  Creates an AbstractUndoableEdit which defaults
   hasBeenDone and alive to true."
  ([]
    (new AbstractUndoableEdit )))

(defn die
  "Sets alive to false. Note that this
   is a one way operation; dead edits cannot be resurrected.
   Sending undo or redo to
   a dead edit results in an exception being thrown.

   Typically an edit is killed when it is consolidated by
   another edit's addEdit or replaceEdit
   method, or when it is dequeued from an UndoManager."
  ([this]
    (-> this (.die))))

(defn redo
  "Throws CannotRedoException if canRedo
   returns false. Sets hasBeenDone to true.
   Subclasses should override to redo the operation represented by
   this edit. Override should begin with a call to super.

  throws: javax.swing.undo.CannotRedoException - if canRedo returns false"
  ([this]
    (-> this (.redo))))

(defn significant?
  "This default implementation returns true.

  returns: true - `boolean`"
  ([this]
    (-> this (.isSignificant))))

(defn add-edit
  "This default implementation returns false.

  an-edit - the edit to be added - `javax.swing.undo.UndoableEdit`

  returns: false - `boolean`"
  ([this an-edit]
    (-> this (.addEdit an-edit))))

(defn to-string
  "Returns a string that displays and identifies this
   object's properties.

  returns: a String representation of this object - `java.lang.String`"
  ([this]
    (-> this (.toString))))

(defn get-undo-presentation-name
  "Retreives the value from the defaults table with key
   AbstractUndoableEdit.undoText and returns
   that value followed by a space, followed by
   getPresentationName.
   If getPresentationName returns ``,
   then the defaults value is returned alone.

  returns: the value from the defaults table with key
      AbstractUndoableEdit.undoText, followed
      by a space, followed by getPresentationName
      unless getPresentationName is `` in which
      case, the defaults value is returned alone. - `java.lang.String`"
  ([this]
    (-> this (.getUndoPresentationName))))

(defn undo
  "Throws CannotUndoException if canUndo
   returns false. Sets hasBeenDone
   to false. Subclasses should override to undo the
   operation represented by this edit. Override should begin with
   a call to super.

  throws: javax.swing.undo.CannotUndoException - if canUndo returns false"
  ([this]
    (-> this (.undo))))

(defn can-redo?
  "Returns true if this edit is alive
   and hasBeenDone is false.

  returns: true if this edit is alive
     and hasBeenDone is false - `boolean`"
  ([this]
    (-> this (.canRedo))))

(defn get-presentation-name
  "This default implementation returns ``. Used by
   getUndoPresentationName and
   getRedoPresentationName to
   construct the strings they return. Subclasses should override to
   return an appropriate description of the operation this edit
   represents.

  returns: the empty string `` - `java.lang.String`"
  ([this]
    (-> this (.getPresentationName))))

(defn replace-edit
  "This default implementation returns false.

  an-edit - the edit to replace - `javax.swing.undo.UndoableEdit`

  returns: false - `boolean`"
  ([this an-edit]
    (-> this (.replaceEdit an-edit))))

(defn get-redo-presentation-name
  "Retreives the value from the defaults table with key
   AbstractUndoableEdit.redoText and returns
   that value followed by a space, followed by
   getPresentationName.
   If getPresentationName returns ``,
   then the defaults value is returned alone.

  returns: the value from the defaults table with key
      AbstractUndoableEdit.redoText, followed
      by a space, followed by getPresentationName
      unless getPresentationName is `` in which
      case, the defaults value is returned alone. - `java.lang.String`"
  ([this]
    (-> this (.getRedoPresentationName))))

(defn can-undo?
  "Returns true if this edit is alive
   and hasBeenDone is true.

  returns: true if this edit is alive
      and hasBeenDone is true - `boolean`"
  ([this]
    (-> this (.canUndo))))

