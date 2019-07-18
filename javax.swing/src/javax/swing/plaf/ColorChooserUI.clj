(ns javax.swing.plaf.ColorChooserUI
  "Pluggable look and feel interface for JColorChooser."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing.plaf ColorChooserUI]))

(defn ->color-chooser-ui
  "Constructor."
  (^ColorChooserUI []
    (new ColorChooserUI )))

