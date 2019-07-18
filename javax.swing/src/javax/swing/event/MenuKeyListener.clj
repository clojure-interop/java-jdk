(ns javax.swing.event.MenuKeyListener
  "MenuKeyListener"
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing.event MenuKeyListener]))

(defn menu-key-typed
  "Invoked when a key has been typed.
   This event occurs when a key press is followed by a key release.

  e - `javax.swing.event.MenuKeyEvent`"
  ([^MenuKeyListener this ^javax.swing.event.MenuKeyEvent e]
    (-> this (.menuKeyTyped e))))

(defn menu-key-pressed
  "Invoked when a key has been pressed.

  e - `javax.swing.event.MenuKeyEvent`"
  ([^MenuKeyListener this ^javax.swing.event.MenuKeyEvent e]
    (-> this (.menuKeyPressed e))))

(defn menu-key-released
  "Invoked when a key has been released.

  e - `javax.swing.event.MenuKeyEvent`"
  ([^MenuKeyListener this ^javax.swing.event.MenuKeyEvent e]
    (-> this (.menuKeyReleased e))))

