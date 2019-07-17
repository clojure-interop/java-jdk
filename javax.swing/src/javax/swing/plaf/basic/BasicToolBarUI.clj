(ns javax.swing.plaf.basic.BasicToolBarUI
  "A Basic L&F implementation of ToolBarUI.  This implementation
  is a `combined` view/controller."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing.plaf.basic BasicToolBarUI]))

(defn ->basic-tool-bar-ui
  "Constructor."
  ([]
    (new BasicToolBarUI )))

(defn *create-ui
  "c - `javax.swing.JComponent`

  returns: `javax.swing.plaf.ComponentUI`"
  (^javax.swing.plaf.ComponentUI [^javax.swing.JComponent c]
    (BasicToolBarUI/createUI c)))

(defn set-floating-color
  "Sets the color displayed when over a floating area

  c - `java.awt.Color`"
  ([^javax.swing.plaf.basic.BasicToolBarUI this ^java.awt.Color c]
    (-> this (.setFloatingColor c))))

(defn install-ui
  "Description copied from class: ComponentUI

  c - the component where this UI delegate is being installed - `javax.swing.JComponent`"
  ([^javax.swing.plaf.basic.BasicToolBarUI this ^javax.swing.JComponent c]
    (-> this (.installUI c))))

(defn get-floating-color
  "Gets the color displayed when over a floating area

  returns: `java.awt.Color`"
  (^java.awt.Color [^javax.swing.plaf.basic.BasicToolBarUI this]
    (-> this (.getFloatingColor))))

(defn floating?
  "returns: `boolean`"
  (^Boolean [^javax.swing.plaf.basic.BasicToolBarUI this]
    (-> this (.isFloating))))

(defn set-docking-color
  "Sets the color displayed when over a docking area

  c - `java.awt.Color`"
  ([^javax.swing.plaf.basic.BasicToolBarUI this ^java.awt.Color c]
    (-> this (.setDockingColor c))))

(defn uninstall-ui
  "Description copied from class: ComponentUI

  c - the component from which this UI delegate is being removed; this argument is often ignored, but might be used if the UI object is stateless and shared by multiple components - `javax.swing.JComponent`"
  ([^javax.swing.plaf.basic.BasicToolBarUI this ^javax.swing.JComponent c]
    (-> this (.uninstallUI c))))

(defn set-rollover-borders
  "Sets the flag for enabling rollover borders on the toolbar and it will
   also install the appropriate border depending on the state of the flag.

  rollover - if true, rollover borders are installed. Otherwise non-rollover borders are installed - `boolean`"
  ([^javax.swing.plaf.basic.BasicToolBarUI this ^Boolean rollover]
    (-> this (.setRolloverBorders rollover))))

(defn rollover-borders?
  "Returns a flag to determine whether rollover button borders
   are enabled.

  returns: true if rollover borders are enabled; false otherwise - `boolean`"
  (^Boolean [^javax.swing.plaf.basic.BasicToolBarUI this]
    (-> this (.isRolloverBorders))))

(defn set-floating-location
  "x - `int`
  y - `int`"
  ([^javax.swing.plaf.basic.BasicToolBarUI this ^Integer x ^Integer y]
    (-> this (.setFloatingLocation x y))))

(defn can-dock?
  "c - `java.awt.Component`
  p - `java.awt.Point`

  returns: `boolean`"
  (^Boolean [^javax.swing.plaf.basic.BasicToolBarUI this ^java.awt.Component c ^java.awt.Point p]
    (-> this (.canDock c p))))

(defn set-orientation
  "orientation - `int`"
  ([^javax.swing.plaf.basic.BasicToolBarUI this ^Integer orientation]
    (-> this (.setOrientation orientation))))

(defn set-floating
  "b - `boolean`
  p - `java.awt.Point`"
  ([^javax.swing.plaf.basic.BasicToolBarUI this ^Boolean b ^java.awt.Point p]
    (-> this (.setFloating b p))))

(defn get-docking-color
  "Gets the color displayed when over a docking area

  returns: `java.awt.Color`"
  (^java.awt.Color [^javax.swing.plaf.basic.BasicToolBarUI this]
    (-> this (.getDockingColor))))

