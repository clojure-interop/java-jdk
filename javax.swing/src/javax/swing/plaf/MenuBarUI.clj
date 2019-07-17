(ns javax.swing.plaf.MenuBarUI
  "Pluggable look and feel interface for JMenuBar."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing.plaf MenuBarUI]))

(defn ->menu-bar-ui
  "Constructor."
  ([]
    (new MenuBarUI )))

