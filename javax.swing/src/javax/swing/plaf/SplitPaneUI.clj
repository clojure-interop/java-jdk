(ns javax.swing.plaf.SplitPaneUI
  "Pluggable look and feel interface for JSplitPane."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing.plaf SplitPaneUI]))

(defn ->split-pane-ui
  "Constructor."
  ([]
    (new SplitPaneUI )))

(defn reset-to-preferred-sizes
  "Messaged to relayout the JSplitPane based on the preferred size
   of the children components.

  jc - `javax.swing.JSplitPane`"
  ([this jc]
    (-> this (.resetToPreferredSizes jc))))

(defn set-divider-location
  "Sets the location of the divider to location.

  jc - `javax.swing.JSplitPane`
  location - `int`"
  ([this jc location]
    (-> this (.setDividerLocation jc location))))

(defn get-divider-location
  "Returns the location of the divider.

  jc - `javax.swing.JSplitPane`

  returns: `int`"
  ([this jc]
    (-> this (.getDividerLocation jc))))

(defn get-minimum-divider-location
  "Returns the minimum possible location of the divider.

  jc - `javax.swing.JSplitPane`

  returns: `int`"
  ([this jc]
    (-> this (.getMinimumDividerLocation jc))))

(defn get-maximum-divider-location
  "Returns the maximum possible location of the divider.

  jc - `javax.swing.JSplitPane`

  returns: `int`"
  ([this jc]
    (-> this (.getMaximumDividerLocation jc))))

(defn finished-painting-children
  "Messaged after the JSplitPane the receiver is providing the look
   and feel for paints its children.

  jc - `javax.swing.JSplitPane`
  g - `java.awt.Graphics`"
  ([this jc g]
    (-> this (.finishedPaintingChildren jc g))))

