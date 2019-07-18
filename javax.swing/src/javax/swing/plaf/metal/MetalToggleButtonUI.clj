(ns javax.swing.plaf.metal.MetalToggleButtonUI
  "MetalToggleButton implementation

  Warning:
  Serialized objects of this class will not be compatible with
  future Swing releases. The current serialization support is
  appropriate for short term storage or RMI between applications running
  the same version of Swing.  As of 1.4, support for long term storage
  of all JavaBeans™
  has been added to the java.beans package.
  Please see XMLEncoder."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing.plaf.metal MetalToggleButtonUI]))

(defn ->metal-toggle-button-ui
  "Constructor."
  (^MetalToggleButtonUI []
    (new MetalToggleButtonUI )))

(defn *create-ui
  "b - `javax.swing.JComponent`

  returns: `javax.swing.plaf.ComponentUI`"
  (^javax.swing.plaf.ComponentUI [^javax.swing.JComponent b]
    (MetalToggleButtonUI/createUI b)))

(defn install-defaults
  "b - `javax.swing.AbstractButton`"
  ([^MetalToggleButtonUI this ^javax.swing.AbstractButton b]
    (-> this (.installDefaults b))))

(defn update
  "If necessary paints the background of the component, then invokes
   paint.

  g - Graphics to paint to - `java.awt.Graphics`
  c - JComponent painting on - `javax.swing.JComponent`

  throws: java.lang.NullPointerException - if g or c is null"
  ([^MetalToggleButtonUI this ^java.awt.Graphics g ^javax.swing.JComponent c]
    (-> this (.update g c))))

