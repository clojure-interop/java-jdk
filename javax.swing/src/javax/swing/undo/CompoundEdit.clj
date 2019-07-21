(ns javax.swing.undo.CompoundEdit
  "A concrete subclass of AbstractUndoableEdit, used to assemble little
  UndoableEdits into great big ones."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing.undo CompoundEdit]))

(defn ->compound-edit
  "Constructor."
  (^CompoundEdit []
    (new CompoundEdit )))

(defn die
  "Sends die to each subedit,
   in the reverse of the order that they were added."
  ([^CompoundEdit this]
    (-> this (.die))))

(defn redo
  "Sends redo to all contained
   UndoableEdits in the order in
   which they were added.

  throws: javax.swing.undo.CannotRedoException - if canRedo returns false"
  ([^CompoundEdit this]
    (-> this (.redo))))

(defn significant?
  "Returns true if any of the UndoableEdits
   in edits do.
   Returns false if they all return false.

  returns: true - `boolean`"
  (^Boolean [^CompoundEdit this]
    (-> this (.isSignificant))))

(defn add-edit
  "If this edit is inProgress,
   accepts anEdit and returns true.

   The last edit added to this CompoundEdit
   is given a chance to addEdit(anEdit).
   If it refuses (returns false), anEdit is
   given a chance to replaceEdit the last edit.
   If anEdit returns false here,
   it is added to edits.

  an-edit - the edit to be added - `javax.swing.undo.UndoableEdit`

  returns: true if the edit is inProgress;
    otherwise returns false - `boolean`"
  (^Boolean [^CompoundEdit this ^javax.swing.undo.UndoableEdit an-edit]
    (-> this (.addEdit an-edit))))

(defn to-string
  "Returns a string that displays and identifies this
   object's properties.

  returns: a String representation of this object - `java.lang.String`"
  (^java.lang.String [^CompoundEdit this]
    (-> this (.toString))))

(defn get-undo-presentation-name
  "Returns getUndoPresentationName
   from the last UndoableEdit
   added to edits.
   If edits is empty, calls super.

  returns: the value from the defaults table with key
      AbstractUndoableEdit.undoText, followed
      by a space, followed by getPresentationName
      unless getPresentationName is \"\" in which
      case, the defaults value is returned alone. - `java.lang.String`"
  (^java.lang.String [^CompoundEdit this]
    (-> this (.getUndoPresentationName))))

(defn undo
  "Sends undo to all contained
   UndoableEdits in the reverse of
   the order in which they were added.

  throws: javax.swing.undo.CannotUndoException - if canUndo returns false"
  ([^CompoundEdit this]
    (-> this (.undo))))

(defn in-progress?
  "Returns true if this edit is in progress--that is, it has not
   received end. This generally means that edits are still being
   added to it.

  returns: `boolean`"
  (^Boolean [^CompoundEdit this]
    (-> this (.isInProgress))))

(defn can-redo?
  "Returns false if isInProgress or if super
   returns false.

  returns: true if this edit is alive
     and hasBeenDone is false - `boolean`"
  (^Boolean [^CompoundEdit this]
    (-> this (.canRedo))))

(defn get-presentation-name
  "Returns getPresentationName from the
   last UndoableEdit added to
   edits. If edits is empty,
   calls super.

  returns: the empty string \"\" - `java.lang.String`"
  (^java.lang.String [^CompoundEdit this]
    (-> this (.getPresentationName))))

(defn end
  "Sets inProgress to false."
  ([^CompoundEdit this]
    (-> this (.end))))

(defn get-redo-presentation-name
  "Returns getRedoPresentationName
   from the last UndoableEdit
   added to edits.
   If edits is empty, calls super.

  returns: the value from the defaults table with key
      AbstractUndoableEdit.redoText, followed
      by a space, followed by getPresentationName
      unless getPresentationName is \"\" in which
      case, the defaults value is returned alone. - `java.lang.String`"
  (^java.lang.String [^CompoundEdit this]
    (-> this (.getRedoPresentationName))))

(defn can-undo?
  "Returns false if isInProgress or if super
   returns false.

  returns: true if this edit is alive
      and hasBeenDone is true - `boolean`"
  (^Boolean [^CompoundEdit this]
    (-> this (.canUndo))))

