(ns javax.swing.plaf.ProgressBarUI
  "Pluggable look and feel interface for JProgressBar."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing.plaf ProgressBarUI]))

(defn ->progress-bar-ui
  "Constructor."
  ([]
    (new ProgressBarUI )))

