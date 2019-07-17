(ns javax.swing.plaf.TabbedPaneUI
  "Pluggable look and feel interface for JTabbedPane."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing.plaf TabbedPaneUI]))

(defn ->tabbed-pane-ui
  "Constructor."
  ([]
    (new TabbedPaneUI )))

(defn tab-for-coordinate
  "pane - `javax.swing.JTabbedPane`
  x - `int`
  y - `int`

  returns: `int`"
  (^Integer [^javax.swing.plaf.TabbedPaneUI this ^javax.swing.JTabbedPane pane ^Integer x ^Integer y]
    (-> this (.tabForCoordinate pane x y))))

(defn get-tab-bounds
  "pane - `javax.swing.JTabbedPane`
  index - `int`

  returns: `java.awt.Rectangle`"
  (^java.awt.Rectangle [^javax.swing.plaf.TabbedPaneUI this ^javax.swing.JTabbedPane pane ^Integer index]
    (-> this (.getTabBounds pane index))))

(defn get-tab-run-count
  "pane - `javax.swing.JTabbedPane`

  returns: `int`"
  (^Integer [^javax.swing.plaf.TabbedPaneUI this ^javax.swing.JTabbedPane pane]
    (-> this (.getTabRunCount pane))))

