(ns javax.swing.plaf.metal.MetalToolBarUI
  "A Metal Look and Feel implementation of ToolBarUI.  This implementation
  is a `combined` view/controller."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing.plaf.metal MetalToolBarUI]))

(defn ->metal-tool-bar-ui
  "Constructor."
  ([]
    (new MetalToolBarUI )))

(defn *create-ui
  "c - `javax.swing.JComponent`

  returns: `javax.swing.plaf.ComponentUI`"
  ([c]
    (MetalToolBarUI/createUI c)))

(defn install-ui
  "Description copied from class: ComponentUI

  c - the component where this UI delegate is being installed - `javax.swing.JComponent`"
  ([this c]
    (-> this (.installUI c))))

(defn uninstall-ui
  "Description copied from class: ComponentUI

  c - the component from which this UI delegate is being removed; this argument is often ignored, but might be used if the UI object is stateless and shared by multiple components - `javax.swing.JComponent`"
  ([this c]
    (-> this (.uninstallUI c))))

(defn update
  "If necessary paints the background of the component, then invokes
   paint.

  g - Graphics to paint to - `java.awt.Graphics`
  c - JComponent painting on - `javax.swing.JComponent`

  throws: java.lang.NullPointerException - if g or c is null"
  ([this g c]
    (-> this (.update g c))))

