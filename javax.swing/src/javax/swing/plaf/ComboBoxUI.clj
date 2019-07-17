(ns javax.swing.plaf.ComboBoxUI
  "Pluggable look and feel interface for JComboBox."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing.plaf ComboBoxUI]))

(defn ->combo-box-ui
  "Constructor."
  ([]
    (new ComboBoxUI )))

(defn set-popup-visible
  "Set the visibility of the popup

  c - `javax.swing.JComboBox`
  v - `boolean`"
  ([^javax.swing.plaf.ComboBoxUI this ^javax.swing.JComboBox c ^Boolean v]
    (-> this (.setPopupVisible c v))))

(defn popup-visible?
  "Determine the visibility of the popup

  c - `javax.swing.JComboBox`

  returns: `boolean`"
  ([^javax.swing.plaf.ComboBoxUI this ^javax.swing.JComboBox c]
    (-> this (.isPopupVisible c))))

(defn focus-traversable?
  "Determine whether or not the combo box itself is traversable

  c - `javax.swing.JComboBox`

  returns: `boolean`"
  ([^javax.swing.plaf.ComboBoxUI this ^javax.swing.JComboBox c]
    (-> this (.isFocusTraversable c))))

