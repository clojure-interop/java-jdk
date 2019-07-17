(ns javax.swing.plaf.metal.MetalTabbedPaneUI
  "The Metal subclass of BasicTabbedPaneUI.

  Warning:
  Serialized objects of this class will not be compatible with
  future Swing releases. The current serialization support is
  appropriate for short term storage or RMI between applications running
  the same version of Swing.  As of 1.4, support for long term storage
  of all JavaBeans™
  has been added to the java.beans package.
  Please see XMLEncoder."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing.plaf.metal MetalTabbedPaneUI]))

(defn ->metal-tabbed-pane-ui
  "Constructor."
  ([]
    (new MetalTabbedPaneUI )))

(defn *create-ui
  "x - `javax.swing.JComponent`

  returns: `javax.swing.plaf.ComponentUI`"
  (^javax.swing.plaf.ComponentUI [^javax.swing.JComponent x]
    (MetalTabbedPaneUI/createUI x)))

(defn update
  "Description copied from class: ComponentUI

  g - the Graphics context in which to paint - `java.awt.Graphics`
  c - the component being painted; this argument is often ignored, but might be used if the UI object is stateless and shared by multiple components - `javax.swing.JComponent`"
  ([^javax.swing.plaf.metal.MetalTabbedPaneUI this ^java.awt.Graphics g ^javax.swing.JComponent c]
    (-> this (.update g c))))

(defn paint
  "Description copied from class: ComponentUI

  g - the Graphics context in which to paint - `java.awt.Graphics`
  c - the component being painted; this argument is often ignored, but might be used if the UI object is stateless and shared by multiple components - `javax.swing.JComponent`"
  ([^javax.swing.plaf.metal.MetalTabbedPaneUI this ^java.awt.Graphics g ^javax.swing.JComponent c]
    (-> this (.paint g c))))

