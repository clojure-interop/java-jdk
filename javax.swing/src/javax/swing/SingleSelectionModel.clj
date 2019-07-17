(ns javax.swing.SingleSelectionModel
  "A model that supports at most one indexed selection."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing SingleSelectionModel]))

(defn get-selected-index
  "Returns the model's selection.

  returns: the model's selection, or -1 if there is no selection - `int`"
  ([^. this]
    (-> this (.getSelectedIndex))))

(defn set-selected-index
  "Sets the model's selected index to index.

   Notifies any listeners if the model changes

  index - an int specifying the model selection - `int`"
  ([^. this ^Integer index]
    (-> this (.setSelectedIndex index))))

(defn clear-selection
  "Clears the selection (to -1)."
  ([^. this]
    (-> this (.clearSelection))))

(defn selected?
  "Returns true if the selection model currently has a selected value.

  returns: true if a value is currently selected - `boolean`"
  ([^. this]
    (-> this (.isSelected))))

(defn add-change-listener
  "Adds listener as a listener to changes in the model.

  listener - the ChangeListener to add - `javax.swing.event.ChangeListener`"
  ([^. this ^javax.swing.event.ChangeListener listener]
    (-> this (.addChangeListener listener))))

(defn remove-change-listener
  "Removes listener as a listener to changes in the model.

  listener - the ChangeListener to remove - `javax.swing.event.ChangeListener`"
  ([^. this ^javax.swing.event.ChangeListener listener]
    (-> this (.removeChangeListener listener))))

