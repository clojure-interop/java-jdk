(ns javax.swing.event.MenuListener
  "Defines a listener for menu events."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing.event MenuListener]))

(defn menu-selected
  "Invoked when a menu is selected.

  e - a MenuEvent object - `javax.swing.event.MenuEvent`"
  ([^javax.swing.event.MenuListener this ^javax.swing.event.MenuEvent e]
    (-> this (.menuSelected e))))

(defn menu-deselected
  "Invoked when the menu is deselected.

  e - a MenuEvent object - `javax.swing.event.MenuEvent`"
  ([^javax.swing.event.MenuListener this ^javax.swing.event.MenuEvent e]
    (-> this (.menuDeselected e))))

(defn menu-canceled
  "Invoked when the menu is canceled.

  e - a MenuEvent object - `javax.swing.event.MenuEvent`"
  ([^javax.swing.event.MenuListener this ^javax.swing.event.MenuEvent e]
    (-> this (.menuCanceled e))))

