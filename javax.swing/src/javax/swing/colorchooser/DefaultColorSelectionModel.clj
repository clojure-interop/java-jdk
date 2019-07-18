(ns javax.swing.colorchooser.DefaultColorSelectionModel
  "A generic implementation of ColorSelectionModel."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing.colorchooser DefaultColorSelectionModel]))

(defn ->default-color-selection-model
  "Constructor.

  Creates a DefaultColorSelectionModel with the
   current color set to color, which should be
   non-null.  Note that setting the color to
   null is undefined and may have unpredictable
   results.

  color - the new Color - `java.awt.Color`"
  (^DefaultColorSelectionModel [^java.awt.Color color]
    (new DefaultColorSelectionModel color))
  (^DefaultColorSelectionModel []
    (new DefaultColorSelectionModel )))

(defn get-selected-color
  "Returns the selected Color which should be
   non-null.

  returns: the selected Color - `java.awt.Color`"
  (^java.awt.Color [^DefaultColorSelectionModel this]
    (-> this (.getSelectedColor))))

(defn set-selected-color
  "Sets the selected color to color.
   Note that setting the color to null
   is undefined and may have unpredictable results.
   This method fires a state changed event if it sets the
   current color to a new non-null color;
   if the new color is the same as the current color,
   no event is fired.

  color - the new Color - `java.awt.Color`"
  ([^DefaultColorSelectionModel this ^java.awt.Color color]
    (-> this (.setSelectedColor color))))

(defn add-change-listener
  "Adds a ChangeListener to the model.

  l - the ChangeListener to be added - `javax.swing.event.ChangeListener`"
  ([^DefaultColorSelectionModel this ^javax.swing.event.ChangeListener l]
    (-> this (.addChangeListener l))))

(defn remove-change-listener
  "Removes a ChangeListener from the model.

  l - the ChangeListener to be removed - `javax.swing.event.ChangeListener`"
  ([^DefaultColorSelectionModel this ^javax.swing.event.ChangeListener l]
    (-> this (.removeChangeListener l))))

(defn get-change-listeners
  "Returns an array of all the ChangeListeners added
   to this DefaultColorSelectionModel with
   addChangeListener.

  returns: all of the ChangeListeners added, or an empty
           array if no listeners have been added - `javax.swing.event.ChangeListener[]`"
  ([^DefaultColorSelectionModel this]
    (-> this (.getChangeListeners))))

