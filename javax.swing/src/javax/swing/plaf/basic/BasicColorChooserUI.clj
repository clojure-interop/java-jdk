(ns javax.swing.plaf.basic.BasicColorChooserUI
  "Provides the basic look and feel for a JColorChooser."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing.plaf.basic BasicColorChooserUI]))

(defn ->basic-color-chooser-ui
  "Constructor."
  ([]
    (new BasicColorChooserUI )))

(defn *create-ui
  "c - `javax.swing.JComponent`

  returns: `javax.swing.plaf.ComponentUI`"
  (^javax.swing.plaf.ComponentUI [^javax.swing.JComponent c]
    (BasicColorChooserUI/createUI c)))

(defn install-ui
  "Description copied from class: ComponentUI

  c - the component where this UI delegate is being installed - `javax.swing.JComponent`"
  ([^javax.swing.plaf.basic.BasicColorChooserUI this ^javax.swing.JComponent c]
    (-> this (.installUI c))))

(defn uninstall-ui
  "Description copied from class: ComponentUI

  c - the component from which this UI delegate is being removed; this argument is often ignored, but might be used if the UI object is stateless and shared by multiple components - `javax.swing.JComponent`"
  ([^javax.swing.plaf.basic.BasicColorChooserUI this ^javax.swing.JComponent c]
    (-> this (.uninstallUI c))))

