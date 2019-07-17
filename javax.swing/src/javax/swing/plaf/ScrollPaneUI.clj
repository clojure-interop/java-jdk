(ns javax.swing.plaf.ScrollPaneUI
  "Pluggable look and feel interface for JScrollPane."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing.plaf ScrollPaneUI]))

(defn ->scroll-pane-ui
  "Constructor."
  ([]
    (new ScrollPaneUI )))

