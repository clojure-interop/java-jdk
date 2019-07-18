(ns javax.swing.colorchooser.ColorSelectionModel
  "A model that supports selecting a Color."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing.colorchooser ColorSelectionModel]))

(defn get-selected-color
  "Returns the selected Color which should be
   non-null.

  returns: the selected Color - `java.awt.Color`"
  (^java.awt.Color [^ColorSelectionModel this]
    (-> this (.getSelectedColor))))

(defn set-selected-color
  "Sets the selected color to color.
   Note that setting the color to null
   is undefined and may have unpredictable results.
   This method fires a state changed event if it sets the
   current color to a new non-null color.

  color - the new Color - `java.awt.Color`"
  ([^ColorSelectionModel this ^java.awt.Color color]
    (-> this (.setSelectedColor color))))

(defn add-change-listener
  "Adds listener as a listener to changes in the model.

  listener - the ChangeListener to be added - `javax.swing.event.ChangeListener`"
  ([^ColorSelectionModel this ^javax.swing.event.ChangeListener listener]
    (-> this (.addChangeListener listener))))

(defn remove-change-listener
  "Removes listener as a listener to changes in the model.

  listener - the ChangeListener to be removed - `javax.swing.event.ChangeListener`"
  ([^ColorSelectionModel this ^javax.swing.event.ChangeListener listener]
    (-> this (.removeChangeListener listener))))

