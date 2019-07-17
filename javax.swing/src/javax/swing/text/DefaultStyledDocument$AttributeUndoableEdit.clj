(ns javax.swing.text.DefaultStyledDocument$AttributeUndoableEdit
  "An UndoableEdit used to remember AttributeSet changes to an
  Element."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing.text DefaultStyledDocument$AttributeUndoableEdit]))

(defn ->attribute-undoable-edit
  "Constructor.

  element - `javax.swing.text.Element`
  new-attributes - `javax.swing.text.AttributeSet`
  is-replacing - `boolean`"
  ([^javax.swing.text.Element element ^javax.swing.text.AttributeSet new-attributes ^Boolean is-replacing]
    (new DefaultStyledDocument$AttributeUndoableEdit element new-attributes is-replacing)))

(defn redo
  "Redoes a change.

  throws: javax.swing.undo.CannotRedoException - if the change cannot be redone"
  ([^javax.swing.text.DefaultStyledDocument$AttributeUndoableEdit this]
    (-> this (.redo))))

(defn undo
  "Undoes a change.

  throws: javax.swing.undo.CannotUndoException - if the change cannot be undone"
  ([^javax.swing.text.DefaultStyledDocument$AttributeUndoableEdit this]
    (-> this (.undo))))

