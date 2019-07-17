(ns javax.swing.JToggleButton$ToggleButtonModel
  "The ToggleButton model

  Warning:
  Serialized objects of this class will not be compatible with
  future Swing releases. The current serialization support is
  appropriate for short term storage or RMI between applications running
  the same version of Swing.  As of 1.4, support for long term storage
  of all JavaBeans™
  has been added to the java.beans package.
  Please see XMLEncoder."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing JToggleButton$ToggleButtonModel]))

(defn ->toggle-button-model
  "Constructor.

  Creates a new ToggleButton Model"
  ([]
    (new JToggleButton$ToggleButtonModel )))

(defn selected?
  "Checks if the button is selected.

  returns: true if the button is selected - `boolean`"
  ([this]
    (-> this (.isSelected))))

(defn set-selected
  "Sets the selected state of the button.

  b - true selects the toggle button, false deselects the toggle button. - `boolean`"
  ([this b]
    (-> this (.setSelected b))))

(defn set-pressed
  "Sets the pressed state of the toggle button.

  b - whether or not the button should be pressed - `boolean`"
  ([this b]
    (-> this (.setPressed b))))

