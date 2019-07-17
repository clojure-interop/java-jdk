(ns javax.swing.undo.UndoableEditSupport
  "A support class used for managing UndoableEdit listeners."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing.undo UndoableEditSupport]))

(defn ->undoable-edit-support
  "Constructor.

  Constructs an UndoableEditSupport object.

  r - an Object - `java.lang.Object`"
  ([r]
    (new UndoableEditSupport r))
  ([]
    (new UndoableEditSupport )))

(defn add-undoable-edit-listener
  "Registers an UndoableEditListener.
   The listener is notified whenever an edit occurs which can be undone.

  l - an UndoableEditListener object - `javax.swing.event.UndoableEditListener`"
  ([this l]
    (-> this (.addUndoableEditListener l))))

(defn remove-undoable-edit-listener
  "Removes an UndoableEditListener.

  l - the UndoableEditListener object to be removed - `javax.swing.event.UndoableEditListener`"
  ([this l]
    (-> this (.removeUndoableEditListener l))))

(defn get-undoable-edit-listeners
  "Returns an array of all the UndoableEditListeners added
   to this UndoableEditSupport with addUndoableEditListener().

  returns: all of the UndoableEditListeners added or an empty
           array if no listeners have been added - `javax.swing.event.UndoableEditListener[]`"
  ([this]
    (-> this (.getUndoableEditListeners))))

(defn post-edit
  "DEADLOCK WARNING: Calling this method may call
   undoableEditHappened in all listeners.
   It is unwise to call this method from one of its listeners.

  e - `javax.swing.undo.UndoableEdit`"
  ([this e]
    (-> this (.postEdit e))))

(defn get-update-level
  "Returns the update level value.

  returns: an integer representing the update level - `int`"
  ([this]
    (-> this (.getUpdateLevel))))

(defn begin-update
  ""
  ([this]
    (-> this (.beginUpdate))))

(defn end-update
  "DEADLOCK WARNING: Calling this method may call
   undoableEditHappened in all listeners.
   It is unwise to call this method from one of its listeners."
  ([this]
    (-> this (.endUpdate))))

(defn to-string
  "Returns a string that displays and identifies this
   object's properties.

  returns: a String representation of this object - `java.lang.String`"
  ([this]
    (-> this (.toString))))

