(ns javax.swing.plaf.basic.BasicCheckBoxMenuItemUI
  "BasicCheckboxMenuItem implementation"
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing.plaf.basic BasicCheckBoxMenuItemUI]))

(defn ->basic-check-box-menu-item-ui
  "Constructor."
  (^BasicCheckBoxMenuItemUI []
    (new BasicCheckBoxMenuItemUI )))

(defn *create-ui
  "c - `javax.swing.JComponent`

  returns: `javax.swing.plaf.ComponentUI`"
  (^javax.swing.plaf.ComponentUI [^javax.swing.JComponent c]
    (BasicCheckBoxMenuItemUI/createUI c)))

(defn process-mouse-event
  "item - `javax.swing.JMenuItem`
  e - `java.awt.event.MouseEvent`
  path - `javax.swing.MenuElement[]`
  manager - `javax.swing.MenuSelectionManager`"
  ([^BasicCheckBoxMenuItemUI this ^javax.swing.JMenuItem item e path ^javax.swing.MenuSelectionManager manager]
    (-> this (.processMouseEvent item e path manager))))

