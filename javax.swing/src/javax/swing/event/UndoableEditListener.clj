(ns javax.swing.event.UndoableEditListener
  "Interface implemented by a class interested in hearing about
  undoable operations."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing.event UndoableEditListener]))

(defn undoable-edit-happened
  "An undoable edit happened

  e - `javax.swing.event.UndoableEditEvent`"
  ([^javax.swing.event.UndoableEditListener this ^javax.swing.event.UndoableEditEvent e]
    (-> this (.undoableEditHappened e))))

