(ns javax.swing.plaf.metal.MetalButtonUI
  "MetalButtonUI implementation

  Warning:
  Serialized objects of this class will not be compatible with
  future Swing releases. The current serialization support is
  appropriate for short term storage or RMI between applications running
  the same version of Swing.  As of 1.4, support for long term storage
  of all JavaBeans™
  has been added to the java.beans package.
  Please see XMLEncoder."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing.plaf.metal MetalButtonUI]))

(defn ->metal-button-ui
  "Constructor."
  (^MetalButtonUI []
    (new MetalButtonUI )))

(defn *create-ui
  "c - `javax.swing.JComponent`

  returns: `javax.swing.plaf.ComponentUI`"
  (^javax.swing.plaf.ComponentUI [^javax.swing.JComponent c]
    (MetalButtonUI/createUI c)))

(defn install-defaults
  "b - `javax.swing.AbstractButton`"
  ([^MetalButtonUI this ^javax.swing.AbstractButton b]
    (-> this (.installDefaults b))))

(defn uninstall-defaults
  "b - `javax.swing.AbstractButton`"
  ([^MetalButtonUI this ^javax.swing.AbstractButton b]
    (-> this (.uninstallDefaults b))))

(defn update
  "If necessary paints the background of the component, then
   invokes paint.

  g - Graphics to paint to - `java.awt.Graphics`
  c - JComponent painting on - `javax.swing.JComponent`

  throws: java.lang.NullPointerException - if g or c is null"
  ([^MetalButtonUI this ^java.awt.Graphics g ^javax.swing.JComponent c]
    (-> this (.update g c))))

