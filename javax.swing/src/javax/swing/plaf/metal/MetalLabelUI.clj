(ns javax.swing.plaf.metal.MetalLabelUI
  "A Windows L&F implementation of LabelUI.  This implementation
  is completely static, i.e. there's only one UIView implementation
  that's shared by all JLabel objects."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing.plaf.metal MetalLabelUI]))

(defn ->metal-label-ui
  "Constructor."
  ([]
    (new MetalLabelUI )))

(defn *create-ui
  "c - `javax.swing.JComponent`

  returns: `javax.swing.plaf.ComponentUI`"
  (^javax.swing.plaf.ComponentUI [^javax.swing.JComponent c]
    (MetalLabelUI/createUI c)))

