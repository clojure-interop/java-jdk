(ns javax.swing.plaf.basic.BasicToggleButtonUI
  "BasicToggleButton implementation"
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing.plaf.basic BasicToggleButtonUI]))

(defn ->basic-toggle-button-ui
  "Constructor."
  ([]
    (new BasicToggleButtonUI )))

(defn *create-ui
  "b - `javax.swing.JComponent`

  returns: `javax.swing.plaf.ComponentUI`"
  (^javax.swing.plaf.ComponentUI [^javax.swing.JComponent b]
    (BasicToggleButtonUI/createUI b)))

(defn paint
  "Description copied from class: ComponentUI

  g - the Graphics context in which to paint - `java.awt.Graphics`
  c - the component being painted; this argument is often ignored, but might be used if the UI object is stateless and shared by multiple components - `javax.swing.JComponent`"
  ([^javax.swing.plaf.basic.BasicToggleButtonUI this ^java.awt.Graphics g ^javax.swing.JComponent c]
    (-> this (.paint g c))))

