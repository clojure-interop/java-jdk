(ns javax.swing.plaf.SliderUI
  "Pluggable look and feel interface for JSlider."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing.plaf SliderUI]))

(defn ->slider-ui
  "Constructor."
  ([]
    (new SliderUI )))

