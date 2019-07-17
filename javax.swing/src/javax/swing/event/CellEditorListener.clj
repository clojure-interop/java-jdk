(ns javax.swing.event.CellEditorListener
  "CellEditorListener defines the interface for an object that listens
  to changes in a CellEditor"
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing.event CellEditorListener]))

(defn editing-stopped
  "This tells the listeners the editor has ended editing

  e - `javax.swing.event.ChangeEvent`"
  ([^. this ^javax.swing.event.ChangeEvent e]
    (-> this (.editingStopped e))))

(defn editing-canceled
  "This tells the listeners the editor has canceled editing

  e - `javax.swing.event.ChangeEvent`"
  ([^. this ^javax.swing.event.ChangeEvent e]
    (-> this (.editingCanceled e))))

