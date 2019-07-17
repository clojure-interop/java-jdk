(ns javax.swing.plaf.metal.MetalToolTipUI
  "A Metal L&F extension of BasicToolTipUI.

  Warning:
  Serialized objects of this class will not be compatible with
  future Swing releases. The current serialization support is
  appropriate for short term storage or RMI between applications running
  the same version of Swing.  As of 1.4, support for long term storage
  of all JavaBeans™
  has been added to the java.beans package.
  Please see XMLEncoder."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing.plaf.metal MetalToolTipUI]))

(defn ->metal-tool-tip-ui
  "Constructor."
  ([]
    (new MetalToolTipUI )))

(def *-pad-space-between-strings
  "Static Constant.

  type: int"
  MetalToolTipUI/padSpaceBetweenStrings)

(defn *create-ui
  "c - `javax.swing.JComponent`

  returns: `javax.swing.plaf.ComponentUI`"
  ([^javax.swing.JComponent c]
    (MetalToolTipUI/createUI c)))

(defn install-ui
  "Description copied from class: ComponentUI

  c - the component where this UI delegate is being installed - `javax.swing.JComponent`"
  ([^javax.swing.plaf.metal.MetalToolTipUI this ^javax.swing.JComponent c]
    (-> this (.installUI c))))

(defn uninstall-ui
  "Description copied from class: ComponentUI

  c - the component from which this UI delegate is being removed; this argument is often ignored, but might be used if the UI object is stateless and shared by multiple components - `javax.swing.JComponent`"
  ([^javax.swing.plaf.metal.MetalToolTipUI this ^javax.swing.JComponent c]
    (-> this (.uninstallUI c))))

(defn paint
  "Description copied from class: ComponentUI

  g - the Graphics context in which to paint - `java.awt.Graphics`
  c - the component being painted; this argument is often ignored, but might be used if the UI object is stateless and shared by multiple components - `javax.swing.JComponent`"
  ([^javax.swing.plaf.metal.MetalToolTipUI this ^java.awt.Graphics g ^javax.swing.JComponent c]
    (-> this (.paint g c))))

(defn get-preferred-size
  "Description copied from class: ComponentUI

  c - the component whose preferred size is being queried; this argument is often ignored, but might be used if the UI object is stateless and shared by multiple components - `javax.swing.JComponent`

  returns: `java.awt.Dimension`"
  ([^javax.swing.plaf.metal.MetalToolTipUI this ^javax.swing.JComponent c]
    (-> this (.getPreferredSize c))))

(defn get-accelerator-string
  "returns: `java.lang.String`"
  ([^javax.swing.plaf.metal.MetalToolTipUI this]
    (-> this (.getAcceleratorString))))

