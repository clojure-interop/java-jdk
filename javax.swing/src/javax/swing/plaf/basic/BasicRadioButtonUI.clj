(ns javax.swing.plaf.basic.BasicRadioButtonUI
  "RadioButtonUI implementation for BasicRadioButtonUI"
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing.plaf.basic BasicRadioButtonUI]))

(defn ->basic-radio-button-ui
  "Constructor."
  ([]
    (new BasicRadioButtonUI )))

(defn *create-ui
  "Returns an instance of BasicRadioButtonUI.

  b - a component - `javax.swing.JComponent`

  returns: an instance of BasicRadioButtonUI - `javax.swing.plaf.ComponentUI`"
  (^javax.swing.plaf.ComponentUI [^javax.swing.JComponent b]
    (BasicRadioButtonUI/createUI b)))

(defn get-default-icon
  "Returns the default icon.

  returns: the default icon - `javax.swing.Icon`"
  (^javax.swing.Icon [^javax.swing.plaf.basic.BasicRadioButtonUI this]
    (-> this (.getDefaultIcon))))

(defn paint
  "paint the radio button

  g - the Graphics context in which to paint - `java.awt.Graphics`
  c - the component being painted; this argument is often ignored, but might be used if the UI object is stateless and shared by multiple components - `javax.swing.JComponent`"
  ([^javax.swing.plaf.basic.BasicRadioButtonUI this ^java.awt.Graphics g ^javax.swing.JComponent c]
    (-> this (.paint g c))))

(defn get-preferred-size
  "The preferred size of the radio button

  c - the component whose preferred size is being queried; this argument is often ignored, but might be used if the UI object is stateless and shared by multiple components - `javax.swing.JComponent`

  returns: `java.awt.Dimension`"
  (^java.awt.Dimension [^javax.swing.plaf.basic.BasicRadioButtonUI this ^javax.swing.JComponent c]
    (-> this (.getPreferredSize c))))

