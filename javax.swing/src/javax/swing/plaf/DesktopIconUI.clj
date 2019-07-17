(ns javax.swing.plaf.DesktopIconUI
  "Pluggable look and feel interface for JDesktopIcon."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing.plaf DesktopIconUI]))

(defn ->desktop-icon-ui
  "Constructor."
  ([]
    (new DesktopIconUI )))

