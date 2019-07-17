(ns javax.swing.plaf.InternalFrameUI
  "Pluggable look and feel interface for JInternalFrame."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing.plaf InternalFrameUI]))

(defn ->internal-frame-ui
  "Constructor."
  ([]
    (new InternalFrameUI )))

