(ns javax.swing.plaf.SpinnerUI
  "Pluggable look and feel interface for JSpinner"
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing.plaf SpinnerUI]))

(defn ->spinner-ui
  "Constructor."
  ([]
    (new SpinnerUI )))

