(ns javax.swing.plaf.metal.MetalSplitPaneUI
  "Metal split pane.

  Warning:
  Serialized objects of this class will not be compatible with
  future Swing releases. The current serialization support is
  appropriate for short term storage or RMI between applications running
  the same version of Swing.  As of 1.4, support for long term storage
  of all JavaBeans™
  has been added to the java.beans package.
  Please see XMLEncoder."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing.plaf.metal MetalSplitPaneUI]))

(defn ->metal-split-pane-ui
  "Constructor."
  (^MetalSplitPaneUI []
    (new MetalSplitPaneUI )))

(defn *create-ui
  "Creates a new MetalSplitPaneUI instance

  x - `javax.swing.JComponent`

  returns: `javax.swing.plaf.ComponentUI`"
  (^javax.swing.plaf.ComponentUI [^javax.swing.JComponent x]
    (MetalSplitPaneUI/createUI x)))

(defn create-default-divider
  "Creates the default divider.

  returns: `javax.swing.plaf.basic.BasicSplitPaneDivider`"
  (^javax.swing.plaf.basic.BasicSplitPaneDivider [^MetalSplitPaneUI this]
    (-> this (.createDefaultDivider))))

