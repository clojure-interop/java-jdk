(ns javax.swing.event.TreeSelectionListener
  "The listener that's notified when the selection in a TreeSelectionModel
  changes.
  For more information and examples see
  How to Write a Tree Selection Listener,
  a section in The Java Tutorial."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing.event TreeSelectionListener]))

(defn value-changed
  "Called whenever the value of the selection changes.

  e - the event that characterizes the change. - `javax.swing.event.TreeSelectionEvent`"
  ([^javax.swing.event.TreeSelectionListener this ^javax.swing.event.TreeSelectionEvent e]
    (-> this (.valueChanged e))))

