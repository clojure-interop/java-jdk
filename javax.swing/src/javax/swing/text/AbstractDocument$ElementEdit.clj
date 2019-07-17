(ns javax.swing.text.AbstractDocument$ElementEdit
  "An implementation of ElementChange that can be added to the document
  event."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing.text AbstractDocument$ElementEdit]))

(defn ->element-edit
  "Constructor.

  Constructs an edit record.  This does not modify the element
   so it can safely be used to catch up a view to the
   current model state for views that just attached to a model.

  e - the element - `javax.swing.text.Element`
  index - the index into the model >= 0 - `int`
  removed - a set of elements that were removed - `javax.swing.text.Element[]`
  added - a set of elements that were added - `javax.swing.text.Element[]`"
  ([^javax.swing.text.Element e ^Integer index removed added]
    (new AbstractDocument$ElementEdit e index removed added)))

(defn get-element
  "Returns the underlying element.

  returns: the element - `javax.swing.text.Element`"
  (^javax.swing.text.Element [^javax.swing.text.AbstractDocument$ElementEdit this]
    (-> this (.getElement))))

(defn get-index
  "Returns the index into the list of elements.

  returns: the index >= 0 - `int`"
  (^Integer [^javax.swing.text.AbstractDocument$ElementEdit this]
    (-> this (.getIndex))))

(defn get-children-removed
  "Gets a list of children that were removed.

  returns: the list - `javax.swing.text.Element[]`"
  ([^javax.swing.text.AbstractDocument$ElementEdit this]
    (-> this (.getChildrenRemoved))))

(defn get-children-added
  "Gets a list of children that were added.

  returns: the list - `javax.swing.text.Element[]`"
  ([^javax.swing.text.AbstractDocument$ElementEdit this]
    (-> this (.getChildrenAdded))))

(defn redo
  "Redoes a change.

  throws: javax.swing.undo.CannotRedoException - if the change cannot be redone"
  ([^javax.swing.text.AbstractDocument$ElementEdit this]
    (-> this (.redo))))

(defn undo
  "Undoes a change.

  throws: javax.swing.undo.CannotUndoException - if the change cannot be undone"
  ([^javax.swing.text.AbstractDocument$ElementEdit this]
    (-> this (.undo))))

