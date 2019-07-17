(ns javax.swing.undo.core
  (:refer-clojure :only [require comment defn ->])
  (:import ))

(require '[javax.swing.undo.AbstractUndoableEdit])
(require '[javax.swing.undo.CannotRedoException])
(require '[javax.swing.undo.CannotUndoException])
(require '[javax.swing.undo.CompoundEdit])
(require '[javax.swing.undo.StateEdit])
(require '[javax.swing.undo.StateEditable])
(require '[javax.swing.undo.UndoManager])
(require '[javax.swing.undo.UndoableEdit])
(require '[javax.swing.undo.UndoableEditSupport])
