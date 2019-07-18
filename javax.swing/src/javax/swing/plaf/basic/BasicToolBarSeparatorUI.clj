(ns javax.swing.plaf.basic.BasicToolBarSeparatorUI
  "A Basic L&F implementation of ToolBarSeparatorUI.  This implementation
  is a `combined` view/controller."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing.plaf.basic BasicToolBarSeparatorUI]))

(defn ->basic-tool-bar-separator-ui
  "Constructor."
  (^BasicToolBarSeparatorUI []
    (new BasicToolBarSeparatorUI )))

(defn *create-ui
  "c - `javax.swing.JComponent`

  returns: `javax.swing.plaf.ComponentUI`"
  (^javax.swing.plaf.ComponentUI [^javax.swing.JComponent c]
    (BasicToolBarSeparatorUI/createUI c)))

(defn paint
  "Description copied from class: ComponentUI

  g - the Graphics context in which to paint - `java.awt.Graphics`
  c - the component being painted; this argument is often ignored, but might be used if the UI object is stateless and shared by multiple components - `javax.swing.JComponent`"
  ([^BasicToolBarSeparatorUI this ^java.awt.Graphics g ^javax.swing.JComponent c]
    (-> this (.paint g c))))

(defn get-preferred-size
  "Description copied from class: ComponentUI

  c - the component whose preferred size is being queried; this argument is often ignored, but might be used if the UI object is stateless and shared by multiple components - `javax.swing.JComponent`

  returns: `java.awt.Dimension`"
  (^java.awt.Dimension [^BasicToolBarSeparatorUI this ^javax.swing.JComponent c]
    (-> this (.getPreferredSize c))))

