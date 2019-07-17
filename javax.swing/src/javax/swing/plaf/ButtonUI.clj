(ns javax.swing.plaf.ButtonUI
  "Pluggable look and feel interface for JButton."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing.plaf ButtonUI]))

(defn ->button-ui
  "Constructor."
  ([]
    (new ButtonUI )))

