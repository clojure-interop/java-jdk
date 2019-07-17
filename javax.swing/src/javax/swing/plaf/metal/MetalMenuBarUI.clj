(ns javax.swing.plaf.metal.MetalMenuBarUI
  "Metal implementation of MenuBarUI. This class is responsible
  for providing the metal look and feel for JMenuBars."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing.plaf.metal MetalMenuBarUI]))

(defn ->metal-menu-bar-ui
  "Constructor."
  ([]
    (new MetalMenuBarUI )))

(defn *create-ui
  "Creates the ComponentUI implementation for the passed
   in component.

  x - JComponent to create the ComponentUI implementation for - `javax.swing.JComponent`

  returns: ComponentUI implementation for x - `javax.swing.plaf.ComponentUI`

  throws: java.lang.NullPointerException - if x is null"
  ([x]
    (MetalMenuBarUI/createUI x)))

(defn install-ui
  "Configures the specified component appropriate for the metal look and
   feel.

  c - the component where this UI delegate is being installed - `javax.swing.JComponent`

  throws: java.lang.NullPointerException - if c is null."
  ([this c]
    (-> this (.installUI c))))

(defn uninstall-ui
  "Reverses configuration which was done on the specified component during
   installUI.

  c - the component where this UI delegate is being installed - `javax.swing.JComponent`

  throws: java.lang.NullPointerException - if c is null."
  ([this c]
    (-> this (.uninstallUI c))))

(defn update
  "If necessary paints the background of the component, then
   invokes paint.

  g - Graphics to paint to - `java.awt.Graphics`
  c - JComponent painting on - `javax.swing.JComponent`

  throws: java.lang.NullPointerException - if g or c is null"
  ([this g c]
    (-> this (.update g c))))

