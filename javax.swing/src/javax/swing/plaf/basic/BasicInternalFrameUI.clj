(ns javax.swing.plaf.basic.BasicInternalFrameUI
  "A basic L&F implementation of JInternalFrame."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing.plaf.basic BasicInternalFrameUI]))

(defn ->basic-internal-frame-ui
  "Constructor.

  b - `javax.swing.JInternalFrame`"
  ([^javax.swing.JInternalFrame b]
    (new BasicInternalFrameUI b)))

(defn *create-ui
  "b - `javax.swing.JComponent`

  returns: `javax.swing.plaf.ComponentUI`"
  (^javax.swing.plaf.ComponentUI [^javax.swing.JComponent b]
    (BasicInternalFrameUI/createUI b)))

(defn install-ui
  "Description copied from class: ComponentUI

  c - the component where this UI delegate is being installed - `javax.swing.JComponent`"
  ([^javax.swing.plaf.basic.BasicInternalFrameUI this ^javax.swing.JComponent c]
    (-> this (.installUI c))))

(defn get-minimum-size
  "Description copied from class: ComponentUI

  x - the component whose minimum size is being queried; this argument is often ignored, but might be used if the UI object is stateless and shared by multiple components - `javax.swing.JComponent`

  returns: a Dimension object or null - `java.awt.Dimension`"
  (^java.awt.Dimension [^javax.swing.plaf.basic.BasicInternalFrameUI this ^javax.swing.JComponent x]
    (-> this (.getMinimumSize x))))

(defn set-east-pane
  "c - `javax.swing.JComponent`"
  ([^javax.swing.plaf.basic.BasicInternalFrameUI this ^javax.swing.JComponent c]
    (-> this (.setEastPane c))))

(defn set-west-pane
  "c - `javax.swing.JComponent`"
  ([^javax.swing.plaf.basic.BasicInternalFrameUI this ^javax.swing.JComponent c]
    (-> this (.setWestPane c))))

(defn get-maximum-size
  "Description copied from class: ComponentUI

  x - the component whose maximum size is being queried; this argument is often ignored, but might be used if the UI object is stateless and shared by multiple components - `javax.swing.JComponent`

  returns: a Dimension object or null - `java.awt.Dimension`"
  (^java.awt.Dimension [^javax.swing.plaf.basic.BasicInternalFrameUI this ^javax.swing.JComponent x]
    (-> this (.getMaximumSize x))))

(defn set-south-pane
  "c - `javax.swing.JComponent`"
  ([^javax.swing.plaf.basic.BasicInternalFrameUI this ^javax.swing.JComponent c]
    (-> this (.setSouthPane c))))

(defn get-west-pane
  "returns: `javax.swing.JComponent`"
  (^javax.swing.JComponent [^javax.swing.plaf.basic.BasicInternalFrameUI this]
    (-> this (.getWestPane))))

(defn set-north-pane
  "c - `javax.swing.JComponent`"
  ([^javax.swing.plaf.basic.BasicInternalFrameUI this ^javax.swing.JComponent c]
    (-> this (.setNorthPane c))))

(defn uninstall-ui
  "Description copied from class: ComponentUI

  c - the component from which this UI delegate is being removed; this argument is often ignored, but might be used if the UI object is stateless and shared by multiple components - `javax.swing.JComponent`"
  ([^javax.swing.plaf.basic.BasicInternalFrameUI this ^javax.swing.JComponent c]
    (-> this (.uninstallUI c))))

(defn key-binding-active?
  "returns: `boolean`"
  (^Boolean [^javax.swing.plaf.basic.BasicInternalFrameUI this]
    (-> this (.isKeyBindingActive))))

(defn get-north-pane
  "returns: `javax.swing.JComponent`"
  (^javax.swing.JComponent [^javax.swing.plaf.basic.BasicInternalFrameUI this]
    (-> this (.getNorthPane))))

(defn get-east-pane
  "returns: `javax.swing.JComponent`"
  (^javax.swing.JComponent [^javax.swing.plaf.basic.BasicInternalFrameUI this]
    (-> this (.getEastPane))))

(defn get-south-pane
  "returns: `javax.swing.JComponent`"
  (^javax.swing.JComponent [^javax.swing.plaf.basic.BasicInternalFrameUI this]
    (-> this (.getSouthPane))))

(defn get-preferred-size
  "Description copied from class: ComponentUI

  x - the component whose preferred size is being queried; this argument is often ignored, but might be used if the UI object is stateless and shared by multiple components - `javax.swing.JComponent`

  returns: `java.awt.Dimension`"
  (^java.awt.Dimension [^javax.swing.plaf.basic.BasicInternalFrameUI this ^javax.swing.JComponent x]
    (-> this (.getPreferredSize x))))

