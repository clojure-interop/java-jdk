(ns javax.swing.event.ListSelectionListener
  "The listener that's notified when a lists selection value
  changes."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing.event ListSelectionListener]))

(defn value-changed
  "Called whenever the value of the selection changes.

  e - the event that characterizes the change. - `javax.swing.event.ListSelectionEvent`"
  ([^javax.swing.event.ListSelectionListener this ^javax.swing.event.ListSelectionEvent e]
    (-> this (.valueChanged e))))

