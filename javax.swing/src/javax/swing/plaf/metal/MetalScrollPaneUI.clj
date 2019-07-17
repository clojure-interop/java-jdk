(ns javax.swing.plaf.metal.MetalScrollPaneUI
  "A Metal L&F implementation of ScrollPaneUI.

  Warning:
  Serialized objects of this class will not be compatible with
  future Swing releases. The current serialization support is
  appropriate for short term storage or RMI between applications running
  the same version of Swing.  As of 1.4, support for long term storage
  of all JavaBeans™
  has been added to the java.beans package.
  Please see XMLEncoder."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing.plaf.metal MetalScrollPaneUI]))

(defn ->metal-scroll-pane-ui
  "Constructor."
  ([]
    (new MetalScrollPaneUI )))

(defn *create-ui
  "x - `javax.swing.JComponent`

  returns: `javax.swing.plaf.ComponentUI`"
  ([^javax.swing.JComponent x]
    (MetalScrollPaneUI/createUI x)))

(defn install-ui
  "Description copied from class: ComponentUI

  c - the component where this UI delegate is being installed - `javax.swing.JComponent`"
  ([^javax.swing.plaf.metal.MetalScrollPaneUI this ^javax.swing.JComponent c]
    (-> this (.installUI c))))

(defn uninstall-ui
  "Description copied from class: ComponentUI

  c - the component from which this UI delegate is being removed; this argument is often ignored, but might be used if the UI object is stateless and shared by multiple components - `javax.swing.JComponent`"
  ([^javax.swing.plaf.metal.MetalScrollPaneUI this ^javax.swing.JComponent c]
    (-> this (.uninstallUI c))))

(defn install-listeners
  "scroll-pane - `javax.swing.JScrollPane`"
  ([^javax.swing.plaf.metal.MetalScrollPaneUI this ^javax.swing.JScrollPane scroll-pane]
    (-> this (.installListeners scroll-pane))))

(defn uninstall-listeners
  "Deprecated. - Replaced by uninstallListeners(JComponent)

  scroll-pane - `javax.swing.JScrollPane`

  returns: `java.lang.  void`"
  ([^javax.swing.plaf.metal.MetalScrollPaneUI this ^javax.swing.JScrollPane scroll-pane]
    (-> this (.uninstallListeners scroll-pane))))

