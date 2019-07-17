(ns javax.swing.event.CaretListener
  "Listener for changes in the caret position of a text
  component."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing.event CaretListener]))

(defn caret-update
  "Called when the caret position is updated.

  e - the caret event - `javax.swing.event.CaretEvent`"
  ([^. this ^javax.swing.event.CaretEvent e]
    (-> this (.caretUpdate e))))

