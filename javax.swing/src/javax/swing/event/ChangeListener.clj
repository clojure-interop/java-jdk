(ns javax.swing.event.ChangeListener
  "Defines an object which listens for ChangeEvents."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing.event ChangeListener]))

(defn state-changed
  "Invoked when the target of the listener has changed its state.

  e - a ChangeEvent object - `javax.swing.event.ChangeEvent`"
  ([this e]
    (-> this (.stateChanged e))))

